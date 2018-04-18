<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'statistic2.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="js/echarts.js"></script>
	<script type="text/javascript" src="http://echarts.baidu.com/resource/echarts-gl-latest/dist/echarts-gl.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%-- <%=expertList%> <br> --%>
	<div id="main" style="width: 1100px; height: 600px;"></div>
	<script type="text/javascript">
    	var myChart = echarts.init(document.getElementById("main"));
    	
    	/* var dataTest = "${expertList}"; */
    	/* console.log(dataTest); */
	
		// 指定图表的配置项和数据
		var hours = [ '25-30岁', '30-35岁', '35-40岁', '40-45岁', '45-50岁', 
			'50-55岁', '55-60岁', '60岁以上'
		];
		var days = [ '助教', '讲师', '副教授', '教授'
		];
	
		var data = [
			[ 0, 0, 5 ],
			[ 0, 1, 1 ],
			[ 0, 2, 0 ],
			[ 0, 3, 0 ],
			[ 0, 4, 0 ],
			[ 0, 5, 0 ],
			[ 0, 6, 0 ],
			[ 0, 7, 0 ],
			[ 1, 0, 7 ],
			[ 1, 1, 0 ],
			[ 1, 2, 15 ],
			[ 1, 3, 0 ],
			[ 1, 4, 0 ],
			[ 1, 5, 0 ],
			[ 1, 6, 0 ],
			[ 1, 7, 0 ],
			[ 2, 0, 1 ],
			[ 2, 1, 1 ],
			[ 2, 2, 0 ],
			[ 2, 3, 0 ],
			[ 2, 4, 0 ],
			[ 2, 5, 0 ],
			[ 2, 6, 0 ],
			[ 2, 7, 0 ],
			[ 3, 0, 7 ],
			[ 3, 1, 3 ],
			[ 3, 2, 0 ],
			[ 3, 3, 0 ],
			[ 3, 4, 7 ],
			[ 3, 5, 0 ],
			[ 3, 6, 5 ],
			[ 3, 7, 9 ],
		];
		option = {
			title : {
				text : '任职资格与年龄和学历的关系图',
			},
			tooltip : {},
			visualMap : {
				max : 20,
				inRange : {
					color : [ '#313695', '#4575b4', '#74add1', '#abd9e9', '#e0f3f8', '#ffffbf', '#fee090', '#fdae61', '#f46d43', '#d73027', '#a50026' ]
				}
			},
			xAxis3D : {
				type : 'category',
				data : hours
			},
			yAxis3D : {
				type : 'category',
				data : days
			},
			zAxis3D : {
				type : 'value'
			},
			grid3D : {
				boxWidth : 200,
				boxDepth : 80,
				light : {
					main : {
						intensity : 1.2
					},
					ambient : {
						intensity : 0.3
					}
				}
			},
			series : [ {
				type : 'bar3D',
				data : data.map(function(item) {
					return {
						value : [ item[1], item[0], item[2] ]
					}
				}),
				shading : 'color',
	
				label : {
					show : false,
					textStyle : {
						fontSize : 16,
						borderWidth : 1
					}
				},
	
				itemStyle : {
					opacity : 0.4
				},
	
				emphasis : {
					label : {
						textStyle : {
							fontSize : 20,
							color : '#900'
						}
					},
					itemStyle : {
						color : '#900'
					}
				}
			} ]
		}
		// 显示图表
		myChart.setOption(option);
    </script>
</body>
</html>
