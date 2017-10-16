package com.atguigu.surveypark.app;

import java.awt.Font;
import java.io.File;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * 测试柱状图
 */
public class AppBar {

	public static void main(String[] args) throws Exception {
		
		//创建类别数据集
		DefaultCategoryDataset ds = new DefaultCategoryDataset();
		ds.addValue(3400, "IBM", "一季度");
		ds.addValue(3100, "Oracle", "一季度");
		ds.addValue(1950, "用友", "一季度");
		
		ds.addValue(2500, "IBM", "二季度");
		ds.addValue(4300, "Oracle", "二季度");
		ds.addValue(3800, "用友", "二季度");
		
		ds.addValue(5300, "IBM", "三季度");
		ds.addValue(4350, "Oracle", "三季度");
		ds.addValue(2300, "用友", "三季度");
		
		//创建jfreechart对象( 饼图)
		String title1 = "前三季度各大公司JEE AS销量统计" ;
		String title2 = "季度" ;
		String title3 = "销量(单位:万台)";
		JFreeChart chart = ChartFactory.createBarChart3D(title1, title2, title3, ds, PlotOrientation.VERTICAL, true, false, false);
		//中文问题
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 25));
		//提示条字体
		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 15));
		//得到绘图区
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		//domain轴标签字体
		plot.getDomainAxis().setLabelFont(new Font("宋体", Font.PLAIN, 15));
		//domain轴小标签字体
		plot.getDomainAxis().setTickLabelFont(new Font("宋体", Font.PLAIN, 15));
		
		//range轴标签字体
		plot.getRangeAxis().setLabelFont(new Font("宋体", Font.PLAIN, 15));
		
		ChartUtilities.saveChartAsJPEG(new File("f:/bar.jpg"), chart, 800, 500);
	}

}
