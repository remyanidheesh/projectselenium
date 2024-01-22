package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.LoginPage;
import page.NotePage;
import page.ProjectPage;
import utility.FakerUtility;

public class ProjectTest extends BaseTest{
  @Test(priority=1,groups= {"regression"},retryAnalyzer = generaltests.Retry.class)
  public void verifyProject() {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	ProjectPage pp = new ProjectPage(driver);
	String actual=pp.doProject("SELENIUM_PROJECT","ADD PROJECTS","SELENIUM_PROJECT");
	String expected="SELENIUM_PROJECT";
	Assert.assertEquals(actual,expected);
  }
  @Test(priority=2,groups= {"regression"},retryAnalyzer = generaltests.Retry.class)
  public void verifySearchProject() {
		LoginPage lp=new LoginPage(driver);
		  lp.doLogin("admin@admin.com","12345678");
		  ProjectPage pp = new ProjectPage(driver);
		pp.clickProjects();
		String actual=pp.search("SELENIUM_PROJECT");
		String expected="SELENIUM_PROJECT";
		Assert.assertEquals(actual,expected);
	}
  @Test(priority=3,groups= {"smoke"})
  public void verifyEdit()
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	ProjectPage pp = new ProjectPage(driver);
	String actual=pp.doEdit("SELENIUM_PROJECT","SELENIUM_PROJECT1");
	String expected="SELENIUM_PROJECT1";
	Assert.assertEquals(actual,expected);
	
	
  }
  @Test(priority=4,groups= {"regression"})
  public void verifyDelete()
  {
	  LoginPage lp=new LoginPage(driver);
	  lp.doLogin("admin@admin.com","12345678");
	  ProjectPage pp = new ProjectPage(driver);
	  String actual=pp.doDelete("SELENIUM_PROJECT1");
	  String expected="No record found.";
	  Assert.assertEquals(actual,expected);
  }
}
