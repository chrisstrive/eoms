function selectProductData(id, cpmc, cplx){
	var url = cpath + '/product.htm?method=productSelect';
	var childRst = window.showModalDialog(url, window, 'dialogWidth:1100px;dialogHeight:auto;status:no;help:no;resizable:yes;');
	if(childRst && childRst != null){
		var childRstArray = childRst.split(':');
		$('#' + id).val(childRstArray[0]);
		$('#' + cpmc).val(childRstArray[1]);
		$('#' + cplx).val(childRstArray[2]);
	}
}