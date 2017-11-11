<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
<head>
<title>综合查询</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="css/jquery.editable-select.min.css" />
<link rel="stylesheet" href="css/buttons.css">
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
-->
</style>

<script type="text/javascript">
$('#editable-select').editableSelect({
	effects : 'slide'
});
$('#html').editableSelect(); 

var  highlightcolor='#eafcd5';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行
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
							<span class="STYLE4">综合查询</span>
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
							<form style="margin:0;" action="cxtj_query.action">
								<table width="97%" border="0" align="center" cellpadding="0" cellspacing="1"
									bgcolor="#c0de98" style="margin-top:10px;">
									<tr>
										<td class="leftTd" align="right">
											<label for="${aTablestru[0].field_name }">${aTablestru[0].field_chname }</label>
										</td>
										<td class="rightTd">
											<input type="text" name="theField" id="${aTablestru[0].field_name }" style="width:200px;"
												align="left">
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">
											<label for="${aTablestru[1].field_name }">${aTablestru[1].field_chname }</label>
										</td>
										<td class="rightTd">
											<input type="text" name="theField" id="${aTablestru[1].field_name }"
												style="width:200px; align="left">
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">
											<label for="${aTablestru[2].field_name }">${aTablestru[2].field_chname }</label>
										</td>
										<td class="rightTd">
											<input style="width:200px;" name="theField" id="${aTablestru[2].field_name }" type="date" />
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">
											<label for="${aTablestru[3].field_name }">${aTablestru[3].field_chname }</label>
										</td>
										<td class="rightTd">
											<input type="text" name="theField" id="${aTablestru[3].field_name }" style="width:200px;">
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">
											<label for="${aTablestru[4].field_name }">${aTablestru[4].field_chname }</label>
										</td>
										<td class="rightTd">
											<input type="date" name="theField" id="${aTablestru[4].field_name }" style="width:200px;">
										</td>
									</tr>

									<tr>
										<td class="leftTd" align="right">
											<label for="${aTablestru[5].field_name }">${aTablestru[5].field_chname }</label>
										</td>
										<td class="rightTd">
											<s:if test="#session.User.user_type == '2'.toString()">
											<select id="editable-select" name="theField" style="width:176px" autocomplete="off">
												<s:iterator value="arrayOfNameList[0]">
													<option><s:property /></option>
												</s:iterator>
											</select>
											<script type="text/javascript"	src="js/jquery-1.9.1.min.js"></script>
											<script type="text/javascript"
												src="js/jquery.editable-select.min.js"></script>
											<script type="text/javascript">
														$('#editable-select').editableSelect({
															effects : 'slide'
														});
														$('#html').editableSelect();
											</script>
											</s:if>
											<s:else>
												<input type="text" name="theField" style="width:200px" value="${juryString }" readonly="readonly"/>
											</s:else>
											<%-- <select style="width:200px"  id="${aTablestru[5].field_name }" name="theField">
												<option value="0">-</option>
												<s:iterator value="arrayOfNameList[0]" status="status">
												<option value="<s:property value="%{arrayOfCodeList[0][#status.index]}"/>">
													<s:property />
												</option>
											</s:iterator>
										</select> --%>
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">
											<label for="${aTablestru[6].field_name }">${aTablestru[6].field_chname }</label>
										</td>
										<td class="rightTd">
											<select style="width:200px" name="theField" id="${aTablestru[6].field_name }">
												<option value="0">-</option>
												<s:iterator value="arrayOfNameList[1]" status="status">
													<option value="<s:property />">
														<s:property />
													</option>
												</s:iterator>
											</select>
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">
											<label for="${aTablestru[7].field_name }">${aTablestru[7].field_chname }</label>
										</td>
										<td class="rightTd">
											<select style="width:200px" name="theField" id="${aTablestru[7].field_name }">
												<option value="0">-</option>
												<s:iterator value="arrayOfNameList[2]" status="status">
													<option value="<s:property />">
														<s:property />
													</option>
												</s:iterator>
											</select>
									</tr>
									<tr>
										<td class="leftTd" align="right">
											<label for="${aTablestru[8].field_name }">${aTablestru[8].field_chname }</label>
										</td>
										<td class="rightTd">
											<select style="width:200px" name="theField" id="${aTablestru[8].field_name }">
												<option value="0">-</option>
												<s:iterator value="arrayOfNameList[3]" status="status">
													<option value="<s:property />">
														<s:property />
													</option>
												</s:iterator>
											</select>
									</tr>


								</table>
								<div style="width:97%" align="right">
									<input style="font-size:15px;margin-top:10px;line-height: 27px; height: 27px;"
										class="button button-action button-rounded" type="submit" value="搜索" />
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
