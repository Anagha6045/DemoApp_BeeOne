package automationCore;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.optional.qual.OptionalBottom;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass {
	
	public WebDriver driver;
	public String excelFilePath="//src//test//resources//TestData//testData.xlsx";
	
	
	
	public WebDriver browserIntialization( String browserName) throws Exception
	{
		if (browserName.equalsIgnoreCase("Chrome"))
		{
	     driver = new ChromeDriver();//chrome

		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();//edge
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();

		}
		else
		{
			throw new Exception("Invalid Name Exception");
		}
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		return driver;

	}


	
	 public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException 
	  { 
         TakesScreenshot ts= (TakesScreenshot)driver;
         File source=ts.getScreenshotAs(OutputType.FILE);
         String destinationFile=System.getProperty("user.dir")+"\\test-output\\"+testCaseName+".png";
         File destination= new File(destinationFile);
         FileUtils.copyFile(source, destination);
         return destinationFile;
		
	  }   
		
		 

}
