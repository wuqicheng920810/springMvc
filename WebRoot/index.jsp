<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()
+":"+request.getServerPort()+path+"/";
%>
<html>
  <body>
<%--     <%
    String mypath = "hello";
    response.sendRedirect(basePath + mypath);
    %> --%>
    <h1><a onclick="location.href='<%=basePath %>jsp/redis.jsp'">redis测试</a></h1>
    
    <h1><a onclick="location.href='<%=basePath %>firstController/list.do'">springmvc跳转测试</a></h1>
    
    <h1><a onclick="location.href='<%=basePath %>firstController/test.do?name=1213dasfas'">springmvc带参数跳转测试</a></h1>
        
    <h1><a onclick="location.href='<%=basePath %>firstController/to_login.do'">测试登入</a></h1>
    
    <h1><a onclick="location.href='<%=basePath %>index3.jsp'">springmvc+JQuery上传</a></h1> 
    
    <h1><a onclick="location.href='<%=basePath %>index2.jsp'">Jquery提交数据</a></h1> 

  </body>
</html>
