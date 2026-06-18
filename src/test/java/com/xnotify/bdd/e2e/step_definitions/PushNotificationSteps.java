package com.xnotify.bdd.e2e.step_definitions;

import com.xnotify.bdd.workflows.NotificationWorkflow;
import io.cucumber.java.en.*;

public class PushNotificationSteps {

    NotificationWorkflow workflow = new NotificationWorkflow();

    @Then("user validates notification in mobile")
    public void validateNotification() throws InterruptedException {

        workflow.validatePushNotificationFlow();
    }
}