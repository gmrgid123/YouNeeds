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
<link href="${path}/resources/css/slider/slider-banner.css"
	rel="stylesheet" type="text/css">

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gugi&display=swap"
	rel="stylesheet">


<style type="text/css">
* {
	font-family: 'Gugi', cursive;
}

.card {
	height: 220px;
	width: 220px;
	border-radius: 15px;
	display: inline-block;
	margin-left: 50px;
	margin-bottom: 0px;
	position: relative;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}

.topbar {
	height: 15%;
}

#btn {
	display: inline-block;
	margin: 50px 20px 20px 20px;
	background-color: #93c0c59d;
	width: 70px;
	height: 50px;
	border-radius: 5px 5px 5px 5px;
	border: none;
	text-align: center;
	font: black;
}

.main {
	height: 1000px;
	background-color: white;
}

<!--
---------------------------------------------------------
-->
.card_header {
	width: 20%;
	height: 200px;
	border-radius: 15px 15px 0 0;
	background-image: url("");
	background-size: 100% 250px;
}

.card_header_D-day {
	background-color: #EF5A31;
	color: #FFF;
	font-weight: bold;
	text-align: center;
	float: right;
	margin: 10px 10px 0 0;
	border-radius: 50%;
	font-weight: bold;
	padding: 10px 10px;
	line-height: 20px;
}

.card_body {
	position: absolute;
	margin-top: 10px;
	margin-bottom: 6px;
	bottom: 0;
	width: 100%;
	height: 100px;
	font-size: 14px;
	color: #9FA5A8;
	padding: 0 15px;
}

.payment {
	float: right;
}

.project_card {
	margin-left: 30px;
}

#c3 {
	margin-top: 55px;
}

