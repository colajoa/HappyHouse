package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.AreaDao;
import com.ssafy.happyhouse.dto.AreaDto;

@Service
public class AreaServiceImpl implements AreaService{
    
    @Autowired
	AreaDao areaDao;

	@Override
	public int registArea(AreaDto dto) {
		return areaDao.registArea(dto);
	}

	@Override
	public List<AreaDto> getList(String userId) {
		return areaDao.getList(userId);
	}

	@Override
	public int removeArea(AreaDto dto) {
		return areaDao.removeArea(dto);
	}
}
