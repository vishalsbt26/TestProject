package com.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.LoginPage;
import com.util.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	private static final Logger logger = LogManager.getLogger();

	public LoginPageTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		logger.info("nav to site");
	}

	@Test(priority = 1)
	public void navigation() {
		loginPage.navToLogin();
		logger.info("navigate to login page");
	}
	
	@DataProvider
	public Object[][] excelData() {
		Object data[][] = TestUtil.getData("login");
		logger.info("taking data");
		return data;
	}

	@Test(priority = 2, dataProvider = "excelData")
	public void loginTest(String uName, String uPwd) {
		loginPage.loginTest(uName, uPwd);
		logger.info("login");
	}

	@Test(priority = 3)
	public void verifyLogIn() {
		loginPage.verifyLogin();
		logger.info("verify login");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
