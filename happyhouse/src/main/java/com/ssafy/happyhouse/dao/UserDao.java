package com.ssafy.happyhouse.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.UserDto;

@Mapper
public interface UserDao {
	public UserDto getLoginUser(String id);

	public void saveRefreshToken(Map<String, String> map);

	public Object getRefreshToken(String userId);

	public void deleteRefreshToken(Map<String, String> map);

	public int insertUser(UserDto user);

	public UserDto getUserInfo(String userId);

	public int updateUser(UserDto user);

	public int deleteUser(UserDto user);

	public String findId(UserDto user);

	public String findPwd(UserDto user);

	public int findUserByIdPwd(UserDto user);

	public int modifyPwd(UserDto user);

	public int countById(String id);
}
