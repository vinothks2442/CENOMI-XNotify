package com.xnotify.bdd.workflows;

import com.xnotify.bdd.web.screens.CampaignBuilderScreen;
import com.xnotify.bdd.mobile.screens.MobileNotificationScreen;

public class NotificationWorkflow {

    CampaignBuilderScreen campaignScreen = new CampaignBuilderScreen();

    MobileNotificationScreen mobileScreen = new MobileNotificationScreen();

    public void validatePushNotificationFlow() throws InterruptedException {

        // WEB FLOW
        campaignScreen.createCampaign();

        // MOBILE FLOW
        mobileScreen.validateNotificationReceived(
                "Welcome Campaign");
    }
}