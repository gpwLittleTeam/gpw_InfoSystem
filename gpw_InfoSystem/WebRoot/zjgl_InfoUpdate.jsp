<%@ page language="java" import="java.util.*,gpw.object.Tablestru,gpw.object.Expert"
		pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	//获取tableStru 数组
	Tablestru[] aTablestrus = (Tablestru[]) request.getSession().getAttribute("aTablestrus");
	int size = aTablestrus.length;
//tableStru的各个属性
	String[] type = new String[size];
	String[] width = new String[size];
	String[] remariksName = new String[size];
	String[] fieldName = new String[size];  //显示给用户的中文字段
	List<String>[] arrayOfNameList = (List<String>[]) request.getSession().getAttribute("arrayOfNameList");   //select 选项的中文字段
	List<String>[] arrayOfCodeList = (List<String>[]) request.getSession().getAttribute("arrayOfCodeList");   //select 选项的英文字段
	for(int i=0;i<size;i++) {
		type[i] = aTablestrus[i].getField_type();
		width[i] = aTablestrus[i].getField_width();
		remariksName[i] = aTablestrus[i].getField_remark();
		fieldName[i] = aTablestrus[i].getField_chname();
	}
/* 	//for() 专家信息
	String[] inputValue = new String[size];
	 */
	 Expert objExpert = (Expert) request.getAttribute("objExpert");
	 String[] inputValue = new String[size];
	 for(int i = 0;i < size;i++) {
	 	inputValue[i] = objExpert.getExpert(1 + i);  //
	 }
	 System.out.println("infoupdate.jsp 27行需要改");
%>

<!DOCTYPE HTML >
<html>
<head>
<title>专家信息修改</title>
<link rel="stylesheet" type="text/css" href="css/jquery.editable-select.min.css"  />
<link rel="stylesheet" href="css/buttons.css">
<META charset="UTF-8">


<style type="text/css">
.a-upload {
	padding: 4px 10px;
	height: 20px;
	line-height: 20px;
	position: relative;
	cursor: pointer;
	color: #888;
	background: #fafafa;
	border: 1px solid #ddd;
	border-radius: 4px;
	overflow: hidden;
	display: inline-block;
	*display: inline;
	*zoom: 1;
	text-decoration: none
}

.a-upload  input {
	position: absolute;
	font-size: 100px;
	right: 0;
	top: 0;
	opacity: 0;
	filter: alpha(opacity = 0);
	cursor: pointer
}

.a-upload:hover {
	color: #444;
	background: #eee;
	border-color: #ccc;
	text-decoration: none
}

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

