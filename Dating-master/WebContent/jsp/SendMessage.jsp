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
	<%@include file="Header.jsp" %>
    <div id="content">
    	<div id="content_left">
        <div class="content_left_section_01">
        	<div class="welcome_title"
            style="background: url('./images/welcome_title.jpg') no-repeat;"></div>
        	<p>
            <span class="show_info_colomn1"> Tên đăng nhập </span> <span
            	class="show_info_colomn2"> <strong>&nbsp${infoUser.getFull_name()}
            </strong>
            </span>
        	</p>
        	<p>
            <span class="show_info_colomn1"> Ngày sinh </span> <span
            	class="show_info_colomn2"> <strong>&nbsp${infoUser.getBirthday()}
            </strong>
            </span>
        	</p>
        	<p>
            <span class="show_info_colomn1"> Giới tính </span> <span
            	class="show_info_colomn2"> <strong>&nbsp${infoUser.getSex()}
            </strong>
            </span>
        	</p>
        	<p>
            <span class="show_info_colomn1"> Địa chỉ </span> <span
            	class="show_info_colomn2"> <strong>&nbsp${infoUser.getAddress()}
            </strong>
            </span>
        	</p>
        	<p>
            <span class="show_info_colomn1"> Email </span> <span
            	class="show_info_colomn2"> <strong>&nbsp${infoUser.getMail()}
            </strong>
            </span>
        	</p>
        	<p>
            <span class="show_info_colomn1"> Công việc </span> <span
            	class="show_info_colomn2"> <strong>&nbsp${infoUser.getJob()}
            </strong>
            </span>
        	</p>
        	<p>
            <span class="show_info_colomn1"> Tôn giáo </span> <span
            	class="show_info_colomn2"> <strong>&nbsp${ infoUser.getReligion()}
            </strong>
            </span>
        	</p>
        	<p>
            <span class="show_info_colomn1"> Châm ngôn tình yêu </span> <span
            	class="show_info_colomn2"> <strong>&nbsp${ infoUser.getStatus()}
            </strong>
            </span>
        	</p>
        	<p>
            <span class="show_info_colomn1"> Giới thiệu về bạn thân </span> <span
            	class="show_info_colomn2"> <strong>&nbsp${ infoUser.getIntroduction()}
            </strong>
            </span>
        	</p>
        	<p>
            <span class="show_info_colomn1"> Hiện tại </span> <span
            	class="show_info_colomn2"> <strong>&nbsp
            	<c:set  var = "on_off" value="${infoUser.getOn_off()}"/>
            	<c:choose>
            		<c:when test="${on_off eq 1}">
            		<i style="color: #2eb82e"> <%="Online"%></i>
            		</c:when>
            		<c:when test="${on_off != 1}">
            		<i style="color: red"> <%="Offline"%></i>
            		</c:when>
            	</c:choose>
            </strong>
            </span>
        	</p>
        	<p>
            <span class="show_info_colomn1"> </span> <span
            	class="show_info_colomn2">
            	<c:if test="${param.view_info_me eq 'true'}">
            	<a href="./jsp/Registration.jsp"><i class="fix_info">Chỉnh sửa thông tin cá nhân</i></a>
            	</c:if>
            	<c:if test="${relationship eq 'friend'}">
            	<a href="./jsp/Registration.jsp"><i class="fix_info">Nhắn tin</i></a> 
            	</c:if>
            	<c:if test="${relationship eq 'notyet'}">
            	<a href="./jsp/Registration.jsp"><i class="fix_info">Gửi lời mời kết bạn</i></a>
            	</c:if>
            </span>
        	</p>
        </div>
        <div class="cleaner_with_divider">&nbsp;</div>
       <%@include file="Suggestions.jsp"%>
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