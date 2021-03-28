<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function idChkProc(){
		var chk = document.getElementsByName("member_id")[0].title;
		if(chk == 'n'){
			alert("id 중복체크를 해주세요");
			document.getElementsByName("member_id")[0].focus();
		}
	}
	
	function idChk(){
		var member_id = document.getElementsByName("member_id")[0].value;
		
		if(member_id == null || member_id.trim() == ""){
			alert("id를 입력해주세요");
		} else {
			
		}
	}
	
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
				<td>
					<input type="text" name="member_id" required="required" />
					<span id="idMsg" class=""></span>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="member_pw" required="required" onclick="idChkProc();" />
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="member_name" required="required" onclick="idChkProc();" />
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<input type="hidden" id="confmKey" name="confmKey" value=""  >
					<input type="text" id="zipNo" name="zipNo" readonly style="width:100px">
					<input type="button" value="우편번호" onclick="jusoPopup();"><br/>
					<input type="text" id="roadAddrPart1" readonly="readonly" /><br/>
					<input type="text" id="addrDetail" value="">
				</td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td>
					<input type="text" name="member_phone" required="required" onclick="idChkProc();" />
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>
					<input type="text" name="member_email" required="required" onclick="idChkProc();" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="가입하기" />
				</td>
			</tr>
		</table>
	</form>

</body>
</html>