package POMClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.Util1;

public class Login extends Util1{
	
	WebDriver driver;
	
    @FindBy(xpath="//a[@id='login2']")
    private WebElement loginBtn;
    
    @FindBy(xpath="//input[@id='loginusername']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='loginpassword']")
	WebElement password;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement lBtn2;
	
	public Login(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;		
	}	
    
	public void clickOnFirstLoginBtn() {
		loginBtn.click();
	}	
	public void enterUsername() throws IOException {
		username.sendKeys(Util1.getProperty("username"));
	}
	public void enterPassword() throws IOException {
		password.sendKeys(getProperty("password"));
	}
	public void clickOnSecondLoginBtn() {
		lBtn2.click();
	}
    

}
