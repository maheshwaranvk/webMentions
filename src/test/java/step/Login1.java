package step;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Login1 {
	ChromeDriver driver;
	@Given("Open Chrome Browser")
	public void open_chrome_browser() {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	}

	@Given("Load Url")
	public void load_url() {
		
		driver.get("http://leaftaps.com/opentaps/");
	   
	}

	@Given("Give UserName as {string}")
	public void give_user_name_as(String uName) {
		driver.findElementById("username").sendKeys(uName);
	}

	
	  @Given("Give PassWord as {string}") public void give_pass_word_as(String
	  pass) { driver.findElementById("password").sendKeys(pass); }
	 

	@When("Click the Login Button")
	public void click_the_login_button() {
		driver.findElementByClassName("decorativeSubmit").click();
	}

	@Then("Home Page should appear")
	public void home_page_should_appear() {
		  System.out.println("HomePage Appeared");
	}
	

@But("Error Page should appear")
public void error_page_should_appear() {
	System.out.println("ErrorPage Appeared");
}
}
