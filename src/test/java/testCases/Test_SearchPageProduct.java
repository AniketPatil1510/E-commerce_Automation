package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;

public class Test_SearchPageProduct extends BaseClass{

	@Test(groups= {"Master"})
	public void verify_pruductSearch() throws InterruptedException {
		logg.info(" Starting_SearchProductTest ");

		try {
			
			HomePage hp=new HomePage(driver);
			
			
			hp.enterProductName("mac");
			
			hp.clickSearchbtn();
			
			SearchPage sp=new SearchPage(driver);
			sp.isProductExist("MacBook");

			Assert.assertEquals(sp.isProductExist("MacBook"),true);

		} catch (Exception e) {
			Assert.fail();
		}

		logg.info(" Finshed SearchProductTest ");

	}

	
}
