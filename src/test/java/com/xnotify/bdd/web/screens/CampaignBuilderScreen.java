package com.xnotify.bdd.web.screens;

import com.xnotify.bdd.ccl.PlayActions;
import com.xnotify.bdd.integrations.common_utils.FilterCriteria;
import com.xnotify.bdd.integrations.common_utils.RandomGenerator;

public class CampaignBuilderScreen {

    PlayActions play = new PlayActions();
    RandomGenerator random = new RandomGenerator();

    String messagingMenu = "//span[text()='Messaging']";
    String campaignBuilderMenu = "//div[text()='Campaigns']";
    String createCampaignButton = "//button[contains(.,'Create Campaign')]";
    String campaignNameField = "//input[@placeholder='Enter campaign name']";
    String campaignDescription = "//textarea[@placeholder='Describe what this campaign does']";
    String campaignTypeDropdown = "//button/span[text()='Select type']";
    String campaignTypeOption = "//div[@role='option']/span[2]";
    String campaignGoalDropdown = "//label[text()='Campaign Goal']/following-sibling::button";
    String campaignGoalOption = "//div[@role='option']/span[2]";
    String audienceDropdown = "//select[@name='audience']";
    String pushNode = "//span[text()='Push']";
    String emailNode = "//span[text()='Email']";
    String inAppNode = "//span[text()='In-App']";
    String scheduleDropdown = "//label[text()='Scheduling Type']/following-sibling::button";
    String scheduleTypeOption = "//div[@role='option']/span[2]";
    String savePublishButton = "//button[text()='Save']";
    String successMessage = "//div[contains(text(),'successfully')]";
    String validationMessage = "//div[contains(@class,'error')]";
    String segmentUserButton = "//button[text()='Segment']";
    String singleUserButton = "//button[text()='Single User']";
    String userEmail = "//input[@type='email']";
    String targetAudienceDropdown = "//button[text()='Segment']/following::button[@role='combobox']";
    String targetAudienceOption = "//div[@role='option']/span[2]";
    String visualFlowBuilderTab = "//button[text()='Visual Flow']";
    String addNodeButton = "//button[text()='Add Node']";
    String scheduleTab = "//button[text()='Schedule']";
    String ScheduleDateTimeField = "//label[text()='Scheduled Date & Time']/following-sibling::input";

    String campaignSearchField = "//input[@placeholder='Search by campaign name...']";
    String statusDropdown = "//button[contains(.,'All Statuses')]";
    String channelDropdown = "//button[contains(.,'All Channels')]";
    String creatorFilterField = "//input[@placeholder='Filter by creator']";
    String createdDateField = "(//input[@placeholder='dd-mm-yyyy'])[1]";
    String rowsPerPageDropdown = "//button[contains(.,'10')]";
    String dropdownOption = "//div[@role='option']/span[2]";
    String resetFilterButton = "//button[contains(.,'Reset')]";
    String campaignTableRows = "//table/tbody/tr";
    String noDataMessage = "//td[contains(text(),'No data')]";
    private String lastSearchTerm = "";
    String noCampaignMessage = "//h3[text()='No campaigns found']";
    String noCampaignText = "//h3[text()='No campaigns found']";

    public void userLoggedIntoApplication() {
        System.out.println("User logged into XNotifi application");
    }

    public void navigateCampaignBuilder() {
        play.click(messagingMenu, "Messaging Menu");
        play.click(campaignBuilderMenu, "Campaign Builder");
    }

    public void clickCreateCampaign() {
        play.click(createCampaignButton, "Create Campaign");
    }

    public void enterCampaignName() {
        play.fill(campaignNameField, RandomGenerator.randomString(10), "Campaign Name");
    }

    public void enterCampaignDescription(String description) {
        play.fill(campaignDescription, description, "Campaign Description");
    }

    public void selectCampaignType(String campaignType) throws InterruptedException {
        play.click(campaignTypeDropdown, "Campaign Type Dropdown");
        play.selectOptionFromDropdown(campaignTypeOption, campaignType);
    }

    public void selectCampaignGoal(String goal) throws InterruptedException {
        play.click(campaignGoalDropdown, "Campaign Goal Dropdown");
        play.selectOptionFromDropdown(campaignGoalOption, goal);
    }

