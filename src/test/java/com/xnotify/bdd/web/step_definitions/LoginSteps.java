package com.xnotify.bdd.web.step_definitions;

import io.cucumber.java.en.*;
import com.xnotify.bdd.web.screens.LoginScreen;

public class LoginSteps {

    LoginScreen loginScreen = new LoginScreen();

    @Given("user navigates to login page")
    public void userNavigatesToLoginPage() {
        loginScreen.navigateToLoginPage();
    }

    @When("user enters username")
    public void userEntersUsername() {
        loginScreen.enterUsername();
    }

    @When("user enters password")
    public void userEntersPassword() {
        loginScreen.enterPassword();
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        loginScreen.clickLoginButton();
    }

    @When("user selects remember me checkbox")
    public void userSelectsRememberMeCheckbox() {
        loginScreen.selectRememberMeCheckbox();
    }

    @When("user clicks on forgot password link")
    public void userClicksOnForgotPasswordLink() {
        loginScreen.clickForgotPasswordLink();
    }

    @When("user clicks on logout button")
    public void userClicksOnLogoutButton() {
        loginScreen.clickLogoutButton();
    }

    @Then("user should be redirected to dashboard page")
    public void userShouldBeRedirectedToDashboardPage() {
        loginScreen.verifyDashboardPageIsVisible();
    }

    @Then("dashboard page should be displayed successfully")
    public void dashboardPageShouldBeDisplayedSuccessfully() {
        loginScreen.verifyDashboardPageIsVisible();
    }

    @Then("user should see error message as {string}")
    public void userShouldSeeErrorMessage(String expectedMessage) {
        loginScreen.verifyErrorMessage(expectedMessage);
    }

    @Then("user should see validation message as {string}")
    public void userShouldSeeValidationMessage(String expectedMessage) {
        loginScreen.verifyValidationMessage(expectedMessage);
    }

    @Then("password should be displayed in masked format")
    public void passwordShouldBeDisplayedInMaskedFormat() {
        loginScreen.verifyPasswordMasked();
    }

    @Then("user should be redirected to forgot password page")
    public void userShouldBeRedirectedToForgotPasswordPage() {
        // loginScreen.verifyForgotPasswordPage();
    }

    @Given("user logged into application successfully")
    public void userLoggedIntoApplicationSuccessfully() {
        loginScreen.loginToApplication();
    }

    @Then("user should be redirected to login page")
    public void userShouldBeRedirectedToLoginPage() {
        // loginScreen.verifyLoginPage();
    }
}
