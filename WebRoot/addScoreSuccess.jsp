<%--
  Created by IntelliJ IDEA.
  User: yuxi
  Date: 2017/4/25
  Time: 下午10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body onload="Load('showOneCase.action')">
    <h1>提交成功，一秒后跳转到考试界面</h1>
    <input type="hidden" value="<s:property value="#request.CId"/>" id = "c_id">
    <input type="hidden" value="<s:property value="#request.TId"/>" id = "t_id">
    <script language="javascript">
        var secs = 2; //倒计时的秒数
        var URL ;
        function Load(url){
            URL = url + "?c_id=" + document.getElementById("c_id").value + "&" + document.getElementById("t_id").value;
            for(var i=secs;i>=0;i--)
            {
                window.setTimeout('doUpdate(' + i + ')', (secs-i) * 1000);
            }
        }
        function doUpdate(num)
        {
            if(num == 0) { window.location = URL; }
        }
    </script>
</body>
</html>