    public void selectAudience(String audience, String targetAudience) throws InterruptedException {

        if (audience.equalsIgnoreCase("Segment")) {
            play.click(segmentUserButton, "Segment User Button");
            selectTargetAudience(targetAudience);
        } else if (audience.equalsIgnoreCase("Single User")) {
            play.click(singleUserButton, "Single User Button");
            play.fill(userEmail, targetAudience, targetAudience);
        } else {
            System.out.println("Invalid Audience Type : " + audience);
        }
    }

    public void selectTargetAudience(String targetAudience) throws InterruptedException {
        play.click(targetAudienceDropdown, "Target Audience Dropdown");
        play.selectOptionFromDropdown(targetAudienceOption, targetAudience);
    }

    public void clickVisualFlowBuilder() throws InterruptedException {
        try {
            play.click(visualFlowBuilderTab, "Visual Flow Builder Tab");
        } catch (Exception e) {
            Thread.sleep(2000);
            System.out.println("Visual Flow Builder Tab not found, retrying...");
            play.click(visualFlowBuilderTab, "Visual Flow Builder Tab");
        }

    }

    public void clickScheduleTab() {
        play.click(scheduleTab, "Schedule tab");
    }

    public void addNode(String nodeType) {
        play.click(addNodeButton, "Add Note button");
        if (nodeType.equalsIgnoreCase("Push")) {
            play.click(pushNode, "Push Node");
        } else if (nodeType.equalsIgnoreCase("Email")) {
            play.click(emailNode, "Email Node");
        } else if (nodeType.equalsIgnoreCase("In-App")) {
            play.click(inAppNode, "inapp Node");
        }
    }

    public void configureSchedule(String scheduleType) throws InterruptedException {

        play.click(scheduleDropdown, "Schedule Dropdown");
        play.selectOptionFromDropdown(scheduleTypeOption, scheduleType);
    }

    public void selectDateTime(String date, String time) {
        play.type(ScheduleDateTimeField, date, "Date");
        play.keyboard("Tab");
        play.type(ScheduleDateTimeField, time, "Time");
    }

    public void saveAndPublish() {
        play.click(savePublishButton, "Save & Publish");
    }

    public void verifyCampaignCreated() {
        play.waitForVisible(successMessage, 10000, "Campaign Created");
    }

    public void verifyValidationMessage() {
        play.waitForVisible(validationMessage, 10000, "Validation Message");
    }

    public void createCampaign() throws InterruptedException {
        // navigateCampaignBuilder();
        // clickCreateCampaign();
        // enterCampaignName();
        // enterCampaignDescription("This is a sample campaign created for automation
        // testing");
        // selectCampaignType("Push");
        // selectCampaignGoal("Customer Engagement");
        // selectAudience("Segment", "All Users");
        // clickVisualFlowBuilder();
        // addNode("Push");
        // clickScheduleTab();
        // configureSchedule("One Time");
        // saveAndPublish();
        // verifyCampaignCreated();
    }

    public void searchCampaign(String campaignName) {
        lastSearchTerm = campaignName == null ? "" : campaignName.trim();
        play.fill(campaignSearchField, campaignName, "Campaign Search");
        play.waitForTableRowText(campaignTableRows, "td:nth-child(1)", lastSearchTerm, 15000);
    }

    public void enterCampaign(String campaignName) {
        play.fill(campaignSearchField, campaignName, "Campaign Search");
    }

    public void clearCampaignSearch() {
        play.clear(campaignSearchField, "Campaign Search");
    }

    public void selectCampaignStatus(String status) throws InterruptedException {
        play.click(statusDropdown, "Status Dropdown");
        play.selectOptionFromDropdown(dropdownOption, status);
    }

    public void selectCampaignChannel(String channel) throws InterruptedException {
        play.click(channelDropdown, "Channel Dropdown");
        play.selectOptionFromDropdown(dropdownOption, channel);
    }

    public void enterCreatorName(String creator) {
        play.type(creatorFilterField, creator, "Creator Filter");
    }

