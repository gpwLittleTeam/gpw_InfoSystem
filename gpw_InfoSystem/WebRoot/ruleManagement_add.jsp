<%@ page language="java" pageEncoding="UTF-8"%>
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
	 	var type = $(this).children('option:selected').attr('fieldType');
	 	var code = $(this).children('option:selected').attr('fieldCode');
	 	var HtmlBlock = "";
		if(type == "3"){
			HtmlBlock = " <select id='conditionSign' name='conditionSign'><option value='=='>等于</option> <option value='>='>大于等于</option><option value='<='>小于等于</option></select> <input id='conditionValue' name='conditionValue'/>";
			$("#additionSpan").html(HtmlBlock);
		}else if(type == "1"){
			HtmlBlock = " <select id='conditionSign' name='conditionSign'><option value='equal'>等于</option> </select>";
			HtmlBlock += " <select id='conditionValue' name='conditionValue'>";
			
			$.post("getCodeList", {fieldCode:code}, function(data){
				//alert(1);
				//console.log(data);
				var listCodeModel = JSON.parse(data.jsonListCodeModel);
				//console.log(listCodeModel);
				$.each(listCodeModel, function(i, listCodeModel){
					//alert(listCodeModel.codeName);
					HtmlBlock += "<option value=" + listCodeModel.codeNo + ">"+ listCodeModel.codeName +"</option>";
				});
				HtmlBlock += "</select>";
				$("#additionSpan").html(HtmlBlock);
			});
		}
	});
	$("#conditionSelect,#additionSpan,#percentageSign,#percentageValue,#range").on("change",function(){
		//暂时先注释，以后有时间再改一下
		preview();
	});
});
function preview() {
	isNull = false;
	var HtmlBlock = "";
	var type = $("#conditionSelect").children('option:selected').attr('fieldType');
	//alert(isNull);
	$("#conditionSelect,#conditionSign,#conditionValue,#percentageSign,#percentageValue,#range").each(function(){
		if($(this).val() == ""){
			isNull = true;
			return;
		}
	});
	
	if(isNull == false){
		if(type==1) {
			$.post("getPreview", {ruleField:$("#conditionSelect").find("option:selected").val(),
				  ruleRelation:$("#conditionSign").find("option:selected").val(),
				  ruleValue:$("#conditionValue").find("option:selected").val(),
				  rulePrecent:$("#percentageValue").val(),
				  rulePrecentRelation:$("#percentageSign").find("option:selected").val()
				  }, function(data){
				  		HtmlBlock += data.ruleContent;
				  		$("#previewDiv").text(HtmlBlock);
					}
			);
		} else {
			$.post("getPreview", {ruleField:$("#conditionSelect").find("option:selected").val(),
				  ruleRelation:$("#conditionSign").find("option:selected").val(),
				  ruleValue:$("#conditionValue").val(),
				  rulePrecent:$("#percentageValue").val(),
				  rulePrecentRelation:$("#percentageSign").find("option:selected").val()
				  }, function(data){
				  		HtmlBlock += data.ruleContent;
				  		$("#previewDiv").text(HtmlBlock);
					}
			);
		}
/* 		HtmlBlock += $("#range").find("option:selected").text() + "的高评委,";
		HtmlBlock += "抽取结果中" + $("#conditionSelect").find("option:selected").text() + $("#conditionSign").find("option:selected").text() + $("#conditionValue").find("option:selected").text() + "的专家的人数";
		HtmlBlock += "需" + $("#percentageSign").find("option:selected").text() + "总抽取人数的" + $("#percentageValue").val() + "%";
		$("#previewDiv").text(HtmlBlock); */
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
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="9" background="images/tab_12.gif">&nbsp;</td>
							<td bgcolor="#f3ffe3" align="center">
								<form action="addRule" method="post" style="margin:0;" action="cxtj_query.action">
								<table width="97%" border="0" align="center" cellpadding="0" cellspacing="1"
									bgcolor="#c0de98" style="margin-top:10px;">
									<tr>
										<td class="leftTd" align="right">
											规则编号
										</td>
										<td class="rightTd">
											<s:property value="ruleNo"/>
											<input type="hidden" name ="ruleNo" value="<s:property value='ruleNo'/>">
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">
											<label for="conditionSelect">规则定义</label>
										</td>
										<td class="rightTd">
											<select id="conditionSelect" name="conditionSelect">
												<option value=""></option>
												<s:iterator id="list" value="listRuleField">
													<option value="<s:property value='#list.field_name'/>" fieldCode="<s:property value='#list.field_code'/>"  fieldType="<s:property value='#list.field_type'/>"><s:property value='#list.field_chname'/></option>
												</s:iterator>
											</select>
											<span id="additionSpan"></span>
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">
											<label for="percentageSign">规则比例</label>
										</td>
										<td class="rightTd">
											<select id="percentageSign" name="percentageSign">
												<option value=">=">大于等于</option>
												<option value="<=">小于等于</option>
												<option value="==">等于</option>
											</select>
											<input id="percentageValue" name="percentageValue"/>
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">
											<label for="range">适用范围</label>
										</td>
										<td class="rightTd">
											<select id="range" name="range">
												<option value="0">所有</option>
												<s:iterator id="list" value="listPermissions">
													<option value="<s:property value='#list.codeNo'/>"><s:property value='#list.codeName'/></option>
												</s:iterator>
											</select>
										</td>
									</tr>
									<tr>
										<td class="leftTd" align="right">
											<label for="force">是否强制</label>
										</td>
										<td class="rightTd">
											<select id="force" name="force">
												<option value="0">否</option>
												<option value="1">是</option>
											</select>
										</td>
									</tr>

									<tr>
										<td class="leftTd" align="right">
											<label for="enabled">是否启用</label>
										</td>
										<td class="rightTd">
											<select id="enabled" name="enabled">
												<option value="0">否</option>
												<option value="1">是</option>
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
