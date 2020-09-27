package com.test.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
	
	//登录按钮
	@FindBy(xpath="//*[@id=\"u1\"]/a[2]")
	private WebElement loginClick;
	
	//用户名登录
	@FindBy(xpath="//*[@id=\"TANGRAM__PSP_11__footerULoginBtn\"]")
	private WebElement userNaneLogin;
	
	//用户名输入框
	@FindBy(xpath="//*[@id=\"TANGRAM__PSP_11__userName\"]")
	private WebElement nameInput;
	
	//密码输入框
	@FindBy(xpath="//*[@id=\"TANGRAM__PSP_11__password\"]")
	private WebElement passInput;

	public WebElement getLoginClick() {
		return loginClick;
	}

	public void setLoginClick(WebElement loginClick) {
		this.loginClick = loginClick;
	}

	public WebElement getUserNaneLogin() {
		return userNaneLogin;
	}

	public void setUserNaneLogin(WebElement userNaneLogin) {
		this.userNaneLogin = userNaneLogin;
	}

	public WebElement getNameInput() {
		return nameInput;
	}

	public void setNameInput(WebElement nameInput) {
		this.nameInput = nameInput;
	}

	public WebElement getPassInput() {
		return passInput;
	}

	public void setPassInput(WebElement passInput) {
		this.passInput = passInput;
	}
	
}
