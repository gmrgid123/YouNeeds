<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/resources/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="${path}/resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<style type="text/css">
.content_body{
	padding: 40px 40px 88px;
	border-radius: 4px;
    border: 1px solid rgb(230, 230, 230);
}
.regdate{
	font-size: 13px;
    line-height: 20px;
    letter-spacing: -0.015em;
    font-family: 'SF Pro Text', 'Helvetica Neue', 'Segoe UI', Arial, 'NotoSansKR', sans-serif;
    color: rgb(109, 109, 109);
    margin: 0 10px 0 0;
    padding: 0 10px 0 0;
}

.reply_body{
	margin-bottom: 30px;
}


.btn_div{
	text-align: center;
	margin: 30px;
}

#listGo{
	width: 200px;
	height: 50px;
}

.reply_box{
	padding: 0.5em;
}

.reply_content_td{
	word-break:break-all;
	font-size: 16px;
}
.reply_date_td{
	text-align:right;
	color: rgb(109, 109, 109);
}

</style>

<script type="text/javascript" src="${path}/resources/ckeditor/ckeditor.js"></script>
</head>
<body>
	<!-- include header -->
	<jsp:include page="../../pages/form/header.jsp"></jsp:include>

	<hr>
	<div style="margin-top: 50px; margin-bottom: 50px; padding-right: 20%; padding-left: 20%;">
		<div class="content_body">
			<div class="content_title">
				<h1 style="text-align: center; margin-bottom: 30px;">QnA 타이틀</h1>
				<div style="float: right;">
					<span class="regdate" style="border-right: 1px solid; border-color: #D7D7D7;">작성자 : 아무개</span>
					<span class="regdate" style="border-right: 1px solid; border-color: #D7D7D7;">작성일 : yyyy-dd-mm</span>
					<span class="regdate">조회수 : 0</span>
				</div>
			</div>
		
			<br>
			<hr>
			<br>
			
			<div class="content" style="margin-right: 10%; margin-left: 10%;">
				<p>내용을 채워야 합니다</p>
			</div>
			
			<br>
			<hr>
		
			<h3 style="text-align: center;">댓글</h3>
			
			<hr>
			
			<div class="reply_body">
				<div class="reply_box">
					<table class="table table-hover" id="reply_table" style="border-bottom: 1px solid #dee2e6;">
						<col width="80px"><col width="400px"><col width="150px">
						<tr>
							<td>닉네임</td>
							<td class="reply_content_td">내용물aaaㄹㄴㅇㅎㄴㅀasdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</td>
							<td class="reply_date_td">yyyy-MM-dd</td>
						</tr>
						<tr>
							<td>홍길동</td>
							<td class="reply_content_td">내용물aaaㄹㄴㅇㅎㄴㅀasdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</td>
							<td class="reply_date_td">yyyy-MM-dd</td>
						</tr>
						<tr>
							<td>닉네임</td>
							<td class="reply_content_td">내용물aaaㄹㄴㅇㅎㄴㅀasdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</td>
							<td class="reply_date_td">yyyy-MM-dd</td>
						</tr>
						<tr>
							<td>닉네임</td>
							<td class="reply_content_td">내용물aaaㄹㄴㅇㅎㄴㅀasdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</td>
							<td class="reply_date_td">yyyy-MM-dd HH:mm:ss</td>
						</tr>
						<tr>
							<td>닉네임</td>
							<td class="reply_content_td">내용물a</td>
							<td class="reply_date_td">yyyy-MM-dd</td>
						</tr>
					</table>
				</div>
				
				<nav class="pagination justify-content-center" style="margin-bottom: 30px;">
			        <ul>
			          <li><a href="#">&laquo; Previous</a></li>
			          <li><a href="#">1</a></li>
			          <li><a href="#">2</a></li>
			          <li><a href="#">3</a></li>
			          <li><a href="#">4</a></li>
			          <li><a href="#">5</a></li>
			          <li><a href="#">Next &raquo;</a></li>
			        </ul>
	      	</nav>
				
			</div>
			
			
			
			<hr>
			
			<div class="reply_edit" style="margin-right: 5%; margin-left: 5%;">
				<div style="padding: 0.3em;"><h5>댓글 작성</h5></div>
				<div>
					<form action="" method="post">
					
						<table style="margin: auto; text-align: center;">
							<col width="1200px"><col width="100px;">
							<tr>
								<td><textarea name="reply_content" style="width: 100%; height:100px; resize: none;" maxlength="8000" required="required"></textarea></td>
								<td><input type="submit" value="작성" style="width: 100%; height:100px;"></td>
							</tr>
						</table>
						
						
					</form>
				</div>
			</div>
			
		</div>
		
		
		
		
		
		<div class="btn_div">
			<input id="listGo" type="button" class="btn btn-secondary"  value="목록으로 돌아가기"  onclick="location.href='qna_board'"/>
		</div>
	</div>



	<!-- include footer -->
	<jsp:include page="../../pages/form/footer.jsp"></jsp:include>
<script src="${path}/resources/js/jquery.min.js"></script>
<script src="${path}/resources/js/jquery.backtotop.js"></script>
<script src="${path}/resources/js/jquery.mobilemenu.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
</body>
</html>