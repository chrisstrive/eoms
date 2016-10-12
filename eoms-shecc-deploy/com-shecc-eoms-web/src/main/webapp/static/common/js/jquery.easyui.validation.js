function myformatter(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	var d = date.getDate();
	return y + (m < 10 ? ('0' + m) : m) + (d < 10 ? ('0' + d) : d);
}

$.extend($.fn.validatebox.defaults.rules, {
	repeat : {
		validator : function(value){
			return value == $("#passwd").val();
		},
		message : 'The repeat password must be the same as password'
	},
	mobile :{
		validator : function(value){
			return /^[0-9]{0,3}(13[0-9]|145|147|15[0-9]|18[0-9])[0-9]{8}$/i.test(value);
		},
		message : 'The field must be a valid cellphone number'
	},
	phone :{
		validator : function(value){
			return /^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)?(\\d{7,8})(-(\\d{3,}))?$/i.test(value);
		},
		message : 'The field must be a valid phone number'
	},
	code :{
		validator : function(value){
			return /^[A-Za-z0-9_]+$/i.test(value);
		},
		message : 'The field must be a valid code or something like that'
	},
	enname :{
		validator : function(value){
			return /^[A-Za-z0-9.·•]+$/i.test(value);
		},
		message : 'The field must be a valid English name'
	},
	checkMawb : {
		validator : function(value) {
			var flag = true;
			$.ajax({
				type : 'POST',
				url : cpath + "/mawb/checkMawb.jspx",
				data : "mawb=" + value + "&mid=" + $('#mid').val(),
				dataType : "json",
				async : false,
				success : function(data, textStatus, jqXHR) {
					flag = data.status;
				},
				error : function(data, textStatus, jqXHR) {
					flag = true;
				}
			});
			return flag;
		},
		message : 'The mawbno is already exist'
	},
	checkHawbno : {
		validator : function(value) {
			var flag = true;
			$.ajax({
				type : 'POST',
				url : cpath + "/hawb/checkHawbno.jspx",
				data : "hawbno=" + value + "&hid=" + $("#hid").val(),
				dataType : "json",
				async : false,
				success : function(data, textStatus, jqXHR) {
					flag = data.status;
				},
				error : function(data, textStatus, jqXHR) {
					flag = true;
				}
			});
			return flag;
		},
		message : 'The hawbno is already exist'
	},
	checkRefno : {
		validator : function(value) {
			var flag = true;
			$.ajax({
				type : 'POST',
				url : cpath + "/hawb/checkRefno.jspx",
				data : "refno=" + value + "&hid=" + $("#hid").val(),
				dataType : "json",
				async : false,
				success : function(data, textStatus, jqXHR) {
					flag = data.status;
				},
				error : function(data, textStatus, jqXHR) {
					flag = true;
				}
			});
			return flag;
		},
		message : 'The refno is already exist'
	},
	checkPartnerCode : {
		validator : function(value) {
			var flag = true;
			$.ajax({
				type : 'POST',
				url : cpath + "/partner/checkPartnerCode.jspx",
				data : "parCode=" + value + "&pid=" + $('#pid').val(),
				dataType : "json",
				async : false,
				success : function(data, textStatus, jqXHR) {
					flag = data.status;
				},
				error : function(data, textStatus, jqXHR) {
					flag = true;
				}
			});
			return flag;
		},
		message : 'The partner code is already exist'
	},
	checkCustomerCode : {
		validator : function(value) {
			var cust_id = $('#cust_id_').val();
			if(cust_id.length>0){
				return true;
			}
			var flag = true;
			$.ajax({
				type : 'POST',
				url : cpath + "/customer/checkCustomerCode.jspx",
				data : "ccode=" + value,
				dataType : "json",
				async : false,
				success : function(data, textStatus, jqXHR) {
					flag = data.status;
				},
				error : function(data, textStatus, jqXHR) {
					flag = true;
				}
			});
			return flag;
		},
		message : 'The customer code is already exist'
	},
});