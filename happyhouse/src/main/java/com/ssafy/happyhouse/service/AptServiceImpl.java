package com.ssafy.happyhouse.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.AptDao;
import com.ssafy.happyhouse.dto.AptDeal;
import com.ssafy.happyhouse.dto.CodeDto;
import com.ssafy.happyhouse.exception.CustomException;
import com.ssafy.happyhouse.exception.ErrorCode;

@Service
public class AptServiceImpl implements AptService{
    
    @Autowired
	AptDao aptDao;

	@Override
	public ArrayList<CodeDto> getSido(CodeDto area) throws Exception {
		ArrayList<CodeDto> sido = aptDao.getSido(area);
		if(sido.size() == 0)	{
			throw new CustomException(ErrorCode.NULL_VALUE);
		}
		return sido;
	}

	@Override
	public ArrayList<CodeDto> getGugun(CodeDto area) throws Exception {
		ArrayList<CodeDto> gugun = aptDao.getGugun(area);
		if(gugun.size() == 0)	{
			throw new CustomException(ErrorCode.NULL_VALUE);
		}
		return gugun;
	}

	@Override
	public ArrayList<CodeDto> getDong(CodeDto area) throws Exception {
		ArrayList<CodeDto> dong = aptDao.getDong(area);
		if(dong.size() == 0)	{
			throw new CustomException(ErrorCode.NULL_VALUE);
		}
		return dong;
	}

	@Override
	public ArrayList<AptDeal> getAptList(String code, int dealYear, int dealMonth) throws Exception {
		ArrayList<AptDeal> apts = aptDao.getAptList(code, dealYear, dealMonth);
		if(apts.size() == 0)	{
			throw new CustomException(ErrorCode.NULL_VALUE);
		}
		return apts;
	}

}
