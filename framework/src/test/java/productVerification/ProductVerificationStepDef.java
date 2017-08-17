package productVerification;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.FrameworkLibrary;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import smokeTest.SmokeTestConstants;
import smokeTest.SmokeTestLibrary;
import smokeTest.SmokeTestStepDef;

import java.io.IOException;
import java.util.List;

public class ProductVerificationStepDef extends FrameworkLibrary {

	private static Log log = LogFactory.getLog(ProductVerificationStepDef.class);
	private static String methodName;


	public ProductVerificationStepDef() throws ConfigurationException, IOException {
		super();

	}

	/**
	 * This method validates the status of the prescription to be filled after performing the task on Assembly device.
	 * @param arg1 contains data of the status to be verfied
	 * @throws Exception
	 */
	@Then("^The prescription status should be In Progress-Filled$")
	public void the_prescription_status_should_be_in_progress_ready(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			SmokeTestStepDef.user_validates_the_status_as_and_selects_the_current_prescription("Filled", arg1);
			WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("In Progress")));
			SmokeTestStepDef.CurrentPrescriptionRow.findElement(By.linkText("In Progress")).click();
			if (isElementPresentVerification(SmokeTestConstants.DonutChartCancelButton)) {
				if(!isElementPresentVerifyClick(SmokeTestConstants.DonutChartCancelButton)){
					throw new Exception("User not able to click donut chart cancel button with the status as In Progress-Filled");
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
	 * This method will click on PV task in task board after fill has been completed.
	 * @throws Exception
	 */
	@When("^User clicks product verification task in the task board$")
	public void user_clicks_product_verification_task_in_the_task_board() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ProductVerificationConstants.PV_Taskboard)) {
				if(!isElementPresentVerifyClick(ProductVerificationConstants.PV_Taskboard)){
					throw new Exception("user not able to click PV task in task board");
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
	 * This method verifies system displayed product verification page.
	 * @throws Exception
	 */
	@Then("^The RxMS system should display product verification page$")
	public void the_RxMS_system_should_display_product_verification_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			isElementPresentVerification(SmokeTestConstants.productVerificationPageTitle);

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method will enter Rx number in PV page.
	 * @throws Exception
	 */
	@When("^User enters Rx number in PV window$")
	public void user_enters_Rx_number_in_PV_window() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ProductVerificationConstants.PV_rxNumberTextBox)) {
				if (!clearAndEnterText(ProductVerificationConstants.PV_rxNumberTextBox, SmokeTestStepDef.dynamicrxnum)) {
					throw new Exception(" User not able to enter Rx number value in PV page text field");
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
	 * This method will click verify button in PV page.
	 * @throws Exception
	 */
	@When("^User clicks Verify Button in PV page$")
	public void user_clicks_Verify_Button_in_PV_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ProductVerificationConstants.PV_VerifyButton)) {
				proxy.newHar();
				if(!isElementPresentVerifyClick(ProductVerificationConstants.PV_VerifyButton)){
					throw new Exception("User not able to click verify button in PV page");
				}
			}
				waitForVisibility(ProductVerificationConstants.PV_rxNumber);
				writeHarFile(workingFolder, "PV", row.getRowNum(), 18);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method will click accept button on PV page.
	 * @throws Exception
	 */
	@When("^User clicks accept on PV window$")
	public void user_clicks_accept_on_PV_window() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ProductVerificationConstants.PV_acceptButton)) {
				if(!isElementPresentVerifyClick(ProductVerificationConstants.PV_acceptButton)){
					throw new Exception("User not able to click accept button on PV page");
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
	 * This method validates the status of the prescription to be Ready after performing the PV task.
	 * @param arg1 contains data of the status to be verfied
	 * @throws Exception
	 */
	@When("^The status in patient order status should be changed to Ready$")
	public void the_status_in_patient_order_status_should_be_changed_to_In_Progress_Ready(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			SmokeTestStepDef.user_validates_the_status_as_and_selects_the_current_prescription("Ready", arg1);

			WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Ready")));
			SmokeTestStepDef.CurrentPrescriptionRow.findElement(By.linkText("Ready")).click();
			if (isElementPresentVerification(SmokeTestConstants.DonutChartCancelButton)) {
				if(!isElementPresentVerifyClick(SmokeTestConstants.DonutChartCancelButton)){
					throw new Exception("User not able to click cancel button with the status as Ready");
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
	 * This method validates the status of the prescription to be sold after performing sold task.
	 * @param arg1 contains data of the status to be verfied
	 * @throws Exception
	 */
	@Then("^The status in patient order status should be changed to Sold$")
	public void verify_sold_status_in_patient_order_status(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			SmokeTestStepDef.user_validates_the_status_as_and_selects_the_current_prescription("Sold", arg1);
			WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sold")));
			SmokeTestStepDef.CurrentPrescriptionRow.findElement(By.linkText("Sold")).click();
			if (isElementPresentVerification(SmokeTestConstants.DonutChartCancelButton)) {
				if(!isElementPresentVerifyClick(SmokeTestConstants.DonutChartCancelButton)){
					throw new Exception("User not able to click cancel button with the status as sold");
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
	 * This method will initiate browser to complete point of sale for the prescription.
	 * @throws Exception
	 */
	@When("^User completes the point of sale transaction$")
	public void user_completes_the_point_of_sale_transaction() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(5000);
			FrameworkLibrary.initiatePOSApp(SmokeTestStepDef.dynamicrxnum);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verifies that System should generate Rx number for current prescription and get drug info.
	 * @param arg1 contaons data about the value that needs to be verified.
	 * @throws Exception
	 */
	@Then("^System should generate Rx number for current prescription and get drug info$")
	public void System_should_generate_Rx_number_for_current_prescription_and_get_info(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			if(isElementPresentVerification(SmokeTestConstants.POS_patientNames)) {
				List<WebElement> list1 = chromeDriver.findElements(By.xpath(SmokeTestConstants.POS_patientNames));
				String expectedPatientName = SmokeTestLibrary.getData(arg1, "LastName").toUpperCase();
				String pickuptime = SmokeTestStepDef.currentPickupTime;
				String pickupdate = SmokeTestStepDef.IntakeDate;
				String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;

				for (int i = 0; i < list1.size(); i++) {
					if (list1.get(i).getText().contains(expectedPatientName)/* && list1.get(i).getText().contains(expectedPhoneNumber)*/) {
						String s = list1.get(i).getAttribute("id");
						String[] parts = s.split("-");
						String part2 = parts[1];
						List<WebElement> singlepresc = chromeDriver.findElements(By.xpath("//*[contains(@id,'single-prescription-" + part2 + "')]"));
						for (int z = 0; z < singlepresc.size(); z++) {
							Thread.sleep(5000);
							if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate) && singlepresc.get(z).getText().contains(pickuptime)) {
								Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("in progress"));
								String dyn = singlepresc.get(z).getAttribute("id");
								String[] dynamo = dyn.split("-");
								String part = dynamo[2];
								String Rxnumber = "//*[@id='single-prescription-" + part + "-" + z + "']/div[3]";
								String currentRxnumber = getElementText(Rxnumber);
								String[] rxnumberparts = currentRxnumber.split("-");
								SmokeTestStepDef.dynamicrxnum = rxnumberparts[0];
								Assert.assertTrue(getElementText(Rxnumber) != null);
							} else if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate) && singlepresc.get(z).getText().contains(possiblepickupTime1)) {
								Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("in progress"));
								String dyn = singlepresc.get(z).getAttribute("id");
								String[] dynamo = dyn.split("-");
								String part = dynamo[2];
								String Rxnumber = "//*[@id='single-prescription-" + part + "-" + z + "']/div[3]";
								String currentRxnumber = getElementText(Rxnumber);
								String[] rxnumberparts = currentRxnumber.split("-");
								SmokeTestStepDef.dynamicrxnum = rxnumberparts[0];
								Assert.assertTrue(getElementText(Rxnumber) != null);
							}

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

	/**
	 * This method clicks Add consult button on PV page.
	 * @throws Exception
	 */
	@When("^User clicks Add Consult Button on product verification page$")
	public void click_add_consult_button_on_PV() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ProductVerificationConstants.PV_AddConsultButton)) {
				if(!isElementPresentVerifyClick(ProductVerificationConstants.PV_AddConsultButton)){
					throw new Exception("User not able to Add consult button on PV page");
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
	 * This method verifies a message that System should display an alert message that this function cannot be completed please complete in ICplus.
	 * @throws Exception
	 */
	@Then("^System should display an alert message that this function cannot be completed please complete in ICplus$")
	public void validate_add_consult_alert_message() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ProductVerificationConstants.PV_addconsultfunctionMessage)) {
				String actualMessage = getElementText(ProductVerificationConstants.PV_addconsultfunctionMessage);

				Assert.assertTrue(actualMessage.contains("This function cannot be completed in the system."));
				Assert.assertTrue(actualMessage.contains("Please complete in IC+"));
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
	 * This method clicks Ok button on Add consult alert.
	 * @throws Exception
	 */
	@When("^User clicks ok button on add consult alert$")
	public void click_ok_button_on_add_consult_alert() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ProductVerificationConstants.PV_addConsultPopupOkButton)) {
				if(!isElementPresentVerifyClick(ProductVerificationConstants.PV_addConsultPopupOkButton)){
					throw new Exception("User not able to click Ok button on add consult alert");
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
	 * This method clicks cancel button on PV page.
	 * @throws Exception
	 */
	@When("^User clicks cancel button on product verification page$")
	public void click_cancel_button_on_pv_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ProductVerificationConstants.PV_cancelButton)) {
				if (!isElementPresentVerifyClick(ProductVerificationConstants.PV_cancelButton)) {
					throw new Exception("Not able to click cancel button on product verification page");
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
	 * This method verifies system displays enter Rx number page.
	 * @throws Exception
	 */
	@Then("^System displays enter rx number page$")
	public void validate_enterrxnumber_page_displayed() throws Exception {
		try {
			isElementPresentVerification(ProductVerificationConstants.PV_enterRxnumber_Label);

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} finally {
			Assert.assertTrue(isElementPresents(ProductVerificationConstants.PV_rxNumberTextBox));
		}
	}

	/**
	 * This method enters Rx number in PV page.
	 * @throws Exception
	 */
	@When("^enter rx number$")
	public void enter_rx_number() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerification(ProductVerificationConstants.PV_enterRxnumber_Label)) {
				if (!clearAndEnterText(ProductVerificationConstants.PV_rxNumberTextBox, "0246641")) {
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

	/**
	 * This method verifies System should display the reason for manual entry selected in filling task.
	 * @throws Exception
	 */
	@Then("^System should display the reason for manual entry selected in filling task$")
	public void validate_notification_PV() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String Notification = getElementText(ProductVerificationConstants.PV_Notifications);
			Assert.assertTrue(Notification.contains("Barcode will not scan"));
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verifies System should display the waiting indicator in pickuptime on PV page
	 * @throws Exception
	 */
	@Then("^System should display the waiting indicator in pickuptime on PV page$")
	public void validate_waiting_indicator() throws Exception  {
		try {
			isElementPresentVerification(ProductVerificationConstants.PV_waitingIndicator);

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/**
	 * This method will click image enlarge button on pv page.
	 * @throws Exception
	 */
	@When("^User clicks image enlarge button on pv page$")
	public void click_image_enlarge_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerification(ProductVerificationConstants.PV_enlargeImageButton)){
				if(!isElementPresentVerifyClick(ProductVerificationConstants.PV_enlargeImageButton)){
					throw new Exception("User not able to click image enlarge button on PV page");
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
	 * This method will verify system displayed enlarged image in PV page.
	 * @throws Exception
	 */
	@Then("^System should display enlarged image$")
	public void validate_enlarged_image() throws Exception  {
		try {
			isElementPresentVerification(ProductVerificationConstants.PV_fullScreenexit);

		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method clicks on close button on enlarged image in PV screen.
	 * @throws Exception
	 */
	@Then("^User clicks close button on enlarged image$")
	public void click_close_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			waitToClick(ProductVerificationConstants.PV_FULLSCREEN_IMAGE_CLOSE_BUTTON).click();
			if(isElementPresentVerification(ProductVerificationConstants.PV_FULLSCREEN_IMAGE_CLOSE_BUTTON)){
				if(!isElementPresentVerifyClick(ProductVerificationConstants.PV_FULLSCREEN_IMAGE_CLOSE_BUTTON)){
					throw new Exception("User not able to click close button on enlarged image");
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
	 * This method will click on exit full screen button in PV page.
	 * @throws Exception
	 */
	@When("^User clicks exit full screen button$")
	public void click_exit_full_screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ProductVerificationConstants.PV_fullScreenexit)) {
				if (!isElementPresentVerifyClick(ProductVerificationConstants.PV_fullScreenexit)) {
					throw new Exception("User not able to click exit full screen button in PV page");
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
	 * This method will verify that system will unzoom the enlarged image.
	 * @throws Exception
	 */
	@Then("^System should unzoom the enlarged image$")
	public void validate_image_unzoom() throws Exception  {
		try {
			isElementPresentVerification(ProductVerificationConstants.PV_enlargeImageButton);

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/**
	 * This method verifies system should display snap cap Icon and label in patient preferences
	 * @throws Exception
	 */
	@Then("System should display snap cap Icon and label in patient preferences")
	public void validate_snap_cap_in_pv() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Assert.assertTrue(getElementText(ProductVerificationConstants.PV_snapcap).equals("Snap cap"));
			isElementPresentVerification(ProductVerificationConstants.PV_snapcapIcon);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verifies generic text box should be blank in PV page.
	 * @throws Exception
	 */
	@Then("^Generic For text box should be blank$")
	public void generic_for_text_should_be_blank() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Assert.assertTrue(getElementText(ProductVerificationConstants.PV_generics) == null);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method validate user is on Product Verification screen.
	 * @throws Exception
	 */

	@Then("^the Product Verification screen user is viewing still remains open$")
	public void the_Product_Verification_screen_user_is_viewing_still_remains_open() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ProductVerificationConstants.PV_PAGE_TITLE)) {
				FrameworkLibrary.verifyTextPresentElectron(ProductVerificationConstants.PV_PAGE_TITLE, ProductVerificationConstants.PV_PAGE_TITLE_VALUE);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^User validates the status as Sold and selects the current prescription$")
	public void userValidatesTheStatusAsSoldAndSelectsTheCurrentPrescription(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			SmokeTestStepDef.user_validates_the_status_as_and_selects_the_current_prescription("Sold", arg1);
			WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sold")));
			SmokeTestStepDef.CurrentPrescriptionRow.findElement(By.linkText("Sold")).click();
			if (isElementPresentVerification(SmokeTestConstants.DonutChartCancelButton)) {
				if(!isElementPresentVerifyClick(SmokeTestConstants.DonutChartCancelButton)){
					throw new Exception("User not able to click cancel button with the status as sold");
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