package com.atguigu.surveypark.app;

import java.awt.Font;
import java.io.File;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 * 测试Jfreechart
 */
public class AppPie {

	public static void main(String[] args) throws Exception {
		
		//创建饼图数据集
		DefaultPieDataset ds = new DefaultPieDataset();
		ds.setValue("IBM", 4000);
		ds.setValue("Oracle", 6500);
		ds.setValue("JBOSS", 3300);
		ds.setValue("用友", 8900);
		
		//创建jfreechart对象( 饼图)
		JFreeChart chart = ChartFactory.createPieChart3D("标题", ds, true, false, false);
		//设置标题字体
		chart.getTitle().setFont(new Font("宋体", Font.BOLD, 25));
		
		//提示条字体
		chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 15));
		
		//得到绘图区
		PiePlot plot = (PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("宋体", Font.ITALIC, 15));
		
		//设置绘图区的背景图
		//plot.setBackgroundImage(ImageIO.read(new File("f:/Sunset.jpg")));
		//chart.setBackgroundImage(ImageIO.read(new File("f:/Water lilies.jpg")));
		
		//设置分离效果
		plot.setExplodePercent("IBM", 0.1f);
//		plot.setExplodePercent("Oracle", 0.15f);
//		plot.setExplodePercent("用友", 0.2f);
//		plot.setExplodePercent("JBOSS", 0.25f);
		
		//设置前景透明
		plot.setForegroundAlpha(0.75f);
		
		//定制标签
		//{0}:公司名称
		//{1}:公司销售额
		//{2}:百分比
		//{3}:总和
		//{4}:没有了
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}({1}/{3}--{2})"));
		
		ChartUtilities.saveChartAsJPEG(new File("f:/pie.jpg"), chart, 800, 500);
	}

}
