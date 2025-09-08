package PomRepogetry;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;

public class Homepage {
	WebDriver driver;
	public Homepage(WebDriver driver) {
		 this.driver = driver;
		PageFactory.initElements(driver, this);
		
		}
   
	
	@FindBy(tagName = "b")
	List<WebElement> allProd;
	
	@FindBy(xpath="//div[text()=' Product Added To Cart ']")
	WebElement  productaddedmessage;
	
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkout_button;
	
	
	@FindBy(xpath="//b[text()='iphone 13 pro']/../..//button[text()=' Add To Cart']")
	WebElement addtocartiphone;
	
	public void listallelemt() {
		for(WebElement prod:allProd) {
			System.out.println(prod.getText());
		}
	}
	
	public void clickcheckout() {
		checkout_button.click();
	}
	
	public void clickaddtocart() {
		addtocartiphone.click();
	}
	public boolean verifyaddedmessage() {
	boolean messgaesucess = productaddedmessage.isDisplayed();
		Assert.isTrue(messgaesucess, "product added in cart message is not show");
		
		return messgaesucess;
		
		}
	
}
