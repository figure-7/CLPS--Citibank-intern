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
	<br>
	<form action="${pageContext.request.contextPath }/springmvc/helloworld" method="post">
		<input type="submit">
	</form>
	
	<hr>
	
	
	<!-- 
		文件上传表单要求:
			①必须请求方式:method="post"
			②必须请求类型编码:enctype="multipart/form-data"
			③必须请求参数类型必须文件域:type="file"
	 -->
	<form action="${pageContext.request.contextPath }/springmvc/testUpload" method="post" enctype="multipart/form-data">
		文件: <input type="file" name="file"/><br><br>
		描述: <input type="text" name="desc"/><br><br>
		<input type="submit" value="提交"/>
	</form>
	
	<form action="${pageContext.request.contextPath }/springmvc/testUploadMany" method="post" enctype="multipart/form-data">
		文件: <input type="file" name="files"/><br><br>
		文件: <input type="file" name="files"/><br><br>
		描述: <input type="text" name="desc"/><br><br>
		<input type="submit" value="提交"/>
	</form>
	
	
	
	
</body>
</html>