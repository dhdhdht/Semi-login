<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.math.BigInteger" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>둘이짜는 데이트코스 Daytwo</title>
<style type="text/css">

	*{
		margin: 0px;
		padding: 0px;
	}
	
</style>
</head>
<body>

	<h1>DAYTWO 로그인 페이지</h1>
	
	<!-- 로그인 화면 jsp -->
	<form action="regist.do" method="post" id="loginform">
		<input type="hidden" name="command" value="loginres">
	<fieldset>
		<legend class="blind">로그인</legend>
		<div class="id_area">
			<div class="input_row" id="id_area">
				<span class="input_box">
					<input type="text" id="id" name="userId" placeholder="아이디" />
				</span>
			</div>
		</div>
		<div class="pw_area">
			<div class="input_row" id="pw_area">
				<span class="input_box">
					<input type="password" id="pw" name="userPw" placeholder="비밀번호" />
				</span>
			</div>
		</div>
		<br/>
		<div>
			<input type="submit" title="로그인" alt="로그인" value="로그인" width="auto" class="" id="" />
		</div>
		<ul class="hi">
			<li>
				<a href="regist.do?command=findId">아이디 찾기</a>
			</li>
			<li>
				<a href="regist.do?command=findPw">비밀번호 찾기</a>
			</li>
			<li>
				<a href="regist.do?command=registForm">회원가입</a>
			</li>
		</ul>
		<br/>
		<div>
			--------------또는--------------
		</div>
		<br/>
		
		<div>
			<a href="https://kauth.kakao.com/oauth/authorize?client_id=6147ede2fee67c7e4d0316a0ef4cb677&redirect_uri=http://localhost:8787/Semi_login/kakao.do&response_type=code" class="link_kakao">
				<img alt="Kakaoimage" src="resources/img/Klogin_y_in.png" style="width:231px; height:50px;"/>
			</a>
		</div>
		<br/>
		<!-- 네이버아이디로로그인 버튼 노출 영역 -->
<%
	String clientId = "zOyYdXgy2oaLzPhWWPFb";//애플리케이션 클라이언트 아이디값";
    String redirectURI = URLEncoder.encode("http://localhost:8787/Semi_login/naver.do", "UTF-8");
    SecureRandom random = new SecureRandom();
    String state = new BigInteger(130, random).toString();
    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
    apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
%>

	<a href="<%=apiURL%>"><img height="50" src="resources/img/Nlogin_g_in.PNG"/></a>
	
			
	</fieldset>
	</form>
</body>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<!-- kakao로그인 실행 함수 -->
<script>
	//javascript SDK 초기화
	//javascript key:804de9dc4d252e4123548ce16301b21c
	Kakao.init("804de9dc4d252e4123548ce16301b21c");
	console.log(Kakao.isInitialized());
	
	function kakaologin(){
		Kakao.Auth.login({
			//사용동의한 항목들(추가항목 동의받기)
			scope: 'profile, account_email, gender',
			//로그인 성공
			success: function(authObj){
				Kakao.API.request({
					//로그인한 사용자의 정보 가져오기
					url:'/v2/user/me',
					success: function(res){
						const kakao_account = res.kakao_account;
						console.log(kakao_account);
					}
				});
			},
			fail: function(error){
				console.log(error);
			}
		});
	}
</script>
</html>