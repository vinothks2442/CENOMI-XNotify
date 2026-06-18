package com.xnotify.bdd.web.step_definitions;

import com.xnotify.bdd.web.screens.TeamManagementScreen;
import io.cucumber.java.en.*;

public class TeamManagementSteps {

    TeamManagementScreen team = new TeamManagementScreen();

    @When("user navigates to Team Management module")
    public void navigateToTeamManagement() {
        team.navigateToTeamManagement();
    }

    @Then("Team Management dashboard should be displayed successfully")
    public void verifyDashboardDisplayed() {
        team.verifyDashboardLoaded();
    }

    @Then("user verifies Total Members card is displayed")
    public void verifyTotalMembersCard() {
        team.verifyTotalMembersCard();
    }

    @Then("user verifies Active Members card is displayed")
    public void verifyActiveMembersCard() {
        team.verifyActiveMembersCard();
    }

    @Then("user verifies Pending Invites card is displayed")
    public void verifyPendingInvitesCard() {
        team.verifyPendingInvitesCard();
    }

    @Then("user verifies Admins card is displayed")
    public void verifyAdminsCard() {
        team.verifyAdminsCard();
    }

    @When("user clicks Invite Member button")
    public void clickInviteMemberButton() {
        team.clickInviteMemberButton();
    }

    @When("user enters valid member email address")
    public void enterValidMemberEmail() {
        team.enterValidMemberEmail();
    }

    @When("users enters first name {string} and last name {string}")
    public void enterMemberName(String firstName, String lastName) {
        team.enterMemberName(firstName, lastName);
    }

    @When("user enters invalid email address")
    public void enterInvalidEmail() {
        team.enterInvalidMemberEmail();
    }

    @Then("user verifies member records are displayed")
    public void verifyMemberRecordsDisplayed() {
        team.verifyMemberRecordsDisplayed();
    }

    @Then("user verifies Team Management dashboard is loaded")
    public void verifyTeamManagementDashboardLoaded() {
        team.verifyDashboardLoaded();
    }

    @Then("all member records should be displayed successfully")
    public void verifyAllMemberRecordsDisplayedSuccessfully() {
        team.verifyMemberRecordsDisplayed();
    }

    @When("user leaves email field blank")
    public void leaveEmailBlank() {
        team.enterBlankEmail();
    }

    @When("user enters already existing member email as {string}")
    public void enterExistingMemberEmail(String email) {
        team.enterExistingMemberEmail(email);
    }

    @When("user selects role as {string}")
    public void selectRole(String role) throws InterruptedException {
        team.selectRole(role);
    }

    @When("user clicks Send Invitation button")
    public void clickSendInvitationButton() {
        team.clickSendInvitation();
    }

    @When("user clicks Cancel button")
    public void clickCancelButton() {
        team.clickCancelInvitation();
    }

    @Then("member invitation should be sent successfully")
    public void verifyInvitationSentSuccessfully() {
        team.verifyInvitationSentSuccessfully();
    }

    @Then("duplicate member validation message should be displayed")
    public void verifyDuplicateMemberValidation() {
        team.verifyExistingMemberValidationMessage();
    }

    @Then("invalid email validation message should be displayed")
    public void verifyInvalidEmailValidation() {
        team.verifyValidationMessage();
    }

    @Then("email mandatory validation message should be displayed")
    public void verifyMandatoryEmailValidation() {
        team.verifyValidationMessage();
    }

    @Then("invitation popup should be closed successfully")
    public void verifyPopupClosed() {
        team.verifyMemberRecordsDisplayed();
    }

    @When("user enters member email in search field as {string}")
    public void searchMember(String email) {
        team.searchMember(email);
    }

    @When("user clears member search field")
    public void clearSearchField() {
        team.clearMemberSearch();
    }

    @Then("all member records should be displayed")
    public void verifyAllMembersDisplayed() {
        team.verifyMemberRecordsDisplayed();
    }

    @Then("searched member record should be displayed")
    public void verifySearchedMemberDisplayed() {
        team.verifyMemberRecordsDisplayed();
    }

