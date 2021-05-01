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
	
	<form action="">
		<div>
		
			<div>
				<input type="text" name="qna_title" placeholder="제목을 입력해주세요." style="width: 100%; height: 40px;">
			</div>
			<br>
			<div>
				<textarea class="form-control" name="qna_content"  id="p_content"  required="required" style="resize: none;"></textarea>
				<script type="text/javascript">
					CKEDITOR.config.resize_enabled= false;
					
					CKEDITOR.replace('p_content',
									{height:600, filebrowserUploadUrl: '${pageContext.request.contextPath }/adm/fileupload.do'}		
					);
				</script>
			</div>	
			<br>
			<div style="text-align: center;">
				<input type="submit" value="작성" class="btn btn-secondary">
				<input type="button" value="취소" onclick="location.href='qna_board'" class="btn btn-secondary">
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