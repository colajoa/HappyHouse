package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.AreaDto;

public interface AreaService {
    int registArea(AreaDto dto);

	List<AreaDto> getList(String userId);

	int removeArea(AreaDto dto);
}
