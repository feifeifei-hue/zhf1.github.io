<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> <!-- 设置jsp文件的编码 ，contentType设置浏览器读取jsp文件的编码-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@page isELIgnored="false"%>
<!--显 -->
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
	<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js" ></script>	
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>	
    <title>皮肤信息显示界面</title>
    <script type="text/javascript">
    	function queren() {
			alert("确认删除？");
		}
    </script>
	<style type="text/css">
		.form-control{
			width: 125px;
		}
	</style>
</head>
<body>

<table class="table table-hover table-striped">
		<tr>
		<td>皮肤名称</td>
		<td>皮肤背景</td>
		<td>皮肤价格</td>
		<td>操作</td>
		</tr>

<c:forEach var="skin" items="${skinall}">
	       <tr>
				<td><a href="${pageContext.request.contextPath}/SkinFindServlet?method=findSkin&Skin_name=${skin.getSkinname()}">${skin.getSkinname()}</a></td>
				<td>${skin.getSkinbg()}</td>
				<td>${skin.getSkinprice()}</td>
				<td><a href="${pageContext.request.contextPath}/SkinDeleteServlet?Skin_name=${skin.getSkinname()}&method=delete1" onclick="queren()">删除</a></td>
		   </tr>
</c:forEach>
</table>
</body>
</html>