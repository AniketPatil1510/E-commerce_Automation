package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;

public class Test_AddCart extends BaseClass {

	@Test(groups= {"Master"})
	public void verify_addToCart() throws InterruptedException {
		logg.info(" Starting AddCartPageTest ");

		try {
			
			HomePage hp=new HomePage(driver);
			
			hp.enterProductName("xyz"); // passing searching name iPhone
			hp.clickSearchbtn();
			
						
			SearchPage sp=new SearchPage(driver);
			
			if(sp.isProductExist("iPhone"))
			{
				sp.selectProduct("iPhone");
				sp.setQuantity("2");
				sp.addToCart();
				
			}
						
			Assert.assertEquals(sp.checkConfMsg(),true);

		} catch (Exception e) {
			Assert.fail();
		}

		logg.info("finished AddCart Test ");

	}

	
}
