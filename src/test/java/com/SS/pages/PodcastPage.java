package com.SS.pages;

import com.SS.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PodcastPage extends BasePage {

    public PodcastPage() {
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//li[contains(@class,'has-menu')]//ul//li//a[normalize-space()='Podcasts']")
    public WebElement podcast;

}