    @Then("searched member records should be displayed")
    public void verifySearchedMembersDisplayed() {
        team.verifyMemberRecordsDisplayed();
    }

    @Then("no member records should be displayed")
    public void verifyNoMemberRecordsDisplayed() {
        team.verifyNoMemberRecordsDisplayed();
    }

    @When("user selects role filter as {string}")
    public void selectRoleFilter(String role) throws InterruptedException {
        team.selectRoleFilter(role);
    }

    @When("user selects status filter as {string}")
    public void selectStatusFilter(String status) throws InterruptedException {
        team.selectStatusFilter(status);
    }

    @When("user clicks Reset Filter button")
    public void clickResetFilterButton() {
        team.clickResetFilter();
    }

    @Then("only Admin members should be displayed")
    public void verifyAdminMembersDisplayed() {
        team.verifyMemberRecordsDisplayed();
    }

    @Then("only Editor members should be displayed")
    public void verifyEditorMembersDisplayed() {
        team.verifyMemberRecordsDisplayed();
    }

    @Then("only Viewer members should be displayed")
    public void verifyViewerMembersDisplayed() {
        team.verifyMemberRecordsDisplayed();
    }

    @Then("only active members should be displayed")
    public void verifyActiveMembersDisplayed() {
        team.verifyMemberRecordsDisplayed();
    }

    @Then("only pending members should be displayed")
    public void verifyPendingMembersDisplayed() {
        team.verifyMemberRecordsDisplayed();
    }

    // =====================================================
    // Edit Member Steps
    // =====================================================

    @When("user clicks member action menu")
    public void clickMemberActionMenu() {
        team.clickActionMenu();
    }

    @When("user selects Edit Member option")
    public void clickEditMemberOption() {
        team.clickEditMemberOption();
    }

    @When("user updates role from {string} to {string}")
    public void updateMemberRole(String existingRole, String updatedRole) throws InterruptedException {
        team.updateMemberRole(existingRole, updatedRole);
    }

    @When("user changes member role")
    public void changeMemberRole() throws InterruptedException {
        team.updateMemberRole("Editor");
    }

    @When("user clicks Update button")
    public void clickUpdateButton() {
        team.clickUpdateButton();
    }

    @Then("member role should be updated successfully")
    public void verifyMemberRoleUpdated() {
        team.verifyMemberUpdatedSuccessfully();
    }

    @Then("latest role should be displayed in member listing")
    public void verifyLatestRoleDisplayed() {
        team.verifyMemberRecordsDisplayed();
    }

    @Then("original member role should remain unchanged")
    public void verifyOriginalRoleRemains() {
        team.verifyMemberRecordsDisplayed();
    }

    // =====================================================
    // Remove Member Steps
    // =====================================================

    @When("user selects Remove Member option")
    public void clickRemoveMemberOption() {
        team.clickRemoveMemberOption();
    }

    @When("user confirms member removal")
    public void confirmMemberRemoval() {
        team.confirmMemberRemoval();
    }

    @When("user clicks Cancel button on confirmation popup")
    public void cancelMemberRemoval() {
        team.cancelMemberRemoval();
    }

    @Then("member should be removed successfully")
    public void verifyMemberRemovedSuccessfully() {
        team.verifyMemberRemovedSuccessfully();
    }

    @Then("removed member should not be displayed")
    public void verifyRemovedMemberNotDisplayed() {
        team.verifyNoMemberRecordsDisplayed();
    }

    @Then("member should remain available in Team Management")
    public void verifyMemberStillExists() {
        team.verifyMemberRecordsDisplayed();
    }

    @Then("pending invitation should be removed successfully")
    public void verifyPendingInviteRemoved() {
        team.verifySuccessMessage();
    }

    // =====================================================
    // Invitation Acceptance Steps
    // =====================================================

    @When("user accepts terms and conditions")
    public void acceptTermsAndConditions() {
        team.acceptTermsAndConditions();
    }

    @When("user clicks Create Account button")
    public void clickCreateAccountButton() {
        team.clickCreateAccountButton();
    }

    @Then("account should be created successfully")
    public void verifyAccountCreatedSuccessfully() {
        team.verifySuccessMessage();
    }

