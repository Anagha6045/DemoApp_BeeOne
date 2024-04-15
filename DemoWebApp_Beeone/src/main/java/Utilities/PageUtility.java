package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUtility {
	
	//browser commands
	public  void loadPage(WebDriver driver,String url)
	{
	 driver.get(url);
	}
	public String getTitleOfThePage(WebDriver driver)
	{
		return driver.getTitle();
	}
	public String getUrlOfThePage(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}
	public  void closeTheTab(WebDriver driver)
	{
		 driver.close();
	}
	public void closeAllTabs(WebDriver driver)
	{
		 driver.quit();
	}


	//navigation commands
	public  void navigateTo(WebDriver driver,String url)
	{
		driver.navigate().to(url);
	}
	public void navigateBack(WebDriver driver)
	{
		driver.navigate().back();
	}
	public void navigateForward(WebDriver driver)
	{
		driver.navigate().forward();
	}
	public void refreshPage(WebDriver driver)
	{
		driver.navigate().refresh();
	}


	//webElement commands
	public void ClearTheField(WebElement element)
	{
		element.clear();
	}

	public void clickOnElement(WebElement element)
	{
		element.click();
	}
	public void enterText(WebElement element, String value)
	{
		element.sendKeys(value);
	}
	public void enterNumber(WebElement element,  CharSequence[] value)
	{
		element.sendKeys(value);
		
	}
	public boolean isElementDisplayed(WebElement element)
	{
		return element.isDisplayed();
	}
	public boolean isElementEnabled(WebElement element)
	{
		return element.isEnabled();
	}
	public boolean isElementSelected(WebElement element)
	{
		return element.isSelected();
	}
	public void submitPage(WebElement element)
	{
	 element.submit();
	}

	public String getTextFromElement(WebElement element)
	{
		return element.getText();
	}

	public String getAttributeValue(WebElement element,String attributeName)
	{
		return element.getAttribute(attributeName);
	}
	public String getTagnameElement(WebElement element)
	{
		return element.getTagName();
	}

    public void clickByJavaScript(WebElement element, WebDriver driver) 
{
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("arguments[0].click();", element);
}
}
