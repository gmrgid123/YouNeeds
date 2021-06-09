<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="per" value="${ sumOrder / inform.target_amount * 100}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>YouNeeds</title>
<link href="${path}/resources/css/layout.css" rel="stylesheet"
	type="text/css" media="all">
<style type="text/css">
.title {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	background-color: #93C0C5;
	color: white;
}
.top {
	width: 1000px;
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
	margin: auto auto 0px auto;
	background-color: #93c0c541;
}
.tl {
	width: 450px;
	height: 300px;
	margin-right: 50px;
	text-align: center;
	background-color: #93c0c521;
}
.tr>h1 {
	color: #93C0C5;
}

.b1 {
	width: 120px;
	height: 40px;
	margin: 20px 0px 0px 250px;
	border: 2px solid #93C0C5;
	border-radius: 20px;
	text-decoration: none;
	text-align: center;
	color: #93C0C5;
	font-weight: bold;
}
.b1:hover {
	background-color: #93C0C5;
	color: white;
}
.middle {
	width: 1000px;
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
	margin: 5px auto 0px auto;
	background-color: #93c0c521;
	color: white;
}
.btn {
	width: 450px;
	font-size: 15px;
}

.btn>a {
	margin-left: 20px;
	color: #3533335d;
}
a:hover {
	color: black;
}

.bottom {
	width: 1000px;
	margin: 5px auto 20px auto;
	background-color: #93c0c541;
	display: flex;
	flex-direction: row;
	align-items: center;
	justify-content: center;
}
.bl {
	width: 550px;
	min-height: 300px;
	height: 100%;
	margin-right: 50px;
	text-align: center;
	background-color: #93c0c521;
}
.br {
	width: 350px;
	height: 200px;;
	background-color: #ffffff6c;
}
.b2 {
	display: inline-block;
	width: 150px;
	height: 40px;
	margin-top: 20px;
	border: 2px solid #93C0C5;
	border-radius: 20px;
	text-decoration: none;
	text-align: center;
	color: #93C0C5;
	font-weight: bold;
}
.b2:hover {
	background-color: #93C0C5;
	color: white;
}
.table th,
.table td {
  padding: 0.75rem;
  vertical-align: top;
  border-top: 1px solid #dee2e6;
}

.table thead th {
  vertical-align: bottom;
  border-bottom: 2px solid #dee2e6;
}

