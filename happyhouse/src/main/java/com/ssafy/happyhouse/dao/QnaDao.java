package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.QnaDto;

@Mapper
public interface QnaDao {
    int insertQna(QnaDto qna);

	List<QnaDto> listQna();

	int visitQna(int idx);

	QnaDto detailQna(int idx);

	int updateQna(QnaDto qna);

	int deleteQna(int idx);

	int replyQna(QnaDto qna);
}
