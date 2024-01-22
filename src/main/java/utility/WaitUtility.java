package utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriver driver;
	public WaitUtility(WebDriver driver)
	{
		this.driver=driver;
	}
	public void WaitVisibility(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void WaitClickable(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void WaitVisibility(By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	public void WaitVisibility(List<WebElement>element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		
	}
	
}
