<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
<link rel="stylesheet" type="text/css" href="css/metro.css">
	<link rel="stylesheet" href="css/metro-icons.css">
<link rel="stylesheet" href="css/metro-responsive.css">
<link rel="stylesheet" href="css/metro-schemes.css">
	<script type="text/javascript" src="js/jquery-3.0.0.min.js"></script>
	<script type="text/javascript" src="js/metro.min.js"></script>

<style type="text/css">
		body{margin:0;padding:0;}
ul,li,dl,dd,dt,p{margin:0;padding:0;}
ul,li{list-style:none;}
/*柱状图样式*/
.histogram-container{position:relative;margin-left:60px;margin-top:10px;margin-bottom:25px;}
.histogram-bg-line{border:#999 solid;border-width:0 1px 1px 1px;border-right-color:#eee;overflow:hidden;width:99%;}
.histogram-bg-line ul{overflow:hidden;border:#eee solid;border-width:1px 0 0 0;}
.histogram-bg-line li{float:left;width:20%;/*根据.histogram-bg-line下的ul里面li标签的个数来控制比例*/overflow:hidden;}
.histogram-bg-line li div{border-right:1px #eee solid;}
.histogram-content{position:absolute;left:0px;top:0;width:99%;height:100%;}
.histogram-content ul{height:100%;}
.histogram-content li{float:left;height:100%;width:10%;/*根据直方图的个数来控制这个width比例*/text-align:center;position:relative;}
.histogram-box{position:relative;display:inline-block;height:100%;width:20px;}
.histogram-content li a{position:absolute;bottom:0;right:0;display:block;width:20px;}
.histogram-content li .name{position:absolute;bottom:-20px;left:0px;white-space:nowrap;display:inline-block;width:100%;font-size:12px;}
.histogram-y{position:absolute;left:-60px;top:-10px;font:12px/1.8 verdana,arial;}
.histogram-y li{text-align:right;width:55px;padding-right:5px;color:#333;}
.histogram-bg-line li div,.histogram-y li{height:60px;/*控制单元格的高度及百分比的高度，使百分数与线条对齐*/}
</style>

</head>

<body>
<center>
    <h1>该站成绩情况一览</h1>
    <h2>本站最高分=<s:property value="#request.max"/></h2>
    <h2>本站最低分=<s:property value="#request.min"/></h2>
    <h2>本站平均分=<s:property value="#request.ave"/></h2>
	<hr>
	</center>
	<div class="histogram-container" id="histogram-container">
    <!--背景方格-->
    <div class="histogram-bg-line">
        <ul>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
        </ul>
        <ul>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
        </ul>
        <ul>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
        </ul>
        <ul>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
        </ul>
        <ul>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
            <li><div></div></li>
        </ul>
    </div>
    <!--柱状条-->
    <div class="histogram-content">
        <ul>
            <li>
                <span class="histogram-box"><a style="height:<s:property value="#request.score_nums[0]"/>%;background:green;" title="<s:property value="#request.score_nums[0]"/>"></a></span>
                <span class="name">100~90</span>
            </li>
            <li>
                <span class="histogram-box"><a style="height:<s:property value="#request.score_nums[1]"/>%;background:green;" title="<s:property value="#request.score_nums[1]"/>"></a></span>
                <span class="name">90~80</span>
            </li>
             <li>
                <span class="histogram-box"><a style="height:<s:property value="#request.score_nums[2]"/>%;background:green;" title="<s:property value="#request.score_nums[2]"/>"></a></span>
                <span class="name">80~70</span>
            </li>
             <li>
                <span class="histogram-box"><a style="height:<s:property value="#request.score_nums[3]"/>%;background:green;" title="<s:property value="#request.score_nums[3]"/>"></a></span>
                <span class="name">70~60</span>
            </li>
             <li>
                <span class="histogram-box"><a style="height:<s:property value="#request.score_nums[4]"/>%;background:green;" title="<s:property value="#request.score_nums[4]"/>"></a></span>
                <span class="name">60~50</span>
            </li>
             <li>
                <span class="histogram-box"><a style="height:<s:property value="#request.score_nums[5]"/>%;background:green;" title="<s:property value="#request.score_nums[5]"/>"></a></span>
                <span class="name">50~40</span>
            </li>
            <li>
                <span class="histogram-box"><a style="height:<s:property value="#request.score_nums[6]"/>%;background:green;" title="<s:property value="#request.score_nums[6]"/>"></a></span>
                <span class="name">40~30</span>
            </li>
             <li>
                <span class="histogram-box"><a style="height:<s:property value="#request.score_nums[7]"/>%;background:green;" title="<s:property value="#request.score_nums[7]"/>"></a></span>
                <span class="name">30~20</span>
            </li>
             <li>
                <span class="histogram-box"><a style="height:<s:property value="#request.score_nums[8]"/>%;background:green;" title="<s:property value="#request.score_nums[8]"/>"></a></span>
                <span class="name">20~10</span>
            </li>
             <li>
                <span class="histogram-box"><a style="height:<s:property value="#request.score_nums[9]"/>%;background:green;" title="<s:property value="#request.score_nums[9]"/>"></a></span>
                <span class="name">10~0</span>
            </li>
            
        </ul>
    </div>
    <!--百分比 y轴-->
    <div class="histogram-y">
        <ul>
            <li>100%</li>
            <li>80%</li>
            <li>60%</li>
            <li>40%</li>
            <li>20%</li>
            <li>0%</li>
        </ul>
    </div>
</div>
 <table class="table striped hovered cell-hovered border bordered">
  <thead>
  <tr>
 <th class="sortable-column">
   <center>
  <h3>
  学号
  </h3>
  </center>
  </th>
  <th class="sortable-column">
   <center>
  <h3>
  姓名
  </h3>
  </center>
  </th>
  
 <th class="sortable-column">
 <center>
  <h3>
  年级
  </h3>
  </center>
  </th>
   <th class="sortable-column">
   <center>
  <h3>
  班级
  </h3>
  </center>
  </th>
   <th class="sortable-column">
   <center>
  <h3>
  成绩
  </h3>
  </center>
  </th>
  </tr>
  </thead>
  
  <s:iterator value="#request.studentScore" id="studentScore">
  <tr>
   <td>
   <s:property value="#studentScore.s_no"/>
   </td>
   <td>
   <s:property value="#studentScore.s_name"/>
   </td>
   <td>
   <s:property value="#studentScore.s_grade"/>
   </td>
   <td>
   <s:property value="#studentScore.s_class"/>
   </td>
   <td>
   <s:property value="#studentScore.score"/>
   </td>
   </tr>
  </s:iterator>
  </table>
</body>
</html>