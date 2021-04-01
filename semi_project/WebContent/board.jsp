<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>♡Day Two♡</title>
<link href="resources/css/board.css" rel="stylesheet" type="text/css" />

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
		height: 700px;
		text-align:center;
	}
	
	#body .search{
		width:70%;
		height:5%;
		text-align:right;
		display:inline-block;
		
	}
	.styled-table{
		border-collapse: collapse;
	    margin: 25px 0;
	    font-size: 1.0em;
	    font-family: sans-serif;
	    min-width: 500px;
	    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
		
	
	}
	.table{
		width:70%;
		height:70%;
		display:inline-block;	
	}
	#body .paging{
		width:30%;
		height:10%;
		display:inline-block;
		
		
	}
	#body .insert-button{
		width:70%;
		height:5%;
		text-align:right;
		display:inline-block;
		
	}
	.table .styled-table thead tr{
		background-color: #009879;
   		color: #ffffff;
   		text-align:left;
	}
	.table .styled-table th,
	.table .styled-table td{
	 padding: 12px 15px;
	}
	.table .styled-table tbody tr {
    border-bottom: 1px solid #dddddd;
	}
	
	.table .styled-table tbody tr:last-of-type {
	    border-bottom: 2px solid #009879;
	}
	
	.table .styled-table tbody .active-row{
	
	 font-weight: bold;
    color: #009879;
	}
	
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
		<div class="search">
				<span>
					<select name="select01">
						<option value="">작성자로 검색</option>
						<option value="">제목으로 검색</option>
					</select>
				
					<input type="text" placeholder="검색어 입력">
					<button>검색</button>
				</span>
		</div>
		<div class="table">
			<table class="styled-table">
				<thead>
					<col width="200px"/>
					<col width="500px"/>
					<col width="400px"/>
					<col width="200px"/>
					<col width="200px"/>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>조회수</th>
					</tr>
			 </thead>
				<tbody>
					<tr class="active-row">
						<td>3</td>
						<td><a href="">안녕하세요</a></td>
						<td>앨리스1</td>
						<td>2020.12.02</td>
						<td>2</td>
					</tr>
					<tr>
						<td>2</td>
						<td><a href="">개춥네</a></td>
						<td>앨리스2</td>
						<td>2020.12.01</td>
						<td>2</td>
					</tr>
					<tr>
						<td>1</td>
						<td><a href="">가입인사~~</a></td>
						<td>앨리스3</td>
						<td>2020.11.13</td>
						<td>2</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="insert-button">
			
				<input type="submit" value="글작성" onclick="" style="text-align:right;"/>
		</div>
		<div class="paging">
			paging
		</div>
	
	</div>
	
	<div id="footer">
		<address>copyright &copy; all rights reserved qclass....</address>
	</div>

</body>
</html>