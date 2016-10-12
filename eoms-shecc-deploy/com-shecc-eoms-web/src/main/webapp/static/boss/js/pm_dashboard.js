

//产品数据加载
function loadNotic(){
	var messages = "";
	$.ajax({
	       type: "POST",//用POST方式传输
	       dataType:"json",//数据格式:JSON
	       url:cxt+'/noticdefault.htm?method=queryNoticsForDashBoard',//目标地址
	       async:false,//作用是防止在ajax成功调用之前就调用$("#Pagination").pagination,这个时候数据个数还没有初始化	      
	       success:function(json) {
	                var noticList = json.noticList;
	                $.each(noticList, function(i, data) {
	                   
	                    messages += "<div class=\"message\"><div class='title'><a href='#' onclick=\"showNotic("  + data.id + ")\" style=\"cursor:pointer\">" + data.noticTitle + "</a></div><div class='titledate'>" + data.publishTimeDateStr + "</div></div>";
	                });
	                  $("#listNotic").append(messages);
	                }//end of success
	        });
}

/**
 * 显示公告
 * @param id
 */
function showNotic(id){
	var url = cxt + "/noticdefault.htm?method=viewNoticDetail&id=" + id;
	window.showModalDialog(url, "查看公告", "dialogWidth:750px;dialogHeight:auto;status:no;help:no;resizable:yes;");
}