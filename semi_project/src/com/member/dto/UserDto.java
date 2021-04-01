package com.member.dto;

public class UserDto {
	
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

	public String getUsergender() {
		return usergender;
	}

	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserprofile() {
		return userprofile;
	}

	public void setUserprofile(String userprofile) {
		this.userprofile = userprofile;
	}
	public void setUsername(String username) {
		this.username = username;
		
	}
	public String getUsername() {
		return username;
	}
	private String userid;
	private String userpw;
	private String username;
	private String usergender;
	private String useremail;
	private String userprofile;
	
	public UserDto() {
		
		
	}
	
	public UserDto(String userid, String userpw, String username,String usergender, String useremail, String userprofile) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.usergender = usergender;
		this.useremail = useremail;
		this.userprofile = userprofile;
	}

	

	
	
}
