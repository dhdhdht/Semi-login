package com.daytwo.biz;

import java.util.List;

import com.daytwo.dao.LoginDao;
import com.daytwo.dto.LoginDto;

public class LoginBiz {
	
	LoginDao dao = new LoginDao();
	
	public List<LoginDto> selectAllUser(){
		return dao.selectAllUser();
	}
	
	public int insertUser(LoginDto dto) {
		return dao.insertUser(dto);
	}
	
	public LoginDto login(String member_id, String member_pw) {
		return dao.login(member_id, member_pw);
	}
	
	public int idCheck(String member_id) {
		return dao.idCheck(member_id);
	}

}
