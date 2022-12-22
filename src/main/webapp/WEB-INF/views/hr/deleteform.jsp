<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<!-- jQuery library -->
		<script src=https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js></script>
		<!-- Popper JS -->
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
		<h1>사원정보 삭제</h1>
		${emp.employeeId}사원 ${emp.firstName} ${emp.lastName}의 정보를 삭제합니다.<p>
		삭제 후 데이터는 복구될 수 없습니다.<p>
		${emp.employeeId}사원의 이메일을 입력하세요.
		<form action="./delete" method="post">
			이메일 : <input type="text" name="email"/>
			<input type="hidden" name="empid" value="${emp.employeeId}"/>
			<input type="submit" value="삭제"/>
		</form>
	</body>
</html>