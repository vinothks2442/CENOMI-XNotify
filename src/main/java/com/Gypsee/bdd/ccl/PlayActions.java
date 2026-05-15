package com.Gypsee.bdd.ccl;

import static org.testng.Assert.assertEquals;


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.Gypsee.bdd.integrations.common_utils.BrowserFactory;
import com.Gypsee.bdd.integrations.report_utils.ReportManager;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.options.WaitForSelectorState;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class PlayActions {

	private Page page = BrowserFactory.getInstance().getPage();
	public Page newTab;
	
	public void openURL(String URL) {
		page.navigate(URL);
		String ActualURL = page.url();
		System.out.println("Actual URL - " + ActualURL);
		System.out.println("Expected URL - " + URL);
		ReportManager.logInfo("Actual URL - " + ActualURL);
		ReportManager.logInfo("Expected URL - " + URL);
	}

	public void click(String locator, String info) {
		page.click(locator);
		System.out.println("Successfully clicked on  -  " + info);
		ReportManager.logInfo("Successfully clicked on  -  " + info);
	}

	public void sendKeys(String locator, String value, String info) {
		page.fill(locator, value);
		System.out.println("Successfully entered value -  " + value + " in " + info + " box");
		ReportManager.logInfo("Successfully entered value -  " + value + " in " + info + " box");
	}

	public void enterText(String locator, String value, String info) {
		page.type(locator, value);
		System.out.println("Successfully entered value -  " + value + " in " + info + " box");
		ReportManager.logInfo("Successfully entered value -  " + value + " in " + info + " box");
	}

	public void clickInsideFrame(String frameLocator, String elementLocator, String info) {
		Locator locator = page.frameLocator(frameLocator).locator(elementLocator);
		locator.click();
		System.out.println("Successfully clicked on  -  " + info);
		ReportManager.logInfo("Successfully clicked on  -  " + info);
	}
	
	public void clickInsideFramegetByLabel(String frameLocator, String elementLocator, String info) {
		Locator locator = page.frameLocator(frameLocator).getByLabel(elementLocator);
		locator.click();
		System.out.println("Successfully clicked on  -  " + info);
		ReportManager.logInfo("Successfully clicked on  -  " + info);
	}
	public void sendKeysInsideFramegetByLabel(String frameLocator, String elementLocator,String value , String info) {
		Locator locator = page.frameLocator(frameLocator).getByLabel(elementLocator);
		locator.fill(value);
		System.out.println("Successfully entered value -  " + value + " in " + info + " box");
		ReportManager.logInfo("Successfully entered value -  " + value + " in " + info + " box");
	}
	
	public void newTabclickInsideFramegetByLabel(String frameLocator, String elementLocator, String info) {
		Locator locator = newTab.frameLocator(frameLocator).getByLabel(elementLocator);
		locator.click();
		System.out.println("Successfully clicked on  -  " + info);
		ReportManager.logInfo("Successfully clicked on  -  " + info);
	}
	public void newTabsendKeysInsideFramegetByLabel(String frameLocator, String elementLocator,String value , String info) {
		Locator locator = newTab.frameLocator(frameLocator).getByLabel(elementLocator);
		locator.fill(value);
		System.out.println("Successfully entered value -  " + value + " in " + info + " box");
		ReportManager.logInfo("Successfully entered value -  " + value + " in " + info + " box");
	}

	/**
	 * In playwright, we no need to search any method,to switching back from frame
	 * to default content It automatically switches content like frame to default
	 * content (exclude nested frames) This will applicable only for methods:
	 * clickInsideFrame, isVisibleInsideFrame, getTextInsideFrame and
	 * sendkeysInsideFrame.
	 **/
	public boolean isVisibleInsideFrame(String frameLocator, String elementLocator, String info) {
		Locator locator = page.frameLocator(frameLocator).locator(elementLocator);
		boolean isPresent = locator.isVisible();
		if (isPresent == true) {
			System.out.println("Successfully element is displayed  -  " + info);
			ReportManager.logInfo("Successfully element is displayed  -  " + info);
		} else {
			ReportManager.logInfo("element not displayed: " + info);
			System.out.println("element not displayed: " + info);

		}
		return isPresent;
	}

	public String getTextInsideFrame(String frameLocator, String elementLocator, String info) {
		Locator locator = page.frameLocator(frameLocator).locator(elementLocator);
		String text = locator.textContent();
		System.out.println("Text is -  " + text);
		ReportManager.logInfo("Text is -  " + text);
		return text;
	}

	public void sendKeysInsideFrame(String frameLocator, String elementLocator, String value, String info) {
		Locator locator = page.frameLocator(frameLocator).locator(elementLocator);
		locator.fill(value);
		System.out.println("Successfully entered value -  " + value + " in " + info + " box");
		ReportManager.logInfo("Successfully entered value -  " + value + " in " + info + " box");
	}

	public void enterTextInsideFrame(String frameLocator, String elementLocator, String value, String info) {
		Locator locator = page.frameLocator(frameLocator).locator(elementLocator);
		locator.type(value);
		System.out.println("Successfully entered value -  " + value + " in " + info + " box");
		ReportManager.logInfo("Successfully entered value -  " + value + " in " + info + " box");
	}

	Frame frame;

	public Frame switchToFrame(String frameLocator, String info) {
		frame = page.frame(frameLocator);
		ReportManager.logInfo("Successfully switched to frame -  " + info);
		System.out.println("Successfully switched to frame -  " + info);
		return frame;
		/**
		 * from this method you will get return value Frame. How to use this method ?
		 * Eg:1 Locator locator =
		 * play.switchToFrame(frameLocator,info).locator(elementInsideFrame); import
		 * Locator from com.microsoft.playwright package now , locator.click; --> it
		 * will click on element inside a frame Eg:2 List <Frame>
		 * childFrames=play.switchToFrame(frameLocator,info).childFrames(); now i need
		 * to click on element which is inside a second childFrame Frame
		 * secondChildFrame=childFrames.get(1);
		 * secondChildFrame.locator(elemtInsideSecondFrame).click; Eg:3 if you need to
		 * switch back to parent frame use this --> Frame parentFrame =
		 * secondChildFrame.parentFrame(); by using parentFrame variable you can enhance
		 * your automation in Nested Frames
		 * 
		 **/
	}

	public void switchToDefaultPage(String info) {
		page = frame.page();
		ReportManager.logInfo("Successfully switched to default page -  " + info);
		System.out.println("Successfully switched to default page -  " + info);
	}

	public String getText(String locator) {
		String Text = page.textContent(locator);
		System.out.println("Text is -  " + Text);
		ReportManager.logInfo("Text is -  " + Text);
		return Text;
	}

	public void draganddrop(String source, String target) {
		page.dragAndDrop(source, target);
		System.out.println("Successfully dragged from " + source + " to " + target);
		ReportManager.logInfo("Successfully dragged from " + source + " to " + target);
	}

	public void check(String locator, String info) {
		page.check(locator);
		System.out.println("Successfully checked -  " + locator + " in " + info + " box");
		ReportManager.logInfo("Successfully checked -  " + locator + " in " + info + " box");

	}

	public String getContent() {
		String content = page.content();
		System.out.println("The HTML page content is " + content);
		ReportManager.logInfo("The HTML page content is " + content);
		return content;
	}

	public void verifyText(String actualText, String expectedText) {
		ReportManager.logInfo("Actual Text - " + actualText);
		ReportManager.logInfo("Expected Text - " + expectedText);
		System.out.println("Actual Text - " + actualText);
		System.out.println("Expected Text - " + expectedText);
		assertEquals(actualText, expectedText);
	}

	public void verifyIntValues(int actualValue, int expectedValue) {
		ReportManager.logInfo("Actual Value - " + actualValue);
		ReportManager.logInfo("Expected Value - " + expectedValue);
		System.out.println("Actual Value - " + actualValue);
		System.out.println("Expected Value - " + expectedValue);
		assertEquals(actualValue, expectedValue);
	}

	public String getAttributeValue(String locator, String name) {

		String attributeText = page.getAttribute(locator, name);
		ReportManager.logInfo("Successfully get attribute text - " + attributeText);
		System.out.println("Successfully get attribute text - " + attributeText);
		return attributeText;
	}

	public void doubleClick(String locator, String info) {
		page.dblclick(locator);
		System.out.println("Successfully double clicked on  -  " + info);
		ReportManager.logInfo("Successfully double clicked on  -  " + info);
	}

	public void backButton(String locator, String info) {
		page.goBack();
		System.out.println("Successfully clicked on Back Button");
		ReportManager.logInfo("Successfully clicked on Back Button");
	}

	public void nextPage(String locator, String info) {
		page.goForward();
		System.out.println("Successfully clicked on Forward Button");
		ReportManager.logInfo("Successfully clicked on Forward Button");
	}

	public void mouseHover(String locator, String info) {
		page.hover(locator);
		System.out.println("Successfully mouse hoverd on  -  " + info);
		ReportManager.logInfo("Successfully mouse hoverd on  -  " + info);
	}

	public boolean isChecked(String locator, String info) {

		boolean isChecked = page.isChecked(locator);
		if (isChecked == true) {
			System.out.println("Successfully element is checked  -  " + info);
			ReportManager.logInfo("Successfully element is checked  -  " + info);
		} else {
			ReportManager.logInfo("element not checked: " + info);
			System.out.println("element not is checked: " + info);

		}
		return isChecked;
	}

	public boolean isDisabled(String locator, String info) {

		boolean isDisabled = page.isDisabled(locator);
		if (isDisabled == true) {
			System.out.println("Successfully element is disabled  -  " + info);
			ReportManager.logInfo("Successfully element is disabled  -  " + info);
		} else {
			ReportManager.logInfo("element not disabled: " + info);
			System.out.println("element not is disabled: " + info);

		}
		return isDisabled;
	}

	public boolean isEnabled(String locator, String info) {

		boolean isEnabled = page.isEnabled(locator);
		if (isEnabled == true) {
			System.out.println("Successfully element is enabled  -  " + info);
			ReportManager.logInfo("Successfully element is enabled  -  " + info);
		} else {
			ReportManager.logInfo("element not enabled: " + info);
			System.out.println("element not is enabled: " + info);

		}
		return isEnabled;
	}

	public boolean isVisible(String locator, String info) {
		boolean isPresent = page.isVisible(locator);
		if (isPresent == true) {
			System.out.println("Successfully element is displayed  -  " + info);
			ReportManager.logInfo("Successfully element is displayed  -  " + info);
		} else {
			ReportManager.logInfo("element not displayed: " + info);
			System.out.println("element not displayed: " + info);

		}
		return isPresent;
	}

	public String getTitle() {
		String title = page.title();
		System.out.println("The title of the page is : " + title);
		ReportManager.logInfo("The title of the page is : " + title);
		return title;
	}
	
	public String getURL() {
		String url = page.url();
		System.out.println("The URL of the page is : " + url);
		ReportManager.logInfo("The URL of the page is : " + url);
		return url;
	}

	public void uncheck(String locator, String info) {
		page.uncheck(locator);
		System.out.println("Successfully element is uncheck  -  " + info);
		ReportManager.logInfo("Successfully element is uncheck  -  " + info);
	}

	public boolean isDisplayed(String locator, String info) {
		boolean isPresent = page.isVisible(locator);

		if (isPresent == true) {
			ReportManager.logInfo("Successfully element displayed: " + info);
			System.out.println("Successfully element displayed: " + info);
		} else {
			ReportManager.logInfo("element not displayed: " + info);
			System.out.println("element not displayed: " + info);

		}
		return isPresent;
	}

	public void scrollToElement(String locator, String info) {
		page.locator(locator).scrollIntoViewIfNeeded();
		ReportManager.logInfo("Successfully scrolled to - " + info);
		System.out.println("Successfully scrolled to - " + info);
	}

	public void keyboard(String keys) {
		/**
		 * refer this link -> https://playwright.dev/java/docs/api/class-keyboard
		 **/
		Keyboard key = page.keyboard();
		key.press(keys);
		System.out.println("Successfully clicked on  -  " + keys);
		ReportManager.logInfo("Successfully clicked on  -  " + keys);
	}
	public void newTabkeyboard(String keys) {
		/**
		 * refer this link -> https://playwright.dev/java/docs/api/class-keyboard
		 **/
		Keyboard key = page.keyboard();
		key.press(keys);
		System.out.println("Successfully clicked on  -  " + keys);
		ReportManager.logInfo("Successfully clicked on  -  " + keys);
	}
	
	public void newtabTextTypeKeyBoard(String keys) {
		/**
		 * refer this link -> https://playwright.dev/java/docs/api/class-keyboard
		 **/
		Keyboard key = newTab.keyboard();
		key.type(keys);
		System.out.println("Successfully entered on  -  " + keys);
		ReportManager.logInfo("Successfully entered on  -  " + keys);
	}
	
	public void actionsKeyBoardKeys(String pages, String keys,int actionsTimes) {
		/**
		 * refer this link -> https://playwright.dev/java/docs/api/class-keyboard
		 **/
		for(int k=0; k<actionsTimes;k++) {
			Keyboard key = null ;
			switch (pages) {
			case "Page":
				key = page.keyboard();
				key.press(keys);
				break;
			case "NewPage":
				key = newTab.keyboard();
				key.press(keys);
				break;
			default:
				break;
			}
		}
	}

	public void delayClick(String locator, double setDelayInMilliSec, String info) {
		page.click(locator, new Page.ClickOptions().setDelay(setDelayInMilliSec));
		System.out.println("Successfully clicked on  -  " + info);
		ReportManager.logInfo("Successfully clicked on  -  " + info);
	}

	public void waitForUpload(String locator, String path, String info) {
		page.setInputFiles(locator, Paths.get(path));
		System.out.println("Successfully file uploaded -  " + info);
		ReportManager.logInfo("Successfully file uploaded  -  " + info);
	}

	public void waitForDownload(String locator, String path) {
		Download download = page.waitForDownload(() -> {
			page.click(locator);
		});
		String fileName = download.suggestedFilename();
		download.saveAs(Paths.get(path + fileName));
		System.out.println("Successfully file downloaded -  " + fileName);
		System.out.println("File path - " + path + fileName);
		ReportManager.logInfo("Successfully file downloaded  -  " + fileName);
	}

	public void SelectOptions(String locator, String index) {
		page.selectOption(locator, index);
		System.out.println("Successfully selected the value in Dropdown");
		ReportManager.logInfo("Successfully selected the value in Dropdown");

	}

	public void clear(String locator, String text) {

		page.locator(locator).click();
		page.keyboard().press("Control+A");
		page.keyboard().down("Delete");
		ReportManager.logInfo("Successfully Cleared text - " + text);
		System.out.println("Successfully Cleared text - " + text);

	}

	public Page getPage() {
		return page;
	}

	public boolean waitForVisible(String locator, double setTimeoutInMilliSec, String info) {
		// boolean isPresent = page.isVisible(locator, new
		// Page.IsVisibleOptions().setTimeout(setTimeoutInMilliSec)); --> this statement
		// got deprecated so,
		ElementHandle element = page.waitForSelector(locator, new Page.WaitForSelectorOptions()
				.setState(WaitForSelectorState.VISIBLE).setTimeout(setTimeoutInMilliSec));
		boolean isPresent = element.isVisible();
		if (isPresent == true) {
			System.out.println("Successfully element is displayed  -  " + info);
			ReportManager.logInfo("Successfully element is displayed  -  " + info);
		} else {
			ReportManager.logInfo("element not displayed: " + info);
			System.out.println("element not displayed: " + info);

		}
		return isPresent;
	}

	public void waitForClick(String locator, double setTimeoutInMilliSec, String info) {
		page.click(locator, new Page.ClickOptions().setTimeout(setTimeoutInMilliSec));
		System.out.println("Successfully clicked on  -  " + info);
		ReportManager.logInfo("Successfully clicked on  -  " + info);
	}

	public void waitForOpenURL(String URL, double setTimeoutInMilliSec) {
		page.navigate(URL, new Page.NavigateOptions().setTimeout(setTimeoutInMilliSec));
		String ActualURL = page.url();
		System.out.println("Actual URL - " + ActualURL);
		System.out.println("Expected URL - " + URL);
		ReportManager.logInfo("Actual URL - " + ActualURL);
		ReportManager.logInfo("Expected URL - " + URL);
	}

	public void retrieveExcelData() throws IOException, EncryptedDocumentException, InvalidFormatException {
		FileInputStream fileinputstream = new FileInputStream("./Excel_File/SwagLabs_With_Sample.xlsx");
		// FileInputStream fileinputstream = new
		// FileInputStream("F:\\Ecubix\\PlaywrightWeb\\Ecubix_With_Sample.xlsx");
		Workbook workbook = WorkbookFactory.create(fileinputstream);
		String date = workbook.getSheet("SwagLabs").getRow(1).getCell(8).getStringCellValue();
		String doctorcode = workbook.getSheet("SwagLabs").getRow(1).getCell(9).getStringCellValue();
		String doctorname = workbook.getSheet("SwagLabs").getRow(1).getCell(10).getStringCellValue();
		String sample = workbook.getSheet("SwagLabs").getRow(1).getCell(24).getStringCellValue();
		String samplequantity = workbook.getSheet("SwagLabs").getRow(1).getCell(25).getStringCellValue();
		System.out.println("TodayDate  -" + date);
		ReportManager.logInfo("Successfully retrieved the Date  -  " + date);
		System.out.println("DoctorCode  -" + doctorcode);
		ReportManager.logInfo("Successfully retrieved the DoctorCode  -  " + doctorcode);
		System.out.println("DoctorName  -" + doctorname);
		ReportManager.logInfo("Successfully retrieved the DoctorName  -  " + doctorname);
		System.out.println("Sample  -" + sample);
		ReportManager.logInfo("Successfully retrieved the Sample  -  " + sample);
		System.out.println("SampleQuantity -" + samplequantity);
		ReportManager.logInfo("Successfully retrieved the SampleQuantity  -  " + samplequantity);

	}

	public void navigateNewTab(String locator, String info) {
		newTab = page.waitForPopup(() -> {
			page.click(locator);
			System.out.println("Successfully clicked on  -  " + info);
			ReportManager.logInfo("Successfully clicked on  -  " + info);
		});

	}

	public void newTabsendKeys(String locator, String amount, String info) {

		newTab.fill(locator, amount);

		System.out.println("Successfully entered value -  " + amount + " in " + info + " box");

		ReportManager.logInfo("Successfully entered value -  " + amount + " in " + info + " box");

	}

	public String newTabgetText(String locator) {

		String Text = newTab.textContent(locator);

		System.out.println("Text is -  " + Text);

		ReportManager.logInfo("Text is -  " + Text);

		return Text;

	}

	public void newTabclick(String locator, String info) {

		newTab.click(locator);

		System.out.println("Successfully clicked on  -  " + info);

		ReportManager.logInfo("Successfully clicked on  -  " + info);

	}

	public void closeNewTab() {

		newTab.close();

	}

	public void newTabverifyText(String actualText, String expectedText) {
		ReportManager.logInfo("Actual Text - " + actualText);
		ReportManager.logInfo("Expected Text - " + expectedText);
		System.out.println("Actual Text - " + actualText);
		System.out.println("Expected Text - " + expectedText);
		assertEquals(actualText, expectedText);
	}

	public void framelocatorFillByLocator(String selector, String locator, String value, String info) {
		page.frameLocator(selector).locator(locator).fill(value);
		System.out.println("Successfully enter the value  -  " + value + " in " + info + " box");
		ReportManager.logInfo("Successfully entered value -  " + value + " in " + info + " box");
	}

	public String frameGetTextByLocator(String selector, String locator) {
		String text = page.frameLocator(selector).locator(locator).textContent();
		System.out.println("Successfully get text  -" + text);
		ReportManager.logInfo("Successfully get text  -  " + text);

		return text;
	}

	public void framemouseHover(String selector, String locator, String info) {
		// page.hover(locator);
		page.frameLocator(selector).locator(locator).hover();
		System.out.println("Successfully mouse hoverd on  -  " + info);
		ReportManager.logInfo("Successfully mouse hoverd on  -  " + info);
	}

	public void frameScrollToElement(String selector, String locator, String info) {
		page.frameLocator(selector).locator(locator).scrollIntoViewIfNeeded();
		ReportManager.logInfo("Successfully scrolled to - " + info);
		System.out.println("Successfully scrolled to - " + info);
	}

	public void ArrowDown(int count) {
		for (int i = 0; i <= count; i++) {
			try {
			} catch (Exception e) {

				System.out.println("");
			}
			BrowserFactory.getInstance().getPage().keyboard().press("ArrowDown");
		}
	}

	public void PageDown(int count) {
		for (int i = 0; i <= count; i++) {
			try {
			} catch (Exception e) {

				System.out.println("");
			}
			BrowserFactory.getInstance().getPage().keyboard().press("PageDown");
		}
	}

	public void frameVerifyTxt(String selector, String actualtext, String expectedText) {

		page.frameLocator(selector);

		ReportManager.logInfo("Actual Text - " + actualtext);

		ReportManager.logInfo("Expected Text - " + expectedText);

		System.out.println("Actual Text - " + actualtext);

		System.out.println("Expected Text - " + expectedText);

		assertEquals(actualtext, expectedText);

	}

	public boolean isVisible(String locator) {
		boolean isElement = page.isVisible(locator);
		return isElement;
	}
	public void getAlertMessage() {
		page.onDialog(dialog -> {
			String Message = dialog.message();
			System.out.println("Alert Message " + Message);
		});
	}

	public void SelectOptionsValue(String locator, String value) {
		page.selectOption(locator, value);
		System.out.println("Successfully selected the value in Dropdown");
		ReportManager.logInfo("Successfully selected the value in Dropdown");
	}

	public void parentSwitchWindow() {
		page.bringToFront();
	}

	public void pageSwitchWindows() {
		Page newTabPage = page.waitForPopup(() -> {
		});
		newTabPage.waitForLoadState();
		String title = newTabPage.title();
		String url = newTabPage.url();
		System.out.println("Successfully Get New Tab Title - " + title);
		ReportManager.logInfo("Successfully Get New Tab Title - " + title);

		System.out.println("Successfully Get New Tab URL - " + url);
		ReportManager.logInfo("Successfully Get New Tab URL - " + url);

	}

	public void uploadFileWithRobotClass(String filePath) throws Exception {
		Robot robot = new Robot();
		robot.delay(3000);
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(3000);
	}

	public void robotTabKey() {
		try {
			Robot robot = new Robot();
			robot.delay(500);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.delay(500);
		} catch (AWTException e) {
//		e.printStackTrace();
		}
	}

	public void robotEnterKey() {
		try {
			Robot robot = new Robot();
			robot.delay(500);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(500);
		} catch (AWTException e) {
//		e.printStackTrace();
		}
	}

	/*
	 * points = 0.75; 1->100% 0.95->95% 1.05->102%
	 */
	public void pageZoom(double points) {
		page.evaluate("document.body.style.zoom = '" + points + "'");
	}

	public void WaitForElementDisappear(String locator) throws InterruptedException {
		page.waitForSelector(locator, new WaitForSelectorOptions().setState(WaitForSelectorState.HIDDEN)); // Only 30
																											// Secs
	}

	public void WaitsForElementDisappear(String locator) {
//		try {
//			page.waitForSelector(locator, new WaitForSelectorOptions().setState(WaitForSelectorState.HIDDEN)); // Only
																												// 30
																												// Secs
//		} catch (Exception e) {
			 int a=0;
			do {
				 a++;
				if (page.isHidden(locator)) {
					 System.out.println("Element has disappeared");
					break;
				}
			} while (page.isVisible(locator));
	System.out.println("Secs "+a);
//		}
	}
	public void clicksUptoLowOpacity(String locatorVisible,String locatorVisibleLowOpacity) {
		try {
			do {
				System.out.println("Visisble Element");
				if (page.isVisible(locatorVisibleLowOpacity)) {
					System.out.println("Visisble LowOpacity Element");
					break;
				}
				page.locator(locatorVisible).click();
				click(locatorVisible, "Clicking > ");
			} while (page.isVisible(locatorVisible));
		}catch (Exception e) {
		}
	}
	public void pageScreenShots() {
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		byte[] buffer = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String str= Base64.getEncoder().encodeToString(buffer);
		ReportManager.getCurrentTest().info(str);
	}
	public void newTabPageScreenShots() {
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		byte[] buffer = page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String str= Base64.getEncoder().encodeToString(buffer);
		ReportManager.getCurrentTest().info(str);
	}
	
	public void newtab() {
		page.context().newPage().navigate(getContent());
	}
}

