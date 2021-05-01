<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>



<!-- JAVASCRIPTS -->
<script src="${path}/resources/js/jquery.min.js"></script>
<script src="${path}/resources/js/jquery.backtotop.js"></script>
<script src="${path}/resources/js/jquery.mobilemenu.js"></script>


<link href="${path}/resources/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="${path}/resources/css/slider/slider-banner.css" rel="stylesheet" type="text/css">

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gugi&display=swap" rel="stylesheet">


<style type="text/css">

* {
	font-family: 'Gugi', cursive;
	margin:0 auto;
	text-align : center;
 }

.category {
	width:200px; 
	height:40px; 
	margin : 0 auto;
	vertical-align: middle;
	text-align-last: center;
}

#btn {
	display:inline-block;
	width: 100px;
	height: 40px;
	background-color : #93C0C5;
	border : none;
	border-radius : 5px 5px 5px 5px;
	font-weight : bold;
	color : white;
	margin-top: 5%;
	margin-left : 10px;
}



		
</style>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 공지 등록</title>
</head>
<body>


<!-- header -->
<jsp:include page="../form/header.jsp"></jsp:include>

<!-- --------------------------------------------------------------------------- -->
		<div class="top"
			style="background-color: #93C0C5; display: flex; text-align: center; height: 50px;">
			<h1 style="margin: auto; font-weight: bold; color: white; font-family: 'Gugi', cursive;">프로젝트
				등록</h1>
		</div>
<!-- --------------------------------------------------------------------------- -->
	
	<form action="">
		<div class="container" style="border : 1px solid black;">
			<div class="t1">
			<label>카테고리 선택</label>
				<select class="category">
				     		<option value="">출판</option>
				            <option value="">공예</option>
				            <option value="">예술</option>
				            <option value="">공연</option>
				            <option value="">푸드</option>
				            <option value="">패션</option>
					</select>
			</div>
			<div class="t2" style="margin-top:20px;" >
				<label>프로젝트 제목</label>	
				<input type ="text" placeholder="프로젝트 제목을 입력하세요(최대40자)" style="width:350px;height:40px;">
			</div>
			<div class="t3" style="margin-top:20px;">
				<label>프로젝트 대표이미지</label>
				<img src="" style="width:400px; height:300px; text-aling:center;">
				<span><input type="button" value="업로드"></span>
			</div>
			<div class="t4" style="margin-top:20px;">
				<label>목표금액</label>	
				<input type ="text" placeholder="목표금액을 설정하세요" style="width:350px;height:40px;">
			</div>
			
			<div class="t5" style="margin-top:20px;">
				<label>프로젝트 펀딩기간</label>
				<label>프로젝트 개최일</label>
				<input type="date">
				<label>프로젝트 마감일</label>
				<input type="date">
			</div>
			
			<div class="t6" style="margin-top:20px;">
				<label>프로젝트 소개</label>
				<input type="text"; placeholder="프로젝트를 소개하세요" style="width:350px;height:300px;">
			</div>
			
			<div class="t7" style="margin-top:20px">
				 <label>펀딩 안내</label>
				 <textarea cols="60" rows="15" style="resize:none;"></textarea>
			</div>
			
			<input type="submit" value="등록" id="btn">
			<input type="button" value="취소" id="btn">
			
		</div>
		</form>

<!-- --------------------------------------------------------------------------- -->
	
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>
	



</body>
</html>