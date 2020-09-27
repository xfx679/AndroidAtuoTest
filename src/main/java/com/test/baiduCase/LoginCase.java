package com.test.baiduCase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.test.base.Base;

import io.appium.java_client.android.AndroidDriver;

public class LoginCase {
	
	

	@Test
	public void login() throws IOException {
		Base base = new Base();
		AndroidDriver driver = base.openBrowser();
		System.out.println("开始");
		base.sleep(2000);
		//点击新版本弹关闭按钮
		driver.findElement(By.id("com.uxin.usedcar:id/dialog_cancelId")).click();
		System.out.println("------点击关闭按钮成功");
		base.sleep(3000);
		//点击开始选车按钮
//		driver.findElement(By.id("com.uxin.usedcar:id/z8")).click();//测试环境
		driver.findElement(By.id("com.uxin.usedcar:id/yv")).click();;//正式环境
		System.out.println("------进入列表页成功");
		base.sleep(2000);
		//屏幕截图
//		base.CaptureScreenShot("appView");
		//滑动页面
//		base.slideUp();
//		base.sleep(2000);
//		System.out.println("------滑动页面成功");
		//列表页点击车辆
		List elements = driver.findElements(By.className("android.widget.TextView"));
		System.out.println(elements.size());
//		WebElement element = (WebElement) elements.get(1);
//		element.click();
//		driver.findElement(By.id("com.uxin.usedcar:id/bww")).click();//进入买家秀页面
		base.sleep(2000);
		System.out.println("结束");
		driver.close();
	}
}
