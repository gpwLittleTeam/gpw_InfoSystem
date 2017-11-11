<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">

<title>抽取委员会</title>
<link rel="stylesheet" href="css/buttons.css">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<style type="text/css">
<!--
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
-->
</style>
<script type="text/javascript">
	function checkForm(obj){
		var viceNo = $("#viceNo").val();
		var committeeNo = $("#committeeNo").val();
		$.post("verifyNo.action",{viceNo:viceNo , committeeNo:committeeNo},function(data){
			console.log(data);
			var nextStep = data.nextStep;
			if(nextStep) {
				obj.submit();
			} else {
				alert(data.feedback);			
			}
		}); 
		
		return false;
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
								height="16" /> <span class="STYLE4">抽取委员会</span></td>
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
						<td width="9" background="images/tab_12.gif"></td>
						<td bgcolor="#f3ffe3">
							<form action="to_pwcq_wyh!secPage.action" method="post" >
								<table width="99%" border="0" align="center" cellpadding="0" cellspacing="1"
									bgcolor="#c0de98">
									<tr colspan="8" height="40" style="background-color:#FFFFFF;text-align:center">
										<td><span class="STYLE7" style="text-align:center">***分布抽取高级专业技术职务任职资格评审委员会***</span>
										</td>
									</tr>
									<!-- <tr>
										<td colspan="8" height="40" bgcolor="#FFFFFF">
											<center><span class="STYLE7">选择高级评委会
												<select name="chooseGPW" style="width: 400px;">
													<option value="1"></option>
												</select>
											</span>
											</center>
										</td>
									</tr> -->
									<tr>
										<td colspan="8" height="40" bgcolor="#FFFFFF" style="text-align:center">
											<span class="STYLE7">
												<label for="year">评委会执行年度 </label>
												<select id="year" name="year">
													<s:iterator id="years" value="years">
														<s:if test="%{#years == year}">
															<option value="<s:property />" selected="selected"><s:property /></option>
														</s:if>
														<s:else>
															<option value="<s:property />" ><s:property /></option>
														</s:else>
													</s:iterator>
												</select>
											</span> <span class="STYLE7">
												<label for="viceNo">抽取的副主任人数 </label>
												<input id="viceNo" name="viceNo" type="number" value="${viceNo }" required="required" min="1" oninvalid="setCustomValidity('抽取人数不能小于1人');" oninput="setCustomValidity('')"/>
											</span> <span class="STYLE7">
												<label for="committeeNo">抽取的委员人数 </label>
												<input id="committeeNo" name="committeeNo" type="number" value="${committeeNo }" required="required" min="1" oninvalid="setCustomValidity('抽取人数不能小于1人');" oninput="setCustomValidity('')" >
											</span></td>
									</tr>
									<tr>
										<td colspan="8" height="150" bgcolor="#FFFFFF"><span class="STYLE7">
												抽取规则：
												<br/>
												<input type="checkbox" value="1" name="">评审对象为本单位或系统内以本单位为主的委员会。
												<br/>
												<input type="checkbox" value="2" name="rules" checked="checked" disabled>具有正副高级合一及正高级评审权限的委员会，正高级专家占四分之一以上。
												<br/>
												<input type="checkbox" value="3" name="rules" checked="checked" disabled>具有正副高级合一及正高级评审权限的委员会，45周岁以下的专家占评委会的四分之一以上；而具有副高级评审权限的委员会，45岁以下的专家占评委会的三分之一以上。
												<br/>
												<input type="checkbox" value="4" name="rules" checked="checked" disabled>上一年执行评委随机保留二分之一，另二分之一随机抽取。
											</span></td>
									</tr>
									<tr>
										<td colspan="8" height="20" bgcolor="#FFFFFF">
											<div class="STYLE7" style="width:100%;margin:5px 0px;text-align:center">
												<input type="button" style="font-size:8px; padding: 0 22px;line-height: 20px; height: 20px;" value="下一步" name="nextmove"
													class="button button-action button-rounded" onclick="return checkForm(this.form);">
											</div>
										</td>
									</tr>
								</table>
							</form>
						</td>
						<td width="9" background="images/tab_16.gif"></td>
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
