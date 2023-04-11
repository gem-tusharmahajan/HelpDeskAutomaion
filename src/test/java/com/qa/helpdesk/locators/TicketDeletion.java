package com.qa.helpdesk.locators;

import org.openqa.selenium.By;

public class TicketDeletion {

    public static By options = By.xpath("(//button/img[@alt='more'])[1]");
    public static By cancelReason = By.xpath("//textarea[@id='userConsent']");
    public static By cancelTicket = By.xpath("//img[@alt='delete']/following-sibling::span");
    public static By cancelBtn = By.xpath("//button[text()='Cancel Ticket']");
    public static By cancelTicketbtn=By.xpath("//span[text()='Cancel Ticket']");

    public static By status=By.xpath("//td[text()='Cancelled']");
    public static By errorMessage=By.xpath("//span[text()='Reason is required']");
    public static By timelineOpen=By.xpath("//div[text()='Open']");
    public static By timelineCancelled=By.xpath("//div[text()='Cancelled']");
    public static By timelineButton=By.xpath("//div[text()='Show Timeline']");

}