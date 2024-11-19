package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {
     
	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String[][] loginData() throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\hi\\eclipse-workspace\\modularFramework\\testData\\modular.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
	    XSSFSheet sheet = workbook.getSheet("login");
	    int totalRows = sheet.getLastRowNum();
	    int totalCells = sheet.getRow(1).getLastCellNum();
	    System.out.println(totalCells);
	    System.out.println(totalRows);
	    String [][] data= new String[totalRows][totalCells];
	    for(int r=0; r<totalRows;r++)
	    {
	  for(int c=0; c<totalCells;c++)
	  {
	  DataFormatter df = new DataFormatter();
	  data[r][c] = df.formatCellValue(sheet.getRow(r+1).getCell(c));
	  System.out.println(data[r][c]);
	  }
	  }
	    workbook.close();
	    file.close();
	    return data;
}
	@DataProvider(name="LogoutData")
	public String[][] logoutData() throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\hi\\eclipse-workspace\\modularFramework\\testData\\modular.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
	    XSSFSheet sheet = workbook.getSheet("logout");
	    int totalRows = sheet.getLastRowNum();
	    int totalCells = sheet.getRow(1).getLastCellNum();
	    System.out.println(totalCells);
	    System.out.println(totalRows);
	    String [][] data= new String[totalRows][totalCells];
	    for(int r=0; r<totalRows;r++)
	    {
	  for(int c=0; c<totalCells;c++)
	  {
	  DataFormatter df = new DataFormatter();
	  data[r][c] = df.formatCellValue(sheet.getRow(r+1).getCell(c));
	  System.out.println(data[r][c]);
	  }
	  }
	    workbook.close();
	    file.close();
	    return data;
}
}

	//public String[][] getData() throws IOException{
		/*String path="C:\\Users\\hi\\eclipse-workspace\\Opencartv121\\testData\\Opencart_LoginData.xlsx";   // taking xl file from testData
		
		ExcelUtility xlutil = new ExcelUtility(path);   // creating an object for xlutility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);
		
		String loginData[][]= new String [totalrows][totalcols];// created for two dimensions array which can store
		
		for(int i=1;i<totalrows;i++) // 1       read the data from xl storing in two dimensional array
		{
			for(int j=0;j<totalcols;j++) // 0  i is rows j is cols
			{
				loginData[i-1][j]= xlutil.getCellData("Sheet1", i, j);  //1,0    //array values starts from zero
				System.out.println(loginData[i-1][j]);
			}
         
		}
		return loginData;   // returning two dimension array
		
	}*/
	
	// DataProvider 2
			// DataProvider 3
	
	// DataProvider 4
	

