<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
	
	
<title>일정관리</title>
</head>
<body>
	<div class="mb-2 mt-2">
		<div>
			<h2>금주 해야할 일</h2>
			<!--  <a href="/auth-out">로그아웃</a>-->
		</div>
		<ul class="list-group">
			<c:forEach var="quest" items="${quests }">
				<li class="list-group-item d-flex justify-content-between" onclick="location.href='/todos/addQuest?questId=${quest.id}'"><span>${quest.description }</span>
					<span class="badge bg-danger">${quest.joinCnt }</span></li>
			</c:forEach>
		</ul>

		<h2>당신이 해야할 일들</h2>
	</div>
	<div class="container">
		<div class="mb-1 text-end">
			<a href="/todos/create" class="btn btn-primary">할일 등록</a>
		</div>
		<table class="table" style="text-align: center;">
			<thead>
				<tr class="table-light">
					<th>세부내용</th>
					<th>달성기한</th>
					<th>달성여부</th>
					<th>수정/삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="obj" items="${todos }">
					<tr data-todo-id="${obj.id }">
						<td><c:out value="${obj.description }" /></td>
						<td>~ <fmt:formatDate value="${obj.targetDate }" /></td>
						<td>${empty obj.done ? '미달성' : '달성' }</td>
						<td><a href="/todos/update?todoId=${obj.id }"
							class="btn btn-info">수정</a> <a
							href="/todos/delete?todoId=${obj.id }" class="btn btn-danger">삭제</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>