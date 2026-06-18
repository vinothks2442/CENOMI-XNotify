package com.xnotify.bdd.web.screens;

import com.microsoft.playwright.Page;
import com.xnotify.bdd.ccl.PlayActions;
import com.xnotify.bdd.integrations.common_utils.FilterCriteria;
import com.xnotify.bdd.integrations.common_utils.RandomGenerator;

public class TeamManagementScreen {

    PlayActions play = new PlayActions();
    RandomGenerator random = new RandomGenerator();

    // Navigation
    String settingsMenu = "//span[text()='Settings']";
    String teamManagementMenu = "//button[text()='Team Management']";

    // Dashboard
    String totalMembersCard = "//p[contains(text(),'Total Members')]";
    String activeMembersCard = "//p[contains(text(),'Active Members')]";
    String pendingInvitesCard = "//p[contains(text(),'Pending Invites')]";
    String adminsCard = "//p[contains(text(),'Admins')]";

    // Invite Member
    String inviteMemberButton = "//button[contains(.,'Invite Member')]";
    String memberEmailField = "//input[@type='email']";
    String roleDropdown = "//select[@id='role']";
    String dropdownOption = "//div[@role='option']";
    String sendInvitationButton = "//button[contains(.,'Send Invitation')]";
    String cancelInvitationButton = "//button[contains(.,'Cancel')]";

    // Search & Filters
    String searchField = "//input[contains(@placeholder,'Search')]";
    String roleFilterDropdown = "//select[@id='role']";
    String statusFilterDropdown = "#status-filter";
    String resetFilterButton = "//button[contains(.,'Reset')]";

    // Member Grid
    String memberTableRows = "//table/tbody/tr";
    String noRecordsMessage = "//h3[text()='No team members found']";

    // Member Actions
    String actionMenu = "(//button[contains(@aria-label,'action')])[1]";
    String editMemberOption = "//*[text()='Edit Member']";
    String removeMemberOption = "//*[text()='Remove Member']";
    String confirmRemoveButton = "//button[contains(.,'Confirm')]";
    String cancelRemoveButton = "//button[contains(.,'Cancel')]";

    // Edit Member
    String editRoleDropdown = "//button[@role='combobox']";
    String updateButton = "//button[contains(.,'Update')]";

    // Messages
    String successMessage = "//div[text()='Invitation sent successfully']";
    String validationMessage = "//div[text()='Please fill in all required fields']";
    String existingMemberValidationMessage = "//div[text()='This email is already associated with another organization']";
    String accessDeniedMessage = "//*[contains(text(),'Access Denied')]";
    String invitationExpiredMessage = "//*[contains(text(),'expired')]";

    // Pagination
    String nextPageButton = "//button[@aria-label='Next Page']";
    String previousPageButton = "//button[@aria-label='Previous Page']";
    String rowsPerPageDropdown = "//button[contains(@aria-haspopup,'listbox')]";
    String termsAndConditionsCheckbox = "//input[@type='checkbox']";
    String createAccountButton = "//button[contains(.,'Create Account')]";

    String emailColumnHeader = "//th[contains(.,'Email')]";
    String roleColumnHeader = "//th[contains(.,'Role')]";
    String statusColumnHeader = "//th[contains(.,'Status')]";

    String firstNameField = "//input[@id='firstName']";
    String lastNameField = "//input[@id='lastName']";

    // Mailinator
    String mailinatorSearchTextbox = "//input[@id='search']";
    String goToPublicInboxButton = "//button[text()='GO']";
    String firstEmailRow = "(//tbody/tr[@ng-repeat='email in emails'])[1]";

    // Invitation
    String acceptInvitationLink = "//a[contains(text(),'Accept invitation')]";

    // Password Setup
    String passwordTextbox = "(//input[@type='password'])[1]";
    String confirmPasswordTextbox = "(//input[@type='password'])[2]";
    String submitButton = "//button[@type='submit']";
    String frameLocator = "//iframe[@id='html_msg_body']";

    String searchMemberTextbox = "//input[@placeholder='Search team members...']";
    String roleOptions = "//div[@role='option']";

    String statusDropdown = "(//button[contains(@role,'combobox')])[2]";
    String statusOptions = "//div[@role='option']";

    String memberRows = "//table/tbody/tr";

    String noDataMessage = "//*[contains(text(),'No members found')]";

    String enteredEmail;

    public void navigateToTeamManagement() {
        play.click(settingsMenu, "Settings Menu");
        play.click(teamManagementMenu, "Team Management Menu");
    }

