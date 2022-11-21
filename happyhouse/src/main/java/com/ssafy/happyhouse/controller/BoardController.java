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
    
    /**
     * 공지사항 등록
     * 
     * @param board
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<?> registBoard(@RequestBody BoardDto board){
        boardService.insertBoard(board);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * 공지사항 목록
     * 
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<?> listBoard(){
        List<BoardDto> list = boardService.listBoard();
        return ResponseEntity.ok(list);
    }

    /**
     * 공지사항 조회수 증가
     * 
     * @param id
     * @return
     */
    @GetMapping("/hit/{id}")
    public ResponseEntity<?> hitBoard(@PathVariable("id") int id){
        boardService.visitBoard(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * 공지사항 조회
     * 
     * @param id
     * @return
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detailBoard(@PathVariable("id") int id){
        BoardDto board = boardService.detailBoard(id);
        return ResponseEntity.ok(board);
    }

    /**
     * 공지사항 수정
     * 
     * @param board
     * @return
     */
    @PutMapping("/post")
    public ResponseEntity<?> modifyBoard(@RequestBody BoardDto board){
        boardService.updateBoard(board);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /**
     * 공지사항 삭제
     * 
     * @param id
     * @return
     */
    @DeleteMapping("/post/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") int id){
        boardService.deleteBoard(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
