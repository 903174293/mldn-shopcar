package com.atguigu.surveypark.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;


public class AppPoi {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//工作簿
		HSSFWorkbook wb = new HSSFWorkbook();
		//工作表
		HSSFSheet sheet  = wb.createSheet("first sheet");
		wb.createSheet("second sheet");
		//行
		HSSFRow row = sheet.createRow(0);
		//单元格
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(false);//boolean
		row.createCell(1).setCellValue(Calendar.getInstance());//calendar
		//date
		row.createCell(2).setCellValue(new Date());//date
		//double
		row.createCell(3).setCellValue(123456789.987373);
		//string
		String str = "ddddddddddddddddddd";
		row.createCell(4).setCellValue(new HSSFRichTextString(str));
		row.createCell(4).setCellValue(new HSSFRichTextString(str));
		
		//常见数据格式对象
		HSSFDataFormat format = wb.createDataFormat();
		//格式化数据
		HSSFCellStyle style = wb.createCellStyle();
		//设置样式的数据格式，对日期格式化
		style.setDataFormat(format.getFormat("yyyy-MM-dd hh:mm:ss"));
		//应用样式给单元格
		row.getCell(1).setCellStyle(style);
		row.getCell(2).setCellStyle(style);
		
		//double值格式化
		style = wb.createCellStyle();
		style.setDataFormat(format.getFormat("#,###.000"));
		row.getCell(3).setCellStyle(style);
		
		//设置列宽(单位:1/20 点)
				sheet.setColumnWidth(1, 3000);
				//自动列宽
				sheet.autoSizeColumn(2);
				
				sheet.setColumnWidth(4, 7000);
				
				//自动回绕文本
				style = wb.createCellStyle();
				style.setWrapText(true);
				row.getCell(4).setCellStyle(style);
				
				//设置文本对齐方式
				row = sheet.createRow(1);
				row.createCell(0).setCellValue("左上");
				row.createCell(1).setCellValue("中中");
				row.createCell(2).setCellValue("右下");
				
				//设置行高
				row.setHeightInPoints(50);
				sheet.setColumnWidth(0, 5000);
				sheet.setColumnWidth(1, 5000);
				sheet.setColumnWidth(2, 5000);
				
				//设置对其方式--左上
				style = wb.createCellStyle();
				style.setAlignment(HSSFCellStyle.ALIGN_LEFT);//左对齐
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);//上对齐
				row.getCell(0).setCellStyle(style);
				
				//设置对其方式--中中
				style = wb.createCellStyle();
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//左对齐
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//上对齐
				row.getCell(1).setCellStyle(style);
				
				//设置对其方式--右下
				style = wb.createCellStyle();
				style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);//左对齐
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_BOTTOM);//上对齐
				row.getCell(2).setCellStyle(style);
				
				//设置字体颜色和大小
				style = row.getCell(1).getCellStyle();
				HSSFFont font = wb.createFont();
				font.setFontName("方正姚体");
				font.setFontHeightInPoints((short)30);
				font.setItalic(true);
				font.setColor(HSSFColor.RED.index);
				style.setFont(font);
				
				//字体旋转
				style = row.getCell(1).getCellStyle();
				style.setRotation((short)-30);
				
				//设置边框
				row = sheet.createRow(2);
				cell = row.createCell(0);
				style = wb.createCellStyle();
				style.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);//双实线
				style.setTopBorderColor(HSSFColor.BLUE.index);
//				style.setFillBackgroundColor(HSSFColor.DARK_BLUE.index);//填充背景色
//				style.setFillForegroundColor(HSSFColor.DARK_BLUE.index);//填充前景色
				cell.setCellStyle(style);
				
				//计算列
				row = sheet.createRow(3);
				row.createCell(0).setCellValue(13);
				row.createCell(1).setCellValue(20);
				row.createCell(2).setCellValue(19);
				row.createCell(3).setCellFormula("sum(A4:C4)");
				//移动行
				sheet.shiftRows(1, 3, 2);
				
				//拆分窗格
				//1000:左侧窗格的宽度
				//2000:上侧窗格的高度
				//3:右侧窗格开始显示列的索引
				//4:下侧窗格开始显示行的索引
				//0:激活的面板区
				//sheet.createSplitPane(1000,2000, 3, 4, 0);
				
				//冻结窗格
				//1:左侧冻结的列数
				//2:上侧冻结的行数
				//3:右侧窗格开始显示列的索引
				//4:下侧窗格开始显示行的索引
				//sheet.createFreezePane(1, 2, 3, 4);
				//保存
				CellRangeAddress d = new CellRangeAddress(1, 3, 1, 3);
				sheet.addMergedRegion(d);
				wb.write(new FileOutputStream(new File("f:/poi.xls")));
			}
		}
