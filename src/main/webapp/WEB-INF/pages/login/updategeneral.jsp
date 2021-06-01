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
<title>Update Account</title>
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
		height: 900px;
	}
	
	.singupForm {
		font-family:sans-serif;
  		position:absolute;
  		margin-top: 200px;
  		margin-bottom: 10px;
  		padding: 30px, 20px;
		width:540px;
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
	
	.pw_1{
		color: green;
		display: none;
	}
	
	.pw_2{
		color: red;
		display: none;
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
	
	.final_pw_ck{
		display: none;
	}
	.final_pwck_ck{
		display: none;
	}
	.final_nickname_ck{
		display: none;
	}
	.final_addr_ck{
		display: none;
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
	var nicknameCheck = false; //닉네임
	var nicknameckCheck = false; //닉네임 중복
	var pwCheck = false; //비번
	var pwckCheck = false; //비번확인
	var pwckorCheck = false; //비번 확인 일치
	var addressCheck = false; //주소

	/* 비밀번호 확인 일치*/
	$("#c_userpw").on("propertychange change keyup paste input", function(){
		   var pw=$("#userpw").val();
		   var pwck=$("#c_userpw").val();
		   $(".final_pwck_ck").css("display", "none");
		   
		   if(pw == pwck){
			   $(".pw_1").css("display", "block");
			   $(".pw_2").css("display", "none");
			   pwckorCheck = true;
		   }else{
			   $(".pw_1").css("display", "none");
			   $(".pw_2").css("display", "block");
			   pwckorCheck = false;
		   }
	});
	/* 닉네임 중복 */
	$("#nickname_btn").click(function(){
	 	var nickname =$(".nickname").val();
	 	var data = {m_nickname : $("#nickname").val()}
	 	
	 	$.ajax({
	 		type: "post",
	 		url: "nicknameChk.do",
	 		data: data,
	 		success:function(result){
	 			console.log("성공"+result);
	 			if(result != 'fail'){
	 				$(".nick_1").css("display", "inline-block");
	 				$(".nick_2").css("display", "none");
	 				nicknameckCheck=true;
	 			}else{
	 				$(".nick_2").css("display", "inline-block");
	 				$(".nick_1").css("display", "none");
	 				nicknameckCheck=false;
	 			}
	 		}
	 	});
	});
	 	
	 	//수정하기
	 	$("#update").click(function(){
	 		var nickname = $(".nickname").val();
			var pw = $("#userpw").val();
			var pwck = $("#c_userpw").val();
			var addr = $(".address").val();
			
			console.log("update")
			
			/* 닉네임 유효성 */
			   if(nickname==""){
				   $(".final_nickname_ck").css("display", "block");
				   nicknameCheck=false;
			   }else{
				   $(".final_nickname_ck").css("display", "none");
				   nicknameCheck=true;
				   
				   var address=$("#address").val();
				   var sub_address=$("#sub_address").val();
				   var m_addr="";
				   
				   m_addr=address+sub_address;
				
				   $("#m_addr").val(m_addr);
			   }
			
			   /* 비밀번호 유효성 */
			   if(pw==""){
				   $(".final_pw_ck").css("display", "block");
				   pwCheck=false;
			   }else{
				   $(".final_pw_ck").css("display", "none");
				   pwCheck=true;
			   }
			   
			   /* 비밀번호 확인 유효성 */
			   if(pwck==""){
				   $(".final_pwck_ck").css("display", "block");
				   pwckCheck=false;
			   }else{
				   $(".final_pwck_ck").css("display", "none");
				   pwckCheck=true;
			   }
			   
			   /* 주소 유효성 */
			   if(addr==""){
				   $(".final_addr_ck").css("display", "block");
				   addressCheck=false;
			   }else{
				   $(".final_addr_ck").css("display", "none");
				   addressCheck=true;
			   }
			   
			   /* 최종 유효성 */
			   if(nicknameCheck && nicknameckCheck && pwCheck && pwckCheck && pwckorCheck && addressCheck){
				   $("#update_form").attr("action", "update.do");
				   $("#update_form").submit();
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
	<form action="" method="post" id="update_form" class="singupForm">
	<input type="hidden" name="m_uid" value="${member.m_uid }">
		<h1>Update account</h1>
		<div class="emailForm">이메일<br><br>
        	<input type="text" name="m_email" id="useremail" class="useremail" value="${member.m_email }" readonly="readonly">
      	</div>
      	<div class="passForm">비밀번호<br><br>
        	<input type="password" id="userpw" class="userpw" value="${member.m_pw }">
      		<br>비밀번호 확인<br><br>
        	<input type="password" name="m_pw" id="c_userpw" class="userpw" placeholder="비밀번호 확인하세요.">
      		<span class="final_pwck_ck">비밀번호 확인을 입력해주세요.</span>
      		<span class="pw_1">비밀번호가 일치합니다.</span>
      		<span class="pw_2">비밀번호가 일치하지 않습니다.</span>
      	</div>
      	<div class="nicknameForm">닉네임<br><br>
        	<input type="text" name="m_nickname" id="nickname" class="nickname" value="${member.m_nickname }">
      		<input type="button" id="nickname_btn" class="userbtn" value="중복확인">
      		<span class="nick_1">사용 가능한 닉네임입니다.</span>
      		<span class="nick_2">이미 존재한 닉네임입니다.</span>
      		<span class="final_nickname_ck">닉네임을 입력해주세요.</span>
      	</div>
      	<div class="addrForm">주소<br><br>
			<input type="button" id="address_btn" class="userbtn" onclick="goPopup()" value="주소검색"> 
			<input type="hidden" name="m_addr" id="m_addr"> 
			<input type="text" id="address" class="address" value="${member.m_addr }" readonly="readonly">
      		<input type="text" id="sub_address" class="sub_address" placeholder="상세주소를 입력하세요.">
      		<span class="final_addr_ck">주소를 입력해주세요.</span>
      	</div>
      	<input type="submit" id="update" class="btn" value="수정하기">
	</form>
</div>
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>

</body>
</html>