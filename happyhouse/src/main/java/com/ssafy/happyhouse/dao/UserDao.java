package com.ssafy.happyhouse.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.UserDto;

@Mapper
public interface UserDao {
	public UserDto getLoginUser(UserDto user);

	public void saveRefreshToken(Map<String, String> map);

	public Object getRefreshToken(String userId);

	public void deleteRefreshToken(Map<String, String> map);

	public int insertUser(UserDto user);

	public UserDto getUser(String userId);

	public int updateUser(UserDto user);

	public int deleteUser(UserDto user);

	public UserDto findId(UserDto user);

	public UserDto findPwd(UserDto user);

	public int idCheck(UserDto user);
}
