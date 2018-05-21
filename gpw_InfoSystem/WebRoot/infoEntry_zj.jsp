<%@ page language="java" import="java.util.*,gpw.object.Tablestru" pageEncoding="UTF-8"
		contentType="text/html; charset=UTF-8"%>
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
	String[] fieldNull = new String[size];
	List<String>[] arrayOfNameList = (List<String>[]) request.getSession().getAttribute("arrayOfNameList");   //select 选项的中文字段
	List<String>[] arrayOfCodeList = (List<String>[]) request.getSession().getAttribute("arrayOfCodeList");   //select 选项的英文字段

	String majorsZNodes = (String) request.getSession().getAttribute("majorsZNodes");
//
	for(int i=0;i<aTablestrus.length;i++) {
		type[i] = aTablestrus[i].getField_type();
		width[i] = aTablestrus[i].getField_width();
		remariksName[i] = aTablestrus[i].getField_remark();
		fieldName[i] = aTablestrus[i].getField_chname();
		fieldNull[i] = aTablestrus[i].getField_null();
	}
	/* System.out.println(aTablestrus[0].getField_id()); */
%>

<!DOCTYPE HTML >
<html>
<head>
<title>专家信息录入</title>
<link rel="stylesheet" type="text/css" href="css/jquery.editable-select.min.css"  />
<link rel="stylesheet" href="css/buttons.css">
<link rel="stylesheet" href="css/demo.css" type="text/css">
<link rel="stylesheet" href="css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core.js"></script>
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
	colspan: 0;
	padding-left: 5px;
	background-color: #FFFFFF;
}

.firTd {
	width: 30%;
	height: 23px;
	background-color: #FFFFFF;
	text-align: right;
}

