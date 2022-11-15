package com.ssafy.happyhouse.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.AptDao;
import com.ssafy.happyhouse.dto.AptDeal;
import com.ssafy.happyhouse.dto.CodeDto;

@Service
public class AptServiceImpl implements AptService{
    
    @Autowired
	AptDao aptDao;

	@Override
	public ArrayList<CodeDto> getSido(CodeDto area) throws Exception {
		return aptDao.getSido(area);
	}

	@Override
	public ArrayList<CodeDto> getGugun(CodeDto area) throws Exception {
		return aptDao.getGugun(area);
	}

	@Override
	public ArrayList<CodeDto> getDong(CodeDto area) throws Exception {
		return aptDao.getDong(area);
	}

	@Override
	public ArrayList<AptDeal> getAptList(String code, int dealYear, int dealMonth) throws Exception {
		return aptDao.getAptList(code, dealYear, dealMonth);
	}

}
