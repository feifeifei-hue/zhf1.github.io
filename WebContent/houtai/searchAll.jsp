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
    <title>英雄信息显示界面</title>
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
<body >

<table class="table table-hover table-striped">
		<tr>
		<td>英雄名称</td>
		<td>英雄生命值</td>
		<td>英雄法力值</td>
		<td>英雄攻击速度</td>
		<td>英雄防御力</td>
		<td>皮肤名称</td>
		<td>铭文名称</td>
		<td>操作</td>
		</tr>

<c:forEach var="hero" items="${heroall}">
	       <tr>
				<td><a href="${pageContext.request.contextPath}/findHeroServlet?method=findHero&Hero_name=${hero.getHeroname()}">${hero.getHeroname()}</a></td>
				<td>${hero.getHerohealth()}</td>
				<td>${hero.getHeromana()}</td>
				<td>${hero.getHeroas()}</td>
				<td>${hero.getHeroac()}</td>
				<td>${hero.getSkinname()}</td>
				<td>${hero.getMottoname()}</td>
				<td><a href="${pageContext.request.contextPath}/deleteServlet?Hero_name=${hero.getHeroname()}&method=delete" onclick="queren()">删除</a></td>
	       	   
		   </tr>
</c:forEach>
</table>
</body>
</html>