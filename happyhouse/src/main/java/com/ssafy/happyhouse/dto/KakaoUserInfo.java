package com.ssafy.happyhouse.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class KakaoUserInfo {
    Long id;
    String email;
    String nickname;

    @Builder
    public KakaoUserInfo(Long id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }
}
