package pagesClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utilities {
	
	WebDriver driver;
	
	//public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
	public void initiateDesktopBrowser(String gridURL , DesiredCapabilities cap) throws MalformedURLException {
		setDriver(gridURL, cap);
		
	}
	
	public void setDriver(String gridURL , DesiredCapabilities cap) throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prakash\\Desktop\\Selenium\\Jars\\chromedriver.exe");
		//driver.set(new RemoteWebDriver(new URL(gridURL), cap));
		driver = new ChromeDriver();
		
	}
	
	public WebDriver getDriver() {
		return driver;
		
	}
	

	public void naviageURL() {
		driver.get("https://www.amazon.in/");
	}
	
	

}
