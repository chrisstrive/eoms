(function($){	
	$.pay={
			alert:function(m,opt){	
				var def ={title:"系统消息",t:"",close:function(){}};
				var o  =$.extend(def, opt);
				$.messager.alert(o.title,m,o.t,function(){o.close();});
			},
			confirm:function(m,opt){
				var def ={title:"确认消息",confirm:function(){},cancel:function(){}};
				var o  =$.extend(def, opt);
				$.messager.confirm(o.title, m, function(r){
					if (r){
						o.confirm();
					}else{
						o.cancel();
					}
				});
			},
			prompt:function(m,opt){
				var def ={title:"确认消息",prompt:function(r){}};
				var o  =$.extend(def, opt);
				$.messager.prompt(o.title, m, function(r){
					if (r){
						o.prompt(r);
					}
				});
			},
			show:function(opt){
				var def ={title:"提示消息",m:'该起床了',timeout:5000,t:'show'};
				var o  =$.extend(def,opt);
				$.messager.show({
					title:o.title,
					msg:o.m,
					timeout:o.timeout,
					showType:o.t
				});
			},
			loading:function(m){
				var loadWin = $.messager.progress({
					title:'请等待',
					msg:'',
					text:m
				});
			},
			closeLoading:function(){
				$.messager.progress('close');
			},
			dialog:function(objId,opt){
				var def ={title:"新窗口",btnOk:'确认',btnCancel:'取消',confirm:function(){},cancel:function(){}};
				var o  =$.extend(def, opt);
				var obj=$("#"+objId);
				$(obj).show();
				$(obj).dialog({
					title:o.title,
					modal:true,
					buttons:[{
						text:o.btnOk,
						handler:function(){
							o.confirm();
						}
					},{
						text:o.btnCancel,
						handler:function(){
							o.cancel();
							$(obj).dialog('close');
						}
					}]
				});
			},
			window:function(m,opt){
				var def ={title:"新窗口",width:600,height:300,iframe:false,success:function(){},modal:false,closable:true};
				var o  =$.extend(def, opt);
				var did=(new Date()).getTime();
				
				if(!o.iframe) { 
					$div = $("<div id='dialog_"+did+"' title='"+o.title+"' class='easyui-window' style='padding-left:10px;'>"+m+"</div>").appendTo($('body'));
					$('#dialog_'+did).window({
						title: o.title,
						width: o.width,
						modal: o.modal,
						closable:o.closable,
						shadow: false,
						closed: false,
						height: o.height,
						draggable:false,
						minimizable:false,
						maximizable:false,
						collapsible:false,
						resizable:false
					});
					o.success();
	            }else{
				    $("<div id='dialog_"+did+"' title='"+o.title+"' class='easyui-window' style='overflow:hidden;'><iframe name='dialog_ifm_"+did+"' id='dialog_ifm_"+did+"' allowtransparency='false'  frameBorder='0' src='javascript:void(0)' width='100%' height='99%' scrolling='auto' style='overflow-x:hidden;'></iframe></div>").appendTo($('body'));	   
				    $('#dialog_'+did).window({
				    	title: o.title,
						width: o.width,
						modal: o.modal,
						closable:o.closable,
						shadow: false,
						closed: false,
						height: o.height,
						minimizable:false,
						maximizable:false,
						collapsible:false,
						resizable:false
					});
				   	$('#dialog_ifm_'+did)[0].contentWindow.window.location.href = m;	
				    o.success();
				}
				return $('#dialog_'+did);
			
			}
		
			
	};
	
	
})(jQuery);