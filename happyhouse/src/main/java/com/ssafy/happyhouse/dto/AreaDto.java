package com.ssafy.happyhouse.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AreaDto {

    private int idx;
	private String userId;
	private String dongcode;
	private String address;

	@Builder
	public AreaDto(int idx, String userId, String dongcode) {
		super();
		this.idx = idx;
		this.userId = userId;
		this.dongcode = dongcode;
	}
}
