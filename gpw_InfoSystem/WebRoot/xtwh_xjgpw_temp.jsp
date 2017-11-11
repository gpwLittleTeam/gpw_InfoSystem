<%@ page language="java"
	import="java.util.*,java.sql.ResultSet,java.sql.Connection,views.View"
	pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>新建高评委</title>
<link rel="stylesheet" href="css/buttons.css">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

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
	font-size: 15px;
	font-weight: bold;
}

-->
.firTd{
height:35px;
background-color:#FFFFFF;
text-align:right;
width:30%;
padding:0 10px;
}
.secTd{
height:35px;
background-color:#FFFFFF;
text-align:left;
padding:0 10px;
}
.thirdTd{
height:35px;
background-color:#FFFFFF;
text-align:left;
color:#F00000;
padding:0 10px;
font-size:10pt;
}
</style>

<script>
function CheckSelect()  
{  
  // 遍历 form  
	 var aCheckbox=document.getElementsByName("zjgl_infoList_checkbox");
	 if (aCheckbox[0].checked == true)  
	 {
	 		 
	  	for ( var i = 1; i < aCheckbox.length; i++)  
	  	{  
	     aCheckbox[i].checked = true;  
		}
	 }
	else  
	{  
		for ( var i = 1; i < aCheckbox.length; i++)  
	  	{  
	     aCheckbox[i].checked = false;  
		}
	} 
}

function deletion()
{
	var msg = "您真的确定要删除吗？";
	if (confirm(msg)==true){
		return true;
	}else{
		return false;
	}
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
							class="STYLE4">新建高评委</span></td>
						<td  background="images/tab_05.gif"></td>
						<td width="15"><img src="images/tab_07.gif" width="16"
							height="30" /></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
			<form name="" id=""  action="xtwh_xjgpw" method="post" style="margin:0">  
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="9" background="images/tab_12.gif">&nbsp;</td>
						<td bgcolor="#f3ffe3" align="center">
						 	
						<br>
						<div style="text-align:left; margin:0 5%; color:#F00000; font-size:10pt;">带  * 的项不能为空</div>  
						
							<table width="97%" border="0" align="center" cellpadding="0"
								cellspacing="1" bgcolor="#c0de98" onmouseover="changeto()"
								onmouseout="changeback()">
								<tr>
									<td class="firTd">
										<span class="STYLE7">高评委代码</span>
									</td>
									<td class="secTd" >
										<input type="text" value=""/>
									</td>
									<td class="thirdTd" >*创建成功后不能修改</td>
								</tr>
								<tr>
									<td class="firTd">
										<span class="STYLE7">高评委名称</span>
									</td>
									<td class="secTd" >
										<input type="text" value=""/>
									</td>
									<td class="thirdTd">*</td>
								</tr>
								<tr>
									<td class="firTd">
										<span class="STYLE7">类型</span>
									</td>
									<td class="secTd" >
										<select>
											<option value="0"></option>  
											<option value="1">按职务类别或相近专业（二级学科）组建</option>
											<option value="2">按专业（学科）组建</option>
										</select>
									</td>
									<td class="thirdTd">*</td>
								</tr>
								<tr>
									<td class="firTd">
										<span class="STYLE7">评审权限</span>
									</td>
									<td class="secTd" >
										<select>
											<option value="0"></option>  
											<option value="1">正高职称</option>
											<option value="2">副高职称 </option>
											<option value="3">正副合一</option>
										</select>
									</td>
									<td class="thirdTd">*</td>
								</tr>
								<tr>
									<td class="firTd">
										<span class="STYLE7">所评资格名称</span>
									</td>
									<td class="secTd" >
										<input type="text" value=""/>
									</td>
									<td class="thirdTd">*</td>
								</tr>
								<tr>
									<td class="firTd">
										<span class="STYLE7">材料接收单位</span>
									</td>
									<td class="secTd" >
										<input type="text" value=""/>
									</td>
									<td class="thirdTd">*</td>
								</tr>
								<tr>
									<td class="firTd">
										<span class="STYLE7">设立时间</span>
									</td>
									<td class="secTd" >
										<input type="date" value=""/>
									</td>
									<td class="thirdTd">*</td>
								</tr>
								<tr>
									<td class="firTd">
										<span class="STYLE7">备注</span>
									</td>
									<td class="secTd" >
										<input type="text" />
									</td>
									<td class="thirdTd"></td>
								</tr>
							</table>
						
						<div style="width:97%;margin-top:10px;text-align:right; "><input type="submit" value="提交" style="font-size:15px; padding: 0 30px;line-height: 27px; height: 27px;"  class="button button-action button-rounded" /></div>
						
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
