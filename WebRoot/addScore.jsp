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
    
    <title>My JSP 'addScore.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->


  </head>
  
  <body>
    <s:form action="addScore.action" method="post" 	enctype="multipart/form-data" >
    	<tr>
						<td>教师</td>
						<td><input type="text" name="score.teacher.TId"> <label>元</label></td>
					</tr>
    	<tr>
						<td>学生</td>
						<td><input type="text" name="score.student.SNo"> <label>元</label></td>
					</tr>
    	<tr>
						<td>站</td>
						<td><input type="text" name="score.station.stId"> <label>元</label></td>
					</tr>
    	<tr>
						<td>分数</td>
						<td><input type="text" name="score.scScore"> <label>元</label></td>
					</tr>
    	<tr>
						<td>总分</td>
						<td><input type="number" name="score.scTotalScore"> <label>元</label></td>
					</tr>
					<tr>
						<td>总分</td>
						<td><input type="number" name="part"> <label>元</label></td>
					</tr>
    <input type="submit" value="dsd" />
    </s:form>
  </body>
</html>
