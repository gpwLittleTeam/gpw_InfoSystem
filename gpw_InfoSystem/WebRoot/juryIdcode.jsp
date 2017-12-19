<%@ page language="java"
	import="java.util.*,gpw.object.*,java.sql.ResultSet,java.sql.Connection,views.View"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	List<JuryIdcode> juryIdcodes = (List<JuryIdcode>) request.getSession().getAttribute("juryIdcodes");   //列表里要显示的专家
//	System.out.println("JSP: "+expertList.get(0).getExpert_Field2());
	request.getSession().setAttribute("juryIdcodes", juryIdcodes);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>生成验证码</title>
<link rel="stylesheet" href="css/buttons.css">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/buttons.css" type="text/css">
<link rel="stylesheet" href="css/universal.css">
<script type="text/javascript" src="js/universal.js"></script>
<script type="text/javascript" src="js/juryIdcode.js"></script> 
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/jquery.alertWindowForIdcode.min.js?a=12"></script>
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
	font-size: 12px
}

.list  td {
	text-align: center;
	background-color: #FFFFFF;
	font-size: 14px;
	height: 26px;
}
</style>

<script>
	$.ajaxSetup({  //同步处理
    	async : false  
	});    

	
	function doCheck(form) {
		//
		var file = $("#excelFile").val();
		/* alert(file); */
		if(file == '' || file == null){
			alert("请选择要上传的文件");
			/* $("#error").html("请选择要上传的文件！"); */
		}else{
			var index = file.lastIndexOf(".");
			/* alert(index); */
			if(index < 0){
				/* $("#error").html("上传文件格式不正确，请选择xls或xlsx文件"); */
				alert("上传文件格式不正确，请选择xls或xlsx文件");	
			}else{
				var ext = file.substring(index+1, file.length);
				/* alert(ext); */
				if(ext != "xls" && ext != "xlsx"){
					/* $("#error").html("上传文件格式不正确，请选择xls或xlsx文件"); */
					alert("上传文件格式不正确，请选择xls或xlsx文件")
				}else{
				form.action = 'inportExcel.action';
				form.submit();
				}
			}
		}	
	};
	
	function showManagement() {
		//alert("showmanagement");
		//ajax 获取
		var htmlBlock = '<form id="generateIdcode"  name="generateIdcode"  action="" method="post" enctype="multipart/form-data" style="margin:0">' +
							'<table width="100%" border="0" cellspacing="0" cellpadding="0">' +
						 		'<tr>' + 
						 		  '<td>' +
								   '</td>' +
								   '<td align="right">' +
								 	  '<div class="button-group" >' +
								 	  	'<input type="file" name="excelFile" id="excelFile"/><input type="button" value="外部导入Excel" style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px;border-radius:5px 5px 5px 5px;" class="button button-pill button-action" onclick="doCheck(document.generateIdcode)"/>' +
										/* '<button type="button" style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px;border-radius:0 5px 5px 0;" class="button button-pill button-action" onclick="">生成验证码</button>' + */ 
									  '</div>' +
								   '</td>' + 
								'</tr>' +
							'</table>' + 
							'<br>' +
							'<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98">' +
								'<tr>' +
									'<th width="1%" background="images/tab_14.gif" class="STYLE1" >' +
										'<input type="checkbox" name="checkbox"  value="0" onclick="CheckSelect()"/></th>' +
									'<th width="15%" height="18" background="images/tab_14.gif" class="STYLE1">专家姓名</th>' +
									'<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">手机号码</th>' +
									'<th width="15%" height="18" background="images/tab_14.gif" class="STYLE1">操作</th>' +
									'<th width="25%" height="18" background="images/tab_14.gif" class="STYLE1">验证码</th>' +
									'<th width="25%" height="18" background="images/tab_14.gif" class="STYLE1">生效时间</th>' +
								'</tr>' +
								'<tr class="list">' + 
									'<td><input type="checkbox" name="checkbox"  value="1"/></td>' +
									'<td class=input-td><input id="expertName" class="input-text" type="text"/></td>' +
									'<td class=input-td><input id="expertPhone" class="input-text" type="text"/></td>' +
									'<td><a onclick="showRandomNum()">生成验证码</a></td>' +
									'<td class=input-td><input id="expertIdcode" class="input-text" type="text" style="border:0; font-weight:bold" value=""/ readonly></td>' +
									'<td class=input-td><input id="expertIdcodeTime" class="input-text" type="text" style="border:0; font-weight:bold" value=""/ readonly></td>' +
								'</tr>' +
								'</table>' +
								'</form>';
		//alert(htmlBlock);
		jQuery.alertWindow("生成验证码", htmlBlock, "#A5DE37"); 
	}
	
	function showRandomNum() {
	 //ajax 获取
	 //alert($("#expertName").val());
	 var expertName = $("#expertName").val();
	 var expertPhone = $("#expertPhone").val();
	 if(expertName != "" && expertPhone != ""){
	 	var htmlBlock = "";
		$.post("showRandomNum.action", {expertName:expertName,expertPhone:expertPhone}, function(data) {
			
			//console.log(data); //
			//console.log(data.resultString); 
			var randomNum = JSON.parse(data.resultString);
			$.each(randomNum, function(i, list) {
				$("#expertIdcode").val(list.random);
				$("#expertIdcodeTime").val(list.time);
			}); 
		});
		//alert(htmlBlock);
		/* jQuery.alertWindow("录入密码(有效期1天)", htmlBlock, "#A5DE37"); */ 
	 }
	 else{
	 	alert("请输入姓名和号码");
	 }
		
	}