.idNumber::-webkit-outer-spin-button,.idNumber::-webkit-inner-spin-button
	{
	-webkit-appearance: none !important;
	margin: 0;
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

.input-text {
	padding: 0;
	border: 10;
	height: 95%;
	background-color: #FFFFFF;
}

.input-td {
	width: 30%;
	colspan: 0;
	padding-left: 5px;
	background-color: #FFFFFF;
}

.firTd {
	height: 23px;
	background-color: #FFFFFF;
	text-align: right;
}

.thirdTd {
	height: 23px;
	background-color: #FFFFFF;
	color: #555555;
	font-size: 10pt;
}

.hint {
	color: #F00000;
	margin: 0 0px;
	font-size: 11pt;
	font-weight: bold;
}
</style>

<script>
	function check_submit() {
		var targetForm = document.forms[0];
		//alert(check[0]); 
		//		if (checkArray[1] == 0) {
		//			alert("信息填写有误，请检查后在提交");
		//			return false;
		//		} else {
		//alert("正在提交");
		targetForm.action = "updateExpert";
		//targetForm.action="infoEntry_submit!submitInfo";
		//		}
	}
	//load the image
	window.onload = function() {
		document.getElementById('file').onchange = function() {
			var imgFile = this.files[0];
			var fr = new FileReader();
			fr.onload = function() {
				document.getElementById('image').getElementsByTagName('img')[0].src = fr.result;
			};
			fr.readAsDataURL(imgFile);
		};
	};
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
														<span class="STYLE4">专家信息修改</span>
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

												<td bgcolor="#f3ffe3">
														<form action="" method="post" style="margin:0" enctype="multipart/form-data">
																<table style="width:80% ; margin-top:20px" border="0" align="center"
																		cellpadding="5px" cellspacing="1" bgcolor="#c0de98">

																		<tr>
																				<td width="20%" class="firTd">
																						<span class="STYLE7">${aTablestrus[0].field_chname }</span>
																				</td>
																				<td class=input-td>
																						<input type="text" name="expert.Expert_Field1"
																								style="width:<%=width[0]%>px;border:0; font-weight:bold" class=input-text
																								value="<s:property value='objExpert.Expert_Field1'/>" readonly />
																						<!-- <input type="hidden" name="expert.Expert_Field1" value="201401"> -->
																				</td>
																				<td width="10%" bgcolor="#FFFFFF" rowspan="7" align="center"
																						style="padding:5px; ">
																						<div id="image"
																								style="max-width:60%;margin-bottom: 8px;background:#FFFFFF; ">
																								<img style="max-width:100%;max-height:100%;" src="${photoName }" />
																						</div>
																						<div style="margin:0;padding:0">
																								<!--margin-left:40%;position:absolute;bottom:5px  -->
																								<a href="" class="a-upload"> <input type="file" name="file" id="file"  accept=".jpg,.bmp,.jpeg,.png">上传头像
																								</a>
																						</div>
																						<div style="font-size:8pt; color:#F00000; margin-top:8px">
																								jpg格式，200×280至300×420，不超过500k,免冠照片。</div>
																				</td>
																		</tr>
																		<tr>
																				<td class="firTd">
																						<span class="STYLE7">${aTablestrus[1].field_chname }</span>
																				</td>
																				<td class=input-td>
																						<input id="expert.Expert_Field2" name="expert.Expert_Field2" type=<%=type[1]%>
																								class=input-text style="width:<%=width[1] %>px"
																								value="<s:property value='objExpert.Expert_Field2'/>"
																								${aTablestrus[1].field_null } />
																						<span id="field1_span" class="hint"></span>
																				</td>
																		</tr>
																		<tr>
																				<td class="firTd">
																						<span class="STYLE7">${aTablestrus[2].field_chname }</span>
																				</td>
																				<td class=input-td>
																						<select id="expert.Expert_Field3" name="expert.Expert_Field3"
																								style="width:<%=width[2]%>px" class="input-text" ${aTablestrus[2].field_null }>
																								<option value="-1">-</option>
																								<!-- onBlur="check('expert.Expert_Field3','2')" -->
																								<%
																									for (int i = 0; i < arrayOfCodeList[2].size(); i++) {
																										if (inputValue[2]!=null && inputValue[2].equals(arrayOfCodeList[2].get(i))) {
																												//	System.err.print("**" + inputValue[2] + "**");	
																								%>
																								<option value=<%=arrayOfCodeList[2].get(i)%> selected="selected"><%=arrayOfNameList[2].get(i)%></option>
																								<%
																										} else {
																								%>
																								<option value=<%=arrayOfCodeList[2].get(i)%>><%=arrayOfNameList[2].get(i)%></option>
																								<%
																									}
																											}
																								%>
																						</select>
																						<span id="field2_span" class="hint"></span>
																				</td>
																		</tr>
																		<tr>
																				<%-- <td height="25" bgcolor="#FFFFFF">
											<span class="STYLE7">最高学历</span>
										</td>
										<td height="25" bgcolor="#FFFFFF" class="STYLE2">
											<%
												out.print(base.getApplicationName());
											%>
										</td> --%>
																				<td class="firTd">
																						<span class="STYLE7">${aTablestrus[3].field_chname }</span>
																				</td>
																				<td class=input-td>
																						<input id="expert.Expert_Field4" name="expert.Expert_Field4" type=<%=type[3]%>
																								class="input-text  idNumber" style="width:<%=width[3]%>px"
																								value="<s:property value='objExpert.Expert_Field4'/>"
																								${aTablestrus[3].field_null } />
																						<span id="field3_span" class="hint"></span>
																				</td>

																		</tr>
																		<tr>
																				<td class="firTd">
																						<span class="STYLE7">${aTablestrus[4].field_chname }</span>
																				</td>
																				<td class=input-td>
																						<input id="expert.Expert_Field5" name="expert.Expert_Field5"
																								class="input-text" style="width:<%=width[4]%>px" type="<%=type[4]%>"
																								value="<s:property value='objExpert.Expert_Field5'/>"
																								${aTablestrus[4].field_null } />
																						<span id="field4_span" class="hint"></span>
																				</td>
																		</tr>


																		<tr>
																				<td class="firTd">
																						<span class="STYLE7">${aTablestrus[5].field_chname }</span>
																				</td>
																				<td class=input-td>
																						<select id="expert.Expert_Field6" name="expert.Expert_Field6" class=input-text style="width:<%=width[5]%>px"
																								${aTablestrus[5].field_null }>
																								<option value="-1">-</option>
																								<%
																									for (int i = 0; i < arrayOfCodeList[5].size(); i++) {
																										if (inputValue[5]!=null && inputValue[5].equals(arrayOfCodeList[5].get(i))) {
																								%>
																								<option value=<%=arrayOfCodeList[5].get(i)%> selected="selected"><%=arrayOfNameList[5].get(i)%></option>
																								<%
																									} else {
																								%>
																								<option value=<%=arrayOfCodeList[5].get(i)%>><%=arrayOfNameList[5].get(i)%></option>
																								<%
																									}
																											}
																								%>
																						</select>
																						<span id="field5_span" class="hint"></span>
																				</td>

																		</tr>
																		<tr>
																				<td class="firTd">
																						<span class="STYLE7">${aTablestrus[6].field_chname }</span>
																				</td>
																				<td class=input-td>
																						<select id="expert.Expert_Field7" name="expert.Expert_Field7"
																								style="width:<%=width[6]%>px" class="input-text" ${aTablestrus[6].field_null }>
																								<option value="-1">-</option>
																								<%
																									for (int i = 0; i < arrayOfCodeList[6].size(); i++) {
																										if (inputValue[6]!=null && inputValue[6].equals(arrayOfCodeList[6].get(i))) {
																												//	System.err.print("**" + inputValue[6] + "**");	
																								%>
																								<option value=<%=arrayOfCodeList[6].get(i)%> selected="selected"><%=arrayOfNameList[6].get(i)%></option>
																								<%
																										} else {
																								%>
																								<option value=<%=arrayOfCodeList[6].get(i)%>><%=arrayOfNameList[6].get(i)%></option>
																								<%
																										}
																									}
																								%>
																						</select>
																						<span id="field6_span" class="hint"></span>
																				</td>
																		</tr>

																		<%
																			for (int i = 7; i < fieldName.length; i++) {
																				String inputName = "expert.Expert_Field" + (i + 1);
																				//		String inputValue = "objExpert.Expert_Field" + (i + 1);
																				request.setAttribute("inputValue", inputValue);
																				String spanName = "field" + i + "_span"; //输入校验  可删
																				if (type[i].equals("select")) {
																		%>
																				<tr>
																				<td class="firTd">
																						<span class="STYLE7"><%=fieldName[i]%></span>
																				</td>
																				<td class=input-td>
																						<select id=<%=inputName%> name=<%=inputName%> style="width:<%=width[i]%>px"
																								class="input-text " ${aTablestrus[i].field_null }>
																								<option value="-1">-</option>
																								<%
																									for (int j = 0; j < arrayOfNameList[i].size(); j++) {
																												//System.out.print(arrayOfNameList[i].get[5] + " - ");
																										if (inputValue[i]!=null && inputValue[i].equals(arrayOfCodeList[i].get(j))) {
																												//	System.err.print("**" + inputValue[i] + "**");	
																								%>
																								<option value=<%=arrayOfCodeList[i].get(j)%> selected="selected"><%=arrayOfNameList[i].get(j)%></option>
																								<%
																									} else {
																								%>
																								<option value=<%=arrayOfCodeList[i].get(j)%>><%=arrayOfNameList[i].get(j)%></option>
																								<%
																									}
																											}
																								%>
																						</select>
																						<span id=<%=spanName%> class="hint"></span>
																				</td>
																				<td class="thirdTd"><%=remariksName[i]%></td>
																		</tr>
																		<%
																			} else if(type[i].equals("dataList")){
																				if(!inputName.equals("expert.Expert_Field31")) {
																		%>
																				<tr>
																				<td class="firTd">
																						<span class="STYLE7"><%=fieldName[i]%></span>
																				</td>
																				<td class="input-td">
																					 	<%-- <input id=<%=inputName%> name=<%=inputName%> style="width:<%=width[i]%>px"
																								type=<%=type[i]%> class="input-text" list="juryList" value="<%=inputValue[i]%>"
																								${aTablestrus[i].field_null } />
																						<datalist id="juryList">
																								<%
																									for (int j = 0; j < arrayOfNameList[i].size(); j++) {
																								%>
																								<option><%=arrayOfNameList[i].get(j)%></option>
																								<%
																									}
																								%>
																						</datalist>
																						<span id=<%=spanName%> class="hint"></span>  --%>
																						<select id="editable-select"  name=<%=inputName%> style="width:<%=width[i]%>px "  class="input-text"  autocomplete="off"  value="<%=inputValue[i]%>"  ${aTablestrus[i].field_null }>
																							<%
																									for (int j = 0; j < arrayOfNameList[i].size(); j++) {
																								%>
																								<option><%=arrayOfNameList[i].get(j)%></option>
																								<%
																									}
																								%>
																						</select>
																						<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
																						<script type="text/javascript" src="js/jquery.editable-select.min.js"></script>
																						<script type="text/javascript">
																									$('#editable-select').editableSelect({
																										effects : 'slide'
																									});
																									$('#html').editableSelect();
																						</script>
																				</td>
																				<td class="thirdTd"><%=remariksName[i]%></td>
																		</tr>
																		<%
																			} else {
																			%>
																			<tr>
																				<td class="firTd">
																						<span class="STYLE7"><%=fieldName[i]%></span>
																				</td>
																				<td class="input-td">
																						<input  style="width:<%=width[i]%>px" 
																								type="text" class="input-text"  value='<%=inputValue[i]%>'  disabled/>
																						<input type ="hidden" id=<%=inputName%> name=<%=inputName%> value='<%=inputValue[i]%>' />
																						<span id=<%=spanName%> class="hint"></span>
																				</td>
																				<td class="thirdTd"><%=remariksName[i]%></td>
																		</tr>
																			<%
																			}
																			} else {
																		%>
																			<tr>
																				<td class="firTd">
																						<span class="STYLE7"><%=fieldName[i]%></span>
																				</td>
																				<td class="input-td">
																						<input id=<%=inputName%> name=<%=inputName%> style="width:<%=width[i]%>px"
																								type=<%=type[i]%> class="input-text"  value="<%=inputValue[i]%>"
																								${aTablestrus[i].field_null } />
																						<span id=<%=spanName%> class="hint"></span>
																				</td>
																				<td class="thirdTd"><%=remariksName[i]%></td>
																		</tr>
																		<% 
																			}
																			}
																		%>
																</table>
																<div style="margin-top:20px;margin-right:10px;" align="center">
																		<input type="submit"
																				style="font-size:15px; padding: 0 30px;  line-height: 27px; height: 27px; position: center"
																				value="保存" class="button button-action button-rounded" onclick="check_submit()" />
																</div>
														</form>
												</td>
												<td width="9" background="images/tab_16.gif"></td>
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
