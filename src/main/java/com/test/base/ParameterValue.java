package com.test.base;

import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

public class ParameterValue {
	
	public static Parameter par = new Parameter();
	
	public static String[] parameterValue() throws IOException {
		String deviceName = par.obtain("deviceName", "appium_oppo");//使用移动设备或模拟器的种类
		String platformName = par.obtain("platformName", "appium_huawei");//使用那个移动端的平台
		String platformVersion = par.obtain("platformVersion", "appium_oppo");//移动平台版本号
		String appPackage = par.obtain("appPackage", "appium_huawei");//要运行的Android应用软件包
		String appActivity = par.obtain("appActivity", "appium_huawei");//获取Android的启动名
		String unicodeKeyboard = par.obtain("unicodeKeyboard", "appium_huawei");//屏蔽自带键盘
		String resetKeyboard = par.obtain("resetKeyboard", "appium_huawei");//频闭自带键盘
		String noReset = par.obtain("noReset", "appium_huawei");//在此会话前，请勿重置y应用程序状态
		String automationName = par.obtain("automationName", "appium_huawei");//使用那个自动化引擎
		
		List<String> list = new ArrayList<String>();
		list.add(deviceName);
		list.add(platformName);
		list.add(platformVersion);
		list.add(appPackage);
		list.add(appActivity);
		list.add(unicodeKeyboard);
		list.add(resetKeyboard);
		list.add(noReset);
		list.add(automationName);
		//第二种遍历,把把链表变为数组相关的内容进行遍历
		String[] strArray = new String[list.size()];
		list.toArray(strArray);
		//用这个的话所有调用的数据类型为object
//		Object[] strArray = list.toArray();
		return strArray;
	}
}
