package pagesClass;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

public class BaseClass {
	
WebDriver driver;
	
	
	public void clickElement(WebDriver driver, WebElement element, String SuccessMessage, String FailureMessage) {
		
	}
	
	public String getElementText(WebElement element) {
	
		String elementText = element.getText();
		
		return elementText;
	}
	
	public String getElementText(String locator) {
		
		String elementText = driver.findElement(By.xpath(locator)).getText();
		
		return elementText;
	}
	
	public void setElement(WebDriver driver, WebElement element, String value, String SuccesMessage) {
		
		element.click();
		element.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		element.sendKeys(value);
		element.sendKeys(Keys.TAB);
		
		driver.switchTo().window("test");
		System.out.println(driver.getTitle());
		driver.findElement(By.id(""));
		
	}
	
	public void waitForElementToAppear(WebElement element) {
		 
		fluentWait(element);
	}
	
	
	public boolean fluentWait(WebElement element) {
		boolean isPresent = false;
		try {
		Wait<WebDriver> wait = ((FluentWait<WebDriver>) new FluentWait<WebDriver>(driver)
				.until(ExpectedConditions.elementToBeClickable(element)))
				.withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(10, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class, ElementNotVisibleException.class);
		isPresent = true;
		} catch (NoSuchElementException e) {
			isPresent = false;
		}
		return isPresent;
	}

}
