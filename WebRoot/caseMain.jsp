<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
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
	  <%--<link href="css/mobiscroll.animation.css" rel="stylesheet" type="text/css" />--%>
      <%--<link href="css/mobiscroll.icons.css" rel="stylesheet" type="text/css" />--%>
      <%--<link href="css/mobiscroll.frame.css" rel="stylesheet" type="text/css" />--%>
      <link rel="stylesheet" href="css/bootstrap-select.css"/>
      <link rel="stylesheet" href="css/bootstrap.css">
      <%--<link href="css/mobiscroll.frame.ios.css" rel="stylesheet" type="text/css" />--%>
      <%--<link href="css/mobiscroll.scroller.css" rel="stylesheet" type="text/css" />--%>
      <%--<link href="css/mobiscroll.scroller.ios.css" rel="stylesheet" type="text/css" />--%>
      <%--<link href="css/mobiscroll.image.css" rel="stylesheet" type="text/css" />--%>
      <%--<script src="js/pace.js"></script>--%>
      <link rel="stylesheet" type="text/css" href="css/dataurl.css">
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
      <script src="js/bootstrap.js"></script>

	<script type="text/javascript">
	
	 function showDialog(id){
            var dialog = $("#"+id).data('dialog');
            if (!dialog.element.data('opened')) {
                dialog.open();
            } else {
                dialog.close();
            }
        }

	function check(value){


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
       //获取Action返回的数据用  data.Action中的属性名 获取
           var studentInfo = eval("("+data+")");
           var name = document.getElementById("name");
           var className = document.getElementById("class");
           var grade = document.getElementById("grade");
           var no = document.getElementById("no");
           name.textContent = studentInfo.name;
           className.textContent = studentInfo.class;
           grade.textContent = studentInfo.grade;
           no.textContent = studentInfo.no;
          },
        error:function () {
            alert("错误")
        }
     });

	}


    </script>

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
    <a href="showAllStations.action?test_id=<s:property value="#request.TId"/>">更换案例</a>
   </center>

<%--<div data-role="dialog" id="dialog" class="padding20" data-close-button="true" data-type="alert">--%>
            <%--<h1>提示信息</h1>--%>
            <%--<p>--%>
                <%--没有查询到该学号，请确认是否输入错误--%>
            <%--</p>--%>
        <%--</div>--%>
        <div data-role="dialog" id="dialog1" class="padding20" data-close-button="true" data-type="alert">
            <h1>提示信息</h1>
            <p>
                有评分项未输入
            </p>
        </div>
   <div data-role="dialog" id="dialog2" class="padding20" data-close-button="true" data-type="alert">
       <h1>请选择分数</h1>
       <div id = "choose"></div>
   </div>
   <div data-role="dialog" id="dialog3" class="padding20" data-close-button="true" data-type="alert">
       <h1>请输入备注</h1>
       <div class="input-control text info">
           <input  id="inputError" type="text" style="color:#FF0000;">
       </div>
       <input id="hiddenError" type="hidden">
       <button type="button" onclick="setNewError()" class="button loading-pulse lighten primary">提交到备注</button>
   </div>
<script>
    function ceshi(id) {
        id = id.substr(6);
        var d = document.getElementById("choose");
        d.innerHTML = "";
        var dataSource = document.getElementById("number"+id);
        var maxScore = Number(dataSource.getAttribute("max"));
        for(var i = 0;i<=maxScore;i++) {
            var b = document.createElement('button');
            b.className = "button primary";
            b.textContent = i.toString();
            b.onclick = function () {
                d.innerHTML = "";
                dataSource.value = Number(this.textContent)
                var dialog = $("#dialog2").data('dialog');
                dialog.close();
                calSum();
            }
            d.appendChild(b);
        }
        var dialog = $("#dialog2").data('dialog');
        dialog.open();
    }
    function showDialog(id){
        var dialog = $(id).data('dialog');
        dialog.open();
    }
    function dialogClose() {
        var dialog = $("#dialog2").data('dialog');
        dialog.close();
    }
