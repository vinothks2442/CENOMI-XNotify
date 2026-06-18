package com.xnotify.bdd.web.step_definitions;

import com.xnotify.bdd.web.screens.CustomerSegmentationScreen;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CustomerSegmentationSteps {

    CustomerSegmentationScreen segmentation = new CustomerSegmentationScreen();

    @Given("user navigates to Customer Segmentation page")
    public void navigateToCustomerSegmentation() {
        segmentation.navigateToCustomerSegmentation();
    }

    @When("user clicks Create Segment button")
    public void clickCreateSegmentButton() {
        segmentation.clickCreateSegmentButton();
    }

    @When("user selects Dynamic Segment type")
    public void selectDynamicSegmentType() {
        segmentation.selectDynamicSegment();
    }

    @When("user selects Static Segment type")
    public void selectStaticSegmentType() {
        segmentation.selectStaticSegment();
    }

    @When("user selects segment type as {string}")
    public void selectSegmentType(String segmentType) throws InterruptedException {
        segmentation.selectSegmentType(segmentType);
    }

    @When("users enters segment description as {string}")
    public void enterSegmentDescription(String description) {
        segmentation.enterDescription(description);
    }

    @When("user enters segment name")
    public void enterSegmentName() {
        segmentation.enterSegmentName();
    }

    @When("user clicks Add Condition button")
    public void clickAddConditionButton() {
        segmentation.clickAddConditionButton();
    }

    @When("user clicks Add Group button")
    public void clickAddGroupButton() {
        segmentation.clickAddGroupButton();
    }

    @When("user selects AND condition")
    public void selectAndCondition() throws InterruptedException {
        segmentation.selectCondition("AND");
    }

    @When("user selects OR condition")
    public void selectOrCondition() throws InterruptedException {
        segmentation.selectCondition("OR");
    }

    @When("user selects attribute {string}")
    public void selectAttribute(String attribute) throws InterruptedException {
        segmentation.selectAttribute(attribute);
    }

    @When("user selects operator {string}")
    public void selectOperator(String operator) throws InterruptedException {
        segmentation.selectOperator(operator);
    }

    @When("user enters condition value {string}")
    public void enterConditionValue(String value) {
        segmentation.enterConditionValue(value);
    }

    @When("user enters condition value as {string}")
    public void enterValue(String value) throws InterruptedException {
        segmentation.selectDropdownValue(value);
    }

    @When("user selects date value as {string}")
    public void selectDateValue(String date) {
        segmentation.selectDateValue(date);
    }

    @When("user removes condition")
    public void removeCondition() {
        segmentation.removeCondition();
    }

    @When("user clicks Save Segment button")
    public void clickSaveSegmentButton() {
        segmentation.clickSaveSegmentButton();
    }

    @Then("segment should be created successfully")
    public void verifySegmentCreatedSuccessfully() {
        segmentation.verifySegmentCreatedSuccessfully();
    }

    @When("user selects dropdown value {string}")
    public void selectDropdownValue(String value) throws InterruptedException {
        segmentation.selectDropdownValue(value);
    }

    @Then("segment should be displayed in segment listing")
    public void verifySegmentDisplayedInListing() {
        segmentation.verifySegmentDisplayedInListing();
    }

    @When("user clicks on the created segment action based on {string} segment name")
    public void clickSegmentActionByName(String segmentName) throws InterruptedException {
        segmentation.clickOnCreatedSegment(segmentName);

    }

    @When("user selects action as {string} from segment action dropdown")
    public void selectSegmentAction(String action) throws InterruptedException {
        segmentation.selectSegmentAction(action);
    }

    @When("user updates segment description as {string}")
    public void updateSegmentDescription(String updatedDescription) {
        segmentation.updateSegmentDescription(updatedDescription);
    }

    @When("segment should be updated successfully")
    public void verifySegmentUpdatedSuccessfully() {
        segmentation.verifySegmentUpdatedSuccessfully();
    }

    @When("user enters segment name in search field as {string}")
    public void enterSegmentNameInSearchField(String segmentName) throws InterruptedException {
        segmentation.enterSegmentNameInSearchField(segmentName);
    }

    @When("matching {string} records should be displayed in the search results")
    public void verifyMatchingRecordsDisplayed(String segmentName) throws InterruptedException {
        segmentation.verifyMatchingRecordsDisplayed(segmentName);
    }

    @When("user selects segment type as {string} option from segment type filter dropdown")
    public void selectSegmentTypefromdropdown(String segmentType) throws InterruptedException {
        segmentation.selectSegmentTypeFilter(segmentType);
    }

    @When("filtered segments with type {string} should be displayed")
    public void verifyMatchingRecordsDisplayedBasedOnSegmentType(String segmentType) throws InterruptedException {
        segmentation.verifyMatchingRecordsDisplayedBasedOnSegmentType(segmentType);
    }

}
