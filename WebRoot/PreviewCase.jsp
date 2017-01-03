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
	part0 = part0+"," + " ";
	}
	else{
	part0 = part0+"," + $(this).val();
	}
	});
	part0 = part0.substring(4,part0.length);
	//part1
	$("input[name='1']").each(function(){
	if($(this).val()==""){
	part1 = part1+"," + " ";
	}
	else{
	part1 = part1+"," + $(this).val();
	}
	});
	part1 = part1.substring(4,part1.length);
	
	
	$("input[name='2']").each(function(){
	if($(this).val()==""){
	part2 = part2+"," + " ";
	}
	else{
	part2 = part2+"," + $(this).val();
	}
	});
	part2 = part2.substring(4,part2.length);
	$('#part0').val(part0);
	$('#part1').val(part1);
	$('#part2').val(part2);
	var v = document.getElementById("cName").value;
	$('#CName').val(v);
	return true;
	}
    </script>
</head>



<body>
<jsp:include page="header.jsp"></jsp:include>
<center><h1>添加案例及要求</h1></center>
<s:form action="adminUpdateRequirement.action" method="post" 	enctype="multipart/form-data" onsubmit="return valid()">
<center>

<h1><s:property value="#request.case.CName"/></h1>

<br>
<h2>案例内容</h2>

<textarea rows="5" cols="40" name="c.CContent" placeholder="如果没有请留空" id="content"><s:property value="#request.case.CContent"/></textarea>
</center>
<table id="viewTabs" class="table striped hovered cell-hovered border bordered">
<thead>
<tr>
 <th class="sortable-column">
   <center>
  <h3>
  <input name="0" value="<s:property value="#request.RName"/>">
  </h3>
  </center>
  </th>
  <th class="sortable-column">
   <center>
  <h3>
  <input name="1" value="<s:property value="#request.RContent"/>">
  </h3>
  </center>
  </th>
  
 <th class="sortable-column">
  <h3>
  <input name="2" value="<s:property value="#request.RScore"/>">
  </h3>
  </th>
  </tr>
</thead>
<tbody>
<s:iterator value="#request.require" id="require" status="st">
   <tr>
   <td>
    <input name="0" value="<s:property value="#require.name"/>">
   </td>
   <td>
    <input name="1" value="<s:property value="#require.content"/>">
   </td>
   <td>
    <input name="2" value="<s:property value="#require.score"/>">
   </td>
   </tr>
   </s:iterator>
</tbody>
</table>
<button onclick="addHtml()" type="button">增加一行</button>
<button onclick="deleteHtml()" type="button">减少一行</button>
<hr>
<input type="hidden" id="CName" name="requirement.CName.CName"/>
<input type="hidden" name="c_name" value="<s:property value="#request.case.CName"/>"/>
<input type="hidden" id="part0" name="requirement.RName"/>
<input type="hidden" id="part1" name="requirement.RContent"/>
<input type="hidden" id="part2" name="requirement.RScore"/>

<center><button type="submit">确认无误，提交</button></center>
</s:form>
</body>
</html>