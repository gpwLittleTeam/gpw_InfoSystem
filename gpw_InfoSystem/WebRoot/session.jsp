<%@ page language="java" import="java.util.*,message.Error,views.View"
	pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//�жϵ�ǰ�Ƿ����û���¼
	Object current = session.getAttribute("current");
	if (current != null) {
		request.getRequestDispatcher(
				View.ERROR + "?error=" + Error.LOGINFIRST + "&page="
						+ View.LOGIN).forward(request, response);
	}
%>