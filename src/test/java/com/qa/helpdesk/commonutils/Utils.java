package com.qa.helpdesk.commonutils;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.helpdesk.locators.*;

import com.qa.helpdesk.stepdefinition.StepDefinition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayList;

import static com.gemini.generic.ui.utils.DriverAction.waitSec;

public class Utils {

    Logger logger = LoggerFactory.getLogger(StepDefinition.class);


    boolean checkSorting(ArrayList< String > arraylist)
    {
        boolean isSorted=true;
        for(int i=1;i < arraylist.size();i++){
            if(arraylist.get(i-1).compareTo(arraylist.get(i)) > 0){
                isSorted= false;
                break;
            }
        }
        return isSorted;
    }


    public void clickBtn(String btnName)
    {
        boolean elementPresent = false;
        waitSec(3);

           switch (btnName)
            {
                case "clear data":
                {
                    try {
                        elementPresent = DriverAction.isExist(calendar.clearDataBtn);
                        DriverAction.click(calendar.clearDataBtn,"clear data");
                    }
                    catch (Exception e)
                    {
                        GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                        throw new RuntimeException(e);
                    }
                    break;
                }

                case "previous":
                {
                    try
                    {
                        elementPresent = DriverAction.isExist(calendar.previousNavigationButton);
                        DriverAction.click(calendar.previousNavigationButton);
                    }
                    catch (Exception e)
                    {
                        GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                        throw new RuntimeException(e);
                    }
                    break;
                }

                case "next":
                {
                    try
                    {
                        elementPresent = DriverAction.isExist(calendar.nextNavigationButton);
                        DriverAction.click(calendar.nextNavigationButton);
                    }
                    catch (Exception e)
                        {
                        GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                        throw new RuntimeException(e);
                        }
                    break;
                }
                case "timeline":
                {
                    try
                    {
                        elementPresent = DriverAction.isExist(TicketDeletion.timelineButton);
                        DriverAction.click(TicketDeletion.timelineButton);
                    }
                    catch (Exception e)
                    {
                        GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                        throw new RuntimeException(e);
                    }
                    break;
                }
                case "clear All":
                {
                    try
                    {
                    elementPresent = DriverAction.isExist(Filter.clearAll);
                    DriverAction.click(Filter.clearAll);
                    }
                    catch (Exception e)
                    {
                        GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                        throw new RuntimeException(e);
                    }
                    break;

                }
                case "collapse":
                {
                    try {
                        elementPresent = DriverAction.isExist(Dashboard.collapseButton);
                        DriverAction.click(Dashboard.collapseButton," Collapsed button");
                    }
                    catch (Exception e)
                    {
                        GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                        throw new RuntimeException(e);
                    }
                    break;
                }
                case "next page":
                {
                    try {
                        elementPresent = DriverAction.isExist(Pagination.nextButton);
                        DriverAction.click(Pagination.nextButton);
                    }
                    catch (Exception e){
                        GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                        throw new RuntimeException(e);
                    }
                    break;
                }
                case "previous page":
                {
                    try {
                        elementPresent = DriverAction.isExist(Pagination.previousButton);
                        DriverAction.click(Pagination.previousButton);
                    }
                    catch (Exception e)
                    {
                        GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                        throw new RuntimeException(e);
                    }
                    break;
                }

                case "logOut":
                {
                    try {
                        elementPresent = DriverAction.isExist(Dashboard.logOutButton);
                        DriverAction.click(Dashboard.logOutButton);
                    }
                    catch (Exception e)
                    {
                        GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                        throw new RuntimeException(e);
                    }
                    break;
                }

                case "close":
                    {
                    try
                    {
                        elementPresent = DriverAction.isExist(Dashboard.crossButton);
                        DriverAction.click(Dashboard.crossButton);
                    }
                    catch (Exception e)
                    {
                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                    }
                    break;
                    }
                case "cross":
                {
                    try
                    {
                        elementPresent = DriverAction.isExist(Filter.crossFilterButton);
                        DriverAction.click(Filter.crossFilterButton);
                    }
                    catch (Exception e)
                    {
                        GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                        throw new RuntimeException(e);
                    }
                    break;
                }

            case "notification":
            {
                try
                {
                elementPresent = DriverAction.isExist(LoginPage.notificationIcon);
                DriverAction.click(LoginPage.notificationIcon);
                }
                catch (Exception e)
                {
                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
                break;
            }
                case "support":
                {
                    try {
                        elementPresent=DriverAction.isExist(LoginPage.supportIcon);
                        DriverAction.click(LoginPage.supportIcon);
                    }
                    catch (Exception e)
                    {
                        GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                        throw new RuntimeException(e);
                    }
                    break;
                }

            case "User Guide":
            {
//                waitSec(4);
                try {
                    elementPresent = DriverAction.isExist(Dashboard.userGuide);
                    DriverAction.click(Dashboard.userGuide);
                    }
                catch (Exception e)
                {
                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
                break;
            }
                case "Page Per Dropdown":
                {
                    try {
                        elementPresent = DriverAction.isExist(Pagination.pagePerDropdown);
                        DriverAction.click(Pagination.pagePerDropdown);
                    }
                    catch (Exception e) {
                        GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                        throw new RuntimeException(e);
                    }
                    break;

                }
                case "unread":
                {
                    try {
                        elementPresent = DriverAction.isExist(Notification.unreadNotifications);
                        DriverAction.click(Notification.unreadNotifications);
                    }
                    catch (Exception e) {

                        GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                        throw new RuntimeException(e);
                    }
                    break;
                }

            case "deleteTicketIcon":
            {
                try {
                    elementPresent = DriverAction.isExist(TicketDeletion.options);
                    DriverAction.click(TicketDeletion.options);
                } catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);

                }
                break;
            }

            case "create new ticket":
            {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.createTicket);
                    DriverAction.click(TicketCreation.createTicket);
                } catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
                break;
            }

