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
<link href="https://fonts.googleapis.com/css2?family=Gugi&display=swap" rel="stylesheet">

<!-- -------------------------------------------------------------------------------- -->

<style type="text/css">
* {
	font-family: 'Gugi', cursive;
}

.title {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	
	height: 59.5px;
	
	background-color: #93C0C5;
	color: white;
	
}

.body {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	margin-bottom : 50px;
	text-align: center;
}

.top{
	width : 350px;
	height : 40px;
	text-align-last : center;
	border: 0.1px solid #93c0c549;
}

#cost {
	width: 350px;
	height: 40px;
	border: 0.1px solid #93c0c549;
}

#date {
	border: 0.1px solid #93c0c549;
}

#intro {
	width: 430px;
	height: 300px;
	border: 0.1px solid #93c0c549;
	border-radius: 10px 10px 10px 10px;
}

textarea {
	resize: none; 
	border: 0.1px solid #93c0c549; 
	border-radius: 10px 10px 10px 10px;
}


.P0 {
	margin-top : 40px;
}

.P1 {
	margin-top : 25px;
}

.P2 {
	margin-top : 25px;
}

.P3 {
	margin-top : 25px;
}

.P4 {
	margin-top : 30px;
}

.P5 {
	margin-top : 30px;
}

.P6 {
	margin-top : 30px;
	margin-bottom : 20px;
}



#btn2 {
	display : inline-block;
	width: 120px;
	height: 40px;
	border: 2px solid  #93C0C5;
	text-align: center;
	color:  #93C0C5;
	font-weight: bold;
}
</style>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 등록</title>

<script type="text/javascript"
	src="${path}/resources/ckeditor/ckeditor.js"></script>
<link href="${path}/resources/css/layout.css" rel="stylesheet"
	type="text/css" media="all">
<link href="${path}/resources/css/bootstrap.css" rel="stylesheet"
	type="text/css">


</head>
<body>

	<!-- header -->
	<jsp:include page="../form/header.jsp"></jsp:include>

	<!-- --------------------------------------------------------------------------- -->
	<!-- --------------------------------------------------------------------------- -->

	<div class="title" style="font-weight : bold;"> <h2>프로젝트 등록</h2> </div>

	<!-- ------------------------------------------------------------------------- -->
	<!-- ------------------------------------------------------------------------- -->
	<form action="#" method="post">
	<div class="body">
		<div class="P0">
		<h5>카테고리 선택</h5>
		<select class="top">
			<option value="">출판</option>
			<option value="">공예</option>
			<option value="">예술</option>
			<option value="">공연</option>
			<option value="">푸드</option>
			<option value="">패션</option>
		</select>
		</div>
		
		<!-- ------------------------------------------------------------------------------ -->

		<div class="P1">
			<h5>프로젝트 제목</h5> 
			<input type="text" id="cost" placeholder="프로젝트 제목을 입력하세요(최대40자)">
		</div>

		<!-- ------------------------------------------------------------------------------- -->

		<div class="P2">
			<h5>목표 금액</h5>
			 <input type="text" id="cost" placeholder="목표금액을 설정하세요">
		</div>

		<!-- ------------------------------------------------------------------------------ -->
		
		<div class="P3">
			<h5>프로젝트 개최 일시</h5><input type="datetime-local" id="date">
			<h5>카테고리 마감 일시</h5><input type="datetime-local" id="date">
		</div>

		<!-- ------------------------------------------------------------------------------ -->
		
		<div class="P4">
			<h5>프로젝트 대표 이미지</h5>
				<img src="#" style="width:400px; height:350px"> 
		</div>

		<!-- ------------------------------------------------------------------------------ -->
		
		<div class="P5">
			
				<h5>프로젝트 소개</h5>
				<div>
					
					<div>
						<textarea class="form-control" id="p_content" name="notice_content" required="required"
							style="resize: none;"></textarea>
						<script type="text/javascript">
							CKEDITOR.config.resize_enabled = false;
							CKEDITOR
									.replace(
											'p_content',
											{
												height : 500,
												filebrowserUploadUrl : '${pageContext.request.contextPath }/adm/fileupload.do'
											});
						</script>
					</div>
					<br>
					
				</div>  
			
		</div>

		<!-- -------------------------------------------------------------------------------- -->

		<div class="P6">
			<h5>펀딩 안내</h5>
			<textarea cols="80" rows="15"> </textarea>		
		</div>
		<div style="text-align: center;">
				<input type="submit" value="작성" id="btn2">
				<input type="button" value="취소" id="btn2" onclick="location.href='notice_board'">
		</div> 
	</div>
	</form>
		<!-- ----------------------------------------------------------- -->

	<!-- ------------------------------------------------------------------------------- -->
	<!-- --------------------------------------------------------------------------- -->

	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>


</body>
</html>