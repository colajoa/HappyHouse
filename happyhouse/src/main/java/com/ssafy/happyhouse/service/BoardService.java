package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.BoardDto;

public interface BoardService {
    int insertBoard(BoardDto board);
	List<BoardDto> getBoardList();
	int visitBoard(int id);
	BoardDto getBoardDetail(int id);
	int updateBoard(BoardDto board);
	int deleteBoard(int id);
}
