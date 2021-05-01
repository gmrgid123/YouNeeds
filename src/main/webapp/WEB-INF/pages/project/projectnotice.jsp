<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>



<!-- JAVASCRIPTS -->
<script src="${path}/resources/js/slider/slider.js" type="text/javascript"></script>
<script src="${path}/resources/js/slider/jssor.slider-28.1.0.min.js" type="text/javascript"></script>
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
 }

.main{ height: 900px; 
	   background-color: white; 
	}

.body {
	display : relative;
	padding : 50px;
	
}

#b1{

	background-color: #d1cdcd26; 
	width: 450px; 
	height:300px;
	float:left; 
	margin : 0;
	}

#b2{
	width: 450px; 
	height:300px; 
	float:right; 
	text-align:left;
	}

#b4{

	background-color: white; 
	width: 600px; 
	height:300px;
	float:left; 
	margin-top:30px;
	
	}

#b5{
	background-color: white; 
	width: 300px; 
	height:300px; 
	float:right; 
	margin-top:30px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
      rgba(0, 0, 0, 0.19);
	font-weight:bold; 
	font-family: 'Gugi', cursive;
	}
p {
	font-weight:bold; 
	font-family: 'Gugi', cursive;
	font-size: 20px;
}
	
#btn1 {
	width: 100px;
	height: 40px;
	background-color : #93C0C5;
	border : none;
	border-radius : 5px 5px 5px 5px;
	font-weight : bold;
	color : white;
	margin-top : 40px;
}
	
#btn2{
		display: inline-block;
		margin-left : 20px;
		font-weight : bold;
		font-size : 15px;
		width: 100px;
		height: 50px;
		float : left;
		border : none;
		background-color :transparent;
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
	
<!-- ------------------------------------------------- -->
		
	
<!-- ------------------------------------------------- -->

	<div class="main" style="text-align:center;">
			<h1 style="font-weight:bold; font-size:40px; font-family: 'Gugi', cursive;">프로젝트명<h1>
		<main class="body">
		          <section>
		            <div id="b1">
		            	<img src="resources/images/1.jpg">
		            </div>
		             <div id="b2" style="font-family: 'Gugi', cursive;">
		             	<p>프로젝트 기간<p>
		             	<p style="margin-top: 50px;">모인금액<p>
		             	<p style="margin-top: 50px;">후원자 수<p>
		             	<input type="button" value="후원하기" id="btn1" onclick="location.href=''">
		             </div>
		           </section>
		           
		<!-- ----------------------------------------------------- -->
		           	<hr>
		           	<div id="b3">
		           		<input type="button" id="btn2" value="프로젝트 소개" onclick="location.href='funding.do'">
		           		<input type="button" id="btn2" value="프로젝트 공지" onclick="location.href='pjnotice.do'">
		           		<input type="button" id="btn2" value="  펀딩안내    " onclick="location.href=''">
		           	</div>
		           	<hr>
		           	
		<!-- ------------------------------------------------------ -->
		            <div id="b4">
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
		          	 <div id="b5"> 	
		            <p style=";">창작자 소개</p>
		            	
		          	 </div>
		</main>
	</div>

<!-- ------------------------------------------------- -->
<!-- footer include -->
<jsp:include page="../form/footer.jsp"></jsp:include>
	

</body>
</html>