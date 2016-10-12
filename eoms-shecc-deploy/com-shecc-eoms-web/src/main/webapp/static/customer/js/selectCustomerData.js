function selectCustomerData(id, khlx, xm, khbh, hybh){
	var url = cpath + '/customer.htm?method=customerSelect';
	var childRst = window.showModalDialog(url, window, 'dialogWidth:1100px;dialogHeight:auto;status:no;help:no;resizable:yes;');
	if(childRst && childRst != null){
		var childRstArray = childRst.split(':');
		$('#' + id).val(childRstArray[0]);
		$('#' + khlx).val(childRstArray[1]);
		$('#' + xm).val(childRstArray[2]);
		$('#' + khbh).val(childRstArray[3]);
		$('#' + hybh).val(childRstArray[4]);
	}
}