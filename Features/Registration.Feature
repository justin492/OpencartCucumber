Feature: Account Registration

  @sanity
  Scenario: Successful Account Registration
    Given the user clicks on Myaccount drop Menu
    When the user clicks on Register option
    And the user enters the details into below fields
      | firstName | John       |
      | lastName  | Kenedy     |
      | telephone | 1234567890 |
      | password  | test@123   |
    And the user selects Privacy Policy
    And the user clicks on Continue button
    Then the user account should get created successfully
    
  @sanity
  Scenario: Register without entering any information
    Given the user clicks on Myaccount drop Menu
    When the user clicks on Register option
    And User does not enter any information in the registration fields
    And the user clicks on Continue button
    Then An error message should be displayed for the mandatory fields
    
  @functional
  Scenario: Yes option is selected for Newsletter field
    Given the user clicks on Myaccount drop Menu
    When the user clicks on Register option
    And the user enters the details into below fields
      | firstName | John       |
      | lastName  | Kenedy     |
      | telephone | 1234567890 |
      | password  | test@123   |
    And the user clicks on Yes radio option for Newsletter
    And the user selects Privacy Policy
    And the user clicks on Continue button
    Then the user account should get created successfully
    When the user clicks on Continue button on Account Success page
    Then the user should be redirected to the My Account page
    When the user clicks on SubscribeOrUnsubscribeOption in My Account page
    Then the user should see the YesOption is Selected by default
    
  #  @sanity
  #Scenario: No option is selected for Newsletter field
  #  Given the user clicks on Myaccount drop Menu
   # When the user clicks on Register option
   # And the user enters the details into below fields
   #   | firstName | John       |
   #   | lastName  | Kenedy     |
    #  | telephone | 1234567890 |
     # | password  | test@123   |
   # And the user clicks on No radio option for Newsletter
   # And the user selects Privacy Policy
   # And the user clicks on Continue button
   # Then the user account should get created successfully
   # When the user clicks on Continue button on Account Success page
   # Then the user should be redirected to the My Account page
   # When the user clicks on SubscribeOrUnsubscribeOption in My Account page
   # Then the user should see the NoOption is Selected by default
    
    @functional
    Scenario: Different ways of Navigating Register Account Page
    	Given the user clicks on Myaccount drop Menu
    	When the user clicks on Register option
    	Then the user should be taken to Register Account page
    	Given the user clicks on Myaccount drop Menu
    	When the user click on Login Option
    	And the user click on continue button inside New customer box 
    	Then the user should be taken to Register Account page
    	Given the user clicks on Myaccount drop Menu
    	When the user click on Login Option
    	And the user click on Register Link from Rightside Menu
    	Then the user should be taken to Register Account page 
    	
    	@sanity
    	Scenario: Entering different Passwords in Password and Confirm Password fields
    	Given the user clicks on Myaccount drop Menu
    	When the user clicks on Register option
    	And the user enters the details into below fields with Mismatched Password and Confirm Password fields
    	| firstName 				| John       |
      | lastName  				| Kenedy     |
      | telephone 				| 1234567890 |
      | password  				| test@123   |
      | confirm password	| abcde			 |
      And the user clicks on Continue button
      Then the warning Message Password confirmation does not match password! should be displayed under Confirm Password fields
    
    @functional
    Scenario: Validating account fields having proper placeholders name
    Given the user clicks on Myaccount drop Menu
    When the user clicks on Register option
    Then Proper placeholder texts should be available in all the fields
    
    @sanity
    Scenario: Validating Passwords fields following Password Complexity Standards
    Given the user clicks on Myaccount drop Menu
    When the user clicks on Register option
    And the user enters the details into below fields but does not follow Password complexity
    	| firstName 				| John       |
      | lastName  				| Kenedy     |
      | telephone 				| 1234567890 |
      | password  				| abcde   	 |
      | confirm password	| abcde			 |
     And the user selects Privacy Policy
     And the user clicks on Continue button
     Then the warning Message should be displayed for not following password complexity type
    @sanity
    Scenario: Leading and trailing spaces should be removed on sucessful account creation
    Given the user clicks on Myaccount drop Menu
    When the user clicks on Register option
    And the user enters valid details with leading and trailing spaces on respective fields
    And the user selects Privacy Policy
    And the user clicks on Continue button
    Then user should check there is no any spaces contains on respective fields on edit account information page