package com.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.member.db.SqlMapConfig;

import com.member.dto.UserDto;

public class UserDao extends SqlMapConfig {
	private String namespace = "com.user.mapper.";

	public List<UserDto> selectList() {

		List<UserDto> list = new ArrayList<UserDto>();

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(true); // 기본값 true;
			list = session.selectList(namespace + "selectList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	public UserDto selectOneByID(String userID) {
		SqlSession session = null;

		UserDto dto = new UserDto();
		try {
			session = getSqlSessionFactory().openSession(true); // 기본값 true;
			dto = session.selectOne(namespace + "selectOneByID", userID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

		return dto;
	}
	/*
	 * public int join(String userid, String userpw) {
	 * 
	 * int res = 0; UserDto dto = new UserDto(userid, userpw); SqlSession session =
	 * null;
	 * 
	 * try { session = getSqlSessionFactory().openSession(true); res =
	 * session.insert(namespace+"insert", dto); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } finally { session.close();
	 * }
	 * 
	 * return res; }
	 */

	public int insert(UserDto dto) {

		int res = 0;
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace + "insert", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

		return res;
	}

	public String profile(String userID, String userProfile) {

		UserDto dto = new UserDto(userID, null, null, null, null, userProfile);
		int res = 0;

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace + "updateProfile", dto);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

	public String getProfile(String userID) {

		UserDto dto = new UserDto();

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace + "userProfile", userID);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	

}
