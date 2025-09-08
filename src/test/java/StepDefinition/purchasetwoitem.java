package StepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PomRepogetry.LoginPage;
import factory.BaseClass;
import io.cucumber.java.en.*;
public class purchasetwoitem {
	
	WebDriver driver;
    LoginPage log;
    WebDriverWait wait = BaseClass.getWait();
	
	 // ---------- Common Step ----------
    @Given("user is login")
    public void user_is_login() {
    	driver=BaseClass.getDriver();
      	 log =new LoginPage(driver);
      	log.enteremail("test@example.com");
      	log.enterpassword("password123");
       log.clickloginbutton();
        // User login setup is already done in Hook before scenario
        System.out.println("User logged in successfully.");
    }

    // ---------- Scenario 1 & 2 ----------
    @And("click add to cart")
    public void click_add_to_cart() {
        WebElement addToCartBtn = BaseClass.getWait().until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(translate(normalize-space(.),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'add to cart')]")
            )
        );
        addToCartBtn.click();
    }



    @Then("validate message")
    public void validate_message() {
    	WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(
	    By.xpath("//div[text()=' Product Added To Cart ']")
	));

	String message = msg.getText().trim(); 
	System.out.println("Validation message: " + message);
    }

    @And("click to cart")
    public void click_to_cart() {
        WebElement cartBtn = BaseClass.getWait().until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(.,'Cart')]")
            )
        );
        cartBtn.click();
    }



    @And("click check out")
    public void click_check_out() {
        WebElement checkoutBtn = BaseClass.getWait().until(
            ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Checkout']"))
        );
        checkoutBtn.click();
    }

    @And("fill payment option")
    public void fill_payment_option() {
        // Select country input
        WebElement countryInput = BaseClass.getWait().until(
            ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select Country']"))
        );
        countryInput.sendKeys("India");

        // Press Enter
        Actions action = new Actions(BaseClass.getDriver());
        action.sendKeys(Keys.RETURN).perform();

        // Select India from dropdown
        WebElement country = BaseClass.getWait().until(
            ExpectedConditions.elementToBeClickable(By.xpath("//button[span[contains(text(),'India')]]"))
        );
        country.click();
    }

    @And("click place order")
    public void click_place_order() {
        WebElement placeOrderBtn = BaseClass.getWait().until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(.,'Place Order')]")
            )
        );

        // Scroll into view (if needed)
        ((JavascriptExecutor) BaseClass.getDriver()).executeScript("arguments[0].scrollIntoView(true);", placeOrderBtn);

        placeOrderBtn.click();
    }


    // ---------- Scenario 2 Specific ----------
    @And("click view second product")
    public void click_view_second_product() {
        WebElement viewBtn = BaseClass.getWait().until(
            ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='View'])[2]"))
        );

        // Scroll into view before clicking
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewBtn);
        viewBtn.click();
    }

}
