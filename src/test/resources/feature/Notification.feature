Feature: User guide functionalities

  Background: Login Page
    Given User is on login Page of helpdesk
    Then Verify user is on homepage of helpdesk
    And Login into Helpdesk portal
    When Enter email id in input field
    When Enter password in input field
    And Click on "Yes" button
    When Select "Employee View" view


    Scenario: Verify notification bell is open
      And Click on "notification" button
      Then Verify notifications tab is opened

  Scenario: Verify Unread Notification Count
    And Click on "notification" button
    When Count number of tickets on notification button
    Then Verify notifications tab is opened
    When Count unread notifications


  Scenario: Verify show more in notification
    And Click on "notification" button
    Then Verify show more button displays


  Scenario: Navigate to a Ticket from Notifications

    And Click on "notification" button
    And Click on "unread" button
    When Navigate to first ticket details