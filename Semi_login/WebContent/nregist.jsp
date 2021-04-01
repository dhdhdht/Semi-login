<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.js"></script>
<script src="https://kit.fontawesome.com/0678876332.js" crossorigin="anonymous"></script>

<style type="text/css">
.pw {
	position: relative;
}

.pw .eyes {
	position: absolute;
	top: 0;
	bottom: 0;
	right: 0;
	margin: auto 2px;
	height: 20px;
	font-size: 22px;
	cursor: pointer;
}
</style>
<script type="text/javascript">

	$(function() {
		// 눈표시 클릭 시 패스워드 보이기 
		$('.eyes').on('click',function() {
					$('.pw').toggleClass('active');
					if ($('.pw').hasClass('active') == true) {
						$(this).find('.fa-eye').attr('class',"fas fa-eye-slash fa-lg").parents('.pw')
								.find('.pw2').attr('type', "text");
					} else {
						$(this).find('.fa-eye-slash').attr('class',"fas fa-eye fa-lg").parents('.pw')
								.find('.pw2').attr('type', 'password');
					}
				});
	});

	//실시간 아이디 중복
	function idCheck() {
		var userName = $("#id").val();
		if ($.trim(userName) == "" || $.trim(userName) == null) {
			$("#idmsg").text("아이디를 입력해주세요")
			$("#idmsg").css("color", "red")
		} else {
			var queryString = "?command=idCheck&member_id=" + userName;
			$.ajax({
				type : 'POST',
				url : 'regist.do' + queryString,
				success : function(data) {

					if (data == 0) {
						$("#idmsg").text("사용할 수 있는 아이디입니다.")
						$("#idmsg").css("color", "blue");
						$("#id").prop("title", "y");
					} else if (data == 1) {
						$("#idmsg").text("사용중인 아이디입니다. 다른 아이디를 입력해 주세요")
						$("#idmsg").css("color", "red");
						$("#id").prop("title", "n");
					}
				},
				error : function() {
					$("#idmsg").text("에러에러");
					$("#idmsg").css("color", "red");
				}
			});
		}

	}
	//비밀번호, 비밀번호 확인
	function passwordCheck() {
		var pw = $("#pw").val();
		var chkpw = $("#chkpw").val();

		if (chkpw == "" && (pw != chkpw || pw == chkpw)) {
			$("#pwmsg").text("비밀번호를 입력해주세요")

		} else if (pw == chkpw) {
			$("#pwmsg").text("");
			$("#pw").prop("title", "y");
			$("#chkpw").prop("title", "y");
		} else if (pw != chkpw) {
			$("#pwmsg").text("비밀번호가 맞지 않습니다.");
			$("#pwmsg").css("color", "red");
			$("#pw").prop("title", "n");
			$("#chkpw").prop("title", "n");

		}
	}
	
		function emailCheck(){
			var email = $("#email").val();
			if ($.trim(email) == "" || $.trim(email) == null) {
				$("#emailmsg").text("이메일을 입력해주세요");
				$("#emailmsg").css("color", "red");
				$("#email").focus();
				$("#email").prop("title", "n");
			} else {
				$("#emailmsg").text("");
				$("#email").prop("title", "y");
			}
		}
	
	function jusoPopup() {
		//주소검색 수행할 팝업 페이지 호출
		var pop = window.open("jusoPopup.jsp", "pop",
				"width=570, height=420, scrollbars=yes, resizable=yes");
	}

	/** API 서비스 제공항목 확대 (2017.02) **/
	

</script>
</head>
<body>

	<h1>NAVER 회원가입</h1>
	<!-- onsubmit="return allCheck();" -->
	<form action="regist.do" method="post" >
		<input type="hidden" name="command" value="insertuser" />
<%

%>

		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" id="id" name="member_id" required title="n" onchange="idCheck();"/>
				</td>
				<td id="idmsg"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
				<div class="pw">
					<input type="password" id="pw" class="pw2" name="member_pw" required title="n" />
					<div class="eyes">
					<i class="fas fa-eye fa-lg"></i>
					</div>
				</div>
				</td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td>
				<div class="pw">
					<input type="password" id="chkpw" class="pw2" required title="n" oninput="passwordCheck()" />
					<div class="eyes">
					<i class="fas fa-eye fa-lg"></i>
					</div>
				</div>
				</td>
				<td id="pwmsg"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" id="name" name="member_name" value="${dto.member_name}" required title="n" readonly onchange="nameCheck();"/></td>
				<td id="namemsg"></td>
			</tr>
			<tr>
				<th>주소</th>
                <td>
                 <div>
                  	<input type="text" id="zipNo" name="zipNo" readonly style="width:100px">
                    <input type="button" value="주소검색" onClick="jusoPopup();">
                </div>
                	<input type="text" id="address" name="member_addr" required readonly />
                </td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="text" id="phone" name="member_phone" value="${dto.member_phone}"required title="n" readonly/>
				</td>
				<td id="phonemsg"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td class="email">
					<input type="text" id="email" name="member_email" value="${dto.member_email}" required title="n" readonly onchange="emailCheck();"/>
				</td>
				<td id="emailmsg"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="가입하기" class="signbtn" onclick="allCheck();" />
					<input type="button" value="메인으로" class="mainbtn" onclick="location.href='regist.do?command=loginForm'" />
				</td>
			</tr>
		</table>
	</form>
	
<script type="text/javascript">
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo) {

    var addressEl = document.querySelector("#address");
    addressEl.value = roadFullAddr;
    
	var zipNum = document.querySelector("#zipNo");
	zipNum.value = zipNo;
	
}

</script>
</body>
</html>