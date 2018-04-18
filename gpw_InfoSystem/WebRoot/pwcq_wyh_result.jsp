<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML>
<html>
<head>
<title>抽取委员会</title>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/jquery.alertWindow.min.js"></script>
<%-- <script src="js/d3.js"></script> --%>
<link rel="stylesheet" href="css/buttons.css">
<link rel="stylesheet" type="text/css" href="css/universal.css?v=<%= System.currentTimeMillis()%>"/>
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

/* d3 pie chart css */
	.pieChart--center--innerCircle {
	  fill: #fff;
	}

	.pieChart--center--text {
	  font-size: 10px;
	}

	.pieChart--center--outerCircle {
	  fill: rgba( 255, 255, 255, 0.75 );
	}

	.pieChart--detail--divider {
	  stroke: gray;
	  stroke-width: 1;
	}

	.pieChart--detail--percentage {
	  font-size: 15px;
	  font-weight: 100;
	  
	  fill: #333;
	  stroke-width: 1px;
	}

	.pieChart--detail--textContainer {
	  background-color: transparent;
	  padding: 10px 0 0 0;
	  margin: 0;
	  
	  color: #666;
	  font-style: italic;
	}

	.pieChart--detail__left {
	  text-align: left;
	}

	.pieChart--detail__right {
	  text-align: right;
	}

	.pieChart__blue {
	  fill: #6bb7c7;
	}

	.pieChart__red {
	  fill: #d79d91;
	}

	/**
	 * Helper classes
	 */ 

	.hidden {
	  display: none;
	}
</style>
<script type="text/javascript">
$(function(){ 
	var result = "<%=request.getAttribute("result")%>";
	var feedback = "<%=request.getAttribute("feedback")%>";
	
// 	var errorColor = "#CC3333";  //抽取结果比例错误时提示色
// 	var defaultColor = "#000000"; //规则要求的比例的提示色
// 	if(result == "0") {
//	do nothing
// 	}else if(result == "2"){
// 		feedback += "<div>当前正高级专家比例为<font style='color:" + errorColor + "'>" + "<%=request.getAttribute("ratioOfSenior")%>" +"%</font>低于</div>";
// 		feedback += "<div>规则要求的正高级专家比例<font style='color:" + defaultColor + "'>25.00%</font>以上</div>";
// 	} else if(result == "3"){
// 		feedback += "<div>当前45周岁以下的专家的比例为<font style='color:" + errorColor + "'>" + "<%=request.getAttribute("ratioOfAge")%>" +"%</font>低于</div>";
// 		feedback += "<div>规则要求的45周岁以下的专家比例<font style='color:" + defaultColor + "'>25.00%</font>以上</div>";
// 	} else{
// 		feedback = "抽取结果有未知错误";
// 	}
	 
//	alert(feedback);
	if(result != "null" && result != "0") {
		jQuery.alertWindow("抽取结果无法满足以下规则", feedback , "#A5DE37"); 
	}
});
</script>
</head>

