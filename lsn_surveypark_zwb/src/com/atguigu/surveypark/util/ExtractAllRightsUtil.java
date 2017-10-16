package com.atguigu.surveypark.util;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.surveypark.service.RightService;

import javassist.Modifier;


/**
 * 提取所有权限工具类
 */
public class ExtractAllRightsUtil {
	
	public static void main(String[] args) throws URISyntaxException {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		RightService rs = (RightService) ac.getBean("rightService");
		
		ClassLoader loader = ExtractAllRightsUtil.class.getClassLoader();//静态方法使用这个：ExtractAllRightsUtil.class得到Class类
		URL url = loader.getResource("com/atguigu/surveypark/struts2/action");
		System.out.println(url.toString());
		System.out.println(url.toURI());
		File dir = new File(url.toURI());
		File[] files = dir.listFiles();
		String fname  = "";
		for(File f : files){
			fname = f.getName();
			if(fname.endsWith(".class")
					&& !fname.equals("BaseAction.class")){
//				System.out.println(fname);
				processAction(fname,rs);
			}
		}
		
	}

	/**
	 * 处理action类，铺获所有的url地址，形成权限
	 */
	@SuppressWarnings("rawtypes")
	private static void processAction(String fname,RightService rs) {
		String pkgName = "com.atguigu.surveypark.struts2.action";
		String simpleClassName = fname.substring(0,fname.indexOf(".class"));
//		System.out.println(simpleClassName);
		String className = pkgName + "." + simpleClassName ; 
		//得到具体类
		try {
			Class clazz = Class.forName(className);
			Method[] methods = clazz.getDeclaredMethods();
			Class retType = null;
			String mname = null;
			Class[] paramType = null;
			String url = null;
			for(Method m : methods){
				retType = m.getReturnType();//返回值类型
				mname = m.getName();//方法名称
				paramType = m.getParameterTypes();//参数类型
				if(retType == String.class
						&& !ValidateUtil.isValid(paramType)
						&& Modifier.isPublic(m.getModifiers())){
					if(mname.equals("execute")){
						url = "/" +simpleClassName;
					}else{
						url = "/" +simpleClassName + "_" +mname;
					}
					System.out.println(url);
					rs.appendRightByURL(url);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
