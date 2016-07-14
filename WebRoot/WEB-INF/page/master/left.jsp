<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page contentType="text/html; charset=UTF-8"%> 
 <%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
       <script type="text/javascript" src="<%=basePath%>jquery/jquery-1.9.1.min.js"></script>
    <style type="text/css">
    .son{margin-left: 30px}
    </style>
    <script type="text/javascript">
    function menuClick( menu ){
				$(menu).next().toggle();
			}
  /*   $(function(){
     //$(".son").hide();
     $(".father").click(function(){
     alert($(".father").children(".son").length);
       // $(this)find("p").toggle();
           //$(".son").toggle();
       });
    }); */
    </script>
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  
  </head>
  
  <body >
   <a href="usersController/right.do"   target="right_f">跳转测试</a>
   <c:forEach items="${sessionScope.listRote }"  var="rote">
   <p class="father" onClick="menuClick(this);">${rote.right_name }</p>
         <div>
             <c:forEach items="${rote.listRight }" var ="roteson" >
                  <p class="son"><a href="#" target="right_f" >${roteson.right_name}</a></p>
             </c:forEach>
         </div>
   </c:forEach> 
  </body>
</html>
