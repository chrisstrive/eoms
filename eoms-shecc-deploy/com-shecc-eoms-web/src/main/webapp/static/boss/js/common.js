/**
 * 通用js
 */

/**
 * Js 时间间隔计算(间隔天数)
 * 
 * @param startDate	开始时间
 * @param endDate	结束时间
 * @returns {Number}	间隔天数。如果结束天数小于开始时间则返回负值。
 */
function GetDateDiff(startDate,endDate)  
{  
    var startTime = new Date(Date.parse(startDate.replace(/-/g,   "/"))).getTime();     
    var endTime = new Date(Date.parse(endDate.replace(/-/g,   "/"))).getTime();     
    var dates = (endTime - startTime)/(1000*60*60*24);     
   
    return  dates;    
}

/**
 * 按yyyy-mm-dd格式化输出日期字符串
 * 
 * @param date	要格式化的日期
 * @returns {String}
 */
function FormatDate(date){
	var s="";
	s += date.getFullYear()+"-";                         // 获取年份。
	s += (date.getMonth() + 1) + "-";            // 获取月份。
	s += date.getDate();                   // 获取日。
	return s;
}

/**
 * 判断对象是否为空
 */
var isEmptyValue = function(value) {  
	var type;
	if(value == null) { // 等同于 value === undefined || value === null
		return true;
	}
	type = Object.prototype.toString.call(value).slice(8, -1);
	switch(type) {
		case 'String':
		return !$.trim(value);
		case 'Array':
		return !value.length;
		case 'Object':
		return $.isEmptyObject(value); // 普通对象使用 for...in 判断，有 key 即为 false
		default:
		return false; // 其他对象均视作非空
	}
};


/**
 * 重新计算箱子的在场天数、堆存费、流转天数、滞箱费
 * @param enterYardDate	进场时间
 * @param outYardDate	出场时间
 * @param freePeriod	免堆期
 * @param storageChargeStandard	堆存费标准
 * @param returnDate	还柜时间
 * @param freeDate	免租天数
 * @param demurrageStandard	滞箱费标准
 * @return Array	其中array[0]为在场天数，array[1]为堆存费，array[2]为流转天数，array[3]为滞箱费
 */
function reCalc(enterYardDate,outYardDate,freePeriod,storageChargeStandard,returnDate,freeDate,demurrageStandard){
	var result = new Array();
	var inYardNum = 0;	// 在场天数
	var storageCharge = 0;	// 堆存费
	var wanderNum = 0;	// 流转天数
	var demurrage = 0;	// 滞箱费
	// 计算在场天数和堆存费
	var now=new Date();
	if(isEmptyValue(outYardDate)){	// 如果没有出场时间，在场天数=当前时间-进场时间。		
		inYardNum = GetDateDiff(enterYardDate,FormatDate(now));
		if(inYardNum<0){
			inYardNum=0;
		}
	} else {
		inYardNum = GetDateDiff(enterYardDate,outYardDate);
	}
	if(!isEmptyValue(storageChargeStandard)){  
		// 堆存费=（在场时间-免堆期）x按柜型的费用
		if(inYardNum > parseInt(freePeriod)){
			storageCharge = (inYardNum-parseInt(freePeriod))*parseFloat(storageChargeStandard);
		}
	}
	
	// 计算流转天数和滞箱费
	if(!isEmptyValue(demurrageStandard)){
		if(isEmptyValue(returnDate)){	// 如果没有还柜时间，流转天数=当前时间-进场时间。
			wanderNum = GetDateDiff(enterYardDate,FormatDate(now));
			if(wanderNum<0){
				wanderNum=0;
			}
		} else {
			wanderNum = GetDateDiff(enterYardDate,returnDate);
		}
		// 滞箱费=（流转时间-免租天数）x按柜型的费用
		if(wanderNum > parseInt(freeDate)){
			demurrage = (wanderNum-parseInt(freeDate))*parseFloat(demurrageStandard);
		}
	}
	
	result.push(inYardNum);
	result.push(storageCharge.toFixed(2));
	result.push(wanderNum);
	result.push(demurrage.toFixed(2));
	return result;
}