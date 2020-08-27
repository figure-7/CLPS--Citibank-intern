<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>

<script type="text/javascript">

	$(function(){
		
		$(".delete").click(function(){
			//var href = $(this).attr("href");
			var href = this.href ; //this是DOM对象
			
			$("#deleteForm").attr("action",href).submit();
			
			return false ;
		});
		
	});

</script>

</head>
<body>
	<form id="deleteForm" action="" method="POST">
		<input type="hidden" name="_method" value="delete"/>
	</form>


	员工列表：<a href="${pageContext.request.contextPath }/toAdd">添加员工</a>
	<hr>
	<br>
	<center>
		<table border="1" width="80%">
			<tr>
				<th>ID</th>
				<th>lastName</th>
				<th>email</th>
				<th>Gender</th>
				<th>DeptName</th>
				<th> Edit </th>
				<th> Delete</th>
			</tr>
			<c:forEach items="${requestScope.empList }" var="emp">
				<tr>
					<td> ${emp.id } </td>
					<td> ${emp.lastName } </td>
					<td> ${emp.email } </td>
					<td> ${emp.gender==1?"男":"女" } </td>
					<td> ${emp.department.departmentName } </td>
					<td> <a href="${pageContext.request.contextPath }/toUpdate/${emp.id}">Edit</a> </td>
					<td> <a class="delete" href="${pageContext.request.contextPath }/delete/${emp.id}">Delete</a> </td>					
				</tr>
			</c:forEach>
		</table>
	</center>

</body>
</html>