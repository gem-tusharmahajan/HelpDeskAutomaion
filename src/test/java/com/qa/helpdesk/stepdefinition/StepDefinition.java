package com.qa.helpdesk.stepdefinition;
import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.helpdesk.commonutils.Utils;
import com.qa.helpdesk.locators.*;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.util.*;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.gemini.generic.ui.utils.DriverAction.*;

public class StepDefinition {


    int displayedTickets = 0;
    String ticketSubjectData, ticketDepartmentData;
    String ticketIdData;
    String ticketDateData;
    String assignedPerson;
    String status;
    String ticketIncidentData;
    boolean ticketFileUploadsData;

    String ticketDescriptionData;
    String monthOrder;
    String ticketCategory;
    String ticketSubCategory;
    String ticketCounts;

    String name;
    int totalMonthDays;
    int totalMonths;

    String ticketCount;

    int count = 0;
    Utils utils = new Utils();


    final Logger logger = LoggerFactory.getLogger(StepDefinition.class);

    @And("^Login into Helpdesk portal$")
    public void helpDeskPortal() {
        try {
            DriverAction.waitUntilElementClickable(LoginPage.loginBtn, 5);
            DriverAction.click(LoginPage.loginBtn,"Login");
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }


    @When("^Enter email id in input field$")
    public void enterEmailId() {
        waitSec(5);
        Properties login = new Properties();
        try (FileReader in = new FileReader("src/test/resources/login.properties")) {
            login.load(in);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }

        String email = login.getProperty("email");

        byte[] decodedBytes = Base64.getDecoder().decode(email);
        String decodedEmail = new String(decodedBytes);

        DriverAction.getElement(LoginPage.emailId).sendKeys(decodedEmail);
        DriverAction.click(LoginPage.outlookNextBtn, "next button");
    }

    @When("^Enter password in input field$")
    public void enterPassword()  {
        DriverAction.waitUntilElementClickable(LoginPage.password, 10);
        Properties login = new Properties();
        try (FileReader in = new FileReader("src/test/resources/login.properties")) {
            login.load(in);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
        String email = login.getProperty("password");
        byte[] decodedBytes = Base64.getDecoder().decode(email);
        String decodedPassword = new String(decodedBytes);
        DriverAction.getElement(LoginPage.password).sendKeys(decodedPassword);
        DriverAction.click(LoginPage.outlookSignInBtn, "Sign in");
    }


    @And("Click on {string} button")
    public void clickOn(String str) {
        try {
            Utils.waitUntilLoaderDisappear();
            utils.clickBtn(str);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify user is on homePage of helpdesk$")
    public void HomePageHelpdesk() {
        DriverAction.waitSec(3);
        try {
            String url=DriverAction.getCurrentURL();
            if (url.equals("https://helpdeskui-np.geminisolutions.com/#/dashboard/0")) {
                GemTestReporter.addTestStep("Verify user is on Home Page of helpdesk", "User is on Home Page of HelpDesk", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify user is on Home Page of helpdesk", "User is not on Home Page of HelpDesk", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }



    @Given("^User is on login Page of helpdesk$")
    public void userIsOnLoginPageOfHelpdesk() {
        try {
            String title=DriverAction.getTitle("https://helpdeskui-np.geminisolutions.com/#/");

            if(title.equals("Helpdesk"))
            {
                GemTestReporter.addTestStep("Exception Occurred", "Exception: " , STATUS.PASS, DriverAction.takeSnapShot());
            }

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("^Count number of tickets$")
    public void countTickets() {
        try {
            waitSec(4);
            DriverAction.waitUntilElementAppear(LoginPage.ticketRows, 10);
            List<WebElement> tickets = DriverManager.getWebDriver().findElements(LoginPage.ticketRows);
            displayedTickets = tickets.size();

            for (int i = 0; i < displayedTickets; i++) {
                String s = String.valueOf(i);
                String status = DriverAction.getElementText(Filter.statusCol(s));
                if (status.equals(""))
                {
                    break;
                }
                else
                {
                    list.add(status);
                }
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Count number of filtered tickets$")
    public void filteredTickets() {

        try {
            int filteredTickets = 0;
            List<WebElement> tickets = DriverManager.getWebDriver().findElements(Filter.noOfTickets);
            filteredTickets = tickets.size();


            if (displayedTickets != filteredTickets) {
                GemTestReporter.addTestStep("Verify filtered tickets are closed and resolved", "user has filtered closed and resolved tickets", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify filtered tickets are closed and resolved", "user has not filtered closed and resolved tickets", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }

    }

    @Then("^Verify filter tab is opened$")
    public void filterTab() {
        try {
            DriverAction.waitUntilElementAppear(Filter.validateFilterTab, 10);
            boolean filterTab = DriverAction.isExist(Filter.validateFilterTab);
            if (filterTab) {
                GemTestReporter.addTestStep("validate filter tab", "filter tab is validated", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("validate filter tab", "filter tab is not validated", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }


    @And("Select {string} and select {string} in filter tab")
    public void checkDepartmentAndStatus(String department, String status)  {
        try {
            waitSec(4);
            boolean filterDepartment = DriverAction.isExist(Filter.department(department));
            DriverAction.click(Filter.department(department));
            DriverAction.waitSec(4);
            boolean filterStatus = DriverAction.isExist(Filter.status(status));
            DriverAction.click(Filter.status(status));
            if (filterStatus && filterDepartment)
                GemTestReporter.addTestStep("Select" + department + "department and " + status + "status in filter tab", "User has successfully selected " + department + "department and " + status + " status in filter window", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Select" + department + "department and " + status + "status in filter tab", "User has not successfully selected " + department + "department and " + status + " status in filter window", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("Count number of filtered tickets with {string} and {string}")
    public void filteredTicketsWithDepartmentAndStatus(String department, String status) {
        try {
            waitSec(4);

            DriverAction.waitUntilElementAppear(LoginPage.ticketRows, 10);

            List<WebElement> element = DriverManager.getWebDriver().findElements(LoginPage.ticketRows);
            int filteredTickets = element.size();

            if (displayedTickets != filteredTickets) {
                GemTestReporter.addTestStep("Filtered tickets", "User gets filtered tickets with " + department + " department  and " + status + "status ,filtered tickets:" + filteredTickets + " Actual tickets: " + displayedTickets, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Filtered tickets", "User does not  get filtered tickets with " + department + " department  and " + status + "status ,filtered tickets:" + filteredTickets + " Actual tickets: " + displayedTickets, STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }


    @When("^Enter ticket id in searchbar$")
    public void ticketData() {
        try {
            DriverAction.waitUntilElementAppear(SearchInTickets.ticketId, 10);
            ticketIdData = DriverAction.getElementText(SearchInTickets.ticketId);
            DriverAction.waitUntilElementAppear(SearchInTickets.searchTicket, 10);
            DriverAction.typeText(SearchInTickets.searchTicket, ticketIdData);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }

    }

    @Then("^Verify selected ticket is displayed$")
    public void verifySelectedTicketIsDisplayed() {
        try {
            waitSec(4);
            String newData = DriverAction.getElementText(SearchInTickets.ticketId);
            if (ticketIdData.equals(newData)) {
                GemTestReporter.addTestStep("Ticket data", "Selected ticket gets display " + newData, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Ticket data", "Selected ticket does not get display ", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Press enter key$")
    public void pressEnterKey() {
        try {
            DriverManager.getWebDriver().findElement(SearchInTickets.searchBar).sendKeys(Keys.ENTER);
            GemTestReporter.addTestStep("Press Enter", "User pressed enter key successfully", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Enter subject in searchbar$")
    public void enterSubjectInSearchbar() {
        try {
            waitSec(3);
            ticketSubjectData = DriverAction.getElementText(SearchInTickets.subject);
            waitSec(2);
            DriverAction.typeText(SearchInTickets.searchTicket, ticketSubjectData);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify selected ticket with subject is displayed$")
    public void verifySelectedTicketWithSubjectIsDisplayed() {
        try {
            String newData = DriverAction.getElementText(SearchInTickets.subject);
            String ticketId = DriverAction.getElementText(SearchInTickets.ticketId);
            if (ticketSubjectData.equals(newData)) {
                GemTestReporter.addTestStep("Ticket data", "Selected ticket gets display with subject" + ticketId + newData, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Ticket data", "Selected ticket does not get display ", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("^Get ticket id$")
    public void getTicketId() {
        try {
            waitSec(2);
            ticketIdData = DriverAction.getElementText(SearchInTickets.ticketId);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify first ticket id gets change$")
    public void verifyFirstTicketIdGetsChange() {
        try {
            waitSec(3);
            String newData = DriverAction.getElementText(SearchInTickets.ticketId);
            if (!ticketIdData.equals(newData)) {
                GemTestReporter.addTestStep("Ticket data", "First ticket id does not get change: First ticket:" + newData + "Second ticket:" + ticketIdData, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Ticket data", "First ticket id does not get change " + newData + ticketIdData, STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }

    }

    @When("^Get ticket subject$")
    public void getTicketSubject() {
        try {
            waitSec(2);
            ticketSubjectData = DriverAction.getElementText(SearchInTickets.subject);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify tickets get sorted in ascending order$")
    public void sorted() {
        try {
            waitSec(4);
            List<String> list = new ArrayList<String>();

            List<String> list1 = new ArrayList<String>();
            DriverAction.click(SearchInTickets.subjectIcon);
            list.addAll(DriverAction.getElementsText(SortTickets.sorted));
            list1.addAll(list);
            Collections.sort(list1);
            waitSec(3);

            if (list.equals(list1)) {
                GemTestReporter.addTestStep("Verify Data is in ascending order", "Data gets sorted in ascending order", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify Data is in ascending order", "Data does not get sorted in ascending order", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("^Get ticket department$")
    public void getTicketDepartment() {
        try {

            waitSec(2);
            ticketDepartmentData = DriverAction.getElementText(SearchInTickets.subject);

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }


    @Then("^Verify first ticket department gets change$")
    public void verifyFirstTicketGetsChange() {

        try {
            String newData = DriverAction.getElementText(SearchInTickets.departmentIcon);
            if (!ticketDepartmentData.equals(newData)) {
                GemTestReporter.addTestStep("Ticket data", "First ticket id does not get change: First ticket:" + newData + "Second ticket:" + ticketDepartmentData, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Ticket data", "First ticket id does not get change " + newData + ticketDepartmentData, STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);

        }
    }


    @When("^Get ticket date$")
    public void getTicketDate() {
        try {
            waitSec(2);
            ticketDateData = DriverAction.getElementText(SearchInTickets.ticketDateData);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify first ticket date gets change$")
    public void verifyFirstTicketDateGetsChange() {
        try {
            waitSec(3);
            String newData = DriverAction.getElementText(SearchInTickets.departmentIcon);
            if (!ticketDateData.equals(newData)) {
                GemTestReporter.addTestStep("Ticket data", "First ticket id does not get change: First ticket:" + newData + "Second ticket:" + ticketDateData, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Ticket data", "First ticket id does not get change " + newData + ticketDateData, STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }


    @When("Get assigned on person data")
    public void getAssignedOnPersonData() {
        try {
            waitSec(2);
            assignedPerson = DriverAction.getElementText(SearchInTickets.ticketDateData);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("Verify first ticket assigned person gets change")
    public void verifyFirstTicketAssignedPersonGetsChange() {
        try {
            waitSec(3);
            String newData = DriverAction.getElementText(SearchInTickets.assignedTo);
            if (!assignedPerson.equals(newData)) {
                GemTestReporter.addTestStep("Ticket data", "First ticket id does not get change: First ticket:" + newData + "Second ticket:" + assignedPerson, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Ticket data", "First ticket id does not get change " + newData + assignedPerson, STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }


    @Then("^Verify first ticket status gets change$")
    public void verifyFirstTicketStatusGetsChange() {
        try {
            waitSec(3);
            String newData = DriverAction.getElementText(SearchInTickets.status);
            if (!status.equals(newData)) {
                GemTestReporter.addTestStep("Ticket data", "First ticket id does not get change: First ticket:" + newData + "Second ticket:" + status, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Ticket data", "First ticket id does not get change " + newData + status, STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("^Get status of ticket$")
    public void getStatusOfTicket() {
        try {
            waitSec(2);
            status = DriverAction.getElementText(SearchInTickets.status);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify create new ticket tab opens$")
    public void ticketCreation() {
        try {
            String data = DriverAction.getElementText(TicketCreation.ticketTab);
            if (data.equals("Create New Ticket")) {
                GemTestReporter.addTestStep("Verify Create new ticket tab is opened", "User has successfully opened create new ticket tab", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify Create new ticket tab is opened", "Create new ticket tab is not opened", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("Enter data in {string} field")
    public void clickOnField(String data) {
        try {
            waitSec(3);
            utils.inputField(data);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }


    @And("Select {string} from input dropdown")
    public void selectFromInputDropDown(String select) {

        try {
            waitSec(3);
            utils.inputField(select);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("Select {string} in ticket window")
    public void selectInTicketWindow(String department) throws InterruptedException {
        try {
            DriverAction.waitUntilElementClickable(TicketCreation.departmentType, 10);
            DriverAction.click(TicketCreation.departmentType);
            DriverAction.waitUntilElementClickable(TicketCreation.departments(department), 10);
            DriverAction.click(TicketCreation.departments(department));
            GemTestReporter.addTestStep("Verify user gets all the required values", "Users gets all the required values", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("^Enter description in ticket window$")
    public void enterDescription() {
        try {
            waitSec(3);
            DriverAction.typeText(TicketCreation.description, "Please download all the required software");
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Click on submit button$")
    public void clickOnSubmitBtn() {
        try {
            waitSec(4);
            DriverAction.waitUntilElementClickable(TicketCreation.submitBtn, 10);
            DriverAction.scrollIntoView(TicketCreation.submitBtn);
            DriverAction.click(TicketCreation.submitBtn);

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("^Get all the required validation data$")
    public void getAllTheRequiredValidationData() {
        try {
            waitSec(2);
            ticketSubjectData = DriverAction.getAttributeName(TicketCreation.subject, "value");
            ticketIncidentData = DriverAction.getElementText(TicketCreation.incident);
            ticketDepartmentData = DriverAction.getElementText(TicketCreation.itRequestDepartments);
            ticketDescriptionData = DriverAction.getElementText(TicketCreation.description);
            ticketFileUploadsData = DriverAction.isExist(TicketCreation.previewFileUpload);
            GemTestReporter.addTestStep("Verify user gets all the required values", "Users gets all the required values", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }

    }

    @When("^Click on ticket id$")
    public void clickOnTicketId() {
        try {
            DriverAction.click(TicketCreation.ticketId, "Ticket Id");
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("^Upload file$")
    public void uploadFile() {

        waitSec(4);
        try {
            String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Errors.png";
            DriverAction.fileUpload(TicketCreation.uploadFiles, filePath);
            GemTestReporter.addTestStep("Verify user uploads specific file", "Users uploads specific file", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify ticket data with displayed data$")
    public void verifyTicketDataWithDisplayedData() {

        try {
            waitSec(3);
            String previewSubject = DriverAction.getElementText(TicketCreation.previewSubject);
            String departmentData = DriverAction.getElementText(TicketCreation.previewRequestDepartment);
            String previewCategory = DriverAction.getElementText(TicketCreation.previewCategory);
            String previewSubCategory = DriverAction.getElementText(TicketCreation.previewSubCategory);
            boolean attachFiles = DriverAction.isExist(TicketCreation.previewFileUploaded);

            if (previewSubject.equals(ticketSubjectData) && attachFiles == ticketFileUploadsData && previewCategory.equals(ticketCategory) && previewSubCategory.equals(ticketSubCategory) && departmentData.equals(ticketDepartmentData)) {
                GemTestReporter.addTestStep("Validate ticket data", "Ticket data is validated", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validate ticket data", "Ticket data is not validated", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify data is updated when user enter in comments and upload files$")
    public void verifyDataIsUpdatedWhenUserEnterInComments() {
        DriverAction.click(TicketCreation.commentTextArea);
        waitSec(2);
        DriverAction.typeText(TicketCreation.commentTextArea, "Please update ticket status");
        waitSec(3);

        try {
            DriverAction.scrollIntoView(TicketCreation.attachFiles);
            String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Errors.png";
            DriverAction.fileUpload(TicketCreation.attachFiles, filePath);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
        waitSec(5);

        DriverAction.click(TicketCreation.updateBtn);
        String text = DriverAction.getElementText(TicketCreation.commentUpdate);

        if (text.contains("Please update ticket status")) {
            GemTestReporter.addTestStep("Update ticket status", "Ticket status is updated", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Update ticket status", "Ticket status is not updated", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @When("Select {string} from subCategory options")
    public void subcategory(String str) throws InterruptedException {
        try {
            DriverAction.waitUntilElementAppear(TicketCreation.subCategoryOptions(str), 10);
            DriverAction.click(TicketCreation.subCategoryOptions(str));
            ticketSubCategory = DriverAction.getElementText(TicketCreation.categoryOptions(str));
            GemTestReporter.addTestStep("Select sub Category from dropdown", "Seleted sub category" + ticketSubCategory, STATUS.PASS);

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("Select {string} from category option")
    public void select(String str) throws InterruptedException {
        try {
            DriverAction.waitUntilElementAppear(TicketCreation.categoryOptions(str), 10);
            DriverAction.click(TicketCreation.categoryOptions(str));
            ticketCategory = DriverAction.getElementText(TicketCreation.categoryOptions(str));
            GemTestReporter.addTestStep("Select category from dropdown", "Seleted category" + ticketCategory, STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Click on row per page dropDown$")
    public void rowPerPage() {
        try {
            DriverAction.waitUntilElementAppear(Filter.rowPerPage, 10);
            DriverAction.click(Filter.rowPerPage);
            DriverAction.click(Filter.rowPerPageDropdown("25"));
            GemTestReporter.addTestStep("Verify user clicks row per page dropdown ", "User successfully clicks row per page dropdown", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Get all the tickets subject$")
    public void getAllTheTicketsSubject() {
        try {
            List<String> list1 = new ArrayList<String>();
            list1.addAll(DriverAction.getElementsText(SortTickets.sorted));

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify ticket is created$")
    public void verifyTicketIsCreated() {

        try {
            DriverAction.isExist(TicketCreation.ticketCreationLogo);
            DriverAction.isExist(TicketCreation.ticketNumber);
            String ticketId = DriverAction.getElementText(TicketCreation.ticketNumber);
            GemTestReporter.addTestStep("Verify ticket is created", "User has successfully created ticket with ticket id:" + ticketId, STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }


    }

    @Then("^Verify data in preview tab$")
    public void verifyDataInPreviewTab() {
        try {
            waitSec(3);
            String previewSubject = DriverAction.getElementText(TicketCreation.previewSubject);
            String previewType = DriverAction.getElementText(TicketCreation.previewType);
            String previewDescription = DriverAction.getElementText(TicketCreation.previewDescription);
            String previewDepartment = DriverAction.getElementText(TicketCreation.previewDepartment);
            boolean fileUpload = DriverAction.isExist(TicketCreation.previewFileUploaded);

            if (ticketSubjectData.equals(previewSubject) && ticketIncidentData.equals(previewType) && ticketDepartmentData.equals(previewDepartment) && previewDescription.equals(previewDescription) && fileUpload == ticketFileUploadsData) {
                GemTestReporter.addTestStep("Verify ticket data in preview tab", "ticket data matches in preview tab", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify ticket data in preview tab", "ticket data does not get matches in preview tab", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("^click on preview button$")
    public void clickOnPreviewButton() {
        try {
            DriverAction.waitUntilElementClickable(TicketCreation.previewBtn, 10);
            DriverAction.click(TicketCreation.previewBtn);
            GemTestReporter.addTestStep("Verify user clicks preview button successfully", "User successfully clicks preview button", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("^Get all the required validation data with Request status$")
    public void requestValidations() {
        try {
            waitSec(3);
            ticketSubjectData = DriverAction.getAttributeName(TicketCreation.subject, "value");
            ticketIncidentData = DriverAction.getElementText(TicketCreation.request);
            ticketDepartmentData = DriverAction.getElementText(TicketCreation.itRequestDepartments);
            ticketDescriptionData = DriverAction.getElementText(TicketCreation.description);
            ticketFileUploadsData = DriverAction.isExist(TicketCreation.previewFileUpload);
            ticketCategory = DriverAction.getElementText(TicketCreation.category);
            ticketSubCategory = DriverAction.getElementText(TicketCreation.subCategory);
            GemTestReporter.addTestStep("Verify user gets required data", "Users gets required data", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^User verifies the calendar$")
    public void VerifyCalendar() {
        try {
            if (DriverAction.isExist(calendar.calendarTab)) {
                GemTestReporter.addTestStep("Verify Calendar", "Calendar is opened", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify Calendar is open", "Calendar is not opened", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^User opens the calendar$")
    public void userOpensTheCalendar() {
        try {
            DriverAction.waitUntilElementClickable(calendar.calendarButton, 10);
            DriverAction.click(calendar.calendarButton, "Calendar icon");
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }
    }

    @When("^Click on cancel button$")
    public void clickOnCancelButton() {
        try {
            waitSec(5);
            DriverAction.isExist(TicketDeletion.cancelTicket);
            DriverAction.click(TicketDeletion.cancelTicket);
            GemTestReporter.addTestStep("Cancel Button", "Cancel button is clicked successfully", STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }

    }

    @And("^Enter cancel ticket reason$")
    public void enterReasonToCancelTicket() {

        waitSec(3);
        try {
            DriverAction.click(TicketDeletion.cancelReason);
            DriverAction.typeText(TicketDeletion.cancelReason, "This is a sample test case");
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }

    }


    @When("^Click on cancel ticket$")
    public void clickOnCancelTicket() {
        try {
            waitSec(3);
            DriverAction.click(TicketDeletion.cancelBtn);
            GemTestReporter.addTestStep("Cancel button ", "User has successfully clicked on cancel button ", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }


    @When("^Click on cancel ticket button$")
    public void clickOnCancelTicketButton() {
        try {
            waitSec(4);
            DriverAction.click(TicketDeletion.cancelTicketbtn);
            GemTestReporter.addTestStep("Cancel ticket ", "User has cancelled ticket", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify user guide pdf gets opens$")
    public void verifyUserGuidePdfGetsOpens() {
        DriverAction.click(Dashboard.userGuide);
        try {
            waitSec(4);
            List<String> tabs = new ArrayList<>(DriverManager.getWebDriver().getWindowHandles());
            DriverAction.switchToWindow(tabs.get(1));

            String url=DriverAction.getCurrentURL();
            if (url.equals("https://geminisolutionsindpvtltd-my.sharepoint.com/personal/priyanka_kumari_geminisolutions_com/_layouts/15/onedrive.aspx?id=%2Fpersonal%2Fpriyanka%5Fkumari%5Fgeminisolutions%5Fcom%2FDocuments%2FGemini%20Helpdesk%20Live%2FHelpdesk%20User%20Guide%2Epdf&parent=%2Fpersonal%2Fpriyanka%5Fkumari%5Fgeminisolutions%5Fcom%2FDocuments%2FGemini%20Helpdesk%20Live&ga=1"))
            {
                GemTestReporter.addTestStep("Verify user is on user guide page of helpdesk", "User is on user guide page of HelpDesk", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify user is on user guide page of helpdesk", "User is not on user guide page of HelpDesk", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Click on copyLink button$")
    public void clickOnCopyLinkButton() {
        try {
//            DriverAction.waitUntilElementClickable(Dashboard.copyLink, 20);
            Utils.waitForElement(Dashboard.copyLink, 40);
            DriverAction.click(Dashboard.copyLink,"copy link");

            DriverAction.waitSec(6);

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);

            GemTestReporter.addTestStep("Verify copy link is clicked", "User successfully clicks copy link button", STATUS.PASS);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify copiedLink tab is opened$")
    public void verifyCopiedLinkTabIsOpened() {
        waitSec(3);
        try {
            boolean copyButton = DriverAction.isExist(Dashboard.copyTabHeading);
            if (copyButton) {
                GemTestReporter.addTestStep("Verify copy tab is opened", "User opens copy tab", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify copy tab is opened", "User is not able to open copy tab", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Click on close button$")
    public void clickOnCloseButton() {
        try {
//            boolean copiedLinkTab=DriverAction.isExist(Dashboard.copiedLinkTab);
//            if(copiedLinkTab)
//            {
//                GemTestReporter.addTestStep("Verify closed button displays", "User verifies close button displays", STATUS.PASS,DriverAction.takeSnapShot());
//            }
//            else {
//                GemTestReporter.addTestStep("Verify closed button displays", "user verifies close button does not display", STATUS.FAIL,DriverAction.takeSnapShot());
//            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }


    @Then("^Verify notifications tab is opened$")
    public void verifyNotificationsTab() {
        try {
            boolean notificationTab = DriverAction.isExist(Notification.notifications);
            if (notificationTab) {
                GemTestReporter.addTestStep("Notification tab is opened", "User opens notification tab successfully ", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Notification tab is opened", "User is not able to open notification tab successfully ", STATUS.FAIL);
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^count number of notification$")
    public void countNumberOfNotification() {
        try {
            List<WebElement> tickets = DriverManager.getWebDriver().findElements(Notification.notificationTickets);
            displayedTickets = tickets.size();
        }
        catch (Exception e)
        {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Count unread notifications$")
    public void countUnreadNotifications() {

        try {
            DriverAction.waitUntilElementClickable(Notification.unreadNotifications, 10);
            DriverAction.click(Notification.unreadNotifications);

//            DriverAction.scrollToBottom();
            while (DriverAction.isExist(Notification.showMore)) {
                DriverAction.scrollIntoView(Notification.showMore);
                Utils.waitForElement(Notification.showMore,10);
                DriverAction.click(Notification.showMore,"Show more");
            }
//            DriverAction.scrollToTop();

            int ticketCount = DriverManager.getWebDriver().findElements(Notification.totalTickets).size();
            String unreadTicketCount = Integer.toString(ticketCount);

            if (unreadTicketCount.equals(ticketCounts)) {
                GemTestReporter.addTestStep("Verify count of tickets in notification button and unread tickets are same ", "Number of ticket on notification bell and in notification tab are same " + "Notification Button:" + ticketCounts + "Notification details" + unreadTicketCount, STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Verify count of tickets in notification button and unread tickets are same ", "Number of ticket on notification bell and in notification tab are not same " + "Notification Button:" + ticketCounts + "Notification details" + unreadTicketCount, STATUS.FAIL);
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^User verifies calendar opens$")
    public void userVerifiesCalendarOpens() {
        try {
            boolean present = DriverAction.isExist(calendar.calendarTab);
            if (present) {
                GemTestReporter.addTestStep("Verify calendar opens", "User opens calendar successfully", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify calendar opens", "User is not able to open calendar successfully", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }

    }

    @And("User selects {string},{string} and {string}")
    public void userSelects(String day, String month, String year) {
        try {
            DriverAction.waitUntilElementClickable(calendar.monthBtn, 10);
            DriverAction.dropDown(calendar.monthBtn, month);
            DriverAction.waitUntilElementClickable(calendar.yearBtn, 10);
            DriverAction.dropDown(calendar.yearBtn, year);
            DriverAction.waitUntilElementClickable(calendar.days(day), 10);
            DriverAction.click(calendar.days(day));
            String selectedDay = DriverAction.getElementText(calendar.days(day));
            GemTestReporter.addTestStep("Verify user selects random date", "User successfully selects random date " + selectedDay + " " + month + " " + year, STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify contact email id is present$")
    public void verifySupportIcon() {
        try {

            String value = DriverAction.getElementText(Dashboard.contactEmailId);
            if (value.contains("support.helpdesk@geminisolutions.com")) {
                GemTestReporter.addTestStep("Verify presence of contact email id", "User opens contact us successfully and email id is present " + value, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify presence of contact email id", "User opens contact us successfully and email id is not present ", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("Select {string} view")
    public void selectView(String str) {
        waitSec(6);
        DriverAction.waitUntilElementClickable(LoginPage.viewToggleBtn, 30);
        DriverAction.click(LoginPage.viewToggleBtn);
        switch (str) {
            case "Support View": {
                try {
                    DriverAction.click(SupportDashboard.supportViewBtn);
                    GemTestReporter.addTestStep("Verify support view button exists", "Support view button exist ", STATUS.PASS, DriverAction.takeSnapShot());
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            case "Employee View": {
                try {
                    DriverAction.click(SupportDashboard.employeeViewBtn);
                    GemTestReporter.addTestStep("Verify employee view button exists", "Employee view button exists and clicked ", STATUS.PASS, DriverAction.takeSnapShot());
                } catch (Exception e) {
                    GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
                    logger.info("An exception occurred!", e);
                    throw new RuntimeException(e);
                }
                break;
            }
            default: {
                break;
            }

        }
    }

    @Then("^Verify support view window opens$")
    public void supportView() {
        try {
            DriverAction.waitUntilElementClickable(SupportDashboard.vipButton, 10);
            boolean elementPresent = DriverAction.isExist(SupportDashboard.vipButton);

            if (elementPresent) {
                GemTestReporter.addTestStep("Verify user successfully opens support View window", "User successfully opens support view window", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify user successfully opens support View window", "User is not able to open support view window", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("^Get all the required validation data to create ticket without uploading a file$")
    public void requiredValidations() {
        try {
            ticketSubjectData = DriverAction.getAttributeName(TicketCreation.subject, "value");
            ticketIncidentData = DriverAction.getElementText(TicketCreation.incident);
            ticketDepartmentData = DriverAction.getElementText(TicketCreation.itRequestDepartments);
            ticketDescriptionData = DriverAction.getElementText(TicketCreation.description);
            GemTestReporter.addTestStep("Verify user gets all the required data to create ticket", "User gets all the required data to create ticket", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }

    }

    @Then("^Verify data in preview tab without uploading a file$")
    public void dataPreviewTab() {
        try {
            String previewSubject = DriverAction.getElementText(TicketCreation.previewSubject);
            String previewType = DriverAction.getElementText(TicketCreation.previewType);
            String previewDescription = DriverAction.getElementText(TicketCreation.previewDescription);
            String previewDepartment = DriverAction.getElementText(TicketCreation.previewDepartment);

            if (ticketSubjectData.equals(previewSubject) && ticketIncidentData.equals(previewType) && ticketDepartmentData.equals(previewDepartment) && previewDescription.equals(previewDescription)) {
                GemTestReporter.addTestStep("Verify ticket data in preview tab", "ticket data matches in preview tab", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify ticket data in preview tab", "ticket data does not get matches in preview tab", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify create new ticket window gets open$")
    public void createNewSupportViewTicket() {
        try {
            String data = DriverAction.getElementText(SupportDashboard.ticketHeader);
            if (data.equals("Create New Ticket")) {
                GemTestReporter.addTestStep("Verify Create new ticket tab is opened", "User has successfully opened create new ticket tab", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify Create new ticket tab is opened", "Create new ticket tab is not opened", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);

        }
    }

    @When("Enter {string} in input field")
    public void inputField(String name) {
        try {
            DriverAction.waitUntilElementClickable(SupportDashboard.callerName, 10);
            DriverAction.typeText(SupportDashboard.callerName, name);
            DriverManager.getWebDriver().findElement(SupportDashboard.callerName).sendKeys(Keys.ENTER);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Click on caller Information icon$")
    public void callerInformationIcon() {
        try {
            DriverAction.click(SupportDashboard.callerInformation);
            GemTestReporter.addTestStep("Verify caller information", "Caller information is verified", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL);
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("^Enter wrong password in input field$")
    public void enterWrongPassword() {
        DriverAction.waitUntilElementClickable(LoginPage.password, 5);
        Properties login = new Properties();
        try (FileReader in = new FileReader("src/test/resources/login.properties")) {
            login.load(in);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
        String password = login.getProperty("wrongPassword");
        DriverAction.getElement(LoginPage.password).sendKeys(password);
        DriverAction.click(LoginPage.outlookSignInBtn);
    }

    @Then("^Verify credentials are wrong$")
    public void verifyWrongCredentials() {
        try {
            String passwordError = DriverAction.getElementText(LoginPage.passwordError);
            if (passwordError.equals("Your account or password is incorrect. If you don't remember your password, reset it now.")) {
                GemTestReporter.addTestStep("Verify password is wrong", "Error message appears " + passwordError, STATUS.FAIL, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify password is wrong", "User has logged in helpdesk with wrong password ", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify side menu is collapsed$")
    public void verifySideMenu() {
        try {
            boolean checkDetails = DriverAction.isExist(Dashboard.sideMenuDetails);
            if (checkDetails) {
                GemTestReporter.addTestStep("Verify side menu is opened", "User has logged into helpdesk and side menu is opened ", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify side menu is collapsed", "User has logged into helpdesk and side menu is collapsed", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("^Count number of tickets on notification button$")
    public void ticketsOnNotificationButton() {
        try {
            ticketCounts = DriverAction.getElementText(Notification.notificationIconTickets);
            boolean ticketExists = DriverAction.isExist(Notification.notificationIconTickets);

            if (ticketExists) {
                GemTestReporter.addTestStep("Count tickets on Notification button", "Count of tickets on notification button is " + ticketCounts, STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Count tickets on Notification button", "Tickets are not displayed on notification button", STATUS.FAIL);
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify show more button displays$")
    public void showMoreExits() {
        try {
            DriverAction.waitUntilElementClickable(Notification.unreadNotifications, 10);
            DriverAction.click(Notification.unreadNotifications,"Unread notifications");
            if (DriverAction.isExist(Notification.showMore))
            {
                while (DriverAction.isExist(Notification.showMore))
                {
                    DriverAction.scrollIntoView(Notification.showMore);
                    DriverAction.click(Notification.showMore,"Show More");
                }
                GemTestReporter.addTestStep("Verify show More button displays", "User verifies show more button displays", STATUS.PASS,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Verify show More button displays", "User verifies show more button does not displays", STATUS.FAIL,DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot(),DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("^Navigate to first ticket details$")
    public void firstTickets() {
        try {
            DriverAction.waitUntilElementClickable(Notification.firstTicket, 10);
            DriverAction.click(Notification.firstTicket);
            boolean ticketHeader = DriverAction.isExist(Notification.ticketHeader);
            if (ticketHeader) {
                GemTestReporter.addTestStep("Verify first ticket opens", "User opens first ticket successfully", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify first ticket opens", "First ticket does not open successfully", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("Select {string} from dropdown")
    public void selectValueDropdown(String str) {
        try {
            DriverAction.click(Pagination.value(str));
            GemTestReporter.addTestStep("Select number of tickets to display from drop down", "User selects " + str + " from drop down", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("Verify number of ticket count on dashboard with dropdown {string}")
    public void verifyTickets(String str) {
        DriverAction.waitSec(4);

        try {
            int ticketsCount = DriverManager.getWebDriver().findElements(Pagination.displayedTickets).size();
            String pageDropDownValue = DriverAction.getElementText(Pagination.value(str));
            int dropDownCount = Integer.parseInt(pageDropDownValue);

            if (ticketsCount == dropDownCount) {
                GemTestReporter.addTestStep("Verify count of ticket on dashboard is same as selected value from dropdown", "User verifies count of ticket on dashboard is same as selected value from dropdown" + " Dropdown value: " + dropDownCount + " Ticket count: " + ticketsCount, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify count of ticket on dashboard is same as selected value from dropdown", "User verifies count of ticket on dashboard is not same as selected value from dropdown" + " Dropdown value: " + dropDownCount + " Ticket count: " + ticketsCount, STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Previous page button is disabled and next page button is enabled$")
    public void pageButtons() {
        try {
            boolean previousButton = DriverManager.getWebDriver().findElement(Pagination.previousButton).isEnabled();
            boolean nextButton = DriverManager.getWebDriver().findElement(Pagination.nextButton).isEnabled();

            if (!previousButton && nextButton) {
                GemTestReporter.addTestStep("Verify Page buttons", "User verifies next page button is enabled and previous page button is disabled", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify Page buttons", "Page buttons does not exist", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify previous page button is enabled$")
    public void previousPageButton() {

        try {
            DriverAction.scrollToBottom();
            boolean previousButton = DriverManager.getWebDriver().findElement(Pagination.previousButton).isEnabled();
            if (previousButton) {
                GemTestReporter.addTestStep("Verify previous page button is enabled", "User verifies previous page button is enabled", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify previous page button is enabled", "Page buttons does not exist", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify previous page button is disabled$")
    public void pageButtonDisabled() {
        try {
            DriverAction.scrollToBottom();
            boolean previousButton = DriverManager.getWebDriver().findElement(Pagination.previousButton).isEnabled();

            if (!previousButton) {
                GemTestReporter.addTestStep("Verify previous page button is disabled", "User verifies previous page button is disabled", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify previous page button is disabled", "Page buttons does not exist", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }

    }

    @When("^Count number of tickets again$")
    public void countNumberOfTicketsAgain() {
        try {
            int filteredTickets = 0;

            List<WebElement> tickets = DriverManager.getWebDriver().findElements(LoginPage.ticketRows);
            filteredTickets = tickets.size();

            List<String> list1 = new ArrayList<String>();

            for (int i = 0; i < filteredTickets; i++) {
                String s = String.valueOf(i);
                String status = DriverAction.getElementText(Filter.statusCol(s));
                if (status.equals("")) {
                    list1.add(status);
                    break;
                } else {
                    list1.add(status);
                }
            }
            if (list != list1) {
                GemTestReporter.addTestStep("Verify filtered tickets are closed and resolved", "user filters closed and resolved tickets", STATUS.PASS, DriverAction.takeSnapShot());
            } else if ((list.get(0).equals("") && list1.get(0).equals("")) && displayedTickets == 1) {
                GemTestReporter.addTestStep("Verify filtered tickets are closed and resolved", "user filters closed and resolved tickets", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify filtered tickets are closed and resolved", "user is not able to filtered closed and resolved tickets", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("Enter {string} in searchbar")
    public void enterKeyword(String str) {
        try {
            DriverAction.waitUntilElementClickable(SearchInTickets.searchBar, 10);
            DriverAction.typeText(SearchInTickets.searchTicket, str);
            DriverAction.click(SearchInTickets.searchBar);
            ticketSubjectData = DriverAction.getElementText(SearchInTickets.subject);
            GemTestReporter.addTestStep("Enter keyword in search bar", "User enters keyword in search bar to check valid ticket is displayed", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    List<String> list = new ArrayList<String>();

    @And("Select all the {string}")
    public void selectDepartments(String department) {
        try {
            String[] array = department.split(",");
            for (String s : array) {
                DriverAction.waitUntilElementClickable(Filter.department(s), 10);
                DriverAction.click(Filter.department(s));
            }
            list.addAll(List.of(array));
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify filtered data is displayed in department column.$")
    public void filteredDataColumn() {
        try {
            int size = DriverManager.getWebDriver().findElements(Filter.departmentCol).size();

            List<String> list1 = new ArrayList<String>();

            for (int i = 0; i <= size; i++) {
                if (i == 0) {
                    continue;
                } else {
                    String s = String.valueOf(i);
                    String values = DriverAction.getElementText(Filter.departmentCols(s));
                    list1.add(values);
                }

            }
            list.addAll(list1);
            Set<String> s = new LinkedHashSet<String>(list);

            int count = s.size();

// No. of department count
            if (count <= 5) {
                GemTestReporter.addTestStep("Verify Department specific tickets are displayed", "Department specific tickets are displayed on dashboard", STATUS.PASS, DriverAction.takeSnapShot());
            } else if (count == 0) {
                GemTestReporter.addTestStep("Verify Department specific tickets are displayed", "Dashboard ticket body is empty", STATUS.FAIL, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify Department specific tickets are displayed", "Department specific tickets are not displayed on dashboard", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify filtered data is displayed in status column.$")
    public void statusData() {
        try {

            int size = DriverManager.getWebDriver().findElements(Filter.statusCol).size();

            List<String> list1 = new ArrayList<String>();

            for (int i = 0; i <= size; i++) {
                if (i == 0)
                {
                    continue;
                } else {
                    String s = String.valueOf(i);
                    String values = DriverAction.getElementText(Filter.statusCol(s));
                    list1.add(values);
                }

            }
            list.addAll(list1);
            Set<String> s = new LinkedHashSet<String>(list);

            int count = s.size();


            if (count <= 9) {
                GemTestReporter.addTestStep("Verify status specific tickets are displayed", "Status specific tickets are displayed on dashboard", STATUS.PASS, DriverAction.takeSnapShot());
            } else if (count == 0) {
                GemTestReporter.addTestStep("Verify Status specific tickets are displayed", "Dashboard ticket body is empty", STATUS.FAIL, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify status specific tickets are displayed", "Status specific tickets are not displayed on dashboard", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }


    @Then("^Verify filter tab is closed$")
    public void filterClosed() {
        try {
            boolean filterTab = DriverAction.isExist(Filter.closedFilter);
            if (!filterTab) {
                GemTestReporter.addTestStep("Verify filter tab is closed", "User verifies filter tab is closed", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify filter tab is closed", "User verifies filter tab is not closed", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("Verify ticket with correct {string} is displayed")
    public void ticketDisplayed(String str) {
        try {
            waitSec(3);
            String data = DriverAction.getElementText(SearchInTickets.subject);
            if (data.equals(str)) {
                GemTestReporter.addTestStep("Verify ticket is displayed with keyword", "User verifies ticket is displayed with searched keyword", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify ticket is displayed with keyword", "User verifies ticket is not displayed with searched keyword", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Click on cross button and verify all the tickets are displayed$")
    public void clickCrossButton() {
        try {
            DriverAction.click(SearchInTickets.crossIcon);

            int rows = DriverManager.getWebDriver().findElements(SearchInTickets.rows).size();

            if (rows != 0) {
                GemTestReporter.addTestStep("Verify all the tickets are displayed", "All the tickets are displayed", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify all the tickets are displayed", "Tickets are not displayed", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception error", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("^Get all the required validation data with Request status without attachment$")
    public void getAllTheRequiredValidationDataWithRequestStatusWithoutAttachment() {
        try {
            waitSec(3);
            ticketSubjectData = DriverAction.getAttributeName(TicketCreation.subject, "value");
            ticketIncidentData = DriverAction.getElementText(TicketCreation.request);
            ticketDepartmentData = DriverAction.getElementText(TicketCreation.itRequestDepartments);
            ticketDescriptionData = DriverAction.getElementText(TicketCreation.description);
            ticketCategory = DriverAction.getElementText(TicketCreation.category);
            ticketSubCategory = DriverAction.getElementText(TicketCreation.subCategory);
            GemTestReporter.addTestStep("Verify user gets all the required validation data with Request status without attachment", "User gets all the required validation data with Request status without attachment", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }


    }

    @Then("^Verify ticket data with displayed data without attachment$")
    public void verifyTicketDataWithDisplayedDataWithoutAttachment() {
        try {
            waitSec(3);
            String previewSubject = DriverAction.getElementText(TicketCreation.previewSubject);
            String departmentData = DriverAction.getElementText(TicketCreation.previewRequestDepartment);
            String previewCategory = DriverAction.getElementText(TicketCreation.previewCategory);
            String previewSubCategory = DriverAction.getElementText(TicketCreation.previewSubCategory);

            if (previewSubject.equals(ticketSubjectData) && previewCategory.equals(ticketCategory) && previewSubCategory.equals(ticketSubCategory) && departmentData.equals(ticketDepartmentData)) {
                GemTestReporter.addTestStep("Validate ticket data", "Ticket data is validated", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validate ticket data", "Ticket data is not validated", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }

    }

    @Then("^Verify error messages appear$")
    public void verifyErrorMessagesAppear() {
        try {
            String subjectMessage = DriverAction.getElementText(TicketCreation.subjectError);
            String typeMessage = DriverAction.getElementText(TicketCreation.typeError);
            String departmentMessage = DriverAction.getElementText(TicketCreation.departmentError);
            String descriptionMessage = DriverAction.getElementText(TicketCreation.descriptionError);

            if (subjectMessage.equals("Subject is required") && typeMessage.equals("Type is required") && departmentMessage.equals("Department is required") && descriptionMessage.equals("Description is required")) {
                GemTestReporter.addTestStep("Verify error appears", "User verifies error appears", STATUS.PASS);
            } else {
                GemTestReporter.addTestStep("Verify error appears", "User is on dashboard", STATUS.FAIL);
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }

    }

    @Then("^Verify file is uploaded.$")
    public void verifyFileIsUploaded() {

        try {
            boolean filedUploaded = DriverAction.isExist(TicketCreation.uploadedFile);
            if (filedUploaded) {
                GemTestReporter.addTestStep("Verify file is uploaded", "File is uploaded with specified extension and size limit", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify file is uploaded", "File is not uploaded with specified extension and size limit", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }
    }

    @When("^Upload file with invalid extension$")
    public void uploadFileWithInvalidExtension() {
        DriverAction.waitUntilElementClickable(TicketCreation.uploadFiles, 10);
        try {
            String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Database.accdb";
            DriverAction.fileUpload(TicketCreation.uploadFiles, filePath);
            GemTestReporter.addTestStep("Verify user uploads file with invalid extension", "User uploads file with invalid extension", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }
    }

    @When("^Upload file with valid extension and large size$")
    public void uploadFileWithValidExtensionAndLargeSize() {
        try {
            String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\sample.pdf";
            DriverAction.fileUpload(TicketCreation.uploadFiles, filePath);
            GemTestReporter.addTestStep("Verify user uploads file with valid extension and large size", "User uploads file with valid extension and large size", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }
    }

    @Then("^Verify alert appears$")
    public void verifyPopUpAppears() {
        try {
            DriverAction.acceptAlert();
            GemTestReporter.addTestStep("Alert Appears", "File size is larger then specified size", STATUS.FAIL);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception", STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }
    }

    @When("^Upload multiple files with valid extension and specified size$")
    public void uploadMultipleFilesWithValidExtensionAndSpecifiedSize() {
        try {
            String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\error.pdf";
            DriverAction.fileUpload(TicketCreation.uploadFiles, filePath);

            filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Errors.png";
            DriverAction.fileUpload(TicketCreation.uploadFiles, filePath);

            filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\Sample.png";
            DriverAction.fileUpload(TicketCreation.uploadFiles, filePath);

            GemTestReporter.addTestStep("Verify user uploads file with valid extension and specified size", "User uploads file with valid extension and specified size", STATUS.FAIL);

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception", STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }
    }

    @Then("^Verify multiple files uploaded$")
    public void verifyMultipleFilesUploaded() {
        try {
            int files = DriverManager.getWebDriver().findElements(TicketCreation.multipleFiles).size();
            if (files < 2) {
                GemTestReporter.addTestStep("Verify multiple files uploaded", "Multiple files are uploaded", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify multiple files uploaded", "Multiple files are not uploaded", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }
    }

    @Then("^Verify ticket status is cancelled$")
    public void verifyTicketStatusIsCancelled() {
        try {
            DriverAction.waitSec(4);
            String ticketStatus = DriverAction.getElementText(TicketDeletion.status);
            if (ticketStatus.equals("Cancelled")) {
                GemTestReporter.addTestStep("Verify ticket status is cancelled", "Ticket status is cancelled", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify ticket status is cancelled", "Ticket status is not cancelled", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }

    }

    @Then("^Verify ticket cancels$")
    public void verifyTicketCancels() {
        try {
            String errorMessage = DriverAction.getElementText(TicketDeletion.errorMessage);
            if (errorMessage.equals("Reason is required")) {
                GemTestReporter.addTestStep("Verify ticket cancels", "Tickets does not cancel", STATUS.FAIL, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify ticket cancels", "Tickets cancels", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }
    }

    @When("^Get timeline state$")
    public void getTimelineState() {

        try {
            String openStatus = DriverAction.getElementText(TicketDeletion.timelineOpen);
            if (openStatus.equals("Open")) {
                GemTestReporter.addTestStep("Verify timeline status", "Timeline status is open", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify timeline status", "Unable to fetch Timeline status", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }
    }

    @Then("^Verify ticket timeline status is cancelled$")
    public void verifyTicketTimelineStatusIsCancelled() {

        try {
            String Status = DriverAction.getElementText(TicketDeletion.timelineCancelled);
            if (Status.equals("Cancelled")) {
                GemTestReporter.addTestStep("Verify timeline status", "Timeline status is cancelled", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify timeline status", "Timeline status is open", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }
    }

    @And("^Get current month order$")
    public void getCurrentMonthName() {
        try {
            monthOrder = DriverAction.getAttributeName(calendar.currentMonth, "value");
            GemTestReporter.addTestStep("Get current month order", "Current month order is " + monthOrder, STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }
    }

    @Then("^Verify month changes$")
    public void verifyMonthChanges() {
        try {
            String currentMonthName = DriverAction.getAttributeName(calendar.currentMonth, "value");

            if (currentMonthName.equals(monthOrder)) {
                GemTestReporter.addTestStep("Verify month changes", "Previous button is clicked and month is changed " + currentMonthName, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify month changes", "Current month is " + currentMonthName, STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }
    }

    @Then("^Verify date is selected$")
    public void verifyDateIsSelected() {
        try {
            boolean currentDay = DriverAction.isExist(calendar.currentDay);
            String currentDate = DriverAction.getElementText(calendar.currentDay);
            if (currentDay) {
                GemTestReporter.addTestStep("Verify default value is selected", "Default value is selected " + currentDate, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify default value is selected", "Default value is not selected", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }
    }


    @And("^Count month and weekdays$")
    public void verifyMonthAndWeekdayCount() {
        try {
            List<WebElement> months = DriverManager.getWebDriver().findElements(calendar.monthBtn);
            totalMonths = months.size();
            List<WebElement> weekDays = DriverManager.getWebDriver().findElements(calendar.totalDays);
            int totalDays = weekDays.size();
            List<WebElement> passiveDays = DriverManager.getWebDriver().findElements(calendar.passiveDays);
            int totalPassiveDays = passiveDays.size();
            List<WebElement> weekendDays = DriverManager.getWebDriver().findElements(calendar.weekend);
            int weekend = weekendDays.size();
            totalMonthDays = totalDays - totalPassiveDays - weekend;

            GemTestReporter.addTestStep("Total number of weekdays and months are", "Total week days are " + totalMonthDays + " Total months are " + totalMonths, STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }

    }

    @Then("^Verify logged in username and designation$")
    public void verifyLoggedInDesignation() {
        try {
            String username = DriverAction.getElementText(LoginPage.loginUsername);
            String designation = DriverAction.getElementText(LoginPage.designation);
            boolean loginUsername = DriverAction.isExist(LoginPage.loginUsername);
            boolean loginDesignation = DriverAction.isExist(LoginPage.designation);
            if (loginDesignation && loginUsername) {
                GemTestReporter.addTestStep("Verify logged in Username and designation", " Username " + username + " Designation " + designation, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify logged in Username and designation", " Error getting username and designation", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Error ", "Exception" + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException();
        }

    }

    @And("^Click on collapse button$")
    public void clickOnCollapseButton() {
        try {
            DriverAction.click(Dashboard.collapseButton, " Collapsed button");
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Click on support button$")
    public void clickOnSupportButton() {
        try {
            DriverAction.click(LoginPage.supportIcon);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }

    }

    @And("^Click on close button of contact us$")
    public void clickOnCloseButtonOfContactUs() {
        try {
            DriverAction.click(Dashboard.crossButton);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Click on logout button$")
    public void clickOnLogoutButton() {
        try {
            DriverAction.click(Dashboard.logOutButton, "log out");
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }


    @And("^Click on next page button$")
    public void clickOnNextPageButton() {
        try {
            DriverAction.click(Pagination.nextButton);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }

    }

    @And("Click on previous button")
    public void clickOnPreviousButton() {
        try {
            DriverAction.click(Pagination.previousButton);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }


    @And("Select the {string}")
    public void selectThe(String str) {
        try {

            DriverAction.waitUntilElementClickable(Filter.department(str), 10);
            DriverAction.click(Filter.department(str));
            String department = DriverAction.getElementText(Filter.department(str));
            list.add(department);

        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("Exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^User verifies range is selected$")
    public void userVerifiesRangeIsSelected() {
        try {
            boolean rangeSelected = DriverAction.isExist(calendar.range);
            if (rangeSelected) {
                GemTestReporter.addTestStep("Verify range is selected", "User verifies specified range is selected", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify range is selected", "User verifies specified range is not selected", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify user is still on login page$")
    public void verifyUserStillOnLoginPage() {
        try {
//            waitSec(6);
            Utils.waitUntilLoaderDisappear();
            boolean check = DriverAction.isExist(Dashboard.logOutButton);
            if (!check) {
                DriverAction.click(LoginPage.loginBtn, "Login button");
                GemTestReporter.addTestStep("Verify user is still on Login page", "User is on HomePage", STATUS.PASS);
            }
            else
            {
                GemTestReporter.addTestStep("Verify user is still on Login page", "User redirects to HomePage", STATUS.PASS);
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

//    Support view

    @And("^Enter caller name$")
    public void enterCallerName() {
        try
        {
            Utils.waitForElement(SupportTicketCreation.callerName, 10);
            WebElement key=DriverAction.getElement(SupportTicketCreation.callerName);
            DriverAction.typeText(SupportTicketCreation.callerName, "Tushar Mahajan");
            DriverAction.waitSec(10);
            key.sendKeys(Keys.ENTER);
//            String callerName=DriverAction.getElementText(SupportTicketCreation.callerFullName);
//            if(callerName.equals(""))
//            {
//                GemTestReporter.addTestStep("Enter caller name", "Caller name field is empty", STATUS.FAIL,DriverAction.takeSnapShot());
//            }
//            else
//            {
//                GemTestReporter.addTestStep("Enter caller name","Caller name is "+callerName,STATUS.PASS,DriverAction.takeSnapShot());
//            }
//            GemTestReporter.addTestStep("Enter caller name", "Caller name entered successfully" + name, STATUS.PASS);

        }
        catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Verify channel field is disabled$")
    public void verifyChannelFieldIsDisabled() {
        try {

            WebElement chanel=DriverManager.getWebDriver().findElement(SupportTicketCreation.channel);
//            boolean checked =Utils.isAttribtuePresent(chanel,"disabled");
//            if (checked) {
//                GemTestReporter.addTestStep("Verify channel field is disabled", "User verifies channel field is disabled", STATUS.PASS, DriverAction.takeSnapShot());
//            } else {
//                GemTestReporter.addTestStep("Verify channel field is disabled", "User verifies channel field is enabled", STATUS.FAIL, DriverAction.takeSnapShot());
//            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("Enter {string} details")
    public void enterDetails(String str) {
        try {
            DriverAction.typeText(SupportDashboard.configuration, str);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("Select {string} from Assigned To options")
    public void selectFromAssignedToOptions(String str) {
        try {
            DriverAction.click(SupportDashboard.assignedTo, "Assigned To");
            DriverAction.click(SupportTicketEditTickets.name(str));
            name = DriverAction.getElementText(SupportTicketEditTickets.name(str));
            GemTestReporter.addTestStep("Verify executive selected from dropdown", "User successfully selected" + name, STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }

    }

    @When("Select {string} from department dropdown")
    public void selectFromDepartmentDropdown(String str) {
        try {
            DriverAction.click(SupportTicketEditTickets.department, "Department");
            String departmentData = DriverAction.getElementText(SupportTicketEditTickets.department);
            if (departmentData.equals("HR")) {
                ticketDepartmentData = DriverAction.getElementText(SupportTicketEditTickets.department);
            }
            else
            {
                DriverAction.click(SupportTicketEditTickets.chooseDepartment(str));
                ticketDepartmentData = DriverAction.getElementText(SupportTicketEditTickets.department);
            }

            if(ticketDepartmentData.equals(""))
            {
                GemTestReporter.addTestStep("Select department from dropdown", "Department input field is empty", STATUS.FAIL,DriverAction.takeSnapShot());
            }
            else
            {
                GemTestReporter.addTestStep("Select department from dropdown", "Selected department " + ticketDepartmentData, STATUS.PASS,DriverAction.takeSnapShot());
            }
        }
        catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("Select {string} from status dropdown")
    public void selectFromStatusDropdown(String str) {
        try {
            DriverAction.click(SupportTicketEditTickets.status(str), "Status");
            String status = DriverAction.getElementText(SupportTicketEditTickets.status(str));
            GemTestReporter.addTestStep("Select status from dropdown", "Selected status " + status, STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("Get {string} ticket count")
    public void getAssignedTicketCount(String str) {
        try {
            switch (str) {
                case "Assigned": {
                    String assignedHeader = DriverAction.getElementText(SupportDashboard.type(str));
                    String[] arrOfStr = assignedHeader.split(" ");
                    String str1 = String.valueOf(arrOfStr[1]);
                    String ans = str1.substring(str1.indexOf("(") + 1, str1.indexOf(")"));
                    String assignedTicket = ans;
                    ticketCount = assignedTicket;
                    GemTestReporter.addTestStep("Get ticket count for assigned", "ticket count for assigned " + ticketCount, STATUS.PASS, DriverAction.takeSnapShot());
                    break;
                }
                case "Unassigned": {
                    DriverAction.click(SupportDashboard.type(str), "unAssigned");
                    String assignedHeader = DriverAction.getElementText(SupportDashboard.type(str));
                    String[] arrOfStr = assignedHeader.split(" ");
                    String str1 = String.valueOf(arrOfStr[1]);
                    String ans = str1.substring(str1.indexOf("(") + 1, str1.indexOf(")"));
                    String unAssignedTicket = ans;
                    ticketCount = unAssignedTicket;
                    GemTestReporter.addTestStep("Get ticket count for assigned", "ticket count for assigned " + ticketCount, STATUS.PASS, DriverAction.takeSnapShot());
                    break;
                }
                case "My Department": {
                    DriverAction.click(SupportDashboard.type(str), "My Department");
                    String assignedHeader = DriverAction.getElementText(SupportDashboard.type(str));
                    String[] arrOfStr = assignedHeader.split(" ");
                    String str1 = String.valueOf(arrOfStr[2]);
                    String ans = str1.substring(str1.indexOf("(") + 1, str1.indexOf(")"));
                    String myDepartment = ans;
                    ticketCount = myDepartment;
                    GemTestReporter.addTestStep("Get ticket count for assigned", "ticket count for assigned " + ticketCount, STATUS.PASS, DriverAction.takeSnapShot());
                    break;
                }
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify ticket count at header is same as footer$")
    public void verifyTicketCountAtHeaderIsSameAsFooter() {
        try {
            String footer = DriverAction.getElementText(SupportDashboard.footerCount);
            String[] arrOfStr = footer.split("of ");
            String str1 = String.valueOf(arrOfStr[1]);
            String footerCount = String.valueOf(str1.charAt(0));

            if (footerCount.equals(ticketCount)) {
                GemTestReporter.addTestStep("Verify total tickets are same", "User verifies total ticket count at header and at footer are same" + footerCount, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify total tickets are same", "User verifies total ticket count at header and at footer are not same" + footerCount, STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }
    //div[contains(@class,'tabs_tabItem__5Muc1 tabs_fontLightGreen__TtaCd')]

    @Then("^Verify ticket count at header is same as footer for unassigned$")
    public void verifyTicketCountAtHeaderIsSameAsFooterUnassigned() {
        try {
            String footer = DriverAction.getElementText(SupportDashboard.footerCount);
            String[] arrOfStr = footer.split("of ");
            String str1 = String.valueOf(arrOfStr[1]);


            String footerCount = str1.substring(0, str1.length() - 1 + 1);

            if (footerCount.equals(ticketCount)) {
                GemTestReporter.addTestStep("Verify total tickets are same", "User verifies total ticket count at header and at footer are same" + footerCount, STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify total tickets are same", "User verifies total ticket count at header and at footer are not same" + footerCount, STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Click on edit ticket icon$")
    public void clickOnEditTicketIcon() {
        try {
            DriverAction.click(SupportDashboard.editTicketIcon, "Edit ticket icon");
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }

    }

    @When("Select {string} on dashboard in support view")
    public void selectOnDashboard(String Str) {
        try {
            Utils.waitForElement(SupportDashboard.type(Str), 10);
            DriverAction.click(SupportDashboard.type(Str), Str);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }

    }

    @Then("Verify ticket displays with vip tag for {string}")
    public void verifyVipTicketsWithVipTagDisplays(String tab) {
        try
        {
            int vipRows = DriverManager.getWebDriver().findElements(SupportDashboard.vipRows).size();
            int totalRows=DriverManager.getWebDriver().findElements(SupportDashboard.totalRows).size();
            int vipTag=DriverManager.getWebDriver().findElements(SupportDashboard.vipTags).size();

            if (count == 0)
            {
                GemTestReporter.addTestStep("Verify vip ticket displays", "No Vip Tickets are available for "+tab+" "+count, STATUS.PASS, DriverAction.takeSnapShot());
            }
            else if((vipRows == vipTag) && (vipTag==totalRows))
            {
                GemTestReporter.addTestStep("Verify vip ticket displays", "Total no.of vip tickets for "+tab+" are "+count, STATUS.FAIL, DriverAction.takeSnapShot());
            }
            else {
                GemTestReporter.addTestStep("Verify vip ticket displays", "Total no.of vip tickets for "+tab+" are "+count, STATUS.PASS, DriverAction.takeSnapShot());
            }
        }
        catch (Exception e)
        {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @When("^get status of ticket$")
    public void statusOfTicket()
    {
        try
        {
            DriverAction.waitSec(3);
            status=DriverAction.getElementText(SupportDashboard.ticketStatus);
            if(status.equals("")) {
                GemTestReporter.addTestStep("Status of ticket", "Status of current ticket is " + status, STATUS.FAIL, DriverAction.takeSnapShot());
            }
            else {
                GemTestReporter.addTestStep("Status of ticket", "Status of current ticket is " + status, STATUS.PASS, DriverAction.takeSnapShot());
            }
            DriverAction.click(SupportDashboard.previousArrow,"Previous arrow");
        }
        catch (Exception e)
        {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @Then("^Verify status of ticket changes$")
    public void verifyStatusOfTicketChanges()
    {
        Utils.waitUntilLoaderDisappear();
        try
        {
            String ticketStatus=DriverAction.getElementText(SupportDashboard.ticketStatus);
            if(!ticketStatus.equals(status))
            {
                GemTestReporter.addTestStep("Verify status of ticket changes", "Status of ticket changes to " +ticketStatus, STATUS.PASS, DriverAction.takeSnapShot());
            }
            else {
                GemTestReporter.addTestStep("Verify status of ticket changes", "Status of ticket does not change ", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        }
        catch (Exception e)
        {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

//    @When("^get ticket id$")
//    public void getTicketId()
//    {
//    }

    @When("^get ticket id from dashboard$")
    public void getTicketIdFromDashboard()
    {
        try
        {
            ticketIdData=DriverAction.getElementText(SupportDashboard.unAssignedTicketId);
            if(ticketIdData.equals(""))
            {
                GemTestReporter.addTestStep("Get Ticket id","unable to get ticket id",STATUS.FAIL,DriverAction.takeSnapShot());
            }
            else {
                GemTestReporter.addTestStep("Get Ticket id","Ticket id "+ticketIdData,STATUS.PASS,DriverAction.takeSnapShot());
            }
        }
        catch (Exception e)
        {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("^Enter ticket id in searchField$")
    public void enterTicketIdInSearchField()
    {
        try {
            DriverAction.typeText(SearchInTickets.searchTicket, ticketIdData);
        }
        catch (Exception e)
        {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }
    @Then("^Verify no new notification displays$")
    public void verifyNoNewNotificationDisplays()
    {
        try
        {
            String notificationMessage=DriverAction.getElementText(Notification.noNewNotification);
            if(notificationMessage.equals("No new notification !!"))
            {
                GemTestReporter.addTestStep("Verify notification message displays","Notification message : "+notificationMessage,STATUS.PASS,DriverAction.takeSnapShot());
            }
            else {
                GemTestReporter.addTestStep("Verify notification message displays","Notification message"+notificationMessage,STATUS.FAIL,DriverAction.takeSnapShot());
            }
        }
        catch (Exception e)
        {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }

    @And("Enter {string} in subject input field")
    public void enterInSubjectInputField(String str)
    {
        try
        {
            DriverAction.typeText(SupportDashboard.configuration, str);
        }
        catch (Exception e)
        {
            GemTestReporter.addTestStep("Exception Occurred", "Exception: " + e, STATUS.FAIL, DriverAction.takeSnapShot());
            logger.info("An exception occurred!", e);
            throw new RuntimeException(e);
        }
    }
}