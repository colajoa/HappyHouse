package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.AreaDto;

@Mapper
public interface AreaDao {
    int registArea(AreaDto dto);

	List<AreaDto> getList(String userId);

	int removeArea(AreaDto dto);
}
