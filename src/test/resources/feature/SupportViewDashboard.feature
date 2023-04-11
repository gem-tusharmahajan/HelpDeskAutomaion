Feature: Support view functions

  Background: Login Page

    Given User is on login Page of helpdesk
    Then Verify user is on homepage of helpdesk
    And Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    And Click on "Yes" button
    And Select "Support View" view

    Scenario: Verify user is on Support view HomePage
    Then Verify support view window opens