#btn2 {
	display: inline-block;
	margin: 60px 20px 20px 20px;
	background-color: #FFFFFF;
	width: 70px;
	height: 50px;
	border-radius: 5px 5px 5px 5px;
	border: 1px solid gray;
	text-align: center;
}
</style>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 목록</title>
</head>
<body>


	<!-- header -->
	<jsp:include page="../form/header.jsp"></jsp:include>

	<!-- --------------------------------------------------------------------------- -->
	<!-- --------------------------------------------------------------------------- -->
	<section>
		<div class="top" style="background-color: #93C0C5; display: flex; text-align: center; height: 50px;">
			<h1 style="margin: auto; font-weight: bold; color: white; 
				font-family: 'Gugi', cursive;">
				프로젝트 목록</h1>
		</div>
		<div class="topbar"
			style="text-align: center; background-color: white; color: gray;">
			<input type="button" value="전체" id="btn" onclick="location.href=''">
			<input type="button" value="출판" id="btn" onclick="location.href=''">
			<input type="button" value="공예" id="btn" onclick="location.href=''">
			<input type="button" value="예술" id="btn" onclick="location.href=''">
			<input type="button" value="공연" id="btn" onclick="location.href=''">
			<input type="button" value="푸드" id="btn" onclick="location.href=''">
			<input type="button" value="패션" id="btn" onclick="location.href=''">
		</div>
	</section>


	<!-- ------------------------------------------------------------------------------ -->
	<!-- -----------------------프로젝트 첫 줄---------------------------------------------- -->
	<div class="main">
		<main class="container">
			<div>
				<a class="project_card" href="pjdetail.do">
					<div class="card" id="c1" style="margin-bottom: 50px;">
						<div class="card_header">
							<span><img src="${path}/resources/images/1.jpg"
								style="width: 100%; height: 100%;"></span>
						</div>
						<div class="card_body">
							<hr>
							<i class="name" style="font-size: 12pt;"><br>프로젝트 제목</i> <br>
							<i class="payment"> 결제금액 : -----원 </i>
						</div>
					</div>
				</a>
				<!-- ----------------------------------------------------------------------- -->
				<a class="project_card" href="#">
					<div class="card" id="c1">
						<div class="card_header">
							<span><img src="${path}/resources/images/"
								style="width: 100%; height: 100%;"></span>
						</div>
						<div class="card_body">
							<hr>
							<i class="name" style="font-size: 12pt;"><br>프로젝트 제목</i> <br>
							<i class="payment"> 결제금액 : -----원 </i>
						</div>
					</div>
				</a>
				<!-- ---------------------------------------------------------------------- -->
				<a class="project_card" href="#">
					<div class="card" id="c1">
						<div class="card_header">
							<span><img src="${path}/resources/images/"
								style="width: 100%; height: 100%;"></span>
						</div>
						<div class="card_body">
							<hr>
							<i class="name" style="font-size: 12pt;"><br>프로젝트 제목</i> <br>
							<i class="payment"> 결제금액 : -----원 </i>
						</div>
					</div>
				</a>
			</div>

			<!-- ---------------------------------------------------------------------- -->
			<!-- ----------------------------프로젝트 둘째줄------------------------------ -->
			<div>
				<a class="project_card" href="#">
					<div class="card" id="c2">
						<div class="card_header">
							<span><img src="${path}/resources/images/"
								style="width: 100%; height: 100%;"></span>
						</div>
						<div class="card_body">
							<hr>
							<i class="name" style="font-size: 12pt;"><br>프로젝트 제목</i> <br>
							<i class="payment"> 결제금액 : -----원 </i>
						</div>
					</div>
				</a>


				<!-- -------------------------------------------------------------------------- -->

				<a class="project_card" href="#">
					<div class="card" id="c2">
						<div class="card_header">
							<span><img src="${path}/resources/images/"
								style="width: 100%; height: 100%;"></span>
						</div>
						<div class="card_body">
							<hr>
							<i class="name" style="font-size: 12pt;"><br>프로젝트 제목</i> <br>
							<i class="payment"> 결제금액 : -----원 </i>
						</div>
					</div>
				</a>

				<!-- ------------------------------------------------------------------------ -->

				<a class="project_card" href="#">
					<div class="card" id="c2">
						<div class="card_header">
							<span><img src="${path}/resources/images/"
								style="width: 100%; height: 100%;"></span>
						</div>
						<div class="card_body">
							<hr>
							<i class="name" style="font-size: 12pt;"><br>프로젝트 제목</i> <br>
							<i class="payment"> 결제금액 : -----원 </i>
						</div>
					</div>
				</a>
			</div>

			<!-- ---------------------------------------------------------------------- -->
			<!-- ----------------------프로젝트 셋째줄------------------------------------- -->
			<div>
				<a class="project_card" href="#">
					<div class="card" id="c3" >
						<div class="card_header">
							<span><img src="${path}/resources/images/"
								style="width: 100%; height: 100%;"></span>
						</div>
						<div class="card_body">
							<hr>
							<i class="name" style="font-size: 12pt;"><br>프로젝트 제목</i> <br>
							<i class="payment"> 결제금액 : -----원 </i>
						</div>
					</div>
				</a>


				<!-- -------------------------------------------------------------------------- -->

				<a class="project_card" href="#">
					<div class="card" id="c3">
						<div class="card_header">
							<span><img src="${path}/resources/images/"
								style="width: 100%; height: 100%;"></span>
						</div>
						<div class="card_body">
							<hr>
							<i class="name" style="font-size: 12pt;"><br>프로젝트 제목</i> <br>
							<i class="payment"> 결제금액 : -----원 </i>
						</div>
					</div>
				</a>

				<!-- ------------------------------------------------------------------------ -->

				<a class="project_card" href="#">
					<div class="card" id="c3">
						<div class="card_header">
							<span><img src="${path}/resources/images/"
								style="width: 100%; height: 100%;"></span>
						</div>
						<div class="card_body">
							<hr>
							<i class="name" style="font-size: 12pt;"><br>프로젝트 제목</i> <br>
							<i class="payment"> 결제금액 : -----원 </i>
						</div>
					</div>
				</a>
		
			<!----------- 마지막 버튼-------------- -->
			<div class="bottom" style="text-align: center;">	
				<input type="button" value="<" id="btn2" onclick="location.href=''">
				<input type="button" value="1" id="btn2" onclick="location.href=''">
				<input type="button" value="2" id="btn2" onclick="location.href=''">
				<input type="button" value="3" id="btn2" onclick="location.href=''">
				<input type="button" value=">" id="btn2" onclick="location.href=''">
			</div>
		</main>
	</div>












	<!-- --------------------------------------------------------------------------- -->

	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>




</body>
</html>