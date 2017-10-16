package com.atguigu.surveypark.struts2.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atguigu.surveypark.model.Page;
import com.atguigu.surveypark.model.Survey;
import com.atguigu.surveypark.model.User;
import com.atguigu.surveypark.service.SurveyService;
import com.atguigu.surveypark.struts2.UserAware;
/**
 * 移动、复制页面的Action
 * @author John
 *
 */
@Controller
@Scope("prototype")
public class MoveOrCopyPageAction extends BaseAction<Page> implements UserAware {

	private static final long serialVersionUID = 1L;
	//原页面的id
	private Integer srcPid;
	//目标页面的id
	private Integer targPid;
	//位置：0-之前 1-之后
	private int pos;
	//目标调查的id
	private Integer sid;

	public Integer getTargPid() {
		return targPid;
	}

	public void setTargPid(Integer targPid) {
		this.targPid = targPid;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	private List<Survey> mySurveys;
	
	@Resource
	private SurveyService surveyService;
	//接收用户：关键
	private User user;

	public SurveyService getSurveyService() {
		return surveyService;
	}

	public void setSurveyService(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	public List<Survey> getMySurveys() {
		return mySurveys;
	}

	public void setMySurveys(List<Survey> mySurveys) {
		this.mySurveys = mySurveys;
	}

	public Integer getSrcPid() {
		return srcPid;
	}

	public void setSrcPid(Integer srcPid) {
		this.srcPid = srcPid;
	}
	
	/**
	 * 到达移动/赋值页列表页面
	 */
	public String toSelectTargetPage(){
		this.mySurveys = surveyService.getSurveyWithPages(user);//得到user的方法也是相当的关键：实现接口的方式，底层应用的是拦截器的机制
		return "moveOrCopyPageListPage";
	}
	/**
	 * 执行移动/赋值页列表页面
	 */
	public String doMoveOrCopyPage(){
		surveyService.moveOrCopyPage(srcPid,targPid,pos);
		return "designSurveyAction";
	}
	/**
	 * 用户注入的方法：关键----------------这个是利用了拦截器的机制------关键
	 */
	@Override
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * 完成移动/复制操作
	 */
	public String doSelectTargetPage(){
		return null;
	}

}
