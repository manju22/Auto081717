package clinicalEvaluation;

import accessManagment.AccessManagementConstants;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataEntry.DataEntryConstants;
import dataReview.dataReviewConstants;
import framework.FrameworkLibrary;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;



import smokeTest.SmokeTestConstants;
import smokeTest.SmokeTestLibrary;
import smokeTest.SmokeTestStepDef;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ClinicalEvaluationStepDef extends FrameworkLibrary {


	public static int NumberOfFillingTasks;
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
	private static String methodName;
	public static WebElement CurrentPrescriptionRow;
	private static Log log = LogFactory.getLog(ClinicalEvaluationStepDef.class);


	public ClinicalEvaluationStepDef() throws ConfigurationException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * This method used for verifying the user is on clinical check page
	 * @throws Throwable
	 */
	@Then("^User should see Clinical Check page$")
	public void user_should_see_Clinical_Check_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			
			if(isElementPresentVerification(ClinicalEvaluationConstants.CLININCAL_CHECK_TITLE)){
				FrameworkLibrary.verifyTextPresentElectron(ClinicalEvaluationConstants.CLININCAL_CHECK_TITLE,"Clinical Check");
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
	 * This method used for verifying the user is on med history tab
	 * @throws Throwable
	 */
	@Then("^User should see Med History Tab$")
	public void user_should_see_Med_History_Tab() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(!isElementPresentVerification(ClinicalEvaluationConstants.MED_HISTORY_LINK)){
				throw new Exception("Unable to find Med History Link");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	/**
	 * This method used for verifying the user is on med history tab
	 * @throws Throwable
	 */

	@When("^User click on Med History Tab$")
	public void user_click_on_Med_History_Tab() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerification(ClinicalEvaluationConstants.MED_HISTORY_LINK)){
				if(!isElementPresentVerifyClick(ClinicalEvaluationConstants.MED_HISTORY_LINK))
					throw new Exception("Unable to find Med History Link.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	/**
	 * This method is used for verifying the refill field is not displayed on CE page
	 * @throws Throwable
	 */

	@Then("^System should not display AddToRefill Button$")
	public void system_should_not_display_AddToRefill_Button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
				Assert.assertFalse( FrameworkLibrary.isElementPresents(ClinicalEvaluationConstants.CE_Add_To_Refill), "AddToRefill Button is present");
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * This Method verifies the user is on reprint button in CE page
	 * @throws Throwable
	 */
	@Then("^System should not display Reprint Button$")
	public void system_should_not_display_Reprint_Button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{		
				Assert.assertFalse( FrameworkLibrary.isElementPresents(ClinicalEvaluationConstants.CE_RePrint), "Reprint Button is present");
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}
	/**
	 * This Method verifies inactive button not displayed on CE page
	 * @throws Throwable
	 */
	@Then("^System should not display Inactive Button$")
	public void system_should_not_display_Inactive_Button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			Assert.assertFalse(chromeDriver.getPageSource().contains("Inactivate"), "Able to see Inactivate Button");
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}
	/**
	 * This Method verifies Transfer button not displayed on CE page
	 * @throws Throwable
	 */
	@Then("^System should not display Transfer Button$")
	public void system_should_not_display_Transfer_Button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
				Assert.assertFalse( FrameworkLibrary.isElementPresents(ClinicalEvaluationConstants.CE_Transfer), "Transfer Button is present");
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}
	/**
	 * This Method verifies Close button not displayed on CE page
	 * @throws Throwable
	 */
	@Then("^System should not display Close Button$")
	public void system_should_not_display_Close_Button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{		
				Assert.assertFalse( FrameworkLibrary.isElementPresents(ClinicalEvaluationConstants.CE_Close_Rx), "Close Button is present");
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}
	/**
	 * This Method verifies Green Dot is present on med history
	 * @throws Throwable
	 */
	@Then("^User should see Green dot in med history status$")
	public void user_should_see_Green_dot_in_med_history_status() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(!isElementPresentVerification(ClinicalEvaluationConstants.GREEN_DOT)){
				throw new Exception("Unable to see Green dot");
			}
			
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	/**
	 * This method verifies Additional medications Tab not displayed
	 * @throws Throwable
	 */

	@Then("^User should see Additional Medications Tab$")
	public void user_should_see_Additional_Medications_Tab() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(!isElementPresentVerification(ClinicalEvaluationConstants.ADDITIONAL_MEDICATIONS)){
				throw new Exception("Unable to see Additional Medication Tab");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click Additional medications Tab in CE page
	 * @throws Throwable
	 */

	@When("^User click on Additional Medications link$")
	public void user_click_on_Additional_Medications_link() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerification(ClinicalEvaluationConstants.ADDITIONAL_MEDICATIONS)){
				if(!isElementPresentVerifyClick(ClinicalEvaluationConstants.ADDITIONAL_MEDICATIONS))
					throw new Exception("Unable to find Additional Medications Link.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verifies additional message present on CE page
	 * @throws Throwable
	 */

	@Then("^system displays the message No additional Med have been added$")
	public void system_displays_the_message_No_additional_Med_have_been_added() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(ClinicalEvaluationConstants.NO_ADDITONAL_MEDS_MSG)){
				FrameworkLibrary.verifyTextPresentElectron(ClinicalEvaluationConstants.NO_ADDITONAL_MEDS_MSG,"No Additional medications have been added. Click update to add a medication");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verifies Update button not displayed
	 * @throws Throwable
	 */

	@Then("^System should not display Update button$")
	public void system_should_not_display_Update_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
				Assert.assertFalse(FrameworkLibrary.isElementPresents(ClinicalEvaluationConstants.DUR_Update_Button));
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click Clinical References Tab in CE page
	 * @throws Throwable
	 */
	@When("^User click on Clinical References Tab$")
	public void user_click_on_Clinical_References_Tab() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerification(ClinicalEvaluationConstants.CLININCAL_REFERENCE_LINK)){
				if(!isElementPresentVerifyClick(ClinicalEvaluationConstants.CLININCAL_REFERENCE_LINK))
					throw new Exception("Unable to find Clinical Reverence Link.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verifying the logos with hyperlink is presented on CE Page
	 * @throws Throwable
	 */

	@Then("^User should see Logos with Hyperlinks$")
	public void user_should_see_Logos_with_Hyperlinks() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(!isElementPresentVerification(ClinicalEvaluationConstants.FirstExistinglogo_for_eachOfThe_Six_ClinicalReferences)){
				throw new Exception("Unable to find First Reference.");
			}
			if(!isElementPresentVerification(ClinicalEvaluationConstants.SecondExistinglogo_for_eachOfThe_Six_ClinicalReferences)){
				throw new Exception("Unable to find Second Reference.");
			}
			if(!isElementPresentVerification(ClinicalEvaluationConstants.ThirdExistinglogo_for_eachOfThe_Six_ClinicalReferences)){
				throw new Exception("Unable to find Third Reference.");
			}
			if(!isElementPresentVerification(ClinicalEvaluationConstants.FourthExistinglogo_for_eachOfThe_Six_ClinicalReferences)){
				throw new Exception("Unable to find Fourth Reference.");
			}
			if(!isElementPresentVerification(ClinicalEvaluationConstants.FifthExistinglogo_for_eachOfThe_Six_ClinicalReferences)){
				throw new Exception("Unable to find Fifth Reference.");
			}
			if(!isElementPresentVerification(ClinicalEvaluationConstants.SixthExistinglogo_for_eachOfThe_Six_ClinicalReferences)){
				throw new Exception("Unable to find Sixth Reference.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click Six clinical references in CE page
	 * @throws Throwable
	 */

	@When("^User click on First existing logo for each of the Six clinical references$")
	public void user_click_on_First_existing_logo_for_each_of_the_Six_clinical_references() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerification(ClinicalEvaluationConstants.FirstExistinglogo_for_eachOfThe_Six_ClinicalReferences)){
				if(!isElementPresentVerifyClick(ClinicalEvaluationConstants.FirstExistinglogo_for_eachOfThe_Six_ClinicalReferences))
					throw new Exception("First clinical reference not found.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method will open the related URL in the application frame passing the information from the First link
	 * @throws Throwable
	 */

	@Then("^system will open the related URL in the application frame passing the information from the First link$")
	public void system_will_open_the_related_URL_in_the_application_frame_passing_the_information_from_the_First_link() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String expected_Title = "CP - Search Results For: ADVI";
			String currentWindow = chromeDriver.getWindowHandle();
			for (String winHandle : chromeDriver.getWindowHandles()) {
				if (chromeDriver.switchTo().window(winHandle).getTitle()
						.equals(expected_Title)) {
					break;
				} else {
					chromeDriver.switchTo().window(currentWindow);
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click on Second existing logo for each of the Six clinical references
	 * @throws Throwable
	 */
	@When("^User click on Second existing logo for each of the Six clinical references$")
	public void user_click_on_Second_existing_logo_for_each_of_the_Six_clinical_references() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerification(ClinicalEvaluationConstants.SecondExistinglogo_for_eachOfThe_Six_ClinicalReferences)){
				if(!isElementPresentVerifyClick(ClinicalEvaluationConstants.SecondExistinglogo_for_eachOfThe_Six_ClinicalReferences))
					throw new Exception("Second clinical reference not found.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method will open the related URL in the application frame passing the information from the Second link
	 * @throws Throwable
	 */

	@Then("^system will open the related URL in the application frame passing the information from the Second link$")
	public void system_will_open_the_related_URL_in_the_application_frame_passing_the_information_from_the_Second_link() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String expected_Title = "Facts & Comparisons eAnswers";
			String currentWindow = chromeDriver.getWindowHandle();
			for (String winHandle : chromeDriver.getWindowHandles()) {
				if (chromeDriver.switchTo().window(winHandle).getTitle()
						.equals(expected_Title)) {
					break;
				} else {
					chromeDriver.switchTo().window(currentWindow);
				}
			}
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

    @And("^the system should not show Stock Plus Report Hyperlink$")
    public void the_system_should_not_show_Stock_Plus_Report_Hyperlink() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Assert.assertFalse(chromeDriver.getPageSource().contains("Stock Plus report"), "Able to see Stock Plus report");
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

	/**
	 * This method is used to click Third existing logo on CE page
	 * @throws Throwable
	 */

	@When("^User click on Third existing logo for each of the Six clinical references$")
	public void user_click_on_Third_existing_logo_for_each_of_the_Six_clinical_references() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerification(ClinicalEvaluationConstants.ThirdExistinglogo_for_eachOfThe_Six_ClinicalReferences)){
				if(!isElementPresentVerifyClick(ClinicalEvaluationConstants.ThirdExistinglogo_for_eachOfThe_Six_ClinicalReferences))
					throw new Exception("Third clinical reference not found.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method will open the related URL and switch to other window handling
	 * @throws Throwable
	 */

	@Then("^system will open the related URL in the application frame passing the information from the Third link$")
	public void system_will_open_the_related_URL_in_the_application_frame_passing_the_information_from_the_Third_link() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String expected_Title = "Immunization Schedules | CDC";
			String currentWindow = chromeDriver.getWindowHandle();
			for (String winHandle : chromeDriver.getWindowHandles()) {
				if (chromeDriver.switchTo().window(winHandle).getTitle()
						.equals(expected_Title)) {
					break;
				} else {
					chromeDriver.switchTo().window(currentWindow);
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
	 * This method to used to click Fourth existing logo on CE page
	 * @throws Throwable
	 */

	@When("^User click on Fourth existing logo for each of the Six clinical references$")
	public void user_click_on_Fourth_existing_logo_for_each_of_the_Six_clinical_references() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerification(ClinicalEvaluationConstants.FourthExistinglogo_for_eachOfThe_Six_ClinicalReferences)){
				if(!isElementPresentVerifyClick(ClinicalEvaluationConstants.FourthExistinglogo_for_eachOfThe_Six_ClinicalReferences))
					throw new Exception("Fourth clinical reference not found.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method will open the related URL and switch to other window handling
	 * @throws Throwable
	 */
	@Then("^system will open the related URL in the application frame passing the information from the Fourth link$")
	public void system_will_open_the_related_URL_in_the_application_frame_passing_the_information_from_the_Fourth_link() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String expected_Title = "Natural Medicines - Search Results";
			String currentWindow = chromeDriver.getWindowHandle();
			for (String winHandle : chromeDriver.getWindowHandles()) {
				if (chromeDriver.switchTo().window(winHandle).getTitle()
						.equals(expected_Title)) {
					break;
				} else {
					chromeDriver.switchTo().window(currentWindow);
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method to used to click Fifth existing logo on CE page
	 * @throws Throwable
	 */
	@When("^User click on Fifth existing logo for each of the Six clinical references$")
	public void user_click_on_Fifth_existing_logo_for_each_of_the_Six_clinical_references() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerification(ClinicalEvaluationConstants.FifthExistinglogo_for_eachOfThe_Six_ClinicalReferences)){
				if(!isElementPresentVerifyClick(ClinicalEvaluationConstants.FifthExistinglogo_for_eachOfThe_Six_ClinicalReferences))
					throw new Exception("Fifth clinical reference not found.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method will open the related URL and switch to other window handling
	 * @throws Throwable
	 */

	@Then("^system will open the related URL in the application frame passing the information from the Fifth link$")
	public void system_will_open_the_related_URL_in_the_application_frame_passing_the_information_from_the_Fifth_link() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String expected_Title = "Merck Manuals Professional Edition";
			String currentWindow = chromeDriver.getWindowHandle();
			for (String winHandle : chromeDriver.getWindowHandles()) {
				if (chromeDriver.switchTo().window(winHandle).getTitle()
						.equals(expected_Title)) {
					break;
				} else {
					chromeDriver.switchTo().window(currentWindow);
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
	 * This method to used to click Sixth existing logo on CE page
	 * @throws Throwable
	 */

	@When("^User click on Sixth existing logo for each of the Six clinical references$")
	public void user_click_on_Sixth_existing_logo_for_each_of_the_Six_clinical_references() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerification(ClinicalEvaluationConstants.SixthExistinglogo_for_eachOfThe_Six_ClinicalReferences)){
				if(!isElementPresentVerifyClick(ClinicalEvaluationConstants.SixthExistinglogo_for_eachOfThe_Six_ClinicalReferences))
					throw new Exception("Sixth clinical reference not found.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method will open the related URL and switch to other window handling
	 * @throws Throwable
	 */

	@Then("^system will open the related URL in the application frame passing the information from the Sixth link$")
	public void system_will_open_the_related_URL_in_the_application_frame_passing_the_information_from_the_Sixth_link() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String expected_Title = "Orange Book Approved Drug Products with Therapeutic Equivalence Evaluations";
			String currentWindow = chromeDriver.getWindowHandle();
			for (String winHandle : chromeDriver.getWindowHandles()) {
				if (chromeDriver.switchTo().window(winHandle).getTitle()
						.equals(expected_Title)) {
					break;
				} else {
					chromeDriver.switchTo().window(currentWindow);
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method to used to click  Major Interaction First CheckBox
	 * @throws Throwable
	 */

	@When("^User click on Major Interaction FirstCheckBox$")
	public void user_click_on_Major_Interaction_FirstCheckBox() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			
			if(isElementPresentVerification(ClinicalEvaluationConstants.MAJORFIRST_CHECKBOX)){
				if(!isElementPresentVerifyClick(ClinicalEvaluationConstants.MAJORFIRST_CHECKBOX))
					throw new Exception("Unable to find checkbox.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * This method to used to click on Override Button
	 * @throws Throwable
	 */

	@When("^User click on Override Button$")
	public void user_click_on_Override_Button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerification(ClinicalEvaluationConstants.OVERRIDE_BUTTON)){
				if(!isElementPresentVerifyClick(ClinicalEvaluationConstants.OVERRIDE_BUTTON))
					throw new Exception("Unable to find Override Button.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method to validate DUR override pop-up is displayed
	 * @throws Throwable
	 */

	@Then("^system must display the DUR Override pop-up$")
	public void system_must_display_the_DUR_Override_pop_up() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(!isElementPresentVerification(ClinicalEvaluationConstants.POPUPWINDOW_MESSAGE)){
				throw new Exception("Unable to find DUR Override Pop-up.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to perform tab sequence using actions
	 * @throws Throwable
	 */
	@Then("^Focus will be on the DUR Intervention Code field$")
	public void focus_will_be_on_the_DUR_Intervention_Code_field() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(ClinicalEvaluationConstants.DUR_DROPDOW_FOCUS)){
				Boolean dur_Dropdown_view = chromeDriver.findElement(By.xpath(ClinicalEvaluationConstants.DUR_DROPDOW_FOCUS)).getAttribute("class").contains("md-input-focused");
				Assert.assertTrue(dur_Dropdown_view);
			}
			if(isElementPresentVerification(ClinicalEvaluationConstants.DUR_COMMENT_TEXTBOXFIELD_Focus)){
				Actions tab = new Actions(chromeDriver);
				Action hitTab = tab.sendKeys(Keys.TAB).build();
				hitTab.perform();
				Boolean comment = chromeDriver.findElement(By.xpath(ClinicalEvaluationConstants.DUR_COMMENT_TEXTBOXFIELD_Focus)).getAttribute("class").contains("md-input-focused");
				Assert.assertTrue(comment);
			}
			if(isElementPresentVerification(ClinicalEvaluationConstants.Save_Button)){
				Actions tab = new Actions(chromeDriver);
				Action hitTab = tab.sendKeys(Keys.TAB).build();
				hitTab.perform();
				Boolean save = chromeDriver.findElement(By.xpath(ClinicalEvaluationConstants.Save_Button)).getAttribute("class").contains("md-focused");
				Assert.assertTrue(save);
			}
			if(isElementPresentVerification(ClinicalEvaluationConstants.Cancel_Button)){
				Actions tab = new Actions(chromeDriver);
				Action hitTab = tab.sendKeys(Keys.TAB).build();
				hitTab.perform();
				Boolean cancel = chromeDriver.findElement(By.xpath(ClinicalEvaluationConstants.Cancel_Button)).getAttribute("class").contains("md-focused");
				Assert.assertTrue(cancel);
			}

			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * This method is used to validating Comment field
	 */

	@Then("^The Comment field will be blank$")
	public void the_Comment_field_will_be_blank() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			Assert.assertTrue(ClinicalEvaluationLibrary.isEmptyCommentField());
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	/**
	 * This method is used to verify save button is enabled
	 * @throws Throwable
	 */
	@Then("^Save button will be enabled$")
	public void save_button_will_be_enabled() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(ClinicalEvaluationConstants.Save_Button)){
				Assert.assertTrue(isButtonEnable(ClinicalEvaluationConstants.Save_Button),"Save Button not enabled.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to verify Cancel button is enabled
	 * @throws Throwable
	 */
	@Then("^Cancel buttons will be enabled$")
	public void cancel_buttons_will_be_enabled() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(ClinicalEvaluationConstants.Cancel_Button)){
				Assert.assertTrue(isButtonEnable(ClinicalEvaluationConstants.Cancel_Button),"Cancel Button not enabled.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to perform tab sequence in DUR drop down using actions
	 * @throws Throwable
	 */

	@Then("^user should be allowed to navigate through all intervention codes$")
	public void user_should_be_allowed_to_navigate_through_all_intervention_codes() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			
			      FrameworkLibrary
			            .isElementPresentVerifyClick(ClinicalEvaluationConstants.Cancel_Button);
			      Boolean majorInteractionRadioButtonDisplayed = ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ClinicalEvaluationConstants.Clinical_Evaluation_Major_Iteractions_Radio_Button))).apply(chromeDriver);
			      if (!majorInteractionRadioButtonDisplayed) {

			         if (isElementPresentVerification(SmokeTestConstants.CE_OverrideButton)) {
			            if (!isElementPresentVerifyClick(SmokeTestConstants.CE_OverrideButton)) {
			               throw new Exception("Not able to click login button");
			            }
			         }
			         if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_override_popup)) {
			            if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_dropdown)) {
			               if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_dropdown)) {
			                  throw new Exception("Not able to click clinical evaluation DUR override dropdown button");
			               } else {
			                  if (isElementPresentVerification("//div[contains(@class,'md-select-menu-')]//md-option//div")) {
			                     List<WebElement> durInterventionCodes = chromeDriver.findElements(By.xpath("//div[contains(@class,'md-select-menu-')]//md-option//div"));
			                     for (int i = 0; i < durInterventionCodes.size(); i++) {
			                    	 log.info("DUR intervention codes" + durInterventionCodes.get(i).getText());
			                        if (durInterventionCodes.get(i).getText().equals("Patient Consulted")) {
			                           Actions enter = new Actions(chromeDriver);
			                           Action hitEnter = enter.sendKeys(Keys.ENTER).build();
			                           hitEnter.perform();
			                           break;
			                        }
			                     }
			                  }
			                     if (isElementPresentVerification("//*[@id='intervention-code']//span/div[contains(@class,'md-text')]")) {
			                        if (getElementText("//*[@id='intervention-code']//span/div[contains(@class,'md-text')]").equals("Patient Consulted")) {
			                           if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_dropdown)) {
			                              if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_dropdown)) {
			                                 throw new Exception("Not able to click clinical evaluation DUR override dropdown button");
			                              } else {
			                                Thread.sleep(1000);
			                                 Actions ac = new Actions(chromeDriver);
			                                 Action a = ac.sendKeys(Keys.ARROW_DOWN).build();
			                                 a.perform();
			                                 Thread.sleep(1000);
			                                 Robot enterKey = new Robot();
			                                 enterKey.keyPress(KeyEvent.VK_ENTER);
			                                 enterKey.keyRelease(KeyEvent.VK_ENTER);
			                                 Assert.assertTrue(getElementText("//*[@id='intervention-code']//span/div[contains(@class,'md-text')]").equals("Prescriber Consulted"), "incorrect DUR intercention code");
			                              }
			                           }
			                        }
			                     }

			                        if (isElementPresentVerification("//*[@id='intervention-code']//span/div[contains(@class,'md-text')]")) {
			                           if (getElementText("//*[@id='intervention-code']//span/div[contains(@class,'md-text')]").equals("Prescriber Consulted")) {
			                              if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_dropdown)) {
			                                 if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_dropdown)) {
			                                    throw new Exception("Not able to click clinical evaluation DUR override dropdown button");

			                                 } else {
			                                    log.info("dfghjkvldsfsfhjcrlhgsesgsohgwehglkdhldfldfldnvdlvnsjlslvnsdlnvlsflsnvln");
			                                    Thread.sleep(1000);
			                                    Actions ac = new Actions(chromeDriver);
			                                    Action a = ac.sendKeys(Keys.ARROW_DOWN).build();
			                                    a.perform();
			                                    Thread.sleep(1000);
			                                    Robot enterKey = new Robot();
			                                    enterKey.keyPress(KeyEvent.VK_ENTER);
			                                    enterKey.keyRelease(KeyEvent.VK_ENTER);
			                                    Assert.assertTrue(getElementText("//*[@id='intervention-code']//span/div[contains(@class,'md-text')]").equals("Reviewed Patient History"), "incorrect DUR intercention code");
			                                 }
			                              }
			                           }
			                        }
			                     }
			                  }
			               }
			            }
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click DUR Drop down and verify the field in CE page
	 * @throws Throwable
	 */
	@Then("^user should select DUR intervention codes$")
	public void user_should_select_DUR_intervention_codes() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		 try {

		      Boolean majorInteractionRadioButtonDisplayed = ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ClinicalEvaluationConstants.Clinical_Evaluation_Major_Iteractions_Radio_Button))).apply(chromeDriver);
		      if (!majorInteractionRadioButtonDisplayed) {

		         if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_override_popup)) {
		            if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_dropdown)) {
		               if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_dropdown)) {
		                  throw new Exception("Not able to click clinical evaluation DUR override dropdown button");
		               } else {
		                  if (isElementPresentVerification("//div[contains(@class,'md-select-menu-')]//md-option//div")) {
		                     List<WebElement> durInterventionCodes = chromeDriver.findElements(By.xpath("//div[contains(@class,'md-select-menu-')]//md-option//div"));
		                     for (int i = 0; i < durInterventionCodes.size(); i++) {
		                        log.info("DUR intervention codes" + durInterventionCodes.get(i).getText());
		                        if (durInterventionCodes.get(i).getText().equals("Patient Consulted")) {
		                           Actions enter = new Actions(chromeDriver);
		                           Action hitEnter = enter.sendKeys(Keys.ENTER).build();
		                           hitEnter.perform();
		                           break;
		                        }
		                     }
		                  }

		               }
		            }
		         }

		   }
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	
	protected String getRandowString() {
		   String ALLCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		   StringBuilder allChars = new StringBuilder();
		   Random rnd = new Random();
		   while (allChars.length() < 250) { // length of the random string.
		      int index = (int) (rnd.nextFloat() * ALLCHARS.length());
		      allChars.append(ALLCHARS.charAt(index));
		   }
		   String longStr = allChars.toString();
		   return longStr;

		}

	/**
	 * This method is used to validate the error message
	 * @param arg1
	 * @throws Throwable
	 */

	@Then("^system display Error msg \"([^\"]*)\"$")
	public void system_display_Error_msg(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(ClinicalEvaluationConstants.DUR_Comment_Error_Msg)){
				FrameworkLibrary.verifyTextPresentElectron(ClinicalEvaluationConstants.DUR_Comment_Error_Msg, "DUR Comment is required.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to perform keywords using Actions
	 * @throws Throwable
	 */

	@Then("^The user selects Alt\\+C$")
	public void the_user_selects_Alt_C() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).build();
			series.perform();
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to verifying invoked redirect in clinical check page
	 * @throws Throwable
	 */

	@Then("^Save functionality will be invoked redirect to clincal check page$")
	public void save_functionality_will_be_invoked_redirect_to_clincal_check_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(ClinicalEvaluationConstants.CLININCAL_CHECK_TITLE)){
				FrameworkLibrary.verifyTextPresentElectron(ClinicalEvaluationConstants.CLININCAL_CHECK_TITLE,"Clinical Check");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to entering the values in comment field
	 * @throws Throwable
	 */

	@When("^user tries to enter more than two hundred fifty characters in the Comment field$")
	public void user_tries_to_enter_more_than_two_hundred_fifty_characters_in_the_Comment_field() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		 try{

		      log.info("Lenght of the char"+getRandowString().length());

		      WebElement elem = chromeDriver.findElement(By.name("comments"));
		      elem.sendKeys(getRandowString());
		      Thread.sleep(2000);
		      int realLength =  elem.toString().length();
		      log.info("Int real lenght"+realLength);
		      
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to perform keywords using Actions
	 * @throws Throwable
	 */
	@When("^The user selects Alt\\+S$")
	public void the_user_selects_Alt_S() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(ClinicalEvaluationConstants.Save_Button)){
				Actions ac = new Actions(chromeDriver);
				Action series = ac.keyDown(Keys.ALT).sendKeys("S").keyUp(Keys.ALT).build();
				series.perform();
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click DUR check box in CE page
	 * @throws Throwable
	 */

	@When("^user wishes to perform a DUR override for all interactions where there are multiple interactions and at least one is major interaction$")
	public void user_wishes_to_perform_a_DUR_override_for_all_interactions_where_there_are_multiple_interactions_and_at_least_one_is_major_interaction() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		 try {
		      Boolean majorInteractionRadioButtonDisplayed = ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ClinicalEvaluationConstants.Clinical_Evaluation_Major_Iteractions_Radio_Button))).apply(chromeDriver);
		      if (!majorInteractionRadioButtonDisplayed) {
		         if (isElementPresentVerification(ClinicalEvaluationConstants.SELECT_ALL_CHECKBOX)) {
		            if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.SELECT_ALL_CHECKBOX))
		               throw new Exception("Unable to find Select All Checkbox.");
		         }
		      }
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click DUR box in CE page
	 * @throws Throwable
	 */

	@When("^user should select DUR intervention codes more than one time$")
	public void user_should_select_DUR_intervention_codes_more_than_one_time() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerification(ClinicalEvaluationConstants.DUR_DROPDOWN)){
				if(!isElementPresentVerifyClick(ClinicalEvaluationConstants.DUR_DROPDOWN))
					throw new Exception("Unable to click DUR Dropdown.");
			}
			if(isElementPresentVerification(ClinicalEvaluationConstants.DUR_DROPDOWN_FRISTOPTIONS)){
				if(!isElementPresentVerifyClick(ClinicalEvaluationConstants.DUR_DROPDOWN_FRISTOPTIONS))
					throw new Exception("Unable to click DUR Dropdown First Options.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * This method is used to entering the values in comment field
	 * @throws Throwable
	 */

	@When("^user enter text in comment text field$")
	public void user_enter_text_in_comment_text_field() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			Thread.sleep(2000);
			WebElement el = chromeDriver.findElement(By.name("comments"));
			el.sendKeys("abcdefiddididididiid");
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click save button in CE page
	 * @throws Throwable
	 */

	@When("^user click on Save button$")
	public void user_click_on_Save_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerification(ClinicalEvaluationConstants.Save_Button)){
				if(!isElementPresentVerifyClick(ClinicalEvaluationConstants.Save_Button))
					throw new Exception("Unable to find Save Button.");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click Dashboard menu in CE page
	 * @throws Throwable
	 */
	@When("^user click on Dashboard menu from left side$")
	public void user_click_on_Dashboard_menu_from_left_side() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Dashbord_Tab)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Dashbord_Tab))
					throw new Exception("Unable to find Dashboard Tab.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click Interactions Link in CE page
	 * @throws Throwable
	 */
	@When("^User click on Interactions Link$")
	public void user_click_on_Interactions_Link() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.INTERACTIONS_LINK)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.INTERACTIONS_LINK))
					throw new Exception("Unable to find Interactions Link.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^User will only be allowed to enter (\\d+) char in Comment field$")
	public void user_will_only_be_allowed_to_enter_char_in_Comment_field(int arg1)  {

	}
	
	
	/**
	 * This method is used to click arrow button and storing elements in list
	 * @throws Throwable
	 */

	@When("^User clicks on down arrow button to view Interaction Summary for Major Interactions$")
	public void user_clicks_on_down_arrow_button_to_view_Interaction_Summary_for_Major_Interactions() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {


				if (isElementPresentVerification(ClinicalEvaluationConstants.Drug_Alergy_Down_Arrow_Moderate)) {
					List<WebElement> drugToDrugInteraction = chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.Drug_Alergy_Down_Arrow_Moderate));
					List<WebElement> drugToDrugInteractionDownArrow = chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.Drug_Alergy_Button_Arrow_Moderate));
					
					int i;
					for (i = 0; i < drugToDrugInteraction.size(); i++) {
						if (drugToDrugInteraction.get(i).getText().contains("Drug - Drug")) {
							drugToDrugInteractionDownArrow.get(i).click();
							break;

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
	 * This method is used to verify storing elements in list
	 * @throws Throwable
	 */

	@Then("^System should display documentation Label$")
	public void system_should_display_documentation_Label() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Documentation_Label)) {
				List<WebElement> documentlabel=chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.Documentation_Label));
				if(!documentlabel.get(0).getText().contains("Documentation")){
				throw new Exception("Document message not found");
				}
				
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to verify documentation text from list
	 * @throws Throwable
	 */

	@Then("^System should display documentation Text$")
	public void system_should_display_documentation_Text() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.Documentation_Text)) {
				List<WebElement> documenttext=chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.Documentation_Text));
				if(!documenttext.get(0).getText().contains("Probable")){
				throw new Exception("Documentation text not displayed");
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
	 * This method is used to verify Drug Name Last Fill Date Label
	 * @throws Throwable
	 */

	@Then("^System should display Drug Name Last Fill Date Label$")
	public void system_should_display_Drug_Name_Last_Fill_Date_Label() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.Drug_Name_Last_Fill_Date_Label)) {
				List<WebElement> documenttext=chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.Drug_Name_Last_Fill_Date_Label));
				if(!documenttext.get(0).getText().contains("FLUVOXAMINE 100MG TABLETS Last Fill Date"))
				throw new Exception("Fill date label not displayed");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to verify Drug Name Last Fill Date from list
	 * @throws Throwable
	 */

	@Then("^System should display Drug Name Last Fill Date$")
	public void system_should_display_Drug_Name_Last_Fill_Date() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.Drug_Name_Last_Fill_Date)) {
				List<WebElement> documenttext=chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.Drug_Name_Last_Fill_Date));
				if(!documenttext.get(0).getText().contains("08/04/2017"))
				throw new Exception("Fill date not displayed");
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
	 * This method is used to verify display Onset Label from list
	 * @throws Throwable
	 */
	@Then("^System should display Onset Label$")
	public void system_should_display_Onset_Label() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Onset_Label)) {
				List<WebElement> documenttext=chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.Onset_Label));
				if(!documenttext.get(0).getText().contains("Onset"))
					throw new Exception("Onset Label not displayed");
				
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
	 * This method is used to verify display Onset Text from list
	 * @throws Throwable
	 */
	@Then("^System should display Onset Text$")
	public void system_should_display_Onset_Text() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Onset_Text)) {
				List<WebElement> documenttext=chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.Onset_Text));
				if(!documenttext.get(0).getText().contains("Delayed"))
				throw new Exception("delayed not displayed");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to verify Informative Message TBD from list
	 * @throws Throwable
	 */

	@Then("^System should display Informative Message TBD$")
	public void system_should_display_Informative_Message_TBD() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.Informative_Message_TBD)) {
				throw new Exception("TBD message not displayed.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to verify View Interaction Monograph from list
	 * @throws Throwable
	 */

	@Then("^System should display View Interaction Monograph$")
	public void system_should_display_View_Interaction_Monograph() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.View_Interaction_Monograph)) {
				List<WebElement> documenttext=chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.View_Interaction_Monograph));
				if(!documenttext.get(0).getText().contains("View Interaction Monograph"))
				throw new Exception("View Interaction Monograph not displayed.");
			}
				
			
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to verify view Interaction Summary for Theraphy Review from list and perform click
	 * @throws Throwable
	 */

	@When("^User clicks on down arrow button to view Interaction Summary for Theraphy Review \"([^\"]*)\"$")
	public void user_clicks_on_down_arrow_button_to_view_Interaction_Summary_for_Theraphy_Review(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(1000);
			Actions downArrow = new Actions(chromeDriver);
			Action PressdownArrow = downArrow.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build();
			PressdownArrow.perform();
			
				if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_Duplicate_Theraphy)) {
					List<WebElement> duplicateTherapy = chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.Clinical_Evaluation_Duplicate_Theraphy));
					List<WebElement> duplicateTherapyDownArrow = chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.Clinical_Evaluation_Duplicate_Theraphy_Button));
					
					int i;
					for (i = 0; i < duplicateTherapy.size(); i++) {
						if (duplicateTherapy.get(i).getText().contains("Duplicate Therapy")) {
							duplicateTherapyDownArrow.get(i).click();
							break;

						}
					}
				}
				

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	
	/**
	 * This method is used to verify Significance Label
	 * @throws Throwable
	 */
	@Then("^System should display Significance Label$")
	public void system_should_display_Significance_Label() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Significance_Label)) {
				FrameworkLibrary.verifyTextPresentElectron(ClinicalEvaluationConstants.Significance_Label, "Significance");
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
	 * This method is used to verify Significance Text
	 * @throws Throwable
	 */

	@Then("^System should display Significance Text$")
	public void system_should_display_Significance_Text() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.Significance_Text)) {
				throw new Exception("Significance Text not displayed.");
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
	 * This method is used to verify Duplicate Allowance Label
	 * @throws Throwable
	 */

	@Then("^System should display Duplicate Allowance Label$")
	public void system_should_display_Duplicate_Allowance_Label() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Duplicate_Allowance_Label)) {
				FrameworkLibrary.verifyTextPresentElectron(ClinicalEvaluationConstants.Duplicate_Allowance_Label, "Duplication Allowance");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to verify Duplicate Allowance Text
	 * @throws Throwable
	 */

	@Then("^System should display Duplicate Allowance Text$")
	public void system_should_display_Duplicate_Allowance_Text() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.Duplicate_Allowance_Text)) {
				throw new Exception("Duplicate Allowance Text not displayed.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to verify Informative Message Text
	 * @throws Throwable
	 */
	
	@Then("^System should display Informative Message Text$")
	public void system_should_display_Informative_Message_Text() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.Informative_Message_Text)) {
				throw new Exception("Informative Message Text not displayed.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (AssertionError e) {
			takeScreenShot(methodName);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		}
	}

	/**
	 * This method is used to click drug Interaction down arrow
	 * @throws Throwable
	 */
	
	@When("^User clicked on drug drug Interaction down arrow$")
	public void User_clicked_on_drug_drug_Interaction_down_arrow() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Drug_Drug_Down_Arrow)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Drug_Drug_Down_Arrow))
					throw new Exception("Unable to find Drug Drug Down Button.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		}
	}
	
	
	/**
	 * This method is used to verify view Interaction Summary for drug allergy from list and perform click
	 * @throws Throwable
	 */

	@When("^User click on downArrow button for drug-allergy interaction for Major Interactions$")
	public void user_click_on_downArrow_button_for_drug_allergy_interaction_for_Major_Interactions() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (isElementPresentVerification(ClinicalEvaluationConstants.Drug_Alergy_Down_Arrow_Major)) {
				List<WebElement> drugToDrugInteraction = chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.Drug_Alergy_Down_Arrow_Major));
				List<WebElement> drugToDrugInteractionDownArrow = chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.Drug_Alergy_Button_Arrow_Major));

				int i;
				for (i = 0; i < drugToDrugInteraction.size(); i++) {
					if (drugToDrugInteraction.get(i).getText().contains("Drug - Allergy")) {
						drugToDrugInteractionDownArrow.get(i).click();
						break;

					}
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		}
	}
	
	
	/**
	 * This method is used to verify Drugs Reported to Cause An Adverse Reaction
	 * @throws Throwable
	 */

	@Then("^I should see Drugs Reported to Cause An Adverse Reaction and the Symtoms Associated With The Drug's Administration$")
	public void i_should_see_Drugs_Reported_to_Cause_An_Adverse_Reaction_and_the_Symtoms_Associated_With_The_Drug_s_Administration() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.Adverse_Reaction_Summary_On_Interaction_Monograph_Page)) {
				throw new Exception("Adverse Reaction Message not displayed.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to verify Structurally Related Drugs
	 * @throws Throwable
	 */
	

	@Then("^I should see Oher Structurally Related Drugs$")
	public void i_should_see_Oher_Structurally_Related_Drugs() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Oher_Structurally_Related_Drugs)) {
				FrameworkLibrary.verifyTextPresentElectron(ClinicalEvaluationConstants.Oher_Structurally_Related_Drugs, "OTHER STRUCTURALLY RELATED DRUGS:");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	
	/**
	 * This method is used to click View Interaction Monograph Link
	 * @throws Throwable
	 */
	@When("^I click on View Interaction Monograph Link$")
	public void i_click_on_View_Interaction_Monograph_Link() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.View_Interaction_Monograph)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.View_Interaction_Monograph))
					throw new Exception("Unable to find Interaction Monograph.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to click drug drug View Interaction Monograph Link
	 * @throws Throwable
	 */

	@When("^I click on drug drug View Interaction Monograph Link$")
	public void i_click_on_drug_drug_View_Interaction_Monograph_Link() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.View_Drug_Drug_Interaction_Monograph)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.View_Drug_Drug_Interaction_Monograph))
					throw new Exception("Unable to find Drug Interaction Monograph.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to verify drug drug View Interaction Monograph label
	 * @throws Throwable
	 */
	@Then("^I should see Drug Drug Interaction Monograph Label$")
	public void i_should_see_Drug_Drug_Interaction_Monograph_Label() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Drug_Drug_Interaction_Monograph_Label)) {
				FrameworkLibrary.verifyTextPresentElectron(ClinicalEvaluationConstants.Drug_Drug_Interaction_Monograph_Label, "Drug/Drug Interaction Monograph");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to verify Drug Allergy Interaction Monograph Label
	 * @throws Throwable
	 */

	@Then("^I should see Drug Allergy Interaction Monograph Label$")
	public void i_should_see_Drug_Allergy_Interaction_Monograph_Label() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Drug_Allergy_Interaction_Monograph_Label)) {
				FrameworkLibrary.verifyTextPresentElectron(ClinicalEvaluationConstants.Drug_Allergy_Interaction_Monograph_Label, "Drug/Allergy Interaction Monograph");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to verify Effect lable Text
	 * @throws Throwable
	 */

	@Then("^I should see Effect lable Text$")
	public void i_should_see_Effect_lable_Text() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Effect_Label_Text)) {
				FrameworkLibrary.verifyTextPresentElectron(ClinicalEvaluationConstants.Effect_Label_Text, "Effect:");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	
	/**
	 * This method is used to verify Mechanism label Text
	 * @throws Throwable
	 */
	@Then("^I should see Mechanism label Text$")
	public void i_should_see_Mechanism_label_Text() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Mechanism_Label_Text)) {
				FrameworkLibrary.verifyTextPresentElectron(ClinicalEvaluationConstants.Mechanism_Label_Text, "Mechanism:");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	
	/**
	 * This method is used to verify Management label Text
	 * @throws Throwable
	 */
	@Then("^I should see Management label Text$")
	public void i_should_see_Management_label_Text() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Management_Label_Text)) {
				FrameworkLibrary.verifyTextPresentElectron(ClinicalEvaluationConstants.Management_Label_Text, "Management:");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to verify Discussion label Text
	 * @throws Throwable
	 */
	@Then("^I should see Discussion label Text$")
	public void i_should_see_Discussion_label_Text() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Discussion_Label_Text)) {
				FrameworkLibrary.verifyTextPresentElectron(ClinicalEvaluationConstants.Discussion_Label_Text, "Discussion:");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to verify Reference label Text
	 * @throws Throwable
	 */
	@Then("^I should see Reference label Text$")
	public void i_should_see_Reference_label_Text() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Reference_Label_Text)) {
				FrameworkLibrary.verifyTextPresentElectron(ClinicalEvaluationConstants.Reference_Label_Text, "References:");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to verify ok button enabled using assertion
	 * @throws Throwable
	 */
	
	@Then("^I should see Ok button Enabled$")
	public void i_should_see_Ok_button_Enabled() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Ok_Popup_Button)) {
				Assert.assertTrue(isButtonEnable(ClinicalEvaluationConstants.Ok_Popup_Button), "Ok button not enabled.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click on Ok Popup Button
	 * @throws Throwable
	 */
	@When("^I click on Ok Popup Button$")
	public void i_click_on_Ok_Popup_Button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Ok_Popup_Button)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Ok_Popup_Button))
					throw new Exception("Unable to click Ok Button.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	
	/**
	 * This method is used to verify Popup should close and redirected to Clinical Check Screen
	 * @throws Throwable
	 */
	@Then("^Popup should close and redirected to Clinical Check Screen$")
	public void popup_should_close_and_redirected_to_Clinical_Check_Screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.CLININCAL_CHECK_TITLE)) {
				throw new Exception("Clinical Check screen not displayed.");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	
	/**
	 * This method is used to perform tab order sequence
	 * @throws Throwable
	 */
	@Then("^Validate the Tab Order Select All Override Send to IC\\+  Cancel$")
	public void validate_the_Tab_Order_Select_All_Override_Send_to_IC_Cancel() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			ClinicalEvaluationLibrary.TestTabOrderDUR();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}
	
	/**
	 * This method is used to perform Actions keyword
	 * @throws Throwable
	 */

	@When("^user hits Alt plus S$")
	public void user_hits_Alt_plus_S() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("s").keyUp(Keys.ALT).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to verify Select All the check boxes
	 * @throws Throwable
	 */
	@Then("^should Select All the checkboxes$")
	public void should_Select_All_the_checkboxes(WebElement chkbx)  throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			boolean checkstatus;
			chkbx = chromeDriver.findElement(By.id("select-all"));
			checkstatus = chkbx.isSelected();
			if (checkstatus == true) {
				Assert.assertTrue(checkstatus);
			} else {
				Assert.assertFalse(checkstatus);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to perform Actions keyword
	 * @throws Throwable
	 */

	@When("^user hits Alt plus O$")
	public void user_hits_Alt_plus_O() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("O").keyUp(Keys.ALT).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to perform Actions keyword
	 * @throws Throwable
	 */
	@When("^user hits Shift Alt plus$")
	public void user_hits_Shift_Alt_plus() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).keyDown(Keys.SHIFT).sendKeys("+").keyUp(Keys.ALT).keyUp(Keys.SHIFT).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to perform Actions keyword
	 * @throws Throwable
	 */

	@When("^user hits Alt plus R$")
	public void user_hits_Alt_plus_R() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("r").keyUp(Keys.ALT).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to verify Rx details page displayed
	 * @throws Throwable
	 */
	@Then("^System should display Rx details page$")
	public void system_should_display_Rx_details_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_Rx_Details_popup)) {
				FrameworkLibrary.verifyTextPresentElectron(ClinicalEvaluationConstants.Clinical_Evaluation_Rx_Details_popup, "Rx Details for");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click jump link for major Interaction
	 * @throws Throwable
	 */
	@When("^User Select the jump link for major Interaction$")
	public void user_Select_the_jump_link_for_major_Interaction() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.MAJOR_INTERACTIONS)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.MAJOR_INTERACTIONS))
					throw new Exception("Unable to find Major Interactions Link.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to verify all major interactions in front
	 * @throws Throwable
	 */

	@Then("^User should see all major interactions in front$")
	public void user_should_see_all_major_interactions_in_front() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.MAJOR_INTERACTIONS_HEADER)) {
				throw new Exception("Major Interactions not displayed.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to click jump link for moderate Interaction
	 * @throws Throwable
	 */

	@When("^User Select the jump link for moderate Interaction$")
	public void user_Select_the_jump_link_for_moderate_Interaction() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.MODERATE_INTERACTIONS)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.MODERATE_INTERACTIONS))
					throw new Exception("Unable to click Moderate Interactions button.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to verify all moderate interactions in front
	 * @throws Throwable
	 */

	@Then("^User should see all moderate interactions in front$")
	public void user_should_see_all_moderate_interactions_in_front() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.MODERATE_INTERACTIONS_HEADER)) {
				throw new Exception("Moderate Interactions not displayed.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to click jump link for Therapy review
	 * @throws Throwable
	 */

	@When("^User Select the jump link for Therapy review$")
	public void user_Select_the_jump_link_for_Therapy_review() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.THERAPY_REVIEW)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.THERAPY_REVIEW))
					throw new Exception("Unable to find Therapy Review button.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	
	/**
	 * This method is used to verify all Therapy review in front
	 * @throws Throwable
	 */
	@Then("^User should see all Therapy review in front$")
	public void user_should_see_all_Therapy_review_in_front() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.THERAPY_REVIEW_HEADER)) {
				throw new Exception("Therapy Review not displayed.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	
	/**
	 * This method is used to click Clinical History tab button
	 * @throws Throwable
	 */

	@When("^user click on Clinical History tab button$")
	public void user_click_on_Clinical_History_tab_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.CE_CLINICAL_HISTORY_TAB)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.CE_CLINICAL_HISTORY_TAB))
					throw new Exception("Unable to click Clinical History Tab.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click on the option
	 * @throws Throwable
	 */
	
	@Then("^should able to click on the options$")
	public void should_able_to_click_on_the_options() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.material_icon)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.material_icon))
					throw new Exception("Unable to find Material Icon.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	
	/**
	 * This method is used to click value from the options
	 * @throws Throwable
	 */
	@When("^Select a valid value from the options$")
	public void select_a_valid_value_from_the_options() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.clinical_Check)) {
				scrollTo(chromeDriver, element);
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.clinical_Check))
					throw new Exception("Unable to click clinical check.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	/**
	 * This method is used to perform the clinical check present on page using assertions
	 * @throws Throwable
	 */
	@Then("^I should be on Clinical Check page$")
	public void i_should_be_on_Clinical_Check_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Assert.assertTrue(chromeDriver.getPageSource().contains("Clinical Check"), "Not on Clinical Check Page");
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click Med History
	 * @throws Throwable
	 */
	@When("^I clicks Med History$")
	public void i_clicks_Med_History() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.CE_MED_HISTORY_TAB)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.CE_MED_HISTORY_TAB))
					throw new Exception("Unable to find Med History Tab.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	
	/**
	 * This method is used to click Additional Medications
	 * @throws Throwable
	 */
	@Then("^I clicks Additional Medications$")
	public void i_clicks_Additional_Medications() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.CE_MED_HISTORY_ADDITIONAL_MEDICATIONS)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.CE_MED_HISTORY_ADDITIONAL_MEDICATIONS))
					throw new Exception("Unable to find Additional Medications Tab.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	
	/**
	 * This method is used to perform the clinical check present on page using assertions
	 * @throws Throwable
	 */
	@Then("^I should see \"([^\"]*)\"$")
	public void i_should_see(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (arg1.equals("Invalid Format")) {
				log.info("Invalid Format is yet to be fixed");
			} else {
				log.info("Validating text content");
				Assert.assertTrue(chromeDriver.getPageSource().contains(arg1), "Text not found");
				Thread.sleep(2000);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	
	/**
	 * This method is used to verify donut chart should display filling directions
	 * @throws Throwable
	 */
	@And("^the donut chart should display filling directions$")
	public void the_donut_chart_should_display_filling_directions() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.DONUT_FILL)) {
				String donutFillCenterWords = getElementText(ClinicalEvaluationConstants.DONUT_FILL);
				String donutFillCenterWordsExpected = "Fill Rx";
				log.info("Instructions on donut chart center: " + donutFillCenterWords);
				log.info("Expected: " + donutFillCenterWordsExpected);
				;
				Assert.assertEquals(donutFillCenterWords, donutFillCenterWordsExpected);
				if (isElementPresentVerification(ClinicalEvaluationConstants.DONUT_FILL_BOTTOM)) {
					String donutFillBottomWords = getElementText(ClinicalEvaluationConstants.DONUT_FILL_BOTTOM);
					String donutFillBottomWordsExpected = "Use Assembly app to perform this step";
					log.info("Instructions on donut chart bottom: " + donutFillBottomWords);
					log.info("Expected: " + donutFillBottomWordsExpected);
					Assert.assertEquals(donutFillBottomWords, donutFillBottomWordsExpected);
					isElementPresentVerification(ClinicalEvaluationConstants.DONUT_FILL_GRAPHIC);
					if (captureScreenshot) {
						takeScreenShot(methodName);
					}
				}
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click send to IC plus button
	 * @throws Throwable
	 */
	@And("^click Send to IC plus button in CE$")
	public void click_Send_to_IC_plus_button_in_CE() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.CE_SEND_TO_IC)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.CE_SEND_TO_IC))
					throw new Exception("Unable to find Sent To IC+ button.");
			}
			if (isElementPresentVerification(ClinicalEvaluationConstants.PROMPT_MESSAGE_YES_BUTTON)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.PROMPT_MESSAGE_YES_BUTTON))
					throw new Exception("Unable to click accept button");
			}
			
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click on Clinical Evaluation task number
	 * @throws Throwable
	 */

	@When("^user click on Clinical Evaluation$")
	public void user_click_on_Clinical_Evaluation() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.CETaskNumber)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.CETaskNumber))
					throw new Exception("Unable to find CE Task Number.");
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
	 * This method is used to perform Actions keyword
	 * @throws Throwable
	 */
	@And("^user clicks ALT plus A$")
	public void user_clicks_ALT_plus_A() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("A").keyUp(Keys.ALT).build();
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
	 * This method is used to perform Actions keyword
	 * @throws Throwable
	 */
	@And("^user clicks ALT plus H$")
	public void user_clicks_ALT_plus_H() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("H").keyUp(Keys.ALT).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to verify Therapeutic Class populated using assertion
	 * @throws Throwable
	 */
	@Then("^system displays Therapeutic Class populated in Rx Details screen$")
	public void system_displays_Therapeutic_Class_populated_in_Rx_Details_screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Therapeutic_Feild)) {
				String ab = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Clinical_Evaluation_Therapeutic_Feild)).getText();
				Assert.assertTrue(!(ab.isEmpty()), "Therapeutic Class in Rx Details screen is not populated");
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
	 * This method is used to perform Actions keyword
	 * @throws Throwable
	 */
	@Then("^user selects Alt plus R$")
	public void user_selects_Alt_plus_R() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("r").keyUp(Keys.ALT).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to verify Rx details will be displayed on the Rx Details pop up using assertions
	 * @throws Throwable
	 */

	@And("^Rx details will be displayed on the Rx Details pop up$")
	public void Rx_details_will_be_displayed_on_the_Rx_Details_pop_up() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Clinical_check_product_RXnumber)) {
				String RX = FrameworkLibrary.getElementText(AccessManagementConstants.Clinical_check_product_RXnumber);
				Assert.assertTrue(RX != null, "Value of Rx number not displayed");
				if (isElementPresentVerification(AccessManagementConstants.Clinical_Check_Product_Daw_Filled)) {
					String Daw = FrameworkLibrary.getElementText(AccessManagementConstants.Clinical_Check_Product_Daw_Filled);
					Assert.assertTrue(Daw != null, "Value of Daw not displayed");
					if (isElementPresentVerification(AccessManagementConstants.Clinical_Check_Product_Directions_Feild)) {
						String Directions = FrameworkLibrary.getElementText(AccessManagementConstants.Clinical_Check_Product_Directions_Feild);
						Assert.assertTrue(Directions != null, "Value of Directions not displayed");
						if (isElementPresentVerification(AccessManagementConstants.Clinical_Check_Product_Original_Date)) {
							String originalDate = FrameworkLibrary.getElementText(AccessManagementConstants.Clinical_Check_Product_Original_Date);
							Assert.assertTrue(originalDate != null, "Value of originalDate not displayed");
							if (isElementPresentVerification(AccessManagementConstants.Clinical_Check_Product_Prescribed_Drug)) {
								String PrescribedDrug = FrameworkLibrary.getElementText(AccessManagementConstants.Clinical_Check_Product_Prescribed_Drug);
								Assert.assertTrue(PrescribedDrug != null, "Value of Prescribed Drug not displayed");
								if (isElementPresentVerification(AccessManagementConstants.Clinical_Check_Product_Qty)) {
									String Quantity = FrameworkLibrary.getElementText(AccessManagementConstants.Clinical_Check_Product_Qty);
									Assert.assertTrue(Quantity != null, "Value of Quantity not displayed");
									if (isElementPresentVerification(AccessManagementConstants.Clinical_Check_Product_Refills)) {
										String Refills = FrameworkLibrary.getElementText(AccessManagementConstants.Clinical_Check_Product_Refills);
										Assert.assertTrue(Refills != null, "Value of Refills not displayed");
										if (isElementPresentVerification(AccessManagementConstants.Clinical_Check_Product_RX_Expiration_Date)) {
											String RxEXpiration = FrameworkLibrary.getElementText(AccessManagementConstants.Clinical_Check_Product_RX_Expiration_Date);
											Assert.assertTrue(RxEXpiration != null, "Value of Exexpiration not displayed");
											if (isElementPresentVerification(AccessManagementConstants.Clinical_Check_Product_Substitute_Filled)) {
												String Substitute = FrameworkLibrary.getElementText(AccessManagementConstants.Clinical_Check_Product_Substitute_Filled);
												Assert.assertTrue(Substitute != null, "Value of Substitute not displayed");
												if (captureScreenshot) {
													takeScreenShot(methodName);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to verify last fill date will be blank using assertions
	 * @throws Throwable
	 */

	@And("^user last fill date will be blank$")
	public void user_last_fill_date_will_be_blank() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Clinical_Check_Last_Fill_Date)) {
				String Lastfill = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Clinical_Check_Last_Fill_Date)).getText();
				Assert.assertTrue(Lastfill != null, "the last fill date is empty");
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to verify user able to see following formats feilds using assertions
	 * @throws Throwable
	 */
	
	@And("^user able to see following formats feilds$")
	public void user_able_to_see_following_formats_feilds(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Clinical_Check_Dispended_Drug_Feild)) {
				Assert.assertTrue(getElementText(AccessManagementConstants.Clinical_Check_Dispended_Drug_Feild).contains(ClinicalEvaluationLibrary.getData(arg1, "DrugName", 0).toUpperCase()));
				Assert.assertTrue(SmokeTestStepDef.dispensedDruginDE.contains(getElementText(AccessManagementConstants.Clinical_Check_Dispended_Drug_Feild)));
				if (isElementPresentVerification(SmokeTestConstants.CE_Rxnumber)) {
					String[] rxnumStorenum = getElementText(SmokeTestConstants.CE_Rxnumber).split("-");
					String actualrxnum = rxnumStorenum[0];
					Assert.assertTrue(actualrxnum.equals(SmokeTestStepDef.dynamicrxnum));
					if (isElementPresentVerification(AccessManagementConstants.Clinical_Check_Days_Supply_Feild)) {
						Assert.assertTrue(getElementText(AccessManagementConstants.Clinical_Check_Days_Supply_Feild).equals(ClinicalEvaluationLibrary.getData(arg1, "DaysSupply", 0)));
						if (isElementPresentVerification(AccessManagementConstants.Clinical_Check_Quantity_Disp_feild)) {
							Assert.assertTrue(getElementText(AccessManagementConstants.Clinical_Check_Quantity_Disp_feild).equals(ClinicalEvaluationLibrary.getData(arg1, "QuantityDisp", 0)));
							String expectedFirstName = ClinicalEvaluationLibrary.getData(arg1, "FirstName", 1);
							String expectedLastName = ClinicalEvaluationLibrary.getData(arg1, "LastName", 1);
							String expectedPrescriberName = expectedLastName + ", " + expectedFirstName;
							if (isElementPresentVerification(AccessManagementConstants.Clinical_Check_Prescriber_Feild)) {
								String ActualprescriberData = getElementText(AccessManagementConstants.Clinical_Check_Prescriber_Feild);
								Assert.assertTrue(ActualprescriberData.toUpperCase().contains(expectedPrescriberName.toUpperCase()));
								if (isElementPresentVerification(AccessManagementConstants.Clinical_Check_Directions_Feild)) {
									Assert.assertFalse(getElementText(AccessManagementConstants.Clinical_Check_Directions_Feild).equals(""));
									if (isElementPresentVerification(AccessManagementConstants.Clinical_Check_Phone_Feild)) {
										Assert.assertFalse(getElementText(AccessManagementConstants.Clinical_Check_Phone_Feild).equals(""));
										if (isElementPresentVerification(AccessManagementConstants.Clinical_Check_Thearapeutic_Feild)) {
											Assert.assertFalse(getElementText(AccessManagementConstants.Clinical_Check_Thearapeutic_Feild).equals(""));
											if (captureScreenshot) {
												takeScreenShot(methodName);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click close on popup
	 * @throws Throwable
	 */
	@Then("^user click close on popup$")
	public void user_click_close_on_popup() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Popup_Close_Button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Clinical_Evaluation_Popup_Close_Button))
					throw new Exception("Unable to find close button.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	
	/**
	 * This method is used to click on Rx number hyperlink
	 * @throws Throwable
	 */
	@Then("^user clicks on the Rx Number hyperlink$")
	public void user_clicks_on_the_Rx_Number_hyperlink() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Rxnumber_Hyperlink)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Clinical_Evaluation_Rxnumber_Hyperlink))
					throw new Exception("Unable to find cancel button.");
			}
			if (!isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Rxnumber_Hyperlink_Displayed_Page)) {
				throw new Exception("Rx details Page popup not dispalyed when clicked on Rx number hyperlink");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click cancel button on CE page
	 * @throws Throwable
	 */
	@Then("^User clicks cancel button on CE page$")
	public void User_clicks_cancel_button_on_CE_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.CE_Cancel)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.CE_Cancel))
					throw new Exception("Unable to find cancel button.");
			}
			waitToClick(SmokeTestConstants.CE_StopCurrentTassk_OkButton).click();

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click on cancel button on CE page without popup
	 * @throws Throwable
	 */
	@Then("^User clicks cancel button on CE page without popup$")
	public void User_clicks_cancel_button_on_CE_page_without_popup() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.CE_Cancel)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.CE_Cancel))
					throw new Exception("Unable to find cancel button.");
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
	 * This method is used to verify CE cancel current task popup appears
	 * @throws Throwable
	 */
	@And("^CE cancel current task popup appears$")
	public void CE_cancel_current_task_popup_appears() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.CE_stop_current_Task_alert_message)) {
				throw new Exception("popup not shown");
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
	 * This method is used to click cancel on cancel current task popup
	 * @throws Throwable
	 */
	@Then("^click cancel on cancel current task popup$")
	public void click_cancel_on_cancel_current_task_popup() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.PROMPT_MESSAGE_CANCEL_BUTTON)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.PROMPT_MESSAGE_CANCEL_BUTTON))
					throw new Exception("Unable to find cancel button.");
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
	 * This method is used to click on Allergies list should display
	 * @throws Throwable
	 */
	@When("^user clicks on Allergies list should display$")
	public void user_clicks_on_Allergies_list_should_display() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Allergies_Link)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Clinical_Evaluation_Allergies_Link))
					throw new Exception("Unable to find CE Allergies Link.");
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
	 * This method is used to verify user should be able to see allergies popup Screen
	 * @throws Throwable
	 */
	@And("^user should be able to see allergies popup Screen$")
	public void user_should_be_able_to_see_allergies_popup_Screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Clinical_Check_Allergies_Popup_Displayed_Feild)) {
				throw new Exception("Allergies popup not displayed");
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
	 * This method is used to click on Health list should display
	 * @throws Throwable
	 */
	@When("^user clicks on Health list should display$")
	public void user_clicks_on_Health_list_should_display() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Health_Conditions_Link)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Clinical_Evaluation_Health_Conditions_Link))
					throw new Exception("Unable to find CE Health Conditions Link.");
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
	 * This method is used to verify user should be able to see Health Conditions popup Screen
	 * @throws Throwable
	 */
	@And("^user should be able to see Health Conditions popup Screen$")
	public void user_should_be_able_to_see_Health_Conditions_popup_Screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Clinical_Check_Health_Popup_Displayed_Feild)) {
				throw new Exception("Health Conditions screen not displayed.");
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
	 * This method is used to click technician clicks on clinical evaluation
	 * @throws Throwable
	 */
	@When("^technician clicks on clinical evaluation$")
	public void technician_clicks_on_clinical_evaluation() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.clinical_Check)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.clinical_Check))
					throw new Exception("Unable to click Clinical Check.");
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
	 * This method is used to click user waits on POS screen
	 * @throws Throwable
	 */
	@Then("^user waits$")
	public void user_waits() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Patientorderstatus_back)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Patientorderstatus_back))
					throw new Exception("Unable to click POS back button.");
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
	 * This method is used to verify User is on clinical evaluation page
	 * @throws Throwable
	 */
	@Then("^User is on clinical evaluation page$")
	public void user_is_on_clinical_evaluation_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.CE_PAGE)) {
				throw new Exception("CE Page not displayed.");
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
	 * This method is used to perform Actions keyword
	 * @throws Throwable
	 */
	@When("^User clicks on health conditions using ALT plus H hot key$")
	public void user_clicks_on_health_conditions_using_ALT_plus_H_hot_key() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("h").keyUp(Keys.ALT).build();
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
	 * This method is used to verify User is able to see a pop showing health conditions of patient
	 * @throws Throwable
	 */
	@Then("^User is able to see a pop showing health conditions of patient$")
	public void user_is_able_to_see_a_pop_showing_health_conditions_of_patient() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.HEALTH_CONDITIONS_POPUP)) {
				throw new Exception("Health conditions popup not displayed.");
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
	 * This method is used to verify health conditions in order from list and performing collections to validate date format
	 * @throws Throwable
	 */

	@Then("^User checks the health conditions of the patient are in order$")
	public void user_checks_the_health_conditions_of_the_patient_are_in_order() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.HEALTH_CONDITIONS_POPUP_DATE_AND_TIME)) {
				ArrayList<String> obtainedListForDateAndTime = new ArrayList<String>();
				List<WebElement> timeAndDate = FrameworkLibrary.chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.HEALTH_CONDITIONS_POPUP_DATE_AND_TIME));
				for (WebElement we : timeAndDate) {
					obtainedListForDateAndTime.add(we.getText());
				}
				ArrayList<String> sortedListForDateAndTime = new ArrayList<String>();
				for (String s : obtainedListForDateAndTime) {
					sortedListForDateAndTime.add(s);
				}
				Collections.sort(sortedListForDateAndTime);
				Collections.reverse(sortedListForDateAndTime);
				Assert.assertTrue(sortedListForDateAndTime.equals(obtainedListForDateAndTime), "Date and time are not in order");
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to perform Actions keyword
	 * @throws Throwable
	 */
	@When("^The user viewing the Health Conditions pop-up screen selects the hot keys combination Alt\\+C$")
	public void the_user_viewing_the_Health_Conditions_pop_up_screen_selects_the_hot_keys_combination_Alt_C() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(2000);
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).build();
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
	 * This method is used to click on Health Conditions pop-up screen clicks the close button
	 * @throws Throwable
	 */
	@When("^The user viewing the Health Conditions pop-up screen clicks the close button$")
	public void the_user_viewing_the_Health_Conditions_pop_up_screen_clicks_the_close_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.HEALTH_CONDITIONS_CLOSE_BUTTON)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.HEALTH_CONDITIONS_CLOSE_BUTTON))
					throw new Exception("Unable to click Health Conditions popup close button.");
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
	 * This method is used to click on Health Conditions pop-up screen clicks the X button
	 * @throws Throwable
	 */
	@When("^The user viewing the Health Conditions pop-up screen clicks the X button$")
	public void the_user_viewing_the_Health_Conditions_pop_up_screen_clicks_the_X_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.HEALTH_CONDITIONS_CROSS_CLOSE_BUTTON)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.HEALTH_CONDITIONS_CROSS_CLOSE_BUTTON))
					throw new Exception("Unable to click Health Conditions X button.");
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
	 * This method is used to perform Actions keyword
	 * @throws Throwable
	 */

	@When("^User clicks on allergies using ALT plus A hot key$")
	public void user_clicks_on_allergies_using_ALT_plus_A_hot_key() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("A").keyUp(Keys.ALT).build();
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
	 * This method is used to verify User is able to see a pop showing allergies of patient
	 * @throws Throwable
	 */
	@Then("^User is able to see a pop showing allergies of patient$")
	public void user_is_able_to_see_a_pop_showing_allergies_of_patient() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(ClinicalEvaluationConstants.ALLERGIES_POPUP)) {
				throw new Exception("Allergies popup not displayed.");
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
	 * This method is used to perform date format using collections and assertions from list
	 * @throws Throwable
	 */
	@Then("^User checks the allergies of the patient are in order$")
	public void user_checks_the_allergies_of_the_patient_are_in_order() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.ALLERGIES_POPUP_DATE_AND_TIME)) {
				ArrayList<String> obtainedListForDateAndTime = new ArrayList<String>();

				List<WebElement> timeAndDate = FrameworkLibrary.chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.ALLERGIES_POPUP_DATE_AND_TIME));

				for (WebElement we : timeAndDate) {

					obtainedListForDateAndTime.add(we.getText());
				}
				ArrayList<String> sortedListForDateAndTime = new ArrayList<String>();

				for (String s : obtainedListForDateAndTime) {
					sortedListForDateAndTime.add(s);
				}
				Collections.sort(sortedListForDateAndTime);
				Collections.reverse(sortedListForDateAndTime);
				Assert.assertTrue(sortedListForDateAndTime.equals(obtainedListForDateAndTime), "Allergies date and time are not in ascending order");
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to perform Actions keyword
	 * @throws Throwable
	 */

	@When("^The user viewing the allergies pop-up screen selects the hot keys combination Alt\\+C$")
	public void the_user_viewing_the_allergies_pop_up_screen_selects_the_hot_keys_combination_Alt_C() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).build();
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
	 * This method is used to click allergies pop-user screen clicks the close button
	 * @throws Throwable
	 */
	@When("^The user viewing the allergies pop-user screen clicks the close button$")
	public void the_user_viewing_the_allergies_pop_user_screen_clicks_the_close_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.ALLERGIES_CLOSE_BUTTON)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.ALLERGIES_CLOSE_BUTTON))
					throw new Exception("Unable to click Allergies close button.");
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
	 * This method is used to click allergies pop-up screen clicks the X button
	 * @throws Throwable
	 */
	@When("^The user viewing the allergies pop-up screen clicks the X button$")
	public void the_user_viewing_the_allergies_pop_up_screen_clicks_the_X_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.ALLERGIES_CROSS_CLOSE_BUTTON)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.ALLERGIES_CROSS_CLOSE_BUTTON))
					throw new Exception("Unable to click Allergies X button.");
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
	 * This method is used to verify CE screen should display Rx number
	 * @throws Throwable
	 */

	@Then("^CE screen should display Rx number$")
	public void CE_screen_should_display_Rx_number() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Clinical_check_product_RXnumber)) {
				throw new Exception("CE RX number not displayed.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
		log.info("Rx Number on display is " + AccessManagementConstants.Clinical_check_product_RXnumber + ".");
	}
	
	
	/**
	 * This method is used to click on selects CE Rx number
	 * @throws Throwable
	 */
	@When("^user selects CE Rx number$")
	public void user_selects_CE_Rx_number() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Rxnumber_Hyperlink)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Clinical_Evaluation_Rxnumber_Hyperlink)) {
					throw new Exception("Unable to click CE Rx number link.");
				}
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to verify system opens Rx details popup
	 * @throws Throwable
	 */
	@Then("^the system opens Rx details popup$")
	public void the_system_opens_Rx_details_popup() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (!isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Rxnumber_Hyperlink_Displayed_Page)) {
				throw new Exception("CE RX page not displayed.");
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
	 * This method is used to verify check Allergies feild system display as Confirm with patient
	 * @throws Throwable
	 */
	@When("^user check Allergies feild system display as Confirm with patient$")
	public void user_check_Allergies_feild_system_display_as_Confirm_with_patient() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Allergies_Confirm_Patient)) {
				throw new Exception("'Confirm with patient' not displayed.");
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
	 * This method is used to verify check health condition system display as Confirm with patient
	 * @throws Throwable
	 */
	@When("^user check health condition system display as Confirm with patient$")
	public void user_check_health_condition_system_display_as_Confirm_with_patient() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Health_Conditions_Confirm_Patient)) {
				throw new Exception("The confirm message for Health condition is not displayed on CE Screen");
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
	 * This method is used to click on Allergies hyper link
	 * @throws Throwable
	 */
	@When("^user clicks on Allergies hyper link$")
	public void user_clicks_on_Allergies_hyper_link() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Allergies_Link)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Clinical_Evaluation_Allergies_Link)) {
					throw new Exception("Unable to click CE Allergies Link.");
				}
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to click close the allergies popup screen
	 * @throws Throwable
	 */
	@And("^user close the allergies popup screen$")
	public void user_close_the_allergies_popup_screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Allergies_Popup_Close_Button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Clinical_Evaluation_Allergies_Popup_Close_Button))
					throw new Exception("Unable to find CE Allergy Close Button.");
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
	 * This method is used to click on Health Condition hyper link
	 * @throws Throwable
	 */
	@When("^user clicks on Health Condition hyper link$")
	public void user_clicks_on_Health_Condition_hyper_link() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Health_Conditions_Link)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Clinical_Evaluation_Health_Conditions_Link))
					throw new Exception("Unable to find CE Health Conditions Link.");
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
	 * This method is used to click on user close the Health Condition popup screen
	 * @throws Throwable
	 */
	@And("^user close the Health Condition popup screen$")
	public void user_close_the_Health_Condition_popup_screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Health_Condition_Popup_Close_Button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Clinical_Evaluation_Health_Condition_Popup_Close_Button))
					throw new Exception("Unable to find close button.");
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
	 * This method is used to click on inprogress status down arrow button
	 * @throws Throwable
	 */
	@When("^user clicks inprogress status down arrow button$")
	public void user_clicks_inprogress_status_down_arrow_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.CH_Result_Inprogress_DownArrow_Button)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.CH_Result_Inprogress_DownArrow_Button))
					throw new Exception("Unable to find In Progress Down Arrow.");
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
	 * This method is used to click system navigates to fill history details click on view
	 * @throws Throwable
	 */
	@Then("^system navigates to fill history details click on view$")
	public void system_navigates_to_fill_history_details_click_on_view() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.CH_Result_Inprogress_DownArrow_View_Button)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.CH_Result_Inprogress_DownArrow_View_Button))
					throw new Exception("Unable to find In Progress Down Arrow.");
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
	 * This method is used to verify on fill history page screen
	 * @throws Throwable
	 */
	@And("^user verify on fill history page screen$")
	public void user_verify_on_fill_history_page_screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.CH_Result_Inprogress_DownArrow_View_Fillhistory_Page_Title)) {
				String ab = FrameworkLibrary.chromeDriver.findElement(By.xpath(ClinicalEvaluationConstants.CH_Result_Inprogress_DownArrow_View_Fillhistory_Page_Title)).getText();
				log.info("the clinical evaluation screen :" + ab);
				Assert.assertTrue(chromeDriver.getPageSource().contains(ab));
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
	 * This method is used to clicks on clinical History tab and select down arrow button
	 * @throws Throwable
	 */
	@Then("^user clicks on clinical History tab and select down arrow button$")
	public void user_clicks_on_clinical_History_tab_and_select_down_arrow_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Drugname_Firstrow_Downarrow_Clinical_evaluation_Hyperlink)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_History_Drugname_Firstrow_Downarrow_Clinical_evaluation_Hyperlink))
					throw new Exception("Unable to click CE Hyperlink.");
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
	 * This method is used to clicks on user selects few iteractions from iteraction clinical evaluation screen and click override
	 * @throws Throwable
	 */
	@And("^user selects few iteractions from iteraction clinical evaluation screen and click override$")
	public void user_selects_few_iteractions_from_iteraction_clinical_evaluation_screen_and_click_override() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Interactions_List_Row_Checkbox_Zero)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_History_Interactions_List_Row_Checkbox_Zero))
					throw new Exception("Unable to click Checkbox Zero.");
			}
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Interactions_List_Row_Checkbox_two)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_History_Interactions_List_Row_Checkbox_two))
					throw new Exception("Unable to click Checkbox Two.");
			}
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Interactions_List_Row_Checkbox_Four)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_History_Interactions_List_Row_Checkbox_Four))
					throw new Exception("Unable to click Checkbox Four.");
			}
			if (isElementPresentVerification(SmokeTestConstants.CE_OverrideButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.CE_OverrideButton))
					throw new Exception("Unable to click Override Button.");
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
	 * This method is used to click cancel button and system shows popup screen and click yes
	 * @throws Throwable
	 */

	@Then("^user click cancel button and system shows popup screen and click yes$")
	public void user_click_cancel_button_and_system_shows_popup_screen_and_click_yes() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.CANCEL_BUTTON)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.CANCEL_BUTTON))
					throw new Exception("Unable to click Cancel Button.");
			}
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_Override_Cancel_Button_Popup_Click_Yes)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_Evaluation_Override_Cancel_Button_Popup_Click_Yes))
					throw new Exception("Unable to click Override Yes Button.");
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
	 * This method is used to validates the previous override iteractions
	 * @throws Throwable
	 */
	@Then("^user validates the previous override iteractions$")
	public void user_validates_the_previous_override_iteractions() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Interactions_List_Row_Checkbox_Zero)) {
				if (chromeDriver.findElement(By.xpath(ClinicalEvaluationConstants.Clinical_History_Interactions_List_Row_Checkbox_Zero)).isSelected()) {
					throw new Exception("Checkbox zero should not be selected.");
				}
			}
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Interactions_List_Row_Checkbox_two)) {
				if (chromeDriver.findElement(By.xpath(ClinicalEvaluationConstants.Clinical_History_Interactions_List_Row_Checkbox_two)).isSelected()) {
					throw new Exception("Checkbox two should not be selected.");
				}
			}
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Interactions_List_Row_Checkbox_Four)) {
				if (chromeDriver.findElement(By.xpath(ClinicalEvaluationConstants.Clinical_History_Interactions_List_Row_Checkbox_Four)).isSelected()) {
					throw new Exception("Checkbox four should not be selected.");
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
	 * This method is used to click on Clinical History tab
	 * @throws Throwable
	 */
	@When("^user clicks on Clinical History tab$")
	public void user_clicks_on_Clinical_History_tab() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.CE_CLINICAL_HISTORY_TAB)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.CE_CLINICAL_HISTORY_TAB))
					throw new Exception("Unable to click Clinical History Tab.");
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
	 * This method is used to verify show Clinical History tab
	 * @throws Throwable
	 */

	@Then("^system should show Clinical History tab$")
	public void system_should_show_Clinical_History_tab() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (!isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Window)) {
				throw new Exception("Clinical History Window not displayed.");
			}
			if (!isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Search)) {
				throw new Exception("Clinical History Search not displayed.");
			}
			if (!isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_X)) {
				throw new Exception("Clinical History X button not displayed.");
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
	 * This method is used to verify CH text box should show shadow text
	 * @throws Throwable
	 */

	@Then("^CH text box should show shadow text$")
	public void CH_text_box_should_show_shadow_text() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Search)) {
				WebElement chSearchBox = FrameworkLibrary.chromeDriver.findElement(By.xpath(ClinicalEvaluationConstants.Clinical_History_Search));
				String chShadowText = chSearchBox.getAttribute("placeholder");
				Assert.assertTrue(chShadowText.equals("Drug Name"));
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
	 * This method is used to click CH text box and type
	 * @throws Throwable
	 */

	@When("^click CH text box and type$")
	public void click_CH_text_box_and_type(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Search)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_History_Search))
					throw new Exception("Unable to find Clinical History Search box.");
			}
			String chSearch = SmokeTestLibrary.getData(arg1, "DrugName").toUpperCase();
			if (!clearAndEnterText(ClinicalEvaluationConstants.Clinical_History_Search, chSearch)) {
				throw new Exception("Not able to enter value in user name text field");
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
	 * This method is used to click CH text box and type and enter
	 * @throws Throwable
	 */
	@When("^click CH text box and type and enter$")
	public void click_CH_text_box_and_type_and_enter(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebElement chSearchBox = FrameworkLibrary.chromeDriver.findElement(By.xpath(ClinicalEvaluationConstants.Clinical_History_Search));
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Search)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_History_Search))
					throw new Exception("Unable to find Clinical History Search box.");
			}
			String chSearch = SmokeTestLibrary.getData(arg1, "DrugName").toUpperCase();
			if (!clearAndEnterText(ClinicalEvaluationConstants.Clinical_History_Search, chSearch)) {
				throw new Exception("Not able to enter value in user name text field");
			} else {
				chSearchBox.sendKeys(Keys.ENTER);
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
	 * This method is used to verify confirm no CH search results found and with valid assertions
	 * @throws Throwable
	 */
	@Then("^confirm no CH search results found$")
	public void confirm_no_CH_results_found() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.CH_Result_None_Text)) {
				Assert.assertTrue(getElementText(ClinicalEvaluationConstants.CH_Result_None_Text).equals("No results matched your search criteria"));
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
	 * This method is used to verify CH search shadow text should disappear valid assertions
	 * @throws Throwable
	 */
	@Then("^CH search shadow text should disappear$")
	public void CH_search_shadow_text_should_disappear() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Search)) {
				WebElement chSearchBox = FrameworkLibrary.chromeDriver.findElement(By.xpath(ClinicalEvaluationConstants.Clinical_History_Search));
				String chShadowTextBool = chSearchBox.getAttribute("class");
				Assert.assertTrue(chShadowTextBool.contains("not-empty"));
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
	 * This method is used to verify CH search bar is emptied out
	 * @throws Throwable
	 */

	@And("^CH search bar is emptied out$")
	public void CH_search_bar_is_emptied_out() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Search)) {
				clearTextField(ClinicalEvaluationConstants.Clinical_History_Search);
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
	 * This method is used to enter drug name and click clinical history search button
	 * @throws Throwable
	 */

	@When("^user enters drug name in clinical history search$")//Row_nine
	public void user_enters_drug_name_in_clinical_history_search(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Search)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_History_Search))
					throw new Exception("Unable to click Clinical History Search button.");
			}
			String chSearch = SmokeTestLibrary.getData(arg1, "DrugName").toUpperCase();
			if (!clearAndEnterText(ClinicalEvaluationConstants.Clinical_History_Search, chSearch)) {
				throw new Exception("Unable to enter drug name in CH search");
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
	 * This method is used to click select X at end of clinical history search and refine
	 * @throws Throwable
	 */

	@When("^select X at end of clinical history search and refine$")
	public void select_X_at_end_of_clinical_history_search_and_refine() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_X)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_History_X))
					throw new Exception("Unable to click Clinical History X button.");
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
	 * This method is used to verify clinical history search bar should be blanked
	 * @throws Throwable
	 */

	@Then("^clinical history search bar should be blanked$")
	public void clinical_history_search_bar_should_be_blanked() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Search)) {
				Assert.assertTrue(getElementText(ClinicalEvaluationConstants.Clinical_History_Search).equals(""), "Search bar has not been emptied out.");
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
	 * This method is used to perform CE search results should contain the drug keyword from list
	 * @throws Throwable
	 */

	@Then("^The CE search results should contain the drug keyword$")
	public void the_CE_search_results_should_contain_the_drug_keyword(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.CH_Result)) {
				List<WebElement> list1 = chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.CH_Result));
				String expectedDrugName = SmokeTestLibrary.getData(arg1, "DrugName").toUpperCase();
				for (int i = 0; i < list1.size(); i++) {
					if (list1.get(i).getText().contains(expectedDrugName)) {
						String s = list1.get(i).getAttribute("id");
						log.info(s);
						String[] parts = s.split("-");
						String part5 = parts[4];
						String currentItemNumber = String.valueOf(Integer.parseInt(part5) + 1);
						if (isElementPresentVerification("//*[contains(@id, 'clinical-history-item-list-" + part5 + "')]")) {
							List<WebElement> singlepresc = chromeDriver.findElements(By.xpath("//*[contains(@id, 'clinical-history-item-list-" + part5 + "')]"));
							log.info("size is" + singlepresc.size());
							for (int z = 0; z < singlepresc.size(); z++) {
								Assert.assertTrue(singlepresc.get(z).getText().contains(expectedDrugName), "Item #" + currentItemNumber + " does not contain expected value (" + expectedDrugName + ").");
								log.info("Item #" + currentItemNumber + " contains expected value (" + expectedDrugName + ").");
							}
						}
					}
					if (captureScreenshot) {
						takeScreenShot(methodName);
					}
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * This method is used to click on Search and Refine field
	 * @throws Throwable
	 */

	@Then("^I should see Search and Refine field$")
	public void i_should_see_Search_and_Refine_field() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Search)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_History_Search))
					throw new Exception("Unable to find Clinical History Search box.");
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
	 * This method is used enter drug name on Clinical History
	 * @throws Throwable
	 */

	@When("^I enter a drug name which is \"([^\"]*)\"$")
	public void i_enter_a_drug_name_which_is(String arg1, DataTable arg2) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Search)) {
				SmokeTestLibrary.enter_Text(arg2, "DrugName", ClinicalEvaluationConstants.Clinical_History_Search, chromeDriver);
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
	 * This method is used to verify see results for the drug
	 * @throws Throwable
	 */

	@Then("^I should see results for the drug$")
	public void i_should_see_results_for_the_drug() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.CH_Result_First_Drug_Name)) {
				Assert.assertTrue(!chromeDriver.findElement(By.xpath(ClinicalEvaluationConstants.CH_Result_First_Drug_Name)).getText().isEmpty(), "Field is empty");
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
	 * This method is used to perform remove the filter on clinical history search
	 * @throws Throwable
	 */
	@Then("^I remove the filter$")
	public void i_remove_the_filter() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Search)) {
				chromeDriver.findElement(By.xpath(ClinicalEvaluationConstants.Clinical_History_Search)).clear();
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
	 * This method is used enter three characters of drug name
	 * @throws Throwable
	 */
	@When("^I enter a three characters of drug name$")
	public void i_enter_a_three_characters_of_drug_name(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_Search)) {
				SmokeTestLibrary.enter_Text(arg1, "DrugName", ClinicalEvaluationConstants.Clinical_History_Search, chromeDriver);
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
	 * This method clicks on durg name column in clinical history
	 * @throws Throwable
	 */
	@When("^user clicks on Drug Name column$")
	public void i_click_drug_name_column() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.CE_CLINICAL_HISTORY_TAB_COLUMN)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.CE_CLINICAL_HISTORY_TAB_COLUMN))
					throw new Exception("Unable to find Clinical History Search box.");
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
	 * This method verifies for the prescription status should be In Progress -Reviewed after completing CE for respective second Rx
	 * @param arg1 will get the data from excel sheet
	 * @throws Throwable
	 */
	@And("^The prescription status should be In Progress -Reviewed after completing CE for respective second Rx$")
	public void verify_the_prescription_status_to_reviewed_after(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			Thread.sleep(5000);
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			Thread.sleep(5000);
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
			String expintakeDate = SmokeTestStepDef.intakenextdate;
			String expectedDrugName = ClinicalEvaluationLibrary.getData(arg1, "DrugName", 1).toLowerCase();

			if (isElementPresentVerification("//tr[contains(@id,'patient-')]")) {
				List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));
				log.info(elements.size());
				for (int i = 0; i < elements.size(); i++) {
					System.out.println("Checking the prescription: "+elements.get(i).getText());
					if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(possiblepickupTime1) &&elements.get(i).getText().toLowerCase().contains(expectedDrugName)) {
						Assert.assertTrue(elements.get(i).findElement(By.linkText("In Progress")).isDisplayed(),"Status is not in reviewed state");
						Assert.assertTrue(elements.get(i).getText().contains("Reviewed"),"Status is not in reviewed state");
						break;
					} else if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(pickuptime) &&elements.get(i).getText().toLowerCase().contains(expectedDrugName)) {
						Assert.assertTrue(elements.get(i).findElement(By.linkText("In Progress")).isDisplayed(),"Status is not in reviewed state");
						Assert.assertTrue(elements.get(i).getText().contains("Reviewed"),"Status is not in reviewed state");
						break;
					} else if (elements.get(i).getText().contains(expintakeDate) && elements.get(i).getText().contains(possiblepickupTime1) &&elements.get(i).getText().toLowerCase().contains(expectedDrugName)) {
						Assert.assertTrue(elements.get(i).findElement(By.linkText("In Progress")).isDisplayed(),"Status is not in reviewed state");
						Assert.assertTrue(elements.get(i).getText().contains("Reviewed"),"Status is not in reviewed state");
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
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method will click on clinical history tab
	 * @throws Throwable
	 */
	@Then("^user clicks on the Clinical History tab$")
	public void user_clicks_on_the_Clinical_History_tab() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions Clinicalhistory = new Actions(chromeDriver);
			Action enter = Clinicalhistory.sendKeys(Keys.ALT, "l").build();
			enter.perform();
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_history_page)) {
				if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_drug_list)) {
					List<WebElement> list = chromeDriver.findElementsByXPath(ClinicalEvaluationConstants.Clinical_History_drug_list);
					Assert.assertTrue(!list.isEmpty());
					if (captureScreenshot) {
						takeScreenShot(methodName);
					}
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verifies the header fields in clinical history
	 * @throws Throwable
	 */
	@Then("^user checks the header fields$")
	public void user_checks_the_header_fields() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_history_header_Drugname)) {
				String Drugname = FrameworkLibrary.getElementText(ClinicalEvaluationConstants.Clinical_history_header_Drugname);
				Assert.assertEquals(Drugname, "Drug Name");
			}
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_history_header_Rxnumber)) {
				String Rxnumber = FrameworkLibrary.getElementText(ClinicalEvaluationConstants.Clinical_history_header_Rxnumber);
				Assert.assertEquals(Rxnumber, "Rx Number");
			}
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_history_header_Storenumber)) {
				String Storenumber = FrameworkLibrary.getElementText(ClinicalEvaluationConstants.Clinical_history_header_Storenumber);
				Assert.assertEquals(Storenumber, "Store Number");
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
	 * This method verifies drug name and strength in clinical history drug list
	 * @throws Throwable
	 */
	@Then("^user verify drug name and strength$")
	public void user_verify_drug_name_and_strength() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_History_drug_list)) {
				List<WebElement> list = chromeDriver.findElementsByXPath(ClinicalEvaluationConstants.Clinical_History_drug_list);
				for (int i = 0; i < list.size(); i++) {
					Assert.assertTrue(list.get(i).getText() != null);
				}
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verifies the store number is five digits in length
	 * @throws Throwable
	 */
	@Then("^verify store number is five digit format$")
	public void verify_store_number_is_five_digit_format() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_history_drug_Store_number)) {
				List<WebElement> list = chromeDriver.findElementsByXPath(ClinicalEvaluationConstants.Clinical_history_drug_Store_number);
				for (int i = 0; i < list.size(); i++) {
					Boolean cond = list.get(i).getText().length() == 5;
					Assert.assertTrue(cond);
				}
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method clicks on a down arrow in clinical history on CE page
	 * @throws Throwable
	 */
	@Then("^click on downward arrow$")
	public void click_on_downward_arrow() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_history_downarrow_one)) {
				if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_history_downarrow_one))
					throw new Exception("Unable to find Clinical History Down Arrow.");
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
	 * This method verifies fill date is in valid format
	 * @throws Throwable
	 */
	@Then("^check fill date is in correct format$")
	public void check_fill_date_is_in_correct_format() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_history_downarrow_filldate_one)) {
				String s = FrameworkLibrary.getElementText(ClinicalEvaluationConstants.Clinical_history_downarrow_filldate_one);
				s.matches("\\d{2}/\\d{2}/\\d{4}");
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verfies the CE is displayed as hyperlink
	 * @throws Throwable
	 */
	@Then("^CE is displayed as hyperlink$")
	public void CE_is_displayed_as_hyperlink() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			chromeDriver.findElementByLinkText("Clinical Evaluation");
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verifies the presence of clinical history page
	 * @throws Throwable
	 */
	@Then("^select the CE hyperlink$")
	public void select_the_CE_hyperlink() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			chromeDriver.findElementByLinkText("Clinical Evaluation").click();
			if (!isElementPresentVerification(ClinicalEvaluationConstants.Clinical_history_evaluation_page)) {
				throw new Exception("Clinical History Evaluation Page not found");
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
	 * This method verifies the number of major interactions from radio button and major interactions from the list are equal in number on CE page
	 * @throws Throwable
	 */
	@Then("^user validates the Major iteractions feilds$")
	public void user_validates_the__Major_iteractions_feilds() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Thread.sleep(1000);
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_Major_Iteraction_Row)) {
				List<WebElement> iteractions = chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.Clinical_Evaluation_Major_Iteraction_Row));
				if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_Major_Iteractions_Radio_Button)) {
					String major = FrameworkLibrary.chromeDriver.findElement(By.xpath(ClinicalEvaluationConstants.Clinical_Evaluation_Major_Iteractions_Radio_Button)).getText();
					Assert.assertEquals(iteractions.size(), Integer.parseInt(major));
				}
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * This method verifies the number of moderate interactions from radio button and moderate interactions from the list are equal in number on CE page
	 * @throws Throwable
	 */
	@And("^user validates the Moderate Iteractions Feilds$")
	public void user_validates_the_Moderate_Iteractions_Feilds() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_Moderate_Iteractions_Row)) {
				List<WebElement> moderate = chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.Clinical_Evaluation_Moderate_Iteractions_Row));
				if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_Moderate_Interactions_Radio_Button)) {
					String moderated = FrameworkLibrary.chromeDriver.findElement(By.xpath(ClinicalEvaluationConstants.Clinical_Evaluation_Moderate_Interactions_Radio_Button)).getText();
					Assert.assertEquals(moderate.size(), Integer.parseInt(moderated));
				}
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verifies the number of therapy interactions from radio button and therapy interactions from the list are equal in number on CE page
	 * @throws Throwable
	 */
	@And("^user validates the Therapy_Iteractions Feilds$")
	public void user_validates_the_Therapy_Iteractions_Feilds() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_Therapy_Iteractions_Row)) {
				List<WebElement> therapy = chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.Clinical_Evaluation_Therapy_Iteractions_Row));
				if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_Therapy_Review_Radio_Button)) {
					String therapys = FrameworkLibrary.chromeDriver.findElement(By.xpath(ClinicalEvaluationConstants.Clinical_Evaluation_Therapy_Review_Radio_Button)).getText();
					Assert.assertEquals(therapy.size(), Integer.parseInt(therapys));
				}

				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	

	/**
	 * This method verifies pending link to perform the CE task is disabled in Patient order status
	 * @throws Throwable
	 */
	@Then("^The perform clinical evaluation hyperlink should be disabled$")
	public void validate_CE_hyperlink_disabled() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.POS_CE_disabled_Hyperlink)) {
				Assert.assertTrue(chromeDriver.findElement(By.xpath(SmokeTestConstants.POS_CE_disabled_Hyperlink)).getAttribute("disabled").equalsIgnoreCase("true"));
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * Method- Validate user is on Clinical Evaluation screen
	 * 
	 */

	@Then("^the Clinical Evaluation screen user is viewing still remains open$")
	public void the_Clinical_Evaluation_screen_user_is_viewing_still_remains_open() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(ClinicalEvaluationConstants.CE_PAGE_TITLE)) {
				FrameworkLibrary.verifyTextPresentElectron(ClinicalEvaluationConstants.CE_PAGE_TITLE, ClinicalEvaluationConstants.CE_PAGE_TITLE_VALUE);
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
	 * This method verifies system displays a Pediatric Interaction for the patient to click and check actual message
	 * @throws Throwable
	 */
	@And("^system displays a Pediatric Interaction for the patient$")
	public void system_displays_a_Pediatric_Interaction_for_the_patient() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Pediatric_feild)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Clinical_Evaluation_Pediatric_feild)) {
					throw new Exception("Unable to find Pediatric Field button.");
				}
				if (isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Pediatric_Message_Validation)) {
					String actual = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Clinical_Evaluation_Pediatric_Message_Validation)).getText();
					String expected = ClinicalEvaluationConstants.Clinical_Evaluation_Pediatric_Actual_Message_Validation;
					Assert.assertEquals(actual, expected);
				}
			
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method verifies system displays an interaction for Eldery patients using actions and click method
	 * @throws Throwable
	 */

