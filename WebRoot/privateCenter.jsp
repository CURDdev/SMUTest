<%--
  Created by IntelliJ IDEA.
  User: yuxi
  Date: 2017/1/19
  Time: 上午11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<table class="table">
    <thead>
    <tr>
        <th><h2 style="color: #ff2d55">您未提交的考试成绩有</h2></th>
    </tr>
    </thead>
    <tbody>
<s:iterator value="#request.tests" id="test">
    <tr>
        <td><a href="getUncommitedScore.action?TId=<s:property value="#session.user.TId"/>&sss=<s:property value="#test.testId"/>"><s:property value="#test.testName"></s:property></a></td>
    </tr>
</s:iterator>
    </tbody>
</table>
</body>
</html>
