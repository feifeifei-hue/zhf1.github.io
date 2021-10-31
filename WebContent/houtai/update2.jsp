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
    <script type="text/javascript">
		function check() {
			var nums = document.getElementsByName("mottoname");
			num=0;
			for(var i = 0;i<nums.length;i++){
				if(nums[i].checked == true){
					num++;
				}
			}
			if(num>5){
				alert("铭文数超过五个");
				document.getElementById("mottoname").focus();
				return false;
			}else{
				return true;
			}
		}
	
	</script>
<title>英雄信息显示</title>
</head>
<body style="background: url(../img/孙尚香.jpg) no-repeat">
<div class="container-fluid" style="margin-top: 15px;">
<form action="${pageContext.request.contextPath}/findHeroServlet?method=updatefind" method="post" >
	<div class="form-group row">
		<div class="col-sm-5">
		<label for="Hero_name" class="col-sm-5" style="text-align: center; margin-top: 7px; color: white;">请输入英雄名称:</label>
		<div class="col-sm-4">
			<input type="text" name="Hero_name" class="form-control" placeholder="请输入英雄名">
		</div>
		</div>
		
		<div class="col-sm-3" >
			<input type="submit" value="查询" class="btn btn-primary" style="width: 60px;"/>
		</div>
		
		</div>
</form>
</div>

<div class="container" style="margin-left: 250px; margin-top: 100px;width: 700px; height: 400px;  ">
		<form action="${pageContext.request.contextPath}/updateServlet?method=update" method="post" class="form-horizontal" onsubmit="return check()">
			<div class="form-group" style="margin-left: 125px; margin-top: 10px;">
			    <label class="col-sm-3 control-label" for="Hero_name" style="color: white;">英雄名称</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Hero_name" name="Hero_name" value="${hero.getHeroname()}" readonly="readonly">
			    </div>
			</div>
			
			<div class="form-group" style="margin-left: 125px;">
				<label class="col-sm-3 control-label" for="sex" style="color: white;">英雄生命值</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Hero_health" name="Hero_health" value="${hero.getHerohealth()}">
			    </div>
			</div>
			
			<div class="form-group" style="margin-left: 125px; margin-top: 10px;">
			    <label class="col-sm-3 control-label" for="Hero_mana" style="color: white;">英雄法力值</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Hero_mana" name="Hero_mana" value="${hero.getHeromana()}">
			    </div>
			  </div>
			
			<div class="form-group" style="margin-left: 125px; margin-top: 10px;">
			    <label class="col-sm-3 control-label" for="Hero_as" style="color: white;">英雄攻击速度</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Hero_as" name="Hero_as" value="${hero.getHeroas()}">
			    </div>
			  </div>
			  
			<div class="form-group" style="margin-left: 125px;">
			    <label class="col-sm-3 control-label" for="Hero_ac" style="color: white;">英雄防御力</label>
			    <div class="col-sm-9">
			      <input class="form-control" type="text" id="Hero_ac" name="Hero_ac" value="${hero.getHeroac()}">
			    </div>
			  </div>
			<div class="form-group" style="margin-left: 125px;">
				<label class="col-sm-3 control-label" for="skinname" style="color: black;">皮肤名称</label>
			    <div class="col-sm-9" style="color: white;">
			      <input type="checkbox" id="skinname" name="skinname" value="苍穹之光">苍穹之光
			      <input type="checkbox" id="skinname" name="skinname" value="电玩小子">电玩小子
			      <input type="checkbox" id="skinname" name="skinname" value="暗夜猫娘">暗夜猫娘
			      <input type="checkbox" id="skinname" name="skinname" value="末日机甲">末日机甲
			      <input type="checkbox" id="skinname" name="skinname" value="海洋之心">海洋之心
			      <br />
			    </div>
			</div>
			<div  style="margin-left: 125px;color: black;">
			    <label class="col-sm-3 control-label" for="mottoname" style="color: black;">铭文名称</label>
			    <div class="col-sm-9">
			      <input type="checkbox" id="mottoname" name="mottoname" value="回声">回声
			      <input type="checkbox" id="mottoname" name="mottoname" value="敬畏">敬畏
			      <input type="checkbox" id="mottoname" name="mottoname" value="怜悯">怜悯
			      <input type="checkbox" id="mottoname" name="mottoname" value="心眼">心眼
			      <input type="checkbox" id="mottoname" name="mottoname" value="鹰眼">鹰眼
			      <input type="checkbox" id="mottoname" name="mottoname" value="虚空">虚空
			      <input type="checkbox" id="mottoname" name="mottoname" value="轮回">轮回
			      <input type="checkbox" id="mottoname" name="mottoname" value="狩猎">狩猎
			      <br /><br />
			    </div>
			</div>
			<div class="form-group" style="padding-left: 400px;">
				<input type="submit" value="更新" class="btn btn-primary" style="width: 60px;"/>
				&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/deleteServlet?Hero_name=${hero.getHeroname()}&method=delete" onclick="queren()">删除</a>
			</div>
		</form>
</div>
</body>
</html>