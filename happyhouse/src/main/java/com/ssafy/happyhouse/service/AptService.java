package com.ssafy.happyhouse.service;

import java.util.ArrayList;

import com.ssafy.happyhouse.dto.AptDeal;
import com.ssafy.happyhouse.dto.CodeDto;

public interface AptService {
	ArrayList<CodeDto> getSido(CodeDto area) throws Exception;
	ArrayList<CodeDto> getGugun(CodeDto area) throws Exception;
	ArrayList<CodeDto> getDong(CodeDto area) throws Exception;
	ArrayList<AptDeal> getAptList(String code, int dealYear, int dealMonth) throws Exception;
}
