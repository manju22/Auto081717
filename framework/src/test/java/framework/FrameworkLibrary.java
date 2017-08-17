package framework;

import accessManagment.AccessManagementConstants;
import assembly.AssemblyConstants;
import clinicalEvaluation.ClinicalEvaluationConstants;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import dataEntry.DataEntryConstants;
import dataEntry.DataEntryStepDef;
import dataReview.dataReviewConstants;
import hangOn.hangOnConstants;
import intake.IntakeConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import junit.framework.AssertionFailedError;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.mitm.TrustSource;
import net.lightbody.bmp.mitm.manager.ImpersonatingMitmManager;
import net.lightbody.bmp.proxy.CaptureType;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationFactory;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import productVerification.ProductVerificationConstants;
import smokeTest.SmokeTestConstants;
import smokeTest.SmokeTestLibrary;
import smokeTest.SmokeTestStepDef;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class FrameworkLibrary extends FrameworkRunner {

	public static Dimension size;
	public static String destDir;
	public static DateFormat dateFormat;
	public static ChromeDriver chromeDriver;
	public static RemoteWebDriver androidDriver;
	public static AndroidDriver<AndroidElement> aDriver;
	public static WebElement element = null;
	public static WebDriver driver = null;
	public static String expecte = null;
	public static String X = null;
	public static String Y = null;
	public static Configuration config = null;
	public static String val = null;
	public static int DE_NumberOfTasksBeforeIntake;
	public static int DR_NumberOfTasksBeforeDE;
	public static WebDriver driver1;
	public static int watingForElement;
	public static boolean captureScreenshot;
	public static boolean isLogin = false;
	public static String usr_role = null;
	public static String environmentToExecute;
	public static String dasboardURL;
	public static String intakeURL;
	public static String pat_serach_results;
	public static String drug_search_results;
	static WebDriverWait browserWithElementWait = null;
	static long t1 = 0;
	static long t2 = 0;
	static long timeTaken = 0;
	static Integer Ycoordinate = null;
	static Integer Xcoordinate = null;
	static Integer img_Width = null;
	static Integer img_Height = null;
	static String imgLocation;
	static String imgSize;
	static Properties prop;
	private static Log log = LogFactory.getLog(FrameworkLibrary.class);
	String actual = null;

	public static BrowserMobProxy proxy;
	public static File reportFile = null;
	private static HSSFWorkbook workbook = null;
	public static HSSFSheet workflowSheet = null;
	public static HSSFRow row;
	private static HSSFRow headerRow = null;
	public static String workingFolder = "";
	public static int currentRowNumber;
	private static String methodName;
	public static String username;
	public static String password;
	public static Scenario scenario;
	public static String tagName;



	public FrameworkLibrary() throws ConfigurationException, IOException {
		ConfigurationFactory factory = new ConfigurationFactory(
				"src/test/resources/config/config.xml");
		config = factory.getConfiguration();
		watingForElement = config.getInt("elementWaitInSecond");
		captureScreenshot = Boolean.valueOf(config.getString("screenCapture"));
		// Perf
		workingFolder = System.getProperty("user.dir");
		reportFile = new File(workingFolder + File.separator + "report.xls");
		startProxyServer();
	}
	
	private void startProxyServer() {
		String baseDir = System.getProperty("user.dir");
		TrustSource trustSource = TrustSource.defaultTrustSource().add(baseDir + File.separator + "cert" + File.separator + "Walgreens_Internal_Root_CA.pem");
		ImpersonatingMitmManager mitmManager = ImpersonatingMitmManager.builder()
				.trustSource(trustSource) // use an explicit trust source, or:
				.trustAllServers(true) // do not validate servers' certificates
				.build();
		//Staring har file
		proxy = new BrowserMobProxyServer();
		proxy.setTrustAllServers(true);
		proxy.setTrustSource(trustSource);
		proxy.setMitmManager(mitmManager);
		proxy.start();
	}

	public static void loadReportFile(HSSFSheet worksheet, String sheetName) {
		try {
			if (reportFile.exists()) {
				FileInputStream fsIP = new FileInputStream(reportFile);
				workbook = new HSSFWorkbook(fsIP);
				worksheet = workbook.getSheet(sheetName);
				if(worksheet == null) {
					worksheet = workbook.createSheet(sheetName);
					if (tagName.equals("@RxMSSOLD")) {
						writeE2EHeader(worksheet);
					} else if(tagName.equals("@Perf_IkariWarriors")) {
						writeIkariHeader(worksheet);
					}
				}
				fsIP.close();
			} else {
				workbook = new HSSFWorkbook();
				worksheet = workbook.createSheet(sheetName);
				if (tagName.equals("@RxMSSOLD")) {
					writeE2EHeader(worksheet);
				} else if(tagName.equals("@Perf_IkariWarriors")) {
					writeIkariHeader(worksheet);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		int lastRowNum = worksheet.getLastRowNum();
		row = worksheet.createRow((short) lastRowNum + 1);
		currentRowNumber = row.getRowNum();
	}

	public static void writeE2EHeader(HSSFSheet worksheet) {
		headerRow = worksheet.createRow(0);
		HSSFCell cell = headerRow.createCell(0);
		cell.setCellValue("Iteration");
		cell = headerRow.createCell(1);
		cell.setCellValue("Applaunch");
		cell = headerRow.createCell(2);
		cell.setCellValue("Login");
		cell = headerRow.createCell(3);
		cell.setCellValue("Patient Local Search");
		cell = headerRow.createCell(4);
		cell.setCellValue("View Patient");
		cell = headerRow.createCell(5);
		cell.setCellValue("IntakeRx");
		cell = headerRow.createCell(6);
		cell.setCellValue("IntakeFinish");
		cell = headerRow.createCell(7);
		cell.setCellValue("DataEntry");
		cell = headerRow.createCell(8);
		cell.setCellValue("DE Finish");
		cell = headerRow.createCell(9);
		cell.setCellValue("DataReview");
		cell = headerRow.createCell(10);
		cell.setCellValue("DR Finish");
		cell = headerRow.createCell(11);
		cell.setCellValue("Clinical Evaluation");
		cell = headerRow.createCell(12);
		cell.setCellValue("CE-MedHistory");
		cell = headerRow.createCell(13);
		cell.setCellValue("CE-ClinicalHistory");
		cell = headerRow.createCell(14);
		cell.setCellValue("CE-Finish");
		cell = headerRow.createCell(15);
		cell.setCellValue("Fill-AppLaunch");
		cell = headerRow.createCell(16);
		cell.setCellValue("Fill-Login");
		cell = headerRow.createCell(17);
		cell.setCellValue("Fill-Print");
		cell = headerRow.createCell(18);
		cell.setCellValue("PV");
	}

	public static void writeIkariHeader(HSSFSheet worksheet) {
		headerRow = worksheet.createRow(0);
		HSSFCell cell = headerRow.createCell(0);
		cell.setCellValue("Iteration");
		cell = headerRow.createCell(1);
		cell.setCellValue("Applaunch");
		cell = headerRow.createCell(2);
		cell.setCellValue("Login");
		cell = headerRow.createCell(5);
		cell.setCellValue("AddPatient");
		cell = headerRow.createCell(6);
		cell.setCellValue("UpdatePatient");
		cell = headerRow.createCell(3);
		cell.setCellValue("Patient Local Search");
		cell = headerRow.createCell(4);
		cell.setCellValue("Patient Global Search");
		cell = headerRow.createCell(7);
		cell.setCellValue("View Patient");
		cell = headerRow.createCell(8);
		cell.setCellValue("Delete RX");
	}

	public static void writeReport() {
		try {
			/*HSSFCell cell = row.createCell(16);
			Date date = new Date();
			cell.setCellValue(date.toString());*/
			FileOutputStream fileOut = new FileOutputStream(reportFile);
			workbook.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Har writeHarFile(String workingFolder, String harName, int rowNum, int cellNum) throws IOException {

		String harReport = config.getProperty("isHarReport").toString();
		boolean isHarReport = Boolean.parseBoolean(harReport);
		if (!isHarReport) {
			return null;
		}
		Har har = proxy.endHar();
		File file = new File(workingFolder  + "/harFiles/"+ rowNum);
		if (!file.isDirectory()) {
			file.mkdirs();
		}
		har.getLog().getPages().get(0).setId(harName);
		har.getLog().getPages().get(0).setTitle(harName);
		List<HarEntry> entries = har.getLog().getEntries();
		for (HarEntry harEntry : entries) {
			harEntry.setPageref(harName);
		}
		File harFile = new File(file + File.separator + harName + ".har");
		har.writeTo(harFile);
		Long onLoad = har.getLog().getPages().get(0).getPageTimings().getOnLoad();
		HSSFCell cell = row.createCell(cellNum);
		cell.setCellValue(onLoad);
		return har;
	}

	public static void initiateBrowser_Android() throws Exception {
		try {
		File app = new File(
				(String) config.getProperty(FrameworkConstants.APKPATH));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities = DesiredCapabilities.android();
		capabilities.setCapability(MobileCapabilityType.PLATFORM,
				Platform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
				config.getProperty(FrameworkConstants.PLATFROMNAME));
		capabilities.setCapability("deviceName",
				config.getProperty(FrameworkConstants.DEVICENAME));
		capabilities.setCapability("version",
				config.getProperty(FrameworkConstants.PLATFROMVERSION));
		capabilities.setCapability("platformName",
				config.getProperty(FrameworkConstants.PLATFROMNAME));
		capabilities.setCapability("app", app.getAbsolutePath());
		Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
		Set<CaptureType> captureTypes = new HashSet<CaptureType>();
		captureTypes.add(CaptureType.REQUEST_BINARY_CONTENT);
		captureTypes.add(CaptureType.REQUEST_CONTENT);
		captureTypes.add(CaptureType.REQUEST_COOKIES);
		captureTypes.add(CaptureType.REQUEST_HEADERS);
		captureTypes.add(CaptureType.RESPONSE_BINARY_CONTENT);
		captureTypes.add(CaptureType.RESPONSE_CONTENT);
		captureTypes.add(CaptureType.RESPONSE_COOKIES);
		captureTypes.add(CaptureType.RESPONSE_HEADERS);
		proxy.enableHarCaptureTypes(captureTypes);
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
		proxy.newHar();
			aDriver = new AndroidDriver<AndroidElement>(new URL(
					(String) config.getProperty(FrameworkConstants.HUBURL)),
					capabilities);
			writeHarFile(workingFolder, "Fill-AppLaunch", row.getRowNum(), 15);
			aDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		} catch (Exception e) {
			Assert.fail("Driver failed to start - " + e.getMessage());
		}
	}

	public static void closeBrowser() {
		chromeDriver.quit();
	}

	/*
	 * Methods for
	 */

	public static void validateImagePosition(String objectProperty,
			String imgLocation, String imgName) {
		try {
			element = getElementByProperty(objectProperty, chromeDriver);
			Point point = element.getLocation();
			String[] imgsp = imgLocation.split("X");
			Xcoordinate = Integer.parseInt(imgsp[0]);
			Ycoordinate = Integer.parseInt(imgsp[1]);
			if (Xcoordinate.equals(point.x) && Ycoordinate.equals(point.y)) {
				log.info("------------------------------------------------------------------------------");
				log.info(imgName
						+ " Image Position :: X & Y coordinate value are Same");
			} else {
				log.info("------------------------------------------------------------------------------");
				log.info("Mismatch of " + imgName
						+ " Image Position X & Y coordinate");
				log.info("Actual X and Y Coordinate of Image "
						+ point.x + "," + point.y);
				log.info("Expected X and Y Coordinate of Image "
						+ Xcoordinate + "," + Ycoordinate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	/*
	 * Methods for
	 */

	public static void validateImageSize(String objectProperty, String imgSize,String imgName) {
		try {
			element = getElementByProperty(objectProperty, chromeDriver);
			Dimension dimensions = element.getSize();
			String[] imgsize = imgSize.split("X");
			img_Width = Integer.parseInt(imgsize[0]);
			img_Height = Integer.parseInt(imgsize[1]);
			if (img_Width.equals(dimensions.width)
					&& img_Height.equals(dimensions.height)) {
				log.info(imgName
						+ " Image Width & Height value are Same");
			} else {
				log.info("Mismatch of " + imgName
						+ " Image Width & Height");
				log.info("Actual Width and Height of Image "
						+ dimensions.width + "," + dimensions.height);
				log.info("Expected Width and Height of Image "
						+ img_Width + "," + img_Height);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Methods for
	 */
	public static boolean isSorted(List<String> list, String order) {
		if (order.equals("ascending")) {
			String previous = "";
			for (String current : list) {
				if (previous.compareTo(current) > 0)
					return false;
				previous = current;
			}
			return true;
		} else if (order.equals("descending")) {
			String previous = list.get(0);
			for (String current : list) {
				if (previous.compareTo(current) < 0)
					return false;
				previous = current;
			}
			return true;
		} else
			return false;
	}

	/*
	 * Methods for
	 */

	public static void accessibilityValidation(String objectProperty,
			String Text, String imgName) {
		try {
			element = getElementByProperty(objectProperty, chromeDriver);
			String alt = element.getAttribute("alt");
			if (alt.equalsIgnoreCase(Text)) {
				log.info(imgName+ " Image accessibility expected and actual name are Same");
			} else {
				log.info(imgName+ " Image accessibility expected and actual name are not Same");
				log.info("Accessibility-Actual : " + alt);
				log.info("Accessibility-Expected : " + Text);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	/*
	 * Methods for
	 */

	public static void linkText_Validation(String objectProperty, String Text) {
		try {
			element = getElementByProperty(objectProperty, chromeDriver);
			String linkText = element.getText();
			if (linkText.equalsIgnoreCase(Text)) {
				log.info("Link Text expected and actual text are Same");
			} else {
				log.info("Link Text expected and actual text are not Same");
				log.info("Link Text - Actual : " + linkText);
				log.info("Link Text -Expected : " + Text);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	/*
	 * Methods for
	 */

	public static void performanceValidation(long t1, long t2,String perf_Expected) throws Exception{
		try {
			timeTaken = (t2 - t1) / 1000;
			long expected = Long.parseLong(perf_Expected);
			if (timeTaken <= expected) {
			} else {
				log.info(" Page Load Time is High while Navigating to ::"+ chromeDriver.getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	/*
	 * Methods for
	 */

	public static WebElement getElementByProperty(String objectProperty,WebDriver webDriver) {
		String propertyType = null;
		WebDriverWait browserWithElementWait = null;
		try {
			if (browserWithElementWait == null) {
				browserWithElementWait = new WebDriverWait(webDriver,
						config.getInt("elementWaitInSecond"));
			}
			propertyType = StringUtils.substringAfter(objectProperty, "~");
			objectProperty = StringUtils.substringBefore(objectProperty, "~");
			if (propertyType.equalsIgnoreCase("CSS")) {
				element = browserWithElementWait.until(ExpectedConditions
						.presenceOfElementLocated(By
								.cssSelector(objectProperty)));
				highlightElement(element, webDriver);
			} else if (propertyType.equalsIgnoreCase("XPATH")) {
				element = browserWithElementWait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath(objectProperty)));
				highlightElement(element, webDriver);
			} else if (propertyType.equalsIgnoreCase("ID")) {
				element = browserWithElementWait.until(ExpectedConditions
						.presenceOfElementLocated(By.id(objectProperty)));
				highlightElement(element, webDriver);
			} else if (propertyType.equalsIgnoreCase("NAME")) {
				element = browserWithElementWait.until(ExpectedConditions
						.presenceOfElementLocated(By.name(objectProperty)));
				highlightElement(element, webDriver);
			} else if (propertyType.equalsIgnoreCase("LINKTEXT")) {
				element = browserWithElementWait.until(ExpectedConditions
						.presenceOfElementLocated(By.linkText(objectProperty)));
				highlightElement(element, webDriver);
			} else {
				element = browserWithElementWait.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath(objectProperty)));
				highlightElement(element, webDriver);
			}
		} catch (Exception e) {

		}
		return element;
	}


	/**
	 * will create Screenshot in Screenshot folder and also show filename as
	 * creation date and Time
	 */


	public static void takeScreenShot(String screenshotName) {
		try {
			destDir = "target/screenshots";
			File scrFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
			new File(destDir).mkdirs();
			dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
			String destFile = dateFormat.format(new Date()) + screenshotName + ".png";
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/****************************************************************************
	 * Method : To Verify Login into RxMs application
	 * author : Photon
	 * Date :   11/Jan/ 2017
	 * Modifier : Jeyaprakash
	 * Modification Data : 17/May/2017
	 ******************************************************************************/

	public static boolean isElementPresentVerification(String objectProperty)
			throws AssertionError, Exception {
		try{
			boolean isElementPresent = false;
			List<Object> constantLists = new ArrayList<Object>();
			constantLists.add(new SmokeTestConstants());
			constantLists.add(new AccessManagementConstants());
			constantLists.add(new AssemblyConstants());
			constantLists.add(new ClinicalEvaluationConstants());
			constantLists.add(new DataEntryConstants());
			constantLists.add(new dataReviewConstants());
			constantLists.add(new hangOnConstants());
			constantLists.add(new IntakeConstants());
			constantLists.add(new ProductVerificationConstants());

			String constantName = getConstantName(objectProperty, constantLists);
			isElementPresent = FrameworkLibrary.isElementPresents(objectProperty);
			Assert.assertTrue(isElementPresent, constantName + " with xpath/id: " + objectProperty + " is not visible");
			Thread.sleep(1000);

			return isElementPresent;
		}catch(Exception e){
			throw new Exception(e.getMessage())	;
		}catch(AssertionError e){
			throw new Exception(e.getMessage())	;
		}
	}

	public static String getConstantName(String str, List constantList) throws Exception {

		for (int j = 0; j < constantList.size(); j++) {
			Object constants = constantList.get(j);
			Field[] f = constants.getClass().getFields();
			for (int i = 0; i < f.length; i++) {
				if (f[i].get(constants).toString().equalsIgnoreCase(str)) {
					return f[i].getName();
				}
			}
		}
		return "Constant not found";

	}

	/*
	 * Methods for
	 */

	public static boolean clearAndEnterText(String objectProperty, String Text) {
		boolean isTextEnteredResult = false;
		try {
			log.info(objectProperty);
			log.info("Text Value is=" + Text);
			if ("-".equals(Text)) {
				isTextEnteredResult = true;
			} else {
				WebElement textBox = getElementByProperty(objectProperty,
						chromeDriver);
				textBox.clear();
				Thread.sleep(2000);
				log.info("Text box element=" + textBox);
				textBox.sendKeys(Text);
				isTextEnteredResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return isTextEnteredResult;
	}


	/*
	 * Methods for Highlight the Elements
	 */
	public static void highlightElement(WebElement element, WebDriver webDriver) {
		for (int i = 0; i < 1; i++) {
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "color: red; border: 3px solid red;");
		}
	}

	/*
	 * Methods for
	 */
	public static void browserNavigation_Back() {
		try {
			chromeDriver.navigate().back();
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Methods for
	 */
	public static void refresh_Page() {
		chromeDriver.navigate().refresh();
	}

	/*
	 * Common Method for Click
	 */
	public static boolean isElementPresentVerifyClick(String objectProperty) {
		boolean isVerifiedAndClicked = false;
		browserWithElementWait = new WebDriverWait(chromeDriver, 30);
		try {
			element = getElementByProperty(objectProperty, chromeDriver);
			if (element != null) {
				t1 = System.currentTimeMillis();
				element.click();
				isVerifiedAndClicked = true;
			} else {
				throw new Exception("Object Couldn't be retrieved and clicked");
			}
		} catch (Exception e) {
			element = null;
		}
		return isVerifiedAndClicked;
	}


	/*
	 * Methods for
	 */

	public static void scrollTo(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView();", element);
	}

	/*
	 * Methods for
	 */

	public static Map<String, List<String>> getHorizontalData(
			DataTable dataTable) {
		Map<String, List<String>> dataMap = null;
		try {
			dataMap = new HashMap<String, List<String>>();
			List<String> headingRow = dataTable.raw().get(0);
			int dataTableRowsCount = dataTable.getGherkinRows().size() - 1;
			ArrayList<String> totalRowCount = new ArrayList<String>();
			totalRowCount.add(Integer.toString(dataTableRowsCount));
			dataMap.put("totalRowCount", totalRowCount);
			for (int i = 0; i < headingRow.size(); i++) {
				List<String> dataList = new ArrayList<String>();
				dataMap.put(headingRow.get(i), dataList);
				for (int j = 1; j <= dataTableRowsCount; j++) {
					List<String> dataRow = dataTable.raw().get(j);
					dataList.add(dataRow.get(i));
				}
			}
		} catch (Exception e) {

		}
		return dataMap;
	}

	/*
	 * Methods for
	 */

	public static Map<String, List<String>> getVerticalData(DataTable dataTable) {
		Map<String, List<String>> dataMap = null;
		try {
			int dataTableRowsCount = dataTable.getGherkinRows().size();
			dataMap = new HashMap<String, List<String>>();
			for (int k = 0; k < dataTableRowsCount; k++) {
				List<String> dataRow = dataTable.raw().get(k);
				String key = dataRow.get(0);
				dataRow.remove(0);
				dataMap.put(key, dataRow);
			}
		} catch (Exception e) {

		}
		return dataMap;
	}

	/*
	 * Methods for
	 */

	public static String getXLSTestData(String FileName, String SheetName,
			String RowId, String column) throws IOException {
		FileInputStream file = null;
		String col1 = null;
		DataFormatter df = new DataFormatter();
		String environment = config.getString("env");
		String xlsName = FileName + "_" + environment;
		file = new FileInputStream(new File(
				System.getProperty("user.dir") + "/src/test/resources" + File.separator + xlsName + ".xls"));
		log.info(file);
		HSSFWorkbook book = new HSSFWorkbook(file);
		HSSFSheet sheet = book.getSheet(SheetName);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for (int rowIterator = 1; rowIterator <= rowCount; rowIterator++) {
			String row = sheet.getRow(rowIterator).getCell(0)
					.getStringCellValue();
			if (RowId.equalsIgnoreCase(row)) {
				for (int colIterator = 1; colIterator < sheet.getRow(
						rowIterator).getLastCellNum(); colIterator++) {
					String col = sheet.getRow(0).getCell(colIterator)
							.getStringCellValue();
					if (col.equalsIgnoreCase(column)) {
						Cell cellvalue = sheet.getRow(rowIterator).getCell(
								colIterator);
						col1 = df.formatCellValue(cellvalue);
						break;

					}
				}
			}
		}
		return col1;

	}


	/**
	 * Verify text present for Electron build
	 */
	public static void verifyTextPresentElectron(String objectProperty, String text_to_verify)
			throws Exception {
		String expected = text_to_verify;
		try {
			browserWithElementWait = new WebDriverWait(chromeDriver, watingForElement);
			element = getElementByProperty(objectProperty, chromeDriver);
			String actual = element.getText().trim();
			Assert.assertEquals(expected, actual);
		} catch (Exception e) {
			log.info("Expected text not matched");
		}
	}


	public static void clearTextField(String objectProperty) {
		WebElement textBox = getElementByProperty(objectProperty,
				chromeDriver);
		textBox.clear();

	}


	public static boolean isButtonEnable(String objectProperty)
			throws Exception {
		boolean isElementPresent = false;
		browserWithElementWait = new WebDriverWait(chromeDriver, watingForElement);
		try {
			element = getElementByProperty(objectProperty, chromeDriver);
			if (element != null && element.isEnabled()) {
				isElementPresent = true;
				t2 = System.currentTimeMillis();
			} else {
				isElementPresent = false;
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementPresent;
	}


	public static void TestTabOrder() {

		String[] orderedElementIds = new String[]{"phone-number",
				"npi-dea-state", "first-name", "last-name"};
		log.info("order element id is" + orderedElementIds);
		for (String item : orderedElementIds) {
			String elementId = item;
			log.info("element id is " + elementId);
			element = chromeDriver.switchTo().activeElement();
			log.info("Active Element is = " + element);
			String Ids = element.getAttribute("id");
			log.info("actual attribute id is=" + Ids);
			if (Ids.isEmpty()) {
				throw new NullPointerException(
						"Element does not have expected ID: " + elementId);
			}
			if (!elementId.equalsIgnoreCase(Ids)) {
				throw new AssertionFailedError("Element: " + elementId
						+ " does not have focus.");
			}
			element.sendKeys(Keys.TAB);
		}
	}

	public static void enter_Text(DataTable arg1, int rowNum, String colval, String propval, WebDriver driver) throws Exception {
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			val = getXLSTestData(dataMap.get("InputFileName").get(rowNum), dataMap.get("SheetName").get(rowNum), dataMap.get("RowId").get(rowNum), colval);
			log.info(val);
			if (!clearAndEnterText(propval, val)) {
				throw new Exception("User Not able to Enter" + val + "in TextField");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getData(DataTable arg1, String colval, String propval, WebDriver driver) throws IOException {

		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		val = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), colval);
		log.info(val);
		return val;
	}


	public static boolean isElementPresents(String xPath) {
		try {
			WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
			chromeDriver.findElementByXPath(xPath);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String getElementText(String xPath) {
		WebElement property = FrameworkLibrary.getElementByProperty(xPath, chromeDriver);
		if (property.getText() != null && !property.getText().isEmpty()) {
			return property.getText();
		} else if(property.getAttribute("value") != null && !property.getAttribute("value").isEmpty()){
			return property.getAttribute("value");
		} else {
			return property.getAttribute("innerText");
		}
	}
	
	public static boolean hasElementPresents(String xPath) {
		try{
            chromeDriver.findElementByXPath(xPath);
            return true;
        }
        catch(Exception e){
            return false;
        }
	}

	public static void logoutApp() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isLogin) {
				if (isElementPresentVerification(FrameworkConstants.LOGOUT)) {
					isElementPresentVerifyClick(FrameworkConstants.LOGOUT);
				}
				if (isElementPresentVerification(FrameworkConstants.LOGOUT_THIS_DEVICE)) {
					isElementPresentVerifyClick(FrameworkConstants.LOGOUT_THIS_DEVICE);
				}
				isLogin = false;
				usr_role = "";

			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	// SIT Common methods for Steps


	public static boolean isDRZero() {
		WebElement elementByProperty = FrameworkLibrary.getElementByProperty(FrameworkConstants.DR_CLICK, chromeDriver);
		String text = elementByProperty.getText();
		return !text.startsWith("0");
	}

	public static boolean wait(boolean condition) {
		try {
			if (condition) {
				return true;
			} else {
				Thread.sleep(3000);
				condition = isDRZero();
				wait(condition);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String WaitforElement(String element) {
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
		return element;

	}

	public static void TextAssertion(String objectproperty, String expectedresult) {
		String s = FrameworkLibrary.getElementText(objectproperty);
		try {
			Assert.assertEquals(s, "expectedresult");
		} catch (AssertionError e) {
			log.info("Assertion error");
		}
		log.info("Assertion is done");
	}

	public static void waitForVisibility(String xpath) {
		WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public static void waitForVisibilityAndroid(String xpath) {
		WebDriverWait wait = new WebDriverWait(aDriver, watingForElement);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public static WebElement waitToClick(String xpath) {
		WebDriverWait waitToClick = new WebDriverWait(chromeDriver, watingForElement);
		WebElement element = waitToClick.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		return element;
	}

	public static void initiatePOSApp(String rxno) throws Exception {
		// ChromeDriver Path
		File chromeDriverPath = new File(
				"chromeDriver/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",
				chromeDriverPath.getAbsolutePath());
		driver1 = new ChromeDriver();
		driver1.get(config.getString("posApp_Url"));
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		Select envSelect = new Select(driver1.findElement(By.id("env")));
		Thread.sleep(5000);
		envSelect.selectByVisibleText("Sys1");
		Thread.sleep(5000);
		log.info("Selected environment");
		WebDriverWait wait = new WebDriverWait(driver1, watingForElement);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("store")));
		Select storeSelect = new Select(driver1.findElement(By.id("store")));
		Thread.sleep(5000);
		storeSelect.selectByValue(DataEntryStepDef.storenumber);
		Thread.sleep(5000);
		log.info("Selected store");
		WebElement rxNumber = driver1.findElement(By.xpath("//*[@id='possim']/table/tbody/tr[3]/td[2]/input"));
		rxNumber.sendKeys(rxno);
		driver1.findElement(By.xpath("//*[@id='possim']/table/tbody/tr[9]/td[2]/input[contains(@value,'Run POS Simulator')]")).click();
		log.info("Clicked on Run POS Simulator button");
		Thread.sleep(5000);
		driver1.quit();
	}

	public static boolean isElementPresentbyClassname(String className) {
		try {
			WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
			wait.until(ExpectedConditions.visibilityOf(chromeDriver.findElement(By.className(className))));

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static WebElement waitToClickByClassName(String className) {
		WebDriverWait waitToClick = new WebDriverWait(chromeDriver, watingForElement);
		WebElement element = waitToClick.until(ExpectedConditions.elementToBeClickable(By.className(className)));
		return element;
	}


	public static void initiateBrowser() throws ConfigurationException,
	IOException, InterruptedException {
		try {

			//if (chromeDriver == null) {
			if (config.getString("breakPoint").equalsIgnoreCase("Desktop")) {
				log.info(" Launching RxMs Application ");
				Collection<String> tagNames = scenario.getSourceTagNames();
				tagName = tagNames.iterator().next();
				if(tagNames.contains("@RxMSSOLD")) {
					tagName = "@RxMSSOLD";
				} else if(tagNames.contains("@Perf_IkariWarriors")) {
					tagName = "@Perf_IkariWarriors";
				}
				loadReportFile(workflowSheet, tagName);
				Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
				String environment = config.getString("env");
				String baseFolder = config.getString("baseFolder");
				String appFolder = config.getString("appFolder");
				String filePath = baseFolder + environment + "-UI" + appFolder;
				dasboardURL = "file:///C:/UIExtract/" + environment + "-UI/rxApp-win32-ia32/resources/app/index.html#/main";
				intakeURL = "file:///C:/UIExtract/" + environment + "-UI/rxApp-win32-ia32/resources/app/index.html#/patient/patient-common/00000000011/11/2";
				pat_serach_results = "file:///C:/UIExtract/" + environment + "-UI/rxApp-win32-ia32/resources/app/index.html#/patient";
				drug_search_results = "file:///C:/UIExtract/" + environment + "-UI/rxApp-win32-ia32/resources/app/index.html#/drug/druglist";
				File pmsAppPath = null;
				if (config.getString("execution_On").equalsIgnoreCase("Server")) {
					File exePath = new File(filePath);
					File[] listFiles = exePath.listFiles();
					for (File file : listFiles) {
						if (file.exists() && file.getAbsolutePath().endsWith(".exe")) {
							pmsAppPath = file;
						}
					}
				} else if (config.getString("execution_On").equalsIgnoreCase("local")) {
					pmsAppPath = new File(config.getString("applicationURL"));
				} else {
					log.error(" Execution mode is not enable in Application properties file ");
				}
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("app", pmsAppPath.getAbsolutePath());
				capabilities.setCapability("debugConnectToRunningApp", true);
				File chromeDriverPath = new File("chromeDriver/chromedriver.exe");
				System.setProperty("webdriver.chrome.driver",chromeDriverPath.getAbsolutePath());
				ChromeOptions options = new ChromeOptions();
				options.setBinary(pmsAppPath.getAbsolutePath());
				DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
				chromeCapabilities.setCapability("app",pmsAppPath.getAbsolutePath());
				chromeCapabilities.setCapability("chrome.binary",pmsAppPath.getAbsolutePath());
				chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
				Set<CaptureType> captureTypes = new HashSet<CaptureType>();
				captureTypes.add(CaptureType.REQUEST_BINARY_CONTENT);
				captureTypes.add(CaptureType.REQUEST_CONTENT);
				captureTypes.add(CaptureType.REQUEST_COOKIES);
				captureTypes.add(CaptureType.REQUEST_HEADERS);
				captureTypes.add(CaptureType.RESPONSE_BINARY_CONTENT);
				captureTypes.add(CaptureType.RESPONSE_CONTENT);
				captureTypes.add(CaptureType.RESPONSE_COOKIES);
				captureTypes.add(CaptureType.RESPONSE_HEADERS);
				proxy.enableHarCaptureTypes(captureTypes);
				chromeCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				chromeCapabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
				proxy.newHar(); 
				chromeDriver = new ChromeDriver(chromeCapabilities);
				waitForVisibility(SmokeTestConstants.Login_Button);
				writeHarFile(workingFolder, "AppLaunch", row.getRowNum(), 1);
				HSSFCell cell = row.createCell(0); 
				cell.setCellValue(row.getRowNum());
				chromeDriver.manage().timeouts().implicitlyWait(watingForElement, TimeUnit.SECONDS);
			}
			//	}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/************************************Android Device Common Method***********************************************/


	/**
	 * will create Screenshot for Android in Screenshot folder and also show filename as
	 * creation date and Time
	 */

	public static void takeScreenShotAndroid(String screenshotName) {
		/*try {
			destDir = "target/screenshots";
			File scrFile = ((TakesScreenshot) aDriver).getScreenshotAs(OutputType.FILE);
			new File(destDir).mkdirs();
			dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
			String destFile = dateFormat.format(new Date()) + screenshotName + ".png";
			FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

	public static boolean isElementPresentVerificationAndroid(String objectProperty)
			throws AssertionError, Exception {
		try {
			boolean isElementPresent = false;
			List<Object> constantLists = new ArrayList<Object>();
			constantLists.add(new AssemblyConstants());
			String constantName = getConstantName(objectProperty, constantLists);
			isElementPresent = FrameworkLibrary.isElementPresentsAndriod(objectProperty);
			Assert.assertTrue(isElementPresent, constantName + " with xpath/id: " + objectProperty + " is not visible");
			Thread.sleep(1000);
			return isElementPresent;
		}catch(Exception e){
			throw new Exception(e.getMessage())	;
		}catch(AssertionError e){
			throw new Exception(e.getMessage())	;
		}	
	}

	public static boolean isElementPresentsAndriod(String xPath) {
		try {
			WebDriverWait wait = new WebDriverWait(aDriver, watingForElement);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
			aDriver.findElementByXPath(xPath);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean clearAndEnterTextForAndroid(String objectProperty, String Text) {
		boolean isTextEnteredResult = false;
		try {
			log.info(objectProperty);
			log.info("Text Value is=" + Text);
			if ("-".equals(Text)) {
				// ignore this field
				isTextEnteredResult = true;
			} else {
				WebElement textBox = getElementByProperty(objectProperty,
						aDriver);
				textBox.clear();
				Thread.sleep(2000);
				log.info("Text box element=" + textBox);
				textBox.sendKeys(Text);
				isTextEnteredResult = true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return isTextEnteredResult;
	}
	
	/**
     * Function written to get text on devices and return Text as String 
     * call this function according to your need
     */

	
	public static String getNDCNumber(String object) throws Exception {
        String ndcNo = null;
        try {
            WebElement ndc=aDriver.findElement(By.xpath(object));
            ndcNo = ndc.getText().trim();
        } catch (Exception e) {
        }
        return ndcNo;
    }


	/**
	 * android devices
	 */

	public static void verifyTextPresentAndroid(String objectProperty, String text_to_verify)
			throws Exception {
		String expected = text_to_verify;
		try {
			browserWithElementWait = new WebDriverWait(aDriver, watingForElement);
			element = getElementByProperty(objectProperty, aDriver);
			String actual = element.getText();
			Assert.assertEquals(expected, actual);
		} catch (Exception e) {
			log.info("Expected text not matched");
		}
	}


	/**
	 * Function written to switch Native to Web View to pass the parameter wherever you want to
	 * call this function according to your need
	 */
	public static void android_switchWebView(String view) throws Exception {
		Set<String> availableContexts = aDriver.getContextHandles();
		log.info("Total No of Context Found After we reach to WebView = " + availableContexts.toString());
		for (String context : availableContexts) {
			if (context.contains(view)) {
				log.info("Context Name is " + context);
				aDriver.context(context);
				//break;
			}
		}
	}

	public static void scrollFrom(String objectProperty) {

		element = getElementByProperty(objectProperty, aDriver);
		int topY = element.getLocation().getY();
		int bottomY = topY + element.getSize().getHeight();
		int centerX = element.getLocation().getX()
				+ (element.getSize().getWidth() / 2);
		aDriver.swipe(centerX, bottomY, centerX, topY, 2000);

	}


	public static void verticalScroll() {
		size = aDriver.manage().window().getSize();
		int y_start = (int) (size.height * 0.60);
		int y_end = (int) (size.height * 0.30);
		int x = size.width / 2;
		aDriver.swipe(x, y_start, x, y_end, 4000);
	}

	public static boolean isElementPresentAndroid(String objectProperty)
			throws Exception {
		boolean isElementPresent = false;
		browserWithElementWait = new WebDriverWait(aDriver, watingForElement);
		try {
			element = getElementByProperty(objectProperty, aDriver);
			if (element != null) {
				isElementPresent = true;
				t2 = System.currentTimeMillis();
			} else {
				throw new Exception("Object Couldn't be retrieved and verified");
			}
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementPresent;
	}

	/*
	 * Common Method for device Click
	 */
	public static boolean isElementVerifyclickAndroid(String objectProperty) {
		boolean isVerifiedAndClicked = false;
		browserWithElementWait = new WebDriverWait(aDriver, watingForElement);
		try {
			element = getElementByProperty(objectProperty, aDriver);
			if (element != null) {
				t1 = System.currentTimeMillis();
				element.click();
				isVerifiedAndClicked = true;
			} else {
				throw new Exception("Object Couldn't be retrieved and clicked");
			}
		} catch (Exception e) {
			element = null;
		}
		return isVerifiedAndClicked;
	}


	/*******************************************************************************************************/



	public static void patientSearch(DataTable dataTable, int rowNum) throws InterruptedException, Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			FrameworkLibrary.isElementPresentVerifyClick(FrameworkConstants.PATIENT_SEARCH);
			Thread.sleep(1000);
			enter_Text(dataTable, rowNum, "LastName", FrameworkConstants.PATIENT_SEARCH_LN, chromeDriver);
			enter_Text(dataTable, rowNum, "FirstName", FrameworkConstants.PATIENT_SEARCH_FN, chromeDriver);
			FrameworkLibrary.isElementPresentVerifyClick(FrameworkConstants.PATIENT_SEARCH_BTN);
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	public static void selectAndViewPatient() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			FrameworkLibrary.isElementPresentVerifyClick(FrameworkConstants.SELECT_PATIENT);
			Thread.sleep(1000);
			FrameworkLibrary.isElementPresentVerifyClick(FrameworkConstants.PATIENT_VIEW_BTN);
			Thread.sleep(1000);
			DE_NumberOfTasksBeforeIntake = Integer.parseInt(FrameworkLibrary.getElementText(FrameworkConstants.DENumberofTasks));
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	public static void clickIntake() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			FrameworkLibrary.isElementPresentVerifyClick(FrameworkConstants.INTAKE_RX_BTN);
			Thread.sleep(1000);
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	public static void searchPrescribers(DataTable dataTable, int rowNum) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(2000);
			enter_Text(dataTable, rowNum, "LastName", FrameworkConstants.PRESCRIBER_LN, chromeDriver);
			enter_Text(dataTable, rowNum, "LastName", FrameworkConstants.PRESCRIBER_FN, chromeDriver);
			Thread.sleep(2000);
			FrameworkLibrary.isElementPresentVerifyClick(FrameworkConstants.PRESCRIBER_SEARCH_BTN);
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	public static void selectPrescriber() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(2000);
			FrameworkLibrary.isElementPresentVerifyClick(FrameworkConstants.SELECT_PRESCRIBER_BTN);
			Thread.sleep(2000);
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	public static void enterProductDetails(DataTable dataTable, int rowNum) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			FrameworkLibrary.isElementPresentVerifyClick(FrameworkConstants.Open_Product);
			Thread.sleep(2000);
			FrameworkLibrary.enter_Text(dataTable, 0, "Date", FrameworkConstants.Product_OriginalDate, chromeDriver);
			FrameworkLibrary.enter_Text(dataTable, 0, "DAW", FrameworkConstants.Product_DAW, chromeDriver);
			FrameworkLibrary.enter_Text(dataTable, 0, "DrugName", FrameworkConstants.DrugName_Field, chromeDriver);
			Thread.sleep(2000);

			Actions upArrow = new Actions(chromeDriver);
			Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
			PressUpArrow.perform();
			Thread.sleep(1000);
			FrameworkLibrary.enter_Text(dataTable, 0, "Quantity", FrameworkConstants.Quantity_field, chromeDriver);
			FrameworkLibrary.enter_Text(dataTable, 0, "QuantityDisp", FrameworkConstants.Quantity_disp, chromeDriver);
			FrameworkLibrary.enter_Text(dataTable, 0, "Directions", FrameworkConstants.Directions_field, chromeDriver);
			FrameworkLibrary.enter_Text(dataTable, 0, "DaysSupply", FrameworkConstants.Days_Supply, chromeDriver);
			FrameworkLibrary.enter_Text(dataTable, 0, "Refills", FrameworkConstants.Refills_field, chromeDriver);
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	public static void enterPaymentAndFinishDE() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(1000);
			FrameworkLibrary.isElementPresentVerifyClick(FrameworkConstants.OPEN_PAYMENT);
			FrameworkLibrary.isElementPresentVerifyClick(FrameworkConstants.PAYMENT_DROPDOWN);
			FrameworkLibrary.isElementPresentVerifyClick(FrameworkConstants.CASH_OPTION);
			Thread.sleep(1000);
			DR_NumberOfTasksBeforeDE = Integer.parseInt(getElementText(FrameworkConstants.DR_CLICK));
			FrameworkLibrary.isElementPresentVerifyClick(FrameworkConstants.DE_FINISH);
			Thread.sleep(3000);
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	public static void login(DataTable dataTable, int rowNum, String role) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isLogin == false) {
				if (isElementPresentVerification(SmokeTestConstants.userName)) {
					enter_Text(dataTable, rowNum, "UserName", SmokeTestConstants.userName, chromeDriver);
				}
				if (isElementPresentVerification(SmokeTestConstants.password)) {
					enter_Text(dataTable, rowNum, "Password", SmokeTestConstants.password, chromeDriver);
				}
				if (isElementPresentVerification(SmokeTestConstants.Login_Button)) {
					if (!isElementPresentVerifyClick(SmokeTestConstants.Login_Button)) {
						throw new Exception("Not able to click login button");
					}
				}
				if (!isElementPresentVerification(SmokeTestConstants.RxMSHome_PharmacyInformationCard)) {
					throw new Exception("Not able to view RxMSHome_Pharmacy Information Card ");
				}
				Assert.assertTrue(isElementPresents(SmokeTestConstants.RxMSHome_PharmacyInformationCard), "RxMS homepage is not displayed");
				Thread.sleep(3000);
				usr_role = role;
				isLogin = true;

			} else if (!(role.equalsIgnoreCase(usr_role))) {
				logoutApp();
				Thread.sleep(3000);
				FrameworkLibrary.login(dataTable, rowNum, role);
			}

		} catch (AssertionError e) {
			isLogin = false;
			SmokeTestLibrary.quitRxmsApp();
			Thread.sleep(9000);
			chromeDriver = null;
			Assert.fail("RXMS home page not displayed");

		} catch (Exception e) {
			e.printStackTrace();
			isLogin = false;
			SmokeTestLibrary.quitRxmsApp();
			Thread.sleep(9000);
			chromeDriver = null;
			Assert.fail("Application failed to login");

		}

	}


	public static void navigateToHomePage() throws Exception {

		try {
			if (!(chromeDriver.getCurrentUrl().toString().equalsIgnoreCase(dasboardURL))) {
				log.info("Printing dashboard URL:" + dasboardURL);
				Thread.sleep(3000);
				if (!isElementPresentVerifyClick(hangOnConstants.RXMS_HOME_PAGE)) {
					SmokeTestLibrary.hotkeyAction(Keys.ALT, "Y", chromeDriver);
					if (!(isElementPresentVerifyClick(hangOnConstants.RXMS_HOME_PAGE))) {
						SmokeTestLibrary.hotkeyAction(Keys.ALT, "O", chromeDriver);
						if (!(isElementPresentVerifyClick(hangOnConstants.RXMS_HOME_PAGE))) {
							SmokeTestLibrary.hotkeyAction(Keys.ALT, "C", chromeDriver);
							Assert.assertTrue(isElementPresentVerifyClick(hangOnConstants.RXMS_HOME_PAGE));
						}
					}
				}
			} else if (chromeDriver.getWindowHandles().size() > 1) {
				chromeDriver.close();
				if (chromeDriver == null)
					Assert.fail("not able to navigate to Home Page, as two windows are opened");
				else
					navigateToHomePage();
			} else if (chromeDriver.getCurrentUrl().toString().equalsIgnoreCase(intakeURL)) {
				Assert.assertTrue(isElementPresentVerifyClick(hangOnConstants.INTAKE_CLOSE_BUT),
						"Intake window not closed");
				navigateToHomePage();
			}
		} catch (Exception e) {
			SmokeTestLibrary.quitRxmsApp();
			e.printStackTrace();
			Assert.fail("Unable to navigate to Home Page");
		}
	}


	public static void navigateToPatientSearch() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			navigateToHomePage();
			Thread.sleep(3000);
			isElementPresentVerifyClick(SmokeTestConstants.Patient_LeftMenuButton);
			Thread.sleep(2000);
			waitToClick(SmokeTestConstants.Patient_SearchButton);
			log.info("Patient search form is displayed");
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	public static void navigateToDrugSearch() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			navigateToHomePage();
			Thread.sleep(3000);
			waitToClick(SmokeTestConstants.drug_LeftMenuButton);
			FrameworkLibrary.isElementPresentVerifyClick(SmokeTestConstants.drug_LeftMenuButton);
			waitToClick(IntakeConstants.Drug_search_button);
			log.info("Drug Search Form is displayed");
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}


	public static void navigateToPlanSearch() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			navigateToHomePage();
			waitToClick(SmokeTestConstants.plan_LeftMenuButton);
			FrameworkLibrary.isElementPresentVerifyClick(SmokeTestConstants.plan_LeftMenuButton);
			Thread.sleep(2000);
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}


	public static void navigateToPrescriberSearch() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			navigateToHomePage();
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.CONTROL).sendKeys("r").keyUp(Keys.CONTROL).build();
			series.perform();
			Assert.assertTrue(isElementPresents(IntakeConstants.PRESCRIBER_SEARCH_PAGE_DISPLAY),
					"Prescriber search page is not displayed");
			WebDriverWait wait = new WebDriverWait(chromeDriver, 30);
			WebElement element = FrameworkLibrary.getElementByProperty(IntakeConstants.PRESCRIBER_SEARCH_FIRST_NAME,
					chromeDriver);
			wait.until(ExpectedConditions.visibilityOf(element));
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	public static void navigateToDataEntry(DataTable arg1, int x) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			navigateToHomePage();
			navigateToPatientSearch();
			enter_Text(arg1, 0, "LastName", FrameworkConstants.PATIENT_SEARCH_LN, chromeDriver);
			enter_Text(arg1, 0, "FirstName", FrameworkConstants.PATIENT_SEARCH_FN, chromeDriver);
			FrameworkLibrary.isElementPresentVerifyClick(FrameworkConstants.PATIENT_SEARCH_BTN);
			selectAndViewPatient();
			clickIntake();
			SmokeTestStepDef.clicks_Finish_button_in_intake_method_screen();
			SmokeTestStepDef.i_navigate_to_patient_order_status();
			SmokeTestStepDef.i_enter_patient_last_name_in_POS_last_name_text_box(arg1);
			SmokeTestStepDef.i_enter_patient_phone_number_in_POS_phone_number_text_box(arg1);
			Thread.sleep(5000);
			waitToClick(SmokeTestConstants.patientOrderStatus_patientSearchButton).click();
			SmokeTestStepDef.the_prescription_status_should_be_clicked(arg1);
			SmokeTestStepDef.system_displays_a_donut_chart();
			isElementPresentVerifyClick(SmokeTestConstants.POS_DE_HyperLink);
			SmokeTestStepDef.sytem_should_display_data_entry_page();
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}


	public static void navigateToDataReview(DataTable arg1, int x[]) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			navigateToDataEntry(arg1, x[0]);
			searchPrescribers(arg1, 1);
			selectPrescriber();
			enterProductDetails(arg1, 2);
			enterPaymentAndFinishDE();
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	public static void sendKeys(String textValue) {
		try {
			for (int i = 0; i < textValue.length(); i++) {
				Actions ac = new Actions(chromeDriver);
				ac = ac.sendKeys("");
				// Action series = ac.keyDown(Keys.ALT).sendKeys("o").keyUp(Keys.ALT).build();
				//series.perform();
				chromeDriver.findElement(By.name("" + textValue.charAt(i))).click();
				Thread.sleep(200);
			}
		} catch (Exception e) {
			log.error("Exception " + e);
		}
	}
	
	
	public static boolean waitForTwoXpathCE(boolean condition, String xPath1, String xPath2) {
		if(condition) {
			return true;
		} else {
			condition = hasElementPresents(xPath1);
			if (!condition) {
				condition = hasElementPresents(xPath2);
			}
			waitForTwoXpathCE(condition, xPath1, xPath2);
		}
		return false;
	}



	/****************************************************************************
	 * Method : To generating random name
	 * author : Jeyaprakash K
	 * Date : June / 28 / 2017
	 ******************************************************************************/

	public static String randomFirstNameGenerator() throws Exception {
		String firstName = null;
		try {
			final String BaseNameString = "abcdefghijklmnopqrstuvwxyz";
			final java.util.Random rand = new java.util.Random();
			final Set<String> identifiers = new HashSet<String>();
			StringBuilder namebuilder = new StringBuilder();
			while (namebuilder.toString().length() == 0) {
				int length = rand.nextInt(2) + 5;
				for (int i = 0; i < length; i++) {
					namebuilder.append(BaseNameString.charAt(rand.nextInt(BaseNameString.length())));
				}
				if (identifiers.contains(namebuilder.toString())) {
					namebuilder = new StringBuilder();
				}
			}
			firstName = namebuilder.toString();

		} catch (Exception e) {
			log.error("Exception is :" + e);
		}
		return firstName;
	}

	public static String randomLastNameGenerator() throws Exception {
		String lastName = null;
		try {
			final String BaseNameString = "abcdefghijklmnopqrstuvwxyz";
			final java.util.Random rand = new java.util.Random();
			final Set<String> identifiers = new HashSet<String>();
			StringBuilder namebuilder = new StringBuilder();
			while (namebuilder.toString().length() == 0) {
				int length = rand.nextInt(2) + 5;
				for (int i = 0; i < length; i++) {
					namebuilder.append(BaseNameString.charAt(rand.nextInt(BaseNameString.length())));
				}
				if (identifiers.contains(namebuilder.toString())) {
					namebuilder = new StringBuilder();
				}
			}
			lastName = namebuilder.toString();

		} catch (Exception e) {
			log.error("Exception is :" + e);
		}
		return lastName;
	}

	/****************************************************************************
	 * Method : To generating random Phone number
	 * author : Jeyaprakash K
	 * Date : June / 28 / 2017
	 ******************************************************************************/

	public static String randomPhoneNumberGenerator() throws Exception {
		String phone = null;
		try {
			final String BasePhoneNumberString = "9876543210";
			final java.util.Random rand = new java.util.Random();
			final Set<String> identifiers = new HashSet<String>();
			StringBuilder phonebuilder = new StringBuilder();
			while (phonebuilder.toString().length() == 0) {
				for (int i = 0; i < 10; i++) {
					phonebuilder.append(BasePhoneNumberString.charAt(rand.nextInt(BasePhoneNumberString.length())));
				}
				if (identifiers.contains(phonebuilder.toString())) {
					phonebuilder = new StringBuilder();
				}
			}
			phone = phonebuilder.toString();
			if (phone.startsWith("0")) {
				phone = phone.replaceFirst("0", "5");
			}
			if (phone.length() < 10) {
				for (int apndInc = 0; apndInc < (10 - phone.length()); apndInc++) {
					phone = phone + "0";
				}
			}
			String phNumber1 = phone.substring(0, 3);
			String phNumber2 = phone.substring(3, 6);
			String phNumber3 = phone.substring(6,10);
			String phNumber = "("+phNumber1+")";
			phone = phNumber +" "+ phNumber2+"-"+phNumber3;
		} catch (Exception e) {
			log.error("Exception is :" + e);
		}
		return phone;
	}


	/****************************************************************************
	 * Method : To generating random DOB
	 * author : Jeyaprakash K
	 * Date : June / 28 / 2017
	 ******************************************************************************/

	public static String randomDOBGenerator() throws Exception {
		String date = null;
		String month = null;
		String year = null;
		String dob = null;
		try {
			final java.util.Random rand = new java.util.Random();
			date = Integer.toString(rand.nextInt(3)) + Integer.toString(rand.nextInt(8));
			month = Integer.toString(rand.nextInt(2)) + Integer.toString(rand.nextInt(3));
			year = "19" + Integer.toString(rand.nextInt(9)) + Integer.toString(rand.nextInt(9));
			if (date.equals("00")) {
				date = "01";
			}
			if (month.equals("00")) {
				month = "10";
			}
			dob = month + "/" + date + "/" + year;
		} catch (Exception e) {
			log.error("Exception is :" + e);
		}
		return dob;
	}



	/****************************************************************************
	 * Method : To generating random Email
	 * author : Jeyaprakash K
	 * Date : June / 28 / June
	 ******************************************************************************/

	public static String randomEmailGenerator() throws Exception {
		String emailAddress = null;
		try {
			Calendar cal = Calendar.getInstance();
			String timeinmills = Long.toString(cal.getTimeInMillis());
			emailAddress = randomFirstNameGenerator() + "_" + timeinmills + "@testebiz.com";
		} catch (Exception e) {
			log.error("Exception is :" + e);
		}
		return emailAddress;
	}







}


