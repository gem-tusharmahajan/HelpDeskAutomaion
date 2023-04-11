package com.qa.helpdesk.locators;

import org.openqa.selenium.By;

public class Dashboard
{
    public static By userGuide=By.xpath("//section/img[@alt='userGuide']");
    public static By userGuidePdf=By.xpath("//span[text()='Helpdesk User Guide.pdf']");
    public static By copyLink=By.xpath("//span[text()='Copy link']");

    public static By copiedLink=By.xpath("//input[@aria-label='Link copied']");

  public static By copyTabHeading =By.xpath("//button[contains(@class,'ms-Button ms-Button--default')]");

    public static By  shareBtn=By.xpath("//span[text()='Share']");
    public static By closeButton= By.xpath("//button[@aria-label='Close']/span/i[contains(@class,'ms-Icon root-32')]");
    public static By contactEmailId=By.xpath("//p[text()='support.helpdesk@geminisolutions.com']");
    public static By collapseButton=By.xpath("//div/img[@alt='toggle icon']");
    public static By sideMenuDetails=By.xpath("//div[@class='leftmenu_profileDetails__7980x']");
    public static By crossButton=By.xpath("//button[@class='btn-close']");
    public static By logOutButton=By.xpath("//img[@src='../assets/ICON_Logout.svg']");
}