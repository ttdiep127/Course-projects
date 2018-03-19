<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chào mừng bạn tới Website Dating.com</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/JS/css/style_log.css" />
</head>
<body background="${pageContext.request.contextPath}/images_bg/bg.jpg">
    <div class="profile">
    <form action="${pageContext.request.contextPath}/RegistrationWebDating?action=finishregis" method="post">
        <fieldset>
            <legend>
                <span class="number">2</span>Thêm thông tin về bạn
            </legend>
            <span class="city">
                <label for="city">Tỉnh/Thành Phố:</label> 
                <select class="dob" name="city">
                  <option value="Đà Nẵng">Đà Nẵng</option>
                  <option value="Đà Nẵng">Quảng Bình</option>
                  <option value="Đà Nẵng">Hà Nội</option>
                  <option>Huế</option>
                  <option>Quảng Nam</option>
                  <option>Cần Thơ</option>
                  <option>TP Hồ Chí Minh</option>
                  <option>Hà Tĩnh</option>
                  <option>Hải Phòng</option>
                  <option>Quảng Quảng</option>
                  <option>Cà Mau</option>
                  <option>Cần Thơ</option>
                </select>
            </span>
            <span class="job">
                <label for="job">Công việc:</label> 
                <input type="text" id="job" name="job"> 
            </span>
            <span><label for="status" id = "status">Châm ngôn tình yêu</label></span>
            <input type="text" id="status" name="status"> 
            <label for="introduction">Đôi nét về bản thân</label>
            <textarea id="introdction" name="introduction"></textarea>
        </fieldset>
    <div>
        <fieldset>
            <a href="#" onclick="javascript:history.go(-1)">
                Quay lại
            </a>
                <button class="regis" type="submit">Hoàn Tất Đăng ký</button>
        </fieldset>
    </div>
    </form>
    </div>
    
</body>
</html>