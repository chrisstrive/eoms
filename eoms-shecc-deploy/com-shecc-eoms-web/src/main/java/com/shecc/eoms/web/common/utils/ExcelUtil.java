package com.shecc.eoms.web.common.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.formula.functions.T;

public class ExcelUtil {
     
	public static void exportExcel(String title, String[] headers,
	         Collection<T> dataset, OutputStream out, String pattern) {
		 // 声明一个工作薄
	      HSSFWorkbook workbook = new HSSFWorkbook();
	      // 生成一个表格
	      HSSFSheet sheet = workbook.createSheet(title);
	      // 设置表格默认列宽度为15个字节
	      sheet.setDefaultColumnWidth((short) 15);
	      // 生成一个样式
	      HSSFCellStyle style = workbook.createCellStyle();
	      // 设置这些样式
	      style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
	      style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	      style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	      style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	      style.setBorderRight(HSSFCellStyle.BORDER_THIN);
	      style.setBorderTop(HSSFCellStyle.BORDER_THIN);
	      style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	      // 生成一个字体
	      HSSFFont font = workbook.createFont();
	      font.setColor(HSSFColor.VIOLET.index);
	      font.setFontHeightInPoints((short) 12);
	      font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	      // 把字体应用到当前的样式
	      style.setFont(font);
	      // 生成并设置另一个样式
	      HSSFCellStyle style2 = workbook.createCellStyle();
	      style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
	      style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	      style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
	      style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
	      style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
	      style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
	      style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
	      style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
	      // 生成另一个字体
	      HSSFFont font2 = workbook.createFont();
	      font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
	      // 把字体应用到当前的样式
	      style2.setFont(font2);
	     
	      //产生表格标题行
	      HSSFRow row = sheet.createRow(0);

	      for (short i = 0; i < headers.length; i++) {
	         HSSFCell cell = row.createCell(i);
	         cell.setCellStyle(style);
	         HSSFRichTextString text = new HSSFRichTextString(headers[i]);
	         cell.setCellValue(text);
	      }
	      //遍历集合数据，产生数据行
	      Iterator<T> it = dataset.iterator();

	      int index = 0;

	      while (it.hasNext()) {
	         index++;
	         row = sheet.createRow(index);
	         T t = (T) it.next();
	         //利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
	         Field[] fields = t.getClass().getDeclaredFields();

	         for (short i = 0; i < fields.length; i++) {
	            HSSFCell cell = row.createCell(i);
	            cell.setCellStyle(style2);
	            Field field = fields[i];
	            String fieldName = field.getName();
	            String getMethodName = "get"
	                   + fieldName.substring(0, 1).toUpperCase()
	                   + fieldName.substring(1);
	            try {
	                Class tCls = t.getClass();
	                Method getMethod = tCls.getMethod(getMethodName,
	                      new Class[] {});
	                Object value = getMethod.invoke(t, new Object[] {});

	                //判断值的类型后进行强制类型转换
	                String textValue = null;

	              if (value instanceof Integer) {
	                 int intValue = (Integer) value;
	                 cell.setCellValue(intValue);
	              }  else if (value instanceof Double) {
	                 double dValue = (Double) value;
	                 textValue = new HSSFRichTextString(String.valueOf(dValue)).toString();
	                 cell.setCellValue(textValue);
	              } else if (value instanceof Long) {
	                 long longValue = (Long) value;
	                 cell.setCellValue(longValue);
	              }  else{
	                   //其它数据类型都当作字符串简单处理
	                   textValue = value.toString();
	                   cell.setCellValue(textValue);
	             }

	            } catch (Exception e) {
	                e.printStackTrace();
	            } finally {
	                //清理资源
	            }
	         }
	      }
	      try {
	         workbook.write(out);
	      } catch (IOException e) {
	         e.printStackTrace();
	      }

	}
}
