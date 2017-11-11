<%@ page language="java" import="java.util.*,views.View,java.sql.ResultSet,java.sql.Connection"
		pageEncoding="UTF-8"%>
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

<title>信息浏览</title>
<link rel="stylesheet" href="css/buttons.css">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">

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
	var highlightcolor = '#eafcd5';
	var clickcolor = '#51b2f6';
	function changeto() {
		source = event.srcElement;
		if (source.tagName == "TR" || source.tagName == "TABLE")
			return;
		while (source.tagName != "TD")
			source = source.parentElement;
		source = source.parentElement;
		cs = source.children;
		//alert(cs.length);
		if (cs[1].style.backgroundColor != highlightcolor && source.id != "nc"
				&& cs[1].style.backgroundColor != clickcolor)
			for (i = 0; i < cs.length; i++) {
				cs[i].style.backgroundColor = highlightcolor;
			}
	}

	function changeback() {
		if (event.fromElement.contains(event.toElement)
				|| source.contains(event.toElement) || source.id == "nc")
			return

		if (event.toElement != source
				&& cs[1].style.backgroundColor != clickcolor)
			//source.style.backgroundColor=originalcolor
			for (i = 0; i < cs.length; i++) {
				cs[i].style.backgroundColor = "";
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
														<span class="STYLE4">专家信息浏览</span>
												</td>
												<td background="images/tab_05.gif"></td>
										</tr>
								</table>
						</td>
						<td width="15">
								<img src="images/tab_07.gif" width="16" height="30" />
						</td>
				</tr>
		</table>
		<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
								<td width="9" background="images/tab_12.gif">&nbsp;</td>
								<td bgcolor="#f3ffe3">

										<table width="80%" border="0" align="center" cellpadding="5" cellspacing="1"
												bgcolor="#f3ffe3">

												<tr>
														<td>
																<span style=" float:right">
																		<input type="button" style="font-size:15px; padding: 0 30px;line-height: 27px; height: 27px;"
																				class="button button-action button-rounded" value="修改"  onclick="window.location.href='to_zjgl_InfoUpdate.action?expert_no=${expert_Info[0] }'">
																</span>
														</td>
												</tr>
										</table>


										<table width="80%" border="0" align="center" cellpadding="10" cellspacing="1"
												bgcolor="#c0de98" onmouseover="changeto()" onmouseout="changeback()"
												style="border-width:3">
												<tr>
														<td width="20%" height="23" bgcolor="#FFFFFF" rowspan="2">
																<span class="STYLE7">${Expert_Field1 }</span>
																<%-- <input type="hidden"  name="Expert_Field1"  value='${expert_Info[0] }'/> --%>
														</td>
														<td width="30%" height="23" bgcolor="#FFFFFF" rowspan="2">${expert_Info[0] }</td>
												</tr>
												<tr>
														<!-- <td colspan="2" width="50%" style="padding:0px; "></td> -->
														<td align="left" width="50%" rowspan="5" bgcolor="#FFFFFF" colspan="2"
																style="position:relative;">
																<div style="text-align:center;height:170px">
																		<img src=${photoName } style="height:170px">
																</div>
														</td>
												</tr>



												<tr>
														<td width="20%" height="23" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field2 }</span>
														</td>
														<td width="30%" height="23" bgcolor="#FFFFFF">${expert_Info[1] }</td>
												</tr>
												<tr>
														<%-- <td height="23" bgcolor="#FFFFFF">
											<span class="STYLE7">身份证号</span>
										</td>
										<td height="23" bgcolor="#FFFFFF">
											<%
												out.print(base.getIdCard());
											%>
										</td> --%>
														<td height="23" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field3 }</span>
														</td>
														<td height="23" bgcolor="#FFFFFF">${expert_Info[2] }</td>
												</tr>
												<tr>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field4 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[3] }</td>
												</tr>
												<tr>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field5 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[4] }</td>
												</tr>


												<tr>
														<td width="20%" height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field6 }</span>
														</td>
														<td width="30%" height="25" bgcolor="#FFFFFF">${expert_Info[5] }</td>
														<td width="20%" height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field7 }</span>
														</td>
														<td width="30%" height="25" bgcolor="#FFFFFF">${expert_Info[6] }</td>
												</tr>
												<tr>

														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field8 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[7] }</td>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field9 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[8] }</td>
												</tr>

												<tr>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field10 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[9] }</td>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field11 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[10] }</td>
												</tr>

												<tr>

														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field12 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[11] }</td>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field13 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF" class="STYLE2">${expert_Info[12] }</td>
												</tr>
												<tr>

														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field14 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[13] }</td>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field15 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[14] }</td>


												</tr>
												<tr>

														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field16 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[15] }</td>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field17 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF" class="STYLE2">${expert_Info[16] }</td>
												</tr>
												<tr>

														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field18 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[17] }</td>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field19 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[18] }</td>
												</tr>
												<tr>

														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field20 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[19] }</td>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field21 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF" class="STYLE2">${expert_Info[20] }</td>
												</tr>
												<tr>

														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field22 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[21] }</td>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field23 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF" class="STYLE2">${expert_Info[22] }</td>
												</tr>
												<tr>

														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field24 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[23] }</td>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field25 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF" class="STYLE2">${expert_Info[24] }</td>
												</tr>
												<tr>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field26 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[25] }</td>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field27 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF" class="STYLE2">${expert_Info[26] }</td>
												</tr>
												<tr>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field28 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[27] }</td>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field29 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF" class="STYLE2">${expert_Info[28] }</td>
												</tr>
												<tr>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field30 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[29] }</td>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field31 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF" class="STYLE2">${expert_Info[30] }</td>
												</tr>
												<tr>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field32 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[31] }</td>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field33 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF" class="STYLE2">${expert_Info[32] }</td>
												</tr>
												<tr>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field34 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF">${expert_Info[33] }</td>
														<td height="25" bgcolor="#FFFFFF">
																<span class="STYLE7">${Expert_Field35 }</span>
														</td>
														<td height="25" bgcolor="#FFFFFF" class="STYLE2">${expert_Info[34] }</td>
												</tr>


										</table>
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
