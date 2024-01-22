package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import constant.Constant;
import utility.ElementUtility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseTest {
	WebDriver driver;
	@Parameters({"browser"})
	  @BeforeMethod (alwaysRun = true)
	//Is used when we want to make sure this always runs even if parameters on which this depends fails
	  public void beforeTest(@Optional ("chrome") String browser) throws IOException {
		 if(browser.equalsIgnoreCase("chrome"))
		  {
			  driver=new ChromeDriver();
		  }
		  else if(browser.equalsIgnoreCase("edge"))
		  {
			  driver=new EdgeDriver();
		  }
 
  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
	  driver.manage().window().maximize();
	  driver.get(ElementUtility.readPropertiesFile("url"));
  
	}
  @AfterMethod
  public void afterMethod(ITestResult result)
  		
  {
	  
	  if(ITestResult.FAILURE==result.getStatus())
	  {
		  try{
				
				
				TakesScreenshot screenshot=(TakesScreenshot)driver;
				String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new java.util.Date());
				String methodName=result.getMethod().getMethodName();
			
				File srcfile=screenshot.getScreenshotAs(OutputType.FILE);
				String path=Constant.screenshotpath+methodName+date+".png";
				File desfile=new File(path);
				FileUtils.copyFile(srcfile,desfile);
				System.out.println("Successfully captured a screenshot");
				
			}
		  catch (Exception e){
				System.out.println("Exception while taking screenshot "+e.getMessage());
			
	  }

	  }
	  
  }}

  


