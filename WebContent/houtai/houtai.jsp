<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta charset="utf-8">
    <title>主页面</title>
	</head>
	<frameset rows="15%,*" > <!--框架集。它被用来组织多个窗口（框架）。每个框架存有独立的文档。您必须使用 cols 或 rows 属性。  -->
		<frame src="up.jsp" noresize="noresize"> <!-- <frame> 标签定义 frameset 中的一个特定的窗口（框架）。 -->
		<frameset cols="15%,*">
			<frame src="left.jsp" noresize="noresize">
			<frame name="right" style="background: url(../img/孙尚香.jpg) no-repeat  ;" noresize="noresize">
		</frameset>  <!--url(../img/left.jpg) no-repeat center #24262f  -->
	</frameset>
</html>
