<%@ page language="java" import="java.util.*,gpw.object.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>验证码打印</title>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/buttons.css">
		<link rel="stylesheet" href="css/universal.css?a=1">
		<script type="text/javascript" src="js/universal.js"></script>
		<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	</head>
	<body>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="30">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
						<td width="1101" background="images/tab_05.gif"><img src="images/311.gif" width="16"
								height="16" /> <span class="STYLE4">验证码打印</span></td>
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
									<table class="list" align="center" 
									 onmouseover="changeto()" onmouseout="changeback()">
									<tr>
										<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">专家姓名</th>
										<th width="25%" height="18" background="images/tab_14.gif" class="STYLE1">手机号码</th>
										<th name="authCode" width="25%" height="18" background="images/tab_14.gif" class="STYLE1">验证码</th>
										<th width="30%" height="18" background="images/tab_14.gif" class="STYLE1" style="min-width:290px;">失效时间</th>

									</tr>
									<s:iterator id="juryIdcodes" value="juryIdcodes" status="count">
										<tr class="list">
											<td><s:property value="#juryIdcodes.expert_name" /> <input type="hidden"
												name="expert_name" value="<s:property value="#juryIdcodes.expert_name" />" /></td>
											<td><s:property value="#juryIdcodes.expert_phone" /></td>
											<td><s:property value="#juryIdcodes.id_code" /></td>
											<td style="position:relative">
												<s:property value="#juryIdcodes.code_invalid_time" />
											</td>
										</tr>
									</s:iterator>
								</table>
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