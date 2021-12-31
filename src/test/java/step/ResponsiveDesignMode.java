package step;

import java.io.File;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ResponsiveDesignMode {

	public static void main(String[] args) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/usr/local/chromedriver"))
                .usingAnyFreePort()
                .build();
		
		capabilities.setPlatform(Platform.ANDROID);
		ChromeOptions options = new ChromeOptions();
		
		
		options.merge(capabilities);
		//capability.setResponsiveDesignPlatform(Platform.IPhone);
		
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver(service,options);
		driver.get("https://www.google.com/");

	}

}
