package hook;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

    WebDriver driver;

    @Before
    public void navigatetheurl() throws IOException {
        // Initialize browser + properties
        BaseClass.initializeBrowser();
        driver = BaseClass.getDriver();

        String url = BaseClass.getProperty("baseUrl");
        driver.manage().window().maximize();
        driver.get(url);
    }

    @After
    public void closebrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
    
    @AfterStep
    public void addScreenshot(Scenario scenario) {
    	TakesScreenshot ts=(TakesScreenshot) driver;
    	// this is for cucumber junit report
        if(scenario.isFailed()) {
        	
        	
        	byte[] screenshotfaild=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshotfaild, "image/png",scenario.getName());
        }
        	else {

        		byte[] screenshotpass=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshotpass, "image/png",scenario.getName());
        	}
      
    }
}
