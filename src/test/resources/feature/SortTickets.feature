Feature: Sort my tickets

  Background: Login Page
    Given User is on login Page of helpdesk
    Then Verify user is on homepage of helpdesk
    And Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    And Click on "Yes" button
    Then Verify user is still on login page
    And Select "Employee View" view


  Scenario: check tickets are sorted in ascending order using ticket subject
    When Get ticket subject
    And Click on row per page dropDown
    Then Verify tickets get sorted in ascending order

    Scenario: sort tickets using id
      When Get ticket id
      And Click on "id" button
      Then Verify first ticket id gets change

  Scenario: sort tickets using department
    When Get ticket department
    And Click on "department" button
    Then Verify first ticket department gets change


  Scenario: sort tickets using created on
    When Get ticket date
    And Click on "date" button
    Then Verify first ticket date gets change

  Scenario: Sort tickets using assigned to
    When Get assigned on person data
    And Click on "assigned To" button
    Then Verify first ticket assigned person gets change

  Scenario: sort tickets using status
    When Get status of ticket
    And Click on "Status" button
    Then Verify first ticket status gets change




