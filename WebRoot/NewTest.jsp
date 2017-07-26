<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
    <title></title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="css/metro.css">
    <link rel="stylesheet" href="css/metro-icons.css">
    <link rel="stylesheet" href="css/metro-responsive.css">
    <link rel="stylesheet" href="css/metro-schemes.css">
	<link href="css/bootstrap.min.css" rel="stylesheet" >
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
    <link rel="stylesheet" href="css/jquery.datetimepicker.css">
    <s:head />
    <%--<sx:head />--%>

</head>
<body>
<center><h1>考试具体信息</h1></center>
<s:form action="addTest.action" method="post" enctype="multipart/form-data" onsubmit="return checkBlank()" >
<center>
<label>考试名称</label>
<input type="text" name="t.testName" id="cName"/>
<br>
<br>
<label>开始时间</label>
<input size="20" type="text" id="datetimepicker1" name="t.testBeginTime">
<label>结束时间</label>
<input size="20" type="text" id="datetimepicker2"  name="t.testEndTime">
    <br>
    <br>
    <div id="first">
    <h3 style="color: #ff2d55;">考试班级</h3>
        <br>
    &nbsp;
        <%--<select name="grade" id="selectGrade">&ndash;%&gt;--%>
        <%--<option value="2012级">2012级</option>--%>
        <%--<option value="2013级">2013级</option>--%>
        <%--<option value="2014级">2014级</option>--%>
        <%--<option value="2015级">2015级</option>--%>
        <%--<option value="2016级">2016级</option>--%>
        <%--<option value="2017级">2017级</option>--%>
        <%--<option value="2018级">2018级</option>--%>
    <%--</select>--%>
        <s:select list="#request.grades" listKey="key" listValue="value" theme="simple" id="selectGrade" name="grade"></s:select>
        <s:select list="#request.classNames" listKey="key" listValue="value" theme="simple" id="selectClass" name="className"></s:select>
    <%--<select name="className" id="selectClass">--%>
        <%--<option value="临床医学一">临床医学一</option>--%>
        <%--<option value="临床医学二">临床医学二</option>--%>
        <%--<option value="临床心理">临床心理</option>--%>
        <%--<option value="中西医临床医学">中西医临床医学</option>--%>
        <%--<option value="法医学">法医学</option>--%>
    <%--</select>--%>
    </div>
    <br>
    <button type="button" onclick="createNewClass()" class="btn btn-success">增加一个考试班级</button>
</center>
<table id="viewTabs" class="table striped hovered cell-hovered border bordered">
<thead>
<tr>
    <th width="5%">站号</th>
    <th width="20%">站的名称</th>
    <th width="75%">站的案例</th>
</tr>
</thead>
<tbody>
    <s:iterator begin="0" end="5" status="st">
    <tr>
    <td>
    <s:property value="#st.index+1"/>
    <input type="hidden" name="stNum" value="<s:property value="#st.index+1"/>"/>
    </td>
    <td>
    <input name="stName"/>
    </td>
    <td>
        <div style="float: left;">
        <s:select list="#request.cases" listKey="key" listValue="value" theme="simple" id="%{#st.index+1}1v" name="caseId"/>
        <a href=# id="<s:property value="#st.index+1"/>1" onClick="javascript:window.open('previewCase.action?c_id='+document.getElementById('<s:property value="#st.index+1"/>1v').value,'','width=632,height=388,toolbar=no, status=no, menubar=no, resizable=yes, scrollbars=yes');return false;">预览</a>
        </div>
        <input type="hidden" name="stations" value="<s:property value="#st.index+1"/>"/>
        <button type="button" class="btn btn-info" id="<s:property value="#st.index+1"/>" onclick="createSelect(this.id)">增加一个案例</button>
        <input type="hidden" value="1" id="h<s:property value="#st.index+1"/>"/>
    </td>
    </tr>
    </s:iterator>
</tbody>
</table>
<button onclick="addHtml()" type="button" class="btn btn-warning">增加一行</button>
<button onclick="deleteHtml()" type="button" class="btn btn-warning">减少一行</button>
<hr>
<center><button type="submit" class="btn btn-danger">确认无误，提交</button></center>
</s:form>
<script type="text/javascript">
    function checkBlank() {
        var name = document.getElementById("cName");
        var beginTime = document.getElementById("datetimepicker1");
        var endTime = document.getElementById("datetimepicker2");
        if(name.value == ""){
            alert("考试名称不能为空")
            return false;
        }
        if(beginTime.value == ""){
            alert("考试开始时间不能为空")
            return false;
        }
        if(endTime.value == ""){
            alert("考试结束时间不能为空")
            return false;
        }

        var tab=document.getElementById("viewTabs");
        var stNames = document.getElementsByName("stName")
        for(i = 0;i<=tab.rows.length-2;i++){
            if(stNames[i].value == ""){
                alert("有考站名称为空");
                return false;
            }
        }
        return true;
    }
