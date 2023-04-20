package com.qa.helpdesk.locators;

import org.openqa.selenium.By;

public class LoginPage {

    public static By helpDeskIcon=By.xpath("//div/img[@alt='helpdesk']");

    public static By dummyIcon=By.xpath("//div/img[@alt='landing_page_img']");
    public static By signInIcon=By.xpath("//div[text()='Sign in']");

    public static By emailId=By.xpath("//input[@name='loginfmt']");
    public static By password=By.xpath("//input[@name='passwd']");

    public static By loginBtn= By.xpath("//button[@type='button']");
    public static By createTicket=By.xpath("//button[contains(text(),'Create New Ticket')]");


    public static By description=By.xpath("//textarea[@name='description']");

    public static By actionBtn(String str)
    {
        return By.xpath("//button[text()="+str+"]']");
    }


    public static By filterIcon=By.xpath("//button[contains(@class,'btn btn-light')]");

    public static By outlookNextBtn=By.xpath("//input[@value='Next']");

    public static By outlookBackBtn=By.xpath("//input[@value='Back']");
    public static By outlookSignInBtn=By.xpath("//input[@value='Sign in']");
//    public static By getPasswordError=By.xpath("//div[@id='passwordError']");
    public static By outlookYesBtn=By.xpath("//input[@value='Yes']");
    public static By ticketRows=By.xpath("//tbody/tr[contains(@class,'MuiTableRow-root')]");
    public static By toggleBtn=By.xpath("//input[@role='switch']");
    public static By validateFilterTab=By.xpath("//div[text()='Filters']");
    public static By userGuide=By.xpath("//section/img[@alt='userGuide']");
    public static By myTickets= By.xpath("//section/img[@alt='home']/following-sibling::span");
    public static By supportIcon=By.xpath("//section/img[@alt='Support']");
    public static By logOutBtn=By.xpath("//section/img[@alt='logout']");
    public static By notificationIcon=By.xpath("//button/img[@alt='notification']");
    public static By viewToggleBtn=By.xpath("//div[text()='Support View']");
    public static By passwordError=By.xpath("//div[contains(@class,'error ext-error')]");

public static By loginUsername=By.xpath("//div[@class='leftmenu_empName__hP5QR']");
public static By designation=By.xpath("//div[@class='leftmenu_empRole__I-c4k']");


}