var menu = new Array();
menu.push( {
	id : 1,
	parentId : 0,
	name : '专家管理',
	url : '',
	level : 1,
	css : 'nobg '
});

menu.push( {
	id : 101,
	parentId : 1,
	name : '浙江工业大学高评委',
	url : './infoBrowsing.jsp',
	target:'rightRightFrame',
	level : 2,
});


if (menu.render) {
	menu.render();
}
