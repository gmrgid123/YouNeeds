<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE HTML>
<html>
<head>
<title>MyPage</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="${path}/resources/css/layout.css" rel="stylesheet"
	type="text/css" media="all">
<link href="${path}/resources/css/slider/slider-banner.css"
	rel="stylesheet" type="text/css">
<style type="text/css">
.main {
	background-color: white;	
	text-align: center;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	color: black;
}

.title{
	font-size: 20pt;
}

.creator{
	font-size: 15pt;
}

.videoChat{
	text-align: center;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	font-size:20pt;
}

</style>

</head>
<body id="top">
	<!-- header include -->
	<jsp:include page="../../pages/form/header.jsp"></jsp:include>
	
	<div class="main">
		<div class="videoChat" style="width: 700px; height: 500px;">
			<div class="title">프로젝트 제목 - 설명회</div>
			<br>
			<div class="creator">설명회 개최자</div>
			<br>
			<div class="videoChat" style="width: 700px; height: 350px; background-color:lightgray;">화상 채팅 화면</div>
		</div>
		
		<textarea class="projectIntro" style="width:700px; height: 200px;" readonly="readonly">프로젝트 소개</textarea>
		<br>
		<br>
		
		
		
		
		
		
		
		
	</div>

	<!-- footer include -->
	<jsp:include page="../../pages/form/footer.jsp"></jsp:include>

	<!-- JAVASCRIPTS -->
	<script src="${path}/resources/js/jquery.min.js"></script>
	<script src="${path}/resources/js/jquery.backtotop.js"></script>
	<script src="${path}/resources/js/jquery.mobilemenu.js"></script>
</body>
</html>