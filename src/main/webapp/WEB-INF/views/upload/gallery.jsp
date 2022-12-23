<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<!-- jQuery library -->
		<script src=https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js></script>
		<!-- Popper JS -->
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		
		<script type="text/javascript">
			window.onload = function() {
				var deleteButtons = document.querySelectorAll(".delete");
				for (var i = 0; i < deleteButtons.length; i++) {
					deleteButtons[i].onclick = function() {
						if (confirm("파일을 삭제하겠습니까?")) {
							return true;
						}
						else {
							return false;
						}
					}
				}
			}
		</script>
	</head>
	<body>
		<c:url var="actionURL" value='/upload/updateDir'/>
		<form action="${actionURL}" method="post" enctype="multipart/form-data">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>경로</th>
				<th>이미지</th>
				<th>크기</th>
				<th>유형</th>
				<th>날짜</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="file" items="${fileList}">
			<tr>
				<td><input type="checkbox" name="fileIds" value="${file.fileId}">${file.fileId}</td>
				<td>${file.directoryName}</td>
				<td>
					<c:set var="len" value="${fn:length(file.fileName)}"/>
					<c:set var="filetype" value="${fn:toUpperCase(fn:substring(file.fileName, len - 4, len))}"/>
					<c:if test="${(filetype == '.JPG') || (filetype == 'JPEG') || (filetype == '.PNG') || (filetype == '.GIF')}">
						<img src='<c:url value="/img/${file.fileId}"/>' width="100">
					</c:if>
				</td>
				<td><fmt:formatNumber value="${file.fileSize/1024}" pattern="#,###"/>KB</td>
				<td>${file.fileContentType}</td>
				<td>${file.fileUploadDate}</td>
				<td>
					<c:url var="deletelink" value="/upload/delete/${file.fileId}"/>
					<a href="${deletelink}" class="delete">삭제</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		선택한 파일을 <select name="directoryName">
			<option value="/">
			<option value="/images">/이미지
			<option value="/data">/자료실
			<option value="/bigdata">/빅데이터
			<option value="/common">/공통
		</select>로 <input type="submit" value="이동"><p>
		<a href='<c:url value="/upload/new"/>'>업로드</a>
		<a href='<c:url value="/upload"/>'>처음으로</a>
		</form>
	</body>
</html>