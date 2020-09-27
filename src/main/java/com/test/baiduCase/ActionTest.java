package com.test.baiduCase;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionTest {
	
	public WebDriver driver;
	
	//初始化
	public void inItDriver() {
		System.setProperty("webdriver.chrome.driver","E:\\qudong\\chromedriver.exe");
		driver = new ChromeDriver();
		//进入163邮箱页面
		driver.get("https://mail.163.com/");
		//窗口放大
		driver.manage().window().maximize();
	}
	
	/*
	 * 文本框
	 */
	public void inputBox() throws InterruptedException {
		//点击密码登录按钮
		driver.findElement(By.linkText("密码登录")).click();
		//切入到iframe框架中
		driver.switchTo().frame(0);
		//输入邮箱账号
		driver.findElement(By.name("email")).sendKeys("13835639917");
		//等待2秒钟
		Thread.sleep(2000);
//		//清除邮箱账号
//		driver.findElement(By.name("email")).clear();
		Thread.sleep(1000);
//		//获取属性信息
		String s = driver.findElement(By.name("email")).getAttribute("placeholder");
		System.out.println(s);
		//登录密码
		driver.findElement(By.name("password")).sendKeys("shaquan199796");
		//点击登录按钮
		driver.findElement(By.linkText("登  录")).click();
		Thread.sleep(1000);
		//切回到主文档
		driver.switchTo().parentFrame();
		//关闭网站
//		driver.close();
	}
	
//	public void 
	
	/*
	 * 单选框
	 */
	public void radioBox() throws InterruptedException {
		//点击设置
		driver.findElement(By.linkText("设置")).click();
		//点击常规设置
		driver.findElement(By.className("nui-menu-item-text")).click();
		Thread.sleep(4000);
		//选择上线分栏
		driver.switchTo().frame(0);
		List<WebElement> elements = driver.findElements(By.xpath("div[contains(@id, 'dvContentContainer')]"));
//		List<WebElement> elements = driver.findElements(By.xpath("//span[contains(@id, 'radio')]"));
		System.out.println(elements.size());		
//		List<WebElement> elementss = elements.get(0).findElements(By.xpath("//b[starts-with(@id, '_mail_icon"));
//		elementss.get(0).click();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ActionTest at = new ActionTest();
		at.inItDriver();
		at.inputBox();
		at.radioBox();
	}

}
