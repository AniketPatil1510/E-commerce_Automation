package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class Test_LoginPage extends BaseClass{

	
	@Test ( groups = {"Sanity","Master"}) ///( groups = {"Sanity","Master"}) this statement is using because here doing the grouping test where Master is for run all the tests
	public void verify_Login()
	{
	   logg.info("**** Starting Login Test ****");
	   
	   
	   HomePage hp = new HomePage( driver); // home page object
	   
	   hp.clickMyAccount();
	   hp.clickLogin();
	   
	   
	   LoginPage lp = new LoginPage(driver); // Login page object
	   
	   lp.enterLoginEmail(prop.getProperty("email"));
	   lp.enterLoginPassword(prop.getProperty("password"));
	   lp.clickLogin();
	   
	   
	   MyAccountPage mp = new MyAccountPage(driver); // My Account Page
	   //verify the account page heading 
	   boolean verifyHead = mp.isMyAccountPageExists();
	   
	   Assert.assertTrue(verifyHead);
	   
	   logg.info("**** Finished Login Test ****");
	
	
	}
}
