Feature: Login Opencart

  @sanity
  Scenario: Successful login with valid credential
    Given User launch chrome browser
    When User opens URl "https://tutorialsninja.com/demo/index.php"
    And Click on My Account link
    And Click on Login Button
    Then Page Title should be "Account Login"
    And User enters Username as "vikas11@gmail.com"
    And User enters as Password as "Rajesh@12"
    And Click on Login
    Then Page Title should be "My Account"
    When Click on My Account link
    And User click on Logout button
    Then Page Title should be "Account Logout"
    And Close browser

  @regression
   Scenario Outline: Login with Multiple Usernames
     Given User launch chrome browser
     When User opens URl "https://tutorialsninja.com/demo/index.php"
     And Click on My Account link
     And Click on Login Button
     Then Page Title should be "Account Login"
     And User enters Username as "<Username>"
     And User enters as Password as "<Password>"
     And Click on Login
     Then Page Title should be "My Account"
     When Click on My Account link
     And User click on Logout button
     Then Page Title should be "Account Logout"
     And Close browser
     Examples:
       | Username | Password |
     |    vikas11@gmail.com      |     Rajesh@12     |
     |    sukesh1@gmail.com      |    Sukesh@12      |
     |     Devil11@gmail.com     |    Ramesh@10      |
     |     Mukesh12@gmail.com     |      Mukesh@16    |
     |    Rohii@gmail            |      mkiuah@1             |

