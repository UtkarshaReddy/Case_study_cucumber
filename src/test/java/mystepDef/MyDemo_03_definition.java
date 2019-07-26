package mystepDef;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MyDemo_03_definition 
{
	WebDriver driver;
	@Given("Launch the testmeapp application")
	public void launch_the_testmeapp_application() 
	{
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		System.setProperty("webdriver.gecko.driver","C:\\Drivers\\geckodriver-v0.24.0-win32\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://10.232.237.143:443/TestMeApp");
		driver.manage().window().maximize();
		
	}

	@Then("Login to testmeapp application")
	public void login_to_testmeapp_application() throws InterruptedException 
	{
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignIn")));
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("fgmnzxc");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mnbvcxz");
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		WebDriverWait wait1 = new WebDriverWait(driver,60);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignOut")));
		String expected_title = "Home";
		String actual_title = driver.getTitle();
		Assert.assertEquals(expected_title,actual_title);
		System.out.println("login successful");
		Thread.sleep(10000);		
	}

	@Then("Searches for a product in the search bar")
	public void searches_for_a_product_in_the_search_bar() throws InterruptedException 
	{
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		  WebDriverWait wait1 = new WebDriverWait(driver,60);
		  wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains (text(),'Categories')]")));
		  driver.findElement(By.xpath("//input[@id='myInput']")).sendKeys("Head");
		  driver.findElement(By.xpath("//input[@type='submit']")).click();
		  WebDriverWait wait = new WebDriverWait(driver,60);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Add to cart')]")));
		  String p_name1 = driver.findElement(By.xpath("//p[text()='Blue tooth head phone']")).getText();
		  System.out.println(p_name1);
		  driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
		  String p_name2 = driver.findElement(By.xpath("//p[text()='Blue tooth head phone']")).getText();
		  System.out.println(p_name2);
		  Assert.assertEquals(p_name1,p_name2);
		  System.out.println("Added to cart"); 	
		  
	}

	@Then("Makes payment and order is placed")
	public void makes_payment_and_order_is_placed() throws InterruptedException 
	{
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		  WebDriverWait wait = new WebDriverWait(driver,60);
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='checkout.htm']")));
		  driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();
		  driver.findElement(By.xpath("//textarea[@id='add1']")).sendKeys(" ffgrthdjtNJVGjtgjfyjfg");
		  driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
		  Thread.sleep(5000);
//		  JavascriptExecutor js = (JavascriptExecutor) driver;
//		  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	//	  Thread.sleep(5000);
		  driver.findElement(By.xpath("//label[text()='Andhra Bank']")).click();
		  driver.findElement(By.xpath("//a[@id='btn']")).click();
		  WebDriverWait wait2 = new WebDriverWait(driver,60);
		  wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='username']")));
		  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456");
		  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@456");
		  driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		  WebDriverWait wait3 = new WebDriverWait(driver,60);
		  wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='transpwd']")));
		  Thread.sleep(10000);
		  driver.findElement(By.xpath("//input[@name='transpwd']")).sendKeys("Trans@456");
		  driver.findElement(By.xpath("//input[@value='PayNow']")).click();
		  Thread.sleep(10000);
		  String order1_title = driver.findElement(By.xpath("//p[contains (text(),'Your')]")).getText();
		  System.out.println(order1_title);
		  String order2_title = "Your order has been confirmed";
		  System.out.println(order2_title);
		  Assert.assertEquals(order1_title,order2_title);
		  System.out.println("ordered succesfully");
		  WebDriverWait wait4 = new WebDriverWait(driver,60);
		  wait4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='logout.htm']")));
		  driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
		  Thread.sleep(10000);
		  driver.close();
	}

}
