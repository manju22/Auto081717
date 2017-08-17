package smokeTest;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import dataReview.dataReviewConstants;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import accessManagment.AccessManagementConstants;
import clinicalEvaluation.ClinicalEvaluationConstants;
import clinicalEvaluation.ClinicalEvaluationLibrary;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataEntry.DataEntryConstants;
import framework.ConnectionFactory;
import framework.FrameworkConstants;
import framework.FrameworkLibrary;
import intake.IntakeConstants;
import intake.IntakeStepDef;
import productVerification.ProductVerificationConstants;


public class SmokeTestStepDef extends FrameworkLibrary {

	public static int DE_NumberOfTasksBeforeIntake;
	public static int DR_NumberOfTasksBeforeDE;
	public static int NumberOfFillingTasks;
	public static int NumberofCETasksBeforeDR;
	public static String IntakeDate;
	public static String intakenextdate;
	public static String currentPickupTime;
	public static String possiblePickupTime;
	public static int ActualDE_NumberOfTasksAfterIntake;
	public static String ExpectedProductName;
	public static String ExpectedDirections;
	public static String ExpectedProduct_quantity;
	public static String ExpectedProduct_quantityDisp;
	public static String ExpectedProduct_DaysSupply;
	public static String ExpectedProduct_refills;
	public static String ExpectedProduct_RxExpDate;
	public static String ExpectedProduct_DAW;
	public static String ExpectedProduct_DrugExpDate;
	public static String ExpectedProduct_OriginalDate;
	public static String dynamicrxnum;
	public static int actualNumberofFillingTasksAfterCompletingCE;
	public static String dispensedDruginDE;
	public static WebElement CurrentPrescriptionRow;
	private static Log log = LogFactory.getLog(SmokeTestStepDef.class);
	public static String lastName;
	public static String firstName;
	public static String phoneNumber;
	public static String patientDOB;
	private static String methodName;
	public static WebElement RxnumberHyperlink;

	public SmokeTestStepDef() throws ConfigurationException, IOException {
		super();
	}
	
	@Before
	public void getScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification  :
	 ******************************************************************************/

