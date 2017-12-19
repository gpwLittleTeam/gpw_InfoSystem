function deleteJuryIdcode(formId,objectAddress,action) {
	var aCheckbox=document.getElementsByName("nrOfCheckbox");
	console.log(aCheckbox);
	for(var i=0;i<aCheckbox.length;i++) {
		if(aCheckbox[i].checked == true) {
			var msg = "您确定要删除选中的"+objectAddress+"吗？";
			if (confirm(msg)==true){
				//alert(formId);
				formId.action = action;
				//alert("22");
				formId.submit();
				//alert("11");
				return true;
			}else{
				return false;
			}
		}
	}
	alert("请选择想要删除的"+objectAddress);
	return false;
}

function updateJuryIdcode(formId,objectAddress,action) {
	var aCheckbox=document.getElementsByName("nrOfCheckbox");
	console.log(aCheckbox);
	for(var i=0;i<aCheckbox.length;i++) {
		if(aCheckbox[i].checked == true) {
			var msg = "您确定要重生效选中的"+objectAddress+"吗？";
			if (confirm(msg)==true){
				//alert(formId);
				formId.action = action;
				//alert("22");
				formId.submit();
				//alert("11");
				return true;
			}else{
				return false;
			}
		}
	}
	alert("请选择想要重生效的"+objectAddress);
	return false;
}