.thirdTd {
	width: 190px;
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

<SCRIPT type="text/javascript">
		var setting = {
			view: {
				dblClickExpand: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: beforeClick,
				onClick: onClick
			}
		};

		var zNodes = <%=majorsZNodes%>

		function beforeClick(treeId, treeNode) {
			var check = (treeNode && !treeNode.isParent);
			if (!check) alert("只能选择城市...");
			return check;
		}
		
		function onClick(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			v = "";
			nodes.sort(function compare(a,b){return a.id-b.id;});
			for (var i=0, l=nodes.length; i<l; i++) {
				v += nodes[i].name + ",";
			}
			if (v.length > 0 ) v = v.substring(0, v.length-1);
			var cityObj = $("#citySel");
			cityObj.attr("value", v);
		}

		function showMenu() {
			var cityObj = $("#citySel");
			var cityOffset = $("#citySel").offset();
			$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

			$("body").bind("mousedown", onBodyDown);
		}
		function hideMenu() {
			$("#menuContent").fadeOut("fast");
			$("body").unbind("mousedown", onBodyDown);
		}
		function onBodyDown(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
				hideMenu();
			}
		}

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
		
	/* 	var checkArray = new Array(35); //当checkArray[i] !=0，不能提交数据
	 function check(docName, num) {
	 var spanName = "field" + num + "_span";
	 var theInput = document.getElementById(docName).value;
	 //	alert("theInput:"+theInput);
	 //	alert("docName:"+docName+" num:"+num);
	 if (theInput == "0" || theInput == "" || theInput == null) {
	 checkArray[num] = 0;
	 document.getElementById(spanName).innerHTML = "×";
	 } else {
	 checkArray[num] = 1;
	 document.getElementById(spanName).innerHTML = "";
	 }
	 } */

	/* function checkIdCardNr() {
	 var theInput = document.getElementById("expert.Expert_Field4").value;
	 if(theInput == "" || theInput == null) {
	 check[1] = 0;
	 document.getElementById("field4_span").innerHTML = "*身份证号不能为空";
	 } else{
	 check[1] = 1;
	 document.getElementById("field4_span").innerHTML = "";
	 }
	 } */

	function check_submit() {
		var targetForm = document.forms[0];
		//alert(check[0]); 
		//		if (checkArray[1] == 0) {
		//			alert("信息填写有误，请检查后在提交");
		//			return false;
		//		} else {
		//alert("正在提交");
		targetForm.action = "infoEntry_submit_zj";
		//targetForm.action="infoEntry_submit!submitInfo";
		//		}
	}
	//load the image
	window.onload = function() {
		document.getElementById('file').onchange = function() {
			var imgFile = this.files[0];
			var fr = new FileReader();
			if (imgFile.size > 100000) {
				alert("您上传照片为超过100KB，请重新上传");
				//alert(document.getElementById('file').value);
				document.getElementById('file').value = "";
			} else {
				fr.onload = function() {
					document.getElementById('image')
							.getElementsByTagName('img')[0].src = fr.result;
				};
				fr.readAsDataURL(imgFile);
			}
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
														<span class="STYLE4">专家信息录入</span>
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
																<table style="width:99% ;margin-top:10px;" border="0" align="center"
																		cellpadding="5px" cellspacing="1" bgcolor="#c0de98">

																		<tr>
																				<td  class="firTd">
																						<span class="STYLE7">${aTablestrus[0].field_chname }</span>
																				</td>
																				<td class=input-td>
																						<input type="text" name="expert.Expert_Field1"
																								style="width:<%=width[0]%>px;border:0; font-weight:bold" class=input-text
																								value='<s:property value="ExpertNo" />' readonly />
																						<!-- <input type="hidden" name="expert.Expert_Field1" value="201401"> -->
																				</td>
																				<td bgcolor="#FFFFFF" rowspan="7" align="center"
																						style="padding:5px; ">
																						<div id="image" style="max-width:60%;margin-bottom: 8px;background:#FFFFFF; ">
																								<img style="max-width:100%;max-height:100%;" src="./images/wutouxiang.jpg" />
																						</div>
																						<div style="margin:0;padding:0">
																								<!--margin-left:40%;position:absolute;bottom:5px  -->
																								<a href="" class="a-upload"> <input type="file" name="file" id="file"
																										accept=".jpg,.bmp,.jpeg,.png">上传头像
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
																						<input type="text" name="expert.Expert_Field2"
																								style="width:<%=width[0]%>px;border:0; font-weight:bold" class=input-text
																								value='<s:property value="expertName" />' readonly />
																						<%-- <input type ="hidden" id=<%=expertName%> name=<%=expertName%> value='${expertName }'/> --%>
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
																								<!-- onBlur="check('expert.Expert_Field3','2')" -->
																								<option value="-1">-</option>
																								<%
																									for (int i = 0; i < arrayOfCodeList[2].size(); i++) {
																								%>
																								<option value=<%=arrayOfCodeList[2].get(i)%>><%=arrayOfNameList[2].get(i)%></option>
																								<%
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
																								value="" class="input-text  idNumber" style="width:<%=width[3]%>px"
																								${aTablestrus[3].field_null } />
																						<span id="field3_span" class="hint"></span>
																				</td>

																		</tr>
																		<tr>
																				<td class="firTd">
																						<span class="STYLE7">${aTablestrus[4].field_chname }</span>
																				</td>
																				<td class=input-td>
																						<input type="text" id="datejs" class="demo-input" placeholder="请选择日期" ${aTablestrus[4].field_null } }>
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
																								%>
																								<option value=<%=arrayOfCodeList[5].get(i)%>><%=arrayOfNameList[5].get(i)%></option>
																								<%
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
																								%>
																								<option value=<%=arrayOfCodeList[6].get(i)%>><%=arrayOfNameList[6].get(i)%></option>
																								<%
																									}
																								%>
																						</select>
																						<span id="field6_span" class="hint"></span>
																				</td>

																		</tr>

																		<%
																			for (int i = 7; i < fieldName.length; i++) {
																				String inputName = "expert.Expert_Field" + (i + 1);
																				String spanName = "field" + i + "_span"; //输入校验  可删
																				//System.out.println("i :"+i + "  type[i] :" + type[i]);
																				if (type[i].equals("select")) {
																					if(!inputName.equals("expert.Expert_Field10") && !inputName.equals("expert.Expert_Field12")) {
																		%>
																		<tr>
																				<td class="firTd">
																						<span class="STYLE7"><%=fieldName[i]%></span>
																				</td>
																				<td class="input-td">
																						<select id=<%=inputName%> name=<%=inputName%> style="width:<%=width[i]%>px"
																								type=<%=type[i]%> class="input-text " <%=fieldNull[i]%>>
																								<option value="-1">-</option>
																								<%
																									for (int j = 0; j < arrayOfNameList[i].size(); j++) {
																								%>
																								<option value=<%=arrayOfCodeList[i].get(j)%>><%=arrayOfNameList[i].get(j)%></option>
																								<%
																									}
																								%>
																								<span id=<%=spanName%> class="hint"></span>
																						</select>
																				</td>
																				<td class="thirdTd"><%=remariksName[i]%></td>
																		</tr>
																		<%
																				} else { //处理专业
																		%>
																		
																		<tr>
																				<td class="firTd">
																						<span class="STYLE7"><%=fieldName[i]%></span>
																				</td>
																				<td class=input-td>
																						<input id="citySel" type="text" readonly value="" style="width:120px;"/>
																						&nbsp;<a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a>
																						<span id=<%=spanName%> class="hint"></span>
																						<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
																							<ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
																						</div>
																				</td>
																				<td class="thirdTd"><%=remariksName[i]%></td>
																		</tr>
																		<%
																				}
																			} else if (type[i].equals("date")) {
																		%>
																		<tr>
																				<td class="firTd">
																						<span class="STYLE7"><%=fieldName[i]%></span>
																				</td>
																				<td class=input-td>
																						<input type="text" id="datejs" class="demo-input" placeholder="请选择日期" <%=fieldNull[i]%> }>
																						<span id=<%=spanName%> class="hint"></span>
																				</td>
																				<td class="thirdTd"><%=remariksName[i]%></td>
																		</tr>
																		<%
																			} else if (type[i].equals("dataList")) {
																				if(!inputName.equals("expert.Expert_Field31")) {
																		%>
																		<tr>
																				<td class="firTd">
																						<span class="STYLE7"><%=fieldName[i]%></span>
																				</td>
																				<td class="input-td">
																						<select id="editable-select"  name=<%=inputName%> style="width:<%=width[i]%>px "  class="input-text"  autocomplete="off"  ${aTablestrus[i].field_null }>
																							<%
																									for (int j = 0; j < arrayOfNameList[i].size(); j++) {
																								%>
																								<option><%=arrayOfNameList[i].get(j)%></option>
																								<%
																									}
																								%>
																						</select>
																						<script type="text/javascript" src="js/jquery.editable-select.min.js"></script>
																						<script type="text/javascript">
																									$('#editable-select').editableSelect({
																										effects : 'slide'
																									});
																									$('#html').editableSelect();
																						</script>
																						<span id=<%=spanName%> class="hint"></span>
																				</td>
																				<td class="thirdTd"><%=remariksName[i]%></td>
																		</tr>
																		<%
																			} else {   //以下处理所属高评委 31
																		%>
																		<tr>
																				<td class="firTd">
																						<span class="STYLE7"><%=fieldName[i]%></span>
																				</td>
																				<td class="input-td">
																						<input  style="width:<%=width[i]%>px" 
																								type="text" class="input-text"  value="${juryName }"  disabled/>
																						<input type ="hidden" id=<%=inputName%> name=<%=inputName%> value='${juryName }'/>
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
																								type=<%=type[i]%> class="input-text" value="" ${aTablestrus[i].field_null } />
																						<span id=<%=spanName%> class="hint"></span>
																				</td>
																				<td class="thirdTd"><%=remariksName[i]%></td>
																		</tr>
																		<%
																			}
																			}
																		%>
																</table>
																<div style="margin-top:20px;text-align:center">
																		<input type="submit"
																				style="font-size:15px; padding: 0 30px;  line-height: 27px; height: 27px;"
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
<script src="laydate/laydate.js"></script>
<script>
	lay('#version').html('-v'+ laydate.v);
	
	//执行一个laydate实例
	laydate.render({
	  elem: '#datejs' //指定元素
	});
</script>
</body>
</html>
