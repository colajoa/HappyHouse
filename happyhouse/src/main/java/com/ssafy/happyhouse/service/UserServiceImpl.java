package com.ssafy.happyhouse.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.UserDao;
import com.ssafy.happyhouse.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

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
	public UserDto getUser(String userId){
		return userDao.getUser(userId);
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
	public UserDto findId(UserDto user){
		return userDao.findId(user);
	}

	@Override
	public UserDto findPwd(UserDto user) {
		return userDao.findPwd(user);
	}

	@Override
	public int idCheck(UserDto user) {
		return userDao.idCheck(user);
	}
}
