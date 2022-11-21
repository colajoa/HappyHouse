package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.BoardDao;
import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.exception.CustomException;
import com.ssafy.happyhouse.exception.ErrorCode;

@Service
public class BoardServiceImpl implements BoardService{
    
    @Autowired
	BoardDao boardDao;

	@Override
	public int insertBoard(BoardDto board) {
		int n = boardDao.insertBoard(board);
		if(n == 0)	throw new CustomException(ErrorCode.SERVER_ERROR);
		return n;
	}

	@Override
	public List<BoardDto> listBoard() {
		List<BoardDto> boards = boardDao.listBoard();
		if(boards.size() == 0)	throw new CustomException(ErrorCode.NULL_VALUE);
		return boards;
	}

	@Override
	public int visitBoard(int id){
		int n = boardDao.visitBoard(id);
		if(n == 0)	throw new CustomException(ErrorCode.SERVER_ERROR);
		return n;
	}
	
	@Override
	public BoardDto detailBoard(int id) {
		BoardDto board = boardDao.detailBoard(id);
		if(board == null)	throw new CustomException(ErrorCode.NULL_VALUE);
		return board;
	}

	@Override
	public int updateBoard(BoardDto board) {
		int n = boardDao.updateBoard(board);
		if(n == 0)	throw new CustomException(ErrorCode.SERVER_ERROR);
		return n;
	}

	@Override
	public int deleteBoard(int id) {
		int n = boardDao.deleteBoard(id);
		if(n == 0)	throw new CustomException(ErrorCode.SERVER_ERROR);
		return n;
	}
}
