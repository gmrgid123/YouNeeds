<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="per" value="${ sumOrder / pDto.target_amount * 100}"/>


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
	height: 100%;
	min-height: 300px;
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
<script type="text/javascript">
function open_chat(){
	window.open("https://${chat_addr}:3000","화상 채팅", "width=480px,height=510px");
}
</script>
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
		<div class="tl">
			<img alt="" src="${path}/uploadImg/projectTitle/${pDto.projectTilteImgDto.title_stored_name}" style="width: 100%; height: 100%;">
		</div>
		<!-- ---------------------------------------------------------------------------- -->
		<div>
			<div class="tr">
				<h1>프로젝트 기간</h1>
				<h3>${pDto.start_date } - ${pDto.end_date }</h3>
				<h1>모인금액/목표금액</h1>
				<h3><fmt:formatNumber value="${sumOrder}" pattern="#,###"/> 원&nbsp;/&nbsp;<fmt:formatNumber value="${pDto.target_amount}" pattern="#,###"/> 원&nbsp;&nbsp;&nbsp;( ${per}% 달성 )</h3> 
				<h1>후원자 수</h1>
				<h3><fmt:formatNumber value="${orderCount}" pattern="#,###"/> 명</h3>
			</div>
			<input type="button" class="b1" value="후원하기" onclick="location.href='orderPayForm?p_id=${pDto.p_id}'">
		</div>
	</div>
	<!-- -------------------------------------------------------------------------------- -->
	<!-- -------------------------------middle-------------------------------------------- -->
	<div class=middle>
		<div class="btn">
			<a href="pjdetail.do?p_id=${pDto.p_id}" style="color:black;">프로젝트 소개</a> 
			<a href="pjNoticeList?p_id=${pDto.p_id}&page=1">프로젝트 공지</a> 
			<a href="pjFundGuide?p_id=${pDto.p_id}">펀딩안내</a>
		</div>
	</div>

	<!-- -------------------------------------------------------------------------------- -->
	<!-- ---------------------------------bottom----------------------------------------- -->
	<div class="bottom" id="div_intro">
		<div class="bl" id="p_intro" name="p_intro">
			<h1 style="text-align: center;">&lt; INTRO &gt;</h1>
			${pDto.projectIntroDto.p_intro }
		</div>
		<div style="text-align: center;">
			<div class="br">
				<h3>&lt; 창작자 &gt;</h3>
				<p>${pDto.creatorDto.create_name }</p>
				<h3>&lt; Intro &gt;</h3>
				<p>${pDto.creatorDto.create_intro }</p>
			</div>
			<input type="button" class="b2" value="공지사항 등록" onclick="location.href='pjNoticeUploadForm?p_id=${pDto.p_id}';"> 
			<input type="button" class="b2" value="화상설명회" onclick="location.href='javascript:open_chat()'">
		</div>
	</div>	

    
	<!-- ----------------------------------------------------------- -->
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>
</body>
</html>