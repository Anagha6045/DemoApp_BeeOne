package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class DemoApp_SignInPage 
{
WebDriver driver;

PageUtility pageUtility =new PageUtility();

@FindBy(id = "email")
WebElement emailField;

@FindBy(id = "password")
WebElement passwordField;

@FindBy(linkText = "forgot password")
WebElement forgotPasswordButton;

@FindBy(linkText = "register now!")
WebElement registerButton;


@FindBy(xpath = "//span[text()='Log in']//parent::button")
WebElement logInButton;

@FindBy(xpath ="//a[text()='Signin']")
WebElement signInButton;

@FindBy(xpath = "//p[text()='Check out your Account or Password again']")
WebElement alertMessage;



public  DemoApp_SignInPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this); 
}


public void enterEmailId(String emailId) {
	emailField.sendKeys(emailId);
}

public void enterPassword(String password) {
	passwordField.sendKeys(password);
}

public void clickOnLogIn() {
	logInButton.click();
}

public void clickRegisterNow()
{
	registerButton.click();
}
public void clickForgotPassword()
{
	forgotPasswordButton.click();
}

public void clickSignInButton()
{
	logInButton.click();
}

public boolean isAlertDisplayed()
{
	return alertMessage.isDisplayed();
}
}
