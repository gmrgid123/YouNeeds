<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="${path}/resources/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="${path}/resources/css/slider/slider-banner.css" rel="stylesheet" type="text/css">
<title>General Sign up</title>
<style type="text/css">
	*{
  		margin: 0px;
  		padding: 00px;
  		text-decoration: none;
	}
	
	#top{
		background-color: #F4FFFF;
	}
	
	#signup{
		height: 450px;
	}
	
	.singupForm {
		font-family:sans-serif;
  		position:absolute;
  		margin-top: 0px;
  		margin-bottom: 10px;
  		padding: 30px, 20px;
		width:500px;
		height:300px;
		background-color:#FFFFFF;
		text-align:left;
		top:50%;
		left:50%;
		transform: translate(-50%,-50%);
		border-radius: 15px;
	}
	
	.title{
		text-align: left;
		margin: 30px;
		font-weight: bold;
	}
	
	.sub_title{
		text-align: center;
		margin: 30px;
		font-weight: bold;
	}
	
	.sub_sub_title{
		text-align: center;
		margin: 30px;
		font-size: 11pt;
		font-weight: bold;
	}

	.passForm{
		color: black;
		margin: 30px;
		padding: 10px 10px;
		font-size: 15pt;
		font-weight: bold;
	}
	
	.userpw{
		border: none;
		border-bottom: 2px solid #adadad;
		outline:none;
		color: #636e72;
		font-size:20px;
		width: 330px;
		height:30px;
		background: none;
	}

	.userbtn{
		position:relative;
		margin-top: -30px;
		left:80%;
		background-color: #6c5ce7;
		color: white;
		width: 100px;
		height:30px;
		font-size: 10pt;
		font-weight: bold;
		border-radius: 3px;
		border:none;
	}
	
</style>

</head>
<body id="top">
	<!-- header include -->
	<jsp:include page="../form/header.jsp"></jsp:include>

<div id="signup">
	<form action="main.do" method="post" class="singupForm">
		<h1 class="title">Update account</h1>
		<h1 class="sub_title">비밀번호 재확인</h1>
		<div class="sub_sub_title">
			개인정보를 위해 비밀번호를 재확인합니다.
		</div>
		<div class="passForm">비밀번호<br><br>
        	<input type="password" id="userpw" class="userpw" placeholder="비밀번호 입력하세요.">
      		<input type="button" class="userbtn" value="확인">
      	</div>
      </form>
		
</div>
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>

</body>
</html>