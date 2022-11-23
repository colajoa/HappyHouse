package com.ssafy.happyhouse.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReplyQnaDto {
    private int idx;
    private int qnaid;
    private String content;
    private Date createdat;

    @Builder
    public ReplyQnaDto(int idx, int qnaId, String content, Date createdAt) {
        this.idx = idx;
        this.qnaid = qnaId;
        this.content = content;
        this.createdat = createdAt;
    }

}