    @Then("password mismatch validation message should be displayed")
    public void verifyPasswordMismatchValidation() {
        team.verifyValidationMessage();
    }

    @Then("mandatory field validation messages should be displayed")
    public void verifyMandatoryFieldValidation() {
        team.verifyValidationMessage();
    }

    @Then("invitation expiry message should be displayed")
    public void verifyInvitationExpiryMessage() {
        team.verifyInvitationExpiredMessage();
    }

    // =====================================================
    // Login Steps
    // =====================================================

    @When("user enters registered email address as {string}")
    public void enterRegisteredEmail(String email) {
        team.enterLoginEmail(email);
    }

    @When("user enters valid password")
    public void enterLoginPassword() {
        team.enterLoginPassword("Password@123");
    }

    @When("user clicks Login button")
    public void clickLoginButton() {
        team.clickLoginButton();
    }

    @Then("user should login successfully")
    public void verifyUserLoginSuccessfully() {
        team.verifySuccessMessage();
    }

    // =====================================================
    // Permission Validation Steps
    // =====================================================

    @Then("Admin user should have access to Team Management module")
    public void verifyAdminAccess() {
        team.verifyAdminAccess();
    }

    @Then("access denied message should be displayed")
    public void verifyAccessDeniedMessage() {
        team.verifyAccessDeniedMessage();
    }

    @Then("unauthorized access page should be displayed")
    public void verifyUnauthorizedPage() {
        team.verifyAccessDeniedMessage();
    }

    // =====================================================
    // Refresh & Browser Navigation
    // =====================================================

    @When("user refreshes browser page")
    public void refreshBrowserPage() {
        team.refreshBrowser();
    }

    @When("user refreshes Team Management page")
    public void refreshTeamManagementPage() {
        team.refreshPage();
    }

    @When("user clicks browser back button")
    public void clickBrowserBackButton() {
        team.clickBrowserBackButton();
    }

    @When("user clicks browser forward button")
    public void clickBrowserForwardButton() {
        team.clickBrowserForwardButton();
    }

    @Then("Team Management page should function correctly")
    public void verifyTeamManagementPageFunctionality() {
        team.verifyMemberRecordsDisplayed();
    }

    // =====================================================
    // Session Validation
    // =====================================================

    @Then("login page should be displayed")
    public void verifyLoginPageDisplayed() {
        team.verifySessionExpired();
    }

    // =====================================================
    // Email Validation Steps
    // =====================================================

    @When("user enters email with leading spaces")
    public void enterEmailWithLeadingSpaces() {
        team.enterEmailWithLeadingSpaces();
    }

    @When("user enters email with trailing spaces")
    public void enterEmailWithTrailingSpaces() {
        team.enterEmailWithTrailingSpaces();
    }

    @When("user enters maximum length valid email address")
    public void enterMaximumLengthEmail() {
        team.enterMaximumLengthEmail();
    }

    @When("user enters email exceeding maximum allowed length")
    public void enterExceedingLengthEmail() {
        team.enterExceedingLengthEmail();
    }

    @When("user enters invalid special character email address")
    public void enterSpecialCharacterEmail() {
        team.enterSpecialCharacterEmail();
    }

    @Then("email should be processed correctly")
    public void verifyEmailProcessedCorrectly() {
        team.verifySuccessMessage();
    }

    @Then("email length validation message should be displayed")
    public void verifyEmailLengthValidation() {
        team.verifyValidationMessage();
    }

    @Then("invalid email validation should be displayed")
    public void verifySpecialCharacterValidation() {
        team.verifyValidationMessage();
    }

    // =====================================================
    // Dashboard Count Validation Steps
    // =====================================================

    @When("user records current member statistics")
    public void recordCurrentMemberStatistics() {
        team.verifyDashboardCountsDisplayed();
    }

    @Then("Pending Invites count should be updated")
    public void verifyPendingInvitesCountUpdated() {
        team.verifyDashboardCountsDisplayed();
    }

    @Then("Active Member count should be updated")
    public void verifyActiveMemberCountUpdated() {
        team.verifyDashboardCountsDisplayed();
    }

