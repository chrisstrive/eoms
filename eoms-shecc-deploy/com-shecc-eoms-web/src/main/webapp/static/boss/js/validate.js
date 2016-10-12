/*
 * 用途：检查输入字符串是否为空或者全部都是空格 
 * 输入：str 
 * 返回： 如果全是空返回true,否则返回false
 */
function isNull(str) {
	if (str == "")
		return true;
	var regu = "^[ ]+$";
	var re = new RegExp(regu);
	return re.test(str);
}

/**
 * 校验字符串长度是否超长
 * @param str
 * 		待校验字符串
 * @param maxLen
 * 		允许最大长度
 * @returns {Boolean}
 */
function checkMaxLen(str, maxLen){
	var strLen = len(str);
	if(strLen <= maxLen){
		return true;
	}
	return false;
}

/**
 * 字符串长度，汉字长度为3，英文数字为1
 * @param s
 * @returns {Number}
 */
function len(s) {
	var l = 0;
	var a = s.split("");
	for (var i=0;i<a.length;i++) {
		if (a[i].charCodeAt(0)<299) {
		   l++;
		} else {
		   l+=3;
		}
	}
	return l;
}

/*
 * 用途：检查输入对象的值是否符合整数格式 
 * 输入：str 输入的字符串 
 * 返回：如果通过验证返回true,否则返回false
 * 
 */
function isInteger(str) {
	var regu = /^[-]{0,1}[0-9]{1,}$/;
	return regu.test(str);
}

/*
 * 用途：检查输入字符串是否符合正整数格式
 * 输入： s：字符串 
 * 返回： 如果通过验证返回true,否则返回false
 * 
 */
function isNumber(s) {
	var regu = "^[0-9]+$";
	var re = new RegExp(regu);
	if (s.search(re) != -1) {
		return true;
	} else {
		return false;
	}
}

/*
 * 用途：检查输入字符串是否是带小数的数字格式,可以是负数 
 * 输入： s：字符串 
 * 返回： 如果通过验证返回true,否则返回false
 * 
 */
function isDecimal(str) {
	if (isInteger(str))
		return true;
	var re = /^[-]{0,1}(\d+)[\.]+(\d+)$/;
	if (re.test(str)) {
		if (RegExp.$1 == 0 && RegExp.$2 == 0)
			return false;
		return true;
	} else {
		return false;
	}
}

/*
 * 用途：校验数字精度
 * 输入： Str：字符串  p 长度 s 小数点位数
 * 返回： 如果通过验证返回true,否则返回false
 * 
 */
function checkDoubleFix(str, p, s){
	if(!isDecimal(str)){
		return false;
	}	
	var strArry = (str + "").split(".");
	var pLength = strArry[0].length;
	var sLength = 0;
	if(strArry[1] != null){
		sLength = strArry[1].length;
	}
	if(sLength > s){
		return false;
	}
	if(pLength > (p - s)){
		return false;
	}
	return true;
}

/*
 * 用途：检查输入字符串是否符合金额格式 格式定义为可带小数的正数，小数点后最多两位 
 * 输入： s：字符串 
 * 返回： 如果通过验证返回true,否则返回false
 * 
 */
function isMoney(s) {
	if (/^\d*(.\d{1,2})?$/.test(s)) {
		return true;
	} else {
		return false;
	}
}

/**
 * 用途：检查输入字符串是否为正整数
 * 输入： s：字符串 
 * 返回： 如果通过验证返回true,否则返回false
 */
function isPositiveInteger(s){
	if (/^\d+$/.test(s)) {
		return true;
	} else {
		return false;
	}
}