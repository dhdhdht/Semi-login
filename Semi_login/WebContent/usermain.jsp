<%@page import="com.daytwo.dto.LoginDto"%>
<%
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-control", "no-store");
	response.setHeader("Expires", "0");
	
/*
	뒤로가기 했을 때, 이전화면이 보이는 이유
	-> 서버에서 문서를 받아오는 것이 아니라, 캐시에 저장된 값을 화면에 뿌려줌
	
	브라우저가 캐시에 응답결과(response)를 저장하지 않도록 설정
	response.setHeader("Pragma", "no-cache");				//http 1.0
	response.setHeader("Cache-control", "no-store");		//http 1.1
	response.setHeader("Expires", "0");						//proxy server
	
	우리는 http 1.1
*/

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
	LoginDto dto = (LoginDto) session.getAttribute("dto"); 

%>

	<h1>로그인 확인페이지</h1>
	
	<div>
		<h1>안녕하세요 <%=dto.getMember_id() %>님</h1>
		<a href="regist.do?command=logout">로그아웃</a>
	</div>
	

</body>
</html>