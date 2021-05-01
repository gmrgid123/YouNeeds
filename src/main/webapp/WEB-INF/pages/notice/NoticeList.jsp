<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>    

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
					<tr>
						<td>1</td>
						<td><a href="notice_view" style="color:black;">임시용 제목 1</a></td>
						<td>yyyy-MM-dd</td>
					</tr>
					<tr>
						<td>2</td>
						<td><a href="order_test">임시용 제목 2</a></td>
						<td>yyyy-MM-dd</td>
					</tr>
					<tr>
						<td>3</td>
						<td><a href="#">임시용 제목 3</a></td>
						<td>yyyy-MM-dd</td>
					</tr>
					<tr>
						<td>4</td>
						<td><a href="#">임시용 제목 4</a></td>
						<td>yyyy-MM-dd</td>
					</tr>
					<tr>
						<td>5</td>
						<td><a href="#">임시용 제목 5</a></td>
						<td>yyyy-MM-dd</td>
					</tr>
				</tbody>
			</table>
				<button type="button" class="btn btn-secondary" onclick="location.href='notice_write'" style="float: right;">글쓰기</button>
		
				<nav class="pagination justify-content-center">
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
	</div>




	<!-- include footer -->
	<jsp:include page="../../pages/form/footer.jsp"></jsp:include>


<script src="${path}/resources/js/jquery.min.js"></script>
<script src="${path}/resources/js/jquery.backtotop.js"></script>
<script src="${path}/resources/js/jquery.mobilemenu.js"></script>
<script src="${path}/resources/js/bootstrap.js"></script>
</body>
</html>