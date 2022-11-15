package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.AptDeal;
import com.ssafy.happyhouse.dto.CodeDto;
import com.ssafy.happyhouse.service.AptServiceImpl;

@RestController
@RequestMapping("/apt")
public class AptController {

    @Autowired
    private AptServiceImpl aptService;

    // 시도 목록 불러오기
    @GetMapping("/sido/")
    public ResponseEntity<?> getSido() throws Exception{
        List<CodeDto> list = aptService.getSido(null);

        if(list.size() > 0) return ResponseEntity.ok(list);
        // ERROR
        return ResponseEntity.ok(HttpStatus.FORBIDDEN);
    }

    /**
     * 구군 정보 불러오기
     * 
     * @param code
     * @return
     */
    @GetMapping("/gugun/{code}")
    public ResponseEntity<?> getGugun(@PathVariable("code") String code) throws Exception{
        CodeDto data = CodeDto.builder().code(code).build();
        List<CodeDto> list = aptService.getGugun(data);
        if(list.size() > 0) return ResponseEntity.ok(list);
        // ERROR
        return ResponseEntity.ok(HttpStatus.FORBIDDEN);
    }

    /**
     * 동 코드 불러오기
     * 
     * @param code
     * @return
     */
    @GetMapping("/dong/{code}")
    public ResponseEntity<?> getDong(@PathVariable("code") String code) throws Exception{
        CodeDto data = CodeDto.builder().code(code).build();
        List<CodeDto> list = aptService.getDong(data);

        if(list.size() > 0) return ResponseEntity.ok(list);
        // ERROR
        return ResponseEntity.ok(HttpStatus.FORBIDDEN);
    }

    /**
     * 아파트 매매가 정보 불러오기
     * 
     * @param code
     * @param dealYear
     * @param dealMonth
     * @return 
     */
    @GetMapping("/aptlist/{code}/{dealYear}/{dealMonth}")
    public ResponseEntity<?> getAptList(@PathVariable("code") String code,
        @PathVariable("dealYear") int dealYear,
        @PathVariable("dealMonth") int dealMonth) throws Exception{
        
        List<AptDeal> list = aptService.getAptList(code, dealYear, dealMonth);

        return ResponseEntity.ok(list);
    }
}