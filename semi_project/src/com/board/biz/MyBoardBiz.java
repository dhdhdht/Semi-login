package com.board.biz;

import java.util.List;

import com.board.dao.BoardDao;
import com.board.dao.BoardDaoImpl;
import com.board.dao.MyBoardDao;
import com.board.dto.BoardDto;
import com.board.dto.MyBoardDto;

public class MyBoardBiz {
	
	MyBoardDao dao = new MyBoardDao();
	
	public List<MyBoardDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	public BoardDto selectOne(int seq) {
		// TODO Auto-generated method stub
		return dao.selectOne(seq);
	}

	
	public int insert(BoardDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	
	public int update(BoardDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	
	public int delet(int seq) {
		// TODO Auto-generated method stub
		return dao.delete(seq);
	}


}
