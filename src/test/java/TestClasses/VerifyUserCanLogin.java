package TestClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BaseClasses.Base1;
import POMClasses.Home;
import POMClasses.Login;
import UtilityClasses.Util1;

@Listeners(ListnerClasses.Listener1.class)


public class VerifyUserCanLogin {

	 WebDriver driver=null;
	 Login lp;
	 Home hp;
	 ExtentHtmlReporter extentReporter;
	 ExtentReports report;
	 ExtentTest test;
	 
	
	@BeforeClass
	public void beforeClass() throws IOException 
	{
		extentReporter=Base1.getHtmlReporter();
		report=Base1.getReports();
		test=Base1.getTest("VerifyUserCanLogin");
		driver = Base1.getdriver("chrome");
	}
	
	@BeforeMethod
	public void beforeMethod() 
	{
		lp=new Login(driver);
		hp=new Home(driver);
	}
	
	@Test
	public void verifyUserCanLogin() throws IOException, InterruptedException 
	{
		lp.clickOnFirstLoginBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		lp.enterUsername();
		lp.enterPassword();
		lp.clickOnSecondLoginBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Assert.assertEquals(hp.getProfileName(), "Welcome xyz@example.com");
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException 
	{
		if(result.getStatus()==ITestResult.SUCCESS)
			{
			   test.log(Status.PASS, result.getName()+" test passed");
			}
		else 
		{
			String path = lp.getScreenshot(driver, result.getName());
			test.log(Status.FAIL, result.getName()+" test failed",MediaEntityBuilder.createScreenCaptureFromPath(path).build());		
		}
	}
	
	@AfterClass
	public void afterClass() 
	{
		report.flush();
	}
}
