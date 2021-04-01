package com.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.board.db.SqlMapConfig2;
import com.board.dto.BoardDto;
import com.board.dto.MyBoardDto;

public class MyBoardDao extends SqlMapConfig2 {
	

	private String namespace = "com.board.mapper.";


	public List<MyBoardDto> selectList() {

		List<MyBoardDto> list = new ArrayList<MyBoardDto>();

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(false); // 기본값 true;
			list = session.selectList(namespace + "selectAllList");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	
	public BoardDto selectOne(int seq) {

		BoardDto dto = null;

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(true);
			dto = session.selectOne(namespace + "selectOne", seq);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}

		return dto;
	}

	
	public int delete(int seq) {

		int res = 0;

		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.selectOne(namespace + "delete", seq);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	
	public int update(BoardDto dto) {
		int res = 0;
		SqlSession session = null;

		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.update(namespace + "update", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return res;
	}

	
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

	
	public int multidelete(String[] seqs) {

		int count = 0;

		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seqs);

		try (SqlSession session = getSqlSessionFactory().openSession(false);) {
			count = session.delete(namespace + "multiDelete", map);
			if (count == seqs.length) {
				session.commit();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return count;
	}
	
	
	
}
