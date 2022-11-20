package com.ssafy.happyhouse.auth.service;

import com.ssafy.happyhouse.dto.KakaoUserInfo;

public interface KakaoOAuth2Service {
    KakaoUserInfo getUserInfo(String code);
}
