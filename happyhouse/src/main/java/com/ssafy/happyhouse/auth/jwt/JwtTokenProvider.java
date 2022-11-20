package com.ssafy.happyhouse.auth.jwt;

import java.util.Date;

import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtTokenProvider {
  private static final String JWT_SECRET = "secretKey";

  // token valid time
  private static final int JWT_EXPIRATION_MS = 604800000;

  // Generate JWT Token
  public static String generateToken(Authentication authentication){
    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION_MS);

    return Jwts.builder()
    .setSubject((String) authentication.getPrincipal())
    .setIssuedAt(new Date())
    .setExpiration(expiryDate)
    .signWith(SignatureAlgorithm.HS256, JWT_SECRET)
    .compact();
  }

  // Extract ID from JWT Token
  public static String getUserIdFromJWT(String token){
    Claims claims = Jwts.parser()
    .setSigningKey(JWT_SECRET)
    .parseClaimsJws(token)
    .getBody();

    return claims.getSubject();
  }

  // Check validation of JWT Token
  public static boolean validateToken(String token){
    try{
      Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
      return true;
    } catch(SignatureException ex){
      log.error("Invalid JWT signature");
    } catch(MalformedJwtException ex){
      log.error("Invalid JWT token");
    } catch(ExpiredJwtException ex) {
      log.error("Expired JWT token");
    } catch(UnsupportedJwtException ex){
      log.error("Unsupported JWT token");
    } catch(IllegalArgumentException ex){
      log.error("JWT claims string is empty.");
    }

    return false;
  }
}
