package com.qa.helpdesk.locators;

import org.openqa.selenium.By;

public class SupportTicketEditTickets {


    public static By department = By.xpath("//div/div/div/label[text()='Department']/../div/div/div/div/div/div[text()='HR']");
    public static By chooseDepartment(String str)
    {
    return By.xpath("//div[@class=' css-rpm0fm']/div[text()='"+str+"']");
    }

    public static By name(String str)
    {
     String firstName=str+"  ";
     return By.xpath("//label[text()='Assigned To']/following::div[text()='"+firstName+"']");
    }

    public static By status(String str)
    {
       return By.xpath("//label[text()='Status']/following::div[text()='"+str+"']");
    }

    public static By values(String str)
    {
        return By.xpath("//div[text()='"+str+"']");
    }

    public static By submitBtn=By.xpath("//button[text()='Submit']");

}