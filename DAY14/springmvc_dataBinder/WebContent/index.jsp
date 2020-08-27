<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src ="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>

<!-- <script type="text/javascript">
	
	 $(function(){
		
		$("#testJSON").click(function(){
			var href = this.href ;
			
			$.ajax({
				   type: "POST",
				   url: href,
				   data: "name=John&location=Boston",
				   success: function(result){
				     
					   for(var i = 0; i < result.length; i++){
						   alert(result[i].lastName + " - " + result[i].gender);
					   }
					   
				   }
			});
			
			return false ;
			
		});
		
	}); 

</script> -->

</head>
<body>
	<a href="${pageContext.request.contextPath }/empList">查询所有员工</a>
	
	<hr>
	
	<form action="${pageContext.request.contextPath }/empAdd" method="POST">
         <!-- 解决问题：
                 1.数据类型转换
                 2.数据格式
                 3.数据校验                 
                 自定义类型转换器：
	                         将字符串转换为Employee对象,完成添加功能         
		BirthDay :<input type="text" name="birthDay"/><br><br>        
		-->
		<!-- 字符串格式：lastName-email-gender-department.id
		    例如：GG-gg@clps.com-0-105        
		 -->
		Employee : <input type="text" name="employee"/>                                
	                  <input type="submit" value="Submit"><br><br>
	</form>
	
	<hr>
	
	<a id="testJSON" href="${pageContext.request.contextPath }/testJSON">testJSON</a>
	<hr>
	<a href="${pageContext.request.contextPath }/testResponseEntity">abc.txt</a>
</body>
</html>