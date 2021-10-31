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
	<script type="text/javascript">
		function check() {
			var nums = document.getElementsByName("mottoname");
			int num=0;
			for(var i = 0;i<nums.length;i++){
				if(nums[i].checked == true){
					num++;
				}
			}
			if(num>5){
				alert("铭文数量超过五个！");
				document.getElementById("mottoname").focus();
				return false;
			}else{
				return true;
			}
		}
	
	</script>	
    <title>英雄信息添加界面</title>
	<style type="text/css">
		.form-control{
			width: 150px;
		}
	</style>
  </head>
  <body style="background: url(../img/孙尚香.jpg) no-repeat">

	<div class="container" style="margin-left: 300px; margin-top: 100px;width: 700px; height: 400px;  ">
		<form action="${pageContext.request.contextPath}/registerServlet?method=add" method="post" class="form-horizontal" onsubmit="return check()">
			<div class="form-group" style="margin-left: 125px; margin-top: 10px;">
			    <label class="col-sm-3 control-label" for="Hero_name" style="color: white;">英雄名称</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Hero_name" name="Hero_name" placeholder="请输入英雄名">
			    </div>
			  </div>
			
			<div class="form-group" style="margin-left: 125px;">
				<label class="col-sm-3 control-label" style="color: white;">英雄生命值</label>
				<div class="col-sm-9">
					<input class="form-control" type="text"  name="Hero_health" placeholder="请输入生命值">
				</div>
			</div>
			
			<div class="form-group" style="margin-left: 125px; margin-top: 10px;">
			    <label class="col-sm-3 control-label" for="Hero_mana" style="color: white;">英雄法力值</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Hero_mana" name="Hero_mana" placeholder="请输入法力值">
			    </div>
			  </div>
			
			<div class="form-group" style="margin-left: 125px; margin-top: 10px;">
			    <label class="col-sm-3 control-label" for="Hero_as" style="color: white;">英雄攻击速度</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Hero_as" name="Hero_as" placeholder="请输入攻速">
			    </div>
			  </div>
			  
			<div class="form-group" style="margin-left: 125px;">
			    <label class="col-sm-3 control-label" for="Hero_ac" style="color: white;">英雄防御力</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Hero_ac" name="Hero_ac" placeholder="请输入防御力">
			    </div>
			</div>
  
			<div class="form-group" style="margin-left: 125px;">
				<label class="col-sm-3 control-label" style="color: white;">皮肤名称</label>
				<div class="col-sm-9" style="color: pink;">
				  <input type="checkbox" id="skinname" name="skinname" value="苍穹之光">苍穹之光
			      <input type="checkbox" id="skinname" name="skinname" value="电玩小子">电玩小子
			      <input type="checkbox" id="skinname" name="skinname" value="暗夜猫娘">暗夜猫娘
			      <input type="checkbox" id="skinname" name="skinname" value="末日机甲">末日机甲
			      <input type="checkbox" id="skinname" name="skinname" value="海洋之心">海洋之心<br />
			    </div>
		     </div>
			
			<div  style="margin-left: 125px;">
			    <label class="col-sm-3 control-label" for="mottoname" style="color: white;">&nbsp;铭文名称</label>
			    <div class="col-sm-9" style="color: pink;">
			      <input type="checkbox" id="mottoname" name="mottoname" value="回声">回声
			      <input type="checkbox" id="mottoname" name="mottoname" value="敬畏">敬畏
			      <input type="checkbox" id="mottoname" name="mottoname" value="怜悯">怜悯
			      <input type="checkbox" id="mottoname" name="mottoname" value="心眼">心眼
			      <input type="checkbox" id="mottoname" name="mottoname" value="鹰眼">鹰眼
			      <input type="checkbox" id="mottoname" name="mottoname" value="虚空">虚空
			      <input type="checkbox" id="mottoname" name="mottoname" value="轮回">轮回
			      <input type="checkbox" id="mottoname" name="mottoname" value="狩猎">狩猎
			    </div>
			</div>
	</div> 
	
			<div class="form-group" style="padding-left: 600px;">
				<input type="submit" value="添加" class="btn btn-primary" style="width: 60px;"/>
			</div>
		</form>
	</div>
  </body>
</html>