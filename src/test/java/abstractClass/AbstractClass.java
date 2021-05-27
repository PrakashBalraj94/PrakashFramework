package abstractClass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import pagesClass.BrowserHandler;
import pagesClass.Utilities;

public class AbstractClass extends Utilities {
	WebDriver driver;
	
	public void initiateBrowser(String browserName) throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		BrowserHandler br = new BrowserHandler();
		
		cap = br.setDesiredCapabilities(browserName);
		initiateDesktopBrowser("http://192.168.1.10:4444/wd/hub", cap);
		
	}
	
	
	

}
