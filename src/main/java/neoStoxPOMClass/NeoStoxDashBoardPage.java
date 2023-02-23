package neoStoxPOMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import neoStoxUtility.Utility;

public class NeoStoxDashBoardPage 
{
	@FindBy(xpath = "(//a[text()='OK'])[2]") private WebElement popUpOkButton;
	//@FindBy(xpath = "(//a[text()='Close'])[5]") private WebElement popUpCloseButton;
	@FindBy(id = "lbl_username") private WebElement userName;
	@FindBy(xpath = "//span[text()='Logout']") private WebElement logOutButton;
	@FindBy(id="lbl_curbalancetop")private WebElement acbal;
	public NeoStoxDashBoardPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	public void handlePopUp(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(5000);
	if(popUpOkButton.isDisplayed())
	{
	Thread.sleep(500);
	Utility.implicitwait(driver, 1000);
	popUpOkButton.click();
	Reporter.log("Handling Popup Ok button",true);
	Thread.sleep(5000);
	}
	else
	{
		Reporter.log("Pop up Not displayed",true);
	}
	}
	public String getActualUserName()
	{
		String actualUserName = userName.getText();
		Reporter.log("UserName on WebPortal is "+actualUserName ,true);
		return actualUserName;
	}
	public String getBalance()
	{
		String bal = acbal.getText();
		Reporter.log("Ac Balance is"+bal,true);
		return bal;
	}
	public void logOutFromNeoStox() throws InterruptedException
	{
	userName.click();
	Thread.sleep(1000);
	logOutButton.click();
	Reporter.log("Logging out From NeoStox",true);
	}
}
