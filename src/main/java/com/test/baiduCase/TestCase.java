package com.test.baiduCase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.test.base.Base;

import io.appium.java_client.android.AndroidDriver;

public class TestCase {
	
	@Test
	public void testCase() throws IOException {
		Base base = new Base();
		AndroidDriver driver = base.openBrowser();
		System.out.println("开始");
		//点击更多
//		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget."
//				+ "LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android."
//				+ "widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android."
//				+ "widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget."
//				+ "LinearLayout/android.widget.LinearLayout[2]/android.widget.GridView/android.view."
//				+ "ViewGroup[5]")).click();
		List elements = driver.findElements(By.id("com.wuba:id/tv_small"));
		System.out.println(elements.size());
		WebElement element = (WebElement) elements.get(4);
		element.click();
		base.sleep(2000);
		base.slideUp();
		System.out.println("结束");
	}
}