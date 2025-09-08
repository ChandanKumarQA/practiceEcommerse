package PomRepogetry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Regiistationpage {
	
	
	WebDriver driver;
	
	public Regiistationpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
		}
	
	
	@FindBy(xpath="//a[text()='Register']")
	WebElement Registation_button;
	
	@FindBy(id="firstName")
	WebElement firstname;
	
	@FindBy(id="lastName")
	WebElement lastname;
	
	
	@FindBy(id="userEmail")
	WebElement email;
	
	@FindBy(id="userMobile")
	WebElement mobileno;
	
	@FindBy(xpath="//select[@formcontrolname='occupation']")
	WebElement occupation;
	
	
	
	@FindBy(id="userPassword")
	WebElement	pasword;
	
	@FindBy(id="confirmPassword")
	WebElement	conformpassword;
	
	
    public void clickRegistattion() {
    	Registation_button.click();
    	
    }
    
    public void enterfirstname(String fname) {
    	firstname.sendKeys(fname);
    }
    
    
    public void enterlastname(String lname) {
    	lastname.sendKeys(lname);
    }
    
    public void entermail(String Email) {
    	email.sendKeys(Email);
    }
    
    public void enterphoneno(String phoneno) {
    	mobileno.sendKeys(phoneno);
    }
    

}
