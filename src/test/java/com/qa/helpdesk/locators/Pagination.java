package com.qa.helpdesk.locators;

import org.openqa.selenium.By;

public class Pagination
{
    public static By pagePerDropdown=By.xpath("//div[contains(@class,'MuiInputBase-root MuiInputBase-colorPrimary css-rmmij8')]");

    public static By value(String str) throws InterruptedException
    {
        return By.xpath("//select/option[@value='"+str+"']");
    }
    public static By displayedTickets=By.xpath("//tbody[contains(@class,'MuiTableBody-root css-1xnox0e')]/tr");

    public static By nextButton=By.xpath("//button[@aria-label='Go to next page']");

    public static By previousButton=By.xpath("//button[@aria-label='Go to previous page']");


}
