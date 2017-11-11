<%@ page language="java" import="java.util.*,gpw.object.*,gpw.paged.*"
	pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:useBean id="pq" scope="page" class="gpw.paged.PageQuery" />

<% 
	//显示全部“选择字段”代码
	Tablestru infoObj = new Tablestru();
	List<String> fieldList = infoObj.getChNameByOrder();     //赋值中文名
	int size = fieldList.size();
	String[] chFieldName = new String[size];
	for(int i=0;i<size;i++){
		chFieldName[i] = fieldList.get(i);
	}
	fieldList = infoObj.getEnNameByOrder();     //赋值英文名
	String[] enFieldName = new String[size];
	for(int i=0;i<size;i++){
		enFieldName[i] = fieldList.get(i);
	}
	//列表专家对象
/* 	Integer expertListSize = (Integer) request.getSession().getAttribute("expertListSize"); */ 
	List<Expert> expertList = (List<Expert>) request.getSession().getAttribute("expertList");   //列表里要显示的专家
//	System.out.println("JSP: "+expertList.get(0).getExpert_Field2());
	request.getSession().setAttribute("expertList", expertList);
	
	//显示USER已选择的字段
	List<String> chDefaultFieldList = (List<String>) request.getSession().getAttribute("chDefaultFieldList");
	List<String> intDefaultFieldList = (List<String>) request.getSession().getAttribute("intDefaultFieldList");
//	System.out.println("chDefaultFieldList JSP:"+chDefaultFieldList);
//	System.out.println("intDefaultFieldList JSP:"+intDefaultFieldList);
//	System.out.println("defaultField :"+ chDefaultFieldList.get(0));

	//page
	expertList = pq.myQuery(expertList,request);
	String bar = pq.PageLegend(); //读取分页提示栏
	
%>

<!DOCTYPE HTML>
<html>
<head>
<title>信息浏览</title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="css/jquery.editable-select.min.css" />
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

.pageDiv {
	text-align: center;
	margin-top: 130px;
}

.pageDiv a {
	text-decoration: none;
	border: 1px solid #c0de98;
	padding: 5px 7px;
	color: #767675;
}

-->
.list  td {
	text-align: center;
	background-color: #FFFFFF;
	font-size: 14px;
	height: 26px;
}

.checkboxStyle {
	display: inline-block;
	width: 150px;
	font-size: 14px;
	margin-left: 10px;
	margin-bottom: 5px
}
</style>

<script>
function add_Td(){
	var tr = document.getElementById("headline");
	alert(tr);
	var td = tr.insertCell(2);
	td.innerText = 1;
}

