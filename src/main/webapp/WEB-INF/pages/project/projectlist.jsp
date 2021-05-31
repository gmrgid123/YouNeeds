<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />


<!-- JAVASCRIPTS -->
<script src="${path}/resources/js/slider/slider.js"
	type="text/javascript"></script>
<script src="${path}/resources/js/slider/jssor.slider-28.1.0.min.js"
	type="text/javascript"></script>
<script src="${path}/resources/js/jquery.min.js"></script>
<script src="${path}/resources/js/jquery.backtotop.js"></script>
<script src="${path}/resources/js/jquery.mobilemenu.js"></script>


<link href="${path}/resources/css/layout.css" rel="stylesheet"
	type="text/css" media="all">

<style type="text/css">

.card {
	height: 220px;
	width: 220px;
	border-radius: 15px;
	display: inline-block;
	margin-left: 50px;
	margin-bottom: 0px;
	position: relative;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}

.title {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	background-color: #93C0C5;
	color: white;
	
}

.topbar {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
	background-color: white;
	color: black;
}

.btn {
	display: inline-block;
	margin: 20px 20px 0px 20px;
	background-color: #93c0c59d;
	width: 50px;
	height: 50px;
	border-radius: 5px 5px 5px 5px;
	border: none;
	cursor: pointer;
}

<!------------------------------------------------------------->


.card_header {
	width: 20%;
	height: 200px;
	border-radius: 15px 15px 0 0;
	background-image: url("");
	background-size: 100% 250px;
}

.card_header_D-day {
	background-color: #EF5A31;
	color: #FFF;
	font-weight: bold;
	text-align: center;
	float: right;
	margin: 10px 10px 0 0;
	border-radius: 50%;
	font-weight: bold;
	padding: 10px 10px;
	line-height: 20px;
}

.card_body {
	position: absolute;
	margin-top: 10px;
	margin-bottom: 6px;
	bottom: 0;
	width: 100%;
	height: 100px;
	font-size: 14px;
	color: #9FA5A8;
	padding: 0 15px;
}

.payment {
	float: right;
}

#c2 {
	margin-top: 55px;
}

#c3 {
	margin-top: 55px;
}


.btn2 {
	display: inline-block;
	margin: 60px 20px 20px 20px;
	background-color: #FFFFFF;
	width: 70px;
	height: 50px;
	border-radius: 5px 5px 5px 5px;
	border: 1px solid gray;
	text-align: center;
}

.cgroup {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
	
	margin-top: 30px;
	margin-right: 42px;
}
.bgroup {
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
	
}
</style>


<!-- -------------------------------------------------------------------------------- -->
<script type="text/javascript">
$(document).ready(function() {
	// fn_search();
	var count = '${count}';
});

function fn_search(pid) {
	///pjdetail.do
	location.href = "${pageContext.request.contextPath}/pjdetail.do?p_id=" + pid; 
}

</script>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 목록</title>
</head>
<body>


	<!-- header -->
	<jsp:include page="../form/header.jsp"></jsp:include>
	
	<!-- --------------------------------------------------------------------------- -->
	<div class="title">
		<h1>프로젝트 목록</h1>
	</div>

	<!-- --------------------------------------------------------------------------- -->
	<div class="topbar">
		<input type="button" value="전체" class="btn" onclick="location.href='${path}/pjlist.do?p_category='">
		<input type="button" value="출판" class="btn" onclick="location.href='${path}/pjlist.do?p_category=출판'">
		<input type="button" value="공예" class="btn" onclick="location.href='${path}/pjlist.do?p_category=공예'">
		<input type="button" value="예술" class="btn" onclick="location.href='${path}/pjlist.do?p_category=예술'">
		<input type="button" value="공연" class="btn" onclick="location.href='${path}/pjlist.do?p_category=공연'">
		<input type="button" value="푸드" class="btn" onclick="location.href='${path}/pjlist.do?p_category=푸드'">
		<input type="button" value="패션" class="btn" onclick="location.href='${path}/pjlist.do?p_category=패션'">
	</div>
	<!-- ------------------------------------------------------------------------------ -->
	
	<c:forEach var="listVo" items="${list}" varStatus="status">
		<c:if test="${status.count % 3 eq 1}">
			<div class="cgroup">
		</c:if>
		<a class="project_card" href="javascript:fn_search('${listVo.p_id}')">
			<div class="card">
				<div class="card_header">
					<span><img src="${path}/resources/images/4.jpg"
						style="width: 100%; height: 120px;"></span>
				</div>
				<div class="card_body">
					<hr>
					<i class="name" style="font-size: 12pt;"><br>${listVo.p_title}</i> <br>
					<i class="payment"> 목표금액 : ${listVo.target_amount}원 </i>
				</div>
			</div>
		</a>
		<c:if test="${status.count % 3 eq 0}">
			</div>
		</c:if>
		<c:if test="${status.last}">
			</div>
		</c:if>
	</c:forEach>
	<c:if test="${count < 3 }">
		</div>
	</c:if>
		
	<!---------------------- 마지막 버튼--------------------- -->
	<div class="bgroup">
		<input type="button" value="←" class="btn2" onclick="location.href=''">
		<input type="button" value="1" class="btn2" onclick="location.href=''">
		<input type="button" value="2" class="btn2" onclick="location.href=''">
		<input type="button" value="3" class="btn2" onclick="location.href=''">
		<input type="button" value="→" class="btn2" onclick="location.href=''">
	</div>


	<!-- --------------------------------------------------------------------------- -->

	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>
</body>
</html>