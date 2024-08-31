package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AccRegistrationPage extends BasePage {
	
	public AccRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	 
	
	//finding Element
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-lastname']")  WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtemail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@name='agree']") WebElement chkdPolicy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation ;

	//h1[normalize-space()='Your Account Has Been Created!']
	//creating action method
	
	public void EnterFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void EnterlastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void Enteremail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void EnterTelephone(String Tel)
	{
		txtTelephone.sendKeys(Tel);
	}

	public void EnterPassword(String pname)
	{
		txtPassword.sendKeys(pname);
	}
	
	public void EnterConfirmPassword(String pname)
	{
		txtConfirmPassword.sendKeys(pname);
	}
	
	public void EnterPolicy()
	{
		chkdPolicy.click();
		
		//chkdPolicy.submit();
		
	}
	
	public void ClickContinue()
	{
		btnContinue.click();
		
		//Sometime time click action not working so here are some alternate solutions
	    
		//btnContinue.submit(); //if click method is not working then choose this one
	
	    //Actions act = new Actions(driver);
	    //act.moveToElement(btnContinue).click().perform();
	
	
	}
	
	public String  getConfirmationmsg()
	{
		try {
		return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
		
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
