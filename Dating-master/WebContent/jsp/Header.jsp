<%@page import="Dating.User.Member.ViewInfoUser"%>
<%@page import="Dating.User.Member.Conversation"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<%@ page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/JS/css/style_page.css"
  rel="stylesheet" />
<title>Chào mừng bạn đã tới với Website Dating.com</title>
</head>
<body>
<input type="hidden" name="user_id_login" value="${user_id_login}">
<c:set var = "user_id_login" value = "${user_id_login}"/>
    <%
    int messNotYet = Conversation.MessageNotYet((String)pageContext.getAttribute("user_id_login"));
    int sttRs = ViewInfoUser.sttRs((String)pageContext.getAttribute("user_id_login"));
    %>
    <div id="header"
      style="background: url('${pageContext.request.contextPath}/images/divider.jpg')">
      <div id="login_box">
      <a href="${pageContext.request.contextPath}/LogOut">Log Out</a>
        <a href="#" onclick="javascript:history.go(-1)">Back</a>
      </div>
    </div>
    <div id="menu"
      style="background: url('${pageContext.request.contextPath}/images/menu_bg.jpg')">
      <ul>
        <li><a href="${pageContext.request.contextPath}/jsp/Home.jsp" class="current">Trang Chủ</a></li>
        <li><a href="${pageContext.request.contextPath}/ViewInfoUser?view_info_me=true">${user_name_login}<i style="color: red">(<%=sttRs%>)</i></a></li>
        <li><a href="${pageContext.request.contextPath}/ListMessage">Cuộc trò chuyện <i style="color: red">(<%=messNotYet%>)
          </i></a></li>
        <li><a href="#">Tin tức</a></li>
        <li><a href="${pageContext.request.contextPath}/ListFriends">Bạn bè</a></li>
        <li><a href="${pageContext.request.contextPath}/Admin?del=">
        <c:if test="${user_type_login eq 'admin'}">Đăng tin</c:if>
        </a></li>
        <li><a href="${pageContext.request.contextPath}/Admin?del=">
        <c:if test="${user_type_login eq 'admin'}">Quản lý User</c:if>
        </a></li>
      </ul>
    </div>
</body>
</html>