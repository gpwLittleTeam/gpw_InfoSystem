<%@ page language="java" import="java.util.*,message.Error,views.View"
	pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//判断当前是否有用户登录
	Object current = session.getAttribute("current");
	if (current != null) {
		request.getRequestDispatcher(
				View.ERROR + "?error=" + Error.LOGINFIRST + "&page="
						+ View.LOGIN).forward(request, response);
	}
%>