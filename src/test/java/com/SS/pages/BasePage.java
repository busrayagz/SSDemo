package com.SS.pages;

import com.SS.utilities.ConfigurationReader;
import com.SS.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath = "//a[@class='header-logo']//img[@alt='SchoolStatus']")
    public WebElement schoolStatusLogo;

    @FindBy(xpath = "//a[normalize-space()='How It Works']")
    public WebElement howItWorksModule;

    @FindBy(xpath = "//a[@href='https://www.schoolstatus.com/who-we-serve']")
    public WebElement whoItsForModule;

    @FindBy(css = "a[href='https://www.schoolstatus.com/features']")
    public WebElement featuresModule;

    @FindBy(xpath = "//li[@class='has-menu']//a[@href='#'][normalize-space()='About']")
    public WebElement aboutModule;

    @FindBy(xpath = "//a[@href='https://www.schoolstatus.com/resources']")
    public WebElement resourcesModule;

    @FindBy(xpath = "//a[@class='login']")
    public WebElement loginModule;

    //for login purposes

    @FindBy(xpath = "//input[@id='userName']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//span/button")
    public WebElement loginBtn;

    public void login(String role) {
        String email = "";
        String password = "";

        switch (role) {
            case "admin":
                email = ConfigurationReader.getProperty("admin");
                password = ConfigurationReader.getProperty("adminPass");
                break;

            case "teacher":
                email = ConfigurationReader.getProperty("teacher");
                password = ConfigurationReader.getProperty("teacherPass");
                break;
            case "student":
                email = ConfigurationReader.getProperty("student");
                password = ConfigurationReader.getProperty("studentPass");
                break;

            case "parent":
                email = ConfigurationReader.getProperty("parent");
                password = ConfigurationReader.getProperty("parentPass");
                break;

            default:

                throw new RuntimeException("Invalid Role Entry : >> " + role + " <<");
        }
        //PS: This will NOT work because data we use is NOT real data.
        String mainWindow = Driver.get().getWindowHandle();
        Set<String> windowHandles = Driver.get().getWindowHandles();
        for (String windowHandle : windowHandles) {
            Driver.get().switchTo().window(windowHandle);
        }
        usernameField.sendKeys(email);
        passwordField.sendKeys(password);
        loginBtn.click();
        Driver.get().switchTo().window(mainWindow);
    }
}
