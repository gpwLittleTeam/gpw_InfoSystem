
/*
** Author : Jonllen
** Create : 2010-05-08
** SVN    : 152
** WebSite: http://www.jonllen.com/
*/

var TreeMenu = function (settings){
    for( p in this.settings) {
        if( !settings.hasOwnProperty(p) ) settings[p] = this.settings[p];
    }
    this.settings = settings;
}

TreeMenu.prototype = {
    list : new Array(),
    settings : {
        indent : 20,
        container : null,
        recursion : false,
        checkbox : false,
        radio : false,
        name : 'ids',
        tree_expand_plus : 'images/tree_expand_plus.gif',
        tree_expand_minus : 'images/tree_expand_minus.gif',
        tree_expand_normal : 'images/tree_expand_normal.gif',
        tree_icon_file : 'images/tree_icon_file.gif',
        tree_icon_folder : 'images/tree_icon_folder.gif',
        tree_icon_folderopen : 'images/tree_icon_folderopen.gif'
    },
    item : {
        id : null,
        level : 1,
        parentId : 0,
        html : '',
        title : '',
        href : 'javascript:;',
        target : 'rightFrame',
        css : 'item',
        img : null,
        click : null,
        createExpand : true,
        expand : false,
        checked : false,
        disabled : false,
        children : null
    },
    push : function (item) {
        var list = Object.prototype.toString.apply(item) === '[object Array]' ? item : [item];
        for( var i=0; i< list.length; i++) {
            var  _item = list[i];
            for( p in this.item) {
                if( !_item.hasOwnProperty(p) ) _item[p] = this.item[p];
            }
            this.list.push(_item);
        }
    },
    render : function (container){
        var _this = this;
        
        var container = container || this.settings.container;
        
        while( container.lastChild) {
            container.removeChild( container.lastChild);
        }
        
        for( var i=0; i<this.list.length; i++) {
            var item = this.list[i];
            if( item.parentId !=0) continue;
            
            var itemElem = document.createElement('div');
            itemElem.className = item.css;
            itemElem.title = item.title;
            
            var expandElem = null;
            if( item.createExpand) {
                expandElem = document.createElement('img');
                expandElem.src = this.settings.tree_expand_plus;
                itemElem.appendChild(expandElem);
            }
            
            var iconElem = document.createElement('img');
            iconElem.src = item.img ? item.img : this.settings.tree_icon_folder;
            itemElem.appendChild(iconElem);
            
            if( this.settings.checkbox || this.settings.radio){
                var inputTemp = document.createElement('div');
                inputTemp.innerHTML = '<input type="'+(this.settings.checkbox?'checkbox':'radio')+'" name="' + this.settings.name + '" />';
                var inputElem = inputTemp.childNodes[0];
                inputElem.value = item.id;
                inputElem.checked = item.checked;
                inputElem.disabled = item.disabled;
                
                itemElem.appendChild(inputElem);
                item.inputElem = inputElem;
            }
            
            var aElem = document.createElement('a');
            aElem.href = item.href;
            aElem.target = item.target;
            aElem.innerHTML = item.html;
            itemElem.appendChild(aElem);
            
            var children = this.getChlid(item.id);
            if( children.length ==0 ){
                expandElem ? expandElem.src = this.settings.tree_expand_normal : null;
                iconElem.src = item.img ? item.img : this.settings.tree_icon_file;
            }
            
            item.children = children;
            item.itemElem = itemElem;
            item.iconElem = iconElem;
            item.expandElem = expandElem;
            item.aElem = aElem;
            
            itemElem.treemenu = item;
            
            container.appendChild(itemElem);
        }
        
        container.onclick = this.onClick;
        container._this = this;
    },
    renderChild : function(item, checked) {
    
        if( item.children.length == 0) return;
        
        var _this = this;
        var expand = item.expand;
        
        for( var i=0;i<item.children.length;i++) {
                
            var childItem = item.children[i];
            
            var childElem = childItem.itemElem;
            
            if( childElem == null) {
                childElem = document.createElement('div');
                childElem.className = childItem.css;
                childElem.title = childItem.title;
                
                var expandElem = null;
                if( childItem.createExpand) {
                    expandElem = document.createElement('img');
                    expandElem.src = this.settings.tree_expand_plus;
                    childElem.appendChild(expandElem);
                }
                
                var iconElem = document.createElement('img');
                iconElem.src = childItem.img ? childItem.img : this.settings.tree_icon_folder;
                childElem.appendChild(iconElem);
                
                if( this.settings.checkbox || this.settings.radio){
                    var inputTemp = document.createElement('div');
                    inputTemp.innerHTML = '<input type="'+(this.settings.checkbox?'checkbox':'radio')+'" name="' + this.settings.name + '" />';
                    var inputElem = inputTemp.childNodes[0];
                    inputElem.value = childItem.id;
                    inputElem.checked = childItem.checked;
                    inputElem.disabled = childItem.disabled;
                    
                    childElem.appendChild(inputElem);
                    childItem.inputElem = inputElem;
                }
                
                var aElem = document.createElement('a');
                aElem.href = childItem.href;
                aElem.target = childItem.target;
                aElem.innerHTML = childItem.html;
                childElem.appendChild(aElem);
                
                var children = this.getChlid(childItem.id);
                if( children.length ==0 ){
                    expandElem ? expandElem.src = this.settings.tree_expand_normal : null;
                    iconElem.src = childItem.img ? childItem.img : this.settings.tree_icon_file;
                }
                
                childItem.level = item.level + 1;
                
                childElem.style.paddingLeft = this.settings.indent+'px';
                childElem.style.display = 'none';
                
                childItem.parent = item;
                childItem.children = children;
                childItem.itemElem = childElem;
                childItem.iconElem = iconElem;
                childItem.expandElem = expandElem;
                childItem.aElem = aElem;
                
                childElem.treemenu = childItem;
                
                item.itemElem.appendChild(childElem);
            }
            
            if( this.settings.recursion ) {
                //递归
                childItem.expand = expand;
                this.renderChild(childItem, checked);
            }
            
            if( childItem.inputElem && typeof checked != 'undefined') {
                childItem.inputElem.checked = checked;
                continue;
            }
            
            childItem.expand = expand;
            childElem.style.display = childItem.expand ? 'none' : 'block';
        }

        if( typeof checked == 'undefined') {
            item.expandElem && (item.expandElem.src = expand ? this.settings.tree_expand_plus : this.settings.tree_expand_minus);
            item.iconElem.src = expand ? (item.img ? item.img : this.settings.tree_icon_folder) : this.settings.tree_icon_folderopen;
            
            item.expand = !expand;
        }
    },
    onClick :function (e) {
        e = e || window.event;
        var target = e.target || e.srcElement;
        
        var _this = this._this;
        var treemenu = target.treemenu || target.parentNode.treemenu || target.parentNode.parentNode.treemenu;
        
        if(treemenu && target.nodeType == 1 && target.type == 'checkbox') {
            var recursion = false;
            if( _this.settings.recursion) {
                recursion = true;
            }
            _this.settings.recursion = true;
            _this.renderChild(treemenu, target.checked);
            _this.settings.recursion = recursion;
            return;
        }
        
        if( treemenu && treemenu.aElem == target) {
            _this.selectItem ? _this.selectItem.aElem.className = '' : null;
            _this.selectItem = treemenu;
            target.className = 'selected';
            target.blur();
            if( treemenu.click) {
                return treemenu.click(treemenu);
            }
           //window.parent..tlocation.href = './shenbao_base.jsp';
            //window.open('./shenbao_base.jsp', 'mainFrame');
            var iframe = window.parent.document.getElementById("rightFrame");
            
            iframe.src=treemenu.href;
           
            return false;
        }
        
        if( target.nodeType == 1 && target.type == 'radio') return;
        
        if( treemenu) {
            _this.renderChild(treemenu);
        }
    },
    expandAll : function (expand) {
        
        expand = expand === false;
        
        var recursion = false;
        if( this.settings.recursion) {
            recursion = true;
        }
        
        this.settings.recursion = true;
        
        for( var i=0; i<this.list.length; i++) {
            var item = this.list[i];
            item.expand = expand;
            if( item.parentId ==0) {
                this.renderChild(item);
            }
        }
        
        this.settings.recursion = recursion;
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
    remove : function (item, list){
        list = list || this.list;
        for( var i=0;i < list.length; i++)
        {
            if( list[i].id == item.id)
            {
                list[i].itemElem.parentNode.removeChild(list[i].itemElem);
                list.splice(i,1);
                if( item.parent ) {
                    for ( var j=0; j<item.parent.children.length; j++) {
                        if( item.parent.children[j].id == item.id) {
                            item.parent.children.splice(j,1);
                            break;
                        }
                    }
                    item.parent.expand = false;
                    this.renderChild(item.parent);
                }
                return list;
            }
        }
        return list;
    }
}