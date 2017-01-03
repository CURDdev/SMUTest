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
    
    <title>My JSP 'caseMain.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/metro.css">
	<link rel="stylesheet" href="css/metro-icons.css">
	<link href="css/mobiscroll.animation.css" rel="stylesheet" type="text/css" />
    <link href="css/mobiscroll.icons.css" rel="stylesheet" type="text/css" />
    <link href="css/mobiscroll.frame.css" rel="stylesheet" type="text/css" />
   
    <link href="css/mobiscroll.frame.ios.css" rel="stylesheet" type="text/css" />
    
  
    <link href="css/mobiscroll.scroller.css" rel="stylesheet" type="text/css" />
 
    <link href="css/mobiscroll.scroller.ios.css" rel="stylesheet" type="text/css" />
  
    <link href="css/mobiscroll.image.css" rel="stylesheet" type="text/css" />


    <style type="text/css">
    body {
        padding: 1em;
        margin: 0;
        font-size: 16px;
        font-family: arial, verdana, sans-serif;
    }
    
    input,
    select {
        width: 100%;
        padding: .625em;
        margin: 0 0 .625em 0;
        border: 1px solid #aaa;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;

    }
    </style>
<link rel="stylesheet" href="css/metro-responsive.css">
<link rel="stylesheet" href="css/metro-schemes.css">
	<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
	<script type="text/javascript" src="js/metro.min.js"></script>
	<script type="text/javascript">
	
	 function showDialog(id){
            var dialog = $("#"+id).data('dialog');
            if (!dialog.element.data('opened')) {
                dialog.open();
            } else {
                dialog.close();
            }
        }
        
	function check(){
	var no = $("#student").val();
	
	$.ajax({ 
        //这里的需要Struts.xml的<action/>的name属性一致。
       url:'checkStudent.action',
       //提交类型
       type:'POST', 
       //提交数据给Action传入数据 
       data:{'s_no':no}, 
       //返回的数据类型
       dataType:'json', 
       //成功是调用的方法
       success:function(data){ 
       //获取Action返回的数据用  data.Action中的属性名 获取
          if(data =="false")
          {
          showDialog(dialog);
          }
          }  
     });
	
	}</script>
  </head>
  
  <body>
   <jsp:include page="header.jsp"></jsp:include>
   <div hidden="true">
        <label for="theme">Theme</label>
        <select name="theme" id="theme" class="settings" >
            
        </select>
    </div>
   <center>
   <h2>案例内容</h2>
    <h4><s:property value="#request.case.CContent"/></h4>
    <a href="showCases.action?stc_id=<s:property value="#request.stId"/>">更换案例</a>
   </center>
  
<div data-role="dialog" id="dialog" class="padding20" data-close-button="true" data-type="alert">
            <h1>提示信息</h1>
            <p>
                没有查询到该学号，请确认是否输入错误
            </p>
        </div>
        <div data-role="dialog" id="dialog1" class="padding20" data-close-button="true" data-type="alert">
            <h1>提示信息</h1>
            <p>
                有评分项未输入
            </p>
        </div>
<script>
    function showDialog(id){
        var dialog = $(id).data('dialog');
        dialog.open();
    }
</script>
<s:form action="addScore1.action" method="post" 	enctype="multipart/form-data" onsubmit="return valid()">
<center>
 <h3 style="color:red">请输入考生学号</h3>
 <div class="input-control text error" style="width:30%" >
   <input type="text"  class="input" id="student" onblur="check()" name="score.student.SNo"/>
  </div>
 
    </center>
    <table class="table striped hovered cell-hovered border bordered">
  <thead>
  <tr>
 <th class="sortable-column">
   <center>
  <h3>
  <s:property value="#request.RName"/>
  </h3>
  </center>
  </th>
  <th class="sortable-column">
   <center>
  <h3>
  <s:property value="#request.RContent"/>
  </h3>
  </center>
  </th>
  
 <th class="sortable-column">
  <h3>
  <s:property value="#request.RScore"/>
  </h3>
  </th>
  <th class="sortable-column">
  <h3>
  打分
  </h3>
  </th>
  </tr>
  </thead>
  
    
   <s:iterator value="#request.require" id="require" status="st">
   <tr>
   <td>
   <s:property value="#require.name"/>
   </td>
   <td>
   <s:property value="#require.content"/>
   </td>
   <td>
   <s:property value="#require.score"/>
   </td>
   <td>
   <div class="input-control text info">
   <input type="number" name="part"/>
   </div>
   </td>
   </tr>
   </s:iterator>
  
    </table>
    
   <input type="hidden" id="score" name="score.scScore">
   <input type="hidden" id="totalScore" name="score.scTotalScore">
   <input type="hidden" id="stId" name="score.station.stId" value="<s:property value="#request.stId"/>">
   <input type="hidden" id="CId" name="c_id" value="<s:property value="#request.CId"/>">
   <input type="hidden" id="TId" name="score.teacher.TId" value="<s:property value="#session.user.TId"/>">
   <center>
   <button class="button loading-pulse lighten primary" type="submit" >确认无误，提交</button>
   </center>
    </s:form>
    <script type="text/javascript">
    function valid(){
	var score = "air";
	var totalScore = 0;
	var flag = 1;
	$("input[name='part']").each(function(){
	if($(this).val()==""){
	 showDialog(dialog1);
	 flag = 0;
	 return false;
	}
	else{
	score = score+"," + $(this).val();
	totalScore = totalScore + parseInt($(this).val());
	}
	});
	score = score.substring(4,score.length);
	if(flag==1){
	$('#score').val(score);
	$('#totalScore').val(totalScore);
	return true;
	}
	else{
	return false;
	}
	}
	</script>
	<script src="js/mobiscroll.dom.js"></script>
    <script src="js/mobiscroll.core.js"></script>
    <script src="js/mobiscroll.scrollview.js"></script>
    <script src="js/mobiscroll.frame.js"></script>

    <script src="js/mobiscroll.frame.ios.js"></script>

    <script src="js/mobiscroll.scroller.js"></script>
   

 
    <script src="js/mobiscroll.i18n.zh.js"></script>

    <script>
    (function ($) {

        function init() {

            mobiscroll.scroller("input[name='part']", {
                theme: theme,
                display: display,
                lang: lang,
                wheels: [
                    [{
                        label: 'First wheel',
                        data: ['0', '1', '2', '3', '4', '5', '6', '7','8','9','10']
                    }
                        
                    ]
                ]
            });
        }

        var theme, display, lang;

        $('.settings').on('change', function () {
            theme = "ios";
            display = "center";
            lang = "zh";

            init();
        });

        $('#theme').trigger('change');
    })(mobiscroll.$);
    </script>
  </body>
</html>
