package com.xnotify.bdd.web.step_definitions;

import com.xnotify.bdd.web.screens.CampaignBuilderScreen;
import io.cucumber.java.en.*;

public class CampaignBuilderSteps {

    CampaignBuilderScreen campaign = new CampaignBuilderScreen();

    @Given("user logged into XNotifi application")
    public void userLoggedIntoApplication() {
        campaign.userLoggedIntoApplication();
    }

    @When("user navigates to Campaign Builder module")
    public void navigateCampaignBuilder() {
        campaign.navigateCampaignBuilder();
    }

    @When("user clicks create campaign button")
    public void clickCreateCampaign() {
        campaign.clickCreateCampaign();
    }

    @When("user enters campaign name")
    public void enterCampaignName() {
        campaign.enterCampaignName();
    }

    @When("user enters campaign description as {string}")
    public void enterCampaignDescription(String description) {
        campaign.enterCampaignDescription(description);
    }

    @When("user selects campaign type as {string}")
    public void selectCampaignType(String campaignType) throws InterruptedException {
        campaign.selectCampaignType(campaignType);
    }

    @When("user selects campaign goal as {string}")
    public void selectCampaignGoal(String goal) throws InterruptedException {
        campaign.selectCampaignGoal(goal);
    }

    @When("user selects audience as {string} and target audience as {string}")
    public void selectAudience(String audience, String targetAudience) throws InterruptedException {
        campaign.selectAudience(audience, targetAudience);
    }

    @When("user clicks visual flow buildert tab")
    public void clickVisualFlowBuilder() {
        campaign.clickVisualFlowBuilder();
    }

    @When("user clicks schedule tab")
    public void clickScheduleTab() {
        campaign.clickScheduleTab();
    }

    @When("user adds {string} node in visual flow")
    public void addNode(String nodeType) {
        campaign.addNode(nodeType);
    }

    @When("user configures {string} schedule type")
    public void configureSchedule(String scheduleType) throws InterruptedException {
        campaign.configureSchedule(scheduleType);
    }

    @When("user clicks save and publish button")
    public void saveAndPublish() throws InterruptedException {
        campaign.saveAndPublish();
    }

    @Then("campaign should be created successfully")
    public void verifyCampaignCreated() {
        campaign.verifyCampaignCreated();
    }

    @Then("validation message should be displayed")
    public void verifyValidationMessage() {
        campaign.verifyValidationMessage();
    }
}
