package com.ssafy.happyhouse.auth.service;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.ssafy.happyhouse.dto.KakaoUserInfo;

@Service
public class KakaoOAuth2ServiceIml implements KakaoOAuth2Service{

    @Override
    public KakaoUserInfo getUserInfo(String code){
        KakaoUserInfo userInfo = getUserInfoByToken(code);

        return userInfo;
    }
    
    private KakaoUserInfo getUserInfoByToken(String accessToken){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        headers.add("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

        RestTemplate rt = new RestTemplate();
        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest = new HttpEntity<>(headers);

        ResponseEntity<String> response = rt.exchange("https://kapi.kakao.com/v2/user/me", HttpMethod.POST, kakaoProfileRequest, String.class);

        JSONObject body = new JSONObject(response.getBody());
        Long id = body.getLong("id");
        String nickname = body.getJSONObject("properties").getString("nickname");

        return new KakaoUserInfo(id, nickname);
    }
}
