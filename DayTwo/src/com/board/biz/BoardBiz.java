package com.board.biz;

import java.util.List;

import com.board.dto.BoardDto;

public interface BoardBiz {
	
	public List<BoardDto> selectAllList();
	public BoardDto selectOneById(String freecomm_id);
	public BoardDto selectOneByTitle(String freecomm_title);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delete(int seq);
	public int updateRead(String freecomm_id);
	public List<BoardDto> selectListPage(int startRaw, int endRow);
	public int getTotalRow();
}
