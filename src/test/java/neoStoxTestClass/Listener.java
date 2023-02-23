package neoStoxTestClass;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import neoStoxUtility.Utility;

public class Listener extends Base implements ITestListener
{
public void onTestFailure(ITestResult result) 
	{
		try 
		{
			Utility.takesScreenShot(driver, result.getName());
			Reporter.log("TC Failed ", true);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
}
public void onTestSuccess(ITestResult result)
	{
		Reporter.log("TC Passed Name is"+result.getName(), true);
	}
}

