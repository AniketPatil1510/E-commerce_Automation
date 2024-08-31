package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage ( WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txtloginemail ;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtloginpassword;
	@FindBy(xpath="//input[@value='Login']") WebElement btnLogin ;
	
	
	public void enterLoginEmail(String email)
	{
		txtloginemail.sendKeys(email);
	}
	
	public void enterLoginPassword(String pwd)
	{
		txtloginpassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	

}
