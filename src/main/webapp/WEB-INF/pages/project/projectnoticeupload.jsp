<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>



<!-- JAVASCRIPTS -->
<script type="text/javascript" src="${path}/resources/ckeditor/ckeditor.js"></script>
<script src="${path}/resources/js/jquery.min.js"></script>
<script src="${path}/resources/js/jquery.backtotop.js"></script>
<script src="${path}/resources/js/jquery.mobilemenu.js"></script>

<link href="${path}/resources/css/layout.css" rel="stylesheet" type="text/css" media="all">

<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gugi&display=swap" rel="stylesheet">


<!-- -------------------------------------------------------------------------------- -->

<style type="text/css">

* {
	font-family: 'Gugi', cursive;
 }
.body{
	margin-left : 35%;
	margin-bottom : 5%;
}

 
#btn {
	display:inline-block;
	width: 100px;
	height: 40px;
	background-color : #93C0C5;
	border : none;
	border-radius : 5px 5px 5px 5px;
	font-weight : bold;
	color : white;
	margin : 0 auto;
	margin-left : 8%;
	
}
.btn-div{
	margin-top:20px;
	margin-left: 5%;
}


		
</style>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 공지 등록</title>
</head>
<body>


<!-- header -->
<jsp:include page="../form/header.jsp"></jsp:include>

<!-- --------------------------------------------------------------------------- -->
<!-- --------------------------------------------------------------------------- -->
	
		<form action="">
				<h1 style="font-family: 'Gugi', cursive; text-align:center;">프로젝트 공지 등록</h1>
			<div class="body">
				<label>제목<input type="text" placeholder="내용을 입력해주세요" required="required"
							style="width:600px; height:30px;"></label>
				<textarea id="edit_content" name="" required="required"></textarea>
				<script type="text/javascript">
					CKEDITOR.config.resize_enabled= false;
					CKEDITOR.replace('edit_content',
									{width:'600px',height:'300px', filebrowserUploadUrl: '${pageContext.request.contextPath }/adm/fileupload.do'}		
					);
				</script>
				<div class="btn-div">
					<input type="submit" value="등록" id="btn">
					<input type="button" value="취소" id="btn">
				</div>
			</div>
		</form>
	
<!-- --------------------------------------------------------------------------- -->
<!-- -------------------------------------------------------------------------------- -->	
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>
	



</body>
</html>