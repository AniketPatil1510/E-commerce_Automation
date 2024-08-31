package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	//this is Constructor which is in detailed in BasePage  thats we extend the base 
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	 //finding the elements
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement linkMyaccount;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement linkRegister;
	@FindBy(linkText="Login") WebElement linkLogin;
	
	@FindBy(xpath="//input[@placeholder='Search']")  WebElement txtSearchbox;  //For Searching the  Product 
    @FindBy(xpath="//div[@id='search']//button[@type='button']") WebElement btnSearch; 
	

	
	//creating the action methods
	
	public void clickMyAccount()
	{ 
		linkMyaccount.click();
	}
	
	
	public void clickRegister()
	{
		linkRegister.click();
		
	}
	
	public void clickLogin()
	{
		linkLogin.click();
	}
	
	public void enterProductName(String pname)  
	{
		txtSearchbox.sendKeys(pname);
	}

	public void clickSearchbtn()  
	{
		btnSearch.click();
	}
	   
}
