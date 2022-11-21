package com.ssafy.happyhouse.service;

import com.ssafy.happyhouse.dto.ReplyQnaDto;

public interface ReplyQnaService {
    int replyQna(ReplyQnaDto reply);

    ReplyQnaDto detailReply(int idx);

    int updateReply(ReplyQnaDto reply);

    int deleteReply(int idx);
}