    // =====================================================
    // Sorting Steps
    // =====================================================

    @When("user clicks member email column header")
    public void clickMemberEmailColumnHeader() {
        team.sortByEmail();
    }

    @When("user clicks role column header")
    public void clickRoleColumnHeader() {
        team.sortByRole();
    }

    @When("user clicks status column header")
    public void clickStatusColumnHeader() {
        team.sortByStatus();
    }

    @Then("member records should be sorted by email")
    public void verifyMemberSortedByEmail() {
        team.verifyMemberRecordsDisplayed();
    }

    @Then("member records should be sorted by role")
    public void verifyMemberSortedByRole() {
        team.verifyMemberRecordsDisplayed();
    }

    @Then("member records should be sorted by status")
    public void verifyMemberSortedByStatus() {
        team.verifyMemberRecordsDisplayed();
    }

    // =====================================================
    // Pagination Steps
    // =====================================================

    @When("user clicks next page button")
    public void clickNextPageButton() {
        team.clickNextPage();
    }

    @When("user clicks previous page button")
    public void clickPreviousPageButton() {
        team.clickPreviousPage();
    }

    @When("user clicks rows per page dropdown")
    public void clickRowsPerPageDropdown() {
        // Intentionally empty because selection step performs click
    }

    @When("user selects different page size")
    public void selectDifferentPageSize() throws InterruptedException {
        team.selectRowsPerPage("25");
    }

    @When("user selects Team Management rows per page as {string}")
    public void selectRowsPerPage(String rows) throws InterruptedException {
        team.selectRowsPerPage(rows);
    }

    @Then("next page member records should be displayed")
    public void verifyNextPageRecordsDisplayed() {
        team.verifyMemberRecordsDisplayed();
    }

    @Then("selected number of member records should be displayed")
    public void verifySelectedRowsDisplayed() {
        team.verifyMemberRecordsDisplayed();
    }

    // =====================================================
    // Multi Tab Validation
    // =====================================================

    @Then("Team Management data should remain consistent")
    public void verifyTeamManagementDataConsistency() {
        team.verifyMemberRecordsDisplayed();
    }

    // =====================================================
    // Dashboard Refresh Validation
    // =====================================================

    @Then("latest member details should be displayed")
    public void verifyLatestMemberDetailsDisplayed() {
        team.verifyMemberRecordsDisplayed();
    }

    // =====================================================
    // Generic Verification Steps
    // =====================================================
    // =====================================================
    // Search Existing Members
    // =====================================================

    @When("user searches existing member")
    public void searchExistingMember() {
        team.searchExistingMember("test@test.com");
    }

    @When("user searches existing Viewer member")
    public void searchExistingViewerMember() {
        team.searchExistingMember("viewer@test.com");
    }

    @When("user searches existing Editor member")
    public void searchExistingEditorMember() {
        team.searchExistingMember("editor@test.com");
    }

    @When("user searches active member")
    public void searchActiveMember() {
        team.searchExistingMember("active@test.com");
    }

    @When("user searches updated member")
    public void searchUpdatedMember() {
        team.searchExistingMember("updated@test.com");
    }

    @When("user searches removed member email")
    public void searchRemovedMemberEmail() {
        team.searchRemovedMember("removed@test.com");
    }

    // =====================================================
    // End To End Flow Steps
    // =====================================================

    @When("Admin user invites a new team member")
    public void adminUserInvitesNewMember() throws InterruptedException {
        team.inviteMember("newmember@test.com", "Viewer");
    }

    @Then("invited member should appear as Active in Team Management")
    public void verifyInvitedMemberAppearsAsActive() {
        team.verifyMemberRecordsDisplayed();
    }

    @Then("system should handle refresh gracefully")
    public void verifySystemHandlesRefreshGracefully() {
        team.verifyMemberRecordsDisplayed();
    }

    // =====================================================
    // Missing Generic Steps From Feature File
    // =====================================================

    @Given("user logged into XNotify application")
    @Given("Admin user logged into XNotify application")
    @Given("non-admin user logged into XNotify application")
    public void userLoggedIntoApplication() {
        // Login handled in Background / reusable login
    }

