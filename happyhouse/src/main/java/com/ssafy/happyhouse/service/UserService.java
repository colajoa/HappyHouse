package com.ssafy.happyhouse.service;

import java.util.Map;

import com.ssafy.happyhouse.dto.UserDto;

public interface UserService {
	// 로그인 유저
	void getLoginUser(UserDto user);

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

	// 아이디 찾기
	String findId(UserDto user);

	// 비밀번호 찾기
	String findPwd(UserDto user);

	// 비밀번호 수정
	int modifyPwd(String id, Map<String, String> passwords);

	// 중복 아이디 확인
	int checkId(String id);

	// 카카오톡 로그인
	int kakaoLogin(String code);

	// 카카오톡 유저 정보 조회
	UserDto getKakaoUser(String code);
}
