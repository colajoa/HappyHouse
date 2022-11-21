package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.QnaDao;
import com.ssafy.happyhouse.dto.QnaDto;
import com.ssafy.happyhouse.exception.CustomException;
import com.ssafy.happyhouse.exception.ErrorCode;

@Service
public class QnaServiceImpl implements QnaService{
    
    @Autowired
	QnaDao qnaDao;

	@Override
	public int insertQna(QnaDto qna) {
		int n = qnaDao.insertQna(qna);
		if(n == 0)	throw new CustomException(ErrorCode.SERVER_ERROR);
		return n;
	}

	@Override
	public List<QnaDto> listQna() {
		List<QnaDto> qnas = qnaDao.listQna();
		if(qnas.size() == 0)	throw new CustomException(ErrorCode.NULL_VALUE);
		return qnas;
	}

	@Override
	public int visitQna(int id){
		int n = qnaDao.visitQna(id);
		if(n == 0)	throw new CustomException(ErrorCode.SERVER_ERROR);
		return n;
	}
	
	@Override
	public QnaDto detailQna(int id) {
		QnaDto qna = qnaDao.detailQna(id);
		if(qna == null)		throw new CustomException(ErrorCode.NULL_VALUE);
		return qna;
	}

	@Override
	public int updateQna(QnaDto qna) {
		int n = qnaDao.updateQna(qna);
		if(n == 0)	throw new CustomException(ErrorCode.SERVER_ERROR);
		return n;
	}

	@Override
	public int deleteQna(int id) {
		int n = qnaDao.deleteQna(id);
		if(n == 0)	throw new CustomException(ErrorCode.SERVER_ERROR);
		return n;
	}
}
