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
		height: 1000px;
	}
	
	.singupForm {
		font-family:sans-serif;
  		position:absolute;
  		margin-top: 250px;
  		margin-bottom: 10px;
  		padding: 30px, 20px;
		width:500px;
		height:800px;
		background-color:#FFFFFF;
		text-align:left;
		top:50%;
		left:50%;
		transform: translate(-50%,-50%);
		border-radius: 15px;
	}
	
	.singupForm h1{
		text-align: center;
		margin: 30px;
		font-weight: bold;
	}
	
	.emailForm{
		color: black;
		margin: 30px;
		padding: 10px 10px;
		font-size: 15pt;
		font-weight: bold;
	}
	
	.correct{
		color: green;
	}
	
	.incorrect{
		color: red;
	}
	
	.passForm{
		color: black;
		margin: 30px;
		padding: 10px 10px;
		font-size: 15pt;
		font-weight: bold;
	}
	
	.nicknameForm{
		color: black;
		margin: 30px;
		padding: 10px 10px;
		font-size: 15pt;
		font-weight: bold;
	}
	
	.addrForm{
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
	
	.num_email{
		border: none;
		border-bottom: 2px solid #adadad;
		outline:none;
		color: #636e72;
		font-size:20px;
		width: 330px;
		height:30px;
		background: none;
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
	
	.nickname{
		border: none;
		border-bottom: 2px solid #adadad;
		outline:none;
		color: #636e72;
		font-size:20px;
		width: 330px;
		height:30px;
		background: none;
	}
	.nick_1{
		color: green;
		display: none;
	}
	
	.nick_2{
		color: red;
		display: none;
	}
	
	.address{
		border: none;
		border-bottom: 2px solid #adadad;
		outline:none;
		color: #636e72;
		font-size:20px;
		width: 330px;
		height:30px;
		background: none;
	}
	
	.sub_address{
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
	
	.btn {
		position:relative;
		left:50%;
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
</style>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
/* 주소 */
function goPopup(){

    new daum.Postcode({
        oncomplete: function(data) {
            $("#address").eq(0).val(data.address);
        }
    }).open();
    
}
    
   
   $(function(){
	   /* 이메일 인증 */
		var code=" ";
	   $("#email").click(function(){
	    	var email = $(".useremail").val();
	    	var checkBox = $(".num_email");
	    	var boxWrap=$(".emailForm");
	    	
	    	$.ajax({
	    		type: "GET",
	    		url:"mailCheck?email="+email,
	    		success:function(data){
	    			console.log("data:"+data);
	    			checkBox.attr("disabled", false);
	    			code=data;
	    		}
	    	});
	    });
	   
	   /* 인증번호 비교*/
	   $("#c_mail").click(function(){
		    	var inputCode = $(".num_email").val();
		    	var checkResult = $("#c_mail_warn");
		    	
		    	if(inputCode == code){
		            checkResult.html("인증번호가 일치합니다.");
		            checkResult.attr("class", "correct");        
		        }else if(inputCode != code){
		    		checkResult.html("인증번호를 다시 확인해주세요.");
		    		checkResult.attr("class", "incorrect");
		    	}
	   });
	   
	   /* 닉네임 중복 */
	   $("#nickname_btn").click(function(){
	    	var nickname =$(".nickname").val();
	    	var data = {nickname : nickname}
	    	
	    	$.ajax({
	    		type: "post",
	    		url: "/nicknameChk",
	    		data: data
	    	});
	    });
	});
    
</script>
</head>
<body id="top">
	<!-- header include -->
	<jsp:include page="../form/header.jsp"></jsp:include>

<div id="signup">
	<form action="main.do" method="post" class="singupForm">
		<h1>Create account</h1>
		<div class="emailForm">이메일<br><br>
        	<input type="text" id="useremail" class="useremail" placeholder="이메일 입력 후 인증해주세요.">
       		<input type="button" id="email" class="userbtn" value="인증하기"/>
       		<input type="text" id="num_email" class="num_email" placeholder="인증번호 입력하세요." disabled="disabled">
       		<input type="button" id="c_mail" class="userbtn" value="인증확인">
       		<div class="clearfix"></div>
       		<span id="c_mail_warn"></span>
      	</div>
      	<div class="passForm">비밀번호<br><br>
        	<input type="password" id="userpw" class="userpw" placeholder="비밀번호 입력하세요.">
      		<br>비밀번호 확인<br><br>
        	<input type="password" id="c_userpw" class="userpw" placeholder="비밀번호 확인하세요.">
      	</div>
      	<div class="nicknameForm">닉네임<br><br>
        	<input type="text" id="nickname" class="nickname" placeholder="닉네임 입력하세요.">
      		<input type="button" id="nickname_btn" class="userbtn" value="중복확인">
      		<span class="nick_1">사용 가능한 닉네임입니다.</span>
      		<span class="nick_2">이미 존재한 닉네임입니다.</span>
      	</div>
      	<div class="addrForm">주소<br><br>
			<input type="button" id="address_btn" class="userbtn" onclick="goPopup()" value="주소검색"> 
			<input type="text" id="address" class="address" placeholder="주소를 검색하세요." required readonly>
      		<input type="text" id="sub_address" class="sub_address" placeholder="상세주소를 입력하세요.">
      	</div>
      	<input type="submit" class="btn" value="Create your YouNeeds account" onclick="">
	</form>
</div>
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>

</body>
</html>