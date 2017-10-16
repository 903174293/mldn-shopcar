package com.atguigu.surveypark.struts2.interceptor;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.atguigu.surveypark.service.RightService;
import com.atguigu.surveypark.util.ValidateUtil;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 捕获url拦截器：
 */
public class CathUrlInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4984197931478851214L;

	@Override
	public void destroy() {

	}

	@Override
	public void init() {

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionProxy proxy = invocation.getProxy();
		// 名字空间
		String ns = proxy.getNamespace();
		// actionName
		String actionName = proxy.getActionName();
		if (!ValidateUtil.isValid(ns) || ns.equals("/")) {
			ns = "";
		}
		String url = ns + "/" + actionName;

		// 取得在application容器中的spring容器------------------非常关键，通过这个知道了spring容器在项目启动的时候加载，存在范围是application，但是还有方法二
//		ApplicationContext ac = (ApplicationContext) invocation
//				.getInvocationContext()
//				.getApplication()
//				.get(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		
		//方法二：关键使用到了spring提供的WebApplicationContextUtils类--------------关键
		ServletContext sc = ServletActionContext.getServletContext();
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		
		RightService rs = (RightService) ac.getBean("rightService");
		rs.appendRightByURL(url);
		return invocation.invoke();// 放行
	}

}
