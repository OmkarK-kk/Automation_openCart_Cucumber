Feature: Edit Account details

  Background:
    Given User launch chrome browser
    When User opens URl "https://tutorialsninja.com/demo/index.php"
    And Click on My Account link
    And Click on Login Button
    Then Page Title should be "Account Login"

  @regression
  Scenario: Edit LastName
    When User enters Username as "rutik11@gmail.com"
    And User enters as Password as "Ruiti12@"
    And Click on Login
    When User click on Edit Account
    Then Page Title should be "My Account Information"
    When User edit lastname
    And Click on Continue Button
    Then Page Title should be displayed "Success: Your account has been successfully updated."
    When Click on My Account link
    And User click on Logout button
    Then Page Title should be "Account Logoutt"
    And Close browser

  @sanity @regression
  Scenario: Edit Telephone
    When User enters Username as "satish12@gmail.com"
    And User enters as Password as "Satish@12"
    And Click on Login
    When User click on Edit Account
    Then Page Title should be "My Account Information"
    When User edit Telephone
    And Click on Continue Button
    Then Page Title should be displayed "Success: Your account has been successfully updated."
    When Click on My Account link
    And User click on Logout button
    Then Page Title should be "Account Logout"
    And Close browser