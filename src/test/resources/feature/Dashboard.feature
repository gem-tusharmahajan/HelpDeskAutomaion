Feature: Dashboard functionalities

  Background: Login into Helpdesk
    Given User is on login Page of helpdesk
    Then Verify user is on homepage of helpdesk
    And Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    And Click on "Yes" button
    And Select "Employee View" view

  Scenario: user guide window
    Then Verify user guide pdf gets opens

  Scenario: check functions of user guide window
    Then Verify user guide pdf gets opens
    And Click on copyLink button
    Then Verify copiedLink tab is opened
    And Click on close button

  Scenario: Verify the contact us functionality
    And Click on support button
    Then Verify contact email id is present
    And Click on close button of contact us

  Scenario: Verify side menu and collapsed button.
    Then Verify user is on HomePage of Helpdesk
    Then Verify side menu is collapsed
    And Click on collapse button
    Then Verify side menu is collapsed

  Scenario: User Log Out the HelpDesk
    Then Verify user is on HomePage of Helpdesk
    And Click on logout button
    Then Verify user is on homepage of helpdesk
