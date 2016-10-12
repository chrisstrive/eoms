//显示审批列表
function initDataReserve(pageindx){
  var tbody = "";
  var pageCount = "";
  // 获取每页显示记录数
  var pageSize = $("#items_per_page_reserve").val();
  var formData= {};
  formData.page=pageindx+1;
  formData.rows=pageSize;
  formData.id=$("#customerForm input[name=id]").val();
  $.ajax({
       type: "POST",//用POST方式传输
       dataType:"json",//数据格式:JSON
       url:cpath + "/reserve.htm?method=reserveList",//目标地址
       async:false,//作用是防止在ajax成功调用之前就调用$("#Pagination").pagination,这个时候数据个数还没有初始化
       data:formData,
       beforeSend:function(){
	    	// 表单校验	
	       	
       },//发送数据之前
       complete:function(){$("#divload").hide();$("#PaginationReserve").show();},//接收数据完毕
       success:function(json) {
                $("#dataTableReserve tr:gt(0)").remove();
                var pageData = json.rows;
                pageCount = json.total;
                $("#totalReserveRecord").html(pageCount);
                if(pageData==""){
                   $("#divload").hide();
                   return false;
                }
                $.each(pageData, function(i, data) {
                    var trs = "";
                    trs += "<tr>" + 
			                    "<td align='center'>" + 
			            		formatcpfl(data.cpfl) + 
			            		"</td>" +
			            		"<td align='center'>" + 
			            		formartNullFun(data.cpqc) + 
			            		"</td>" +
			            		"<td align='center'>" + 
			            		formatkyyje(data.zje, data.zjyje) + 
			            		"</td>" +
			            		"<td align='center'>" + 
			            		formartNullFun(data.yyje) + 
			            		"</td>" +
			            		"<td align='center'>" + 
			            		formartNullFun(data.yygmsj) + 
			            		"</td>" +
			            		"<td align='center'>" + 
			            		formartNullFun(data.cjsj) + 
			            		"</td>" +
                    		"</tr>";
                 tbody+=trs; 
                });

                  $("#dataTableReserve").append(tbody);
                 //行交替颜色
                  $("#dataTableReserve tr:gt(0):odd").attr("class", "");
                  $("#dataTableReserve tr:gt(0):even").attr("class", "");
                }//end of success
        });
		$("#PaginationReserve").pagination(pageCount, {
		       callback: pageselectCallbackReserve,
		       prev_text: '<<上一页',
		       next_text: '下一页 >>',
		       items_per_page:pageSize,
		       num_display_entries:6,
		       current_page:pageindx,
		       num_edge_entries:2
		});
}
function pageselectCallbackReserve(page_id,jq) {
	initDataReserve(page_id);
}