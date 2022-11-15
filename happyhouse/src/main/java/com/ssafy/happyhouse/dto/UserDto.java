package com.ssafy.happyhouse.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    
    private String id;
	private String pwd;
	private String name;
    private String phoneNumber;
    private String role;

	@Builder
	public UserDto(String id, String pwd, String name, String phoneNumber, String role) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
	}

}
