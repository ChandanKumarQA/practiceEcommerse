package StepDefinition;


import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import PomRepogetry.LoginPage;
import factory.BaseClass;

public class LoginSteps {

    WebDriver driver;
    LoginPage log;
    
    

    @Given("the user is on the login page")
    public void the_user_is_on_login_page() {
    	driver=BaseClass.getDriver();
    	 log =new LoginPage(driver);
       
    }

    @When("the user enters a valid email")
    public void the_user_enters_valid_email() {
    	log.enteremail("test@example.com");
       
    }

    @When("the user enters a valid password")
    public void the_user_enters_valid_password() {
    	log.enterpassword("password123");
    }

    @When("the user clicks the login button")
    public void the_user_clicks_login_button() {
        log.clickloginbutton();
    }

    
    @Then("the user should be successfully logged in")
    public void the_user_should_be_successfully_logged_in() {
       
       log.validatemessage();
       
    }
   
}
