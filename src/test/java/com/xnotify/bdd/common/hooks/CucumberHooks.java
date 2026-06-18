// package com.xnotify.bdd.common.hooks;

// import java.nio.file.Paths;

// import java.text.SimpleDateFormat;
// import java.util.ArrayList;
// import java.util.Date;

// import org.openqa.selenium.OutputType;
// import org.openqa.selenium.TakesScreenshot;

// import com.microsoft.playwright.TimeoutError;
// import com.microsoft.playwright.Tracing;
// import com.xnotify.bdd.integrations.common_utils.BrowserFactory;
// import com.xnotify.bdd.integrations.common_utils.DriverFactory;
// import com.xnotify.bdd.integrations.report_utils.ReportManager;
// import com.xnotify.bdd.integrations.report_utils.ScreenshotUtil;

// import io.cucumber.java.After;
// import io.cucumber.java.Before;
// //import static org.junit.Assume.*;
// import io.cucumber.java.Scenario;

// public class CucumberHooks {

// 	public static ArrayList<String> passedTests = new ArrayList<String>();
// 	public static ArrayList<String> failedTests = new ArrayList<String>();
// 	public static ArrayList<String> totalTestCases = new ArrayList<String>();

// 	private static String str_Execution_TYPE = System.getProperty("execType");// "Mobile_UI";//
// 	DriverFactory driverFactory = DriverFactory.getInstance();
// 	public String str_BrowserType = System.getProperty("Browser");
// 	BrowserFactory browserfactory = BrowserFactory.getInstance();
// 	public static String featureFileName;

// 	@Before(value = "@Noaudio", order = 0)
// 	public void skipscenario(Scenario scenario) {
// 		System.out.println("Skipped scenario is:" + scenario.getName());
// 		// Assume.assumetrue(false);
// 	}

// 	@Before
// 	public void before(Scenario scenario) throws Exception {
// 		System.out.println("+++++++++++++++++++before hooks++++++++++++++++++");

// 		if (str_Execution_TYPE.equalsIgnoreCase("Web_UI")) {
// 			ReportManager.startTest(scenario.getName(), "SMOKE");
// 			System.out.println("Execution started @ " + str_BrowserType + " browser & for type : Web UI");
// 			try {

// 				browserfactory.setBrowser(str_BrowserType);
// 				browserfactory.getBrowserContext().tracing()
// 						.start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));

// 			} catch (Exception e) {
// 				// TODO Auto-generated catch block
// 				e.printStackTrace();
// 			}
// 		} else if (str_Execution_TYPE.equalsIgnoreCase("Mobile_UI")) {
// 			ReportManager.startTest(scenario.getName(), "SMOKE");
// 			DriverFactory.getInstance().getMobileDriver().activateApp("com.curebay.medicare");
// 			System.out.println("---Open App---");

// 		} else if (str_Execution_TYPE.equalsIgnoreCase("API")) {
// 			ReportManager.startTestAPI(scenario.getName(), "SMOKE");
// 			System.out.println(
// 					"Thread ID: " + Thread.currentThread().getId() +
// 							" | Scenario: " + scenario.getName());

// 		} else if (str_Execution_TYPE.equalsIgnoreCase("E2E")) {

// 			ReportManager.startTest(scenario.getName(), "E2E");
// 			System.out.println(
// 					"Execution started for Hybrid E2E Flow");

// 			// START WEB
// 			browserfactory.setBrowser(str_BrowserType);

// 			browserfactory.getBrowserContext()
// 					.tracing()
// 					.start(new Tracing.StartOptions()
// 							.setScreenshots(true)
// 							.setSnapshots(true));

// 			// START MOBILE
// 			driverFactory.setMobileDriver(
// 					"Android",
// 					"YOUR_UDID",
// 					"4723/wd/hub",
// 					"Samsung A55");

// 			System.out.println(
// 					"Web + Mobile initialized successfully");
// 		} else {
// 			throw new Exception(
// 					"[-] Please set exection type[Web_UI or Mobile_UI or API] value in cucumberhooks class line number 21");
// 		}

