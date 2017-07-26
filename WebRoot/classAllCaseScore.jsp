<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'index.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="css/metro.css">
    <link rel="stylesheet" href="css/metro-icons.css">
    <link rel="stylesheet" href="css/metro-responsive.css">
    <link rel="stylesheet" href="css/metro-schemes.css">
    <script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
    <script type="text/javascript" src="js/metro.min.js"></script>
</head>
<body>
<center>
    <h1>详细成绩一览</h1>
    <s:form action="AllScoreToExcel.action" method="post">
        <input type="hidden" value="<s:property value="#request.testId"/>" name = "test_id">
        <input type="hidden" value="<s:property value="#request.class_name"/>" name="class_name">
        <input type="submit"  class="button loading-pulse lighten primary" value="点击导出Excel">
    </s:form>
    <br>
</center>
<table class="table striped hovered cell-hovered border bordered">
    <thead>
    <tr>
        <th class="sortable-column">
            <center>
                <h3>
                    学号
                </h3>
            </center>
        </th>
        <th class="sortable-column">
            <center>
                <h3>
                    姓名
                </h3>
            </center>
        </th>

        <th class="sortable-column">
            <center>
                <h3>
                    年级
                </h3>
            </center>
        </th>
        <th class="sortable-column">
            <center>
                <h3>
                    班级
                </h3>
            </center>
        </th>
        <th class="sortable-column">
            <center>
                <h3>
                    站名
                </h3>
            </center>
        </th>
        <th class="sortable-column">
            <center>
                <h3>
                    案例名
                </h3>
            </center>
        </th>
        <th class="sortable-column">
            <center>
                <h3>
                    打分老师姓名
                </h3>
            </center>
        </th>
        <th class="sortable-column">
            <center>
                <h3>
                    成绩
                </h3>
            </center>
        </th>
    </tr>
    </thead>

    <s:iterator value="#request.studentScore" id="studentScore">
        <tr>
            <td>
                <s:property value="#studentScore.SNo"/>
            </td>
            <td>
                <s:property value="#studentScore.SName"/>
            </td>SN
            <td>
                <s:property value="#studentScore.SGrade"/>
            </td>
            <td>
                <s:property value="#studentScore.SClass"/>
            </td>
            <td>
                <s:property value="#studentScore.stationName"/>
            </td>
            <td>
                <s:property value="#studentScore.CaseName"/>
            </td>
            <td>
                <s:property value="#studentScore.TName"/>
            </td>
            <td>
                <s:property value="#studentScore.score"/>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>