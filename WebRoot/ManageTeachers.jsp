<%--
  Created by IntelliJ IDEA.
  User: yuxi
  Date: 2017/4/22
  Time: 下午2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
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
    <s:head/>
</head>
<body>
    <div data-role="dialog" id="dialog" class="padding20" data-close-button="true" data-type="alert">
        <h1>请输入新增教师信息</h1>
        <div class="input-control text info">
            <label>教师 ID</label>
            <input  id="TId" type="text" style="color:#FF0000;" onchange="checkTeacher()">
        </div>
        <div class="input-control text info">
            <label>密码</label>
            <input  id="TPassword" type="text" style="color:#FF0000;">
        </div>
        <div class="input-control text info">
            <label>教师姓名</label>
            <input  id="TName" type="text" style="color:#FF0000;">
        </div>
        <button type="button" onclick="commitNewTeacher()" class="button loading-pulse lighten primary">提交</button>
    </div>
    <div data-role="dialog" id="dialog1" class="padding20" data-close-button="true" data-type="alert">
        <h1>修改教师信息</h1>
        <div class="input-control text info">
            <label>教师 ID</label>
            <h3 id="teacherID"></h3>
        </div>
        <div class="input-control text info">
            <label>教师姓名</label>
            <input  id="updateTName" type="text" style="color:#FF0000;">
        </div>
        <button type="button" onclick="updateOneUser()" class="button loading-pulse lighten primary">修改</button>
    </div>
    <center><h1>教师管理</h1></center>
    <table class="table striped hovered cell-hovered border bordered" id="table">
        <thead>
            <tr>
                <th>
                    <h2>登录 ID</h2>
                </th>
                <th>
                    <h2>教师姓名</h2>
                </th>
                <th>
                    <h2>操作</h2>
                </th>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="#request.userInfos" id="userInfo">
                <tr>
                    <td>
                        <h3 id="TId<s:property value="#userInfo.teacherId"/>"><s:property value="#userInfo.teacherId"></s:property></h3>
                    </td>
                    <td>
                        <h3 id="TName<s:property value="#userInfo.teacherId"/>"><s:property value="#userInfo.teacherName"></s:property></h3>
                    </td>
                    <td>
                        <%--<button class="button danger" id="<s:property value="#st.index"/>" onclick="deleteOneUser(this.id)">删除</button>--%>
                            <button class="button danger" id="<s:property value="#userInfo.teacherId"/>" onclick="update(this.id)">修改</button>
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
    <button class="button primary" onclick="addOneUser()">增加一名用户</button>
    <script type="text/javascript">
        function commitNewTeacher() {
            $.ajax({
                //这里的需要Struts.xml的<action/>的name属性一致。
                url:'addOneTeacher.action',
                //提交类型
                type:'POST',
                //提交数据给Action传入数据
                data:{'teacher.TId':document.getElementById("TId").value,'teacher.TName':document.getElementById("TName").value,'teacher.TPassword':document.getElementById("TPassword").value},
                //返回的数据类型
                dataType:'json',
                //成功是调用的方法
                success:function(data){
                    var info = eval("("+data+")");
                    //获取Action返回的数据用  data.Action中的属性名 获取
                    if(info.result == "ok") {
                        alert("添加成功");
                        afterAddChangeTable(document.getElementById("TId").value,document.getElementById("TName").value);
                        document.getElementById("TId").value = "";
                        document.getElementById("TName").value = "";
                        document.getElementById("TPassword").value = "";
                        var dialog = $("#dialog").data('dialog');
                        dialog.close();
                    }
                },
                error:function () {
                    alert("服务器错误");
                }
            });
        }
        function checkTeacher() {
            $.ajax({
                //这里的需要Struts.xml的<action/>的name属性一致。
                url:'checkTeacherId.action',
                //提交类型
                type:'POST',
                //提交数据给Action传入数据
                data:{'TId':document.getElementById("TId").value},
                //返回的数据类型
                dataType:'json',
                //成功是调用的方法
                success:function(data){
                    var info = eval("("+data+")");
                    //获取Action返回的数据用  data.Action中的属性名 获取
                    if(info.result == "alreadyHad") {
                        alert("已经有相同 ID,请重新给出 ID");
                        document.getElementById("TId").value = "";
                    }
                },
                error:function () {
                    alert("服务器错误");
                }
            });
        }
        function afterAddChangeTable(TId,TName) {
            var table = document.getElementById("table");
            var rowsNum = table.rows.length;
            var colsNum = table.rows.item(0).cells.length;   //表格的列数
            table.insertRow(rowsNum);
            for(var i = 0;i < colsNum; i++)
            {
                table.rows[rowsNum].insertCell(i);//插入列
                if(i == 0){
                    table.rows[rowsNum].cells[i].innerHTML = "<h3 id=\"TId"+ document.getElementById("TId").value +"\">"+ TId+"</h3>";
                }
                else if(i == 1){
                    table.rows[rowsNum].cells[i].innerHTML = "<h3 id=\"TName"+ document.getElementById("TId").value +"\">"+ TName+"</h3>";
                }
                else
                {
                    table.rows[rowsNum].cells[i].innerHTML = "<button class=\"button danger\" id=\""+document.getElementById("TId").value +"\" onclick=\"update(this.id)\">修改</button>"
                }
            }
        }
        function addOneUser() {
            var dialog = $("#dialog").data('dialog');
            dialog.open();
        }
        function deleteOneUser(id) {
            var index = event.srcElement.parentElement.parentElement.rowIndex;
            var con = confirm("确定要删除？");
            if(con == false){
                return;
            }
            $.ajax({
                //这里的需要Struts.xml的<action/>的name属性一致。
                url:'deleteOneTeacher.action',
                //提交类型
                type:'POST',
                //提交数据给Action传入数据

                data:{'TId':document.getElementById("TId"+id).textContent},
                //返回的数据类型
                dataType:'json',
                //成功是调用的方法
                success:function(data){
                    //获取Action返回的数据用  data.Action中的属性名 获取
                    var info = eval("("+data+")");
                    if(info.result == "ok") {
                        alert("删除成功");
                        var tab = document.getElementById("table");
                        tab.deleteRow(index );
                    }
                },
                error:function () {
                    alert("错误")
                }
            });
        }
        function update(id) {
            document.getElementById("teacherID").textContent = document.getElementById("TId"+id).textContent;
            var dialog = $("#dialog1").data('dialog');
            dialog.open();
        }
        function updateOneUser() {
            $.ajax({
                //这里的需要Struts.xml的<action/>的name属性一致。
                url:'updateOneTeacherName.action',
                //提交类型
                type:'POST',
                //提交数据给Action传入数据

                data:{'TId':document.getElementById("teacherID").textContent,'TName':document.getElementById("updateTName").value},
                //返回的数据类型
                dataType:'json',
                //成功是调用的方法
                success:function(data){
                    //获取Action返回的数据用  data.Action中的属性名 获取
                    var info = eval("("+data+")");
                    if(info.result == "ok") {
                        alert("修改成功");
                        var dialog = $("#dialog1").data('dialog');
                        dialog.close();
                        document.getElementById("TName"+document.getElementById("teacherID").textContent).textContent = document.getElementById("updateTName").value;
                    }
                },
                error:function () {
                    alert("错误")
                }
            });
        }
    </script>
</body>
</html>
