package com.SS.step_definitions;

import com.SS.pages.PodcastPage;
import com.SS.utilities.ConfigurationReader;
import com.SS.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class GoToPodcast_StepDefs {

    PodcastPage podcastPage = new PodcastPage();

    @Given("User navigate to SchoolStatus.com")
    public void user_navigate_to_school_status_com() {
        Driver.get().get(ConfigurationReader.getProperty("url"));
        Driver.get().manage().window().maximize();

    }
    @And("User login as a Teacher successfully")
    public void userLoginAsATeacherSuccessfully() {
        podcastPage.loginModule.click();
        podcastPage.login("teacher");
    }
    @Given("User go to Resources module")
    public void user_go_to_resources_module() {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(podcastPage.resourcesModule).perform();


    }
    @When("User clicks on Podcast module from dropdown")
    public void user_clicks_on_podcast_module_from_dropdown() {

        podcastPage.podcast.click();
    }
    @Then("Verify Title is {string}")
    public void verify_title_is_class_dismissed_podcasts(String expectedTitle) {

        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }


}
