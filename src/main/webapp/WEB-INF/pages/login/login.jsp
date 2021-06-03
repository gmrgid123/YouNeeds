<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML>
<html>
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="${path}/resources/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="${path}/resources/css/slider/slider-banner.css" rel="stylesheet" type="text/css">
<style>
	*{
  		margin: 0px;
  		padding: 00px;
  		text-decoration: none;
	}
	
	#top{
		background-color: #F4FFFF;
	}
	
	#login{
		height: 400px;
	}

	.loginForm {
		font-family:sans-serif;
  		position:absolute;
  		margin-top: 50px;
  		margin-bottom: 100px;
  		padding: 30px, 20px;
		width:300px;
		height:400px;
		background-color:#FFFFFF;
		text-align:center;
		top:50%;
		left:50%;
		transform: translate(-50%,-50%);
		border-radius: 15px;
	}

	.loginForm h2{
		text-align: center;
		margin: 30px;
	}
		
	.emailForm{
		border-bottom: 2px solid #adadad;
		margin: 30px;
		padding: 10px 10px;
	}
		
	.passForm{
		border-bottom: 2px solid #adadad;
		margin: 30px;
		padding: 10px 10px;
	}
		
	.email {
		width: 100%;
		border:none;
		outline:none;
		color: #636e72;
		font-size:16px;
		height:25px;
		background: none;
	}
		
	.pw {
		width: 100%;
		border:none;
		outline:none;
		color: #636e72;
		font-size:16px;
		height:25px;
		background: none;
		}
		
	.login_warn{
		margin-top: 30px;
		text-align: center;
		color: red;
	}
		
	.btn {
		position:relative;
		left:40%;
		transform: translateX(-50%);
		margin-bottom: 40px;
		width:80%;
		height:40px;
		background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
		background-position: left;
		background-size: 200%;
		color:white;
		font-weight: bold;
		border:none;
		cursor:pointer;
		transition: 0.4s;
		display:inline;
	}
		
	.btn:hover {
		background-position: right;
	}
	
	.passText {
		font-size: 9pt;
		text-align: right;
		margin-right: 30px;
	}
		
	.bottomText {
		text-align: center;
	}
	
	#footer{
		margin-top: 200px;
	}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	
	  $(function(){
		  	let message = '${msg}';
			console.log(message);
			
	         if(message == "fail"){
	            alert("일치하는 이메일 정보가 없습니다. 회원가입 진행해주세요.");
	            
	         } else if(message == "success"){
	            alert("이메일로 발송해 드렸습니다. 로그인 진행해주세요.");
	         }
	         //alert(message);
	   	  
	 		$("#login_btn").click(function(){
	 			$("#loginForm").attr("action", "login.do");
	 			$("#loginForm").submit();
	 		});
	   });

</script>

</head>
<body id="top">

	<!-- header include -->
	<jsp:include page="../form/header.jsp"></jsp:include>

<div id="login">
	<form action="" method="post" id="loginForm" class="loginForm">
      <h2>Login</h2>
      <div class="emailForm">
        <input type="text" name="m_email" id="email" class="email" placeholder="E-MAIL">
      </div>
      <div class="passForm">
        <input type="password" name="m_pw" id="pw" class="pw" placeholder="PW">
      </div>
      <c:if test="${msg=='false'}">
      	<div class="login_warn">이메일 또는 비밀번호를 잘못 입력하셨습니다.</div>
	</c:if>
       <div class="passText">
        <a href="found_pw">비밀번호를 잊으셨나요?</a>
      </div>
      <br>
      <input type="button" id="login_btn" class="btn" value="LOG IN">
      
      <div class="bottomText">
        Don't you have ID? <a href="general_create.do">sign up</a>
      </div>
    </form>
</div>

	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>

</body>
</html>