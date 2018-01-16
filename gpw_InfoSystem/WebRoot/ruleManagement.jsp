<%@ page language="java" import="java.util.*,gpw.object.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
<head>
<title>抽取规则管理</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/buttons.css">
<link rel="stylesheet" href="css/universal.css">
<script type="text/javascript" src="js/universal.js?a=1"></script>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/json2.js"></script>

<style type="text/css">
.inputPrecent {
	width:40px;
}

</style>

<script>
function save() {
	var form = document.getElementById("theForm");
	//alert(form.name);
	form.action = "updateRuleForceAndEnable.action";
	form.submit();
}
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
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="9" background="images/tab_12.gif">&nbsp;</td>
						<td bgcolor="#f3ffe3" align="center">
							<span class="button-group" style="margin-right:1%;float: right">
								<button type="button"
									style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px;border-radius:5px 0 0 5px;"
									class="button button-pill button-action"onclick="window.location.href='to_ruleManagement_add.action'">增加</button>
								<button type="button"
									style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px;border-radius:0 5px 5px 0;"
									class="button button-pill button-action" onclick="deletion(document.theForm,'规则','deleteRule.action')">删除</button>

							</span>
							<div style="clear:both"></div>
							<nav id="feedbackNav" class="feedbackNav"></nav>
							<form id="theForm" name="theForm" action="" method="post" style="margin:0">
								<table class="list" align="center" style="margin-top:0px;"
									 onmouseover="changeto()" onmouseout="changeback()">
									<tr>
										<th  background="images/tab_14.gif" class="STYLE1"><input type="checkbox" name="chooseAll" value="0" onclick="CheckSelect()" /></th>
										<th height="" background="images/tab_14.gif" class="STYLE1">规则编号</th>
										<th height="18" background="images/tab_14.gif" class="STYLE1">规则内容</th>
										<th height="18" background="images/tab_14.gif" class="STYLE1">适用范围</th>
										<th height="18" background="images/tab_14.gif" class="STYLE1">是否强制</th>
										<th height="18" background="images/tab_14.gif" class="STYLE1">是否启用</th>
									</tr>
									<s:iterator id="list" value="listRuleManagements">
										<tr>
											<td><input type="checkbox" id="nrOfCheckbox"  name="nrOfCheckbox" value="<s:property value='#list.rule_no'/>" /></td>
											<td><s:property value="#list.rule_no"/></td>
											<td><s:property value="#list.rule_field"/></td>
											<td><s:property value="#list.rule_range"/></td>
											<td>
												<s:if test="%{#list.rule_force == '0'.toString()}">
													<input type="checkbox" id="forceUse"  name="forceUse" value="<s:property value='#list.rule_no'/>"/>
												</s:if>
												<s:else>
													<input type="checkbox" id="forceUse"  name="forceUse" value="<s:property value='#list.rule_no'/>" checked/>
												</s:else>
											</td>
											<td>
												<s:if test="%{#list.rule_enabled == '0'.toString()}">
													<input type="checkbox" id="enabled"  name="enabled" value="<s:property value='#list.rule_no'/>"/>
												</s:if>
												<s:else>
													<input type="checkbox" id="enabled"  name="enabled" value="<s:property value='#list.rule_no'/>" checked/>
												</s:else>
											</td>
										</tr>
									</s:iterator>
								</table>
							</form>
							<div style="width:97%">
								<input style="font-size:15px;margin-top:10px;line-height: 27px; height: 27px;"
									class="button button-action button-rounded" type="button" onclick="save()" value="保存" />
							</div> 
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
