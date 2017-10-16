package com.atguigu.surveypark.model;

import java.util.Date;

/**
 * Answer：关键：这个实体类对Question对象不进行关联：原因：不会单独抽出一个问题出来对其进行研究，只关心最后的所有问题的统计结果
 */
public class Answer extends BaseEntity{
	
	private static final long serialVersionUID = -4430696809432774247L;
	private Integer id;
	private String answerIds;// 选项的索引.
	private String otherAnswer;
	private String uuid;// 批次.一个人对应一个uuid
	private Date answerTime;

	private Integer questionId;// 关联字段：关键：不建立关联关系，它们的关系就用普通的字段维护------------------------
	private Integer surveyId;// 关联字段(冗余)：关键：为了提高性能，违反了数据库的三范式，使用了冗余字段----------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAnswerIds() {
		return answerIds;
	}

	public void setAnswerIds(String answerIds) {
		this.answerIds = answerIds;
	}

	public String getOtherAnswer() {
		return otherAnswer;
	}

	public void setOtherAnswer(String otherAnswer) {
		this.otherAnswer = otherAnswer;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(Date answerTime) {
		this.answerTime = answerTime;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Integer surveyId) {
		this.surveyId = surveyId;
	}

}
