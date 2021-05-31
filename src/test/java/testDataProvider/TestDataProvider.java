package testDataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import pagesClass.BaseClass;


public class TestDataProvider extends BaseClass{

	@DataProvider(name = "data-provider")
	public static Object[][] getTestDataFromExcel(ITestContext context){
		return readExcel();

	}

	@SuppressWarnings({ "null", "unlikely-arg-type" })
	public static Object[][] readExcel() {
		Object[][] data = null;

		ArrayList<Map<String,String>> ar = new ArrayList<>();
		try {
			File f = new File("C:\\Users\\Prakash\\Desktop\\Testdata.xlsx");

			FileInputStream fis = new FileInputStream(f);

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet sh = wb.getSheetAt(0);

			String sName = sh.getSheetName();

			System.out.println(sName);

			int s = sh.getLastRowNum();

			int i =0;
			int runmodeCol = 0;

			ArrayList<String> key = new ArrayList<>();

			ArrayList<String> value = new ArrayList<>();
			
			ArrayList<Integer> runMode = new ArrayList<>();
			
			//To get runmode column number
			for (int j = 0; j<180; j++) {
				Row r = sh.getRow(i);
				Cell c = r.getCell(j);
				if(c==null) {
					break;
				}

				String run = c.getStringCellValue();
				
				if(run.equalsIgnoreCase("Runmode")) {
					runmodeCol = j;
					break;
				}
			}
			
			//To get test case to execute
			for (int k = 0; k<s; k++) {
				Row r = sh.getRow(k+1);
				Cell c = r.getCell(runmodeCol);

				String run = c.getStringCellValue();

				if(run.equalsIgnoreCase("yes")) {
					runMode.add(k+1);
				}
			}
			
			//To get the column headings value
			for (int j = 0; j<180; j++) {

				Row r = sh.getRow(i);
				Cell c = r.getCell(j);
				if(c==null) {
					break;
				}

				r.getLastCellNum();

				String k = c.getStringCellValue();
				
				key.add(k);

			}	
			
			//To get the values for the test data
			for (int k = 0; k<runMode.size(); k++) {
				Hashtable<String, String> table =new Hashtable<String, String>();

				for (int j = 0; j<key.size(); j++) {
					String kk;
					Row r = sh.getRow(runMode.get(k));
					Cell c = r.getCell(j);
					if(c == null) {
						kk = "";
					} else {
						kk = c.getStringCellValue();
					}

					value.add(kk);

				}

				for (int t =0; t<key.size(); t++) {

					table.put(key.get(t), value.get(t));

				}
				value.clear();
				ar.add(k, table);
			}

			data = new Object[ar.size()][1];

			for (int y=0; y<ar.size() ; y++) {

				Hashtable<String, String>table1 = new Hashtable<>(ar.get(y));
				data[y][0] = table1;
			}

		} catch (Exception e) {

		}
		return data;
	}

}
