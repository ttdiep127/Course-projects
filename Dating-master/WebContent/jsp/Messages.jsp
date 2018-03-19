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
        <c:out value="${info_mess.getFull_name()}"/>
        <div class="latest_profile_box_list"> <img src="${pageContext.request.contextPath}/images/avatar_man.jpg" alt=""></div>
          <c:set value="${user_id_login}" var = "id_login"/>
          <form action="${pageContext.request.contextPath}/SendMessage?w=${info_mess.getId_user()}&&n=${info_mess.getFull_name()}&&ac=send" method="post">
          <c:forEach items="${info_mess.message}" var = "message">
            <c:choose>
            <c:when test="${message.getId_user_send() eq id_login }">
                <div class="content_mess_left">${message.getContent()}</div>
                <div class="day_sent_left"><i>${message.getDate()}</i></div>
            </c:when>
            <c:otherwise>
                <div class="content_mess_right">${message.getContent()}</div>
                <div class="day_sent_right"><i>${message.getDate()}</i></div>
            </c:otherwise>
            </c:choose>
          </c:forEach>
          <textarea rows="3" cols="64" name="send"></textarea>
          <button type="submit" style="float: right; padding-right: 10px;">Gửi tin</button>
          </form>
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