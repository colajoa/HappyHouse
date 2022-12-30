package com.ssafy.happyhouse.controller;

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

import com.ssafy.happyhouse.dto.ReplyQnaDto;
import com.ssafy.happyhouse.service.ReplyQnaService;

@RestController
@RequestMapping("/qna/reply")
public class ReplyQnaController {
    
    @Autowired
    private ReplyQnaService replyService;


    /**
     * QnA 답변 등록
     * 
     * @param reply
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<?> replyQna(@RequestBody ReplyQnaDto reply){
        replyService.replyQna(reply);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * QnA 답변 상세조회
     * 
     * @param idx
     * @return
     */
    @GetMapping("/detail/{idx}")
    public ResponseEntity<?> getReplyDetail(@PathVariable("idx") int idx){
        ReplyQnaDto reply = replyService.getReplyDetail(idx);
        return ResponseEntity.ok(reply);
    }

    /**
     * QnA 답변 수정
     * 
     * @param idx
     * @param reply
     * @return
     */
    @PutMapping("/{idx}")
    public ResponseEntity<?> updateReply(@PathVariable("idx") int idx, @RequestBody ReplyQnaDto reply){
        reply.setIdx(idx);
        replyService.updateReply(reply);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * QnA 답변 삭제
     * 
     * @param idx
     * @return
     */
    @DeleteMapping("/{idx}")
    public ResponseEntity<?> deleteReply(@PathVariable("idx") int idx){
        replyService.deleteReply(idx);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
