package com.xnotify.bdd.mobile.screens;

import com.xnotify.bdd.ccl.MobileActions;

public class MobileNotificationScreen {

    MobileActions mobile = new MobileActions();

    public void validateNotificationReceived(
            String expectedText) {

        mobile.openNotifications();

    }
}