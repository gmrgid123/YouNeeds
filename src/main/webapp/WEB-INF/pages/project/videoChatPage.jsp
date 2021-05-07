<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE HTML>
<html>
<head>
<title>videoChatPage</title>
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
	margin: 0 auto;
	position: relative;
	text-align: center;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	
}

.localVideo{
	position: absolute;
	margin: 0;
}

</style>

</head>
<body id="top">
	<!-- header include -->
	<jsp:include page="../../pages/form/header.jsp"></jsp:include>
	
	<div class="main">
		<div class="videoChat" style="width: 700px;">
			<div class="title">프로젝트 제목 - 설명회</div>
			<br>
			<div class="creator">설명회 개최자</div>
			<br>
			<div class="videoChat" style="width: 700px; height: 550px; background-color:black;">
				<video controls autoplay id="localVideo" style="width: 700px; height: 500px"></video>
			</div>
			<div style="width: 700px; height: 200px; background-color:black;">
				<video controls autoplay id="remoteVideo" style="width: 200px; height: 200px"></video>
			</div>
		</div>
		
		<br>
		
		<textarea class="projectIntro" style="width:700px; height: 200px;" readonly="readonly">프로젝트 소개</textarea>


		<br>
		<br>
		
	</div>

	<!-- footer include -->
	<jsp:include page="../../pages/form/footer.jsp"></jsp:include>

	<!-- JAVASCRIPTS -->
	<script src="http://localhost:82/socket.io/socket.io.js"></script>
	<script src="https://webrtc.github.io/adapter/adapter-latest.js"></script>
	<script src="${path}/resources/js/Web_RTC_Server/RTC.js"></script>
	<script src="${path}/resources/js/Web_RTC_Server/index.js"></script>
	<script src="${path}/resources/js/jquery.min.js"></script>
	<script src="${path}/resources/js/jquery.backtotop.js"></script>
	<script src="${path}/resources/js/jquery.mobilemenu.js"></script>
</body>
</html>