	@When("^clicks Finish button in intake method screen$")
	public static void clicks_Finish_button_in_intake_method_screen() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(DataEntryConstants.IMAGE_DE_FINISH_SCREEN_FRONT_BUTTON)) {
				throw new Exception("Not able to click IMAGE_DE_FINISH_SCREEN_FRONT_BUTTON");
			}
			if (!isElementPresentVerification(DataEntryConstants.IMAGE_DE_FINISH_SCREEN_BACK_BUTTON)) {
				throw new Exception("Not able to click IMAGE_DE_FINISH_SCREEN_BACK_BUTTON");
			}
			if (isElementPresentVerification(SmokeTestConstants.Rx_FinishButton)) {
				proxy.newHar();
				if (!isElementPresentVerifyClick(SmokeTestConstants.Rx_FinishButton)) {
					throw new Exception("Not able to click Rx_FinishButton");
				}
				waitForVisibility(SmokeTestConstants.RxMSHome_Store_Number);
				boolean contains = scenario.getSourceTagNames().contains("@RxMSSOLD");
				if (contains) {
					writeHarFile(workingFolder, "IntakeFinish", row.getRowNum(), 6);
				}
			}
			Date today = Calendar.getInstance().getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd");
			SimpleDateFormat formatter2 = new SimpleDateFormat("h:mm a");
			IntakeDate = formatter.format(today);
			Calendar cal3 = Calendar.getInstance();
			cal3.setTime(formatter.parse(IntakeDate));
			cal3.add(Calendar.DATE, 1);
			intakenextdate = formatter.format(cal3.getTime());
			Calendar cal = Calendar.getInstance();
			cal.setTime(today);
			cal.add(Calendar.MINUTE, 15);
			currentPickupTime = formatter2.format(cal.getTime());
			cal.add(Calendar.MINUTE, 1);
			possiblePickupTime = formatter2.format(cal.getTime());
			log.info(currentPickupTime + "or" + possiblePickupTime);
			log.info(IntakeDate);

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^A DR task should be created$")
	public static void DR_task_creation() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			boolean drZero = SmokeTestLibrary.isDRZero();
			SmokeTestLibrary.wait(drZero);
			int expectedDR_NumberOfTasksAfterDE = DR_NumberOfTasksBeforeDE + 1;
			String expectedDRTasksAfterDE = Integer.toString(expectedDR_NumberOfTasksAfterDE);
			WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
			wait.until(ExpectedConditions.textToBePresentInElement(getElementByProperty(SmokeTestConstants.DRNumberofTasks, chromeDriver), expectedDRTasksAfterDE));
			int actualDR_NumberOfTasksAfterDE = Integer.parseInt(getElementText(SmokeTestConstants.DRNumberofTasks));
			Assert.assertEquals(actualDR_NumberOfTasksAfterDE, expectedDR_NumberOfTasksAfterDE, "DR task is not created");
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}

	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User validates patient data$")
	public static void validate_patient_data(DataTable patient) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			isElementPresentVerification(SmokeTestConstants.DR_PatientName);
			String expFirstName = SmokeTestLibrary.getData(patient, "FirstName");
			String expLastName = SmokeTestLibrary.getData(patient, "LastName");
			String expectedPatientName = expFirstName + "," + expLastName;
			String actualPatientName = getElementText(SmokeTestConstants.DR_PatientName);
			Assert.assertTrue(expectedPatientName.equalsIgnoreCase(actualPatientName));
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User validates prescriber data$")
	public static void validate_prescriber_data(DataTable prescriber) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String expectedFirstName = SmokeTestLibrary.getData(prescriber, "FirstName");
			String expectedLastName = SmokeTestLibrary.getData(prescriber, "LastName");
			String expectedPrescriberName = expectedLastName + ", " + expectedFirstName;
			String ActualprescriberData = getElementText(SmokeTestConstants.DR_PrescriberField);
			Assert.assertTrue(ActualprescriberData.toUpperCase().contains(expectedPrescriberName.toUpperCase()));

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User validates product data$")
	public static void validate_product_data(DataTable drug) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String ActualProductName = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DR_ProductName, chromeDriver).getAttribute("value");
			String ActualProduct_RxExpDate = FrameworkLibrary.getElementByProperty(SmokeTestConstants.RxExpiration_date, chromeDriver).getAttribute("value");
			String ActualProduct_DAW = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Product_DAW, chromeDriver).getAttribute("value");
			String ActualProduct_DrugExpDate = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DrugExpiryDate_Field, chromeDriver).getAttribute("value");
			String ActualProduct_OriginalDate = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Product_OriginalDate, chromeDriver).getAttribute("value");
			String ActualProduct_quantity = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Quantity_field, chromeDriver).getAttribute("value");
			String ActualProduct_quantityDisp = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Quantity_disp, chromeDriver).getAttribute("value");
			String ActualDirections = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DR_ProductDirections, chromeDriver).getAttribute("value");

			Assert.assertEquals(ActualProductName, ExpectedProductName);
			Assert.assertEquals(ActualProduct_RxExpDate, ExpectedProduct_RxExpDate);
			Assert.assertEquals(ActualProduct_DAW, ExpectedProduct_DAW);
			Assert.assertEquals(ActualProduct_DrugExpDate, ExpectedProduct_DrugExpDate);
			Assert.assertEquals(ActualProduct_OriginalDate, ExpectedProduct_OriginalDate);
			Assert.assertEquals(ActualDirections, ExpectedDirections);
			Assert.assertEquals(ActualProduct_quantity, ExpectedProduct_quantity);
			Assert.assertEquals(ActualProduct_quantityDisp, ExpectedProduct_quantityDisp);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}

	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should display an alert message asking for this device or all devices$")
	public static void logout_popup() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Assert.assertTrue(SmokeTestLibrary.isLogoutAlertPresent());
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should display the login page$")
	public static void system_should_display_the_login_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.userName)) {
				Assert.assertTrue(isElementPresents(SmokeTestConstants.login_card), "Login page is not displayed");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should display RxMS home page$")
	public static void system_should_display_RxMS_home_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.RxMSHome_PharmacyInformationCard)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.RxMSHome_PharmacyInformationCard), "RxMS homepage is not displayed");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should navigate to patient search page$")
	public static void system_should_navigate_to_patient_search_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(SmokeTestConstants.Patient_SearchButton)) {
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^Sytem should display data entry page$")
	public static void sytem_should_display_data_entry_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.DataEntryPageTitle)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.DataEntryPageTitle), "Data Entry page is not displayed");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should display data review page$")
	public static void system_should_display_data_review_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.DataReviewPageTitle)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.DataReviewPageTitle));
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should display patient order status page$")
	public static void system_should_display_patient_order_status_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.patientOrderStatusPageTitle)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.patientOrderStatusPageTitle));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should display drug search page$")
	public static void system_should_display_drug_search_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.drugSearchPageTitle)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.drugSearchPageTitle));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should display plan search page$")
	public static void system_should_display_plan_search_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.planSearchPageTitle)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.planSearchPageTitle));
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should display prescriber search page$")
	public static void system_should_display_prescriber_search_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.prescriberSearchPageTitle)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.prescriberSearchPageTitle));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^The pending link for current prescription should be clicked$")
	public static void the_prescription_status_should_be_clicked(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(5000);
			i_click_search_button_on_patient_order_status();
			Thread.sleep(5000);
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
			String expintakeDate = SmokeTestStepDef.intakenextdate;
			//List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[td[md-icon[@aria-hidden='false']]]"));
			List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));
			log.info(elements.size());
			for (int i = elements.size() - 1; i >= 0; i--) {

				if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(possiblepickupTime1)) {
					int pendinglinkColumn = 5;
					if (i == 0) {
						pendinglinkColumn++;
					}

					log.info(elements.get(i).getText());
					String dyn = elements.get(i).getAttribute("id");
					String[] dynamo = dyn.split("-");
					String part1 = dynamo[1];
					String part2 = dynamo[2];
					String pendinglink = "//tr[@id='patient-" + part1 + "-" + part2 + "']/td[" + pendinglinkColumn + "]/a";
					Assert.assertTrue(isElementPresentVerification(pendinglink));
					Assert.assertTrue(elements.get(i).getText().toUpperCase().contains("PENDING"));
					getElementByProperty(pendinglink, chromeDriver).click();
					break;
				} else if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(pickuptime)) {
					int pendinglinkColumn = 5;
					if (i == 0) {
						pendinglinkColumn++;
					}
					log.info(elements.get(i).getText());
					String dyn = elements.get(i).getAttribute("id");
					String[] dynamo = dyn.split("-");
					String part1 = dynamo[1];
					String part2 = dynamo[2];
					String pendinglink = "//tr[@id='patient-" + part1 + "-" + part2 + "']/td[" + pendinglinkColumn + "]/a";
					Assert.assertTrue(isElementPresentVerification(pendinglink));
					Assert.assertTrue(elements.get(i).getText().toUpperCase().contains("PENDING"));
					getElementByProperty(pendinglink, chromeDriver).click();
					break;
				} else if (elements.get(i).getText().contains(expintakeDate) && elements.get(i).getText().contains(possiblepickupTime1)) {
					int pendinglinkColumn = 5;
					if (i == 0) {
						pendinglinkColumn++;
					}
					log.info(elements.get(i).getText());
					String dyn = elements.get(i).getAttribute("id");
					String[] dynamo = dyn.split("-");
					String part1 = dynamo[1];
					String part2 = dynamo[2];
					String pendinglink = "//tr[@id='patient-" + part1 + "-" + part2 + "']/td[" + pendinglinkColumn + "]/a";
					Assert.assertTrue(isElementPresentVerification(pendinglink));
					Assert.assertTrue(elements.get(i).getText().toUpperCase().contains("PENDING"));
					getElementByProperty(pendinglink, chromeDriver).click();
					break;
				} else {
					log.info("The" + i + "prescription is not current");
					if (i == 0) {
						Assert.fail("prescription not found.");
					}
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/
	@Then("^System displays a donut chart$")
	public static void system_displays_a_donut_chart() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.POS_DonutChart)) {
				Assert.assertTrue(isElementPresents(SmokeTestConstants.POS_DonutChart));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User navigates to patient order status$")
	public static void i_navigate_to_patient_order_status() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(5000);
			isElementPresentVerifyClick(SmokeTestConstants.patientOrderStatus_LefttMenuButton);
			if (!isElementPresents(SmokeTestConstants.patientOrderStatusPageTitle)) {
				boolean Alert_Condition = FrameworkLibrary.isElementPresents(SmokeTestConstants.patientOrderStatus_Alert_OK_Button);
				if (Alert_Condition) {
					FrameworkLibrary.isElementPresentVerifyClick(SmokeTestConstants.patientOrderStatus_Alert_OK_Button);
				}
				isElementPresentVerifyClick(SmokeTestConstants.patientOrderStatus_LefttMenuButton);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User enters patient last name in POS last name text box$")
	public static void i_enter_patient_last_name_in_POS_last_name_text_box(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");

			if (isElementPresentVerification(SmokeTestConstants.patientOrderStatuts_patientSearchField)) {
				if (!clearAndEnterText(SmokeTestConstants.patientOrderStatuts_patientSearchField, LastName)) {
					throw new Exception("Not able to enter value patientOrderStatuts_patientSearchField text field");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}
	
	
	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User enters newly added patient last name and phone number in POS$")
	public static void User_enters_newly_added_patient_last_name_and_phone_number_in_POS() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.patientOrderStatuts_patientSearchField)) {
				if (!clearAndEnterText(SmokeTestConstants.patientOrderStatuts_patientSearchField, lastName)) {
					throw new Exception("Not able to enter value patientOrderStatuts_patientSearchField text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.patientOrder_phoneNumber)) {
				WebElement element = chromeDriver.findElement(By.xpath(SmokeTestConstants.patientOrder_phoneNumber));
				element.click();
				Thread.sleep(1000);
				element.sendKeys(phoneNumber);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}
	

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User enters patient phone number in POS phone number text box$")
	public static void i_enter_patient_phone_number_in_POS_phone_number_text_box(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String PhoneNumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");

			if (isElementPresentVerification(SmokeTestConstants.patientOrder_phoneNumber)) {
				WebElement element = chromeDriver.findElement(By.xpath(SmokeTestConstants.patientOrder_phoneNumber));
				element.click();
				Thread.sleep(1000);
				element.sendKeys(PhoneNumber);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks search button on patient order status$")
	public static void i_click_search_button_on_patient_order_status() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(5000);
			if (isElementPresentVerification(SmokeTestConstants.patientOrderStatus_patientSearchButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.patientOrderStatus_patientSearchButton)) {
					throw new Exception("Not able to click patientOrderStatus_patientSearchButton");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should generate Rx number for current prescription$")
	public static void System_should_generate_Rx_number_for_current_prescription(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			Thread.sleep(5000);
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			Thread.sleep(5000);
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			Thread.sleep(5000);
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
			String expintakeDate = SmokeTestStepDef.intakenextdate;
			//List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[td[md-icon[@aria-hidden='false']]]"));
			List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));
			log.info(elements.size());
			for (int i = 0; i < elements.size(); i++) {
				log.info(elements.get(i).getText());
				if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(possiblepickupTime1)) {
					int p = 3;
					if (i == 0) {
						p++;
					}
					int l = p + 3;
					Assert.assertTrue(elements.get(i).getText().toUpperCase().contains("IN PROGRESS"));
					Assert.assertTrue(elements.get(i).getText().toUpperCase().contains("ENTERED"));
					String dyn = elements.get(i).getAttribute("id");
					String[] dynamo = dyn.split("-");
					String part1 = dynamo[1];
					String part2 = dynamo[2];
					String part3 = dynamo[3];
					String Rxnumber = "//*[@id='patient-" + part1 + "-" + part2 + "-" + part3 + "']/td[" + p + "]";
					RxnumberHyperlink = getElementByProperty(Rxnumber,chromeDriver);
					String currentRxnumber = getElementText(Rxnumber);

					long timeoutExpiredMS = System.currentTimeMillis() + 120000;
					while (getElementText(Rxnumber) == null) {
						log.info("waiting for the rx number to be generated..");
						SmokeTestStepDef.i_click_search_button_on_patient_order_status();
						log.info("rx number after waiting is" + getElementText(Rxnumber));
						if (System.currentTimeMillis() > timeoutExpiredMS) {
							Assert.fail("Timed out after waiting for rx number to be generated");
						}
					}
					log.info(currentRxnumber);
					Assert.assertTrue(getElementText(Rxnumber) != null);
					String[] rxnumberparts = currentRxnumber.split("-");
					dynamicrxnum = rxnumberparts[0];
					log.info(dynamicrxnum);
					log.info("Rx number is generated");
					String priceXpath = "//*[@id='patient-" + part1 + "-" + part2 + "-" + part3 + "']/td[" + l + "]";
					String dynamicrxnum1 = rxnumberparts[1];
					log.info(dynamicrxnum1);
					log.info("The size of the Rx number number is:" + dynamicrxnum.length());
					log.info("The size of the store number is :" + dynamicrxnum1.length());
					Assert.assertEquals(dynamicrxnum.length(), 7);
					Assert.assertEquals(dynamicrxnum1.length(), 5);
					String price = getElementText(priceXpath);
					Assert.assertTrue(price != null);
					log.info("The price for current prescription is generated");
					break;
				} else if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(pickuptime)) {
					int p = 3;
					if (i == 0) {
						p++;
					}
					int l = p + 3;
					Assert.assertTrue(elements.get(i).getText().toUpperCase().contains("IN PROGRESS"));
					Assert.assertTrue(elements.get(i).getText().toUpperCase().contains("ENTERED"));
					String dyn = elements.get(i).getAttribute("id");
					String[] dynamo = dyn.split("-");
					String part1 = dynamo[1];
					String part2 = dynamo[2];
					String part3 = dynamo[3];
					String Rxnumber = "//*[@id='patient-" + part1 + "-" + part2 + "-" + part3 + "']/td[" + p + "]";
					RxnumberHyperlink = getElementByProperty(Rxnumber,chromeDriver);
					String currentRxnumber = getElementText(Rxnumber);

					long timeoutExpiredMS = System.currentTimeMillis() + 120000;
					while (getElementText(Rxnumber) == null) {
						log.info("waiting for the rx number to be generated..");
						SmokeTestStepDef.i_click_search_button_on_patient_order_status();
						log.info("rx number after waiting is" + getElementText(Rxnumber));
						if (System.currentTimeMillis() > timeoutExpiredMS) {
							Assert.fail("Timed out after waiting for rx number to be generated");
						}
					}
					log.info(currentRxnumber);
					Assert.assertTrue(getElementText(Rxnumber) != null);
					String[] rxnumberparts = currentRxnumber.split("-");
					dynamicrxnum = rxnumberparts[0];
					log.info(dynamicrxnum);
					log.info("Rx number is generated");
					String priceXpath = "//*[@id='patient-" + part1 + "-" + part2 + "-" + part3 + "']/td[" + l + "]";
					String dynamicrxnum1 = rxnumberparts[1];
					log.info(dynamicrxnum1);
					log.info("The size of the Rx number number is:" + dynamicrxnum.length());
					log.info("The size of the store number is :" + dynamicrxnum1.length());
					Assert.assertEquals(dynamicrxnum.length(), 7);
					Assert.assertEquals(dynamicrxnum1.length(), 5);
					String price = getElementText(priceXpath);
					Assert.assertTrue(price != null);
					log.info("The price for current prescription is generated");
					break;
				} else if (elements.get(i).getText().contains(expintakeDate) && elements.get(i).getText().contains(possiblepickupTime1)) {
					int p = 3;
					if (i == 0) {
						p++;
					}
					int l = p + 3;
					Assert.assertTrue(elements.get(i).getText().toUpperCase().contains("IN PROGRESS"));
					Assert.assertTrue(elements.get(i).getText().toUpperCase().contains("ENTERED"));
					String dyn = elements.get(i).getAttribute("id");
					String[] dynamo = dyn.split("-");
					String part1 = dynamo[1];
					String part2 = dynamo[2];
					String part3 = dynamo[3];
					String Rxnumber = "//*[@id='patient-" + part1 + "-" + part2 + "-" + part3 + "']/td[" + p + "]";
					RxnumberHyperlink = getElementByProperty(Rxnumber,chromeDriver);
					String currentRxnumber = getElementText(Rxnumber);

					long timeoutExpiredMS = System.currentTimeMillis() + 120000;
					while (getElementText(Rxnumber) == null) {
						log.info("waiting for the rx number to be generated..");
						SmokeTestStepDef.i_click_search_button_on_patient_order_status();
						log.info("rx number after waiting is" + getElementText(Rxnumber));
						if (System.currentTimeMillis() > timeoutExpiredMS) {
							Assert.fail("Timed out after waiting for rx number to be generated");
						}
					}
					log.info(currentRxnumber);
					Assert.assertTrue(getElementText(Rxnumber) != null);
					String[] rxnumberparts = currentRxnumber.split("-");
					dynamicrxnum = rxnumberparts[0];
					log.info(dynamicrxnum);
					log.info("Rx number is generated");
					String priceXpath = "//*[@id='patient-" + part1 + "-" + part2 + "-" + part3 + "']/td[" + l + "]";
					String dynamicrxnum1 = rxnumberparts[1];
					log.info(dynamicrxnum1);
					log.info("The size of the Rx number number is:" + dynamicrxnum.length());
					log.info("The size of the store number is :" + dynamicrxnum1.length());
					Assert.assertEquals(dynamicrxnum.length(), 7);
					Assert.assertEquals(dynamicrxnum1.length(), 5);
					String price = getElementText(priceXpath);
					Assert.assertTrue(price != null);
					log.info("The price for current prescription is generated");
					break;
				} else {
					log.info("The" + i + "prescription is not current");
					if (i == elements.size() - 1) {
						Assert.fail("prescription not found.");
					}
				}

			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}


	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User hits ctrl plus p hot key")
	public static void user_hits_ctrl_plus_p_hot_key() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.CONTROL).sendKeys("p").keyUp(Keys.CONTROL).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User hits ctrl plus d hot key$")
	public static void user_hits_ctrl_plus_d_hot_key() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(2000);
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.CONTROL).sendKeys("d").keyUp(Keys.CONTROL).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User hits ctrl plus r hot key$")
	public static void user_hits_ctrl_plus_r_hot_key() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.CONTROL).sendKeys("r").keyUp(Keys.CONTROL).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User hits ctrt plus l hot key$")
	public static void user_hits_ctrl_l_hot_key() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.CONTROL).sendKeys("l").keyUp(Keys.CONTROL).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User hits ctrl plus s hot key$")
	public static void user_hits_ctrl_s_hot_key() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User hits ctrl plus one hot key$")
	public static void user_hits_ctrl_plus_one_hot_key() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.CONTROL).sendKeys("1").keyUp(Keys.CONTROL).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should navigate to DE screen or System shows a pop-up if there are no DE tasks$")
	public static void system_should_navigate_to_DE_screenor_System_shows_a_pop_up_if_there_are_no_DE_tasks() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebDriverWait wait = new WebDriverWait(chromeDriver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.className(SmokeTestConstants.NoTasks_Alert_ok_btn_className)));
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("o").keyUp(Keys.ALT).build();
			series.perform();
		} catch (Exception e) {
			log.info("No Alert found");
			Thread.sleep(5000);
			waitForVisibility(SmokeTestConstants.DataEntryPageTitle);
			Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.DataEntryPageTitle), "Data Entry page is not displayed");
			log.info("Data Entry page is displayed");
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).build();
			series.perform();
			Thread.sleep(2000);
			Actions ac2 = new Actions(chromeDriver);
			Action series2 = ac2.keyDown(Keys.ALT).sendKeys("y").keyUp(Keys.ALT).build();
			series2.perform();
		}
	}


	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User hits ctrl plus two hot key$")
	public static void user_hits_ctrl_plus_two_hot_key() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(4000);
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.CONTROL).sendKeys("2").keyUp(Keys.CONTROL).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should navigate to DR screen or System shows a pop-up if there are no DR tasks$")
	public static void system_should_navigate_to_DR_screen_or_System_shows_a_pop_up_if_there_are_no_DR_tasks()  throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebDriverWait wait = new WebDriverWait(chromeDriver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.className(SmokeTestConstants.NoTasks_Alert_ok_btn_className)));
			chromeDriver.findElementByClassName(SmokeTestConstants.NoTasks_Alert_ok_btn_className).click();
		} catch (Exception e) {
			log.info("No Alert found");
			// takeScreenShot(methodName);
			Thread.sleep(6000);
			waitForVisibility(SmokeTestConstants.DataReviewPageTitle);
			Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.DataReviewPageTitle), "Data Review page is not displayed");
			log.info("Data Review page is displayed");
			Thread.sleep(3000);
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).build();
			series.perform();
			log.info("Performed ALT + c");
			Thread.sleep(2000);
			Actions ac2 = new Actions(chromeDriver);
			Action series2 = ac2.keyDown(Keys.ALT).sendKeys("y").keyUp(Keys.ALT).build();
			series2.perform();
			log.info("Performed ALT + y");
		}
	}


	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User hits ctrl plus three hot key$")
	public static void user_hits_ctrl_plus_three_hot_key() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(3000);
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.CONTROL).sendKeys("3").keyUp(Keys.CONTROL).build();
			series.perform();
			log.info("Performed CTRL + 3");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should navigate to CE screen or System shows a pop-up if there are no CE tasks$")
	public static void system_should_navigate_to_CE_screen_or_System_shows_a_pop_up_if_there_are_no_CE_tasks() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebDriverWait wait = new WebDriverWait(chromeDriver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.className(SmokeTestConstants.NoTasks_Alert_ok_btn_className)));
			waitToClickByClassName(SmokeTestConstants.NoTasks_Alert_ok_btn_className).click();
		} catch(Exception e) {
			waitForVisibility(SmokeTestConstants.CE_selectAll_TherapyReview);
			Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.CE_selectAll_TherapyReview), "CE page is not displayed");
			log.info("CE page is displayed");
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).build();
			series.perform();
			log.info("Performed ALT + C");
		}
	}


	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User hits ctrl plus four hot key$")
	public static void user_hits_ctrl_plus_four_hot_key() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(2000);
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.CONTROL).sendKeys("4").keyUp(Keys.CONTROL).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}

	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should navigate to PV screen or System shows a pop-up if there are no PV tasks$")
	public static void system_should_navigate_to_PV_screen_or_System_shows_a_pop_up_if_there_are_no_PV_tasks() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(1000);
			if (isElementPresentVerification(ProductVerificationConstants.PV_rxNumberTextBox)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(ProductVerificationConstants.PV_rxNumberTextBox), "Product Verification page is not displayed");
				log.info("Product Verification page is displayed");

			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User hits ctrl plus o hot key$")
	public static void user_hits_ctrl_plus_o() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.CONTROL).sendKeys("o").keyUp(Keys.CONTROL).build();
			series.perform();
			if (isElementPresentVerification(FrameworkConstants.LOGOUT_THIS_DEVICE)) {
				isElementPresentVerifyClick(FrameworkConstants.LOGOUT_THIS_DEVICE);
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}

	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User hits ctrl plus l hot key$")
	public static void user_hits_ctrl_plus_l_hot_key() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.CONTROL).sendKeys("1").keyUp(Keys.CONTROL).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		}

	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User hits ctrl plus h hot key$")
	public static void user_hits_ctrl_plus_h_hot_key() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(3000);
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.CONTROL).sendKeys("h").keyUp(Keys.CONTROL).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());	
			}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User hits alt plus Y hot key$")
	public static void alt_plus_y_hotkey() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action altY = ac.keyDown(Keys.ALT).sendKeys("Y").keyUp(Keys.ALT).build();
			altY.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
			}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User hits alt plus N hot key$")
	public static void alt_plus_N_hot_key() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(2000);
			Actions ac = new Actions(chromeDriver);
			Action altN = ac.keyDown(Keys.ALT).sendKeys("N").keyUp(Keys.ALT).build();
			altN.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should display clinical evaluation page$")
	public static void validate_CE_page_is_displayed() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.CLININCAL_CHECK_TITLE)) {
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} finally {
			Assert.assertTrue(isElementPresents(ClinicalEvaluationConstants.CLININCAL_CHECK_TITLE));
		}

	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should display product verification page$")
	public static void validate_pv_page_displayed() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(SmokeTestConstants.productVerificationPageTitle)) {
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} finally {
			Assert.assertTrue(isElementPresents(SmokeTestConstants.productVerificationPageTitle));
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should display an alert message - All changes will be lost. Do you want to proceed?$")
	public static void validate_alert_all_changes_will_be_lost() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.cancelAlertMessage)) {
				String alertMessage = getElementText(SmokeTestConstants.cancelAlertMessage);
				Assert.assertTrue(alertMessage.toLowerCase().contains("all changes will be lost"));
				Assert.assertTrue(alertMessage.toLowerCase().contains("do you want to proceed?"));
				if (!isElementPresentVerification(SmokeTestConstants.patientOrderStatus_Alert_OK_Button)) {

				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^validate the number of refills in database$")
	public static void validate_refills_in_database(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(5000);
			Connection connection = ConnectionFactory.getConnection();
			String query = "select days_supply, patient_code, store_code,number_refill  from  prescription_specification where patient_code   = '00000002024' order by id desc";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			String refillinexcel = SmokeTestLibrary.getData(arg1, "Refills");
			log.info("refill from sheet" + refillinexcel);
			int refillinsheet = Integer.parseInt(refillinexcel);
			while (rs.next()) {
				int refill = rs.getInt("NUMBER_REFILL");
				log.info("The refill in database is" + refill);
				Assert.assertTrue(refillinsheet == refill);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^validate the number of refills in patient order status$")
	public static void validate_num_refill_POS(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			Thread.sleep(5000);
			List<WebElement> list1 = chromeDriver.findElements(By.xpath(SmokeTestConstants.POS_patientNames));
			String expectedPatientName = SmokeTestLibrary.getData(arg1, "LastName").toUpperCase();
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
			String expectedDrugName = ClinicalEvaluationLibrary.getData(arg1, "DrugName", 1).toLowerCase();
			for (int i = 0; i < list1.size(); i++) {
				if (list1.get(i).getText().contains(expectedPatientName)/* && list1.get(i).getText().contains(expectedPhoneNumber)*/) {
					String s = list1.get(i).getAttribute("id");
					log.info(s);
					String[] parts = s.split("-");
					String part2 = parts[1];
					List<WebElement> singlepresc = chromeDriver.findElements(By.xpath("//*[contains(@id,'single-prescription-" + part2 + "')]"));
					log.info("size is" + singlepresc.size());

					for (int z = 0; z < singlepresc.size(); z++) {
						if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate) && singlepresc.get(z).getText().contains(pickuptime) && singlepresc.get(z).getText().toLowerCase().contains(expectedDrugName)) {
							log.info("single current prescription contains" + singlepresc.get(z).getText());
							Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("in progress"));
							Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("entered"));
							String dyn = singlepresc.get(z).getAttribute("id");
							String[] dynamo = dyn.split("-");
							String part = dynamo[2];
							String Rxnumber = "//*[@id='single-prescription-" + part + "-" + z + "']/div[3]";
							String currentRxnumber = getElementText(Rxnumber);
							Assert.assertTrue(getElementText(Rxnumber) != null);
							log.info(currentRxnumber);
							String[] rxnumberparts = currentRxnumber.split("-");
							dynamicrxnum = rxnumberparts[0];
							log.info(dynamicrxnum);
							log.info("Rx number is generated");
							String priceXpath = "//*[@id='single-prescription-" + part + "-" + z + "']/div[6]";
							String price = getElementText(priceXpath);
							Assert.assertTrue(price != null);
							log.info("The price for current prescription is generated");
							isElementPresentVerifyClick("//*[@id='single-prescription-" + part + "-" + z + "']/div[3]/a");
							waitForVisibility(SmokeTestConstants.POS_rxnumber_refillnum);
							int refillnumberinUI = Integer.parseInt(getElementText(SmokeTestConstants.POS_rxnumber_refillnum));
							int expectedRefillNum = Integer.parseInt(ClinicalEvaluationLibrary.getData(arg1, "Refills", 1));
							Assert.assertTrue(refillnumberinUI == expectedRefillNum);
							waitToClick(SmokeTestConstants.rxDetailsCancelButton).click();

						} else if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate) && singlepresc.get(z).getText().contains(possiblepickupTime1) && singlepresc.get(z).getText().toLowerCase().contains(expectedDrugName)) {
							log.info("single current prescription contains" + singlepresc.get(z).getText());
							Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("in progress"), "The prescription status is not seen as in progress");
							Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("entered"), "The prescription status is not seens as entered");
							log.info("The status is In Progress - Entered after completing the data review task");
							String dyn = singlepresc.get(z).getAttribute("id");
							String[] dynamo = dyn.split("-");
							String part = dynamo[2];
							String Rxnumber = "//*[@id='single-prescription-" + part + "-" + z + "']/div[3]";
							String currentRxnumber = getElementText(Rxnumber);
							log.info(currentRxnumber);
							Assert.assertTrue(getElementText(Rxnumber) != null);
							String[] rxnumberparts = currentRxnumber.split("-");
							dynamicrxnum = rxnumberparts[0];
							log.info(dynamicrxnum);
							log.info("Rx number is generated");
							String priceXpath = "//*[@id='single-prescription-" + part + "-" + z + "']/div[6]";
							String price = getElementText(priceXpath);
							Assert.assertTrue(price != null);
							log.info("The price for current prescription is generated");
							isElementPresentVerifyClick("//*[@id='single-prescription-" + part + "-" + z + "']/div[3]/a");
							waitForVisibility(SmokeTestConstants.POS_rxnumber_refillnum);
							int refillnumberinUI = Integer.parseInt(getElementText(SmokeTestConstants.POS_rxnumber_refillnum));
							int expectedRefillNum = Integer.parseInt(ClinicalEvaluationLibrary.getData(arg1, "Refills", 1));
							Assert.assertTrue(refillnumberinUI == expectedRefillNum);
							waitToClick(SmokeTestConstants.rxDetailsCancelButton).click();
						} else if (singlepresc.get(z).getText().toLowerCase().contains(intakenextdate) && singlepresc.get(z).getText().contains(possiblepickupTime1)) {
							log.info("single current prescription contains" + singlepresc.get(z).getText());
							Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("in progress"), "The prescription status is not seen as in progress");
							Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("entered"), "The prescription status is not seens as entered");
							log.info("The status is In Progress - Entered after completing the data review task");
							String dyn = singlepresc.get(z).getAttribute("id");
							String[] dynamo = dyn.split("-");
							String part = dynamo[2];
							String Rxnumber = "//*[@id='single-prescription-" + part + "-" + z + "']/div[3]";
							String currentRxnumber = getElementText(Rxnumber);
							log.info(currentRxnumber);
							Assert.assertTrue(getElementText(Rxnumber) != null);
							String[] rxnumberparts = currentRxnumber.split("-");
							dynamicrxnum = rxnumberparts[0];
							log.info(dynamicrxnum);
							log.info("Rx number is generated");
							String priceXpath = "//*[@id='single-prescription-" + part + "-" + z + "']/div[6]";
							String price = getElementText(priceXpath);
							Assert.assertTrue(price != null);
							log.info("The price for current prescription is generated");
							isElementPresentVerifyClick("//*[@id='single-prescription-" + part + "-" + z + "']/div[3]/a");
							waitForVisibility(SmokeTestConstants.POS_rxnumber_refillnum);
							int refillnumberinUI = Integer.parseInt(getElementText(SmokeTestConstants.POS_rxnumber_refillnum));
							int expectedRefillNum = Integer.parseInt(ClinicalEvaluationLibrary.getData(arg1, "Refills", 1));
							Assert.assertTrue(refillnumberinUI == expectedRefillNum);
							waitToClick(SmokeTestConstants.rxDetailsCancelButton).click();
						}

					}
				}
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * This method validates the message displayed in patient order status when user attempts to delete a prescription that is sent to IC+.
	 * The message is passed as input to the method and it iterates through the prescription rows and picks the current prescription based on pickup timie obtained
	 * in intake method. It can be re-used accross all the scenarios where the error messages in patient order status is validated.
	 *
	 */
	@Then("^System should display a message \"([^\"]*)\" under the prescription$")
	public static void validate_delete_rx_icplus_message(String message) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(3000);
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
			String expintakeDate = SmokeTestStepDef.intakenextdate;
			List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));
			String deleteRxMessageLocator = "//*[@id='patient-order-status-list']//div[contains(@class,'rxms-primary-validation-message-error ')]";
			log.info(elements.size());
			for (int i = 0; i < elements.size(); i++) {
				log.info(elements.get(i).getText());
				if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(possiblepickupTime1)) {
					Actions ac = new Actions(chromeDriver);
					Action a = ac.sendKeys(Keys.ARROW_DOWN).build();
					a.perform();
					String ActualMessage = getElementText(deleteRxMessageLocator);
					log.info("Message displayed is" + ActualMessage);
					Assert.assertTrue(ActualMessage.contains(message));
					break;
				} else if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(pickuptime)) {
					Actions ac = new Actions(chromeDriver);
					Action a = ac.sendKeys(Keys.ARROW_DOWN).build();
					a.perform();
					String ActualMessage = getElementText(deleteRxMessageLocator);
					log.info("Message displayed is" + ActualMessage);
					Assert.assertTrue(ActualMessage.contains(message));
					break;
				} else if (elements.get(i).getText().contains(expintakeDate) && elements.get(i).getText().contains(possiblepickupTime1)) {
					Actions ac = new Actions(chromeDriver);
					Action a = ac.sendKeys(Keys.ARROW_DOWN).build();
					a.perform();
					String ActualMessage = getElementText(deleteRxMessageLocator);
					log.info("Message displayed is" + ActualMessage);
					Assert.assertTrue(ActualMessage.contains(message));
					break;
				} else {
					log.info("The" + i + "prescription is not current");
					if (i == elements.size() - 1) {
						Assert.fail("prescription not found.");
					}
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User validates the status as \"([^\"]*)\" and selects the current prescription$")
	public static void user_validates_the_status_as_and_selects_the_current_prescription(String arg1, DataTable arg2) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(5000);
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			Thread.sleep(8000);
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
			String expintakeDate = SmokeTestStepDef.intakenextdate;
			List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));

			Assert.assertTrue(elements.get(0).getText().toUpperCase().contains(SmokeTestLibrary.getData(arg2, "LastName").toUpperCase()));
			for (int i = elements.size() - 1; i >= 0; i--) {
				int waitingColumn = 1;
				if (i == 0) {
					waitingColumn++;
				}
				if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(possiblepickupTime1)) {
					Assert.assertTrue(elements.get(i).getText().toUpperCase().contains(arg1.toUpperCase()));
					CurrentPrescriptionRow = elements.get(i);
					String id = CurrentPrescriptionRow.getAttribute("id");
					String xpath = "//*[@id='" + id + "']/td[" + waitingColumn + "]";
					getElementByProperty(xpath, chromeDriver).click();
					Thread.sleep(2000);
					long timeoutExpiredMS = System.currentTimeMillis() + 20000;
					while (1 != 2) {
						Actions ac = new Actions(chromeDriver);
						Action a = ac.sendKeys(Keys.ARROW_UP).build();
						a.perform();
						if (System.currentTimeMillis() > timeoutExpiredMS) {
							break;
						}
					}

					elements.get(0).click();
					getElementByProperty(xpath, chromeDriver).click();

					break;
				} else if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(pickuptime)) {

					Assert.assertTrue(elements.get(i).getText().toUpperCase().contains(arg1.toUpperCase()));
					CurrentPrescriptionRow = elements.get(i);
					String id = CurrentPrescriptionRow.getAttribute("id");
					String xpath = "//*[@id='" + id + "']/td[" + waitingColumn + "]";
					getElementByProperty(xpath, chromeDriver).click();
					Thread.sleep(2000);
					long timeoutExpiredMS = System.currentTimeMillis() + 10000;
					while (1 != 2) {
						Actions ac = new Actions(chromeDriver);
						Action a = ac.sendKeys(Keys.ARROW_UP).build();
						a.perform();
						if (System.currentTimeMillis() > timeoutExpiredMS) {
							break;
						}
					}

					elements.get(0).click();
					getElementByProperty(xpath, chromeDriver).click();

					break;
				} else if (elements.get(i).getText().contains(expintakeDate) && elements.get(i).getText().contains(possiblepickupTime1)) {
					Assert.assertTrue(elements.get(i).getText().toUpperCase().contains(arg1.toUpperCase()));
					CurrentPrescriptionRow = elements.get(i);
					String id = CurrentPrescriptionRow.getAttribute("id");
					String xpath = "//*[@id='" + id + "']/td[" + waitingColumn + "]";
					getElementByProperty(xpath, chromeDriver).click();
					Thread.sleep(2000);
					long timeoutExpiredMS = System.currentTimeMillis() + 10000;
					while (1 != 2) {
						Actions ac = new Actions(chromeDriver);
						Action a = ac.sendKeys(Keys.ARROW_UP).build();
						a.perform();
						if (System.currentTimeMillis() > timeoutExpiredMS) {
							break;
						}
					}

					elements.get(0).click();
					getElementByProperty(xpath, chromeDriver).click();

					break;
				} else {
					if (i == 0) {
						Assert.fail("prescription not found.");
					}
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
			}

	}
	
	
	@When("^User validates the status as \"([^\"]*)\" and selects the current prescription and validate newly created lastname$")
	public static void user_validates_the_status_as_and_selects_the_current_prescription_and_validate_newly_created_lastname(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(5000);
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			Thread.sleep(8000);
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
			String expintakeDate = SmokeTestStepDef.intakenextdate;
			List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));

			for (int i = elements.size() - 1; i >= 0; i--) {
				int waitingColumn = 1;
				if (i == 0) {
					waitingColumn++;
				}
				if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(possiblepickupTime1)) {
					Assert.assertTrue(elements.get(i).getText().toUpperCase().contains(arg1.toUpperCase()));
					CurrentPrescriptionRow = elements.get(i);
					String id = CurrentPrescriptionRow.getAttribute("id");
					String xpath = "//*[@id='" + id + "']/td[" + waitingColumn + "]";
					getElementByProperty(xpath, chromeDriver).click();
					Thread.sleep(2000);
					long timeoutExpiredMS = System.currentTimeMillis() + 10000;
					while (1 != 2) {
						Actions ac = new Actions(chromeDriver);
						Action a = ac.sendKeys(Keys.ARROW_UP).build();
						a.perform();
						if (System.currentTimeMillis() > timeoutExpiredMS) {
							break;
						}
					}

					elements.get(0).click();
					getElementByProperty(xpath, chromeDriver).click();

					break;
				} else if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(pickuptime)) {

					Assert.assertTrue(elements.get(i).getText().toUpperCase().contains(arg1.toUpperCase()));
					CurrentPrescriptionRow = elements.get(i);
					String id = CurrentPrescriptionRow.getAttribute("id");
					String xpath = "//*[@id='" + id + "']/td[" + waitingColumn + "]";
					getElementByProperty(xpath, chromeDriver).click();
					Thread.sleep(2000);
					long timeoutExpiredMS = System.currentTimeMillis() + 10000;
					while (1 != 2) {
						Actions ac = new Actions(chromeDriver);
						Action a = ac.sendKeys(Keys.ARROW_UP).build();
						a.perform();
						if (System.currentTimeMillis() > timeoutExpiredMS) {
							break;
						}
					}

					elements.get(0).click();
					getElementByProperty(xpath, chromeDriver).click();

					break;
				} else if (elements.get(i).getText().contains(expintakeDate) && elements.get(i).getText().contains(possiblepickupTime1)) {
					Assert.assertTrue(elements.get(i).getText().toUpperCase().contains(arg1.toUpperCase()));
					CurrentPrescriptionRow = elements.get(i);
					String id = CurrentPrescriptionRow.getAttribute("id");
					String xpath = "//*[@id='" + id + "']/td[" + waitingColumn + "]";
					getElementByProperty(xpath, chromeDriver).click();
					Thread.sleep(2000);
					long timeoutExpiredMS = System.currentTimeMillis() + 10000;
					while (1 != 2) {
						Actions ac = new Actions(chromeDriver);
						Action a = ac.sendKeys(Keys.ARROW_UP).build();
						a.perform();
						if (System.currentTimeMillis() > timeoutExpiredMS) {
							break;
						}
					}

					elements.get(0).click();
					getElementByProperty(xpath, chromeDriver).click();

					break;
				} else {
					if (i == 0) {
						Assert.fail("prescription not found.");
					}
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
			}

	}

	/*
	 * This method validates that the prescription deleted does not exist anymore in the patient order status delete. It takes the pickup time captured in
	 * the global variable and iterates through the rows in the patient order status and asserts that the pickup time does not exist in any of the rows
	 *
	 */
	@Then("^The prescription should be deleted$")
	public static void the_prescription_should_be_deleted() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(5000);
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			Thread.sleep(5000);
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
			String expintakeDate = SmokeTestStepDef.intakenextdate;
			List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));
			log.info(elements.size());
			for (int i = 0; i < elements.size(); i++) {
				Assert.assertFalse(elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(possiblepickupTime1));
				Assert.assertFalse(elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(pickuptime));
				Assert.assertFalse(elements.get(i).getText().contains(expintakeDate) && elements.get(i).getText().contains(possiblepickupTime1));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to select the null value in the state dropdown in DE prescriber search.
	 *
	 * @throws Throwable
	 */

	@When("^User selects null value in the state dropdown$")
	public static void select_null_value_state_drpdown() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.prescriberSearch_StateDropDown)) {
				FrameworkLibrary.isElementPresentVerifyClick(SmokeTestConstants.prescriberSearch_StateDropDown);
			}
			Thread.sleep(2000);
			List<WebElement> nullStateValue = chromeDriver.findElements(By.cssSelector("md-option.md-ink-ripple[value='']"));
			nullStateValue.get(1).click();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	
	@When("^User closes the donut chart in patient order status$")
	public static void close_the_donut_chart() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.DonutChartCancelButton)) {
				isElementPresentVerifyClick(SmokeTestConstants.DonutChartCancelButton);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method : To Verify RxMs application launch
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Given("^User launches the RxMS desktop application$")
	public void user_launches_the_RxMS_application() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			FrameworkLibrary.initiateBrowser();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method : To Verify Login into RxMs application
	 * author : Photon
	 * Date :   11 / Jan / 2017
	 * Modifier : Jeyaprakash
	 * Modification Data : 01 / May / 2017
	 ******************************************************************************/

	@When("^User enters the valid credentials in login text fields$")
	public void user_enters_valid_credentials(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		try {
			username = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "UserName");
			password = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Password");
			if (isElementPresentVerification(SmokeTestConstants.userName)) {
				if (!clearAndEnterText(SmokeTestConstants.userName, username)) {
					throw new Exception("Not able to enter value in user name text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.password)) {
				if (!clearAndEnterText(SmokeTestConstants.password, password)) {
					throw new Exception("Not able to enter value in password text field");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks login button$")
	public void clicks_login_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Login_Button)) {
				proxy.newHar();
				if (!isElementPresentVerifyClick(SmokeTestConstants.Login_Button)) {
					throw new Exception("Not able to click login button");
				}
				waitForVisibility(SmokeTestConstants.RxMSHome_Store_Number);
				writeHarFile(workingFolder, "Login", row.getRowNum(), 2);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks on patient tab in left side menu$")
	public void User_clicks_on_patient_tab_in_left_side_menu() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Patient_LeftMenuButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_LeftMenuButton)) {
					throw new Exception("Not able to click on Patient_Left Menu Button");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^User enters patient First Name and Last Name$")
	public void User_enters_patient_First_Name_and_Last_Name(DataTable arg1) throws Exception  {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
			String FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");

			if (isElementPresentVerification(SmokeTestConstants.Patient_LastName)) {
				if (!clearAndEnterText(SmokeTestConstants.Patient_LastName, LastName)) {
					throw new Exception("Not able to enter value in LastName text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
				if (!clearAndEnterText(SmokeTestConstants.Patient_FirstName, FirstName)) {
					throw new Exception("Not able to enter value in FirstName text field");
				}
			}
			if (isElementPresentVerification(IntakeConstants.Patient_Phone_Number_Feild)) {
				chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild)).clear();
			}
			if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB)) {
				chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_DOB)).clear();
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^clicks search button on patient search page$")
	public void clicks_search_button_on_patient_search_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Patient_SearchButton)) {
				proxy.newHar();
				if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_SearchButton)) {
					throw new Exception("Not able to click on Patient_SearchButton Button");
				}
				Collection<String> sourceTagNames = scenario.getSourceTagNames();
				if (sourceTagNames.contains("@Perf_IkariWarriors") || sourceTagNames.contains("@RxMSSOLD")) {
					waitForVisibility(SmokeTestConstants.patientSearch_rows);
					writeHarFile(workingFolder, "Patient Local Search", row.getRowNum(), 3);
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^clicks search button on patient search page for global search$")
	public void clicks_search_button_on_patient_search_page_for_global_search() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Patient_SearchButton)) {
				proxy.newHar();
				if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_SearchButton)) {
					throw new Exception("Not able to click on Patient_SearchButton Button");
				}
				Collection<String> sourceTagNames = scenario.getSourceTagNames();
				if (sourceTagNames.contains("@Perf_IkariWarriors") || sourceTagNames.contains("@RxMSSOLD")) {
					waitForVisibility(SmokeTestConstants.patientSearch_rows);
					writeHarFile(workingFolder, "Patient Global Search", row.getRowNum(), 4);
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^clicks search button on patient search page for failure$")
	public void clicks_search_button_on_patient_search_page_for_failure() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Patient_SearchButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_SearchButton)) {
					throw new Exception("Not able to click on Patient_SearchButton Button");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks view button$")
	public void User_clicks_view_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Patient_ViewButton)) {
				proxy.newHar();
				if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_ViewButton)) {
					throw new Exception("Not able to click Patient_ViewButton");
				}
			}
			waitForVisibility(SmokeTestConstants.Patient_FirstName);
			Collection<String> tagNames = scenario.getSourceTagNames();
			if (tagNames.contains("@RxMSSOLD")) {
				writeHarFile(workingFolder, "view", row.getRowNum(), 4);
			} else if (tagNames.contains("@Perf_IkariWarriors")) {
				writeHarFile(workingFolder, "view", row.getRowNum(), 7);
			}
			DE_NumberOfTasksBeforeIntake = Integer.parseInt(FrameworkLibrary.getElementText(SmokeTestConstants.DENumberofTasks));

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^clicks intake Rx$")
	public void clicks_intake_Rx() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Intake_RxButton)) {
				proxy.newHar();
				if (!isElementPresentVerifyClick(SmokeTestConstants.Intake_RxButton)) {
					throw new Exception("Not able to click Intake_RxButton");
				}
				waitForVisibility(DataEntryConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN);
				boolean contains = scenario.getSourceTagNames().contains("@RxMSSOLD");
				if (contains) {
					writeHarFile(workingFolder, "IntakeRx", row.getRowNum(), 5);
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^Data Entry task should be created$")
	public void Data_Entry_task_should_be_created() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			int ExpectedDE_NumberOfTasksAfterIntake = DE_NumberOfTasksBeforeIntake + 1;
			String ExpectedtextInDETaskboard = Integer.toString(ExpectedDE_NumberOfTasksAfterIntake);
			WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
			wait.until(ExpectedConditions.textToBePresentInElement(FrameworkLibrary.getElementByProperty(SmokeTestConstants.DataEntry_RightMenuButton, chromeDriver), ExpectedtextInDETaskboard));
			ActualDE_NumberOfTasksAfterIntake = Integer.parseInt(FrameworkLibrary.getElementText(SmokeTestConstants.DENumberofTasks));
			Assert.assertEquals(ActualDE_NumberOfTasksAfterIntake, ExpectedDE_NumberOfTasksAfterIntake, "Data Entry task is not created");
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
		}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks DE task in the taskboard$")
	public void User_clicks_DE_task_in_the_taskboard() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			SmokeTestLibrary.hotkeyAction(Keys.CONTROL, "1", chromeDriver);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User enters prescriber first name and Last name$")
	public void User_enters_prescriber_first_name_and_Last_name(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
			String FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_LastName)) {
				if (!clearAndEnterText(SmokeTestConstants.Prescriber_LastName, LastName)) {
					throw new Exception("Not able to enter value in LastName text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_FirstName)) {
				if (!clearAndEnterText(SmokeTestConstants.Prescriber_FirstName, FirstName)) {
					throw new Exception("Not able to enter value in FirstName text field");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^clicks search button on prescriber search$")
	public void clicks_search_button_on_prescriber_search() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_searchButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.Prescriber_searchButton)) {
					throw new Exception("Not able to click Prescriber_SelectButton");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^clicks select to select a prescriber$")
	public void clicks_select_to_select_a_prescriber() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_SelectButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.Prescriber_SelectButton)) {
					throw new Exception("Not able to click Prescriber_SelectButton");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^clicks open product button$")
	public void clicks_open_product_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Open_Product)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.Open_Product)) {
					throw new Exception("Not able to click Open_Product");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 * @throws Throwable 
	 ******************************************************************************/

	@Then("^enters product information$")
	public void enters_product_information(DataTable arg1) throws Throwable  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			Date today = Calendar.getInstance().getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy");
			String Date = formatter.format(today);
			String DAW = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			String Quantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
			String Directions = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Directions");
			String DaysSupply = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DaysSupply");
			String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
			if (!isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {

			}
			//            if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
			//                if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, Date)) {
			//                    throw new Exception("Not able to enter value in user name text field");
			//                }
			//            }
			//            if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
			//                if (!clearAndEnterText(SmokeTestConstants.Product_DAW, DAW)) {
			//                    throw new Exception("Not able to enter value in user name text field");
			//                }
			//            }
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, DrugName)) {
					throw new Exception("Not able to enter value in DrugName text field");
				}
			}

			if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();
				Thread.sleep(1000);
				if(isElementPresentVerification(SmokeTestConstants.DispensedDrug_Field)){
		           	if(getElementByProperty(SmokeTestConstants.DispensedDrug_Field,chromeDriver).getAttribute("aria-disabled").equalsIgnoreCase("false")){
		           		IntakeStepDef.user_hits_Enter_Key();
		           	} 
		           }
			}
			if (isElementPresentVerification(SmokeTestConstants.Quantity_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Quantity_field, Quantity)) {
					throw new Exception("Not able to enter value in Quantity text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.Directions_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Directions_field, Directions)) {
					throw new Exception("Not able to enter value in Directions text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.Days_Supply)) {
				if (!clearAndEnterText(SmokeTestConstants.Days_Supply, DaysSupply)) {
					throw new Exception("Not able to enter value in DaysSupply text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Refills_field, Refills)) {
					throw new Exception("Not able to enter value in Refills text field");
				}
			}
			ExpectedProductName = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DrugName_Field, chromeDriver).getAttribute("value");
			ExpectedDirections = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Directions_field, chromeDriver).getAttribute("value");
			ExpectedProduct_quantity = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Quantity_field, chromeDriver).getAttribute("value");
			ExpectedProduct_quantityDisp = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Quantity_disp, chromeDriver).getAttribute("value");
			ExpectedProduct_DaysSupply = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Days_Supply, chromeDriver).getAttribute("value");
			ExpectedProduct_refills = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Refills_field, chromeDriver).getAttribute("value");
			ExpectedProduct_RxExpDate = FrameworkLibrary.getElementByProperty(SmokeTestConstants.RxExpiration_date, chromeDriver).getAttribute("value");
			ExpectedProduct_DAW = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Product_DAW, chromeDriver).getAttribute("value");
			ExpectedProduct_DrugExpDate = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DrugExpiryDate_Field, chromeDriver).getAttribute("value");
			ExpectedProduct_OriginalDate = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Product_OriginalDate, chromeDriver).getAttribute("value");
			ExpectedDirections = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Directions_field, chromeDriver).getAttribute("value");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^clicks open payment button$")
	public static void clicks_open_payment_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Open_payment)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.Open_payment)) {
					throw new Exception("Not able to click Open_payment");
				}
			}
			dispensedDruginDE = getElementText(SmokeTestConstants.DE_dispensedDrug);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^clicks open payment2 button$")
	public void clicks_open_payment2_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Open_payment2)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.Open_payment2)) {
					throw new Exception("Not able to click Open_payment2");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^selects payment type$")
	public void selects_payment_type() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
				isElementPresentVerifyClick(SmokeTestConstants.Payment_Dropdown);
			}
			if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
				isElementPresentVerifyClick(SmokeTestConstants.Cash_option);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^clicks Finish button to complete Data Entry$")
	public void clicks_Finish_button_to_complete_Data_Entry() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			DR_NumberOfTasksBeforeDE = Integer.parseInt(getElementText(SmokeTestConstants.DRNumberofTasks));
			if (isElementPresentVerification(SmokeTestConstants.DE_FinishButton)) {
				proxy.newHar();
				if (!isElementPresentVerifyClick(SmokeTestConstants.DE_FinishButton)) {
					throw new Exception("Not able to click DE_FinishButton");
				}
				//waitForVisibility(SmokeTestConstants.patientOrderStatus_patientSearchButton);
				writeHarFile(workingFolder, "DE_Finish", row.getRowNum(), 8);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^clicks DR button in the task board$")
	public void clicks_DR_button_in_the_task_board() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			boolean drZero = SmokeTestLibrary.isDRZero();
			SmokeTestLibrary.wait(drZero);

			int expectedDR_NumberOfTasksAfterDE = DR_NumberOfTasksBeforeDE + 1;
			String expectedDRTasksAfterDE = Integer.toString(expectedDR_NumberOfTasksAfterDE);
			WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
			wait.until(ExpectedConditions.textToBePresentInElement(getElementByProperty(SmokeTestConstants.DRNumberofTasks, chromeDriver), expectedDRTasksAfterDE));
			int actualDR_NumberOfTasksAfterDE = Integer.parseInt(getElementText(SmokeTestConstants.DRNumberofTasks));
			Assert.assertEquals(actualDR_NumberOfTasksAfterDE, expectedDR_NumberOfTasksAfterDE, "DR task is not created");
			FrameworkLibrary.isElementPresentVerifyClick(SmokeTestConstants.DataReview_RightMenuButton);
			WebDriverWait waitforAlert = new WebDriverWait(chromeDriver, watingForElement);
			waitforAlert.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SmokeTestConstants.DR_ALERT_OK_BTN)));
			boolean elementPresent = FrameworkLibrary.isElementPresents(SmokeTestConstants.DR_ALERT_OK_BTN);
			if (elementPresent) {
				if (isElementPresentVerification(SmokeTestConstants.DR_ALERT_OK_BTN)) {
					if (!isElementPresentVerifyClick(SmokeTestConstants.DR_ALERT_OK_BTN)) {
						throw new Exception("Not able to click DR_ALERT_OK_BTN button");
					}
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^User clicks first accept to validate patient data$")
	public void User_clicks_first_accept_to_validate_patient_data() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Patient_AccceptButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_AccceptButton)) {
					throw new Exception("Not able to click Patient_AccceptButton");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^clicks second accept to validate prescriber data$")
	public void clicks_second_accept_to_validate_prescriber_data() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_AcceptButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.Prescriber_AcceptButton)) {
					throw new Exception("Not able to click Prescriber_AcceptButton");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^clicks third accept to validate product data$")
	public void click_third_accept_to_validate_product_data() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Product_AcceptButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.Product_AcceptButton)) {
					throw new Exception("Not able to click Product_AcceptButton");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^clicks Finish to complete data review$")
	public void clicks_Finish_to_complete_data_review() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			NumberofCETasksBeforeDR = Integer.parseInt(getElementText(SmokeTestConstants.CETaskNumber));
			if (isElementPresentVerification(SmokeTestConstants.DR_FINISH)) {
				proxy.newHar();
				if (!isElementPresentVerifyClick(SmokeTestConstants.DR_FINISH)) {
					throw new Exception("Not able to click DR_FINISH button");
				}
				waitForVisibility(SmokeTestConstants.patientOrderStatus_patientSearchButton);
				writeHarFile(workingFolder, "DR_Finish", row.getRowNum(), 10);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^User clicks drug search in left side menu$")
	public void User_clicks_drug_search_in_left_side_menu() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.drug_LeftMenuButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.drug_LeftMenuButton)) {
					throw new Exception("Not able to click drug_LeftMenu  button");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User enters drug name in text box labeled drug name$")
	public void User_enters_drug_name_in_text_box_labeled_drug_name(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(SmokeTestConstants.drug_search_field)) {
				if (!clearAndEnterText(SmokeTestConstants.drug_search_field, DrugName)) {
					throw new Exception("Not able to enter value in drug_search text field");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^clicks search button on drug search page$")
	public void clicks_search_button_on_drug_seach_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.drugSearch_Button)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.drugSearch_Button)) {
					throw new Exception("Not able to click drugSearch_Button ");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should display the drug results$")
	public void system_should_display_the_drug_results(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(5000);
			String expectedval = SmokeTestLibrary.getData(arg1, "DrugName").toLowerCase();
			boolean condition = chromeDriver.getPageSource().toLowerCase().contains(expectedval);
			Assert.assertTrue(condition, "Drug search results are not displayed");
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks plan search button in left side menu$")
	public void User_clicks_plan_search_button_in_left_side_menu() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.plan_LeftMenuButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.plan_LeftMenuButton)) {
					throw new Exception("Not able to click plan_Left MenuButton");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User enters plan name in the text box labeled plan name$")
	public void User_enters_plan_name_in_the_text_box_labeled_plan_name(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String PlanName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PlanName");

			if (isElementPresentVerification(SmokeTestConstants.planName_searchfield)) {
				if (!clearAndEnterText(SmokeTestConstants.planName_searchfield, PlanName)) {
					throw new Exception("Not able to enter value in planName_search field");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/
	@When("^clicks search button on plan search page$")
	public void clicks_search_button_on_plan_search_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.plan_searchButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.plan_searchButton)) {
					throw new Exception("Not able to click plan_search Button");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/
	@Then("^plan results should be displayed$")
	public void plan_results_should_be_displayed(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			List<WebElement> planresults = chromeDriver.findElements(By.xpath(SmokeTestConstants.plan_rows));
			Assert.assertTrue(planresults.size() != 0);
			String expectedval = SmokeTestLibrary.getData(arg1, "PlanName").toLowerCase();
			boolean condition = chromeDriver.getPageSource().toLowerCase().contains(expectedval);
			Assert.assertTrue(condition);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks patient order status in left side menu$")
	public void User_clicks_patient_order_stauts_in_left_side_menu() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.patient_OrderStatus_LeftMenuButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.patientOrderStatus_LefttMenuButton)) {
					throw new Exception("Not able to click plan_search Button");
				}
			}
			boolean Alert_Condition = FrameworkLibrary.isElementPresents(SmokeTestConstants.patientOrderStatus_Alert_OK_Button);
			if (Alert_Condition) {
				if (isElementPresentVerification(SmokeTestConstants.patientOrderStatus_Alert_OK_Button)) {
					if (!isElementPresentVerifyClick(SmokeTestConstants.patientOrderStatus_Alert_OK_Button)) {
						throw new Exception("Not able to click patientOrderStatus_Alert_OK_Button ");
					}
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.patientOrderStatus_LefttMenuButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.patientOrderStatus_LefttMenuButton)) {
					throw new Exception("Not able to click patientOrderStatus_LefttMenuButton ");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User enters patient last name in the search field$")
	public void User_enters_patient_last_name_in_the_search_field(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
			if (isElementPresentVerification(SmokeTestConstants.patientOrderStatuts_patientSearchField)) {
				if (!clearAndEnterText(SmokeTestConstants.patientOrderStatuts_patientSearchField, LastName)) {
					throw new Exception("Not able to enter value in user name text field");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^clicks search button on patient order status page$")
	public void clicks_search_button_on_patient_order_status_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^patient order status results should be displayed$")
	public void patient_order_status_results_should_be_displayed(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.patientOrderStatus_Table)) {
				String expectedval = SmokeTestLibrary.getData(arg1, "LastName").toLowerCase();
				boolean condition = chromeDriver.getPageSource().toLowerCase().contains(expectedval);
				Assert.assertTrue(condition);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks prescriber search in left side navigation menu$")
	public void User_clicks_prescriber_search_in_left_side_navigation_menu() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.prescriberSearch_LeftSideNavButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.prescriberSearch_LeftSideNavButton)) {
					throw new Exception("Not able to click prescriberSearch_LeftSideNavButton");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User enters prescriber first name and last name on prescriber search page$")
	public void User_enters_prescriber_first_name_and_last_name_on_prescriber_search_page(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
			String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");

			if (isElementPresentVerification(SmokeTestConstants.prescriberSearch_FirstName)) {
				if (!clearAndEnterText(SmokeTestConstants.prescriberSearch_FirstName, FirstName)) {
					throw new Exception("Not able to enter value in FirstNames text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.prescriberSearch_LastName)) {
				if (!clearAndEnterText(SmokeTestConstants.prescriberSearch_LastName, LastName)) {
					throw new Exception("Not able to enter value in LastName text field");
				}
				isElementPresentVerifyClick(SmokeTestConstants.PrescriberSearch_stateSelectDrpDown);
				WebElement nullValue = chromeDriver.findElement(By.cssSelector(SmokeTestConstants.PrescriberSearch_stateNullValueSelector));
				WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
				wait.until(ExpectedConditions.elementToBeClickable(nullValue));
				nullValue.click();
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^clicks search on prescriber search page$")
	public void clicks_search_on_prescriber_search_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.prescriberSearch_SearchButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.prescriberSearch_SearchButton)) {
					throw new Exception("Not able to click prescriberSearch_SearchButton");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^prescriber search results should be displayed$")
	public void prescriber_search_results_should_be_displayed(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			/*if (isElementPresentVerification(SmokeTestConstants.prescriberSearch_Results)) {
                String expectedval = SmokeTestLibrary.getData(arg1, "LastName");
                log.info("prescriber last name is " + expectedval);
                Thread.sleep(5000);
                boolean condition = chromeDriver.getPageSource().toLowerCase().contains(expectedval);
                Assert.assertTrue(condition, "The prescriber search results are not displayed");
            }*/
			if (isElementPresentVerification(SmokeTestConstants.prescriber_table)) {
				List<WebElement> prescresults = chromeDriver.findElements(By.xpath(SmokeTestConstants.prescriberSearch_Results));
				Assert.assertTrue(prescresults.size()!=0);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks log out button in left side navigation menu$")
	public void User_clicks_log_out_button_in_left_side_navigation_menu() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(SmokeTestConstants.RxMS_logoutButton)) {
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} finally {
			if (isElementPresentVerification(SmokeTestConstants.RxMS_logoutButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.RxMS_logoutButton)) {
					throw new Exception("Not able to click RxMS_logoutButton");
				}
			}
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^User clicks this device on the logout alert$")
	public void click_this_device_on_logout_alert() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			chromeDriver.findElement(By.cssSelector(SmokeTestConstants.this_device_button_logout_cssSelector)).click();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should display patient search results$")
	public void system_should_display_patient_search_results() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.patient_table)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.patient_table));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^System should navigate to Intake Method Screen$")
	public void system_should_navigate_to_Intake_Method_Screen() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.intakeMethodTitle)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.intakeMethodTitle));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^A filling task should get created in the taskboard$")
	public void A_filling_task_should_get_created_in_the_taskboard() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(2000);
			int expectedNumberofFillingTasksAfterCompletingCE = NumberOfFillingTasks + 1;
			String ExpectedTextinFillingTaskboard = Integer.toString(expectedNumberofFillingTasksAfterCompletingCE);
			WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
			wait.until(ExpectedConditions.textToBePresentInElement(FrameworkLibrary.getElementByProperty(SmokeTestConstants.fillingTaskNumber, chromeDriver), ExpectedTextinFillingTaskboard));
			actualNumberofFillingTasksAfterCompletingCE = Integer.parseInt(getElementText(SmokeTestConstants.fillingTaskNumber));
			Assert.assertEquals(actualNumberofFillingTasksAfterCompletingCE, expectedNumberofFillingTasksAfterCompletingCE, "Filling task is not created after completing data review");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^Number of DR tasks should be decreased$")
	public void number_of_DR_tasks_should_be_decreased() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		String expectedDRNumafterDR = Integer.toString(DR_NumberOfTasksBeforeDE);
		WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
		try {
			wait.until(ExpectedConditions.textToBePresentInElement(FrameworkLibrary.getElementByProperty(SmokeTestConstants.DRNumberofTasks, chromeDriver), expectedDRNumafterDR));
		} catch (TimeoutException e) {
			log.info("DR task number is not decreased");
		}
		int actualNumberofDRtasksAfterDR = Integer.parseInt(FrameworkLibrary.getElementText(SmokeTestConstants.DRNumberofTasks));
		int expectedNumberofDRtasksAfterDR = DR_NumberOfTasksBeforeDE;
		try {
			Assert.assertEquals(actualNumberofDRtasksAfterDR, expectedNumberofDRtasksAfterDR);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^A clinical evaluation task should get created$")
	public void a_clinical_evaluation_task_should_get_created() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		int ExpectedNumberofCETasksAfterDR = NumberofCETasksBeforeDR + 1;
		try {
			String expectedCEafterDR = Integer.toString(ExpectedNumberofCETasksAfterDR);
			WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
			wait.until(ExpectedConditions.textToBePresentInElement(getElementByProperty(SmokeTestConstants.CETaskNumber, chromeDriver), expectedCEafterDR));
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} finally {
			int ActualNumberofCETasksAfterDR = Integer.parseInt((FrameworkLibrary.getElementText(SmokeTestConstants.CETaskNumber)));
			Assert.assertEquals(ActualNumberofCETasksAfterDR, ExpectedNumberofCETasksAfterDR);
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks CE in the task board$")
	public void User_clicks_CE_in_the_task_board() throws Exception {
		FrameworkLibrary.waitToClick(SmokeTestConstants.CETaskNumber).click();
		try {
			WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SmokeTestConstants.CE_Alert_Yes_Button)));
		} catch (TimeoutException e) {
		} finally {
			if (isElementPresents(SmokeTestConstants.CE_Alert_Yes_Button)) {
				isElementPresentVerifyClick(SmokeTestConstants.CE_Alert_Yes_Button);
			}
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^clicks select all for therapy review$")
	public void clicks_select_all_for_therapy_review() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			isElementPresentVerification(SmokeTestConstants.CE_Rxnumber);
			String[] rxnumStorenum = getElementText(SmokeTestConstants.CE_Rxnumber).split("-");
			String actualrxnum = rxnumStorenum[0];
			log.info(actualrxnum);
			log.info(dynamicrxnum);
			if (isElementPresentVerification(SmokeTestConstants.CE_selectAll_TherapyReview)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.CE_selectAll_TherapyReview)) {
					throw new Exception("Not able to click CE_selectAll_TherapyReview");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^clicks Override in CE screen$")
	public void clicks_Override_in_CE_screen() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			NumberOfFillingTasks = Integer.parseInt(FrameworkLibrary.getElementText(SmokeTestConstants.fillingTaskNumber));
			if (isElementPresentVerification(SmokeTestConstants.CE_OverrideButton)) {
				proxy.newHar();
				if (!isElementPresentVerifyClick(SmokeTestConstants.CE_OverrideButton)) {
					throw new Exception("Not able to click CE_OverrideButton");
				}
				waitForVisibility(SmokeTestConstants.patientOrderStatus_patientSearchButton);
				writeHarFile(workingFolder, "CE_Finish", row.getRowNum(), 14);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^Number of CE tasks should be decreased by one$")
	public void number_of_CE_tasks_should_be_decreased_by_one() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String expectedCENumafterCE = Integer.toString(NumberofCETasksBeforeDR);
			WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
			wait.until(ExpectedConditions.textToBePresentInElement(FrameworkLibrary.getElementByProperty(SmokeTestConstants.CETaskNumber, chromeDriver), expectedCENumafterCE));
			int actualNumberofCEtasksAfterDR = Integer.parseInt(FrameworkLibrary.getElementText(SmokeTestConstants.CETaskNumber));
			int expectedNumberofCEtasksAfterDR = NumberofCETasksBeforeDR;
			Assert.assertEquals(actualNumberofCEtasksAfterDR, expectedNumberofCEtasksAfterDR);

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^User clicks filling in the taskboard$")
	public void User_clicks_filling_in_the_taskboard() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.fillingTaskNumber)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.fillingTaskNumber)) {
					throw new Exception("Not able to click fillingTaskNumber");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^The system should display a message Use - the Mobile Device to complete Filling$")
	public void the_system_should_display_a_message_Use_the_Mobile_Device_to_complete_Filling() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(SmokeTestConstants.FillingTask_Message)));
			String actualFillMessage = chromeDriver.findElement(By.className(SmokeTestConstants.FillingTask_Message)).getText();
			log.info("The actual message is" + actualFillMessage);
			String expectedFillMessage = "USE THE MOBILE DEVICE TO COMPLETE FILLING.";
			Assert.assertTrue(actualFillMessage.equalsIgnoreCase(expectedFillMessage));
			log.info("The Fill message is displayed");
			wait.until(ExpectedConditions.elementToBeClickable(By.className(SmokeTestConstants.FillingTask_PopupOkButton))).click();

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^An Alert should be displayed - All changes will be lost Do you want to proceed$")
	public void handle_the_alert() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.cancelAlertMessage)) {

				String alertMessage = getElementText(SmokeTestConstants.cancelAlertMessage);
				Assert.assertTrue(alertMessage.toLowerCase().contains("all changes will be lost"));
				Assert.assertTrue(alertMessage.toLowerCase().contains("do you want to proceed?"));
				boolean Alert_Condition = FrameworkLibrary.isElementPresents(SmokeTestConstants.patientOrderStatus_Alert_OK_Button);
				Assert.assertTrue(Alert_Condition);
				if (!isElementPresentVerifyClick(SmokeTestConstants.CancelAlert_NoButton)) {
					throw new Exception("Not able to click CancelAlert_NoButton");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks patient order status button in navigation panel$")
	public void click_pos_navigation_panel() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(2000);
			SmokeTestStepDef.user_hits_ctrl_s_hot_key();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks Home button in the navigation panel$")
	public void homeButton_click() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.home_Button)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.home_Button)) {
					throw new Exception("Not able to click home_Button");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks DE button in the taskboard$")
	public void DE_click() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.DENumberofTasks)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.DENumberofTasks)) {
					throw new Exception("Not able to click DENumberofTasks");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clcks DR button in the taskboard$")
	public void DR_click() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.DataReview_RightMenuButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.DataReview_RightMenuButton)) {
					throw new Exception("Not able to click DataReview_RightMenuButtons");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}


	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks CE task in the taskboard$")
	public void CE_click() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.CETaskNumber)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.CETaskNumber)) {
					throw new Exception("Not able to click CETaskNumber");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks PV in the taskboard$")
	public void PV_click() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.PV_Taskboard)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.PV_Taskboard)) {
					throw new Exception("Not able to click PV_Taskboard");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks Back button on DE page$")
	public void DEBack_Click() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.DE_backButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.DE_backButton)) {
					throw new Exception("Not able to click DE_backButton");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks Back button on DR page$")
	public void DRBack_Click() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.DR_backButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.DR_backButton)) {
					throw new Exception("Not able to click DR_backButton");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("User clicks cancel button on DE page")
	public void DE_Cancel_Click() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.DE_CancelButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.DE_CancelButton)) {
					throw new Exception("Not able to click DE_CancelButton");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("User clicks cancel button on DR page")
	public void DR_Cancel_Click() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.DR_Cancel)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.DR_Cancel)) {
					throw new Exception("Not able to click DR_Cancel button");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User clicks perform data entry hyperlink$")
	public void user_clicks_perform_data_entry_hyperlink() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.POS_DE_HyperLink)) {
				proxy.newHar();
				if (!isElementPresentVerifyClick(SmokeTestConstants.POS_DE_HyperLink)) {
					throw new Exception("Not able to click POS_DE_HyperLink");
				}
				waitForVisibility(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN);
				writeHarFile(workingFolder, "DataEntry", row.getRowNum(), 7);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^User clicks perform data review hyperlink$")
	public void click_DR_Hyperlink() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.POS_DR_HyperLink)) {
				proxy.newHar();
				if (!isElementPresentVerifyClick(SmokeTestConstants.POS_DR_HyperLink)) {
					throw new Exception("Not able to click POS_DR_HyperLink");
				}
				waitForVisibility(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN);
				writeHarFile(workingFolder, "Data_Review", row.getRowNum(), 9);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^User clicks perform clinical evaluation hyperlink$")
	public void click_CE_Hyperlink() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.POS_CE_Hyperlink)) {
				proxy.newHar();
				if (!isElementPresentVerifyClick(SmokeTestConstants.POS_CE_Hyperlink)) {
					throw new Exception("Not able to click POS_CE_Hyperlink");
				}
				waitForVisibility(SmokeTestConstants.CE_Rxnumber);
				writeHarFile(workingFolder, "CE-Interaction", row.getRowNum(), 11);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^click on CE med history$")
	public void click_on_CE_med_history() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.CE_MED_HISTORY)) {
				proxy.newHar();
				if (!isElementPresentVerifyClick(SmokeTestConstants.CE_MED_HISTORY)) {
					throw new Exception("Not able to click POS_CE_Hyperlink");
				}
				waitForVisibility(SmokeTestConstants.CE_MED_HISTORY_DATA);
				writeHarFile(workingFolder, "CE-MedHistory", row.getRowNum(), 12);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	@Then("^click on CE clinical History$")
	public void click_on_CE_clinical_History() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.CE_CLINICAL_HISTORY)) {
				proxy.newHar();
				if (!isElementPresentVerifyClick(SmokeTestConstants.CE_CLINICAL_HISTORY)) {
					throw new Exception("Not able to click POS_CE_Hyperlink");
				}
				waitForVisibility(SmokeTestConstants.CE_CLINICAL_HISTORY_DATA);
				writeHarFile(workingFolder, "CE-ClinicalHistory", row.getRowNum(), 13);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	@Then("^click on CE interaction$")
	public void click_on_CE_interaction() throws Exception { 
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.CE_Interaction)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.CE_Interaction)) {
					throw new Exception("Not able to click POS_CE_Hyperlink");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^The In progress link for current prescription should be clicked$")
	public void the_in_progress_link_for_current_prescription_should_be_clicked(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			i_click_search_button_on_patient_order_status();
			Thread.sleep(5000);
			SmokeTestLibrary.hotkeyAction(Keys.ALT, "S", chromeDriver);
			Thread.sleep(5000);
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
			String expintakeDate = SmokeTestStepDef.intakenextdate;
			/*List<WebElement> elements = chromeDriver.findElements(By.xpath("//*[@id='patient-order-status-list']/table/tbody/tr[contains(@id,'patient-')]"));*/
			List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));
			//List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[td[md-icon[@aria-hidden='false']]]"));
			log.info(elements.size());
			for (int i = 0; i < elements.size(); i++) {
				log.info(elements.get(i).getText());
				if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(possiblepickupTime1)) {
					elements.get(i).findElement(By.linkText("In Progress")).click();
					break;
				} else if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(pickuptime)) {
					elements.get(i).findElement(By.linkText("In Progress")).click();
					break;
				} else if (elements.get(i).getText().contains(expintakeDate) && elements.get(i).getText().contains(possiblepickupTime1)) {
					elements.get(i).findElement(By.linkText("In Progress")).click();
					break;
				} else {
					log.info("The" + i + "prescription is not current");
					if (i == elements.size() - 1) {
						Assert.fail("prescription not found.");
					}
				}
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^The prescription status should be In Progress -Reviewed$")
	public void verify_the_prescription_status_to_reviewed(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
			String expintakeDate = SmokeTestStepDef.intakenextdate;
			//List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[td[md-icon[@aria-hidden='false']]]"));
			List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));
			log.info(elements.size());
			for (int i = 0; i < elements.size(); i++) {
				log.info(elements.get(i).getText());
				if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(possiblepickupTime1)) {
					Assert.assertTrue(elements.get(i).getText().toLowerCase().contains("reviewed"));
					break;
				} else if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(pickuptime)) {
					Assert.assertTrue(elements.get(i).getText().toLowerCase().contains("reviewed"));
					break;
				} else if (elements.get(i).getText().contains(expintakeDate) && elements.get(i).getText().contains(possiblepickupTime1)) {
					Assert.assertTrue(elements.get(i).getText().toLowerCase().contains("reviewed"));
					break;
				} else {
					log.info("The" + i + "prescription is not current");
					if (i == elements.size() - 1) {
						Assert.fail("prescription not found.");
					}
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/*This message is used to validate the prescription status in patient order status after completing Intake, DE, DR, CE, Fill, PV and Sold tasks.
	 * The expected status should be passed as a parameter from the feature file step.
	 *
	 *
	 */

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@After
	@Then("^User closes the application$")
	public void User_closes_the_application() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String harReport = config.getProperty("isHarReport").toString();
			boolean isHarReport = Boolean.parseBoolean(harReport);
			if (isHarReport) {
				writeReport();
			}
			if (SmokeTestLibrary.quitRxmsApp()) {
				log.info("RxMS application is closed");
			} else if (SmokeTestLibrary.quitFillApp()) {
				log.info("Fill application is closed");
			} else if (SmokeTestLibrary.quitPOSApp()) {
				log.info("POS website is closed");
			} else {
				log.info("no webdriver instance is running");
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method :
	 * author : Photon
	 * Date :
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^enters c2 drug$")
	public void enterc2drug(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String Date = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			String DAW = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");

			String Quantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
			String Directions = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Directions");
			String DaysSupply = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DaysSupply");

			if (!isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {

			}
			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, Date)) {
					throw new Exception("Not able to enter value in user name text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, DAW)) {
					throw new Exception("Not able to enter value in user name text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, DrugName)) {
					throw new Exception("Not able to enter value in DrugName text field");
				}
			}

			Thread.sleep(2000);
			Actions upArrow = new Actions(chromeDriver);
			Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
			PressUpArrow.perform();
			Thread.sleep(1000);

			if (isElementPresentVerification(SmokeTestConstants.Quantity_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Quantity_field, Quantity)) {
					throw new Exception("Not able to enter value in Quantity text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.Directions_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Directions_field, Directions)) {
					throw new Exception("Not able to enter value in Directions text field");
				}
			}
			ExpectedProductName = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DrugName_Field, chromeDriver).getAttribute("value");
			log.info("Drug name is" + ExpectedProductName);
			ExpectedDirections = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Directions_field, chromeDriver).getAttribute("value");
			ExpectedProduct_quantity = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Quantity_field, chromeDriver).getAttribute("value");
			log.info("the product quantity in DE is" + ExpectedProduct_quantity);
			ExpectedProduct_quantityDisp = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Quantity_disp, chromeDriver).getAttribute("value");
			log.info("the product quantity in DE is" + " " + ExpectedProduct_quantityDisp);
			ExpectedProduct_DaysSupply = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Days_Supply, chromeDriver).getAttribute("value");
			ExpectedProduct_refills = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Refills_field, chromeDriver).getAttribute("value");
			ExpectedProduct_RxExpDate = FrameworkLibrary.getElementByProperty(SmokeTestConstants.RxExpiration_date, chromeDriver).getAttribute("value");
			ExpectedProduct_DAW = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Product_DAW, chromeDriver).getAttribute("value");
			ExpectedProduct_DrugExpDate = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DrugExpiryDate_Field, chromeDriver).getAttribute("value");
			ExpectedProduct_OriginalDate = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Product_OriginalDate, chromeDriver).getAttribute("value");
			ExpectedDirections = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Directions_field, chromeDriver).getAttribute("value");
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User hits alt plus t hot key$")
	public void hit_ctrl_plus_t() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(2000);
			SmokeTestLibrary.hotkeyAction(Keys.ALT, "t", chromeDriver);
		} catch(Exception e){
			 
			takeScreenShot(methodName);
		}  
	}

	/**
	 * This method is used to click delete rx in the patient order status page. This method should be used after selecting the prescription to delete in
	 * preceding step.
	 */

	@When("^User clicks delete prescription in patient order status$")
	public void click_delete_rx_button_for_current_prescription() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			
			if (isElementPresentVerification(SmokeTestConstants.POS_delete_rx_Button)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.POS_delete_rx_Button)) {
					throw new Exception("Not able to click POS_delete_rx_Button");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^User validates that payload in interoperability tracking table has all mandatory fields$")
	public void user_validates_that_payload_in_interoperability_tracking_table_has_all_mandatory_fields() throws Exception {

	}

	@When("^clicks delete rx button on the alert message$")
	public void click_delete_rx_alert() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			proxy.newHar();
			if (isElementPresentVerification(SmokeTestConstants.POS_deleteRxButtononAlert)) {
				isElementPresentVerifyClick(SmokeTestConstants.POS_deleteRxButtononAlert);
			}
			//waitForVisibility(SmokeTestConstants.patientSearch_rows);
			writeHarFile(workingFolder, "deleteRx", row.getRowNum(), 8);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method : 
	 * author : Photon
	 * Date :  
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^User selects pickup time as waiting$")
	public void User_selects_pickup_time_as_waiting() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.radio_Waiting_Button)) {
				isElementPresentVerifyClick(SmokeTestConstants.radio_Waiting_Button);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	/****************************************************************************
	 * Method : 
	 * author : Photon
	 * Date :  
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^selects origin code as Scan$")
	public void selects_origin_code_as_Scan() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.radio_Scan_Button)) {
				isElementPresentVerifyClick(SmokeTestConstants.radio_Scan_Button);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}


	/**
	 * This method will create new random patient with last name, first name, phone number and date of birth.
	 * @throws Throwable
	 */
	@When("^User enters random patient First Name and Last Name$")
	public void userEntersRandomPatientFirstNameAndLastName() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			lastName = randomLastNameGenerator();
			firstName = randomFirstNameGenerator();
			phoneNumber = randomPhoneNumberGenerator();
			patientDOB = randomDOBGenerator();

			if (isElementPresentVerification(SmokeTestConstants.Patient_LastName)) {
				if (!clearAndEnterText(SmokeTestConstants.Patient_LastName, lastName)) {
					throw new Exception("Not able to enter value in LastName text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
				if (!clearAndEnterText(SmokeTestConstants.Patient_FirstName, firstName)) {
					throw new Exception("Not able to enter value in FirstName text field");
				}
			}
			if (isElementPresentVerification(IntakeConstants.Patient_Phone_Number_Feild)) {
				WebElement element = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild));
				element.sendKeys(phoneNumber);
			}
			if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB)) {
				if (!clearAndEnterText(IntakeConstants.PATIENT_SEARCH_DOB, patientDOB)) {
					throw new Exception("Not able to enter value in LastName text field");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/**
	 * This method will verify patient search results are displayed.
	 * @throws Throwable
	 */
	@Then("^System should display patient search results for the random patient$")
	public void systemShouldDisplayPatientSearchResultsForTheRandomPatient() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String message = "0 Results found. Please refine your search.";
			if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_RESULTS_MESSAGE)) {
				String resultMsg = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_RESULTS_MESSAGE)).getText();
				Assert.assertTrue(resultMsg.equals(message), "results message is not shown where there are no patient result matches in patient search page");
				Thread.sleep(5000);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verifies user should navigate to new patient registration page
	 * @throws Throwable
	 */
	@Then("^System should navigate to new patient registration page$")
	public void systemShouldNavigateToNewPatientRegistrationPage() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification( SmokeTestConstants.PATIENT_REGISTRATION_PAGE)){
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	@Then("^user click on the update button to update patient information$")
	public void user_click_on_the_update_button_to_update_patient_information() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(AccessManagementConstants.Patient_View_Update_Button)) {
				isElementPresentVerifyClick(AccessManagementConstants.Patient_View_Update_Button);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/****************************************************************************
	 * Method : To Verify Login into RxMs application
	 * author : Photon
	 * Date :   11 / Jan / 2017
	 * Modifier : Jeyaprakash
	 * Modification Data : 01 / May / 2017
	 ******************************************************************************/

	@When("^user enter approximate weight to update$")
	public void user_enter_approximate_weight_to_update() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Text_approximate_weight)) {
				if (!clearAndEnterText(SmokeTestConstants.Text_approximate_weight, "140")) {
					throw new Exception("Not able to enter value in user name text field");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/**
	 * This method will verify the patient lastname, firstname and phonenumber fields are same from the search page.
	 * @throws Throwable
	 */
	@And("^User validates the random patient lastname,firstname and phonenumber$")
	public void userValidatesTheRandomPatientLastnameFirstnameAndPhonenumber() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(SmokeTestConstants.PATIENT_REGISTRATION_PAGE_LAST_NAME)&&isElementPresentVerification(SmokeTestConstants.PATIENT_REGISTRATION_PAGE_FIRST_NAME)&& isElementPresentVerification(SmokeTestConstants.PATIENT_REGISTRATION_PAGE_PHONE_NUMBER)&&isElementPresentVerification(SmokeTestConstants.PATIENT_REGISTRATION_PAGE_DOB)){
				Assert.assertEquals(lastName.toUpperCase(),getElementText(SmokeTestConstants.PATIENT_REGISTRATION_PAGE_LAST_NAME).toUpperCase());
				Assert.assertEquals(firstName.toUpperCase(),getElementText(SmokeTestConstants.PATIENT_REGISTRATION_PAGE_FIRST_NAME).toUpperCase());
				Assert.assertEquals(phoneNumber,getElementText(SmokeTestConstants.PATIENT_REGISTRATION_PAGE_PHONE_NUMBER));
				Assert.assertEquals(patientDOB,getElementText(SmokeTestConstants.PATIENT_REGISTRATION_PAGE_DOB));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method will select gender for the patient
	 * @param gender
	 * @throws Throwable
	 */
	@Then("^User enters \"([^\"]*)\" for gender field$")
	public void userEntersForGenderField(String gender) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if (isElementPresentVerification(SmokeTestConstants.PATIENT_REGISTRATION_GENDER_SELECT)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.PATIENT_REGISTRATION_GENDER_SELECT))
					throw new Exception("Not able to click State");
			}

			List<WebElement> genderList = FrameworkLibrary.chromeDriver.findElements(By.xpath(SmokeTestConstants.PATIENT_REGISRATION_GENDER_LIST));
			for (int i = 0; i < genderList.size(); i++) {

				if (genderList.get(i).getAttribute("value").equals(gender)) {
					genderList.get(i).click();
					break;
				}
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
		
	}

	/**
	 * This method will click on next button using Alt plus N hot key.
	 * @throws Throwable
	 */
	@And("^User clicks on next button using Alt plus N hot key$")
	public void userClicksOnNextButtonUsingAltPlusNHotKey() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("n").keyUp(Keys.ALT).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verifies user is on clinical informatino section
	 * @throws Throwable
	 */
	@Then("^User is on clinical information section$")
	public void userIsOnClinicalInformationSection() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(SmokeTestConstants.PATIENT_REGISTRATION_CLINICAL_INFORMATION_SECTION)){
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method will select confirm with patient radio button.
	 * @throws Throwable
	 */
	@And("^Selects confirm with patient radio button$")
	public void selectsConfirmWithPatientRadioButton() throws Exception {

		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(SmokeTestConstants.PATIENT_REGISTRATION_CLINICAL_INFORMATION_CONFIRM_WITH_PATIENT)){
				if(!isElementPresentVerifyClick(SmokeTestConstants.PATIENT_REGISTRATION_CLINICAL_INFORMATION_CONFIRM_WITH_PATIENT)){
					throw new Exception("Not able to click confirm with patient button in clinical information");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			 
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verifies user is on additional medication section
	 * @throws Throwable
	 */
	@Then("^user is on additional medications section$")
	public void userIsOnAdditionalMedicationsSection() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(SmokeTestConstants.PATIENT_REGISTRATION_ADDITIONAL_MEDICATIONS)){
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method selects no button for additional medication
	 * @throws Throwable
	 */
	@And("^selects no button for additional medication$")
	public void selectsNoButtonForAdditionalMedication() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(SmokeTestConstants.PATIENT_REGISTRATION_ADDITINAL_MEDICATINOS_NO_MEDS)){
				if(!isElementPresentVerifyClick(SmokeTestConstants.PATIENT_REGISTRATION_ADDITINAL_MEDICATINOS_NO_MEDS)){
					throw new Exception("Not able to no button for additional medication");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verifies user is on third party plans section.
	 * @throws Throwable
	 */
	@Then("^User is on third party plans section$")
	public void userIsOnThirdPartyPlansSection() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(SmokeTestConstants.PATIENT_REGISTRATION_THIRD_PARTY_PLANS)){
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/**
	 * This method will select no plan or cash button for third party plans in third party plan section.
	 * @throws Throwable
	 */
	@And("^selects no plan or cash button for third party plans$")
	public void selectsNoPlanOrCashButtonForThirdPartyPlans() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(SmokeTestConstants.PATIENT_REGISTRATION_THIRD_PARTY_PLANS)){
				if(!isElementPresentVerifyClick(SmokeTestConstants.PATIENT_REGISTRATION_THIRD_PARTY_PLANS)){
					throw new Exception("Not able to no button for third party plans");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verifies user is on preferences section
	 * @throws Throwable
	 */
	@Then("^user is on preferences section$")
	public void userIsOnPreferencesSection() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(SmokeTestConstants.PATIENT_REGISTRATION_PREFERENCES_SECTION)){
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}

		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method will select snap cap for preferences to a new patient
	 * @throws Throwable
	 */
	@And("^selects snap cap for preferences$")
	public void selectsSnapCapForPreferences() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(SmokeTestConstants.PATIENT_REGISTRATION_PREFERENCES_SNAP_CAP)){
				if(!isElementPresentVerifyClick(SmokeTestConstants.PATIENT_REGISTRATION_PREFERENCES_SNAP_CAP)){
					throw new Exception("Not able to snap cap button for preferences");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method will click on save and exit button in new patient registration page
	 * @throws Throwable
	 */
	@Then("^User clicks on save and exit button to complete the registration \"([^\"]*)\"$")
	public void userClicksOnSaveAndExitButtonToCompleteTheRegistration(String args) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			proxy.newHar();
			if(isElementPresentVerification(SmokeTestConstants.PATIENT_REGISTRATION_SAVE_AND_EXIT_BUTTON)){
				if(!isElementPresentVerifyClick(SmokeTestConstants.PATIENT_REGISTRATION_SAVE_AND_EXIT_BUTTON)){
					throw new Exception("Not able to snap cap button for preferences");
				}
				if ("add".equalsIgnoreCase(args)) {
					waitForVisibility(SmokeTestConstants.Updated_Patient_Phonenumber);
					String elementText = getElementText(SmokeTestConstants.Updated_Patient_Phonenumber);
					writeHarFile(workingFolder, "Add_Patient", row.getRowNum(), 5);
				}
				else if ("update".equalsIgnoreCase(args)) {
					waitForVisibility(SmokeTestConstants.View_approximate_weight);
					String elementText = getElementText(SmokeTestConstants.View_approximate_weight);
					writeHarFile(workingFolder, "Update_Patient", row.getRowNum(), 6);
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
			Thread.sleep(4000);
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method enters new registered patient first name and last name in text fields
	 * @throws Throwable
	 */
	@When("^User enters newly registered patient First Name and Last Name$")
	public void userEntersNewlyRegisteredPatientFirstNameAndLastName() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (isElementPresentVerification(SmokeTestConstants.Patient_LastName)) {
				if (!clearAndEnterText(SmokeTestConstants.Patient_LastName, lastName)) {
					throw new Exception("Not able to enter value in LastName text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
				if (!clearAndEnterText(SmokeTestConstants.Patient_FirstName, firstName)) {
					throw new Exception("Not able to enter value in FirstName text field");
				}
			}
			if (isElementPresentVerification(IntakeConstants.Patient_Phone_Number_Feild)) {
				WebElement element = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild));
				element.sendKeys(phoneNumber);
			}
			if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB)) {
				if (!clearAndEnterText(IntakeConstants.PATIENT_SEARCH_DOB, patientDOB)) {
					throw new Exception("Not able to enter value in LastName text field");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/**
	 * This method enters new registered patient first name and last name in patient order status text fields
	 *
	 * @throws Throwable
	 */
	@And("^User enters newly registered patient Last Name in patient order status screen$")
	public void userEntersNewlyRegisteredPatientFirstNameAndLastNameInPatientOrderStatusScreen() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification((dataReviewConstants.patient_order_status_lastname))) {
				if (!clearAndEnterText(dataReviewConstants.patient_order_status_lastname, lastName)) {
					throw new Exception("Not able to enter value in LastName text field");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

}