</script>
<script language="javascript" type="text/javascript">
    //动态添加行与列
    function addHtml( )
    {
        var tab=document.getElementById("viewTabs"); //获得表格
        var colsNum=tab.rows.item(0).cells.length;   //表格的列数
        var num=tab.rows.length;//表格当前的行数
        var rownum=num;
        tab.insertRow(rownum);
        var s = document.getElementById("11v");
        for(var i=0;i < colsNum; i++)
        {
            tab.rows[rownum].insertCell(i);//插入列
            if(i==0){
                tab.rows[rownum].cells[i].innerHTML = num+"<input type=\"hidden\" name=\"stNum\" value=\""+num+"\"/>";
            }
            else if(i==1){
                tab.rows[rownum].cells[i].innerHTML="<input type='text' name=\"stName\"/>";
            }
            else if(i==2){

                var str ="<div style=\"float: left;\"><select id='"+num+"1v' name='caseId'>";
                for(var j = 0;j<s.options.length;j++)
                    str+= "<option value='"+s.options[j].value+"'>"+s.options[j].text;
                str+= "</select><a href=# id=\""+rownum+"1\" onClick=\"javascript:window.open('previewCase.action?c_id='+document.getElementById('"+num+"1v').value,'','width=632,height=388,toolbar=no, status=no, menubar=no, resizable=yes, scrollbars=yes');return false;\">预览</a></div><button id=\""+num+"\" onclick=\"createSelect(this.id)\" type=\"button\">增加一个案例</button><input id=\"h"+num+"\" type=\"hidden\" value=\"1\">"
                str+="<input type=\"hidden\" name=\"stations\" value=\""+rownum+"\"/>";
                tab.rows[rownum].cells[i].innerHTML = str;
            }
        }
    }
    function createNewClass() {
        var selectGrade = document.getElementById("selectGrade");
        var selectClass = document.getElementById("selectClass");
        var newNode = document.createElement("div");
        var front = document.getElementById("selectClass");
        var str = "<br><select name='grade'>";
        for(var j = 0;j<selectGrade.options.length;j++)
            str+= "<option value='"+selectGrade.options[j].value+"'>"+selectGrade.options[j].text;

        str += "</select>&nbsp;<select name='className'>";
        for(var k = 0;k<selectClass.options.length;k++)
            str+= "<option value='"+selectClass.options[k].value+"'>"+selectClass.options[k].text;
        str += "</select>";
        newNode.innerHTML=str;
        var reforeNode = document.getElementById("first");
        reforeNode.insertBefore(newNode,front.nextSibling);
    }
    function createSelect(id){
        var oTest = document.getElementById("viewTabs");
        var h = document.getElementById("h"+id);
        var newNode = document.createElement("div");
        newNode.style.float="left";
//        var reforeNode = document.getElementById(id.toString()+h.value.toString());
        var s = document.getElementById("11v");
        var hh = Number(h.value)+1;
//        alert(id.toString()+h.value.toString());
        var str= "<input type=\"hidden\" name=\"stations\" value=\""+id+"\"/>";
        str +="<select id='"+id.toString()+hh.toString()+"v' name=\"caseId\">";
        for(var j = 0;j<s.options.length;j++)
            str+= "<option value='"+s.options[j].value+"'>"+s.options[j].text;

        str+= "</select><a href=# id=\""+id.toString()+hh.toString()+"\" onClick=\"javascript:window.open('previewCase.action?c_id='+document.getElementById('"+id.toString()+hh.toString()+"v').value,'','width=632,height=388,toolbar=no, status=no, menubar=no, resizable=yes, scrollbars=yes');return false;\">预览</a>";

        newNode.innerHTML = str;
        var addButton = document.getElementById(id);
        oTest.rows[id].cells[2].insertBefore(newNode,addButton);
        h.value = Number(h.value)+1;
    }
    function deleteHtml( )
    {
        var tab=document.getElementById("viewTabs"); //获得表格
        var colsNum=tab.rows.item(0).cells.length;   //表格的列数
        var num=tab.rows.length;//表格当前的行数
        var rownum=num-1;
        tab.deleteRow(rownum);
    }

</script>
</body>
<script src="js/jquery.js"></script>
<script src="js/jquery.datetimepicker.full.js"></script>
<script type="application/javascript">
    $('#datetimepicker1').datetimepicker({
        format:"Y-m-d H:i:00",
    });
    $('#datetimepicker2').datetimepicker({
        format:"Y-m-d H:i:00",
    });
    $.datetimepicker.setLocale('ch');
</script>
</html>