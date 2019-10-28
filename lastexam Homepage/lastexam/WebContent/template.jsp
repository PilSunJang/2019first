<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String content = request.getParameter("contentPage");
%> 
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<body>
<title>Insert title here</title>
</head>
<img src="img/apple.jpg" width="150" height="70"><p>
<table border="0" cellspacing=cellpadding=5width="100%" heught="100%">
	<tr>
		<td colspan="2"><jsp:include page="topmenu.jsp" flush="false" /></td> 
	</tr>
		<td width="200"><jsp:include page="leftmenu.jsp" flush="false" /></td>
		<td><jsp:include page="<%= content %>" flush="false"/></td>
	<tr>
	</tr>
	<tr>
		<td colspan="2"><jsp:include page="bottom.jsp" flush="false" /></td> 	
	</tr>
</table>


</body>
</html>