function fieldsetShow(){  
	var fieldset1=document.getElementById("fieldset1");  
	if(fieldset1.style.display=='none') {
	 	fieldset1.style.display='block';
	}
}  
function fieldsetHide(){  
	var fieldset1=document.getElementById("fieldset1");  
	if(fieldset1.style.display=='block') {
	 	fieldset1.style.display='none';
	}
}  
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
							class="STYLE4">信息浏览</span></td>
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
						<td bgcolor="#f3ffe3" align="left" style="padding:5px">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td style="height:30px;">
										<form action="infoList_gly_query" method="post"
											style="margin:0">
											<%-- <input name="juryName" list="gpwList" style="width:15%;height:22px" autocomplete="off"
												placeholder="输入要查询的高评委名称，可空" />
											<div style="overflow:auto; height10px">
												<datalist id="gpwList">
													<s:iterator value="listGpw">
														<option><s:property /></option>
													</s:iterator>
												</datalist>
											</div> --%>

											<select id="editable-select" name="juryName"
												autocomplete="off">
												<s:iterator value="listGpwName">
													<option value="<s:property />"><s:property /></option>
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

											<select name="QueryItem" style="width:15%;height:29px"
												id="QueryItem">
												<option value="0">-显示所有专家-</option>
												<option value="name">姓名</option>
												<option value="majorGroup">专业组</option>
												<option value="workplace">工作单位</option>
												<option value="number">编号</option>
											</select> <input style="width:15%;height:22px" name="theValue"
												type="text" /> <span style="margin-left:20px"> <input
												type="submit"
												style="font-size:15px; padding: 0 30px;line-height: 27px; height: 27px;"
												value="查询" class="button button-action button-rounded">
											</span>
										</form>
									</td>
									<td align="right">
										<div class="button-group">
											<button type="button"
												style="font-size:15px;  padding:0 30;height:27px;line-height:27px;border-radius:5px 5px 5px 5px;"
												class="button button-pill button-action"
												onclick="fieldsetShow()">选择字段</button>
										</div>
									</td>
								</tr>
							</table>
							<div id="fieldset1" style="display:none;">
								<form action="setDefaultFieldForGPW.action"
									style="margin:0;padding:0">
									<fieldset style="margin-top:15px;">
										<legend>选择显示字段</legend>
										<%
											int startNr = 2;
											List<String> tempList = new ArrayList<String>(chDefaultFieldList);
										%>
										<span class=checkboxStyle> <input type="checkbox"
											value=<%=enFieldName[0]%> name="" disabled="disabled" checked /><%=chFieldName[0]%>
											<input type="hidden" value=<%=enFieldName[0]%>
											name="chosenField" />
										</span> <span class=checkboxStyle> <input type="checkbox"
											value=<%=enFieldName[1]%> name="" disabled="disabled" checked /><%=chFieldName[1]%>
											<input type="hidden" value=<%=enFieldName[1]%>
											name="chosenField" />
										</span>
										<%
											int found = 0;
											for (int i = startNr; i < size; i++) {
												found = 0;
												for (int x = startNr; x < tempList.size(); x++) {
													//System.out.println("tempList.get(2)" + tempList.get(x));
													if (chFieldName[i].equals(tempList.get(x))) {
														tempList.remove(x);
														found = 1;
										%>
										<span class=checkboxStyle> <input type="checkbox"
											value=<%=enFieldName[i]%> name="chosenField" checked /><%=chFieldName[i]%>
										</span>
										<%
											break;
													}
												}
												if (found == 0) {
										%>
										<span class=checkboxStyle> <input type="checkbox"
											value=<%=enFieldName[i]%> name="chosenField" /><%=chFieldName[i]%>
										</span>
										<%
											}
											}
										%>
										<span class=checkboxStyle> <input type="submit"
											value="确定"
											style="font-size:8px; padding: 0 18px;line-height: 18px; height: 18px;"
											class="button button-action button-rounded"
											onclick="fieldsetHide()" />
										</span>
									</fieldset>
								</form>
							</div> <br>
							<form id="list" name="list" action="deleteExpert" method="post"
								target="_self">
								<table id="infoTable" width="100%" border="0" align="left"
									cellpadding="0" cellspacing="1" bgcolor="#c0de98"
									onmouseover="changeto()" onmouseout="changeback()">
									<tr>
										<th width="1%" background="images/tab_14.gif" class="STYLE1"
											id="headline"><input type="checkbox" name="chooseAll"
											value="" onclick="CheckSelect()" /></th>
										<th width="5%" height="18" background="images/tab_14.gif"
											class="STYLE1">序号</th>
										<th width="8%" height="18" background="images/tab_14.gif"
											class="STYLE1"><%=chDefaultFieldList.get(0)%></th>
										<th width="8%" height="18" background="images/tab_14.gif"
											class="STYLE1"><%=chDefaultFieldList.get(1)%></th>
										<%
											for (int i = 2; i < chDefaultFieldList.size(); i++) {
										%>
										<th width="8%" height="18" background="images/tab_14.gif"
											class="STYLE1"><%=chDefaultFieldList.get(i)%></th>
										<%
											}
										%>
										<!-- <th width="8%" height="18" background="images/tab_14.gif"
											class="STYLE1">姓名</th>
										<th width="5%" height="18" background="images/tab_14.gif"
											class="STYLE1">性别</th>
										<th width="10%" height="18" background="images/tab_14.gif"
											class="STYLE1">出生日期</th>
										<th width="10%" height="18" background="images/tab_14.gif"
											class="STYLE1">工作单位</th>
										<th width="17%" height="18" background="images/tab_14.gif"
											class="STYLE1">现任高评委名称</th>
										<th width="10%" height="18" background="images/tab_14.gif"
											class="STYLE1">现任高评委职务</th>
										<th width="10%" height="18" background="images/tab_14.gif"
											class="STYLE1">所属专业组</th>
										<th width="10%" height="18" background="images/tab_14.gif"
											class="STYLE1">专业组职务</th> -->
									</tr>
									<%
										for (int i = 0; i < expertList.size(); i++) {
									%>
									<tr class="list">
										<td><input type="checkbox" name="zjgl_infoList_checkbox"
											value=<%=expertList.get(i).getExpert_Field1()%> /></td>
										<td><%=i + 1%></td>
										<td><%=expertList.get(i).getExpert_Field1()%></td>
										<td><s:url id="url" action="to_infoBrowsing.action">
												<s:param name="expert_no"><%=expertList.get(i).getExpert_Field1()%></s:param>
											</s:url> <s:a href="%{url}" style="font-size:14px;" target="_blank"><%=expertList.get(i).getExpert_Field2()%></s:a>
										</td>
										<%
											for (int j = 2; j < chDefaultFieldList.size(); j++) {
										%><!-- 编号和专家姓名一定显示 -->
										<td><%=expertList.get(i).getExpert(
							Integer.parseInt(intDefaultFieldList.get(j)))%></td>
										<%
											}
										%>
									</tr>
									<%
										}
									%>
									<!-- <tr class="list">
										<td><input type="checkbox" name="zjgl_infoList_checkbox"
											value="2" /></td>
										<td>2</td>
										<td>20140102</td>
										<td><a style="font-size:14px;" target="_blank"
											href="./zjgl_infoBrowsing_gpw.jsp">陈伟涛</a></td>
										<td>男</td>
										<td>1950/12/31</td>
										<td>浙江工业大学</td>
										<td>浙江工业大学浙江工业大学高评委</td>
										<td>高评委职务</td>
										<td>电子组</td>
										<td>组员</td>
									</tr>
 -->
								</table>
							</form> <!-- 分页  -->
							<div class=pageDiv>
								<tr><td align="center" colspan=2><%=bar %></td></tr>
							</div>
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
