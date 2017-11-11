
/*
** Author : Jonllen
** Create : 2010-05-01
** Update : 2010-05-09
** SVN    : 153
** WebSite: http://www.jonllen.com/
*/

var ContextMenu = function (settings) {

    for( p in this.settings)
    {
        if( !settings.hasOwnProperty(p) ) settings[p] = this.settings[p];
    }
    this.settings = settings;
    
    this.settings.menu = document.createElement('div');
    this.settings.menu.className = this.settings.css;
    this.settings.menu.style.cssText = 'position:absolute;display:none;';
    document.body.insertBefore(this.settings.menu,document.body.childNodes[0]);
    
    return this;
}

ContextMenu.prototype = {
    list : new Array(),
    active : new Array(),
    iframes : new Array(),
    settings : {
        menu : null,
        excursionX : 0,
        excursionY : 0,
        css : 'contextmenu',
        container : null,
        locked : false
    },
    item : {
        id : null,
        level : 1,
        parentId : 0,
        html : '',
        title : '',
        href : 'javascript:;',
        target : '_self',
        css : null,
        element : null,
        childElement : null,
        parent : null,
        children : null,
        type : 'static',
        click : null,
        clickClose : false
    },
    push : function (item) {
        var list = Object.prototype.toString.apply(item) === '[object Array]' ? item : [item];
        for( var i=0; i< list.length; i++) {
            var  _item = list[i];
            for( p in this.item) {
                if( !_item.hasOwnProperty(p) ) _item[p] = this.item[p];
            }
            _item.element = null;
            if( _item.name ) _item.html = _item.name;
            if( _item.url ) _item.href = _item.url;
            if( _item.type == 'static') {
                this.list.push(_item);
            }else {
                if(this.dynamic == null) this.dynamic = new Array();
                this.dynamic.push(_item);
            }
        }
        return this;
    },
    bind : function (){
        var _this = this;
        for( var i=0; this.dynamic && i<this.dynamic.length; i++)
        {
            var item = this.dynamic[i];
            var itemElem = document.createElement('div');
            itemElem.title = item.title;
            itemElem.innerHTML = '<a href="'+item.href+'" target="'+item.target+'">'+item.html+'</a>';
            itemElem.className = 'item ' + (item.css?' '+item.css:'');
            item.element = itemElem;
            
            if( item.click ) {
                (function (item){
                    item.element.childNodes[0].onclick = function (e){
                        if( item.clickClose) _this.hidden();
                        return item.click(e);
                    };
                })(item);
            }
            
            itemElem.contextmenu = item;
            itemElem.onmouseover = function (e){ _this.hidden(item.level);};
            
            var index = item.index || 0;
            if( index >= this.settings.menu.childNodes.length)
                index = this.settings.menu.childNodes.length - 1;
            if( index < 0 )
                this.settings.menu.appendChild(itemElem);
            else
                this.settings.menu.insertBefore(itemElem, this.settings.menu.childNodes[index]);
        }
    },
    render : function ( container ) {
        
        var _this = this;
        
        container = container || this.settings.container;
        
        this.settings.menu.innerHTML = '';
        
        for( var i=0;i < this.list.length; i++)
        {
            var item = this.list[i];
            if ( item.parentId != 0 ) continue;
            var itemElem = document.createElement('div');
            itemElem.title = item.title;
            itemElem.innerHTML = '<a href="'+item.href+'" target="'+item.target+'">'+item.html+'</a>';
            itemElem.className = 'item ' + (item.css?' '+item.css:'');
            var disabled = _this.hasClass(itemElem, 'disabled');
            if ( disabled ) {
                itemElem.childNodes[0].disabled = true;
                itemElem.childNodes[0].className = 'disabled';
                itemElem.childNodes[0].removeAttribute('href');
            }
            if ( _this.hasClass(itemElem, 'hidden') ) {
                itemElem.style.display = 'none';
            }
            
            if( item.click ) {
                (function (item){
                    item.element.childNodes[0].onclick = function (e){
                        if( item.clickClose) _this.hidden();
                        return item.click(e);
                    };
                })(item);
            }
            
            itemElem.contextmenu = item;
            itemElem.contextmenu.children = this.getChlid(item.id);
            if( itemElem.contextmenu.children.length > 0 )
                itemElem.childNodes[0].className += ' hasChild';
            itemElem.onmouseover = function (e){ _this.renderChlid(this);};
            this.settings.menu.appendChild(itemElem);
        }
        
        this.active[0] = { element : _this.settings.menu };
        this.settings.menu.contextmenu = _this;
        container.oncontextmenu = function (e){
            e = window.event || e;
            var target = e.target || e.srcElement;
            if( e.preventDefault)
                e.preventDefault();
            var mouseCoords = _this.mouseCoords(e);
            _this.settings.menu.style.left = mouseCoords.x + _this.settings.excursionX + 'px';
            _this.settings.menu.style.top = mouseCoords.y + _this.settings.excursionY + 'px';
            _this.hidden();
            _this.show(0, target);
            return false;
        };
        this.addEvent(document, 'click', function (e){
            e = window.event || e;
            var target = e.target || e.srcElement;
            var isContextMenu = !!target.contextmenu;
            if( isContextMenu == false) {
                var parent = target.parentNode;
                while( parent!=null) {
                    if( parent.contextmenu) {
                        isContextMenu = true;
                        break;
                    }
                    parent = parent.parentNode;
                }
            }
            if (isContextMenu == false) {
                _this.hidden();
            }
        });
        
    },
    renderChlid : function ( target ){
    
        if(this.settings.locked) return;
        
        var contextmenu = target.contextmenu;
        var currentLevel = contextmenu.level;
        this.hidden(currentLevel);
        
        var hasChild = false;
        for( var j=0;j<contextmenu.children.length;j++) {
            if( (' '+contextmenu.children[j].css+' ').indexOf(' hidden ') == -1) {
                hasChild = true;
                break;
            }
        }
        if( !hasChild) return;
        
        var childElem = contextmenu.element;
        if (childElem == null) {
            
            childElem = document.createElement('div');
            childElem.className = this.settings.css;
            childElem.style.position = 'absolute';
            childElem.style.zIndex = 1000 + contextmenu.level;
            
            var _this = this;
            
            for( var i=0;i < contextmenu.children.length; i++)
            {
                var childItem = contextmenu.children[i];

                var childItemElem = document.createElement('div');
                childItemElem.title = childItem.title;
                childItemElem.innerHTML = '<a href="'+childItem.href+'" target="'+childItem.target+'">'+childItem.html+'</a>';
                childItemElem.className = 'item' + (childItem.css?' '+childItem.css : '');
                var disabled = this.hasClass(childItemElem, 'disabled');
                if ( disabled ) {
                    childItemElem.childNodes[0].disabled = true;
                    childItemElem.childNodes[0].removeAttribute('href');
                }
                if ( this.hasClass(childItemElem, 'hidden') ) {
                    childItemElem.style.display = 'none';
                }
                
                if( childItem.click ) {
                    (function (childItem){
                        childItem.element.childNodes[0].onclick = function (e){
                            if( childItem.clickClose) _this.hidden();
                            return childItem.click(e);
                        };
                    })(childItem);
                }
                
                childItem.parent = contextmenu;
                childItemElem.contextmenu = childItem;
                childItemElem.contextmenu.children = this.getChlid(childItem.id);
                var hasChild = false;
                for( var j=0; j<childItemElem.contextmenu.children.length; j++) {
                    if( (' '+childItemElem.contextmenu.children[j].css+' ').indexOf(' hidden ') == -1) {
                        hasChild = true;
                        break;
                    }
                }
                if( hasChild ) {
                    childItemElem.childNodes[0].className += ' hasChild';
                }
                childItemElem.onmouseover =  function (e){ _this.renderChlid(this);};
                childElem.appendChild(childItemElem);
            }
            
            document.body.insertBefore(childElem,document.body.childNodes[0]);
            contextmenu.element = childElem;

        }
        
        this.active[currentLevel] = contextmenu;
        
        var xy = this.elemOffset(target);
        var x = xy.x + target.offsetWidth + this.settings.excursionX;
        var y = xy.y + this.settings.excursionY;
        childElem.style.left = x + 'px';
        childElem.style.top = y + 'px';
        childElem.style.display = 'block';
        
        this.show(currentLevel);
    },
    getChlid : function (id) {
        var list = new Array();
        for( var i=0;i < this.list.length; i++)
        {
            var item = this.list[i];
            if( item.parentId == id)
            {
                list.push(item);
            }
        }
        return list;
    },
    show : function (level, target) {
    
        if(this.settings.locked) return;
        
        level = level || 0;
        var item = this.active[level];
        
        if ( level == 0 ) {
            for( var i=0;this.dynamic && i < this.dynamic.length; i++)
            {
                var dynamicItemElem = this.dynamic[i].element;
                if( dynamicItemElem !=null) dynamicItemElem.parentNode.removeChild(dynamicItemElem);
            }
            if (this.dynamic) this.dynamic.length = 0;
            this.onShow(target, this);
        }
        
        var menuElem = item.element;
        menuElem.style.display = 'block';
        var iframeElem = this.iframes[level];
        if ( iframeElem == null) {
            iframeElem = document.createElement('iframe');
            iframeElem.scrolling = 'no';
            iframeElem.frameBorder = 0;    
            iframeElem.style.cssText = 'position:absolute; overflow:hidden;';
            document.body.insertBefore(iframeElem,document.body.childNodes[0]);
            this.iframes.push(iframeElem);
        }
        iframeElem.width = menuElem.offsetWidth;
        iframeElem.height = menuElem.offsetHeight;
        var menuElemOffset = this.elemOffset(menuElem);
        iframeElem.style.left = menuElemOffset.x + 'px';
        iframeElem.style.top = menuElemOffset.y + 'px';
        iframeElem.style.display = 'block';
        
    },
    onShow : function (target, _this) {
    
        if( target.nodeType == 1 && target.tagName == 'A' && target.innerHTML.indexOf('.rar') != -1 ){
            //解压文件
            _this.push( {
                html : '解压缩到“'+target.innerHTML.substring(0,target.innerHTML.lastIndexOf('.'))+'\\”...',
                click : function (e){
                    e = e || window.event;
                    var srcElement = e.srcElement || e.target;
                    srcElement.className = 'on';
                    srcElement.innerHTML = '解压缩到“'+target.innerHTML.substring(0,target.innerHTML.lastIndexOf('.'))+'\\”...';
                    var url = '/Ajax/FileZip.aspx?mode=unzip&files='+target.href.substring(target.href.replace('//','xx').indexOf('/'));
                    if( typeof Ajax == 'undefined') return;
                    Ajax.get(url, function (data, _this){
                        _this.settings.locked = true;
                        eval(data);
                        if( rs.success ) {
                            location.reload();
                        }else{
                            alert(rs.error);
                            _this.hidden();
                        }
                    }, _this);
                    srcElement.onclick = null;
                    _this.settings.locked = true;
                    
                },
                clickClose : false,
                index : 2,
                type : 'dynamic'
            });
        }
        else if( target.nodeType == 1 && target.title.indexOf('添加到') == 0) {
            //添加单个压缩文件
             _this.push( { 
                html : target.title,
                title : target.title,
                click : function (e){
                    var index = target.href.indexOf('?path=');
                    if( index != -1){
                        var fullName = target.href.substring(index+'?path='.length);
                    }else {
                        var fullName = target.href.substring(target.href.replace('//','xx').indexOf('/'));
                    }
                    e = e || window.event;
                    var srcElement = e.srcElement || e.target;
                    srcElement.className = 'on';
                    srcElement.innerHTML = '正在添加到“'+fullName.substring(fullName.lastIndexOf('/')+1)+'.rar”...';
                    var url = '/Ajax/FileZip.aspx?mode=zip&files='+fullName;
                    if( typeof Ajax == 'undefined') return;
                    Ajax.get(url, function (data, _this){
                        _this.settings.locked = true;
                        eval(data);
                        if( rs.success ) {
                            location.reload();
                        }else{
                            alert(rs.error);
                            _this.hidden();
                        }
                    }, _this);
                    srcElement.onclick = null;
                    _this.settings.locked = true;
                },
                clickClose : false,
                index : 2,
                type : 'dynamic',
                css : 'on'
            });
        }else {
            //添加多个压缩文件
            var fileName = '';
            var files = new Array();
            var ids = document.getElementsByName('ids');
            for( var i=0; i<ids.length; i++) {
                if( !ids[i].checked) continue;
                
                var file = ids[i].value;
                files.push(file);
                if( files.length == 1) {
                    fileName = file.substring(file.lastIndexOf('/')+1) + '.rar';
                }
            }
            if( files.length > 0 ){
                _this.push( {
                    html : '添加'+files.length+'个文件到压缩包“'+fileName+'”',
                    click : function (e){
                        
                        e = e || window.event;
                        var srcElement = e.srcElement || e.target;
                        srcElement.className = 'on';
                        srcElement.innerHTML = '正在添加到“'+fileName+'”...';
                        var url = '/Ajax/FileZip.aspx?mode=zip&files='+files.join('|');
                        if( typeof Ajax == 'undefined') return;
                        Ajax.get(url, function (data, _this){
                            _this.settings.locked = true;
                            eval(data);
                            if( rs.success ) {
                                location.reload();
                            }else{
                                alert(rs.error);
                                _this.hidden();
                            }
                        }, _this);
                        srcElement.onclick = null;
                        _this.settings.locked = true;
                        
                    },
                    clickClose : false,
                    index : 2,
                    type : 'dynamic'
                });
            }
        }
        
        if( target.nodeType == 1 && target.tagName == 'A') {
            _this.push( { 
                html : '属性“'+target.innerHTML+'”',
                href : target.href,
                click : function (e){
                    prompt('属性“'+target.innerHTML+'”',target.href);
                    return false;
                },
                clickClose : true,
                index : 3,
                type : 'dynamic'
            });
        }
        
        var selection = window.getSelection ? window.getSelection().toString() : document.selection.createRange().text;
        if( selection ) {
            _this.push( {
                html : '复制“' + (selection.length > 15 ? selection.substring(0,12) + '...' : selection) +'”',
                title : '复制“' + selection + '”',
                click : function (e) {
                    if(window.clipboardData) {    
                        window.clipboardData.clearData();
                        window.clipboardData.setData("Text", selection);
                    }else {
                        netscape.security.PrivilegeManager.enablePrivilege('UniversalXPConnect');
                        var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);
                        var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);
                        if (!clip || !trans) return;

                        trans.addDataFlavor('text/unicode');
                        var len = new Object();
                        var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
                        str.data = selection;
                        trans.setTransferData("text/unicode",str,selection.length*2);
                        var clipid=Components.interfaces.nsIClipboard;
                        if (!clip) return false;
                        clip.setData(trans,null,clipid.kGlobalClipboard);
                    }
                },
                clickClose : true,
                index : 0,
                type : 'dynamic'
            });
        }
        
        _this.bind();
    },
    hidden : function (level) {

        level = level || 0;
        
        for( var i = level; i<this.active.length; i++) {
            var item = this.active[i];

            var iframeElem = this.iframes[i];
            if ( iframeElem !=null)
                iframeElem.style.display = 'none';
            
            if(this.settings.locked) return;
            
            var menuElem = item.element;
            if ( menuElem !=null)
                menuElem.style.display = 'none';
                
        }
        this.onHidden(level);
    },
    onHidden : function (level) {
    },
    hasClass : function (elem, name) {
        return !!elem && (' '+elem.className+' ').indexOf(' '+name+' ') != -1;
    },
    elemOffset : function(elem){
        var left = 0;
        var top  = 0;
        while (elem.offsetParent){
            left += elem.offsetLeft;
            top  += elem.offsetTop;
            elem  = elem.offsetParent;
        }
        left += elem.offsetLeft;
        top  += elem.offsetTop;
        return {x:left, y:top};
    },
    mouseCoords : function (e){
        if (e.pageX && e.pageY) {
            return {
                x: e.pageX,
                y: e.pageY
            };
        }
        var d = (document.documentElement && document.documentElement.scrollTop) ? document.documentElement : document.body;
        return {
            x: e.clientX + d.scrollLeft,
            y: e.clientY + d.scrollTop
        };
    },
    addEvent : function(target,eventType,func){
		if(target.attachEvent)
		{
			target.attachEvent("on" + eventType, func);
			
		}else if(target.addEventListener)
		{
			target.addEventListener(eventType == 'mousewheel' ? 'DOMMouseScroll' : eventType, func, false);
		}
		return this;
	},
	removeEvent : function(target,eventType,func){
		if(target.detachEvent)
		{
			target.detachEvent("on" + eventType, func);
			
		}else if(target.removeEventListener)
		{
			target.removeEventListener(eventType == 'mousewheel' ? 'DOMMouseScroll' : eventType, func, false);
		}
		return this;
	}
}