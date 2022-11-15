package com.ssafy.happyhouse.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.UserDto;

@Mapper
public interface UserDao {
    public UserDto getLoginUser(UserDto user);

	public int insertUser(UserDto user);

	public int updateUser(UserDto user);

	public int deleteUser(UserDto user);

	public UserDto findPwd(UserDto user);

	public int idCheck(UserDto user);
}
