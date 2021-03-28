<%@page import="java.util.List"%>
<%@page import="com.login.dto.MYMemberDto"%>
<%@page import="com.login.biz.MYMemberBiz"%>
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
	String command = request.getParameter("command");
	System.out.println("[" + command + "]");
	
	MYMemberBiz biz = new MYMemberBiz();
	
	if(command.equals("login")){
		//1.
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		
		MYMemberDto dto = biz.login(myid, mypw);
		
		if (dto != null){
			//session scope에 객체 담기 (session은 만료되기전까지 어디서나 사용할 수 있다 / 단 모든세션은 동일 브라우저에 한함)
			session.setAttribute("dto", dto);
			//만료되는 시간 설정 (default: 30분 / 음수로 지정할경우 무제한)
			session.setMaxInactiveInterval(10 * 60);
			
			if (dto.getMyrole().equals("ADMIN")){
				response.sendRedirect("adminmain.jsp");
			} else if (dto.getMyenabled().equals("N")){
%>
		<script type="text/javascript">
			alert("없는 회원정보 입니다.");
			location.href="index.html";
		</script>
<%
			} else if (dto.getMyrole().equals("USER")){
				response.sendRedirect("usermain.jsp");
			}
			
		} else {
%>
		<script type="text/javascript">
			alert("로그인 실패");
			location.href="index.html";
		</script>
<%			
		}
		
	} else if (command.equals("logout")) {
		//session scope에서 값 삭제(만료)
		session.invalidate();
		response.sendRedirect("index.html");
		
	} else if (command.equals("listall")) {
		List<MYMemberDto> list = biz.selectAllUser();
		//3.보내줄 값 있으면 객체에 담자
		request.setAttribute("list", list); //("어떤이름으로", 어떤객체를 담자)
		//4.
		pageContext.forward("userlistall.jsp");
		
	} else if (command.equals("listen")) { //listenabled = listen
		List<MYMemberDto> list = biz.selectEnabledUser();
		request.setAttribute("list", list);
		pageContext.forward("userlisten.jsp");
			
	} else if (command.equals("updateroleform")){
		int myno = Integer.parseInt(request.getParameter("myno"));
		MYMemberDto dto = biz.selectUser(myno);
		request.setAttribute("dto", dto);
		pageContext.forward("updaterole.jsp");
		
	} else if (command.equals("updaterole")) {
		//1. 뭘 보냈는지?
		int myno = Integer.parseInt(request.getParameter("myno"));
		String myrole = request.getParameter("myrole");
		//2.
		int res = biz.updateRole(myno, myrole);
		//4.
		if (res > 0){
%>
		<script type="text/javascript">
			alert("등급 변경 성공");
			location.href="logincontroller.jsp?command=listen"
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("등급 변경 실패");
			location.href="logincontroller.jsp?command=updateroleform&myno=<%=myno%>";
		</script>
<%
		}
	} else if (command.equals("registform")) {
		response.sendRedirect("regist.jsp");
		
	} else if (command.equals("idchk")){
		//1. 뭘 받았는가?
		String myid = request.getParameter("myid");
		//2.
		MYMemberDto dto = biz.idCheck(myid);
		boolean idnotused = true;
		
		if (dto.getMyid() != null){
			idnotused = false;
		}
		
		response.sendRedirect("idchk.jsp?idnotused="+idnotused);
		
	} else if (command.equals("insertuser")){
		//1.뭘 받았는가?(보내준 값이 있으면 받는다.)
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");
		//2.db에 전달할 값있으면 전달하고 없으면 그대로 호출
		MYMemberDto dto = new MYMemberDto(0, myid, mypw, myname, myaddr, myphone, myemail, null, null);
		//3.화면에 전달할 값 있으면 request객체에 담는다.
		//4.보낸다.
		int res = biz.insertUser(dto);
		
		if (res > 0){
%>
		<script type="text/javascript">
			alert("가입성공");
			location.href = "index.html";
		</script>
<%			
		} else {
%>
		<script type="text/javascript">
			alert("가입실패");
			location.href = "logincontroller.jsp?command=registform";
		</script>
<%
		}
		
	} else if (command.equals("adminmain")){
		response.sendRedirect("adminmain.jsp");
	}

%>






	<h1 style="color: red;">잘못왔다...</h1>

</body>
</html>
