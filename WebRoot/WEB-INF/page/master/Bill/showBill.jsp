<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<script type="text/javascript">
		var page = {
			basePath: "<%=basePath%>"

	};
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'showBill.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
td {
	width: 35%
}
</style>
<script src="<%=basePath%>jquery/jquery-1.9.1.min.js"></script>
<script src="<%=basePath%>jquery/jquery-ui-datepicker.js"></script>
<script src="<%=basePath%>jquery/laydate/laydate.js"></script>
<script src="<%=basePath%>jquery/laydate/mydatepicker.js"></script>

</head>

<body>
	<p>
		<a href="javascript:history.go(0);">刷新</a>
	</p>
	<div class="topdiv" style="width: 100%;height: 20%;">
		<f:form modelAttribute="bill">
			<table>
				<tr>
					<td>商品名称<input type="text" name="goodsname" id="goodsname" />
					</td>
					<td>购买人名称<input type="text" name="username" id="username" />
					</td>
				</tr>
				<tr>
					<td>开始时间<input type="text" id="beginDate" name="beginDate"
						readonly="readonly" />
					<td>截止时间<input type="text" id="endDate" name="endDate"
						readonly="readonly" /></td>
				</tr>
				<tr>
					<td>商品类别<f:select path="paytype" items="${payList}"
							itemLabel="typename" itemValue="id">
						</f:select>
					<td>购物方式 <f:select path="goodstpye" items="${goodsList}"
							itemLabel="typename" itemValue="id">
						</f:select></td>
				</tr>
				<tr>
					<td><input type="button" value="提交" id="from_but" />
					</td>
				</tr>
			</table>
		</f:form>
	</div>
	<table class="miantable" id="miantable"></table>
	<div></div>
</body>
<script type="text/javascript">
	laydate({
		elem : '#beginDate',
		format : 'YYYY-MM-DD'
	});

	laydate({
		elem : '#endDate',
		format : 'YYYY-MM-DD'
	});

	$(function() {
		$("#from_but").click(function() {
			$.getJSON(page.basePath + "billAction/ajax.do", {
				"goodsname" : $("#goodsname").val(),
				"username" : $("#username").val(),
				"beginDate" : $("#beginDate").val(),
				"endDate" : $("#endDate").val(),
				"paytype" : $("#paytype").val(),
				"goodstpye" : $("#goodstpye").val()
			}, function(date) {
			alert(date.length);
				$("#miantable").empty();
				var context = "";
				for ( var i = 0; i < date.length; i++) {
					context =context+ "<tr>"
					                +"<td>111</td>" 
					                + "</tr>"
				}
				alert(context);
				$("#miantable").html(context);
			});
		});

	})
</script>
</html>
