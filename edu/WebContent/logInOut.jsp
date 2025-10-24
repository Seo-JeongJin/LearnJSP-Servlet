<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input</title>
</head>
<body>
<% if (session.isNew() || session.getAttribute("id") == null) { %>
	<%
		String msg = (String) request.getAttribute("error");
		if (msg == null) { // 프로그램이 처음 시작됐을 때 반환 값은 null이므로 변수에 "" 을 저장해 아무 것도 출력되지 않게함 
			msg = "";
		}
	%>
	<%= msg %>
	<form action="example10.jsp" method="post">
		ID : <input type="text" name="id"><br>
		PASSWORD : <input type="password" name="pwd"><br>
		<input type="submit" value="로그인">
	</form>
<% } else { %>
	<a href="example10.jsp">로그아웃</a>
<% } %>
</body>
</html>