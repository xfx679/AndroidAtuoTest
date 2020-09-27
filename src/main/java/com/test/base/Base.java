package com.test.base;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Base{

	// 获取项目路径(本地项目路径)
	String filePath = System.getProperty("user.dir");
	static AndroidDriver driver = null;
	static Duration duration=Duration.ofSeconds(1);

	// 启动app
	public AndroidDriver openBrowser() throws IOException {
		// 添加配置，创建DesiredCapabilities对象
		DesiredCapabilities des = new DesiredCapabilities();
		String[] parVa = ParameterValue.parameterValue();
		des.setCapability("deviceName", parVa[0]);
		des.setCapability("platformName", parVa[1]);
		des.setCapability("platformVersion", parVa[2]);
		des.setCapability("appPackage", parVa[3]);
		des.setCapability("appActivity", parVa[4]);
		des.setCapability("unicodeKeyboard", parVa[5]);
		des.setCapability("resetKeyboard", parVa[6]);
		des.setCapability("noReset", parVa[7]);
		des.setCapability("automationName", parVa[8]);
		// .创建驱动...URL是appium的固定地址；指定appium通讯的地址，将相对应的配置传入到驱动里边
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), des);
		sleep(3000);
		return driver;
	}

	// 关闭浏览器
	public void colseBrowser() {
		driver.quit();
	}

	// 等待时间
	public void sleep(int time) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获取url地址
	public WebDriver getUrl(String url) {
		driver.get(url);
		sleep(2000);
		return driver;
	}

	/**
	  * 向上滑动屏幕
	  */
	 public static void slideUp() {
	  int width = driver.manage().window().getSize().width;
//	  System.out.println(width);
	  int height = driver.manage().window().getSize().height;
//	  System.out.println(height);
	  new TouchAction(driver).press(PointOption.point(width / 2, height * 3 / 4)).waitAction()
	    .moveTo(PointOption.point(width / 2, height / 10)).release().perform();
	 }

	/**
	 * 向下滑动
	 */
	public static void slideDown() {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		new TouchAction(driver).press(PointOption.point(width / 2, height / 10)).waitAction()
				.moveTo(PointOption.point(width / 2, height * 3 / 4)).release().perform();
	}

	/**
	 * 向左滑动屏幕
	 */
	public void SwipeLeft() {
		Dimension size = driver.manage().window().getSize();
		int height = size.height;
		int width = size.width;
		new TouchAction(driver).longPress(PointOption.point(width - 100, height / 2)).waitAction()
				.moveTo(PointOption.point(100, height / 2)).release().perform();
	}

	/**
	 * 向右滑动屏幕
	 */
	public void SwipeRight() {
		Dimension size = driver.manage().window().getSize();
		int height = size.height;
		int width = size.width;
		new TouchAction(driver).longPress(PointOption.point(100, height / 2)).waitAction()
				.moveTo(PointOption.point(width - 100, height / 2)).release().perform();
	}
	
	 //截图方法
    public void CaptureScreenShot(String fileName) throws IOException {
        File srcfile=driver.getScreenshotAs(OutputType.FILE);//截图
        File location = new File(filePath + "/src/pic");//存放的电脑路径上
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String screenShotName = location.getAbsolutePath()+File.separator+dateFormat.format(new Date())+fileName+".png";
        FileUtils.copyFile(srcfile,new File(screenShotName));
    }
    
    
    
}
