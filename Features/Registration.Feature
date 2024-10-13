Feature: Account Registration

  @sanity
  Scenario: Successful Account Registration
    Given the user navigates to Register Account page
    When the user enters the details into below fields
      | firstName | John       |
      | lastName  | Kenedy     |
      | telephone | 1234567890 |
      | password  | test@123   |
    And the user selects Privacy Policy
    And the user clicks on Continue button
    Then the user account should get created successfully
    
  @regression
  Scenario: Register without entering any information
    Given the user navigates to Register Account page
    When User does not enter any information in the registration fields
    And the user clicks on Continue button
    Then An error message should be displayed for the mandatory fields
    
  @sanity
  Scenario: Yes option is selected for Newsletter field
    Given the user navigates to Register Account page
    When the user enters the details into below fields
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
    