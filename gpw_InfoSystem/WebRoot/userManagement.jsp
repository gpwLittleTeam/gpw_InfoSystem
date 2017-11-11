<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="./css/buttons.css"/>
<link rel="stylesheet" href="./css/myStyle.css"/>
<script type="text/javascript" src="js/universal.js" charset="UTF-8"></script>
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
	font-size: 15px;
	font-weight: bold;
}

-->
.list  td {
	text-align: center;
	background-color: #FFFFFF;
	font-size: 12px;
	height: 26px;
}
</style>

<script>
function resetPsw(formName) {
	var aCheckbox=document.getElementsByName("nrOfCheckbox");
	for(var i=0;i<aCheckbox.length;i++) {
		if(aCheckbox[i].checked == true) {
			var msg = "您确定要重置选中用户的密码吗？\n重置后密码为该用户的用户名";
			if (confirm(msg)==true){
				formName.action="resetPsw.action";
				formName.submit();
				return true;
			}else{
				return false;
			}
		}
	}
	alert("请选择需要重置密码的用户");
	return;
}

function save(formName){
	formName.action="udpateEnable.action";
	formName.submit();
}

var  highlightcolor='#eafcd5';
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(var i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(var i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
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
							<span class="STYLE4">用户管理</span>
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
				<form id="theForm"  name="theForm"  action="" method="post" style="margin:0" >
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="9" background="images/tab_12.gif">&nbsp;</td>
							<td bgcolor="#f3ffe3">
								<div style="text-align:right;width:99%">
									<div class="button-group">
										<input type="button" value="新增"
											style="font-size:15px;  width:100px;padding:0 10;height:27px;line-height:27px;border-radius:7px 0 0 7px;"
											class="button button-pill button-action" onclick="location.href='to_createUser.action'"/>
										<input type="submit" value="保存"
											style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px"
											class="button button-pill button-action"  onclick="save(document.theForm)"/>
										<input type="button" name="delete" value="删除"
											style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px"
											class="button button-pill button-action" onclick="deletion(document.theForm,'用户','deleteUser.action')" />
										<input type="button" name="reset" value="重置密码"
											style="font-size:15px;  width:100px;padding:0 10;height:27px;line-height:27px;border-radius:0 7px 7px 0;"
											class="button button-pill button-action" onclick="resetPsw(document.theForm)"/>
									</div>
								</div>
								<nav class="forFeedback"><s:property value="feedback"/></nav>
								<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1"
									bgcolor="#c0de98" onmouseover="changeto()" onmouseout="changeback()" style="margin:10px;">
									<tr>
										<th width="1%" background="images/tab_14.gif" class="STYLE1">
											<input type="checkbox" name="chooseAll" value="0" onclick="CheckSelect()" />
										</th>
										<th width="15%" height="18" background="images/tab_14.gif" class="STYLE1">序号</th>
										<th width="15%" height="18" background="images/tab_14.gif" class="STYLE1">用户名</th>
										<th width="15%" height="18" background="images/tab_14.gif" class="STYLE1">用户类别</th>
										<th width="15%" height="18" background="images/tab_14.gif" class="STYLE1">评委会名称</th>
										<th width="15%" height="18" background="images/tab_14.gif" class="STYLE1">状态</th>
									</tr>
									<s:iterator id="user" value="listUserLogin" status="count">
										<tr class="list">
											<td>
												<input type="checkbox"  id="checkbox<s:property value="#count.index+1" />" name="nrOfCheckbox"
													value="<s:property value="#user.user_name"/>"  />
											</td>
											<td>
												<s:property value="#count.index+1" />
											</td>
											<td>
												<s:property value="#user.user_name" />
												<input type="hidden" name="user_name" value="<s:property value="#user.user_name" />"/>
											</td>
											<td>
												<s:property value="#user.user_type" />
											</td>
											<td>
												<s:property value="#user.user_dept" />
											</td>
											<td>
												<select style="width:30%;height:27" id="user_enable" name="user_enable" >
													<s:if test="%{#user.user_enable == 1}">
														<option value="0">禁用</option>
														<option value="1" selected="selected">启用</option>
													</s:if>
													<s:else>
														<option value="0" selected="selected">禁用</option>
														<option value="1">启用</option>
													</s:else>
												</select>
											</td>
										</tr>
									</s:iterator>
								</table>
							</td>
							<td width="9" background="images/tab_16.gif">&nbsp;</td>
						</tr>
					</table>
				</form>
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
