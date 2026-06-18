package com.xnotify.bdd.common.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.xnotify.bdd.integrations.NG_listners.PageEvent;
import com.xnotify.bdd.integrations.NG_listners.SuiteEvent;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@Listeners({ SuiteEvent.class, PageEvent.class })

@CucumberOptions(

        features = {
                "src/test/java/com/xnotify/bdd/e2e/features"
        },

        glue = {

                "com/xnotify/bdd/common/hooks",

                // WEB STEP DEFINITIONS
                "com/xnotify/bdd/web/step_definitions",

                // MOBILE STEP DEFINITIONS
                "com/xnotify/bdd/mobile/step_definitions",

                // E2E STEP DEFINITIONS
                "com/xnotify/bdd/e2e/step_definitions"
        },

        tags = "@e2e",

        plugin = {

                "pretty",

                "html:target/site/cucumber-pretty/cucumberE2E.html",

                "json:target/cucumber/e2e-cucumber.json",

                "rerun:target/e2e_rerun.txt"
        },

        monochrome = true, publish = true, dryRun = false)

public class E2ERunner {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {

        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

        System.out.println("@Before class - E2E Runner");
    }

    @Test(groups = "cucumber", description = "Run E2E Cucumber Scenario", dataProvider = "scenarios")

    public void scenario(
            PickleWrapper pickleEventWrapper,
            FeatureWrapper cucumberFeatureWrapper) throws Throwable {

        testNGCucumberRunner.runScenario(
                pickleEventWrapper.getPickle());
    }

    @DataProvider(parallel = false)

    public Object[][] scenarios() {

        System.out.println("@Data provider - E2E");

        if (testNGCucumberRunner == null) {

            testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        }

        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)

    public void tearDownClass() {

        System.out.println("@After class - E2E");

        testNGCucumberRunner.finish();
    }
}