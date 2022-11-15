package com.ssafy.happyhouse.dao;

import com.ssafy.happyhouse.dto.UserDto;

public interface UserDao {
    public UserDto getLoginUser(UserDto user);

	public int insertUser(UserDto user);

	public int updateUser(UserDto user);

	public int deleteUser(UserDto user);

	public UserDto findPwd(UserDto user);

	public int idCheck(UserDto user);
}
