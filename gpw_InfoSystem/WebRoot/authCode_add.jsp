<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML >
<html>
<head>
<title>增加授权</title>
<link rel="stylesheet" href="css/buttons.css">
<link rel="stylesheet" href="css/universal.css?a=2">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>

<style type="text/css">
.list td{
	height:30px;
}


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
</style>

<script type="text/javascript">
	function addMore() {
		var htmlBlock = "<tr><td><input type='text' name='expert_name'/></td>" + 
						"<td><input type='text'name='expert_phone'/></td>" + 
						"<td><a onclick=(deleteRow(this))>删除</a></td></tr>";
		$("tr[name='addMore']").before(htmlBlock);
		return 0;
	}
	function deleteRow(obj) {
		$(obj).parent().parent().remove();
	}
	
	$(function(){
//		alert("1");
		$("#excelFile").change(function(){
			$("#importData").submit();
		});
	});
	
// 	function doCheck(form) {
// 		alert("11");
// 		var file = $("#excelFile").val();
// 		/* alert(file); */
// 		if (file == '' || file == null) {
// 			alert("请选择要上传的文件");
// 			/* $("#error").html("请选择要上传的文件！"); */
// 		} else {
// 			var index = file.lastIndexOf(".");
// 			/* alert(index); */
// 			if (index < 0) {
// 				/* $("#error").html("上传文件格式不正确，请选择xls或xlsx文件"); */
// 				alert("上传文件格式不正确，请选择xls或xlsx文件");
// 			} else {
// 				var ext = file.substring(index + 1, file.length);
// 				/* alert(ext); */
// 				if (ext != "xls" && ext != "xlsx") {
// 					/* $("#error").html("上传文件格式不正确，请选择xls或xlsx文件"); */
// 					alert("上传文件格式不正确，请选择xls或xlsx文件")
// 				} else {
// 					alert("125"); 
// 					form.action = 'inportExcel.action';
// 					form.submit();
// 				}
// 			}
// 		}
// 	};
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
								height="16" /> <span class="STYLE4">增加授权</span></td>
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
							<form id="importData" name="importData" action="importExcel.action" method="post" enctype="multipart/form-data" style="width:80%;margin:10px;padding:0;text-align:right">
								<a href="" class="a-upload"> <input type="file" name="excelFile" id="excelFile" accept=".xls,.xlsx">导入excel</a>
							</form>
							<form action="addJuryIdcode.action" method="post" target="_self">
								<table class="list" style="width:80%" >
									<tr>
										<th width="26%" height="18" background="images/tab_14.gif" class="STYLE1">专家姓名</th>
										<th width="45%" height="24" background="images/tab_14.gif" class="STYLE1">手机号码</th>
										<th width="16%" height="24" background="images/tab_14.gif" class="STYLE1">操作</th>
									</tr>
									<tr>
										<td><input type="text" name="expert_name"/></td>
										<td><input type="text" name="expert_phone"/></td>
										<td><a onclick="deleteRow(this)">删除</a></td>
									</tr>
									<tr name="addMore">
										<td colspan="4">
											<div onclick="addMore()"> 
												<input type="button" class="button button-action button-circle" style="width:22px;height:22px;line-height:inherit;font-weight:bold" value="+"/>
												<span style="color:#999999">继续添加专家</span>
											</div>
										</td>
									</tr>
								</table>
								<div style="width:80%;margin: 20px;" >
									<input	type="submit" style="font-size:15px; padding: 0 30px;line-height: 27px; height: 27px;"
										value="保存" class="button button-action button-rounded">
								</div>
							</form>
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
