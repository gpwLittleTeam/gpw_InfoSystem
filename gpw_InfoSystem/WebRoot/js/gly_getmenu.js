/**
 * 
 */

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
	url : 'to_zjgl_InfoList_gly.action',
	target:'rightFrame',
	level : 2,
});


//****************



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
	name : '高评委管理',
	url : 'to_gpwgl',
	target : 'rightframe',
	level : 1,
	css : 'nobg'
});



menu.push( {
	id : 5,
	parentId : 0,
	name : '代码管理',
	url : '',
	target : 'rightframe',
	level : 1,
	css : 'nobg'
});
menu.push( {
	id : 501,
	parentId : 5,
	name : '高评委职务代码表',
	url : 'to_codePage.action?table=Counciltitle',
	level : 2
});
menu.push( {
	id :502,
	parentId : 5,
	name : '学位代码表',
	url : 'to_codePage.action?table=Degree',
	level : 2
});
menu.push( {
	id : 503,
	parentId : 5,
	name : '学历代码表',
	url : 'to_codePage.action?table=Education',
	level : 2
});
menu.push( {
	id : 504,
	parentId : 5,
	name : '聘任情况代码表',
	url : 'to_codePage.action?table=engage',
	level : 2
});
/*menu.push( {
	id : 505,
	parentId : 5,
	name : '专业组代码表',
	url : 'to_codePage_Group.action',
	level : 2
});*/
menu.push( {
	id : 506,
	parentId : 5,
	name : '专业组职务代码表',
	url : 'to_codePage.action?table=grouptitle',
	level : 2
});
menu.push( {
	id : 507,
	parentId : 5,
	name : '系列代码表',
	url : 'to_codePage.action?table=series',
	level : 2
});
menu.push( {
	id : 508,
	parentId : 5,
	name : '性别代码表',
	url : 'to_codePage.action?table=sex',
	level : 2
});
menu.push( {
	id : 509,
	parentId : 5,
	name : '专业代码表',
	url : 'to_codePage.action?table=special',
	level : 2
});
menu.push( {
	id : 510,
	parentId : 5,
	name : '任职资格代码表',
	url : 'to_codePage.action?table=title',
	level : 2
});
menu.push( {
	id : 511,
	parentId : 5,
	name : '资格级别代码表',
	url : 'to_codePage.action?table=titlegrade',
	level : 2
});

menu.push( {
	id : 6,
	parentId : 0,
	name : '高评委用户管理',
	url : 'to_userManagement.action',
	level : 1
});
menu.push( {
	id : 7,
	parentId : 0,
	name : '修改密码',
	url : './xgmm.jsp',
	level : 1
});





if (menu.render) {
	menu.render();
}