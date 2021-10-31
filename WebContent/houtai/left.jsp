<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css"/>
	<script src="../js/jquery-3.4.1.js" ></script>	
	<script src="../js/bootstrap.min.js" ></script>
	<script type="text/javascript"> 
		function displaySubMenu(li) { 
		var subMenu = li.getElementsByTagName("ul")[0]; 
		subMenu.style.display = "block"; 
		} 
		function hideSubMenu(li) { 
		var subMenu = li.getElementsByTagName("ul")[0]; 
		subMenu.style.display = "none"; 
		} 
		function showUl(t){
			$(t).next().toggle();
		};
		//$(".ul_div").click(function(){
		//	$(this).next().show();
		//});
	</script> 	
    <title>导航条</title>
	<style type="text/css">
	
		.form-control{
			width: 125px;
		}
		.ul_div{
			width:100%;
			height: 30px;
			padding-left:30px;
			font-size: 17px;
			cursor: pointer;
			line-height: 30px;
		}
		ul{
			display:none;
		}
		a{
			color: #999999;
		}
	</style>
	</head>
<body style="background: rgb(40,52,48);color: rgba(255,255,255,0.8);">

<div>
	<div class="ul_div" onclick="showUl(this)">
		<span class="glyphicon glyphicon-user" style="margin-right: 10px;"></span>
		英雄管理
	</div>
	<ul class="nav nav-pills nav-stacked" style="text-align: center;">
  		<li role="presentation"><a href="HeroAdd.jsp" target="right">添加英雄信息</a></li>
  		<li role="presentation"><a href="findHero.jsp" target="right">查询英雄信息</a></li>
  		<li role="presentation"><a href="update.jsp" target="right">修改英雄信息</a></li>
  		<li role="presentation"><a href="update.jsp" target="right">删除英雄信息</a></li>
  		<li role="presentation"><a href="${pageContext.request.contextPath}/searchAllServlet?method=search" target="right">查看英雄信息</a></li>
	</ul> <!-- 无序列表 -->
	
</div>
	<div>
	<div class="ul_div" onclick="showUl(this)">
		<span class="glyphicon glyphicon-list-alt" style="margin-right: 10px;"></span>
		皮肤管理
	</div>
	<ul class="nav nav-pills nav-stacked" style="text-align: center;">
  		<li role="presentation"><a href="SkinAdd.jsp" target="right">添加皮肤信息</a></li>
  		<li role="presentation"><a href="findSkin.jsp" target="right">查询皮肤信息</a></li>
  		<li role="presentation"><a href="update3.jsp" target="right">修改皮肤信息</a></li>
  		<li role="presentation"><a href="update3.jsp" target="right">删除皮肤信息</a></li>
  		<li role="presentation"><a href="${pageContext.request.contextPath}/SkinSearchServlet?method=search1" target="right">查看皮肤信息</a></li>
	</ul>
	</div>
	<div>
	<div class="ul_div" onclick="showUl(this)">
		<span class="glyphicon glyphicon-bookmark" style="margin-right: 10px;"></span>
		铭文管理
	</div>
	<ul class="nav nav-pills nav-stacked" style="text-align: center;">
  		<li role="presentation"><a href="MottoAdd.jsp" target="right">添加铭文信息</a></li>
  		<li role="presentation"><a href="findMotto.jsp" target="right">查询铭文信息</a></li>
  		<li role="presentation"><a href="update5.jsp" target="right">修改铭文信息</a></li>
  		<li role="presentation"><a href="update5.jsp" target="right">删除铭文信息</a></li>
  		<li role="presentation"><a href="${pageContext.request.contextPath}/MottoSearchServlet?method=search2" target="right">查看铭文信息</a></li>
	</ul>
	</div>
</body>
</html>
