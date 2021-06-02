<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YouNeeds-Notice</title>
<link href="${path}/resources/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="${path}/resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<style type="text/css">
	table.table thead th{
		text-align: center;
		vertical-align: top;
	}
	table.table tbody td{
		text-align: center;
	}
	div.board{
		padding-top: 50px;
		padding-bottom: 100px;
		padding-left: 20%;
		padding-right: 20%;
	}
	.board h2{
		text-align: center;
		padding-bottom: 20px;
	}
	nav.pagination{
		text-align: center;
	}
	td a{
	text-decoration: none !important;
	}
</style>
</head>
<body>
	<!-- include header -->
	<jsp:include page="../../pages/form/header.jsp"></jsp:include>
	
	<hr>
	
	<div class="">
		<div class="board list notice">
			<h2>공지사항</h2>
			<table class="table table-striped">
				<col width="80px"><col width="300px"><col width="80px">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성일자</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${empty list }">
							<td colspan="3">===작성된 글이 존재하지 않습니다.===</td>
						</c:when>
						<c:otherwise>
							<c:forEach var="dto" items="${list }">
								<tr>
									<td>${dto.notice_id}</td>
									<td><a href="noticeView?no=${dto.notice_id}" style="color:black;">${dto.notice_title }</a></td>
									<td><fmt:formatDate value="${dto.notice_regdate}" pattern="yyyy-MM-dd"/></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
				<c:if test="${sessionScope.login.m_type eq '관리' }">
					<button type="button" class="btn btn-secondary" onclick="location.href='notice_write'" style="float: right;">글쓰기</button>
				</c:if>
				
				<c:if test="${not empty list}">
				<nav class="pagination justify-content-center">
			        <ul>
			      
			        	<c:if test="${start_num ne 1}">
			        		<li><a href="notice_board?p=${start_num-1}">&laquo; Previous</a></li>
			        	</c:if>
			        	
			        	
			        	<c:set var="doneLoop" value="false"/>
			        	<c:forEach begin="${start_num}" end="${end_num}" step="1" varStatus="status">
			        		
			        		
			        		 <c:if test="${not doneLoop}">
			        		 	<c:if test="${max eq status.current}">
					        		 	<c:set var="doneLoop" value="true"/>
					        		 	<c:set var="end_num" value="${status.current}"/>
					        	</c:if>
			        		 	<c:choose>
			        		 		<c:when test="${page eq status.current}">
			        		 			<li style="background: #eee;"><a href="notice_board?p=<c:out value="${status.current}"/>"><c:out value="${status.current}"/></a></li>
			        		 		</c:when>
			        		 		<c:otherwise>
			        		 			<li><a href="notice_board?p=<c:out value="${status.current}"/>"><c:out value="${status.current}"/></a></li>
			        		 		</c:otherwise>
			        		 	</c:choose>
			        		 </c:if>
			        		
			        	</c:forEach>
			        	
			        	<c:if test="${end_num ne max}">
				          	<li><a href="notice_board?p=${end_num+1}">Next &raquo;</a></li>
				        </c:if>
			        </ul>
	      		</nav>
	      		</c:if>
	      
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