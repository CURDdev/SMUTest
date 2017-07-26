<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showClasses.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <sx:head />
  </head>
  
  <body>
  <%--<s:action name="showClasses"></s:action>--%>
   <%--<s:iterator value="#request.classes" id="class">--%>
    <%--<s:form action="browseScores.action" method="POST">--%>
    <%--<input name="class_name" value="<s:property value="#class.className"/>" type="hidden"/>--%>
    <%--<input type="submit" value="<s:property value="#class.className"/>"/>--%>
    <%--</s:form>--%>
    <%--</s:iterator>--%>
  <form action="SumScoreToExcel.action" method="post" onsubmit="return valid()">
  选择考试&nbsp&nbsp<s:select list="#request.testNames" listKey="key" listValue="value" theme="simple" name="test_id" id="testIdSource"></s:select>
  选择年级&nbsp&nbsp<s:select list="#request.grades" listKey="key" listValue="value" theme="simple" id = "grade" headerKey="全部" headerValue="全部"></s:select>
  选择班级&nbsp&nbsp<s:select list="#request.classNames" listKey="key" listValue="value" theme="simple" id = "class" headerKey="全部" headerValue="全部"></s:select>
      <input name="class_name" type="hidden" id="className">
      <input type="submit" value="导出总分"></input>
  </form>
  <form action="getParticularScoresExcel.action" method="post" onsubmit="return addValue()">
      <input type="hidden" name="test_id" id="testId">
      <input name = "class_name" type="hidden" id="className1">
      <input type="submit" value="导出各站得分"></input>
  </form>
  <%--<form action="browseScores.action" method="post" onsubmit="return valid()">--%>
      <%--选择考试&nbsp&nbsp<s:select list="#request.testNames" listKey="key" listValue="value" theme="simple" name="testId" id="testIdSource"></s:select>--%>
      <%--选择年级&nbsp&nbsp<s:select list="#request.grades" listKey="key" listValue="value" theme="simple" id = "grade" headerKey="全部" headerValue="全部"></s:select>--%>
      <%--选择班级&nbsp&nbsp<s:select list="#request.classNames" listKey="key" listValue="value" theme="simple" id = "class" headerKey="全部" headerValue="全部"></s:select>--%>
      <%--<input name="class_name" type="hidden" id="className">--%>
      <%--<sx:submit targets="main" value="导出总分"></sx:submit>--%>
  <%--</form>--%>
  <%--<form action="browseAllCaseScores.action" method="post" onsubmit="return addValue()">--%>
      <%--<input type="hidden" name="testId" id="testId">--%>
      <%--<input name = "class_name" type="hidden" id="className1">--%>
      <%--<sx:submit targets="main" value="导出各站得分"></sx:submit>--%>
  <%--</form>--%>
  <h2 style="color: #FF0000">导出时间较长，请耐心等待，不要关闭页面</h2>
  <div id = "main"></div>
  <script>
      function addValue() {
          var testIdSource = document.getElementById("testIdSource");
          var testIdTarget = document.getElementById("testId");
          testIdTarget.value = testIdSource.value;
          var className1 = document.getElementById("className1");
          className1.value = document.getElementById("grade").value + document.getElementById("class").value;
      }
      function valid() {
          var className = document.getElementById("className");
          className.value = document.getElementById("grade").value + document.getElementById("class").value;
      }
  </script>
  </body>
</html>
