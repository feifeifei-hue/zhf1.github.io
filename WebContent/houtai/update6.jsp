<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<!-- 改 -->
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
	<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js" ></script>	
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>	
	<script type="text/javascript">
    	function queren() {
			alert("确认删除？");
		}
    </script>
   
<title>铭文信息显示</title>
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

<div class="container" style="margin-left: 250px; margin-top: 100px;width: 700px; height: 400px;  ">
		<form action="${pageContext.request.contextPath}/MottoUpdateServlet?method=update2" method="post" class="form-horizontal" onsubmit="return check()">
			<div class="form-group" style="margin-left: 125px; margin-top: 10px;">
			    <label class="col-sm-3 control-label" for="Motto_name" style="color: pink;">铭文名称</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Motto_name" name="Motto_name" value="${motto.getMottoname()}" readonly="readonly">
			    </div>
			</div>
			
			<div class="form-group" style="margin-left: 125px;">
				<label class="col-sm-3 control-label" for="Motto_rank" style="color: pink;">铭文等级</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Motto_rank" name="Motto_rank" value="${motto.getMottorank()}">
			    </div>
			</div>
			
			<div class="form-group" style="margin-left: 125px; margin-top: 10px;">
			    <label class="col-sm-3 control-label" for="Motto_function" style="color: pink;">铭文功能</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Motto_function" name="Motto_function" value="${motto.getMottofc()}">
			    </div>
			  </div>
			
			<div class="form-group" style="padding-left: 400px;">
				<input type="submit" value="更新" class="btn btn-primary" style="width: 60px;"/>
				&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/MottoDeleteServlet?Motto_name=${motto.getMottoname()}&method=delete2" onclick="queren()">删除</a>
			</div>
		</form>
</div>
</body>
</html>