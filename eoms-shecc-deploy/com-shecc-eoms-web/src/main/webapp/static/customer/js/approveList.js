//显示审批列表
function initDataApprove(pageindx){
  var tbody = "";
  var pageCount = "";
  // 获取每页显示记录数
  var pageSize = $("#items_per_page_approve").val();
  var formData= {};
  formData.page=pageindx+1;
  formData.rows=pageSize;
  formData.id=$("#customerForm input[name=id]").val();
  $.ajax({
       type: "POST",//用POST方式传输
       dataType:"json",//数据格式:JSON
       url:cpath + "/approval.htm?method=approveList",//目标地址
       async:false,//作用是防止在ajax成功调用之前就调用$("#Pagination").pagination,这个时候数据个数还没有初始化
       data:formData,
       beforeSend:function(){
	    	// 表单校验	
	       	
       },//发送数据之前
       complete:function(){$("#divload").hide();$("#PaginationApprove").show();},//接收数据完毕
       success:function(json) {
                $("#dataTableApprove tr:gt(0)").remove();
                var pageData = json.rows;
                pageCount = json.total;
                $("#totalApproveRecord").html(pageCount);
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
                    		formatsplx(data.splx) + 
                    		"</td>" +
                    		"<td align='center'>" + 
                    		(formartNullFun(data.spyj).length > 10 ? (formartNullFun(data.spyj).substr(0,10) + '...') : formartNullFun(data.spyj)) +
                    		"</td>" +
                    		"<td align='center'>" + 
                    		formatspjg(data.spjg) + 
                    		"</td>" +
                    		"<td align='center'>" + 
                    		formartNullFun(data.spsj) + 
                    		"</td>" +
                    		"<td align='center'>" + 
                    		formartNullFun(data.spr_xm) + 
                    		"</td>" +
                    		"</tr>";
                 tbody+=trs; 
                });

                  $("#dataTableApprove").append(tbody);
                 //行交替颜色
                  $("#dataTableApprove tr:gt(0):odd").attr("class", "");
                  $("#dataTableApprove tr:gt(0):even").attr("class", "");
                }//end of success
        });
		$("#PaginationApprove").pagination(pageCount, {
		       callback: pageselectCallbackApprove,
		       prev_text: '<<上一页',
		       next_text: '下一页 >>',
		       items_per_page:pageSize,
		       num_display_entries:6,
		       current_page:pageindx,
		       num_edge_entries:2
		});
}

function pageselectCallbackApprove(page_id,jq) {
	initDataApprove(page_id);
}