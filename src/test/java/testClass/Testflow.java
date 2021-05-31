package testClass;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Hashtable;

import org.openqa.selenium.support.ui.Select;
import org.testng.ITest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import abstractClass.AbstractClass;
import pagesClass.HomePage;
import testDataProvider.TestDataProvider;

public class Testflow extends AbstractClass implements ITest{
	
	public Hashtable<String, String> dataTable;
	
	public static final String BROWSER = "Browser";
	
	@Factory(dataProviderClass = TestDataProvider.class, dataProvider = "data-provider")
	public Testflow (Hashtable<String, String> table) {
		this.dataTable = table;
	}

	@Test(priority =1)
	public void testExecutionFlow() throws Exception {
		
		System.out.println(dataTable);
		initiateBrowser(dataTable.get(BROWSER));
		naviageURL(dataTable.get("URL"));
		
		HomePage home = new HomePage(getDriver(), dataTable);
		
		home.accountLogin(dataTable);
		
	}
	
	@AfterClass
	public void tearDown(){
		getDriver().quit();
	}


	@Override
	public String getTestName() {
		// TODO Auto-generated method stub
		return null;
	}

}
