function deletion(formId,objectAddress,action) {
	alert("deletion");
	var aCheckbox=document.getElementsByName("nrOfCheckbox");
	alert("deletion2");
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

function update(formId,objectAddress,action) {
	alert("deletion");
	var aCheckbox=document.getElementsByName("nrOfCheckbox");
	alert("deletion2");
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


function CheckSelect()  
{  
  // 遍历 form  
	 var chooseAll=document.getElementsByName("chooseAll");
	 var aCheckbox=document.getElementsByName("nrOfCheckbox");
	 if (chooseAll[0].checked == true)  
	 {
	 		 
	  	for ( var i = 0; i < aCheckbox.length; i++)  
	  	{  
	     aCheckbox[i].checked = true;  
		}
	 }
	else  
	{  
		for ( var i = 0; i < aCheckbox.length; i++)  
	  	{  
	     aCheckbox[i].checked = false;  
		}
	} 
}