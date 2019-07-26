package mystepDef;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class MyDemo_01_definitions 
{
	WebDriver driver;
	@Given("Launch the testme application")
	public void launch_the_testme_application() 
	{
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new cucumber.api.PendingException();
		System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.24.0-win32\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();
	}

	@Then("I click on signup button")
	public void i_click_on_signup_button() 
	{
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new cucumber.api.PendingException();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignUp")));
		driver.findElement(By.linkText("SignUp")).click();
	}

	@Then("I enter the  username {string}")
	public void i_enter_the_username(String string) 
	{
	    // Write code here that turns the phrase above into concrete actions
	 //   throw new cucumber.api.PendingException();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='userName']")));
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(string);
	}

	@Then("I enter the  firstname {string}")
	public void i_enter_the_firstname(String string) 
	{
	    // Write code here that turns the phrase above into concrete actions
	 //   throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(string);
	}

	@Then("I enter the  lastname {string}")
	public void i_enter_the_lastname(String string) 
	{
	    // Write code here that turns the phrase above into concrete actions
	 //   throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(string);
	}

	@Then("I enter the  password {string}")
	public void i_enter_the_password(String string) 
	{
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(string);
	}

	@Then("I enter the  confirmpassword {string}")
	public void i_enter_the_confirmpassword(String string) 
	{
	    // Write code here that turns the phrase above into concrete actions
	 //   throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(string);
	}

	@Then("I select the  gender {string}")
	public void i_select_the_gender(String string) 
	{
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("//input[@name='gender']")).sendKeys(string);
	}

	@Then("I enter the  email id {string}")
	public void i_enter_the_email_id(String string) 
	{
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new cucumber.api.PendingException();
		 driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(string);
		
	}

	@Then("I enter the  mobile number {string}")
	public void i_enter_the_mobile_number(String string) 
	{
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys(string);
	}

	@Then("I enter the  dob {string}")
	public void i_enter_the_dob(String string) 
	{
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(string);
	}

	@Then("I enter the address {string}")
	public void i_enter_the_address(String string) 
	{
	    // Write code here that turns the phrase above into concrete actions
	 //   throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys(string);
	}

	@Then("I enter the security question {string}")
	public void i_enter_the_security_question(String string) 
	{
	    // Write code here that turns the phrase above into concrete actions
	 //   throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("//select[@name='securityQuestion']")).sendKeys(string);
	}

	@Then("I enter the answer {string}")
	public void i_enter_the_answer(String string) 
	{
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("//input[@name='answer']")).sendKeys(string);
	}

	@When("I click on register button and verify registration")
	public void i_click_on_register_button_and_verify_registration() throws InterruptedException 
	{
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new cucumber.api.PendingException();
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		Thread.sleep(5000);
	    String actual_msg = driver.findElement(By.xpath("//div[contains (text(),' User Registered Succesfully!!! Please login')]")).getText();
	    String expected_msg = "User Registered Succesfully!!! Please login";
	    System.out.println(expected_msg);
	    System.out.println(actual_msg);
	    Assert.assertEquals(expected_msg,actual_msg);
	    System.out.println("Registration successful");
		Thread.sleep(10000);
	}
}
