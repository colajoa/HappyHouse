package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.BoardDto;

@Mapper
public interface BoardDao {
    int insertBoard(BoardDto post);

	List<BoardDto> listBoard();

	int visitBoard(int id);

	BoardDto detailBoard(int id);

	int updateBoard(BoardDto post);

	int deleteBoard(int id);
}
