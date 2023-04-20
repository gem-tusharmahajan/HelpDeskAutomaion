Feature: Ticket creation

  Background: Login Page

    Given User is on login Page of helpdesk
    Then Verify user is on homePage of helpdesk
    And Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    And Click on "Yes" button
    Then Verify user is still on login page
    Then Verify user is on homePage of helpdesk
    And Select "Employee View" view


  Scenario Outline: Check 'Create Ticket' functionality for type 'Incident' and without attachment
    When Click on "create new ticket" button
    Then Verify create new ticket tab opens
    And Enter data in "<subject>" field
    And Click on "<Type>" button
    And Select "<select>" from options
    And Enter description in ticket window
    And Select "<Department>" in ticket window
    And Upload file
    When Get all the required validation data
    And click on preview button
    Then Verify data in preview tab
    And Click on "submit" button

    Examples:
      | subject | Type | select   | Department |
      | Android | IT   | Incident | IT         |
      | Android | IT   | Incident | Accounts   |
      | Android | IT   | Incident | Admin      |
      | Android | IT   | Incident | HR         |


  Scenario Outline: Check 'Create Ticket' functionality for type 'Incident' with attachment

    When Click on "create new ticket" button
    Then Verify create new ticket tab opens
    When Enter data in "<subject>" field
    When Click on "<Type>" button
    When Select "<select>" from options
    When Enter description in ticket window
    When Select "<Department>" in ticket window
    When Get all the required validation data to create ticket without uploading a file
    And click on preview button
    Then Verify data in preview tab without uploading a file
    And Click on "submit" button

    Examples:
      | subject | Type | select   | Department |
      | Android | IT   | Incident | IT         |
      | Android | IT   | Incident | Accounts   |
      | Android | IT   | Incident | Admin      |
      | Android | IT   | Incident | HR         |


