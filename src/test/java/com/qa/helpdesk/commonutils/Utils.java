package com.qa.helpdesk.commonutils;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.helpdesk.locators.*;
import com.qa.helpdesk.stepdefinition.StepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.gemini.generic.ui.utils.DriverAction.waitSec;

public class Utils {

    Logger logger = LoggerFactory.getLogger(StepDefinition.class);


    public void clickBtn(String btnName) {
        boolean elementPresent = false;
        Utils.waitUntilLoaderDisappear();
        switch (btnName) {
            case "edit ticket": {
                try {
                    elementPresent = DriverAction.isExist(SupportDashboard.editTicket);
                    if (elementPresent) {
                        DriverAction.click(SupportDashboard.editTicket, "Edit ticket");
                    } else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }

                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "clear data": {
                try {
                    elementPresent = DriverAction.isExist(calendar.clearDataBtn);
                    if (elementPresent) {
                        DriverAction.click(calendar.clearDataBtn, "clear data");
                    } else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "previous": {
                try {
                    elementPresent = DriverAction.isExist(calendar.previousNavigationButton);
                    if (elementPresent) {
                        DriverAction.click(calendar.previousNavigationButton, "Previous navigation button");
                    } else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "VIP": {
                try {
                    elementPresent = DriverAction.isExist(SupportDashboard.vipButton);
                    if (elementPresent) {
                        DriverAction.click(SupportDashboard.vipButton, "VIP");
                    }
                    else
                    {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "next": {
                try {
                elementPresent = DriverAction.isExist(calendar.nextNavigationButton);
                if (elementPresent)
                {DriverAction.click(calendar.nextNavigationButton, "Next navigation button");
                }
                else
                {
                    GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                }
                }
                catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
                case "timeline": {
                try {
                    elementPresent = DriverAction.isExist(TicketDeletion.timelineButton);
                    if(elementPresent) {
                        DriverAction.click(TicketDeletion.timelineButton);
                    }
                else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "clear all": {
                try {
                    elementPresent = DriverAction.isExist(Filter.clearAll);
                    if(elementPresent){
                    DriverAction.click(Filter.clearAll);
                    }
                    else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;

            }
            case "collapse": {
                try {
                    elementPresent = DriverAction.isExist(Dashboard.collapseButton);
               if(elementPresent) {
                   DriverAction.click(Dashboard.collapseButton, " Collapsed button");
               }
               else {
                   GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
               }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "next page": {
                try {
                    elementPresent = DriverAction.isExist(Pagination.nextButton);
                    if(elementPresent) {
                        DriverAction.click(Pagination.nextButton);
                    }
                    else {
                   GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());

                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "Unassigned":
            {
                try
                {
                    elementPresent = DriverAction.isExist(SupportDashboard.type("Unassigned"));
                    if(elementPresent)
                    {
                        DriverAction.click(SupportDashboard.type("Unassigned"),"Unassigned");
                    }
                    else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }

                }
                catch (Exception e)
                {

                }
                break;
            }
            case "My Department":
            {
                try {
                    elementPresent = DriverAction.isExist(SupportDashboard.type("My Department"));
                    if(elementPresent)
                    {
                    DriverAction.click(SupportDashboard.type("My Department"),"My Department");
                    }
                    else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "arrowDown":
            {
                try {
                    elementPresent = DriverAction.isExist(SupportDashboard.arrowDown);
                    if(elementPresent)
                    {
                        DriverAction.click(SupportDashboard.arrowDown,"Arrow Down");
                    }
                    else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "Assign":
            {
                try {
                    elementPresent = DriverAction.isExist(SupportDashboard.assignToMe);
                    if(elementPresent)
                    {
                        DriverAction.click(SupportDashboard.assignToMe,"Assign to me");
                    }
                    else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }


            case "Resolved":
            {
                try {
                    elementPresent = DriverAction.isExist(SupportDashboard.status(btnName));
                    if(elementPresent)
                    {
                        DriverAction.click(SupportDashboard.status(btnName),btnName);
                    }
                    else
                    {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "On-Hold":
            {
                try {
                    elementPresent = DriverAction.isExist(SupportDashboard.status(btnName));
                    if(elementPresent)
                    {
                        DriverAction.click(SupportDashboard.status(btnName),btnName);
                    }
                    else
                    {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "previous page": {
                try {
                    elementPresent = DriverAction.isExist(Pagination.previousButton);
                    if(elementPresent)
                    {
                        DriverAction.click(Pagination.previousButton);
                    }
                    else
                    {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                 } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "logOut": {
                try
                {
               elementPresent = DriverAction.isExist(Dashboard.logOutButton);
               if(elementPresent)
               {
               DriverAction.click(Dashboard.logOutButton,"log out");
               }
               else
               {
               GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
               }
               } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "statusArrow":
            {
            try {
                elementPresent = DriverAction.isExist(SupportDashboard.statusDropdown);
                if(elementPresent)
                {
                DriverAction.click(SupportDashboard.statusDropdown,"Status dropdown");
                }
                else
                {
                GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                }
                }
                catch (Exception e) {
                GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                logger.info("An exception occurred!", e);
                throw new RuntimeException(e);
            }
            break;
            }
            case "close": {
                try {
                    elementPresent = DriverAction.isExist(Dashboard.crossButton);
                   if(elementPresent)
                   {
                   DriverAction.click(Dashboard.crossButton);
                   }
                   else
                   {
                   GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                   }
                }
                catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "cross": {
                try {
                    elementPresent = DriverAction.isExist(Filter.crossFilterButton);
                if(elementPresent) {
                    DriverAction.click(Filter.crossFilterButton);
                }
                else {
                    GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "notification": {
                try {

                    elementPresent = DriverAction.isExist(LoginPage.notificationIcon);
                 if(elementPresent)
                 {
                    DriverAction.click(LoginPage.notificationIcon,"Notification bell");
                }
                else {
                     GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                 }
                }
                catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "support": {
                try {
                    elementPresent = DriverAction.isExist(LoginPage.supportIcon);
                 if(elementPresent) {
                     DriverAction.click(LoginPage.supportIcon);
                 }
                else {
                     GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                 }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "User Guide": {
                try {
                    elementPresent = DriverAction.isExist(Dashboard.userGuide);
                  if(elementPresent) {
                      DriverAction.click(Dashboard.userGuide);
                  }
                  else {
                      GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                  }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "Page Per Dropdown": {
                try {
                    elementPresent = DriverAction.isExist(Pagination.pagePerDropdown);
                    if(elementPresent)
                    {
                    DriverAction.click(Pagination.pagePerDropdown);
                }
                    else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                }catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;

            }
            case "unread": {
                try {
                    elementPresent = DriverAction.isExist(Notification.unreadNotifications);

                    if(elementPresent) {
                        DriverAction.click(Notification.unreadNotifications);
                    }
                else{
                   GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }

                } catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "option": {
                try {
                    elementPresent = DriverAction.isExist(TicketDeletion.options);
                    if(elementPresent) {

                        DriverAction.click(TicketDeletion.options);
                    }
                    else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);

                }
                break;
            }

            case "create new ticket": {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.createTicket);
                if(elementPresent) {
                    DriverAction.click(TicketCreation.createTicket);
                }
                else {
                    GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                }
                }
                catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "Yes": {
                try {
                    elementPresent = DriverAction.isExist(LoginPage.outlookYesBtn);
                    if(elementPresent)
                    {
                        DriverAction.waitUntilElementClickable(LoginPage.outlookYesBtn, 10);
                    DriverAction.click(LoginPage.outlookYesBtn, "yes button");
                }
                    else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                }
                catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "filter": {
                try {
                    elementPresent = DriverAction.isExist(LoginPage.filterIcon);
                if(elementPresent) {
                    DriverAction.click(LoginPage.filterIcon);
                }
                else {
                    GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                }
                } catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "toggle": {
                try {
                    elementPresent = DriverAction.isExist(LoginPage.toggleBtn);
          if(elementPresent) {
              DriverAction.click(LoginPage.toggleBtn);
          }
                else
                {
                    GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                }
                } catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }


            case "searchBar": {
                try {
                    elementPresent = DriverAction.isExist(SearchInTickets.searchTicket);
                    if(elementPresent)
                    {
                        DriverAction.click(SearchInTickets.searchTicket);
                    }
                    else
                    {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "search": {
                try {
                    elementPresent = DriverAction.isExist(SearchInTickets.searchBar);
                    if(elementPresent) {
                        DriverAction.click(SearchInTickets.searchBar);
                    }
                else
                {
                    GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "Id": {
                try {
                    elementPresent = DriverAction.isExist(SearchInTickets.ticketIcon);
                    if(elementPresent){
                        DriverAction.click(SearchInTickets.ticketIcon);
                        DriverAction.click(SearchInTickets.ticketIcon);
                    }
                    else
                    {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "subject": {
                try {
                    elementPresent = DriverAction.isExist(SearchInTickets.subjectIcon);
                    if(elementPresent) {
                        DriverAction.click(SearchInTickets.subjectIcon);
                    }
                    else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "department": {
                try {
                    elementPresent = DriverAction.isExist(SearchInTickets.departmentIcon);

                 if(elementPresent) {
                     DriverAction.click(SearchInTickets.departmentIcon);
                 }
                 else {
                     GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                 }
                } catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "date": {
                try {
                    elementPresent = DriverAction.isExist(SearchInTickets.ticketDateData);
                   if(elementPresent) {
                       DriverAction.click(SearchInTickets.ticketDateData);
                   }
                   else {
                       GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                   }
                } catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "assigned To": {
                try {
                    elementPresent = DriverAction.isExist(SearchInTickets.assignedTo);
                if(elementPresent) {
         DriverAction.click(SearchInTickets.assignedTo);
        }
         else
        {
            GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
         }
        }
                catch (Exception e)
                {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "status": {
                try {
                    elementPresent = DriverAction.isExist(SortTickets.status);
                    if(elementPresent) {
                        DriverAction.click(SearchInTickets.status);
                    }
                    else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "IT": {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.type);
                    if(elementPresent) {
                        DriverAction.click(TicketCreation.type);
                    }
                    else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "submit": {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.submitBtn);
                  if(elementPresent) {
                DriverAction.click(TicketCreation.submitBtn);
                    }
                  else {
                      GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                  }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "continue": {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.continueBtn);
                    if(elementPresent) {
                        DriverAction.waitUntilElementAppear(TicketCreation.continueBtn, 10);
                        DriverAction.click(TicketCreation.continueBtn);
                    }
                    else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "Category": {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.category);
           if(elementPresent) {
               DriverAction.click(TicketCreation.category);
           }
           else {
               GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
           }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "supportSubCategory": {
                try {
                    elementPresent = DriverAction.isExist(SupportDashboard.subCategory);
                if(elementPresent){
                    DriverAction.click(SupportDashboard.subCategory);
                }
                else {
                    GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                }

                }
                catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "subCategory": {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.subCategory);
          if(elementPresent){
              DriverAction.click(TicketCreation.subCategory);
          }       else {
              GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
          }

                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "unassignedTicketId":
            {
                try {
                    elementPresent = DriverAction.isExist(SupportDashboard.unAssignedTicketId);
                    if(elementPresent){
                        DriverAction.click(SupportDashboard.unAssignedTicketId,"Ticket Id");
                    }
                    else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }

                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "AssignedTicketId":
            {
                try {
                    elementPresent = DriverAction.isExist(SupportDashboard.assignedTicketId);
                    if(elementPresent){
                        DriverAction.click(SupportDashboard.assignedTicketId,"Ticket Id");
                    }
                    else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "Assign Tab":
            {
                try {
                    elementPresent = DriverAction.isExist(SupportDashboard.assignTab);
                    if(elementPresent)
                    {
                        DriverAction.scrollToTop();
                        DriverAction.click(SupportDashboard.assignTab,"Assign tab");
                    }
                    else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "check":
            {
                try {
                    elementPresent = DriverAction.isExist(SupportDashboard.assignTab);
                    if(elementPresent)
                    {
                    DriverAction.click(Notification.checkButton,"Check button");
                    }
                    else {
                        GemTestReporter.addTestStep("Button clicks", btnName + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            default: {
                break;
            }
        }
        if (elementPresent) {
            GemTestReporter.addTestStep("Verify button is clicked", "User verifies " + btnName + " is present and clicked", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verify button is clicked", "User verifies " + btnName + " is not present and clicked", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    public void inputField(String inputField) {

        boolean elementPresent = false;
        waitSec(5);
        switch (inputField) {
            case "Android": {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.subject);
                  if(elementPresent) {
                      DriverAction.click(TicketCreation.subject);
                      DriverAction.typeText(TicketCreation.subject, inputField);
                  }
                  else {
                      GemTestReporter.addTestStep("Button clicks", inputField + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                  }

                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "Haxm": {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.subject);
                  if(elementPresent){
                      DriverAction.click(TicketCreation.subject);
                    DriverAction.typeText(TicketCreation.subject, inputField);
                  }
                  else {
                      GemTestReporter.addTestStep("Button clicks", inputField + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                  }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "Intellij": {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.subject);
                   if(elementPresent) {
                       DriverAction.click(TicketCreation.subject);
                       DriverAction.typeText(TicketCreation.subject, inputField);
                   }
                   else {
                       GemTestReporter.addTestStep("Button clicks", inputField + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                   }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "Eclipse": {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.subject);
                 if(elementPresent) {
                     DriverAction.click(TicketCreation.subject);
                     DriverAction.typeText(TicketCreation.subject, inputField);
                 }
                 else {
                     GemTestReporter.addTestStep("Button clicks", inputField + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                 }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }

            case "Incident": {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.incident);
                  if(elementPresent) {
                      DriverAction.click(TicketCreation.incident);
                  }
                  else {
                      GemTestReporter.addTestStep("Button clicks", inputField + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                  }
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "Request": {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.request);
                    if (elementPresent) {
                        DriverAction.click(TicketCreation.request);
                    } else {
                        GemTestReporter.addTestStep("Button clicks", inputField + "is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                }
                catch (Exception e)
                {
                    GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL, DriverAction.takeSnapShot());
                }
            break;
        }
        }
        if (elementPresent) {
            GemTestReporter.addTestStep("Verify button is clicked", inputField + " is present and clicked", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verify button is clicked", "Element is not found", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
    public static void waitForElement(By locator, int duration) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds((long) duration));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitUntilLoaderDisappear() {
        try {
            WebDriverWait webDriverWait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(30));
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(SupportDashboard.loader));
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            throw new RuntimeException(e);
        }
    }

}