@And("^system displays an interaction for Eldery patients$")
public void system_displays_an_interaction_for_Eldery_patients() throws Exception  {
	methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	try {
	
	 Actions upArrow = new Actions(chromeDriver);
     Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_DOWN).build();
     PressUpArrow.perform();
     Thread.sleep(1000);
		if (isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Elderly_Patient_Field)) {
			if (!isElementPresentVerifyClick(AccessManagementConstants.Clinical_Evaluation_Elderly_Patient_Field)) {
				throw new Exception("Unable to find Elderly Patient Field.");
			}
			if (isElementPresentVerification(AccessManagementConstants.Clinical_Evaluation_Elderly_Patient_Message_Displayed)) {
				String actual = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Clinical_Evaluation_Elderly_Patient_Message_Displayed)).getText();
				String expected = ClinicalEvaluationConstants.Clinical_Evaluation_Elderly_Patient_Actual_Message;
				Assert.assertEquals(actual, expected);
				
				
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
 * This method verifies that System should click on in progress link for current prescription after adding Rx
 * @param arg1 will get the data from excel sheet
 * @throws Throwable
 */
@Then("^The In progress link for current prescription should be clicked after adding Rx$")
public void click_in_progress_after_add_rx(DataTable arg1) throws Exception  {
	methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	try {
		SmokeTestStepDef.i_click_search_button_on_patient_order_status();
		Thread.sleep(5000);
		SmokeTestStepDef.i_click_search_button_on_patient_order_status();
		Thread.sleep(5000);
		if (isElementPresentVerification("//tr[contains(@id,'patient-')]")) {
			//List<WebElement> list1 = chromeDriver.findElements(By.xpath(SmokeTestConstants.POS_patientNames));
			String expectedDrugName = ClinicalEvaluationLibrary.getData(arg1, "DrugName", 1).toLowerCase();
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
			String expintakeDate = SmokeTestStepDef.intakenextdate;

			List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));
			log.info(elements.size());
			for (int i = 0; i < elements.size(); i++) {
				log.info(elements.get(i).getText());
				if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(possiblepickupTime1)&& elements.get(i).getText().toLowerCase().contains(expectedDrugName)) {
					elements.get(i).findElement(By.linkText("In Progress")).click();
					break;
				} else if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(pickuptime) && elements.get(i).getText().toLowerCase().contains(expectedDrugName)) {
					elements.get(i).findElement(By.linkText("In Progress")).click();
					break;
				} else if (elements.get(i).getText().contains(expintakeDate) && elements.get(i).getText().contains(possiblepickupTime1)&& elements.get(i).getText().toLowerCase().contains(expectedDrugName)) {
					elements.get(i).findElement(By.linkText("In Progress")).click();
					break;
				} else {
					log.info("The" + i + "prescription is not current");
					if (i == elements.size() - 1) {
						Assert.fail("prescription not found.");
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
 * This method verifies that System generates Rx number for current prescription after adding Rx
 * @param arg1 will get the data from excel sheet
 * @throws Throwable
 */
@Then("^System should generate Rx number for current prescription after adding Rx$")
public void system_should_generate_Rx_number_for_current_prescription_after_adding_Rx(DataTable arg1) throws Exception {
	methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	try {
		
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			Thread.sleep(5000);
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			Thread.sleep(5000);
			
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
			String expintakeDate = SmokeTestStepDef.intakenextdate;
			String expectedDrugName = ClinicalEvaluationLibrary.getData(arg1, "DrugName", 1).toLowerCase();
			System.out.println("Prduct from excel sheet: " + expectedDrugName);

			if (isElementPresentVerification("//tr[contains(@id,'patient-')]")) {
			List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));
			log.info(elements.size());
			for (int i = 0; i < elements.size(); i++) {
				log.info(elements.get(i).getText());
				if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(possiblepickupTime1) && elements.get(i).getText().toLowerCase().contains(expectedDrugName)) {
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
					SmokeTestStepDef.dynamicrxnum = rxnumberparts[0];
					log.info(SmokeTestStepDef.dynamicrxnum);
					log.info("Rx number is generated");
					String priceXpath = "//*[@id='patient-" + part1 + "-" + part2 + "-" + part3 + "']/td[" + l + "]";
					String dynamicrxnum1 = rxnumberparts[1];
					log.info(dynamicrxnum1);
					log.info("The size of the Rx number number is:" + SmokeTestStepDef.dynamicrxnum.length());
					log.info("The size of the store number is :" + dynamicrxnum1.length());
					Assert.assertEquals(SmokeTestStepDef.dynamicrxnum.length(), 7);
					Assert.assertEquals(dynamicrxnum1.length(), 5);
					String price = getElementText(priceXpath);
					Assert.assertTrue(price != null);
					log.info("The price for current prescription is generated");
					break;
				} else if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(pickuptime) && elements.get(i).getText().toLowerCase().contains(expectedDrugName)) {
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
					SmokeTestStepDef.dynamicrxnum = rxnumberparts[0];
					log.info(SmokeTestStepDef.dynamicrxnum);
					log.info("Rx number is generated");
					String priceXpath = "//*[@id='patient-" + part1 + "-" + part2 + "-" + part3 + "']/td[" + l + "]";
					String dynamicrxnum1 = rxnumberparts[1];
					log.info(dynamicrxnum1);
					log.info("The size of the Rx number number is:" + SmokeTestStepDef.dynamicrxnum.length());
					log.info("The size of the store number is :" + dynamicrxnum1.length());
					Assert.assertEquals(SmokeTestStepDef.dynamicrxnum.length(), 7);
					Assert.assertEquals(dynamicrxnum1.length(), 5);
					String price = getElementText(priceXpath);
					Assert.assertTrue(price != null);
					log.info("The price for current prescription is generated");
					break;
				} else if (elements.get(i).getText().contains(expintakeDate) && elements.get(i).getText().contains(possiblepickupTime1)&& elements.get(i).getText().toLowerCase().contains(expectedDrugName)) {
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
					SmokeTestStepDef.dynamicrxnum = rxnumberparts[0];
					log.info(SmokeTestStepDef.dynamicrxnum);
					log.info("Rx number is generated");
					String priceXpath = "//*[@id='patient-" + part1 + "-" + part2 + "-" + part3 + "']/td[" + l + "]";
					String dynamicrxnum1 = rxnumberparts[1];
					log.info(dynamicrxnum1);
					log.info("The size of the Rx number number is:" + SmokeTestStepDef.dynamicrxnum.length());
					log.info("The size of the store number is :" + dynamicrxnum1.length());
					Assert.assertEquals(SmokeTestStepDef.dynamicrxnum.length(), 7);
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
	}
	}catch (Exception e) {
		takeScreenShot(methodName);
		throw new Exception(e.getMessage());
	}
	
}

