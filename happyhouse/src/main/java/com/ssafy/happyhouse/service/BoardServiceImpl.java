package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.BoardDao;
import com.ssafy.happyhouse.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService{
    
    @Autowired
	BoardDao boardDao;

	@Override
	public int insertBoard(BoardDto board) {
		return boardDao.insertBoard(board);
	}

	@Override
	public List<BoardDto> listBoard() {
		return boardDao.listBoard();
	}
	
	@Override
	public BoardDto detailBoard(int id) {
		return boardDao.detailBoard(id);
	}

	@Override
	public int updateBoard(BoardDto board) {
		return boardDao.updateBoard(board);
	}

	@Override
	public int deleteBoard(int id) {
		return boardDao.deleteBoard(id);
	}
}
