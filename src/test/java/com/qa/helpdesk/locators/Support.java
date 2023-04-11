package com.qa.helpdesk.locators;

import org.openqa.selenium.By;

public class Support
{

    public static By employeeViewBtn=By.xpath("//div[@class=' css-rpm0fm']/div[text()='Employee View']");

    public static By supportViewBtn=By.xpath("//div[@class=' css-rpm0fm']/div[text()='Support View']");

    public static By vipButton=By.xpath("//span/img[@alt='vip']/ancestor::button");

    public static By callerName=By.xpath("//input[@aria-describedby='react-select-3-placeholder']");
    public static By ticketHeader=By.xpath("//span[text()='Create New Ticket']");

    public static By callerInformation=By.xpath("//span[contains(@class,'agentForm_icon1__9n7E8')]");

    public static org.openqa.selenium.By headers(String str) throws InterruptedException
    {
        return By.xpath("//div[text()='"+str+"']");

    }

}