    public void selectCreatedDate(String date) {
        play.fill(createdDateField, date, "Created Date");
    }

    public void selectRowsPerPage(String rows) throws InterruptedException {
        play.click(rowsPerPageDropdown, "Rows Per Page");
        play.selectOptionFromDropdown(dropdownOption, rows);
    }

    public void clickResetFilter() {
        play.click(resetFilterButton, "Reset Filter");
    }

    public void verifyCampaignRecordsDisplayed() {
        play.waitForVisible(campaignTableRows, 10000, "Campaign Records");

    }

    public void verifyFilteredCampaignNameMatchingRecordsDisplayed(String expectedText) throws InterruptedException {
        // play.validateFilteredResults(campaignTableRows, 1, lastSearchTerm);
        play.validateTableFilters(
                campaignTableRows,
                noCampaignMessage,
                new FilterCriteria().campaignName(expectedText)
                        .build());
    }

    public void verifyFilteredCampaignMatchingRecordsDisplayed(String expectedText, String expectedStatus)
            throws InterruptedException {
        // play.validateFilteredResults(campaignTableRows, 1, lastSearchTerm);
        play.validateTableFilters(
                campaignTableRows,
                noCampaignMessage,
                new FilterCriteria().campaignName(expectedText).status(expectedStatus)
                        .build());
    }

    public void verifyFilteredCampaignStatusAndChannel(String expectedStatus, String expectedChannel)
            throws InterruptedException {
        // play.validateFilteredResults(campaignTableRows, 1, lastSearchTerm);
        play.validateTableFilters(
                campaignTableRows,
                noCampaignMessage,
                new FilterCriteria().status(expectedStatus).channel(expectedChannel)
                        .build());
    }

    public void verifyFilteredCampaignNameAndChannel(String expectedText, String expectedChannel)
            throws InterruptedException {
        // play.validateFilteredResults(campaignTableRows, 1, lastSearchTerm);
        play.validateTableFilters(
                campaignTableRows,
                noCampaignMessage,
                new FilterCriteria().campaignName(expectedText).channel(expectedChannel)
                        .build());
    }

    public void verifyFilteredCampaignMatchingChannelAndStatus(String expectedChannel, String expectedStatus)
            throws InterruptedException {
        // play.validateFilteredResults(campaignTableRows, 1, lastSearchTerm);
        play.validateTableFilters(
                campaignTableRows,
                noCampaignMessage,
                new FilterCriteria().channel(expectedChannel).status(expectedStatus)
                        .build());
    }

    public void verifyFilteredCampaignMatchingCreatorAndStatus(String expectedCreator, String expectedStatus)
            throws InterruptedException {
        // play.validateFilteredResults(campaignTableRows, 1, lastSearchTerm);
        play.validateTableFilters(
                campaignTableRows,
                noCampaignMessage,
                new FilterCriteria().createdBy(expectedCreator).status(expectedStatus)
                        .build());
    }

    public void verifyFilteredCampaignStatusRecordsDisplayed(String expectedText) throws InterruptedException {
        // play.validateFilteredResults(campaignTableRows, 1, lastSearchTerm);
        play.validateTableFilters(
                campaignTableRows,
                noCampaignMessage,
                new FilterCriteria().status(expectedText)
                        .build());
    }

    public void verifyFilteredCampaignChannelRecordsDisplayed(String expectedText) throws InterruptedException {
        // play.validateFilteredResults(campaignTableRows, 1, lastSearchTerm);
        play.validateTableFilters(
                campaignTableRows,
                noCampaignMessage,
                new FilterCriteria().channel(expectedText)
                        .build());
    }

    public void verifyFilteredCampaignCreatorRecordsDisplayed(String expectedText) throws InterruptedException {
        // play.validateFilteredResults(campaignTableRows, 1, lastSearchTerm);
        play.validateTableFilters(
                campaignTableRows,
                noCampaignMessage,
                new FilterCriteria().createdBy(expectedText)
                        .build());
    }

    public void verifyNoRecordsDisplayed(String expectedText) throws InterruptedException {
        Thread.sleep(3000);
        String actualText = play.getInnerText(noCampaignText);
        play.verifyText(actualText, expectedText);
    }

}
