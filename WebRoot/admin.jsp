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
    <title>My JSP 'admin.jsp' starting page</title>
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
    <s:if test="#session.user==null">
    <% response.sendRedirect("login.jsp");   %>
    </s:if>
    <s:if test="#session.user.Role!='admin'">
    <% response.sendRedirect("login.jsp");   %>
    </s:if>
    <center><h2>教师管理</h2></center>
    <table class="table striped hovered cell-hovered border bordered">
      <tr>
        <td>
          <center>
            <a href="getAllTeachers.action" target="mainRight">管理教师账号</a>
          </center>
        </td>
      </tr>
    </table>
    <center><h2>学生管理</h2></center>
    <table class="table striped hovered cell-hovered border bordered">
      <tr>
        <td>
          <center>
            <a href="showTestsAndClasses.action" target="mainRight">添加学生</a>
          </center>
        </td>
      </tr>
      <tr>
        <td>
          <center>
            <a href="admin_stationMain.jsp" target="mainRight">添加临时学生</a>
          </center>
        </td>
      </tr>
    </table>
    <center><h2>成绩管理</h2></center>
    <table class="table striped hovered cell-hovered border bordered">
      <tr>
        <td>
          <center>
          <a href="showTestsAndClasses.action" target="mainRight">查看班级成绩</a>
          </center>
        </td>
      </tr>
      <tr>
        <td>
          <center>
            <a href="admin_stationMain.jsp" target="mainRight">查看毎站成绩情况</a>
          </center>
        </td>
      </tr>
    </table>
    <center><h2>题库管理</h2></center>
    <table class="table striped hovered cell-hovered border bordered">
        <td>
          <center>
          <a href="addRequire.jsp" target="mainRight">添加案例</a>
          </center>
        </td>
      </tr>
      <tr>
        <td>
          <center>
          <a href="adminShowAllCases.action" target="mainRight">修改案例</a>
          </center>
        </td>
      </tr>
    </table>
        <center><h2>考试管理</h2></center>
    <table class="table striped hovered cell-hovered border bordered">
      <tr>
        <td>
          <center>
          <a href="beginNewTest.action" target="mainRight">开始一门新的考试</a>
          </center>
        </td>
      </tr>
      <tr>
        <td>
          <center>
            <a href="getLaterTests.action" target="mainRight">查看还未开始的考试信息</a>
          </center>
        </td>
      </tr>
      <tr>
        <td>
          <center>
            <a href="adminShowTests.action" target="mainRight">查看正在进行的考试信息</a>
          </center>
        </td>
      </tr>
      <tr>
        <td>
          <center>
            <a href="getPreTests.action" target="mainRight">查看已结束的考试信息</a>
          </center>
        </td>
      </tr>
    </table>
  </body>
</html>
