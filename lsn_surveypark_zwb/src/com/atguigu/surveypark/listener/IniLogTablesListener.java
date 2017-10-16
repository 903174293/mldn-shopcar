package com.atguigu.surveypark.listener;

import javax.annotation.Resource;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.atguigu.surveypark.service.LogService;
import com.atguigu.surveypark.util.LogUtil;

/**
 * 初始化日志表监听器
 */
@Component
@SuppressWarnings("rawtypes")
public class IniLogTablesListener implements ApplicationListener {
	@Resource
	private LogService logService ;
	
	public void onApplicationEvent(ApplicationEvent arg0) {
		//上下文刷新事件
		if(arg0 instanceof ContextRefreshedEvent){//启动项目的时候开始建表
			
			String tableName = LogUtil.generateLogTableName(0);//当前月
			logService.createLogTable(tableName);
			
			tableName = LogUtil.generateLogTableName(1);//下一个月
			logService.createLogTable(tableName);
			
			tableName = LogUtil.generateLogTableName(2);//下两个月
			logService.createLogTable(tableName);
			System.out.println("初始化日志表完成!!!");
		}
	}
}
