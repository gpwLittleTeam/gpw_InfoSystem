<%@ page language="java" import="java.util.*,gpw.object.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>结果统计</title>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/buttons.css">
		<link rel="stylesheet" href="css/universal.css?a=1">
		<script type="text/javascript" src="js/universal.js"></script>
		<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	</head>
	<body>
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
							<fieldset style="width:97%; border-color:#c0de98; border-width: 2px;" align="left">
								<legend class="STYLE1">最终抽取结果：(总人数为：${directorListSize+viceDirectorListSize+committeeListSize })</legend>
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
							</fieldset>
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