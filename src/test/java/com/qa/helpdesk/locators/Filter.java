package com.qa.helpdesk.locators;

import org.openqa.selenium.By;

public class Filter {

    public static By validateFilterTab = By.xpath("//div[text()='Filters']");

    public static By filterIcon = By.xpath("//button[contains(@class,'btn btn-light')]");

    public static org.openqa.selenium.By department(String str) throws InterruptedException {
        return By.xpath("//button[contains(text(),'" + str + "')]");
    }

    public static org.openqa.selenium.By status(String str) throws InterruptedException {
        return By.xpath("//button[contains(text(),'" + str + "')]");
    }

    public static By rowPerPage = By.xpath("//select[@aria-label='rows per page']");

    public static By rowPerPageDropdown = By.xpath("//select[@aria-label='rows per page']/option[text()='25']");

    public static By noOfTickets = By.xpath("//p[contains(@class,'MuiTablePagination-displayedRows')]");

    public static By clearAll = By.xpath("//button[@class='filters_clearButton__ZWsvi']");

    public static org.openqa.selenium.By departmentColumn(String str) {
        return By.xpath("//th[text()='Department']/ancestor::table/tbody/tr['" + str + "']/td['" + str + "']");
    }

    public static By departmentCol = By.xpath("//th[text()='Department']/ancestor::table/tbody/tr/td[3]");

    public static By statusCol = By.xpath("//th[text()='Status']/ancestor::table/tbody/tr/td[7]");


    public static org.openqa.selenium.By departmentCols(String str) {
        return By.xpath("(//th[text()='Department']/ancestor::table/tbody/tr/td[3])["+str+"]");
    }
    public static org.openqa.selenium.By statusCol(String str)
    {
        return By.xpath("(//th[text()='Department']/ancestor::table/tbody/tr/td[7])['"+str+"']");
    }

    public static By crossFilterButton=By.xpath("//div/img[@alt='cross icon']");

    public static By closedFilter=By.xpath("//div[@class='filters_filterWrapper__pVutl container']");


}