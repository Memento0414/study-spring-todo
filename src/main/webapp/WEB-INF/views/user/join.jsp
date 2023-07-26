<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<link href="/resource/css/style.css?<%=System.currentTimeMillis()%>" rel="stylesheet"/>
<meta charset="UTF-8">
<title>회원가입</title>

</head>
<body>
	<div style="display: flex; justify-content: center; padding: 25px;">
		<img src="/resource/image/logo.JPG" width="20%" height="120px" />
	</div>
	<div class="form-around">
		<form action="/user/join-task" method="post" class="default-form">
				<input type="text" name="id" placeholder="아이디" />
				<input type="password" name="password" placeholder="비밀번호" />
				<div>
					<button type="submit" class="default-btn">가입하기</button>
				</div>
		
				<div style="padding: 4px;">
					<span style="color:red"><b>${error}</b></span>
				</div>
		
		</form>
	</div>
</body>
</html>