<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@page isELIgnored="false"%>
<!--查询  -->
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
<title>皮肤信息显示</title>
</head>
<body style="background: url(../img/孙尚香.jpg) no-repeat">
<div class="container-fluid" style="margin-top: 15px;">
<form action="${pageContext.request.contextPath}/MottoFindServlet?method=findMotto" method="post" >
	<div class="form-group row">
		<div class="col-sm-11">
		
		<label for="Motto_name" class="col-sm-1" style="text-align: center; margin-top: 7px; color: white;" >铭文名称:</label>
		<div class="col-sm-3">
			<input type="text" name="Motto_name" class="form-control" placeholder="请输入铭文名" style="width: 150px">
		</div>
		
		<label for="Motto_rank" class="col-sm-1" style="text-align: center; margin-top: 7px; color: white;">铭文等级:</label>
			<div class="col-sm-3">
				<input type="text" name="Motto_rank" class="form-control" placeholder="请输入铭文等级" style="width: 150px">
			</div>
		
		</div>
	</div>
		
	<div class="form-group row">
		<div class="col-sm-11">
		
		<label for="Motto_function" class="col-sm-1" style="text-align: center; margin-top: 7px; color: white;">铭文功能:</label>
		<div class="col-sm-3">
			<input type="text" name="Motto_function" class="form-control" placeholder="请输入铭文功能" style="width: 150px">
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
			<td>铭文名称</td>
			<td>铭文等级</td>
			<td>铭文功能</td>
		</tr>

<c:forEach var="motto" items="${mottoall}">
	       <tr>
				<td>${motto.getMottoname()}</td>
				<td>${motto.getMottorank()}</td>
				<td>${motto.getMottofc()}</td>
		   </tr>
</c:forEach>  
</table>	

</body>
</html>
