Feature: Filter page functionalities

  Background: Login Page
    Given User is on login Page of helpdesk
    And Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    And Click on "Yes" button
    Then Verify user is still on login page
    Then Verify user is on homePage of helpdesk
    And Select "Employee View" view


  Scenario: Hide cancelled, closed and resolved tickets
    Then  Verify user is on homePage of helpdesk
    When Count number of tickets
    And Click on "filter" button
    Then Verify filter tab is opened
    And Click on "toggle" button
    And Click on "filter" button
    And Count number of filtered tickets


  Scenario Outline: Clear all filters
    And Click on "<filter>" button
    Then Verify filter tab is opened
    And Select "<department>" and select "<status>" in filter tab
    And Click on "filter" button
    When Count number of tickets
    And Click on "filter" button
    And Click on "clear all" button
    And Click on "filter" button
    When Count number of tickets again
    Examples:
      | department | status     |
      | IT         | Open       |
      | IT         | Unassigned |
      | IT         | Assigned   |
      | IT         | On Hold    |
      | IT         | Resolved   |
      | IT         | Cancelled  |
      | IT         | Closed     |
      | IT         | Re-opened  |
      | IT         | Rejected   |
      | HR         | Open       |
      | HR         | Unassigned |
      | HR         | Assigned   |
      | HR         | On Hold    |
      | HR         | Resolved   |
      | HR         | Cancelled  |
      | HR         | Closed     |
      | HR         | Re-opened  |
      | HR         | Rejected   |
      | Accounts   | Open       |
      | Accounts   | Unassigned |
      | Accounts   | Assigned   |
      | Accounts   | On Hold    |
      | Accounts   | Resolved   |
      | Accounts   | Cancelled  |
      | Accounts   | Closed     |
      | Accounts   | Re-opened  |
      | Accounts   | Rejected   |
      | Admin      | Open       |
      | Admin      | Unassigned |
      | Admin      | Assigned   |
      | Admin      | On Hold    |
      | Admin      | Resolved   |
      | Admin      | Cancelled  |
      | Admin      | Closed     |
      | Admin      | Re-opened  |
      | Admin      | Rejected   |
      | test dept  | Open       |
      | test dept  | Unassigned |
      | test dept  | Assigned   |
      | test dept  | On Hold    |
      | test dept  | Resolved   |
      | test dept  | Cancelled  |
      | test dept  | Closed     |
      | test dept  | Re-opened  |
      | test dept  | Rejected   |

  Scenario: Department filter
    And Click on "filter" button
    Then Verify filter tab is opened
    And Select the "IT"
    And Select the "Accounts"
    And Select the "HR"
    And Select the "Admin"
    And Select the "test dept"
    Then Verify filtered data is displayed in department column.


  Scenario: Status filter
    And Click on "filter" button
    Then Verify filter tab is opened
    And Select the "Open"
    And Select the "Unassigned"
    And Select the "Assigned"
    And Select the "On Hold"
    And Select the "Resolved"
    And Select the "Cancelled"
    And Select the "Closed"
    And Select the "Re-opened"
    And Select the "Rejected"
    And Click on "filter" button
    Then Verify filtered data is displayed in status column.


  Scenario Outline: Both filters (Department and Status)

    Then  Verify user is on homePage of helpdesk
    And Click on row per page dropDown
    When Count number of tickets
    When Click on "filter" button
    Then Verify filter tab is opened
    And Select "<department>" and select "<status>" in filter tab
    And Click on "filter" button
    And Count number of filtered tickets with "<department>" and "<status>"

    Examples:
      | department | status     |
      | IT         | Open       |
      | IT         | Unassigned |
      | IT         | Assigned   |
      | IT         | On Hold    |
      | IT         | Resolved   |
      | IT         | Cancelled  |
      | IT         | Closed     |
      | IT         | Re-opened  |
      | IT         | Rejected   |
      | HR         | Open       |
      | HR         | Unassigned |
      | HR         | Assigned   |
      | HR         | On Hold    |
      | HR         | Resolved   |
      | HR         | Cancelled  |
      | HR         | Closed     |
      | HR         | Re-opened  |
      | HR         | Rejected   |
      | Accounts   | Open       |
      | Accounts   | Unassigned |
      | Accounts   | Assigned   |
      | Accounts   | On Hold    |
      | Accounts   | Resolved   |
      | Accounts   | Cancelled  |
      | Accounts   | Closed     |
      | Accounts   | Re-opened  |
      | Accounts   | Rejected   |
      | Admin      | Open       |
      | Admin      | Unassigned |
      | Admin      | Assigned   |
      | Admin      | On Hold    |
      | Admin      | Resolved   |
      | Admin      | Cancelled  |
      | Admin      | Closed     |
      | Admin      | Re-opened  |
      | Admin      | Rejected   |
      | test dept  | Open       |
      | test dept  | Unassigned |
      | test dept  | Assigned   |
      | test dept  | On Hold    |
      | test dept  | Resolved   |
      | test dept  | Cancelled  |
      | test dept  | Closed     |
      | test dept  | Re-opened  |
      | test dept  | Rejected   |


  Scenario: Close filter button
    And Click on "filter" button
    Then Verify filter tab is opened
    And Click on "cross" button
    Then Verify filter tab is closed

      