package stepDefinitions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
		BaseClass.getLogger().info("Click Myaccount drop Menu.. ");
		hp=new HomePage(BaseClass.getDriver());
    	hp.clickMyAccount();
       
                   
	}
	
	@When("the user clicks on Register option")
	public void the_user_clicks_on_Register_option() {
	
		BaseClass.getLogger().info("Click Register option.. ");
        hp.clickRegister();
                   
	}

	@When("the user enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
		
		BaseClass.getLogger().info("Entering details in respective fields.. ");
		
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
		BaseClass.getLogger().info("Selecting Privacy Policy.. ");
		regpage.setPrivacyPolicy();
	}

	@When("the user clicks on Continue button")
	public void user_clicks_on_continue_button() {
		BaseClass.getLogger().info("Click on continue button.. ");
		regpage.clickContinue();
	}

	@Then("the user account should get created successfully")
	public void user_account_should_get_created_successfully() {
		BaseClass.getLogger().info("Account should get created.. ");
		successpage=new AccountSuccessPage(BaseClass.getDriver());
		boolean isAccountCreated=successpage.isAccountCreatedMsgDisplayed();
		Assert.assertTrue("The Confirmation msg for account creation is incorrect", isAccountCreated);
		}
	
	@When("User does not enter any information in the registration fields")
	public void userDoesNotEnterAnyInformation() {
		BaseClass.getLogger().info("Not Entering any details in fields.. ");
	    // This step can remain empty as no action is needed
		//regpage=new AccountRegistrationPage(BaseClass.getDriver());
	}
	
	
	@Then("An error message should be displayed for the mandatory fields")
	public void An_error_message_should_be_displayed_for_the_mandatory_fields() {
		
		BaseClass.getLogger().info("Error Msg should be displayed for the Mandatory fields.. ");
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
		BaseClass.getLogger().info("Selecting Yes Radio button.. ");
		regpage.clickYesOption();
	}
	
	@When("the user clicks on Continue button on Account Success page")
	public void the_user_clicks_on_Continue_button_on_Account_Success_page() {
		BaseClass.getLogger().info("Clicking continue button on Account Success page.. ");
		successpage.clickContinue();
	}
	
	@Then ("the user should be redirected to the My Account page")
	public void the_user_should_be_redirected_to_the_My_Account_page()
	{
		BaseClass.getLogger().info("Redirecting to My Account page.. ");
		AccountPage=new MyAccountPage(BaseClass.getDriver());
		boolean MyAccountExist=AccountPage.isMyaccount();
		Assert.assertTrue("User is not on the Myaccount Page", MyAccountExist);
	}
	
	@When ("the user clicks on SubscribeOrUnsubscribeOption in My Account page")
	public void the_user_clicks_on_SubscribeOrUnsubscribeOption_in_My_Account_page(){
	BaseClass.getLogger().info("Clicking SubscribeOrUnsubscribeOption in My account page.. ");
	AccountPage.clickSubscribeorUnsubscribetoNewsletter();
	
	}
	
	@Then ("the user should see the YesOption is Selected by default")
	public void the_user_should_see_the_YesOption_is_Selected_by_default() {
	
	BaseClass.getLogger().info("YesOption selected by default.. ");
	SubscriptionPage=new NewslettersubcriptionPage(BaseClass.getDriver());
	Assert.assertTrue("Yes option is not selected by default",SubscriptionPage.isyesoptionselected());
	}
	
	@When ("the user click on Login Option")
	public void the_user_click_on_Login_Option() {
		BaseClass.getLogger().info("Clicking Login Option.. ");
		regpage.clickLogin();
	}
	
	@When("the user click on continue button inside New customer box")
	public void the_user_click_on_continue_button_inside_New_customer_box() {
		BaseClass.getLogger().info("Clicking continue button inside New customer box.. ");
	    lp = new LoginPage(BaseClass.getDriver());
	    lp.clickNewCustomerbtn();
	}
	
	@When ("the user click on Register Link from Rightside Menu")
	public void the_user_click_on_Register_Link_from_Rightside_Menu() {
		BaseClass.getLogger().info("Clicking on Register Link from Rightside Menu.. ");
		hp.clickRegister();
	}
	
	
	@Then ("the user should be taken to Register Account page")
	public void the_user_should_be_taken_to_Register_Account_page() {
	
		BaseClass.getLogger().info("Redirected to Register Account page.. ");
		String Title=regpage.getRegisterPageTitle();
		Assert.assertEquals(Title, "Register Account");
	}
	
	@When ("the user enters the details into below fields with Mismatched Password and Confirm Password fields")
	public void the_user_enters_the_details_into_below_fields_with_Mismatched_Password_and_Confirm_Password_fields(DataTable dataTable) {
	BaseClass.getLogger().info("Mismatching password and Confirm password fields.. ");
	Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
	regpage.setFirstName(dataMap.get("firstName"));
	regpage.setLastName(dataMap.get("lastName"));
	regpage.setEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
	regpage.setTelephone(dataMap.get("telephone"));
	regpage.setPassword(dataMap.get("password"));
	regpage.setConfirmPassword(dataMap.get("confirm password"));
	
	}
	
	@Then ("Proper placeholder texts should be available in all the fields")
	public void Proper_placeholder_texts_should_be_available_in_all_the_fields()
	{
		BaseClass.getLogger().info("Placeholder text should be present...");
		Set <String>actualplaceholderName=regpage.getplaceholderNames();
		Set <String>ExpectedplaceholderName=new HashSet<String>();
		ExpectedplaceholderName.add("First Name");
		ExpectedplaceholderName.add("Last Name");
		ExpectedplaceholderName.add("E-Mail");
		ExpectedplaceholderName.add("Telephone");
		ExpectedplaceholderName.add("Password");
		ExpectedplaceholderName.add("Password Confirm");
		
		Assert.assertEquals(actualplaceholderName,ExpectedplaceholderName);
		
		Set <String>Missingplaceholders=new HashSet<>(ExpectedplaceholderName);
		Missingplaceholders.removeAll(actualplaceholderName);
		if(!Missingplaceholders.isEmpty())
		{
			BaseClass.getLogger().info("Placeholder text cases failed...");
			Assert.fail();
		}
		
		Set <String>Extraplaceholders=new HashSet<>(actualplaceholderName);
		Extraplaceholders.removeAll(ExpectedplaceholderName);
		if(!Extraplaceholders.isEmpty())
		{
			BaseClass.getLogger().info("Placeholder text cases failed...");
			Assert.fail();
		}
		
		
	}
	
	@When ("the user enters the details into below fields but does not follow Password complexity")
	public void the_user_enters_the_details_into_below_fields_but_does_not_follow_Password_complexity(DataTable dataTable) {
	BaseClass.getLogger().info("Not following Password complexity...");
	Map<String,String> dataMap=dataTable.asMap(String.class,String.class);
	regpage.setFirstName(dataMap.get("firstName"));
	regpage.setLastName(dataMap.get("lastName"));
	regpage.setEmail(BaseClass.randomAlphaNumeric()+"@gmail.com");
	regpage.setTelephone(dataMap.get("telephone"));
	regpage.setPassword(dataMap.get("password"));
	regpage.setConfirmPassword(dataMap.get("confirm password"));
	
	}
	
	@Then("the warning Message should be displayed for not following password complexity type")
	public void the_warning_Message_should_be_displayed_for_not_following_password_complexity_type()
	{
		BaseClass.getLogger().info("Warning Msg should be displayed for not following password complexity...");
		boolean Registered=successpage.isAccountCreatedMsgDisplayed();
		Assert.assertEquals(Registered, false);
	}
	
	@Then("the privacy policy should not selected by default")
	public void the_privacy_policy_should_not_selected_by_default()
	{
		BaseClass.getLogger().info("Checking privacy policy is selected by default or not");
		boolean checkprivacypolicy=regpage.getprivacypolicy();
		Assert.assertEquals(checkprivacypolicy,false);
	}
}
 
