package com.login.biz;

import java.util.List;

import com.login.dao.MYMemberDao;
import com.login.dto.MYMemberDto;

public class MYMemberBiz {
	
	MYMemberDao dao = new MYMemberDao();
	
	/* 원래는 이렇게 만들어 줘야한다(정석)
	MYMemberDao dao;
	
	public MYMemberBiz() {
		dao = new MYMemberDao();
	}
	 */
	
	
	public List<MYMemberDto> selectAllUser(){
		return dao.selectAllUser();
	}
	public List<MYMemberDto> selectEnabledUser(){
		return dao.selectEnabledUser();
	}
	public int updateRole(int myno, String myrole) {
		return dao.updateRole(myno, myrole);
	}
	
	
	public MYMemberDto login(String myid, String mypw) {
		return dao.login(myid, mypw);
	}
	public MYMemberDto idCheck(String myid) {
		return dao.idCheck(myid);
	}
	public int insertUser(MYMemberDto dto) {
		return dao.insertUser(dto);
	}
	public MYMemberDto selectUser(int myno) {
		return dao.selectUser(myno);
	}
	public int updateUser(MYMemberDto dto) {
		return dao.updateUser(dto);
	}
	public int deleteUser(int myno) {
		return dao.deleteUser(myno);
	}


}
