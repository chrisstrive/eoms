//显示审批列表
function initDataVisit(pageindx){
  var tbody = "";
  var pageCount = "";
  // 获取每页显示记录数
  var pageSize = $("#items_per_page_visit_record").val();
  var formData= {};
  formData.page=pageindx+1;
  formData.rows=pageSize;
  formData.id=$("#customerForm input[name=id]").val();
  $.ajax({
       type: "POST",//用POST方式传输
       dataType:"json",//数据格式:JSON
       url:cpath + "/visitRecord.htm?method=visitList",//目标地址
       async:false,//作用是防止在ajax成功调用之前就调用$("#PaginationVisitRecord").Pagination,这个时候数据个数还没有初始化
       data:formData,
       beforeSend:function(){
	    	// 表单校验	
	       	
       },//发送数据之前
       complete:function(){$("#divload").hide();$("#PaginationVisitRecord").show();},//接收数据完毕
       success:function(json) {
                $("#dataTableVisitRecord tr:gt(0)").remove();
                var pageData = json.rows;
                pageCount = json.total;
                $("#totalVisitRecord").html(pageCount);
                if(pageData==""){
                   $("#divload").hide();
                   return false;
                }
                $.each(pageData, function(i, data) {
                    var trs = "";
                    trs += "<tr>" + 
		                    "<td align='center'>" + 
		            		formartNullFun(data.bfsj) + 
		            		"</td>" +
		            		"<td align='center'>" + 
		            		formatzjjz(data.bfzt) + 
		            		"</td>" +
		            		"<td align='center'>" + 
		            		formatbffs(data.bflx) + 
		            		"</td>" +
		            		"<td align='center'>" + 
                    		(formartNullFun(data.bfnr).length > 10 ? (formartNullFun(data.bfnr).substr(0,10) + '...') : formartNullFun(data.bfnr)) + 
                    		"</td>" +
                    		"<td align='center'>" + 
                    		(formartNullFun(data.bz).length > 10 ? (formartNullFun(data.bz).substr(0,10) + '...') : formartNullFun(data.bz)) + 
                    		"</td>" +
                    		"</tr>";
                 tbody+=trs; 
                });

                  $("#dataTableVisitRecord").append(tbody);
                 //行交替颜色
                  $("#dataTableVisitRecord tr:gt(0):odd").attr("class", "");
                  $("#dataTableVisitRecord tr:gt(0):even").attr("class", "");
                }//end of success
        });
		$("#PaginationVisitRecord").pagination(pageCount, {
		       callback: pageselectCallbackVisit,
		       prev_text: '<<上一页',
		       next_text: '下一页 >>',
		       items_per_page:pageSize,
		       num_display_entries:6,
		       current_page:pageindx,
		       num_edge_entries:2
		});
}
function pageselectCallbackVisit(page_id,jq) {
	initDataVisit(page_id);
}