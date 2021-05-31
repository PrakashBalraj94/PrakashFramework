package testClass;

import java.util.Hashtable;

import org.testng.ITest;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import abstractClass.AbstractClass;
import testDataProvider.TestDataProvider;

public class MobileWebpage extends AbstractClass implements ITest{

	public Hashtable<String, String> dataTable;

	public static final String BROWSER = "Browser";

	@Factory(dataProviderClass = TestDataProvider.class, dataProvider = "data-provider")
	public MobileWebpage (Hashtable<String, String> table) {
		this.dataTable = table;
	}

	@Test(priority =1)
	public void mobileWebPageFlow() throws Exception {

	}

	@Override
	public String getTestName() {
		// TODO Auto-generated method stub
		return null;
	}

}