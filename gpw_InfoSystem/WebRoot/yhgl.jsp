<%@ page language="java" pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title></title>
<link rel="stylesheet" href="./css/buttons.css">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

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
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function deletion()
{
	var msg = "您真的确定要删除吗？";
	if (confirm(msg)==true){		
		var targetForm = document.forms[0];
		targetForm.action = "yhgl!delete";
		return true;
	}else{
		return false;
	}
}


function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function  clickto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

function saveFunc()
{
	// 获取页面第一个表单
	var targetForm = document.forms[0];
	// 动态修改表单的action属性
	targetForm.action = "yhgl!save";
}
</script>
</head>

<body>
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="30">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="15" height="30"><img src="images/tab_03.gif"
							width="15" height="30" /></td>
						<td width="1101" background="images/tab_05.gif"><img
							src="images/311.gif" width="16" height="16" /> <span
							class="STYLE4">用户管理</span></td>
						<td background="images/tab_05.gif"></td>
						<td width="15"><img src="images/tab_07.gif" width="16"
							height="30" /></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<s:form action="yhgl" method="post" style="margin:0"
					namespace="/">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="9" background="images/tab_12.gif">&nbsp;</td>

							<td bgcolor="#f3ffe3">

								<div style="text-align:right;width:99%">
									<div class="button-group">
										<button
											style="font-size:15px;  width:100px;padding:0 10;height:27px;line-height:27px;border-radius:7px 0 0 7px;"
											class="button button-pill button-action">新增</button>
										<input type="submit" name="save" method="save" value="保存"
											style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px"
											class="button button-pill button-action" onclick="saveFunc()"/>
										<input type="submit" name="delete" method="delete" value="删除"
											style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px"
											class="button button-pill button-action" onclick="deletion()" />
										<input type="submit" name="reset" method="reset" value="重置密码"
											style="font-size:15px;  width:100px;padding:0 10;height:27px;line-height:27px;border-radius:0 7px 7px 0;"
											class="button button-pill button-action" />
									</div>
								</div> <br>
								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="1" bgcolor="#c0de98" onmouseover="changeto()"
									onmouseout="changeback()">
									<tr>
										<th width="1%" background="images/tab_14.gif" class="STYLE1">
											<input type="checkbox" name="zjgl_infoList_checkbox"
											value="0" onclick="CheckSelect()" />
										</th>
										<th width="15%" height="18" background="images/tab_14.gif"
											class="STYLE1">序号</th>
										<th width="15%" height="18" background="images/tab_14.gif"
											class="STYLE1">用户名</th>
										<th width="15%" height="18" background="images/tab_14.gif"
											class="STYLE1">用户类别</th>
										<th width="15%" height="18" background="images/tab_14.gif"
											class="STYLE1">评委会名称</th>
										<th width="15%" height="18" background="images/tab_14.gif"
											class="STYLE1">状态</th>

									</tr>
									<tr class="list">
										<td><input type="checkbox" name="zjgl_infoList_checkbox"
											value="1" /></td>
										<td>1</td>
										<td>海蓝色雨林</td>
										<td>管理员</td>
										<td></td>
										<td><select style="width:30%;height:27" id="firstQuery">
												<option value="0">禁用</option>
												<option value="1">启用</option>
											</select>
										</td>

									</tr>
									<tr class="list">
										<td><input type="checkbox" name="zjgl_infoList_checkbox"
											value="2" /></td>
										<td>2</td>
										<td>VB</td>
										<td>高评委</td>
										<td>浙江工业大学</td>
										<td><select style="width:30%;height:27" id="firstQuery">
												<option value="0">禁用</option>
												<option value="1">启用</option>
											</select>
										</td>
									</tr>
								</table>

							</td>
							<td width="9" background="images/tab_16.gif">&nbsp;</td>
						</tr>
					</table>
				</s:form> 
				<script type="text/javascript">
       			 
			    </script>
    		</td>
		</tr>
		<tr>
			<td height="29">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="15" height="29"><img src="images/tab_20.gif"
							width="15" height="29" /></td>
						<td background="images/tab_21.gif">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="25%" height="29" nowrap="nowrap"><span
										class="STYLE1"></span></td>
									<td width="75%" valign="top" class="STYLE1">
										<div align="right">
											<table width="352" height="20" border="0" cellpadding="0"
												cellspacing="0">

											</table>
										</div>
									</td>
								</tr>
							</table>
						</td>
						<td width="14"><img src="images/tab_22.gif" width="14"
							height="29" /></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
