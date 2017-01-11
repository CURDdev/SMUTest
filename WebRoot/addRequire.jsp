<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="css/metro-responsive.css">
<link rel="stylesheet" href="css/metro-schemes.css">
	<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
	<script type="text/javascript" src="js/metro.min.js"></script>
	
    <script language="javascript" type="text/javascript">
        //动态添加行与列

        function addHtml( )
        {
            var tab=document.getElementById("viewTabs"); //获得表格
            var colsNum=tab.rows.item(0).cells.length;   //表格的列数
            var num=tab.rows.length;//表格当前的行数
            var rownum=num;
            tab.insertRow(rownum);
            for(var i=0;i < colsNum; i++)
            {
                tab.rows[rownum].insertCell(i);//插入列
                tab.rows[rownum].cells[i].innerHTML="<input type='text' name='"+i+"'/>";;
            }
        }
        
        function deleteHtml( )
        {
            var tab=document.getElementById("viewTabs"); //获得表格
            var colsNum=tab.rows.item(0).cells.length;   //表格的列数
            var num=tab.rows.length;//表格当前的行数
            var rownum=num-1;
            tab.deleteRow(rownum);
        }
        
        
    function valid(){
	var part0 = "air";
	var part1 = "air";
	var part2 = "air";
	var content = document.getElementById("content");
	if(content.value == ""){
	content.value = "none";
	}
	//part0
	$("input[name='0']").each(function(){
	if($(this).val()==""){
	part0 = part0+"/" + " ";
	}
	else{
	part0 = part0+"/" + $(this).val();
	}
	});
	part0 = part0.substring(4,part0.length);
	//part1
	$("input[name='1']").each(function(){
	if($(this).val()==""){
	part1 = part1+"/" + " ";
	}
	else{
	part1 = part1+"/" + $(this).val();
	}
	});
	part1 = part1.substring(4,part1.length);
	
	
	$("input[name='2']").each(function(){
	if($(this).val()==""){
	part2 = part2+"/" + " ";
	}
	else{
	part2 = part2+"/" + $(this).val();
	}
	});
	part2 = part2.substring(4,part2.length);
	$('#part0').val(part0);
	$('#part1').val(part1);
	$('#part2').val(part2);
	return true;
	}
    </script>
</head>



<body>
<jsp:include page="admin_header.jsp"></jsp:include>
<center><h1>添加案例及要求</h1></center>
<form action="addCaseStore.action" method="post" 	enctype="multipart/form-data" onsubmit="return valid()">
<center>
<label>案例名称</label>
<input type="text" name="caseStore.CName" id="cName"/>

<br>
<h2>案例内容</h2>

<textarea rows="5" cols="40" name="caseStore.CContent" placeholder="如果没有请留空" id="content"></textarea>
</center>
<table id="viewTabs" class="table striped hovered cell-hovered border bordered">
<tbody>
<tr>
    <th width="33%"><input type="text" name="0" value ="项目名称"/></th>
    <th width="33%"><input type="text" name="1" value ="项目细节"/></th>
    <th width="33%"><input type="text" name="2" value ="该项总分"/></th>
</tr>
</tbody>
</table>
<button onclick="addHtml()" type="button">增加一行</button>
<button onclick="deleteHtml()" type="button">减少一行</button>
<hr>
<input type="hidden" id="part0" name="requirementStore.RName"/>
<input type="hidden" id="part1" name="requirementStore.RContent"/>
<input type="hidden" id="part2" name="requirementStore.RScore"/>

<center><button type="submit">确认无误，提交</button></center>
</form>
</body>
</html>