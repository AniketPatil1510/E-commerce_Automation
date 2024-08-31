package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage( WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement msgHeading ; //MYAccount page heading after login
	
	
	// check - is account page exists or not 
	public boolean isMyAccountPageExists()
	{
		try 
		{
		  return(msgHeading.isDisplayed());
	    }
		catch(Exception e)
		{
			return false;
		}
	}
	
	//logout the page so we can get another input
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement linklogout;

	public void clicklogout()
	{
		linklogout.click();
	}
	
}
