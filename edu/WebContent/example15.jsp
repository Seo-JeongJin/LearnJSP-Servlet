<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String p = request.getParameter("p"); // 쿼리 값에 파일 주소 집어넣기
	%>
	<jsp:forward page="<%=p%>"/>
</body>
</html>