<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@ page import="Dating.User.Bean.InfoUser"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/JS/css/style_page.css"
  rel="stylesheet" />
<title>Chào mừng bạn đã tới với Website Dating.com</title>
</head>
<body>
  <div id="container">
    <%@include file="Header.jsp"%>
    <div id="content">
      <div id="content_left">
        <div class="content_left_section_01">
          <div class="welcome_title"
            style="background: url('${pageContext.request.contextPath}/images/welcome_title.jpg') no-repeat;"></div>
          <p>
            <strong>${result_search}</strong>
          </p>
        <div class="content_left_section_02">
        <div class="latest_profile_title">Danh sách tìm được .</div>
        <c:forEach items="${listSearch}" var = "search">
        <div class="latest_profile_box_list"> <img src="${pageContext.request.contextPath}/images/avatar_man.jpg" alt=""></div>
          <div class="name">${search.getFull_name()}</div>
          <c:set  var = "on_off" value="${search.getOn_off()}"/>
            	<c:choose>
            		<c:when test="${on_off eq 1}">
            		<i style="color: #2eb82e"> <%="Online"%></i>
            		</c:when>
            		<c:when test="${on_off != 1}">
            		<i style="color: red"> <%="Offline"%></i>
            		</c:when>
            	</c:choose>
          <div class="readmore"><a href="${pageContext.request.contextPath}/ViewInfoUser?search_user_name=${search.getFull_name()}&&view_info_me=false">Details &raquo;</a></div>
        </c:forEach>
        </div>
        <div class="cleaner_with_width">&nbsp;</div>
        <span></span> 
         
      </div>
        <div class="cleaner">&nbsp;</div>
        <span></span>
      </div>
      <div id="content_right">
        <%@include file="Search.jsp"%>
        <div class="cleaner">&nbsp;</div>
        <span></span>
        <%@include file="News.jsp"%>
      </div>
    </div>
    <div class="cleaner_with_height">&nbsp;</div>
    <div id="footer"></div>
  </div>
</body>
</html>