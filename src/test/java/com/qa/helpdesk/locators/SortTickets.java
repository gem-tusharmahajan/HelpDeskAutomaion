package com.qa.helpdesk.locators;

import org.openqa.selenium.By;

public class SortTickets
{

    public static By ticketIcon=By.xpath("//span[@role='button']/img[@id='ID']");
    public static By subjectIcon=By.xpath("//span[@role='button']/img[@id='Subject']");
    public static By departmentIcon=By.xpath("//span[@role='button']/img[@id='Department']");
    public static By ticketDateData=By.xpath("(//td)[5]");
    public static By assignedTo=By.xpath("(//td)[6]");
    public static By status =By.xpath("(//td)[7]");

    public static By sort= By.xpath("//tr/td[2]");


    public static By sorted=By.xpath("//tr//td[2]");


}