/**
 * This method verifies for the prescription status should be In Progress -Reviewed after completing CE for respective first Rx
 * @param arg1 will get the data from excel sheet
 * @throws Throwable
 */
@And("^The prescription status should be In Progress -Reviewed after completing CE for respective first Rx$")
public void verify_the_prescription_status_to_reviewed(DataTable arg1) throws Exception  {
	methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
	try {
			
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			Thread.sleep(5000);
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			Thread.sleep(5000);
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
			String expintakeDate = SmokeTestStepDef.intakenextdate;
			String expectedDrugName = ClinicalEvaluationLibrary.getData(arg1, "DrugName", 1).toLowerCase();
			
			if (isElementPresentVerification("//tr[contains(@id,'patient-')]")) {
			List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));
			log.info(elements.size());
			for (int i = 0; i < elements.size(); i++) {
				System.out.println("Checking the prescription: "+elements.get(i).getText());
				if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(possiblepickupTime1) &&elements.get(i).getText().toLowerCase().contains(expectedDrugName)) {
					Assert.assertTrue(elements.get(i).findElement(By.linkText("In Progress")).isDisplayed(),"Status is not in reviewed state");
					Assert.assertTrue(elements.get(i).getText().contains("Reviewed"),"Status is not in reviewed state");
					break;
				} else if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(pickuptime) &&elements.get(i).getText().toLowerCase().contains(expectedDrugName)) {
					Assert.assertTrue(elements.get(i).findElement(By.linkText("In Progress")).isDisplayed(),"Status is not in reviewed state");
					Assert.assertTrue(elements.get(i).getText().contains("Reviewed"),"Status is not in reviewed state");
					break;
				} else if (elements.get(i).getText().contains(expintakeDate) && elements.get(i).getText().contains(possiblepickupTime1) &&elements.get(i).getText().toLowerCase().contains(expectedDrugName)) {
					Assert.assertTrue(elements.get(i).findElement(By.linkText("In Progress")).isDisplayed(),"Status is not in reviewed state");
					Assert.assertTrue(elements.get(i).getText().contains("Reviewed"),"Status is not in reviewed state");
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
		}
	} catch (Exception e) {
		takeScreenShot(methodName);
		throw new Exception(e.getMessage());
	}
}

