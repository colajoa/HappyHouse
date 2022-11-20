package com.ssafy.happyhouse.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    
    ID_EXISTS(HttpStatus.FORBIDDEN, "이미 사용중인 아이디입니다."),
    USER_NOT_FOUND(HttpStatus.NO_CONTENT, "해당하는 정보의 사용자를 찾을 수 없습니다."),
    INVALID_PASSWORD(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다."),
    LOGIN_REQUIRED(HttpStatus.UNAUTHORIZED, "로그인이 필요한 페이지입니다."),
    NOT_ADMIN(HttpStatus.UNAUTHORIZED, "관리자만 사용가능한 기능입니다."),
    NULL_VALUE(HttpStatus.NO_CONTENT, "값이 존재하지 않습니다."),
    ;

    private final HttpStatus status;
    private final String message;
}
