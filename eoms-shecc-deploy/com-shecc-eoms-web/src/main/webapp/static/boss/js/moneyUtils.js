/**
 * 货币相关工具类
 */

/**
 * 将元转成分显示
 * 
 * @param {} val
 * @return {String}
 */
function transMoney(val){
	if(val){
		return val/100;
	}
	return "";
}