# REQUEST

  Scenario Outline: Check 'Create Ticket' functionality for type 'Request' and with attachment

    When Click on "create new ticket" button
    Then Verify create new ticket tab opens
    And Enter data in "<subject>" field
    And Click on "<Type>" button
    When Select "<select>" from options
    When Enter description in ticket window
    When Select "<Department>" in ticket window
    And Click on "Category" button
    When Select "<categoryType>" from category option
    And Click on "subCategory" button
    When Select "<subCategoryType>" from subCategory options
    When Upload file
    When Get all the required validation data with Request status
    And click on preview button
    Then Verify ticket data with displayed data
    And Click on "submit" button

    Examples:
      | subject | Type | select  | Department | categoryType     | subCategoryType                |
      | Android | IT   | Request | IT         | sample req type  | sub type 1                     |
      | Haxm    | IT   | Request | IT         | sample req type  | sub type 2                     |
      | Android | IT   | Request | IT         | Access Request   | Creation Of DL/o365 group      |
      | Android | IT   | Request | IT         | Access Request   | Modification of DL/o365 group  |
      | Android | IT   | Request | IT         | Access Request   | Modification of security group |
      | Android | IT   | Request | IT         | Access Request   | New Security group             |
      | Android | IT   | Request | Accounts   | Travel           | Travel cards                   |
      | Haxm    | IT   | Request | Accounts   | Travel           | Travel insurance               |
      | Android | IT   | Request | HR         | Leave Management | Compensatory Off               |
      | Haxm    | IT   | Request | HR         | Leave Management | LNSA                           |
      | Haxm    | IT   | Request | HR         | Leave Management | Missed Leaves                  |
      | Android | IT   | Request | Admin      | sample req type  | sub type 3                     |
      | Haxm    | IT   | Request | Admin      | sample req type  | sub type 4                     |
      | Haxm    | IT   | Request | Admin      | Facility         | Courier requirements           |
      | Haxm    | IT   | Request | Admin      | Hardware         | Mobile Devices                 |
      | Haxm    | IT   | Request | Admin      | Registration     | Access card or Face scanner    |


  Scenario Outline: Check 'Create Ticket' functionality for type 'Request' and without attachment

    When Click on "create new ticket" button
    Then Verify create new ticket tab opens
    And Enter data in "<subject>" field
    And Click on "<Type>" button
    When Select "<select>" from options
    When Enter description in ticket window
    When Select "<Department>" in ticket window
    And Click on "Category" button
    When Select "<categoryType>" from category option
    And Click on "subCategory" button
    When Select "<subCategoryType>" from subCategory options
    When Upload file
    When Get all the required validation data with Request status without attachment
    And click on preview button
    Then Verify ticket data with displayed data without attachment
    And Click on "submit" button

    Examples:
      | subject | Type | select  | Department | categoryType     | subCategoryType                |
      | Android | IT   | Request | IT         | sample req type  | sub type 1                     |
      | Haxm    | IT   | Request | IT         | sample req type  | sub type 2                     |
      | Android | IT   | Request | IT         | Access Request   | Creation Of DL/o365 group      |
      | Android | IT   | Request | IT         | Access Request   | Modification of DL/o365 group  |
      | Android | IT   | Request | IT         | Access Request   | Modification of security group |
      | Android | IT   | Request | IT         | Access Request   | New Security group             |
      | Android | IT   | Request | Accounts   | Travel           | Travel cards                   |
      | Haxm    | IT   | Request | Accounts   | Travel           | Travel insurance               |
      | Android | IT   | Request | HR         | Leave Management | Compensatory Off               |
      | Haxm    | IT   | Request | HR         | Leave Management | LNSA                           |
      | Haxm    | IT   | Request | HR         | Leave Management | Missed Leaves                  |
      | Android | IT   | Request | Admin      | sample req type  | sub type 3                     |
      | Haxm    | IT   | Request | Admin      | sample req type  | sub type 4                     |
      | Haxm    | IT   | Request | Admin      | Facility         | Courier requirements           |
      | Haxm    | IT   | Request | Admin      | Hardware         | Mobile Devices                 |
      | Haxm    | IT   | Request | Admin      | Registration     | Access card or Face scanner    |


  Scenario: Submit Create Ticket form without filling mandatory fields [Negative scenario]

    When Click on "create new ticket" button
    Then Verify create new ticket tab opens
    And Click on "submit" button
    Then Verify error messages appear


  Scenario: Check file upload with specified extensions and size limits
    And Click on "create new ticket" button
    Then Verify create new ticket tab opens
    When Upload file
    Then Verify file is uploaded.


  Scenario: Check file upload with invalid extensions and valid size limits
    And Click on "create new ticket" button
    Then Verify create new ticket tab opens
    When Upload file with invalid extension
    Then Verify file is uploaded.


  Scenario: Check file upload with valid extensions and invalid size limits

    When Click on "create new ticket" button
    Then Verify create new ticket tab opens
    When Upload file with valid extension and large size
    Then Verify alert appears


  Scenario: Check multiple files can be attached with valid extensions and size limit
    When Click on "create new ticket" button
    Then Verify create new ticket tab opens
    When Upload multiple files with valid extension and specified size
    Then Verify multiple files uploaded


#  Scenario Outline: Check 'Create Ticket' functionality for type 'Request' and without attachment and check comments added
#
#    And Click on "<create new ticket>" button
#    Then Verify create new ticket tab opens
#    And Enter data in "<subject>" field
#    And Click on "<Type>" button
#    And Select "<select>" from options
#    And Enter description in ticket window
#    And Select "<Department>" in ticket window
#    And Click on "<category>" button
#    And Select "<categoryType>" from category option
#    And Click on "<subCategory>" button
#    And Select "<subCategoryType>" from subCategory options
#    When Get all the required validation data with Request status
#    And Click on submit btn
#    And Click on "<continue>" button
#    And Click on ticket id
#    Then Verify ticket data with displayed data
#    Then Verify data is updated when user enter in comments and upload files
#
#    Examples:
#      | create new ticket | subject | Type | select  | Department | continue | category | categoryType    | subCategory | subCategoryType                |
#      | create new ticket | Android | IT   | Request | IT         | continue | Category | sample req type | subCategory | sub type 1                     |
#      | create new ticket | Haxm    | IT   | Request | IT         | continue | Category | sample req type | subCategory | sub type 2                     |
#      | create new ticket | Android | IT   | Request | IT         | continue | Category | Access Request  | subCategory | Creation Of DL/o365 group      |
#      | create new ticket | Android | IT   | Request | IT         | continue | Category | Access Request  | subCategory | Modification of DL/o365 group  |
#      | create new ticket | Android | IT   | Request | IT         | continue | Category | Access Request  | subCategory | Modification of security group |
#      | create new ticket | Android | IT   | Request | IT         | continue | Category | Access Request  | subCategory | New Security group             |
#
#
#
#
#
