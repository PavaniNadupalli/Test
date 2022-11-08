package stepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.PropertyFileReader;

public class composeGmailStepDef {
	public static WebDriver Driver;
	PropertyFileReader obj = new PropertyFileReader();
	
	@Given ("^Open chrome browser and enter gmail login url$")
	@And("^enter valid login credentials$")
	public void openchromeBrowserAndEnterUrl() throws IOException, InterruptedException {
		
	Properties properties = obj.getProperty();
	Driver = new ChromeDriver();
	Driver.manage().window().maximize();
	Driver.get(properties.getProperty("url"));
	Thread.sleep(2000);
	Driver.findElement(By.id("identifierId")).sendKeys("sampletest.Incubyte@gmail.com");
	Driver.findElement(By.xpath("//span[text() = 'Next']")).click();
	Driver.findElement(By.name("Passwd")).sendKeys("Incubyte@123");
	Driver.findElement(By.id("passwordNext")).click();
	Thread.sleep(2000);
	
}
	
	@When("^Click on compose and enter valid email address$")
	public void enterValidMailAddress() throws InterruptedException
	{
       Driver.findElement(By.xpath("//div[text()='Compose']")).click();
	   Driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("sampletest.Incubyte@gmail.com");
	   Thread.sleep(2000);
	}
	
	@And("^Enter  subject and body as specified$")
	public void subjectAndBody() throws InterruptedException
	{
		Driver.findElement(By.name("subjectbox")).sendKeys("Incubyte");
		Driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("Automation QA test for Incubyte");
		Thread.sleep(2000);
		
	}
	@Then("^click on send button $")
	public void clickOnSend() throws InterruptedException
	{
      Driver.findElement(By.xpath("//div[text()='Send']")).click();
	  Thread.sleep(2000);
	  Driver.quit();
	}
	
}
