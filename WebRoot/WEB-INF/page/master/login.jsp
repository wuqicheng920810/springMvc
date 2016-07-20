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
     var basePath= "<%=basePath%>"
    </script>
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	body{background-image: url(<%=basePath%>images/login_1.jpg );}
	.mainDiv{width:481px;height: 241px;margin: auto; position: absolute; top: 0; left: 0; bottom: 0; right: 0; background-image: url(<%=basePath%>images/login_2.png);}
	.log_Win{margin-left: 140px;margin-top: 70px}
	.input_t{width: 150px;height: 35px}
   .button_1{margin-left: 140px;width: 200px;height: 50px;margin-top: 5px}
	</style>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body >
      <div class="mainDiv" >
          <div class="log_Win">
             <p><input class="input_t" type="text"  id="loginname" name="loginname"/></p>
             <p><input class="input_t" style="margin-top: 10px" type="password"  id="password" name="password"/> <a href="usersController/to_register.do">注册</a></p>
             <p><input class="button_1"  name="login_but" type="button"  value="登入"/></p>
          </div>
      </div>
  </body>
    <script type="text/javascript" src="<%=basePath%>jquery/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
      $(function(){
           $(":button").click(function(){
              var uName= $.trim($("#loginname").val());
              var pwd=$.trim($("#password").val());
              if(uName!=""&&pwd!=""){
              $.getJSON(basePath+"userAction/userLogin.do", {"loginname":uName ,"password":pwd, }, 
                function(data){
                    if(data.success==1){
                          window.location=basePath+"jumpAction/toMain.do";
                           }
                    else{
                        alert("用户名或者密码错误");
                          }
                 });
                }
                else{
                 alert("用户名和密码不能为空");
               
                 }
             });
      
      })
    </script>
</html>
