<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<link href="/resource/css/style.css?<%=System.currentTimeMillis()%>" rel="stylesheet"/>	
<title>할일 관리</title>
</head>
<body>
	<div style=" display: flex; height: 75vh; align-items: center;">
	<div class="container">
		<div style="display: flex; justify-content: center; padding: 25px;">
			<a href="/todos"><img src="/resource/image/logo.JPG"  width="100%" height="100px" /></a>
		</div>
		<div class="mb-2 mt-2" style="padding: 8px;">
			<h2># 목표 설정</h2>
		</div>
		<form action="/todos/create-task" method="post">
			<div class="mb-2">
				<label>날짜</label> <input type="date" name="targetDate"
					class="form-control" />
			</div>
			<div class="mb-2">
				<label>목표</label> <input type="text" name="description"
					class="form-control" placeholder="일정을 입력해주세요."/>
			</div>
			<div style="color: red; text-align: center;"> <b>${message }</b></div>
			<div style="padding: 8px; display: flex; justify-content: center;">
				<button type="submit" class="btn btn-primary">목표 등록</button>
			</div>
		</form>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
			crossorigin="anonymous"></script>
	</div>
	</div>
</body>
</html>











