package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.auth.jwt.JwtTokenProvider;
import com.ssafy.happyhouse.dto.AreaDto;
import com.ssafy.happyhouse.service.AreaServiceImpl;

@RestController
@RequestMapping("/area")
public class AreaController {
    
    @Autowired
    private AreaServiceImpl iAreaService;

    /**
     * 관심지역 정보 저장하기
     * 
     * @param dongcode
     * @param request
     * @return ResponseEntity
     */
    @GetMapping("/{dongCode}")
    public ResponseEntity<?> registerIArea(@PathVariable("dongCode") String dongcode, HttpServletRequest request){

        // Check Login
        String token = request.getHeader("Authorization");
        String userId = JwtTokenProvider.getUserIdFromJWT(token);

        // Set InterestArea
        AreaDto areaDto = AreaDto.builder()
                                            .userId(userId)
                                            .dongcode(dongcode)
                                            .build();

        iAreaService.registArea(areaDto);
        
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * 관심지역 정보 불러오기
     * 
     * @param request
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<?> listIArea(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String userId = JwtTokenProvider.getUserIdFromJWT(token);
        List<AreaDto> list = iAreaService.getList(userId);

        if(list.size() > 0) return ResponseEntity.ok(list);
        return ResponseEntity.ok(HttpStatus.FORBIDDEN);
    }

    /**
     * 관심지역 정보 삭제하기
     * 
     * @param dongcode
     * @param request
     * @return
     */
    @DeleteMapping("/{dongcode}")
    public ResponseEntity<?> removeIArea(@PathVariable("dongcode") String dongcode, HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String userId = JwtTokenProvider.getUserIdFromJWT(token);
        AreaDto iAreaDto = AreaDto.builder()
                                        .dongcode(dongcode)
                                        .userId(userId)
                                        .build();
        iAreaService.removeArea(iAreaDto);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
