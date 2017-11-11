<%@ page language="java" import="java.util.*,views.View"
	pageEncoding="GBK" isErrorPage="true"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>Error occur</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
p,h1{
	text-align: center;
}
</style>

	</head>

	<body>

		<%
			String errorMessage = request.getParameter("error");
			String prePage = request.getParameter("page");
		%>
		<div style="width: 100%; height: 100%;">
			<p><%=errorMessage%></p>
			<p>
				<a href="<%=prePage%>" target="_self">Back</a>
			</p>
		</div>
		<hr width="100%" />
		<jsp:include page="<%=View.DOWN %>"></jsp:include>
	</body>
</html>
