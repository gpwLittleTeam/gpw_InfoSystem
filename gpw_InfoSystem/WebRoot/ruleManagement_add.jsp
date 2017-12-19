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
								
								<select>
									<option value="年龄">年龄</option>
									<option value="性别">性别</option>
									<option value="资格级别">资格级别</option>
								</select>
								<select>
									<option value="=">=</option>
									<option value=">">&gt;</option>
									<option value="<">&lt;</option>
								</select>
								<select>
									<option value="正高级">正高级</option>
									<option value="副高级">副高级</option>
									<option value="初级">初级</option>
								</select>
								<select>
									<option value="-">-</option>
									<option value="或者">或者</option>
									<option value="并且">并且</option>
								</select>
								
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
