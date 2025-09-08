//package StepDefinition;
//
//
//import io.cucumber.java.en.*;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import PomRepogetry.LoginPage;
//import factory.BaseClass;
//
//public class PurchaseSteps {
//
//	 WebDriver driver;
//	    LoginPage log;
//	   
//		WebDriverWait wait = BaseClass.getWait();
//    @Given("user is login")
//    public void user_is_login() {
//    	driver=BaseClass.getDriver();
//   	 log =new LoginPage(driver);
//   	log.enteremail("test@example.com");
//   	log.enterpassword("password123");
//    log.clickloginbutton();
//    
//    }
//
//    @And("click add to cart")
//    public void click_add_to_cart() {
//    
//    	    WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(
//    	        By.xpath("//button[contains(text(),'Add To Cart')]")
//    	    ));
//    	    addToCartBtn.click();
//    }
//
//    @Then("validate message")
//    public void validate_message() {
//    	WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(
//    		    By.xpath("//div[text()=' Product Added To Cart ']")
//    		));
//
//    		String message = msg.getText().trim(); 
//    		System.out.println("Validation message: " + message);
//    }
//
//    @And("click to cart")
//    public void click_to_cart() {
//        driver.findElement(By.xpath("//button[contains(text(), 'Cart ')]")).click();
//    }
//
//    @And("click check out")
//    public void click_check_out() {
//        driver.findElement(By.xpath("//button[text()='Checkout']")).click();
//    }
//
//    @And("fill payment option")
//    public void fill_payment_option() {
//    	driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
//    	
//    	WebElement country = BaseClass.getWait().until(
//    		    ExpectedConditions.elementToBeClickable(
//    		        By.xpath("//button[span[contains(normalize-space(),'India')]]")
//    		    )
//    		);
//    		country.click();
//
////    	Actions action= new Actions(driver);
////    	action.sendKeys(Keys.RETURN);
//    	
//       
//    }
//
//    @Then("click place order")
//    public void click_place_order() {
//        WebElement placeOrderBtn = BaseClass.getWait().until(
//            ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Place Order ']"))
//        );
//        placeOrderBtn.click();
//
//       
//    }
//
//    
//    
//}
