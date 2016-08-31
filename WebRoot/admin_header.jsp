<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'header.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/metro.min.css">
	<link rel="stylesheet" href="css/metro-icons.css">
<link rel="stylesheet" href="css/metro-responsive.css">
<link rel="stylesheet" href="css/metro-schemes.css">
	<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
	<script type="text/javascript" src="js/metro.min.js"></script>
  </head>
  
  <body>
   <div class="app-bar" data-role="appbar">
  <div class="container">
        <a class="app-bar-element branding" href="index.jsp">
<img style="height: 28px; display: inline-block; margin-right: 10px;" src="image/band.png">
南方医科大学临床技能测验系统管理员界面
</a>
        <span class="app-bar-divider"></span>
        <ul class="app-bar-menu">
        <s:if test="#session.user.Role=='admin'">
            <li><a href="logOut.action">注销</a></li>
            </s:if>
            <s:else>
             <li><a href="login.jsp">登录</a></li>
            </s:else>
            <li><a href="">支持</a></li>
            <li><a href="">帮助</a></li>
        
        </ul>
        </div>
    </div>     
  </body>
</html>
