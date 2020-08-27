<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		Spring框架提供了一套标签库：
			并没有提供迭代的标签，也没有提供提交表单的标签。
			
		Spring框架标签：
			简单
			表单自动回显
			
		java.lang.IllegalStateException: Neither BindingResult nor plain target object for 
		bean name 'command' available as request attribute
			原因：框架标签库局部表单自动回显功能，在回显时，根据标签的path属性，从"command"对应的实体对象中查找属性值
			如果请求域中没有叫做"command"属性的实体对象，也就无法回显，所以报错。
			表单回显可以使用	modelAttribute 属性来指定模型对象，来获取相关实体对象的属性进行表单回显。	
	 -->
	
	修改员工:
	<hr>
	<form:form action="${pageContext.request.contextPath }/doUpdate" method="PUT" modelAttribute="employee">

		<form:hidden path="id"/>

		<%-- lastName : <form:input path="lastName"/> <br/><br/> --%>
		
		email : <form:input path="email"/><br/><br/>
		
		<% 
			Map<String,String> genders = new HashMap<String,String>();
			genders.put("1","Male");
			genders.put("0","Female");
			request.setAttribute("genders", genders);
		%>
		
		gender : 		
			<form:radiobuttons path="gender" items="${genders}"/><br/><br/>
			
		DeptName :
			<!-- 级联属性 -->
			<form:select path="department.id" 
					items="${deptList }" 
					itemLabel="departmentName" 
					itemValue="id"/><br/><br/>
					
			<input type="submit" value="修改"/><br/><br/>
	</form:form>

</body>
</html>