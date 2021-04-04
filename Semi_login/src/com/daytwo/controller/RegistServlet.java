package com.daytwo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daytwo.biz.LoginBiz;
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
		
		LoginBiz biz = new LoginBiz();
		HttpSession session = request.getSession();
		
		String command = request.getParameter("command");
		
		if (command.equals("loginForm")) {
			response.sendRedirect("login.jsp");
			
		} else if(command.equals("registForm")){
			response.sendRedirect("regist.jsp");
		
		} else if(command.equals("insertuser")) {
			String member_id = request.getParameter("member_id");
			String member_pw = biz.encodeHash(request.getParameter("member_pw"));
			String member_name = request.getParameter("member_name");
			String member_addr = request.getParameter("member_addr");
			String member_phone = request.getParameter("member_phone");
			String member_email = request.getParameter("member_email");
			
			LoginDto dto = new LoginDto(0, member_id, member_pw, member_name, member_addr, member_phone, member_email, null, null, null);
			
			System.out.println(dto.getMember_id());
			System.out.println(dto.getMember_pw());
			System.out.println(dto.getMember_name());
			System.out.println(dto.getMember_addr());
			System.out.println(dto.getMember_phone());
			System.out.println(dto.getMember_email());
			
			int res = biz.insertUser(dto);
			System.out.println(res);
			if (res > 0) {
				response.sendRedirect("index.html");
			} else {
				response.sendRedirect("regist.jsp");
			}
			
			
		} else if(command.equals("loginres")) {
			String member_id = request.getParameter("userId");
			String member_pw = biz.encodeHash(request.getParameter("userPw"));
			
			LoginDto dto = new LoginDto();
			
			dto.setMember_id(member_id);
			dto.setMember_pw(member_pw);
			
			dto = biz.login(member_id, member_pw);
			
				if(dto.getMember_enabled().equals("Y")) {
					session.setAttribute("dto", dto);
	                session.setMaxInactiveInterval(10 * 60);
					if (dto.getMember_role().equals("ADMIN")) {
						jsResponse(response, "adminmain.jsp", "로그인 성공!(admin)");
					} else {
						jsResponse(response, "usermain.jsp", "로그인 성공!(user)");
					}
					
				} else {
					jsResponse(response, "index.html", "아이디나 비밀번호를 확인해주세요");
				}

		
		} else if (command.equals("logout")) {
			session.invalidate();
			response.sendRedirect("login.jsp");
			
		} else if (command.equals("idCheck")) {
			String member_id = request.getParameter("member_id");
			System.out.println("servlet : "+member_id);
			int res = biz.idCheck(member_id);
			
			PrintWriter out = response.getWriter();
			out.print(res);
			System.out.println("res : " + res);
			
		} else if (command.equals("main")) {
			response.sendRedirect("index.html");
			
		} else if (command.equals("findId")) {
			response.sendRedirect("findId.jsp");
		} else if (command.equals("findPw")) {
			response.sendRedirect("findPw.jsp");
		}
	}
	
	private void jsResponse(HttpServletResponse response, String url, String msg) throws IOException {
        String s = "<script type='text/javascript'>"
                 + "alert('" + msg + "');"
                 + "location.href='" + url + "';"
                 + "</script>";
        response.getWriter().print(s);
    }


}
