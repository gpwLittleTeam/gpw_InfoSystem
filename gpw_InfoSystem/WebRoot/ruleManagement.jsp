<%@ page language="java" import="java.util.*,gpw.object.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
<head>
<title>抽取规则管理</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/buttons.css">
<link rel="stylesheet" href="css/universal.css">
<script type="text/javascript" src="js/universal.js"></script>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/json2.js"></script>

<style type="text/css">
.inputPrecent {
	width:40px;
}

</style>

<script>
</script>
</head>

<body>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="30">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
						<td width="1101" background="images/tab_05.gif"><img src="images/311.gif" width="16"
								height="16" /> <span class="STYLE4">抽取规则管理</span></td>
						<td background="images/tab_05.gif"></td>
						<td width="15"><img src="images/tab_07.gif" width="16" height="30" /></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<!-- <form id="theForm" name="theForm" action="" method="post" style="margin:0"> -->
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="9" background="images/tab_12.gif">&nbsp;</td>
							<td bgcolor="#f3ffe3" align="center">
								
								<nav id="feedbackNav" class="feedbackNav"></nav>
								<span class="button-group" style="margin-right:1%;float: right">
												<button type="button"
													style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px;border-radius:5px 0 0 5px;"
													class="button button-pill button-action"onclick="window.location.href='to_authCode_add.action'">增加</button>
												<button type="button"
													style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px;border-radius:0 0 0 0;"
													class="button button-pill button-action"onclick="">删除</button>
												<button type="button"
													style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px;border-radius:0 0 0 0;"
													class="button button-pill button-action"onclick="">启用</button>
												<button type="button"
													style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px;border-radius:0 5px 5px 0;"
													class="button button-pill button-action"onclick="window.open('to_authCode_print.action')">禁用</button>
											</span>
								<table class="list" align="center" style="margin-top:0px;"
									 onmouseover="changeto()" onmouseout="changeback()">
									<tr>
										<th width="1%" background="images/tab_14.gif" class="STYLE1"><input type="checkbox"
											name="chooseAll" value="0" onclick="CheckSelect()" /></th>
										<th width="80%" height="18" background="images/tab_14.gif" class="STYLE1">规则</th>
										<th width="19%" height="18" background="images/tab_14.gif" class="STYLE1">状态</th>
									</tr>
									<tr>
										<td ><input type="checkbox" id=""  name="nrOfCheckbox" checked/></td>
										<td>具有正副高级合一及正高级评审权限的委员会，正高级专家占四分之一以上。 </td>
										<td>已启用</td>
									</tr>
									<tr>
										<td><input type="checkbox" id=""  name="nrOfCheckbox" checked/></td>
										<td>具有正副高级合一及正高级评审权限的委员会，<input type="number" style="width:40px;" max="150" min="0" value="50"/>周岁以下的专家占评委会的<input type="number" class="inputPrecent" max="100" min="0" value="50"/>%以上；而具有副高级评审权限的委员会，<input type="number" style="width:40px;" max="150" min="0" value="50"/>岁以下的专家占评委会的<input type="number" class="inputPrecent" max="100" min="0" value="30"/>%以上。 </td>
										<td>已启用</td>
									</tr>
									<tr>
										<td ><input type="checkbox" id=""  name="nrOfCheckbox" /></td>
										<td>上一年执行评委随机保留<input type="number" class="inputPrecent" max="100" min="0" value="50"/>%，剩余部分随机抽取。</td>
										<td>已禁用</td>
									</tr>
								</table>
								<div style="width:97%">
									<input style="font-size:15px;margin-top:10px;line-height: 27px; height: 27px;"
										class="button button-action button-rounded" type="submit" value="保存" />
								</div>
							</td>
							<td width="9" background="images/tab_16.gif">&nbsp;</td>
						</tr>
					</table>
			<!-- 	</form> -->
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
