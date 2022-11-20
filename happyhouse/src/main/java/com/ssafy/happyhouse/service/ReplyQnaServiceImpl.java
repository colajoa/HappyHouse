package com.ssafy.happyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.QnaDao;
import com.ssafy.happyhouse.dao.ReplyQnaDao;
import com.ssafy.happyhouse.dto.QnaDto;
import com.ssafy.happyhouse.dto.ReplyQnaDto;

@Service
public class ReplyQnaServiceImpl implements ReplyQnaService{

    @Autowired
    ReplyQnaDao replyDao;

    @Autowired
    QnaDao qnaDao;

    @Override
    public int replyQna(ReplyQnaDto reply) {
        int n = replyDao.replyQna(reply);

        // 답변 등록 시 qna 테이블에 isReply = true;
        QnaDto qna = QnaDto.builder().id(reply.getQnaid()).isReply(true).build();
        if(n != 0)  qnaDao.replyQna(qna);
        return n;
    }

    @Override
    public ReplyQnaDto detailReply(int idx) {
        return replyDao.detailReply(idx);
    }

    @Override
    public int updateReply(ReplyQnaDto reply) {
        return replyDao.updateReply(reply);
    }

    @Override
    public int deleteReply(int idx) {
        ReplyQnaDto reply = detailReply(idx);
        int n = replyDao.deleteReply(idx);

        QnaDto qna 
        = QnaDto.builder().id(reply.getQnaid()).isReply(false).build();
        qnaDao.replyQna(qna);
        return n;
    }
    
}
