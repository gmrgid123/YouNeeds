<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML>
<html>
<head>
<title>Orizon</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="${path}/resources/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="${path}/resources/css/slider/slider-banner.css" rel="stylesheet" type="text/css">
<style type="text/css">
div .card {
   height: 300px;
   width: 330px;
   border-radius: 15px;
   display: inline-block;
   margin-top: 0px;
   margin-left: 0px;
   margin-bottom: 0px;
   position: relative;
   box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
      rgba(0, 0, 0, 0.19);
}

.card_img{
	border-radius: 15px 15px 0 0 ;
}

.card_header {
   width: 100%;
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
   margin-top: 15px;
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


.project_card{
	margin: 30px;
	
}
</style>
</head>
<body id="top">
	<!-- header include -->
<jsp:include page="../pages/form/header.jsp"></jsp:include>

<!-- Could use a jQuery background switcher script here to swap the background image for a different one -->
<div id="jssor_1" style="position:relative;margin:0 auto;top:0px;left:0px;width:980px;height:500px;overflow:hidden;visibility:hidden;">
        <!-- Loading Screen -->
        <div data-u="loading" class="jssorl-009-spin" style="position:absolute;top:0px;left:0px;width:100%;height:100%;text-align:center;background-color:rgba(0,0,0,0.7);">
            <img style="margin-top:-19px;position:relative;top:50%;width:38px;height:38px;" src="${path}/resources/images/slider/spin.svg" />
        </div>
        <div data-u="slides" style="cursor:default;position:relative;top:0px;left:0px;width:980px;height:500px;overflow:hidden;">
            <div>
                <a href="#"><img data-u="image" src="${path}/resources/images/slider/banner.jpg" /></a>
            </div>
            <div>
                <a href="#"><img data-u="image" src="${path}/resources/images/slider/banner2.jpg" /></a>
            </div>
            <div>
                <a href="#"><img data-u="image" src="${path}/resources/images/slider/banner3.jpg" /></a>
            </div>
        </div><a data-scale="0" href="https://www.jssor.com" style="display:none;position:absolute;">responsive slider</a>
        <!-- Bullet Navigator -->
        <div data-u="navigator" class="jssorb053" style="position:absolute;bottom:16px;right:16px;" data-autocenter="1" data-scale="0.5" data-scale-bottom="0.75">
            <div data-u="prototype" class="i" style="width:12px;height:12px;">
                <svg viewbox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                    <path class="b" d="M11400,13800H4600c-1320,0-2400-1080-2400-2400V4600c0-1320,1080-2400,2400-2400h6800 c1320,0,2400,1080,2400,2400v6800C13800,12720,12720,13800,11400,13800z"></path>
                </svg>
            </div>
        </div>
        <!-- Arrow Navigator -->
        <div data-u="arrowleft" class="jssora093" style="width:50px;height:50px;top:0px;left:30px;" data-autocenter="2" data-scale="0.75" data-scale-left="0.75">
            <svg viewbox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                <circle class="c" cx="8000" cy="8000" r="5920"></circle>
                <polyline class="a" points="7777.8,6080 5857.8,8000 7777.8,9920 "></polyline>
                <line class="a" x1="10142.2" y1="8000" x2="5857.8" y2="8000"></line>
            </svg>
        </div>
        <div data-u="arrowright" class="jssora093" style="width:50px;height:50px;top:0px;right:30px;" data-autocenter="2" data-scale="0.75" data-scale-right="0.75">
            <svg viewbox="0 0 16000 16000" style="position:absolute;top:0;left:0;width:100%;height:100%;">
                <circle class="c" cx="8000" cy="8000" r="5920"></circle>
                <polyline class="a" points="8222.2,6080 10142.2,8000 8222.2,9920 "></polyline>
                <line class="a" x1="5857.8" y1="8000" x2="10142.2" y2="8000"></line>
            </svg>
        </div>
    </div>
    <!-- #endregion Jssor Slider End -->



<div class="wrapper row3"  style="padding-top: 100px; padding-bottom: 100px; text-align: center;">
	
  <main class="container clear" style="max-width: 1200px;">
  	<div>
  		<h2 style="text-align: left; padding-left: 30px;     font-family: Noto Sans KR,Nanum Gothic;">최신 프로젝트</h2>
  	</div>
  	<div class="project_recent">
		
		<c:choose>
			<c:when test="${empty recentList}">
				<p>최신 프로젝트가 아무것도 없습니다.</p>
			</c:when>
			<c:otherwise>
				<c:forEach var="dto" items="${recentList}">
					
					<a class="project_card" href="pjdetail.do?p_id=${dto.p_id }">
		               <div class="card">
		                  <div class="card_header">
		                  	<span><img class="card_img" src="${path}/uploadImg/projectTitle/${dto.projectTilteImgDto.title_stored_name}" style="width: 100%; height: 100%;"></span>
		                  </div>
		
		                  <div class="card_body">
		                     <hr>
		                     <i class="name" style="font-size: 12pt;">${dto.p_title}</i>
		                     <br>
		                     <i class="payment"> 목표금액 : <fmt:formatNumber value="${dto.target_amount}" pattern="#,###"/>원 </i>
		                  </div>
		               </div>
					</a>
					
				</c:forEach>
			</c:otherwise>
		</c:choose>

		
		
	</div>
  </main>
</div>






	<!-- footer include -->
	<jsp:include page="../pages/form/footer.jsp"></jsp:include>

<!-- JAVASCRIPTS -->
<script src="${path}/resources/js/slider/slider.js" type="text/javascript"></script>
<script src="${path}/resources/js/slider/jssor.slider-28.1.0.min.js" type="text/javascript"></script>
<script src="${path}/resources/js/jquery.min.js"></script>
<script src="${path}/resources/js/jquery.backtotop.js"></script>
<script src="${path}/resources/js/jquery.mobilemenu.js"></script>
</body>
</html>