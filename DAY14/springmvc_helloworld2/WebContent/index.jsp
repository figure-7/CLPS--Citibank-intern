<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<a href="${pageContext.request.contextPath }/springmvc/helloworld">HelloWorld</a>
	
	<hr>
	
	<a href="${pageContext.request.contextPath }/springmvc/ant/helloworld">HelloWorld</a>
	
	<hr>
	
	<a href="${pageContext.request.contextPath }/springmvc/testPathVariable/10/zhangsan">testPathVariable</a>
	
	<hr>
	
	<!-- 1.测试GET请求 -->
	<a href="${pageContext.request.contextPath }/springmvc/testRESTFul/1">testRESTFul_GET</a>
	
	<br><br>
	
	<!-- 2.测试POST请求 -->
	<form action="${pageContext.request.contextPath }/springmvc/testRESTFul" method="post">
		<input type="submit" value="testRESTFul_POST"/>
	</form>

	<br><br>
	<!-- 3.测试PUT请求 -->
	<form action="${pageContext.request.contextPath }/springmvc/testRESTFul/1" method="post">
		<input type="hidden" name="_method" value="put">
		<input type="submit" value="testRESTFul_PUT"/>
	</form>

	<br><br>
	<!-- 3.测试Delete请求 -->
	<form action="${pageContext.request.contextPath }/springmvc/testRESTFul/1" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="testRESTFul_DELETE"/>
	</form>
	
	<br><br>
	
	
	<a href="${pageContext.request.contextPath }/springmvc/testRequestParam?age=10">testRequestParam</a>
	<br><br>
	<a href="${pageContext.request.contextPath }/springmvc/testRequestHeader">testRequestHeader</a>
	<br><br>

	<a href="${pageContext.request.contextPath }/springmvc/testCookieValue">testCookieValue</a>

	<br><br>
	<!-- 测试 POJO 对象传参，支持级联属性 -->
	<form action="${pageContext.request.contextPath }/springmvc/testPOJO" method="POST">
		username: <input type="text" name="username"/><br>
		password: <input type="password" name="password"/><br>
		email: <input type="text" name="email"/><br>
		age: <input type="text" name="age"/><br>
		
		<!-- 级联属性 -->
		city: <input type="text" name="address.city"/><br>
		province: <input type="text" name="address.province"/>
		<input type="submit" value="Submit"/>
	</form>
	
	
	<br><br>
	
	
	<a href="${pageContext.request.contextPath }/springmvc/testServletAPI">testServletAPI</a>
	
	
	<br><br>
	<a href="${pageContext.request.contextPath }/springmvc/testModelAndView">testModelAndView</a>
	
	
	<br><br>
	<a href="${pageContext.request.contextPath }/springmvc/testMap">testMap</a>
	
	<br><br>

</body>
</html>