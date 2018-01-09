<%@ page language="java" import="java.util.*,gpw.object.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML>
<html>
<head>
<title>抽取规则管理</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/buttons.css">
<link rel="stylesheet" href="css/universal.css">
<script type="text/javascript" src="js/universal.js"></script>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/json2.js"></script>

<style type="text/css">
.inputPrecent {
	width:40px;
}

</style>

<script>
$(function(){
	$("#conditionSelect").change(function(){
	 	var value = $(this).children('option:selected').val();
	 	var HtmlBlock = "";
		if(value == "年龄"){
			HtmlBlock = " <select id='conditionSign'><option>等于</option> <option>大于</option><option>小于</option></select> <input id='conditionValue'/>";
		}else if(value == "资格级别"){
			HtmlBlock = " <select id='conditionSign'><option>等于</option> </select> <select id='conditionValue'> <option>正高级</option> <option>副高级</option> </select>";
		}
		$("#additionSpan").html(HtmlBlock);
	});
	$("#conditionSelect,#additionSpan,#percentageSign,#percentageValue,#range").on("change",function(){
		preview();
	});
});
function preview() {
	isNull = false;
	//alert(isNull);
	$("#conditionSelect,#conditionSign,#conditionValue,#percentageSign,#percentageValue,#range").each(function(){
		if($(this).val() == ""){
			isNull = true;
		}
	});
	var HtmlBlock = "";
	if(isNull == false){
		HtmlBlock += $("#range").val() + "的高评委,";
		HtmlBlock += "抽取结果中" + $("#conditionSelect").val() + $("#conditionSign").val() + $("#conditionValue").val() + "的专家的人数";
		HtmlBlock += "需" + $("#percentageSign").val() + "总抽取人数的" + $("#percentageValue").val() + "%";
		$("#previewDiv").text(HtmlBlock);
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
						<td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
						<td width="1101" background="images/tab_05.gif"><img src="images/311.gif" width="16"
								height="16" /> <span class="STYLE4">抽取规则管理</span></td>
						<td background="images/tab_05.gif"></td>
						<td width="15"><img src="images/tab_07.gif" width="16" height="30" /></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<!-- <form id="theForm" name="theForm" action="" method="post" style="margin:0"> -->
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="9" background="images/tab_12.gif">&nbsp;</td>
							<td bgcolor="#f3ffe3" align="center">
								<form style="margin:0;" action="cxtj_query.action">
								<table width="97%" border="0" align="center" cellpadding="0" cellspacing="1"
									bgcolor="#c0de98" style="margin-top:10px;">
									<tr>
										<td class="leftTd" align="right">
											<label for="">规则编号</label>
										</td>
										<td class="rightTd">
											0003
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">
											<label for="conditionSelect">规则定义</label>
										</td>
										<td class="rightTd">
											<select id="conditionSelect" >
												<option value=""></option>
												<option value="年龄">年龄</option>
												<option value="资格级别">资格级别</option>
											</select>
											<span id="additionSpan"></span>
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">
											<label for="">规则比例</label>
										</td>
										<td class="rightTd">
											<select id="percentageSign">
												<option value="等于">等于</option>
												<option value="大于">大于</option>
												<option value="小于">小于</option>
											</select>
											<input id="percentageValue"/>
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">
											<label for="">适用范围</label>
										</td>
										<td class="rightTd">
											<select id="range">
												<option value="所有">所有</option>
												<option value="正高职称">正高职称</option>
												<option value="副高职称">副高职称</option>
												<option value="正副合一">正副合一</option>
											</select>
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">
											<label for="">是否强制</label>
										</td>
										<td class="rightTd">
											<select>
												<option value="">否</option>
												<option value="">是</option>
											</select>
										</td>
									</tr>

									<tr>
										<td class="leftTd" align="right">
											<label for="">是否启用</label>
										</td>
										<td class="rightTd">
											<select>
												<option value="">否</option>
												<option value="">是</option>
											</select>
										</td>
									</tr>
									<tr>
										<td style="background-color: #FFFFFF;height: 30px;text-align:center;color:#99CC33;font-size:14px" colspan="2">
											<div id="previewDiv"></div>
										</td>
									</tr>
								</table>
								<div style="width:97%">
									<input style="font-size:15px;margin-top:10px;line-height: 27px; height: 27px;"
										class="button button-action button-rounded" type="submit" value="保存" />
								</div>
							</form>
							</td>
							<td width="9" background="images/tab_16.gif">&nbsp;</td>
						</tr>
					</table>
			<!-- 	</form> -->
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
