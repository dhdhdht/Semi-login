package com.member.biz;

import java.util.List;

import com.member.dao.MemberDao;
import com.member.dao.MemberDaoImpl;
import com.member.dto.MemberDto;

public class MemberBizImpl implements MemberBiz {

	MemberDao dao = new MemberDaoImpl();
	
	@Override
	public List<MemberDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	@Override
	public MemberDto selectOneByID(String member_id) {
		// TODO Auto-generated method stub
		return dao.selectOneByID(member_id);
	}

	@Override
	public int changeProfile(String member_id, String member_pr) {
		// TODO Auto-generated method stub
		return dao.changeProfile(member_id, member_pr);
	}

	@Override
	public String getProfile(String userID) {
		// TODO Auto-generated method stub
		return dao.getProfile(userID);
	}

	@Override
	public int insert(MemberDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

}
