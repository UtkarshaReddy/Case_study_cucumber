package mystepDef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MyDemo_02_definitions 
{
	WebDriver driver;
	@Given("I am launching the testme application in firefox")
	public void i_am_launching_the_testme_application_in_firefox() 
	{
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		
		System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.24.0-win32\\geckodriver.exe");
		driver =  new FirefoxDriver();
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();	
	}

	@Given("I click on SignIn link")
	public void i_click_on_SignIn_link() 
	{
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new cucumber.api.PendingException();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignIn")));
		driver.findElement(By.linkText("SignIn")).click();
		
	}

	@Then("I provide username {string}")
	public void i_provide_username(String string) 
	{
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='userName']")));
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(string);
		
	}

	@Then("I provide password {string}")
	public void i_provide_password(String string) 
	{
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(string);
		
	}

	@Then("I click on login and verify the login status")
	public void i_click_on_login_and_verify_the_login_status() throws InterruptedException 
	{
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignOut")));
		String expected_title = "Home";
		String actual_title = driver.getTitle();
		Assert.assertEquals(expected_title,actual_title);
		System.out.println("login successful");
		driver.findElement(By.linkText("SignOut")).click();
		Thread.sleep(10000);
		driver.close();
	}
}
