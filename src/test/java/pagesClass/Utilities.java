package pagesClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utilities extends BaseClass{
	
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	public void initiateDesktopBrowser(DesiredCapabilities cap) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prakash\\Desktop\\Selenium\\Jars\\chromedriver.exe");
		driver = new ChromeDriver(cap);
		driver.manage().window().maximize();
		
	}
	
	public WebDriver getDriver() {
		return driver;
		
	}
	
}
