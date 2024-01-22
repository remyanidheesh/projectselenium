package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ElementUtility;
import utility.WaitUtility;

public class ProjectPage {
	WebDriver driver;
	@FindBy(xpath="//span[text()='Projects']")
	WebElement projects;
	@FindBy(xpath="//span[text()='All Projects']")
	WebElement allprojects;
	@FindBy(xpath="//a[@title='Add project']")
	WebElement addprojects;
	@FindBy(xpath="//input[@id='title']")
	WebElement title;
	@FindBy(xpath="//textarea[@id='description']")
	WebElement description;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement save;
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement close;
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchproject;
	
	@FindBy(xpath="//table[@id='project-table']//tbody//tr[1]//td[9]//a[1]")
	WebElement edit;
	@FindBy(xpath="//table[@id='project-table']//tbody//tr[1]//td[2]")
	WebElement tablesearch;
	@FindBy(xpath="//input[@id='title']")
	WebElement title_edit;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement save_edit;
	@FindBy(xpath="//table[@id='project-table']//tbody//tr[1]//td[9]//a[2]")
	WebElement delete;
	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement deletebttn;
	@FindBy(xpath="//button[@class='close']")
	WebElement close1;
	@FindBy(xpath="//table[@id='project-table']//tbody//tr[1]//td[1]")
	WebElement table;
	WaitUtility waitutility;
	ElementUtility elementutility;
	public ProjectPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		waitutility=new WaitUtility(driver);
		elementutility=new ElementUtility(driver);
	}

public String doProject(String titlefield,String descriptionfield,String search)
{
	projects.click();
	allprojects.click();
	addprojects.click();
	title.sendKeys(titlefield);
	description.sendKeys(descriptionfield);
	save.click();
	close.click();
	projects.click();
	allprojects.click();
	String actual=search(search);
	return actual;
	
}
public String doEdit(String titlefield,String value1)
{
	projects.click();
	allprojects.click();
	searchproject.sendKeys(titlefield);
	edit.click();
	title.clear();
	title.sendKeys(value1);
	save.click();
	close.click();
	projects.click();
	allprojects.click();
	String actual=search(value1);
	return actual;
	
}
public String doDelete(String titlefield)
{
	projects.click();
	allprojects.click();
	searchproject.sendKeys(titlefield);
	delete.click();
	deletebttn.click();
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(100));
	  wait.until(ExpectedConditions.elementToBeClickable(close1));
	  close1.click();
	  projects.click();
		allprojects.click();
		searchproject.sendKeys(titlefield);
	  String actual=table.getText();
	  return actual;
}
public String search(String search) 
{
	waitutility.WaitVisibility(searchproject);
	searchproject.sendKeys(search);
	By locator=By.xpath("//table[@id='project-table']//tbody//tr//td//a[contains(text(),'"+search+"')]");
	waitutility.WaitVisibility(locator);
	List<WebElement> notetable=driver.findElements(By.xpath("//table[@id='project-table']//tbody//tr//td//a[contains(text(),'"+search+"')]"));
	waitutility.WaitVisibility(notetable);
int row=elementutility.getTableDataRowCount(notetable,search);
	String message="";
	if(row!=0) 
	{
		WebElement tableRow=driver.findElement(By.xpath("//table[@id='project-table']//tbody//tr["+row+"]//td[2]"));
		message=tableRow.getText();
		System.out.println(message);
		
	}
	return message;
}
public void clickProjects()
{
	projects.click();
	allprojects.click();
	
}
}