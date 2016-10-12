function selectLcsData(lcsId, lcsXm){
	var url = cpath + '/employeedefault.htm?method=selectEmployeeDispth';
	var childRst = window.showModalDialog(url, window, 'dialogWidth:1100px;dialogHeight:auto;status:no;help:no;resizable:yes;');
	if(childRst && childRst != null){
		var childRstArray = childRst.split(':');
		$('#' + lcsId).val(childRstArray[0]);
		$('#' + lcsXm).val(childRstArray[1]);
	}
}