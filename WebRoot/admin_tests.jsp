<%--
  Created by IntelliJ IDEA.
  User: yuxi
  Date: 2017/3/9
  Time: 上午10:28
  To change this template use File | Settings | File Templates.
--%>
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
    <title>My JSP 'menu.jsp' starting page</title>
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
<div data-role="dialog" id="dialog" class="padding20" data-close-button="true" data-type="alert">
    <h1>修改或增加考试班级</h1>
    <div id="classes">

    </div>
    <button type="button" onclick="updateOneUser()" class="button loading-pulse lighten primary">修改</button>
</div>
<table class="table striped hovered cell-hovered border bordered">
    <thead>
    <tr>
        <th>
            <center>
                <h3>
                    请选择考试
                </h3>
            </center>
        </th>
    </tr>
    </thead>
    <s:iterator value="#request.tests" id="tests">
        <tr>
            <td>
                <center><h4>
                    <a href="adminShowAllStations.action?test_id=<s:property value="#tests.testId"/>"><s:property value="#tests.testName"/></a>
                    <h5>(适用于<s:property value="#tests.className"/>)</h5>
                    <h5>开始时间：<s:property value="#tests.testBeginTime"></s:property></h5>
                    <h5>结束时间：<s:property value="#tests.testEndTime"></s:property> </h5>
                </h4>
                    <button type="button" id = "<s:property value="#tests.testId"/>" onclick="showClasses(this.id)">添加或删除考试班级</button>
                </center>
            </td>
        </tr>
    </s:iterator>
</table>
<script type="text/javascript">
    function showClasses(id) {
        $.ajax({
            //这里的需要Struts.xml的<action/>的name属性一致。
            url:'getOneTestClasses.action',
            //提交类型
            type:'POST',
            //提交数据给Action传入数据
            data:{'TId':id},
            //返回的数据类型
            dataType:'json',
            //成功是调用的方法
            success:function(data){
                var info = eval("("+data+")");
                //获取Action返回的数据用  data.Action中的属性名 获取
                var obj = document.getElementById("classes");
                obj.innerHTML = "<h1>" + info.result + "</h1>" +"<button>✘</button>";
                var dialog = $("#dialog").data('dialog');
                dialog.open();
            },
            error:function () {
                alert("服务器错误");
            }
        });
    }
</script>
</body>
</html>
