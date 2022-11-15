package com.ssafy.happyhouse.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CodeDto {
    
    String name;
	String code;

	@Builder
	public CodeDto(String name, String code){
		this.name = name;
		this.code = code;
	}
    
}
