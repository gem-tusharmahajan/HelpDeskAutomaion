package com.qa.helpdesk.locators;

import org.openqa.selenium.By;

public class TicketCreation
{
    public static By createTicket=By.xpath("//button[text()='Create New Ticket']");
    public static By subject=By.xpath("//input[@placeholder='Enter Subject']");
    public static By ticketTab=By.xpath("//div[text()='Create New Ticket']");
    public static By type=By.xpath("//div/div/div/label[text()='Type']/../../div/div/div/div/div/div[text()='Choose Option']");
    public static By departmentType=By.xpath("//div/div/div/label[text()='Department']/../div/div/div/div/div/div[text()='Choose Option']");
    public static By incident=By.xpath("//div[text()='Incident']");
    public static By request=By.xpath("//div[text()='Request']");
    public static org.openqa.selenium.By departments(String str) throws InterruptedException
    {
        return By.xpath("//div[text()='"+str+"']");
    }
    public static By description=By.xpath("//textarea[@name='description']");
    public static By submitBtn=By.xpath("//button[text()='Submit']");
    public static By continueBtn=By.xpath("//button[text()='Continue']");
    public static By ticketId=By.xpath("(//u[contains(@class,'Table_ticketId')])[1]");
    public static By previewFileUpload=By.xpath("//div[@class='modal_uploadedFile__U-EK9']/img");
    public static By previewFileUploaded=By.xpath("//div[@class='modal_uploadedFile__U-EK9']/img");

    public static By ticketDateData=By.xpath("(//td)[5]");

    public static By assignedTo=By.xpath("(//td)[6]");

    public static By uploadFiles=By.xpath("//div[@role='presentation']/input");
    public static By itIncidentDepartment=By.xpath("//div[text()='Department']/following-sibling::div");
    public static By itIncidentDescription=By.xpath("//div[text()='Description']/following-sibling::div");

    public static By itRequestDepartments=By.xpath("//label[text()='Department']/following-sibling::div");
    public static By commentTextArea=By.xpath("//textarea");
    public static By updateBtn=By.xpath("//button[text()='Update']");
    public static By attachFiles=By.xpath("//div[@role='presentation']/input");
    public static By commentUpdate=By.xpath("(//div/span[text()='TM']/../div)[2]");
    public static By category=By.xpath("//label[text()='Category']/following-sibling::div");
    public static org.openqa.selenium.By categoryOptions(String str) throws InterruptedException
    {
        return By.xpath("//div[text()='"+str+"']");
    }

    public static By subCategory=By.xpath("//label[text()='Sub-category']/following-sibling::div");
    public static org.openqa.selenium.By subCategoryOptions(String str) throws InterruptedException
    {
        return By.xpath("//div[text()='"+str+"']");
    }
   public static By ticketCreationLogo=By.xpath("//div/img[@alt='ticket created']");
    public static By ticketNumber=By.xpath("//span[text()='Ticket ID:']/ancestor::p");
    public static By previewSubject=By.xpath("//label[@for='subject']/following-sibling::p");
    public static By previewType=By.xpath("//label[@for='type']/../../p");
    public static By previewDescription=By.xpath("//label[@for='description']/following-sibling::p");
    public static By previewDepartment=By.xpath("//label[@for='department']/following-sibling::p");
    public static By previewBtn=By.xpath("//button[text()='Preview']");

    public static By calendarImg = By.xpath("//img[@alt='calender']");

    public static By sampleCategory=By.xpath("//div[text()='sub type 1']");

    public static By sampleSubCategory=By.xpath("//div[text()='sample req type']");
    public static By previewRequestDepartment=By.xpath("//label[text()='Department']/following-sibling::p");
    public static By previewCategory=By.xpath("//label[text()='Category']/following-sibling::p");
    public static By previewSubCategory=By.xpath("//label[text()='Sub-category']/following-sibling::p");
    public static By subjectError=By.xpath("//span[text()='Subject is required']");
    public static By typeError=By.xpath("//span[text()='Type is required']");
    public static By departmentError=By.xpath("//span[text()='Department is required']");
    public static By descriptionError=By.xpath("//span[text()='Description is required']");
    public static By uploadedFile=By.xpath("//div[contains(@class,'row mt-2')]");
    public static By multipleFiles=By.xpath("//div[@class='row mt-2 modal_labelValue__gAjkJ']");
}