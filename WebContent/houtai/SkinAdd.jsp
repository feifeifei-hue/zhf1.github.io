<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- device-width表示，视区宽度应为设备的屏幕宽度。initial-scale用于设置Web页面的初始缩放比例,设为1显示未经缩放的Web页面 -->
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
	<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js" ></script>	
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" ></script>
    <title>皮肤信息添加界面</title>
	<style type="text/css">
		.form-control{
			width: 150px;
		}
	</style>
  </head>
<body style="background: url(../img/孙尚香.jpg) no-repeat">
  
	<div class="container" style="margin-left: 300px; margin-top: 100px;width: 700px; height: 400px;  ">
		<form action="${pageContext.request.contextPath}/SkinAddServlet?method=add1" method="post" class="form-horizontal" onsubmit="return check()">
			<div class="form-group" style="margin-left: 125px; margin-top: 10px;">
			    <label class="col-sm-3 control-label" for="Skin_name">皮肤名称</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Skin_name" name="Skin_name" placeholder="请输入皮肤名">
			    </div>
			  </div>
			
			<div class="form-group" style="margin-left: 125px;">
				<label class="col-sm-3 control-label">皮肤背景</label>
				<div class="col-sm-9">
					<input class="form-control" type="text"  name="Skin_bg" placeholder="请输入皮肤背景">
				</div>
			</div>
			
			<div class="form-group" style="margin-left: 125px; margin-top: 10px;">
			    <label class="col-sm-3 control-label" for="Skin_price">皮肤价格</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Skin_price" name="Skin_price" placeholder="请输入皮肤价格">
			    </div>
			</div>
	
			<div class="form-group" style="padding-left: 300px;">
				<input type="submit" value="添加" class="btn btn-primary" style="width: 60px;"/>
			</div>
		</form>
	</div>
  </body>
</html>