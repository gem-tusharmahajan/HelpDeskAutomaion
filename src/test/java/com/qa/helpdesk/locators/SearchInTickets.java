package com.qa.helpdesk.locators;

import org.openqa.selenium.By;

public class SearchInTickets {

    public static By searchTicket=By.xpath("//input[@name='search']");

    public static By searchBar=By.xpath("//button[contains(@class,'py-2 button_backgroundBtn__vdCcK px-3')]");
    public static By ticketId=By.xpath("(//u[contains(@class,'Table_ticketId')])[1]");
    public static By subject=By.xpath("(//td)[2]");
    public static By ticketIcon=By.xpath("//span[@role='button']/img[@id='ID']");
    public static By subjectIcon=By.xpath("//span[@role='button']/img[@id='Subject']");
    public static By departmentIcon=By.xpath("//span[@role='button']/img[@id='Department']");
    public static By ticketDateData=By.xpath("(//td)[5]");
    public static By assignedTo=By.xpath("(//td)[6]");
    public static By status =By.xpath("(//td)[7]");
    public static By rows=By.xpath("//tr");
    public static By crossIcon=By.xpath("//span/img[@alt='cross']");
}