</script>
<s:form  action="addScore1.action" method="post" 	enctype="multipart/form-data" onsubmit="return valid()">
<center>
 <h3 style="color:red">请选择考生</h3>
</center>
   <%--<input type="text"  class="input" id="student" onblur="check()" name="score.student.SNo"/>--%>

    <div class="col-lg-4 col-lg-offset-4  col-lg-6 col-sm-offset-3 col-xs-8 col-xs-offset-2">
     <s:select id="basic" cssClass="selectpicker show-tick form-control" data-live-search="true" list="#request.students" listKey="key" listValue="value" theme="simple" name="score.student.SNo" onchange="check(this.value)" headerKey="请选择考生" headerValue="请选择考生" />
    </div>


    <br>
    <br>
    <br>
   <div class="col-lg-7 col-lg-offset-4  col-lg-6 col-sm-offset-3 col-xs-8 col-xs-offset-2">
    <label>学号:</label>
    <span id="no"></span>
    <label>姓名:</label>
    <span id="name"></span>
    <label>年级:</label>
    <span id="grade"></span>
    <label>班级:</label>
    <span id="class"></span>
   </div>
    <table class="table striped hovered cell-hovered border bordered" id="t">
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
  <th class="sortable-column" width="10%">
  <h3>
  打分
  </h3>
  </th>


      <th class="sortable-column">
          <h3>
              备注
          </h3>
      </th>
      <th class="sortable-column">
          <h3>
              添加新的错误
          </h3>
      </th>
  </tr>
  </thead>


   <s:iterator value="#request.require" id="require" status="st">
   <tr>
   <td>
        <h3><s:property value="#require.name"/></h3>
   </td>
   <td>
        <h3><s:property value="#require.content"/></h3>
   </td>
   <td>
   <h4 id="<s:property value="#st.index"/>"><s:property value="#require.score"/></h4>
   </td>
   <td>
   <%--<div class="input-control text info">--%>
       <div class="input-control text">
            <input type="number" disabled max="<s:property value="#require.score"/>" id="number<s:property value="#st.index"/>" width="5%" name="part" onchange="calSum()" style="color: #FF0000"/>
       </div>
       <button type="button" class="button success" onclick="ceshi(this.id)" id="button<s:property value="#st.index"/>">打  分</button>
   <%--</div>--%>
   </td>
       <td>
           <s:select list="#request.map" id="select%{#st.index+1}" listKey="key" listValue="value" theme="simple" cssClass="selectpicker" headerKey="没有错误" headerValue="没有错误" name="error">

           </s:select>
       </td>
       <td>
       <%--<div class="input-control text info">--%>
           <%--<input type="text" id="error<s:property value="#st.index+1"/>"/>--%>
       <%--</div>--%>
           <button type="button" class="button warning" onclick="addError(this.id)" id="<s:property value="#st.index+1"/>">添加到选框</button>

           <%--用于提交新添加的错误到数据库--%>
           <input type="hidden" name="newError" id="hidden<s:property value="#st.index+1"/>" value="air"/>
       </td>
   </tr>
   </s:iterator>
    </table>
   <input type="hidden" id="score" name="score.scScore">
    <input type="hidden" id="score" name="score.CId" value="<s:property value="#request.CId"/>">
   <input type="hidden" id="totalScore" name="score.scTotalScore">
   <input type="hidden" id="stId" name="score.station.stId" value="<s:property value="#request.stId"/>">
   <input type="hidden" id="CId" name="c_id" value="<s:property value="#request.CId"/>">
   <input type="hidden" id="TId" name="score.teacher.TId" value="<s:property value="#session.user.TId"/>">
    <input type="hidden" id="studentError" name="score.errors">
    <input type="hidden" value="<s:property value="#request.TId"/>" name="score.TId">
    <input type="hidden" value="<s:property value="#request.RId"/>" name="RId">
   <center>
       <h3 style="color: #ff2d55">当前总分</h3>
       <h3 id="sum">0</h3>
   <button class="button loading-pulse lighten primary" type="submit" >确认无误，提交</button>
   </center>
    </s:form>
    <script type="text/javascript">

        function calSum() {
            var studentSumScore = Number(0);
            $("input[name='part']").each(function(){
                if($(this).val()==""){
                    studentSumScore = studentSumScore + Number(0);
                }
                else{
                    studentSumScore = studentSumScore + Number($(this).val());
                }
            });
            var sum = document.getElementById("sum");
            sum.textContent = studentSumScore;
        }
    function valid(){
            if(document.getElementById("basic").value == "请选择考生")
            {
                alert("请先选择考生");
                return false;

            }
	var score = "air";
	var totalScore = 0;
	var flag = 1;
	var error = "air";
	$("select[name='error']").each(function () {
	    if($(this).val() == ""){
            $(this).val("没有错误");
        }
        error = error + "/" + $(this).val();
    })
        error = error.substring(4,error.length);
    $('#studentError').val(error);
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
	    console.log(score);
	    console.log(totalScore);
	$('#score').val(score);
	$('#totalScore').val(totalScore);
	return true;
	}
	else{
	return false;
	}
	}
	</script>
	<%--<script src="js/mobiscroll.dom.js"></script>--%>
    <%--<script src="js/mobiscroll.core.js"></script>--%>
    <%--<script src="js/mobiscroll.scrollview.js"></script>--%>
    <%--<script src="js/mobiscroll.frame.js"></script>--%>
    <%--<script src="js/mobiscroll.frame.ios.js"></script>--%>
    <%--<script src="js/mobiscroll.scroller.js"></script>--%>
    <%--<script src="js/mobiscroll.i18n.zh.js"></script>--%>
    <script>
        var tab=document.getElementById("t");
        for(var i = 1;i<=tab.rows.length-1;i++)
        {
            var a = document.getElementById("select"+i);
            a.setAttribute("multiple", true);
            a.setAttribute("data-done-button", true);
        }
