package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	@FindBy(name="email")
	WebElement emailfield;
	@FindBy(name="password")
	WebElement pswfield;
	@FindBy(className="mt15")
	WebElement submit;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	public boolean doLogin(String email,String password)
	{
		emailfield.sendKeys(email);
		pswfield.sendKeys(password);
		submit.click();
		WebElement notelink=driver.findElement(By.xpath("//span[text()='Notes']"));
		boolean isdisplay=notelink.isDisplayed();
		return isdisplay;
		
		
		
		
	}

}
