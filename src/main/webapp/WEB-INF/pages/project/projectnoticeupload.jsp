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
	
		<form class="body" action="" >
				<h1 style="font-family: 'Gugi', cursive; text-align:center;">프로젝트 / 화상설명회 공지 등록</h1>
				<input type="text" placeholder="제목을 입력해주세요" required="required" style="width:600px; height:30px;">
				<table>
                    <tbody id="tbody">
                        <tr>
                            <td><textarea id="board_content" name="board_content" cols="83" rows="20"></textarea></td>
                        </tr>
                    </tbody>
                </table>
				<div class="btn-div">
					<input type="submit" value="등록" id="btnSave" class="btn" >
					<input type="button" value="취소" id="btn_Cancle" class="btn" onclick="location.href='pjintro.do'">
				</div>
		</form>
	
<!-- --------------------------------------------------------------------------- -->
<!-- --------------------------------------------------------------------------- -->	
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>
</body>
</html>