<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
<head>
<title>抽取评议组</title>
<link rel="stylesheet" href="css/buttons.css" type="text/css">
<link rel="stylesheet" href="css/universal.css?a=3">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/universal.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/jquery.alertWindow.min.js?a=1"></script>
<meta charset="UTF-8" />

<style type="text/css">
span {
	display: -moz-inline-box;
	display: inline-block;
	width: 150px;
}

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

.STYLE7 {
	font-size: 12px
}

-->
.operation a {
	font-size: 13px;
	color: #06482a;
	text-decoration: none;
}

.operation a:visited {
	font-size: 13px;
	color: #06482a;
	text-decoration: none;
}

.operation a:hover {
	font-size: 13px;
	color: #FF0000;
	text-decoration: underline;
}

.operation a:active {
	font-size: 13px;
	color: #FF0000;
	text-decoration: none;
}

.list  td {
	text-align: center;
	background-color: #FFFFFF;
	font-size: 14px;
	height: 26px;
}

.name a {
	font-size: 14px;
	color: #06482a;
	text-decoration: none;
}

.name a:visited {
	font-size: 14px;
	color: #06482a;
	text-decoration: none;
}

.name a:hover {
	font-size: 14px;
	color: #FF0000;
	text-decoration: none;
}

.name a:active {
	font-size: 14px;
	color: #FF0000;
	text-decoration: none;
}

.input-number {
	width: 64px;
}
</style>

<script>
 	 $.ajaxSetup({  //同步处理
    	async : false  
	});    
	//原来的
	function showMembers(groupNo,groupName) {
	 //ajax 获取
		var htmlBlock = "<table style='width:100%'><tr><th>专家编号</th><th>专家姓名</th><th>专家性别</th><th>所获学位</th><th>现从事专业</th><th>资格级别</th><th>拟任专业组职务</th></tr>";
		$.post("showMemberOfGroup.action", {groupNo : groupNo}, function(data) {
		//console.log(data); //
		var memeberOfGroup = JSON.parse(data.resultString);
			//console.log(data); //
		//	console.log(memeberOfGroup);//console
			$.each(memeberOfGroup, function(i, list) {
				htmlBlock = htmlBlock + "<tr><td>"
						+ list.expert_Field1
						+ "</td><td>"
						+ list.expert_Field2
						+ "</td><td>"
						+ list.expert_Field3
						+ "</td><td>"
						+ list.expert_Field7
						+ "</td><td>"
						+ list.expert_Field12
						+ "</td><td>"
						+ list.expert_Field18
						+ "</td><td>"
						+ list.expert_Field34
						+ "</td></tr>";
// 				htmlBlock = htmlBlock + '<div><span style="width:200px">'
// 						+ list.expert_Field1
// 						+ '</span><span>';
// 				htmlBlock = htmlBlock + list.expert_Field2 + '</span></div>'; 
				
			});
		});
		htmlBlock += "</table>";
		//alert(htmlBlock);
		jQuery.alertWindow(groupName+"参与抽取的成员", htmlBlock, "#A5DE37"); 
	}
	//新版下滑
