package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	WebElement NewCustomerbtn;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Register']")
	WebElement Registerlink;


	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public void clickNewCustomerbtn()
	{
		NewCustomerbtn.click();
	}
	
	public void clickRegisterlink()
	{
		Registerlink.click();
	}

}
