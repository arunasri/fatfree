Feature: We are outlining login succesful/failure behavior
  On success user should be taken to home page
  On failure error should be displayed about the failure

  Scenario Outline: different logins
    Given User is on login page
    When User enters "<username>" and "<password>"
    Then User should land on dash board page
    Examples:
    | username | password |
    | georoge  | geroge   |
    | heather  | heather   |


  Scenario: george login test
    Given User is on login page
    When User enters "georoge" and "george"
    Then User should land on dash board page

  Scenario: heather login test
    Given User is on login page
    When User enters "heather" and "heather"
    Then User should land on dash board page

  Scenario: heather invalid login test
    Given User is on login page
    When User enters "heather" and "xxxx"
    Then User should land on login error page
