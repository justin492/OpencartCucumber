package pageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EdityouraccountinfoPage extends BasePage {

	
	public EdityouraccountinfoPage(WebDriver driver) {
		super(driver);
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
			
			
			public Map<String,String> getinfo()
			{
				Map<String,String> actualdetails=new HashMap<String, String>();
				actualdetails.put("Firstname", txtFirstname.getAttribute("value"));
				actualdetails.put("Firstname", txtLasttname.getAttribute("value"));
				actualdetails.put("Firstname", txtEmail.getAttribute("value"));
				actualdetails.put("Firstname", txtTelephone.getAttribute("value"));
				return actualdetails;
				
			}
}
