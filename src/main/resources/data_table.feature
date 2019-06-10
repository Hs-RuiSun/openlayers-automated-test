Feature: how data table works in cucumber

  Scenario:
    Given User is on Home Page
    When User Navigate to LogIn Page
    And User enters Credentials to LogIn
      | Username   | Password |
      | testuser_1 | Test@153 |
      | testuser_2 | Test@154 |
    Then Message displayed Login Successfully