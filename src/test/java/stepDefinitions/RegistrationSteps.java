package stepDefinitions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
     
	@Given("the user clicks on Myaccount drop Menu")
	public void the_user_clicks_on_Myaccount_drop_Menu() {
	
		hp=new HomePage(BaseClass.getDriver());
    	hp.clickMyAccount();
       
                   
	}
	
	@When("the user clicks on Register option")
	public void the_user_clicks_on_Register_option() {
	
		
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
		
		Map<String,String> actualErrors=regpage.getAllErrorMessages();
		Map<String,String> Expectederrors=new HashMap<>();
		Expectederrors.put("FirstName", "First Name must be between 1 and 32 characters!");
		Expectederrors.put("LastName", "Last Name must be between 1 and 32 characters!");
		Expectederrors.put("Email", "E-Mail Address does not appear to be valid!");
		Expectederrors.put("Telephone", "Telephone must be between 3 and 32 characters!");
		Expectederrors.put("Password", "Password must be between 4 and 20 characters!");
		Expectederrors.put("Privacypolicy"," Warning: You must agree to the Privacy Policy!");
		for(Map.Entry<String, String> entry:Expectederrors.entrySet())
		{
		
			Assert.assertEquals(entry.getValue().trim(), actualErrors.get(entry.getKey()).trim());
		}
		
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
	
	@When ("the user click on Login Option")
	public void the_user_click_on_Login_Option() {
		regpage.clickLogin();
	}
	
	@When("the user click on continue button inside New customer box")
	public void the_user_click_on_continue_button_inside_New_customer_box() {
	    lp = new LoginPage(BaseClass.getDriver());
	    lp.clickNewCustomerbtn();
	}
	
	@When ("the user click on Register Link from Rightside Menu")
	public void the_user_click_on_Register_Link_from_Rightside_Menu() {
		hp.clickRegister();
	}
	
	
	@Then ("the user should be taken to Register Account page")
	public void the_user_should_be_taken_to_Register_Account_page() {
	
		String Title=regpage.getRegisterPageTitle();
		Assert.assertEquals(Title, "Register Account");
	}
	
	@When ("the user enters the details into below fields with Mismatched Password and Confirm Password fields")
	public void the_user_enters_the_details_into_below_fields_with_Mismatched_Password_and_Confirm_Password_fields(DataTable dataTable) {
	Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
	regpage.setFirstName(dataMap.get("firstName"));
	regpage.setLastName(dataMap.get("lastName"));
	regpage.setEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
	regpage.setTelephone(dataMap.get("telephone"));
	regpage.setPassword(dataMap.get("password"));
	regpage.setConfirmPassword(dataMap.get("confirm password"));
	
	}
	
	
}
 
