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
<script src="${path}/resources/js/jquery.min.js"></script>
<script src="${path}/resources/js/jquery.backtotop.js"></script>
<script src="${path}/resources/js/jquery.mobilemenu.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
<script type="text/javascript">
function delcheck(){
	if(confirm("삭제를 진행하시겠습니까?")){
		location.href="noticeDelete.do?no=${noticeDto.notice_id}";
	}else{
		
	}
}
</script>

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
}

.btn_div{
	text-align: center;
	margin: 30px;
}

#listGo{
	width: 200px;
	height: 50px;
}
.updateBtn{
	margin-top: 10px;
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
				<h1 style="text-align: center;">${noticeDto.notice_title}</h1>
				<div style="text-align: right;">
					<span class="regdate">작성일 : <fmt:formatDate value="${noticeDto.notice_regdate}" pattern="yyyy-MM-dd  HH:mm:ss"/></span>
				</div>
			</div>
		
			<br>
			<hr>
			<br>
			
			<div class="content" style="margin-right: 10%; margin-left: 10%;">
				<p>${noticeDto.notice_content}</p>
			</div>
		</div>
		
		<c:if test="${sessionScope.member.m_type eq '관리' }">
			<div style="float: right;">
				<input type="button" class="btn btn-secondary updateBtn" value="수정" onclick="location.href='noticeUpdateForm?no=${noticeDto.notice_id}';">
				<input type="button" class="btn btn-secondary updateBtn" value="삭제" onclick="delcheck();"/>
			</div>
		</c:if>
		
		<div class="btn_div">
			<input id="listGo" type="button" class="btn btn-secondary"  value="목록으로 돌아가기"  onclick="location.href='notice_board?p=1'"/>
		</div>
	
	</div>



	<!-- include footer -->
	<jsp:include page="../../pages/form/footer.jsp"></jsp:include>
</body>
</html>