// function CheckSelect()  
// {  
//   // 遍历 form  
// 	 var aCheckbox=document.getElementsByName("checkbox");
// 	 if (aCheckbox[0].checked == true)  
// 	 {
	 		 
// 	  	for ( var i = 1; i < aCheckbox.length; i++)  
// 	  	{  
// 	     aCheckbox[i].checked = true;  
// 		}
// 	 }
// 	else  
// 	{  
// 		for ( var i = 1; i < aCheckbox.length; i++)  
// 	  	{  
// 	     aCheckbox[i].checked = false;  
// 		}
// 	} 
// }
// function MCheckSelect()  
// {  
//   // 遍历 form  
// 	 var aCheckbox=document.getElementsByName("Mcheckbox");
// 	 if (aCheckbox[0].checked == true)  
// 	 {
	 		 
// 	  	for ( var i = 1; i < aCheckbox.length; i++)  
// 	  	{  
// 	     aCheckbox[i].checked = true;  
// 		}
// 	 }
// 	else  
// 	{  
// 		for ( var i = 1; i < aCheckbox.length; i++)  
// 	  	{  
// 	     aCheckbox[i].checked = false;  
// 		}
// 	} 
// }

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
							class="STYLE4">验证码管理</span></td>
						<td  background="images/tab_05.gif"></td>
						<td width="15"><img src="images/tab_07.gif" width="16"
							height="30" /></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<form id="theForm"  name="theForm"  action="" method="post" style="margin:0">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="9" background="images/tab_12.gif">&nbsp;</td>
						<td bgcolor="#f3ffe3" align="center">
						 	<table width="100%" border="0" cellspacing="0" cellpadding="0">
						 		<tr>
						 		  <td>
								   </td>
								   <td align="right">
								 	  <div class="button-group" >
								 	  	<!-- <button type="button"
													style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px;border-radius:5px 0 0 5px;"
													class="button button-pill button-action"
													onclick="">导入</button> -->
										<button type="button" 
													style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px;border-radius:5px 0 0 5px;" class="button button-pill button-action" onclick="deleteJuryIdcode(document.theForm,'验证码','deleteJuryIdcode.action')">删除</button>
										<button type="button" 
													style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px;" 
													class="button button-pill button-action" onclick="updateJuryIdcode(document.theForm,'验证码','updateJuryIdcode.action')">再生效</button>
										<!-- <button type="button"
													style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px"
													class="button button-pill button-action">导出</button> -->
										<!-- <button type="button"
													style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px"
													class="button button-pill button-action">批量生成</button> -->
										<button type="button"
													style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px;border-radius:0 5px 5px 0;"
													class="button button-pill button-action"
													onclick="showManagement()">生成验证码</button>
									  </div>
								   </td>
								</tr>
							</table>
						<br>
							<table width="100%" border="0" align="center" cellpadding="0"
								cellspacing="1" bgcolor="#c0de98" onmouseover="changeto()"
								onmouseout="changeback()">
								<tr>
									<th width="1%" background="images/tab_14.gif"
										class="STYLE1" >
										<input type="checkbox" name="chooseAll"  value="0" onclick="CheckSelect()"/>
									</th>
									<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">专家姓名</th>
									<th width="25%" height="18" background="images/tab_14.gif" class="STYLE1">手机号码</th>
									<th width="25%" height="18" background="images/tab_14.gif" class="STYLE1">验证码</th>
									<th width="30%" height="18" background="images/tab_14.gif" class="STYLE1">生效时间</th>
							
								</tr>
								<s:iterator id="juryIdcodes" value="juryIdcodes" status="count">
									<tr class="list">
										<td>
											<input type="checkbox"  id="checkbox<s:property value="#count.index+1"/>" name="nrOfCheckbox" value='{"expert_name":"<s:property value="#juryIdcodes.expert_name" />","expert_phone":"<s:property value="#juryIdcodes.expert_phone"/>"}' />
										</td>
										<!-- <td>
											<s:property value="#count.index+1" />
										</td> -->
										<td>
											<s:property value="#juryIdcodes.expert_name" />
											<input type="hidden" name="expert_name" value="<s:property value="#juryIdcodes.expert_name" />"/>
										</td>
										<td>
											<s:property value="#juryIdcodes.expert_phone" />
										</td>
										<td>
											<s:property value="#juryIdcodes.id_code" />
										</td>
										<td>
											<s:property value="#juryIdcodes.code_insert_time" />
										</td>
									</tr>
								</s:iterator>
								
								<!-- '<tr>' + 
								"<td><input type=\"checkbox\" name=\"Mcheckbox\"  value='{\"expert_name\":\""+list.expert_name+"\",\"expert_phone\":\""+list.expert_phone+"\"}'/></td>" + 
									'<td class=input-td><input id="MexpertName" class="input-text" type="text" style="border:0; font-weight:bold" value="'+list.expert_name+'"/></td>' +
									'<td class=input-td><input id="MexpertPhone" class="input-text" type="text" style="border:0; font-weight:bold" value="'+list.expert_phone+'"/></td>' +
									'<td class=input-td><input id="MidCode" class="input-text" type="text" style="border:0; font-weight:bold" value="'+list.id_code+'"/></td>' +
									'<td class=input-td><input id="McodeInsertTime" class="input-text" type="text" style="border:0; font-weight:bold" value="'+list.code_insert_time+'"/></td>' +
								'</tr>'; -->
								<!-- <tr class="list">
									<td><input type="checkbox" name="checkbox"  value="1"/></td>
									<td class=input-td><input id="expertName" class="input-text" type="text"/></td>
									<td class=input-td><input id="expertPhone" class="input-text" type="text"/></td>
									<td><a onclick="showRandomNum()">生成验证码</a></td>
									<td class=input-td><input id="expertIdcode" class="input-text" type="text" style="border:0; font-weight:bold" value=""/ readonly></td>
									<td class=input-td><input id="expertIdcodeTime" class="input-text" type="text" style="border:0; font-weight:bold" value=""/ readonly></td>
								</tr> -->
								</table>
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
