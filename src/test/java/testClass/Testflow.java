package testClass;

import java.net.MalformedURLException;
import java.util.Hashtable;

import org.openqa.selenium.support.ui.Select;
import org.testng.ITest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import abstractClass.AbstractClass;
import pagesClass.HomePage;
import testDataProvider.TestDataProvider;

public class Testflow extends AbstractClass implements ITest{
	
	public Hashtable<String, String> dataTable;
	
	public static final String BROWSER = "Browser";
	
	//@Factory(dataProviderClass = TestDataProvider.class)
	/*public Testflow (Hashtable<String, String> table) {
		this.dataTable = table;
	}*/
	
	public Testflow (){
		
	}
	
	
	@Test(priority =1)
	public void testExecurionFlow() throws MalformedURLException {
		
		
		initiateBrowser("chrome");
		naviageURL();
		
		HomePage home = new HomePage();
		
		
		
		
		
	}


	@Override
	public String getTestName() {
		// TODO Auto-generated method stub
		return null;
	}

}
