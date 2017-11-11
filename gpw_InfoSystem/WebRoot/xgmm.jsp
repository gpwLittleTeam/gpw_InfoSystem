<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
<head>
<title>密码修改</title>
<meta charset="UTF-8" />
<link rel="stylesheet" href="css/buttons.css">
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
header {
	font-size: 13px;
	color:#F00000;
	
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
	background-color: #FFFFFF;
}

</style>

<script>
var error = true;
function checkPsw()
{
	var oldpsw = document.getElementById("oldpsw").value;
	var newpsw = document.getElementById("newpsw").value; 
	var newpswSpan = document.getElementById("newpswSpan");
	if(oldpsw == newpsw) {
		newpswSpan.innerHTML = "新密码和原密码不能相同";
		return false;
	} else {
		newpswSpan.innerHTML = "";
		return true; 
	}
}

function checkPsw2(){
	var psw1 = document.getElementById("newpsw").value;
	var psw2 = document.getElementById("newpsw2").value;
	/* alert(psw1); */
	if(psw1 != psw2){
		document.getElementById("secpswSpan").innerHTML = "两次输入的密码不同，请重新输入。";
		return false;
	} else {
		document.getElementById("secpswSpan").innerHTML = "";
		return true;
	}
}

 function checkSubmit() {
 	alert("11");
 	alert(checkPsw2());
 	alert(checkPsw());
 	if(checkPsw2() && checkPsw()) {
 		alert("true");
 		return true;
 	} else {
 		alert("false");
 		return false;
 	}
 }
</script>
</head>

<body>
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
						<td height="30">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
												<td width="15" height="30">
														<img src="images/tab_03.gif" width="15" height="30" />
												</td>
												<td width="1101" background="images/tab_05.gif">
														<img src="images/311.gif" width="16" height="16" />
														<span class="STYLE4">密码修改</span>
												</td>
												<td background="images/tab_05.gif"></td>
												<td width="15">
														<img src="images/tab_07.gif" width="16" height="30" />
												</td>
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
														<form id="formId" action="xgmm.action" method="post" style="margin:0" onsubmit="return checkSubmit();">
															    <header>${errorMassage }</header>
																<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1"
																		bgcolor="#c0de98" style="margin-top:3px;">
																		<tr>
																				<td class="leftTd" align="right">用户名</td>
																				<td class="rightTd">
																						<input type="text" style="width:200px;" align="left"
																								value='<s:property value="#session.User.user_name"/>' disabled="disabled">
																				</td>
																		</tr>
																		<tr>
																				<td class="leftTd" align="right">原密码</td>
																				<td class="rightTd">
																						<input type="password" id="oldpsw"name="oldpsw" style="width:200px;" align="left"
																								autocomplete="off" required="required">
																				</td>
																		</tr>
																		<tr>
																				<td class="leftTd" align="right">新密码</td>
																				<td id="newpswTd" class="rightTd">
																						<input type="password" id="newpsw" name="newpsw" placeholder="长度不能小于6位"
																								style="width:200px;" align="left" pattern="[a-zA-Z0-9]\w{5,17}"
																								title="长度在6~18之间，只能包含字母、数字和下划线" maxlength="16" onblur="checkPsw()"
																								autocomplete="off" required="required">
																						<span id="newpswSpan" style="color:#F00000;margin:0 10px; font-size:10pt;"></span>
																				</td>
																				
																		</tr>
																		<tr>
																				<td class="leftTd" align="right">再次确认密码</td>
																				<td id="newpswTd2" class="rightTd">
																						<input type="password" id="newpsw2" name="newpsw2" placeholder="再次输入新密码"
																								style="width:200px;" align="left" pattern="[a-zA-Z0-9]\w{5,17}"
																								title="长度在6~18之间，只能包含字母、数字和下划线" maxlength="16" onblur="checkPsw2()"
																								autocomplete="off" required="required">
																						<span id="secpswSpan" style="color:#F00000;margin:0 10px; font-size:10pt;"></span>
																				</td>
																		</tr>
																		
																</table>
																
																<div style="width:97%" align="right">
																		<input style="font-size:15px;margin-top:10px;line-height: 27px; height: 27px;"
																				class="button button-action button-rounded" type="submit" value="确定"/>
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
												<td width="15" height="29">
														<img src="images/tab_20.gif" width="15" height="29" />
												</td>
												<td background="images/tab_21.gif">
														<table width="100%" border="0" cellspacing="0" cellpadding="0">
																<tr>
																		<td width="25%" height="29" nowrap="nowrap">
																				<span class="STYLE1"></span>
																		</td>
																		<td width="75%" valign="top" class="STYLE1">
																				<div align="right">
																						<table width="352" height="20" border="0" cellpadding="0" cellspacing="0">
																						</table>
																				</div>
																		</td>
																</tr>
														</table>
												</td>
												<td width="14">
														<img src="images/tab_22.gif" width="14" height="29" />
												</td>
										</tr>
								</table>
						</td>
				</tr>
		</table>
</body>
</html>
