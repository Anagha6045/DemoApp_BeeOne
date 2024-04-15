package PageClasses;


import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PageUtility;
import Utilities.WaitUtility;

public class DemoApp_SignUpPage {

	WebDriver driver;
	PageUtility page_Utility = new PageUtility();
	WaitUtility wait_Utility = new WaitUtility();

	@FindBy(id = "name")
	WebElement firstNamefield;
	@FindBy(id = "lastName")
	WebElement lastNamefield;
	@FindBy(id = "email")
	WebElement emailfield;
	@FindBy(id = "password")
	WebElement passwordField;
	@FindBy(id = "confirmPassword")
	WebElement confirmPasswordField;
	@FindBy(xpath = "//button[@type='button']//span")
	WebElement submitButton;
	
	


	public DemoApp_SignUpPage(WebDriver driver) {
	   this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSubmit() 
	{
          
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", submitButton);

	}

	public void enterFirstName(String firstName) {
		firstNamefield.click();
		firstNamefield.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		lastNamefield.sendKeys(lastName);
	}

	public void enterEmailId(String emailId) {
		emailfield.sendKeys(emailId);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void enterConfirmPassword(String password) {
		confirmPasswordField.sendKeys(password);
	}

	
}
