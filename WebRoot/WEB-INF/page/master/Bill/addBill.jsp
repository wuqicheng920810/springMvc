<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page contentType="text/html; charset=UTF-8"%> 
 <%@ page isELIgnored="false" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addBilljsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script src="<%=basePath%>jquery/jquery-1.9.1.min.js"></script>
		<script src="<%=basePath%>jquery/jquery-ui-datepicker.js"></script>
		<script src="<%=basePath %>jquery/laydate/laydate.js"></script>
	<script src="<%=basePath %>jquery/laydate/mydatepicker.js"></script>
  </head>
  
  <body>
  <f:form action="billAction/addBill.do" modelAttribute="bill"  method="post" enctype="multipart/form-data">
   <table>
           <tr>
              <td>商品名称</td>
              <td><input  type="text"  name="goodsname" /></td>
          <tr>
               <td>消费时间</td>
               <td><input  type="text"  readonly="readonly" id="payDate" name="paydate" /></td>
          </tr>
          <tr>
               <td>商品类别</td>
               <td>  
               <f:select path="goodstpye"   items="${goodsList}"  itemLabel="typename"       itemValue="id"> </f:select>    
            </td>
          </tr>
            <tr>
               <td>购物方式</td>
               <td>  
               <f:select path="paytype"   items="${payList}"  itemLabel="typename"       itemValue="id"> </f:select>    
            </td>
          </tr>
           <tr>
               <td>总金额</td>
               <td>  
               <input  type="text"  onkeyup="value=value.replace(/[^\d.-]/g,'') "  name="money" /> 
            </td>
          </tr>
           <tr>
               <td>数量</td>
               <td>  
               <input  type="text"  onkeyup="value=value.replace(/[^\d]/g,'')"  name="number" /> 
            </td>
          </tr>
            <tr>
               <td>数量</td>
               <td>  
               <input  type="file"   readonly="readonly"  name="file" /> 
            </td>
          </tr>
          <tr><td><input type="submit" value="提交" /></td></tr>
   </table>
   </f:form>
  </body>
  <script type="text/javascript">
 laydate({
				elem : '#payDate',
				format : 'YYYY-MM-DD'
									});
  </script>
</html>
