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
    <title>铭文信息添加界面</title>
	<style type="text/css">
		.form-control{
			width: 150px;
		}
	</style>
  </head>
<body style="background: url(../img/孙尚香.jpg) no-repeat">
  
	<div class="container" style="margin-left: 300px; margin-top: 100px;width: 700px; height: 400px;  ">
		<form action="${pageContext.request.contextPath}/MottoAddServlet?method=add2" method="post" class="form-horizontal" onsubmit="return check()">
			<div class="form-group" style="margin-left: 125px; margin-top: 10px;">
			    <label class="col-sm-3 control-label" for="Motto_name">铭文名称</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Motto_name" name="Motto_name" placeholder="请输入铭文名">
			    </div>
			  </div>
			
			<div class="form-group" style="margin-left: 125px;">
				<label class="col-sm-3 control-label">铭文等级</label>
				<div class="col-sm-9">
					<input class="form-control" type="text"  name="Motto_rank" placeholder="请输入铭文等级">
				</div>
			</div>
			
			<div class="form-group" style="margin-left: 125px; margin-top: 10px;">
			    <label class="col-sm-3 control-label" for="Motto_function">铭文功能</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Motto_function" name="Motto_function" placeholder="请输入铭文功能">
			    </div>
			</div>
	
			<div class="form-group" style="padding-left: 300px;">
				<input type="submit" value="添加" class="btn btn-primary" style="width: 60px;"/>
			</div>
		</form>
	</div>
  </body>
</html>