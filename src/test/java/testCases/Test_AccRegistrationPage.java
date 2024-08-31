package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccRegistrationPage;
import pageObjects.HomePage;



public class Test_AccRegistrationPage extends BaseClass {
	
////////////////////////////////////////////////////////////////////////
	
	@Test  ( groups = {"Regression","Master"})  // ( groups = {"Regression","Master"}) -- this statement is used for grouping test where Master is for run all the tests
	public void verify_account_regidtration()
	{
		logg.info("****Starting Account Registration Test****");//Logs
		
	//first we create object oh home and registration pages to get all method 		
	  HomePage hp = new HomePage(driver);
	  hp.clickMyAccount();
	  logg.info(" clicked on my account "); /////Logs
	  hp.clickRegister();
	  logg.info("  and clicked on register link "); /////Logs
	  
	  
	  AccRegistrationPage regPage = new AccRegistrationPage(driver);
	  
	  /*//method 1
	    regPage.EnterFirstName("Aniket");
		regPage.EnterlastName("Patil");
		regPage.Enteremail("testeraniket1234567@gmail.com");
		regPage.EnterTelephone("9192939496");
		regPage.EnterPassword("Test12345");
		regPage.EnterConfirmPassword("Test12345");
		regPage.EnterPolicy();
		regPage.ClickContinue();
		
		String confmsg = regPage.getConfirmationmsg();
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");  
		
		//Above data are one time use only because if we are using 2nd time it show this account aleready exit 
		// so solve that problem we can generate random data using RandomStringUtil -- this is predefined class from java
	
	 */
	   //method 2 - 
	  
	  //now we are creating actions for random data- for that at the end we created a method 
	    regPage.EnterFirstName(randomString().toUpperCase());       //if we use just RandomString method so its generate small letters names but usually name are in upper case so we uses upper case 
		regPage.EnterlastName(randomString().toUpperCase());
		regPage.Enteremail(randomString()+"@gmail.com"); //for generating random email we are concat with"@gmail.com"
		regPage.EnterTelephone(randomNumber()); //using RandomNUmber for generate numbers
		
		
		//in password if we use same method for password and confirm password it will not genearte same password 
		//because in password filed it generate but next time in confirm password it generate another new random password 
		//so we store that password in variable and passe in confirm password 
		String pw = randomAplhaNumericPassword();
		
		regPage.EnterPassword(pw);
		regPage.EnterConfirmPassword(pw);
		
		
		regPage.EnterPolicy();
		regPage.ClickContinue();
		logg.info("Provided all details of customer  and clicked continue"); ////Logs
		
		String confmsg = regPage.getConfirmationmsg();
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");  
		
		logg.info("****Finished Account Registration Test****");//Logs
		
		
      }
	
	
		
}
