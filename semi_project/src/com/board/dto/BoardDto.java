package com.board.dto;

import java.util.Date;

public class BoardDto {

	private int freecomm_no;
	private int freecomm_seq;
	private String freecomm_id;
	private String freecomm_title;
	private String freecomm_content;
	private Date freecomm_regdate;
	private int freecomm_groupno;
	private int freecomm_step;
	private int freecomm_titletab;
	
	public BoardDto() {
		
	}
	
	public BoardDto(int freecomm_no, int freecomm_seq, String freecomm_id, String freecomm_title,
			String freecomm_content, Date freecomm_regdate, int freecomm_groupno, int freecomm_step,
			int freecomm_titletab) {
		super();
		this.freecomm_no = freecomm_no;
		this.freecomm_seq = freecomm_seq;
		this.freecomm_id = freecomm_id;
		this.freecomm_title = freecomm_title;
		this.freecomm_content = freecomm_content;
		this.freecomm_regdate = freecomm_regdate;
		this.freecomm_groupno = freecomm_groupno;
		this.freecomm_step = freecomm_step;
		this.freecomm_titletab = freecomm_titletab;
	}
 
	public int getFreecomm_no() {
		return freecomm_no;
	}

	public void setFreecomm_no(int freecomm_no) {
		this.freecomm_no = freecomm_no;
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

	public Date getFreecomm_regdate() {
		return freecomm_regdate;
	}

	public void setFreecomm_regdate(Date freecomm_regdate) {
		this.freecomm_regdate = freecomm_regdate;
	}

	public int getFreecomm_groupno() {
		return freecomm_groupno;
	}

	public void setFreecomm_groupno(int freecomm_groupno) {
		this.freecomm_groupno = freecomm_groupno;
	}

	public int getFreecomm_step() {
		return freecomm_step;
	}

	public void setFreecomm_step(int freecomm_step) {
		this.freecomm_step = freecomm_step;
	}

	public int getFreecomm_titletab() {
		return freecomm_titletab;
	}

	public void setFreecomm_titletab(int freecomm_titletab) {
		this.freecomm_titletab = freecomm_titletab;
	}
	
	
	
}
