package com.ssafy.happyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.UserDao;
import com.ssafy.happyhouse.dto.UserDto;

@Service
public class UserServiceImpl implements UserService{
    
	@Autowired
	private UserDao userDao;

	@Override
	public UserDto getLoginUser(UserDto user) {
		return userDao.getLoginUser(user);
	}

	@Override
	public int insertUser(UserDto user) {
		return userDao.insertUser(user);
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
	public UserDto findPwd(UserDto user) {
		return userDao.findPwd(user);
	}

	@Override
	public int idCheck(UserDto user) {
		return userDao.idCheck(user);
	}
}
