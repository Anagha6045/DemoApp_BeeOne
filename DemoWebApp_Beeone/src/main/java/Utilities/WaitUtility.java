package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	public void waitForAnElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitFowaitForAnElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForPresenceOfElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); // Set a timeout of 10 seconds
	   element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(null)));
		
	}
}
