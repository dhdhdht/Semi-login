package com.member.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.member.db.SqlMapConfig;
import com.member.dto.MemberDto;

public class MemberDaoImpl extends SqlMapConfig implements MemberDao {

	private String namespace="com.member.mapper.";
	
	
	@Override
	public List<MemberDto> selectList() {
		List<MemberDto> list = new ArrayList<MemberDto>();

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

	@Override
	public MemberDto selectOneByID(String member_id) {
		SqlSession session = null;

		MemberDto dto = new MemberDto();
		try {
			session = getSqlSessionFactory().openSession(true); // 기본값 true;
			dto = session.selectOne(namespace + "selectOneByID", member_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

		return dto;
	}

	@Override
	public int changeProfile(String member_id, String member_profile) {
		MemberDto dto = new MemberDto(member_id, member_profile);
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

		return res;
	}

	@Override
	public String getProfile(String member_id) {
		MemberDto dto = new MemberDto();

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace + "getProfile", member_id);
			
			if(dto.getMember_profile().equals("defaultprofile.png") || dto.getMember_profile().equals(null)) {
				return "http://localhost:8787/DayTwo/images/defaultprofile.png";
			} else {
				return "http://localhost:8787/DayTwo/images/" + dto.getMember_profile();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return "http://localhost:8787/DayTwo/images/defaultprofile.png";
	}

	@Override
	public int insert(MemberDto dto) {
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

}
