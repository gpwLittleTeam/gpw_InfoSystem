<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML>
<html>
<head>
<title></title>
<link rel="stylesheet" href="css/buttons.css" type="text/css">
<link rel="stylesheet" href="css/universal.css">
<script type="text/javascript" src="js/universal.js"></script>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/jquery.alertWindow.min.js?a=12"></script>
<meta charset="UTF-8" />
</head>
<body>
	<script type="text/JavaScript">
 	 $.ajaxSetup({  //同步处理
    	async : false  
	});    
	
	function showRandomNum() {
	 //ajax 获取
		var htmlBlock = "";
		$.post("showRandomNum.action", {}, function(data) {
			
			console.log(data); //
			//console.log(data.resultString); 
			var randomNum = JSON.parse(data.resultString);
			
			$.each(randomNum, function(i, list) {
				htmlBlock = htmlBlock + '<div><span style="width:200px">'
						+ "生效时间: " + list.time + '</span></div>'
						+ '<div><span style="width:200px">'
						+ "密码: " + list.random
						+ '</span></div>';
				
			});
		});
		//alert(htmlBlock);
		jQuery.alertWindow("录入密码(有效期1天)", htmlBlock, "#A5DE37"); 
	}
	
	showRandomNum();
	</script>	
</body>
</html>
