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
<title>Create Sign up</title>
<style type="text/css">
	*{
  		margin: 0px;
  		padding: 00px;
  		text-decoration: none;
	}
	
	span{
		font-size: 17px;
	}
	
	#top{
		background-color: #F4FFFF;
	}
	
	#signup{
		height: 1300px;
	}
	
	.singupForm {
		font-family:sans-serif;
  		position:absolute;
  		margin-top: 400px;
  		margin-bottom: 10px;
  		padding: 30px, 20px;
		width:540px;
		height:1200px;
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
	
	.c_name{
		border: none;
		border-bottom: 2px solid #adadad;
		outline:none;
		color: #636e72;
		font-size:20px;
		width: 330px;
		height:30px;
		background: none;
	}
	
	.c_intro{
		border: none;
		border-bottom: 2px solid #adadad;
		outline:none;
		color: #636e72;
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
	
	.final_mail_ck{
		display: none;
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
	.final_create{
		display: none;
	}
	.final_create_int{
		display: none;
	}
</style>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
/* ?????? */
function goPopup(){

    new daum.Postcode({
        oncomplete: function(data) {
            $("#address").eq(0).val(data.address);
        }
    }).open();
    
}

/* ????????? ?????? ?????????*/
function mailFormCheck(email){
    var form = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
 	return form.test(email);
} 

$(function(){
	/* ????????? ?????? */
	var code=" ";
	
	/* ????????? ?????? */
	   var nicknameCheck = false; //?????????
	   var nicknameckCheck = false; //????????? ??????
	   var pwCheck = false; //??????
	   var pwckCheck = false; //????????????
	   var pwckorCheck = false; //?????? ?????? ??????
	   var mailCheck = false; //?????????
	   var mailnumCheck = false; //????????? ????????????
	   var addressCheck = false; //??????
	   var createCheck = false; //????????????
	   var createIntCheck = false; //????????????
	
	 /* ????????? ???????????? */
	   $("#email").click(function(){
	    	var email = $(".useremail").val();
	    	var checkBox = $(".num_email");
	    	var boxWrap=$(".emailForm");
	    	var warnMsg =$(".mail_warn");
	    	
	    	/* ????????? ????????? */
	    	if(mailFormCheck(email)){
	    		warnMsg.html("???????????? ?????? ???????????????. ???????????? ??????????????????.");
	    		warnMsg.css("display", "inline-block");
	    	}else{
	    		warnMsg.html("???????????? ?????? ????????? ???????????????.");
	    		warnMsg.css("display", "inline-block");
	    		return false;
	    	}
	    	
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
	    	
	
	    	/* ???????????? ?????? */
	 	   $("#c_mail").click(function(){
	 		    	var inputCode = $(".num_email").val();
	 		    	var checkResult = $("#c_mail_warn");
	 		    	
	 		    	if(inputCode == code){
	 		            checkResult.html("??????????????? ???????????????.");
	 		            checkResult.attr("class", "correct"); 
	 		            mailnumCheck=true;
	 		        }else if(inputCode != code){
	 		    		checkResult.html("??????????????? ?????? ??????????????????.");
	 		    		checkResult.attr("class", "incorrect");
	 		    		mailnumCheck=false;
	 		    	}
	 	   });
	    	
	 	  /* ???????????? ?????? ??????*/
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
	 	  
		   /* ????????? ?????? */
		   $("#nickname_btn").click(function(){
		    	var nickname =$(".nickname").val();
		    	var data = {m_nickname : $("#nickname").val()}
		    	
		    	$.ajax({
		    		type: "post",
		    		url: "nicknameChk.do",
		    		data: data,
		    		success:function(result){
		    			console.log("??????"+result);
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
		 //????????????
		   $("#join_button").click(function(){
			   /* ????????? ?????? */
			   var nickname = $(".nickname").val();
			   var pw = $("#userpw").val();
			   var pwck = $("#c_userpw").val();
			   var mail = $(".useremail").val();
			   var addr = $(".address").val();
			   var create = $(".c_name").val();
			   var createInt = $(".c_intro").val();
			   
			   /* ????????? ????????? */
			   if(nickname==""){
				   $(".final_nickname_ck").css("display", "block");
				   nicknameCheck=false;
			   }else{
				   $(".final_nickname_ck").css("display", "none");
				   nicknameCheck=true;
			   }
			   
			   /* ???????????? ????????? */
			   if(pw==""){
				   $(".final_pw_ck").css("display", "block");
				   pwCheck=false;
			   }else{
				   $(".final_pw_ck").css("display", "none");
				   pwCheck=true;
			   }
			   
			   /* ???????????? ?????? ????????? */
			   if(pwck==""){
				   $(".final_pwck_ck").css("display", "block");
				   pwckCheck=false;
			   }else{
				   $(".final_pwck_ck").css("display", "none");
				   pwckCheck=true;
			   }
			   
			   /* ????????? ????????? */
			   if(mail==""){
				   $(".final_mail_ck").css("display", "block");
				   mailCheck=false;
			   }else{
				   $(".final_mail_ck").css("display", "none");
				   mailCheck=true;
				   
				   var address=$("#address").val();
				   var sub_address=$("#sub_address").val();
				   //var m_addr="";
				   
				  // m_addr=address+sub_address;
				
				   $("#m_addr").val(address);
				   $("#m_addr_detail").val(sub_address);
			   }
			   
			   /* ?????? ????????? */
			   if(addr==""){
				   $(".final_addr_ck").css("display", "block");
				   addressCheck=false;
			   }else{
				   $(".final_addr_ck").css("display", "none");
				   addressCheck=true;
			   }
			   
			   /* ???????????? ????????? */
			   if(create==""){
				   $(".final_create").css("display", "block");
				   createCheck=false;
			   }else{
				   $(".final_create").css("display", "none");
				   createCheck=true;
			   }
			   
			   /*????????? ?????? ?????????*/
			   if(createInt==""){
				   $(".final_create_int").css("display", "block");
				   createIntCheck=false;				   
			   }else{
				   $(".final_create_int").css("display", "none");
				   createIntCheck=true;
			   }
			   
			   /* ?????? ????????? */
			   if(nicknameCheck && nicknameckCheck && pwCheck && pwckCheck && pwckorCheck && mailCheck && mailnumCheck && addressCheck && createCheck && createIntCheck){
				   $("#join_form").attr("action", "c_insert.do");
				   $("#join_form").submit();
				   console.log("??????");
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
	<form action="" method="post" id="join_form" class="singupForm">
		<h1>Create account</h1>
		<input type="hidden" name="memberDto.m_type" value="??????">
		<div class="emailForm">?????????<br><br>
        	<input type="text" name="memberDto.m_email" id="useremail" class="useremail" placeholder="????????? ?????? ??? ??????????????????.">
       		<input type="button" id="email" class="userbtn" value="????????????">
       		<input type="text" id="num_email" class="num_email" placeholder="???????????? ???????????????.">
       		<input type="button" id="c_mail" class="userbtn" value="????????????">
      		<div class="clearfix"></div>
       		<span id="c_mail_warn"></span>
       		<span class="final_mail_ck">???????????? ??????????????????.</span>
      		<span class="mail_warn"></span>
      	</div>
      	<div class="passForm">????????????<br><br>
        	<input type="password" id="userpw" class="userpw" placeholder="???????????? ???????????????.">
      		<span class="final_pw_ck">??????????????? ??????????????????.</span>
      		<br>???????????? ??????<br><br>
        	<input type="password" name="memberDto.m_pw" id="c_userpw" class="userpw" placeholder="???????????? ???????????????.">
      		<span class="final_pwck_ck">???????????? ????????? ??????????????????.</span>
      		<span class="pw_1">??????????????? ???????????????.</span>
      		<span class="pw_2">??????????????? ???????????? ????????????.</span>
      	</div>
      	<div class="nicknameForm">?????????<br><br>
        	<input type="text" name="memberDto.m_nickname" id="nickname" class="nickname" placeholder="????????? ???????????????.">
      		<input type="button" id="nickname_btn" class="userbtn" value="????????????">
      		<span class="nick_1">?????? ????????? ??????????????????.</span>
      		<span class="nick_2">?????? ????????? ??????????????????.</span>
      		<span class="final_nickname_ck">???????????? ??????????????????.</span>
      	</div>
      	<div class="addrForm">??????<br><br>
			<input type="button" id="address_btn" class="userbtn" onclick="goPopup()" value="????????????"> 
			<input type="hidden" name="memberDto.m_addr" id="m_addr">
			<input type="hidden" name="memberDto.m_addr_detail" id="m_addr_detail"> 
			<input type="text" id="address" class="address" placeholder="????????? ???????????????." required readonly>
      		<input type="text" id="sub_address" class="sub_address" placeholder="??????????????? ???????????????." required="required">
      		<span class="final_addr_ck">????????? ??????????????????.</span>
      	</div>
      	<div class="passForm">????????? ???<br><br>
        	<input type="text" name="create_name" id="c_name" class="c_name" placeholder="????????? ?????? ???????????????.">
      		<span class="final_create">????????? ?????? ??????????????????.</span>
      		<br>????????? ??????<br><br>
        	<textarea cols="45" rows="3" name="create_intro" id="c_intro" class="c_intro" placeholder="????????? ????????? ???????????????."></textarea>
      		<span class="final_create_int">????????? ????????? ??????????????????.</span>
      	</div>
      	<input type="submit" class="btn" value="Create your YouNeeds account" id="join_button">
	</form>
</div>
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>

</body>
</html>