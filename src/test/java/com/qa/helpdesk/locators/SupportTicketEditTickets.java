package com.qa.helpdesk.locators;

import org.openqa.selenium.By;

public class SupportTicketEditTickets {


    public static By department = By.xpath("//div/div/div/label[text()='Department']/../div/div/div/div/div/div[text()='HR']");
    public static By chooseDepartment(String str)
    {
    return By.xpath("//div[@class=' css-rpm0fm']/div[text()='"+str+"']");
    }

//  public static By name= By.xpath("//div[@class=' css-rpm0fm']/div[@id='react-select-9-option-1']");

    //div[@class=' css-rpm0fm']/div[text()='Tushar Mahajan  ']
    public static By name(String str)
    {
     String firstName=str+"  ";

     return By.xpath("//div[@class=' css-rpm0fm']/div[text()='"+firstName+"']");
    }

    public static By status(String str)
    {
    return By.xpath("//div[@class=' css-hlgwow']/div[text()='"+str+"']");
    }

    public static By values(String str)
    {
        return By.xpath("//div[text()='"+str+"']");
    }

    public static By submitBtn=By.xpath("//button[text()='Submit']");

//    public static By statuss=By.xpath("//div[contains(@class," css-hlgwow")]/div[text()='Assigned']");

}