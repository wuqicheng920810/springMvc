<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()
+":"+request.getServerPort()+path+"/";
%>
<html>
  <body>
         <form action="loginAction.do" method="get">
           用户名：<input type="text" name="userName" />
           密码   ：<input type="text" name="passWord">
           <input type="submit" value="提交" />
         </form>
  </body>
</html>