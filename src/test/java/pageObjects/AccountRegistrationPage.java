package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	JavascriptExecutor js;
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		this.js=(JavascriptExecutor)driver;
	}

	// Elements
		@FindBy(name = "firstname")
		WebElement txtFirstname;

		@FindBy(name = "lastname")
		WebElement txtLasttname;

		@FindBy(name = "email")
		WebElement txtEmail;

		@FindBy(name = "telephone")
		WebElement txtTelephone;

		@FindBy(name = "password")
		WebElement txtPassword;

		@FindBy(name = "confirm")
		WebElement txtConfirmPassword;

		@FindBy(name = "agree")
		WebElement chkdPolicy;

		@FindBy(xpath = "//input[@value='Continue']")
		WebElement btnContinue;
		
		@FindBy(xpath = "//div[text()=' Warning: You must agree to the Privacy Policy!']")
		WebElement FieldErrorMessage;
		
		@FindBy(xpath="//label[normalize-space()='Yes']")
		WebElement YesOption;
		
		@FindBy(xpath="//h1[normalize-space()='Register Account']")
		WebElement RegisterAccountHeader;
		
		@FindBy(linkText = "Login")   
		WebElement linkLogin;
			

		public void setFirstName(String fname) {
			txtFirstname.sendKeys(fname);

		}

		public void setLastName(String lname) {
			txtLasttname.sendKeys(lname);

		}

		public void setEmail(String email) {
			txtEmail.sendKeys(email);

		}

		public void setTelephone(String tel) {
			txtTelephone.sendKeys(tel);

		}

		public void setPassword(String pwd) {
			txtPassword.sendKeys(pwd);

		}

		public void setConfirmPassword(String pwd) {
			txtConfirmPassword.sendKeys(pwd);

		}

		public void setPrivacyPolicy() {
			chkdPolicy.click();

		}

		public void clickContinue() {
			//btnContinue.click();
			js.executeScript("arguments[0].click();",btnContinue);

		}
		
		public void clickLogin() {
			linkLogin.click();
		}

		
		public String verifyMandatoryFieldErrorMessages()   // MyAccount Page heading display status
		{
			try {
				return (FieldErrorMessage.getText());
			} catch (Exception e) {
				return (e.getMessage());
			}
			
		}
		
		public void clickYesOption()
		{
			YesOption.click();
		}
		
		public String getRegisterPageTitle()
		{
			try {
			return (RegisterAccountHeader.getText());
			}catch(Exception e) {
				return (e.getMessage());
			}
		}
		
}