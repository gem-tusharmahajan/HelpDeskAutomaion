Feature: Login Page Automation

  Background: Login to helpdesk with valid credentials
    Given User is on login Page of helpdesk
    Then Verify user is on homepage of helpdesk
    And Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    And Click on "Yes" button
    And Select "Employee View" view

  Scenario: Verify helpdesk homepage icons
    Then Verify user is on HomePage of Helpdesk
    Then Verify logged in username and designation


    Scenario: Login to helpdesk with invalid credentials
      Given User is on login Page of helpdesk
      Then Verify user is on homepage of helpdesk
      And  Login into Helpdesk portal
      When Enter email id in input field
      When Enter wrong password in input field
      Then Verify credentials are wrong
