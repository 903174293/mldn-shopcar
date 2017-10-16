package com.atguigu.surveypark.test;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.surveypark.service.LogService;

/**
 * 测试UserService
 */
public class TestLogService {
	
	private static LogService ls ;

	@BeforeClass
	public static void iniUserService(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ls = (LogService) ac.getBean("logService");
	}
	/**
	 * 插入用户 
	 */
	@Test
	public void test0() throws SQLException{
		ls.findNearestLogs(3);
	}
}
