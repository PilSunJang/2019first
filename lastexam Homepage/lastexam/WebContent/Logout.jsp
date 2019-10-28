<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String id = (String )session.getAttribute("id");
if(id !=null ){
session.invalidate();
out.println("이용해 주셔서 감사합니다.");
}else{
	out.println("이미 로그아웃 상태입니다");
}




%>
</body>
</html>