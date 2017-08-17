package assembly;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.FrameworkLibrary;
import intake.IntakeConstants;
import io.appium.java_client.android.AndroidKeyCode;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AssemblyStepDef extends FrameworkLibrary {

	private static Log log = LogFactory.getLog(AssemblyStepDef.class);
	public static String lastName;
	public static String firstName;
	public static String patientDOB;
	private static String methodName;
	private static String ndcNumber;

	public AssemblyStepDef() throws ConfigurationException, IOException {
		super();
	}


	/**
	 * Method- To enter Invalid user Name in User Name Text field
	 *
	 */

	@When("^User Enter Wrong userName in UserName text field$")
	public void user_Enter_Wrong_userName_in_UserName_text_field() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.USER_NAME)) {
				if (!clearAndEnterTextForAndroid(AssemblyConstants.USER_NAME, "LOGIN"))
					throw new Exception("Unable to enter in User Name Text Field");
			}
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Validate error message The User name and Password combination does not match
	 *
	 */

	@Then("^System displays error msg The Username Password combination does not match$")
	public void system_displays_error_msg_The_Username_Password_combination_does_not_match() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (isElementPresentVerificationAndroid(AssemblyConstants.Invalid_UserPassword_Text_Msg)) {
				verifyTextPresentAndroid(AssemblyConstants.Invalid_UserPassword_Text_Msg, "The Username / Password combination does not match.");
				throw new Exception("Expected text didn't matched");
			}
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		}catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Enter Wrong Password in Password text field
	 *
	 */

	@When("^User Enter Wrong Password in Password text field$")
	public void user_Enter_Wrong_Password_in_Password_text_field() throws Exception   {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.USER_NAME)) {
				if (!clearAndEnterTextForAndroid(AssemblyConstants.PASSWORD, "changeme"))
					throw new Exception("Unable to enter in Password Text Field");
			}
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Enter User Name in User Name text field
	 *
	 */

	@When("^User Enter userName in UserName text field$")
	public void user_Enter_userName_in_UserName_text_field()  throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.USER_NAME)) {
				if (!clearAndEnterTextForAndroid(AssemblyConstants.USER_NAME, "SIT_PH44"))
					throw new Exception("Unable to enter in User Name Text Field");
			}
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Enter Password in Password text field
	 *
	 */

	@When("^User Enter Password in Password text field$")
	public void user_Enter_Password_in_Password_text_field() throws Exception   {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.PASSWORD)) {
				if (!clearAndEnterTextForAndroid(AssemblyConstants.PASSWORD, "Changeme2"))
					throw new Exception("Unable to enter in Password Text Field");
			}
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify and click on Login button
	 *
	 */

	@When("^User click on Login Button$")
	public void user_click_on_Login_Button()  throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.LOGIN_BUTTON)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.LOGIN_BUTTON))
					throw new Exception("Unable to click on Login Button.");
			}
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Validate Hamburger menu is located
	 *
	 */

	@Then("^I see Hamburger menu is located$")
	public void i_see_Hamburger_menu_is_located()  throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (!isElementPresentAndroid(AssemblyConstants.Hamberger_Menu_WebView)) {
				throw new Exception("Element is not present");
			}

			/*if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Validate Fill text after login
	 *
	 */

	@Then("^I see Fill text after login$")
	public void i_see_Fill_text_after_login() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (!isElementPresentAndroid(AssemblyConstants.Fill_Text_WebView)) {
				throw new Exception("Element is not present");
			}

			/*if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Validate see All caught up when we have no other prescriptions to fill is present
	 *
	 */

	@Then("^I see All caught up you have no other prescriptions to fill is present$")
	public void i_see_All_caught_up_you_have_no_other_prescriptions_to_fill_is_present() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (!isElementPresentAndroid(AssemblyConstants.Fill_Text_WebView) && !isElementPresentAndroid(AssemblyConstants.You_have_No_OtherText_WebView) && !isElementPresentAndroid(AssemblyConstants.Prescription_toFill_Text_WebView)) {
				throw new Exception("Element is not present");
			}

			/*if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Verify and click on Hamburger menu link
	 *
	 */

	@When("^I click on Hamburger menu link$")
	public void i_click_on_Hamburger_menu_link()  throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.Hamberger_Menu_WebView)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.Hamberger_Menu_WebView))
					throw new Exception("Unable to click on Hamburger menu link.");
			}
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Validate Logout button is present
	 *
	 */

	@Then("^I see Logout button$")
	public void i_see_Logout_button()  throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (!isElementPresentAndroid(AssemblyConstants.Logout_Button)) {
				throw new Exception("Element is not present");
			}

			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Verify and click on Logout button 
	 *
	 */

	@When("^I click on Logout button$")
	public void i_click_on_Logout_button()  throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.Logout_Button)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.Logout_Button))
					throw new Exception("Unable to click on Logout Button.");
			}
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Validate message "All changes will be lost, Do you want to proceed
	 *
	 */

	@Then("^System displays following message All changes will be lost Do you want to proceed$")
	public void System_displays_following_message_All_changes_will_be_lost_Do_you_want_to_proceed()  throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (isElementPresentVerificationAndroid(AssemblyConstants.All_Change_Will_Lost_Text) && isElementPresentVerificationAndroid(AssemblyConstants.Do_You_WantToProceed_Text)) {
				verifyTextPresentAndroid(AssemblyConstants.All_Change_Will_Lost_Text, "All changes will be lost.");
				verifyTextPresentAndroid(AssemblyConstants.Do_You_WantToProceed_Text, "Do you want to proceed?");
				throw new Exception("Expected text didn't matched");
			}
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Validate Page redirect to the login home page
	 *
	 */

	@Then("^Page redirect to the login home page$")
	public void page_redirect_to_the_login_home_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			user_see_Login_page();
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Verify and click on confirm log out Yes button
	 *
	 */

	@When("^User click on confirm log out Yes button$")
	public void User_click_on_confirm_log_out_Yes_button()  throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.Logout_Yes_Button)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.Logout_Yes_Button))
					throw new Exception("Unable to click on confirm Logout yes Button.");
			}
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Validate available unreserved filling task is present
	 *
	 */

	@Then("^system displays the first available unreserved filling task to that user$")
	public void system_displays_the_first_available_unreserved_filling_task_to_that_user()  throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (!isElementPresentAndroid(AssemblyConstants.Drug_Information_Heading)) {
				throw new Exception("Element is not present");
			}
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Verify and Click on This Device Button
	 *
	 */

	@When("^User click on This Device$")
	public void user_click_on_This_Device()  throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.Logout_This_Device)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.Logout_This_Device))
					throw new Exception("Unable to click on This Device Button.");
			}
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Validate Login page display
	 *
	 */

	@Then("^User see Login page$")
	public void user_see_Login_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (!isElementPresentAndroid(AssemblyConstants.Login_Text)) {
				throw new Exception("Element is not present");
			}

			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Validate Drug Information page
	 *
	 */

	@Then("^I should see the Drug Information page$")
	public void i_should_see_the_Drug_Information_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentAndroid(AssemblyConstants.Drug_Information_Heading)) {
				throw new Exception("Element is not present");
			}
			/*if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}

	}
	

	/**
	 * Method- Verify and click on Yes button on Drug Information page
	 *
	 */

	@When("^User clicks Yes button on Drug Information page$")
	public void user_clicks_Yes_button_on_Drug_Information_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			ndcNumber=getNDCNumber(AssemblyConstants.ASSEMBLY_NDC_NO);
			log.info("Global ndc Number is " + ndcNumber);
			if (isElementPresentVerificationAndroid(AssemblyConstants.Yes_Button)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.Yes_Button)) {
					throw new Exception("Unable to click on Yes Button.");
				}
			}
			/*if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Verify and enter the UPC number in UPC Number edit field
	 *
	 */

	@When("^User enter the UPC number in UPC Number edit field$")
	public void user_enter_the_UPC_number_in_UPC_Number_edit_field(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			String upcNumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "UPCNumber");
			if(isElementPresentVerificationAndroid(AssemblyConstants.UPC_Number_TextField)){
				if(!clearAndEnterTextForAndroid(AssemblyConstants.UPC_Number_TextField,upcNumber)){
					throw new Exception("Not able to enter value UPC text field");
				}
			}
			/*if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}

	}
	
	@When("^User enter the NDC number dynamically in NDC Number edit field$")
	public void user_enter_the_NDC_number_dynamically_in_NDC_Number_edit_field() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			//ndcNumber=getNDCNumber();
			System.out.println("Final Global ndc Number is " + ndcNumber);
			if(isElementPresentVerificationAndroid(AssemblyConstants.NDC_Number_TextField)){
				if(!clearAndEnterTextForAndroid(AssemblyConstants.NDC_Number_TextField,ndcNumber)){
					throw new Exception("Not able to enter value in NDC text field");
				}
			}
			/*if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * Method- Verify and click on Next button on Enter Drug Identifier page
	 *
	 */

	@When("^I click on Next button on Enter Drug Identifier page$")
	public void i_click_on_Next_button_on_Enter_Drug_Identifier_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.Next_Button)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.Next_Button)) {
					throw new Exception("Unable to click on Next Button.");
				}
			}
			/*if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Validate Reason for Manual Entry screen
	 *
	 */

	@Then("^I should see Reason for Manual Entry screen$")
	public void i_should_see_Reason_for_Manual_Entry_screen() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentAndroid(AssemblyConstants.reasonformanualentryQuestion)) {
				throw new Exception("Element is not present");
			}
			/*if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Validate Next Button is present
	 *
	 */

	@Then("^I should see the Next button on Reason for Manual Entry Page$")
	public void i_should_see_the_Next_button_on_Reason_for_Manual_Entry_Page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentAndroid(AssemblyConstants.manual_entry_screen_next_btn)) {
				throw new Exception("Element is not present");
			}
			/*if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify and click on Next Button
	 *
	 */

	@When("^I click on Next button on Reason for Manual Entry Page$")
	public void i_click_on_Next_button_on_Reason_for_Manual_Entry_Page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.Next_Button_Below_BarCode_WillNotScan_Radio)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.Next_Button_Below_BarCode_WillNotScan_Radio)) {
					throw new Exception("Unable to click on Next button on Reason for Manual Entry Page");
				}
			}
			/*if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify Confirm Quantity page displayed
	 *
	 */

	@Then("^I should see Confirm Quantity page$")
	public void i_should_see_Confirm_Quantity_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentAndroid(AssemblyConstants.confirmQuantityTitle)) {
				throw new Exception("Element is not present");
			}
			/*if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify and click Yes button on Confirm Quantity page
	 *
	 */

	@When("^I click on Yes button on Confirm Quantity page$")
	public void i_click_on_Yes_button_on_Confirm_Quantity_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.Yes_Button_Confirm_Quantity)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.Yes_Button_Confirm_Quantity)) {
					throw new Exception("Unable to click on Yes button on Confirm Quantity page");
				}
			}
			/*if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify and click on FillNextRx button
	 *
	 */

	@When("^I click on FillNextRx button$")
	public void i_click_on_FillNextRx_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			proxy.newHar();
			if (isElementPresentVerificationAndroid(AssemblyConstants.Fill_Next_Rx_Button)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.Fill_Next_Rx_Button)) {
					throw new Exception("Unable to click on FillNextRx button");
				}
				waitForVisibilityAndroid(AssemblyConstants.refresh_button);
				writeHarFile(workingFolder, "Fill_Print", row.getRowNum(), 17);
			}
			/*if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Validate Refresh button is present
	 *
	 */

	@Then("^I should see Initial Page screen again$")
	public void i_should_see_Initial_Page_screen_again() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentAndroid(AssemblyConstants.refresh_button)) {
				throw new Exception("Element is not present");
			}
			/*if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify drug information page
	 *
	 */

	@Then("^System should display drug information page$")
	public void validate_drug_info_page_displayed() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentAndroid(AssemblyConstants.Drug_Information_Heading)) {
				throw new Exception("Element is not present on drug information page");
			}
			if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Validate and enter login credential
	 *
	 */

	@When("^User logs in to the Fill appplication on android device$")
	public void launch_and_login_to_fill_App() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			FrameworkLibrary.initiateBrowser_Android();
			AssemblyLibrary.login_Assembly_Android();
			/*if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/**
	 * Method- Verify and click on No Button
	 *
	 */

	@When("^User clicks No button on durg information page$")
	public void click_no_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentAndroid(AssemblyConstants.No_Button)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.No_Button))
					throw new Exception("Unable to click on No Button");
			}
			if(captureScreenshot){
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify Alert Popup 
	 *
	 */

	@Then("^An alert message should be displayed - This function cannot be completed in ICplus$")
	public void validate_no_button_alert_device() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentAndroid(AssemblyConstants.NoStock_ICplusAlertOkButton)) {
				throw new Exception("Alert Message not displayed");
			}
			/*if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Selects Ok button on the partial fill error alert message
	 *
	 */

	@When("^User selects Ok on the partial fill error message$")
	public void click_ok_on_alert_device() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (isElementPresentAndroid(AssemblyConstants.NoStock_ICplusAlertOkButton)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.NoStock_ICplusAlertOkButton))
					throw new Exception("Unable to click on Partial error message OK popup");

			}
			/*if(captureScreenshot){
				takeScreenShot(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify Refresh button and Drug information Heading present
	 *
	 */

	@Then("System should display No Assemby tasks screen or drug information page of the next rx")
	public void system_should_display_no_tasks_page_or_drug_info_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentAndroid(AssemblyConstants.refresh_button) && !isElementPresentAndroid(AssemblyConstants.Drug_Information_Heading)) {
				throw new Exception("Unable to see Refresh and Drug information heading");
			}
			/*if(captureScreenshot){
				takeScreenShot(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify Scan Image is present
	 *
	 */

	@When("^System should display Scan Product page$")
	public void validate_scan_product_page_displayed() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentAndroid(AssemblyConstants.Scan_Image)) {
				throw new Exception("Element is not present");
			}
			/*if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Verify and click on Manually enter NDC radio button
	 *
	 */

	@Then("^User clicks Manually Enter NDC button on scan product page$")
	public void enter_ndc_manually() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.Manually_Inter_NDC)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.Manually_Inter_NDC)) {
					throw new Exception("Unable to click on Manually Enter NDC.");
				}
			}
			/*if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}*/
		}  catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify Drug Heading on Drug Identifier page
	 *
	 */

	@Then("^System should display Drug Identifier page$")
	public void validate_drug_identifier_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentAndroid(AssemblyConstants.Drug_Identifiere_Page_Heading)) {
				throw new Exception("Element is not present");
			}
			/*if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Enters the UPC number in UPC Number edit field
	 *
	 */

	@When("^User enters the UPC number in UPC Number edit field$")
	public void enter_upc_number() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.UPC_Number_TextField)) {
				if (!clearAndEnterTextForAndroid(AssemblyConstants.UPC_Number_TextField, "30032421001"))
					throw new Exception("Unable to enter in UDC no");
			}
			if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify NDC number field should be disabled 
	 *
	 */

	@When("^NDC number field should be greyed out$")
	public void ndc_field_should_be_greyed_out() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Assert.assertTrue(aDriver.findElement(By.xpath(AssemblyConstants.NDC_Number_TextField)).getAttribute("disabled").equalsIgnoreCase("true"));
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Enter the NDC number in NDC Number edit field
	 *
	 */

	@When("^User enters the NDC number in NDC Number edit field$")
	public void enter_ndc()  throws Exception{
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.UPC_Number_TextField)) {
				if (!clearAndEnterTextForAndroid(AssemblyConstants.UPC_Number_TextField, "30032421001"))
					throw new Exception("Unable to enter in UDC no");
			}
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify UPC number field should be disabled
	 *
	 */

	@Then("^UPC number field should be greyed out$")
	public void upc_field_disabled() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Assert.assertTrue(aDriver.findElement(By.xpath(AssemblyConstants.UPC_Number_TextField)).getAttribute("disabled").equalsIgnoreCase("true"));
			log.info("UDC number is Enabled");
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Enter incorrect NDC or UPC in drug identifier page
	 *
	 */

	@Then("^User enters incorrect NDC or UPC in drug identifier page$")
	public void incorrect_ndc_upc() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.UPC_Number_TextField)) {
				if (!clearAndEnterTextForAndroid(AssemblyConstants.UPC_Number_TextField, "23243435234"))
					throw new Exception("Unable to enter in UPC number");
			}
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Clicks on Back button 
	 *
	 */

	@When("^User clicks back button on android device$")
	public void click_back_button_in_device()  throws Exception {
		Thread.sleep(4000);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			aDriver.pressKeyCode(AndroidKeyCode.BACK);
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify and clicks next Button on enter drug identifier page
	 *
	 */

	@When("^User clicks next Button on enter drug identifier page$")
	public void click_next_on_drug_identifer_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.Next_Button)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.Next_Button)) {
					throw new Exception("Unable to click on Next Button on enter drug identifier page.");
				}
			}
			if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}
		}  catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify and click on BarCode will not scan Radio Button
	 *
	 */

	@When("^User selects one of the four reasons$")
	public void select_one_of_the_four_reasons() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.BarCode_WillNotScan_Radio)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.BarCode_WillNotScan_Radio)) {
					throw new Exception("Unable to click one of the four reasons");
				}
			}
			if(captureScreenshot){
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify Alert Message
	 *
	 */

	@Then("^System should display an error message - there was an error with the entered product identifier$")
	public void validate_incorrent_ndc_alert() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String alertmessage = aDriver.findElement(By.xpath(AssemblyConstants.incorrect_ndc_message)).getText();
			log.info("expected message on the alert is " + alertmessage);
			Assert.assertTrue(alertmessage.contains("There was an error with the NDC or UPC you entered"));
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify and clicks Try again Button on the incorrect product identifier error message
	 *
	 */

	@When("^User clicks Try again on the incorrect product identifier error message$")
	public void click_tryagain_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.incorrect_NDC_TryAgainBtn)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.incorrect_NDC_TryAgainBtn)) {
					throw new Exception("Unable to click one of the four reasons");
				}
			}
			if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify reason is present on manual entry screen
	 *
	 */

	@Then("^System should display reason for manual entry screen$")
	public void validateReasonScreen() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentAndroid(AssemblyConstants.reasonformanualentryQuestion)) {
				throw new Exception("Unable to click one of the four reasons");
			}
			/*if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify following four reason codes is present as radio buttons
	 *
	 */

	@Then("^System should display following four reason codes as radio buttons$")
	public void validate_reason_code(List<String> reasoncodes)  throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			for (int i = 0; i < reasoncodes.size(); i++) {
				Assert.assertTrue(aDriver.getPageSource().contains(
						reasoncodes.get(i)));
			}
			/*if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}*/
		}catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Verify and clicks next button on reason for manual entry screen
	 *
	 */

	@When("^User clicks next button on reason for manual entry screen$")
	public void click_next_Btn_on_manual_entry_screen() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.manual_entry_screen_next_btn)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.manual_entry_screen_next_btn)) {
					throw new Exception("Unable to clicks next button on reason for manual entry screen");
				}
			}
			/*if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}*/
		}  catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify confirm quantity page is present
	 *
	 */

	@Then("^System should display confirm quantity page$")
	public void validate_confirm_quantity_page_displayed() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentAndroid(AssemblyConstants.confirmQuantityTitle)) {
				throw new Exception("Element is not present");
			}
			/*if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify and clicks No button on confirm quantity page
	 *
	 */

	@When("^User clicks No button on confirm quantity page$")
	public void click_no_Btn() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.confirmQuantityNoBtn)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.confirmQuantityNoBtn)) {
					throw new Exception("Unable to clicks No button on confirm quantity page");
				}
			}
			/*if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}*/
		}  catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify next button should be disabled on reason for manual entry page
	 *
	 */

	@Then("^next button should be disabled on reason for manual entry page$")
	public void validate_next_Btn_disabled() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			boolean isNextBtnDisabled = !aDriver.findElement(
					By.xpath(AssemblyConstants.manual_entry_screen_next_btn))
					.isEnabled();
			Assert.assertTrue(isNextBtnDisabled);
			/*if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify and click additional reason on reason for manual entry screen
	 *
	 */

	@When("^User selects additional reason on reason for manual entry screen$")
	public void select_different_reason() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.reason_filledfromautomation)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.reason_filledfromautomation)) {
					throw new Exception("Unable to selects additional reason on reason for manual entry screen");
				}
			}
			/*if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}*/
		}catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify Radio Button enable the user to select only one reason at a time
	 *
	 */

	@When("^System should enable the user to select only one reason at a time$")
	public void validate_that_user_can_select_only_one_reason() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			isElementPresentVerificationAndroid(AssemblyConstants.BarCode_WillNotScan_Radio);
			isElementPresentVerificationAndroid(AssemblyConstants.reason_barcodemissing);
			isElementPresentVerificationAndroid(AssemblyConstants.reason_Stockbottlemissing);
			Assert.assertTrue(aDriver
					.findElement(
							By.xpath(AssemblyConstants.BarCode_WillNotScan_Radio))
					.getAttribute("aria-checked").equals("false"));
			Assert.assertTrue(aDriver
					.findElement(
							By.xpath(AssemblyConstants.reason_barcodemissing))
					.getAttribute("aria-checked").equals("false"));
			Assert.assertTrue(aDriver
					.findElement(
							By.xpath(AssemblyConstants.reason_Stockbottlemissing))
					.getAttribute("aria-checked").equals("false"));
			/*if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}*/
		}  catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify and clicks Yes button on confirm quantity page
	 *
	 */

	@When("^User clicks Yes button on confirm quantity page$")
	public void click_yes_button_on_confirm_quantity_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerificationAndroid(AssemblyConstants.confirmQuantityYesButton)) {
				if (!isElementVerifyclickAndroid(AssemblyConstants.confirmQuantityYesButton)) {
					throw new Exception("Unable to selects additional reason on reason for manual entry screen");
				}
			}
			/*if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}*/
		} catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify Packaging And Preferences Header is present
	 *
	 */

	@Then("^User should be navigated to packaging and preferences screen$")
	public void validate_packaging_and_preferences_page() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentAndroid(AssemblyConstants.Assembly_PackagingAndPreferencesHeader)) {
				throw new Exception("Element is not present");
			}
			/*if (captureScreenshot) {
				takeScreenShotAndroid(methodName);
			}*/
		}  catch (Exception e) {
			//takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify popup error message on POS after click on DeletRx In filling
	 *
	 */

	@Then("^System should diplay popup error message on POS after click on DeletRx In filling$")
	public void system_should_diplay_popup_error_message_on_POS_after_click_on_DeletRx_In_filling() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(AssemblyConstants.POS_Fill_PoupMsg1) && isElementPresentVerification(AssemblyConstants.POS_Fill_PoupMsg2)) {
				FrameworkLibrary.verifyTextPresentElectron(AssemblyConstants.POS_Fill_PoupMsg1, "Delete this prescription?");
				FrameworkLibrary.verifyTextPresentElectron(AssemblyConstants.POS_Fill_PoupMsg2, "Please retrieve the prescription and return to stock after deleting");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * Method- Verify focus is on the first item by default
	 *
	 */

	@Then("^focus is on the first item by default$")
	public void focus_is_on_the_first_item_by_default() throws Throwable {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		 
		try {
			if (isElementPresentVerification(IntakeConstants.FAILURE_NOTIFICATION_LINK)) {
				Boolean focusedLocation = chromeDriver.findElement(By.xpath(IntakeConstants.FAILURE_NOTIFICATION_LINK)).getAttribute("class").contains("md-focused");
				Assert.assertTrue(focusedLocation);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Verify and clicks on the Update Rx button
	 *
	 */

	@When("^User clicks on the Update Rx button$")
	public void user_clicks_on_the_Update_Rx_button() throws Throwable {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName(); 
		try {
			if (isElementPresentVerification(IntakeConstants.POS_UPDATE_RX_BUTTON)) {
				if (!isElementPresentVerifyClick(IntakeConstants.POS_UPDATE_RX_BUTTON)) {
					throw new Exception("Not able to click on Update Rx Button");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Verify Update Rx Title on Update Rx Page
	 *
	 */

	@Then("^the system should display Update Rx page$")
	public void the_system_should_display_Update_Rx_page() throws Throwable {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName(); 
		try {
			if (isElementPresentVerification(IntakeConstants.UPDATE_RX_TITLE)) {
				FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.UPDATE_RX_TITLE, IntakeConstants.UPDATE_RX_TITLE_VALUE);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/**
	 * Method- Verify and clicks on the Update button
	 *
	 */

	@When("^clicks on the Update button$")
	public void clicks_on_the_Update_button() throws Throwable {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName(); 
		try {
			if (isElementPresentVerification(IntakeConstants.UPDATERX_UPDATE_BUTTON)) {
				if (!isElementPresentVerifyClick(IntakeConstants.UPDATERX_UPDATE_BUTTON)) {
					throw new Exception("Not able to click on Update Button");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Verify failure error Popup alert message
	 *
	 */

	@When("^an error has encountered$")
	public void an_error_has_encountered() throws Throwable {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName(); 
		try {
			if (isElementPresentVerification(IntakeConstants.UPDATE_RX_POPUP_FAILURE_MESSAGE)) {
				FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.UPDATE_RX_POPUP_FAILURE_MESSAGE, IntakeConstants.UPDATE_RX_POPUP_FAILURE_MESSAGE_VALUE);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/**
	 * Method- Verify and click on the close popup error
	 *
	 */

	@When("^click on the close popup error$")
	public void click_on_the_close_popup_error() throws Throwable {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName(); 
		try {
			if (isElementPresentVerification(IntakeConstants.UPDATE_RX_POPUP_CLOSE_BUTTON)) {
				if (!isElementPresentVerifyClick(IntakeConstants.UPDATE_RX_POPUP_CLOSE_BUTTON)) {
					throw new Exception("Not able to click on close poup button");
				}
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Verify system should display the patient information that reflect the information at time of Updating the Rx
	 *
	 */

	@Then("^system should display the patient information that reflect the information at time of Updating the Rx$")
	public void system_should_display_the_patient_information_that_reflect_the_information_at_time_of_Updating_the_Rx(DataTable arg1) throws Throwable {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		try{
			lastName=getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
			firstName=getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
			patientDOB=getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DateOfBirth");
			String splitFullName  = lastName + " " +","+ firstName;		
			if(isElementPresentVerification(IntakeConstants.FAILURE_PREVIEW_FNAME_LAME)&&isElementPresentVerification(IntakeConstants.FAILURE_PREVIEW_DOB)){
				Assert.assertEquals(splitFullName.toUpperCase(),getElementText(IntakeConstants.FAILURE_PREVIEW_FNAME_LAME).toUpperCase());
				Assert.assertEquals(patientDOB,getElementText(IntakeConstants.FAILURE_PREVIEW_DOB));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}

		}catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Verify system should display Error Reason Update Rx Failed
	 *
	 */

	@Then("^system should display Error Reason Update Rx Failed$")
	public void system_should_display_Error_Reason_Update_Rx_Failed() throws Throwable {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName(); 
		try {
			if (isElementPresentVerification(IntakeConstants.FAILURE_PREVIEW_UPDATE_REASON)) {
				FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.FAILURE_PREVIEW_UPDATE_REASON, IntakeConstants.FAILURE_PREVIEW_UPDATE_REASON_VALUE);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	/**
	 * Method- Verify system should display Rx Number
	 *
	 */

	@Then("^system should display Rx Number$")
	public void system_should_display_Rx_Number() throws Throwable {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(IntakeConstants.FAILURE_PREVIEW_UPDATE_RX_NUMBER)) {
				throw new Exception("Unable to see Rx Number");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}  catch (Exception e) {
			takeScreenShotAndroid(methodName);
			throw new Exception(e.getMessage());
		} 
	}
}

