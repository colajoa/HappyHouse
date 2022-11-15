package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.QnaDao;
import com.ssafy.happyhouse.dto.QnaDto;

@Service
public class QnaServiceImpl implements QnaService{
    
    @Autowired
	QnaDao qnaDao;

	@Override
	public int insertQna(QnaDto qna) {
		return qnaDao.insertQna(qna);
	}

	@Override
	public List<QnaDto> listQna() {
		return qnaDao.listQna();
	}
	
	@Override
	public QnaDto detailQna(int id) {
		return qnaDao.detailQna(id);
	}

	@Override
	public int updateQna(QnaDto qna) {
		return qnaDao.updateQna(qna);
	}

	@Override
	public int deleteQna(int id) {
		return qnaDao.deleteQna(id);
	}
}
