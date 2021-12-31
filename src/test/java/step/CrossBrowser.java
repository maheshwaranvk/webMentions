package step;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser {
	public static RemoteWebDriver driver;
	
	@Given("Open browser as {string}")
	public void open_browser_as_browser(String browser) {
	    if(browser.equalsIgnoreCase("chrome")) {
	    	WebDriverManager.chromedriver().setup();
	    	driver=new ChromeDriver();
	    }
	    
	    else if(browser.equalsIgnoreCase("firefox")) {
	    	
	    	WebDriverManager.firefoxdriver().setup();
	    	driver=new FirefoxDriver();
	    }
	    
	    else if(browser.equalsIgnoreCase("edge")) {
	    	
	    	WebDriverManager.edgedriver().setup();
	    	driver = new EdgeDriver();
	    }
	}

	@Given("Load Google Url")
	public void load_google_url() {
	    driver.get("https://www.google.com/");
	    
	}

	@Then("Google Url should open")
	public void google_url_should_open() {
	    String title = driver.getTitle();
	    
	    SoftAssert as = new SoftAssert();
	    boolean equalsIgnoreCase = title.equalsIgnoreCase("Google");
	    as.assertTrue(equalsIgnoreCase);
	}
	
}
