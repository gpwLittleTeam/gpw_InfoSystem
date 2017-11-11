<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>新建用户</title>
<link rel="stylesheet" type="text/css" href="css/jquery.editable-select.min.css" />
<link rel="stylesheet" href="css/buttons.css">

<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE1 {
	font-size: 12px
}

.STYLE4 {
	font-size: 12px;
	color: #1F4A65;
	font-weight: bold;
}

a:link {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}

a:visited {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}

a:hover {
	font-size: 12px;
	color: #FF0000;
	text-decoration: underline;
}

a:active {
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.STYLE7 {
	font-size: 14px;
	font-weight: bold;
}

.leftTd {
	padding-right: 10px;
	width: 35%;
	background-color: #FFFFFF;
	height: 30px;
	font-size: 14px;
}

.rightTd {
	padding-left: 10px;
	padding-top: 1.5px;
	padding-bottom: 1.5px;
	background-color: #FFFFFF;
}

.non-editable {
	width: 200px;
	border-width: 0px;
	font-weight: bold;
}

.editable {
	width: 200px;
	border-width: 2px;
}
</style>
</head>

<body>
	<table style="width:100%; border-width:0px;  text-align:left" cellpadding="0" cellspacing="0">
		<tr>
			<td style="height:30">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
						<td class="width:100% " background="images/tab_05.gif"><img src="images/311.gif"
							width="16" height="16" /> <span class="STYLE4">新建用户</span></td>
						<td background="images/tab_05.gif"></td>
						<td width="15"><img src="images/tab_07.gif" width="16" height="30" /></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="9" background="images/tab_12.gif">&nbsp;</td>
						<td bgcolor="#f3ffe3" align="center">
							<form action="createUser.action" method="post">
								<table width="97%" border="0" align="center" cellpadding="0" cellspacing="1"
									bgcolor="#c0de98" style="margin-top:10px;">
									<tr>
										<td class="leftTd" align="right">用户名</td>
										<td class="rightTd"><input name="objUserLogin.user_name" type="text" class="editable" />
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">用户密码</td>
										<td class="rightTd"><input name="objUserLogin.user_psd" type="password"
											class="editable" /></td>
									</tr>
									<tr>
										<td class="leftTd" align="right">状态</td>
										<td class="rightTd"><select name="objUserLogin.user_enable" calss="editable">
												<option value="0">禁用</option>
												<option value="1" selected>启用</option>
										</select></td>
									</tr>
									<tr>
										<td class="leftTd" align="right">用户类别</td>
										<td class="rightTd"><select name="objUserLogin.user_type" calss="editable">
												<option value="1">高评委用户</option>
												<option value="2" selected>管理员用户</option>
										</select></td>
									</tr>
									<tr>
										<td class="leftTd" align="right">所属高评委</td>
										<td class="rightTd">
										<select id="editable-select" name="objUserLogin.user_jury" style="width:176px"
											autocomplete="off">
												<s:iterator id="jury" value="JuryList">
													<option><s:property value="#jury.Jury_name"/></option>
												</s:iterator>
										</select> 
										<script type="text/javascript"	src="js/jquery-1.9.1.min.js"></script>
											<script type="text/javascript" src="js/jquery.editable-select.min.js"></script> <script
												type="text/javascript">
												$('#editable-select')
														.editableSelect({
															effects : 'slide'
														});
										</script>
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">联系单位</td>
										<td class="rightTd"><input name="objUserLogin.user_dept" type="text" class="editable" />
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">联系电话</td>
										<td class="rightTd"><input name="objUserLogin.user_tel" type="tel" class="editable" />
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">创建时间</td>
										<td class="rightTd"><input name="objUserLogin.user_date" type="date" class="editable" />
										</td>
									</tr>
								</table>
								<div style="width:97%" align="right">
									<input style="font-size:15px;margin-top:10px;line-height: 27px; height: 27px;"
										class="button button-action button-rounded" type="submit" value="保存" />
								</div>
							</form>
						</td>
						<td width="9" background="images/tab_16.gif">&nbsp;</td>
					</tr>
				</table>

			</td>
		</tr>
		<tr>
			<td height="29">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="15" height="29"><img src="images/tab_20.gif" width="15" height="29" /></td>
						<td background="images/tab_21.gif">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="25%" height="29" nowrap="nowrap"><span class="STYLE1"></span></td>
									<td width="75%" valign="top" class="STYLE1">
										<div align="right">
											<table width="352" height="20" border="0" cellpadding="0" cellspacing="0">

											</table>
										</div>
									</td>
								</tr>
							</table>
						</td>
						<td width="14"><img src="images/tab_22.gif" width="14" height="29" /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
