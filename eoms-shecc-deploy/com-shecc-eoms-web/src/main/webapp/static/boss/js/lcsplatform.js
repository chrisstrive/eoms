//客户数据加载
function lcscustomer(){
	var tbody = "";	
	var queryparam=$("#customerForm").serialize();
	
	$.ajax({
	       type: "POST",//用POST方式传输
	       dataType:"json",//数据格式:JSON
	       url:cxt+'/taskdefault.htm?method=lcsCustomer',//目标地址
	       async:false,//作用是防止在ajax成功调用之前就调用$("#Pagination").pagination,这个时候数据个数还没有初始化	   
	       data:queryparam,
	       beforeSend:function(){
		    	// 表单校验	
		       	return true;
	       },//发送数据之前
	       complete:function(){},//接收数据完毕
	       success:function(json) {
	                $("#tlcscustomer tr:gt(0)").remove();
	                var pageData = json.pageData;
	                pageCount = json.pageCount;	                
	                if(pageData==""){
	                  // $("#divload").hide();
	                  // dis();
	                   return false;
	                }
	                $.each(pageData, function(i, data) {
	                    var trs = "";
	                    trs += "<tr>" + 			                    
	                    		"<td  align='left' title='"+(data.khlx == null ? "" : data.khlx)+"'>" + 
	                    		(data.khlx == null ? "" : data.khlx) + 
	                    		"</td>" +
	                    		"<td  align='left' title='"+(data.gmcp == null ? "" : data.gmcp)+"'>" + 
	                    		(data.gmcp == null ? "" : data.gmcp) +
	                    		
	                    		"</td>" +
	                    		"<td  align='left' title='"+(data.lxdh == null ? "" : data.lxdh)+"'>" + 
	                    		(data.lxdh == null ? "" : data.lxdh) + 
	                    		"</td>" +
	                    		"<td  align='left' title='"+(data.xm == null ? "" : data.xm)+"'><a href=\"javascript:customerDetail('"+data.k+"','"+data.id+"')\">" + 
	                    		(data.xm == null ? "" : data.xm) +
	                    		
	                    		"</a></td>" +
	                    		"<td  align='left' title='"+(data.zjlx == null ? "" : data.zjlx)+"'>" + 
	                    		(data.zjlx == null ? "" : data.zjlx) +
	                    		"</td>" +
	                    		"<td  id='zjhm' align='left'  title='"+(data.zjhm == null ? "" : data.zjhm)+"' ><p data-ellipsis='true' data-ellipsis-max-line='1' >" + 
	                    		 (data.zjhm == null ? "" : data.zjhm) +
	                    		
	                    		"</p></td>" +
	                    		"<td  align='left' title='"+(data.khzt == null ? "" : data.khzt)+"' >" + 
	                    		(data.khzt == null ? "" : data.khzt) +
	                    		 
	                    		"</td>" +	                    		
	                    		"</tr>";
	                 tbody+=trs; 
	                });

	                  $("#tlcscustomer").append(tbody);
	                 //行交替颜色
	                  $("#tlcscustomer tr:gt(0):odd").attr("class", "");
	                  $("#tlcscustomer tr:gt(0):even").attr("class", "");
	                }//end of success
	        });
}

//产品数据加载
function lcsproduct(){
	var tbody = "";
	var queryparam=$("#productForm").serialize();
	$.ajax({
	       type: "POST",//用POST方式传输
	       dataType:"json",//数据格式:JSON
	       url:cxt+'/taskdefault.htm?method=lcsProduct',//目标地址
	       async:false,//作用是防止在ajax成功调用之前就调用$("#Pagination").pagination,这个时候数据个数还没有初始化	  
	       data:queryparam,
	       beforeSend:function(){
		    	// 表单校验	
		       	return true;
	       },//发送数据之前
	       complete:function(){},//接收数据完毕
	       success:function(json) {
	                $("#tlcproduct tr:gt(0)").remove();
	                var pageData = json.pageData;
	                pageCount = json.pageCount;	                
	                if(pageData==""){
	                  // $("#divload").hide();
	                  // dis();
	                   return false;
	                }
	                $.each(pageData, function(i, data) {
	                    var trs = "";
	                    trs += "<tr>" + 			                    
	                    		"<td align='left'  title='"+(data.cpfl == null ? "" : data.cpfl)+"' >" + 
	                    		(data.cpfl == null ? "" : data.cpfl) + 
	                    		"</td>" +
	                    		"<td align='left'  title='"+(data.cpjc == null ? "" : data.cpjc)+"' ><a href=\"javascript:query(\'"+data.id+"\')\">" + 
	                    		(data.cpjc == null ? "" : data.cpjc) +
	                    		
	                    		"</a></td>" +
	                    		"<td align='left'  title='"+(data.tjrq == null ? "" : data.tjrq)+"' >" + 
	                    		(data.tjrq == null ? "" : data.tjrq) +
	                    		
	                    		
	                    		"</td>" +
	                    		"<td align='left'  title='"+(data.cpqxy == null ? "" : data.cpqxy)+"' >" + 
	                    		(data.cpqxy == null ? "" : data.cpqxy) +
	                    		
	                    		"</td>" +
	                    		"<td align='left'  title='"+(data.yqsyl == null ? "" : data.yqsyl)+"' >" + 
	                    		(data.yqsyl == null ? "" : data.yqsyl) +
	                    		"</td>" +
	                    		"<td align='left'  title='"+(data.bckyyje == null ? "" : data.bckyyje)+"' >" + 
	                    		(data.bckyyje == null ? "" : data.bckyyje) +
	                    		
	                    		"</td>" +
	                    		"<td align='left'  title='"+(data.zt == null ? "" : data.zt)+"' >" + 
	                    		(data.zt == null ? "" : data.zt) +
	                    		 
	                    		"</td>" +	                    		
	                    		"</tr>";
	                 tbody+=trs; 
	                });

	                  $("#tlcproduct").append(tbody);
	                 //行交替颜色
	                  $("#tlcproduct tr:gt(0):odd").attr("class", "");
	                  $("#tlcproduct tr:gt(0):even").attr("class", "");
	                }//end of success
	        });
}

