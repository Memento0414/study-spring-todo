<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	 <form action="/user/join-task" method="post">
	 	<div>
	 		<input type="text" name="id" placeholder="아이디"/>
	 		<input type="password" name="password" placeholder="비밀번호"/>
	 		<div>
	 			<button type="submit">가입하기</button>
	 		</div> 
	 	</div>
	 </form>
</body>
</html>