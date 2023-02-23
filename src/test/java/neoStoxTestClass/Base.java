package neoStoxTestClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxUtility.Utility;

public class Base 
{
	protected static WebDriver driver;
	public void launchBrowser() throws IOException
	{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vishal Irkal\\Desktop\\Ragini Study\\chromedriver.exe");
	//created object of chromedriver
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	//driver.get("https://neostox.com/");
	driver.get(Utility.readFromProperityFile("url"));
	Reporter.log("Launching Browser",true);
	Utility.implicitwait(driver, 1000);
	}
}
