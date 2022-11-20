package com.ssafy.happyhouse.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QnaDto {
    
    private int id;
	private String title;
	private String writer;
	private String content;
	private int hit;
	private String createdat;

	@Builder
	public QnaDto(int id, String title, String writer, String content, int hit, String createdat) {
		super();
		this.id = id;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.hit = hit;
		this.createdat = createdat;
	}

}
