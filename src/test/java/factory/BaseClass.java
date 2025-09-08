package factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

    private static WebDriver driver;
    private static Properties p;
    private static WebDriverWait wait;
    static Logger logger;

    // Initialize browser
    public static void initializeBrowser() throws IOException {
        if (p == null) {
        	FileInputStream fis = new FileInputStream("src/test/resources/SignIn.propeties");

            p = new Properties();
            p.load(fis);
        }

        String browser = p.getProperty("browser");

        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
     // initialize default wait here (10s, you can adjust)
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Getter for driver
    public static WebDriver getDriver() {
        return driver;
    }

    // Getter for properties
    public static String getProperty(String key) {
        return p.getProperty(key);
    }
    
    public static String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	
	public static String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	// Getter for wait
    public static WebDriverWait getWait() {
        return wait;
    }
    
	public static String randomAlphaNumeric()
	{
	String str=RandomStringUtils.randomAlphabetic(5);
	 String num=RandomStringUtils.randomNumeric(10);
	return str+num;
	}
	
	
	public static Logger getLogger() 
	{		 
		logger=LogManager.getLogger(); //Log4j
		return logger;
	}
}