    public void verifyDashboardLoaded() {
        play.waitForVisible(totalMembersCard, 10000, "Total Members Card");
        play.waitForVisible(activeMembersCard, 10000, "Active Members Card");
        play.waitForVisible(pendingInvitesCard, 10000, "Pending Invites Card");
        play.waitForVisible(adminsCard, 10000, "Admins Card");
    }

    public void clickInviteMemberButton() {
        play.click(inviteMemberButton, "Invite Member Button");
    }

    public void verifyTotalMembersCard() {
        play.waitForVisible(totalMembersCard, 10000, "Total Members Card");
    }

    public void verifyActiveMembersCard() {
        play.waitForVisible(activeMembersCard, 10000, "Active Members Card");
    }

    public void verifyPendingInvitesCard() {
        play.waitForVisible(pendingInvitesCard, 10000, "Pending Invites Card");
    }

    public void verifyAdminsCard() {
        play.waitForVisible(adminsCard, 10000, "Admins Card");
    }

    public String enterValidMemberEmail() {
        enteredEmail = "team" + System.currentTimeMillis() + "@mailinator.com";
        play.fill(memberEmailField, enteredEmail, "Member Email");
        return enteredEmail;
    }

    public void enterMemberName(String firstName, String lastName) {
        play.fill(firstNameField, firstName, "Member First Name");
        play.fill(lastNameField, lastName, "Member Last Name");
    }

    public void enterExistingMemberEmail(String email) {
        play.fill(memberEmailField, email, "Existing Member Email");
    }

    public void enterInvalidMemberEmail() {
        play.fill(memberEmailField, "invalidemail", "Invalid Email");
    }

    public void enterBlankEmail() {
        play.fill(memberEmailField, "", "Blank Email");
    }

    public void selectRole(String role) throws InterruptedException {
        play.selectOptionsByValue(roleDropdown, role);
    }

    public void clickSendInvitation() {
        play.click(sendInvitationButton, "Send Invitation Button");
    }

    public void clickCancelInvitation() {
        play.click(cancelInvitationButton, "Cancel Invitation Button");
    }

    // =====================================================
    // Search Methods
    // =====================================================

    public void searchMember(String memberEmail) {
        play.fill(searchField, memberEmail, "Member Search");
    }

    public void clearMemberSearch() {
        play.clear(searchField, "Member Search");
    }

    public void verifyMemberRecordsDisplayed() {
        play.waitForVisible(memberTableRows, 10000, "Member Records");
    }

    public void verifyNoMemberRecordsDisplayed() {
        play.waitForVisible(noRecordsMessage, 10000, "No Member Records Message");
    }

    // =====================================================
    // Role Filter Methods
    // =====================================================

    public void selectRoleFilter(String role) throws InterruptedException {
        play.selectOptionsByValue(roleFilterDropdown, role);
    }

    // =====================================================
    // Status Filter Methods
    // =====================================================

    public void selectStatusFilter(String status) throws InterruptedException {
        play.selectOptionsByValue(statusFilterDropdown, status);
    }

    public void clickResetFilter() {
        play.click(resetFilterButton, "Reset Filter Button");
    }

    // =====================================================
    // Edit Member Methods
    // =====================================================

    public void clickActionMenu() {
        play.click(actionMenu, "Member Action Menu");
    }

    public void clickEditMemberOption() {
        play.click(editMemberOption, "Edit Member Option");
    }

    public void updateMemberRole(String role) throws InterruptedException {
        play.click(editRoleDropdown, "Edit Role Dropdown");
        play.selectOptionFromDropdown(dropdownOption, role);
    }

    public void clickUpdateButton() {
        play.click(updateButton, "Update Button");
    }

    public void updateMemberRole(String existingRole, String updatedRole) throws InterruptedException {
        clickActionMenu();
        clickEditMemberOption();
        updateMemberRole(updatedRole);
        clickUpdateButton();
    }

    // =====================================================
    // Remove Member Methods
    // =====================================================

    public void clickRemoveMemberOption() {
        play.click(removeMemberOption, "Remove Member Option");
    }

    public void confirmMemberRemoval() {
        play.click(confirmRemoveButton, "Confirm Remove Button");
    }

    public void cancelMemberRemoval() {
        play.click(cancelRemoveButton, "Cancel Remove Button");
    }

    public void removeMember() {
        clickActionMenu();
        clickRemoveMemberOption();
        confirmMemberRemoval();
    }

    // =====================================================
    // Validation Methods
    // =====================================================

    public void verifySuccessMessage() {
        play.waitForVisible(successMessage, 10000, "Success Message");
    }

    public void verifyValidationMessage() {
        // play.waitForVisible(validationMessage, 10000, "Validation Message");
        String actualValidationMessage = play.textContent(validationMessage);
        String expectedValidationMessage = "Please fill in all required fields";
        play.verifyText(actualValidationMessage, expectedValidationMessage);
    }

