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
        <div class="content_left_section_02_mess">
        <p style="font-size: 14px;color: #800000">Cuộc trò chuyện</p>
        <c:forEach items="${message}" var = "info">
        
        <a href="${pageContext.request.contextPath}/SendMessage?w=${info.getId_user()}&&n=${info.getFull_name()}" style=" text-decoration: none;">
        <div class="latest_profile_box_list"> <img src="${pageContext.request.contextPath}/images/avatar_man.jpg" alt=""></div>
          <div class="name_mess">${info.getFull_name()}</div>
          <c:forEach items="${info.message}" var = "message">
          <div style="background-color: #ccccb3; width: 80%; margin-left: 65px">
            <c:if test="${message.getStatus() eq 1}">
              <div class="content_mess" >${message.getContent()}</div>
              <div class="day_sent"><i>${message.getDate()}</i></div>
            </c:if>
          </div>
          <div style="width: 80%; margin-left: 65px">
            <c:if test="${message.getStatus() eq 0}">
              <div class="content_mess" >${message.getContent()}</div>
              <div class="day_sent"><i>${message.getDate()}</i></div>
            </c:if>
          </div>
          </c:forEach>
         </a>
         
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