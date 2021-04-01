package com.board.dao;

import java.util.List;

import com.board.dto.BoardDto;


public interface BoardDao {
	
	public List<BoardDto> selectList();
	public BoardDto selectOne(int seq);
	public int delete(int seq);
	public int update(BoardDto dto);
	public int insert(BoardDto dto);
	
	public int multidelete(String[] seq);

}
