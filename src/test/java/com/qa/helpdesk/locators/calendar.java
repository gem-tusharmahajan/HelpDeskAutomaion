package com.qa.helpdesk.locators;

import org.openqa.selenium.By;

public class calendar {

    public static By ca = By.xpath("//img[@alt='calender']");

    public static By calendarButton = By.xpath("//img[@alt='calender']/ancestor::button");

    public static By calendarTab = By.xpath("//div/span[@class='rdrWeekDay']");

    public static org.openqa.selenium.By calendarMonths(String str) throws InterruptedException {
        return By.xpath("//button/span/span[text()='" + str + "']']");
    }

    public static org.openqa.selenium.By calendarDays(String str) throws InterruptedException {
        return By.xpath("//button/span/span[text()=" + str + "]");
    }

    public static By clearDataBtn = By.xpath("//button[text()='Clear Data']");


    public static By monthBtn = By.xpath("//span[@class='rdrMonthPicker']/select/option");

    public static By yearBtn = By.xpath("//span[@class='rdrYearPicker']/select");

    public static By range=By.xpath("//span[@class='rdrInRange']");
public static By weekend=By.xpath("//button[contains(@class,'rdrDay rdrDayWeekend')]");
    public static org.openqa.selenium.By days(String str) throws InterruptedException
    {
        return By.xpath("//button[contains(@class,'rdrDay')]/span/span[text()='"+str+"']");
        //button[contains(@class,'rdrDay')]/span/span[text()='4']
    }

    public static By nextNavigationButton=By.xpath("//button[@class='rdrNextPrevButton rdrNextButton']");

    public static By previousNavigationButton=By.xpath("//button[@class='rdrNextPrevButton rdrPprevButton']");

    public static By currentMonth=By.xpath("//select/option[@value='3']");

    public static By currentDay=By.xpath("//button[contains(@class,'rdrDay rdrDayToday')]");

public static By totalDays=By.xpath("//button[contains(@class,'rdrDay')]");
    public static By passiveDays=By.xpath("//button[contains(@class,'rdrDay rdrDayPassive')]");


}