    public void verifyExistingMemberValidationMessage() {
        // play.waitForVisible(existingMemberValidationMessage, 10000, "Existing Member
        // Validation Message");
        String actualValidationMessage = play.textContent(existingMemberValidationMessage);
        String expectedValidationMessage = "This email is already associated with another organization";
        play.verifyText(actualValidationMessage, expectedValidationMessage);
    }

    public void verifyAccessDeniedMessage() {
        play.waitForVisible(accessDeniedMessage, 10000, "Access Denied Message");
    }

    public void verifyInvitationExpiredMessage() {
        play.waitForVisible(invitationExpiredMessage, 10000, "Invitation Expired Message");
    }

    public void verifyInvitationSentSuccessfully() {
        verifySuccessMessage();
    }

    public void verifyMemberUpdatedSuccessfully() {
        verifySuccessMessage();
    }

    public void verifyMemberRemovedSuccessfully() {
        verifySuccessMessage();
    }

    // =====================================================
    // Search + Filter Combined Methods
    // =====================================================

    public void searchAndFilterByRole(String email, String role) throws InterruptedException {
        searchMember(email);
        selectRoleFilter(role);
    }

    public void searchAndFilterByStatus(String email, String status) throws InterruptedException {
        searchMember(email);
        selectStatusFilter(status);
    }

    public void filterByRoleAndStatus(String role, String status) throws InterruptedException {
        selectRoleFilter(role);
        selectStatusFilter(status);
    }

    // =====================================================
    // Member Selection Helpers
    // =====================================================

    public void searchExistingMember(String email) {
        searchMember(email);
        verifyMemberRecordsDisplayed();
    }

    public void searchRemovedMember(String email) {
        searchMember(email);
    }

    public void searchPendingMember(String email) {
        searchMember(email);
    }

    public void refreshPage() {
        play.keyboard("F5");
    }

    public void waitForMemberGridRefresh() {
        play.waitForVisible(memberTableRows, 10000, "Member Grid Refresh");
    }

    // =====================================================
    // Sorting Methods
    // =====================================================

    public void sortByEmail() {
        play.click(emailColumnHeader, "Email Column Header");
    }

    public void sortByRole() {
        play.click(roleColumnHeader, "Role Column Header");
    }

    public void sortByStatus() {
        play.click(statusColumnHeader, "Status Column Header");
    }

    // =====================================================
    // Pagination Methods
    // =====================================================

    public void clickNextPage() {
        play.click(nextPageButton, "Next Page Button");
    }

    public void clickPreviousPage() {
        play.click(previousPageButton, "Previous Page Button");
    }

    public void selectRowsPerPage(String rows) throws InterruptedException {
        play.click(rowsPerPageDropdown, "Rows Per Page Dropdown");
        play.selectOptionFromDropdown(dropdownOption, rows);
    }

    // =====================================================
    // Dashboard Count Methods
    // =====================================================

    public String getTotalMembersCount() {
        return play.getInnerText(totalMembersCard);
    }

    public String getActiveMembersCount() {
        return play.getInnerText(activeMembersCard);
    }

    public String getPendingInvitesCount() {
        return play.getInnerText(pendingInvitesCard);
    }

    public String getAdminsCount() {
        return play.getInnerText(adminsCard);
    }

    public void verifyDashboardCountsDisplayed() {
        getTotalMembersCount();
        getActiveMembersCount();
        getPendingInvitesCount();
        getAdminsCount();
    }

    // =====================================================
    // Invitation Acceptance Flow
    // =====================================================

    public void acceptTermsAndConditions() {
        play.check(termsAndConditionsCheckbox, "Terms And Conditions");
    }

    public void clickCreateAccountButton() {
        play.click(createAccountButton, "Create Account Button");
    }

    // =====================================================
    // Login Methods
    // =====================================================

    String loginEmailField = "//input[@type='email']";
    String loginPasswordField = "//input[@type='password']";
    String loginButton = "//button[contains(.,'Login')]";

    public void enterLoginEmail(String email) {
        play.fill(loginEmailField, email, "Login Email");
    }

    public void enterLoginPassword(String password) {
        play.fill(loginPasswordField, password, "Login Password");
    }

    public void clickLoginButton() {
        play.click(loginButton, "Login Button");
    }

    public void login(String email, String password) {
        enterLoginEmail(email);
        enterLoginPassword(password);
        clickLoginButton();
    }

    // =====================================================
    // Permission Validation
    // =====================================================

    public void verifyInviteMemberButtonDisplayed() {
        play.waitForVisible(inviteMemberButton, 10000, "Invite Member Button");
    }

