package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.QnaDto;

@Mapper
public interface QnaDao {
    int insertQna(QnaDto qna);

	List<QnaDto> listQna();

	int visitQna(int id);

	QnaDto detailQna(int id);

	int updateQna(QnaDto qna);

	int deleteQna(int id);

	int replyQna(QnaDto qna);
}
