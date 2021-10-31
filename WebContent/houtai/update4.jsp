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
   
<title>皮肤信息显示</title>
</head>
<body style="background: url(../img/孙尚香.jpg) no-repeat">
<div class="container-fluid" style="margin-top: 15px;">
<form action="${pageContext.request.contextPath}/SkinFindServlet?method=updatefind1" method="post" >
	<div class="form-group row">
		<div class="col-sm-5">
		<label for="Skin_name" class="col-sm-5" style="text-align: center; margin-top: 7px">请输入皮肤名称:</label>
		<div class="col-sm-4">
			<input type="text" name="Skin_name" class="form-control" placeholder="请输入皮肤名">
		</div>
		</div>
		<div class="col-sm-3" >
			<input type="submit" value="查询" class="btn btn-primary" style="width: 60px;"/>
		</div>
		
		</div>
</form>
</div>

<div class="container" style="margin-left: 250px; margin-top: 100px;width: 700px; height: 400px;  ">
		<form action="${pageContext.request.contextPath}/SkinUpdateServlet?method=update1" method="post" class="form-horizontal" onsubmit="return check()">
			<div class="form-group" style="margin-left: 125px; margin-top: 10px;">
			    <label class="col-sm-3 control-label" for="Skin_name" style="color: pink;">皮肤名称</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Skin_name" name="Skin_name" value="${skin.getSkinname()}" readonly="readonly">
			    </div>
			</div>
			
			<div class="form-group" style="margin-left: 125px;">
				<label class="col-sm-3 control-label" for="Skin_bg" style="color: pink;">皮肤背景</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Skin_bg" name="Skin_bg" value="${skin.getSkinbg()}">
			    </div>
			</div>
			
			<div class="form-group" style="margin-left: 125px; margin-top: 10px;">
			    <label class="col-sm-3 control-label" for="Skin_price" style="color: pink;">皮肤价格</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Skin_price" name="Skin_price" value="${skin.getSkinprice()}">
			    </div>
			  </div>
			
			<div class="form-group" style="padding-left: 400px;">
				<input type="submit" value="更新" class="btn btn-primary" style="width: 60px;"/>
				&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/SkinDeleteServlet?Skin_name=${skin.getSkinname()}&method=delete1" onclick="queren()">删除</a>
			</div>
		</form>
</div>
</body>
</html>