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
    
    <title>My JSP 'menu.jsp' starting page</title>
    
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

  </head>
           
  <body>
<s:action name="adminShowAllStations"></s:action>
  <table class="table striped hovered cell-hovered border bordered">
  <thead>
  <tr>
 <th>
  <center>
  <h3>
  请选择您负责的站目
  </h3>
  </center>
  </th>
  
  </tr>
  </thead>
   <s:iterator value="#request.stations" id="station">
   <tr>
   <td>
   <center><h4>
   
   <a href="adminshowCases.action?stc_id=<s:property value="#station.stationId"/>&t_id=<s:property value="#request.t_id"/>"><s:property value="#station.stationName"/></a>
   
   </h4>
       <s:generator separator="," val="#station.stationCases">
           <s:iterator>
               <s:property></s:property>
           </s:iterator>
       </s:generator>
   </center>
   </td>
   </tr>
   </s:iterator>
   </table>
  </body>
</html>
