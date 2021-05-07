<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />



<!-- JAVASCRIPTS -->
<script src="${path}/resources/js/slider/slider.js"
	type="text/javascript"></script>
<script src="${path}/resources/js/slider/jssor.slider-28.1.0.min.js"
	type="text/javascript"></script>
<script src="${path}/resources/js/jquery.min.js"></script>
<script src="${path}/resources/js/jquery.backtotop.js"></script>
<script src="${path}/resources/js/jquery.mobilemenu.js"></script>

<link href="${path}/resources/css/layout.css" rel="stylesheet"
	type="text/css" media="all">

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gugi&display=swap"
	rel="stylesheet">


<!-- -------------------------------------------------------------------------------- -->
<style>
* {
	font-family: 'Gugi', cursive;
}

.title {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	background-color: #93C0C5;
	color: white;
}

.top {
	width: 1000px;
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
	margin: auto auto 0px auto;
	background-color: #93c0c541;
}

.tl {
	width: 450px;
	height: 300px;
	margin-right: 50px;
	text-align: center;
	background-color: #93c0c521;
}

.tr {
	width: 350px;
	height: 200px;
	background-color: #ffffff6c;
}

.tr>h1 {
	line-height: 60px;
	margin: 0px 0px 0px 20px;
	font-size: 20px;
	color: black;
}

#b1 {
	width: 120px;
	height: 40px;
	margin-top: 20px;
	border: 2px solid #93C0C5;
	border-radius: 20px;
	text-decoration: none;
	text-align: center;
	color: #93C0C5;
	font-weight: bold;
}

#b1:hover {
	background-color: #93C0C5;
	color: white;
}

.middle {
	width: 1000px;
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
	margin: 5px auto 0px auto;
	background-color: #93c0c521;
}

.btn {
	width: 450px;
	font-size: 20px;
}

.btn>a {
	margin-left: 20px;
	color: #3533335d;
}

a:hover {
	color: black;
}

.bottom {
	width: 1000px;
	margin: 5px auto 0px auto;
	background-color: #93c0c541;
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
}

.bl {
	width: 450px;
	height: 300px;
	margin-right: 50px;
	text-align: center;
	background-color: #93c0c521;
}

.br {
	width: 350px;
	height: 200px;;
	background-color: #ffffff6c;
}

#b2 {
	display: inline-block;
	width: 150px;
	height: 40px;
	margin-top: 20px;
	border: 2px solid #93C0C5;
	border-radius: 20px;
	text-decoration: none;
	text-align: center;
	color: #93C0C5;
	font-weight: bold;
}

#b2:hover {
	background-color: #93C0C5;
	color: white;
}
</style>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펀딩안내</title>
</head>
<body>


	<!-- header -->
	<jsp:include page="../form/header.jsp"></jsp:include>


	<!-- -------------------------------------------------------------------------------- -->
	<div class="title">
		<h1>프로젝트명</h1>
	</div>
	<!-- ------------------------------------top----------------------------------------- -->


	<div class="top">
		<div class="tl">
			프로젝트 대표 이미지 (프로젝트 등록시)
			
		</div>
		<!-- ---------------------------------------------------------------------------- -->
		<div>
			<div class="tr">
				<h1>프로젝트 기간</h1>
				<h1>모인 금액</h1>
				<h1>후원자 수</h1>
			</div>
			<input type="button" id="b1" value="후원하기" style="text-align: center;"
				onclick="location.href='order_test'">
		</div>
	</div>

	<!-- -------------------------------------------------------------------------------- -->
	<!-- -------------------------------middle-------------------------------------------- -->

	<div class=middle>
		<div class="btn">
			<a href="pjintro.do">프로젝트 소개</a> <a href="pjnotice.do">프로젝트 공지</a> <a
				href="pjfunding.do">펀딩안내</a>
		</div>
	</div>

	<!-- -------------------------------------------------------------------------------- -->
	<!-- ---------------------------------bottom----------------------------------------- -->
	<div class="bottom">
		<div class="bl">
			펀딩안내 (프로젝트 등록시)
		</div>
		<div style="text-align: center;">
			<div class="br">
				창작자 소개 (창작 회원 가입시)
				
			</div>

			<input type="button" id="b2" value="공지사항 등록"> <input
				type="button" id="b2" value="화상설명회 개최공지">
		</div>
	</div>


	<!-- ----------------------------------------------------------- -->
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>


</body>
</html>