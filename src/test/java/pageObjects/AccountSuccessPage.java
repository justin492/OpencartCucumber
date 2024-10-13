package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSuccessPage extends BasePage {

	public AccountSuccessPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement btnContinue;
	

	public boolean isAccountCreatedMsgDisplayed() {
		try {
			return (msgConfirmation.isDisplayed());
		} catch (Exception e) {
			return false;

		}

	}
	
	public void clickContinue() {
		btnContinue.click();

	}
	
	public void clickLogout() {
		lnkLogout.click();

	}
	
	
}
