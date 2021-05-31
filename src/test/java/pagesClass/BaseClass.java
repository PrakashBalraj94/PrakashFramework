package pagesClass;

import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.LoggerFactory;

public class BaseClass {
	
	public Hashtable<String, String> table;
	
	public static Logger log = Logger.getLogger(BaseClass.class);
	
	public static org.slf4j.Logger logger = LoggerFactory.getLogger("testLogger");
	
	
	WebDriver driver;

	public void clickElement(WebDriver driver, WebElement element, String SuccessMessage, String FailureMessage) {
		try {
			//fluentWait(driver, element);
			Thread.sleep(1000);
			highlightElement(driver, element);
			//Thread.sleep(1000);
			element.click();
			logger.info(SuccessMessage);
			
		} catch(Exception e) {
			logger.info(FailureMessage);
		}
	}

	public String getElementText(WebElement element) {

		String elementText = element.getText();

		return elementText;
	}

	public String getElementText(String locator) {

		String elementText = driver.findElement(By.xpath(locator)).getText();

		return elementText;
	}

	public void setElement(WebDriver driver, WebElement element, String value, String successMessage, String failureMessage) {
		try {
			highlightElement(driver, element);
			element.click();
			element.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
			element.sendKeys(value);
			logger.info(successMessage);
		} catch (Exception e) {
			logger.info(failureMessage);
		}
	}

	public void waitForElementToAppear(WebElement element) {
		long startTime = System.currentTimeMillis();
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
			wait.withTimeout(10, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS)
			.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			long endTime = System.currentTimeMillis();
			Long totalTime = endTime - startTime;
			System.out.println("total time: : "+TimeUnit.MILLISECONDS.toSeconds(totalTime));
		} catch (Exception e) {
			long endTime = System.currentTimeMillis();
			Long totalTime = endTime - startTime;
			System.out.println("Element not visible : "+TimeUnit.MILLISECONDS.toSeconds(totalTime));
		}

	}

	public void fluentWait(WebDriver driver, WebElement element) {
			Wait<WebDriver> wait = ((FluentWait<WebDriver>) new FluentWait<WebDriver>(driver)
					.until(ExpectedConditions.elementToBeClickable(element)))
					.withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(10, TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class, ElementNotVisibleException.class)
					.ignoring(StaleElementReferenceException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public void highlightElement(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("arguments[0].setAttribute('style','border: solid 5px blue')", element);

	}

}
