<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML>
<html>
<head>

<title>抽取委员会</title>
<link rel="stylesheet" href="css/buttons.css">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/d3.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/universal.css?v=<%= System.currentTimeMillis()%>"/>
<link rel="stylesheet" href="css/universal.css"/>
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

/*D3*/
.arc text {
  font: 10px sans-serif;
  text-anchor: middle;
}

.arc path {
  stroke: #fff;
}

-->
</style>

<script type="text/javascript">
	var saveSuccess = 0;
	function saveResult() {
		$.post("addHistoryTitleForWYH.action", function(data) {
			console.log(data.feedback); //
			var feedback = data.feedback;
			if(feedback == "保存成功！") {
				alert(feedback);
				saveSuccess = 1;
				$("#feedbackNav").html(feedback);
			}
		});
	}
	
	function checkLeave() {
		if(saveSuccess != 1){
			event.returnValue="您还未保存抽取结果";
		}
	};

</script>
</head>

<body onbeforeunload="checkLeave()">
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="30">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
						<td width="1101" background="images/tab_05.gif"><img src="images/311.gif" width="16"
								height="16" /> <span class="STYLE4">结果统计</span></td>
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
							<nav id="feedbackNav" class="feedbackNav"><s:property value="feedback"/></nav>
							<fieldset style="width:97%; border-color:#c0de98; border-width: 2px;" align="left">
								<legend class="STYLE1">最终抽取结果：(总人数为：6)</legend>
								<table class="normalDisplayTable">
								<!-- width="99%" border="0" align="center" cellpadding="0" cellspacing="1"
								bgcolor="#c0de98" -->
								<tr class="STYLE7">
									<td rowspan="${directorListSize+1 }" width=20% bgcolor="#FFFFFF">
											<span>主任委员抽取结果</span>
									</td>
									<th height="18" background="images/tab_14.gif" class="STYLE1">专家编号</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">专家姓名</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">专家性别</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">拟任高评委职务</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">所属专业组名称</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">资格级别</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">所获学位</th>
								</tr>
								<s:iterator id="expert" value="listDirector">
									<tr>
										<td><s:property value="#expert.Expert_Field1" /></td>
										<td><s:property value="#expert.Expert_Field2" /></td>
										<td><s:property value="#expert.Expert_Field3" /></td>
										<td><s:property value="#expert.Expert_Field32" /></td>
										<td><s:property value="#expert.Expert_Field33" /></td>
										<td><s:property value="#expert.Expert_Field18" /></td>
										<td><s:property value="#expert.Expert_Field7" /></td>
									</tr>
								</s:iterator>
								
								
								<tr class="STYLE7">
									<td rowspan="${viceDirectorListSize+1 }" width=20% bgcolor="#FFFFFF">
										<span>副主任委抽取结果</span>
									</td>
									<th height="18" background="images/tab_14.gif" class="STYLE1">专家编号</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">专家姓名</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">专家性别</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">拟任高评委职务</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">所属专业组名称</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">资格级别</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">所获学位</th>
								</tr>
								<s:iterator id="expert" value ="listViceDirector">
									<tr>
										<td><s:property value="#expert.Expert_Field1" /></td>
										<td><s:property value="#expert.Expert_Field2" /></td>
										<td><s:property value="#expert.Expert_Field3" /></td>
										<td><s:property value="#expert.Expert_Field32" /></td>
										<td><s:property value="#expert.Expert_Field33" /></td>
										<td><s:property value="#expert.Expert_Field18" /></td>
										<td><s:property value="#expert.Expert_Field7" /></td>
									</tr>
								</s:iterator>
								
								
								<tr align="center" class="STYLE7">
									<td rowspan="${committeeListSize+1 }" width=20% bgcolor="#FFFFFF">
										<span>委员抽取结果</span>
									</td>
									<th height="18" background="images/tab_14.gif" class="STYLE1">专家编号</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">专家姓名</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">专家性别</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">拟任高评委职务</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">所属专业组名称</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">资格级别</th>
									<th height="18" background="images/tab_14.gif" class="STYLE1">所获学位</th>
								</tr>
								<s:iterator id="expert" value ="listCommittee">
									<tr>
										<td><s:property value="#expert.Expert_Field1" /></td>
										<td><s:property value="#expert.Expert_Field2" /></td>
										<td><s:property value="#expert.Expert_Field3" /></td>
										<td><s:property value="#expert.Expert_Field32" /></td>
										<td><s:property value="#expert.Expert_Field33" /></td>
										<td><s:property value="#expert.Expert_Field18" /></td>
										<td><s:property value="#expert.Expert_Field7" /></td>
									</tr>
								</s:iterator>
								</table>
								<div class="STYLE7" style="width:100%;margin:5px 0px;text-align:center">
									<button type="button"
										style="font-size:8px; padding: 0 22px;line-height: 20px; height: 20px;" name="lastmove"
										class="button button-action button-rounded">导出</button>
									<button type="button"
										style="font-size:8px; padding: 0 22px;line-height: 20px; height: 20px;" name="lastmove"
										class="button button-action button-rounded" onclick="saveResult()">保存</button>
								</div>

							</fieldset>

							<div class="STYLE7" style="width:100%;margin:5px 0px;text-align:center">
								<button type="button"
									style="font-size:8px; padding: 0 22px;line-height: 20px; height: 20px;" name="lastmove"
									class="button button-action button-rounded" onclick="location.href='to_pwcq_wyh!backResult.action'">上一步</button>
								<button type="button"
									style="font-size:8px; padding: 0 22px;line-height: 20px; height: 20px;" name="finish"
									class="button button-action button-rounded" onclick="location.href='./index.jsp'">关闭</button>

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
