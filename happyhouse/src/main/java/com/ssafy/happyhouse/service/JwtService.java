package com.ssafy.happyhouse.service;

import java.util.Map;

public interface JwtService {
  <T> String createAccessToken(String key, T data);
  <T> String createRefreshToken(String key, T data);
  <T> String create(String key, T data, String subject, long expire);
  boolean checkToken(String jwt);
  Map<String, Object> get(String key);
  String getUserId();
}
