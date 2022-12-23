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
		<c:url var="actionURL" value='/upload/new'/>
		<form action="${actionURL}" method="post" enctype="multipart/form-data">
			<select name="dir">
				<option value="/">
				<option value="/images">/이미지
				<option value="/data">/자료실
				<option value="/bigdata">/빅데이터
				<option value="/common">/공통
			</select>
			<input type="file" name="file"/>
			<input type="submit" value="SAVE"/>
			<input type="reset" value="CANCEL"/>
		</form>
	</body>
</html>