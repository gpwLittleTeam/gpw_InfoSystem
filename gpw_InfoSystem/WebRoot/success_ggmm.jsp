<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;" />
<title>�����޸ĳɹ�</title>
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
	<span id="jumpTo">5</span>����Զ���ת����ҳ
	<script type="text/javascript">
		countDown(5, './index.jsp');
	</script>
	<div>
		�� �ֶ����<a href="./index.jsp">��ҳ</a>��ת
	</div>
</body>
</html>
