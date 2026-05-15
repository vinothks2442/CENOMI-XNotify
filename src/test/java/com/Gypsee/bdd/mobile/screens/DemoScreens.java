package com.Gypsee.bdd.mobile.screens;

import java.io.IOException;

import org.testng.Assert;

import com.Gypsee.bdd.ccl.MobileActions;
import com.Gypsee.bdd.integrations.common_utils.ConfigReader;
import com.Gypsee.bdd.integrations.common_utils.MobileUtil;
import com.Gypsee.bdd.integrations.report_utils.ReportManager;

public class DemoScreens {
	MobileActions actions = new MobileActions();

	public void ableToSeeVehicle() {
		String actualTxt = actions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Gypsee", "car"));
        Assert.assertEquals(actualTxt, ConfigReader.getValue("carName"));
		
	}

	public void clicksOnBcakBtn() {
		actions.Click(MobileUtil.returnByBasedOnPageNameAndObjectName("Gypsee2", "Gypsee_BackButton"), "back");
	}

	public void clicksOnOkay() {
		actions.Click(MobileUtil.returnByBasedOnPageNameAndObjectName("Gypsee2", "Gypsee_addDeviceAlertOk"), "okay");
	}

	public void ableToSeeDeviceAdded() throws IOException {
		ReportManager.logMobileScreenshotInfo();
		
	}

}
