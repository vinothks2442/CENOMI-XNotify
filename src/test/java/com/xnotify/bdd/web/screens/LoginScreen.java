package com.xnotify.bdd.web.screens;

import com.xnotify.bdd.ccl.PlayActions;
import com.xnotify.bdd.integrations.common_utils.ConfigReader;

import junit.framework.Assert;

public class LoginScreen {

        private final PlayActions play = new PlayActions();

        // Locators

        String txtUsername = "//input[@id='email']";
        String txtPassword = "//input[@id='password']";
        String btnLogin = "//button[text()='Sign in']";
        String chkRememberMe = "//input[@type='checkbox']";
        String lnkForgotPassword = "//a[contains(text(),'Forgot Password')]";
        String lblErrorMessage = "//div[contains(@class,'error')]";
        String lblValidationMessage = "//span[contains(@class,'validation-error')]";
        String dashboardHeading = "//span[text()='Notifi']";
        String loginPageHeading = "//h1[text()='Login']";
        String btnLogout = "//button[text()='Logout']";

        // Actions

        public void navigateToLoginPage() {
                play.navigate(ConfigReader.getValue("url"));
        }

        public void enterUsername() {
                play.fill(txtUsername,
                                ConfigReader.getValue("email"),
                                "Username Textbox");
        }

        public void enterPassword() {
                play.fill(txtPassword,
                                ConfigReader.getValue("password"),
                                "Password Textbox");
        }

        public void clickLoginButton() {
                play.click(btnLogin,
                                "Login Button");
        }

        public void selectRememberMeCheckbox() {
                play.click(chkRememberMe,
                                "Remember Me Checkbox");
        }

        public void clickForgotPasswordLink() {
                play.click(lnkForgotPassword,
                                "Forgot Password Link");
        }

        public void clickLogoutButton() {
                play.click(btnLogout,
                                "Logout Button");
        }

        // Verifications

        public void verifyDashboardPageIsVisible() {
                String actualHeading = play.textContent(dashboardHeading);
                Assert.assertEquals(
                                "Notifi",
                                actualHeading);
        }

        public void verifyLoginPageIsVisible() {

                String actualHeading = play.textContent(loginPageHeading);

                Assert.assertEquals(
                                "Login",
                                actualHeading);
        }

        public void verifyErrorMessage(
                        String expectedMessage) {

                String actualMessage = play.textContent(lblErrorMessage);

                Assert.assertEquals(
                                expectedMessage,
                                actualMessage);
        }

        public void verifyValidationMessage(
                        String expectedMessage) {

                String actualMessage = play.textContent(lblValidationMessage);

                Assert.assertEquals(
                                expectedMessage,
                                actualMessage);
        }

        public void verifyPasswordMasked() {

                String attributeValue = play.inputValue(
                                txtPassword);

                Assert.assertEquals(
                                "password",
                                attributeValue);
        }

        // Reusable Methods

        public void loginToApplication() {
                enterUsername();
                enterPassword();
                clickLoginButton();
        }

        public void verifyDashboardPage() {

        }
}