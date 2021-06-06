<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 공지 등록</title>
<!-- JAVASCRIPTS -->
<script type="text/javascript" src="${path}/resources/ckeditor/ckeditor.js"></script>
<script src="${path}/resources/js/jquery.min.js"></script>
<script src="${path}/resources/js/jquery.backtotop.js"></script>
<script src="${path}/resources/js/jquery.mobilemenu.js"></script>

<link href="${path}/resources/css/layout.css" rel="stylesheet" type="text/css" media="all">


<!-- -------------------------------------------------------------------------------- -->

<style type="text/css">

.body{
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}

.btn{
	width: 150px;
	height: 40px;
	margin : 20px 0px 20px 0px;
	
	border: 2px solid #93C0C5;
	border-radius : 20px;
	text-decoration: none;
	text-align: center;
	
	color: #93C0C5;
	font-weight: bold;
}


		
</style>
</head>
<body>


<!-- header -->
<jsp:include page="../form/header.jsp"></jsp:include>

<!-- --------------------------------------------------------------------------- -->
<!-- --------------------------------------------------------------------------- -->
	
		<form class="body" action="prjNoticeInsert.do" method="post">
			<input type="hidden" name="p_id" value="${param.p_id }">
				<h1 style="font-family: 'Gugi', cursive; text-align:center;">프로젝트 공지 등록</h1>
				<input type="text" name="p_notice_title" placeholder="제목을 입력해주세요" required="required" style="width:600px; height:30px;">
				
				<textarea id="p_notice_content" name="p_notice_content" cols="83" rows="20"></textarea>
             	<script type="text/javascript">
					CKEDITOR.config.resize_enabled= false;
					var editor = CKEDITOR.replace('p_notice_content',
									{height:600, filebrowserUploadUrl: '${path}/uploadImg/pjNotice'}		
					);
					editor.on( 'required', function( evt ) {
					    alert( '내용을 작성해주세요.' );
					    evt.cancel();
					} );
				</script>
             	
				<div class="btn-div">
					<input type="submit" value="등록" id="btnSave" class="btn" >
					<input type="button" value="취소" id="btn_Cancle" class="btn" onclick="location.href=''">
				</div>
		</form>
	
<!-- --------------------------------------------------------------------------- -->
<!-- --------------------------------------------------------------------------- -->	
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>
</body>
</html>