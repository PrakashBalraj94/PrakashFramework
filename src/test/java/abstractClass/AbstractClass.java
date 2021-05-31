package abstractClass;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import pagesClass.BrowserHandler;
import pagesClass.Utilities;

public class AbstractClass extends Utilities {
		
	public void initiateBrowser(String browserName) {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		BrowserHandler br = new BrowserHandler();
		
		cap = br.setDesiredCapabilities(browserName);
		
		initiateDesktopBrowser(cap);
	}
	
	public void naviageURL(String url) throws InterruptedException {
		
		getDriver().get(url);
		Thread.sleep(2000);
	}
	
	
	

}
