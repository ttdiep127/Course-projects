<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/JS/css/style_page.css"
  rel="stylesheet" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/JS/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/JS/css/bootstrap.min.css">
<title>Chào mừng bạn đã tới với Website Dating.com</title>
</head>
<body>
  <div id="container">
   <%@include file="Header.jsp"%>
   <div class="container">
   <div class="row">
		  <div class="col-lg-6 offset-lg-3" style="margin-left: 47.5%;">
		    
			<div class="input-group" style="width:65%; float: right; padding-right: 40px;" >
                     
                <input type="text" class="form-control" name="search" placeholder="Search Id, Name" />
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button" style="background-color: #2875d4; color: white;">Search</button>
                </span>
                
				
            </div>
           
			</div>
		</div>
		<br/>
		<div id="table-sendrequest">

		  <table class="table table-condensed table-freeze-multi table-bordered table-hover" id="tabla" 
		    data-scroll-height="305" data-cols-number="3">
		    <colgroup class="widthColMonth">
		      <col width="80px;">
		      <col width="180px;">
			  <col width="30px;">
			  <col width="30px;">
		      <col width="45px;">
			  <col width="60px;">
			  <col width="120px;">
		    </colgroup>
		    <thead>
		      
		      <tr>
		        <th rowspan="2">User Id</th>
				<th rowspan="2" colspan="2">Name</th>
		        <th rowspan="3" colspan="3">Address</th>
		        <th rowspan="2">Year</th>
			
		      </tr>
			  
		    </thead>
		    <tbody id="myTable">
		      <tr>
		        <td></td>
				<td colspan="2"></td>
		        <td colspan="3"></td>
		        <td></td>
		     
		    <td style="white-space:nowrap;">
					<a><button type="button" style="height:27px; width:58px;" class="btn btn-primary btn-sm">Add</button></a>
				</td>
		      </tr>
		    </tbody>
		  	</table>
			<div class="col-md-12 center text-center">
	            <ul class="pagination" id="myPager"></ul>
	    	</div>
    	</div>
		<div id="table-sendrequest">

		  <table class="table table-condensed table-freeze-multi table-bordered table-hover" id="tabla" 
		    data-scroll-height="305" data-cols-number="3">
		    <colgroup class="widthColMonth">
		      <col width="80px;">
		      <col width="180px;">
			  <col width="30px;">
			  <col width="30px;">
		      <col width="45px;">
			  <col width="60px;">
			  <col width="120px;">
		    </colgroup>
		    <thead>
		      
		      <tr>
		        <th rowspan="2">User Id</th>
				<th rowspan="2" colspan="2">Name</th>
		        <th rowspan="3" colspan="3">Date</th>
		        <th rowspan="2">User Add</th>
			
		      </tr>
			  
		    </thead>
		    <tbody id="myTable">
		    <c:forEach items="${listAdmin}" var = "admin">
		      <tr>
		        <td>${admin.getId_user() }</td>
				<td colspan="2">${admin.getFull_name()}</td>
		        <td colspan="3">${admin.getDate()}</td>
		        <td>${admin.getId_add()}</td>
		     
		    <td style="white-space:nowrap;">
					<a href="${pageContext.request.contextPath}/Admin?del=true&&i=${admin.getId_user()}">Xóa</button></a>
				</td>
		      </tr>
		      </c:forEach>
		    </tbody>
		  	</table>
			<div class="col-md-12 center text-center">
	            <ul class="pagination" id="myPager"></ul>
	    	</div>
    	</div>
  </div>
</body>
</html>