var cpath = "";
var $parent = self.parent.$;
(function(){
	var pathname = window.location.pathname;
	cpath = pathname.substring(0, pathname.indexOf("/",2));
})();
$(document).ready(function(){
	if($("#selectall")){
		$("#selectall").click(function(){
			var selboxs = document.getElementsByName("selbox");
			for(var i=0;i<selboxs.length;i++){
				selboxs[i].checked = this.checked;
			}
		});
	}
});
function form2map(fname){
	var form = $('#'+fname);
	var fdata = {};
	$.each(form.serializeArray(),function(){
		if (fdata[this.name] !== undefined) {
            if (!fdata[this.name].push) {
            	fdata[this.name] = [fdata[this.name]];
            }
            fdata[this.name].push(this.value || '');
        } else {
        	fdata[this.name] = this.value || '';
        }
	});
	return fdata;
};
/**************************** 数据验证格式化---start ***************************/

/***
 * 格式化显示的数据
 * @returns
 */
function formartNullFun() {
	var value = arguments[0];
	if (typeof(value) == 'undefined') {
		return '';
	}
	if (value == null || value == '') {
		return '';
	}
	return value;
}

/***
 * 判断对象是否为空
 * 空 返回 true
 */ 
function isNull() {
	if (arguments.length == 0) {
		return true;
	}
	var value = arguments[0];
	if (typeof(value) == 'undefined' || value == '' || value == null || value.length == 0) {
		return true;
	}
}

/**
 * 将提交的表单数据转换成JSON字符串
 * @returns
 */ 
function jsonToStr() {
	var data = arguments[0];
	if (typeof(data) == 'string') {
		return data;
	}
	var jsonData = '';
	for (var i = 0; i < data.length; i ++) {
		var value = data[i].value;
		//必须先替换换行符
		value = value.replace(/\r/ig,",").replace(/\n/ig,","); //如果是多行文本框控件，则把换行替换成逗号
		//通过json 格式化，否则传入到后台异常
		value = $.toJSON(value); //对特殊字符进行处理
		jsonData += ('"' + data[i].name + '":' + value + '');
		jsonData += (i == (data.length - 1) ? '' : ',');
	}
	jsonData = '{' + jsonData + '}';
	return jsonData;
}

/**************************** 数据验证格式化---end ***************************/
/************************************************************************/

/************************************************************************/
/**************************** easyui方法---start ***************************/

/***
 * 弹 窗
 */
function easyui_window(divid, title, href, width, height) {
	if ($("#" + id) != null) {
		$("#" + id).css('display', 'block');
	}
	var strIndex = href.lastIndexOf('/') + 1;
	var endIndex = href.lastIndexOf('.');
	iframeId = href.substring(strIndex, endIndex);
	$('#'+divid).window( {
		title : title,
		width : width,
		height : height,
		content: '<iframe scrolling="yes" frameborder="0"  src="' + href + '" name="' + iframeId + '" style="width:100%;height:100%;"></iframe>',
		modal : true,
		shadow : false,		
		top : ($(window).height()) * 0.1,
		left : ($(window).width()) * 0.03,
		closed : false,
		closable : true,
		collapsible : false,
		minimizable : false,
		maximizable : false
	});
}

/***
 * 添加一个选项卡parameter（title: 选项卡标题, href： 选项卡地址） 
 */
function addTab(divid, title, href, width, height) {
	var tt = $('#'+ divid);
	var initalPath = cpath + href;
	var strIndex = href.lastIndexOf('/') + 1;
	var endIndex = href.lastIndexOf('.');
	iframeId = href.substring(strIndex, endIndex);
	var content = '<iframe scrolling="yes" frameborder="0"'+
	'src="' + initalPath + '" name="' + iframeId + '" style="width:100%;height:100%;"></iframe>';
	if (!tt.tabs('exists', title)) {
		tt.tabs('add',{
			title:title,
			width:width,
			height:height,
			content:content,
			border:false,
			closable:true
			/*tools:[{    // 可以加工具条
				id:'btnsave',
				text:'导出',
				disabled:false,
				iconCls:'icon-save',
				handler:callback
			}]*/
		});
	}else {
		tt.tabs('select',title);
		refreshTab({divId:tt,tabTitle:title,url:initalPath});
	}
}

