package com.member.dao;

import java.util.List;

import com.member.dto.MemberDto;

public interface MemberDao {

	
	public List<MemberDto> selectList();
	public MemberDto selectOneByID(String member_id);
	public int changeProfile(String member_id, String member_pr);
	public String getProfile(String member_id);
	public int insert(MemberDto dto);
}
