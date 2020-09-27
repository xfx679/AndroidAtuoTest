package com.test.baiduCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaiDuTest {

	public static WebDriver driver;

	// 初始化
	public void inItDriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\qudong\\chromedriver.exe");
		driver = new ChromeDriver();
		// 进入百度页面
		driver.get("https://www.baidu.com/");
//		driver.get("https://passport.baidu.com/v2/?login&tpl=mn&u=http%3A%2F%2Fwww.baidu.com%2F&sms=5");
		// 窗口放大
		driver.manage().window().maximize();
	}

	/**
	 * 文本框
	 * 
	 * @throws InterruptedException
	 */
	public void inputBox() throws InterruptedException {
		// 点击登录按钮
		driver.findElement(By.linkText("登录")).click();
		// 停留一秒中
		Thread.sleep(1000);
		// 点击用户名登录
		driver.findElement(By.xpath("//*[@class=\"tang-pass-footerBar\"]/p[text()=\"用户名登录\"]")).click();
		// 输入用户名
		driver.findElement(By.id("TANGRAM__PSP_10__userName")).sendKeys("13835639917");
		Thread.sleep(2000);
		// 清除用户名
//		driver.findElement(By.id("TANGRAM__PSP_10__userName")).clear();
		// 获取属性信息
		String s = driver.findElement(By.id("TANGRAM__PSP_10__userName")).getAttribute("placeholder");
		System.out.println(s);
		//输入密码
		driver.findElement(By.id("TANGRAM__PSP_10__password")).sendKeys("Q1234567890.");
		//点击登录按钮
//		driver.findElement(By.id("TANGRAM__PSP_10__submit")).click();
	}
	
	/**
	 * 复选框+下拉框
	 * @throws InterruptedException
	 */
	public void radioBox() throws InterruptedException {
		driver.get("https://www.baidu.com/");
		//点击设置+鼠标悬停
//		Actions action = new Actions(driver);
//		action.moveToElement(driver.findElement(By.className("setting-text"))).perform();
		//点击设置
		driver.findElement(By.id("s-usersetting-top")).click();
		//打开搜索设置
		driver.findElement(By.linkText("搜索设置")).click();
		//点击搜索框提示：不显示
		List<WebElement> element = driver.findElements(By.className("s1"));
		System.out.println(element.size());
	}
	public static void main(String[] args) throws InterruptedException {
		BaiDuTest bt = new BaiDuTest();
		bt.inItDriver();
		bt.inputBox();
		bt.radioBox();
		driver.close();
	}
}
