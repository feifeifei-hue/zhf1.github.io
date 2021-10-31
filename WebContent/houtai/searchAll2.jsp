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
    <title>铭文信息显示界面</title>
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
		<td>铭文名称</td>
		<td>铭文等级</td>
		<td>铭文功能</td>
		<td>操作</td>
		</tr>

<c:forEach var="motto" items="${mottoall}">
	       <tr>
				<td><a href="${pageContext.request.contextPath}/MottoFindServlet?method=findMotto&Motto_name=${motto.getMottoname()}">${motto.getMottoname()}</a></td>
				<td>${motto.getMottorank()}</td>
				<td>${motto.getMottofc()}</td>
				<td><a href="${pageContext.request.contextPath}/MottoDeleteServlet?Motto_name=${motto.getMottoname()}&method=delete2" onclick="queren()">删除</a></td>
		   </tr>
</c:forEach>
</table>
</body>
</html>