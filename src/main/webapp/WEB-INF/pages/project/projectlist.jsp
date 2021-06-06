<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로젝트 목록</title>
<!-- JAVASCRIPTS -->

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
	font-size : 18px;
	
}

.btn {
	margin: 20px 20px 0px 20px;
	background-color: #93c0c59d;
	width: 100px;
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
.bgroup{
	margin-top: 30px;
	margin-bottom: 30px;
}
nav.pagination{
		text-align: center;
}
.justify-content-center {
  -ms-flex-pack: center !important;
  justify-content: center !important;
}

</style>


<!-- -------------------------------------------------------------------------------- -->
<script type="text/javascript">
function fn_search(pid) {
	///pjdetail.do
	location.href = "${pageContext.request.contextPath}/pjdetail.do?p_id=" + pid; 
}
</script>
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
		<input type="button" value="전체" class="btn" onclick="location.href='${path}/pjlist.do?p=1&p_category='">
		<input type="button" value="출판" class="btn" onclick="location.href='${path}/pjlist.do?p=1&p_category=출판'">
		<input type="button" value="공예" class="btn" onclick="location.href='${path}/pjlist.do?p=1&p_category=공예'">
		<input type="button" value="예술" class="btn" onclick="location.href='${path}/pjlist.do?p=1&p_category=예술'">
		<input type="button" value="공연" class="btn" onclick="location.href='${path}/pjlist.do?p=1&p_category=공연'">
		<input type="button" value="푸드" class="btn" onclick="location.href='${path}/pjlist.do?p=1&p_category=푸드'">
		<input type="button" value="패션" class="btn" onclick="location.href='${path}/pjlist.do?p=1&p_category=패션'">
	</div>
	<!-- ------------------------------------------------------------------------------ -->
	
	<c:choose>
		<c:when test="${empty plist}">
			<h3>등록된 프로젝트가 존재하지 않습니다.</h3>
		</c:when>
		<c:otherwise>
			<c:forEach var="listVo" items="${plist}" varStatus="status">
				<c:if test="${status.count % 3 eq 1}">
					<div class="cgroup">
				</c:if>
				
				<a class="project_card" href="javascript:fn_search('${listVo.p_id}')">
					<div class="card">
						<div class="card_header">
							<span><img src="${path}/uploadImg/projectTitle/${listVo.projectTilteImgDto.title_stored_name}"
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
		</c:otherwise>
	</c:choose>
	
	
	
			

			
		
	<!---------------------- 마지막 버튼--------------------- -->
	<div class="bgroup">
				<c:if test="${not empty plist}">
				<nav class="pagination justify-content-center">
			        <ul>
			      
			        	<c:if test="${start_num ne 1}">
			        		<c:choose>
								<c:when test="${not empty param.p_category }">
									<li><a href="pjlist.do?p=${start_num-1}&p_category=${param.p_category}">&laquo; Previous</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="pjlist.do?p=${start_num-1}">&laquo; Previous</a></li>
								</c:otherwise>
							</c:choose>
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
			        		 			<c:choose>
											<c:when test="${not empty param.p_category }">
												<li style="background: #eee;"><a href="pjlist.do?p=<c:out value="${status.current}"/>&p_category=${param.p_category}"><c:out value="${status.current}"/></a></li>
											</c:when>
											<c:otherwise>
												<li style="background: #eee;"><a href="pjlist.do?p=<c:out value="${status.current}"/>"><c:out value="${status.current}"/></a></li>
											</c:otherwise>
										</c:choose>
			        		 		</c:when>
			        		 		<c:otherwise>
			        		 			<c:choose>
											<c:when test="${not empty param.p_category }">
												<li><a href="pjlist.do?p=<c:out value="${status.current}"/>&p_category=${param.p_category}"><c:out value="${status.current}"/></a></li>
											</c:when>
											<c:otherwise>
												<li><a href="pjlist.do?p=<c:out value="${status.current}"/>"><c:out value="${status.current}"/></a></li>
											</c:otherwise>
										</c:choose>
			        		 		</c:otherwise>
			        		 	</c:choose>
			        		 </c:if>
			        		
			        	</c:forEach>
			        	
													        	
			        	<c:if test="${end_num ne max}">
			        		 <c:choose>
								<c:when test="${not empty param.p_category }">
									<li><a href="pjlist.do?p=${end_num+1}&p_category=${param.p_category}">Next &raquo;</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="pjlist.do?p=${end_num+1}">Next &raquo;</a></li>
								</c:otherwise>
							</c:choose>
				        </c:if>
			        </ul>
	      		</nav>
	      		</c:if>
	</div>

	<!-- --------------------------------------------------------------------------- -->
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>
</body>
</html>