<body>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<th height="30">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<th width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></th>
						<th width="1101" background="images/tab_05.gif" align="left">
							<img src="images/311.gif" width="16" height="16" /> 
							<span class="STYLE4">结果统计</span>
						</th>
						<th background="images/tab_05.gif"></th>
						<th width="15"><img src="images/tab_07.gif" width="16" height="30" /></th>
					</tr>
				</table>
			</th>
		</tr>
		<tr>
			<td>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
					<tr>
						<th width="9" background="images/tab_12.gif">&nbsp;</th>
						<td style="background-color:#f3ffe3;" align="center">
							<table class="normalDisplayTable" style="margin:10px 0px;">
								<tr align="center" class="STYLE7">
									<td rowspan="${directorListSize+1 }" width=20% >		<center>
										<span>主任委员抽取结果</span>
									</td>
									<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">专家编号</th>
									<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">专家姓名</th>
									<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">专家性别</th>
									<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">拟任高评委名称</th>
								</tr>
								<s:iterator id="expert" value="listDirector">
									<tr>
										<td><s:property value="#expert.Expert_Field1" /></td>
										<td><s:property value="#expert.Expert_Field2" /></td>
										<td><s:property value="#expert.Expert_Field3" /></td>
										<td><s:property value="#expert.Expert_Field32" /></td>
									</tr>
								</s:iterator>
								
								
								<tr align="center" class="STYLE7">
									<td rowspan="${viceDirectorListSize+1 }" width=20% >
										<span>副主任委抽取结果</span>
									</td>
									<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">专家编号</th>
									<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">专家姓名</th>
									<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">专家性别</th>
									<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">拟任高评委名称</th>
								</tr>
								<s:iterator id="expert" value ="listViceDirector">
									<tr>
										<td><s:property value="#expert.Expert_Field1" /></td>
										<td><s:property value="#expert.Expert_Field2" /></td>
										<td><s:property value="#expert.Expert_Field3" /></td>
										<td><s:property value="#expert.Expert_Field32" /></td>
									</tr>
								</s:iterator>
								
								
								<tr align="center" class="STYLE7">
									<td rowspan="${committeeListSize+1 }" width=20% >
										<span>委员抽取结果</span>
									</td>
									<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">专家编号</th>
									<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">专家姓名</th>
									<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">专家性别</th>
									<th width="20%" height="18" background="images/tab_14.gif" class="STYLE1">拟任高评委名称</th>
								</tr>
								<s:iterator id="expert" value ="listCommittee">
									<tr>
										<td><s:property value="#expert.Expert_Field1" /></td>
										<td><s:property value="#expert.Expert_Field2" /></td>
										<td><s:property value="#expert.Expert_Field3" /></td>
										<td><s:property value="#expert.Expert_Field32" /></td>
									</tr>
								</s:iterator>

								<tr>
									<td colspan="5" style="font-size:20px; font-weight:bold;">评委会组成情况</td>
								</tr>
								<tr>
									<td colspan="3" class="STYLE7">主任委员</td>
									<td colspan="2">${directorListSize }人</td>
								</tr>

								<tr>

									<td colspan="3" class="STYLE7">副主任委员</td>
									<td colspan="2">${viceDirectorListSize }人</td>

								</tr>
								<tr>
									<td colspan="3" class="STYLE7">委员</td>
									<td colspan="2">${committeeListSize }人</td>

								</tr>
								<tr >

									<td colspan="3" class="STYLE7">正高级专家占</td>
									<td colspan="2">${ratioOfSenior }%</td>

								</tr>
								<tr>
									<td colspan="5">
										<div id="pieChart1">
											<svg id="pieChartSVG">
												<defs>
													<filter id='pieChartInsetShadow'>
														<feOffset dx='0' dy='0'/>
														<feGaussianBlur stdDeviation='3' result='offset-blur' />
														<feComposite operator='out' in='SourceGraphic' in2='offset-blur' result='inverse' />
														<feFlood flood-color='black' flood-opacity='1' result='color' />
														<feComposite operator='in' in='color' in2='inverse' result='shadow' />
														<feComposite operator='over' in='shadow' in2='SourceGraphic' />
													</filter>
													<filter id="pieChartDropShadow">
														<feGaussianBlur in="SourceAlpha" stdDeviation="3" result="blur" />
														<feOffset in="blur" dx="0" dy="3" result="offsetBlur" />
														<feMerge>
															<feMergeNode />
															<feMergeNode in="SourceGraphic" />
														</feMerge>
													</filter>
												</defs>
											</svg>
										</div>
									</td>
								</tr>
								<tr >

									<td colspan="3" class="STYLE7">45岁以下(含)专家占</td>
									<td colspan="2">${ratioOfAge }%</td>
								</tr>
								<tr>
									<td colspan="5">
										<div id="pieChart2">
											<svg id="pieChartSVG">
												<defs>
													<filter id='pieChartInsetShadow'>
														<feOffset dx='0' dy='0'/>
														<feGaussianBlur stdDeviation='3' result='offset-blur' />
														<feComposite operator='out' in='SourceGraphic' in2='offset-blur' result='inverse' />
														<feFlood flood-color='black' flood-opacity='1' result='color' />
														<feComposite operator='in' in='color' in2='inverse' result='shadow' />
														<feComposite operator='over' in='shadow' in2='SourceGraphic' />
													</filter>
													<filter id="pieChartDropShadow">
														<feGaussianBlur in="SourceAlpha" stdDeviation="3" result="blur" />
														<feOffset in="blur" dx="0" dy="3" result="offsetBlur" />
														<feMerge>
															<feMergeNode />
															<feMergeNode in="SourceGraphic" />
														</feMerge>
													</filter>
												</defs>
											</svg>
										</div>
									</td>
								</tr>
								<tr >

									<td colspan="3" class="STYLE7">外单位专家占</td>
									<td colspan="2">${rationOfOutsider }%</td>

								</tr>
								<tr>
									<th colspan="5" height="20" >
										<div class="STYLE7" style="width:100%;margin:5px 0px;text-align:center">
											<button type="button"
												style="font-size:8px; padding: 0 22px;line-height: 20px; height: 20px;" name="lastmove"
												class="button button-action button-rounded" onclick="location.href='to_pwcq_wyh!backFourth.action'">上一步</button>
											<button type="button"
												style="font-size:8px; padding: 0 22px;line-height: 20px; height: 20px;" name="finish"
												class="button button-action button-rounded"
												onclick="location.href='to_pwcq_wyh!finalPage.action'">下一步</button>
										</div>
									</th>
								</tr>
							</table>
						</td>
						<th width="9" background="images/tab_16.gif">&nbsp;</th>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<th height="29">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<th width="15" height="29"><img src="images/tab_20.gif" width="15" height="29" /></th>
						<th background="images/tab_21.gif">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<th width="25%" height="29" nowrap="nowrap"><span class="STYLE1"></span></th>
									<th width="75%" valign="top" class="STYLE1">
										<div align="right">
											<table width="352" height="20" border="0" cellpadding="0" cellspacing="0">

											</table>
										</div>
									</th>
								</tr>
							</table>
						</th>
						<th width="14"><img src="images/tab_22.gif" width="14" height="29" /></th>
					</tr>
				</table>
			</th>
		</tr>
	</table>
	<%-- <script src="https://d3js.org/d3.v3.min.js"></script> --%>
	<script src="js/d3.v3.min.js"></script>
	<script>
	;( function() {
	  var data = {
	    pieChart  : [
	      {
	        color       : 'red',
	        description : '正高级专家占',
	        title       : 'flowers',
	        value       : ${ratioOfSenior }/100
	      },
	      {
	        color       : 'blue',
	        description : '非正高级专家占',
	        title       : 'trains',
	        value       : 1-${ratioOfSenior }/100
	      }
	    ]
	  };

	  var data2 = {
	  	pieChart  : [
	      {
	        color       : 'red',
	        description : '45岁以下(含)专家占',
	        title       : 'flowers',
	        value       : ${ratioOfAge }/100
	      },
	      {
	        color       : 'blue',
	        description : '45岁以上专家占',
	        title       : 'trains',
	        value       : 1-${ratioOfAge }/100
	      }
	    ]
	  };
	  
	  var DURATION = 1500;
	  var DELAY    = 500;
	  
	  
	  /**
	   * draw the fancy pie chart
	   *
	   * @param {String} elementId elementId
	   * @param {Array}  data      data
	   */
	  function drawPieChart( elementId, data ) {
	    // TODO code duplication check how you can avoid that
	    var containerEl = document.getElementById( elementId ),
	        width       = containerEl.clientWidth,
	        height      = width * 0.2,
	        radius      = Math.min( width, height ) / 2,
	        container   = d3.select( containerEl ),
	        svg         = container.select( 'svg' )
	                              .attr( 'width', width )
	                              .attr( 'height', height );
	    var pie = svg.append( 'g' )
	                .attr(
	                  'transform',
	                  'translate(' + width / 2 + ',' + height / 2 + ')'
	                );
	    
	    var detailedInfo = svg.append( 'g' )
	                          .attr( 'class', 'pieChart--detailedInformation' );

	    var twoPi   = 2 * Math.PI;
	    var pieData = d3.layout.pie().value( function( d ) { return d.value; } );

	    var arc = d3.svg.arc()
	                    .outerRadius( radius - 20)
	                    .innerRadius( 0 );
	    
	    var pieChartPieces = pie.datum( data )
	                            .selectAll( 'path' )
	                            .data( pieData )
	                            .enter()
	                            .append( 'path' )
	                            .attr( 'class', function( d ) {
	                              return 'pieChart__' + d.data.color;
	                            } )
	                            .attr( 'filter', 'url(#pieChartInsetShadow)' )
	                            .attr( 'd', arc )
	                            .each( function() {
	                              this._current = { startAngle: 0, endAngle: 0 }; 
	                            } )
	                            .transition()
	                            .duration( DURATION )
	                            .attrTween( 'd', function( d ) {
	                              var interpolate = d3.interpolate( this._current, d );
	                              this._current = interpolate( 0 );
	                    
	                              return function( t ) {
	                                return arc( interpolate( t ) );
	                              };
	                            } )
	                            .each( 'end', function handleAnimationEnd( d ) {
	                              drawDetailedInformation( d.data, this ); 
	                            } );

	    drawChartCenter(); 
	    
	    function drawChartCenter() {
	      var centerContainer = pie.append( 'g' )
	                                .attr( 'class', 'pieChart--center' );
	      
	      centerContainer.append( 'circle' )
	                      .attr( 'class', 'pieChart--center--outerCircle' )
	                      .attr( 'r', 0 )
	                      .attr( 'filter', 'url(#pieChartDropShadow)' )
	                      .transition()
	                      .duration( DURATION )
	                      .delay( DELAY )
	                      .attr( 'r', radius - 50 );
	      
	      centerContainer.append( 'circle' )
	                      .attr( 'id', 'pieChart-clippy' )
	                      .attr( 'class', 'pieChart--center--innerCircle' )
	                      .attr( 'r', 0 )
	                      .transition()
	                      .delay( DELAY )
	                      .duration( DURATION )
	                      .attr( 'r', radius - 55 )
	                      .attr( 'fill', '#fff' );
	    }
	    
	    function drawDetailedInformation ( data, element ) {
	      var bBox      = element.getBBox(),
	          infoWidth = width * 0.3,
	          anchor,
	          infoContainer,
	          position;
	      
	      // console.log(bBox.x + bBox.width / 2);
	      if ( ( bBox.x + bBox.width / 2 ) >= 0 ) {
	        infoContainer = detailedInfo.append( 'g' )
	                                    .attr( 'width', infoWidth )
	                                    .attr(
	                                      'transform',
	                                      'translate(' + ( width - infoWidth ) + ',' + ( 50 ) + ')'
	                                    );
	        anchor   = 'end';
	        position = 'right';
	      } else {
	        infoContainer = detailedInfo.append( 'g' )
	                                    .attr( 'width', infoWidth )
	                                    .attr(
	                                      'transform',
	                                      'translate(' + 0 + ',' + ( 50 ) + ')'
	                                    );
	        anchor   = 'start';
	        position = 'left';
	      }

	      infoContainer.data( [ data.value * 100 ] )
	                    .append( 'text' )
	                    .text ( '0 %' )
	                    .attr( 'class', 'pieChart--detail--percentage' )
	                    .attr( 'x', ( position === 'left' ? 0 : infoWidth ) )
	                    .attr( 'y', -10 )
	                    .attr( 'text-anchor', anchor )
	                    .transition()
	                    .duration( DURATION )
	                    .tween( 'text', function( d ) {
	                      var i = d3.interpolateRound(
	                        +this.textContent.replace( /\s%/ig, '' ),
	                        d
	                      );

	                      return function( t ) {
	                        this.textContent = i( t ) + ' %';
	                      };
	                    } );
	      
	      infoContainer.append( 'line' )
	                    .attr( 'class', 'pieChart--detail--divider' )
	                    .attr( 'x1', 0 )
	                    .attr( 'x2', 0 )
	                    .attr( 'y1', 0 )
	                    .attr( 'y2', 0 )
	                    .transition()
	                    .duration( DURATION )
	                    .attr( 'x2', infoWidth );
	      
	      infoContainer.data( [ data.description ] ) 
	                    .append( 'foreignObject' )
	                    .attr( 'width', infoWidth ) 
	                    .attr( 'height', 100 )
	                    .append( 'xhtml:body' )
	                    .attr(
	                      'class',
	                      'pieChart--detail--textContainer ' + 'pieChart--detail__' + position
	                    )
	                    .html( data.description );
	    }
	  }
	  
	  function ಠ_ಠ() {
	    drawPieChart(     'pieChart1',     data.pieChart );
	    drawPieChart(     'pieChart2',     data2.pieChart );
	  }
	  
	  // yeah, let's kick things off!!!
	  ಠ_ಠ();
	  
	})();
	</script>
</body>
</html>
