package com.xnotify.bdd.web.screens;

import com.xnotify.bdd.ccl.PlayActions;

public class CampaignBuilderScreen {

    PlayActions play = new PlayActions();

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
    String scheduleDropdown = "//label[text()='Scheduling Type']/following-sibling::button";
    String scheduleTypeOption = "//div[@role='option']/span[2]";
    String savePublishButton = "//button[text()='Save']";
    String successMessage = "//div[contains(text(),'successfully')]";
    String validationMessage = "//div[contains(@class,'error')]";
    String segmentUserButton = "//button[text()='Segment']";
    String singleUserButton = "//button[text()='Single User']";
    String targetAudienceDropdown = "//button[text()='Segment']/following::button[@role='combobox']";
    String targetAudienceOption = "//div[@role='option']/span[2]";
    String visualFlowBuilderTab = "//button[text()='Visual Flow']";
    String addNodeButton = "//button[text()='Add Node']";
    String scheduleTab = "//button[text()='Schedule']";

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

    public void enterCampaignName(String campaignName) {
        play.fill(campaignNameField, campaignName, "Campaign Name");
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
        } else if (audience.equalsIgnoreCase("Single User")) {
            play.click(singleUserButton, "Single User Button");
        } else {
            System.out.println("Invalid Audience Type : " + audience);
        }

        selectTargetAudience(targetAudience);
    }

    public void selectTargetAudience(String targetAudience) throws InterruptedException {
        play.click(targetAudienceDropdown, "Target Audience Dropdown");
        play.selectOptionFromDropdown(targetAudienceOption, targetAudience);
    }

    public void clickVisualFlowBuilder() {
        play.click(visualFlowBuilderTab, "Visual Flow Builder Tab");
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
        }
    }

    public void configureSchedule(String scheduleType) throws InterruptedException {

        play.click(scheduleDropdown, "Schedule Dropdown");
        play.selectOptionFromDropdown(scheduleTypeOption, scheduleType);
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
}
