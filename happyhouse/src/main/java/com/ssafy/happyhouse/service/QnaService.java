package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.QnaDto;

public interface QnaService {
    int insertQna(QnaDto qna);
	List<QnaDto> listQna();
	int visitQna(int id);
	QnaDto detailQna(int id);
	int updateQna(QnaDto qna);
	int deleteQna(int id);
}
