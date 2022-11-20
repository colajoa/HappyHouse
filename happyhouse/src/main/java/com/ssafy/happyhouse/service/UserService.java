package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.UserDto;

public interface UserService {
	// 로그인 유저
	UserDto getLoginUser(UserDto user);

	// 리프레시토큰 발급
	void saveRefreshToken(String userId, String refreshToken);

	// 리프레시토큰 받기
	Object getRefreshToken(String userId);

	// 리프레시토큰 삭제
	void deleteRefreshToken(String userId);

	// 회원가입
	int insertUser(UserDto user);

	// 유저 정보 조회
	UserDto getUserInfo(String userId);

	// 유저 정보 수정
	int updateUser(UserDto user);

	// 회원 탈퇴
	int deleteUser(UserDto user);

	String findById(UserDto user);

	// 비밀번호 찾기
	String findByPwd(UserDto user);

	// 비밀번호 수정
	int modifyPwd(UserDto user);

	// 중복 아이디 확인
	int idCheck(String id);

	int kakaoLogin(String code);
}
