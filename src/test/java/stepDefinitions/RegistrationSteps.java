package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountRegistrationPage;
import pageObjects.AccountSuccessPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.NewslettersubcriptionPage;


public class RegistrationSteps {

	 WebDriver driver;
     HomePage hp;
     LoginPage lp;
     AccountRegistrationPage regpage;
     AccountSuccessPage successpage;
     MyAccountPage AccountPage;
     NewslettersubcriptionPage SubscriptionPage;
     public RegistrationSteps() {
    	 
         regpage = new AccountRegistrationPage(BaseClass.getDriver()); 
     }
     
	@Given("the user navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
	
		hp=new HomePage(BaseClass.getDriver());
    	hp.clickMyAccount();
        hp.clickRegister();
                   
	}

	@When("the user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	    
		//regpage=new AccountRegistrationPage(BaseClass.getDriver());
		regpage.setFirstName(dataMap.get("firstName"));
		regpage.setLastName(dataMap.get("lastName"));
		regpage.setEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
		regpage.setTelephone(dataMap.get("telephone"));
		regpage.setPassword(dataMap.get("password"));
		regpage.setConfirmPassword(dataMap.get("password"));
		
	}

	@When("the user selects Privacy Policy")
	public void user_selects_privacy_policy() {
		regpage.setPrivacyPolicy();
	}

	@When("the user clicks on Continue button")
	public void user_clicks_on_continue_button() {
		regpage.clickContinue();
	}

	@Then("the user account should get created successfully")
	public void user_account_should_get_created_successfully() {
		successpage=new AccountSuccessPage(BaseClass.getDriver());
		boolean isAccountCreated=successpage.isAccountCreatedMsgDisplayed();
		Assert.assertTrue("The Confirmation msg for account creation is incorrect", isAccountCreated);
		}
	
	@When("User does not enter any information in the registration fields")
	public void userDoesNotEnterAnyInformation() {
	    // This step can remain empty as no action is needed
		//regpage=new AccountRegistrationPage(BaseClass.getDriver());
	}
	
	
	@Then("An error message should be displayed for the mandatory fields")
	public void An_error_message_should_be_displayed_for_the_mandatory_fields() {
		
		String mandatoryerrormsg=regpage.verifyMandatoryFieldErrorMessages();
		Assert.assertEquals(mandatoryerrormsg, "Warning: You must agree to the Privacy Policy!");
		}
	
	@When("the user clicks on Yes radio option for Newsletter")
	public void the_user_clicks_on_Yes_radio_option_for_Newsletter() {
		regpage.clickYesOption();
	}
	
	@When("the user clicks on Continue button on Account Success page")
	public void the_user_clicks_on_Continue_button_on_Account_Success_page() {
		successpage.clickContinue();
	}
	
	@Then ("the user should be redirected to the My Account page")
	public void the_user_should_be_redirected_to_the_My_Account_page()
	{
		AccountPage=new MyAccountPage(BaseClass.getDriver());
		boolean MyAccountExist=AccountPage.isMyaccount();
		Assert.assertTrue("User is not on the Myaccount Page", MyAccountExist);
	}
	
	@When ("the user clicks on SubscribeOrUnsubscribeOption in My Account page")
	public void the_user_clicks_on_SubscribeOrUnsubscribeOption_in_My_Account_page(){
	AccountPage.clickSubscribeorUnsubscribetoNewsletter();
	
	}
	
	@Then ("the user should see the YesOption is Selected by default")
	public void the_user_should_see_the_YesOption_is_Selected_by_default() {
	
	SubscriptionPage=new NewslettersubcriptionPage(BaseClass.getDriver());
	Assert.assertTrue("Yes option is not selected by default",SubscriptionPage.isyesoptionselected());
	}
	
		
	
	
}
 
