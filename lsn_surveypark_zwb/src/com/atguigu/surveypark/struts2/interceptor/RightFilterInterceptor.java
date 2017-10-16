package com.atguigu.surveypark.struts2.interceptor;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.atguigu.surveypark.model.User;
import com.atguigu.surveypark.model.security.Right;
import com.atguigu.surveypark.service.RightService;
import com.atguigu.surveypark.struts2.UserAware;
import com.atguigu.surveypark.struts2.action.BaseAction;
import com.atguigu.surveypark.struts2.action.LoginAction;
import com.atguigu.surveypark.struts2.action.RegAction;
import com.atguigu.surveypark.struts2.action.SurveyAction;
import com.atguigu.surveypark.util.ValidateUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 登陆拦截器
 */
public class RightFilterInterceptor  implements Interceptor {

	private static final long serialVersionUID = 4230211839075439660L;

	public void destroy() {
	}

	public void init() {
	}
	@SuppressWarnings("rawtypes")
	public String intercept(ActionInvocation arg0) throws Exception {
		BaseAction action = (BaseAction) arg0.getAction();
		ActionProxy proxy = arg0.getProxy();
		String ns = proxy.getNamespace();
		String actionName = proxy.getActionName();
		if(ValidateUtil.hasRight(ns, actionName, ServletActionContext.getRequest(),action)){
			return arg0.invoke();
		}
		return "login" ;
	}
//	@SuppressWarnings("rawtypes")
//	public String intercept(ActionInvocation arg0) throws Exception {
//		BaseAction action = (BaseAction) arg0.getAction();
//		if(action instanceof LoginAction|| action instanceof RegAction){
//			return arg0.invoke();
//		}
//		else{
//			User user = (User) arg0.getInvocationContext().getSession().get("user");
//			if(user == null){
//				//去登陆
//				return "login" ;
//			}
//			else{
//				//放行
//				if(action instanceof UserAware){
//					//注入user给action
//					((UserAware)action).setUser(user);
//				}
//				return arg0.invoke();//放行
//			}
//		}
//	}
	
//	@SuppressWarnings("unchecked")
//	public String intercept(ActionInvocation arg0) throws Exception {
//		ActionProxy proxy = arg0.getProxy();
//		String ns = proxy.getNamespace();
//		String actionName = proxy.getActionName();
//		if(!ValidateUtil.isValid(ns)||"/".equals(ns)){
//			ns = "";
//		}
//		String url = ns + "/" +actionName;
//		//从application中查询right------------这一步非常关键：
//		Map<String,Right> map = (Map<String, Right>) arg0.getInvocationContext().getApplication().get("all_rights_map");
//		//通过url查询Right对象---------这一步非常关键
//		Right r = map.get(url);
//		//公共资源
//		if(r == null || r.isCommon()){
//			return arg0.invoke();
//		}else{
//			User user = (User) arg0.getInvocationContext().getSession().get("user");
//			//登录
//			if(user == null){
//				return "login";
//			}else{
//		
//				//超级管理员?
//				if(user.isSuperAdmin()){
//					return arg0.invoke();
//				}else{
//					//有权限？
//					if(user.hasRight(r)){
//						return arg0.invoke();
//					}else{
//						return "error_no_right";
//					}
//				}
//			}
//		}
//		
//	}
}