//销售统计
function lcstongji(){
	var tbody = "";
$.ajax({
       type: "POST",//用POST方式传输
       dataType:"json",//数据格式:JSON
       url:cxt+'/taskdefault.htm?method=lcsTongji',//目标地址
       async:false,//作用是防止在ajax成功调用之前就调用$("#Pagination").pagination,这个时候数据个数还没有初始化	      
       beforeSend:function(){
	    	// 表单校验	
	       	return true;
       },//发送数据之前
       complete:function(){},//接收数据完毕
       success:function(json) {
                $("#tlctongji tr:gt(0)").remove();
                var pageData = json.pageData;
                pageCount = json.pageCount;	                
                if(pageData==""){
                  // $("#divload").hide();
                  // dis();
                   return false;
                }
                $.each(pageData, function(i, data) {
                    var trs = "";
                    trs += "<tr>" + 			                    
                    		"<td align='left'>" + 
                    		(data.curje == null ? "" : data.curje) + 
                    		"</td>" +
                    		"<td align='left'>" + 
                    		(data.completeje == null ? "" : data.completeje) +
                    		
                    		"</td>" +
                    		"<td align='left'>" + 
                    		(data.uncompleteje == null ? "" : data.uncompleteje) +
                    		
                    		
                    		"</td>" +
                    		"<td align='left'>" + 
                    		(data.customercount == null ? "" : data.customercount) +
                    		
                    		"</td>" +
                    		"<td align='left'>" + 
                    		(data.jyej == null ? "" : data.jyej) +
                    		"</td>" +
                    		"<td align='left'>" + 
                    		(data.iscomplete == null ? "" : data.iscomplete) +
                    		
                    		"</td>" +                    		                    		
                    		"</tr>";
                 tbody+=trs; 
                });

                  $("#tlctongji").append(tbody);
                 //行交替颜色
                  $("#tlctongji tr:gt(0):odd").attr("class", "");
                  $("#tlctongji tr:gt(0):even").attr("class", "");
                }//end of success
        });
}

//我的待办
function lcsdaiban(){
	var tbody = "";
	$.ajax({
	       type: "POST",//用POST方式传输
	       dataType:"json",//数据格式:JSON
	       url:cxt+'/taskdefault.htm?method=lcsdaiban',//目标地址
	       async:false,//作用是防止在ajax成功调用之前就调用$("#Pagination").pagination,这个时候数据个数还没有初始化	      
	       beforeSend:function(){
		    	// 表单校验	
		       	return true;
	       },//发送数据之前
	       complete:function(){},//接收数据完毕
	       success:function(json) {
	                $("#lcsdaiban").html("");
	                var pageData = json.pageData;
	                pageCount = json.pageCount;	                
	                if(pageData==""){
	                  // $("#divload").hide();
	                  // dis();
	                   return false;
	                }
	                $.each(pageData, function(i, data) {
	                    var trs = "";
	                    trs += "<a href='#' onclick='showDaiBanInfo("+data.id+","+data.dblx+",\"待办处理\",\""+cxt+"/taskdefault.htm?method=customerApproveApply&id=" + data.id+"&sysid="+data.sysid+"\")'><li><label>【"+(data.type == null ? "" : data.type)+"】</label><label>"+
	                    (data.content == null ? "" : data.content)+"</label> <label>"+(data.riqi == null ? "" : data.riqi)+"</label></li></a>";
		                   
	                 tbody+=trs; 
	                });

	                  $("#lcsdaiban").append(tbody);
	                 //行交替颜色
	                 // $("#tlctongji tr:gt(0):odd").attr("class", "");
	                 // $("#tlctongji tr:gt(0):even").attr("class", "");
	                }//end of success
	        });
}

