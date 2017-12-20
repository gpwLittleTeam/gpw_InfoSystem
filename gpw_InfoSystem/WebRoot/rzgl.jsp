<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	//	System.out.println("basePath: "+basePath+"\npath"+path);
%>

<!DOCTYPE HTML >
<html>
<head>
<base href="<%=basePath%>">

<title>任职管理</title>
<link rel="stylesheet" href="css/buttons.css">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

form {
	margin-top: 10px;
}

.STYLE1 {
	font-size: 12px
}

.STYLE4 {
	font-size: 12px;
	color: #1F4A65;
	font-weight: bold;
}

a {
	font-size: 14px;
	color: #06482a;
	text-decoration: none;
}

a:visited {
	font-size: 14px;
	color: #06482a;
	text-decoration: none;
}

a:hover {
	font-size: 14px;
	color: #FF0000;
	text-decoration: underline;
}

a:active {
	font-size: 14px;
	color: #FF0000;
	text-decoration: none;
}

.STYLE7 {
	font-size: 12px
}

-->
.list  td {
	text-align: center;
	background-color: #FFFFFF;
	font-size: 14px;
	height: 26px;
}
</style>

<script>
function CheckSelect()  
{  
  // 遍历 form  
	 var chooseAll=document.getElementsByName("chooseAll");
	 var aCheckbox=document.getElementsByName("nrOfCheckbox");
	 if (chooseAll[0].checked == true)  
	 {
	 		 
	  	for ( var i = 0; i < aCheckbox.length; i++)  
	  	{  
	     aCheckbox[i].checked = true;  
		}
	 }
	else  
	{  
		for ( var i = 0; i < aCheckbox.length; i++)  
	  	{  
	     aCheckbox[i].checked = false;  
		}
	} 
}
function deletion(objForm)
{
	var aCheckbox=document.getElementsByName("nrOfCheckbox");
	for(var i=0;i<aCheckbox.length;i++) {
		if(aCheckbox[i].checked == true) {
			var msg = "您确定要删除选中的记录吗？";
			if (confirm(msg)==true){
				objForm.submit();
				return true;
			}else{
				return false;
			}
		}
	}
	alert("请选择需要删除的专家");
	return;
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
														<span class="STYLE4">任职管理</span>
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
														<form action="rzgl_query.action" method="get">
																<table width="98%" border="0" cellspacing="0" cellpadding="0">
																		<tr>
																				<td style="height:30;width:60%" align="left">
																						<select name="selectedYear" style="width:180px; height:27px" id="selectedYear">
																								<option value="0">显示所有年份</option>
																								<s:iterator value="years">
																										<option value="<s:property />"><s:property /></option>
																								</s:iterator>
																						</select>
																						<span style="margin-left:20px">
																								<input type="submit"
																										style="font-size:15px; padding: 0 30px;line-height: 27px; height: 27px;"
																										value="查询" class="button button-action button-rounded">
																						</span>
																				</td>
																				<td align="right">
																						<span style="margin-left:20px">
																								<input type="button" id="" name=""
																										style="font-size:15px; padding: 0 30px;line-height: 27px; height: 27px;"
																										value="删除" class="button button-action button-rounded"
																										onclick="deletion(document.rzglForm)">
																						</span>
																				</td>
																		</tr>
																</table>
														</form>
														<form name="rzglForm" id="rzglForm" action="deleteRzgl.action" method="post" target="_self">
																<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1"
																		bgcolor="#c0de98" onmouseover="changeto()" onmouseout="changeback()">
																		<tr>
																				<th width="1%" background="images/tab_14.gif" class="STYLE1">
																						<input type="checkbox" name="chooseAll" value="0"
																								onclick="CheckSelect()" />
																				</th>
																				<th width="13%" height="18" background="images/tab_14.gif" class="STYLE1">专家编号</th>
																				<th width="11%" height="24" background="images/tab_14.gif" class="STYLE1">专家姓名</th>
																				<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">所属高评委</th>
																				<th width="15%" height="18" background="images/tab_14.gif" class="STYLE1">所属专业组</th>
																				<th width="15%" height="18" background="images/tab_14.gif" class="STYLE1">所任职务</th>
																				<th width="11%" height="18" background="images/tab_14.gif" class="STYLE1">任职年度</th>
																		</tr>
																		<s:iterator id="obj" value="listHistorytitle">
																				<tr class="list">
																						<td>
																								<input type="checkbox" name="nrOfCheckbox" value='<s:property value='#obj.expert_no'/>&<s:property value='#obj.expert_serveyear'/>' />
																						</td>
																						<td>
																								<s:property value='#obj.expert_no' />
																						</td>
																						<td>
																								<s:property value='#obj.expert_name' />
																						</td>
																						<td>
																								<s:property value='#obj.expert_jury' />
																						</td>
																						<td>
																								<s:property value='#obj.expert_group' />
																						</td>
																						<td>
																								<s:property value='#obj.expert_post' />
																						</td>
																						<td>
																								<s:property value='#obj.expert_serveyear' />
																						</td>
																				</tr>
																		</s:iterator>
																</table>
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
