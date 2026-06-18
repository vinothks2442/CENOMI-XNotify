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
    public void clickVisualFlowBuilder() throws InterruptedException {
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

    @When("user selects desired date and time as {string} and {string}")
    public void selectDateTime(String date, String time) {
        campaign.selectDateTime(date, time);
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

    @When("user enters campaign name in search field as {string}")
    public void searchCampaign(String campaignName) {
        campaign.searchCampaign(campaignName);
    }

    @When("user enters invalid campaign name in search field as {string}")
    public void searchCampaigns(String campaignName) {
        campaign.enterCampaign(campaignName);
    }

    @When("user clears campaign search field")
    public void clearCampaignSearch() {
        campaign.clearCampaignSearch();
    }

    @When("user selects campaign status as {string}")
    public void selectCampaignStatus(String status) throws InterruptedException {
        campaign.selectCampaignStatus(status);
    }

    @When("user selects campaign channel as {string}")
    public void selectCampaignChannel(String channel) throws InterruptedException {
        campaign.selectCampaignChannel(channel);
    }

    @When("user enters creator name as {string}")
    public void enterCreatorName(String creator) {
        campaign.enterCreatorName(creator);
    }

    @When("user selects created date as {string}")
    public void selectCreatedDate(String date) {
        campaign.selectCreatedDate(date);
    }

    @When("user selects rows per page as {string}")
    public void selectRowsPerPage(String rows) throws InterruptedException {
        campaign.selectRowsPerPage(rows);
    }

    @When("user clicks reset filter button")
    public void clickResetFilter() {
        campaign.clickResetFilter();
    }

    @Then("matching {string} records should be displayed")
    public void verifyCampaignRecordsDisplayed(String matchingText) throws InterruptedException {
        campaign.verifyFilteredCampaignNameMatchingRecordsDisplayed(matchingText);
    }

    @Then("matching member {string} records should be displayed")
    public void verifyMemberRecordsDisplayed(String matchingText) throws InterruptedException {
        // campaign.verifyFilteredMemberNameMatchingRecordsDisplayed(matchingText);
    }

    @Then("matching filtered campaign records should be displayed")
    public void verifyFilteredCampaignRecordsDisplayed() {
        campaign.verifyCampaignRecordsDisplayed();
    }

    @Then("matching filtered campaign name {string} and status {string} records should be displayed")
    public void verifyFilteredCampaignRecordsDisplayed(String campaignName, String status) throws InterruptedException {
        campaign.verifyFilteredCampaignMatchingRecordsDisplayed(campaignName, status);
    }

    @Then("matching filtered campaign name {string} and channel {string} records should be displayed")
    public void verifyFilteredCampaignNameAndChannel(String campaignName, String channel) throws InterruptedException {
        campaign.verifyFilteredCampaignMatchingRecordsDisplayed(campaignName, channel);
    }

    @Then("matching filtered campaign status {string} and channel {string} records should be displayed")
    public void verifyFilteredCampaignStatusAndChannel(String campaignStatus, String channel)
            throws InterruptedException {
        campaign.verifyFilteredCampaignStatusAndChannel(campaignStatus, channel);
    }

    @Then("matching filtered campaign channel {string} and status {string} records should be displayed")
    public void verifyFilteredCampaignChannelAndStatusDisplayed(String expectedChannel, String status)
            throws InterruptedException {
        campaign.verifyFilteredCampaignMatchingChannelAndStatus(expectedChannel, status);
    }

    @Then("matching filtered campaign creator {string} and status {string} records should be displayed")
    public void verifyFilteredCampaignCreatedByAndStatusDisplayed(String expectedCreator, String status)
            throws InterruptedException {
        campaign.verifyFilteredCampaignMatchingCreatorAndStatus(expectedCreator, status);
    }

    @Then("filtered campaigns with status {string} should be displayed")
    public void verifyStatusFilteredRecords(String status) throws InterruptedException {
        campaign.verifyFilteredCampaignStatusRecordsDisplayed(status);
    }

    @Then("filtered campaigns with channel {string} should be displayed")
    public void verifyChannelFilteredRecords(String channel) throws InterruptedException {
        campaign.verifyFilteredCampaignChannelRecordsDisplayed(channel);
    }

    @Then("filtered campaigns created by {string} should be displayed")
    public void verifyCreatorFilteredRecords(String creator) throws InterruptedException {
        campaign.verifyFilteredCampaignCreatorRecordsDisplayed(creator);
    }

    @Then("campaigns created on selected date should be displayed")
    public void verifyDateFilteredRecords() {
        campaign.verifyCampaignRecordsDisplayed();
    }

    @Then("all campaign records should be displayed")
    public void verifyAllCampaignRecordsDisplayed() {
        campaign.verifyCampaignRecordsDisplayed();
    }

    @Then("no campaign records should be displayed")
    public void verifyNoCampaignRecordsDisplayed() throws InterruptedException {
        campaign.verifyNoRecordsDisplayed("No campaigns found");
    }
}
