<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>♡Day Two♡</title>

<link rel="stylesheet" type="text/css" />


<style type="text/css">

	*{
		padding: 0px;
		margin: 0px;
	}
	div{
		border : 1px dashed blue;
		margin:10px;
	}
	#header{
    text-align: left;
	}
	#body{
		height: 800px;
		text-align:center;
	}
	#body .table .styled-table{
		border-collapse: collapse;
	    margin: 25px 0;
	    font-size: 1.0em;
	    font-family: sans-serif; 
	    width: 90%;
	    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
	
	}
	
	#body .table{
		width:70%;
		height:70%;
		display:inline-block;
	}
	
	

	
	#body .insert-button{
	
		width:70%;
		height:5%;
		text-align:right;
		display:inline-block;
		
		
		
	}
	
	#body .table .styled-table th,
	#body .table .styled-table td{
	 padding: 12px 15px;
	}
	
	#body .file-upload{
		width:70%;
		height:5%;
		display:inline-block;
		text-align:right;
	}
	
	
	
	
	/*insert 페이지 는 왜 화면 축소하면 표는 같이 안줄어드는거지....*/
</style>

</head>
<body>

<div id="header">
	<h1>제목</h1>
		<div>
			<span><a href="#">메뉴1</a></span>
			<span><a href="#">메뉴2</a></span>
			<span><a href="#">메뉴3</a></span>
			<span><a href="#">메뉴4</a></span>
		
		</div>
	</div>
	
	<div id="body">
		<div class="file-upload">
				<input type="file" value="파일선택" multiple />
				<input type="submit" value="업로드" />
		</div>
		
		<div class="table">
			
			<table class="styled-table" border="1">
				<tr>
					<th>작성일</th>
					<td><input type="date" name="date"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="23" cols="200" name="content"></textarea></td>
				</tr>
			
			
			</table>
			
		</div>
		<div class="insert-button">
				<input type="submit" value="작성" />
				<input type="button" value="취소" onclick="">
		</div>
	</div>
	
	<div id="footer">
		<address>copyright &copy; all rights reserved qclass....</address>
	</div>

</body>
</html>