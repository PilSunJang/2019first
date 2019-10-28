<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Template Example</title>
</head>
<body>
<img src="img/apple.jpg" width="300" height="150"><p>

<table border="1" cellspacing=0  cellpadding=5 width="100%" heught="100%">
	<tr>
		<td colspan="2">
		<table border = 0 cellpadding=5 cellspacing =0 width="100%">
	      <tr>
		<td width="150" align="center"><a href="indexProc.jsp?control=kin">iMAX</a></td>
		<td width="150" align="center"><a href="indexProc.jsp?control=km">iPad</a></td>
		<td width="150" align="center"><a href="indexProc.jsp?control=news">iPhone</a></td>
		<td width="150" align="center"><a href="indexProc.jsp?control=SessionLogin">로그인</a></td>					
	     </tr>
       </table>
		
		
		</td> 
	</tr>
	<tr>

</td>
<td><img src="img/asd.PNG" width="1200" height="500"></td>
</tr>

	
	<tr>
		<td colspan="2">
		<%@ include file="bottom.jsp" %></td> 	
	</tr>
</table>
</body>
</html>