package com.qa.helpdesk.locators;

import org.openqa.selenium.By;

public class Notification
{
    public static By notifications=By.xpath("//div/span[text()='Notifications']");
    public static By notificationTickets=By.xpath("//div[contains(@class,'notification_mainBody')]/li");
    public static By unreadNotifications=By.xpath("//div[@role='button']/div[text()='Unread']");

    public static By noNewNotification=By.xpath("//div[text()='No new notification !!']");
    public static By showMore=By.xpath("//a/u[contains(@class,'notification_showMore')]");
//    public static By totalTickets=By.xpath("//div[contains(@class,'notification_mainBody')]/li");
    public static By totalTickets=By.xpath("//img[@alt='unread']");
    public static By notificationIconTickets=By.xpath("//div[contains(@class,'header_count')]/span");
    public static By firstTicket=By.xpath("//div[contains(@class,'notification_mainBody')]/li");
    public static By ticketHeader=By.xpath("//section[contains(@class,'header_myTickets')]");

    public static By checkButton=By.xpath("//img[@alt='check']");

}