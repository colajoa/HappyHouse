package com.ssafy.happyhouse.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.ReplyQnaDto;

@Mapper
public interface ReplyQnaDao {
    int replyQna(ReplyQnaDto reply);

    ReplyQnaDto detailReply(int idx);

    int updateReply(ReplyQnaDto reply);

    int deleteReply(int idx);
}
