<%@ page language="java" import="java.util.*,gpw.object.*"
	pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List<Expert> expertList = (List<Expert>) request.getSession().getAttribute("expertList");   //列表里要显示的专家
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>统计1</title>

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
    	
    	var dataTest = "${expertList}";
    	/* console.log(dataTest); */
	
		// 指定图表的配置项和数据
		var option = {
			title : {
				text : '年龄与所获学位关系图',
			},
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				data : [ '硕士人数', '博士人数' ]
			},
			toolbox : {
				show : true,
				feature : {
					dataView : {
						show : true,
						readOnly : false
					},
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
					data : [ '25-30岁', '30-35岁', '35-40岁', '40-45岁', '45-50岁', '50-55岁', '55-60岁', '60岁以上' ]
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
					data : [ 5, 3, 1, 1, 0, 0, 0, 0 ],
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
					data : [ 1, 2, 3, 4, 5, 6, 8, 8 ],
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
					}
				}
			]
		};
	
	
		// 显示图表
		myChart.setOption(option);
    </script>
</body>

</html>
