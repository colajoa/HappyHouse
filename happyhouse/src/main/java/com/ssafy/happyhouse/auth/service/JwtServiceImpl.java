package com.ssafy.happyhouse.auth.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtServiceImpl implements JwtService {
private static final Logger logger = LoggerFactory.getLogger(JwtServiceImpl.class);

  private static final String SALT = "ssafySecret";
  private static final int ACCESS_TOKEN_EXPIRE_MINUTES = 1; // 분단위
  private static final int REFRESH_TOKEN_EXPIRE_MINUTES = 2; // 주단위

  @Override
  public <T> String createAccessToken(String key, T data) {
    return create(key, data, "access-token", 1000 * 10 * ACCESS_TOKEN_EXPIRE_MINUTES);
  }

  @Override
  public <T> String createRefreshToken(String key, T data) {
    return create(key, data, "refresh-token", 1000 * 30 * ACCESS_TOKEN_EXPIRE_MINUTES);
  }

  // Token
  @Override
  public <T> String create(String key, T data, String subject, long expire) {
    String jwt = Jwts.builder()
        .setHeaderParam("typ", "JWT")
        .setHeaderParam("regDate", System.currentTimeMillis())
        .setExpiration(new Date(System.currentTimeMillis()))
        .setSubject(subject)
        .claim(key, data)
        .signWith(SignatureAlgorithm.HS256, this.generateKey())
        .compact();

    return jwt;
  }

  // Create key in Signature setting
  private byte[] generateKey(){
    byte[] key = null;
    try{
      key = SALT.getBytes("UTF-8");
    } catch(UnsupportedEncodingException e){
      if(logger.isInfoEnabled()){
        e.printStackTrace();
      } else {
        logger.error("Making JWT Key Error ::: {}", e.getMessage());
      }
    }
    return key;
  }

  // 토큰 확인 
  @Override
  public boolean checkToken(String jwt){
    try{
      Jws<Claims> claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt);
      logger.debug("claims: {}", claims);
      return true;
    } catch(Exception e){
      if(logger.isInfoEnabled()){
        e.printStackTrace();
      } else {
        logger.error(e.getMessage());
      }
      return false;
    }
  }

  @Override
  public Map<String, Object> get(String key){
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    String jwt = request.getHeader("access-token");
    Jws<Claims> claims = null;

    try{
      claims = Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(jwt);
    } catch (Exception e){
      if(logger.isInfoEnabled()){
        e.printStackTrace();
      } else {
        logger.error(e.getMessage());
      }
    }

    Map<String, Object> value = claims.getBody();
    logger.info("value: {}", value);
    return value;
  }

  @Override
  public String getUserId(){
    return (String) this.get("user").get("userid");
  }
}
