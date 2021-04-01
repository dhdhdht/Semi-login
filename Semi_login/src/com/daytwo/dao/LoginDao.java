package com.daytwo.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
		LoginDto dto = new LoginDto();
		System.out.println("login : " + member_id);
		System.out.println("pw : "+ member_pw);
		
		dto.setMember_id(member_id);
		dto.setMember_pw(member_pw);
		
		try {
			session = getSqlSessionFactory().openSession(true);
			 dto = session.selectOne("loginmapper.login", dto);
			 System.out.println("test: " + dto.getMember_enabled());
			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return dto;
	}
	
	//아이디 유무 확인
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
	
	//naver로그인 이메일 중복체크
	public int naverCheck(String member_email) {
		SqlSession session = null;
		int res = 0;
		System.out.println("dao : " + member_email);
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.selectOne("loginmapper.naverCheck", member_email);
			
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
	
	public LoginDto getlogininfo(String member_email) {
		LoginDto dto = new LoginDto();
		//멤버이메일을 보내서 sql문에 넣어서 select로 dto가져와야지
		SqlSession session = null; 
		System.out.println("info : " + member_email);
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne("loginmapper.logininfo", member_email);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dto;
	}
	
	
	//비밀번호 암호화(md5, sha-1, sha-256, sha-512)
	public String encodeHash(String pass) {
		String encodeString = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(pass.getBytes());
			byte[] encodeData = md.digest();
			for(int i = 0; i < encodeData.length; i++) {
				encodeString += Integer.toHexString(encodeData[i]&0xFF);
			}
			System.out.println(encodeString);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return encodeString;
	}

}
