<%@ page language="java" import="java.util.*,gpw.object.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
//	List<JuryIdcode> juryIdcodes = (List<JuryIdcode>) request.getSession().getAttribute("juryIdcodes");   //列表里要显示的专家
//	System.out.println("JSP: "+expertList.get(0).getExpert_Field2());
//	request.getSession().setAttribute("juryIdcodes", juryIdcodes);
%>
<!DOCTYPE HTML>
<html>
<head>
<title>验证码管理</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/buttons.css">
<link rel="stylesheet" href="css/universal.css?a=1">
<script type="text/javascript" src="js/universal.js"></script>
<script type="text/javascript" src="js/juryIdcode.js"></script>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/jquery.alertWindowForIdcode.min.js?a=12"></script>

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
	function customInvalidTime(obj,date,name,phone) {
		var htmlBlock = '';
		date = date.substring(0,10);
		htmlBlock = "<input type='date' value='" + date + "' onblur=\"updateInvalidTime(this,'" + name + "','" + phone + "')\"/>";
		//alert(htmlBlock);
		$(obj).parent().siblings().html(htmlBlock);
	}
	
	function updateInvalidTime(obj, name ,phone) {
		
		$.post("updateInvalidTime.action", {invalidTime: $(obj).val(), expertName: name, expertPhone: phone},function(data){
			//alert(data.newAuthCode);
			var newAuthCode = data.newAuthCode;

			$("#feedbackNav").html(data.resultString);
			$(obj).parent().parent().prev().prev().html(data.newAuthCode);
			$(obj).parent().html(data.newTime);
		});
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
								height="16" /> <span class="STYLE4">验证码管理</span></td>
						<td background="images/tab_05.gif"></td>
						<td width="15"><img src="images/tab_07.gif" width="16" height="30" /></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<form id="theForm" name="theForm" action="" method="post" style="margin:0">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="9" background="images/tab_12.gif">&nbsp;</td>
							<td bgcolor="#f3ffe3" align="center">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td></td>
										<td >
											<span class="button-group" style="margin-right:1%;float: right">
												<button type="button"
													style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px;border-radius:5px 0 0 5px;"
													class="button button-pill button-action"
													onclick="window.location.href='to_authCode_add.action'">增加</button>
												<button type="button"
													style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px;"
													class="button button-pill button-action"
													onclick="updateJuryIdcode(document.theForm,'验证码','updateJuryIdcode.action')">再生效</button>
												<button type="button"
													style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px;border-radius:0 0 0 0;"
													class="button button-pill button-action"
													onclick="deleteJuryIdcode(document.theForm,'验证码','deleteJuryIdcode.action')">删除</button>
												<button type="button"
													style="font-size:15px;  width:130px;padding:0 10px;height:27px;line-height:27px;border-radius:0 0 0 0;"
													class="button button-pill button-action"
													onclick="deleteJuryIdcode(document.theForm,'验证码','deleteJuryIdcode.action')">发送短信</button>
												<button type="button"
													style="font-size:15px;  width:130px;padding:0 10;height:27px;line-height:27px;border-radius:0 5px 5px 0;"
													class="button button-pill button-action"
													onclick="window.open('to_authCode_print.action')">打印</button>
											</span>
										</td>
									</tr>
								</table>
								<nav id="feedbackNav" class="feedbackNav"></nav>
								<table class="list" align="center" style="margin-top:0px;"
									 onmouseover="changeto()" onmouseout="changeback()">
									<tr>
										<th width="1%" background="images/tab_14.gif" class="STYLE1"><input type="checkbox"
											name="chooseAll" value="0" onclick="CheckSelect()" /></th>
										<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">专家姓名</th>
										<th width="25%" height="18" background="images/tab_14.gif" class="STYLE1">手机号码</th>
										<th name="authCode" width="25%" height="18" background="images/tab_14.gif" class="STYLE1">验证码</th>
										<th name="state" width="25%" height="18" background="images/tab_14.gif" class="STYLE1">状态</th>
										<th width="30%" height="18" background="images/tab_14.gif" class="STYLE1" style="min-width:290px;">失效时间</th>

									</tr>
									<s:iterator id="juryIdcodes" value="juryIdcodes" status="count">
										<tr class="list">
											<td ><input type="checkbox" id="checkbox<s:property value="#count.index+1"/>"
												name="nrOfCheckbox"
												value='{"expert_name":"<s:property value="#juryIdcodes.expert_name" />","expert_phone":"<s:property value="#juryIdcodes.expert_phone"/>"}' />
											</td>
											<td><s:property value="#juryIdcodes.expert_name" /> <input type="hidden"
												name="expert_name" value="<s:property value="#juryIdcodes.expert_name" />" /></td>
											<td><s:property value="#juryIdcodes.expert_phone" /></td>
											<td><s:property value="#juryIdcodes.id_code" /></td>
											<td><s:property value="#juryIdcodes.state" /></td>
											<td style="position:relative">
												<span>
													<s:property value="#juryIdcodes.code_invalid_time" />
												</span>
												<span style="position:absolute; right:20px; top:3px">
													<input type="button" class="button button-action button-rounded" style="font-size:8px; padding: 0 9px;line-height: 20px; height: 20px;" value="自定义" onclick="customInvalidTime (this,'<s:property value="#juryIdcodes.code_invalid_time" />','<s:property value="#juryIdcodes.expert_name" />','<s:property value="#juryIdcodes.expert_phone" />')"/>
												</span>
											</td>
										</tr>
									</s:iterator>
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
