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
<style>
* {
	font-family: 'Gugi', cursive;
}

.pjtitle {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	
	margin-top: 30px;
	background-color: #93C0C5;
	color : white;
	
	
}

.pjtop {
	width: 1000px;
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
	margin: 40px auto 0px auto;
}

.pjl {
	width: 100%;
	height: 300px;
	margin-right: 50px;
	text-align: center;

}

.pjl>img {
	width: 400px;
	height: 300px;
	background-position: center;
	background-size: cover;
}

.pjr {
	width: 350px;
	height: 300px;
	margin-right: 30px;
}
.pjl td{
	text-align: center;
}

.pjr>h1 {
	line-height: 60px;
	color :  #93c0c5;;
    
}

.btn1 {
	width: 120px;
	height: 40px;
	border: 2px solid  #93C0C5;
	text-decoration: none;
	text-align: center;
	color:  #93C0C5;
	font-weight: bold;
}

.btn1:hover {
	background-color: #93C0C5;
	color: white;
}

.pjbtn{
	
	margin-left : 260px;
	width:1000px; 
	height:50px;
}

#btn2{
	color : black;
	margin-right: 40px;
	font-size : 17px;
	font-weight : bold;
	line-height: 50px;
	}



.pjbtm {
	width: 1000px;
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
	margin: 30px auto 100px auto;
	
}

#btn3 {
	display : inline-block;
	width: 140px;
	height: 40px;
	border: 2px solid  #93C0C5;
	text-decoration: none;
	text-align: center;
	color:  #93C0C5;
	font-weight: bold;
}

#btn3:hover {
	background-color: #93C0C5;
	color: white;
}

</style>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트</title>
</head>
<body>


	<!-- header -->
	<jsp:include page="../form/header.jsp"></jsp:include>


	<!-- -------------------------------------------------------------------------------- -->
	<!-- -------------------------------------------------------------------------------- -->
	
	<div class="pjtitle"><h1>프로젝트명</h1></div>
	<div class="pjtop">	
		<div class="pjl">
			<img src="resources/images/1.jpg">
		</div>
		<div class="pjr">
			<h1>프로젝트 기간</h1>
			<h1>모인 금액</h1>
			<h1>후원자 수</h1>
			<input type="button" class="btn1" value="후원하기" onclick="location.href='order_test'">
		</div>
	</div>
		<div class="pjbtn">
			<div class="pjl">
				<hr>
				<a href="pjintro.do" id="btn2">프로젝트 소개</a>
				<a href="pjnotice.do" id="btn2">프로젝트 공지</a>
				<a href="pjfunding.do" id="btn2">펀딩안내</a>	
				<hr>
			</div>
		</div>
	
	<!-- -------------------------------------------------------------------------------- -->
	
	<!-- -------------------------------------------------------------------------------- -->
	<div class="pjbtm">
		<div class="pjl">
			<table>
            <col width="80px"><col width="300px"><col width="80px">
            <thead>
               <tr>
                  <th>글번호</th>
                  <th>제목</th>
                  <th>작성일자</th>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td>1</td>
                  <td><a href="notice_view" style="color:black;">임시용 제목 1</a></td>
                  <td>yyyy-MM-dd</td>
               </tr>
               <tr>
                  <td>2</td>
                  <td><a href="order_test">임시용 제목 2</a></td>
                  <td>yyyy-MM-dd</td>
               </tr>
               <tr>
                  <td>3</td>
                  <td><a href="#">임시용 제목 3</a></td>
                  <td>yyyy-MM-dd</td>
               </tr>
               <tr>
                  <td>4</td>
                  <td><a href="#">임시용 제목 4</a></td>
                  <td>yyyy-MM-dd</td>
               </tr>
               <tr>
                  <td>5</td>
                  <td><a href="#">임시용 제목 5</a></td>
                  <td>yyyy-MM-dd</td>
               </tr>
            </tbody>
         </table>
		</div>

		
		<div class="pjr" style="margin-bottom : 50px;">
			<h1>창작자 소개</h1>
			<pre> 
			
			
			</pre>
			<input type="button" id="btn3" value="공지등록" onclick="location.href='pjupnotice.do'">
			<input type="button" id="btn3" value="화상설명회 개최공지" onclick="location.href='pjupnotice.do'">
		</div>
			
			
		</div>
	<!-- ----------------------------------------------------------- -->
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>


</body>
</html>