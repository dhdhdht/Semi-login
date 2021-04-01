package com.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.biz.MyBoardBiz;
import com.board.dao.MyBoardDao;
import com.board.dto.MyBoardDto;




@WebServlet("/MyBoardServlet")
public class MyBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");
		
		String command = request.getParameter("command");
		MyBoardBiz biz = new MyBoardBiz();
		MyBoardDao dao = new MyBoardDao();
		
		
		if(command.equals("list")) {
			
			List<MyBoardDto> list = biz.selectList();
			
			request.setAttribute("list", list);
			
			dispatch(request, response, "myboardlist.jsp");
		} else if(command.equals("regist")) {
			
			response.sendRedirect("regist.jsp");
		} 
		
	}
	public void dispatch(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

}
