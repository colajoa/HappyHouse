package com.ssafy.happyhouse.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter{

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
  throws ServletException, IOException{
    try{
      String jwt = getJwtFromRequest(request);
      if(jwt != null && JwtTokenProvider.validateToken(jwt)){
        String userId = JwtTokenProvider.getUserIdFromJWT(jwt);

        UserAuthentication authentication = new UserAuthentication(userId, null, null);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authentication);
      } else {
        if(jwt == null){
          request.setAttribute("unauthorization", "401 인증키 없음");
        }
        if(JwtTokenProvider.validateToken(jwt)){
          request.setAttribute("unauthorization", "401-001 인증키 만료");
        }
      }
    }catch(Exception ex) {
      log.error("Could not set user authentication in security context", ex);
    }
    filterChain.doFilter(request, response);
  }
  
  private String getJwtFromRequest(HttpServletRequest request){
    String bearerToken = request.getHeader("Authorization");
    if(!bearerToken.isEmpty() && bearerToken.startsWith("Bearer ")){
      return bearerToken.substring("Bearer ".length());
    }

    return null;
  }
}
