package com.board.biz;

import java.util.List;

import com.board.dto.BoardDto;


public interface BoardBiz {

	public List<BoardDto> selectList();
	public BoardDto selectOne(int seq);
	public int insert(BoardDto dto);
	public int update(BoardDto dto);
	public int delet(int seq);
	
	public int multidelete(String[] seq);
	
}
