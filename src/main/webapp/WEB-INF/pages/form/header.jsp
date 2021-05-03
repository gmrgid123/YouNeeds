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
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row0">
  <header id="header" class="clear"> 
    <!-- ################################################################################################ -->
    <div id="logo" class="fl_left">
      <h1 id="main_icon"><a href="main.do">YouNeeds</a></h1>
    </div>
    <div class="fl_right">
      <ul class="nospace inline">
        <li><a href="login.do">로그인 / 회원가입</a></li>
        <li><a href="userMypage">유저 마이페이지 테스트</a></li>
        <li><a href="creatorMypage">창작 마이페이지 테스트</a></li>
        <li><a href="videoChatPage">화생채팅 페이지 테스트</a></li>
        <li><a href="pwdCheckTest">비밀번호 체크 페이지 테스트</a></li>
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
        
        <!-- 펼치기 스타일 메뉴 -->
        <!--
        <li><a class="drop" href="#">Pages</a>
          <ul>
            <li><a href="${path}/pages/gallery.jsp">Gallery</a></li>
            <li><a href="${path}/pages/full-width.jsp">Full Width</a></li>
            <li><a href="${path}/pages/sidebar-left.jsp">Sidebar Left</a></li>
            <li><a href="${path}/pages/sidebar-right.jsp">Sidebar Right</a></li>
            <li><a href="${path}/pages/basic-grid.jsp">Basic Grid</a></li>
          </ul>
        </li>
        
        <li><a class="drop" href="#">Dropdown</a>
          <ul>
            <li><a href="#">Level 2</a></li>
            <li><a class="drop" href="#">Level 2 + Drop</a>
              <ul>
                <li><a href="#">Level 3</a></li>
                <li><a href="#">Level 3</a></li>
              </ul>
            </li>
          </ul>
        </li>
          -->
         <!-- 펼치기 스타일 메뉴 -->
        
        
        <li><a href="pjlist.do">프로젝트 목록</a></li>
        <li><a href="pjupload.do">프로젝트 등록</a></li>
        <li><a href="notice_board">공지사항</a></li>
        <li><a href="qna_board">QnA</a></li>
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
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
</body>
</html>