            case "Yes":
            {
                try
                {
                    elementPresent = DriverAction.isExist(LoginPage.outlookYesBtn);
                    DriverAction.waitUntilElementClickable(LoginPage.outlookYesBtn,10);
                    DriverAction.click(LoginPage.outlookYesBtn,"yes button");
                    waitSec(5);
                }
                catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
                break;
            }

            case "filter":
            {
                try {
                    elementPresent = DriverAction.isExist(LoginPage.filterIcon);
                    DriverAction.click(LoginPage.filterIcon);
                }
                catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
                break;
            }
            case "toggle":
            {
                try {
                    elementPresent = DriverAction.isExist(LoginPage.toggleBtn);
                    DriverAction.click(LoginPage.toggleBtn);
                }
                catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
                break;
            }

            case "searchBar":
            {
                try {
                    elementPresent = DriverAction.isExist(SearchInTickets.searchTicket);
                    DriverAction.click(SearchInTickets.searchTicket);
                } catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
                break;
            }

            case "search":
            {
                try {
                    elementPresent = DriverAction.isExist(SearchInTickets.searchBar);
                    DriverAction.click(SearchInTickets.searchBar);
                }
                catch (Exception e)
                {
                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
                break;
            }

            case "Id":
            {
                try {
                    elementPresent = DriverAction.isExist(SearchInTickets.ticketIcon);
                    DriverAction.click(SearchInTickets.ticketIcon);
                    DriverAction.click(SearchInTickets.ticketIcon);
                } catch (Exception e)
                {
                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
                break;
            }
            case "subject": {
                try {
                    elementPresent = DriverAction.isExist(SearchInTickets.subjectIcon);
                    DriverAction.click(SearchInTickets.subjectIcon);
                } catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
                break;
            }
            case "department": {
                try {
                    elementPresent = DriverAction.isExist(SearchInTickets.departmentIcon);
                    DriverAction.click(SearchInTickets.departmentIcon);
                }
             catch (Exception e) {

                 GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                 throw new RuntimeException(e);
             }
                break;
            }

            case "date": {
                try {
                    elementPresent = DriverAction.isExist(SearchInTickets.ticketDateData);
                    DriverAction.click(SearchInTickets.ticketDateData);
                }
                catch (Exception e)
                {

                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
                break;
            }
            case "assigned To": {
             try {
                 elementPresent = DriverAction.isExist(SearchInTickets.assignedTo);
                 DriverAction.click(SearchInTickets.assignedTo);
             }
             catch (Exception e)
             {


                 GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                 throw new RuntimeException(e);
             }
                break;
            }
            case "status": {
                try {


                    elementPresent = DriverAction.isExist(SortTickets.status);
                    DriverAction.click(SearchInTickets.status);
                }

                catch (Exception e)
                {

                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
                break;
            }

            case "IT":
            {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.type);
                    DriverAction.click(TicketCreation.type);
                }
                catch (Exception e)
                {

                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
                break;
            }

            case "submit":
            {
                try
                {
                    elementPresent = DriverAction.isExist(TicketCreation.submitBtn);
                    DriverAction.click(TicketCreation.submitBtn);
                }
                catch (Exception e)
                {
                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
                break;
            }
            case "continue":
            {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.continueBtn);
                    DriverAction.waitUntilElementAppear(TicketCreation.continueBtn,10);
                    DriverAction.click(TicketCreation.continueBtn);
                }
catch (Exception e) {

                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
    throw new RuntimeException(e);
}
                break;
            }

            case "Category":
            {
 try {
     elementPresent = DriverAction.isExist(TicketCreation.category);
     DriverAction.click(TicketCreation.category);
 }
 catch (Exception e)
 {
     GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
     throw new RuntimeException(e);
 }
 break;
 }
            case "subCategory":
            {
 try {
     elementPresent=DriverAction.isExist(TicketCreation.subCategory);
     DriverAction.click(TicketCreation.subCategory);
 }
 catch (Exception e)
 {

     GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
     throw new RuntimeException(e);

 }
       break;
            }
            default:
            {
                break;
            }
        }
        if (elementPresent)
        {
        GemTestReporter.addTestStep("Verify button is clicked","User verifies "+btnName+"is present and clicked",STATUS.PASS,DriverAction.takeSnapShot());
        }
   else
    {
    GemTestReporter.addTestStep("Verify button is clicked","User verifies "+btnName+"is not present and clicked",STATUS.FAIL,DriverAction.takeSnapShot());
    }

 }

