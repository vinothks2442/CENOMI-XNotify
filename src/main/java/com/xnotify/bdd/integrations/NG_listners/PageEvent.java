// package com.xnotify.bdd.integrations.NG_listners;

// import java.io.IOException;

// import org.testng.ITestContext;
// import org.testng.ITestListener;
// import org.testng.ITestResult;

// import com.aventstack.extentreports.markuputils.ExtentColor;
// import com.aventstack.extentreports.markuputils.Markup;
// import com.aventstack.extentreports.markuputils.MarkupHelper;
// import com.xnotify.bdd.integrations.common_utils.BrowserFactory;
// import com.xnotify.bdd.integrations.common_utils.VideoRecord;
// import com.xnotify.bdd.integrations.report_utils.ReportManager;

// public class PageEvent implements ITestListener {

// 	public static String strBrowser;

// 	@Override
// 	public void onTestStart(ITestResult arg0) {
// 		System.out.println("+++++++++++++++++++++onTestStart++++++++++++++++++++");

// 		strBrowser = System.getProperty("Browser");
// 		System.out.println("Execution started @ " + strBrowser + " browser & for type : Web UI");
// 		try {

// 			VideoRecord.startRecord(arg0.getMethod().getMethodName());

// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}

// 	}

// 	@Override
// 	public void onTestSuccess(ITestResult iTestResult) {

// 		try {
// 			BrowserFactory.getInstance().getPlaywright().close();
// 			VideoRecord.stopRecord();

// 		} catch (Exception e) {

// 			e.printStackTrace();
// 		}

// 	}

// 	@Override
// 	public void onTestFailure(ITestResult iTestResult) {

// 		// retry.retry(iTestResult);
// 		System.out.println("+++++++++++++++++++++onTestFailure++++++++++++++++++++");
// 		ReportManager.logFail(iTestResult.getThrowable().toString());

// 		try {

// 			VideoRecord.stopRecord();
// 			BrowserFactory.getInstance().getPlaywright().close();

// 		} catch (Exception e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}
// 	}

// 	@Override
// 	public void onTestSkipped(ITestResult arg0) {
// 		// TODO Auto-generated method stub

// 		// ExtentLogger.skip("<b><i>" + result.getThrowable().toString() + "</i></b>");
// 		String logText = "<b>" + arg0.getMethod().getMethodName() + " is skipped.</b>";
// 		Markup markup_message = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);

// 	}

// 	@Override
// 	public void onFinish(ITestContext arg0) {
// 		// TODO Auto-generated method stub

// 	}

// 	@Override
// 	public void onStart(ITestContext arg0) {

// 		// strBrowser = arg0.getCurrentXmlTest().getParameter("browser");
// 	}

// 	@Override
// 	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
// 		// TODO Auto-generated method stub

// 	}
// }

package com.xnotify.bdd.integrations.NG_listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.xnotify.bdd.integrations.common_utils.BrowserFactory;
import com.xnotify.bdd.integrations.common_utils.VideoRecord;
import com.xnotify.bdd.integrations.report_utils.ReportManager;

public class PageEvent implements ITestListener {

	public static String strBrowser;

	public static String str_Execution_TYPE = System.getProperty("execType");

	@Override
	public void onTestStart(ITestResult arg0) {

		System.out.println(
				"+++++++++++++++++++++onTestStart++++++++++++++++++++");

		strBrowser = System.getProperty("Browser");

		System.out.println(
				"Execution started @ "
						+ strBrowser
						+ " browser & for type : "
						+ str_Execution_TYPE);

		try {

			// START VIDEO ONLY FOR WEB/E2E

			if (str_Execution_TYPE.equalsIgnoreCase("Web_UI")
					|| str_Execution_TYPE.equalsIgnoreCase("E2E")) {

				VideoRecord.startRecord(
						arg0.getMethod().getMethodName());
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {

		try {

			// CLOSE PLAYWRIGHT ONLY IF INITIALIZED

			if ((str_Execution_TYPE.equalsIgnoreCase("Web_UI")
					|| str_Execution_TYPE.equalsIgnoreCase("E2E"))

					&& BrowserFactory.getInstance()
							.getPlaywright() != null) {

				BrowserFactory.getInstance()
						.getPlaywright()
						.close();
			}

			// STOP VIDEO

			if (str_Execution_TYPE.equalsIgnoreCase("Web_UI")
					|| str_Execution_TYPE.equalsIgnoreCase("E2E")) {

				VideoRecord.stopRecord();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {

		System.out.println(
				"+++++++++++++++++++++onTestFailure++++++++++++++++++++");

		try {

			// AVOID NULL POINTER

			if (ReportManager.getCurrentTest() != null) {

				ReportManager.logFail(
						iTestResult.getThrowable().toString());
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		try {

			// STOP VIDEO

			if (str_Execution_TYPE.equalsIgnoreCase("Web_UI")
					|| str_Execution_TYPE.equalsIgnoreCase("E2E")) {

				VideoRecord.stopRecord();
			}

			// CLOSE PLAYWRIGHT SAFELY

			if ((str_Execution_TYPE.equalsIgnoreCase("Web_UI")
					|| str_Execution_TYPE.equalsIgnoreCase("E2E"))

					&& BrowserFactory.getInstance()
							.getPlaywright() != null) {

				BrowserFactory.getInstance()
						.getPlaywright()
						.close();
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {

		String logText = "<b>"
				+ arg0.getMethod().getMethodName()
				+ " is skipped.</b>";

		Markup markup_message = MarkupHelper.createLabel(
				logText,
				ExtentColor.YELLOW);

		System.out.println(logText);
	}

	@Override
	public void onFinish(ITestContext arg0) {

	}

	@Override
	public void onStart(ITestContext arg0) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(
			ITestResult arg0) {

	}
}