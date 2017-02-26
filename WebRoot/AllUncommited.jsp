<%--
  Created by IntelliJ IDEA.
  User: yuxi
  Date: 2017/2/7
  Time: 下午6:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/metro.css">
    <link rel="stylesheet" href="css/metro-icons.css">
    <link rel="stylesheet" href="css/metro-responsive.css">
    <link rel="stylesheet" href="css/metro-schemes.css">
    <script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
    <script type="text/javascript" src="js/metro.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<form action="commitScore.action" method="post">
<table class="table striped hovered cell-hovered border bordered">
    <thead>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>成绩</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
<s:iterator value="#request.scores" id="score">
    <tr>
        <td><s:property value="#score.student.SNo"></s:property></td>
        <td><s:property value="#score.scScore"></s:property></td>
        <td><s:property value="#score.scTotalScore"></s:property></td>
        <td><a href="getOneCommitedScore.action?stc_id=<s:property value="#score.scId"/>">修改</a><input type="hidden" name = "scId" value="<s:property value="#score.scId"/>"></td>
    </tr>
</s:iterator>
    </tbody>
</table>
    <input type="hidden" id="TId" name="TId" value="<s:property value="#session.user.TId"/>">
    <center>
        <button class="button loading-pulse lighten primary" type="submit" >确认无误，提交</button>
    </center>
</form>
</body>
</html>
