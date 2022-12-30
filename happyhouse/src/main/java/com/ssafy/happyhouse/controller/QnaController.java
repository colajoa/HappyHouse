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
        qnaService.insertQna(qna);
        return ResponseEntity.ok(HttpStatus.OK);
    }


    /**
     * QNA 목록
     * 
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<?> getQnaList(){
        List<QnaDto> list = qnaService.getQnaList();
        return ResponseEntity.ok(list);
    }

    /**
     * QnA 조회수 증가
     * 
     * @param id
     * @return
     */
    @GetMapping("/hit/{id}")
    public ResponseEntity<?> hitQna(@PathVariable("id") int id){
        qnaService.visitQna(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * QNA 조회
     * 
     * @param id
     * @return
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getQnaDetail(@PathVariable("id") int id){
        QnaDto qna = qnaService.getQnaDetail(id);
        return ResponseEntity.ok(qna);
    }

    /**
     * QNA 수정
     * 
     * @param qna
     * @return
     */
    @PutMapping("/{idx}")
    public ResponseEntity<?> modifyQna(@RequestBody QnaDto qna){
        qnaService.updateQna(qna);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * QNA 삭제
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQna(@PathVariable("id") int id){
        qnaService.deleteQna(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