// 	function showMembers(groupNo,groupName,obj) {
// 		/* $("input[name='keleyicom']").slideToggle("slow"); */
// 		$(obj).parent().parent().next().slideToggle("slow");
// 		$(
// 		alert($(obj).parent().parent().next().);
// 	}
	
	function oneStepDrawMember(){
		var AGroupNo = [];
		var AGroupName = [];
		$("input[name='nrOfCheckbox']:checked").each(function(){
			AGroupNo.push($(this).val());
			AGroupName.push($(this).parent().nextAll().eq(1).text());
		});
		var exist;
		var cease;
		$.post("clearSession.action", {}, function() {
		});
		for(var i=0;i<AGroupNo.length;i++) {
			var nrOfChoosen = $("#noChoosenOf"+AGroupNo[i]).val();
			//exist = true;
			//cease = false;
			if(nrOfChoosen=="") {
				$("#noChoosenOf"+AGroupNo[i]).focus();
				alert("输入抽取人数");
				//cease = true;
				continue;
			} else if(nrOfChoosen > $("#noChoosenOf"+AGroupNo[i]).attr("max")) {
				alert("抽取人数超过最大值");
				//cease = true;
				continue;
			} else if(nrOfChoosen < $("#noChoosenOf"+AGroupNo[i]).attr("min")) {
				alert("抽取人数小于最小值");
				//cease = true;
				continue;
			}
			//清理session
			
			
			if($("tr[name='resultGroup"+AGroupNo[i]+"']").length==0){
				drawMember(AGroupNo[i],AGroupName[i]);  //前面都没问题的话，才会走到这一步
			} else {
				redrawMember(AGroupNo[i],AGroupName[i]);
			}
		}
		/* if(exist){
			alert("都已有抽取结果\n若想重新抽取请点击“重抽”");
			redrawMember(AGroupNo[i],AGroupName[i]);
		} else {
			if(!cease) {
				for(var i=0;i<AGroupNo.length;i++) {
					if($("#resultGroup"+AGroupNo[i]).length==0){
						drawMember(AGroupNo[i],AGroupName[i]);
					}
				}
			}
		} */
	}
	
	
	function drawMember(groupNo,groupName){
		var nrOfChoosen = $("#noChoosenOf"+groupNo).val();
		if($("tr[name='resultGroup"+groupNo+"']").length==0){
			if(nrOfChoosen=="") {
				alert("输入抽取人数");
				return false;
			}
			else if(nrOfChoosen > $("#noChoosenOf"+groupNo).attr("max")) {
				alert("抽取人数超过最大值");
				return false;
			} else if(nrOfChoosen < $("#noChoosenOf"+groupNo).attr("min")) {
				alert("抽取人数小于最小值");
				return false;
			}
			$.post("drawingMemeberOfGroup.action", {groupNo : groupNo,numberChoosen:nrOfChoosen}, function(data) {
  				var theErrors = data.theErrors;
				//alert(theErrors); 
				//console.log(data); 
				if(theErrors == null) {
					var htmlBlock = "";
					var leaderResult = JSON.parse(data.leaderResult);
					var memberResult = JSON.parse(data.memberResult);
					var resultNumber = leaderResult.length + memberResult.length;
					//console.log(leaderResult); //
					//console.log(memberResult); //
					$.each(leaderResult,function(i,leaderResult){
						htmlBlock += "<tr class='list name' name=" + "resultGroup" + groupNo + ">" + "<td rowSpan=" + resultNumber + ">"+ groupName 
							+ "<input type='hidden' name='resultNumber' value='"+ resultNumber+"'/>"
							+ "<input type='hidden' name='groupName' value='"+ groupName +"'" 
							+ "</td>";
						htmlBlock += "<td>" + leaderResult.expert_Field1 + "</td>"
						htmlBlock += "<td><a target='_blank' href='to_infoBrowsing.action?expert_no="+ leaderResult.expert_Field1 +"'>" + leaderResult.expert_Field2 + "</a></td>";
						htmlBlock += "<td>"
							+ leaderResult.expert_Field3
							+ "</td><td>"
							+ leaderResult.expert_Field7
							+ "</td><td>"
							+ leaderResult.expert_Field12
							+ "</td><td>"
							+ leaderResult.expert_Field18
							+ "</td><td>"
							+ leaderResult.expert_Field34
							+ "</td><td>"
							+ "组长"
							+ "</td></tr>";
						/* htmlBlock += "<input type='hidden' name='leaderResult' value='" + leaderResult.expert_Field1 +"'/>"; */
					});
					//htmlBlock += "</td><td>";
					$.each(memberResult,function(i,memberResult){
						/* htmlBlock += "<a target='_blank' style='padding:0px 10px' href='to_infoBrowsing.action?expert_no="+ memberResult.expert_Field1 +"'>" + memberResult.expert_Field2 + "</a>";
						htmlBlock += "<input type='hidden' name='memberResult'  value='" +memberResult.expert_Field1 +"'/>"; */
						htmlBlock += "<tr class='list name' name=" + "resultGroup" + groupNo + ">";
						htmlBlock += "<td>" + memberResult.expert_Field1 + "</td>"
						htmlBlock += "<td><a target='_blank' href='to_infoBrowsing.action?expert_no="+ memberResult.expert_Field1 +"'>" + memberResult.expert_Field2 + "</a></td>";
						htmlBlock += "<td>"
							+ memberResult.expert_Field3
							+ "</td><td>"
							+ memberResult.expert_Field7
							+ "</td><td>"
							+ memberResult.expert_Field12
							+ "</td><td>"
							+ memberResult.expert_Field18
							+ "</td><td>"
							+ memberResult.expert_Field34
							+ "</td><td>"
							+ "组员"
							+ "</td></tr>";
					});	
					//htmlBlock += "</td></tr>";
					$("#drawResult").append(htmlBlock);
				}else {
					if(theErrors == "NoLeaderToRandom") {
						alert(groupName+"中没有拟任组长的专家");
					} else if(theErrors == "NoMemberToRandom") {
						alert(groupName+"中没有拟任组员的专家");
					}
				}
			});
		} else {
			alert(groupName + "已有抽取结果\n若想重新抽取请点击“重抽”");
		}
	}

	function redrawMember(groupNo,groupName) {
		var nrOfChoosen = $("#noChoosenOf"+groupNo).val();
		if($("tr[name='resultGroup"+groupNo+"']").length==0){
			alert("请先点击“抽取”");
		} else {
			if(nrOfChoosen=="") {
				alert("输入抽取人数");
				return false;
			} else if(nrOfChoosen > $("#noChoosenOf"+groupNo).attr("max")) {
				alert("抽取人数超过最大值");
				return false;
			} else if(nrOfChoosen < $("#noChoosenOf"+groupNo).attr("min")) {
				alert("抽取人数小于最小值");
				return false;
			}
			$.post("drawingMemeberOfGroup.action", {groupNo : groupNo,numberChoosen:nrOfChoosen}, function(data) {
				var theErrors = data.theErrors;
				if(theErrors == null) {
					var htmlBlock = "";
					var leaderResult = JSON.parse(data.leaderResult);
					var memberResult = JSON.parse(data.memberResult);
					var resultNumber = leaderResult.length + memberResult.length;
					//console.log(leaderResult); //
					//console.log(memberResult); //
					$.each(leaderResult,function(i,leaderResult){
						//alert("307");
						htmlBlock += "<tr class='list name' name=" + "resultGroup" + groupNo + ">" + "<td rowSpan=" + resultNumber + ">"+ groupName 
							+ "<input type='hidden' name='resultNumber' value='"+ resultNumber+"'/>"
							+ "<input type='hidden' name='groupName' value='"+ groupName +"'" 
							+ "</td>";
						htmlBlock += "<td>" + leaderResult.expert_Field1 + "</td>"
						htmlBlock += "<td><a target='_blank' href='to_infoBrowsing.action?expert_no="+ leaderResult.expert_Field1 +"'>" + leaderResult.expert_Field2 + "</a></td>";
						htmlBlock += "<td>"
							+ leaderResult.expert_Field3
							+ "</td><td>"
							+ leaderResult.expert_Field7
							+ "</td><td>"
							+ leaderResult.expert_Field12
							+ "</td><td>"
							+ leaderResult.expert_Field18
							+ "</td><td>"
							+ leaderResult.expert_Field34
							+ "</td><td>"
							+ "组长"
							+ "</td></tr>";
					});
					//htmlBlock += "</a></td><td>";
					$.each(memberResult,function(i,memberResult){
						//htmlBlock += "<a target='_blank' style='padding:0px 10px' href='./zjgl_infoBrowsing.jsp'>" + memberResult.expert_Field2 + "</a>";
						htmlBlock += "<tr class='list name' name=" + "resultGroup" + groupNo + ">";
						htmlBlock += "<td>" + memberResult.expert_Field1 + "</td>"
						htmlBlock += "<td><a target='_blank' href='to_infoBrowsing.action?expert_no="+ memberResult.expert_Field1 +"'>" + memberResult.expert_Field2 + "</a></td>";
						htmlBlock += "<td>"
							+ memberResult.expert_Field3
							+ "</td><td>"
							+ memberResult.expert_Field7
							+ "</td><td>"
							+ memberResult.expert_Field12
							+ "</td><td>"
							+ memberResult.expert_Field18
							+ "</td><td>"
							+ memberResult.expert_Field34
							+ "</td><td>"
							+ "组员"
							+ "</td></tr>";
					});	
					//htmlBlock += "</td></tr>";
					//alert($("tr[name='resultGroup"+groupNo+"']").length);
					$("tr[name='resultGroup"+groupNo+"']").remove();
					$("#drawResult").append(htmlBlock);
				}
			});
		}
	}
	
	function onblurMethod(obj){
		if($("#"+obj.id).val() != ""){
			$("#"+obj.id).parent().prevAll().eq(3).children().eq(0).prop("checked",true);
		}  else {
			$("#"+obj.id).parent().prevAll().eq(3).children().eq(0).prop("checked",false);
		}
	}
	function updateNo(no) {
		//alert(no);
		var checkbox = $("input[name='nrOfCheckbox']:checked");
		checkbox.each(function(){
			$(this).parent().siblings().eq(-1).children().val(no);
		});
		//alert(checkbox.length);
	}
	
	/**讲结果保存至数据库**/
	function saveResult() {
		$.post("addHistoryTitleForPYZ.action",function(data){
			$("#feedbackNav").html(data.feedback);
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
							height="16" /> <span class="STYLE4">抽取评议组</span></td>
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
								<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" style="margin:0 0 10px 0"
									bgcolor="#c0de98">
									<tr>
										<th width="1%" background="images/tab_14.gif" class="STYLE1"><input type="checkbox"
											name="chooseAll" value="0" onclick="CheckSelect('nrOfCheckbox')" /></th>
										<th width="9%" height="18" background="images/tab_14.gif" class="STYLE1">序号</th>
										<th width="22.5%" height="18" background="images/tab_14.gif" class="STYLE1">专业组名称</th>
										<th width="17.5%" height="18" background="images/tab_14.gif" class="STYLE1">可抽取人数</th>
										<th width="22.5%" height="18" background="images/tab_14.gif" class="STYLE1">抽取人数<input style="height:9px; margin-left:8px; width:25px;" onchange="updateNo(this.value)"></th>
									<!-- 	<th width="27.5%" height="18" background="images/tab_14.gif" colspan="2" class="STYLE1">操作</th> -->
									</tr>
									<s:iterator id="group" value="listGroup" status="index">
										<tr class="list operation">
											<td><input type="checkbox" name="nrOfCheckbox" value="<s:property value='#group.Group_no'/>" /></td>
											<td><s:property value="#index.index + 1" /></td>
											<td><a onclick="showMembers('<s:property value="#group.Group_no"/>','<s:property value="#group.Group_name"/>')"><s:property value="#group.Group_name" /></a></td>
											<td><a onclick="showMembers('<s:property value="#group.Group_no"/>','<s:property value="#group.Group_name"/>')"><s:property value="%{noOfGroupMembers[#index.index]}" /></a></td>
											<td class=input-td><input id="noChoosenOf<s:property value="#group.Group_no"/>" class="input-number" type="number" onblur="onblurMethod(this)" min="2" max="<s:property value="%{noOfGroupMembers[#index.index]}"/>"/></td>
											<%-- <td><a onclick="drawMember('<s:property value="#group.Group_no"/>','<s:property value="#group.Group_name"/>')">抽取</a></td>
											<td><a onclick="redrawMember('<s:property value="#group.Group_no"/>','<s:property value="#group.Group_name"/>')">重抽</a></td> --%>
										</tr>
										<!-- <tr name="testTd" >
											<td colspan="5">TEST TD</td>
										</tr>
										<tr name="testTd" >
											<td colspan="5">TEST TD</td>
										</tr>
										<tr name="testTd" >
											<td colspan="5">TEST TD</td>
										</tr> -->
									</s:iterator>
								</table>
								<div style="width:98%;" >
									<input type="button" onclick="oneStepDrawMember()" value="抽取已选中专业组" class="customBtnStyleSingle button button-action button-rounded"/>
								</div>
								<!-- <form name="infoList" id="infoList" action="addHistoryTitle!addHistoryTitleForPYZ.action" method="post" target="_self"
								style="margin:10px 0;width:98%"> -->
								<form name="infoList" id="infoList" action="to_pwcq_pyz_print.action" method="post" style="margin:10px 0;width:98%" target="_blank">
								<fieldset style="width:98%;border:#c0de98 dashed 1px;">
									<legend align="left" style="font-size:14px; color:#1F4A65;font-weight:bold;">抽取结果</legend>
									<table id="drawResult" width="100%" border="0" align="center" cellpadding="0" cellspacing="1"
										bgcolor="#c0de98" style="margin:10px 0">
										<tr>
											<th width="15%" height="18" background="images/tab_14.gif" class="STYLE1">专业组名称</th>
											<!-- <th width="15%" height="18" background="images/tab_14.gif" class="STYLE1">组长</th>
											<th width="40" height="18" background="images/tab_14.gif" class="STYLE1">组员 -->
											<th background="images/tab_14.gif" class="STYLE1">专家编号</th>
											<th background="images/tab_14.gif" class="STYLE1">专家姓名</th>
											<th background="images/tab_14.gif" class="STYLE1">专家性别</th>
											<th background="images/tab_14.gif" class="STYLE1">所获学位</th>
											<th background="images/tab_14.gif" class="STYLE1">现从事专业</th>
											<th background="images/tab_14.gif" class="STYLE1">资格级别</th>
											<th background="images/tab_14.gif" class="STYLE1">拟任专业组职务</th>
											<th background="images/tab_14.gif" class="STYLE1">抽取结果</th>
										</tr>
										<!-- <tr class="list name">
											
										</tr> -->
									</table>
									<div width="98%">
										<input type="button" value="保存"
											class="button button-action button-rounded customBtnStyleSingle" onclick="saveResult()"/>
										<input type="submit" value="打印"
												class="button button-action button-rounded customBtnStyleSingle"/>
									</div>
								</fieldset>
								
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
