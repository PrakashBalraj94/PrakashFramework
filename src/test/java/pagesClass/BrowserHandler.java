package pagesClass;

import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserHandler {
	
	public DesiredCapabilities cap = new DesiredCapabilities();
	
	public DesiredCapabilities setDesiredCapabilities(String browserName) {
		
		switch(browserName.toLowerCase()) {
		case "chrome":
			return returnChromeCapabilities();
		default:
			return returnChromeCapabilities();
			
		}
		
	}
	
	
	public DesiredCapabilities returnChromeCapabilities() {
		
		cap = DesiredCapabilities.chrome();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-web-security");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("--no-sandbox");
		options.setExperimentalOption("w3c", false);
		
		cap.setPlatform(Platform.ANY);
		cap.setJavascriptEnabled(true);
		
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		return cap;
	}

}
