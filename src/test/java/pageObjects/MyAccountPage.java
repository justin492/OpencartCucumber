package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class MyAccountPage extends BasePage {

		public MyAccountPage(WebDriver driver) {
			super(driver);
		}
		
		@FindBy(xpath= "//h2[normalize-space()='My Account']")
		WebElement Myaccount;
		
		@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
		WebElement lnkLogout;
		
		@FindBy(xpath="//a[normalize-space()='Subscribe / unsubscribe to newsletter']")
		WebElement lnkSubscribeorUnsubscribetoNewsletter;
		
		
		public void clickSubscribeorUnsubscribetoNewsletter(){
			
			lnkSubscribeorUnsubscribetoNewsletter.click();
			
		}
		
		public void clickLogout() {
			lnkLogout.click();

		}
		
		public boolean isMyaccount() {
			try {
				return (Myaccount.isDisplayed());
			} catch (Exception e) {
				return false;

			}
		}
		
	
}
