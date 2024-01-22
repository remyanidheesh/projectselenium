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

public class NotePage {
	WebDriver driver;
	//@FindBy(locator="value")
		//WebElement elementname;
	
	@FindBy(xpath="//span[text()='Notes']")
	WebElement notes; 
	@FindBy(xpath="//a[text()=' Add note']")
	WebElement addnotes;
	@FindBy(xpath="//input[@name='title']")
	WebElement title;
	@FindBy(xpath="//textarea[@id='description']")
	WebElement description;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement save;
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement close;
	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement searchnotes;
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td[4]//a[1]")
	WebElement edit;
	
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td[2]//a")
	WebElement tablesearch;
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td[4]//a[2]")
	WebElement delete;
	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement deletebttn;
	@FindBy(xpath="//button[@class='close']")
	WebElement close1;
	@FindBy(xpath="//table[@id='note-table']//tr[1]//td[1]")
	WebElement table;
	WaitUtility waitutility;
	ElementUtility elementutility;
	public NotePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this );
		//initialize webelements declared using @FindBY
		waitutility=new WaitUtility(driver);
		elementutility=new ElementUtility(driver);
	}
    
	public String doNote(String titlefield, String descriptionfield,String searchvalue) {
		
		notes.click();
		addnotes.click();
		title.sendKeys(titlefield);
		description.sendKeys(descriptionfield);
		save.click();
		close.click();
		notes.click();
		String actual=search(searchvalue);
		
		return actual;
		
		}
	public String doEdit(String titlefield,String value)
	{
		notes.click();
		searchnotes.sendKeys(titlefield);
		edit.click();
		title.clear();
		title.sendKeys(value);
		save.click();
		close.click();
		notes.click();
		String actual=search(value);
		
		return actual;
		
	}
	public String doDelete(String titlefield)
	{
		notes.click();
		searchnotes.sendKeys(titlefield);
		delete.click();
		deletebttn.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(close1));
		close1.click();
		notes.click();
		searchnotes.sendKeys(titlefield);
		
		String actual=table.getText();
		return actual;
	}
	public String search(String search) 
	{
		waitutility.WaitVisibility(searchnotes);
		searchnotes.sendKeys(search);
		By locator=By.xpath("//table[@id='note-table']//tbody//tr//td//a[contains(text(),'"+search+"')]");
		waitutility.WaitVisibility(locator);
		List<WebElement> notetable=driver.findElements(By.xpath("//table[@id='note-table']//tbody//tr//td//a[contains(text(),'"+search+"')]"));
		waitutility.WaitVisibility(notetable);
	int row=elementutility.getTableDataRowCount(notetable,search);
		String message="";
		if(row!=0) 
		{
			WebElement tableRow=driver.findElement(By.xpath("//table[@id='note-table']//tbody//tr["+row+"]//td[2]"));
			message=tableRow.getText();
			System.out.println(message);
			
		}
		return message;
	}
	public void clickElement()
	{
		notes.click();
	}
}
