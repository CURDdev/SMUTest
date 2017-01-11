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
    
    <title>My JSP 'case.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/metro.css">
	<link rel="stylesheet" href="css/metro-icons.css">
<link rel="stylesheet" href="css/metro-responsive.css">
<link rel="stylesheet" href="css/metro-schemes.css">
	<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
	<script type="text/javascript" src="js/metro.min.js"></script>

  </head>
           
  <body>
 
  	<jsp:include page="header.jsp"></jsp:include>

  <table class="table striped hovered cell-hovered border bordered">
  <thead>
  <tr>
 <th>
  <center>
  <h3>
  请选择案例
  </h3>
  </center>
  </th>
  
  </tr>
  </thead>
   <s:iterator value="#request.cases" id="case">
   <tr>
   <td>
   <center>
 
   
  <%--  <s:a href="showOneCase.action?c_id=<s:property value="#case.CName"/>"><s:property value="#case.CName"/></s:a> --%>
   <s:form action="showOneCase.action">
   <input name="c_id" type="hidden" value="<s:property value="#case.CId"/>">
       <input name="t_id" type="hidden" value="<s:property value="#request.t_id"/>">
   <input type="submit" value="<s:property value="#case.CName"/>">
   </s:form>
   
   </center>
   </td>
   </tr>
   </s:iterator>
   </table>
  </body>
</html>
