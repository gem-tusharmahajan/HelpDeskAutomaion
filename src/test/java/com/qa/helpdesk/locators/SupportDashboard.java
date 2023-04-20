package com.qa.helpdesk.locators;

import org.openqa.selenium.By;

public class SupportDashboard
{

    public static By employeeViewBtn=By.xpath("//div[@class=' css-rpm0fm']/div[text()='Employee View']");

    public static By supportViewBtn=By.xpath("//div[@class=' css-rpm0fm']/div[text()='Support View']");

//    public static By vipButton=By.xpath("//span/img[@alt='vip']/ancestor::button");

    public static By callerName=By.xpath("//input[@aria-describedby='react-select-3-placeholder']");
    public static By ticketHeader=By.xpath("//span[text()='Create New Ticket']");

    public static By callerInformation=By.xpath("//span[contains(@class,'agentForm_icon1__9n7E8')]");

    public static By headers(String str) throws InterruptedException
    {
        return By.xpath("//div[text()='"+str+"']");

    }
    public static By subCategory=By.xpath("//label[text()='Sub-category ']/following-sibling::div");
    public static By editTicket=By.xpath("//div/img[@alt='Edit']");
    public static By configuration=By.xpath("//input[@placeholder='Enter Configuration Item']");
    public static By assignedTo=By.xpath("//label[text()='Assigned To']/following::input[1]");
    public static By assignedToOptions(String str)
    {
        return By.xpath("//div[@class=' css-rpm0fm']/div[text()='"+str+"']");
    }
     public static By footerCount=By.xpath("//p[@class='MuiTablePagination-displayedRows css-1chpzqh']");
    public static By type(String str)

    {
        return By.xpath("//div[text()='"+str+"']");
    }
    public static By editTicketIcon=By.xpath("//button/img[@aria-label='Edit Ticket']");

    public static By submitBtn=By.xpath("//button[text()='Submit']");
   public static By vipButton=By.xpath("//span/img[@alt='vip']/ancestor::button");
   public static By vipRows=By.xpath("//tr[contains(@class,'MuiTableRow-root tickettableagent_vipRow')]");
   public static By vipTags=By.xpath("//td/img[@alt='vipTag']");
    public static By totalRows=By.xpath("//tbody/tr");

    public static By arrowDown=By.xpath("(//img[contains(@class,'QuickAssign_arrowDown')])[1]");

    public static By assignToMe=By.xpath("//li[@role='menuitem']/div[text()='Assign to me']");

    public static By unAssignedTicketId=By.xpath ("(//img[contains(@class,'QuickAssign_arrowDown')]/../../preceding-sibling::td/a)[1]");

    public static By ticketStatus=By.xpath("//div[text()='Status']/following-sibling::div");

    public static By previousArrow=By.xpath("//img[@alt='home']");

    public static By loader=By.xpath("//div[contains(@class,'Loader_cover')]");

    public static By statusDropdown=By.xpath("(//img[contains(@class,'QuickStatusChange_arrowDown')])[1]");

//    public static By status=By.xpath("//li[@role='menuitem']/div[text()='Assign to me']");

    public static By status(String str){
        return By.xpath("//li[@role='menuitem']/div[text()='"+str+"']");
    }
    public static By assignedTicketId=By.xpath("(//img[contains(@class,'QuickStatusChange_arrowDown')]/../../preceding-sibling::td/a)[1]");

    public static By assignTab=By.xpath("//div[text()='Assigned']");
}