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
<title>Found Password</title>
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

	.emailForm{
		color: black;
		margin: 30px;
		padding: 10px 10px;
		font-size: 15pt;
		font-weight: bold;
	}
	
	.useremail{
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
	
	.final_mail_ck{
		display: none;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">

var mailCheck = false; //이메일

$(function(){
	
	$("#email").click(function(){
		var mail = $(".useremail").val();
		if(mail==""){
			   $(".final_mail_ck").css("display", "block");
			   mailCheck=false;
		   }else{
			   $(".final_mail_ck").css("display", "none");
			   mailCheck=true;
		   }
		 /* 최종 유효성 */
		 if(mailCheck){
			 $(".singupForm").attr("action", "find_pass.do");
			 $(".singupForm").submit();
		 }
		return false;
	});
});
</script>
</head>
<body id="top">
	<!-- header include -->
	<jsp:include page="../form/header.jsp"></jsp:include>

<div id="signup">
	<form action="" method="post" class="singupForm">
		<h1 class="title">Found Password</h1>
		<h1 class="sub_title">비밀번호 찾기</h1>
		<div class="sub_sub_title">
			가입하셨던 이메일 계정을 입력하시면,
			이메일로 발송해드립니다.
		</div>
		<div class="emailForm">이메일<br><br>
        	<input type="text" name="m_email" id="useremail" class="useremail" placeholder="이메일 입력 후 발송해주세요.">
       		<input type="submit" id="email" class="userbtn" value="발송하기">
      		<span class="final_mail_ck">이메일을 입력해주세요.</span>
      		<span class="mail_warn"></span>
      	</div>
      </form>
		
</div>
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>

</body>
</html>