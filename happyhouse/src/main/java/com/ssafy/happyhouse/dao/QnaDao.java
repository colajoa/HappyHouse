package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.dto.QnaDto;

public interface QnaDao {
    int insertQna(QnaDto post);

	List<QnaDto> listQna();

	QnaDto detailQna(int id);

	int updateQna(QnaDto post);

	int deleteQna(int id);
}
