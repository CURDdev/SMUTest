<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'admin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <%--<sx:head />--%>
  </head>
  
  <body>
  <jsp:include page="admin_header.jsp"></jsp:include>
  
  <s:if test="#session.user==null">
  <% response.sendRedirect("login.jsp");   %>
  </s:if>
  <s:if test="#session.user.Role!='admin'">
  <% response.sendRedirect("login.jsp");   %>
  </s:if>
  <%--<div style="width:10%; float:left;">--%>
  <table class="table striped hovered cell-hovered border bordered">
  <tr>
  <td>
    <a href="showTestsAndClasses.action">查看班级成绩</a>
    </td>
    </tr>
    <tr>
    <td>
    <a href="admin_stationMain.jsp">查看毎站成绩情况</a>
    </td>
    </tr>
     <tr>
    <td>
    <a href="admin_main.jsp">查看站目信息</a>
    </td>
    </tr>
     <tr>
    <td>
    <a href="addRequire.jsp">添加案例</a>
    </td>
    </tr>
    <tr>
      <td>
        <a href="adminShowAllCases.action">修改案例</a>
      </td>
    </tr>
    <tr>
    <td>
    <a href="beginNewTest.action">开始一门新的考试</a>
    </td>
    </tr>
    </table>
  <%--</div>--%>
  <%--<sx:div cssStyle="width:90%; float:left;" id = "main">--%>
  <%--</sx:div>--%>

  </body>
</html>
