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