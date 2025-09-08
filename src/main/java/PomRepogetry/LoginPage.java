package PomRepogetry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		 this.driver = driver;
		PageFactory.initElements(driver, this);
		
		}
	
	
	@FindBy(id="userEmail")
	WebElement Email_textfield;
	
	@FindBy(id="userPassword")
	WebElement Password_textfield;
	
	@FindBy(id="login")
	WebElement login_button;
	
	
	@FindBy(xpath="//div[text()=' Login Successfully ']")
	WebElement  sucessmessage;
	
	
	public void enteremail(String email) {
		Email_textfield.sendKeys(email);
	}
	
	public void enterpassword(String password) {
		Password_textfield.sendKeys(password);
	}
	
	public void clickloginbutton() {
		login_button.click();
	}
	
	public boolean validatemessage() {
		Assert.isTrue(sucessmessage.isDisplayed(),"sucess message is not display");
		return true;
		
	}
}
