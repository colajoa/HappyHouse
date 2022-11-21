package com.ssafy.happyhouse.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.auth.service.KakaoOAuth2ServiceIml;
import com.ssafy.happyhouse.dao.UserDao;
import com.ssafy.happyhouse.dto.KakaoUserInfo;
import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.exception.CustomException;
import com.ssafy.happyhouse.exception.ErrorCode;

@Service
public class UserServiceImpl implements UserService {

	@Value("${KAKAO_ADMIN_KEY}")
	private static String ADMIN_TOKEN;

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private KakaoOAuth2ServiceIml kakaoOAuth2;

	@Override
	public UserDto getLoginUser(UserDto user) {
		UserDto findUser = userDao.getLoginUser(user);
		if (findUser == null)
			throw new CustomException(ErrorCode.USER_NOT_FOUND);
		return findUser;
	}

	@Override
	public void saveRefreshToken(String userId, String refreshToken) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", refreshToken);
		userDao.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userId) {
		return userDao.getRefreshToken(userId);
	}

	@Override
	public void deleteRefreshToken(String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", null);
		userDao.deleteRefreshToken(map);
	}

	@Override
	public int insertUser(UserDto user) {
		// 비밀번호 암호화
		String encodedPassword = passwordEncoder.encode(user.getPwd());
		user.setPwd(encodedPassword);

		int n = userDao.insertUser(user);
		if (n == 0)
			throw new CustomException(ErrorCode.SERVER_ERROR);
		return n;
	}

	@Override
	public UserDto getUserInfo(String userId) {
		UserDto user = userDao.getUserInfo(userId);
		if (user == null)
			throw new CustomException(ErrorCode.USER_NOT_FOUND);
		return user;
	}

	@Override
	public int updateUser(UserDto user) {
		int n = userDao.updateUser(user);
		if (n == 0)
			throw new CustomException(ErrorCode.SERVER_ERROR);
		return n;
	}

	@Override
	public int deleteUser(UserDto user) {
		int n = userDao.deleteUser(user);
		if (n == 0)
			throw new CustomException(ErrorCode.SERVER_ERROR);
		return n;
	}

	@Override
	public String findById(UserDto user) {
		String id = userDao.findById(user);
		if (id == null || id.equals(""))
			throw new CustomException(ErrorCode.USER_NOT_FOUND);
		return id;
	}

	@Override
	public String findByPwd(UserDto user) {
		String pwd = userDao.findByPwd(user);
		if (pwd == null || pwd.equals(""))
			throw new CustomException(ErrorCode.USER_NOT_FOUND);
		return pwd;
	}

	@Override
	public int modifyPwd(UserDto user) {
		int n = userDao.modifyPwd(user);
		if (n == 0)
			throw new CustomException(ErrorCode.SERVER_ERROR);
		return n;
	}

	@Override
	public int idCheck(String id) {
		int n = userDao.countById(id);
		if (n == 0)
			throw new CustomException(ErrorCode.SERVER_ERROR);
		return n;
	}

	@Override
	public int kakaoLogin(String code) {
		KakaoUserInfo userInfo = kakaoOAuth2.getUserInfo(code);

		String id = userInfo.getNickname();
		String password = userInfo.getId() + ADMIN_TOKEN;

		int cnt = userDao.countById(id);
		// 이미 가입되어 있는 유저
		if (cnt != 0)
			return cnt;

		// 미가입 시 회원 정보 저장
		String encodedPassword = passwordEncoder.encode(password);

		UserDto user = UserDto.builder()
				.id(id)
				.pwd(encodedPassword)
				.name(id)
				.phoneNumber(null)
				.role("user")
				.build();

		int n = userDao.insertUser(user);
		if(n == 0)	throw new CustomException(ErrorCode.SERVER_ERROR);
		return n;
	}
}
