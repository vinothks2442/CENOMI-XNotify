package com.Gypsee.bdd.mobile.screens;

import java.io.IOException;

import com.Gypsee.bdd.ccl.MobileActions;
import com.Gypsee.bdd.integrations.common_utils.MobileUtil;
import com.Gypsee.bdd.integrations.report_utils.ReportManager;

public class FuelShine_HomePage_07 {
	MobileActions action = new MobileActions();

	public void displayPageDetails() throws IOException, InterruptedException
	{
		
		
		Thread.sleep(7000);
				ReportManager.logMobileScreenshot();
	}
	public void clickOnPerformance() throws InterruptedException
	{
		Thread.sleep(2000);

		action.Click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "HomePage_Performnace"),
				"HomePage_Performance");		
	}
	public void clikcOnMyVallet() throws InterruptedException
	{
		Thread.sleep(2000);

		action.Click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "HomePage_MyVallet"),
				"HomePage_Myvallet");		

	}
	public void clickOnSettings() throws InterruptedException
	{
		action.Click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "HomePage_Settings"),
				"HomePage_settings");	
		Thread.sleep(2000);


		
	}
	public void clickMyvehicles()
	{
		action.Click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "HomePage_Settings_Myvehicle"),
				"Setting_Myvehicle");		

		
	}
	public void clickBackButton()
	{
		action.Click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "HomePage_Settings_backButton"),
				"HomePage_BackButton");		

		
	}
	public void clickAlertConfiguration()
	{
		action.Click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "HomePage_Settings_AlertConfig"),
				"Settin_AlertConfig");		
	
	}
	
	public void clickAddVehiclePlusSymbol()
	{
		action.Click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "MyVehicle_Add"),
				"Adding number");
	}
	public void enterInvalidVehicleNumber(String string)
	{
		action.Click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "MyVehicle_InvalidNumber"),
				"Invalid Number");		
	
	  action.sendKeys(
				MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "MyVehicle_InvalidNumber"),
				string);

	}
	
	public void clickAddVehicleButton()
	{
		action.Click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "MyVehicle_AddButton"),
				"Button number");
	}
	public void clickMyValletDuration()
	{
		action.Click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "MyVallet_Duration"),
				"Vallet duration");
	}
	public void clickTodayDuration()
	{
		action.Click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "MyVallet_Today"),
				"Today Duration");
	}
	public void clickForteenDaysDuration()
	{
		action.Click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "MyVallet_ForteenDays"),"for Forteendays");
	}
				public void clickTwentyEightDaysDuration()
				{
					action.Click(
							MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "MyVallet_TwentyEightdays"),
							"Vallet  Eight for twentyduration");
				}
				public void clickThreeMonthsDuration()
				{
					action.Click(
							MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "MyVallet_ThreeMonths"),
							"Three months duration");
				}
				public void clickSixMonthsDuration()
				{
					action.Click(
							MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "MyVallet_SixMonths"),
							"Six months duration");
				}
				public void clickOneYearDuration()
				{
					action.Click(
							MobileUtil.returnByBasedOnPageNameAndObjectName("FuelShine2", "MyVallet_OneYear"),
							"One year duration");
				}

	}
	
	

