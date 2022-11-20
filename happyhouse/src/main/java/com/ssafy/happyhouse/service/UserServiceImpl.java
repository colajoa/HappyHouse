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
		return userDao.getLoginUser(user);
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
		return userDao.insertUser(user);
	}

	@Override
	public UserDto getUserInfo(String userId){
		return userDao.getUserInfo(userId);
	}

	@Override
	public int updateUser(UserDto user) {
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUser(UserDto user) {
		return userDao.deleteUser(user);
	}

	@Override
	public String findById(UserDto user){
		return userDao.findById(user);
	}

	@Override
	public String findByPwd(UserDto user) {
		return userDao.findByPwd(user);
	}

	@Override
	public int idCheck(String id) {
		return userDao.countById(id);
	}

	@Override
	public int kakaoLogin(String code){
		KakaoUserInfo userInfo = kakaoOAuth2.getUserInfo(code);

		String id = userInfo.getNickname();
		String password = userInfo.getId() + ADMIN_TOKEN;

		int cnt = userDao.countById(id);
		if(cnt != 0)	return cnt;
		String encodedPassword = passwordEncoder.encode(password);

		UserDto user = UserDto.builder()
		.id(id)
		.pwd(encodedPassword)
		.name(id)
		.phoneNumber(null)
		.role("user")
		.build();

		return userDao.insertUser(user);
	}
}
