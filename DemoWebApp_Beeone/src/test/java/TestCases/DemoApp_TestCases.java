package TestCases;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automationCore.BaseClass;
import PageClasses.DemoApp_HomePage;
import PageClasses.DemoApp_SignInPage;
import PageClasses.DemoApp_SignUpPage;
import Utilities.ExcelUtility;
import Utilities.FakerUility;

public class DemoApp_TestCases extends BaseClass {
	WebDriver driver;
	FileInputStream fis;
	Properties prop;
	DemoApp_SignInPage signIn_Page;
	DemoApp_SignUpPage signUp_page;
	DemoApp_HomePage home_Page;
	ExcelUtility excel_Utility;
	FakerUility fake_Utility;

	@BeforeMethod(alwaysRun = true)
	
	@Parameters({ "Browser" })
	public void initialization(String browser) throws Exception {

		driver = browserIntialization(browser);
		fis = new FileInputStream(
				"C:\\Users\\anagh\\DemoWebApp_Beeone\\src\\test\\resources\\TestData\\testdata.properties");
		prop = new Properties();
		prop.load(fis);

		driver.get(prop.getProperty("default_url"));

		signIn_Page = new DemoApp_SignInPage(driver);
		signUp_page = new DemoApp_SignUpPage(driver);
		home_Page = new DemoApp_HomePage(driver);
		excel_Utility = new ExcelUtility();
		fake_Utility = new FakerUility();

	}

	@Test
	public void registerUser() throws IOException, AWTException {
		String firstName = excel_Utility.getString(1, 0, excelFilePath, "BeeOne_signUp");
		String lastName = excel_Utility.getString(1, 1, excelFilePath, "BeeOne_signUp");
		String emailId = excel_Utility.getString(1, 2, excelFilePath, "BeeOne_signUp");
		String password = excel_Utility.getString(1, 3, excelFilePath, "BeeOne_signUp");
		String confirmPassword = excel_Utility.getString(1, 4, excelFilePath, "BeeOne_signUp");

		home_Page.clickOnSignUp();
		signUp_page.enterFirstName(firstName);
		signUp_page.enterLastName(lastName);
		signUp_page.enterEmailId(fake_Utility.randomNumberCreation() + emailId);
		signUp_page.enterPassword(password);
		signUp_page.enterConfirmPassword(confirmPassword);
		signUp_page.clickOnSubmit();

		String url = driver.getCurrentUrl();

		Assert.assertEquals(url, prop.getProperty("url_signUp"));

	}

	@Test(dataProvider = "login_Details")
	public void loginUsingdataProvider(String userName, String passWord) {

		driver.get(prop.getProperty("loginUrl"));
		signIn_Page.clickSignInButton();
		signIn_Page.enterEmailId(userName);
		signIn_Page.enterPassword(passWord);
		signIn_Page.clickOnLogIn();

		String url = home_Page.getUrl();

		if (url.equalsIgnoreCase(prop.getProperty("url"))) {
			Assert.assertEquals(home_Page.isLogOutButtonPresent(), true);
		} else {
			Assert.assertEquals(signIn_Page.isAlertDisplayed(), true);
		}

	}

	@Test
	public void verifyOptionClickable() {
		home_Page.clickOnSignIn();
		signIn_Page.enterEmailId(prop.getProperty("username"));
		signIn_Page.enterPassword(prop.getProperty("password"));
		signIn_Page.clickOnLogIn();

		home_Page.clickBlogButton();
		home_Page.clickOnOption();

		Assert.assertEquals(home_Page.isOptionClickable(), true);

	}

	@Test
	public void logOutFunction() {
		home_Page.clickOnSignIn();
		signIn_Page.enterEmailId(prop.getProperty("username"));
		signIn_Page.enterPassword(prop.getProperty("password"));
		signIn_Page.clickOnLogIn();

		home_Page.clickOnlogOut();

		String url = driver.getCurrentUrl();

		Assert.assertEquals(url, prop.getProperty("default_url"));

	}

	@Test
	public void forgotPassword() {
		home_Page.clickOnSignIn();
		signIn_Page.clickForgotPassword();
		String url = driver.getCurrentUrl();

		Assert.assertEquals(url, prop.getProperty("url_reset"));

	}

	@Test
	public void navigateToSignUpFromSignIn() {
		home_Page.clickOnSignIn();
		signIn_Page.clickRegisterNow();
		String url = driver.getCurrentUrl();

		Assert.assertEquals(url, prop.getProperty("url_signUp"));
	}

	@DataProvider(name = "login_Details")
	public Object[][] testData() throws IOException {

		Object[][] login_data = new Object[3][2];

		prop = new Properties();
		fis = new FileInputStream(
				"C:\\Users\\anagh\\DemoWebApp_Beeone\\src\\test\\resources\\TestData\\testdata.properties");
		prop = new Properties();
		prop.load(fis);

		login_data[0][0] = prop.getProperty("user1");
		login_data[0][1] = prop.getProperty("password1");
		login_data[1][0] = prop.getProperty("user2");
		login_data[1][1] = prop.getProperty("password2");
		login_data[2][0] = prop.getProperty("user3");
		login_data[2][1] = prop.getProperty("password3");

		return login_data;
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
