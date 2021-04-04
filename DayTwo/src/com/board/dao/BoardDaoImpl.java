package com.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.board.db.SqlMapConfig;
import com.board.dto.BoardDto;

public class BoardDaoImpl extends SqlMapConfig implements BoardDao {

	
	private String namespace = "com.board.mapper.";
	@Override
	public List<BoardDto> selectAllList() {
		
		List<BoardDto> list = new ArrayList<BoardDto>();

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(true);
			list = session.selectList(namespace + "selectAllList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
		
		
	}

	@Override
	public BoardDto selectOneById(String freecomm_id) {
		BoardDto dto = new BoardDto();
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace + "selectOneById", freecomm_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
				
		return dto;
	}

	@Override
	public BoardDto selectOneByTitle(String freecomm_title) {
		
		BoardDto dto = new BoardDto();
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace + "selectOneByTitle", freecomm_title);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
				
		
		return dto;
	}
	

	@Override
	public BoardDto selectOneBySeq(String freecomm_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(BoardDto dto) {
		int res = 0;
		
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.insert(namespace + "insert", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return res;
	}

	@Override
	public int updateRead(String freecomm_id) {
				
			SqlSession session = null;
			int res = 0;
			
			try {
				session = getSqlSessionFactory().openSession(true);
				res= session.update(namespace + "updateRead", freecomm_id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				session.close();
			}
		return res;
	}

	@Override
	public List<BoardDto> selectListPage(int startRow, int endRow) {
		
		List<BoardDto> list = new ArrayList<BoardDto>();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRow", startRow);
		map.put("endRow", endRow);
		
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			list = session.selectList(namespace + "selectList_paging", map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public int getTotalRow() {
		
		int res = 0;
		
		SqlSession session = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.selectOne(namespace + "totalCount");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return res;
	}


	
	
}
