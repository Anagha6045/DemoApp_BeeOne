package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.PageUtility;

public class DemoApp_HomePage {
	WebDriver driver;

	PageUtility pageUtility =new PageUtility();
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logOutButton;
	
	@FindBy(xpath = "//a[text()='Signup']")
	WebElement signUpButton;
	
	@FindBy(xpath ="//a[text()='Signin']")
	WebElement signInButton;
	

	@FindBy(xpath ="//span[text()='Blogs']")
	WebElement blogButton;
	
	@FindBy(xpath ="//li[text()='Option 1']")
	WebElement optionButton;
	
	public DemoApp_HomePage(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this); 
		
	}
	public String getUrl()
	{
		return pageUtility.getUrlOfThePage(driver);
	}
	public boolean isLogOutButtonPresent()
	{
		return logOutButton.isDisplayed();
	}
	public void clickOnSignUp()
	{
		 signUpButton.click();
	}
	
	public void clickBlogButton()
	{
		blogButton.click();
	}
	public void clickOnSignIn()
	{
		signInButton.click();
	}
	public void clickOnOption()
	{
		optionButton.click();
	}
	public boolean  isOptionClickable()
	{
		return optionButton.isEnabled();
	}
	public void clickOnlogOut()
	{
		logOutButton.click();
	}

}
