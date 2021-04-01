<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>♡ DayTwo - 오늘부터 1일? 우린 오늘부터 '데이투'! ♡</title>

<script type="text/javascript">
	
</script>


<head>
<meta charset="UTF-8">
<title>♡Day Two♡</title>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
	border: 1px dashed blue;
}

.header {
	margin: 20px;
	padding: 0;
	border: 0;
	background: rgb(201, 170, 185);
	width: 100%;
	height: 67px;
	color: white;
	text-align: center;
	font-family: Georgia, "Malgun Gothic", serif;
	font-size: 17px;
	font-weight: bolder;
	transition: none;
}

.search-bar {
	margin: 1;
	padding: 1;
	background: "none";
	width: 100%;
	height: 15px;
	text-size: 13px;
	text-style: inherit;
	text-align: right;
}

.search-bar {
	transform: translateX(-30px)
}

.search-bar+button {
	background: none;
}

#menuicon {
	display: none;
}

#menuicon+label {
	display: block;
	margin: 5px;
	width: 30px;
	height: 20px;
	position: relative;
	cursor: pointer;
}

#menuicon+label span {
	display: block;
	position: absolute;
	width: 100%;
	height: 5px;
	border-radius: 30px;
	background: rgb(92, 86, 86);
	transition: all .35s;
}

#menuicon+label span:nth-child(1) {
	top: 0%;
}

#menuicon+label span:nth-child(2) {
	top: 50%;
	transform: translateY(-50%);
}

#menuicon+label span:nth-child(3) {
	bottom: 0%;
}

#menuicon:checked+label {
	z-index: 2;
}

#menuicon:checked+label {
	background: #fff;
}

#menuicon:checked+label span:nth-child(1) {
	top: 50%;
	transform: translateY(-50%) rotate(45deg);
}

#menuicon:checked+label span:nth-child(2) {
	opacity: 0;
}

#menuicon:checked+label span:nth-child(3) {
	bottom: 50%;
	transform: translateY(50%) rotate(-45deg);
}

div.sidebar {
	width: 250px;
	height: 75%;
	background-color: #dcdcdc;
	position: fixed;
	top: "";
	left: -250px;
	z-index: 1;
	transition: all .35s;

}

#menuicon:checked+label+div {
	left: 0;
}

.menu {
	margin: 0;
	padding: 0;
	width: 250px;
	height: 100%;
	background-color: #dcdcdc;
	font-weight: bolder;
	font-color: white;
	font-size: 17;
	position: fixed;
	top: 0;
	left: -250px;
	z-index: 1;
	transition: all .35s;
}

#subMenu {
	margin-top: 15px;
	margin-bottom: 15px;
	background-color: #dcdcdc;
	position: relative;
	text-align: right;
	font-color: white;
	font-size: 20px;
	text-decoration: underline;
}

.map {
	margin: 0;
	padding: 0;
	border: 0;
	background: #dcdcdc;
	width: 100%;
	height: 1080px;
}

#menuicon2 {
	display: none;
}

#menuicon2+label {
	border: 5px;
	border-style: solid;
	border-color: rgb(255, 235, 181);
	background-color: none;
	display: block;
	margin: 5px;
	width: 25px;
	height: 25px;
	position: relative;
	cursor: pointer;
	float: right;
	margin: 5px;
	border-radius: 100%;
	background-color: none
}

#menuicon2:checked+label {
	z-index: 2;
	right: 250px;
}

#menuicon2+label span {
	display: block;
	background-color: none;
	position: absolute;
	width: 70%;
	height: 5px;
	border-radius: 30%;
	background: rgb(194, 194, 194);
	transition: all .35s;
}

#menuicon2+label span:nth-child(1) {
	top: 60%;
	right: 5%;
	transform: translateY(0%) rotate(-45deg);
}

#menuicon2+label span:nth-child(2) {
	bottom: 60%;
	right: 5%;
	transform: translateY(0%) rotate(45deg);
}

#menuicon2:checked+label {
	z-index: 2;
	right: 250px;
}

#menuicon2:checked+label span:nth-child(1) {
	top: 60%;
	right: 5%;
	transform: translateY(0%) rotate(45deg);
}

#menuicon2:checked+label span:nth-child(2) {
	bottom: 60%;
	right: 5%;
	transform: translateY(0%) rotate(-45deg);
}

div.sidebar2 {
	width: 250px;
	height: 70%;
	background-color: #dcdcdc;
	position: fixed;
	top: 0;
	right: -250px;
	z-index: 1;
	transition: all .35s;
}

#menuicon2:checked +label+div .sidebar2 {
	right: 0;
}

#weather {
	margin: 2;
	padding: 2;
	border: 2;
	width: 200px;
	height: 40px;
}

#dust {
	margin: 2;
	padding: 2;
	border: 2;
	width: 200px;
	height: 40px;
}

