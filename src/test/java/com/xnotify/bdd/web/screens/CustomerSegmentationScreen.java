package com.xnotify.bdd.web.screens;

import com.xnotify.bdd.ccl.PlayActions;
import com.xnotify.bdd.integrations.common_utils.BrowserFactory;
import com.xnotify.bdd.integrations.common_utils.FilterCriteria;

import net.bytebuddy.utility.RandomString;
import java.util.Map;

public class CustomerSegmentationScreen {

    String attributeOptions = "//div[@id='attribute-dropdown']//div[contains(@class,'option')]";
    String operatorOptions = "//div[@id='operator-dropdown']//div[contains(@class,'option')]";
    String valueTextbox = "//input[@id='value-textbox']";
    String actionOptionLocator = "//div[@role='menuitem']";
    String memberRows = "//table/tbody/tr";
    String noDataMessage = "//td[contains(text(),'No data')]";
    public String searchSegmentNameTextbox = "//input[@placeholder='Search by segment name']";
    public String segmentTypeDropdown = "//button[contains(@role,'combobox')]";
    public String segmentTypeOptions = "//div[@role='option']";

    // ==========================================
    // Navigation
    // ==========================================

    String messagingMenu = "//span[contains(text(),'Messaging')]";
    String customerSegmentationMenu = "//button[text()='Customer Segmentation']";

    // ==========================================
    // Segment Landing Page
    // ==========================================

    String createSegmentButton = "//button[contains(.,'Create Segment')]";

    // ==========================================
    // Segment Type Selection
    // ==========================================

    String dynamicSegmentRadioButton = "//button[contains(.,'Dynamic')]";
    String staticSegmentRadioButton = "//button[contains(.,'Static')]";
    String dateTextbox = "//input[@type='date']";
    String segmentationMenu = "//div[contains(@class,'react-datepicker__day') and not(contains(@class,'outside-month')) and text()='%s']";
    String segmentRows = "//tbody/tr/td[1]/div/p[1]";
    String actionButtonInRow = "//tbody/tr/td[6]/button";

    // ==========================================
    // Basic Information
    // ==========================================

    String segmentNameTextbox = "//input[@placeholder='e.g., Active Android Users']";

    String descriptionTextbox = "//textarea[@placeholder='Describe this segment...']";

    // ==========================================
    // Audience Rules Section
    // ==========================================

    String audienceRulesSection = "//h2[contains(.,'Audience Rules')]";

    String addConditionButton = "//button[contains(.,'Add Condition')]";

    String addGroupButton = "//button[contains(.,'Add Group')]";

    // ==========================================
    // Match Type
    // ==========================================

    String andCondition = "//button[text()='AND']";
    String orCondition = "//button[text()='OR']";

    // ==========================================
    // Attribute Condition Row
    // ==========================================

    String attributeDropdown = "//button[contains(.,'Select attribute')]";

    String operatorDropdown = "//button[contains(.,'Operator')]";

    String conditionValueTextbox = "//input[@placeholder='Enter value...']";

    // ==========================================
    // Dropdown Options
    // ==========================================

    String valueDropdown = "//button[contains(.,'Select value')]";
    String dropdownOptions = "//div[@role='option']";

    // ==========================================
    // Remove Condition
    // ==========================================

    String deleteConditionButton = "//button//*[name()='svg']/ancestor::button";

    // Alternative safer locator
    String deleteConditionButtonAlt = "//button[contains(@class,'text-red')]";

    // ==========================================
    // Save / Cancel
    // ==========================================

    String saveSegmentButton = "//button[contains(.,'Save')]";

    String cancelSegmentButton = "//button[contains(.,'Cancel')]";

    // ==========================================
    // Success / Validation Messages
    // ==========================================

    String successMessage = "//*[contains(text(),'successfully')]";
    String updateSuccessMessage = "//div[text()='Segment updated successfully']";

    String validationMessage = "//*[contains(@class,'error')]";

    // ==========================================
    // Segment Listing
    // ==========================================

    String segmentListingTable = "//table";

    String searchSegmentTextbox = "//input[contains(@placeholder,'Search segments...')]";

    // ==========================================
    // Created Segment
    // ==========================================

    String createdSegmentName = "//table//td[contains(text(),'%s')]";

    PlayActions play = new PlayActions();

    public void navigateToCustomerSegmentation() {
        play.click(customerSegmentationMenu, "Customer Segmentation Menu");
    }

    public void clickCreateSegmentButton() {
        play.click(createSegmentButton, "Create Segment Button");
    }

    public void selectDynamicSegment() {
        play.click(dynamicSegmentRadioButton, "Dynamic Segment");
    }

    public void selectStaticSegment() {
        play.click(staticSegmentRadioButton, "Static Segment");
    }

    public void enterSegmentName() {
        play.fill(segmentNameTextbox, RandomString.make(5), "Segment Name");
    }

    public void enterDescription(String description) {
        play.fill(descriptionTextbox, description, "Description");
    }

