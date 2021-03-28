package com.daytwo.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.daytwo.db.SqlMapConfig;
import com.daytwo.dto.LoginDto;

public class LoginDao extends SqlMapConfig {
	
	/*
	 * 관리자 기능
	 * 1. 회원 전체 정보 확인
	 * 2. 회원 등급 조정 
	 * 
	 */
	
	//1. 전체정보
	public List<LoginDto> selectAllUser(){
		SqlSession session = null;
		
		List<LoginDto> list = new ArrayList<LoginDto>();
		
		session = getSqlSessionFactory().openSession(true);
		list = session.selectList("boardmapper.selectList");
		
		session.close();
		
		
		
		return list;
	}

}