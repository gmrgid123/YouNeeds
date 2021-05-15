<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/resources/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="${path}/resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function open_PopUp(){
		window.open("payDetail_popup?order_id="+${order_no},"결제 정보 상세 보기", "width=480px,height=510px");
	}
</script>
</head>
<body>
	<!-- include header -->
	<jsp:include page="../../pages/form/header.jsp"></jsp:include>
	<hr>
	
	
	<div style="text-align: center; margin-top: 100px; margin-bottom: 200px;">
		<h5>프로젝트 펀딩 결제를 성공했습니다.</h5>
		<br>
		<button class="btn btn-info" onclick="open_PopUp();">결제 상세 정보 보기</button>
	</div>
	
	<!-- include footer -->
	<jsp:include page="../../pages/form/footer.jsp"></jsp:include>
	
<script src="${path}/resources/js/jquery.min.js"></script>
<script src="${path}/resources/js/jquery.backtotop.js"></script>
<script src="${path}/resources/js/jquery.mobilemenu.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
</body>
</html>