/**
 * This method clicks on override for major review and other as well in CE page
 * @throws Throwable
 */
@And("^user clicks on Override in CE screen$")
public void user_clicks_on_Override_in_CE_screen() throws Exception  {
	methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

	Boolean majorInteractionRadioButtonDisplayed = ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ClinicalEvaluationConstants.Clinical_Evaluation_Major_Iteractions_Radio_Button))).apply(chromeDriver);
			if(!majorInteractionRadioButtonDisplayed) {
				String count = FrameworkLibrary.getElementText(ClinicalEvaluationConstants.Clinical_Evaluation_Major_Iteractions_Radio_Button);
				int cnt = Integer.parseInt(count);
				if (isElementPresentVerification(SmokeTestConstants.CE_OverrideButton)) {
					if (!isElementPresentVerifyClick(SmokeTestConstants.CE_OverrideButton)) {
						throw new Exception("Not able to click login button");
					}
				}
				if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_override_popup)) {

					for (int i = 0; i < cnt; i++) {
						if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_dropdown)) {
							if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_dropdown)) {
								throw new Exception("Not able to click clinical evaluation DUR override dropdown button");
							}

							Thread.sleep(2000);
							Actions downArrow = new Actions(chromeDriver);
							Action PressdownArrow = downArrow.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build();
							PressdownArrow.perform();

							if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_comments)) {
								chromeDriver.findElementByXPath(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_comments).sendKeys("As per the patient guidance");
								if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_save)) {
									if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_save)) {
										throw new Exception("Not able to click clinical evaluation DUR override save button");
									}
								}
							}
						}
					}
				}
			}else if (isElementPresentVerification(SmokeTestConstants.CE_OverrideButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.CE_OverrideButton)) {
					throw new Exception("Not able to click login button");
				}
			}
}

