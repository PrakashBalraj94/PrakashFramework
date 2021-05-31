package pagesClass;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.apache.bcel.classfile.ConstantObject;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserHandler {

	public DesiredCapabilities cap = new DesiredCapabilities();

	public DesiredCapabilities setDesiredCapabilities(String browserName) {

		switch(browserName.toLowerCase()) {
		case "chrome":
			return returnChromeCapabilities();
		case "chromeipad":
			return returnChromeIpadCapabilities();
		case "chromeandroid":
			return returnChromeAndroidCapabilities();
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
		//options.setBinary("C:/Users/Prakash/Desktop/Selenium/Jars/chromedriver.exe");

		cap.setPlatform(Platform.ANY);
		//cap.setBrowserName(BrowserType.CHROME);
		cap.setJavascriptEnabled(true);

		//cap.setCapability("chrome.binary", "C:/Users/Prakash/Desktop/Selenium/Jars/chromedriver.exe");
		cap.setCapability(ChromeOptions.CAPABILITY, options);

		//cap.setPlatform(Platform.WINDOWS);

		return cap;
	}

	public DesiredCapabilities returnChromeIpadCapabilities() {

		cap = DesiredCapabilities.chrome();

		ChromeOptions options = new ChromeOptions();
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "iPad Pro");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-web-security");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("--no-sandbox");
		options.setExperimentalOption("mobileEmulation", mobileEmulation);
		options.setExperimentalOption("w3c", false);
		cap.setPlatform(Platform.ANY);
		cap.setJavascriptEnabled(true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		return cap;
	}
	
	public DesiredCapabilities returnChromeAndroidCapabilities() {

		cap = DesiredCapabilities.chrome();

		ChromeOptions options = new ChromeOptions();
		Map<String, String> mobileEmulation = new HashMap<String, String>();
		mobileEmulation.put("deviceName", "iPhone X");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-web-security");
		options.addArguments("--allow-running-insecure-content");
		options.addArguments("--no-sandbox");
		options.setExperimentalOption("mobileEmulation", mobileEmulation);
		options.setExperimentalOption("w3c", false);
		cap.setPlatform(Platform.ANY);
		cap.setJavascriptEnabled(true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		return cap;
	}

}
