var menu = menu || new Array();
menu.push( {
	id : 1,
	parentId : 0,
	name : '��˹���',
	url : '#',
	level : 1,
	css : 'nobg '
});

menu.push( {
	id : 101,
	parentId : 1,
	name : 'δ��˲���',
	url : './review_weishen.jsp',
	target:'rightFrame',
	level : 2,
});
menu.push( {
	id : 102,
	parentId : 1,
	name : '����˲���',
	url : './review_yishen.jsp',
	target:'rightFrame',
	level : 2,
});



if (menu.render) {
	menu.render();
}
