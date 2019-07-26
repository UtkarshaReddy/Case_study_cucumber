package mystepDef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MyDemo_04_definition 

{
	WebDriver driver;
	@Given("Alex has registered in to TestMeApp")
	public void alex_has_registered_in_to_TestMeApp() throws InterruptedException 
	{
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.24.0-win32\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize(); 
//		WebDriverWait wait = new WebDriverWait(driver,60);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignUp")));
//		driver.findElement(By.xpath("//a[contains (text( ),'SignUp')]")).click();
//		Thread.sleep(5000);
//	    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("fgmnzxnp");
//	    driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("fvjcgBdv");
//	    Thread.sleep(10000);
//		String actual_text = driver.findElement(By.xpath("//span[text()='Available']")).getText();
//		String expected_text = "Available";
//	    System.out.println(expected_text);
//	    System.out.println(actual_text);	   
//		Assert.assertEquals(expected_text,actual_text);
//		    driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("dfbghdh");
//		    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mnbvcxz");
//		    driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("mnbvcxz");
//		    driver.findElement(By.xpath("//input[@value='Male']")).click();
//		    driver.findElement(By.xpath("//input[@name='mobileNumber']")).sendKeys("9239867890");
//		    driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("nzdhjzrzdn@gmail.com");
//		    driver.findElement(By.xpath("//input[@name='dob']")).sendKeys("07/17/2019");
//		    driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys(" ffgrtdjtjtgjfyjfg");
//		    WebElement question =  driver.findElement(By.xpath("//select[@name='securityQuestion']"));
//		    Select Ques1 = new Select(question);
//			Ques1.selectByIndex(1);
//		    driver.findElement(By.xpath("//input[@name='answer']")).sendKeys("Black");
//		    driver.findElement(By.xpath("//input[@name='Submit']")).click();
//		    Thread.sleep(5000);
//		    String actual_msg = driver.findElement(By.xpath("//div[contains (text(),' User Registered Succesfully!!! Please login')]")).getText();
//		    String expected_msg = "User Registered Succesfully!!! Please login";
//		    System.out.println(expected_msg);
//		    System.out.println(actual_msg);  
//		    Assert.assertEquals(expected_msg,actual_msg);
//		    System.out.println("Registration successful");
//			Thread.sleep(10000);
			WebDriverWait wait1 = new WebDriverWait(driver,60);
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignIn")));
			driver.findElement(By.linkText("SignIn")).click();
			driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("fgmnzxc");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mnbvcxz");
			driver.findElement(By.xpath("//input[@name='Login']")).click();
			WebDriverWait wait2 = new WebDriverWait(driver,60);
			wait2.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignOut")));
			String expected_title = "Home";
			String actual_title = driver.getTitle();
			Assert.assertEquals(expected_title,actual_title);
			System.out.println("login successful");
			Thread.sleep(10000);		
	}

	@When("Alex search a particular product like headphones")
	public void alex_search_a_particular_product_like_headphones() throws InterruptedException 
	{
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		  WebDriverWait wait1 = new WebDriverWait(driver,60);
		  wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains (text(),'Categories')]")));
		  driver.findElement(By.xpath("//input[@id='myInput']")).sendKeys("Head");
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@When("Try to proceed to payment without adding any item in the cart")
	public void try_to_proceed_to_payment_without_adding_any_item_in_the_cart() throws InterruptedException 
	{
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new cucumber.api.PendingException();
//		  WebDriverWait wait = new WebDriverWait(driver,60);
//		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='displayCart.htm']")));
		  System.out.println("payment");
  
	}

	@Then("TestMeApp doesn't display the cart icon")
	public void testmeapp_doesn_t_display_the_cart_icon() 
	{
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		String expected_title = "Cart1";
		String actual_title = driver.findElement(By.xpath("//a[@href='displayCart.htm']")).getText();
		System.out.println(expected_title);
		System.out.println(actual_title);
		
		
		
	}
}
