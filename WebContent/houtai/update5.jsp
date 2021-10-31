<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
	<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js" ></script>	
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>	
    <title>铭文信息修改界面</title>
	<style type="text/css">
		.form-control{
			width: 150px;
		}
	</style>
  </head>
<body style="background: url(../img/孙尚香.jpg) no-repeat">

<div class="container-fluid" style="margin-top: 15px;">
<form action="${pageContext.request.contextPath}/MottoFindServlet?method=updatefind2" method="post" >
	<div class="form-group row">
		<div class="col-sm-5">
		<label for="Motto_name" class="col-sm-5" style="text-align: center; margin-top: 7px; color: pink;">请输入铭文名称:</label>
		<div class="col-sm-4">
			<input type="text" name="Motto_name" class="form-control" placeholder="请输入铭文名">
		</div>
		</div>
		
		<div class="col-sm-3" >
			<input type="submit" value="查询" class="btn btn-primary" style="width: 60px;"/>
		</div>
		
		</div>
</form>
</div>

</body>
</html>