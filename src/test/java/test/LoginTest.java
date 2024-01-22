package test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import page.LoginPage;
import utility.ExcelRead;

public class LoginTest extends BaseTest {
  @Test(dataProvider = "dp")
  public void verify(String username,String password) {
	  LoginPage lp=new LoginPage(driver);
	  boolean value=lp.doLogin("admin@admin.com","12345678");
	  Assert.assertTrue(value);
  }
  
  @DataProvider
  public Object[][] dp() throws InvalidFormatException, IOException {
	 Object [][] data= ExcelRead.getDataFromExcel(Constant.excelPath, 
				"Sheet1");
	 return data;
  }
  
}
