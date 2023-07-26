<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정관리</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<link href="/resource/css/style.css?<%=System.currentTimeMillis()%>" rel="stylesheet"/>	
</head>
<body>
	<div style="display: flex; justify-content: center; padding: 25px;">
		<img src="/resource/image/logo.JPG" width="20%" height="120px" />
	</div>
		<div>
		<div class="form-around" style="flex-direction: column;">
			<form action="/auth-task" method="post" class="default-form">
				<input type="text" name="id" placeholder="아이디" /> 
				<input type="password" name="password" placeholder="비밀번호" />
				<div>
					<button type="submit" class="default-btn">로그인</button>
				</div>
				<div style="padding: 8px;">
					<span style="color: red;"><b>${error }</b></span>
				</div>
			</form>
			<span style="padding: 16px;">하루의 일과를 관리 해보세요! <a href="/user/join"><b>회원가입</b></a></span>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>	
</body>
</html>