.table tbody + tbody {
  border-top: 2px solid #dee2e6;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
<script type="text/javascript">
function open_chat(){
	window.open("https://${chat_addr}:3000","화상 채팅", "width=480px,height=510px");
}
</script>
</head>
<body>
	<!-- header -->
	<jsp:include page="../form/header.jsp"></jsp:include>
	<!-- -------------------------------------------------------------------------------- -->
	<div class="title">
		<h1>${inform.p_title}</h1>
	</div>
	<!-- ------------------------------------top----------------------------------------- -->
	<div class="top">
		<div class="tl">
			<img alt="" src="${path}/uploadImg/projectTitle/${inform.projectTilteImgDto.title_stored_name}" style="width: 100%; height: 100%;">
		</div>
		<!-- ---------------------------------------------------------------------------- -->
		<div>
			<div class="tr">
				<h1>프로젝트 기간</h1>
				<h3>${inform.start_date} - ${inform.end_date}</h3>
				<h1>모인금액/목표금액</h1>
				<h3><fmt:formatNumber value="${sumOrder}" pattern="#,###"/> 원&nbsp;/&nbsp;<fmt:formatNumber value="${inform.target_amount}" pattern="#,###"/> 원&nbsp;&nbsp;&nbsp;( ${per}% 달성 )</h3> 
				<h1>후원자 수</h1>
				<h3><fmt:formatNumber value="${orderCount}" pattern="#,###"/> 명</h3>
			</div>
			<input type="button" class="b1" value="후원하기" onclick="location.href='orderPayForm?p_id=${inform.p_id}'">
		</div>
	</div>
	<!-- -------------------------------------------------------------------------------- -->
	<!-- -------------------------------middle-------------------------------------------- -->
	<div class=middle>
		<div class="btn">
			<a href="pjdetail.do?p_id=${inform.p_id}">프로젝트 소개</a> 
			<a href="pjNoticeList?p_id=${inform.p_id}&page=1" style="color:black;">프로젝트 공지</a> 
			<a href="pjFundGuide?p_id=${inform.p_id}">펀딩안내</a>
		</div>
	</div>
	<!-- -------------------------------------------------------------------------------- -->
	<!-- ---------------------------------bottom----------------------------------------- -->
	<!-- 공지사항 -->
	<div class="bottom" id="div_notice">
		<div class="bl">
			<table class="table" style="margin-top:20px;">
            <col width="80px"><col width="300px"><col width="100px">
            <thead>
               <tr>
                  <th>글번호</th>
                  <th>제목</th>
                  <th>작성일자</th>
               </tr>
            </thead>
            <tbody id="tbody_notice">
            	<c:choose>
            		<c:when test="${empty nList}">
            			<tr>
            				<td colspan="3">===작성된 글이 존재하지 않습니다.===</td>
            			</tr>
            		</c:when>
            		<c:otherwise>
            			<c:forEach var="pjn" items="${nList}">
            				<tr>
            					<td>${pjn.p_notice_no}</td>
            					<td><a href="pjNoticeView?p_id=${pjn.p_id}&no=${pjn.p_notice_no}" style="color:black;">${pjn.p_notice_title}</a></td>
            					<td><fmt:formatDate value="${pjn.p_notice_regdate}" pattern="yyyy-MM-dd"/></td>
            				</tr>
            			</c:forEach>
            		</c:otherwise>
            	</c:choose>
            </tbody>
         </table>
         
         <br><br><br>
         
         <c:if test="${not empty nList}">
				<nav class="pagination justify-content-center">
			        <ul>
			      
			        	<c:if test="${start_num ne 1}">
			        		<li><a href="pjNoticeList?p_id=${inform.p_id}&page=${start_num-1}"  style="color:black;">&laquo; Previous</a></li>
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
			        		 			<li style="background: #eee;"><a href="pjNoticeList?p_id=${inform.p_id}&page=<c:out value="${status.current}"/>"  style="color:black;"><c:out value="${status.current}"/></a></li>
			        		 		</c:when>
			        		 		<c:otherwise>
			        		 			<li><a href="pjNoticeList?p_id=${inform.p_id}&page=<c:out value="${status.current}"/>"  style="color:black;"><c:out value="${status.current}"/></a></li>
			        		 		</c:otherwise>
			        		 	</c:choose>
			        		 </c:if>
			        		
			        	</c:forEach>
			        	
			        	<c:if test="${end_num ne max}">
				          	<li><a href="pjNoticeList?p_id=${inform.p_id}&page=${end_num+1}"  style="color:black;">Next &raquo;</a></li>
				        </c:if>
			        </ul>
	      		</nav>
	      		</c:if>
         
		</div>
		<div style="text-align: center;">
            <div class="br">
            	<h3>&lt; 창작자 &gt;</h3>
				<p>${inform.creatorDto.create_name }</p>
				<h3>&lt; Intro &gt;</h3>
				<p>${inform.creatorDto.create_intro }</p>
            </div>  
            <input type="button" class="b2" value="공지사항 등록" onclick="location.href='pjNoticeUploadForm?p_id=${inform.p_id}'">
             <input type="button" class="b2" value="화상설명회" onclick="location.href='javascript:open_chat()'">
        </div>
    </div>
    
 
	<!-- ----------------------------------------------------------- -->
	<!-- footer include -->
	<jsp:include page="../form/footer.jsp"></jsp:include>
</body>
</html>