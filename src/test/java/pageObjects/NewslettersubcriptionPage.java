package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewslettersubcriptionPage extends BasePage {

	public NewslettersubcriptionPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h1[normalize-space()='Newsletter Subscription']")
	WebElement SubscriptionPage;
	
	@FindBy(xpath="//input[@value='1']")
	WebElement newsletteryesoption;
	
	public String getSubscriptionPage()
	{
		try {
			return (SubscriptionPage.getText());
		}
		catch (Exception e) {
			return (e.getMessage());

		}
	}
	
	
	public boolean isyesoptionselected()
	{
		try {
			return (newsletteryesoption.isSelected());
		}
		catch(Exception e){
			return false;
			
		}
	}


}
