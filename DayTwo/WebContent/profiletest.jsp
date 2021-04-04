<%@page import="com.member.dao.MemberDaoImpl"%>
<%@page import="com.member.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%

	MemberDao dao = new MemberDaoImpl();
	dao.getProfile("admin");

%>
	
<body>


	<p>회원이미지</p>
	
	<img alt="" src="<%=dao.getProfile("admin")%>">


</body>
</html>