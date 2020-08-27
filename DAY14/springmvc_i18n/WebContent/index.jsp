<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 切换语言 -->
	<a href="${pageContext.request.contextPath }/testI18N?locale=zh_CN">中文</a> | 
	<a href="${pageContext.request.contextPath }/testI18N?locale=en_US">英语</a>
	
	<hr>

	<a href="${pageContext.request.contextPath }/helloworld">HelloWorld</a>
	<br>
	<form action="${pageContext.request.contextPath }/helloworld" method="post">
		<input type="submit">
	</form>
	
	<hr>
	
	<a href="${pageContext.request.contextPath }/testI18N">test I18N</a>
</body>
</html>