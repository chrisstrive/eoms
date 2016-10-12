/**
*	锁屏
*/
function lockScreen(){
	$("#popupDiv").show();  
}

/**
*	解锁
*/
function unLockScreen(){
	$("#popupDiv").hide();  
}

/**
*	显示验证信息
*/
function showValidateMsg(content){
	$("#showMsgDiv").show();
	$("#showMsg").html(content);
}

function validateEmpty(val){
	if(val==null || val=='' || val.length==0) {
		return false;
	} else {
		return true;
	}
}
function validateNumber(val){
	var isNotEmpty = validateEmpty(val);
	if(isNotEmpty) {
		var re = /^[0-9]\d*$/;
		 if(!re.test(val)) {
			 return false;
		 } else {
			 return true;
		 }
	} else {
		return true;
	}
}
function validateNumber2(val){
	var isNotEmpty = validateEmpty(val);
	if(isNotEmpty) {
		var re = /^\d+(\.\d+)?$/;
		 if(!re.test(val)) {
			 return false;
		 } else {
			 return true;
		 }
	} else {
		return true;
	}
}
function validateLength(val, length){
	var isNotEmpty = validateEmpty(val);
	if(isNotEmpty) {
		if(val.length < length){
			return false;
		}
	} else {
		return true;
	}
}
function validateEmail(val){
	var isNotEmpty = validateEmpty(val);
	if(isNotEmpty) {
		var re = /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/;
		 if(!re.test(val)) {
			 return false;
		 } else {
			 return true;
		 }
	} else {
		return true;
	}
}
function validatePhone(val){
	var isNotEmpty = validateEmpty(val);
	if(isNotEmpty) {
		var re = /^\d{2,4}-?\d{4,12}$/;
		if(!re.test(val)) {
			return false;
		} else {
			return true;
		}
	} else {
		return true;
	}
}
// 如果同时验证手机号或者座机号
// /(^[0-9]{3,4}\-[0-9]{7,8}$)|(^[0-9]{7,8}$)|(^\([0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)|(13\d{9}$)|(15[0135-9]\d{8}$)|(18[267]\d{8}$)/
// 
function validateMobile(val){
	var isNotEmpty = validateEmpty(val);
	if(isNotEmpty) {
		var re = /^1[3|4|5|8][0-9]\d{4,8}$/;
		if(!re.test(val)) {
			return false;
		} else {
			return true;
		}
	} else {
		return true;
	}
}

function validateNO(val){
	var isNotEmpty = validateEmpty(val);
	if(isNotEmpty){
		//身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X。    
		if (!(/(^\d{15}$)|(^\d{17}([0-9]|X)$)/.test(val))) {  
		    return false;  
		}  
		//校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。  
		//下面分别分析出生日期和校验位  
		var len, re;  
		len = val.length; 
		 
		//当身份证为15位时的验证出生日期。 
		if (len == 15) {  
		    re = new RegExp(/^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/);  
		    var arrSplit = val.match(re);  
		
		    //检查生日日期是否正确  
		    var dtmBirth = new Date('19' + arrSplit[2] + '/' + arrSplit[3] + '/' + arrSplit[4]);  
		    var bGoodDay;  
		    bGoodDay = (dtmBirth.getYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));  
		    if (!bGoodDay){  
		        return false;  
		    } else{  
		        //将15位身份证转成18位  
		        //校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。  
		        //var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);  
		        //var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');  
		        //var nTemp = 0, i;    
		        //val = val.substr(0, 6) + '19' + val.substr(6, val.length - 6);  
		        //for(i = 0; i < 17; i ++){  
		        //  nTemp += val.substr(i, 1) * arrInt[i];  
		        //}  
		        //val += arrCh[nTemp % 11];  
		        //alert("该15位身份证对应的18位是：" + val); 
		        //return val;    
		    }    
		}
		if (len == 18){  //当身份证号为18位时，校验出生日期和校验位。 
		    var year = val.substr(6,4); 
		    var nowDate = new Date(); 
		    var nowYear = nowDate.getYear(); 
		    if((nowYear - year) > 112){ 
		        return false; 
		    } 
		
		    re = new RegExp(/^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/);  
		    var arrSplit = val.match(re);  
		
		    //检查生日日期是否正确  
		    var dtmBirth = new Date(arrSplit[2] + "/" + arrSplit[3] + "/" + arrSplit[4]);  
		    var bGoodDay;  
		    bGoodDay = (dtmBirth.getFullYear() == Number(arrSplit[2])) && ((dtmBirth.getMonth() + 1) == Number(arrSplit[3])) && (dtmBirth.getDate() == Number(arrSplit[4]));  
		    if (!bGoodDay){  
		        return false;  
		    }  
		    else{  
		        //检验18位身份证的校验码是否正确。  
		        //校验位按照ISO 7064:1983.MOD 11-2的规定生成，X可以认为是数字10。  
		        var valnum;  
		        var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);  
		        var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');  
		        var nTemp = 0, i;  
		        for(i = 0; i < 17; i ++){  
		            nTemp += val.substr(i, 1) * arrInt[i];  
		        }  
		        valnum = arrCh[nTemp % 11];  
		        if (valnum != val.substr(17, 1)){  
		            return false;  
		        }  
		    }  
		} 
		 
		//验证地区是否有效 
		var aCity={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "} 
		if(aCity[parseInt(val.substr(0,2))] == null){ 
		    return false; 
		} 
		return true;  
	} else {
		return true;
	}
}

function validateBirthday(val, birthday) {
	var isNotEmpty = validateEmpty(birthday);
	if(validateEmpty(val) && validateNO(val) && isNotEmpty) {
		// birthday 格式YYYY-MM-DD
		if(val.length==15){
			var birth = '19' + val.substr(6,2) + '-' + val.substr(8,2) + '-' + val.substr(10,2);
			if(birthday == birth){
				return true;
			} else {
				return false;
			}
		} 
		if(val.length==18){
			var birth = val.substr(6,4) + '-' + val.substr(10,2) + '-' + val.substr(12,2);
			if(birthday == birth){
				return true;
			} else {
				return false;
			}
		} 
	} else {
		return true;
	}
}

function validateSex(val, sex) {
	var isNotEmpty = validateEmpty(sex);
	if(validateEmpty(val) && validateNO(val) && isNotEmpty) {
		// sex 1为先生,0为女士
		if(val.length==15){
			if(parseInt(val.substr(-1))%2 == sex){
				return true;
			} else {
				return false;
			}
		} 
		if(val.length==18){
			if(parseInt(val.substr(-2, 1))%2 == sex){
				return true;
			} else {
				return false;
			}
		} 
	} else {
		return true;
	}
}

function validateOrder(smaller, bigger){
	var isSmallNotEmpty = validateEmpty(smaller);
	var isBigNotEmpty = validateEmpty(bigger);
	if(isSmallNotEmpty && isBigNotEmpty) {
		if(bigger >= smaller){
			return true;
		} else {
			return false;
		}
	}
	return true;
}