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

<title>����ְ�����������</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/buttons.css">
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
  // ���� form  
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
	var msg = "�����ȷ��Ҫɾ����";
	if (confirm(msg)==true){
		return true;
	}else{
		return false;
	}
}

var  highlightcolor='#eafcd5';
//�˴�clickcolorֻ����winϵͳ��ɫ������ܳɹ�,�����#xxxxxx�Ĵ���Ͳ���,��û�����Ϊʲô:(
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
							class="STYLE4">��ְ����</span></td>
						<td background="images/tab_05.gif"></td>
						<td width="15"><img src="images/tab_07.gif" width="16"
							height="30" /></td>
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
							<form action="rzgl_gpw.action" method="post">
								<table width="98%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td style="height:30;width:60%" align="left"><select
											name="firstQuery" style="width:180px;height:27"
											id="firstQuery">
												<option value="0">-ѡ����ְ���-</option>
												<option value="1">2002</option>
												<option value="2">2003</option>
										</select> <span style="margin-left:20px"> <input type="submit"
												style="font-size:15px; padding: 0 30px;line-height: 27px; height: 27px;"
												value="��ѯ" class="button button-action button-rounded">
										</span></td>
										<td align="right"><span style="margin-left:20px">
												<input type="button" id="" name=""
												style="font-size:15px; padding: 0 30px;line-height: 27px; height: 27px;"
												value="ɾ��" class="button button-action button-rounded"
												onclick="deletion()">
										</span></td>

									</tr>
								</table>
							</form>
							<form name="infoList" id="infoList" action="#" method="post"
								target="_self">
								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="1" bgcolor="#c0de98" onmouseover="changeto()"
									onmouseout="changeback()">
									<tr>
										<th width="1%" background="images/tab_14.gif" class="STYLE1">
											<input type="checkbox" name="zjgl_infoList_checkbox"
											value="0" onclick="CheckSelect()" />
										</th>
										<th width="13%" height="18" background="images/tab_14.gif"
											class="STYLE1">���</th>
										<th width="11%" height="24" background="images/tab_14.gif"
											class="STYLE1">����</th>
										<th width="20%" height="18" background="images/tab_14.gif"
											class="STYLE1">���θ���ί</th>
										<th width="15%" height="18" background="images/tab_14.gif"
											class="STYLE1">רҵ��</th>
										<th width="15%" height="18" background="images/tab_14.gif"
											class="STYLE1">ְ��</th>
										<th width="11%" height="18" background="images/tab_14.gif"
											class="STYLE1">��ְ���</th>
										<%-- <%-- <%
											if (!honour.isAdmin())
												out
														.println("<th width=\"6%\" height=\"18\" background=\"images/tab_14.gif\"class=\"STYLE1\""
																+ ">"
																+ "ɾ��</th><th width=\"6%\" height=\"18\" background=\"images/tab_14.gif\"class=\"STYLE1\""
																+ ">" + "�޸�</th>");
										%> --%>
									</tr>
									<tr class="list">
										<td><input type="checkbox" name="zjgl_infoList_checkbox"
											value="1" /></td>
										<td>01020008</td>
										<td><a href="">���</a></td>
										<td>�㽭��ҵ��ѧ�߼�ְ����ְ�ʸ�</td>
										<td>������</td>
										<td>����ίԱ</td>
										<td>2002���</td>
									</tr>
									<tr class="list">
										<td><input type="checkbox" name="zjgl_infoList_checkbox"
											value="2" /></td>
										<td>01020009</td>
										<td><a href="">��ΰ��</a></td>
										<td>�㽭��ҵ��ѧ�߼�ְ����ְ�ʸ�</td>
										<td>��ľ������</td>
										<td>������ίԱ</td>
										<td>2002���</td>
									</tr>
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