/**
 * 如果当前选项卡的title已经存在、则刷新当前的选项卡
 */
function refreshTab(cfg) {
	var refresh_tab = cfg.tabTitle?cfg.divId.tabs('getTab',cfg.tabTitle) : cfg.divId.tabs('getSelected');  
	if(refresh_tab && refresh_tab.find('iframe').length > 0) {
		var _refresh_ifram = refresh_tab.find('iframe')[0];  
		var refresh_url = cfg.url ? cfg.url : _refresh_ifram.src;  
		//_refresh_ifram.src = refresh_url;  
		_refresh_ifram.contentWindow.location.href = refresh_url;
	}  
}

/***
 * 显示操作结果信息
 */
function showMsg(title, msg) {
	$.messager.show({
        title:title,
        msg:msg,
        timeout:3000,
        showType:'slide'
    });
}

/**
 * 打开添加dialog
 */
function add(title, href) {
	$('#add-dlg').dialog('open').dialog('setTitle',title);
	$('#add-fm').form('clear');
    url = cpath + href;
}
/***
 * 打开编辑dialog 
 */
function edit(title, href) {
    var row = $('#dg').datagrid('getSelected');
    if (row) {
    	$('#id').val(row.id);
        $('#edit-dlg').dialog('open').dialog('setTitle',title);
        $('#edit-fm').form('load',row);
        url = cpath + href;
    } else {
    	showMsg("温馨提示", "请选中一行进行操作！！！");
    }
}
/**
 * 添加 
 */
function saveObj() {
	$('#add-fm').form('submit', {
        onSubmit: function() {
        	var flag = $(this).form('validate');
        	if (!flag) return;
        	var strDatas = jsonToStr($('#add-fm').serializeArray());
        	$.ajax({
            	type: "POST",
            	url: url,
            	dataType: "json",
            	data: "_data_=" + strDatas,
            	success: function(data) {
    				if (!data.result) {
    					showMsg("警告", result.remark);
          			} else {
          				showMsg("提示", "添加成功！！！");
          				$('#add-dlg').dialog('close');        // close the dialog
                        $('#dg').datagrid('reload');
           			}
    			},
    			error: function(error) {
    				showMsg("错误", "操作失败:error message:" + error.remark);
    			}
            }); 
        }
	});
}
/**
 * 编辑
 */
function editObj() {
	$('#edit-fm').form('submit', {
        onSubmit: function() {
        	var flag = $(this).form('validate');
        	if (!flag) return;
        	var strDatas = jsonToStr($('#edit-fm').serializeArray());
        	$.ajax({
            	type: "POST",
            	url: url,
            	dataType: "json",
            	data: "_data_=" + strDatas,
            	success: function(data) {
    				if (!data.result) {
    					showMsg("警告", result.remark);
          			} else {
          				showMsg("提示", "修改成功！！！");
          				$('#edit-dlg').dialog('close');
                        $('#dg').datagrid('reload');
           			}
    			},
    			error: function(error) {
    				showMsg("错误", "操作失败:error message:" + error.remark);
    			}
            }); 
        }
	});
}
/**
 * 删除
 * @param href url
 */
function destroyObj(href) {
    var row = $('#dg').datagrid('getSelected');
    if (row) {
        $.messager.confirm('Confirm','确定要执行删除吗?',function(r) {
            if (r) {
            	var strDatas = '{\"baseId\":\"'+ row.id +'\"}';
                $.ajax({
                	type: "POST",
                	url: cpath + href,
                	dataType: "json",
                	data: "_data_=" + strDatas,
                	success: function(result) {
                		if (!result.result) {
                			showMsg("警告", result.remark);
                		} else {
                			showMsg("提示", "删除成功！！！");
                			$('#dg').datagrid('reload');
                		}
                	},
                	error: function(error) {
                		showMsg("错误", "操作失败:error message:" + error.remark);
                	}
                });
            }
        });
    } else {
    	showMsg("温馨提示","请选中一行进行操作！！！");
    }
}

