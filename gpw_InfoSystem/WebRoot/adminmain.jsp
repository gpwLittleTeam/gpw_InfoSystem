<%@ page language="java" import="java.util.*,views.View"  pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>÷∞≥∆∆¿…ÛœµÕ≥11</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head><jsp:include page="<%=View.SESSION %>"></jsp:include>
	<frameset rows="61,*,24" cols="*" framespacing="0" frameborder="no" border="0" >
		<frame src="top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
		<frame src="admincenter.jsp" name="mainFrame" id="mainFrame" />
		<frame src="down.jsp" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame" />
		
	</frameset>
	<noframes>
	</noframes>
</html>
