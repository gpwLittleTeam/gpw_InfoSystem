<%@ page language="java" import="java.util.*,views.View" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" href="css/buttons.css" type="text/css">
<link rel="stylesheet" href="css/universal.css">
<script type="text/javascript" src="js/universal.js"></script>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/jquery.alertWindowLogin.min.js?a=12"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>浙江省高评委信息管理系统</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}

.STYLE3 {
	color: #528311;
	font-size: 12px;
}

.STYLE4 {
	color: #42870a;
	font-size: 12px;
}
-->
</style>
<script>
	function showIdcodeLogin(){
		var htmlBlock = '<form action="to_zjgl_InfoEntryZJ" method="post">' + 
			'<table width="100%" border="0" cellpadding="0" cellspacing="0">' + 
				'<tr>' +
					'<td>' +
						'<div align="center">' + 
							'<span>姓名</span>' +
						'</div>' +
					'</td>' +
					'<td>' +
						'<input type="text" name="expertName"/>' + 
					'</td>' +
				'</tr>' + 
					'<td>' +
						'<div align="center">' + 
							'<span>手机号码</span>' +
						'</div>' +
					'</td>' +
					'<td>' +
						'<input type="text" name="expertPhone"/>' + 
					'</td>' +
				'</tr>' +
				'</tr>' + 
					'<td>' +
						'<div align="center">' + 
							'<span>验证码</span>' +
						'</div>' +
					'</td>' +
					'<td>' +
						'<input type="text" name="expertIdcode"/>' + 
					'</td>' +
				'</tr>' +
				'<tr>' +
					'<td>' +
						'<input type="submit" value="提交"/>' +
					'</td>' +
				'</tr>' +
			'</table>' + 
		'</form>';
		jQuery.alertWindow("专家端录入信息", "#A5DE37"); 
	}
</script>
</head>

<body>
	<table width="100%" height="100%" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td bgcolor="#e5f6cf">&nbsp;</td>
		</tr>
		<tr>
			<td height="608" background="images/login_03.gif">
				<table width="862" border="0" align="center" cellpadding="0"
					cellspacing="0">

					<tr>
						<td height="266" background="images/login_04_.gif">&nbsp;</td>
					</tr>
					<tr>
						<td height="95">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">

								<tr>

									<td width="424" height="95" background="images/login_06.gif">
										&nbsp;</td>
									<td width="183" background="images/login_07.gif">
										<form style="width:100%;padding:0;margin:0" name="loginForm"
											action="login.action" method="post">
											<table style="position:relative;" width="100%" height="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td colspan="2" style="position:absolute;font-size:9pt;color:#F00000; left:5;top:-15;">${message }</td>
												</tr>
												<tr>
													<td width="21%" height="30">
														<div align="center">
															<span class="STYLE3">用户</span>
														</div>
													</td>
													<td width="79%" height="30"><input type="text"
														name="account" id="txtAccount"
														style="height: 18px; width: 130px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;" title="用户名不能为空" required >
													</td>
												</tr>
												<tr>
													<td height="30">
														<div align="center">
															<span class="STYLE3">密码</span>
														</div>
													</td>
													<td height="30"><input type="password" name="psw"
														id="txtPsw"
														style="height: 18px; width: 130px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;" />
													</td>
												</tr>
												<tr>
													<td height="30" align="left"><input type="button" value="录入" onclick="showIdcodeLogin()"/></td>
													<td height="30" align="right"><input type="submit"
														value="登录" /></td>
												</tr>
											</table>
										</form>
									</td>
									<td width="255" background="images/login_08.gif"></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="247" valign="top" background="images/login_09.gif">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="22%" height="30">&nbsp;</td>
									<td width="56%">&nbsp;</td>
									<td width="22%">&nbsp;</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td height="30">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td width="44%" height="20">&nbsp;</td>
												<td width="56%" class="STYLE4">版本 2017V1.0</td>
											</tr>
										</table>
									</td>
									<td>&nbsp;</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td bgcolor="#a2d962">&nbsp;</td>
		</tr>
	</table>

</body>
</html>
