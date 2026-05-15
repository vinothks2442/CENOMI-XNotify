package com.Gypsee.bdd.mobile.step_definitions;
import java.io.IOException;

import com.Gypsee.bdd.mobile.screens.FuelShine_HomePage_07;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class FuelShine_HomePage_Steps_07 {
	FuelShine_HomePage_07 fhp=new FuelShine_HomePage_07();
	@When("User clicks on performance prsent in fuelshine home page")
	public void user_clicks_on_performance_prsent_in_fuelshine_home_page() throws InterruptedException {
		fhp.clickOnPerformance();
	    
	}

	@Then("User should able to see the Performance page")
	public void user_should_able_to_see_the_performance_page() throws IOException, InterruptedException {
		fhp.displayPageDetails();
	  
	}

@When("user clicks on MyVallet present in fuelshine homepage")
public void user_clicks_on_my_vallet_present_in_fuelshine_homepage() throws InterruptedException {
	fhp.clikcOnMyVallet();

}

@When("Uesr clicks on settings present in fuelshine homepage")
public void uesr_clicks_on_settings_present_in_fuelshine_homepage() throws InterruptedException {
	fhp.clickOnSettings();

}
@Then("User should able to see the  page info")
public void user_should_able_to_see_the_page_info() throws IOException, InterruptedException {
	fhp.displayPageDetails();

}
@When("User clicks on myvehicles in settings page")
public void user_clicks_on_myvehicles_in_settings_page() {
   fhp.clickMyvehicles();
}

@When("User clicks on back button of Myvehicles")
public void user_clicks_on_back_button_of_myvehicles() {
	fhp.clickBackButton();
   
}

@When("user clicks on Alert confuguration present in settings")
public void user_clicks_on_alert_confuguration_present_in_settings() {
	fhp.clickAlertConfiguration();
    
}

@When("User clicks on back button of Alert configuration")
public void user_clicks_on_back_button_of_alert_configuration() {
	fhp.clickBackButton();
   
}
@When("^User clicks on myvehicles (.+) in settings page$")
public void user_clicks_on_myvehicles_bvfgg_in_settings_page(String string) {
	fhp.enterInvalidVehicleNumber(string);
    
}

@Then("User should able to see the error message")
public void user_should_able_to_see_the_error_message() throws IOException, InterruptedException {
    fhp.displayPageDetails();
}

@When("User clicks on add vehicle plus symbol")
public void user_clicks_on_add_vehicle_plus_symbol() {
	fhp.clickAddVehiclePlusSymbol();

}

@When("User clicks on AddButton of VIN Alert box")
public void user_clicks_on_add_button_of_vin_alert_box() {
    fhp.clickAddVehicleButton();

}


@When("user clicks on my vallet icon prsent in bottom of profile")
public void user_clicks_on_my_vallet_icon_prsent_in_bottom_of_profile() {
	fhp.clickMyValletDuration();
   
}

@Then("User should able to see the different types vallet durations")
public void user_should_able_to_see_the_different_types_vallet_durations() throws IOException, InterruptedException {
	fhp.displayPageDetails();
    
}

@When("user clicks on Today present in the list")
public void user_clicks_on_today_present_in_the_list() {
	fhp.clickTodayDuration();
  
}

@Then("User should able to see the today vallet details")
public void user_should_able_to_see_the_today_vallet_details() throws IOException, InterruptedException {
	fhp.displayPageDetails();
   
}

@When("User clicks the forteendays duration")
public void user_clicks_the_forteendays_duration() {
   fhp.clickForteenDaysDuration();
}

@Then("User should able to see the forteendays vallet details")
public void user_should_able_to_see_the_forteendays_vallet_details() throws IOException, InterruptedException {
	fhp.displayPageDetails();
   
}

@When("User clicks the twentyeight days duration")
public void user_clicks_the_twentyeight_days_duration() {
	fhp.clickTwentyEightDaysDuration();
    
}

@Then("User should able to see the twentyeight  vallet details")
public void user_should_able_to_see_the_twentyeight_vallet_details() throws IOException, InterruptedException {
	fhp.displayPageDetails();
   
}

@When("User clicks the three months duration")
public void user_clicks_the_three_months_duration() {
   fhp.clickThreeMonthsDuration();
}

@Then("User should able to see the three months  vallet details")
public void user_should_able_to_see_the_three_months_vallet_details() throws IOException, InterruptedException {
	fhp.displayPageDetails();

   
}

@When("User clicks the six months duration")
public void user_clicks_the_six_months_duration() {
	fhp.clickSixMonthsDuration();
    
}

@Then("User should able to see the six months  vallet details")
public void user_should_able_to_see_the_six_months_vallet_details() throws IOException, InterruptedException {
	fhp.displayPageDetails();

    
}

@When("User clicks the one year duration")
public void user_clicks_the_one_year_duration() {
	fhp.clickOneYearDuration();
   
}

@Then("User should able to see the one year vallet details")
public void user_should_able_to_see_the_one_year_vallet_details() throws IOException, InterruptedException {
	fhp.displayPageDetails();
   
}

@Then("User should able to see the vallet details")
public void user_should_able_to_see_the_vallet_details() throws IOException, InterruptedException {
	fhp.displayPageDetails();

	
    }







}
