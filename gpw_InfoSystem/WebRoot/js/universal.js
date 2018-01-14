/** formId-->> document.XXX */
function deletion(formId,objectAddress,action) {
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


/*表格 行变色*/
var  highlightcolor='#eafcd5';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(){
	source=event.srcElement;
	
	if  (source.tagName=="TR"||source.tagName=="TABLE")
		return;
	
	while(source.tagName!="TD")
		source=source.parentElement;
	
	source=source.parentElement;
	cs  =  source.children;
	//alert(cs.length);
	if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
		for(var i=0;i<cs.length;i++){
			cs[i].style.backgroundColor=highlightcolor;
		}
}

function  changeback(){
	if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
	return;
	if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
		for(var i=0;i<cs.length;i++){
			cs[i].style.backgroundColor="";
		}
}
/*表格行变色 end
