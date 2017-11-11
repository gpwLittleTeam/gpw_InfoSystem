<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;" />
<title>密码修改成功</title>
<script type="text/javascript">
	function countDown(secs, surl) {
		//alert(surl); 
		var jumpTo = document.getElementById('jumpTo');
		jumpTo.innerHTML = secs;
		if (--secs > 0) {
			setTimeout("countDown(" + secs + ",'" + surl + "')", 1000);
		} else {
			location.href = surl;
		}
	}
</script>
</head>
<body>
	<span id="jumpTo">5</span>秒后自动跳转到主页
	<script type="text/javascript">
		countDown(5, './index.jsp');
	</script>
	<div>
		或 手动点击<a href="./index.jsp">主页</a>跳转
	</div>
</body>
</html>
