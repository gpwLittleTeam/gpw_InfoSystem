<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
<head>
<title>专业组管理</title>
<link rel="stylesheet" type="text/css" href="css/universal.css?v=<%= System.currentTimeMillis()%>"/>
<link rel="stylesheet" href="css/buttons.css">
<meta charset="UTF-8" />
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

a {
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
	font-size: 12px
}

.list  td {
	text-align: center;
	/* background-color: #FFFFFF; */
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
			var msg = "您确定要删除选中的专业组吗？";
			if (confirm(msg)==true){
				objForm.submit();
				return true;
			}else{
				return false;
			}
		}
	}
	alert("请选择需要删除的专业组");
	return;
}

var  highlightcolor='#eafcd5';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
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
for(var i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=clickcolor;
}
else
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
						<td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
						<td width="1101" background="images/tab_05.gif"><img src="images/311.gif" width="16"
							height="16" /> <span class="STYLE4">专业组管理</span></td>
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
							<table width="98%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td align="right">
										<nav class="button-group">
											<button type="button"
												style="width:130px;padding:0;height:27px;line-height:27px;border-radius:5px 0 0 5px;"
												class="button button-pill button-action" onclick="location.href='to_xjzyz.action'">新建专业组</button>
											<button type="button"
												style="width:130px;padding:0;height:27px;line-height:27px;border-radius:0px 5px 5px 0px;"
												class="button button-pill button-action" onclick="deletion(document.infoList)">删除专业组</button>
										</nav>
									</td>
								</tr>
							</table>
							<nav class="forFeedback"><s:property value="feedback"/></nav>
							<form name="infoList" id="infoList" action="deleteGroup.action" method="post" target="_self">
								<table class="normalDisplayTable" onmouseover="changeto()" onmouseout="changeback()">
								<!--  width="98%" border="0" align="center" cellpadding="0" cellspacing="1"
									bgcolor="#c0de98"  -->
									<tr>
										<th width="1%" background="images/tab_14.gif" class="STYLE1"><input type="checkbox"
											name="chooseAll" value="0" onclick="CheckSelect()" /></th>
										<th width="14%" height="18" background="images/tab_14.gif" class="STYLE1">专业组编号</th>
										<th width="22%" height="18" background="images/tab_14.gif" class="STYLE1">专业组名称</th>
										<th width="22%" height="18" background="images/tab_14.gif" class="STYLE1">专业组设立时间</th>
										<th width="22%" height="18" background="images/tab_14.gif" class="STYLE1">备注</th>
										<th width="19%" height="18" background="images/tab_14.gif" class="STYLE1">操作</th>

									</tr>
									<s:iterator id="group" value="objGroupList">
										<tr class="list">
											<td><input type="checkbox" name="nrOfCheckbox"
												value="<s:property value="#group.Group_no" />" /></td>
											<td><s:property value="#group.Group_no" /></td>
											<td><s:property value="#group.Group_name" /></td>
											<td><s:property value="#group.Group_date" /></td>
											<td><s:property value="#group.Group_comm"/></td>
											<td><s:url id="url" action="to_xgzyz.action">
													<s:param name="groupNo">
														<s:property value="#group.Group_no" />
													</s:param>
												</s:url> <s:a href="%{url}" target="_self">修改</s:a></td>
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
