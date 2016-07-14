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
    <h1>跳转新路径</h1>
  </body>
</html>