package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.QnaDto;
import com.ssafy.happyhouse.service.QnaService;

@RestController
@RequestMapping("/qna")
public class QnaController {
    
    @Autowired
    private QnaService qnaService;
    
    /**
     * QNA 등록
     * 
     * @param qna
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<?> registQna(@RequestBody QnaDto qna){
        int n = qnaService.insertQna(qna);
        if(n > 0)   return ResponseEntity.ok(HttpStatus.OK);
        return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**
     * QNA 목록
     * 
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<?> listQnas(){
        List<QnaDto> list = qnaService.listQna();
        if(list.size() > 0) return ResponseEntity.ok(list);
        return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * QnA 조회수 증가
     * 
     * @param id
     * @return
     */
    @GetMapping("/hit/{id}")
    public ResponseEntity<?> hitQna(@PathVariable("id") int id){
        int n = qnaService.visitQna(id);
        if(n != 0)  return ResponseEntity.ok(HttpStatus.OK);
        return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * QNA 조회
     * 
     * @param id
     * @return
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detailQna(@PathVariable("id") int id){
        QnaDto qna = qnaService.detailQna(id);

        if(qna != null)    return ResponseEntity.ok(qna);
        return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * QNA 수정
     * 
     * @param qna
     * @return
     */
    @PutMapping("/post")
    public ResponseEntity<?> modifyQna(@RequestBody QnaDto qna){
        int n = qnaService.updateQna(qna);
        if(n > 0)   return ResponseEntity.ok(HttpStatus.OK);
        return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * QNA 삭제
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deleteQna(@PathVariable("id") int id){
        int n = qnaService.deleteQna(id);
        if(n > 0)   return ResponseEntity.ok(HttpStatus.OK);
        return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