//    (function ($) {
//        var t = document.getElementById("t");
//       var l = t.rows.length;
//        function init() {
//            for(var j = 0;j<=l-2;j++) {
//                var maxNum = Number($("#number"+j).attr("max"));
//                var d = new Array;
//                for (var i = 0; i <= maxNum; i++) {
//                    d.push(i);
//                }
//                console.log(maxNum);
//                mobiscroll.scroller("#number"+j, {
//                    theme: theme,
//                    display: display,
//                    lang: lang,
//                    wheels: [
//                        [{
//                            label: 'First wheel',
//                            data: d
//                        }
//                        ]
//                    ]
//                });
//            }
//        }
//        var theme, display, lang;
//        $('.settings').on('change', function () {
//            theme = "ios";
//            display = "center";
//            lang = "zh";
//            init();
//        });
//        $('#theme').trigger('change');
//    })(mobiscroll.$);
    </script>
   <script src="js/bootstrap-select.js"></script>
   <script type="text/javascript">
       function addError(id) {
//           var error = document.getElementById("error"+id);
           var obj=document.getElementById("select"+id);
//           var hidden = document.getElementById("hidden"+id);
//           hidden.value = hidden.value + "," + error.value;
           var dialog = $("#dialog3").data('dialog');
           dialog.open();
           var hiddenError = document.getElementById("hiddenError");
           hiddenError.value = id;
       }
       function setNewError() {
           var d = document.getElementById("inputError");
           var hiddenId = document.getElementById("hiddenError").value;
           var hidden = document.getElementById("hidden"+hiddenId);
           hidden.value = hidden.value + "," + d.value;
           var obj=document.getElementById("select"+hiddenId);
           obj.options.add(new Option(d.value,d.value));
           $('.selectpicker').selectpicker('render');
           $('.selectpicker').selectpicker('refresh');
           var dialog = $("#dialog3").data('dialog');
           dialog.close();
       }
   </script>
  </body>
</html>
