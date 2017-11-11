var menu = menu || new Array();
menu.push( {
	id : 1,
	parentId : 0,
	name : 'ÉóºË¹ÜÀí',
	url : '#',
	level : 1,
	css : 'nobg '
});

menu.push( {
	id : 101,
	parentId : 1,
	name : 'Î´ÉóºË²ÄÁÏ',
	url : './review_weishen.jsp',
	target:'rightFrame',
	level : 2,
});
menu.push( {
	id : 102,
	parentId : 1,
	name : 'ÒÑÉóºË²ÄÁÏ',
	url : './review_yishen.jsp',
	target:'rightFrame',
	level : 2,
});



if (menu.render) {
	menu.render();
}
