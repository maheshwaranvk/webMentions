package step;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	ChromeDriver driver;
	@Given("Launch the Browser")
	public void launch_the_browser() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    
	}

	@Given("Load the URL")
	public void load_the_url() {
	 driver.get("http://leaftaps.com/opentaps/");
	}

	@Given("Enter UserName")
	public void enter_user_name() {
		driver.findElementById("username").sendKeys("DemoSalesManager");
		
	}

	@Given("Enter Password")
	public void enter_password() {
		driver.findElementById("password").sendKeys("crmsfa");
	}

	@When("Click on Login Button")
	public void click_on_login_button() {
		driver.findElementByClassName("decorativeSubmit").click();
	}

	@Then("HomePage should be displayed")
	public void home_page_should_be_displayed() {
	    System.out.println("HomePage Appeared");
	}
}
