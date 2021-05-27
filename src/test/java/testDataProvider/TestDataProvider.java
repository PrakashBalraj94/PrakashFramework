package testDataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestDataProvider {
	
	
	

	public void readExcel() {
		try {
			File f = new File("C:\\Users\\Prakash\\Desktop\\Testdata.xlsx");

			FileInputStream fis = new FileInputStream(f);

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet sh = wb.getSheetAt(0);

			String sName = sh.getSheetName();

			System.out.println(sName);

			int s = sh.getLastRowNum();

			int i =0;

			ArrayList<String> key = new ArrayList<>();

			ArrayList<String> value = new ArrayList<>();

			for (int j = 0; j<=s; j++) {

				Row r = sh.getRow(i);
				Cell c = r.getCell(j);
				
				r.getLastCellNum();

				String k = c.getStringCellValue();
				
				key.add(k);

			}	

			for (int k = 0; k<s; k++) {
				for (int j = 0; j<=s; j++) {
					
					Row r = sh.getRow(k+1);
					Cell c = r.getCell(j);

					String kk = c.getStringCellValue();

					value.add(kk);

				}	
			}
			
			Hashtable<String, String> table = new Hashtable<>();

			for (int t =0; t<key.size(); t++) {
				table.put(key.get(t), value.get(t));
			}

			
		} catch (Exception e) {

		}
	}

}
