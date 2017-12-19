
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
	name : '信息浏览',
	url : 'to_zjgl_InfoList_gpw.action',
	target:'rightFrame',
	level : 2,
});
menu.push( {
	id : 102,
	parentId : 1,
	name : '专家录入',
	url : 'to_zjgl_InfoEntry.action',
	level : 2,
});

menu.push( {
	id : 2,
	parentId : 0,
	name : '评委抽取',
	url : '',
	level : 1,
	css : 'nobg '
});
menu.push( {
	id : 201,
	parentId : 2,
	name : '抽取委员会',
	url : 'to_pwcq_wyh!firstPage.action',
	level : 2
});
menu.push( {
	id : 202,
	parentId : 2,
	name : '抽取评议组',
	url : 'to_pwcq_pyz.action',
	level : 2
});

menu.push( {
	id : 3,
	parentId : 0,
	name : '查询统计',
	url : '',
	level : 1,
	css : 'nobg '
});

menu.push( {
	id : 301,
	parentId : 3,
	name : '信息查询',
	url : 'to_cxtj_query.action',
	level : 2
});

menu.push( {
	id : 302,
	parentId : 3,
	name : '信息统计',
	url :'./cxtj_statistics.jsp',
	level : 2,
});

menu.push( {
	id : 4,
	parentId : 0,
	name : '专业组管理',
	url : 'to_zyzgl.action',
	target : 'rightframe',
	level : 1,
	css : 'nobg'
});



menu.push( {
	id : 5,
	parentId : 0,
	name : '任职管理',
	url : 'to_rzgl.action',
	target : 'rightframe',
	level : 1,
	css : 'nobg'
});

menu.push( {
	id : 6,
	parentId : 0,
	name : '修改密码',
	url : './xgmm.jsp',
	target : 'rightframe',
	level : 1,
	css : 'nobg'
});

/*menu.push( {
	id : 7,
	parentId : 0,
	name : '验证码管理',
	url : 'to_juryIdcode',
	target : null,
	level : 1,
	css : 'nobg'
});*/

menu.push( {
	id : 8,
	parentId : 0,
	name : '验证码管理',
	url : 'to_authCode',
	level : 1,
	css : 'nobg'
});


if (menu.render) {
	menu.render();
}