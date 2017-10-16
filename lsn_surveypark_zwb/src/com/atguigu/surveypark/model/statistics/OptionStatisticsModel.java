package com.atguigu.surveypark.model.statistics;

import java.io.Serializable;

/**
 * 选项统计模型：
 * @author John
 *
 */
public class OptionStatisticsModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6622651563571501397L;

	//选项的回答人数：
	private int count;
	
	private int matrixColIndex;//列标签
	private String matrixColLabel;//列索引
	
	private int matrixRowIndex;//行标签
	private String matrixRowLabel;//行索引
	
	private int matrixSelectIndex;
	private String matrixSelectLabel;
	/*
	 * 非矩阵：饼图
	 */
	private int optionIndex;//选项索引
	private String optionLabel;//选项标签

	public int getCount() {
		return count;
	}

	public int getMatrixColIndex() {
		return matrixColIndex;
	}

	public String getMatrixColLabel() {
		return matrixColLabel;
	}

	public int getMatrixRowIndex() {
		return matrixRowIndex;
	}

	public String getMatrixRowLabel() {
		return matrixRowLabel;
	}

	public int getMatrixSelectIndex() {
		return matrixSelectIndex;
	}

	public String getMatrixSelectLabel() {
		return matrixSelectLabel;
	}

	public int getOptionIndex() {
		return optionIndex;
	}

	public String getOptionLabel() {
		return optionLabel;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setMatrixColIndex(int matrixColIndex) {
		this.matrixColIndex = matrixColIndex;
	}

	public void setMatrixColLabel(String matrixColLabel) {
		this.matrixColLabel = matrixColLabel;
	}

	public void setMatrixRowIndex(int matrixRowIndex) {
		this.matrixRowIndex = matrixRowIndex;
	}

	public void setMatrixRowLabel(String matrixRowLabel) {
		this.matrixRowLabel = matrixRowLabel;
	}

	public void setMatrixSelectIndex(int matrixSelectIndex) {
		this.matrixSelectIndex = matrixSelectIndex;
	}

	public void setMatrixSelectLabel(String matrixSelectLabel) {
		this.matrixSelectLabel = matrixSelectLabel;
	}
	public void setOptionIndex(int optionIndex) {
		this.optionIndex = optionIndex;
	}
	
	public void setOptionLabel(String optionLabel) {
		this.optionLabel = optionLabel;
	}
}
