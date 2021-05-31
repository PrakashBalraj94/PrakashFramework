package pagesClass;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass{
	WebDriver driver;
	
	@FindBy(xpath = "//div[@id='nav-tools']//span[text()='Account & Lists']")
	WebElement accountMenu;
	
	@FindBy(xpath = "//div[@id='nav-flyout-ya-signin']//span[text()='Sign in']")
	WebElement signInBtn;
	
	@FindBy(id = "ap_email")
	WebElement emailField;
	
	@FindBy(className ="a-button-input")
	WebElement continueBtn;
	
	@FindBy(id ="ap_password")
	WebElement passwordField;
	
	@FindBy(id = "signInSubmit")
	WebElement signinSubmitBtn;
	
	public HomePage (WebDriver driver, Hashtable<String, String> table) {
		this.driver = driver;
		this.table = table;
		PageFactory.initElements(driver, this);
	}
	
	public void accountLogin(Hashtable<String, String> table) {
		//waitForElementToAppear(accountMenu);
		mouseHover(driver, accountMenu);
		clickElement(driver, signInBtn, "SignIn button clicked", "Failed to click signIn button");
		setElement(driver, emailField, table.get("EmailID"), "Entered value", "Failed to enter value");
		clickElement(driver, continueBtn, "Continue button clicked", "Failed to click continue button");
		setElement(driver, passwordField, table.get("Password"), "Entered value", "Failed to enter value");
		clickElement(driver, signinSubmitBtn, "Signin button clicked", "Failed to click signin button");
		
	}
	
	
	


}
