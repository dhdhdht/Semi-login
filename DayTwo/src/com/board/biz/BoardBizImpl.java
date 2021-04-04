package com.board.biz;

import java.util.List;

import com.board.dao.BoardDao;
import com.board.dao.BoardDaoImpl;
import com.board.dto.BoardDto;

public class BoardBizImpl implements BoardBiz {

	BoardDao dao = new BoardDaoImpl();
	@Override
	public List<BoardDto> selectAllList() {
		
		return dao.selectAllList();
	}

	@Override
	public BoardDto selectOneById(String freecomm_id) {
		// TODO Auto-generated method stub
		return dao.selectOneById(freecomm_id);
	}

	@Override
	public BoardDto selectOneByTitle(String freecomm_title) {
		// TODO Auto-generated method stub
		return dao.selectOneByTitle(freecomm_title);
	}

	@Override
	public int insert(BoardDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(BoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateRead(String freecomm_id) {
		// TODO Auto-generated method stub
		return dao.updateRead(freecomm_id);
	}

	@Override
	public List<BoardDto> selectListPage(int startRaw, int endRow) {
		// TODO Auto-generated method stub
		return dao.selectListPage(startRaw, endRow);
	}

	@Override
	public int getTotalRow() {
		// TODO Auto-generated method stub
		return dao.getTotalRow();
	}

}
