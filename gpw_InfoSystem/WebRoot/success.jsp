<%@ page language="java" import="java.util.*,views.View"
	pageEncoding="ISO-8859-1"%>
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

		<title></title>

		<style type="text/css">
p,h1 {
	text-align: center;
}
</style>

	</head>

	<body>
		<%
			String message = request.getParameter("message");
			String prePage = request.getParameter("page");
		%>
		<div style="width: 100%; height: 100%;">
			<p><%=message%></p>
			<p>
				<a href="<%=prePage%>" target="_self">Back</a>
			</p>
		</div>
		<hr width="100%" />
		<jsp:include page="<%=View.DOWN %>"></jsp:include>
	</body>
</html>
