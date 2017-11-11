<%@ page language="java" import="java.util.*,views.View"
	pageEncoding="UTF-8"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title></title>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}

td {
	height: 100%;
}
-->
</style>
	</head>

	<body>
		<%-- <jsp:include page="session.jsp"></jsp:include> --%>
		<table width="100%" height="100%" border="0" cellpadding="0"
			cellspacing="0" style="table-layout: fixed">
			<tr>
				<td background="images/main_40.gif" style="width: 3px;" >
					&nbsp;
				</td>
				<td width="177" style="border-right: solid 1px #9ad452;">
					<iframe name="I2" width="177" height="100%" frameborder="0" src="left.jsp">
						浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。
					</iframe>
				</td>
				<td style="vertical-align: top;"height="100%" >
					<iframe id="rightFrame" scrolling="yes" name="rightFrame" src="index.jsp" width="100%"  
						frameborder="0">
						浏览器不支持嵌入式框架，或被配置为不显示嵌入式框架。
					</iframe>
				</td>
				<td background="images/main_42.gif" style="width: 3px;">
					&nbsp;
				</td>
			</tr>
		</table>
	</body>
</html>
