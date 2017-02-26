<%--
  Created by IntelliJ IDEA.
  User: yuxi
  Date: 2017/2/25
  Time: 下午4:28
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
<jsp:include page="admin_header.jsp"></jsp:include>
<table class="table striped hovered cell-hovered border bordered">
    <thead>
    <tr>
        <th>
            <center>
                <h3>
                    请选择您负责的站目
                </h3>
            </center>
        </th>

    </tr>
    </thead>
    <s:iterator value="#request.cases" id="case">
        <tr>
            <td>
                <center><h4>

                    <a href="adminShowOneCase.action?c_id=<s:property value="#case.CId"/>"><s:property value="#case.CName"/></a>

                </h4>
                </center>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
