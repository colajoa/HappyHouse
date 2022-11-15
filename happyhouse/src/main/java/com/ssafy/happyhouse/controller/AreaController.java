package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.AreaDto;
import com.ssafy.happyhouse.dto.UserDto;
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
    @GetMapping("/area/{dongCode}")
    public ResponseEntity<?> registerIArea(
        @PathVariable("dongCode") String dongcode,
        HttpServletRequest request){

        // Check Login
        HttpSession session = request.getSession();
        UserDto user = (UserDto) session.getAttribute("loginUser");

        // Set InterestArea
        AreaDto areaDto = AreaDto.builder()
                                            .userId(user.getId())
                                            .dongcode(dongcode)
                                            .build();

        int n = iAreaService.registArea(areaDto);
        
        if(n > 0)   return ResponseEntity.ok(HttpStatus.OK);
        return ResponseEntity.ok(HttpStatus.FORBIDDEN);
    }

    /**
     * 관심지역 정보 불러오기
     * 
     * @param session
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<?> listIArea(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDto user = (UserDto)session.getAttribute("loginUser");
        List<AreaDto> list = iAreaService.getList(user.getId());

        if(list.size() > 0) return ResponseEntity.ok(list);
        return ResponseEntity.ok(HttpStatus.FORBIDDEN);
    }

    /**
     * 관심지역 정보 삭제하기
     * 
     * @param dongcode
     * @param session
     * @return
     */
    @DeleteMapping("/area/{dongcode}")
    public ResponseEntity<?> removeIArea(@PathVariable("dongcode") String dongcode, HttpSession session){
        UserDto user = (UserDto) session.getAttribute("loginUser");
        AreaDto iAreaDto = AreaDto.builder()
                                        .dongcode(dongcode)
                                        .userId(user.getId())
                                        .build();
        int n = iAreaService.removeArea(iAreaDto);

        if(n > 0) return ResponseEntity.ok(HttpStatus.OK);
        return ResponseEntity.ok(HttpStatus.FORBIDDEN);
    }
}
