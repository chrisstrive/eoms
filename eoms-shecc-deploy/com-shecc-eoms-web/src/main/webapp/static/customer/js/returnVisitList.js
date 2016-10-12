//显示审批列表
function initDataReturnVisit(pageindx){
  var tbody = "";
  var pageCount = "";
  // 获取每页显示记录数
  var pageSize = $("#items_per_page_return_visit_record").val();
  var formData= {};
  formData.page=pageindx+1;
  formData.rows=pageSize;
  formData.id=$("#customerForm input[name=id]").val();
  $.ajax({
       type: "POST",//用POST方式传输
       dataType:"json",//数据格式:JSON
       url:cpath + "/visitRecord.htm?method=returnVisitList",//目标地址
       async:false,//作用是防止在ajax成功调用之前就调用$("#PaginationReturnVisitRecord").Pagination,这个时候数据个数还没有初始化
       data:form,
       beforeSend:function(){
	    	// 表单校验	
	       	
       },//发送数据之前
       complete:function(){$("#divload").hide();$("#PaginationReturnVisitRecord").show();},//接收数据完毕
       success:function(json) {
                $("#dataTableReturnVisitRecord tr:gt(0)").remove();
                var pageData = json.rows;
                pageCount = json.total;
                $("#totalReturnVisitRecord").html(pageCount);
                if(pageData==""){
                   $("#divload").hide();
                   return false;
                }
                $.each(pageData, function(i, data) {
                    var trs = "";
                    trs += "<tr>" + 
	                    "<td align='center'><input type='checkbox' name='id' value='" + 
	            		formartNullFun(data.id) + "'/>"+
	            		"</td>" +
	            		"<td align='center'>" + 
	            		formartNullFun(data.kh_xm) + 
	            		"</td>" +
	            		"<td align='center'>" + 
	            		formartNullFun(data.lcs_xm) + 
	            		"</td>" +
	            		"<td align='center'>" + 
	            		formartNullFun(data.bfzt) + 
	            		"</td>" +
	            		"<td align='center'>" + 
	            		formartNullFun(data.bfsj) + 
	            		"</td>" +
	            		"<td align='center'>" +
	            		"<a href=\"javascript:editIndividual('" + data.id + "')\">编辑</a>&nbsp;" +
	            		"<a href=\"javascript:deleteCustomer('" + data.id + "')\">删除</a>&nbsp;" + 
	            		"<a href=\"javascript:detailIndividual('" + data.id + "')\">详细信息</a>&nbsp;" + 
	            		"</td>" +
	            		"</tr>";
                    tbody+=trs; 
                });

                  $("#dataTableReturnVisitRecord").append(tbody);
                 //行交替颜色
                  $("#dataTableReturnVisitRecord tr:gt(0):odd").attr("class", "");
                  $("#dataTableReturnVisitRecord tr:gt(0):even").attr("class", "");
                }//end of success
        });
		$("#PaginationReturnVisitRecord").Pagination(pageCount, {
		       callback: pageselectCallbackReturnVisit,
		       prev_text: '<<上一页',
		       next_text: '下一页 >>',
		       items_per_page:pageSize,
		       num_display_entries:6,
		       current_page:pageindx,
		       num_edge_entries:2
		});
}
function pageselectCallbackReturnVisit(page_id,jq) {
	initDataReturnVisit(page_id);
}