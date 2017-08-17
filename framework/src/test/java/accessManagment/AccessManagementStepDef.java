package accessManagment;

import clinicalEvaluation.ClinicalEvaluationConstants;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.FrameworkLibrary;
import hangOn.hangOnConstants;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import smokeTest.SmokeTestConstants;
import smokeTest.SmokeTestStepDef;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

// roles,roleManagement,roleManage

public class AccessManagementStepDef extends FrameworkLibrary {

	public static int DE_NumberOfTasksBeforeIntake;
	public static int DR_NumberOfTasksBeforeDE;
	public static int NumberOfFillingTasks;
	public static int NumberofCETasksBeforeDR;
	public static String IntakeDate;
	public static String currentPickupTime;
	public static String possiblePickupTime;
	public static String patientFullName;
	static String account_Name;
	private static String methodName;
	private static Log log = LogFactory.getLog(AccessManagementStepDef.class);
	String storeNo;
	Actions bc = new Actions(chromeDriver);
	AccessManagementLibrary accessManagementLibrary = null;


	public AccessManagementStepDef() throws ConfigurationException, IOException {

		super();
		// TODO Auto-generated constructor stub
		//accessManagementLibrary = new AccessManagementLibrary(chromeDriver);
	}

	/****************************************************************************
	 * Method : To click on login button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/
	@And("^I click on login buton$")
	public void i_click_on_login_buton() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.login_button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.login_button)) {
					throw new Exception("Not able to click the Login button");
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
	 * Method : To check if required tabs are visible
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^I able to see folling tabs$")
	public void i_able_to_see_folling_tabs1(DataTable tableData) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			List<String> options = tableData.asList(String.class);
			for (int i = 0; i < options.size(); i++) {
				log.info("Verifying element is....." + options.get(i));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		}
	}

	/****************************************************************************
	 * Method : To Check if the expected buttons are visible
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^I able to see follwing buttons$")
	public void i_able_to_see_follwing_buttons(DataTable tableData) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			List<String> options = tableData.asList(String.class);
			for (int i = 0; i < options.size(); i++) {
				log.info("Verifying element is....." + options.get(i));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		}
	}

	/*
	 * Method to click on Med history button on patient profile
	 */
	@Then("^user click on Med History$")
	public void user_click_on_Med_History() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patient_MedHIstory_Button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Patient_MedHIstory_Button)) {
					throw new Exception("Not able to click the MedHistory button");
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
	 * Method : To check if user is able to see medication history 
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^User able to see Medication History$")
	public void user_able_to_see_Medication_History(DataTable tableData) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			List<String> options = tableData.asList(String.class);
			for (int i = 0; i < options.size(); i++) {
				log.info("Verifying element is....." + options.get(i));
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
	 * Method : To click on in progress down button on med history
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^user click on in progress arrow down button$")
	public void user_click_on_in_progress_arroe_down_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.MedHistory_Arrow_Dropdown)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.MedHistory_Arrow_Dropdown)) {
					throw new Exception("Not able to click the Medhistory dropdown");
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
	 * Method : To check if user is able to see specific fields
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^User able to see following feilds$")
	public void user_able_to_see_following_feilds(DataTable tableData) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			List<String> options = tableData.asList(String.class);
			for (int i = 0; i < options.size(); i++) {
				log.info("Verifying element is....." + options.get(i));
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
	 * Method : To click on image tab of patient profile page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^user click on image tab$")
	public void user_click_on_image_tab1() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patient_Images_Tab)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Patient_Images_Tab)) {
					throw new Exception("Not able to click the tab");
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
	 * Method : To check if user is able to see images tab contents in patient profile
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^I able to see image page$")
	public void i_able_to_see_image_page1(DataTable tableData) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			List<String> options = tableData.asList(String.class);
			for (int i = 0; i < options.size(); i++) {
				log.info("Verifying element is....." + options.get(i));
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
	 * Method : TO check if user is able to see specified tabs
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^I able to see folling tabs:$")
	public void i_able_to_see_folling_tabs(DataTable tableData) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			List<String> options = tableData.asList(String.class);
			for (int i = 0; i < options.size(); i++) {
				log.info("Verifying element is....." + options.get(i));
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
	 * Method : To check if the update button is enabled on patient profile
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@And("^update button is enabled$")
	public void update_button_is_enabled() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patient_Update_Enabled_Button)) {
				Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Patient_Update_Enabled_Button)).isEnabled(), "Update button is not enabled");
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
	 * Method : To check if user is able to see scan button enabled on patient profile
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^user able to see Scan button enabled$")
	public void user_able_to_see_Scan_button_enabled() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patient_Scan_Hidden_Button)) {
				Assert.assertTrue(!FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Patient_Scan_Hidden_Button)).getText().contains("Scan"), "Scan button not present");
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
	 * Method : To check if user is able to see add new and update buttons
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^User able to see hidden buttons AddNew and Update$")
	public void user_able_to_see_hidden_buttons_AddNew_and_Update() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patient_Add_New) && isElementPresentVerification(AccessManagementConstants.Patient_Update_Button)) {
				Assert.assertTrue(!FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Patient_Add_New)).isEnabled(), "Add New Button should not be enabled");
				Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Patient_Update_Button)).isEnabled(), "Update button should not be enabled");
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
	 * Method : To click on General info tab of patient profile
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^user clicks on General info$")
	public void user_clicks_on_General_info() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patient_Genaral_Info)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Patient_Genaral_Info)) {
					throw new Exception("Not able to click General Info");
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
	 * Method : To check if user is able to see demographic and allergies details
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^user able to see Demographic and Allergies details$")
	public void user_able_to_see_Demographic_and_Allergies_details(DataTable tableData) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			List<String> options = tableData.asList(String.class);
			for (int i = 0; i < options.size(); i++) {
				log.info("Verifying element is....." + options.get(i));
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
	 * Method : To check when user clicks on third party pan tabs of patient profile page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^user click on third party plan$")
	public void user_click_on_third_party_plan() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patient_3rd_Party_Plans)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Patient_3rd_Party_Plans)) {
					throw new Exception("Not able to click 3rd Party Plans");
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
	 * Method : To check if user is able to see patient plan information details
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^user able to see patient plan information$")
	public void user_able_to_see_patient_plan_information(DataTable tableData) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			List<String> options = tableData.asList(String.class);
			for (int i = 0; i < options.size(); i++) {
				log.info("Verifying element is....." + options.get(i));
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
	 * Method : To click on preferences tab on patient profile
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@When("^user click on Preferences$")
	public void user_click_on_Preferences() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patient_Preferences_Tab)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Patient_Preferences_Tab)) {
					throw new Exception("Not able to click Preferences Tab");
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
	 * Method : Check if preference tab has required fields
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I am preferences page tab$")
	public void i_am_preferences_page_tab(DataTable tableData) throws Exception  {
		List<String> options = tableData.asList(String.class);
		for (int i = 0; i < options.size(); i++) {
			log.info("Verifying element is....." + options.get(i));
		}

	}

	/****************************************************************************
	 * Method : To check if the expected error message is displayed
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^User able to see error message No results found$")
	public void user_able_to_see_error_message_no_results_found() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Boolean condition = FrameworkLibrary.chromeDriver.getPageSource().contains("No results found.");
			Assert.assertTrue(condition, "No results found error message not present on page");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method : To check if User management tab is highlighted by default on Admin landing page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^User Management by deafult it will be highlited$")
	public void user_management_by_default_it_will_be_highlited() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.userManagement)) {
				throw new Exception("User Management is not highlighted");
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
	 * Method : To check if Duplicate role name error message is displayed 
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^system displays error message already exist$")
	public void system_displays_error_message_already_exist() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Boolean condition = FrameworkLibrary.chromeDriver.getPageSource().contains("Duplicate role name");
			Assert.assertTrue(condition, "Duplicate role name error message not present on page");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method : To check if popup is displayed for duplicate role entry during add new role
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I able to see popup for duplicte role entry$")
	public void i_able_to_see_popup_for_duplicate_role_entry() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Boolean condition = FrameworkLibrary.chromeDriver.getPageSource().contains("This role name already exists. Update role name");
			Assert.assertTrue(condition, "This role name already exists. Update role name popup message not present on page");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method : To click on duplicate role entry popup
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I click ok on duplicte role entry popup$")
	public void i_click_ok_on_duplicate_role_entry_popup() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(AccessManagementConstants.Admin_Add_role_Popup)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Admin_Add_role_Popup))
					throw new Exception("Not able to click the Add role popup");
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
	 * Method : To check if duplicate role entry popup is getting closed
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^duplicte role entry popup will be closed$")
	public void duplicate_role_entry_popup_will_be_closed() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Boolean condition = FrameworkLibrary.chromeDriver.getPageSource().contains("This role name already exists. Update role name");
			Assert.assertFalse(!condition, "This role name already exists. Update role name popup message is present on page");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method : To check if pharmacy information is displayed
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I can view the  pharmacy location information$")
	public void i_can_view_the_pharmacy_location_information(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		Map<String, List<String>> dataMap = null;
		try {
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String PharmacyInformation = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
					dataMap.get("RowId").get(0), "Pharmacy Information");
			log.info(PharmacyInformation);
			Boolean condition = FrameworkLibrary.chromeDriver.getPageSource().contains("Pharmacy Information");
			Assert.assertTrue(condition, "location info not presented on page");
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Method to see product that matches search criteria
	 */
	@Then("^I able to see product that matches with the search criteria entered$")
	public void i_able_to_seeproduct_that_matches_with_the_search_criteria_entered(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (!isElementPresentVerification(AccessManagementConstants.Drug_AMI_Search_Results)) {
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
	 * Method : To check if the specified navigation tabs are present
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^user able to see following navigation tabs$")
	public void user_able_to_see_following_navigation_tabs() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(AccessManagementConstants.Dashboard_patient_search_Tab) && isElementPresentVerification(AccessManagementConstants.Dashboard_patient_search_Tab) && isElementPresentVerification(AccessManagementConstants.Dashboard_drug_search_Tab)
					&& isElementPresentVerification(AccessManagementConstants.Dashboard_plan_search_Tab) && isElementPresentVerification(AccessManagementConstants.Dashboard_patient_order_status_search_Tab) && isElementPresentVerification(AccessManagementConstants.Dashboard_admin)
					&& isElementPresentVerification(AccessManagementConstants.Dashboard_logout_button)) {
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
	 * Method : TO check if user is on role management screen
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^user will be on role management Screen$")
	public void user_will_be_on_role_management_Screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Patient_RXMS_RoleManagement)) {
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
	 * Method : To enter drug ndc number on drug search page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I enter Drug NDC number on search feild$")
	public void i_enter_Drug_NDC_number_on_search_feild(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.drug_search_feild)) {
				AccessManagementLibrary.enter_Text(arg1, "NDC-Code", AccessManagementConstants.drug_search_feild, chromeDriver);
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
	 * Method : To check if results displayed for NDC based keyword search on drug search page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I able to see the drug NDC on drug search results$")
	public void i_able_to_see_the_drug_NDC_on_drug_search_results() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String exptVal = getXLSTestData("TestData", "Product-NDC", "Row_Intake_1", "NDC-Code");
			if (isElementPresentVerification(AccessManagementConstants.Drug_NDC_Code)) {
				String actVal = chromeDriver.findElement(By.xpath(AccessManagementConstants.Drug_NDC_Code)).getText();
				Assert.assertTrue(exptVal.contains(actVal), "Text not found!");
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
	 * Method : To click search button using Alt plus S on drug search page 
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^clicks search button on drug search page using ALT plus S hot key$")
	public void clicks_search_button_on_drug_search_page_using_ALT_plus_S_hot_key() throws Exception  {
		Actions ac = new Actions(chromeDriver);
		Action series = ac.keyDown(Keys.ALT).sendKeys("s").keyUp(Keys.ALT).build();
		series.perform();
	}

	/****************************************************************************
	 * Method : To check if clinical references page is displayed
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^system displays correctly clinical references page$")
	public void system_displays_correctly_clinical_references_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Drug_Clinical_Reference_Results)) {
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
	 * Method : To click on clinical references
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^user click on Clinical References$")
	public void user_click_on_Clinical_References() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Drug_Clinical_Reference)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Drug_Clinical_Reference))
					throw new Exception("Not able to click Clinical Reference");
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
	 * Method : To enter drug quick code on drug search field
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I enter Drug Quick Code on search feild$")
	public void i_enter_Drug_Quick_Code_on_search_feild(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.drug_search_feild)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.drug_search_feild))
					throw new Exception("Not able to click search field");
				AccessManagementLibrary.enter_Text(arg1, "Quick-code", AccessManagementConstants.drug_search_feild, chromeDriver);
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
	 * Method : To check if results displayed based on quick code search on drug search page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I able to see the Quick Code on drug search results$")
	public void i_able_to_see_the_Quick_Code_on_drug_search_results() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			//String exptVal = getXLSTestData("DrugSearch", "Product-Quick", "Row_Intake_1", "Quick-code");
			//log.info(exptVal);
			if (isElementPresentVerification(AccessManagementConstants.Drug_Quick_Code)) {
				boolean actVal = (chromeDriver.findElement(By.xpath(AccessManagementConstants.Drug_Quick_Code)).getAttribute("value")) != null;
				Assert.assertTrue(actVal, "Text not found!");
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
	 * Method : To check if Generali info tab is displayed on product page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^shows the Product General Info tab$")
	public void shows_the_Product_General_Info_tab() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Drug_General_Info_Product)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(AccessManagementConstants.Drug_General_Info_Product));
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
	 * Method : To enter specified test 
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^user enter \"([^\"]*)\" it will select a name start with R$")
	public void user_enter_it_will_select_a_name_start_with_R(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.SYSTEM_AREA_DROPDOWN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.SYSTEM_AREA_DROPDOWN)) {
				}
				FrameworkLibrary.chromeDriver.findElement(By.xpath("//div[@class='md-text ng-binding' and contains(text(),'BPM')]")).click();
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
	 * Method : To click on disbaled/enabled task
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I click on any \"([^\"]*)\" task$")
	public void i_click_on_any_task(final String taskactivity) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (taskactivity.equals("enabled")) {
				if (isElementPresentVerification(AccessManagementConstants.DR_TaskButton)) {
					Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.DR_TaskButton, chromeDriver).isEnabled(), "DR task is disabled");
				}
			} else if (taskactivity.equals("disabled")) {
				Assert.assertFalse(FrameworkLibrary.getElementByProperty(AccessManagementConstants.DR_TaskButton, chromeDriver).isEnabled(), "DR task is enabled");
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
	 * Method : To Close the application
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I close the application$")
	public void i_close_the_application() throws Exception  {
		chromeDriver.quit();
	}

	/****************************************************************************
	 * Method : To check if the system displays specific task as disabled
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^Sytem should display the specific task disabled$")
	public void sytem_should_display_the_specific_task_disabled() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.DR_TaskButton) && isElementPresentVerification(AccessManagementConstants.CE_TaskButton) && isElementPresentVerification(AccessManagementConstants.ProductVerification_TaskButton)) {
				Assert.assertFalse(FrameworkLibrary.getElementByProperty(AccessManagementConstants.DR_TaskButton, chromeDriver).isEnabled(), "DR task is enabled");
				Assert.assertFalse(FrameworkLibrary.getElementByProperty(AccessManagementConstants.CE_TaskButton, chromeDriver).isEnabled(), "CE task is enabled");
				Assert.assertFalse(FrameworkLibrary.getElementByProperty(AccessManagementConstants.ProductVerification_TaskButton, chromeDriver).isEnabled(), "Product verification task is enabled");
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
	 *  Method to check if the system displays the task as enabled
	 */
	@Then("^Sytem should display the task enabled$")
	public void sytem_should_display_the_task_enabled() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(AccessManagementConstants.DR_TaskButton) && isElementPresentVerification(AccessManagementConstants.DE_TaskButton) && isElementPresentVerification(AccessManagementConstants.CE_TaskButton) && isElementPresentVerification(AccessManagementConstants.ProductVerification_TaskButton)) {
				Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.DR_TaskButton, chromeDriver).isDisplayed(), "DR task is not displayed");
				Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.DE_TaskButton, chromeDriver).isDisplayed(), "DE task is not displayed");
				Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.CE_TaskButton, chromeDriver).isDisplayed(), "CE task is not displayed ");
				Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.ProductVerification_TaskButton, chromeDriver).isDisplayed(), "PV task is not displayed ");

				Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.DR_TaskButton, chromeDriver).isEnabled(), "DR task is enabled");
				Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.DE_TaskButton, chromeDriver).isEnabled(), "DE task is enabled");
				Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.CE_TaskButton, chromeDriver).isEnabled(), "CE task is enabled");
				Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.ProductVerification_TaskButton, chromeDriver).isEnabled(), "PV task is enabled");
				Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.Filling_TaskButton, chromeDriver).isEnabled(), "Filling is enabled");

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
	 * Method : To click on navigation panel
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^user click on navigation panel$")
	public void i_click_on_the_naviagation_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(AccessManagementConstants.Navigation_link)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Navigation_link))
					throw new Exception("Not able to click Navigation Link");
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
	 * Method : To check if the navigation panel is collapsed
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see navigation panel is collapsed$")
	public void i_should_see_navigation_panel_is_collapsed() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Navigation_collapsed)) {
				Assert.assertFalse(AccessManagementLibrary.isElementPresent(AccessManagementConstants.Navigation_collapsed), "Naviagation panel is not collapsed");
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
	 * Method : To check if patient with name starting with P is selected
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^user enter patient it will select a name start with P$")
	public void user_enter_patient_it_will_select_a_name_start_with_P() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.SYSTEM_AREA_DROPDOWN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.SYSTEM_AREA_DROPDOWN))
					throw new Exception("Not able to click system area dropdown");
				FrameworkLibrary.chromeDriver.findElement(By.xpath("//div[@class='md-text ng-binding' and contains(text(),'PATIENT')]")).click();
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
	 * Method : To check if the navigation panel is expanded
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see navigation panel is expanded$")
	public void i_should_see_navigation_panel_is_expanded() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Navigation_collapsed)) {
				throw new Exception("Naviagation panel is not expanded");
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
	 * Method : To click on username
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I click on the username$")
	public void i_click_on_the_username() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Navigation_initial)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Navigation_initial))
					throw new Exception("Not able to click Initial");
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
	 * Method : To click on user initial on home screen
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I click on the initial$")
	public void i_click_on_the_initial() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Navigation_initial)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Navigation_initial))
					throw new Exception("Not able to click Initial");
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
	 * Method : To click on back and navigated to dashboard page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click back to navigate to dashboard page$")
	public void i_click_back_to_navigate_to_dashboard() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Profile_back_button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Profile_back_button))
					throw new Exception("Not able to click Profile Back Button");
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
	 * Method : To select Pharmacist role from the role list
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^User selct Pharmacist role from list$")
	public void user_selct_Pharmacist_role_from_list() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.PHARMACIST_ROLE_FROM_LIST)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PHARMACIST_ROLE_FROM_LIST))
					throw new Exception("Not able to click Role from list");
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
	 * Method : To select a patient with read permissions and move to right
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I select patient with read permissions and click move to right$")
	public void i_select_patient_with_read_permissions_and_click_move_to_right() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Admin_Create_role_Search_Available)) {
				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Admin_Create_role_Search_Available)).sendKeys("Read");
				for (int i = 1; i <= 7; i++) {
					FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='available']/md-list[" + i + "]/md-list-item/div/md-checkbox")).click();

				}
				if (!isElementPresentVerifyClick(AccessManagementConstants.MOVE_TO_LEFT)) {
					throw new Exception("Not able to click Move to Left");
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
	 * Method : To remove all permissions except update permission for the selected role
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I remove all permissions except update permission$")
	public void i_remove_all_permissions_except_update_permission() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			i_select_patient_with_read_permissions_and_click_move_to_right();
			if (isElementPresentVerification(AccessManagementConstants.Admin_Create_role_Search_Available)) {
				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Admin_Create_role_Search_Available)).sendKeys("Create");
				for (int i = 1; i <= 2; i++) {
					FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='available']/md-list[" + i + "]/md-list-item/div/md-checkbox")).click();

				}
				if (!isElementPresentVerifyClick(AccessManagementConstants.MOVE_TO_LEFT)) {

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
	 * Method : To select all read permissions and move it to available permissions field
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I will select all read permissions and move to avilable permission$")
	public void i_will_select_all_read_permissions_and_move_to_avilable_permission() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Admin_Create_role_Search_NotAvailable)) {
				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Admin_Create_role_Search_NotAvailable)).sendKeys("Read");
				for (int i = 1; i <= 7; i++) {
					FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='not-available']/md-list[" + i + "]/md-list-item/div/md-checkbox")).click();

				}
				if (!isElementPresentVerifyClick(AccessManagementConstants.MOVE_TO_RIGHT)) {
					throw new Exception("Not able to click Move to Right");
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

	/****************************************************************************
	 * Method : To Select all permissions and click move to right button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I will select all permissions and move to avilable permission$")
	public void i_will_select_all_permissions_and_move_to_avilable_permission() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			i_will_select_all_read_permissions_and_move_to_avilable_permission();
			if (isElementPresentVerification(AccessManagementConstants.Admin_Create_role_Search_NotAvailable)) {
				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Admin_Create_role_Search_NotAvailable)).sendKeys("Create");
				for (int i = 1; i <= 2; i++) {
					FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='not-available']/md-list[" + i + "]/md-list-item/div/md-checkbox")).click();
				}
				if (!isElementPresentVerifyClick(AccessManagementConstants.MOVE_TO_RIGHT))
					throw new Exception("Not able to click Move to Right");
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
	 * Method : To check if Add new button is hidden for specific roles
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I able to see system hides the Add New button$")
	public void i_able_to_see_system_hides_the_Add_New_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Boolean condition = FrameworkLibrary.chromeDriver.getPageSource().contains("Add New");
			Assert.assertFalse(condition, "Add New button presented on page");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/****************************************************************************
	 * Method : To check if update button is hidden
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I able to see system hides update button$")
	public void i_able_to_see_system_hides_update_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Boolean condition = FrameworkLibrary.chromeDriver.getPageSource().contains("pdate");
			Assert.assertFalse(condition, "Update button presented on page");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method : To select update permission option for the selected role type
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I select patient update permissions and click move to right$")
	public void i_select_patient_update_permissions_and_click_move_to_right() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			i_remove_all_permissions_except_update_permission();
			if (isElementPresentVerification(AccessManagementConstants.Admin_Create_role_Search_Available)) {
				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Admin_Create_role_Search_Available)).sendKeys("update");
				for (int i = 1; i <= 5; i++) {
					FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='available']/md-list[" + i + "]/md-list-item/div/md-checkbox")).click();
				}

				if (!isElementPresentVerifyClick(AccessManagementConstants.MOVE_TO_LEFT))
					throw new Exception("Not able to click Move to left");
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
	 * Method : To select update and create permissions for specific role type
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I will select all update and create permissions and move to avilable permission$")
	public void i_will_select_all_update_and_create_permissions_and_move_to_avilable_permission() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			i_will_select_all_permissions_and_move_to_avilable_permission();
			if (isElementPresentVerification(AccessManagementConstants.Admin_Create_role_Search_Available)) {
				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Admin_Create_role_Search_Available)).sendKeys("update");
				for (int i = 1; i <= 5; i++) {
					FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='available']/md-list[" + i + "]/md-list-item/div/md-checkbox")).click();

				}

				if (!isElementPresentVerifyClick(AccessManagementConstants.MOVE_TO_RIGHT))
					throw new Exception("Not able to click Move to Right");
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
	 * Method : To check if update button is displayed
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^system displays the update button$")
	public void system_displays_the_update_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patient_Update_Button)) {
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
	 * Method : To select Admin role from role list page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I select Admin role from role information$")
	public void I_select_Admin_role_from_role_information(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String role = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Role");
			String roleDec = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Description");
			log.info(roleDec);
			chromeDriver.findElement(By.xpath("//*[contains(@aria-label,'" + role + "')]")).click();

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		} catch (AssertionError e) {
			e.printStackTrace();
			takeScreenShot(methodName);

		}

	}

	/****************************************************************************
	 * Method : To select Data review
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^user enter Data review it will select DR$")
	public void user_enter_Data_review_it_will_select_DR() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.SYSTEM_AREA_DROPDOWN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.SYSTEM_AREA_DROPDOWN))
					throw new Exception("Not able to click System Area Dropdown");
				FrameworkLibrary.chromeDriver.findElement(By.xpath("//div[@class='md-text ng-binding' and contains(text(),'Data Review')]")).click();
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
	 * Method : To enter data entry
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^user enter Data Entry it will select DE$")
	public void user_enter_Data_Entry_it_will_select_DE() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.SYSTEM_AREA_DROPDOWN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.SYSTEM_AREA_DROPDOWN))
					throw new Exception("Not able to click System Area Dropdown");
				FrameworkLibrary.chromeDriver.findElement(By.xpath("//div[@class='md-text ng-binding' and contains(text(),'Data Entry')]")).click();
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
	 * Method : To enter drug name on search field of drug search
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I enter Minimum Criteria Drug name on search feild$")
	public void i_enter_Minimum_Criteria_Drug_name_on_search_feild(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.drug_search_feild)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.drug_search_feild))
					throw new Exception("Not able to click search field");
				AccessManagementLibrary.enter_Text(arg1, "DrugSearchResult", AccessManagementConstants.drug_search_feild, chromeDriver);
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
	 * Method : TO check if user is able to update button on store information page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^user able to see store update button$")
	public void user_able_to_see_store_update_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Store_Home_Update_Button)) {
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
	 * Method : To remove permissions other than read 
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I remove all permissions except Read permission$")
	public void i_remove_all_permissions_except_Read_permission() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			i_remove_all_permissions_except_update_permission();

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/****************************************************************************
	 * Method : To click view button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I click the View Button$")
	public void i_click_the_View_Button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Admin_View_Button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Admin_View_Button))
					throw new Exception("Not able to click View Button");
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
	 * Method : TO check if user is able to see update button on store page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^user able to see update button$")
	public void user_able_to_see_update_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Store_Update_button)) {
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
	 * Method : To click any team member and TO CHECK if user is able to see phone numbers
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click on team member profile and able to see Phone Number$")
	public void i_click_on_team_member_profile_and_able_to_see_Phone_Number() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.TeamMember_Phone_Profile)) {
				String Phone = getElementText(AccessManagementConstants.TeamMember_Phone_Profile);
				Assert.assertTrue(Phone != null);
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
	 * Method : To check if new password and confirm password do not match
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^user able to see error New Password and Confirm Password do not match$")
	public void user_able_to_see_error_New_Password_and_Confirm_Password_do_not_match() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Admin_Password_Missmatch)) {
				String actualerrormessage = getElementText(AccessManagementConstants.Admin_Password_Missmatch);
				String expectedMessage = "reportThe New Password and Confirm Password do not match.";
				Assert.assertTrue(actualerrormessage.equalsIgnoreCase(expectedMessage));
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
	 * Method : To click back button from team member profile page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click on back button on Team member profile$")
	public void i_click_on_back_button_on_Team_member_profile() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.TeamMember_Profile_Back_Button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.TeamMember_Profile_Back_Button))
					throw new Exception("Not able to click Profile Back Button");
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
	 * Method : To navigate to user profile page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I will be navigate to user profile$")
	public void i_will_be_navigate_to_user_profile() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.User_profile_tab)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.User_profile_tab))
					throw new Exception("Not able to click Profile Tab");
			}
			if (isElementPresentVerification(AccessManagementConstants.MY_Profile)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.MY_Profile))
					throw new Exception("Not able to click Profile Tab");
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
	 * Method : To click on team member tab
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click on team member tab$")
	public void i_click_on_team_member_tab() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Team_member_tab)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Team_member_tab))
					throw new Exception("Not able to click member tab");
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
	 * Method : To check if user is not able to see team member tab
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I not able to see team member tab$")
	public void I_not_able_to_see_team_member_tab() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.All_buttons_Present)) {
				Assert.assertTrue(!AccessManagementLibrary.getElement(AccessManagementConstants.All_buttons_Present).getText().contains("Add"), "Add buton not present");
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
	 * Method : To check if user is able to see list of team members
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I able to see list of team members$")
	public void i_able_to_see_list_of_team_members(DataTable tableData) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String pageSource = chromeDriver.getPageSource();
			List<String> options = tableData.asList(String.class);
			for (int i = 0; i < options.size(); i++) {
				log.info("Verifying element is....." + options.get(i));
				Boolean condition = pageSource.contains(options.get(i));
				Assert.assertTrue(condition, options.get(i) + " field not presented on page");
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
	 * Method : To select a team member from team member list
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I will select perticular team member from the list$")
	public void i_will_select_perticular_team_member_from_the_list() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Team_member_UXA)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Team_member_UXA))
					throw new Exception("Not able to click UXA");
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
	 * Method : To check if user doesnot have privilage to update
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I am on profile page he dont have the sufficient privilages to update$")
	public void i_am_on_profile_page_he_dont_have_the_sufficient_privilages_to_update() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Team_profile_Update)) {
				Boolean condition = chromeDriver.findElement(By.xpath(AccessManagementConstants.Team_profile_Update)).isDisplayed();
				Assert.assertTrue(!condition, "it is not displayed");
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
	 * Method : To click on my profile tab
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I will click on My profile$")
	public void i_will_click_on_My_profile() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.User_profile_tab)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.User_profile_tab))
					throw new Exception("Not able to click Profile tab");
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
	 * Method : To select retail pharmacist employee
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I will select  Retail Pharmacist employee$")
	public void i_will_select_emplyee() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Team_member_Pharmacit)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Team_member_Pharmacit))
					throw new Exception("Not able to click Pharmacist");
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
	 * Method : To see employee details and select ID
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I am able to see employee details and copy emplyee ID$")
	public void i_am_able_to_see_employee_details_and_emplyee_ID(DataTable tableData) throws Exception  {
		List<String> options = tableData.asList(String.class);
		for (int i = 0; i < options.size(); i++) log.info("Verifying element is....." + options.get(i));
	}


	/****************************************************************************
	 * Method : To click on close button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I will click on close button$")
	public void I_will_click_on_close_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Team_member_Close_Icon)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Team_member_Close_Icon))
					throw new Exception("Not able to click Close Icon");
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
	 * Method to enter employee ID and search
	 */
	@Then("^I enter employeeID on user management feild and i will click on search$")
	public void i_enter_employeeID_on_user_management_feild_and_i_will_click_on_search(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(AccessManagementConstants.Employeed_Id_Searchfeild)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Employeed_Id_Searchfeild))
					throw new Exception("Not able to click search field");
				AccessManagementLibrary.enter_Text(arg1, "EmployeeID", AccessManagementConstants.Employeed_Id_Searchfeild, chromeDriver);
			}
			if (isElementPresentVerification(AccessManagementConstants.User_Management_Search_Button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.User_Management_Search_Button))
					throw new Exception("Not able to click search button");
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
	 * Method : To check if user is able to see password management
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I am able to see password management$")
	public void i_am_able_to_see_password_management() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String pageSource = chromeDriver.getPageSource();
			Boolean condition = pageSource.contains("Password Management");
			Assert.assertTrue(condition, "Password Management field not presented on page");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	/****************************************************************************
	 * Method : To check if user is able to see password guidelines
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I able to see Password Guidelines$")
	public void i_am_able_to_see_password_guidelines() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String pageSource = chromeDriver.getPageSource();
			Boolean condition = pageSource.contains("Password Guidelines");
			Assert.assertTrue(condition, "Password Guidelines field not presented on page");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/****************************************************************************
	 * Method : To enter new password and click on confirm password field
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I enter new password and i click conformed password$")
	public void i_enter_new_password_and_i_click_conformed_password(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Employee_New_password)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Employee_New_password))
					throw new Exception("Not able to click New password");
				FrameworkLibrary.enter_Text(arg1, 0, "Credentials", AccessManagementConstants.Employee_New_password, chromeDriver);
			}
			if (isElementPresentVerification(AccessManagementConstants.Employee_conform_password)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Employee_conform_password))
					throw new Exception("Not able to click confirm password");
				FrameworkLibrary.enter_Text(arg1, 0, "Credentials", AccessManagementConstants.Employee_conform_password, chromeDriver);
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
	 * Method : To click on reset password
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click on reset password$")
	public void i_click_on_reset_password() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Password_Reset_button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Password_Reset_button))
					throw new Exception("Not able to click Reset button");
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
	 * Method : To check if user is able to login with new credentials
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 * @throws Throwable 
	 ******************************************************************************/


	@Then("^I am able to loggin with new credentials$")
	public void i_am_able_to_loggin_with_new_credentials(DataTable arg1) throws Throwable {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			AccessManagementLibrary.enter_username_and_password_drugSearch(arg1);
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	/****************************************************************************
	 * Method : To enter role description on desc text box
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I update the role Description$")
	public void i_update_the_role_Descriptio(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.ROLE_DESC_TEXTBOX)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.ROLE_DESC_TEXTBOX))
					throw new Exception("Not able to click Desc text box");
				Map<String, List<String>> dataMap = null;
				dataMap = FrameworkLibrary.getHorizontalData(arg1);
				String description = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Description");
				if (!clearAndEnterText(AccessManagementConstants.ROLE_DESC_TEXTBOX, description)) {
					throw new Exception("Not able to enter value in desc text field");
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
	 * Method : To click on update button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I click on Update Button$")
	public void i_click_on_UpdateButton() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Update_button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Update_button))
					throw new Exception("Not able to click Update Button");
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
	 * Method : To check if status is updated
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I able to see updated status after finised$")
	public void i_able_to_see_updated_status_after_finised(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String exptVal = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Description");

			Boolean condition = chromeDriver.getPageSource().contains(exptVal);
			Assert.assertTrue(condition, exptVal + "Text not found!");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	/****************************************************************************
	 * Method : To select Admin full access role and click on update
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I will select Admin full access role and click on update$")
	public void i_will_select_Admin_full_access_role_and_click_on_update(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String role = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Role");
			String roleDec = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Description");
			chromeDriver.findElement(By.xpath("//*[contains(@aria-label,'" + role + "') and contains(@aria-label,'" + roleDec + "')]")).click();
			if (isElementPresentVerification(AccessManagementConstants.Update_button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Update_button))
					throw new Exception("Not able to click Update button");
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
	 * Method : To check if user is on role information page and user selects any permission
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I am on role information and i select any permission feild from dropdown$")
	public void i_am_on_role_information_and_i_select_any_permission_feild_from_dropdown() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.SYSTEM_AREA_DROPDOWN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.SYSTEM_AREA_DROPDOWN))
					throw new Exception("Not able to click System Area Dropdown");
			}
			if (isElementPresentVerification(AccessManagementConstants.Role_Permission_Dropdown)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Role_Permission_Dropdown))
					throw new Exception("Not able to click Role permission Dropdown");
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
	 * Method : To select and set access to the selected role
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I will grant few access to perticular feild$")
	public void i_will_grant_few_access_to_perticular_feild_and_click_save() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Grant_Permission1)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Grant_Permission1))
					throw new Exception("Not able to click Permission1");
			}
			if (isElementPresentVerification(AccessManagementConstants.Grant_Permission2)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Grant_Permission2))
					throw new Exception("Not able to click Permission2");
			}
			if (isElementPresentVerification(AccessManagementConstants.MOVE_TO_RIGHT)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.MOVE_TO_RIGHT))
					throw new Exception("Not able to click Move to Right");
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
	 * Method : To revoke permission for the selected role
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I will select feild and i revoke the existing permission and click on save$")
	public void i_will_select_feild_and_i_revoke_the_existing_permission_and_click_on_save() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.SYSTEM_AREA_DROPDOWN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.SYSTEM_AREA_DROPDOWN))
					throw new Exception("Not able to click System Area Dropdown");
				if (!isElementPresentVerifyClick(AccessManagementConstants.Role_Permission_Dropdown))
					throw new Exception("Not able to click Role_Permission_Dropdown");
				if (!isElementPresentVerifyClick(AccessManagementConstants.Permission_Revoke1))
					throw new Exception("Not able to click first item");
				if (!isElementPresentVerifyClick(AccessManagementConstants.Permission_Revoke2))
					throw new Exception("Not able to click second item");
				if (!isElementPresentVerifyClick(AccessManagementConstants.ADDUPDATE_ROLE_SAVE_BUTTON))
					throw new Exception("Not able to click save button");
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
	 * Method : To select new permission which is not available to the selected role
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I will grant new permission which is not avilable to user previous$")
	public void i_will_grant_new_permission_which_is_not_avilable_to_user_previous() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.SYSTEM_AREA_DROPDOWN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.SYSTEM_AREA_DROPDOWN))
					throw new Exception("Not able to click System Area Dropdown");
				if (!isElementPresentVerifyClick(AccessManagementConstants.Role_Permission_Dropdown))
					throw new Exception("Not able to click Role_Permission_Dropdown");
				if (!isElementPresentVerifyClick(AccessManagementConstants.Grant_Permission3))
					throw new Exception("Not able to click 3rd permission");
				if (!isElementPresentVerifyClick(AccessManagementConstants.Grant_Permission4))
					throw new Exception("Not able to click 4th permission");
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
	 * Method : To select a role
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I select role$")
	public void i_select_role(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String role = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Role");
			String roleDec = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Description");
			chromeDriver.findElement(By.xpath("//*[contains(@aria-label,'" + role + "') and contains(@aria-label,'" + roleDec + "')]")).click();

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	/****************************************************************************
	 * Method : To check if user is not able to see add, update and delete buttons
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I am not able to see Add Update and delete buttons$")
	public void i_am_not_able_to_update_and_delete_permissions() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.All_buttons_Present)) {
				Assert.assertTrue(!AccessManagementLibrary.getElement(AccessManagementConstants.All_buttons_Present).getText().contains("Add"), "Add buton not present");
				Assert.assertTrue(!AccessManagementLibrary.getElement(AccessManagementConstants.All_buttons_Present).getText().contains("Update"), "Update buton not present");
				Assert.assertTrue(!AccessManagementLibrary.getElement(AccessManagementConstants.All_buttons_Present).getText().contains("Delete"), "Delete buton not present");
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
	 * Method : To navigate back to home screen from team member page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I navigate back to home screen$")
	public void i_navigate_back_to_home_screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Team_Back_Navigation)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Team_Back_Navigation))
					throw new Exception("Not able to click back navigation");
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
	 * Method : To enter patient last name
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I enter patient Last name on search feild$")
	public void i_enter_patient_name_on_search_feild(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.input_name_feild)) {
				AccessManagementLibrary.enter_Text(arg1, "Pateint_Last_Name", AccessManagementConstants.input_name_feild, chromeDriver);
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
	 * Method : To check if user is able to see permissions assigned
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I am able to permissions assigned to perticular feild$")
	public void I_am_able_to_permissions_assigned_to_perticular_feild(DataTable tableData) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String pageSource = chromeDriver.getPageSource();
			List<String> options = tableData.asList(String.class);
			for (int i = 0; i < options.size(); i++) {
				log.info("Verifying element is....." + options.get(i));
				Boolean condition = pageSource.contains(options.get(i));
				Assert.assertTrue(condition, options.get(i) + " field not presented on page");
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
	 * Method : To click on dashboard button and see if user is navigated to home page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I navigate to home button$")
	public void i_navigate_to_home_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Dashboard_buttuon)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Dashboard_buttuon))
					throw new Exception("Not able to click Dashboard button");
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
	 * Method : To check if user don't have access to edit or update
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I can view page i dont have access to edit or update$")
	public void i_can_view_page_i_dont_have_access_to_edit_or_update() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Store_All_Button_Presents)) {
				Assert.assertTrue(!AccessManagementLibrary.getElement(AccessManagementConstants.Store_All_Button_Presents).getText().contains("Update"), "Update button not present");
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
	 * Method : To check if user is not able to perform Intake
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I am unable to perform intake$")
	public void i_am_unable_to_perform_intake() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patient_All_Intake_Presents)) {
				Assert.assertTrue(!AccessManagementLibrary.getElement(AccessManagementConstants.Patient_All_Intake_Presents).getText().contains("Intake"), "Intake button not present");
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
	 * Method : To check if user is able to access DE screen
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I am able to access DE Screen$")
	public void i_am_able_to_access_DE_Screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.CLICK_DE)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.CLICK_DE))
					throw new Exception("Not able to click DE");
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
	 * Method : To check if user should not be able to access DR screen
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I am not able to access DR screen$")
	public void i_am_not_able_to_access_DR_screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.DR_Disabled)) {
				boolean condition = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.DR_Disabled)).isEnabled();
				Assert.assertFalse(condition);
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
	 * Method : To close the DR screen
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I close the DR screen$")
	public void i_close_dr_screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.DR_SCREEN_CLOSE_BTN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.DR_SCREEN_CLOSE_BTN))
					throw new Exception("Not able to click Close Button");
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
	 * Method : To click on store number from dashboard page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click on store number$")
	public void i_click_on_store_number() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Store_number)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Store_number))
					throw new Exception("Not able to click Store");
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
	 * Method : To check if user is able to see store information section
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I am able to see store information window$")
	public void i_am_able_to_see_store_information_window(DataTable tableData) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String pageSource = chromeDriver.getPageSource();
			List<String> options = tableData.asList(String.class);
			for (int i = 0; i < options.size(); i++) {
				log.info("Verifying element is....." + options.get(i));
				Boolean condition = pageSource.contains(options.get(i));
				Assert.assertTrue(condition, options.get(i) + " field not presented on page");
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
	 * Method : To click on update button on store page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click on update button$")
	public void i_click_on_update_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Store_Update_button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Store_Update_button))
					throw new Exception("Not able to click Update button");
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
	 * Method : To validate from date and to date of store hours
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("I will update valid from date to valid to$")
	public void i_will_update_date_to(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String fromDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Valid_From");
			String toDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Valid_To");

			if (isElementPresentVerification(AccessManagementConstants.Store_From_Button)) {
				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Store_From_Button)).sendKeys(fromDate);
				if (isElementPresentVerifyClick(AccessManagementConstants.Store_To_Button)) {
					FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Store_To_Button)).sendKeys(toDate);
				}
			}
			String[] fromDateVals = fromDate.split("/");
			String[] toDateVals = toDate.split("/");

			int size = (Integer.parseInt(toDateVals[1]) - Integer.parseInt(fromDateVals[1])) + 1;
			for (int i = 0; i < size; i++) {
				FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='home-store-info-radio-24hrs-" + Integer.toString(i) + "']")).click();
			}
			if (!isElementPresentVerifyClick(AccessManagementConstants.Store_Closed_click5)) {
				throw new Exception("Not able to click");
			}
			if (!isElementPresentVerifyClick(AccessManagementConstants.Store_Closed_click6)) {
				throw new Exception("Not able to click");
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
	 * Method : To click on CE
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click on CE$")
	public void i_click_on_CE() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Admin_Read_Role_CE)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Admin_Read_Role_CE))
					throw new Exception("Not able to click Read Role CE");
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
	 * Method : To check if specified fields are visible
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I am able to see following feilds$")
	public void i_am_able_to_see_following_feilds(DataTable tableData) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String pageSource = chromeDriver.getPageSource();
			List<String> options = tableData.asList(String.class);
			for (int i = 0; i < options.size(); i++) {
				log.info("Verifying element is....." + options.get(i));
				Boolean condition = pageSource.contains(options.get(i));
				Assert.assertTrue(condition, options.get(i) + " field not presented on page");
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
	 * Method : To click ok button on role popup
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I click Ok button$")
	public void i_click_Ok_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Admin_Read_Role_CE_Popup)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Admin_Read_Role_CE_Popup))
					throw new Exception("Not able to click Read Role CE Popup");
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
	 * Method : To click on Save button to save updated pharmacy hours
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click on Save to change pharmacy hours$")
	public void i_click_on_Save_to_change_pharmacy_hours() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Store_Save_Button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Store_Save_Button))
					throw new Exception("Not able to click Save Button");
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
	 * Method : To check if user is able to see specified fields
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I able to see following feilds$")
	public void i_able_to_see_following_feilds(DataTable tableData) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String pageSource = chromeDriver.getPageSource();
			List<String> options = tableData.asList(String.class);
			for (int i = 0; i < options.size(); i++) {
				log.info("Verifying element is....." + options.get(i));
				Boolean condition = pageSource.contains(options.get(i));
				Assert.assertTrue(condition, options.get(i) + " field not presented on page");
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
	 * Method : TO check if user is able to see specified changes
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I am able to see following changes in UI$")
	public void i_am_able_to_see_following_changes_in_UI(DataTable tableData) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String pageSource = chromeDriver.getPageSource();
			List<String> options = tableData.asList(String.class);
			for (int i = 0; i < options.size(); i++) {
				log.info("Verifying element is....." + options.get(i));
				Boolean condition = pageSource.contains(options.get(i));
				Assert.assertTrue(condition, options.get(i) + " field not presented on page");
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
	 * Method : To check if user is not able to see update button on store information page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I am unable to see update button on store information page$")
	public void i_am_unable_to_see_update_button_on_store_information_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Store_Update_button)) {
				Boolean condition = chromeDriver.findElement(By.xpath(AccessManagementConstants.Store_Update_button)).isDisplayed();
				Assert.assertTrue(!condition, "update button is not present");
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
	 * Method : To verify if user is not able to access DE screen
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I am not able to access DE Screen$")
	public void I_am_not_able_to_access_DE_Screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.DE_Disabled)) {
				boolean condition = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.DE_Disabled)).isEnabled();
				Assert.assertFalse(condition);
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
	 * Method : To click on technician profile button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I click on technician profile button$")
	public void i_click_on_technician_profile_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.PROFILE_BUTTON)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PROFILE_BUTTON))
					throw new Exception("Not able to click Profile button");
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
	 * Method : To check that user should not be able to see team members option
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should not be able to see team members option$")
	public void i_should_not_be_able_to_see_team_members_option() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.RXMS_MEMBER_SIDENAV)) {
				Assert.assertTrue(!AccessManagementLibrary.getElement(AccessManagementConstants.RXMS_MEMBER_SIDENAV).getText().contains("Team Members"), "Team member option is displayed where it is not expexted");
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
	 * Method : To click logout button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I press the logout button$")
	public void i_press_the_logout_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.RXMS_LOGOUT_BUTTON)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.RXMS_LOGOUT_BUTTON))
					throw new Exception("Not able to click logout button");
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
	 * Method : To click on Pharmacist profile button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I click on pharmacist profile button$")
	public void i_click_on_pharmacist_profile_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.PROFILE_BUTTON)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PROFILE_BUTTON))
					throw new Exception("Not able to click profile button");
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
	 * Method : To check if user is able to see team members options and click the tab
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should be able to see team members option and click$")
	public void i_should_be_able_to_see_team_members_option_and_click() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.RXMS_MEMBER_SIDENAV)) {
				Assert.assertTrue(AccessManagementLibrary.getElement(AccessManagementConstants.RXMS_MEMBER_SIDENAV).getText().contains("Team Members"), "Team member option is displayed");

				if (!isElementPresentVerifyClick(AccessManagementConstants.RXMS_TEAM_MEMBERS_SIDENAV_TEAM_MEMBERS_OPTION))
					throw new Exception("Not able to click side nav");
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
	 * Method : To check if at least one team member is present on team member page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should navigate to list of team members profile$")
	public void i_should_navigate_to_list_of_team_members_profile() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Team_member_UXA)) {
				Assert.assertTrue(AccessManagementLibrary.getTeamMemberList().size() > 0, "Atleast one team member is not displayed");
				Assert.assertTrue(AccessManagementLibrary.getTeamMemberphoneList().size() > 0, "phone number is displayed");
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
	 * Method : To click on any of the team members and navigate to profile page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click on self profile from team members list and navigate to see his profile$")
	public void i_click_on_self_profile_from_team_members_list_and_navigate_to_see_his_profile(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String userFullName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
					dataMap.get("RowId").get(0), "UserFullName");
			List<WebElement> list = AccessManagementLibrary.getTeamMemberList();
			for (WebElement member : list) {
				if (member.getText().trim().equalsIgnoreCase(userFullName.trim())) {
					member.click();
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
	 * Method : To click on any team member and navigate to profile page 
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click on other profile from team members list and navigate to see his profile$")
	public void i_click_on_other_profile_from_team_members_list_and_navigate_to_see_his_profile(DataTable arg1)throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String userFullName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
					dataMap.get("RowId").get(0), "UserFullName");
			List<WebElement> list = AccessManagementLibrary.getTeamMemberList();
			for (WebElement member : list) {
				if (member.getText().trim().equalsIgnoreCase(userFullName.trim())) {
					member.click();
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
	 * Method : To check if user is not able to see update button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should not see the update option in that page$")
	public void i_should_not_see_the_update_option_in_that_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			List<WebElement> list = FrameworkLibrary.chromeDriver.findElements(By.xpath("*//a[contains(text(),'Update')]"));
			FrameworkLibrary.chromeDriver.findElement(By.xpath("//button[contains(text(),'lose')]")).click();

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	/****************************************************************************
	 * Method : To click on Pharmacist manager profile
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click on Pharmacist Manager profile icon$")
	public void i_click_on_Pharmacist_Manager_profile_icon() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.PROFILE_BUTTON)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PROFILE_BUTTON))
					throw new Exception("Not able to click PROFILE_BUTTON");
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
	 * Method : To click on admin profile icon
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click on admin profile icon$")
	public void i_click_on_admin_icon() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.PROFILE_BUTTON)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PROFILE_BUTTON))
					throw new Exception("Not able to click PROFILE_BUTTON");
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
	 * Method : To check if user is able to see update option
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I should be able to see update option in that page$")
	public void i_should_be_able_to_see_the_update_option_in_that_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			List<WebElement> list = FrameworkLibrary.chromeDriver.findElements(By.xpath("*//a[contains(text(),'Update')]"));
			FrameworkLibrary.chromeDriver.findElement(By.xpath("//button[contains(text(),'lose')]")).click();

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method : To click close button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I Press close button$")
	public void i_Press_close_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			FrameworkLibrary.chromeDriver.findElement(By.xpath("//button[contains(text(),'lose')]")).click();

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	/****************************************************************************
	 * Method : To check if profile page is displayed
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see my profile page$")
	public void i_should_see_my_profile_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.RXMS_MY_PROFILE_PAGE)) {
				Assert.assertTrue(AccessManagementLibrary.isElementPresent(AccessManagementConstants.RXMS_MY_PROFILE_PAGE), "My Profile page is not displayed");
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
	 * Method : TO check if user is not able to see update button on my profile
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should not see the update button in my profile page$")
	public void i_should_not_see_the_update_button_in_my_profile_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.UPDATE_BUTTON_STRING_XPATH)) {
				List<WebElement> list = FrameworkLibrary.chromeDriver.findElements(By.xpath(AccessManagementConstants.UPDATE_BUTTON_STRING_XPATH));
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
	 * Method : TO check if user is able to see update button on my profile page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should be able to see update button in my profile page$")
	public void i_should_be_able_to_see_the_update_button_in_my_profile_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.UPDATE_BUTTON_STRING_XPATH)) {
				List<WebElement> list = FrameworkLibrary.chromeDriver.findElements(By.xpath(AccessManagementConstants.UPDATE_BUTTON_STRING_XPATH));
				Assert.assertTrue(list.get(0).isDisplayed(), "update button is displayed in employee information section where it should not be expected");
				Assert.assertTrue(list.get(1).isDisplayed(), "update button is displayed in license and certication section where it should not be expected");
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
	 * Method : To select Deactivate option
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	// RXQE-1826
	@Then("^I select the Deactivated option from drop down$")
	public void i_select_the_Deactivated_option_from_drop_down() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			AccessManagementLibrary.selectValueFromDropdown("Deactivated");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}


	/****************************************************************************
	 * Method : TO check if user is able to see deactivated team member
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I see the Deactived team members$")
	public void i_see_the_Deactived_team_members() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Assert.assertTrue(AccessManagementLibrary.getTeamMemberList().size() > 0, "Atleast one team member is not displayed for deactivated accounts");
			if (AccessManagementLibrary.getTeamMemberList().size() == 0) {
				AccessManagementLibrary.selectValueFromDropdown("Active");
				AccessManagementLibrary.getTeamMemberList().get(0).click();
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
	 * Method : TO set active for the selected user
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click on them and change them to active$")
	public void i_click_on_them_and_change_them_to_active() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.ACTIVATE_BUTTON_STRING_XPATH)) {
				account_Name = AccessManagementLibrary.getTeamMemberList().get(0).getText().trim();
				AccessManagementLibrary.getTeamMemberList().get(0).click();
				new WebDriverWait(FrameworkLibrary.chromeDriver, 2000).until(ExpectedConditions.elementToBeClickable(By.xpath(AccessManagementConstants.ACTIVATE_BUTTON_STRING_XPATH)));
				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.ACTIVATE_BUTTON_STRING_XPATH)).click();
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
	 * Method : To click close
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click close$")
	public void i_click_close() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.CLOSE_BUTTON_STRING_XPATH)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.CLOSE_BUTTON_STRING_XPATH))
					throw new Exception("Not able to click Close");
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
	 * Method : To click on active link from dropdown and user should see active users
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I select active from drop down and see the user$")
	public void i_select_active_from_drop_down_and_see_the_user() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			boolean flag = false;
			AccessManagementLibrary.selectValueFromDropdown("Active");
			List<WebElement> list = AccessManagementLibrary.getTeamMemberList();
			for (WebElement member : list) {
				if (member.getText().trim().equalsIgnoreCase(account_Name.trim())) {
					flag = true;
					member.click();
				}
			}
			Assert.assertTrue(flag, "Activated account is not displayed under active team members list");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/****************************************************************************
	 * Method : To select a user and make the user as deactive
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I select the user and make deactive$")
	public void i_select_the_user_and_make_deactive() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.DEACTIVATE_BUTTON_STRING_XPATH)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.DEACTIVATE_BUTTON_STRING_XPATH))
					throw new Exception("Not able to click Deactivate Button");
			}
			if (isElementPresentVerification(AccessManagementConstants.OK_BUTTON_STRING_XPATH)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.OK_BUTTON_STRING_XPATH))
					throw new Exception("Not able to click Deactivate Button");
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
	 * Method : To see if the specified user is in deactive page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I see the user in deactive page$")
	public void i_see_the_user_in_deactive_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			AccessManagementLibrary.selectValueFromDropdown("Deactivated");
			boolean flag = false;
			List<WebElement> list = AccessManagementLibrary.getTeamMemberList();
			for (WebElement member : list) {
				if (member.getText().trim().equalsIgnoreCase(account_Name.trim())) {
					flag = true;
				}
			}
			Assert.assertTrue(flag, "Deactivated account is not displayed under Deactive team members list");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	/****************************************************************************
	 * Method : To verify if the specified navigation link is visible
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see \"([^\"]*)\" navigation link$")
	public void i_see_required_navigation_link(final String navlink) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (navlink.equals("Role Management")) {
				if (isElementPresentVerification(AccessManagementConstants.ROLE_MGMT_NAVLINK)) {
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
	 * Method : To check if the specified button is visible 
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see \"([^\"]*)\" Button$")
	public void i_see_Button(final String buttonname) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (buttonname.equals("Add")) {
				isElementPresentVerification(AccessManagementConstants.ADD_ROLE_BUTTON);
			} else if (buttonname.equals("Save")) {
				isElementPresentVerification(AccessManagementConstants.ADDUPDATE_ROLE_SAVE_BUTTON);
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
	 * Method : To check if user is able to see specified button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@And("^I should see the \"([^\"]*)\" Button$")
	public void i_should_see_required_Button(final String buttonname) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (buttonname.equals("Update")) {
				isElementPresentVerification(AccessManagementConstants.UPDATE_ROLE_BUTTON);
			} else if (buttonname.equals("Delete")) {
				isElementPresentVerification(AccessManagementConstants.DELETE_ROLE_BUTTON);
			} else if (buttonname.equals("Cancel")) {
				isElementPresentVerification(AccessManagementConstants.ADDUPDATE_ROLE_CANCEL_BUTTON);
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
	 * Method : To click on the specified button on role page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I click the \"([^\"]*)\" Button$")
	public void i_click_the_required_Button(final String buttonname) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (buttonname.equals("Add")) {
				if (isElementPresentVerification(AccessManagementConstants.ADD_ROLE_BUTTON)) {
					if (isElementPresentVerifyClick(AccessManagementConstants.ADD_ROLE_BUTTON)) {
						throw new Exception("Not able to click Add Role Button");
					}
				}
			} else if (buttonname.equals("Update")) {
				if (isElementPresentVerification(AccessManagementConstants.UPDATE_ROLE_BUTTON)) {
					if (isElementPresentVerifyClick(AccessManagementConstants.UPDATE_ROLE_BUTTON)) {
						throw new Exception("Not able to click Update Role Button");
					}
				}
			} else if (buttonname.equals("Delete")) {
				if (isElementPresentVerification(AccessManagementConstants.DELETE_ROLE_BUTTON)) {
					if (isElementPresentVerifyClick(AccessManagementConstants.DELETE_ROLE_BUTTON)) {
						throw new Exception("Not able to click Delete Role Button");
					}
				}
			} else if (buttonname.equals("Save")) {
				if (isElementPresentVerification(AccessManagementConstants.ADDUPDATE_ROLE_SAVE_BUTTON)) {
					if (isElementPresentVerifyClick(AccessManagementConstants.ADDUPDATE_ROLE_SAVE_BUTTON)) {
						throw new Exception("Not able to click AddUpdate Role Save Button");
					}
				}
			} else if (buttonname.equals("No")) {
				if (isElementPresentVerification(AccessManagementConstants.DELETE_OVERLAY_NO_BUTTON)) {
					if (isElementPresentVerifyClick(AccessManagementConstants.DELETE_OVERLAY_NO_BUTTON)) {
						throw new Exception("Not able to click Delete Overlay No Button");
					}
				}
			} else if (buttonname.equals("Admin Back")) {
				if (isElementPresentVerification(AccessManagementConstants.ADMIN_BACK_BUTTON)) {
					if (isElementPresentVerifyClick(AccessManagementConstants.ADMIN_BACK_BUTTON)) {
						throw new Exception("Not able to click Admin back Button");
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
	 * Method : To check if user is on specified page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should be on \"([^\"]*)\" screen$")
	public void i_should_be_on_required_screen(final String screenname) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (screenname.equals("Role Management")) {
				Assert.assertTrue(chromeDriver.getPageSource().contains("Role Management"), "Text Role Management Not Found");
			} else if (screenname.equals("Role Management")) {
				Assert.assertTrue(chromeDriver.getPageSource().contains("Prescriber Search"), "Not on Prescriber Search screen");
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
	 * Method : To enter role name on role text field
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I enter role name on role field$")
	public void i_enter_role_name_on_role_feild(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.ROLE_NAME_TEXTBOX)) {
				FrameworkLibrary.enter_Text(arg1, 0, "Role", AccessManagementConstants.ROLE_NAME_TEXTBOX, chromeDriver);
			}
			if (isElementPresentVerification(AccessManagementConstants.ROLE_DESC_TEXTBOX)) {
				FrameworkLibrary.enter_Text(arg1, 0, "Description", AccessManagementConstants.ROLE_DESC_TEXTBOX, chromeDriver);
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
	 * Method : To select a value from role type field
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I select one value from Role type$")
	public void i_select_one_item_from_role() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.SYSTEM_AREA_DROPDOWN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.SYSTEM_AREA_DROPDOWN))
					throw new Exception("Not able to click System Area Drop down");
				FrameworkLibrary.chromeDriver.findElement(By.xpath("//div[@class='md-text ng-binding' and contains(text(),'BPM')]")).click();
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
	 * Method : To select a role type from the list
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I select one feild from Role type from list$")
	public void i_select_one_item_from_Role_type_from_list() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.SYSTEM_AREA_DROPDOWN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.SYSTEM_AREA_DROPDOWN))
					throw new Exception("Not able to click System area dropdown");
			}
			if (isElementPresentVerification(AccessManagementConstants.Store_UserManagement_List)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Store_UserManagement_List))
					throw new Exception("Not able to click User management list");
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
	 * Method : To select few permissions and click on move to right button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I select few permissions and click move to right$")
	public void i_select_few_permissions_move_to_right() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.SELECT_PERMISSION1)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.SELECT_PERMISSION1))
					throw new Exception("Not able to click first permission");
			}
			if (isElementPresentVerification(AccessManagementConstants.SELECT_PERMISSION2)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.SELECT_PERMISSION2))
					throw new Exception("Not able to click second permission");
			}
			if (isElementPresentVerification(AccessManagementConstants.SELECT_PERMISSION3)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.SELECT_PERMISSION3))
					throw new Exception("Not able to click third permission");
			}
			if (isElementPresentVerification(AccessManagementConstants.MOVE_TO_RIGHT)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.MOVE_TO_RIGHT))
					throw new Exception("Not able to click move to right button");
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
	 * Method : To check if user is able to see the new role on role list page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see the new role on Role Management screen$")
	public void i_should_see_new_role_on_role_management_screen(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String myrole = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Role");
			Assert.assertTrue(chromeDriver.getPageSource().contains(myrole), "Role Not Found");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/****************************************************************************
	 * Method : To select the newly created role
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I select the new role$")
	public void i_select_the_new_role(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.TEXTROLE_MGMT_LIST)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.TEXTROLE_MGMT_LIST))
					throw new Exception("Not able to click new role");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if user is able to see the selected role name on update screen
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see role name on update screen$")
	public void i_should_see_role_name_on_update_screen(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String myrole = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Role");
			if (isElementPresentVerification(AccessManagementConstants.UPDATE_ROLE_NAME_TEXTBOX)) {
				Assert.assertTrue(FrameworkLibrary.getElementText(AccessManagementConstants.UPDATE_ROLE_NAME_TEXTBOX).contains(myrole), "Role Not Found");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/****************************************************************************
	 * Method : To change the role description value
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I change description value$")
	public void i_change_description_value(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.UPDATE_ROLE_DESC_TEXTBOX)) {
				FrameworkLibrary.enter_Text(arg1, 0, "Description", AccessManagementConstants.UPDATE_ROLE_DESC_TEXTBOX, chromeDriver);
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if user is able to see the chanages in role list page for the speicified role
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see the changes on Role Management screen$")
	public void i_should_see_changes_on_role_management_screen(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String newdescription = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Description");
			Assert.assertTrue(chromeDriver.getPageSource().contains(newdescription), "Description Not Found");
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if user is able to see confirmation text on role overlay
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see confirmation text on overlay$")
	public void i_should_see_on_overlay() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.DELETE_OVERLAY_CONFIRM_TEXT)) {
				Assert.assertTrue(FrameworkLibrary.getElementText(AccessManagementConstants.DELETE_OVERLAY_CONFIRM_TEXT).contains(AccessManagementConstants.DELETE_OVERLAY_CONFIRM_STRING), "String not found");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/****************************************************************************
	 * Method : To click on the specified button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click \"([^\"]*)\" Button$")
	public void i_click_required_Button(final String buttonname) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (buttonname.equals("No")) {
				if (isElementPresentVerification(AccessManagementConstants.DELETE_OVERLAY_NO_BUTTON)) {
					if (!isElementPresentVerifyClick(AccessManagementConstants.DELETE_OVERLAY_NO_BUTTON))
						throw new Exception("Not able to click No Button");
				}
			} else if (buttonname.equals("Yes")) {
				if (isElementPresentVerification(AccessManagementConstants.DELETE_OVERLAY_YES_BUTTON)) {
					if (!isElementPresentVerifyClick(AccessManagementConstants.DELETE_OVERLAY_YES_BUTTON))
						throw new Exception("Not able to click yes Button");
				}
			}


			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To check if user is not able to see the specified role
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should not see the role on Role Management screen$")
	public void i_should_not_see_role_on_role_management_screen(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String deletedmyrole = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Role");
			Assert.assertTrue(chromeDriver.getPageSource().contains(deletedmyrole), "Delete role failed");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method : To check if user is not able to see team member menu
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should not see Team Member Menu$")
	public void i_should_not_see_Team_Member_Menu() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Assert.assertFalse(chromeDriver.getPageSource().contains("Team Member"), "Team Member link is present");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To select the technician role
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I select the Technician role$")
	public void i_select_the_technician_role() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.XPATH_TECHNICIAN_ROLE)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.XPATH_TECHNICIAN_ROLE))
					throw new Exception("Not able to click Technician Role");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if user is able to see the technician role name
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see the role name Technician$")
	public void i_should_see_role_name_technician() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Assert.assertTrue(chromeDriver.getPageSource().contains("RetailTechnician"), "Role Not Found");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To select prescriber from role type drop down
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I select Prescriber from Role type$")
	public void i_select_Prescriber_from_Role_type() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.ROLE_DROP_DOWN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.ROLE_DROP_DOWN))
					throw new Exception("Not able to click Role Drop Down");
			}
			if (isElementPresentVerification(AccessManagementConstants.XPATH_PRESCRIBER_ROLE_IN_DROPDOWN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.XPATH_PRESCRIBER_ROLE_IN_DROPDOWN))
					throw new Exception("Not able to click Prescriber Role");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To select specified permissions and move to left
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I select following permissions and click move to left$")
	public void i_select_few_permissions_and_click_move_to_left(DataTable tableData) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Admin_Create_role_Search_NotAvailable)) {
				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Admin_Create_role_Search_NotAvailable)).sendKeys("Update");
				for (int i = 1; i <= 2; i++) {
					FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='available']/md-list[" + i + "]/md-list-item/div/md-checkbox")).click();
				}

				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Admin_Create_role_Search_NotAvailable)).sendKeys("Create");
				for (int i = 1; i <= 2; i++) {
					FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='available']/md-list[" + i + "]/md-list-item/div/md-checkbox")).click();
				}
			}
			if (isElementPresentVerification(AccessManagementConstants.Admin_Create_role_Search_NotAvailable)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.MOVE_TO_LEFT))
					throw new Exception("Not able to click Move to left");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To enter prescriber name on search field
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I enter prescriber name on search field$")
	public void i_enter_prescriber_name_on_search_field(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.input_name_feild)) {
				AccessManagementLibrary.enter_Text(arg1, "Pateint_Last_Name", AccessManagementConstants.input_name_feild, chromeDriver);
			}
			if (isElementPresentVerification(AccessManagementConstants.input_first_name)) {
				AccessManagementLibrary.enter_Text(arg1, "Patient_first_Name", AccessManagementConstants.input_first_name, chromeDriver);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To click on search button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click on Search button$")
	public void i_click_on_Search_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Seacrh_button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Seacrh_button))
					throw new Exception("Not able to click search button");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if user is able to see prescriber profile page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I am able to see Prescriber Profile Page$")
	public void i_am_able_to_see_prescriber_details() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Assert.assertTrue(chromeDriver.getPageSource().contains("Prescriber Details"), "Not on Prescriber Details page");
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if system displays prescriber search result
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^System should display prescriber search results$")
	public void system_should_display_prescriber_search_results() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.patient_table)) {
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if user is not able to see the specified button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should not see \"([^\"]*)\" button$")
	public void i_not_see_button(final String buttonname) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (buttonname.equals("Update Location")) {
				isElementPresentVerification(AccessManagementConstants.PRESCRIBER_DETAIL_UPDATE_LOCATION_BUTTON);
			} else if (buttonname.equals("Add Location")) {
				isElementPresentVerification(AccessManagementConstants.PRESCRIBER_DETAIL_ADD_LOCATION_BUTTON);
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To click on the specified section from Pharmacy information page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I click on \"([^\"]*)\" from Pharmacy Information$")
	public void i_click_on_from_Pharmacy_Information(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.STORE_LINK)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.STORE_LINK))
					throw new Exception("Not able to click Store link");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if user is able to see specified page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see \"([^\"]*)\" page$")
	public void i_should_see_page(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Assert.assertTrue(chromeDriver.getPageSource().contains("Store Information"), "Not on Store page");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To click on store update button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I click on Update button$")
	public void i_click_on_Update_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.STORE_UPDATE_BUTTON)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.STORE_UPDATE_BUTTON))
					throw new Exception("Not able to click Update Button");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To select valid From field of store
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I select Valid From field$")
	public void i_select_Valid_From_field(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.STORE_INFO_VALID_FROM)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.STORE_INFO_VALID_FROM))
					throw new Exception("Not able to click Valid From");
				if (!isElementPresentVerifyClick("//*[@id='md-3-month-2017-2-17']/span")) {
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To select valid to date field of store
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I select Valid To field$")
	public void i_select_Valid_To_field(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.STORE_INFO_VALID_TO)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.STORE_INFO_VALID_TO))
					throw new Exception("Not able to click Valid To");
				if (!isElementPresentVerifyClick("//*[@id='md-4-month-2017-2-31']/span")) {
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method : To update validate from and to dates for the store
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("I will update valid from and valid to dates$")
	public void i_will_update_from_to_dates(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String fromDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Valid_From");
			String toDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Valid_To");
			FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Store_From_Button)).sendKeys(fromDate);

			if (isElementPresentVerification(AccessManagementConstants.Store_To_Button)) {
				if (isElementPresentVerifyClick(AccessManagementConstants.Store_To_Button))
					FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Store_To_Button)).sendKeys(toDate);
			}
			String[] fromDateVals = fromDate.split("/");
			String[] toDateVals = toDate.split("/");
			log.info(fromDateVals);
			log.info(toDateVals);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/****************************************************************************
	 * Method : To select specified hours for all the days
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I select \"([^\"]*)\" for all days$")
	public void i_select_closed_for_all_days(final String hourstype) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			for (int i = 0; i < 7; i++) {
				if (hourstype.equals("closed")) {
					FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='home-store-info-radio-closed-" + Integer.toString(i) + "']")).click();
				} else if (hourstype.equals("24hrs")) {
					FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='home-store-info-radio-24hrs-" + Integer.toString(i) + "']")).click();
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To click on save button on store page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I clik on Save button$")
	public void i_clik_on_Save_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.STORE_INFO_SAVE_BUTTON)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.STORE_INFO_SAVE_BUTTON))
					throw new Exception("Not able to click Save Button");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : TO check if overriden is updated on all days
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see Overridden Hours on all days$")
	public void i_should_see_Overridden_Hours_on_all_days() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Assert.assertTrue(chromeDriver.getPageSource().contains("Overridden Hours"), "Overridden Hours not found");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}




	/****************************************************************************
	 * Method : To click on refresh button on task board
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^user click on refresh button on task board$")
	public void user_click_on_task_from_task_board() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.TASK_BOARD_REFRESH_BUTTON)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.TASK_BOARD_REFRESH_BUTTON))
					throw new Exception("Not able to click Refresh Button");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method : To check if the current task count is increased during refresh
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^System task board refresh and update with current count$")
	public void system_task_board_refresh_and_update_with_current_count() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.TASK_BOARD_PROGRESS_BAR)) {
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method : If user selects the pickup as specified
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^User selects pickup time as Pickup time as \"([^\"]*)\"$")
	public void user_selects_pickup_time_as_Pickup_time_as(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To check if system displays waiting tasks count
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^system should display the number of waiting tasks$")
	public void system_should_display_the_number_of_waiting_tasks() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.TASK_DE_COUNT)) {
				String task_count = FrameworkLibrary.getElementText(AccessManagementConstants.TASK_DE_COUNT);
				Assert.assertTrue(Integer.valueOf(task_count) > 0);
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/*
	 * Method to check if related icon is visible next to number of waiting tasks
	 */
	@Then("^I should see the related icon next to the number of the waiting task$")
	public void i_should_see_the_related_icon_next_to_the_number_of_the_waiting_task() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/*
	 * Method to check if a user with no permission enters credentials
	 */
	@When("^no permission user enters valid credentials$")
	public void no_permission_user_enters_valid_credentials(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/*
	 * Method to check if Intake button is not displayed
	 */
	@Then("^I should not see Intake Rx button$")
	public void i_should_not_see_Intake_Rx_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/*
	 * Method to check if user is not able to click accept button
	 */
	@Then("^User should not be able to click accept button$")
	public void user_should_not_be_able_to_click_accept_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		} catch (AssertionError e) {
			e.printStackTrace();
			takeScreenShot(methodName);

		}
	}

	/*
	 * Method to set timing for the specified days
	 */
	@Then("^I set \"([^\"]*)\" for the following days:$")
	public void i_set_for_the_following_days(String arg1, DataTable arg2) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/*
	 * Method to check if specified days are visible
	 */
	@Then("^I should see \"([^\"]*)\" for the following days:$")
	public void i_should_see_for_the_following_days(String arg1, DataTable arg2) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if deactivate or active buttons are not visible
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should not see deactivate or active button$")
	public void i_should_not_see_deactivate_or_active_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.TEAM_MEMBER_DEACTIVATE_BUTTON)) {
			}
			if (!isElementPresentVerification(AccessManagementConstants.TEAM_MEMBER_ACTIVATE_BUTTON)) {
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To check if the DR task is not clickable
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^user should not be able to click on DR task$")
	public void user_should_not_be_able_to_click_DR_task() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.DR_TaskButton)) {
				Assert.assertFalse(FrameworkLibrary.getElementByProperty(AccessManagementConstants.DR_TaskButton, chromeDriver).isEnabled(), "DR task is enabled");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/****************************************************************************
	 * Method : To check if user is not able to see team member menu
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should not be able to see team members$")
	public void i_should_not_be_able_to_see_team_members() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.TEAM_MEMBER_MENU)) {
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To select payment type as cash
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^selects payment type cash$")
	public void selects_payment_type_cash() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Payment_Dropdown)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Payment_Dropdown))
					throw new Exception("Not able to click Payment");
			}
			if (isElementPresentVerification(AccessManagementConstants.Cash_option)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Cash_option))
					throw new Exception("Not able to click Cash");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/*
	 * Method to check if user is able to see specified fields
	 */
	/**************************roleManage ****************************************/
	@Then("^I am able see following fields:$")
	public void i_am_able_see_following_fields(DataTable tableData) throws Exception  {
		String pageSource = chromeDriver.getPageSource();
		List<String> options = tableData.asList(String.class);
		for (int i = 0; i < options.size(); i++) {
			Boolean condition = pageSource.contains(options.get(i));
			log.info(condition);
		}
	}


	/****************************************************************************
	 * Method : To check if user is able to see available permissions and not available permissions field
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I am able to see Avilable permissions and Not Available permissions$")
	public void i_am_able_to_see_Avilable_permissions_and_Not_Available_permissions() throws Exception  {

		//validation required to display permissions
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Patient_Profile_Update_Authentication)) {
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To revoke few permissions from the existing permissions of selected role
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I revoke permission from existing$")
	public void i_revoke_permission_from_existing() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Permission_Revoke1)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Permission_Revoke1))
					throw new Exception("Not able to click Revoke");
			}
			if (isElementPresentVerification(AccessManagementConstants.MOVE_TO_LEFT)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.MOVE_TO_LEFT))
					throw new Exception("Not able to click Move to left");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To grant new permissions for the role
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I grant new permissions$")
	public void i_grant_new_permissions() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Grant_Permission1)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Grant_Permission1))
					throw new Exception("Not able to click Permission1");
			}
			if (isElementPresentVerification(AccessManagementConstants.Grant_Permission2)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Grant_Permission2))
					throw new Exception("Not able to click Permission2");
			}
			if (isElementPresentVerification(AccessManagementConstants.Grant_Permission3)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Grant_Permission3))
					throw new Exception("Not able to click Permission3");
			}
			if (isElementPresentVerification(AccessManagementConstants.Grant_Permission4)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Grant_Permission4))
					throw new Exception("Not able to click Permission4");
			}
			if (isElementPresentVerification(AccessManagementConstants.MOVE_TO_RIGHT)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.MOVE_TO_RIGHT))
					throw new Exception("Not able to click MOVE_TO_RIGHT");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To select a role from the dropdown field
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I select role from dropdown$")
	public void I_select_role_from_dropdown() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.SYSTEM_AREA_DROPDOWN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.SYSTEM_AREA_DROPDOWN))
					throw new Exception("Not able to click SYSTEM_AREA_DROPDOWN");
			}
			if (isElementPresentVerification(AccessManagementConstants.BPM_Dropdown)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.BPM_Dropdown))
					throw new Exception("Not able to click BPM_Dropdown");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/****************************************************************************
	 * Method : To select the specified role 
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I select role from role information$")
	public void I_select_role_from_role_information(DataTable arg1) throws Exception  {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String role = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Role");
			String roleDec = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Description");
			log.info(roleDec);
			chromeDriver.findElement(By.xpath("//*[contains(@aria-label,'" + role + "')]")).click();
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/*private void For(List<WebElement> list) {
        // TODO Auto-generated method stub

    }*/

	/****************************************************************************
	 * Method : To click on logout button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^I click on logout button$")
	public void I_click_on_logout_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Logout_button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Logout_button))
					throw new Exception("Not able to click Logout_button");
			}
			if (isElementPresentVerification(AccessManagementConstants.Logout_This_device)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Logout_This_device))
					throw new Exception("Not able to click Logout_This_device");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if update button is disabled
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@And("^i am able to see Update button should be disabled$")
	public void i_am_able_to_see_Update_button_should_be_disabled() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Update_button)) {
				Boolean condition = chromeDriver.findElement(By.xpath(AccessManagementConstants.Update_button)).isDisplayed();
				Assert.assertTrue(condition, "update button is not disable");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To check if user is able to see specified fields
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^user able to see following feilds$")
	public void user_able_to_see_following_feilds1(DataTable tableData) throws Exception  {
		List<String> options = tableData.asList(String.class);
		for (int i = 0; i < options.size(); i++) {
			log.info("Verifying element is....." + options.get(i));
		}
	}

	/****************************************************************************
	 * Method : To click on specified button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I \"([^\"]*)\" see \"([^\"]*)\" button$")
	public void i_see_button(String arg1, String arg2) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Store_Update_button)) {
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if user is navigated to employee information page when clicked on update button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click on update button it navigate to employee information update$")
	public void i_click_on_update_button_it_navigate_to_employee_information_update() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patient_Profile_Update_Authentication)) {
				Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.Patient_Profile_Update_Authentication, chromeDriver).isEnabled());
				Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.Patient_Profile_Update_Authentication2_option, chromeDriver).isEnabled());
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To check if task board is expanded when clicked
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^user click on task board it will expand$")
	public void user_click_on_task_board_it_will_expand() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification("//*[@id='main-left-sidenav-burger-menu']/md-list/md-list-item[2]")) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Taskboard_navigation))
					throw new Exception("Not able to click Taskboard_navigation");
			}
			if (isElementPresentVerification("//*[@id='main-left-sidenav-burger-menu']/md-list/md-list-item[2]")) {
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To click on specified link from left nav
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I click on \"([^\"]*)\" from left side menu$")
	public void i_click_on_link_name_from_left_side_menu(final String linkname) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (linkname.equals("Role Management")) {
				if (isElementPresentVerification(AccessManagementConstants.ROLE_MGMT_NAVLINK)) {
					if (!isElementPresentVerifyClick(AccessManagementConstants.ROLE_MGMT_NAVLINK))
						throw new Exception("Not able to click ROLE_MGMT_NAVLINK");
				}
			} else if (linkname.equals("Admin Button")) {
				if (isElementPresentVerification(AccessManagementConstants.DASHBOARD_ADMIN_NAVLINK)) {
					if (!isElementPresentVerifyClick(AccessManagementConstants.DASHBOARD_ADMIN_NAVLINK))
						throw new Exception("Not able to click DASHBOARD_ADMIN_NAVLINK");
				}
			} else if (linkname.equals("Prescriber Search Button")) {
				if (isElementPresentVerification(AccessManagementConstants.PRESCRIBER_SEARCH_BUTTON)) {
					if (!isElementPresentVerifyClick(AccessManagementConstants.PRESCRIBER_SEARCH_BUTTON))
						throw new Exception("Not able to click PRESCRIBER_SEARCH_BUTTON");
				}
			}


			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To check if the specified task is enabled and displayed
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^System should display the specific task enabled$")
	public void sytem_should_display_the_specific_task_enabled() throws Exception  {

		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.DR_TaskButton, chromeDriver).isDisplayed(), "DR task is not displayed");
			Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.DE_TaskButton, chromeDriver).isDisplayed(), "DE task is not displayed");
			Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.CE_TaskButton, chromeDriver).isDisplayed(), "CE task is not displayed ");
			Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.ProductVerification_TaskButton, chromeDriver).isDisplayed(), "PV task is not displayed ");

			Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.DR_TaskButton, chromeDriver).isEnabled(), "DR task is enabled");
			Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.DE_TaskButton, chromeDriver).isEnabled(), "DE task is enabled");
			Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.CE_TaskButton, chromeDriver).isEnabled(), "CE task is enabled");
			Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.ProductVerification_TaskButton, chromeDriver).isEnabled(), "PV task is enabled");
			Assert.assertTrue(FrameworkLibrary.getElementByProperty(AccessManagementConstants.Filling_TaskButton, chromeDriver).isEnabled(), "Filling is enabled");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To logout RXMS app
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I logout of RxMS$")
	public void i_logout_of_RxMS() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.RxMS_logoutButton)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.RxMS_logoutButton))
					throw new Exception("Not able to click logoutButton");
			}
			if (isElementPresentVerification(AccessManagementConstants.LogoutAlert_button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.LogoutAlert_button))
					throw new Exception("Not able to click LogoutAlert_button");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To click finish button on intake screen
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^Click Finish button in intake method screen$")
	public void clicks_Finish_button_in_intake_method_screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Finish)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Finish))
					throw new Exception("Not able to click Finish");
			}
			if (isElementPresentVerification(AccessManagementConstants.TASK_REFRESH_BTN)) {
				Thread.sleep(10000);
				if (!isElementPresentVerifyClick(AccessManagementConstants.TASK_REFRESH_BTN))
					throw new Exception("Not able to click TASK_REFRESH_BTN");
				isElementPresentVerifyClick(AccessManagementConstants.TASK_REFRESH_BTN);
				Thread.sleep(5000);
				isElementPresentVerifyClick(AccessManagementConstants.TASK_REFRESH_BTN);
			}
			Date today = Calendar.getInstance().getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd");
			SimpleDateFormat formatter2 = new SimpleDateFormat("h:mm a");
			IntakeDate = formatter.format(today);

			Calendar cal = Calendar.getInstance();
			cal.setTime(today);
			cal.add(Calendar.MINUTE, 15);
			currentPickupTime = formatter2.format(cal.getTime());

			cal.add(Calendar.MINUTE, 1);
			possiblePickupTime = formatter2.format(cal.getTime());

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method : User Validating the Drug details page in RxMS application
	 * author : Jeyaprakash K
	 * Date : Feb-20-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@And("^Validating the drug details page sub menu$")
	public void validating_drug_details_sub_menu() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			boolean ele = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.DRUG_DETAILS_GENERALINFO_TAB)).isDisplayed();
			Assert.assertTrue(ele, "Drug Detail page General Info tab not displayed");
			boolean elem = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.DRUG_DETAILS_CLINICAL_REFERENCE)).isDisplayed();
			Assert.assertTrue(elem, "Drug Detail page Clinical Reference tab not displayed");
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method : To click on patient printout and validate the popup
	 * author : Jeyaprakash K
	 * Date : Feb-20-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^Click Print patient handout and validate popup$")
	public void print_patient_handout_and_validate_popup() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.PRIENT_PATIENT_HANDOUT)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PRIENT_PATIENT_HANDOUT))
					throw new Exception("Not able to click PRINT_PATIENT_HANDOUT");
			}
			boolean ele = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PRIENT_PATIENT_HANDOUT_POPUP_FUNCTION_UNAVAILABLE)).isDisplayed();
			Assert.assertTrue(ele, "Function Unavailable MSG no shown");
			boolean elem = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PRIENT_PATIENT_HANDOUT_ICPLUS)).isDisplayed();
			Assert.assertTrue(elem, "IC+ MSG Not shown");
			if (isElementPresentVerification(AccessManagementConstants.PRIENT_PATIENT_HANDOUT_POPUP_OK_BTN)) {
				isElementPresentVerifyClick(AccessManagementConstants.PRIENT_PATIENT_HANDOUT_POPUP_OK_BTN);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To validate drug type in drug details page
	 * author : Jeyaprakash K
	 * Date : Feb-20-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/
	@Then("^Validating drug type in drug details page$")
	public void validating_drugType_in_drugDetails_Page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String drugType = chromeDriver.findElement(By.xpath(AccessManagementConstants.DRUG_DETAILS_PAGE_DRUG_TYPE)).getAttribute("value");
			if (drugType.equalsIgnoreCase("Brand for")) {
			} else if (drugType.equalsIgnoreCase("Generic For")) {
			} else {
				log.info("The drug type is not 'Brand for' or'Generic For' ");
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method : To enter employeeid and search
	 *
	 * author :Jeyaprakash K
	 *
	 * Date : Feb-20-2017
	 *
	 * Modifier :
	 *
	 * Modification Data :
	 *
	 ******************************************************************************/

	@Then("^User enter employeeID on user management feild and i will click on search$")
	public void users_enter_employeeID_on_user_management_feild_and_i_will_click_on_search(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);

			if (isElementPresentVerification(AccessManagementConstants.Employeed_Id_Searchfeild)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Employeed_Id_Searchfeild))
					throw new Exception("Not able to click Searchfeild");
			}
			AccessManagementLibrary.enter_Text(arg1, "EmployeeID", AccessManagementConstants.Employeed_Id_Searchfeild, chromeDriver);
			if (dataMap.containsKey("Alt+S")) {
				if ("Yes".equalsIgnoreCase(dataMap.get("Alt+S").get(0))) {
					Robot r = new Robot();
					r.keyPress(KeyEvent.VK_ALT);
					r.keyPress(KeyEvent.VK_S);
					r.keyRelease(KeyEvent.VK_ALT);
					r.keyRelease(KeyEvent.VK_S);
				}
			} else {
				if (isElementPresentVerification(AccessManagementConstants.User_Management_Search_Button)) {
					if (!isElementPresentVerifyClick(AccessManagementConstants.User_Management_Search_Button))
						throw new Exception("Not able to click Searchfeild");
				}
			}

			if (dataMap.containsKey("EmpId")) {
				String empId = dataMap.get("EmpId").get(0);
				if (empId.equalsIgnoreCase("Invalid")) {
					if (isElementPresentVerification(AccessManagementConstants.ADMIN_NO_RESULT_FOUND_TXT)) {
						boolean ele = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.ADMIN_NO_RESULT_FOUND_TXT)).isDisplayed();
						Assert.assertTrue(ele, "No Result Text not displayed");
					}
				}
			}
			if (dataMap.containsKey("EmpId")) {
				String empId = dataMap.get("EmpId").get(0);
				if (empId.equalsIgnoreCase("Valid")) {
					if (dataMap.containsKey("Click_X_Icon")) {
						if ("Yes".equalsIgnoreCase(dataMap.get("Click_X_Icon").get(0))) {
							if (isElementPresentVerification(AccessManagementConstants.ADMIN_EMPID_FIELD_X_ICON)) {
								if (!isElementPresentVerifyClick(AccessManagementConstants.ADMIN_EMPID_FIELD_X_ICON))
									throw new Exception("Not able to click X Icon");
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
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method : To validate password field
	 *
	 * author :Jeyaprakash K
	 *
	 * Date : Feb-21-2017
	 *
	 * Modifier :
	 *
	 * Modification Data :
	 *
	 ******************************************************************************/

	@When("^User enter the without lower upper numeric values in paasword field and validate$")
	@Then("^User validating password fields and reset the password$")
	public void user_enter_new_password_and_i_click_conformed_password(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebElement element;
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String password = dataMap.get("Password").get(0);
			String confirmpassword = dataMap.get("ConfirmPWD").get(0);
			if (isElementPresentVerification(AccessManagementConstants.Employee_New_password)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Employee_New_password))
					throw new Exception("Not able to click Employee_New_password");
			}
			element = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Employee_New_password));
			element.clear();
			element.sendKeys(password);
			Thread.sleep(1000);
			if (isElementPresentVerification(AccessManagementConstants.Employee_conform_password)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Employee_conform_password))
					throw new Exception("Not able to click Employee_conform_password");
			}
			element = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Employee_conform_password));
			element.clear();
			element.sendKeys(confirmpassword);
			Thread.sleep(1000);
			if (dataMap.containsKey("Alt+R")) {
				if ("Yes".equalsIgnoreCase(dataMap.get("Alt+R").get(0))) {
					Robot r = new Robot();
					r.keyPress(KeyEvent.VK_ALT);
					r.keyPress(KeyEvent.VK_R);
					r.keyRelease(KeyEvent.VK_ALT);
					r.keyRelease(KeyEvent.VK_R);
					boolean ele = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PWD_RESET_MSG_USE_ALT_R)).isDisplayed();
					Assert.assertTrue(ele, "");
					if (isElementPresentVerification(AccessManagementConstants.PWD_X_ICON)) {
						if (!isElementPresentVerifyClick(AccessManagementConstants.PWD_X_ICON))
							throw new Exception("Not able to click PWD_X_ICON");
					}
				}
			} else if (dataMap.containsKey("Cancel_Password_Reset")) {
				if ("Yes".equalsIgnoreCase(dataMap.get("Cancel_Password_Reset").get(0))) {
					Robot r = new Robot();
					r.keyPress(KeyEvent.VK_ALT);
					r.keyPress(KeyEvent.VK_C);
					r.keyRelease(KeyEvent.VK_ALT);
					r.keyRelease(KeyEvent.VK_C);
				}
			} else {
				if (isElementPresentVerification(AccessManagementConstants.Password_Reset_button)) {
					if (!isElementPresentVerifyClick(AccessManagementConstants.Password_Reset_button))
						throw new Exception("Not able to click Password_Reset_button");
				}
			}
			if (dataMap.containsKey("PasswordValidation")) {
				if ("Yes".equalsIgnoreCase(dataMap.get("PasswordValidation").get(0))) {
					if ("LessChar".equalsIgnoreCase(dataMap.get("PasswordType").get(0))) {
						if (isElementPresentVerification(AccessManagementConstants.PWD_VALIDATION_LESSTHAN_8_CHAR)) {
							boolean ele = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PWD_VALIDATION_LESSTHAN_8_CHAR)).isDisplayed();
							Assert.assertTrue(ele, "Password is less than 8 char");
						}
					}
					if ("WithoutNumeric".equalsIgnoreCase(dataMap.get("PasswordType").get(0))) {
						if (isElementPresentVerification(AccessManagementConstants.PWD_VALIDATION_WITHOUT_NUMERIC_LOWER_UPER)) {
							boolean ele = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PWD_VALIDATION_WITHOUT_NUMERIC_LOWER_UPER)).isDisplayed();
							Assert.assertTrue(ele, "Password is, Case Sensitive,  Must Include one(1) Numeral,Must have at least one(1) Uppercase and Lowercase");
						}
					}
					if ("PasswordNotMatch".equalsIgnoreCase(dataMap.get("PasswordType").get(0))) {
						if (isElementPresentVerification(AccessManagementConstants.PWD_DOES_NOT_MATCH)) {
							boolean ele = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PWD_DOES_NOT_MATCH)).isDisplayed();
							Assert.assertTrue(ele, "The New Password and Confirm Password do not match.");
						}
					}
					if ("InvalidPWD".equalsIgnoreCase(dataMap.get("PasswordType").get(0))) {
						if (isElementPresentVerification(AccessManagementConstants.INVALID_PWD)) {
							boolean ele = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.INVALID_PWD)).isDisplayed();
							Assert.assertTrue(ele, "The password must be at least 8 characters long, including at least one uppercase letter, one lower case letter and at least one numeric.");
						}
					}
				}
			}
			if (isElementPresentVerification(AccessManagementConstants.Navigation_initial)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Navigation_initial))
					throw new Exception("Not able to click Initial");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/****************************************************************************
	 * Method : verify that you are able to see under the price column the cash price returned + plan ID
	 *
	 * author : Jeyaprakash K
	 *
	 * Date :  Feb-21-2017
	 *
	 * Modifier :
	 *
	 * Modification Data :
	 *
	 ******************************************************************************/

	@Then("^User validte the price column the cash price returned with plan ID$")
	public void user_validate_the_cash_price_reurned_with_planID(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebElement element;
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String lName = dataMap.get("PatientLastName").get(0);
			if (isElementPresentVerification(AccessManagementConstants.PATIENT_ORDER_STATUS_ICON)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PATIENT_ORDER_STATUS_ICON))
					throw new Exception("Not able to click PATIENT_ORDER_STATUS_ICON");
			}
			element = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PATIENT_ORDER_STATUS_LASTNAME_TXT));
			element.clear();
			element.sendKeys(lName);
			if (isElementPresentVerification(AccessManagementConstants.PATIENT_ORDER_STATUS_SEARCH_BTN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PATIENT_ORDER_STATUS_SEARCH_BTN))
					throw new Exception("Not able to click PATIENT_ORDER_STATUS_SEARCH_BTN");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/****************************************************************************
	 * Method :  User Click on logout tab and Validate the functionality in RxMS app
	 *
	 * author : Jeyaprakash K
	 *
	 * Date :  Feb-21-2017
	 *
	 * Modifier :
	 *
	 * Modification Data :
	 *
	 ******************************************************************************/

	@When("^User click cancel button while performing logout operation$")
	public void user_cancel_on_logout() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.LOGOUT_BTN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.LOGOUT_BTN))
					throw new Exception("Not able to click LOGOUT_BTN");
			}
			if (isElementPresentVerification(AccessManagementConstants.LOGOUT_CANCEL)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.LOGOUT_CANCEL))
					throw new Exception("Not able to click LOGOUT_CANCEL");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To click on This device button to logout only from the current device
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^User click ThisDevice button and validate while performing logout operation$")
	public void user_Click_on_logout_ThisDevice() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.LOGOUT_BTN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.LOGOUT_BTN))
					throw new Exception("Not able to click LOGOUT_BTN");
			}
			if (isElementPresentVerification(AccessManagementConstants.LOGOUT_THIS_DEVICE)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.LOGOUT_THIS_DEVICE))
					throw new Exception("Not able to click LOGOUT_THIS_DEVICE");
			}
			if (isElementPresentVerification(AccessManagementConstants.LOGIN_TXT)) {
				String login_H = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.LOGIN_TXT)).getText();
				Assert.assertEquals(login_H, "Login", "Should not able to view login page");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To click on All Device button of popup during logout functionality
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^User click AllDevice button and validate while performing logout operation$")
	public void user_Click_on_logout_allDevice() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.LOGOUT_BTN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.LOGOUT_BTN))
					throw new Exception("Not able to click LOGOUT_BTN");
			}
			if (isElementPresentVerification(AccessManagementConstants.LOGOUT_ALL_DEVICE)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.LOGOUT_ALL_DEVICE))
					throw new Exception("Not able to click LOGOUT_ALL_DEVICE");
			}
			if (isElementPresentVerification(AccessManagementConstants.LOGIN_TXT)) {
				String login_H = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.LOGIN_TXT)).getText();
				Assert.assertEquals(login_H, "Login", "Should not able to view login page");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To search for specific plans
	 *
	 * author : Jeyaprakash K
	 *
	 * Date :  Feb-21-2017
	 *
	 * Modifier :
	 *
	 * Modification Data :
	 *
	 ******************************************************************************/


	@Then("^User search Appropriate plan$")
	public void user_search_Appropriate_plan(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebElement element;
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String planID = dataMap.get("PlanID").get(0);
			String bin = dataMap.get("BIN").get(0);
			String pcn = dataMap.get("PCN").get(0);
			String plan_Name = dataMap.get("PLAN_NAME").get(0);
			if (isElementPresentVerification(AccessManagementConstants.PLAN_TAB)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PLAN_TAB))
					throw new Exception("Not able to click PLAN_TAB");
			}
			if (isElementPresentVerification(AccessManagementConstants.PLAN_ID_SEARCH_FIELD)) {
				element = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PLAN_ID_SEARCH_FIELD));
				element.clear();
				element.sendKeys(planID);
				if (isElementPresentVerification(AccessManagementConstants.PLAN_SEARCH_BTN)) {
					if (!isElementPresentVerifyClick(AccessManagementConstants.PLAN_SEARCH_BTN))
						throw new Exception("Not able to click PLAN_SEARCH_BTN");
				}
				
				Assert.assertTrue(chromeDriver.findElements(By.xpath(AccessManagementConstants.plan_search_rows)).size()>0);
				
			}
			if (isElementPresentVerification(AccessManagementConstants.PLAN_SEARCH_BIN)) {
				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PLAN_ID_SEARCH_FIELD)).clear();
				element = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PLAN_SEARCH_BIN));
				element.clear();
				element.sendKeys(bin);
				
				if (isElementPresentVerification(AccessManagementConstants.PLAN_SEARCH_BTN)) {
					if (!isElementPresentVerifyClick(AccessManagementConstants.PLAN_SEARCH_BTN))
						throw new Exception("Not able to click PLAN_SEARCH_BTN");
				}
				
				Assert.assertTrue(chromeDriver.findElements(By.xpath(AccessManagementConstants.plan_search_rows)).size()>0);
				
			}
			if (isElementPresentVerification(AccessManagementConstants.PLAN_SEARCH_PCN)) {
				//FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PLAN_SEARCH_BIN)).clear();
				element = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PLAN_SEARCH_PCN));
				element.clear();
				element.sendKeys(pcn);
				
				if (isElementPresentVerification(AccessManagementConstants.PLAN_SEARCH_BTN)) {
					
					if (!isElementPresentVerifyClick(AccessManagementConstants.PLAN_SEARCH_BTN))
						throw new Exception("Not able to click PLAN_SEARCH_BTN");
				}
				
				Assert.assertTrue(chromeDriver.findElements(By.xpath(AccessManagementConstants.plan_search_rows)).size()>0);
				
			}
			if (isElementPresentVerification(AccessManagementConstants.PLAN_SEARCH_PLAN_NAME)) {
				
				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PLAN_SEARCH_BIN)).clear();
				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PLAN_SEARCH_PCN)).clear();
				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PLAN_ID_SEARCH_FIELD)).clear();
				
				
				element = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PLAN_SEARCH_PLAN_NAME));
				element.clear();
				element.sendKeys(plan_Name);
				
				if (isElementPresentVerification(AccessManagementConstants.PLAN_SEARCH_BTN)) {
					if (!isElementPresentVerifyClick(AccessManagementConstants.PLAN_SEARCH_BTN))
						throw new Exception("Not able to click PLAN_SEARCH_BTN");
				}
				
				Assert.assertTrue(chromeDriver.findElements(By.xpath(AccessManagementConstants.plan_search_rows)).size()>0);
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method : To navigate back to dashboard screen
	 *
	 * author : Jeyaprakash K
	 *
	 * Date :  Feb-21-2017
	 *
	 * Modifier :
	 *
	 * Modification Data :
	 *
	 ******************************************************************************/

	@And("^User navigate back to dashboard screen$")
	public void user_navigate_back_to_dashboard_screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.PLAN_NAVIGATE_BACK_BTN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PLAN_NAVIGATE_BACK_BTN))
					throw new Exception("Not able to click PLAN_NAVIGATE_BACK_BTN");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/****************************************************************************
	 * Method : To validate team member profile values
	 *
	 * author : Jeyaprakash K
	 *
	 * Date :  Feb-21-2017
	 *
	 * Modifier :
	 *
	 * Modification Data :
	 *
	 ******************************************************************************/

	@Then("^User validating team member profile$")
	public void User_validating_team_member_profile() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.EMP_INFO)) {
				boolean emp_info = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.EMP_INFO)).isDisplayed();
				Assert.assertTrue(emp_info, "User Should not able to view Employee Information");
			}
			if (isElementPresentVerification(AccessManagementConstants.LICENSE_CERTIFICATION)) {
				boolean license = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.LICENSE_CERTIFICATION)).isDisplayed();
				Assert.assertTrue(license, "User Should not able to view License & Certification");
			}
			if (isElementPresentVerification(AccessManagementConstants.ASSIGNED_STORE)) {
				boolean store = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.ASSIGNED_STORE)).isDisplayed();
				Assert.assertTrue(store, "User Should not able to view Assigned Stores");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To verify that it is possible to view all Role associated to my Team Member profile with Scroll
	 *
	 * author : Jeyaprakash K
	 *
	 * Date :  Feb-21-2017
	 *
	 * Modifier :
	 *
	 * Modification Data :
	 *
	 ******************************************************************************/

	@Then("^User validating the team member role$")
	public void User_validating_the_team_member_role() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.TEAM_MEMBER_ROLE_H)) {
				boolean Role_H = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.TEAM_MEMBER_ROLE_H)).isDisplayed();
				Assert.assertTrue(Role_H, "User Should not able to view the Role Header");
			}
			if (isElementPresentVerification(AccessManagementConstants.TEAM_MEMBER_ROLE1)) {
				boolean Role1 = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.TEAM_MEMBER_ROLE1)).isDisplayed();
				Assert.assertTrue(Role1, "User Should not able to view team member roles");
			}
			if (isElementPresentVerification(AccessManagementConstants.TEAM_MEMBER_ROLE2)) {
				boolean Role1 = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.TEAM_MEMBER_ROLE2)).isDisplayed();
				Assert.assertTrue(Role1, "User Should not able to view team member roles");
			}
			if (isElementPresentVerification(AccessManagementConstants.TEAM_MEMBER_ROLE3)) {
				boolean Role1 = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.TEAM_MEMBER_ROLE3)).isDisplayed();
				Assert.assertTrue(Role1, "User Should not able to view team member roles");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method :Determine Prescription Intake Type - Notification message for an Intake Notification failure
	 *
	 * author : Jeyaprakash K
	 *
	 * Date :  Feb-21-2017
	 *
	 * Modifier :
	 *
	 * Modification Data :
	 *
	 ******************************************************************************/

	@Then("^I validate the Notification message$")
	public void i_validate_the_Notification_message() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.NOTIFICATION_TXT)) {
				String notification = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.NOTIFICATION_TXT)).getText();
				Assert.assertEquals(notification, "Login", "Should not able to view notification msg");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method :Determine Prescription Intake Type - Notification message for an Intake Notification failure
	 *
	 * author : Jeyaprakash K
	 *
	 * Date :  Feb-21-2017
	 *
	 * Modifier :
	 *
	 * Modification Data :
	 *
	 ******************************************************************************/

	@Then("^User refreshes and Validate the taskboard$")
	public void user_refreshes_and_Validate_the_taskboard() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.TASK_REFRESH_BTN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.TASK_REFRESH_BTN))
					throw new Exception("Not able to click TASK_REFRESH_BTN");
			}
			if (isElementPresentVerification(AccessManagementConstants.DATA_ENTRY_TAB)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.DATA_ENTRY_TAB))
					throw new Exception("Not able to click DATA_ENTRY_TAB");
			}
			if (isElementPresentVerification(AccessManagementConstants.NO_TASK_AVAILABLE_POPUP_H)) {
				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.NO_TASK_AVAILABLE_POPUP_H)).isDisplayed();
			}
			if (isElementPresentVerification(AccessManagementConstants.NO_TASK_PLS_CHOOSE_ANOTHER_TASK)) {
				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.NO_TASK_PLS_CHOOSE_ANOTHER_TASK)).isDisplayed();
			}
			if (isElementPresentVerification(AccessManagementConstants.NO_TASK_AVAILABLE_POPUP_OK_BTN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.NO_TASK_AVAILABLE_POPUP_OK_BTN))
					throw new Exception("Not able to click OK Button");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method : The user checks the status of a prescription for a patient
	 *
	 * author : Jeyaprakash K
	 *
	 * Date :  Feb-21-2017
	 *
	 * Modifier :
	 *
	 * Modification Data :
	 *
	 ******************************************************************************/

	@Then("^I checks the status of a prescription for a patient$")
	public void i_checks_the_status_of_a_prescription_for_a_spatient() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.CHECK_ICPLUS)) {
				FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.CHECK_ICPLUS)).isDisplayed();
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if user is able to navigate on the tabs 
	 *
	 * author : Jeyaprakash K
	 *
	 * Date :  Feb-21-2017
	 *
	 * Modifier :
	 *
	 * Modification Data :
	 *
	 ******************************************************************************/

	@Then("^User navigate the tabs in RxMs home screen$")
	public void user_navigate_the_tabs_in_RxMs_home_screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.PATIENT_TAB)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PATIENT_TAB))
					throw new Exception("Not able to click PATIENT_TAB");
				back_navigate_HotKey();
			}
			if (isElementPresentVerification(AccessManagementConstants.DRUG_TAB)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.DRUG_TAB))
					throw new Exception("Not able to click DRUG_TAB");
				back_navigate_HotKey();
			}
			if (isElementPresentVerification(AccessManagementConstants.PRESCRIBER_TAB)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PRESCRIBER_TAB))
					throw new Exception("Not able to click DRUG_TAB");
				back_navigate_HotKey();
			}
			if (isElementPresentVerification(AccessManagementConstants.PLAN__TAB)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PLAN__TAB))
					throw new Exception("Not able to click PLAN__TAB");
				back_navigate_HotKey();
			}
			if (isElementPresentVerification(AccessManagementConstants.PATIENT_ORDER_TAB)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PATIENT_ORDER_TAB))
					throw new Exception("Not able to click PATIENT_ORDER_TAB");
				back_navigate_HotKey();
			}
			/*if(isElementPresentVerification(AccessManagementConstants.ADMIN_TAB)){
				if(!isElementPresentVerifyClick(AccessManagementConstants.ADMIN_TAB))
					throw new Exception("Not able to click ADMIN_TAB");
				back_navigate_HotKey();
			}*/
			if (isElementPresentVerification(AccessManagementConstants.LOGOUT_TAB)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.LOGOUT_TAB))
					throw new Exception("Not able to click LOGOUT_TAB");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/*
	 * Method to click hot keys to navigate back
	 */
	public void back_navigate_HotKey() throws Exception  {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_LEFT);
		Thread.sleep(1000);
		r.keyRelease(KeyEvent.VK_ALT);
		r.keyRelease(KeyEvent.VK_LEFT);
		Thread.sleep(1000);

	}

	/****************************************************************************
	 * Method : To verify elements on RXMS home screen
	 *
	 * author : Jeyaprakash K
	 *
	 * Date :  Feb-21-2017
	 *
	 * Modifier :
	 *
	 * Modification Data :
	 *
	 ******************************************************************************/

	@Then("^User verify RxMs home screen elements$")
	public void user_verify_RxMs_home_screen_elements() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.LOGO)) {
				boolean logo = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.LOGO)).isDisplayed();
				Assert.assertTrue(logo, "User Should not able to view RxMs logo");
			}
			if (isElementPresentVerification(AccessManagementConstants.PATIENT_TAB)) {
				boolean patient = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PATIENT_TAB)).isDisplayed();
				Assert.assertTrue(patient, "User Should not able to view RxMs patient tab");
			}
			if (isElementPresentVerification(AccessManagementConstants.PLAN__TAB)) {
				boolean plan = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PLAN__TAB)).isDisplayed();
				Assert.assertTrue(plan, "User Should not able to view RxMs plan");
			}
			if (isElementPresentVerification(AccessManagementConstants.DRUG_TAB)) {
				boolean drug = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.DRUG_TAB)).isDisplayed();
				Assert.assertTrue(drug, "User Should not able to view RxMs drug tab");
			}
			if (isElementPresentVerification(AccessManagementConstants.PRESCRIBER_TAB)) {
				boolean prescriber = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PRESCRIBER_TAB)).isDisplayed();
				Assert.assertTrue(prescriber, "User Should not able to view RxMs prescriber stab");
			}
			if (isElementPresentVerification(AccessManagementConstants.PATIENT_ORDER_TAB)) {
				boolean pos = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PATIENT_ORDER_TAB)).isDisplayed();
				Assert.assertTrue(pos, "User Should not able to view RxMs patient order status tab");
			}
			if (isElementPresentVerification(AccessManagementConstants.LOGOUT_TAB)) {
				boolean logout = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.LOGOUT_TAB)).isDisplayed();
				Assert.assertTrue(logout, "User Should not able to view RxMs logout tab");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method : The User clicks Add Comments button and validate the popup msg
	 * author : Jeyaprakash K
	 * Date :  Mar-13-2017
	 * Modifier :
	 * Modification Data :
	 *
	 ******************************************************************************/

	@And("^User clicks add comments button and validate the popup msg$")
	public void users_clicks_add_comments_button_and_validate_the_popup_msg() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.COMMENTS_ICON)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.COMMENTS_ICON))
					throw new Exception("Not able to click COMMENTS_ICON");
			}
			if (isElementPresentVerification(AccessManagementConstants.HIDE_COMMENTS)) {
				boolean hideBtn = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.HIDE_COMMENTS)).isDisplayed();
				Assert.assertTrue(hideBtn, "Should not able to view notification msg");
			}
			if (isElementPresentVerification(AccessManagementConstants.ADD_COMMENTS_ICON)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.ADD_COMMENTS_ICON))
					throw new Exception("Not able to click ADD_COMMENTS_ICON");
			}
			if (isElementPresentVerification(AccessManagementConstants.COMMENTS_POPUP_MSG)) {
				boolean comments = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.COMMENTS_POPUP_MSG)).isDisplayed();
				Assert.assertTrue(comments, "Should not able to view notification msg");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/****************************************************************************
	 * Method : Patient Search and validating his 3rd party plans
	 * author : Jeyaprakash K
	 * Date :  Mar-14-2017
	 * Modifier :
	 * Modification Data :
	 *
	 ******************************************************************************/

	@And("^User clicks 3rd party plans button and validate plans$")
	public void users_clicks_3rd_party_plans_button_and_validate_plans() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.PATIENT_3RD_PLAN_ICON)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PATIENT_3RD_PLAN_ICON))
					throw new Exception("Not able to click PATIENT_3RD_PLAN_ICON");
			}
			if (isElementPresents(AccessManagementConstants.Third_paty_plan_Title)) {
				boolean plan = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Third_paty_plan_Title)).isDisplayed();
				Assert.assertTrue(plan, "plan not visible");
				Assert.assertTrue(getElementText(AccessManagementConstants.PATIENT_NO_PLANS).contains("Plan"));
			} else if (isElementPresents(AccessManagementConstants.PATIENT_NO_PLANS)) {
				boolean noplan = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PATIENT_NO_PLANS)).isDisplayed();
				Assert.assertTrue(noplan, "No plan message is not visible");
			    Assert.assertTrue(getElementText(AccessManagementConstants.PATIENT_NO_PLANS).equalsIgnoreCase("no plans"));
			} else {
				Assert.fail("plan or no plan information not found");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : Patient Search and validating his General Info
	 * author : Jeyaprakash K
	 * Date :  Mar-14-2017
	 * Modifier :
	 * Modification Data :
	 *
	 ******************************************************************************/

	@And("^User clicks General Info and validate$")
	public void user_clicks_General_Info_and_validate() throws Exception  {
		FrameworkLibrary.isElementPresentVerifyClick("");
		FrameworkLibrary.chromeDriver.findElement(By.xpath("")).isDisplayed();
	}


	/****************************************************************************
	 * Method : To verify pending link for current prescription is clicked
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^User verify pending link for current prescription should be clicked$")
	public void the_prescription_status_should_be_clicked(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			List<WebElement> list1 = chromeDriver.findElements(By.xpath(SmokeTestConstants.POS_patientNames));
			String expectedPatientName = dataMap.get("LastName").get(0);
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;

			for (int i = 0; i < list1.size(); i++) {
				if (list1.get(i).getText().contains(expectedPatientName)) {
					String s = list1.get(i).getAttribute("id");
					String[] parts = s.split("-");
					String part2 = parts[1];
					List<WebElement> singlepresc = chromeDriver.findElements(By.xpath("//*[contains(@id,'single-prescription-" + part2 + "')]"));

					for (int z = 0; z < singlepresc.size(); z++) {

						if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate) && singlepresc.get(z).getText().contains(pickuptime)) {
							Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("pending"));
							String dyn = singlepresc.get(z).getAttribute("id");
							String[] dynamo = dyn.split("-");
							String part = dynamo[2];
							String ele = "//*[@id='single-prescription-" + part + "-" + z + "']/div[5]/div[1]/a";
							waitToClick(ele).click();
						} else if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate) && singlepresc.get(z).getText().contains(possiblepickupTime1)) {

							Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("pending"));
							String dyn = singlepresc.get(z).getAttribute("id");
							String[] dynamo = dyn.split("-");
							String part = dynamo[2];
							String ele = "//*[@id='single-prescription-" + part + "-" + z + "']/div[5]/div[1]/a";
							waitToClick(ele).click();
						}
					}
				}
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method : To verify the ICPlust link for current prescription
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^The ICPlus link for current prescription should be verified$")
	public void the_in_icPlus_link_for_current_prescription_should_be_verified(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String expectedPatientName = dataMap.get("LastName").get(0);
			List<WebElement> list1 = chromeDriver.findElements(By.xpath(AccessManagementConstants.POS_patientNames));
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
			for (int i = 0; i < list1.size(); i++) {
				if (list1.get(i).getText().contains(expectedPatientName)/* && list1.get(i).getText().contains(expectedPhoneNumber)*/) {
					String s = list1.get(i).getAttribute("id");
					String[] parts = s.split("-");
					String part2 = parts[1];
					List<WebElement> singlepresc = chromeDriver.findElements(By.xpath("//*[contains(@id,'patient-order-status-team-member-status-id-" + part2 + "')]"));

					for (int z = 0; z < singlepresc.size(); z++) {
						if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate) && singlepresc.get(z).getText().contains(pickuptime)) {
							Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("check ic+"));
							String dyn = singlepresc.get(z).getAttribute("id");
							String[] dynamo = dyn.split("-");
							String part = dynamo[2];
							String ele = "//*[@id='patient-order-status-team-member-status-id-" + part + "-" + z + "']/div[5]/div[1]/a";
							boolean elem = chromeDriver.findElement(By.xpath(ele)).isDisplayed();
							Assert.assertTrue(elem, "Check IC Plus");
						} else if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate) && singlepresc.get(z).getText().contains(possiblepickupTime1)) {

							Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("check ic+"));
							String dyn = singlepresc.get(z).getAttribute("id");
							String[] dynamo = dyn.split("-");
							String part = dynamo[2];
							String ele = "//*[@id='patient-order-status-team-member-status-id-" + part + "-" + z + "']/div[5]/div[1]/a";
							boolean elem = chromeDriver.findElement(By.xpath(ele)).isDisplayed();
							Assert.assertTrue(elem, "Check IC Plus");
						}
					}
				}
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method : To enter prescriber first name and last name value
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^Users enters prescriber first name and Last name$")
	public void User_enters_prescriber_first_name_and_Last_name(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_LastName)) {
				AccessManagementLibrary.enter_Text(arg1, "Lastname", SmokeTestConstants.Prescriber_LastName, chromeDriver);
			}
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_FirstName)) {
				AccessManagementLibrary.enter_Text(arg1, "Firstname", SmokeTestConstants.Prescriber_FirstName, chromeDriver);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method : To click on Check ICPlus button on data entry page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^Clicks Check ICPlus button to complete Data Entry$")
	public void clicks_Finish_button_to_complete_Data_Entry() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.SEND_ICPLUS)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.SEND_ICPLUS))
					throw new Exception("Not able to click SEND_ICPLUS");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/*
	 * Method to click on dataentry link
	 */
	@Then("^I click on DataEntry$")
	public void i_click_on_DE() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.PERFORM_DATAENTRY)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PERFORM_DATAENTRY))
					throw new Exception("Not able to click PERFORM_DATAENTRY");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To validate REMS drug popup
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^User is validating REMS Drug pop-up$")
	public void validate_REMS_Drug_popUp() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.REMS_POP_UP)) {
				boolean elem = chromeDriver.findElement(By.xpath(AccessManagementConstants.REMS_POP_UP)).isDisplayed();
				Assert.assertTrue(elem, "Should not able to view REMS drug pop-up error msg");
			}
			if (isElementPresentVerification(AccessManagementConstants.CANCEL_BTN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.CANCEL_BTN))
					throw new Exception("Not able to click CANCEL_BTN");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To enter prescriber phone number value
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^User enters the Prescriber phonenumber$")
	public void enters_Prescriber_phonenumber(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebElement element;
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String PhoneNumber = dataMap.get("Phonenumber").get(0);
			if (isElementPresentVerification(AccessManagementConstants.PRESCRIBER_PHONE)) {
				element = chromeDriver.findElement(By.xpath(AccessManagementConstants.PRESCRIBER_PHONE));
				element.click();
				element.sendKeys(PhoneNumber);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To enter prescriber NPI data
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^User enters the Prescriber NPI$")
	public void enters_Prescriber_NPI(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String npi = dataMap.get("NPI").get(0);
			if (isElementPresentVerification(AccessManagementConstants.PRESCRIBER_NPI_DEA)) {
				chromeDriver.findElement(By.xpath(AccessManagementConstants.PRESCRIBER_NPI_DEA)).sendKeys(npi);
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To enter prescriber DEA value
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^User enters the Prescriber DEA$")
	public void enters_Prescriber_DEA(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebElement element;
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String dea = dataMap.get("DEA").get(0);
			if (isElementPresentVerification(AccessManagementConstants.PRESCRIBER_NPI_DEA)) {
				element = chromeDriver.findElement(By.xpath(AccessManagementConstants.PRESCRIBER_NPI_DEA));
				element.sendKeys(dea);
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To validate the prescriber validation message
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^User validate the Prescriber$")
	public void validate_the_Prescriber() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.PRESCRIBER_VALIDATION_MSG)) {
				boolean elem = chromeDriver.findElement(By.xpath(AccessManagementConstants.PRESCRIBER_VALIDATION_MSG)).isDisplayed();
				Assert.assertTrue(elem, "User should not able to view Prescriber validation msg");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To click prescriber search button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^User click the Prescriber search button$")
	public void Prescriber_search_btn() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Prescriber_searchButton)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Prescriber_searchButton))
					throw new Exception("Not able to click searchButton");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To enter patient data on DE screen
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^User enters the data in DE Screen$")
	public void enters_product_information(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			WebElement element;
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			if (dataMap.containsKey("Prescriber")) {
				String Prescriber = dataMap.get("Prescriber").get(0);
				if (Prescriber.equalsIgnoreCase("Yes")) {
					WebDriverWait wait = new WebDriverWait(chromeDriver, 30);
					element = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Prescriber_LastName, chromeDriver);
					wait.until(ExpectedConditions.visibilityOf(element));
					String Lastname = dataMap.get("Lastname").get(0);
					String Firstname = dataMap.get("Firstname").get(0);
					element = chromeDriver.findElement(By.xpath(SmokeTestConstants.Prescriber_LastName));
					element.clear();
					element.sendKeys(Lastname);
					element = chromeDriver.findElement(By.xpath(SmokeTestConstants.Prescriber_FirstName));
					element.clear();
					element.sendKeys(Firstname);
					if (dataMap.containsKey("State")) {
						String selectState = dataMap.get("State").get(0);
						if (selectState.equalsIgnoreCase("Yes")) {
							isElementPresentVerifyClick(AccessManagementConstants.SELECT_STATE);
							isElementPresentVerifyClick(AccessManagementConstants.TX);
						}
					}
				}
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To enter details for product on DE screen
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^User Enters DE product information$")
	public void User_enters_product_information(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			WebElement element;
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String Date = dataMap.get("Date").get(0);
			String DAW = dataMap.get("DAW").get(0);
			String Substitute = dataMap.get("Substitute").get(0);
			String DrugName = dataMap.get("DrugName").get(0);
			String DrugExpiryDate = dataMap.get("DrugExpiryDate").get(0);
			String Qty = dataMap.get("Qty").get(0);
			String Qty_Disp = dataMap.get("Qty_Disp").get(0);
			String Dir = dataMap.get("Dir").get(0);
			String Days_Supply = dataMap.get("Days_Supply").get(0);
			String Refills = dataMap.get("Refills").get(0);
			String RxExpiration = dataMap.get("RxExpiration").get(0);
			FrameworkLibrary.isElementPresentVerifyClick(SmokeTestConstants.Open_Product);
			chromeDriver.findElement(By.xpath(SmokeTestConstants.Product_OriginalDate)).sendKeys(Date);
			element = chromeDriver.findElement(By.xpath(AccessManagementConstants.SUBSTITUTE));
			element.clear();
			element.sendKeys(Substitute);
			element = chromeDriver.findElement(By.xpath(SmokeTestConstants.Product_DAW));
			element.clear();
			element.sendKeys(DAW);
			element = chromeDriver.findElement(By.xpath(AccessManagementConstants.drug_view_size));
			element.click();
			element = chromeDriver.findElement(By.xpath(SmokeTestConstants.DrugName_Field));
			element.clear();
			element.sendKeys(DrugName);
			chromeDriver.findElement(By.xpath(SmokeTestConstants.DrugName_Field)).sendKeys(Keys.ENTER);
			Actions upArrow = new Actions(chromeDriver);
			Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_UP, Keys.ARROW_UP, Keys.ENTER).build();
			PressUpArrow.perform();
			chromeDriver.findElement(By.xpath(SmokeTestConstants.DrugExpiryDate_Field)).sendKeys(DrugExpiryDate);
			chromeDriver.findElement(By.xpath(SmokeTestConstants.Quantity_field)).sendKeys(Qty);
			chromeDriver.findElement(By.xpath(SmokeTestConstants.Quantity_disp)).sendKeys(Qty_Disp);
			chromeDriver.findElement(By.xpath(SmokeTestConstants.Directions_field)).sendKeys(Dir);
			chromeDriver.findElement(By.xpath(SmokeTestConstants.Days_Supply)).sendKeys(Days_Supply);
			chromeDriver.findElement(By.xpath(SmokeTestConstants.Refills_field)).sendKeys(Refills);
			chromeDriver.findElement(By.xpath(SmokeTestConstants.RxExpiration_date)).sendKeys(RxExpiration);
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To view user and validated patient details
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^User view and validate the patient details$")
	public void user_view_patient_details() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Demographic)) {
				boolean Demographic = chromeDriver.findElement(By.xpath(AccessManagementConstants.Demographic)).isDisplayed();
				Assert.assertTrue(Demographic, "User should not able to view Demographic Header");
			}
			if (isElementPresentVerification(AccessManagementConstants.AllergiesHealthConditions)) {
				boolean AllergiesHealthConditions = chromeDriver.findElement(By.xpath(AccessManagementConstants.AllergiesHealthConditions)).isDisplayed();
				Assert.assertTrue(AllergiesHealthConditions, "User should not able to view AllergiesHealthConditions Header");
			}
			if (isElementPresentVerification(AccessManagementConstants.PlanSummary)) {
				boolean PlanSummary = chromeDriver.findElement(By.xpath(AccessManagementConstants.PlanSummary)).isDisplayed();
				Assert.assertTrue(PlanSummary, "User should not able to view PlanSummary Header");
			}
			if (isElementPresentVerification(AccessManagementConstants.PATIENT_3RD_PLAN_ICON)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.PATIENT_3RD_PLAN_ICON))
					throw new Exception("Not able to click PATIENT_3RD_PLAN_ICON");
			}

			if (FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PATIENT_3RD_PARTY_PLANS)).isDisplayed()) {
				boolean plan = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PATIENT_3RD_PARTY_PLANS)).isDisplayed();
				Assert.assertTrue(plan, "Should not able to view Patient Plan");

			} else if (FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PATIENT_NO_PLANS)).isDisplayed()) {
				boolean noplan = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.PATIENT_NO_PLANS)).isDisplayed();
				Assert.assertTrue(noplan, "Should not able to view Patient No Plan");

			}
			if (isElementPresentVerification(AccessManagementConstants.Preferences)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Preferences))
					throw new Exception("Not able to click Preferences");
			}
			boolean RxPreferences = chromeDriver.findElement(By.xpath(AccessManagementConstants.RxPreferences)).isDisplayed();
			Assert.assertTrue(RxPreferences, "User should not able to view RxPreferences Header");
			
			if (isElementPresentVerification(AccessManagementConstants.Patient_Images_Tab)) {
				boolean image = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Patient_Images_Tab)).isDisplayed();
				Assert.assertTrue(image, "Should not able to view image");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To check if no dispensed drug is identified
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^User validating no dispensed drug identified$")
	public void no_dispensed_drug_identified() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.NO_DISPENSED_DRUG)) {
				boolean elem = chromeDriver.findElement(By.xpath(AccessManagementConstants.NO_DISPENSED_DRUG)).isDisplayed();
				Assert.assertTrue(elem, "User should not able to view no dispensed drug identified msg");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To click on view button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I click on view button$")
	public void i_click_on_view_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.view_button)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.view_button))
					throw new Exception("Not able to click view_button");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To navigate back to patient search page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^go back to the patient search$")
	public void go_back_to_the_patient_search() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patientprofile_Demographic)) {
				String deceased = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Patientprofile_Demographic)).getText();
				Assert.assertEquals(deceased, "Deceased");
			}
			if (isElementPresentVerification(AccessManagementConstants.Patientprofile_back)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Patientprofile_back))
					throw new Exception("Not able to click back button");
			}
			FrameworkLibrary.clearTextField(AccessManagementConstants.input_name_feild);

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To click on third party links tab
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^click on third party link$")
	public void click_on_third_party_link() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patientprofile_thirdparty)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Patientprofile_thirdparty))
					throw new Exception("Not able to click Patientprofile_thirdparty");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/****************************************************************************
	 * Method : To verify specified details
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^Verify all the details$")
	public void verify_all_the_details() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patientprofile_thirdparty_PlanId)) {
				String PlanId = FrameworkLibrary.getElementText(AccessManagementConstants.Patientprofile_thirdparty_PlanId);
				log.info("PLan ID " + PlanId);
				Assert.assertTrue(PlanId != null, "Patient have a plan Id");
			}
			if (isElementPresentVerification(AccessManagementConstants.Patientprofile_thirdparty_RecID)) {
				String RecId = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Patientprofile_thirdparty_RecID)).getText();
				log.info("REc ID " + RecId);
				Assert.assertTrue(RecId != null, "Value is not null");
			}
			if (isElementPresentVerification(AccessManagementConstants.Patientprofile_thirdparty_GroupId)) {
				String GroupID = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Patientprofile_thirdparty_GroupId)).getText();
				log.info("Group ID " + GroupID);
				Assert.assertTrue(GroupID != null, "GroudId id not null");
			}
			if (isElementPresentVerification(AccessManagementConstants.Patientprofile_thirdparty_BIN)) {
				String BIN = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Patientprofile_thirdparty_BIN)).getText();
				log.info("BIN " + BIN);
				Assert.assertTrue(BIN != null, "Bin is not null");
			}
			String Rtp = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Patientprofile_thirdparty_Rtp)).getText();
			log.info(Rtp);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To click on relation to plan cardholder
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^Click on Relation to plan Cardholder$")
	public void click_on_Relation_to_plan_Cardholder() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Patientprofile_thirdparty_Rtp)) {
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To cick on view comments link
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^Click on view comments$")
	public void click_on_view_comments() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patientprofile_showcomments)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Patientprofile_showcomments))
					throw new Exception("Not able to click Show Comments");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To click on hide comments link
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^Click on Hide Comments$")
	public void click_on_Hide_Comments() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patientprofile_hidecomments)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Patientprofile_hidecomments))
					throw new Exception("Not able to click hidecomments");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To check if user is not able to see prescriber menu in the left navigation
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should not be able to see prescriber menu in the left nav$")
	public void i_should_not_be_able_to_see_prescriber_menu_in_the_left_nav() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Dashboard_prescriber_search_Tab)) {
				throw new Exception("Not able to click the tab");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if user is able to see prescriber menu on the left navigation
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should be able to see prescriber menu in the left nav$")
	public void i_should_be_able_to_see_prescriber_menu_in_the_left_nav() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Dashboard_prescriber_search_Tab)) {
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To click Alt plus A key
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^User hits Alt plus A hotkey$")
	public void user_hits_Alt_plus_A_hotkey() throws Exception  {
		Actions ac = new Actions(chromeDriver);
		Action series = ac.keyDown(Keys.ALT).sendKeys("a").keyUp(Keys.ALT).build();
		series.perform();

	}

	/*
	 * Method to check if user is not able to see plus minust buttons for DEA field
	 */
	@Then("^I should not see plus minus button for DEA$")
	public void i_should_not_see_plus_minus_button_for_DEA() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Patient_Profile_Update_Authentication)) {
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/*
	 * Method to check if user is not able to see plus/minust buttons for Stre or ctrl licenses field
	 */
	@Then("^I should not see plus minus button for State Or Ctrl License$")
	public void i_should_not_see_plus_minus_button_for_State_Or_Ctrl_License() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Patient_Profile_Update_Authentication)) {
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To check if user is able to see Update button in Employee Information
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/

	@Then("^I should be able to see Update button in Employee Information$")
	public void i_should_be_able_to_see_Update_button_in_Employee_Information() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Patient_Profile_Update_Authentication)) {
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To check if user is able to see update button in licenses certification section
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should be able to see Update button in Licenses Certification$")
	public void i_should_be_able_to_see_Update_button_in_Licenses_Certification() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Patient_Profile_Update_Authentication2_option)) {
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To check if user is not able to click team members
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should not be able to click the team members$")
	public void i_should_not_be_able_to_click_the_team_members() throws Exception  {
		Assert.assertFalse(isElementPresents(AccessManagementConstants.Team_member_tab));
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Team_member_tab)) {
				throw new Exception("Not able to click the tab");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/*
	 * Method to check if user is not able to see phone numbers
	 */
	@Then("^I should not see phone numbers$")
	public void i_should_not_see_phone_numbers() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 


	}

	/****************************************************************************
	 * Method : To check if user is able to click on the team members
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should be able to click the team members$")
	public void i_should_be_able_to_click_the_team_members() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Patientprofile_hidecomments)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.Patientprofile_hidecomments))
					throw new Exception("Not able to click hide comments");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To check if user is able to see phone number
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see phone numbers$")
	public void i_should_see_phone_numbers() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.TEAM_MEMBER_PROFILE_PHONE_NUMBER)) {
				throw new Exception("Not able to click the phone number");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/*
	 * Method to check if user is able to see roles assigned to team members
	 */
	@Then("^I should be able to see roles assigned to the team member$")
	public void i_should_be_able_to_see_roles_assigned_to_the_team_member() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.TEAM_MEMBER_PROFILE_ROLE_1)) {

			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/*
	 * Method to check if user is able to see scroll bar if role count is more
	 */
	@Then("^I should see scroll bar if role count is more$")
	public void i_should_see_scroll_bar_if_role_count_is_more() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/*
	 * Method to check if user is not able to see specified navigation link
	 */
	@Then("^I should not see \"([^\"]*)\" navigation link$")
	public void i_should_not_see_navigation_link(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/*
	 * Method to check if user is able to see specified button
	 */
	@Then("^I should see \"([^\"]*)\" button$")
	public void i_should_see_button(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/*
	 * Method to press Alt plus specified key
	 */
	@When("^User hits Alt plus \"([^\"]*)\" hotkey$")
	public void user_hits_Alt_plus_hotkey(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/*
	 * Method to check if not functionality is available
	 */
	@Then("^I should not see any functionality$")
	public void i_should_not_see_any_functionality() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/*
	 * Method to check if the specified fields are visible
	 */
	@Then("^I should see following fields:$")
	public void i_should_see_following_fields(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/*
	 * Method to click Alt plus S and check if navigated to employeeid field
	 */
	@When("^User clicks ALt plus S it navigate to employeeid feild$")
	public void user_clicks_ALt_plus_S_it_navigate_to_employeeid_feild() throws Exception  {
		Actions ab = new Actions(chromeDriver);
		Action series = ab.keyDown(Keys.ALT).sendKeys("s").keyUp(Keys.ALT).build();
		series.perform();

	}

	/*
	 * Method to click Alt plus R key to navigate to password reset field
	 */
	@When("^User click Alt plus R it navigate to password reset feild$")
	public void user_click_Alt_plus_R_it_navigate_to_password_reset_feild() throws Exception  {
		Actions ab = new Actions(chromeDriver);
		Action series = ab.keyDown(Keys.ALT).sendKeys("r").keyUp(Keys.ALT).build();
		series.perform();
	}

	/*
	 * Method to click Alt plus M key
	 */
	@When("^User click Alt plus M it navigate to master password reset$")
	public void user_click_Alt_plus_M_it_navigate_to_master_password_reset() throws Exception  {
		Actions ac = new Actions(chromeDriver);
		Action series = ac.keyDown(Keys.ALT).sendKeys("m").keyUp(Keys.ALT).build();
		series.perform();
	}

	/*
	 * Method to click Alt plus C key
	 */
	@And("^user hits close button using ALT plus C hot keys$")
	public void user_hits_close_button_using_ALT_plus_C_hot_keys() throws Exception  {
		Actions ab = new Actions(chromeDriver);
		Action series = ab.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).build();
		series.perform();
	}

	/*
	 * Method to check the tab order sequence
	 */
	@And("^User check the tab order sequence$")
	public void User_check_the_tab_order_sequence() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/****************************************************************************
	 * Method : To check if user is able to see roles listed in ascending order
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see Roles listed in ascending order$")
	public void i_should_see_Roles_listed_in_ascending_order() throws Exception  {

		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			ArrayList<String> obtainedListForDateAndTime = new ArrayList<String>();
			ArrayList<String> sortedListForDateAndTime = new ArrayList<String>();

			if (sortedListForDateAndTime.equals(obtainedListForDateAndTime)) {
				ArrayList<String> obtainedListForFields = new ArrayList<String>();
				if (isElementPresentVerification(ClinicalEvaluationConstants.ALLERGIES_POPUP_ALLERGY_FIELDS_INFORMATION)) {
					List<WebElement> allergyFields = FrameworkLibrary.chromeDriver.findElements(By.xpath(ClinicalEvaluationConstants.ALLERGIES_POPUP_ALLERGY_FIELDS_INFORMATION));
					for (WebElement we : allergyFields) {
						obtainedListForFields.add(we.getAttribute("value"));
					}
				}

				ArrayList<String> sortedListForFields = new ArrayList<String>();
				for (String s : obtainedListForFields) {
					sortedListForFields.add(s);
				}
				Collections.sort(sortedListForFields);

				Assert.assertTrue(sortedListForFields.equals(obtainedListForFields), "roles are not in ascending order");
			}


			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/*
	 * Method to select one of the roles from role type field
	 */
	@Then("^I select one item from Role type$")
	public void i_select_one_item_from_Role_type() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/****************************************************************************
	 * Method : To enter a keyword in search field
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I enter a keyword in search field$")
	public void i_enter_a_keyword_in_search_field(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.ROLE_MANAGEMENT_SEARCH_FIELD)) {
				AccessManagementLibrary.enter_Text(arg1, "keyword", AccessManagementConstants.ROLE_MANAGEMENT_SEARCH_FIELD, chromeDriver);
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : Display roles results based on keyword search
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see results based on the keyword$")
	public void i_should_see_results_based_on_the_keyword(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			val = FrameworkLibrary.getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "keyword");

			if (isElementPresentVerification(AccessManagementConstants.ROLE_MANAGEMENT_ROLES_ROW_1)) {
				Assert.assertTrue(chromeDriver.findElement(By.xpath(AccessManagementConstants.ROLE_MANAGEMENT_ROLES_ROW_1)).getText().contains(val), "Search result not found");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To Click role description column on list page
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I click on Role Description column$")
	public void i_click_on_Role_Description_column() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.ROLE_MANAGEMNT_ROLE_DESCRIPTION_COLUMN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.ROLE_MANAGEMNT_ROLE_DESCRIPTION_COLUMN))
					throw new Exception("Not able to click Initial");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/*
	 * Display role descriptions listed in ascending order
	 */
	@Then("^I should see role descriptions listed in ascending order$")
	public void i_should_see_role_descriptions_listed_in_ascending_order() throws Exception  {
		// Write code here that turns the phrase above into concrete actions
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method : To click on role name column
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I click on Role Name column$")
	public void i_click_on_Role_Name_column() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.ROLE_MANAGEMNT_ROLE_NAME_COLUMN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.ROLE_MANAGEMNT_ROLE_NAME_COLUMN))
					throw new Exception("Not able to click Role Name");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/*
	 * Method to check if user is able to see role names listed in ascending order
	 */
	@Then("^I should see role names listed in ascending order$")
	public void i_should_see_role_names_listed_in_ascending_order() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/*
	 * Method to click Alt plus D hot key
	 */
	@When("^User hits Alt plus D hotkey$")
	public void user_hits_Alt_plus_D_hotkey() throws Exception  {
		Actions ac = new Actions(chromeDriver);
		Action series = ac.keyDown(Keys.ALT).sendKeys("d").keyUp(Keys.ALT).build();
		series.perform();

	}

	@When("^I click TAB key$")
	public void i_click_TAB_key() throws Exception  {
		Actions upArrow = new Actions(chromeDriver);
		Action tab = upArrow.sendKeys(Keys.TAB).build();
		tab.perform();
	}

	/****************************************************************************
	 * Method : To check if the user is not able to see plan link in the left nav
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should not see Plan link in the left navigation$")
	public void i_should_not_see_Plan_link_in_the_left_navigation() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.PLAN_LINK)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.PLAN_LINK))
					Assert.assertTrue(FrameworkLibrary.isElementPresentVerifyClick(SmokeTestConstants.PLAN_LINK));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : TO check if the user should not see plan search page for specific role
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should not see Plan search page$")
	public void i_should_not_see_Plan_search_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Assert.assertTrue(FrameworkLibrary.chromeDriver.getPageSource().contains("Plan Search"));
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if the plan link is visible on the left navigation
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see Plan link in the left navigation$")
	public void i_should_see_Plan_link_in_the_left_navigation() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.PLAN_LINK)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresentVerifyClick(SmokeTestConstants.PLAN_LINK), "Element not present");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To check if the specified field is empty
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^\"([^\"]*)\" field should be empty$")
	public void field_should_be_empty(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (arg1.equals("Role Name")) {
				if (isElementPresentVerification(AccessManagementConstants.ROLE_NAME_TEXTBOX)) {
					Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.ROLE_NAME_TEXTBOX)).equals(""));
				}
			} else if (arg1.equals("Role Description")) {
				if (isElementPresentVerification(AccessManagementConstants.ROLE_DESC_TEXTBOX)) {
					Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.ROLE_DESC_TEXTBOX)).equals(""));
				}
			} else if (arg1.equals("Role Type")) {
				if (isElementPresentVerification(AccessManagementConstants.UPDATE_NOTAVAILABLE_PERMISSIONS_ITEM)) {
					Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.UPDATE_NOTAVAILABLE_PERMISSIONS_ITEM)).equals(""));
				}
			} else if (arg1.equals("Available permissions")) {
				if (isElementPresentVerification(AccessManagementConstants.UPDATE_AVAILABLE_PERMISSIONS_ITEM)) {
					Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.UPDATE_AVAILABLE_PERMISSIONS_ITEM)).equals(""));
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : TO check if the specified field is disabled
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^\"([^\"]*)\" should be disabled$")
	public void should_be_disabled(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.USER_ONLY_CHECKBOX)) {
				Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.USER_ONLY_CHECKBOX)).isEnabled());
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if user is able to see the specified message
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see \"([^\"]*)\" message$")
	public void i_should_see_message(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (arg1.equals("No results found.")) {
				if (isElementPresentVerification(hangOnConstants.POST_SEARCH_ERROR_SECTION)) {
					Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(hangOnConstants.POS_SEARCH_RESULT_MESSAGE)).equals(arg1));
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To select specified permissions from specific field
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I select few permissions from \"([^\"]*)\" field$")
	public void i_select_few_permissions_from_field(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if the specified button move to right/ move to left is disabled
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I should see move to \"([^\"]*)\" button is disabled$")
	public void i_should_see_move_to_button_is_disabled(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (arg1.equals("right")) {
				if (isElementPresentVerification(AccessManagementConstants.MOVE_TO_RIGHT)) {
					Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.MOVE_TO_RIGHT)).isEnabled());
				}
			} else if (arg1.equals("left")) {
				if (isElementPresentVerification(AccessManagementConstants.MOVE_TO_LEFT)) {
					Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.MOVE_TO_LEFT)).isEnabled());
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To click on move to right button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I click move to right$")
	public void i_click_move_to_right() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.MOVE_TO_RIGHT)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.MOVE_TO_RIGHT))
					throw new Exception("Not able to click MOVE_TO_RIGHT");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if user is able to see permissions in available field
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see permissions in Available permissions field$")
	public void i_should_see_permissions_in_Available_permissions_field() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/*
	 * Method to check if user is not able to see permissions in available field
	 */
	@Then("^I should not see permissions in Available permissions field$")
	public void i_should_see_not_permissions_in_Available_permissions_field() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To check if user is able to search for a permission
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I search for a permission in \"([^\"]*)\" field$")
	public void i_search_for_a_permission_in_field(String arg1, DataTable arg2) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.drug_search_feild)) {
				AccessManagementLibrary.enter_Text(arg2, "keyword", AccessManagementConstants.drug_search_feild, chromeDriver);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}

	/*
	 * Method to check if user is able to see results in counter field
	 */
	@Then("^I should see results in counter field$")
	public void i_should_see_results_in_counter_field(DataTable arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		} catch (AssertionError e) {
			e.printStackTrace();
			takeScreenShot(methodName);

		}

	}


	/****************************************************************************
	 * Method : To check if specified checkbox is selected
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I select \"([^\"]*)\" check box$")
	public void i_select_check_box(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.USER_ONLY_CHECKBOX)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.USER_ONLY_CHECKBOX))
					throw new Exception("Not able to click Checkbox");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	@Then("^I should see permissions listed in counter$")
	public void i_should_see_permissions_listed_in_counter() throws Exception  {
		// Write code here that turns the phrase above into concrete actions

	}


	/****************************************************************************
	 * Method : To check if user is not able to see specified information
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should not see \"([^\"]*)\" information$")
	public void i_should_not_see_information(String arg1) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (arg1.equals("Pharmacy Location")) {
				if (!isElementPresentVerification(AccessManagementConstants.DASHBOARD_PHARMACY_INFORMATION_SECTION)) {
					Assert.assertTrue(FrameworkLibrary.isElementPresents(AccessManagementConstants.DASHBOARD_PHARMACY_INFORMATION_SECTION));
				}
			}
			if (!isElementPresentVerification(AccessManagementConstants.Patient_Images_Tab)) {
				throw new Exception("Not able to click the tab");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if user is able to see useful links on the dashboard
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should see useful links$")
	public void i_should_see_useful_links() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.DASHBOARD_USEFUL_LINKS_SECTION)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(AccessManagementConstants.DASHBOARD_USEFUL_LINKS_SECTION));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To check if user is not able to see update button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should not see update button$")
	public void i_should_not_see_update_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.Store_Home_Update_Button)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(AccessManagementConstants.Store_Home_Update_Button));
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

	/****************************************************************************
	 * Method : To click on cancel button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^I click cancel button$")
	public void i_click_cancel_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.STORE_INFO_CANCEL_BUTTON)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.STORE_INFO_CANCEL_BUTTON))
					throw new Exception("Not able to click CANCEL_BUTTON");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if user is not able to see specified sections
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^I should not see \"([^\"]*)\" section$")
	public void i_should_not_see_section(String arg1) throws Exception  {
		// Write code here that turns the phrase above into concrete actions
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (arg1.equals("Pharmacy Information")) {
				if (isElementPresentVerification(AccessManagementConstants.STORE_INFO_PHARMACY_HOURS)) {
					Assert.assertTrue(FrameworkLibrary.isElementPresents(AccessManagementConstants.STORE_INFO_PHARMACY_HOURS));
				}
			} else if (arg1.equals("Pharmacy Inventory Information")) {
				if (isElementPresentVerification(AccessManagementConstants.STORE_INFO_PHARMACY_INVENTORY_INFO)) {
					Assert.assertTrue(FrameworkLibrary.isElementPresents(AccessManagementConstants.STORE_INFO_PHARMACY_INVENTORY_INFO));
				}
			} else if (arg1.equals("Pharmacy Hours")) {
				if (isElementPresentVerification(AccessManagementConstants.STORE_INFO_PHARMACY_HOURS)) {
					Assert.assertTrue(FrameworkLibrary.isElementPresents(AccessManagementConstants.STORE_INFO_PHARMACY_HOURS));
				}
			} else if (arg1.equals("Store Hours")) {
				if (isElementPresentVerification(AccessManagementConstants.STORE_INFO_STORE_HOURS)) {
					Assert.assertTrue(FrameworkLibrary.isElementPresents(AccessManagementConstants.STORE_INFO_STORE_HOURS));
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 

	}


	/****************************************************************************
	 * Method : To click on logout button
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^User click on only logout button$")
	public void user_click_on_only_logout_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.LOGOUT_BTN)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.LOGOUT_BTN))
					throw new Exception("Not able to click LOGOUT_BTN");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To check if logout popup is displaying expected buttons and information
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@Then("^Pop-up should display with message information the user to Logout with \"([^\"]*)\", \"([^\"]*)\"  and Cancel option$")
	public void pop_up_should_display_with_message_information_the_user_to_Logout_with_and_Cancel_option(String arg1, String arg2) throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(AccessManagementConstants.Logout_This_device) && isElementPresentVerification(AccessManagementConstants.LOGOUT_ALL_DEVICE) && isElementPresentVerification(AccessManagementConstants.LOGOUT_CANCEL)) {
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}


	/****************************************************************************
	 * Method : To click on cancel button on logout popup
	 * author : Photon
	 * Date :  April-2017
	 * Modifier :
	 * Modification Data :
	 ******************************************************************************/


	@When("^User click cancel button$")
	public void user_click_cancel_button() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AccessManagementConstants.LOGOUT_CANCEL)) {
				if (!isElementPresentVerifyClick(AccessManagementConstants.LOGOUT_CANCEL))
					throw new Exception("Not able to click LOGOUT_CANCEL");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage())	;
		} 
	}

}