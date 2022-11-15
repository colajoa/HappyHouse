package com.ssafy.happyhouse.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardDto {

    private int id;
	private String title;
	private String writer;
	private String content;
	private String createdAt;

	@Builder
	public BoardDto(int id, String title, String writer, String content, String createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.createdAt = createdAt;
	}
    
}
