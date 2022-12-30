package com.ssafy.happyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.QnaDao;
import com.ssafy.happyhouse.dao.ReplyQnaDao;
import com.ssafy.happyhouse.dto.QnaDto;
import com.ssafy.happyhouse.dto.ReplyQnaDto;
import com.ssafy.happyhouse.exception.CustomException;
import com.ssafy.happyhouse.exception.ErrorCode;

@Service
public class ReplyQnaServiceImpl implements ReplyQnaService{

    @Autowired
    ReplyQnaDao replyDao;

    @Autowired
    QnaDao qnaDao;

    @Override
    public int replyQna(ReplyQnaDto reply) {
        int n = replyDao.replyQna(reply);

        if(n == 0)  {
            throw new CustomException(ErrorCode.SERVER_ERROR);
        }

        // 답변 등록 시 qna 테이블에 isReply = true;
        QnaDto qna = QnaDto.builder()
            .idx(reply.getQnaid())
            .isReply(true)
            .build();
        qnaDao.replyQna(qna);
        return n;
    }

    @Override
    public ReplyQnaDto getReplyDetail(int idx) {
        ReplyQnaDto reply = replyDao.detailReply(idx);
        if(reply == null)   {
            throw new CustomException(ErrorCode.NULL_VALUE);
        }
        return reply;
    }

    @Override
    public int updateReply(ReplyQnaDto reply) {
        int n = replyDao.updateReply(reply);
        if(n == 0)  {
            throw new CustomException(ErrorCode.SERVER_ERROR);
        }
        return n;
    }

    @Override
    public int deleteReply(int idx) {
        ReplyQnaDto reply = getReplyDetail(idx);
        int n = replyDao.deleteReply(idx);

        if(n == 0)  {
            throw new CustomException(ErrorCode.SERVER_ERROR);
        }

        QnaDto qna = QnaDto.builder()
            .idx(reply.getQnaid())
            .isReply(false)
            .build();
        qnaDao.replyQna(qna);
        return n;
    }
    
}
