<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
<head>
<title>抽取委员会</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<link rel="stylesheet" href="css/buttons.css">
<link rel="stylesheet" type="text/css" href="css/universal.css?v=<%=System.currentTimeMillis()%>" />
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
<script type="text/javascript">
	function drawCommittee() {
		if ($("tr[name='resultExpert']").length == 0) {
			$.post("drawingCommittee.action", {}, function(data) {
				var jsonListCommittee = JSON.parse(data.jsonListCommittee);
				//	console.log(jsonListCommittee);
				var htmlBlock = "";
				$.each(jsonListCommittee, function(i, jsonListCommittee) {
					htmlBlock += "<tr name='resultExpert' ><td>"
							+ jsonListCommittee.expert_Field1 + "</td><td>"
							+ jsonListCommittee.expert_Field2 + "</td><td>"
							+ jsonListCommittee.expert_Field3 + "</td><td>"
							+ jsonListCommittee.expert_Field32 + "</td></tr>";
				});
				$("#resultTable").append(htmlBlock);
		//		$("#resultTd").attr("rowspan", jsonListCommittee.length + 1);
			});
		} else {
			alert("已有抽取结果，点击“重抽”来重新抽取");
		}
	}

	function reDrawCommittee() {
		if ($("tr[name='resultExpert']").length != 0) {
			$.post("drawingCommittee.action", {}, function(data) {
				var jsonListCommittee = JSON.parse(data.jsonListCommittee);
				//	console.log(jsonListCommittee);
				var htmlBlock = "";
				$.each(jsonListCommittee, function(i, jsonListCommittee) {
					htmlBlock += "<tr name='resultExpert' ><td>"
							+ jsonListCommittee.expert_Field1 + "</td><td>"
							+ jsonListCommittee.expert_Field2 + "</td><td>"
							+ jsonListCommittee.expert_Field3 + "</td><td>"
							+ jsonListCommittee.expert_Field32 + "</td></tr>";
				});
				$("tr[name='resultExpert']").remove();
				$("#resultTable").append(htmlBlock);
		//		$("#resultTd").attr("rowspan", jsonListCommittee.length + 1);
			});
		} else {
			alert("请点击“抽取”按钮");
		}
	}

	function nextStep() {
		if ($("tr[name='resultExpert']").length != 0) {
			location.href = 'to_pwcq_wyh!resultPage.action';
		} else {
			alert("还未抽取委员候选人");
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
								height="16" /> <span class="STYLE4">抽取委员</span></td>
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
							<table style="width:98%;text-align:center;margin:10px 0px;">
								<tr>
									<td valign="top" style="width:45%">
										<table class="normalDisplayTable" style="width:100%">
											<tr>
												<th width="30%" height="18" background="images/tab_14.gif" class="STYLE1">专家编号</th>
												<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">专家姓名</th>
												<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">专家性别</th>
												<th width="30%" height="18" background="images/tab_14.gif" class="STYLE1">拟任高评委职务</th>
											</tr>
											<s:iterator id="committee" value="candidateCommittee">
												<tr>
													<td><s:property value="#committee.Expert_Field1" /></td>
													<td><s:property value="#committee.Expert_Field2" /></td>
													<td><s:property value="#committee.Expert_Field3" /></td>
													<td><s:property value="#committee.Expert_Field32" /></td>
												</tr>
											</s:iterator>
										</table>
									</td>
									<td style="width:10%">
										<div>
											<button type="button"
												style="font-size:8px; padding: 0 22px;line-height: 20px; height: 20px;" name="lastmove"
												class="button button-action button-rounded" onclick="drawCommittee()">抽取</button>
										</div>
										<div>
											<button type="button"
												style="font-size:8px; padding: 0 22px;line-height: 20px; height: 20px;" name="nextmove"
												class="button button-action button-rounded" onclick="reDrawCommittee()">重抽</button>
										</div>
									</td>
									<td valign="top" style="width:45%">
										<table class="normalDisplayTable" id="resultTable">
											<tr>
												<th width="30%" height="18" background="images/tab_14.gif" class="STYLE1">专家编号</th>
												<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">专家姓名</th>
												<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">专家性别</th>
												<th width="30%" height="18" background="images/tab_14.gif" class="STYLE1">拟任高评委职务</th>
											</tr>
											<s:if test="listCommittee!=null">
												<s:iterator id="expert" value="listCommittee">
													<tr name='resultExpert'>
														<td><s:property value="#expert.Expert_Field1" /></td>
														<td><s:property value="#expert.Expert_Field2" /></td>
														<td><s:property value="#expert.Expert_Field3" /></td>
														<td><s:property value="#expert.Expert_Field32" /></td>
													</tr>
												</s:iterator>
											</s:if>
										</table>
									</td>
								</tr>
								<tr>
									<td colspan="3">
										<div class="STYLE7" style="width:99%;margin:10px 0px;text-align:center">
											<button type="button"
												style="font-size:8px; padding: 0 22px;line-height: 20px; height: 20px;" name="lastmove"
												class="button button-action button-rounded"
												onclick="location.href='to_pwcq_wyh!backThird.action'">上一步</button>
											<button type="button"
												style="font-size:8px; padding: 0 22px;line-height: 20px; height: 20px;" name="nextmove"
												class="button button-action button-rounded" onclick="nextStep()">下一步</button>
										</div>
									</td>
								</tr>
							</table>
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
