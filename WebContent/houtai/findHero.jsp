<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@page isELIgnored="false"%>
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
<title>英雄信息显示</title>
</head>
<body style="background: url(../img/孙尚香.jpg) no-repeat">
<div class="container-fluid" style="margin-top: 15px;">
<form action="${pageContext.request.contextPath}/findHeroServlet?method=findHero" method="post" >
	<div class="form-group row">
		<div class="col-sm-11">
		<!--label，为input元素定义标注，for规定label绑定到的表单元素  -->
		<label for="Hero_name" class="col-sm-1" style="text-align: center; margin-top: 7px; color: white;" >英雄名称:</label>
		<div class="col-sm-3">											<!-- 规定帮助用户填写的提示 -->
			<input type="text" name="Hero_name" class="form-control" placeholder="请输入英雄名" style="width: 150px">
		</div>
		
		<label for="Hero_health" class="col-sm-1" style="text-align: center; margin-top: 7px; color: white;">英雄生命值:</label>
			<div class="col-sm-3">
			<input type="text" name="Hero_health" class="form-control" placeholder="请输入生命值" style="width: 150px">
			</div>
		</div>
		</div>
		
	<div class="form-group row">
		<div class="col-sm-11">
		
		<label for="Hero_mana" class="col-sm-1" style="text-align: center; margin-top: 7px; color: white;">英雄法力值:</label>
		<div class="col-sm-3">
			<input type="text" name="Hero_mana" class="form-control" placeholder="请输入法力值" style="width: 150px">
		</div>
		
		<label for="Hero_as" class="col-sm-1" style="text-align: center; margin-top: 7px; color: white;">英雄攻击速度:</label>
		<div class="col-sm-3">
			<input type="text" name="Hero_as" class="form-control" placeholder="请输入攻速" style="width: 150px">
		</div>
		
		<div class="col-sm-3" >
			<input type="submit" value="查询" class="btn btn-primary" style="width: 60px;"/>
		</div>
		
		</div>
		
	</div>
</form>
</div>
	
<table class="table table-hover" style="color: pink;">
		<tr>
		<td>英雄名称</td>
		<td>英雄生命值</td>
		<td>英雄法力值</td>
		<td>英雄攻击速度</td>
		<td>英雄防御力</td>
		<td>皮肤名称</td>
		<td>铭文名称</td>
		</tr>

<c:forEach var="hero" items="${heroall}"> <!-- 循环，items要被循环的信息 -->
	       <tr>
				<td>${hero.getHeroname()}</td>
				<td>${hero.getHerohealth()}</td> 	<%-- ${}输出或者计算一个表达式的内容,不能在<% %>使用 --%>
				<td>${hero.getHeromana()}</td>
				<td>${hero.getHeroas()}</td>
				<td>${hero.getHeroac()}</td>
				<td>${hero.getSkinname()}</td>
				<td>${hero.getMottoname()}</td> 	   
		   </tr>
</c:forEach>  
</table>	

</body>
</html>