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
<link href="${path}/resources/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
	<table class="table table-bordered">
		<tr>
			<td>결제한 프로젝트</td>
			<td>[${dto.p_id}] : ${dto.projectDto.getP_title() }</td>
		</tr>
		<tr>
			<td>결제번호</td>
			<td>${dto.order_id }</td>
		</tr>
		<tr>
			<td>결제자명</td>
			<td>${dto.order_name }</td>
		</tr>
		<tr>
			<td>결제금액</td>
			<td><fmt:formatNumber value="${dto.order_pay }" pattern="#,###"/> 원</td>
		</tr>
		<tr>
			<td>결제날짜</td>
			<td><fmt:formatDate value="${dto.order_date }" pattern="yyyy-MM-dd  HH:mm:ss"/></td>
		</tr>
		<tr>
			<td>결제자 연락처</td>
			<td>${dto.order_phone }</td>
		</tr>
		<tr>
			<td>결제자 이메일</td>
			<td>${dto.order_email }</td>
		</tr>
		<tr>
			<td>결제자 주소</td>
			<td>${dto.order_addr }</td>
		</tr>
	</table>
</body>
</html>