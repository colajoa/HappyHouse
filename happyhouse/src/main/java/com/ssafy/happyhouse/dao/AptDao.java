package com.ssafy.happyhouse.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.AptDeal;
import com.ssafy.happyhouse.dto.CodeDto;

@Mapper
public interface AptDao {
    ArrayList<CodeDto> getSido(CodeDto data) throws SQLException;

	ArrayList<CodeDto> getGugun(CodeDto data) throws SQLException;

	ArrayList<CodeDto> getDong(CodeDto data) throws SQLException;

	ArrayList<AptDeal> getAptList(String code, int dealYear, int dealMonth) throws SQLException;
}
