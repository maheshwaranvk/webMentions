package step;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow {

	public RemoteWebDriver driver;
	public String text,text2;
	
	@Given("Load to ServiceNow Application")
	public void load_to_service_now_application() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://dev68594.service-now.com/");
		driver.switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//input[@id='user_name']")));
	}
	
	@Given("Enter UserName here")
	public void enter_user_name_here() {
		driver.findElementById("user_name").sendKeys("admin");
	}

	@Given("Enter Password here")
	public void enter_password_here() {
		driver.findElementById("user_password").sendKeys("India@123");
	}

	@Given("Click Login")
	public void click_login() {
		driver.findElementById("sysverb_login").click();
		driver.switchTo().defaultContent();
	}

	@Then("Check Login Successfull")
	public void check_login_successfull() {
	    
	}

	@Given("Search Incident filter Navigator")
	public void search_incident_filter_navigator() throws InterruptedException {
		driver.findElementById("filter").sendKeys("incident");
		Thread.sleep(5000);
	}

	@Given("Click All")
	public void click_all() {
		driver.findElementByXPath("(//div[@class='sn-widget-list-title' and text()='All'])[2]").click();
	}

	@Given("Click New")
	public void click_new() {
		driver.switchTo().frame("gsft_main");
		driver.findElementById("sysverb_new").click();
	}

	@Then("Create Incident Page should appear")
	public void create_incident_page_should_appear() {
	
		System.out.println(text);
		driver.findElementById("lookup.incident.caller_id").click();
	}

	@Given("Select a Caller from dropdown")
	public void select_a_caller_from_dropdown() throws InterruptedException {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWind = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(listWind.get(1));
		Thread.sleep(2000);
		driver.findElementByXPath("(//a[@class='column_head list_hdrcell table-col-header'])[4]").click();
		driver.findElementByXPath("(//a[@class='glide_ref_item_link'])[1]").click();
		driver.switchTo().window(listWind.get(0));
	}

	@Given("Enter value for short description")
	public void enter_value_for_short_description() {
		driver.switchTo().frame("gsft_main");
		driver.findElementByXPath("//a[@id='lookup.incident.short_description']").click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listWind1 = new ArrayList<String>(windowHandles1);
		
		driver.switchTo().window(listWind1.get(1));
		driver.findElementByXPath("//a[text()='Issue with a web page']").click();
		driver.switchTo().window(listWind1.get(0));
		
		driver.switchTo().frame("gsft_main");
	}

	@Given("Read the incident")
	public void read_the_incident() {
		text = driver.findElementById("incident.number").getAttribute("value");
	}

	@Given("Click on Submit button")
	public void click_on_submit_button() throws InterruptedException {
		driver.findElementById("sysverb_insert").click();
		Thread.sleep(3000);
	}

	@Given("Search the incident number in the list")
	public void search_the_incident_number_in_the_list() {
		driver.findElementByXPath("(//input[@class='form-control'])[1]").sendKeys(text);
		driver.findElementByXPath("(//input[@class='form-control'])[1]").sendKeys(Keys.ENTER);
		text2 = driver.findElementByXPath("//a[@class='linked formlink']").getText();
	}

	@Then("Incident should be created successfully")
	public void incident_should_be_created_successfully() {
		if(text.equalsIgnoreCase(text2)==true) {System.out.println("Incident Created Successfully");}
		

		else { System.out.println("Incident is not created");}
	}
	
}
