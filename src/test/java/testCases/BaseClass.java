package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	
public static WebDriver driver;
public Logger logg; //variable for log4j metohd
public Properties prop; //for loading config.properties file	
  //launching the browser so created setup method

  @BeforeClass (groups={"Sanity","Regression","Master"}) //for grouping statement
       
	@Parameters({"os","browser"}) //this statement is for parallel browsing test so now in setup method we passed this all parameters - string os string br : for run used testng.xml
	public void setup(String os, String br) throws IOException
	{
		//loading config.properties file so we use properties class and fileReader
		  FileReader Cfile = new FileReader("C:\\Users\\lenovo\\eclipse-workspace\\Opencart_Project\\src\\test\\resources\\config.properties");
		  
		  prop=new Properties();
		  prop.load(Cfile);
		
		
		
		logg = LogManager.getLogger(this.getClass()); //generating log .. use log manger class predefined
		//this is the only one statement for generate logs
		
		switch(br)
		{
		case "chrome": driver = new ChromeDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		default: System.out.println("inavalid browser name"); return;
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get(prop.getProperty("appURL")); // reading URL from config file
		driver.manage().window().maximize();
		
	}
	
   //close or quit the browser so created tear down method
	@AfterClass  (groups={"Sanity","Regression","Master"}) //for grouping statement
	public void teardown()
	{
		driver.quit();
	}
	
	
	//create new method for  generate random things random 
	// so solve that problem we can generate random data using RandomStringUtil -- this is predefined class from java
	      
    //for generate alpha characters only - letters/alphabets
    public String randomString() //creating method for letter/alphabets only so we can use in only - first name, Last name, email
	{
	    String generatedstring = RandomStringUtils.randomAlphabetic(6); // 5 represented as  no of letters random string 
		return generatedstring; 
	}
			
	//for generate numeric characters only - numbers
	public String randomNumber() //creating method for numbers only so we can use in only - telephone no , mobile no, pincode, etc...
	{
		String generatednumber = RandomStringUtils.randomNumeric(10); // 10 represented as  no of letters random string 
		return generatednumber; 
	}
			
	//for generate Apha-numeric characters only - passwords
	public String randomAplhaNumericPassword() //creating method for numbers as well as alpha character - Passwords
	{
		 String generatedpassword = RandomStringUtils.randomAlphanumeric(8); // 8 represented as  no of letters random string 
		 return generatedpassword; 
    }
	
	
	//Screenshots
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	

	

}