.finish {
	width: 100px;
	height: 20px;
	text-decoration: underline;
	font-weight: bolder;
	text-color: white;
}

#footer {
	margin-top: 2px;
	padding: 1;
	background: white;
	width: 100%;
	height: 70px;
	font-size: 9px;
	font-color: light grey;
	text-align: left;
	position: fixed;
	bottom: 0;
}
</style>

</head>
<body>

	<div class="header" role="banner" onclick="location.href='main.jsp'"
		id="bannerText">

		<h1>♪ 하루 종일, 우리 둘이 Day Two ♪</h1>
	</div>

	<div class="search-bar">
		<input type="text" placeholder="검색어를 입력해주세요.">
		<button>검색</button>
	</div>



	<div class="content" role="content">

		<div class="Menu" id="left">

			<input type="checkbox" id="menuicon"> <label for="menuicon">
				<span></span> <span></span><span></span>
			</label>

			<div class="sidebar">

				<div class="leftMenu" id="subMenu">
					<a href="login.html"> 로그인 / 회원가입</a> <!-- 로그인페이지 -->
				</div>
				<div class="leftMenu" id="subMenu"> 
					<a href=""> 공지사항 </a>
				</div>
				<div class="leftMenu" id="subMenu">
					<a href="recommend.html"> 추천코스 </a> <!-- 추천코스 -->
				</div>
				<div class="leftMenu" id="subMenu">
					<a href="board.html"> DayTwo 후기 </a>   <!-- 게시판 -->
				</div>
				<div class="leftMenu" id="subMenu"> 
					<a href=""> 내 캘린더 </a>
				</div>
				<div class="leftMenu" id="subMenu">
					<a href="mypage.html"> 회원 정보 수정 </a> <!-- 정보수정 -->
				</div>
				<div class="leftMenu" id="subMenu">
					<a href=""> ☞ 후원하기 </a>
				</div>

			</div>

		</div>

		<div class="Menu" id="right">

			<div>
				<input type="checkbox" id="menuicon2"> <label
					for="menuicon2"> <span></span> <span></span>
				</label>

				<div class="sidebar2">
					<p>새로운 일정 만들기</p>
					<div class="Menu" id="right">

						<div id="rightMenu">
							날짜 년도 월 일 <input type="checkbox">

							<div id="weather">sysdate</div>
						</div>

						<div id="rightMenu">
							<div id="dust">오늘의 미세먼지 농도는 ... 입니다.</div>
						</div>

						<a href=""> 출발</a>
						<div>지도에서 클릭해주세요</div>
						<br> <a href=""> 도착</a>
						<div>지도에서 클릭해주세요</div>
						<br>

						<div id="rightMenu">
							<div>경로지정</div>
							카페<input type="checkbox"> 식당<input type="checkbox">
							<br> 문화시설<input type="checkbox"> <br> 실내<input
								type="checkbox"> 실외<input type="checkbox"> <br>

							<div id="checkNotice">체크 후 클릭해주세요</div>
						</div>
					</div>
					<div class="finish">
						<div id="finish" onclick="">완료</div>
						<div>/</div>
						<div id="finish" onclick="this">재설정</div>

					</div>
				</div>
			</div>

		</div>

	</div>

	<div>
		<a> 지도 api를 위에 덧입혀 주세요 </a>
	</div>

	<div id="footer">

		<a class="sc-link-verylight" href="" title="Popular searches">Popular
			searches</a> <a class="sc-link-verylight" href=""
			title="People directory">Directory</a> <a class="sc-link-verylight"
			href="" title="About SoundCloud">About us</a> <a
			class="sc-link-verylight" href="" target="_blank"
			title="Creator Resources">Creator Resources</a> <a
			class="sc-link-verylight" href="" target="_blank"
			title="SoundCloud blog">Blog</a> <a class="sc-link-verylight" href=""
			target="_blank" title="Jobs at SoundCloud">Jobs</a> <a
			class="sc-link-verylight" href="" target="_blank"
			title="SoundCloud for developers">Developers</a> <a
			class="sc-link-verylight" href="" target="_blank"
			title="SoundCloud help">Help</a> <a class="sc-link-verylight" href=""
			title="Terms of use">Legal</a> <a class="sc-link-verylight" href=""
			title="Privacy policy">Privacy</a> <a class="sc-link-verylight"
			href="" title="Cookies policy">Cookies</a> <a
			class="sc-link-verylight" href="" title="Company information">Imprint</a>
		<a class="sc-link-verylight" href="" title="Charts">Charts</a>

		<div class="footer__localeSelector">
			<a type="button" class="localeSelector" tabindex="0"
				aria-haspopup="true" role="button" aria-owns="dropdown-button">
				Language: <span class="sc-text">Korean (KR)</span>
			</a>
		</div>

	</div>



</body>
</html>