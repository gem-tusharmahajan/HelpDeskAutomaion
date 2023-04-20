package com.qa.helpdesk.locators;
import org.openqa.selenium.By;

public class SupportTicketCreation
{
    public static By callerName=By.xpath("//div[text()='Search name']/following::input");

    public static By callerOptions(String str){
        return By.xpath("//div[text()='"+str+"']");
    }
    public static By channel=By.xpath("//div[text()='Choose channel']/following-sibling::input");
}
