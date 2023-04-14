#Feature: Edit tickets
#
#  Background: Login into Helpdesk
#    Given User is on login Page of helpdesk
#    Then Verify user is on homepage of helpdesk
#    Given Login into Helpdesk portal
#    When Enter email id in input field
#    When Enter password in input field
#    And Click on "Yes" button
#    Then Verify user is still on login page
#    And Select "Support View" view
#
#  Scenario Outline: ticket edits using action button
#    And Click on "option" button
#    And Click on "edit ticket" button
#    And Click on "category" button
#    When Select "<categoryType>" from category option
#    And Click on "supportSubCategory" button
#    When Select "<subCategoryType>" from subCategory options
#    And Enter "configuration item" details
#    And Select "<name>" from Assigned To options
#    And Select "<status>" from status dropdown
#    And Click on "submit" button
#    Examples:
#      | categoryType   | subCategoryType            | name           | status   |
#      | Exit Clearance | Exit Clearance formalities | Tushar Mahajan | Assigned |
#      | Joining        | Welcome Kit allocation     | Tushar Mahajan | Assigned |
#      | Miscellaneous  | Audit Processes            | Tushar Mahajan | Assigned |
#      | Miscellaneous  | Audit Distribution         | Tushar Mahajan | Assigned |
#      | Exit Clearance | Exit Clearance formalities | Tushar Mahajan | On Hold  |
#      | Joining        | Welcome Kit allocation     | Tushar Mahajan | On Hold  |
#      | Miscellaneous  | Audit Processes            | Tushar Mahajan | On Hold  |
#      | Miscellaneous  | Audit Distribution         | Tushar Mahajan | On Hold  |
#      | Exit Clearance | Exit Clearance formalities | Tushar Mahajan | Resolved |
#      | Joining        | Welcome Kit allocation     | Tushar Mahajan | Resolved |
#      | Miscellaneous  | Audit Processes            | Tushar Mahajan | Resolved |
#      | Miscellaneous  | Audit Distribution         | Tushar Mahajan | Resolved |
#      | Exit Clearance | Exit Clearance formalities | Vishal Gautam  | Assigned |
#      | Joining        | Welcome Kit allocation     | Vishal Gautam  | Assigned |
#      | Miscellaneous  | Audit Processes            | Vishal Gautam  | Assigned |
#      | Miscellaneous  | Audit Distribution         | Vishal Gautam  | Assigned |
#      | Exit Clearance | Exit Clearance formalities | Vishal Gautam  | On Hold  |
#      | Joining        | Welcome Kit allocation     | Vishal Gautam  | On Hold  |
#      | Miscellaneous  | Audit Processes            | Vishal Gautam  | On Hold  |
#      | Miscellaneous  | Audit Distribution         | Vishal Gautam  | On Hold  |
#      | Exit Clearance | Exit Clearance formalities | Vishal Gautam  | Resolved |
#      | Joining        | Welcome Kit allocation     | Vishal Gautam  | Resolved |
#      | Miscellaneous  | Audit Processes            | Vishal Gautam  | Resolved |
#      | Miscellaneous  | Audit Distribution         | Vishal Gautam  | Resolved |
#
#
#
#
#
#  Scenario Outline: ticket edits from edit icon
#    And Click on ticket id
#    And Click on "edit ticket" button
#    And Click on edit ticket icon
#    And Click on "category" button
#    When Select "<categoryType>" from category option
#    And Click on "supportSubCategory" button
#    When Select "<subCategoryType>" from subCategory options
#    And Enter "configuration item" details
#    And Select "<name>" from Assigned To options
#    And Select "<status>" from status dropdown
#    And Click on "submit" button
#    Examples:
#      | categoryType   | subCategoryType            | name           | status   |
#      | Exit Clearance | Exit Clearance formalities | Tushar Mahajan | Assigned |
#      | Joining        | Welcome Kit allocation     | Tushar Mahajan | Assigned |
#      | Miscellaneous  | Audit Processes            | Tushar Mahajan | Assigned |
#      | Miscellaneous  | Audit Distribution         | Tushar Mahajan | Assigned |
#      | Exit Clearance | Exit Clearance formalities | Tushar Mahajan | On Hold  |
#      | Joining        | Welcome Kit allocation     | Tushar Mahajan | On Hold  |
#      | Miscellaneous  | Audit Processes            | Tushar Mahajan | On Hold  |
#      | Miscellaneous  | Audit Distribution         | Tushar Mahajan | On Hold  |
#      | Exit Clearance | Exit Clearance formalities | Tushar Mahajan | Resolved |
#      | Joining        | Welcome Kit allocation     | Tushar Mahajan | Resolved |
#      | Miscellaneous  | Audit Processes            | Tushar Mahajan | Resolved |
#      | Miscellaneous  | Audit Distribution         | Tushar Mahajan | Resolved |
#      | Exit Clearance | Exit Clearance formalities | Vishal Gautam  | Assigned |
#      | Joining        | Welcome Kit allocation     | Vishal Gautam  | Assigned |
#      | Miscellaneous  | Audit Processes            | Vishal Gautam  | Assigned |
#      | Miscellaneous  | Audit Distribution         | Vishal Gautam  | Assigned |
#      | Exit Clearance | Exit Clearance formalities | Vishal Gautam  | On Hold  |
#      | Joining        | Welcome Kit allocation     | Vishal Gautam  | On Hold  |
#      | Miscellaneous  | Audit Processes            | Vishal Gautam  | On Hold  |
#      | Miscellaneous  | Audit Distribution         | Vishal Gautam  | On Hold  |
#      | Exit Clearance | Exit Clearance formalities | Vishal Gautam  | Resolved |
#      | Joining        | Welcome Kit allocation     | Vishal Gautam  | Resolved |
#      | Miscellaneous  | Audit Processes            | Vishal Gautam  | Resolved |
#      | Miscellaneous  | Audit Distribution         | Vishal Gautam  | Resolved |