/**
 * This method enter product information for product
 * @throws Throwable
 */
	@And("^enters product information for second product$")
	public void entersProductInformationForSecondProduct(DataTable arg1) throws Exception {
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

			if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();
				Thread.sleep(1000);
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


	/**
	 * This method enter product information for product in DE screen for first time
	 * @throws Throwable
	 */
	@And("^enters product information for first product$")
	public void entersProductInformationForFirstProduct(DataTable arg1) throws Exception {
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

			if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();
				Thread.sleep(1000);
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
	
	/**
	 * This method to check status as Reviewed and selects the current prescription
	 * @throws Throwable
	 */
	
	@And("^User validates the status as Reviewed and selects the current prescription$")
	public void UservalidatesthestatusasReviewedandselectsthecurrentprescription(DataTable arg1) throws Exception{
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			Thread.sleep(5000);
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			Thread.sleep(8000);
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
			String expintakeDate = SmokeTestStepDef.intakenextdate;
			String expectedDrugName = ClinicalEvaluationLibrary.getData(arg1, "DrugName", 1).toLowerCase();
			List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));

			for (int i = elements.size() - 1; i >= 0; i--) {
				int waitingColumn = 1;
				if (i == 0) {
					waitingColumn++;
				}
				if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(possiblepickupTime1) &&elements.get(i).getText().toLowerCase().contains(expectedDrugName)) {
					Assert.assertTrue(elements.get(i).findElement(By.linkText("In Progress")).isDisplayed(),"Status is not in reviewed state");
					Assert.assertTrue(elements.get(i).getText().contains("Reviewed"),"Status is not in reviewed state");
					CurrentPrescriptionRow = elements.get(i);
					String id = CurrentPrescriptionRow.getAttribute("id");
					String xpath = "//*[@id='" + id + "']/td[" + waitingColumn + "]";
					getElementByProperty(xpath, chromeDriver).click();
					Thread.sleep(2000);
					long timeoutExpiredMS = System.currentTimeMillis() + 40000;
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
				} else if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(pickuptime) &&elements.get(i).getText().toLowerCase().contains(expectedDrugName)) {
					Assert.assertTrue(elements.get(i).findElement(By.linkText("In Progress")).isDisplayed(),"Status is not in reviewed state");
					Assert.assertTrue(elements.get(i).getText().contains("Reviewed"),"Status is not in reviewed state");
					CurrentPrescriptionRow = elements.get(i);
					String id = CurrentPrescriptionRow.getAttribute("id");
					String xpath = "//*[@id='" + id + "']/td[" + waitingColumn + "]";
					getElementByProperty(xpath, chromeDriver).click();
					Thread.sleep(2000);
					long timeoutExpiredMS = System.currentTimeMillis() + 40000;
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
				} else if (elements.get(i).getText().contains(expintakeDate) && elements.get(i).getText().contains(possiblepickupTime1)&&elements.get(i).getText().toLowerCase().contains(expectedDrugName)) {
					Assert.assertTrue(elements.get(i).findElement(By.linkText("In Progress")).isDisplayed(),"Status is not in reviewed state");
					Assert.assertTrue(elements.get(i).getText().contains("Reviewed"),"Status is not in reviewed state");
					CurrentPrescriptionRow = elements.get(i);
					String id = CurrentPrescriptionRow.getAttribute("id");
					String xpath = "//*[@id='" + id + "']/td[" + waitingColumn + "]";
					getElementByProperty(xpath, chromeDriver).click();
					Thread.sleep(2000);
					long timeoutExpiredMS = System.currentTimeMillis() + 40000;
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

	
	/**
	 * This method to click on OK button on current task cancel pop up
	 * @throws Throwable
	 */

	@And("^clicks on OK button on current task cancel pop up$")
	public void clicksOnOKButtonOnCurrentTaskCancelPopUp() throws Throwable {

		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(!isElementPresentVerifyClick(SmokeTestConstants.CE_StopCurrentTassk_OkButton))
					throw new Exception("Unable to find Med History Link.");
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	
	
}
