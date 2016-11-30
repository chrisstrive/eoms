/**
 * 通用js
 */

/**
 * 去除字符串首尾空格
 */
function Trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

/**
 * 在列表中格式化图片
 */
function formatPic(reqPath,picPath) {
	if (picPath == null || Trim(picPath).length == 0) {
		return "无图片";
	} else {
		return "<a href=\"javascript:viewPic('" + reqPath+"','"+picPath + "')\">查看</a>"
	}
}

/**
 * 根据图片路径弹出图片展示窗口
 */
function viewPic(reqPath, picPath) {
	var url = reqPath+"/fileUpload.htm?method=viewPic&picPath="
	+ picPath;
	window.open(url, "查看图片", "dialogWidth:1000px;dialogHeight:auto;status:no;help:no;resizable:yes;");
}