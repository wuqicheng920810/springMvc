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
    <title>My JSP 'index3.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
     <script type="text/javascript" src="<%=basePath%>jquery/jquery-1.9.1.min.js"></script>
     <script src="<%=basePath%>jquery/ajaxfileupload.js" type="text/javascript"></script>
     
 
  </head>
  
<body>  
<!-- <form action="firstController/upload.do" method="post" enctype="multipart/form-data">  
 --><input id="uploadFile"  type="file" name="file" /> <input id="submit" type="submit" value="Submit" />
<!--  </form>  
 --></body>
<script type="text/javascript">
$(function(){
   $("#submit").click(function(){
     if($(":file").val().length>0){
       alert("可以进行上传文件了");
        $.ajaxFileUpload({ 
          url:page.basePath + 'firstController/upload.do', 
          data: {"userId":1},
          secureuri:false,  
          fileElementId:'uploadFile',//file标签的id  
          success: function (data, status) {  
        	alert("完成上传");
          },  
          error: function (data, status, e) {  
       		alert("导入失败!"+data.responseText);
          	window.location.reload();
          }  
      }); 
        true ;
     }
     else{
       alert("跟本就没有选择文件啊");
       return false;
     }
   });
});

   
</script>
</html>
