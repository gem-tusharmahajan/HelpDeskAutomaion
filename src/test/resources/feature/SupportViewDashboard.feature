#Feature: Support view functions
#
#  Background: Login into helpdesk
#
#    Given User is on login Page of helpdesk
#    Then Verify user is on homepage of helpdesk
#    And Login into Helpdesk portal
#    When Enter email id in input field
#    When Enter password in input field
#    And Click on "Yes" button
#    And Select "Support View" view
#
#  Scenario: Verify user is on Support view HomePage
#    Then Verify support view window opens
#
#  Scenario: Verify Count of tickets in Assigned window
#    When Get "Assigned" ticket count
#    Then Verify ticket count at header is same as footer
#
#  Scenario: Verify Count of tickets in unAssigned window
#    When Get "Unassigned" ticket count
#    Then Verify ticket count at header is same as footer for unassigned
#
#
#  Scenario: Verify Count of tickets in My Departmets window
#    When Get "My Department" ticket count
#    Then Verify ticket count at header is same as footer for unassigned