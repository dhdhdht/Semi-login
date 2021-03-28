package com.daytwo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.daytwo.db.SqlMapConfig;
import com.daytwo.dto.LoginDto;

public class LoginDao extends SqlMapConfig {

	public List<LoginDto> selectAllUser() {
		SqlSession session = null;

		List<LoginDto> list = new ArrayList<LoginDto>();

		try {
			session = getSqlSessionFactory().openSession(true);
			list = session.selectList("loginmapper.selectList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	// 회원가입 시 회원 추가
	public int insertUser(LoginDto dto) {

		int res = 0;

		try (SqlSession session = getSqlSessionFactory().openSession(true);) {
			res = session.insert("loginmapper.reginsert", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;

	}

	// 로그인
	public LoginDto login(String member_id, String member_pw) {
		SqlSession session = null;
		LoginDto dto = null;
				
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("member_id", member_id);
		map.put("member_pw", member_pw);
		
		try {
			session = getSqlSessionFactory().openSession(true);
			 dto = session.selectOne("loginmapper.login", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return dto;
	}
	
	public int idCheck(String member_id) {
		SqlSession session = null;
		int res = 0;
		System.out.println("dao : " + member_id);
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.selectOne("loginmapper.idCheck", member_id);
			
			if(res>0) {
				res=1;
			}else {
				res=0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return res;
	}

}
