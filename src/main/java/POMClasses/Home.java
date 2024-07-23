package POMClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	
WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'Welcome')]")
	WebElement welcome;
	
	public Home(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public String getProfileName() throws InterruptedException
	{
		Thread.sleep(1000);
		String pName=driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).getText();
		return pName;
	}
	

}
