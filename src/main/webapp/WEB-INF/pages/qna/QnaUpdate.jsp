<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YouNeeds-Qna</title>
<script type="text/javascript" src="${path}/resources/ckeditor/ckeditor.js"></script>
<link href="${path}/resources/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="${path}/resources/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- include header -->
	<jsp:include page="../../pages/form/header.jsp"></jsp:include>

	<hr>
	<div style="margin-top: 50px; margin-bottom: 50px; padding-right: 20%; padding-left: 20%;">
	
	<div>
		<h2>QnA</h2>
	</div>
	

	<form action="qnaUpdate.do" method="post" onsubmit="return editorSubmit();">
		<div>
			<input type="hidden" name="qna_id" value="${dto.qna_id}">
			<div>
				<input type="text" name="qna_title" value="${dto.qna_title}" placeholder="제목을 입력해주세요." required="required" style="width: 100%; height: 40px;">
			</div>
			<br>
			<div>
				<textarea class="form-control" name="qna_content"  id="qna_content"  required="required" style="resize: none;">${dto.qna_content }</textarea>
				<script type="text/javascript">
				CKEDITOR.config.resize_enabled= false;
				var editor = CKEDITOR.replace('qna_content',
								{height:600, filebrowserUploadUrl: '${path}/uploadImg/qna'}		
				);
				editor.on( 'required', function( evt ) {
				    alert( '내용을 작성해주세요.' );
				    evt.cancel();
				} );
				</script>
			</div>	
			<br>
			<div style="text-align: center;">
				<input type="submit" value="작성" class="btn btn-secondary">
				<input type="button" value="취소" onclick="location.href='qnaView?no=${dto.qna_id}';" class="btn btn-secondary">
			</div>
			
		</div>
	</form>
	
	
	</div>



	<!-- include footer -->
	<jsp:include page="../../pages/form/footer.jsp"></jsp:include>
<script src="${path}/resources/js/jquery.min.js"></script>
<script src="${path}/resources/js/jquery.backtotop.js"></script>
<script src="${path}/resources/js/jquery.mobilemenu.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
</body>
</html>