//新闻公告
function lcsnews(){
	var tbody = "";

	$.ajax({
	       type: "POST",//用POST方式传输
	       dataType:"json",//数据格式:JSON
	       url:cxt+'/taskdefault.htm?method=lcsnew',//目标地址
	       async:false,//作用是防止在ajax成功调用之前就调用$("#Pagination").pagination,这个时候数据个数还没有初始化	      
	       beforeSend:function(){
		    	// 表单校验	
		       	return true;
	       },//发送数据之前
	       complete:function(){},//接收数据完毕
	       success:function(json) {
	                $("#lcsnew").html("");
	                var pageData = json.pageData;
	                pageCount = json.pageCount;	                
	                if(pageData==""){
	                  // $("#divload").hide();
	                  // dis();
	                   return false;
	                }
	                $.each(pageData, function(i, data) {
	                    var trs = "";

	                    trs += "<li><label><a href=\"javascript:void(0)\" onclick=\"opendiv('"+data.id+"')\" > "+
	                    (data.content == null ? "" : data.content)+"&nbsp"+(data.riqi == null ? "" : data.riqi)+"</a></label></li>";

		                   
	                 tbody+=trs; 
	                });
	                  $("#lcsnew").append(tbody);
	                 //行交替颜色
	                 // $("#tlctongji tr:gt(0):odd").attr("class", "");
	                 // $("#tlctongji tr:gt(0):even").attr("class", "");
	                }//end of success
	        });
}

/*
 * 知识
 */
function lcsknowledge(){
	var tbody = "";
	$.ajax({
	       type: "POST",//用POST方式传输
	       dataType:"json",//数据格式:JSON
	       url:cxt+'/taskdefault.htm?method=lcsknowledge',//目标地址
	       async:false,//作用是防止在ajax成功调用之前就调用$("#Pagination").pagination,这个时候数据个数还没有初始化	      
	       beforeSend:function(){
		    	// 表单校验	
		       	return true;
	       },//发送数据之前
	       complete:function(){},//接收数据完毕
	       success:function(json) {
	                $("#lcsknowledge").html("");
	                var pageData = json.pageData;
	                pageCount = json.pageCount;	                
	                if(pageData==""){
	                  // $("#divload").hide();
	                  // dis();
	                   return false;
	                }
	                $.each(pageData, function(i, data) {
	                    var trs = "";

	                    trs += "<li><label><a href=\"javascript:void(0)\" onclick=\"downloadFile('"+data.id+"')\" >【"+(data.type == null ? "" : data.type)+"】"+
	                    (data.content == null ? "" : data.content)+"&nbsp"+(data.riqi == null ? "" : data.riqi)+"</a></label></li>";

		                   
	                 tbody+=trs; 
	                });

	                  $("#lcsknowledge").append(tbody);
	                 //行交替颜色
	                 // $("#tlctongji tr:gt(0):odd").attr("class", "");
	                 // $("#tlctongji tr:gt(0):even").attr("class", "");
	                }//end of success
	        });

}



function showDaiBanInfo(id,dblx,titleName,url){	
	if(dblx && dblx == '2'){  //日历
	  // window.parent.window.addTab(titleName, url, '', true);
		 window.parent.clkMenu(url);

	   return;
	}
	$.ajax({
	       type: "POST",//用POST方式传输
	       dataType:"json",//数据格式:JSON
	       url:cxt+'/taskdefault.htm?method=checkApprove',//目标地址
	       data:{'id':id},
	       async:false,//作用是防止在ajax成功调用之前就调用$("#Pagination").pagination,这个时候数据个数还没有初始化	      
	       success:function(json) {
	               if(json.returnCode){
	            	   if(json.returnCode == "0000"){
	            		 //  window.parent.window.addTab(titleName, url, '', true);
	            		   window.parent.clkMenu(url);
	            	   }else{
	            		   alert("审核已经结束");
	            	   }
	               }
	             }   
	        });
}


function showUserInfo(titleName,url){	
	
	   //window.parent.window.addTab(titleName, url, '', true);
	   window.parent.clkMenu(url);
	   return;
}


/*
 * 下载文件
 */
function downloadFile(id){
	var url = cxt+"/databasemanagement.htm?method=downloadFiles&id=" + id;
	location.href = url;
}
/*
 * 
 */
function opendiv(vid){
	var url =  cxt+'/noticdefault.htm?method=viewNoticDetail&id='+vid;
	var childRst = window.showModalDialog(url, '查看公告', 'dialogWidth:800px;dialogHeight:auto;status:no;help:no;resizable:yes;');
	
}

function customerDetail(t,tId){
	if(t=='1'){
		//location.href = ;
		showUserInfo('',cxt+"/customer.htm?method=customerIndividualDetail&id="+tId);
	} else if(t=='2'){
		
		showUserInfo('',cxt+"/customer.htm?method=customerCompanyDetail&id="+tId);
    }
}

function query(id){
	
	showUserInfo('',cxt + "/product.htm?method=productQuery&id=" + id);
	
}

