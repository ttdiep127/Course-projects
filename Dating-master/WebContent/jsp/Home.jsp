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
            <strong>Website Hẹn hò</strong>
          </p>
          <p>Đồ án Phân Tích Thiết Kế Hệ Thông Tin - Nhóm SE7 thực hiện.
          </p>
          <div style="padding-left: 100px;">
          <p><strong>Trần Thị Điệp </strong>      -   102140203.
          </p>
          <p><strong>Võ Thị Hiền Diệu </strong>   -   102140204.
          </p>
          <p><strong>Trương Minh Đức  </strong>   –   102140205.
          </p>
          <p><strong>Trương Hồng Hạnh </strong>   -   102140206.
          </p>
          <p><strong>Nguyễn Thanh Hải </strong>   -   102130065.
          </p>
          </div>
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