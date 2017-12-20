<%@ page language="java" import="java.util.*,views.View" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>高评委专家库网络信息管理服务系统</title>
	</head>
	<jsp:include page="<%=View.SESSION %>"></jsp:include>
	<frameset rows="61,*,24" cols="*" framespacing="0" frameborder="no" border="0" >
		<frame src="top.jsp" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" />
		<frameset cols="180,*">
		<frame  src="leftForGLY.jsp" name="leftFrame"   frameborder="1"  style="overflow-x:hidden;" scrolling="yes" noresize="noresize" id="leftFrame" />
		<frame  src="index.jsp" name="rightFrame" scrolling="yes" noresize="noresize" id="rightFrame" >
		</frameset>
		
		<!-- <frame src="center.jsp" name="mainFrame" id="mainFrame" /> -->
		<frame src="down.jsp" name="bottomFrame" scrolling="no" noresize="noresize" id="bottomFrame" />
		
	</frameset>
</html>
