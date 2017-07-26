<%--
  Created by IntelliJ IDEA.
  User: yuxi
  Date: 2017/4/10
  Time: 下午3:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>My JSP 'main.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>
<frameset rows="8%,*" border= "7"  framespacing= "0 " frameborder="1"  bordercolor= "#CADAE8 " >
    <frame src="admin_header.jsp">
    <frameset cols="15%,*">
        <frame src="admin.jsp">
        <frame src="adminMainLeft.jsp" name="mainRight">
    </frameset>

</frameset>
<body>
This is my JSP page. <br>
</body>
</html>

