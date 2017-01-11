<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
    <title></title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="css/metro.css">
	<link rel="stylesheet" href="css/metro-icons.css">
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<link rel="stylesheet" href="css/metro-responsive.css">
<link rel="stylesheet" href="css/metro-schemes.css">

	
	
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
                
                var str ="<select id='"+num+"1v' name='caseId'>";
                for(var j = 0;j<s.options.length;j++)
                str+= "<option value='"+s.options[j].value+"'>"+s.options[j].text;
               
                str+= "</select><a href=# id=\""+rownum+"1\" onClick=\"javascript:window.open('previewCase.action?c_id='+document.getElementById('"+num+"1v').value,'','width=632,height=388,toolbar=no, status=no, menubar=no, resizable=yes, scrollbars=yes');return false;\">预览</a><button id=\""+num+"\" onclick=\"createSelect(this.id)\" type=\"button\">增加一个案例</button><input id=\"h"+num+"\" type=\"hidden\" value=\"1\">"
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
            var str = "<select name='grade'>";
            for(var j = 0;j<selectGrade.options.length;j++)
                str+= "<option value='"+selectGrade.options[j].value+"'>"+selectGrade.options[j].text;

            str += "</select><select name='className'>";
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
            var reforeNode = document.getElementById(id.toString()+h.value.toString());
            var s = document.getElementById("11v");
            var hh = Number(h.value)+1;
            /*  alert(hh); */
            var str= "<input type=\"hidden\" name=\"stations\" value=\""+id+"\"/>";
            str +="<select id='"+id.toString()+hh.toString()+"v' name=\"caseId\">";
            for(var j = 0;j<s.options.length;j++)
                str+= "<option value='"+s.options[j].value+"'>"+s.options[j].text;
               
                str+= "</select><a href=# id=\""+id.toString()+hh.toString()+"\" onClick=\"javascript:window.open('previewCase.action?c_id='+document.getElementById('"+id.toString()+hh.toString()+"v').value,'','width=632,height=388,toolbar=no, status=no, menubar=no, resizable=yes, scrollbars=yes');return false;\">预览</a>";
               
            newNode.innerHTML = str;
            oTest.rows[id].cells[2].insertBefore(newNode,reforeNode.nextSibling);//新建的元素节点插入id为P1节点元素的后面
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
    <s:head />
<sx:head />
</head>
<body>
<jsp:include page="admin_header.jsp"></jsp:include>
<center><h1>考试具体信息</h1></center>
<form action="addTest.action" method="post" 	enctype="multipart/form-data" onsubmit="return valid()" >
<center>
<label>考试名称</label>
<input type="text" name="t.testName" id="cName"/>
<br>
<br>
<label>开始时间</label>
<input size="20" type="text" name="t.testBeginTime" readonly class="form_datetime">
<label>结束时间</label>
<input size="20" type="text"  name="t.testEndTime" readonly class="form_datetime">
<br>
    <div id="first">
<span>考试班级</span>
    <select name="grade" id="selectGrade">
        <option value="2012级">2012级</option>
        <option value="2013级">2013级</option>
        <option value="2014级">2014级</option>
        <option value="2015级">2015级</option>
        <option value="2016级">2016级</option>
        <option value="2017级">2017级</option>
        <option value="2018级">2018级</option>
    </select>
    <select name="className" id="selectClass">
        <option value="临床医学一">临床医学一</option>
        <option value="临床医学二">临床医学二</option>
        <option value="临床心理">临床心理</option>
        <option value="中西医临床医学">中西医临床医学</option>
        <option value="法医学">法医学</option>
    </select>
    </div>
    <button type="button" onclick="createNewClass()">增加一个考试班级</button>
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
    <s:iterator begin="0" end="10" status="st">
    <tr>
    <td>
    <s:property value="#st.index+1"/>
    <input type="hidden" name="stNum" value="<s:property value="#st.index+1"/>"/>
    </td>
    <td>
    <input name="stName"/>
    </td>
    <td>
    
    <s:select list="#request.cases" listKey="key" listValue="value" theme="simple" id="%{#st.index+1}1v" name="caseId"/>
    <a href=# id="<s:property value="#st.index+1"/>1" onClick="javascript:window.open('previewCase.action?c_id='+document.getElementById('<s:property value="#st.index+1"/>1v').value,'','width=632,height=388,toolbar=no, status=no, menubar=no, resizable=yes, scrollbars=yes');return false;">预览</a>
    <input type="hidden" name="stations" value="<s:property value="#st.index+1"/>"/>
    <button type="button" id="<s:property value="#st.index+1"/>" onclick="createSelect(this.id)">增加一个案例</button>
    <input type="hidden" value="1" id="h<s:property value="#st.index+1"/>"/>
    </td>
    </tr>
    </s:iterator>
</tbody>
</table>
<button onclick="addHtml()" type="button">增加一行</button>
<button onclick="deleteHtml()" type="button">减少一行</button>
<hr>
<center><button type="submit">确认无误，提交</button></center>
</form>

<!-- <div id="right" style="float:left; width:50%; height:100%;border-left:2px solid #0000FF;">
</div> -->
<script type="text/javascript" src="js/jquery-3.0.0.min.js" charset="UTF-8"></script>
	<script type="text/javascript" src="js/metro.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <script type="text/javascript">
    $(".form_datetime").datetimepicker({format: 'yyyy-mm-dd hh:ii:00'});
</script>   
</body>
</html>