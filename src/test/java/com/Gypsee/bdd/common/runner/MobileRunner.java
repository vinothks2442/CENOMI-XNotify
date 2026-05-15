package com.Gypsee.bdd.common.runner;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Gypsee.bdd.integrations.NG_listners.MobileEvent;
import com.Gypsee.bdd.integrations.NG_listners.SuiteEvent;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@Listeners({ SuiteEvent.class, MobileEvent.class })

@CucumberOptions(features = "src/test/java/com/Gypsee/bdd/mobile/features", glue = {
		"com/Gypsee/bdd/mobile/step_definitions", "com/Gypsee/bdd/common/hooks" }, tags = "@Login",

		plugin = { "pretty", "json:target/cucumber/cucumber.json", "html:target/site/cucumber-pretty/cucumber_Mobile.html",
				 }, monochrome = true, publish = true, dryRun = false)
public class MobileRunner {
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		System.out.println("@Before class");
	}

	@Test(groups = "cucumber", description = "Run Cucumber Scenario", dataProvider = "scenarios")
	public void scenario(PickleWrapper pickleEventWrapper, FeatureWrapper cucumberFeatureWrapper) throws Throwable {
		testNGCucumberRunner.runScenario(pickleEventWrapper.getPickle());
	}

	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		System.out.println("@Data provider");
		if (testNGCucumberRunner == null) {
			testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		}

		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() {
		System.out.println("@Afterclass");
		testNGCucumberRunner.finish();
	}
}
