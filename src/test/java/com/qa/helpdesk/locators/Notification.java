package com.qa.helpdesk.locators;

import org.openqa.selenium.By;

public class Notification
{
    public static By notifications=By.xpath("//div/span[text()='Notifications']");
    public static By notificationTickets=By.xpath("//div[@class='notification_mainBody__E6eFf']/li");
    public static By unreadNotifications=By.xpath("//div[@role='button']/div[text()='Unread']");

    public static By noNewNotification=By.xpath("//div[text()='No new notification !!']");
    public static By showMore=By.xpath("//a/u[contains(@class,'notification_showMore__RnR9I')]");
    public static By totalTickets=By.xpath("//div[@class='notification_mainBody__E6eFf']/li");

    public static By notificationIconTickets=By.xpath("//div[contains(@class,'header_count__-dTHO')]/span");

    public static By firstTicket=By.xpath("//div[@class='notification_mainBody__E6eFf']/li");

    public static By ticketHeader=By.xpath("//section[@class='header_myTickets__aaVje']");

}