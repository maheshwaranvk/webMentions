package step;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class leaftapsLeadStep {
	String text ;
	RemoteWebDriver driver ;
	String originalID;
	String duplicateID;
	
	SoftAssert as = new SoftAssert();
	
	@Given("Launch the Chrome Browser")
	public void launch_the_chrome_browser() {
	    WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@Given("Load the link")
	public void load_the_link() {
	    driver.get("http://leaftaps.com/opentaps/control/main");
	}

	@Given("Enter the UserName ID")
	public void enter_the_user_name_id() {
		driver.findElementById("username").sendKeys("DemoSalesManager");
	}

	@Given("Enter the Password")
	public void enter_the_password() {
		driver.findElementById("password").sendKeys("crmsfa");
	}

	@Given("Click the Login button")
	public void click_the_login_button() {
		driver.findElementByClassName("decorativeSubmit").click();
	}

	@Then("CRM\\/SFA Page should appear")
	public void crm_sfa_page_should_appear() {
	  boolean equalsIgnoreCase = driver.getTitle().equalsIgnoreCase("Leaftaps - TestLeaf Automation Platform");
	  
	  as.assertEquals(equalsIgnoreCase, true, "CRM/SFA Page Appeared");
	}

	@Given("Enther CRM\\/SFA link")
	public void enther_crm_sfa_link() {
		driver.findElementByLinkText("CRM/SFA").click();
	}

	@Then("Leaftaps Home Page should appear")
	public void leaftaps_home_page_should_appear() {
	   boolean equalsIgnoreCase = driver.getTitle().equalsIgnoreCase("My Home | opentaps CRM");
	   
	   as.assertEquals(equalsIgnoreCase, true, "Home Page Appeared");
	}

	@Given("Click Leads")
	public void click_leads() {
		driver.findElementByLinkText("Leads").click();
	}

	@Then("Leaftaps Leads Page should appear")
	public void leaftaps_leads_page_should_appear() {
		 boolean equalsIgnoreCase = driver.getTitle().equalsIgnoreCase("My Leads | opentaps CRM");
		  
		  as.assertEquals(equalsIgnoreCase, true, "My Lead Page Appeared");
	}

	@Given("Click Create Leads")
	public void click_create_leads() {
		driver.findElementByLinkText("Create Lead").click();
	}

	@Then("Leaftaps Create Lead Page should appear")
	public void leaftaps_create_lead_page_should_appear() {
		 boolean equalsIgnoreCase = driver.getTitle().equalsIgnoreCase("Create Lead | opentaps CRM");
		  
		  as.assertEquals(equalsIgnoreCase, true, "Create Lead Page Appeared");
	}

	@Given("Enter companyName as {string}")
	public void enter_company_name_as(String cName) {
		driver.findElementById("createLeadForm_companyName").sendKeys(cName);
	}

	@Given("Enter firstName as {string}")
	public void enter_first_name_as(String fName) {
		driver.findElementById("createLeadForm_firstName").sendKeys(fName);
	}

	@Given("Enter lastName as {string}")
	public void enter_last_name_as(String lName) {
		driver.findElementById("createLeadForm_lastName").sendKeys(lName);
	}

	@Given("Click Create Lead button")
	public void click_create_lead_button() {
		driver.findElementByName("submitButton").click();
	}

	@Then("Lead should be created")
	public void lead_should_be_created() {
		 boolean equalsIgnoreCase = driver.getTitle().equalsIgnoreCase("View Lead | opentaps CRM");
		  
		  as.assertEquals(equalsIgnoreCase, true, "Lead Created");
	}
	
	
	@Given("Click FindLeads")
	public void click_find_leads() {
		driver.findElementByXPath("//a[text()='Find Leads']").click();
	}

	@Given("Enter the name in FirstName {string}")
	public void enter_the_name_in_first_name(String name) throws InterruptedException {
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys(name);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
	}

	@Given("Select the First searched Lead")
	public void select_the_first_searched_lead() {
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").click();
		
	}

	@Then("Lead should get open")
	public void lead_should_get_open() {
		boolean equalsIgnoreCase = driver.getTitle().equalsIgnoreCase("View Lead | opentaps CRM");
		  
		  as.assertEquals(equalsIgnoreCase, true, "Lead Opened");
	}

	@Given("Click Edit button")
	public void click_edit_button() {
		driver.findElementByXPath("//a[text()='Edit']").click();
	}

	@Given("Update CompanyName {string}")
	public void update_company_name(String cmpName) {
		driver.findElementById("updateLeadForm_companyName").sendKeys(cmpName);
	}

	@Given("Click Update")
	public void click_update() {
		driver.findElementByXPath("(//input[@name='submitButton' and @class='smallSubmit'])[1]").click();
	}

	@Then("Lead should be updated")
	public void lead_should_be_updated() {
		String text = driver.findElementById("viewLead_companyName_sp").getText();
		System.out.println(text);
	}
	
	@Given("Click Merge Lead")
	public void click_merge_lead() {
		driver.findElementByXPath("//a[text()='Merge Leads']").click();
	}

	@Given("Click the icon in From Lead")
	public void click_the_icon_in_from_lead() {
		driver.findElementByXPath("(//img[@alt='Lookup'])[1]").click();
		
	}

	@Given("Enter the From Lead Name {string}")
	public void enter_the_from_lead_name(String fromName) throws InterruptedException {
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWindow = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(listWindow.get(1));
		//System.out.println(driver.getTitle());
		driver.findElementByXPath("//input[@name='firstName']").sendKeys(fromName);
		
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		text = driver.findElementByXPath("(//a[@class='linktext'])[1]").getText();
		driver.findElementByXPath("(//a[@class='linktext'])[1]").click();
		
		driver.switchTo().window(listWindow.get(0));
	}

	@Given("Click the icon in To Lead")
	public void click_the_icon_in_to_lead() {
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
	}

	@Given("Enter the TO Lead Name {string}")
	public void enter_the_to_lead_name(String toName) throws InterruptedException {

		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listWindow1 = new ArrayList<String>(windowHandles1);
		
		driver.switchTo().window(listWindow1.get(1));
		driver.findElementByXPath("//input[@name='firstName']").sendKeys(toName);
		driver.findElementByXPath("(//button[@class='x-btn-text'])[1]").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		driver.switchTo().window(listWindow1.get(0));
	}

	@Given("Click Merge button")
	public void click_merge_button() {
		driver.findElementByXPath("//a[@class='buttonDangerous']").click();
	}

	@Then("Click Ok in the Alert")
	public void click_ok_in_the_alert() {
		driver.switchTo().alert().accept();
	}

	@Then("Leads should be Merged")
	public void leads_should_be_merged() {
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("//input[@name='id']").sendKeys(text);
		
		driver.findElementByXPath("//button[text()='Find Leads']").click();
	}
	
	@Given("Click Find Lead button")
	public void click_find_lead_button() {
		driver.findElementByXPath("//a[text()='Find Leads']").click();
	}

	@Given("Enter the Lead ID to Delete {string}")
	public void enter_the_lead_id_to_delete(String leadId) throws InterruptedException {
		driver.findElementByXPath("(//label[text()='Lead ID:']/following::input)[1]").sendKeys(leadId);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a").click();
	}

	@Given("Click Delete Lead Button")
	public void click_delete_lead_button() throws InterruptedException {
		driver.findElementByXPath("//a[@class='subMenuButtonDangerous']").click();
		Thread.sleep(2000);
	}

	@Then("Lead should be deleted {string}")
	public void lead_should_be_deleted(String leadId) {
driver.findElementByXPath("//a[text()='Find Leads']").click();
		
		driver.findElementByXPath("//label[text()='Lead ID:']/following::input[1]").sendKeys(leadId);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		String text = driver.findElementByXPath("//div[@class='x-toolbar x-small-editor']//div[1]").getText();
	
		System.out.println(text);
	}
	
	@Given("Click Find Leads Button")
	public void click_find_leads_button() {
		driver.findElementByXPath("//a[text()='Find Leads']").click();
	}

	@Given("Click Email option")
	public void click_email_option() {
		driver.findElementByXPath("(//span[@class='x-tab-strip-inner'])[3]/span").click();
		
	}

	@Given("Enter {string} to it")
	public void enter_to_it(String email) {
		driver.findElementByXPath("//input[@name='emailAddress']").sendKeys(email);
		
	}

	@Given("Click Find Leads button")
	public void click_find_leads_buttons() throws InterruptedException {
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
	}

	@Given("Click first occurance of the lead")
	public void click_first_occurance_of_the_lead() {
		originalID = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a[1]").getText();
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a[1]").click();
	}

	@Given("Click Duplicate Lead button")
	public void click_duplicate_lead_button() {
		driver.findElementByXPath("//a[text()='Duplicate Lead']").click();
		driver.findElementByXPath("//input[@name='submitButton']").click();
		String text = driver.findElementById("viewLead_companyName_sp").getText();
		duplicateID = text.replaceAll("[^0-9]", "");
	}

	@Given("Verify the Lead is duplicated")
	public void verify_the_lead_is_duplicated() throws InterruptedException {
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("//label[text()='Lead ID:']/following::input[1]").sendKeys(originalID);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		String originalName = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a").getText();
		System.out.println(originalName);
		
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		driver.findElementByXPath("//label[text()='Lead ID:']/following::input[1]").sendKeys(duplicateID);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(2000);
		String duplicateName = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a").getText();
		System.out.println(duplicateName);
		
		boolean contentEquals = originalName.contentEquals(duplicateName);
		
		if(contentEquals==true) {System.out.println("Duplicates Completed");}
		else{System.out.println("Duplicates not Completed");}
	}
}
