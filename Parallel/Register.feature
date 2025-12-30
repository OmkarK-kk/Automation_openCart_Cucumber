Feature: Registration

  @sanity
  Scenario: Subscriber Registration
    Given User launch chrome browser
    When User opens URl "https://tutorialsninja.com/demo/index.php"
    And Click on My Account link
    And Click on Register Button
    Then Page Title should be "Register Account"
    When User enters all user details
    And Select privacy check Box
    And Click on Continue Button
    Then Page Title should be "Your Account Has Been Created!"
    And Close browser

  @regression
  Scenario: Registration with multiple data
    Given User launch chrome browser
    When User opens URl "https://tutorialsninja.com/demo/index.php"
    And Click on My Account link
    And Click on Register Button
    Then Page Title should be "Register Account"
    When User enters all user details
      |fname  | lName|email|phone|pass|confPass|
      |Mayurf    | laleq  | maur120@gmail.com  | 9901099107 |Mayur778@ |Mayur778@ |
      |Sanilf    | sahanqe| sanl96@gmail.com |9870595671  |Sanil@767 |Sanil@767 |
      |sanjayf   |markeq  |sanjuy01@gmail.com  |8166516879  |Sanju@786 |Sanju@786 |
      |Nikhilf   |kaneq   |Nikhi870@gmail.com |98881621910 |Nikhil87@8|Nikhil87@8|
    And Select privacy check Box
    And Click on Continue Button
    Then Page Title should be "Your Account Has Been Created!"
    And Close browser


