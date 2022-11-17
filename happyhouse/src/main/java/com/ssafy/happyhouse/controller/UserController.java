package com.ssafy.happyhouse.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.config.JwtTokenProvider;
import com.ssafy.happyhouse.config.UserAuthentication;
import com.ssafy.happyhouse.dto.Token;
import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.dto.Token.Response;
import com.ssafy.happyhouse.service.JwtServiceImpl;
import com.ssafy.happyhouse.service.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private JwtServiceImpl jwtService;

    /**
     * 회원 가입
     * 
     * @param user
     * @return
     */
    @PostMapping("/join")
    public ResponseEntity<?> register(@RequestBody UserDto user) {
        int n = userService.insertUser(user);
        if (n > 0) {
            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 로그인
     * 
     * @param user
     * @param session
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(HttpServletRequest request, HttpServletResponse response, @Validated @RequestBody Token.Request user) {
        UserDto findUser = userService.getLoginUser(UserDto.builder().id(user.getId()).pwd(user.getSecret()).build());

        if(!user.getSecret().equals(findUser.getPwd())){
            throw new IllegalArgumentException("비밀번호를 확인하세요.");
        }

        Authentication authentication = new UserAuthentication(user.getId(), null, null);
        String token = JwtTokenProvider.generateToken(authentication);

        Response res = Response.builder().token(token).build();

        return ResponseEntity.ok(res);
    }

    @GetMapping("/info")
    public ResponseEntity<?> userInfo(HttpServletRequest request){
        String token = request.getHeader("Authorization").substring("Bearer ".length());
        String userId = JwtTokenProvider.getUserIdFromJWT(token);

        UserDto user = userService.getUser(userId);

        return ResponseEntity.ok(user);
        // return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * 회원정보 수정
     * 
     * @param updateInfo
     * @param session
     * @return
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserDto updateInfo, HttpSession session) {
        int n = userService.updateUser(updateInfo);
        if (n > 0) {
            session.setAttribute("loginUser", updateInfo);
            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 회원 탈퇴
     * 
     * @param deleteInfo
     * @param session
     * @return
     */
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUser(@RequestBody UserDto deleteInfo, HttpSession session) {
        int n = userService.deleteUser(deleteInfo);
        if (n > 0) {
            session.invalidate();
            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 로그아웃
     * 
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        /* session.invalidate();*/
        Map<String, Object> map = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * 아이디 중복 체크
     * 
     * @param user
     * @return
     */
    @PostMapping("/idCheck")
    public ResponseEntity<?> idCheck(@RequestBody UserDto user) {
        int n = userService.idCheck(user);
        System.out.println("Call");
        if (n == 0) {
            return ResponseEntity.ok(HttpStatus.OK);
        } else {
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 비밀번호 찾기
     * 
     * @param user
     * @return
     */
    @PostMapping("/findPwd")
    public ResponseEntity<?> findPwd(@RequestBody UserDto user) {
        UserDto findUser = userService.findPwd(user);
        if (findUser != null) {
            return ResponseEntity.ok(findUser);
        } else {
            return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
