package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.QnaDto;

@Mapper
public interface QnaDao {
    int insertQna(QnaDto post);

	List<QnaDto> listQna();

	QnaDto detailQna(int id);

	int updateQna(QnaDto post);

	int deleteQna(int id);
}