/**************************** easyui方法---end ***************************/
/************************************************************************/

/**************************************************************************/
/******************************* 日期方法---start ****************************/

/***
 * 格式化显示JSON 日期显示 (easyui)
 * @param val date
 * @param row 行 
 * @returns {String}
 */ 
function formatterDate(val, row) {
	if (val == null || val == undefined || val == "") {
		return "";
	}
	var thedate = new Date(val);
	var y = thedate.getFullYear();
	var m = thedate.getMonth() + 1;
	var d = thedate.getDate();
	var h = thedate.getHours();
	var f = thedate.getMinutes();
	var s = thedate.getSeconds();
	return y + '-' + isGtTen(m) + '-' + isGtTen(d) + ' ' + isGtTen(h) + ':' + isGtTen(f) + ':' + isGtTen(s);
}

/***
 * 格式化显示JSON 日期显示 (easyui)
 * @param val date
 * @param row 行 
 * @returns {String}
 */ 
function formatterDateToDay(val, row) {
	if (val == null || val == undefined || val == "") {
		return "";
	}
	var thedate = new Date(val);
	var y = thedate.getFullYear();
	var m = thedate.getMonth() + 1;
	var d = thedate.getDate();
	var h = thedate.getHours();
	var f = thedate.getMinutes();
	var s = thedate.getSeconds();
	return y + '-' + isGtTen(m) + '-' + isGtTen(d);
}

function isGtTen(obj) {
	return obj < 10 ? ('0' + obj) : obj;
}

/******************************* 日期方法---end ****************************/
/**************************************************************************/


/***********************************************************************************/
/************************************cookie操作方法start*****************************/
function getCookiePath() {
	var href=document.location.href;
	return href.substring(href.indexOf(resourceCharts)+
			resourceCharts.length).replaceAll("/","").replaceAll("#","");
}

//设置cookie
function setCookie(cookieName,cvalue,expiredays,path) {
	var expireDate=new Date();
	var expireStr="";
	if(expiredays!=null) {
		expireDate.setTime(expireDate.getTime()+(expiredays*24*3600*1000));
		expireStr="; expires="+expireDate.toGMTString();
	}
	pathStr=(path==null)?"; path=/":"; path="+path;
	document.cookie=cookieName+'='+escape(cvalue)+expireStr+pathStr;
	
}

//取得cookie	
function getCookie(cookieName) {
	var index=-1;
 	if(document.cookie) 
 		index=document.cookie.indexOf(cookieName);
 	if(index==-1) {
 		return "";
 	} else {
 	     var iBegin = (document.cookie.indexOf("=", index) +1);
 	     if(iBegin==0)
 	    	 return "";
          var iEnd =document.cookie.indexOf(";", index);
          if (iEnd == -1)
          {
              iEnd = document.cookie.length;
          }
          return unescape(document.cookie.substring(iBegin,iEnd));
	}
} 

//为了删除指定名称的cookie，可以将其过期时间设定为一个过去的时间
function delCookie(name) {
   var date = new Date();
   date.setTime(date.getTime() - 10000);
   document.cookie = name + "=a; expires=" + date.toGMTString();
}

/**********************************cookie操作方法end*****************************/
/*****************************************************************************/

/*****************************************************************************/
/************************************String方法start*****************************/
/**
 * 字符串替换,过滤了一些特殊字符
 * @param s1	原始字符串
 * @param s2	需要替换的字符串
 * @returns		{String}
 */
String.prototype.replaceAll = function(s1, s2) {
	var r = new RegExp(s1.replace(/([\(\)\[\]\{\}\^\$\+\-\*\?\.\"\'\|\/\\])/g,
			"\\$1"), "ig");
	return this.replace(r, s2);
};

/**
 * 去掉字符串两端的空格
 * @returns
 */
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
};

/**
 * 去掉字符串左端的空格
 * @returns
 */
String.prototype.ltrim = function() {
	return this.replace(/(^\s*)/g, "");
};

/**
 * 去掉字符串右端的空格
 * @returns
 */
String.prototype.rtrim = function() {
	return this.replace(/(\s*$)/g, "");
};

/************************************String方法end******************************/
/*****************************************************************************/