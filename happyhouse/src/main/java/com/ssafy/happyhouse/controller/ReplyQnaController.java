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


    @PostMapping("/register")
    public ResponseEntity<?> replyQna(@RequestBody ReplyQnaDto reply){
        replyService.replyQna(reply);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/detail/{idx}")
    public ResponseEntity<?> detailReply(@PathVariable("idx") int idx){
        ReplyQnaDto reply = replyService.detailReply(idx);
        return ResponseEntity.ok(reply);
    }

    @PutMapping("/{idx}")
    public ResponseEntity<?> updateReply(@PathVariable("idx") int idx, @RequestBody ReplyQnaDto reply){
        reply.setIdx(idx);
        replyService.updateReply(reply);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{idx}")
    public ResponseEntity<?> deleteReply(@PathVariable("idx") int idx){
        replyService.deleteReply(idx);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
