package neoStoxTestClass;

import org.testng.annotations.Test;
import neoStoxPOMClass.NeoStoxDashBoardPage;
import neoStoxPOMClass.NeoStoxHomePage;
import neoStoxPOMClass.NeoStoxPasswordPage;
import neoStoxPOMClass.NeoStoxSignInPage;
import neoStoxUtility.Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
@Listeners(neoStoxTestClass.Listener.class)

public class ValidateUserNameUsingProperityFile extends Base
{
	NeoStoxDashBoardPage dash;
	NeoStoxPasswordPage Pass;
	NeoStoxSignInPage Signin;
	NeoStoxHomePage Home;
	
	
@BeforeClass
  public void launchBrowswer() throws IOException 
	{
		launchBrowser();
		Home = new NeoStoxHomePage(driver);
		Signin = new NeoStoxSignInPage(driver);
		Pass = new NeoStoxPasswordPage(driver);
		dash = new NeoStoxDashBoardPage(driver);
	}
	
@BeforeMethod
  public void loginToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		Signin.clickOnSignInButton();
		Utility.implicitwait(driver, 1000);
		Signin.enterMobileNumber(Utility.readFromProperityFile("mobile"));
		Signin.clickOnSignInButton();
		Pass.enterPassword(Utility.readFromProperityFile("password"));
		Pass.clickOnSubmitButton();
		dash.handlePopUp(driver);
	}
// This is Test Method or test case
	@Test
  public void validateUserName() throws EncryptedDocumentException, IOException 
	{
		//Assert.fail();
		Assert.assertEquals(dash.getActualUserName(), Utility.readFromProperityFile("username"));
		Reporter.log("UserName is matching", true);
		//Utility.takesScreenShot(driver, Utility.readFromProperityFile("TCID"));
		// Line no 60 is all about reading data from properity file
	}
	
	
// This test case is for checking account balance is null or not
	@Test
public void validateAcBal() throws IOException
	{
		Assert.assertNotNull(dash.getBalance(), "Ac Balance is null TC Failed");
		//Utility.takesScreenShot(driver,Utility.readFromProperityFile("TCID1"));
		// Line no 67 is all about reading data from properity file
	}
	
	
	
@AfterMethod
public void logoutFromNeoStox() throws InterruptedException
  {
	  dash.logOutFromNeoStox();
  }
@AfterClass
  public void closingBrowser() 
  {
    	driver.close();
  }

}
