package com.atguigu.surveypark.model.statistics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.atguigu.surveypark.model.Question;

/**
 * 问题统计模型：
 * @author John
 *
 */
public class QuestionStatisticsModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2442560103597422985L;
	
	private int count;//回答该问题的人数：
	private List<OptionStatisticsModel> osms = new ArrayList<OptionStatisticsModel>();//选项统计模型的集合
	private Question question;//问题的模型：

	public int getCount() {
		return count;
	}

	public List<OptionStatisticsModel> getOsms() {
		return osms;
	}

	public Question getQuestion() {
		return question;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setOsms(List<OptionStatisticsModel> osms) {
		this.osms = osms;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}
