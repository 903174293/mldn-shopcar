package com.atguigu.surveypark.util;

import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * 日志工具类
 */
public class LogUtil {
	
	/**
	 * 生成日志表名称：logs_2013_9
	 * offset:偏移量
	 */
	public static String generateLogTableName(int offset) {
		//得到当前的年份和月份，使用日历类：
		Calendar c = Calendar.getInstance();
		//2017
		int year = c.get(Calendar.YEAR);
		//0-11
		int month =  c.get(Calendar.MONTH) + 1 + offset;
		
		if(month > 12){
			year ++;
			month = month - 12 ;
		}
		if(month < 1){
			year --;
			month = month +12;
		}
//		return "logs_" +year +"_" +month;
		
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("00");//这个类是用来：01、02、03............10、11、12
		return "logs_" + year + "_" + df.format(month) ;
	}

}
