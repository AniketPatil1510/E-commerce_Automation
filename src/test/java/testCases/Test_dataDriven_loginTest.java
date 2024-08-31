package testCases;


import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProvidersForTestData;

// creating test cases for login where we get the data from excel
    // creating test cases positive as well as negative test 
	// for that...... getting from valid and invalid data from excel file


/* Data is valid == login success == test pass == logout
                    login failed  == test fail  */
/* Data is invalid ==   login success == test fail == logout
                        login failed  == test pass */

 
public class Test_dataDriven_loginTest  extends  BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProvidersForTestData.class, groups="Datadriven") //LoginData is the name of data provider and getting data provider.class -- and --  groups="Datadriven" this is the grouping test  statement  
	public void verify_logindriventest(String email,String pwd,String expRes) //creating parameters email,pwd,expRes
	{
		
		logg.info("***** Starting data drivrn login test *****");
		  
		HomePage hp = new HomePage( driver); // home page object
		   
		   hp.clickMyAccount();
		   hp.clickLogin();
		   
		   
		   LoginPage lp = new LoginPage(driver); // Login page object
		   
		   lp.enterLoginEmail(email);
		   lp.enterLoginPassword(pwd);
		   lp.clickLogin();
		   
		   
		   MyAccountPage mp = new MyAccountPage(driver); // My Account Page
		   //verify the account page heading 
		   boolean verifyHead = mp.isMyAccountPageExists();
		   
		   
 //now we are create all +ve -ve conditions
		   
		   /* Data is valid == login success == test pass == logout
			                   login failed  == test fail  */
			
		 if(expRes.equals("valid"))        // data is valid then
		   {
			   if(verifyHead==true)        //  login is successfull 
			   {
				   Assert.assertTrue(true);  //test pass
				   
				   mp.clicklogout();
			   }
			   else             //  login is unsuccessfull 
			   {
				   Assert.assertTrue(false);   //test fail
			   }
		   }
		   
		   
		 /* Data is invalid ==   login success == test fail == logout
		                         login failed  == test pass */
		 
		   if(expRes.equals("Invalid"))      //Data is invalid  
		   {
			   if(verifyHead==true)        //login success 
			   {
				   Assert.assertTrue(false);    //test fail
				   
				   mp.clicklogout();
			   }
			   else             
			   {
				   Assert.assertTrue(true);  //test pass
			   }
		   }
		   
		   logg.info("***** FINSHED  data drivrn login test *****");
	}
	
}
