<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />



<!-- JAVASCRIPTS -->
<script src="${path}/resources/js/slider/slider.js" type="text/javascript"></script>
<script src="${path}/resources/js/slider/jssor.slider-28.1.0.min.js" type="text/javascript"></script>
<script src="${path}/resources/js/jquery.min.js"></script>
<script src="${path}/resources/js/jquery.backtotop.js"></script>
<script src="${path}/resources/js/jquery.mobilemenu.js"></script>


<link href="${path}/resources/css/layout.css" rel="stylesheet" type="text/css" media="all">


<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gugi&display=swap" rel="stylesheet">

<!-- -------------------------------------------------------------------------------- -->

<style type="text/css">
* {
	font-family: 'Gugi', cursive;
	margin: 0 auto;
}

section {
	height: 800px;
	background-color : #93c0c521;
}

#left {
	float:left;
	width: 45%;
    height: 85%;
    text-align : center;
    margin : 20px 0px 0px 30px;
}

#right {
	float: right;
	width: 45%;
    height: 85%; 
    text-align : center;
    margin : 20px 30px 0px 0px;
}

.category {
	width: 80px;
	height: 40px;
	text-align-last: center;
	border: 0.1px solid #93c0c549;
	
}

#btn1{
	background-color: #93c0c59d;
	width: 100px;
	height: 30px;
	border-radius: 5px 5px 5px 5px;
	border: none;
	text-align: center;
	margin-top : 10px;
	color : white;
}

#btn2 {
	display: inline-block;
	background-color: #93c0c59d;
	width: 80px;
	height: 40px;
	border-radius: 5px 5px 5px 5px;
	border : none;
	text-align: center;
	margin : 40px;
}

</style>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 등록</title>
</head>
<body>

	<!-- header -->
	<jsp:include page="../form/header.jsp"></jsp:include>

	<!-- --------------------------------------------------------------------------- -->
	<!-- --------------------------------------------------------------------------- -->
		
		<div class="top" style="background-color: #93C0C5; display: flex; text-align: center; height: 50px;">
			<h1 style="margin: auto; font-weight: bold; color: white; 
				font-family: 'Gugi', cursive;">
				프로젝트 등록</h1>
		</div>
		
	<!-- ------------------------------------------------------------------------- -->
	<!-- ------------------------- left-------------------------------------------- -->
	

	 <section>
        <article id="left">
        	<label>카테고리 선택</label>
				<select class="category">
					<option value="">출판</option>
					<option value="">공예</option>
					<option value="">예술</option>
					<option value="">공연</option>
					<option value="">푸드</option>
					<option value="">패션</option>
				</select>
	<!-- ------------------------------------------------------------------------------ -->
				<div style="margin-top:20px;">
					<label>프로젝트 제목	
						<input type ="text" placeholder="프로젝트 제목을 입력하세요(최대40자)" 
							   style="width:350px;height:40px; border: 0.1px solid #93c0c549;">
					</label>
				</div>
	<!-- ------------------------------------------------------------------------------- -->
			
				<div style="margin-top :20px;">
					<label>목표금액	
						<input type ="text" placeholder="목표금액을 설정하세요" 
							   style="width:350px;height:40px; border: 0.1px solid #93c0c549;">
					</label>
				</div>	
	<!-- ------------------------------------------------------------------------------ -->
			<div style="margin-top:20px;">
				<label>프로젝트 개최일시  <input type="datetime-local" style="border: 0.1px solid #93c0c549;"></label>
			</div>
			<div>
				<label>프로젝트 마감일시<input type="datetime-local"  style="border: 0.1px solid #93c0c549;"></label>
				
			</div>
			
	<!-- ------------------------------------------------------------------------------ -->
			<div style="margin-top:30px;">
			<label> 프로젝트 대표 이미지 </label>
						<img src="#" style="width:400px; height:250px;">
						<input type="button" value="업로드" id="btn1">
			</div>

		</article>
	<!-- ------------------------------------------------------------------------------ -->
	<!-- ---------------------------------right---------------------------------------- -->
      
        <article id="right">
        
        	<div style="margin-top:10px;">
				<label>프로젝트 소개</label>
				<input type="text" placeholder="프로젝트를 소개하세요" 
								   style="width:430px;height:300px; border: 0.1px solid #93c0c549;
								   border-radius: 10px 10px 10px 10px;">
			</div>
				
	<!-- -------------------------------------------------------------------------------- -->
			
			<div style="margin-top:20px">
				<label>펀딩 안내
					<textarea cols="60" rows="15" 
							  style="resize:none; border: 0.1px solid #93c0c549;
							  border-radius: 10px 10px 10px 10px;"></textarea>
				</label>
			</div>
			
			 <div>
				<input type="submit" value="등록" id="btn2">
				<input type="button" value="취소" id="btn2">
			</div>
          </article>
        </section>
	   
       
        
    <!-- ------------------------------------------------------------------------------- -->
       
		
 
	
	
	
	
	<!-- --------------------------------------------------------------------------- -->

	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>


</body>
</html>