package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.LoginPage;
import page.NotePage;

public class NoteTest extends BaseTest {
	@Test(priority=1,groups= {"regression"})
	public void verifyNote() {
		LoginPage lp=new LoginPage(driver);
		  lp.doLogin("admin@admin.com","12345678");
		NotePage np = new NotePage(driver);
		String actual=np.doNote("SELENIUM_NOTE", "ADD NOTES","SELENIUM_NOTE");
		String expected="SELENIUM_PROJECT";
		Assert.assertEquals(actual,expected);
	}
	@Test(priority=2,groups= {"regression"})
	public void verifySearchNote() {
		LoginPage lp=new LoginPage(driver);
		  lp.doLogin("admin@admin.com","12345678");
		NotePage np = new NotePage(driver);
		np.clickElement();
		String actual=np.search("SELENIUM_NOTE");
		String expected="SELENIUM_NOTE";
		Assert.assertEquals(actual,expected);
	}
	@Test(priority=3,groups= {"smoke"})
	public void verifyEdit() {
		LoginPage lp=new LoginPage(driver);
		  lp.doLogin("admin@admin.com","12345678");
		NotePage np = new NotePage(driver);
		
		String actual=np.doEdit("SELENIUM_NOTE","SELENIUM_NOTE1");
		String expected="SELENIUM_NOTE1";
		Assert.assertEquals(actual, expected);
		
	}
	@Test(priority=4,groups= {"regression"})
	public void verifyDelete() {
		LoginPage lp=new LoginPage(driver);
		  lp.doLogin("admin@admin.com","12345678");
		NotePage np = new NotePage(driver);
		String actual=np.doDelete("SELENIUM_NOTE1");
		String expected="No record found.";
		Assert.assertEquals(actual,expected);
	}
	
	
}
