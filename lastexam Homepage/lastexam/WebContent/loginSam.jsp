<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String name = request.getParameter("irum");
    
	String control = request.getParameter("control");
	String content = control + ".jsp";
%>
   <% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = 1 cellpadding=5 cellspacing =0 width="600">
    <tr>
        <td ><%= name %>님 로그인 중입니다. </td>
        <td>로그아웃</td>
     </tr>   
	<tr>
	   <td colspan=2>
		<jsp:forward page="template.jsp">
	<jsp:param name="contentPage" value="<%= content %>" />
</jsp:forward>	
</td>			
	</tr>
</table>
</body>
</html>