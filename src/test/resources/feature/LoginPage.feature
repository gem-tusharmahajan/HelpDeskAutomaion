Feature: Login Page Automation

  Background: Login to helpdesk with valid credentials
    Given User is on login Page of helpdesk
    And Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    And Click on "Yes" button
    Then Verify user is still on login page
    Then Verify user is on homePage of helpdesk
    And Select "Employee View" view

  Scenario: Verify helpdesk homepage icons
    Then Verify user is on homePage of helpdesk
    Then Verify logged in username and designation


    Scenario: Login to helpdesk with invalid credentials
      Given User is on login Page of helpdesk
      Then Verify user is on homePage of helpdesk
      And  Login into Helpdesk portal
      When Enter email id in input field
      When Enter wrong password in input field
      Then Verify credentials are wrong
