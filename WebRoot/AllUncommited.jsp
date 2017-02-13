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
        <td><a href="#">修改</a></td>
    </tr>
</s:iterator>
    </tbody>
    <script>
        /** 最终提交一名*/
        function commit() {
            $.ajax({
                //这里的需要Struts.xml的<action/>的name属性一致。
                url:'checkStudent.action',
                //提交类型
                type:'POST',
                //提交数据给Action传入数据
                data:{'s_no':value},
                //返回的数据类型
                dataType:'json',
                //成功是调用的方法
                success:function(data){

                },
                error:function () {
                    alert("错误")
                }
            });
        }
    </script>
</body>
</html>
