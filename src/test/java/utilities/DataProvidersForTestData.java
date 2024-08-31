package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProvidersForTestData {
	
	//data provider 1: creating data provider method for login data
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path =".\\testData\\Opencart_LoginData.xlsx"; //taking xl file from test data folder 
	    
		ExcelUtility xlutil = new ExcelUtility(path);
	
	    int totalrows = xlutil.getRowCount("sheet1"); //it gives total numbers of rows
	    int totalcols = xlutil.getCellCount("sheet1",1); // it gives total numbers of colomns
	    
	    String logindata[][]= new String [totalrows][totalcols];
	    
	    for (int i =1;i<=totalrows; i++) //read the data from xl sheet and copy to the 2 dimensional array
            {
	           for(int j = 0; j< totalcols; j++) // i is rows and j is columns
	           {
	        	   logindata[i-1][j]=xlutil.getCellData("sheet1", i, j); // getting the cell data ( row i & column j) and storing the data into login data variable
	           }
	        }
         return logindata;
      }
	
	//data provider 2:
}
