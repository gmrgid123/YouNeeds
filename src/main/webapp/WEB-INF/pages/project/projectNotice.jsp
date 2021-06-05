<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YouNeeds</title>
<link href="${path}/resources/css/layout.css" rel="stylesheet"
	type="text/css" media="all">
<style type="text/css">
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
.tr>h1 {
	font-size: 28px;
	color: #93C0C5;
}

.b1 {
	width: 120px;
	height: 40px;
	margin: 20px 0px 0px 250px;
	border: 2px solid #93C0C5;
	border-radius: 20px;
	text-decoration: none;
	text-align: center;
	color: #93C0C5;
	font-weight: bold;
}
.b1:hover {
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
	color: white;
}
.btn {
	width: 450px;
	font-size: 15px;
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
	margin: 5px auto 20px auto;
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
.b2 {
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
.b2:hover {
	background-color: #93C0C5;
	color: white;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../form/header.jsp"></jsp:include>
	<!-- -------------------------------------------------------------------------------- -->
	<div class="title">
		<h1>${pDto.p_title}</h1>
	</div>
	<!-- ------------------------------------top----------------------------------------- -->
	<div class="top">
		<div class="tl"></div>
		<!-- ---------------------------------------------------------------------------- -->
		<div>
			<div class="tr">
				<h1>프로젝트 기간</h1>
				<h3>${pDto.start_date} - ${pDto.end_date}</h3>
				<h1>모인금액/목표금액</h1>
				<h3>&nbsp;/&nbsp;${pDto.target_amount}</h3> 
				<h1>후원자 수</h1>
				<h3></h3>
			</div>
			<input type="button" class="b1" value="후원하기" onclick="location.href='orderPayForm'">
		</div>
	</div>
	<!-- -------------------------------------------------------------------------------- -->
	<!-- -------------------------------middle-------------------------------------------- -->
	<div class=middle>
		<div class="btn">
			<a href="">프로젝트 소개</a> 
			<a href="">프로젝트 공지</a> 
			<a href="">펀딩안내</a>
		</div>
	</div>
	<!-- -------------------------------------------------------------------------------- -->
	<!-- ---------------------------------bottom----------------------------------------- -->
	<!-- 공지사항 -->
	<div class="bottom" id="div_notice">
		<div class="bl">
			<table style="margin-top:20px;">
            <col width="80px"><col width="300px"><col width="80px">
            <thead>
               <tr>
                  <th>글번호</th>
                  <th>제목</th>
                  <th>작성일자</th>
               </tr>
            </thead>
            <tbody id="tbody_notice">
               <tr>
                  <td>1</td>
                  <td><a href="notice_view" style="color:black;">임시용 제목 1</a></td>
                  <td>yyyy-MM-dd</td>
               </tr>
            </tbody>
         </table>
		</div>
		<div class="button">
            <div class="br"></div>  
            <input type="button" class="b2" value="공지사항 등록" onclick="location.href='pjupnotice.do'">
             <input type="button" class="b2" value="화상설명회 개최공지" onclick="location.href='pjupnotice.do'">
        </div>
    </div>
    
    <!-- 펀딩안내 -->
    <div class="bottom" id="div_funding" style="display:none;">
		<div class="bl">
			펀딩안내 (프로젝트 등록시)
		</div>
		<div style="text-align: center;">
			<div class="br">
				창작자 소개 (창작 회원 가입시)
				
			</div>
			<input type="button" class="b2" value="공지사항 등록" onclick="location.href='pjupnotice.do'"> 
			<input type="button" class="b2" value="화상설명회 개최공지" onclick="location.href='pjupnotice.do'">
		</div>
	</div> 
	<!-- ----------------------------------------------------------- -->
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>
</body>
</html>