    public void selectSegmentType(String segmentType) throws InterruptedException {
        if (segmentType.equalsIgnoreCase("Dynamic")) {
            selectDynamicSegment();
        } else if (segmentType.equalsIgnoreCase("Static")) {
            selectStaticSegment();
        } else {
            throw new IllegalArgumentException("Invalid segment type: " + segmentType);
        }
    }

    public void clickAddConditionButton() {
        play.click(addConditionButton, "Add Condition Button");
    }

    public void clickAddGroupButton() {
        play.click(addGroupButton, "Add Group Button");
    }

    public void selectCondition(String condition) throws InterruptedException {
        if (condition.equalsIgnoreCase("AND")) {
            play.click(andCondition, "AND Condition");
        } else if (condition.equalsIgnoreCase("OR")) {
            play.click(orCondition, "OR Condition");
        } else {
            throw new IllegalArgumentException("Invalid condition: " + condition);
        }
    }

    public void selectAttribute(String attribute) throws InterruptedException {
        play.click(attributeDropdown, "Attribute Dropdown");
        play.selectOptionFromDropdown(dropdownOptions, attribute);
    }

    public void selectOperator(String operator) throws InterruptedException {
        play.click(operatorDropdown, "Operator Dropdown");
        play.selectOptionFromDropdown(dropdownOptions, operator);
    }

    public void enterConditionValue(String value) {
        BrowserFactory.getInstance().getPage().locator(conditionValueTextbox).last().fill(value);
        // play.fill(conditionValueTextbox, value, "Condition Value");
    }

    public void removeCondition() {
        play.click(deleteConditionButton, "Delete Condition");
    }

    public void clickSaveSegmentButton() {
        play.click(saveSegmentButton, "Save Segment");
    }

    public void verifySegmentCreatedSuccessfully() {
        play.waitForVisible(successMessage, 10000, "Segment Success Message");
    }

    public void selectDropdownValue(String value) throws InterruptedException {
        play.click(valueDropdown, "Value Dropdown");
        play.selectOptionFromDropdown(dropdownOptions, value);
    }

    public void selectDateValue(String date) {
        BrowserFactory.getInstance().getPage().locator(dateTextbox).last().fill(date);
        // play.fill(dateTextbox, date, "Date Value");
    }

    public void verifySegmentDisplayedInListing() {
        play.waitForVisible(segmentListingTable, 10000, "Segment Listing Table");
    }

    public void createDynamicSegment(String segmentName, String attribute, String operator, String value)
            throws InterruptedException {
        clickCreateSegmentButton();
        selectDynamicSegment();
        enterSegmentName();
        clickAddConditionButton();
        selectAttribute(attribute);
        selectOperator(operator);
        enterConditionValue(value);
        clickSaveSegmentButton();
    }

    public void createStaticSegment(String segmentName) {
        clickCreateSegmentButton();
        selectStaticSegment();
        enterSegmentName();
        clickSaveSegmentButton();
    }

    public void searchSegment(String segmentName) {
        play.fill(searchSegmentTextbox, segmentName, "Search Segment Textbox");
    }

    public void clickOnCreatedSegment(String segmentName) throws InterruptedException {
        play.clickActionDropdownByName(segmentRows, actionButtonInRow, segmentName);
    }

    public void selectSegmentAction(String action) throws InterruptedException {
        play.selectOptionFromDropdown(actionOptionLocator, action);
    }

    public void updateSegmentDescription(String description) {
        play.fill(descriptionTextbox, description, "Updated Description");
    }

    public void verifySegmentUpdatedSuccessfully() {
        String actualText = play.textContent(updateSuccessMessage);
        play.verifyText(actualText, "Segment updated successfully");
    }

    public void verifyFilteredSegmentNameMatchingRecordsDisplayed(String expectedText) {
        play.validateTableFilters(
                memberRows,
                noDataMessage,
                new FilterCriteria().segmentName(expectedText)
                        .build());
    }

    public void verifyFilteredSegmentTypeMatchingRecordsDisplayed(String expectedText) {
        play.validateTableFilters(
                memberRows,
                noDataMessage,
                new FilterCriteria().segmentType(expectedText)
                        .build());
    }

    public void enterSegmentNameInSearchField(String segmentName) {
        play.fill(searchSegmentTextbox, segmentName, "Search Segment Textbox");
    }

    public void verifyMatchingRecordsDisplayed(String segmentName) {
        play.validateTableFilters(
                memberRows,
                noDataMessage,
                new FilterCriteria().segmentName(segmentName)
                        .build());
    }

    public void selectSegmentTypeFilter(String segmentType) throws InterruptedException {
        play.click(segmentTypeDropdown, "Segment Type Dropdown");
        play.selectOptionFromDropdown(segmentTypeOptions, segmentType);
    }

    public void verifyMatchingRecordsDisplayedBasedOnSegmentType(String segmentType) {
        play.validateTableFilters(
                memberRows,
                noDataMessage,
                new FilterCriteria().segmentType(segmentType)
                        .build());
    }

}
