<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
  <script type="text/javascript">
     var basePath= "<%=basePath%>"
    </script>
<title>My JSP 'register.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
  <form action="usersController/inserUser.do" method="post"  id="myForm" >
		<table>
			<tr>
				<td>用户名</td>
				<td><input type="text"  id="LoginName" name="LoginName" />
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" id="passWord" name="passWord" />
				</td>
			</tr>
			<tr>
				<td>确认密码</td>
				<td><input type="password" id="passWord2" name="passWord2" />
				</td>
			</tr>
			<tr>
				<td><input type="button" id="but2" value="提交" /></td>
			</tr>
		</table>
		</form>
</body>
<script type="text/javascript" src="<%=basePath%>jquery/jquery-1.9.1.min.js"></script>
 <script type="text/javascript">
	$(function() {

    
 	$("#but2").click(function() {
 	
/*  	      $.getJSON(basePath+"usersController/test_name.do",
              {
         "LoginName":$("#LoginName").val()
        
              },function(date){ 
              alert(1);
                     }
         ); */
 	var s=false;
			var name = $.trim($("#LoginName"));
			var pwd = $.trim($("#passWord").val());
			var pwd2 = $.trim($("#passWord").val());
			 if(name.length<6&&pwd.length<6){
			  alert("用户名大于6位数");
			  }
			 else{
			    if(pwd==pwd2){
			      $.getJSON(basePath+"usersController/test_name.do", {"LoginName":$("#LoginName").val(),},
			      function(date){ 
			      if(date.num==0){
			      alert("进入");
			           document.getElementById("myForm").submit();
			      }
			      else{
			          alert("此用户已经存在");
			           return false;
			      }
                                         }
                                );
			    }
			    else{
			      alert("两次输入的密码不一致");
			    }
			 }
		});  
	});
</script>
</html>
