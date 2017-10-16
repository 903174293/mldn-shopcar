package com.atguigu.surveypark.advice;

import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;

import com.atguigu.surveypark.model.Log;
import com.atguigu.surveypark.model.User;
import com.atguigu.surveypark.service.LogService;
import com.atguigu.surveypark.util.StringUtil;
import com.opensymphony.xwork2.ActionContext;

/**
 * Logger日志记录仪，记录写操作
 */
public class Logger {
	
	@Resource
	private LogService logService;
	/**
	 * 记录：
	 */
	public Object record(ProceedingJoinPoint pjp){//pjp是处理连接点
		Log log = new Log();
		try{//环绕通知用这个包起来，出现异常回滚
			//设置操作人：
			ActionContext ac = ActionContext.getContext();
			if(ac != null){
				Map<String,Object> session = ac.getSession();
				if(session != null){
					User user = (User) session.get("user");
					if(user != null){//注意：日志表几乎不跟其他表关联
						log.setOperator(""+user.getId() + ":" +user.getEmail());
						
					}
				}
			}
			//设置操作名称：
			String mname = pjp.getSignature().getName();//得到方法签名
			log.setOperName(mname);
			//设置操作参数：
			Object[] params = pjp.getArgs();
			log.setOperParams(StringUtil.arr2Str(params));
			//调用目标对象的方法：
			Object ret = pjp.proceed();
			//设置操作结果
			log.setOperResult("success");//如果抛出异常，就失败了
			//设置结果消息
			if(ret != null){
				log.setResultMsg(ret.toString());
			}
			return ret ;//返回目标对象方法的返回值
		}catch(Throwable e){
			log.setOperResult("failure");
			log.setResultMsg(e.getMessage());
		}finally{
			logService.saveEntity(log);
		}
		return null;
	}
}
