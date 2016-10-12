//显示审批列表
function initDataTransaction(pageindx){
  var tbody = "";
  var pageCount = "";
  // 获取每页显示记录数
  var pageSize = $("#items_per_page_transaction").val();
  var formData= {};
  formData.page=pageindx+1;
  formData.rows=pageSize;
  formData.khid=$("#customerForm input[name=id]").val();
  $.ajax({
       type: "POST",//用POST方式传输
       dataType:"json",//数据格式:JSON
       url:cpath + "/transaction.htm?method=queryTransactionForPage",//目标地址
       async:false,//作用是防止在ajax成功调用之前就调用$("#PaginationTransaction").Pagination,这个时候数据个数还没有初始化
       data:formData,
       beforeSend:function(){
	    	// 表单校验	
	       	
       },//发送数据之前
       complete:function(){$("#divload").hide();$("#PaginationTransaction").show();},//接收数据完毕
       success:function(json) {
                $("#dataTableTransaction tr:gt(0)").remove();
                var pageData = json.pageData;
                pageCount = json.pageCount;
                $("#totalTransactionRecord").html(pageCount);
                if(pageData==""){
                   $("#divload").hide();
                   return false;
                }
                $.each(pageData, function(i, data) {
                    var trs = "";
                    trs += "<tr>" + 
                    		"<td align='center'>" + 
                    		formartNullFun(data.id) + 
                    		"</td>" +
                    		"<td align='center'>" + 
                    		formartNullFun(data.jybh) + 
                    		"</td>" +
                    		"<td align='center'>" + 
                    		formartNullFun(data.cpqc) +
                    		"</td>" +
                    		"<td align='center'>" + 
                    		formartNullFun(data.khmc) + 
                    		"</td>" +
                    		"<td align='center'>" + 
                    		formartNullFun(data.qyrq) + 
                    		"</td>" +
                    		"<td align='center'>" + 
                    		formartNullFun(data.dkrq) + 
                    		"</td>" +
                    		"<td align='center'>" + 
                    		(data.jyzt == null ? "" : formatjyzt(data.jyzt))+
                    		"</td>" +
                    		"<td align='center'>" +
                    		"<a href=\"javascript:deleteTransaction('" + data.id + "')\">删除</a>&nbsp;" + 
                    		"</td>" +
                    		"</tr>";
                 tbody+=trs; 
                });

                  $("#dataTableTransaction").append(tbody);
                 //行交替颜色
                  $("#dataTableTransaction tr:gt(0):odd").attr("class", "");
                  $("#dataTableTransaction tr:gt(0):even").attr("class", "");
                }//end of success
        });
		$("#PaginationTransaction").pagination(pageCount, {
		       callback: pageselectCallbackTransaction,
		       prev_text: '<<上一页',
		       next_text: '下一页 >>',
		       items_per_page:pageSize,
		       num_display_entries:6,
		       current_page:pageindx,
		       num_edge_entries:2
		});
}
function pageselectCallbackTransaction(page_id,jq) {
	initDataTransaction(page_id);
}
function deleteTransaction(id){
	$.ajax({  
        type : 'post',  
        url : cpath + '/transaction.htm?method=deleteTransaction',  
        dataType : 'json',  
        data : "id=" + id,
        beforeSend:function(){
        	// 隐藏错误提示DIV
        	//$("#showMsgDiv").hide();
        	// 锁屏
        	//lockScreen();
        	if(confirm("是否删除该交易?")){
        		return true;
        	}else {
        		// 解锁
            	//unLockScreen();
        		return false;
        	}
        },//发送数据之前
        complete:function(){
        	// 解锁
        	//unLockScreen();
        },//接收数据完毕
        success : function (xmlq) {  
        	unLockScreen();
        	var returnCode = xmlq.returnCode;
        	var description = xmlq.description;
        	if(returnCode == "0000"){
        		alert("删除交易成功!");
        		// 解锁
            	//unLockScreen();
        		initDataTransaction(0);
        	}else{
        		alert(description);
        	}
        },  
        error : function (xmlq, errq) {  
            alert("系统错误");  
        }  
    })
}