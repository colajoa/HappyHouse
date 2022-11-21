package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.AreaDao;
import com.ssafy.happyhouse.dto.AreaDto;
import com.ssafy.happyhouse.exception.CustomException;
import com.ssafy.happyhouse.exception.ErrorCode;

@Service
public class AreaServiceImpl implements AreaService{
    
    @Autowired
	AreaDao areaDao;

	@Override
	public int registArea(AreaDto dto) {
		int n = areaDao.registArea(dto);
		if(n == 0)	throw new CustomException(ErrorCode.SERVER_ERROR);
		return n;
	}

	@Override
	public List<AreaDto> getList(String userId) {
		List<AreaDto> list = areaDao.getList(userId);
		if(list.size() == 0)	throw new CustomException(ErrorCode.NULL_VALUE);
		return list;
	}

	@Override
	public int removeArea(AreaDto dto) {
		int n = areaDao.removeArea(dto);
		if(n == 0)	throw new CustomException(ErrorCode.SERVER_ERROR);
		return n;
	}
}
