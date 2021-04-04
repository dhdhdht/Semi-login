<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="javascript:kakaoLogin();">hiiiiiiiiiiiiii</a>

	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
		
	<script type="text/javascript">
		window.Kakao.init("804de9dc4d252e4123548ce16301b21c");
		
		function kakaoLogin(){
			window.Kakao.Auth.login({
				scope:'profile, account_email, gender',
				success: function(authObj){
					console.log(authObj);
					window.Kakao.API.request({
						url:'/v2/user/me',
						success: function(res) {
							var kakao_account = res.kakao_account.email;
							alert(kakao_account);
							
						}
					});
				}
			});
		}
	</script>

</body>
</html>