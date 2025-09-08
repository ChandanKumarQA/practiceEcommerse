package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import PomRepogetry.Regiistationpage;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Registation {
	WebDriver driver = BaseClass.getDriver();
	Regiistationpage reg = new Regiistationpage(driver);
	
BaseClass base=new BaseClass();

	@When("the user clicks on the Register button")
	
	public void the_user_clicks_on_the_register_button() throws InterruptedException {
		BaseClass.getLogger().info("click registation page");
		
		reg.clickRegistattion();
	}

	@When("the user fills in all required values")
	public void the_user_fills_in_all_required_values() {
	   reg.enterfirstname("testqa");
	    reg.enterlastname("qat");
	   reg.entermail(BaseClass.randomAlphaNumeric()+"@gmail.com");
	    driver.findElement(By.id("userMobile")).sendKeys("6827144878");
	   WebElement ocupation = driver.findElement(By.xpath("//select[@formcontrolname='occupation']"));
	   Select ocupationdropdown =new Select(ocupation);
	   ocupationdropdown.selectByVisibleText("Student");
	   driver.findElement(By.xpath("//input[@formcontrolname='gender']")).click();
	   driver.findElement(By.id("userPassword")).sendKeys("Pass@123");
	   driver.findElement(By.id("confirmPassword")).sendKeys("Pass@123");
	   
	   driver.findElement(By.xpath("//input[@formcontrolname='required']")).click();
	   driver.findElement(By.id("login")).click();
	   
	   //driver.quit();
	}

//	@Then("the registration should be successful")
//	public void the_registration_should_be_successful() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("a success message should be displayed")
//	public void a_success_message_should_be_displayed() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

}
