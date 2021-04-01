package com.board.dto;

import java.util.Date;

public class MyBoardDto {
	
	public MyBoardDto(String userid, String userpw, String useremail, String useremailhash, boolean uesremailchecked) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.useremail = useremail;
		this.useremailhash = useremailhash;
		this.uesremailchecked = uesremailchecked;
	}

	private String userid;
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUseremailhash() {
		return useremailhash;
	}

	public void setUseremailhash(String useremailhash) {
		this.useremailhash = useremailhash;
	}

	public boolean isUesremailchecked() {
		return uesremailchecked;
	}

	public void setUesremailchecked(boolean uesremailchecked) {
		this.uesremailchecked = uesremailchecked;
	}

	private String userpw;
	private String useremail;
	private String useremailhash;
	private boolean uesremailchecked;
	
	public MyBoardDto() {
		
	}
}
