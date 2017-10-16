package com.atguigu.surveypark.model.security;

import com.atguigu.surveypark.model.BaseEntity;

/**
 * 权限
 */
public class Right extends BaseEntity{
	
	private static final long serialVersionUID = -1546093517684994949L;
	private Integer id;
	private long rightCode;//权限码
	private String rightDesc;
	private String rightName = "未命名";
	private int rightPos;//权限位，想弹鼓对权限的分组，从0开始
	private String rightUrl;
	//是否公共资源
	private boolean common;
	public Integer getId() {
		return id;
	}
	public long getRightCode() {
		return rightCode;
	}
	public String getRightDesc() {
		return rightDesc;
	}
	public String getRightName() {
		return rightName;
	}
	public int getRightPos() {
		return rightPos;
	}
	public String getRightUrl() {
		return rightUrl;
	}
	public boolean isCommon() {
		return common;
	}
	public void setCommon(boolean common) {
		this.common = common;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setRightCode(long rightCode) {
		this.rightCode = rightCode;
	}
	public void setRightDesc(String rightDesc) {
		this.rightDesc = rightDesc;
	}
	public void setRightName(String rightName) {
		this.rightName = rightName;
	}
	public void setRightPos(int rightPos) {
		this.rightPos = rightPos;
	}
	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}

}
