package com.board.dao;

import java.util.ArrayList;
import java.util.List;

import com.board.dto.BoardDto;

public interface BoardDao {
	
	public List<BoardDto> selectAllList();
	public BoardDto selectOneById(String freecomm_id);
	public BoardDto selectOneByTitle(String freecomm_title);
	public BoardDto selectOneBySeq(String freecomm_seq);
	public int insert(BoardDto dto);
	public int updateRead(String freecomm_id);
	public List<BoardDto> selectListPage(int startRaw, int endRow);
	public int getTotalRow();
}
	
