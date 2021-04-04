package com.board.dto;

import java.util.Date;

public class BoardDto {
	
	private int freecomm_seq;
	private String freecomm_id;
	private String freecomm_title;
	private String freecomm_content;
	private String freecomm_regdate;
	private String freecomm_read;
	public BoardDto() {
		
	}
	
	public BoardDto(int freecomm_seq, String freecomm_id, String freecomm_title, String freecomm_content,
			String freecomm_regdate, String freecomm_read) {
		super();
		this.freecomm_seq = freecomm_seq;
		this.freecomm_id = freecomm_id;
		this.freecomm_title = freecomm_title;
		this.freecomm_content = freecomm_content;
		this.freecomm_regdate = freecomm_regdate;
		this.freecomm_read = freecomm_read;
	}
	public String getFreecomm_read() {
		return freecomm_read;
	}
	public void setFreecomm_read(String freecomm_read) {
		this.freecomm_read = freecomm_read;
	}
	
	public int getFreecomm_seq() {
		return freecomm_seq;
	}

	public void setFreecomm_seq(int freecomm_seq) {
		this.freecomm_seq = freecomm_seq;
	}

	public String getFreecomm_id() {
		return freecomm_id;
	}

	public void setFreecomm_id(String freecomm_id) {
		this.freecomm_id = freecomm_id;
	}

	public String getFreecomm_title() {
		return freecomm_title;
	}

	public void setFreecomm_title(String freecomm_title) {
		this.freecomm_title = freecomm_title;
	}

	public String getFreecomm_content() {
		return freecomm_content;
	}

	public void setFreecomm_content(String freecomm_content) {
		this.freecomm_content = freecomm_content;
	}

	public String getFreecomm_regdate() {
		return freecomm_regdate;
	}

	public void setFreecomm_regdate(String freecomm_regdate) {
		this.freecomm_regdate = freecomm_regdate;
	}

}