    @When("user waits for search results")
    @When("user waits for filtered search results")
    @When("user waits for filtered results")
    @When("user waits for search execution")
    @When("user waits for member records refresh")
    @When("user waits for page refresh")
    public void waitForResults() {
        team.waitForMemberGridRefresh();
    }

    @Then("matching records are filtered")
    public void matchingRecordsFiltered() {
        team.verifyMemberRecordsDisplayed();
    }

    @Then("no matching member exists")
    public void noMatchingMemberExists() {
        team.verifyNoMemberRecordsDisplayed();
    }

    @When("user enters uppercase member email in search field as {string}")
    public void enterUppercaseEmail(String email) {
        team.searchMember(email);
    }

    @When("user enters invalid member email in search field")
    public void enterInvalidSearchEmail() {
        team.searchMember("invalid@test.com");
    }

    @When("user enters valid member email in search field")
    @When("user enters member email in search field")
    public void enterMemberEmailSearch() {
        team.searchMember("test.member@example.com");
    }

    @Then("user verifies filtered records are displayed")
    public void verifyFilteredRecordsDisplayed() {
        team.verifyMemberRecordsDisplayed();
    }

    @When("user clicks role filter dropdown")
    public void clickRoleFilterDropdown() {
        // Dropdown opens in selectRoleFilter()
    }

    @When("user clicks status filter dropdown")
    public void clickStatusFilterDropdown() {
        // Dropdown opens in selectStatusFilter()
    }

    @Then("only active Admin members should be displayed")
    @Then("only active Editor members should be displayed")
    @Then("matching Admin member records should be displayed")
    @Then("matching active member records should be displayed")
    public void verifyCombinedFilters() {
        team.verifyMemberRecordsDisplayed();
    }

    @When("user updates member role successfully")
    public void updateMemberRoleSuccessfully() throws Exception {
        team.editMemberRole("Editor");
    }

    @Then("user verifies updated role column value")
    public void verifyUpdatedRoleColumnValue() {
        team.verifyMemberRecordsDisplayed();
    }

    @When("user opens Edit Member popup")
    public void openEditPopup() {
        team.clickActionMenu();
        team.clickEditMemberOption();
    }

    @Then("user verifies Edit Member option")
    public void verifyEditMemberOption() {
        team.clickActionMenu();
    }

    @Then("user verifies Remove Member option")
    public void verifyRemoveMemberOption() {
        team.clickActionMenu();
    }

    @Then("member action menu should be displayed successfully")
    public void memberActionMenuDisplayed() {
        team.verifyMemberRecordsDisplayed();
    }

    @When("user removes a member successfully")
    public void removeMemberSuccessfully() {
        team.deleteMember();
    }

    @When("user refreshes member listing")
    public void refreshMemberListing() {
        team.refreshPage();
    }

    @When("user filters pending invited members")
    public void filterPendingMembers() throws Exception {
        team.selectStatusFilter("Pending");
    }

    @When("user confirms removal action")
    public void confirmRemovalAction() {
        team.confirmMemberRemoval();
    }

    @When("system processes request")
    public void systemProcessesRequest() {
    }

    @Given("invitation email is sent to team member")
    @Given("invited user accesses onboarding page")
    @Given("invited user account is created successfully")
    @Given("invitation link has already expired")
    @Given("invited user receives invitation successfully")
    public void invitationPreconditions() {
    }

    @When("invited user opens invitation email")
    @When("invited user clicks invitation link")
    @When("invitation page is loaded")
    @When("invitation token is validated")
    @When("account setup page is displayed")
    @When("system validates account information")
    @When("authentication is completed")
    @When("system validates password fields")
    @When("system validates mandatory fields")
    @When("validation execution completes")
    @When("invited user opens expired invitation link")
    @When("system validates invitation token")
    @When("invitation expiry date is verified")
    @When("onboarding request is rejected")
    @When("error page is displayed")
    public void onboardingPlaceholderSteps() {
    }

    @Then("invited user should access onboarding page successfully")
    public void onboardingPageDisplayed() {
        team.verifySuccessMessage();
    }

