<%@ page language="java" import="java.util.*,views.View"
	pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
}

.STYLE1 {
	color: #43860c;
	font-size: 12px;
}
-->
</style>
</head>
<body>
	<%-- <jsp:include page="<%=View.SESSION %>"></jsp:include> --%>
	<table width="100%" border="0" cellspacing="0" cellpadding="0"
		style="table-layout: fixed;">
		<tr>
			<td height="9"
				style="line-height: 9px; background-image: url(images/main_04.gif)">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="97" height="9"
							style="background-image: url('images/main_01.gif'); background-repeat: repeat-x;">
							&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="47"
				style="background-image: url('images/main_09.gif'); background-repeat: repeat-x;">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="38" height="47"
							style="background-image: url('images/main_06.gif'); background-repeat: repeat-x;">
							&nbsp;</td>
						<td width="59">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td height="29"
										style="background-image: url('images/main_07.gif'); background-repeat: repeat-x;">
										&nbsp;</td>
								</tr>
								<tr>
									<td height="18"
										style="background-image: url('images/main_14.gif'); background-repeat: repeat-x;">
										<table width="100%" border="0" cellspacing="0" cellpadding="0"
											style="table-layout: fixed;">
											<tr>
												<td style="width: 1px;">&nbsp;</td>
												<td><span class="STYLE1"><s:property value="#session.User.user_name"/></span></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
						<td width="380"
							style="background-image: url('images/main_08.gif'); background-repeat: repeat-x;">
							&nbsp;</td>
						<td>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td height="23" valign="bottom"><br /></td>
								</tr>
							</table>
						</td>
						<td width="200"
							style="background-image: url('images/main_11.gif'); background-repeat: repeat-x;">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="11%" height="23">&nbsp;</td>
									<td width="89%" valign="bottom"><span class="STYLE1">日期：
											<%
										java.util.Date myDate = new java.util.Date();
										out.print(1900 + myDate.getYear());
									%>年<%
										out.print(1 + myDate.getMonth());
									%>月<%
										out.print(myDate.getDate());
									%>日
											<%
										if (myDate.getDay() == 0)
											out.println("星期日");
										else if (myDate.getDay() == 1)
											out.println("星期一");
										else if (myDate.getDay() == 2)
											out.println("星期二");
										else if (myDate.getDay() == 3)
											out.println("星期三");
										else if (myDate.getDay() == 4)
											out.println("星期四");
										else if (myDate.getDay() == 5)
											out.println("星期五");
										else if (myDate.getDay() == 6)
											out.println("星期六");
									%>

									</span></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="5"
				style="line-height: 5px; background-image: url(images/main_18.gif)">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="180"
							style="background-image: url('images/main_16.gif'); background-repeat: repeat-x;"
							style="line-height: 5px;">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<map name="Map" id="Map">
		<area shape="rect" coords="3,1,49,22" href="#" />
		<area shape="rect" coords="52,2,95,21" href="#" />
		<area shape="rect" coords="102,2,144,21" href="#" />
		<area shape="rect" coords="150,1,197,22" href="#" />
		<area shape="rect" coords="210,2,304,20" href="#" />
		<area shape="rect" coords="314,1,361,23" href="#" />
	</map>
</body>
</html>
