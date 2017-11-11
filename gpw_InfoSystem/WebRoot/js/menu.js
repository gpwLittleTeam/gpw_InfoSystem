
/*
** Author : Jonllen
** Create : 2009-12-13
** Update : 2010-05-08
** SVN    : 152
** WebSite: http://www.jonllen.com/
*/

var Menu = function (container) {
    this.container = container;
    return this;
}

Menu.prototype = {
    list : new Array(),
    active : new Array(),
    iframes : new Array(),
    settings : {
        id : null,
        parentId : 0,
        name : null,
        url : null,
        level : 1,
        parent : null,
        children : null,
        css : null,
        element : null
    },
    push : function (item) {
        var list = Object.prototype.toString.apply(item) === '[object Array]' ? item : [item];
        
        for( var i=0; i< list.length; i++) {
            var settings = list[i];
            for( p in this.settings) {
                if( !settings.hasOwnProperty(p) ) settings[p] = this.settings[p];
            }
            this.list.push(settings);
        }
        return this;
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
    render : function (container) {
        var _this = this;
        var menuElem = container || this.container;
        for( var i=0;i < this.list.length; i++)
        {
            var item = this.list[i];
            if ( item.parentId != 0 ) continue;
            var itemElem = document.createElement('div');
            itemElem.innerHTML = '<a href="'+item.url+'">'+item.name+'</a>';
            itemElem.className = 'item';
            if ( item.css ) itemElem.className += ' '+item.css;
            var disabled = (' '+item.css+' ').indexOf(' disabled ')!=-1;
            if ( disabled ) {
                itemElem.childNodes[0].disabled = true;
                itemElem.childNodes[0].className = 'disabled';
                itemElem.childNodes[0].removeAttribute('href');
            }
            if ( (' '+item.css+' ').indexOf(' hidden ')!=-1 ) {
                itemElem.style.display = 'none';
            }
            itemElem.menu = item;
            itemElem.menu.children = this.getChlid(item.id);
            itemElem.onmouseover = function (e){
                _this.renderChlid(this);
            };
            menuElem.appendChild(itemElem);
        }
        document.onclick = function (e){
            e = window.event || e;
            var target = e.target || e.srcElement;
            if (!target.menu) {
                var self = _this;
                for( var i=1;i<_this.active.length;i++) {
                    var item = _this.active[i];
                    var menuElem = document.getElementById('menu'+item.id);
                    if ( menuElem !=null)
                        menuElem.style.display = 'none';
                }
                for(var j=1;j<_this.iframes.length;j++){
                    _this.iframes[j].style.display = 'none';
                }
            }
        };
    },
    renderChlid : function (target){
        var self = this;
        var item = target.menu;
        var activeItem = self.active[item.level];
        while(activeItem) {
            var activeItemElem = activeItem.element;
            if ( activeItemElem!= null ) activeItemElem.style.display = 'none';
            activeItem = self.active[activeItem.level + 1];
        }
        self.active[item.level] = item;
        
        var level = item.level;
        while(this.iframes[level]) {
            this.iframes[level].style.display = 'none';
            level++;
        }
        
        var childElem = document.getElementById('menu'+item.id);
        if (childElem==null) {
            var hasChild = false;
            for( var j=0;j<item.children.length;j++) {
                if( (' '+item.children[j].css+' ').indexOf(' hidden ') == -1) {
                    hasChild = true;
                    break;
                }
            }
            if( hasChild) {
            
                var xy = self.elemOffset(target);
                var x = xy.x;
                var y = target.offsetHeight + xy.y;
                if ( item.level >= 2 )
                {
                    x += target.offsetWidth - 1;
                    y -= target.offsetHeight;
                }
                
                childElem = document.createElement('div');
                childElem.id = 'menu'+item.id;
                childElem.className = 'child';
                childElem.style.position = 'absolute';
                childElem.style.left = x + 'px';
                childElem.style.top = y + 'px';
                childElem.style.zIndex = 1000 + item.level;
                for( var i=0;i < item.children.length; i++)
                {
                    var childItem = item.children[i];
                    var childItemElem = document.createElement('a');
                    var disabled = (' '+childItem.css+' ').indexOf('disabled')!=-1;
                    if ( disabled ) {
                        childItemElem.disabled = true;
                        childItemElem.className += ' '+childItem.css;
                    }else {
                        childItemElem.href = childItem.url;
                    }
                    if ( (' '+childItem.css+' ').indexOf(' hidden ')!=-1 ) {
                        childItemElem.style.display = 'none';
                    }
                    childItemElem.innerHTML = childItem.name;
                    childItemElem.menu = childItem;
                    childItemElem.menu.children = self.getChlid(childItem.id);
                    var hasChild = false;
                    for( var j=0;j<childItemElem.menu.children.length;j++) {
                        if( (' '+childItemElem.menu.children[j].css+' ').indexOf(' hidden ') == -1) {
                            hasChild = true;
                            break;
                        }
                    }
                    if( hasChild ) {
                        childItemElem.className += ' hasChild';
                    }
                    childItemElem.onmouseover = function (e) {
                        self.renderChlid(this)
                    };
                    childElem.appendChild(childItemElem); 
                }
                document.body.insertBefore(childElem,document.body.childNodes[0]);
                item.element = childElem;
            }
        }
        
        if( childElem!=null) {
            var iframeElem = this.iframes[item.level];
            if ( iframeElem == null) {
                iframeElem = document.createElement('iframe');
                iframeElem.scrolling = 'no';
                iframeElem.frameBorder = 0;
                iframeElem.style.cssText = 'position:absolute; overflow:hidden;';
                document.body.insertBefore(iframeElem,document.body.childNodes[0]);
                this.iframes[item.level]=iframeElem;
            }
            childElem.style.display = 'block';
            iframeElem.width = childElem.offsetWidth;
            iframeElem.height = childElem.offsetHeight;
            iframeElem.style.left = parseInt(childElem.style.left) + 'px';
            iframeElem.style.top = parseInt(childElem.style.top) + 'px';
            iframeElem.style.display = 'block';
        }
        
    },
    elemOffset : function(elem){
        if( elem==null) return {x:0,y:0};
        var t = elem.offsetTop;
        var l = elem.offsetLeft;
        while( elem = elem.offsetParent) {
            t += elem.offsetTop;
            l += elem.offsetLeft;
        }
        return {x : l,y : t};
    }
};