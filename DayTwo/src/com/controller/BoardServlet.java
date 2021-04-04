package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import com.board.biz.BoardBiz;
import com.board.biz.BoardBizImpl;
import com.board.dao.BoardDao;
import com.board.dao.BoardDaoImpl;
import com.board.dto.BoardDto;
import com.board.util.Paging;


/**
 * Servlet implementation class BoardController
 */
@WebServlet("/BoardController")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String command = request.getParameter("command");

		BoardBiz biz = new BoardBizImpl();

		String input = request.getParameter("input");
		
		if (command.equals("boardlist")) {
			
			int pageNum = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
			
			int totalCount = biz.getTotalRow();
			
			Paging paging = new Paging();
			paging.setPageNo(pageNum);
			paging.setPageSize(5);
			paging.setTotalCount(totalCount);
			
			pageNum = (pageNum -1) * 10;

			List<BoardDto> list = biz.selectListPage(pageNum, paging.getPageSize());

			request.setAttribute("list", list);
			request.setAttribute("page", pageNum);
			request.setAttribute("totalCount", totalCount);
			dispatch(request, response, "board.jsp");

		}  else if(command.equals("select")) {
			String freecomm_id = request.getParameter("freecomm_id");
			
			BoardDto dto = biz.selectOneById(freecomm_id);
			
			int res = biz.updateRead(freecomm_id);
			
			if(dto != null && res > 0) {
				
				request.setAttribute("dto", dto);
				
				dispatch(request, response, "select.jsp");
				
			} else {
				
				response.sendError(res, "선택된 글이 없습니다.");

			}
		} else if(command.equals("insert")) {
			
			
			
		}
	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}
}
