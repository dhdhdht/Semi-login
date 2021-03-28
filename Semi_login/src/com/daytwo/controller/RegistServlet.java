package com.daytwo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daytwo.dto.LoginDto;


@WebServlet("/regist.do")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public RegistServlet() {}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		
		if(command.equals("registForm")){
			response.sendRedirect("regist.jsp");
		
		} else if(command.equals("insertuser")) {
			String member_id = request.getParameter("member_id");
			String member_pw = request.getParameter("member_pw");
			String member_name = request.getParameter("member_name");
			String member_addr = request.getParameter("member_addr");
			String member_phone = request.getParameter("member_phone");
			String member_email = request.getParameter("member_email");
			
			LoginDto dto = new LoginDto(0, member_id, member_pw, member_name, member_addr, member_phone, member_email, null, null);
			
			
		} else if(command.equals("loginres")) {
			String member_id = request.getParameter("member_id");
			String member_pw = request.getParameter("member_pw");
		}
	}

}