// 		/**
// 		 * ReportManager.createAPI_Node(scenario.getName()); String str_Features =
// 		 * scenario.getId().split(";")[0]; String[] str_arryFeature =
// 		 * str_Features.split("features/"); System.out.println(str_arryFeature);
// 		 * String[] str_Feature = str_arryFeature[1].split(".feature"); featureFileName
// 		 * = str_Feature[0]; System.out.println(str_Feature[0]);
// 		 **/
// 	}

// 	@After
// 	public void after(Scenario scenario) throws Exception {
// 		System.out.println("+++++++++++++++++++after hooks+++++++++++++++++++");
// 		String dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
// 		if (str_Execution_TYPE.equalsIgnoreCase("Web_UI")) {
// 			browserfactory.getBrowserContext().tracing()
// 					.stop(new Tracing.StopOptions().setPath(Paths.get(System.getProperty("user.dir")
// 							+ "/TracingReports/" + dateStamp + "/" + scenario.getName() + ".zip")));
// 			totalTestCases.add(scenario.getName());
// 			if (totalTestCases.contains(scenario.getName())) {
// 				System.out.println("Removing TC from totalTestCases: " + scenario.getName());
// 				totalTestCases.remove(scenario.getName());
// 			}
// 			if (failedTests.contains(scenario.getName())) {
// 				System.out.println("Removing TC from failedTests: " + scenario.getName());
// 				failedTests.remove(scenario.getName());
// 			}
// 			if (passedTests.contains(scenario.getName())) {
// 				System.out.println("Removing TC from passedTests: " + scenario.getName());
// 				passedTests.remove(scenario.getName());
// 			}
// 			if (scenario.isFailed()) {
// 				failedTests.add(scenario.getName());
// 				try {
// 					final byte[] screenshot = (ScreenshotUtil.takeScreenshot().getBytes());
// 					scenario.attach(screenshot, "image/png", featureFileName);
// 					scenario.log("ScreenShot Attached");
// 				} catch (TimeoutError e) {

// 					// System.out.println("Screenshots not captured");
// 				}
// 				try {
// 					ReportManager.logWebScreenshot();
// 				} catch (Exception e) {
// 				}

// 			} else if (str_Execution_TYPE.equalsIgnoreCase("E2E")) {

// 				// WEB CLEANUP
// 				browserfactory.getBrowserContext()
// 						.tracing()
// 						.stop(new Tracing.StopOptions()
// 								.setPath(Paths.get(
// 										System.getProperty("user.dir")
// 												+ "/TracingReports/"
// 												+ dateStamp + "/"
// 												+ scenario.getName()
// 												+ ".zip")));

// 				// MOBILE CLEANUP
// 				DriverFactory.getInstance()
// 						.getMobileDriver()
// 						.terminateApp("com.cenomi.mallsapp");

// 				System.out.println(
// 						"E2E execution completed");
// 			}

// 			else {
// 				passedTests.add(scenario.getName());
// 			}

// 		} else if (str_Execution_TYPE.equalsIgnoreCase("Mobile_UI")) {
// 			totalTestCases.add(scenario.getName());
// 			if (totalTestCases.contains(scenario.getName())) {
// 				System.out.println("Removing TC from totalTestCases: " + scenario.getName());
// 				totalTestCases.remove(scenario.getName());
// 			}
// 			if (failedTests.contains(scenario.getName())) {
// 				System.out.println("Removing TC from failedTests: " + scenario.getName());
// 				failedTests.remove(scenario.getName());
// 			}
// 			if (passedTests.contains(scenario.getName())) {
// 				System.out.println("Removing TC from passedTests: " + scenario.getName());
// 				passedTests.remove(scenario.getName());
// 			}
// 			if (scenario.isFailed()) {
// 				failedTests.add(scenario.getName());
// 				final byte[] screenshot = ((TakesScreenshot) DriverFactory.getInstance().getMobileDriver())
// 						.getScreenshotAs(OutputType.BYTES);
// 				scenario.attach(screenshot, "image/png", featureFileName);
// 				scenario.log("ScreenShot Attached");

// 			} else {
// 				passedTests.add(scenario.getName());

// 			}
// 			DriverFactory.getInstance().getMobileDriver().terminateApp("in.gypsee.customer");
// 			System.out.println("---Close App---");
// 			DriverFactory.getInstance().getMobileDriver().activateApp("in.gypsee.customer");
// 			System.out.println("---Open App---");

