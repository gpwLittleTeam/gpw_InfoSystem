<%@ page language="java" import="java.util.*,views.View" pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title></title>
		<script>
		parent.document.all.I2.height = screen.height;
        parent.document.all.rightFrame.height = screen.height - 300;
  		</script>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.STYLE2 {
	color: #43860c;
	font-size: 12px;
}

a:link {
	font-size: 12px;
	text-decoration: none;
	color: #43860c;
}

a:visited {
	font-size: 12px;
	text-decoration: none;
	color: #43860c;
}

a:hover {
	font-size: 12px;
	text-decoration: none;
	color: #FF0000;
}
-->
</style>
		<script type="text/JavaScript">
				function MM_preloadImages() { //v3.0
				  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
				    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
				    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
				}
				
				function MM_swapImgRestore() { //v3.0
				  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
				}
				
				function MM_findObj(n, d) { //v4.01
				  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
				    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
				  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
				  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
				  if(!x && d.getElementById) x=d.getElementById(n); return x;
				}
				
				function MM_swapImage() { //v3.0
				  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
				   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
				}
		</script>
	</head>

	<body
		onload="MM_preloadImages('images/main_26_1.gif','images/main_29_1.gif','images/main_31_1.gif')">
		<jsp:include page="<%=View.SESSION %>"></jsp:include>
		<table width="177" style="height: 100%" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td valign="top">
					<table width="173" border="0" cellspacing="0" cellpadding="0"
						style="table-layout: fixed;" height="179">
						<tr>
							<td height="26" style="background-image: url('images/main_21.gif');background-repeat :repeat-x;" >
								&nbsp;
							</td>
						</tr>
						<!--<tr>
							<td height="80"
								style="background-image: url(images/main_23.gif); background-repeat: repeat-x;">
								  <table width="170" border="0" align="center" cellpadding="0"
									cellspacing="0" height="72">
									<tr>
										<td height="45">
											<div align="center">
												<a href="#"><br />
												</a>
											</div>
										</td>
										<td>
											<div align="center">
												<a href="#">
												<br />
												</a>
											</div>
										</td>
										<td>
											<div align="center">
												<a href="#"><br />
												</a>
											</div>
										</td>
									</tr>
									<tr>
										<td height="25">
											<div align="center" class="STYLE2">
												<a href="#"><br /></a>
											</div>
										</td>
										<td>
											<div align="center" class="STYLE2">
												<a href="#"><br /></a>
											</div>
										</td>

									</tr>
								</table>
							</td>
						</tr>
						-->
						<tr>
							<td style="line-height: 4px; background: url(images/main_38.gif)">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td>
								<div id="treemenu" class="treemenu"></div>
								<div style="text-align: center;">
									<br />
								</div>
								<div style="margin: 20px auto;">
									&nbsp;&nbsp;&nbsp;
									<br />
								</div>
								<script type="text/javascript" src="adminjs/getmenu.js"
									charset="gb2312"></script>
								<script type="text/javascript" src="adminjs/TreeMenu.js"></script>
								<script type="text/javascript">
									//TreeMenu
									var treemenu = new TreeMenu( {
										container : document.getElementById('treemenu'),
										tree_expand_plus : 'images/tree_expand_plus.gif',
										tree_expand_minus : 'images/tree_expand_minus.gif',
										tree_expand_normal : 'images/tree_expand_normal.gif',
										tree_icon_file : 'images/tree_icon_file.gif',
										tree_icon_folder : 'images/tree_icon_folder.gif',
										tree_icon_folderopen : 'images/tree_icon_folderopen.gif'
									});
								
									function bindTree() {
										treemenu.list.length = 0;
								
										treemenu.push( {
											id : 9999,
											parentId : 0,
											html : '职称申报管理',
											href : '#',
											img : 'images/ico_profile.gif',
											disabled : true,
											createExpand : false,
											click : function(treemenu) {
												//alert('您选择了' + treemenu.html);
											}
								
										});
								
										for ( var i = 0; i < menu.length; i++) {
											treemenu.push( {
												id : menu[i].id,
												parentId : menu[i].parentId,
												html : menu[i].name,
												href : menu[i].url,
												title : menu[i].name
											});
										}
								
										treemenu.push( {
											id : 10000,
											parentId : 0,
											title : '',
											html : '退出系统',
											target : '_top',
											href : 'LoginServlet?action=logoff',
											click : function() {
												return true;
											}
										});
								
										treemenu.render();
									}
								
									bindTree();
								
									function checkboxMode() {
										treemenu.settings.checkbox = true;
										bindTree();
									}
								
									function radioMode() {
										treemenu.settings.checkbox = false;
										treemenu.settings.radio = true;
										bindTree();
									}
								</script>
								<br />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
