package com.xnotify.bdd.mobile.step_definitions;

import java.io.IOException;

import com.xnotify.bdd.mobile.screens.DemoScreens;

import io.cucumber.java.en.*;

public class DemoSteps {
	DemoScreens page = new DemoScreens();
	@Then("user should able to see the hyundai vehicle")
	public void user_should_able_to_see_the_hyundai_vehicle() {
	    page.ableToSeeVehicle();
	}

	@When("user clicks on back button")
	public void user_clicks_on_back_button() {
	    page.clicksOnBcakBtn();
	}

	@When("user clicks on okay")
	public void user_clicks_on_okay() {
	    page.clicksOnOkay();
	}

	@Then("usre should able to see the device added")
	public void usre_should_able_to_see_the_device_added() throws IOException {
	    page.ableToSeeDeviceAdded();
	}

}
