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

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardController {
    
    @Autowired
    private BoardService boardService;
    
    @PostMapping("/register")
    public ResponseEntity<?> registBoard(@RequestBody BoardDto board){
        int n = boardService.insertBoard(board);
        if(n > 0)   return ResponseEntity.ok(HttpStatus.OK);
        return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/list")
    public ResponseEntity<?> listBoard(){
        List<BoardDto> list = boardService.listBoard();
        if(list.size() > 0) return ResponseEntity.ok(list);
        return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detailBoard(@PathVariable("id") int id){
        BoardDto board = boardService.detailBoard(id);

        if(board != null)    return ResponseEntity.ok(board);
        return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/post")
    public ResponseEntity<?> modifyBoard(@RequestBody BoardDto board){
        int n = boardService.updateBoard(board);
        if(n > 0)   return ResponseEntity.ok(HttpStatus.OK);
        return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") int id){
        int n = boardService.deleteBoard(id);
        if(n > 0)   return ResponseEntity.ok(HttpStatus.OK);
        return ResponseEntity.ok(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
