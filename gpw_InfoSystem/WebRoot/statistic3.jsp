<%@ page language="java" import="java.util.*,gpw.object.*"
	pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

/* List<Expert> expertList = (List<Expert>) request.getSession().getAttribute("expertList");   //列表里要显示的专家 */
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>统计3</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript" src="js/echarts.js"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%-- <%=expertList%> <br> --%>
	<div id="main" style="width: 1100px; height: 600px;"></div>
	<script type="text/javascript">
    	var myChart = echarts.init(document.getElementById("main"));
    	
    	var dataMaster = "${resultNumberOfMaster}";
    	dataMaster = dataMaster.substring(1, dataMaster.length - 1);
    	dataMaster = dataMaster.split(",");
	
		var dataPhD = "${resultNumberOfPhD}";
		dataPhD = dataPhD.substring(1, dataPhD.length - 1);
    	dataPhD = dataPhD.split(",");
    	
    	var dataSenior = "${resultNumberOfSenior}";
    	dataSenior = dataSenior.substring(1, dataSenior.length - 1);
    	dataSenior = dataSenior.split(",");
    	
    	var dataDSenior = "${resultNumberOfDSenior}";
    	dataDSenior = dataDSenior.substring(1, dataDSenior.length - 1);
    	dataDSenior = dataDSenior.split(",");
    	
    	var dataProfessor = "${resultNumberOfProfessor}";
    	dataProfessor = dataProfessor.substring(1, dataProfessor.length - 1);
    	dataProfessor = dataProfessor.split(",");
    	
    	var dataDProfessor = "${resultNumberOfDProfessor}";
    	dataDProfessor = dataDProfessor.substring(1, dataDProfessor.length - 1);
    	dataDProfessor = dataDProfessor.split(",");
	
		// 指定图表的配置项和数据
		var option = {
			title : {
				text : '根据拟任职称的分析图',
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '硕士人数', '博士人数', '正高级人数', '副高级人数', '高校教授人数', '高校计划副教授人数' ]
			},
			toolbox : {
				show : true,
				feature : {
					magicType : {
						show : true,
						type : [ 'line', 'bar' ]
					},
					restore : {
						show : true
					},
					saveAsImage : {
						show : true
					}
				}
			},
			calculable : true,
			xAxis : [
				{
					type : 'category',
					data : [ '主任委员', '副主任委员', '委员', '组长', '组员' ]
				}
			],
			yAxis : [
				{
					type : 'value'
				}
			],
			series : [
				{
					name : '硕士人数',
					type : 'bar',
					data : dataMaster,
					markPoint : {
						data : [
							{
								type : 'max',
								name : '最大值'
							},
							{
								type : 'min',
								name : '最小值'
							}
						]
					},
					markLine : {
						data : [
							{
								type : 'average',
								name : '平均值'
							}
						]
					}
				},
				{
					name : '博士人数',
					type : 'bar',
					data : dataPhD,
					markPoint : {
						/* data : [
						    {name : '年最高', value : 8, xAxis: 7, yAxis: 8},
						    {name : '年最低', value : 1, xAxis: 0, yAxis: 1}
						] */
						data : [
							{
								type : 'max',
								name : '最大值'
							},
							{
								type : 'min',
								name : '最小值'
							}
						]
					},
					markLine : {
						data : [
							{
								type : 'average',
								name : '平均值'
							}
						]
					},
				},
				{
					name : '正高级人数',
					type : 'bar',
					data : dataSenior,
					markPoint : {
						data : [
							{
								type : 'max',
								name : '最大值'
							},
							{
								type : 'min',
								name : '最小值'
							}
						]
					},
					markLine : {
						data : [
							{
								type : 'average',
								name : '平均值'
							}
						]
					}
				},
				{
					name : '副高级人数',
					type : 'bar',
					data : dataDSenior,
					markPoint : {
						data : [
							{
								type : 'max',
								name : '最大值'
							},
							{
								type : 'min',
								name : '最小值'
							}
						]
					},
					markLine : {
						data : [
							{
								type : 'average',
								name : '平均值'
							}
						]
					}
				},
				{
					name : '高校教授人数',
					type : 'bar',
					data : dataProfessor,
					markPoint : {
						data : [
							{
								type : 'max',
								name : '最大值'
							},
							{
								type : 'min',
								name : '最小值'
							}
						]
					},
					markLine : {
						data : [
							{
								type : 'average',
								name : '平均值'
							}
						]
					}
				},
				{
					name : '高校计划副教授人数',
					type : 'bar',
					data : dataDProfessor,
					markPoint : {
						data : [
							{
								type : 'max',
								name : '最大值'
							},
							{
								type : 'min',
								name : '最小值'
							}
						]
					},
					markLine : {
						data : [
							{
								type : 'average',
								name : '平均值'
							}
						]
					}
				}
			]
		};
	
	
		// 显示图表
		myChart.setOption(option);
    </script>
</body>

</html>
