<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>세션</title>
</head>
<body>
<%String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String name = "홍길동";

session.setAttribute("id",id ) ;
session.setAttribute("pwd",pwd );
session.setAttribute("name",name );

%>
<%=session.getAttribute("name") %> 님 반갑습니다.<br><br>
아이디 <%=session.getAttribute("id") %>로 접속하셨습니다.<br><br><br>
<a href="Logout.jsp">로그아웃</a> 

</body>
</html>