    public void verifyMemberActionsDisplayed() {
        play.waitForVisible(actionMenu, 10000, "Member Actions");
    }

    public void verifyRoleManagementDisplayed() {
        play.waitForVisible(roleFilterDropdown, 10000, "Role Management");
    }

    public void verifyAdminAccess() {
        verifyInviteMemberButtonDisplayed();
        verifyMemberActionsDisplayed();
        verifyRoleManagementDisplayed();
    }

    // =====================================================
    // Browser Navigation Methods
    // =====================================================

    public void refreshBrowser() {
        play.keyboard("F5");
    }

    public void clickBrowserBackButton() {
        play.backButton("", "Browser Back");
    }

    public void clickBrowserForwardButton() {
        play.nextPage("", "Browser Forward");
    }

    // =====================================================
    // Session Validation Methods
    // =====================================================

    public void verifySessionExpired() {
        play.waitForVisible(loginButton, 10000, "Session Expired Login Page");
    }

    // =====================================================
    // Email Validation Methods
    // =====================================================

    public void enterEmailWithLeadingSpaces() {
        play.fill(memberEmailField, "   user@test.com", "Email With Leading Spaces");
    }

    public void enterEmailWithTrailingSpaces() {
        play.fill(memberEmailField, "user@test.com   ", "Email With Trailing Spaces");
    }

    public void enterMaximumLengthEmail() {
        play.fill(memberEmailField,
                "averylongemailaddressforteammanagementtestingpurpose123456789@testdomain.com",
                "Maximum Length Email");
    }

    public void enterExceedingLengthEmail() {
        play.fill(memberEmailField,
                "averyveryveryveryveryveryveryveryveryveryveryverylongemailaddressbeyondlimit@testdomain.com",
                "Exceeding Length Email");
    }

    public void enterSpecialCharacterEmail() {
        play.fill(memberEmailField, "@@@###$$$", "Special Character Email");
    }

    // =====================================================
    // End To End Workflow Methods
    // =====================================================

    public void inviteMember(String email, String role) throws InterruptedException {
        clickInviteMemberButton();
        enterExistingMemberEmail(email);
        selectRole(role);
        clickSendInvitation();
    }

    public void editMemberRole(String role) throws InterruptedException {
        clickActionMenu();
        clickEditMemberOption();
        updateMemberRole(role);
        clickUpdateButton();
    }

    public void deleteMember() {
        clickActionMenu();
        clickRemoveMemberOption();
        confirmMemberRemoval();
    }

    public void navigateToLoginPage() {
        // optional
    }

    public void enterUsername() {
        enterLoginEmail("admin@test.com");
    }

    public void enterPassword() {
        enterLoginPassword("Password@123");
    }

    public void verifyDashboardPageIsVisible() {
        verifyAdminAccess();
    }

    public void verifyLoginPageIsVisible() {
        play.waitForVisible(loginButton, 10000, "Login Page");
    }

    public void openInvitationLink() throws InterruptedException {
        Page page = play.openInvitationLinkAndAcceptInvitation();

        page.navigate("https://www.mailinator.com/");

        page.locator(mailinatorSearchTextbox).fill(enteredEmail);
        page.locator(goToPublicInboxButton).click();
        Thread.sleep(2000); // Wait for email to arrive - replace with better wait
        page.locator(firstEmailRow).click();

        Page childPage = page.context().waitForPage(() -> {
            page.frameLocator(frameLocator).locator(acceptInvitationLink).click();
        });

        childPage.locator(passwordTextbox).fill("Test@1234");
        childPage.locator(confirmPasswordTextbox).fill("Test@1234");
        childPage.locator(submitButton).click();
        childPage.close();
        page.close();
    }

    public void enterMemberNameInSearchField(String memberName) {
        play.fill(searchMemberTextbox, memberName, "Search Member Textbox");
    }

    public void verifyMatchingMemberRecordsDisplayed() {
        play.validateTableFilters(
                memberRows,
                noDataMessage,
                new FilterCriteria()
                        .membername(searchMemberTextbox)
                        .build());
    }

    public void verifyRoleFilteredRecords(String role) {
        play.validateTableFilters(
                memberRows,
                noDataMessage,
                new FilterCriteria()
                        .memberRole(role)
                        .build());
    }

    public void verifyStatusFilteredRecords(String status) {
        play.validateTableFilters(
                memberRows,
                noDataMessage,
                new FilterCriteria()
                        .memberStatus(status)
                        .build());
    }

    public void verifyRoleAndStatusFilteredRecords(String role, String status) {
        play.validateTableFilters(
                memberRows,
                noDataMessage,
                new FilterCriteria()
                        .memberRole(role)
                        .memberStatus(status)
                        .build());
    }

}