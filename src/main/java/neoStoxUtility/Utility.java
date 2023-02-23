package neoStoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
	//Excel
	//Wait
	//Screenshot
	//read data from inbuilt Excel
	public static String readFromProperityFile(String key) throws IOException 
	{
		Properties prop =new Properties();
		FileInputStream myFile=new FileInputStream("C:\\Users\\Vishal Irkal\\eclipse-workspace\\August 20 Evening _Selenium\\myProperity.properties");
		prop.load(myFile);
		String value = prop.getProperty(key);
		return value;
	}
	public static String readFromExcel(int row, int cell) throws EncryptedDocumentException, IOException
	{
		File myFile =new File("C:\\Users\\Vishal Irkal\\Desktop\\Ragini Study\\Vishal2.xlsx");
		Sheet mySheet = WorkbookFactory.create(myFile).getSheet("Sheet1");
		String value = mySheet.getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("Reading Data From Excel row is"+row+ "Cell is "+cell,true);
		Reporter.log("Data is "+value,true);
		return value;
	}
	public static void implicitwait(WebDriver driver,int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
	}
	public static void takesScreenShot(WebDriver driver,String v) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Vishal Irkal\\Desktop\\Ragini Study\\Screenshot\\"+v+".png");
		FileHandler.copy(src, dest);
	}
}
