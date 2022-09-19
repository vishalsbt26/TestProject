package com.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPage extends TestBase {
	private static final Logger logger = LogManager.getLogger(LoginPage.class);
	@FindBy(xpath = "//a[@class='login']")
	WebElement signInBtn;

	@FindBy(id = "email")
	WebElement emailId;

	@FindBy(id = "passwd")
	WebElement pWd;

	@FindBy(id = "SubmitLogin")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@class='logout']")
	WebElement signoutBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void navToLogin() {
		signInBtn.click();
		logger.info("navigate to login");
	}

	public void loginTest(String uName, String uPwd) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		emailId.sendKeys(uName);
		pWd.sendKeys(uPwd);
		loginBtn.click();
		logger.info("enter credentials and click login button");
	}

	public void verifyLogin() {
		signoutBtn.isDisplayed();
		logger.info("verify login");
	}
}
