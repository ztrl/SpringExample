<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<p><a href='<c:url value="/upload/new"/>'>업로드</a></p>
		<p><a href='<c:url value="/upload/list"/>'>파일 전체 목록</a></p>
		<p><a href='<c:url value="/upload/list/bigdata"/>'>빅데이터 목록</a></p>
		<p><a href='<c:url value="/upload/gallery"/>'>갤러리</a></p>
	</body>
</html>