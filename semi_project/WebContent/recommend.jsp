<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>♡Day Two♡</title>
<link href="resources/css/recommend.css" rel="stylesheet" type="text/css" />

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
		height: 750px;
		text-align:center;
	}
	.recommend-wrap{
		height:700px;
	}
	#body .recommend-wrap .img{
		height:200px;
		width:200px;
		margin:50px;
		display:inline-block;
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

    <div class="recommend-wrap">

        <div class="img"></div>
        <div class="img"></div>
        <div class="img"></div>
        <div class="img"></div>
        <div class="img"></div>
        <div class="img"></div>
        <div class="img"></div>
        <div class="img"></div>
        <div class="img"></div>
        <div class="img"></div>
        <div class="img"></div>
        <div class="img"></div>

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