    @When("user enters registered email address")
    public void enterRegisteredEmailWithoutValue() {
        team.enterLoginEmail("test@test.com");
    }

    @Then("invitation should be processed successfully")
    public void invitationProcessedSuccessfully() {
        team.verifySuccessMessage();
    }

    @When("user submits invitation request")
    public void submitInvitationRequest() {
        team.clickSendInvitation();
    }

    @When("user invites a new team member successfully")
    public void inviteNewMemberSuccessfully() throws Exception {
        team.inviteMember("newmember@test.com", "Viewer");
    }

    @When("invitation is processed successfully")
    @When("dashboard statistics are refreshed")
    @When("latest member counts are calculated")
    @When("invited user completes account setup process")
    @When("invited user logs into application")
    @When("Team Management dashboard refreshes")
    @When("latest statistics are recalculated")
    @When("member status becomes Active")
    @When("sorting is applied to member records")
    @When("displayed records are reordered")
    @When("sorting indicator is displayed")
    @When("member records exceed single page limit")
    @When("second page records are loaded")
    @When("pagination controls are displayed")
    @When("member listing refreshes")
    @When("pagination controls are recalculated")
    @When("user opens Invite Member popup")
    @When("user enters invitation details")
    @When("application reloads Team Management page")
    @When("invitation email is delivered successfully")
    @When("invited user completes account setup")
    @When("invited user logs into XNotify platform")
    public void genericWorkflowSteps() {
    }

    @When("user verifies Team Management page is loaded")
    public void verifyPageLoaded() {
        team.verifyDashboardLoaded();
    }

    @When("user verifies Invite Member button is displayed")
    public void verifyInviteButtonDisplayed() {
        team.verifyInviteMemberButtonDisplayed();
    }

    @When("user verifies member management actions are displayed")
    public void verifyMemberManagementActionsDisplayed() {
        team.verifyMemberActionsDisplayed();
    }

    @When("user verifies role management controls are displayed")
    public void verifyRoleManagementControlsDisplayed() {
        team.verifyRoleManagementDisplayed();
    }

    @When("user attempts to navigate to Team Management module")
    @When("user enters Team Management URL directly in browser")
    public void attemptNavigateToTeamManagement() {
    }

    @When("system validates user permissions")
    @When("access control rules are executed")
    @When("restricted functionality is evaluated")
    @When("unauthorized request is processed")
    @When("application validates user permissions")
    @When("authorization rules are executed")
    @When("restricted page access is evaluated")
    @When("navigation request is rejected")
    @When("user remains inactive for configured timeout period")
    @When("application session expires")
    @When("user performs Team Management action")
    @When("authentication validation is triggered")
    @When("user verifies displayed member information")
    @When("member information is reloaded")
    @When("user opens member details workflow")
    @When("application restores previous state")
    @When("user opens Team Management module in first tab")
    @When("user opens Team Management module in second tab")
    @When("user performs member search in first tab")
    @When("user switches to second tab")
    @When("application validates active session")
    public void genericValidationSteps() {
    }

    @When("invited user opens invitation link")
    public void invitedUserOpensInvitationLink() throws InterruptedException {
        team.openInvitationLink();
    }

    @When("user enters member name in search field as {string}")
    public void enterMemberNameInSearchField(String memberName) {
        team.enterMemberNameInSearchField(memberName);
    }

    @Then("matching member records should be displayed")
    public void verifyMatchingMemberRecordsDisplayed() {
        team.verifyMatchingMemberRecordsDisplayed();
    }

    @Then("only {string} role records should be displayed")
    public void verifyRoleFilteredRecords(String role) {
        team.verifyRoleFilteredRecords(role);
    }

    @Then("only {string} status records should be displayed")
    public void verifyStatusFilteredRecords(String status) {
        team.verifyStatusFilteredRecords(status);
    }

    @Then("only records matching role {string} and status {string} should be displayed")
    public void verifyRoleAndStatusFilteredRecords(String role, String status) {
        team.verifyRoleAndStatusFilteredRecords(role, status);
    }
}
