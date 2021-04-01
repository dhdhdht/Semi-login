package com.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.dao.UserDao;
import com.member.dto.UserDto;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset=UTF-8");

		String command = request.getParameter("command");
		UserDto dto = new UserDto();

		String userID = null;
		String userPW = null;

		UserDao dao = new UserDao();

		if (command.equals("signup")) {

			response.sendRedirect("signup.jsp");

		} else if (command.equals("join")) {
			if (userID == null || userPW == null) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('입력을 하지 않은 사항이 있습니다.')");
				script.println("history.back()");
				script.println("</script>");
				script.close();
				return;
			}
			int res = 0;//dao.join(userID, userPW);

			if (res > 0) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('회원가입 성공!')");
				script.println("location.href='index.jsp");
				script.println("</script>");
				script.close();
				return;
			}

		} else if (command.equals("loginaction")) {
			response.sendRedirect("userLogin.jsp");
		} else if (command.equals("loginaction")) {
			if (request.getParameter("userID") != null) {
				userID = request.getParameter("userID");
			}

			if (request.getParameter("userPW") != null) {
				userPW = request.getParameter("userPW");
			}

			if (userID == null || userPW == null) {
				PrintWriter script = response.getWriter();
				script.println("<script>");
				script.println("alert('입력을 하지 않은 사항이 있습니다.')");
				script.println("history.back()");
				script.println("</script>");
				script.close();
				return;
			}

		}

	}

}
