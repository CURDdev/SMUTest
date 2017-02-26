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
  <jsp:include page="admin_header.jsp"></jsp:include>
  <%--<s:action name="showClasses"></s:action>--%>
   <%--<s:iterator value="#request.classes" id="class">--%>
    <%--<s:form action="browseScores.action" method="POST">--%>
    <%--<input name="class_name" value="<s:property value="#class.className"/>" type="hidden"/>--%>
    <%--<input type="submit" value="<s:property value="#class.className"/>"/>--%>
    <%--</s:form>--%>
    <%--</s:iterator>--%>
  <form action="browseScores.action" method="post" onsubmit="return valid()">
  选择考试&nbsp&nbsp<s:select list="#request.testNames" listKey="key" listValue="value" theme="simple" name="testId"></s:select>
  选择年级&nbsp&nbsp<s:select list="#request.grades" listKey="key" listValue="value" theme="simple" id = "grade"></s:select>
  选择班级&nbsp&nbsp<s:select list="#request.classNames" listKey="key" listValue="value" theme="simple" id = "class"></s:select>
      <input name="class_name" type="hidden" id="className">
      <sx:submit targets="main" value="查询"></sx:submit>
  </form>
  <div id = "main"></div>
  <script>
      function valid() {
          var className = document.getElementById("className");
          className.value = document.getElementById("grade").value + document.getElementById("class").value;
          alert(className.value);
      }
  </script>
  </body>
</html>
