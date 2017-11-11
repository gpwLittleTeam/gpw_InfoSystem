<!DOCTYPE HTML>
<html>
<head>
	<title>身份信息错误</title>
	<meta charset="UTF-8" />
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
	<div>
		身份失效，请<a target="_top" href="./login.jsp">重新登入</a>，或<a target="_top" href="javascript:parent.location.reload();">刷新页面</a>
	</div>
	<div>
		<span id="jumpTo">5</span>秒后自动跳转到登入界面
		<script type="text/javascript">
			countDown(5, './index.jsp');
		</script>
	</div>
</body>
</html>
