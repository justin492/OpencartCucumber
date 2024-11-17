package pageObjects;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
		WebElement PrivacypolicyErrorMsg;
		
		@FindBy(xpath="//label[normalize-space()='Yes']")
		WebElement YesOption;
		
		@FindBy(xpath="//h1[normalize-space()='Register Account']")
		WebElement RegisterAccountHeader;
		
		@FindBy(linkText = "Login")   
		WebElement linkLogin;
		
		@FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
		WebElement FirstNameErrorMsg;
		
		@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
		WebElement LastNameErrorMsg;
		
		@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
		WebElement EmailErrorMsg;
		
		@FindBy(xpath="//div[contains(text(),'Telephone must be between 3 and 32 characters!')]")
		WebElement TelephoneErrorMsg;
		
		@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
		WebElement PasswordErrorMsg;
		
		@FindBy(xpath="//div[@class='text-danger']")
		WebElement PasswordMismatchError;	

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

		
		public Map<String,String> getAllErrorMessages()   // MyAccount Page heading display status
		{
			Map<String,String> errorMessages=new HashMap<>();
			errorMessages.put("FirstName", FirstNameErrorMsg.getText());
			errorMessages.put("LastName", LastNameErrorMsg.getText());
			errorMessages.put("Email", EmailErrorMsg.getText());
			errorMessages.put("Telephone", TelephoneErrorMsg.getText());
			errorMessages.put("Password", PasswordErrorMsg.getText());
			errorMessages.put("Privacypolicy",PrivacypolicyErrorMsg.getText());
			return errorMessages;
			
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
		
		public Set<String> getplaceholderNames()
		{
			Set<String> placeholder=new HashSet<>();
			placeholder.add(txtFirstname.getAttribute("placeholder"));
			placeholder.add(txtLasttname.getAttribute("placeholder"));
			placeholder.add(txtEmail.getAttribute("placeholder"));
			placeholder.add(txtTelephone.getAttribute("placeholder"));
			placeholder.add(txtPassword.getAttribute("placeholder"));
			placeholder.add(txtConfirmPassword.getAttribute("placeholder"));
			return placeholder;
		}
		
		public boolean getprivacypolicy()
		{
			return chkdPolicy.isSelected();
		}
		
		public String getpasswordvalue()
		{
			return txtPassword.getAttribute("type");
		}
		
		public String getconfirmpasswordvalue()
		{
			return txtConfirmPassword.getAttribute("type");
		}
}