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
    <script type="text/javascript">
        function deleteOneCase(value,indexToBedeleted) {
            var con = confirm("确定要删除？");
            if(con == false){
                return;
            }
            $.ajax({
                //这里的需要Struts.xml的<action/>的name属性一致。
                url:'deleteOneCase.action',
                //提交类型
                type:'POST',
                //提交数据给Action传入数据
                data:{'c_id':value},
                //返回的数据类型
                dataType:'json',
                //成功是调用的方法
                success:function(data){
                    //获取Action返回的数据用  data.Action中的属性名 获取
                    alert("删除成功")
                    var tab = document.getElementById("tab");
                    tab.deleteRow(indexToBedeleted+1);
                },
                error:function () {
                    alert("错误")
                }
            });
        }
    </script>
</head>
<body>
<table class="table striped hovered cell-hovered border bordered" id="tab">
    <thead>
    <tr>
        <th>
            <center>
                <h3>
                    请选择案例
                </h3>
            </center>
        </th>

    </tr>
    </thead>
    <s:iterator value="#request.cases" id="case" status="st">
        <tr>
            <td>
                <center><h4>

                    <a href="adminShowOneCase.action?c_id=<s:property value="#case.CId"/>"><s:property value="#case.CName"/></a>
                    <br>
                    <button onclick="deleteOneCase(<s:property value="#case.CId"/>,<s:property value="#st.index"/>)">删除</button>
                </h4>
                </center>
            </td>
        </tr>
    </s:iterator>
</table>
</body>
</html>
