<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    	<script type="text/javascript">
		var page = {
			basePath: "<%=basePath%>", 
		
		};
	</script>
    
    <title>My JSP 'index2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script type="text/javascript" src="<%=basePath%>jquery/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
      $(function(){
         $(":button").click(function(){
         var uName=$("#uName").val();
         var uPwd=$("#uPwd").val();
         alert(1);
         $.getJSON(page.basePath+"firstController/loginAction.do",
              {
         "userName":uName,
         "passWord":uPwd,
              },function(date){ 
                     }
         );
         });
      
      });
    </script>
  </head>
  
  <body>
    <li>
      <ul><input type="text"  id="uName" name="Users.userName"/></ul>
      <ul><input type="text"  id="uPwd" name="Users.passWord"/> </ul>
      <ul><input type="button"  value="提交"/> </ul>
    </li>
  </body>
</html>