// 		} else if (str_Execution_TYPE.equalsIgnoreCase("API")) {
// 			System.out.println("+++++++++++++++++++API+++++++++++++++++++");
// 			totalTestCases.add(scenario.getName());
// 			if (scenario.isFailed()) {
// 				failedTests.add(scenario.getName());
// 			} else {
// 				passedTests.add(scenario.getName());
// 			}

// 		} else {
// 			throw new Exception(
// 					"[-] Please set exection type[Web_UI OR Mobile_UI OR API] value in cucumberhooks class line number 21");
// 		}

// 	}

// }

/* Modified hooks to support E2E Execution (Mobile+Web) */

package com.xnotify.bdd.common.hooks;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.microsoft.playwright.TimeoutError;
import com.microsoft.playwright.Tracing;
import com.xnotify.bdd.integrations.common_utils.BrowserFactory;
import com.xnotify.bdd.integrations.common_utils.DriverFactory;
import com.xnotify.bdd.integrations.report_utils.ReportManager;
import com.xnotify.bdd.integrations.report_utils.ScreenshotUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {

	public static ArrayList<String> passedTests = new ArrayList<String>();

	public static ArrayList<String> failedTests = new ArrayList<String>();

	public static ArrayList<String> totalTestCases = new ArrayList<String>();

	private static String str_Execution_TYPE = System.getProperty("execType");

	DriverFactory driverFactory = DriverFactory.getInstance();

	public String str_BrowserType = System.getProperty("Browser");

	BrowserFactory browserfactory = BrowserFactory.getInstance();

	public static String featureFileName;

	@Before(value = "@Noaudio", order = 0)

	public void skipscenario(Scenario scenario) {

		System.out.println(
				"Skipped scenario is:" +
						scenario.getName());
	}

	@Before

	public void before(Scenario scenario)
			throws Exception {

		System.out.println(
				"+++++++++++++++++++before hooks++++++++++++++++++");

		// =========================
		// WEB EXECUTION
		// =========================

		if (str_Execution_TYPE
				.equalsIgnoreCase("Web_UI")) {

			ReportManager.startTest(
					scenario.getName(),
					"SMOKE");

			System.out.println(
					"Execution started @ "
							+ str_BrowserType
							+ " browser & for type : Web UI");

			browserfactory.setBrowser(
					str_BrowserType);

			browserfactory
					.getBrowserContext()
					.tracing()
					.start(
							new Tracing.StartOptions()
									.setScreenshots(true)
									.setSnapshots(true));
		}

		// =========================
		// MOBILE EXECUTION
		// =========================

		else if (str_Execution_TYPE
				.equalsIgnoreCase("Mobile_UI")) {

			ReportManager.startTest(
					scenario.getName(),
					"SMOKE");

			DriverFactory.getInstance()
					.getMobileDriver()
					.activateApp("com.curebay.medicare");

			System.out.println(
					"---Open Mobile App---");
		}

		// =========================
		// API EXECUTION
		// =========================

		else if (str_Execution_TYPE
				.equalsIgnoreCase("API")) {

			ReportManager.startTestAPI(
					scenario.getName(),
					"SMOKE");

			System.out.println(
					"Thread ID: "
							+ Thread.currentThread().getId()
							+ " | Scenario: "
							+ scenario.getName());
		}

		// =========================
		// E2E EXECUTION
		// =========================

		else if (str_Execution_TYPE
				.equalsIgnoreCase("E2E")) {

			ReportManager.startTest(
					scenario.getName(),
					"E2E");

			System.out.println(
					"Execution started for E2E Flow");

			// =========================
			// START WEB
			// =========================

			browserfactory.setBrowser(
					str_BrowserType);

			browserfactory
					.getBrowserContext()
					.tracing()
					.start(
							new Tracing.StartOptions()
									.setScreenshots(true)
									.setSnapshots(true));

			// =========================
			// START MOBILE
			// =========================

			String platform = System.getProperty(
					"platform",
					"Android");

			String udid = System.getProperty(
					"udid",
					"RZCX314XC4F");

			String deviceName = System.getProperty(
					"deviceName",
					"Samsung A55");

			System.out.println(
					"Initializing Mobile Driver for E2E");

			driverFactory.setMobileDriver(
					platform,
					udid,
					"",
					deviceName);

			System.out.println(
					"Mobile Driver initialized successfully");

			// OPTIONAL
			// APK already auto launches

			DriverFactory.getInstance()
					.getMobileDriver()
					.activateApp(
							"com.cenomi.mallsapp");

			System.out.println(
					"Web + Mobile initialized successfully");
		}

		else {

			throw new Exception(
					"[-] Please set execution type properly");
		}
	}

	@After

	public void after(Scenario scenario)
			throws Exception {

		System.out.println(
				"+++++++++++++++++++after hooks+++++++++++++++++++");

		String dateStamp = new SimpleDateFormat("dd.MM.yyyy")
				.format(new Date());

		// =========================
		// WEB CLEANUP
		// =========================

		if (str_Execution_TYPE
				.equalsIgnoreCase("Web_UI")) {

			browserfactory
					.getBrowserContext()
					.tracing()
					.stop(
							new Tracing.StopOptions()
									.setPath(
											Paths.get(
													System.getProperty("user.dir")
															+ "/TracingReports/"
															+ dateStamp + "/"
															+ scenario.getName()
															+ ".zip")));

			handleWebResult(scenario);
		}

		// =========================
		// MOBILE CLEANUP
		// =========================

		else if (str_Execution_TYPE
				.equalsIgnoreCase("Mobile_UI")) {

			handleMobileResult(scenario);

			DriverFactory.getInstance()
					.getMobileDriver()
					.terminateApp(
							"in.gypsee.customer");

			System.out.println(
					"---Close Mobile App---");
		}

		// =========================
		// API CLEANUP
		// =========================

		else if (str_Execution_TYPE
				.equalsIgnoreCase("API")) {

			handleAPIResult(scenario);
		}

		// =========================
		// E2E CLEANUP
		// =========================

		else if (str_Execution_TYPE
				.equalsIgnoreCase("E2E")) {

			// STOP WEB TRACE

			browserfactory
					.getBrowserContext()
					.tracing()
					.stop(
							new Tracing.StopOptions()
									.setPath(
											Paths.get(
													System.getProperty("user.dir")
															+ "/TracingReports/"
															+ dateStamp + "/"
															+ scenario.getName()
															+ ".zip")));

			// TERMINATE MOBILE APP SAFELY

			if (DriverFactory.getInstance()
					.getMobileDriver() != null) {

				DriverFactory.getInstance()
						.getMobileDriver()
						.terminateApp(
								"com.cenomi.mallsapp");

				System.out.println(
						"Mobile app terminated successfully");

			} else {

				System.out.println(
						"Mobile driver is null. Skipping terminateApp()");
			}

			handleWebResult(scenario);

			System.out.println(
					"E2E execution completed");
		}
	}

	// =========================
	// COMMON METHODS
	// =========================

	public void handleWebResult(
			Scenario scenario) {

		totalTestCases.add(
				scenario.getName());

		if (scenario.isFailed()) {

			failedTests.add(
					scenario.getName());

			try {

				final byte[] screenshot = ScreenshotUtil
						.takeScreenshot()
						.getBytes();

				scenario.attach(
						screenshot,
						"image/png",
						featureFileName);

				scenario.log(
						"Screenshot Attached");

			} catch (TimeoutError e) {

			}

			try {

				ReportManager.logWebScreenshot();

			} catch (Exception e) {

			}

		} else {

			passedTests.add(
					scenario.getName());
		}
	}

	public void handleMobileResult(
			Scenario scenario) {

		totalTestCases.add(
				scenario.getName());

		if (scenario.isFailed()) {

			failedTests.add(
					scenario.getName());

			final byte[] screenshot = ((TakesScreenshot) DriverFactory
					.getInstance()
					.getMobileDriver())
					.getScreenshotAs(
							OutputType.BYTES);

			scenario.attach(
					screenshot,
					"image/png",
					featureFileName);

			scenario.log(
					"Screenshot Attached");

		} else {

			passedTests.add(
					scenario.getName());
		}
	}

	public void handleAPIResult(
			Scenario scenario) {

		totalTestCases.add(
				scenario.getName());

		if (scenario.isFailed()) {

			failedTests.add(
					scenario.getName());

		} else {

			passedTests.add(
					scenario.getName());
		}
	}
}
