<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page errorPage="example3.jsp" %>

<% 
	String param = request.getParameter("id");
	if (param.equals("text")) { /* 변수 param 이 null 이면 NullPointerException 이 발생하고 example3.jsp가 실행됨 */
		param = "파라미터가 입력되었습니다. (예외 상황이 발생하지 않았습니다.)";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>
		<%= param %>
	</h4>
</body>
</html>