<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Gugi&display=swap" rel="stylesheet">
<style type="text/css">
.wrapper {
	font-family: 'Gugi', cursive;
}
#main_icon{
    margin-bottom: 0.5rem;
    font-weight: 500;
    line-height: 1.2;
}
</style>
</head>
<body>
<!-- ################################################################################################ -->
<div class="wrapper row0">
  <header id="header" class="clear"> 
    <!-- ################################################################################################ -->
    <div id="logo" class="fl_left">
      <h1 id="main_icon"><a href="main.do">YouNeeds</a></h1>
    </div>
    <div class="fl_right">
      <ul class="nospace inline">
      <c:if test="${sessionScope.member ==null }">
        	<li><a href="loginForm.do">로그인 / 회원가입</a></li>
       </c:if>

       <c:if test="${sessionScope.member !=null }">
       		<li>${sessionScope.member.m_nickname } 님</li>
       		<li><a href="logout">로그아웃</a></li>
       		<li><a href="userMypage">마이페이지 테스트</a></li>
      	</c:if>
      	</ul>
       		     
    </div>
    <!-- ################################################################################################ -->
  </header>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row1">
  <div id="topbar" class="clear"> 
    <!-- ################################################################################################ -->
    <nav id="mainav" class="fl_left">
      <ul class="clear">
        <li class="active"><a href="main.do">Home</a></li>
      
        
        
        <li><a href="pjlist.do?p=1">프로젝트 목록</a></li>
        <li><a href="pjupload.do">프로젝트 등록</a></li>
        <li><a href="notice_board?p=1">공지사항</a></li>
        <li><a href="qna_board?p=1">QnA</a></li>
      </ul>
    </nav>
    <div id="search" class="fl_right">
      <form class="clear" method="post" action="#">
        <fieldset>
          <legend style="display: none;">Search:</legend>
          <input type="text" value="" placeholder="Search Here">
          <button class="fa fa-search" type="submit" title="Search"><em>Search</em></button>
        </fieldset>
      </form>
    </div>
    <!-- ################################################################################################ -->
  </div>
</div>
<!-- ################################################################################################ -->
</body>
</html>