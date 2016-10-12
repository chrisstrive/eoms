function submitForm(){
	$("#myform").form("submit", {
		url: baseurl + "/save.jspx",
		onSubmit: function(){
		     return $(this).form('validate');
		},
		success: function(data, textStatus, jqXHR){
			if(data.status == true){
				$.messager.alert('Success','Save data success！','info',function(){
					$("#dlg").window("close");
					$('#dg').datagrid("reload");
				});
			}else{
				$.messager.alert("Warnning", data.message);
		    }
	     }
	});
}

function cancelForm(){
	$("#dlg").window("close");
}

function resetForm(){
	$("#myform").form('clear');
}