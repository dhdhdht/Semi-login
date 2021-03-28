<%@page import="com.login.dto.MYMemberDto"%>
<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-control", "no-store");
	response.setHeader("Expires", "0");

%>

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
<body>

<%
	MYMemberDto dto = (MYMemberDto) session.getAttribute("dto");

	if (dto == null){
		pageContext.forward("index.html");
	}

%>

	<div>
		<h1>안녕하세요 <%=dto.getMyid() %>님</h1>
		<a href="logincontroller.jsp?command=logout">logout</a>
	</div>
	<div>
		<a>내 정보조회</a>
	</div>
	<div>
		<a>내 정보수정</a>
	</div>
	<div>
		<a>회원탈퇴</a>
	</div>
</body>
</html>