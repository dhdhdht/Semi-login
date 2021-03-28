<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">


	function idCheck(){
		var userName = $("#mainId").val();
		if($.trim(userName) == "" || $.trim(userName) == null){
			$("#idmsg").text("아이디를 입력해주세요")
			$("#idmsg").css("color", "red")
		} else {
			var queryString = "?command=idCheck&member_id="+userName; 
			$.ajax({ 
					type : 'POST', 
					url : 'regist.do'+queryString, 
					success : function(data){
						
						if(data==0){ 
							$("#idmsg").text("사용할 수 있는 아이디입니다.")
							$("#idmsg").css("color", "blue"); 
							$("#mainId").prop("title", "y");
						} else if(data==1){ 
							$("#idmsg").text("사용중인 아이디입니다. 다른 아이디를 입력해 주세요")
							$("#idmsg").css("color", "red");
							$("#mainId").prop("title", "n");
							}
						},
					error: function(){
						$("#idmsg").text("?????")
						$("#idmsg").css("color", "red");
					}
				});
		}
		
	}
	//수정필요
	/*function passwordCheck(){
		var pw = $("#pw").val();
		var chkpw = $("#chkpw").val();
		if (chkpw == "" && (pw != chkpw || pw == chkpw)){
			$(".signbtn").prop("disabled", true);
            $(".signbtn").css("background-color", "#aaaaaa");
            $("#chkpw").css("background-color", "#FFCECE");
		} else if (pw == chkpw){
			$("#chkpw").css("background-color", "#B0F6AC");
            pwdCheck = 1;
            if(idCheck==1 && pwdCheck == 1) {
                $(".signbtn").prop("disabled", false);
                $(".signbtn").css("background-color", "#4CAF50");
                signupCheck();
            }
			
		} else if (pw != chkpw){
			$(".signbtn").prop("disabled", true);
            $(".signbtn").css("background-color", "#aaaaaa");
            $("#chkpw").css("background-color", "#FFCECE");
		}
	}
	*/
	function jusoPopup(){
		//주소검색 수행할 팝업 페이지 호출
		var pop = window.open("jusoPopup.jsp","pop", "width=570, height=420, scrollbars=yes, resizable=yes");
	}
	
	/** API 서비스 제공항목 확대 (2017.02) **/
	function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
							, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.form.roadAddrPart1.value = roadAddrPart1;
		document.form.roadAddrPart2.value = roadAddrPart2;
		document.form.addrDetail.value = addrDetail;
		document.form.zipNo.value = zipNo;
	}
	

</script>
</head>
<body>

	<h1>회원가입</h1>

	<form action="regist.do" method="post">
		<input type="hidden" name="command" value="insertuser" />

		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" id="mainId" name="member_id"
					required="required" title="n" onchange="idCheck();"/></td>
				<td id="idmsg"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="pw" name="member_pw"
					required="required" oninput="passwordCheck()" /></td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td><input type="password" id="chkpw" oninput="passwordCheck()" />
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="member_name" required="required"
					onclick="idChkProc();" /></td>
			</tr>
			<tr>
				<th>주소</th>
				<td><input type="hidden" id="confmKey" name="confmKey" value="">
					<input type="text" id="zipNo" name="zipNo" readonly
					style="width: 100px"> <input type="button" value="우편번호"
					onclick="jusoPopup();"><br /> <input type="text"
					id="roadAddrPart1" readonly="readonly" /><br /> <input
					type="text" id="addrDetail" name="member_addr" value=""></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="member_phone" required="required"
					onclick="idChkProc();" /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="member_email" required="required"
					onclick="idChkProc();" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="가입하기"
					class="signbtn" /></td>
			</tr>
		</table>
	</form>

</body>
</html>