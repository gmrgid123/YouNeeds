<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="${path}/resources/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="${path}/resources/css/slider/slider-banner.css" rel="stylesheet" type="text/css">
<title>Sign up</title>
<style>
	#top{
		background-color: #F4FFFF;
	}
	
	#btn{
		margin-top: 50px 
	}
	.g_btn{
		position:relative;
		left:35%;
		margin-top: 20px;
		margin-bottom: 50px;
		padding: 50px 40px;
		background-color: #00008C;
		border-radius: 10px;
		border:none;
	}
	
	.g_btn a{
		color: white;
		text-decoration: none;
		pont-size: 200%;
		font-weight: bold;
		text-align: center;
	}
	
	.c_btn{
		position:relative;
		left:55%;
		margin-top: -274px;
		margin-bottom: 50px;
		padding: 50px 40px;
		background-color: #646464;
		border:none;
		border-radius: 10px;
	}
	
	.c_btn a{
		color: white;
		text-decoration: none;
		pont-size: 35pt;
		font-weight: bold;
		text-align: center;
	}
</style>
</head>
<body id="top">
	<!-- header include -->
	<jsp:include page="../form/header.jsp"></jsp:include>
	
	<div id=btn>
		<button class="g_btn"><a href="general.do" style="font-size: 35pt">일반<br>회원</a></button>
		<button class="c_btn"><a href="create.do" style="font-size: 35pt">창작<br>회원</a></button>
	</div>
	
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>
	
</body>
</html>