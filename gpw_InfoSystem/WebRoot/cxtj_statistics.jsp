<%@ page language="java"
	import="java.util.*,views.View,java.sql.ResultSet,java.sql.Connection"
	pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" +request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title></title>

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
	font-size: 14px;
	font-weight: bold;
}
-->
</style>

		<script>
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
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
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
</script>
	</head>

	<body>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="15" height="30">
								<img src="images/tab_03.gif" width="15" height="30" />
							</td>
							<td width="1101" background="images/tab_05.gif">
								<img src="images/311.gif" width="16" height="16" />
								<span class="STYLE4">�ۺ�ͳ��</span>
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
							<td width="9" background="images/tab_12.gif">
								&nbsp;
							</td>
							
							<td bgcolor="#f3ffe3">
							
								<table style="font-size:13; width="100%"   border="0" align="center"   cellpadding="10"
									cellspacing="1" bgcolor="#f3ffe3"  >
							
										<tr align="center" >
											<td style="width:55%" align="center">
												<fieldset style="width:300; border-color:#c0de98; border-width: 2px;"align="left">
													<legend>ѡ��ר�ҿ�</legend>
													<input type="radio"  name="delete"  value="" />��ʷר�ҿ�
													<input type="radio"  name="delete"  value="" />��ǰר�ҿ�
													<input type="radio"  name="delete"  value="" />����ר�ҿ�
												</fieldset>
											</td>
											<td width="12%"></td>
											<td width="33%"  >
												<fieldset align="left" style="width:130px; border-color:#c0de98; border-width: 2px;">
													<legend>ͳ�Ʒ�ʽ</legend>
													<input type="radio"  name="delete"  value="" />һά
														<input type="radio"  name="delete"  value="" />��ά
												</fieldset>	
											</td>
										</tr>
										
										<tr height="100px;" >
											<td  valign="top" bgcolor="#ffffff" style="padding:0; margin:0;">
												<table   width="100%" border="0" align="center" cellpadding="0" 
									cellspacing="1"  >
													<tr>
														<th height="24"  background="images/tab_14.gif"
											class="STYLE1">��ѯ��Χ</th>
														<th height="24"  background="images/tab_14.gif"
											class="STYLE1">��ѯ�ֶ�</th>
														<th height="24"  background="images/tab_14.gif"
											class="STYLE1">��ѯ����</th>
														<th height="24"  background="images/tab_14.gif"
											class="STYLE1">��ѯֵ</th>
														<th height="24"  background="images/tab_14.gif"
											class="STYLE1">��ѯ�߼�</th>
													</tr>
													<tr>
														<td>v1</td>
														<td>v2</td>
														<td>v3</td>
														<td>v4</td>
														<td>v5</td>
													</tr>
													
												</table>   
											 </td>
											<td align="center">
												<input type="button"  style="width:90px;"  value="ͳ����" /><br><br><br>
												<input type="button"  style="width:90px;" value="ˮƽͳ����"/><br><br><br>
												<input type="button"  style="width:90px;"  value="��ֱͳ����"/>
											</td>
										
											<td  valign="top" bgcolor="#ffffff" style="padding:0; margin:0;">
												<table   width="100%" border="0" align="center" cellpadding="0" 
									cellspacing="1"  >
													<tr>
														<th height="24"  background="images/tab_14.gif"
											class="STYLE1">�ֶ�1</th>
														<th height="24"  background="images/tab_14.gif"
											class="STYLE1">�ֶ�2</th>
														<th height="24"  background="images/tab_14.gif"
											class="STYLE1">�ֶ�3</th>
													</tr>
													<tr>
														<td>v1</td>
														<td>v2</td>
														<td>v3</td>
													</tr>
												</table>
											</td>
										</tr>

										<tr>
											<td></td>
											<td></td>
											<td align="right"><input type="button" style="width:80px;" value="ִ��"/></td>
										</tr>
										
										<tr>
											<td colspan="3">
												<fieldset >
													<legend>ͳ�ƽ��</legend>
													<table   bgcolor="#ffffff" width="100%" border="0" align="center" cellpadding="0" 
									cellspacing="1"  >
													<tr>
														<th height="24"  background="images/tab_14.gif"
											class="STYLE1">��Ŀ</th>
														<th height="24"  background="images/tab_14.gif"
											class="STYLE1">�ֶ�1</th>
														<th height="24"  background="images/tab_14.gif"
											class="STYLE1">�ֶ�2</th>
											<th height="24"  background="images/tab_14.gif"
											class="STYLE1">�ϼ�</th>
													</tr>
													<tr align="center">
														<td>����</td>
														<td>30</td>
														<td>35</td>
														<td>65</td>
													</tr>
												</table>
												</fieldset>
											</td>
										</tr>
						

								</table>
							</td>
							<td width="9" background="images/tab_16.gif">
								&nbsp;
							</td>
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
												<table width="352" height="20" border="0" cellpadding="0"
													cellspacing="0">

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