    public void inputField(String inputField) {

        boolean elementPresent = false;
        waitSec(5);
        switch (inputField) {

            case "Android":
            {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.subject);
                    DriverAction.click(TicketCreation.subject);
                    DriverAction.typeText(TicketCreation.subject, inputField);

                }
                catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL);
                    throw new RuntimeException(e);
                }
            break;
            }

            case "Haxm":
            {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.subject);
                    DriverAction.click(TicketCreation.subject);
                    DriverAction.typeText(TicketCreation.subject,inputField);
                }
                catch (Exception e)
                {
                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
                break;
            }

            case "Intellij":
            {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.subject);
                    DriverAction.click(TicketCreation.subject);
                    DriverAction.typeText(TicketCreation.subject, inputField);
                }
                catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
           break;
            }

            case "Eclipse":
            {
                try
                    {
                     elementPresent = DriverAction.isExist(TicketCreation.subject);
                     DriverAction.click(TicketCreation.subject);
                     DriverAction.typeText(TicketCreation.subject,inputField);
                    }
        catch (Exception e)
        {
            GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
            throw new RuntimeException(e);
        }
break;
}

            case "Incident": {
                try {
                    elementPresent = DriverAction.isExist(TicketCreation.incident);
                    DriverAction.click(TicketCreation.incident);
                }
                catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred","Exception: "+e,STATUS.FAIL,DriverAction.takeSnapShot());
                    throw new RuntimeException(e);
                }
            break;
            }
                case "Request":
                {
                    try {
                        elementPresent = DriverAction.isExist(TicketCreation.request);
                        DriverAction.click(TicketCreation.request);
                    }
                    catch (Exception e){

                        GemTestReporter.addTestStep("EXCEPTION ERROR", "SOME ERROR OCCURRED", STATUS.FAIL,DriverAction.takeSnapShot());
                    }
                }
                break;
        }
            if (elementPresent)
            {
                GemTestReporter.addTestStep("Verify button is clicked",inputField+ " is present and clicked",STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify button is clicked", "Element is not found", STATUS.FAIL,DriverAction.takeSnapShot());
            }
        }

    public static void waitForElement(By locator, int duration) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds((long) duration));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    }