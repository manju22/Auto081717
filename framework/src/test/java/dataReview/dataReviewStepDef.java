package dataReview;

import accessManagment.AccessManagementConstants;
import accessManagment.AccessManagementLibrary;
import clinicalEvaluation.ClinicalEvaluationConstants;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataEntry.DataEntryConstants;
import framework.FrameworkConstants;
import framework.FrameworkLibrary;
import gherkin.formatter.model.DataTableRow;
import hangOn.hangOnConstants;
import intake.IntakeConstants;
import intake.IntakeLibrary;
import intake.IntakeStepDef;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import smokeTest.SmokeTestConstants;
import smokeTest.SmokeTestLibrary;
import smokeTest.SmokeTestStepDef;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class dataReviewStepDef extends FrameworkLibrary {

    public static String dynamicrxnum;
    private String methodName;
    private static Log log = LogFactory.getLog(dataReviewStepDef.class);

    public dataReviewStepDef() throws ConfigurationException, IOException {
        super();
    }

    /**
     * This method adds no of days(count) to the Original Date field in Update
     * product section in DR
     *
     * @param count no of days to be added i.e date when the drug becomes expired
     *              depending on the drug
     * @throws Exception If an exception occurs
     */

    public static String addsDaystoOriginDate(int count) throws Exception {
        String date = null;
        try {
            date = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Product_OriginalDate, chromeDriver)
                    .getAttribute("value");
            SimpleDateFormat date_format = new SimpleDateFormat("MM/dd/yyyy");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date_format.parse(date));
            cal.add(Calendar.DATE, count);
            date = date_format.format(cal.getTime());
        } catch (ParseException e) {

        }
        return date;
    }

    /**
     * This method will move focus to the element and click it.
     *
     * @param driver         contains data about webdriver.
     * @param elementToHover contains data about the element focus should move to.
     * @param elementToClick contains data about the element to be clicked after the focus.
     */
    public void HoverAndClick(WebDriver driver, String elementToHover, String elementToClick) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions action = new Actions(driver);
            action.moveToElement(chromeDriver.findElementByXPath(elementToHover))
                    .click(chromeDriver.findElementByXPath(elementToClick)).build().perform();
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**
     * This method will click on the element using Enter key on keyboard
     *
     * @param elementToSendEnterKeyAction contains information about the element
     */
    public void HitEnterKey(String elementToSendEnterKeyAction) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            chromeDriver.findElement(By.xpath(elementToSendEnterKeyAction)).sendKeys(Keys.ENTER);

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @When("^search DR patient$")
    public void search_DR_patient(DataTable dataTable) throws Exception {
        patientSearch(dataTable, 0);
    }

    @Then("^The new patient should be reflected in the DR screen$")
    public void The_new_patient_should_be_reflected_in_the_DR_screen() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            if (isElementPresentVerification(dataReviewConstants.patient_lastname_bar)) {
                getElementText(dataReviewConstants.patient_lastname_bar);
            }

            if (isElementPresentVerification(dataReviewConstants.patient_lastname_bar)) {
                getElementText(dataReviewConstants.patient_firstname_bar);
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
     *
	 * This method is to click the prescriber accept button in Data Review
	 */
    @When("^Validate patient data by clicking 1 Accept button$")
    public void validate_patient_data_by_clicking_1_Accept_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            Thread.sleep(500);
            waitToClick(dataReviewConstants.one_accept);
            isElementPresentVerifyClick(dataReviewConstants.one_accept);
            if (isElementPresentVerification(dataReviewConstants.patient_lastname_bar)) {
                getElementText(dataReviewConstants.patient_lastname_bar);
            }

            if (isElementPresentVerification(dataReviewConstants.patient_lastname_bar)) {
                getElementText(dataReviewConstants.patient_firstname_bar);
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^the 1 Accepted button should be green$")
    public void the_1_Accepted_button_should_be_green() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (!isElementPresentVerification(dataReviewConstants.one_accept_check)) {
                throw new Exception("unable to see one accept button");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^Change the existing prescriber to a new prescriber and save$")
    public void change_the_existing_prescriber_to_a_new_prescriber_and_save(DataTable dataTable) throws Exception {
        searchPrescribers(dataTable, 0);
    }

    @Then("^The new prescriber should be reflected in the DR screen$")
    public void the_new_prescriber_should_be_reflected_in_the_DR_screen() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            getElementText(dataReviewConstants.prescriber_lastname);
            if (!isElementPresentVerification(dataReviewConstants.prescriber_lastname)) {
                throw new Exception("unable to find the element");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^Validate prescriber data by clicking 2 Accept button$")
    public void validate_prescriber_data_by_clicking_2_Accept_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            waitToClick(dataReviewConstants.two_accept);
            isElementPresentVerifyClick(dataReviewConstants.two_accept);
            if (isElementPresentVerification(dataReviewConstants.two_accept)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.two_accept)) {
                    throw new Exception("unable to click on second accept");
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

    @Then("^the 2 Accepted button should be green$")
    public void the_2_Accepted_button_should_be_green() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (!isElementPresentVerification(dataReviewConstants.two_accept_check)) {
                throw new Exception("unable to click on second accept");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^Select Update in section 3 and make a modification to the product$")
    public void select_Update_in_section_3_and_make_a_modification_to_the_product(DataTable dataTable)
            throws Exception {
        enterProductDetails(dataTable, 0);

    }

    @Then("^Section 3 should reflect changes$")
    public void section_3_should_reflect_changes() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.product_info_form)) {
                getElementText(dataReviewConstants.product_info_form);
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^Validate product Data by clicking 3 Accept button$")
    public void validate_product_Data_by_clicking_3_Accept_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.three_accept)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.three_accept))
                    throw new Exception("unable to click on three accept");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^the 3 Accepted button should be green$")
    public void the_3_Accepted_button_should_be_green() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (!isElementPresentVerification(dataReviewConstants.three_accept_check)) {
                throw new Exception("unable to click on three accept");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @And("^click finish DR$")
    public void click_finish_DR() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.dr_finish)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.dr_finish)) {
                    throw new Exception("unable to click on dr finish");
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

    @Then("^Alert message should be displayed states that Vaildation is not done, please validate$")
    public void alert_message_should_be_displayed_states_that_Vaildation_is_not_done_please_validate()
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.DataReview_Error_Msg)) {
                FrameworkLibrary.verifyTextPresentElectron(dataReviewConstants.DataReview_Error_Msg,
                        "Validation has not been completed, please validate.");
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
     * This method is used to click on ICPlus button in Data Review
	 */
    @When("^User clicks send to ICplus Button on DR page$")
    public void User_clicks_send_to_ICplus_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.dr_send_to_ic)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.dr_send_to_ic))
                    throw new Exception("Not able to click on send to IC+ element");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^System must display a message that validation has not been completed$")
    public void system_must_display_a_message_that_validation_has_not_been_completed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            String expectedMessage = "Validation has not been completed, please validate.";
            if (isElementPresentVerification(SmokeTestConstants.DR_Validation_message)) {
                String actualMessage = FrameworkLibrary
                        .getElementByProperty(SmokeTestConstants.DR_Validation_message, chromeDriver).getText();
                Assert.assertEquals(actualMessage, expectedMessage);
                if (isElementPresentVerification(SmokeTestConstants.DR_ValidationPopupOkButton)) {
                    isElementPresentVerifyClick(SmokeTestConstants.DR_ValidationPopupOkButton);
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
     * This method is to update the product data with LDD drug
	 */
    @When("^User updates product data with LDD drug in data review$")
    public void enter_LDD_drug_in_DR(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            String drugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
            if (isElementPresentVerification(SmokeTestConstants.DR_ProductName)) {
                if (!clearAndEnterText(DataEntryConstants.DR_ProductName, drugName)) {
                    throw new Exception("User not able to enter drugname");
                }
                if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
                    Actions upArrow = new Actions(chromeDriver);
                    Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
                    PressUpArrow.perform();
                    Thread.sleep(1000);
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

    @When("^User enters sound alike during data review$")
    public void enter_sound_alike_drug_in_dr(DataTable arg1) throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            String drugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
            if (isElementPresentVerification(SmokeTestConstants.DR_ProductName)) {
                if (!clearAndEnterText(DataEntryConstants.DR_ProductName, drugName)) {
                    throw new Exception("User not able to enter drugname");
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
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^System should display a caution message$")
    public void caution_message_for_soundalike_drug() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(DataEntryConstants.soundAlikeDrugPopupOkButton)) {
                boolean ispopupdisplayed = isElementPresentVerification(DataEntryConstants.soundAlikeDrugPopupOkButton);
                Assert.assertTrue(ispopupdisplayed);
                if (!isElementPresentVerifyClick(DataEntryConstants.soundAlikeDrugPopupOkButton)) {
                    throw new Exception("not able to click on souund alike drug popup");
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

    @Then("^I am able to see following fields:$")
    public void i_am_able_to_see_following_fields(DataTable tableData) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            for (DataTableRow row : tableData.getGherkinRows()) {
                String option = row.getCells().get(0);
                String s = option.toLowerCase();
                if (s.equals("3rd Party Plans")) {
                    String third_party_Text = FrameworkLibrary.chromeDriver
                            .findElement(By.xpath(IntakeConstants.PATIENT_PROFILE_THIRD_PARTY_PLAN_TAB)).getText();
                    Assert.assertEquals(third_party_Text, option);

                } else if (s.equals("Preferences")) {
                    String preferences_Text = FrameworkLibrary.chromeDriver
                            .findElement(By.xpath(AccessManagementConstants.Patient_Preferences_Tab)).getText();
                    Assert.assertEquals(preferences_Text, option);

                } else if (s.equals("Images")) {
                    String Images_Text = FrameworkLibrary.chromeDriver
                            .findElement(By.xpath(IntakeConstants.PATIENT_PROFILE_IMAGE_TAB)).getText();
                    Assert.assertEquals(Images_Text, option);

                } else if (s.equals("Med History")) {
                    String med_History_Text = FrameworkLibrary.chromeDriver
                            .findElement(By.xpath(IntakeConstants.MED_HISTORY_TAB)).getText();
                    Assert.assertEquals(med_History_Text, option);

                } else if (s.equals("Clinical History")) {
                    String clinical_History_Text = FrameworkLibrary.chromeDriver
                            .findElement(By.xpath(IntakeConstants.PATIENT_PROFILE_CLINICAL_HISTORY)).getText();
                    Assert.assertEquals(clinical_History_Text, option);

                } else if (s.equals("General Info")) {
                    String general_Info_Text = FrameworkLibrary.chromeDriver
                            .findElement(By.xpath(IntakeConstants.Patient_profile_general_info)).getText();
                    Assert.assertEquals(general_Info_Text, option);

                } else if (s.equals("Intake Rx")) {
                    String intake_Rx_Text = FrameworkLibrary.chromeDriver
                            .findElement(By.xpath(FrameworkConstants.INTAKE_RX_BTN)).getText();
                    Assert.assertEquals(intake_Rx_Text, option);

                } else if(s.equals("Update")) {
                    String update_Text = FrameworkLibrary.chromeDriver
                            .findElement(By.xpath(IntakeConstants.Patient_search_update_button)).getText();
                    Assert.assertEquals(update_Text, option);
                }

            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


    @And("^I should be able to see \"([^\"]*)\" \"([^\"]*)\" and \"([^\"]*)\" buttons$")
    public void iShouldBeAbleToSeeAndButtons(String search, String view, String update) throws Throwable {
        String search_Button_Text = FrameworkLibrary.chromeDriver
                .findElement(By.xpath(SmokeTestConstants.Patient_SearchButton)).getText();
        String view_Button_Text = FrameworkLibrary.chromeDriver
                .findElement(By.xpath(SmokeTestConstants.Patient_ViewButton)).getText();

        Assert.assertEquals(search_Button_Text, search);
        Assert.assertTrue(view_Button_Text.contains(view));
        Assert.assertTrue(view_Button_Text.contains(update));
    }

    @Then("^I should not see following fields:$")
    public void i_should_not_see_following_fields(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            String pageSource = chromeDriver.getPageSource();
            List<String> options = arg1.asList(String.class);
            for (int i = 0; i < options.size(); i++) {
                Boolean condition = pageSource.contains(options.get(i));
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

    /*
     * This method is to enter the prescriber first name and last name
	 */
    @When("^User enters prescriber first name and Last name from DR$")
    public void user_enters_prescriber_FN_LN_from_DR(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.dr_prescriberSearch_lastname)) {
                FrameworkLibrary.enter_Text(arg1, 0, "LastName", dataReviewConstants.dr_prescriberSearch_lastname,
                        chromeDriver);
            }
            if (isElementPresentVerification(dataReviewConstants.dr_prescriberSearch_firstname)) {
                FrameworkLibrary.enter_Text(arg1, 0, "FirstName", dataReviewConstants.dr_prescriberSearch_firstname,
                        chromeDriver);
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^clicks search button on prescriber search from DR$")
    public void click_prescribersearch_from_DR() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.dr_prescriberSearch_searchButton)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.dr_prescriberSearch_searchButton)) {
                    throw new Exception("unable to click prescriber search button");
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

    @When("^User is selecting a dispensed drug during the Data Entry$")
    public void user_is_selecting_a_dispensed_drug_during_the_Data_Entry(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            String drugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
            if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
                if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, drugName)) {
                    throw new Exception("User not able to enter drugname");
                }
                if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
                    Actions upArrow = new Actions(chromeDriver);
                    Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
                    PressUpArrow.perform();
                    Thread.sleep(1000);
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

    @Then("^System displays quality alert message and a quality alert screen indicator of S or B associated$")
    public void system_displays_quality_alert_message_and_a_quality_alert_screen_indicator_of_S_or_B_associated()
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.Drug_Popup_Alert)) {
                Assert.assertTrue(isElementPresents(dataReviewConstants.Drug_Popup_Alert));
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^click on Ok in quality alert message$")
    public void click_on_Ok_in_quality_alert_message() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.Drug_Popup_Alert_OK_Btn)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.Drug_Popup_Alert_OK_Btn)) {
                    throw new Exception("unable to click on drug alert popup ok button");
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

    @Then("^System should not displays quality alert message$")
    public void system_should_not_displays_quality_alert_message() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Boolean condition = isElementPresents(dataReviewConstants.Drug_Popup_Alert_OK_Btn);
            Assert.assertFalse(condition);

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^User is selecting a dispensed drug during the data review screen$")
    public void i_update_product_data_with_rems_drug_in_data_review_screen(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(DataEntryConstants.DR_ProductUpdate)) {
                if (isElementPresentVerifyClick(DataEntryConstants.DR_ProductUpdate)) {
                    if (isElementPresentVerification(DataEntryConstants.DR_ProductName)) {
                        FrameworkLibrary.enter_Text(arg1, 0, "DrugName", DataEntryConstants.DR_ProductName,
                                chromeDriver);
                        if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
                            Actions upArrow = new Actions(chromeDriver);
                            Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
                            PressUpArrow.perform();
                            Thread.sleep(1000);
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

    @Then("^I should see \"([^\"]*)\" status$")
    public void i_should_see_status(String arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (arg1.equals("Rx Received")) {
                Assert.assertTrue(chromeDriver.getPageSource().contains("Rx Received"), "Rx Received Status Not Found");
            } else if (arg1.equals("Entered")) {
                Assert.assertTrue(chromeDriver.getPageSource().contains(arg1), "Entered Status Not Found");
            } else if (arg1.equals("Reviewed")) {
                Assert.assertTrue(chromeDriver.getPageSource().contains(arg1), "Reviewed Status Not Found");

            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^I check PickupTime column is read only$")
    public void i_check_PickupTime_column_is_read_only(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.POS_patientNames)) {
                List<WebElement> list1 = chromeDriver.findElements(By.xpath(SmokeTestConstants.POS_patientNames));
                String expectedPatientName = SmokeTestLibrary.getData(arg1, "LastName").toUpperCase();
                if (list1.get(0).getText().contains(
                        expectedPatientName)/*
											 * &&
											 * list1.get(i).getText().contains(
											 * expectedPhoneNumber)
											 */) {
                    String s = list1.get(0).getAttribute("id");
                    String[] parts = s.split("-");
                    String part2 = parts[1];
                    String ele = "//*[@id='single-prescription-" + part2 + "'-0]/div[1]";
                    WebDriverWait wait = new WebDriverWait(FrameworkLibrary.chromeDriver, 2000);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ele)));
                    waitToClick(ele).click();
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

    @Then("^if status is Check IC\\+ the Rx number is not clickable$")
    public void if_status_is_Check_IC_the_Rx_number_is_not_clickable(DataTable arg1) throws Exception {
        validate_clickable_patient_order_status(arg1, "3");
    }

    @When("^the status is Reviewed$")
    public void the_status_is_Reviewed() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Assert.assertTrue(chromeDriver.getPageSource().contains("Reviewed"), "Reviewed Status Not Found");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^the Rx number is clickable$")
    public void the_Rx_number_is_clickable(DataTable arg1) throws Exception {
        validate_clickable_patient_order_status(arg1, "3");
    }

    @When("^user clicks \"([^\"]*)\" button$")
    public void user_clicks_button(String arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.POS_PAYMENT_UPDATE)) {
                if (arg1.equals("Update Payment")) {
                    isElementPresentVerifyClick(dataReviewConstants.POS_PAYMENT_UPDATE);
                } else if (arg1.equals("Update Rx")) {
                    isElementPresentVerifyClick(dataReviewConstants.POS_UPDATE_RX);
                } else if (arg1.equals("Delete Rx(s)")) {
                    isElementPresentVerifyClick(dataReviewConstants.POS_DELETE_RXS);
                } else if (arg1.equals("Reprint Paperwork")) {
                    isElementPresentVerifyClick(dataReviewConstants.POS_REPRINT_PAPERWORK);
                } else if (arg1.equals("Update")) {
                    isElementPresentVerifyClick(DataEntryConstants.PRESCRIBER_SEARCH_UPDATE_BUTTON);
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

    @Then("^I should get \"([^\"]*)\"$")
    public void i_should_get(String arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(3000);
            Assert.assertTrue(chromeDriver.getPageSource().contains(arg1),
                    "Expected text " + arg1 + " was not present");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^I click ok button$")
    public void i_click_ok_button() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.POS_FUNCTION_UNAVAILABLE_OK)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.POS_FUNCTION_UNAVAILABLE_OK)) {
                    throw new Exception("unable to click on function available ok button");
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

    @Then("^I should see Task board is expanded$")
    public void i_should_see_Task_board_is_expanded() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.TASKBAR_EXPANDED)) {
                Assert.assertTrue(isElementPresentVerification(dataReviewConstants.TASKBAR_EXPANDED));
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^I should see following tabs:$")
    public void i_should_see_following_tabs(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String pageSource = chromeDriver.getPageSource();
            List<String> options = arg1.asList(String.class);
            for (int i = 0; i < options.size(); i++) {
                Boolean condition = pageSource.contains(options.get(i));
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

    @Then("^I am not able to access DR Screen$")
    public void i_am_not_able_to_access_DR_Screen() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_DISABLED)) {
                boolean condition = FrameworkLibrary.chromeDriver.findElement(By.xpath(dataReviewConstants.DR_DISABLED))
                        .isEnabled();
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

    @Then("^I should see priority icon in DE$")
    public void i_should_see_priority_icon_in_DE() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.TASK_CE_PRIORITY_ICON)) {
                Assert.assertTrue(AccessManagementLibrary.isElementPresent(dataReviewConstants.TASK_CE_PRIORITY_ICON),
                        "Priority icon is not present");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^I should see Task board is collapsed$")
    public void i_should_see_Task_board_is_collapsed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.TASKBAR_EXPANDED)) {
                Assert.assertTrue(AccessManagementLibrary.isElementPresent(dataReviewConstants.TASKBAR_EXPANDED),
                        "Priority icon is not present");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^I click on taskboard$")
    public void i_click_on_taskboard() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.TASKBAR_LINK)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.TASKBAR_LINK)) {
                    throw new Exception("unable to click on taskbarlink");
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

    @When("^I click on home button$")
    public void i_click_ob_home_button() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DASHBOARD_HOME_BUTTON)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.DASHBOARD_HOME_BUTTON)) {
                    throw new Exception("unable to click on Dashboard home button");
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

    @And("^User clicks Filling task in taskboard$")
    public void user_clicks_Filling_task_in_taskboard() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.TASK_FILLING_LINK)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.TASK_FILLING_LINK)) {
                    throw new Exception("unable to click on task filling link");
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
	 * This method is to check the popup message is displayed after clicking on
	 * fill task and clicking on "OK" button
	 */
    @Then("^System should display message that Use the Mobile Device to complete Filling$")
    public void system_should_display_message_that_Use_the_Mobile_Device_to_complete_Filling() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(2000);
            Assert.assertTrue(chromeDriver.getPageSource().contains("Use the Mobile Device to complete Filling."));

            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("0").keyUp(Keys.ALT).build();
            series.perform();

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    public void validate_clickable_patient_order_status(DataTable arg1, String divlocation) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.POS_patientNames)) {
                List<WebElement> list1 = chromeDriver.findElements(By.xpath(SmokeTestConstants.POS_patientNames));
                String expectedPatientName = SmokeTestLibrary.getData(arg1, "LastName").toUpperCase();
                if (list1.get(0).getText().contains(
                        expectedPatientName)/*
											 * &&
											 * list1.get(i).getText().contains(
											 * expectedPhoneNumber)
											 */) {
                    String s = list1.get(0).getAttribute("id");
                    String[] parts = s.split("-");
                    String part2 = parts[1];
                    String ele = "//*[@id='single-prescription-" + part2 + "'-0]/div[" + divlocation + "]";
                    WebDriverWait wait = new WebDriverWait(FrameworkLibrary.chromeDriver, 2000);
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ele)));
                    waitToClick(ele).click();
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

    @When("^User clicks Patient search button$")
    public void i_clicks_patient_search_button() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.one_search)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.one_search)) {
                    throw new Exception("unable to click on one search button");
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

    @When("^User clicks update and enters a Rems or LDD drug$")
    public void user_clicks_update_selects_a_Rems_or_LDD_drug(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(FrameworkConstants.DR_PRODUCT_UPDATE_BTN)) {
                if (!isElementPresentVerifyClick(FrameworkConstants.DR_PRODUCT_UPDATE_BTN)) {
                    throw new Exception("unable to click on one search button");
                }
                if (isElementPresentVerification(DataEntryConstants.Product_OriginalDate)) {
                    FrameworkLibrary.enter_Text(arg1, 0, "OriginalDate", DataEntryConstants.Product_OriginalDate,
                            chromeDriver);
                    FrameworkLibrary.enter_Text(arg1, 0, "DAW", DataEntryConstants.Product_DAW, chromeDriver);
                    FrameworkLibrary.enter_Text(arg1, 0, "DrugName", DataEntryConstants.DrugName_Field, chromeDriver);
                    Thread.sleep(5000);
                    Actions productinfo = new Actions(chromeDriver);
                    Action selectProduct = productinfo.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
                    selectProduct.perform();
                    Thread.sleep(2000);
                    Action enter = productinfo.sendKeys(Keys.ENTER).build();
                    enter.perform();
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

    @When("^click on intake$")
    public void click_on_intake() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.Patientprofile_GroupId)) {
                String GroupId = getElementText(dataReviewConstants.Patientprofile_GroupId);
//                String GroupId = FrameworkLibrary.chromeDriver
//                        .findElement(By.xpath(dataReviewConstants.Patientprofile_GroupId)).getText();
                String Actual_GroupID = "D0REJECTED";
                Assert.assertEquals(GroupId, Actual_GroupID);
            }
            if (isElementPresentVerification(SmokeTestConstants.Intake_RxButton)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.Intake_RxButton)) {
                    throw new Exception("unable to click on Intake button");
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

    @When("^selects payment type plan$")
    public void selects_payment_type_plan() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.Payment_Dropdown)) {
                    throw new Exception("unable to click on payment dropdown");
                }
                if (!isElementPresentVerifyClick(dataReviewConstants.PLAN_OPTIONS)) {
                    throw new Exception("unable to click on payment plan");
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
	 * This method is used to check whether Rx number is generated or not and
	 * checks the status as IC plus
	 */
    @Then("^System should generate a Rx number and Ic plus status for current prescriptionone$")
    public void System_should_generate_a_Rx_number_and_IC_plus_status_for_current_prescriptionone(DataTable arg1)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            SmokeTestStepDef.i_click_search_button_on_patient_order_status();
            SmokeTestStepDef.i_click_search_button_on_patient_order_status();

            if (isElementPresentVerification(SmokeTestConstants.POS_patientNames)) {
                List<WebElement> list1 = chromeDriver.findElements(By.xpath(SmokeTestConstants.POS_patientNames));
                String expectedPatientName = SmokeTestLibrary.getData(arg1, "LastName").toUpperCase();
                String pickuptime = SmokeTestStepDef.currentPickupTime;
                String pickupdate = SmokeTestStepDef.IntakeDate;
                String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;

                for (int i = 0; i < list1.size(); i++) {
                    if (list1.get(i).getText().contains(expectedPatientName)) {
                        String s = list1.get(i).getAttribute("id");
                        String[] parts = s.split("-");
                        String part2 = parts[1];
                        List<WebElement> singlepresc = chromeDriver
                                .findElements(By.xpath("//*[contains(@id,'single-prescription-" + part2 + "')]"));

                        for (int z = 0; z < singlepresc.size(); z++) {

                            if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate)
                                    && singlepresc.get(z).getText().contains(pickuptime)) {
                                Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("inprogress"));
                                String dyn = singlepresc.get(z).getAttribute("id");
                                String[] dynamo = dyn.split("-");
                                String part = dynamo[2];
                                String Rxnumber = "//*[@id='single-prescription-" + part + "-" + z + "']/div[3]";
                                String currentRxnumber = getElementText(Rxnumber);
                                Assert.assertTrue(getElementText(Rxnumber) != null);
                                String[] rxnumberparts = currentRxnumber.split("-");
                                SmokeTestStepDef.dynamicrxnum = rxnumberparts[0];
                                String priceXpath = "//*[@id='single-prescription-" + part + "-" + z + "']/div[6]";
                                String price = getElementText(priceXpath);
                                Assert.assertTrue(price != null);
                            } else if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate)
                                    && singlepresc.get(z).getText().contains(possiblepickupTime1)) {

                                Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("check ic+"));
                                String dyn = singlepresc.get(z).getAttribute("id");
                                String[] dynamo = dyn.split("-");
                                String part = dynamo[2];
                                String Rxnumber = "//*[@id='single-prescription-" + part + "-" + z + "']/div[3]";
                                String currentRxnumber = getElementText(Rxnumber);
                                Assert.assertTrue(getElementText(Rxnumber) != null);
                                String[] rxnumberparts = currentRxnumber.split("-");
                                SmokeTestStepDef.dynamicrxnum = rxnumberparts[0];
                                String priceXpath = "//*[@id='single-prescription-" + part + "-" + z + "']/div[6]";
                                String price = getElementText(priceXpath);
                                Assert.assertTrue(price != null);
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

    @And("^user click view button system displays prescriber details page$")
    public void user_click_view_button_system_displays_prescriber_details_page() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(AccessManagementConstants.Dataentry_Page_Prescriber_View_Button)) {
                if (!isElementPresentVerifyClick(AccessManagementConstants.Dataentry_Page_Prescriber_View_Button)) {
                    throw new Exception("unable to click on data entry prescriber view button");
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

    @And("^user validate the Prescriber details page and navigate back$")
    public void user_validate_the_Prescriber_details_page_and_navigate_back() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(
                    AccessManagementConstants.Dataentry_Page_Prescriber_Page_General_Info_Details)) {
                Assert.assertTrue(FrameworkLibrary.isElementPresents(
                        AccessManagementConstants.Dataentry_Page_Prescriber_Page_General_Info_Details));
            }
            if (isElementPresentVerification(
                    AccessManagementConstants.Dataentry_Page_Prescriber_Page_Location_Communication)) {
                Assert.assertTrue(FrameworkLibrary.isElementPresents(
                        AccessManagementConstants.Dataentry_Page_Prescriber_Page_Location_Communication));
            }
            if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_PROFILE_X_BUTTON)) {
                if (!isElementPresentVerifyClick(
                        DataEntryConstants.PRESCRIBER_PROFILE_X_BUTTON)) {
                    throw new Exception("unable to click on data entry prescriber details back button");
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

    @Then("^I should not be able to click on DR from taskboard$")
    public void i_should_not_be_able_to_click_on_DR_from_taskboard() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(AccessManagementConstants.Admin_Read_Role_DR)) {
                Assert.assertFalse(
                        FrameworkLibrary.chromeDriver
                                .findElement(By.xpath(AccessManagementConstants.Admin_Read_Role_DR)).isEnabled(),
                        "DR is enabled");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^I should be able to click on DR from taskboard$")
    public void i_should_be_able_to_click_on_DR_from_taskboard() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(AccessManagementConstants.Admin_Read_Role_DR)) {
                if (!isElementPresentVerifyClick(AccessManagementConstants.Admin_Read_Role_DR)) {
                    throw new Exception("unable to click on DR admin read role");
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

    @Then("^I should not see DR screen$")
    public void i_should_not_see_DR_screen() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Assert.assertFalse(chromeDriver.getPageSource().contains("Payment"), "DR Screen Opened");
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^I click on back button from DR screen$")
    public void i_click_on_back_button_from_DR_screen() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_BACK_BUTTON)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.DR_BACK_BUTTON)) {
                    throw new Exception("unable to click on DR back button");
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

    @Then("^I should click yes$")
    public void i_should_click_yes() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(2000);
            if (isElementPresentVerification(dataReviewConstants.DE_backbutton_Popup)) {
                Actions ac = new Actions(chromeDriver);
                Action series = ac.keyDown(Keys.ALT).sendKeys("y").keyUp(Keys.ALT).build();
                series.perform();
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^I should see DR screen$")
    public void i_should_see_DR_screen() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(3000);
            Assert.assertTrue(chromeDriver.getPageSource().contains("Data Review"), "DR screeen not opened");
            Assert.assertTrue(chromeDriver.getPageSource().contains("Accept"), "DR screeen not opened");
            Assert.assertTrue(chromeDriver.getPageSource().contains("Search"), "DR screeen not opened");
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^user edits paycode for one$")
    public void user_edits_paycode_for_one(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.dr_product_update_btn)) {
                if (isElementPresentVerifyClick(dataReviewConstants.dr_product_update_btn)) {
                    SmokeTestLibrary.enter_Text(arg1, "DAW", SmokeTestConstants.Product_DAW, chromeDriver);
                    Actions tab = new Actions(chromeDriver);
                    Action presstab = tab.sendKeys(Keys.TAB).build();
                    presstab.perform();
                    if (isElementPresentVerification(dataReviewConstants.Dr_payment_paycode1)) {
                        String s = FrameworkLibrary.getElementText(dataReviewConstants.Dr_payment_paycode1);
                        boolean cond = s.contains("1 -");
                        Assert.assertTrue(cond);
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

    @Then("^user edits paycode for two$")
    public void user_edits_paycode_for_two(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
                SmokeTestLibrary.enter_Text(arg1, "DAW", SmokeTestConstants.Product_DAW, chromeDriver);
                Actions tab = new Actions(chromeDriver);
                Action presstab = tab.sendKeys(Keys.TAB).build();
                presstab.perform();
                if (isElementPresentVerification(SmokeTestConstants.Product_Substitute)) {
                    SmokeTestLibrary.enter_Text(arg1, "Substitute", SmokeTestConstants.Product_Substitute, chromeDriver);
                }
                if (isElementPresentVerification(dataReviewConstants.Dr_payment_paycode1)) {
                    String paycode = FrameworkLibrary.getElementText(dataReviewConstants.Dr_payment_paycode1);
                    boolean cond = paycode.contains("2 -");
                    Assert.assertTrue(cond);
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

    @Then("^user edits paycode for zero$")
    public void user_edits_paycode_for_zero(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Product_Substitute)) {
                SmokeTestLibrary.enter_Text(arg1, "Substitute", SmokeTestConstants.Product_Substitute, chromeDriver);
                if (isElementPresentVerification(dataReviewConstants.Dr_payment_paycode1)) {
                    String paycode1 = FrameworkLibrary.getElementText(dataReviewConstants.Dr_payment_paycode1);
                    boolean cond = paycode1.contains("0 -");
                    Assert.assertTrue(cond);
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

    @Then("^user selects a rems drug$")
    public void user_selects_a_rems_drug(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
                SmokeTestLibrary.enter_Text(arg1, "DrugName", SmokeTestConstants.DrugName_Field, chromeDriver);
                if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
                    Actions upArrow = new Actions(chromeDriver);
                    Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
                    PressUpArrow.perform();
                    Thread.sleep(1000);
                }
                if (isElementPresentVerification(dataReviewConstants.Dr_Product_drug_popup)) {
                    String msg = FrameworkLibrary.getElementText(dataReviewConstants.Dr_Product_drug_popup);
                    Assert.assertEquals("This function cannot be completed in this system.", msg);
                    if (isElementPresentVerification(dataReviewConstants.Dr_Product_drug_cancel)) {
                        isElementPresentVerifyClick(dataReviewConstants.Dr_Product_drug_cancel);
                        if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
                            SmokeTestLibrary.enter_Text(arg1, "DrugName", SmokeTestConstants.DrugName_Field,
                                    chromeDriver);
                            if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
                                Actions upArrow = new Actions(chromeDriver);
                                Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
                                PressUpArrow.perform();
                                Thread.sleep(1000);
                            }
                            if (isElementPresentVerification(dataReviewConstants.Dr_Product_drug_Icplus)) {
                                if (!isElementPresentVerifyClick(dataReviewConstants.Dr_Product_drug_Icplus)) {
                                    throw new Exception("unable to click on Drug IC+");
                                }
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

    /*
	 * This method is to enter the product information from Excel
	 */
    @When("^enter the product information$")
    public void enter_the_product_information(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
                isElementPresentVerifyClick(SmokeTestConstants.Product_OriginalDate);
                SmokeTestLibrary.enter_Text(arg1, "Date", SmokeTestConstants.Product_OriginalDate, chromeDriver);
                SmokeTestLibrary.enter_Text(arg1, "DAW", SmokeTestConstants.Product_DAW, chromeDriver);
                SmokeTestLibrary.enter_Text(arg1, "Substitute", dataReviewConstants.substitute_box, chromeDriver);
                SmokeTestLibrary.enter_Text(arg1, "DrugName", SmokeTestConstants.DrugName_Field, chromeDriver);
                Thread.sleep(3000);
                Actions upArrow = new Actions(chromeDriver);
                Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
                PressUpArrow.perform();
                Thread.sleep(1000);
                SmokeTestLibrary.enter_Text(arg1, "Quantity", SmokeTestConstants.Quantity_field, chromeDriver);
                SmokeTestLibrary.enter_Text(arg1, "Directions", SmokeTestConstants.Directions_field, chromeDriver);
                SmokeTestLibrary.enter_Text(arg1, "DaysSupply", SmokeTestConstants.Days_Supply, chromeDriver);
                SmokeTestLibrary.enter_Text(arg1, "Refills", SmokeTestConstants.Refills_field, chromeDriver);
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^user selects fax field$")
    public void user_selects_fax_field() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(AccessManagementConstants.Radio_fax)) {
                if (!isElementPresentVerifyClick(AccessManagementConstants.Radio_fax)) {
                    throw new Exception("unable to click on Radio fax button");
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

    @When("^user selects phone field$")
    public void user_selects_phone_field() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(AccessManagementConstants.Radio_phone)) {
                isElementPresentVerifyClick(AccessManagementConstants.Radio_phone);
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^User selects pickup time as Pick Up Later tommorow$")
    public void User_selects_pickup_time_as_Pick_Up_Later_tommorow() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.date_latest)) {
                isElementPresentVerifyClick(SmokeTestConstants.date_latest);
            }
            if (isElementPresentVerification(AccessManagementConstants.date_tuesday)) {
                isElementPresentVerifyClick(AccessManagementConstants.date_tuesday);
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
	 * This method is used to validate patient name and contact number in Data
	 * Review
	 */
    @And("^User validate the patient name and contact number$")
    public void User_validate_the_patient_name_and_contact_number(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Map<String, List<String>> dataMap = null;
            dataMap = FrameworkLibrary.getHorizontalData(arg1);

            String PatientLastName = getXLSTestData(dataMap.get("InputFileName").get(0),
                    dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");

            Thread.sleep(1000);

            String PatientFirstName = getXLSTestData(dataMap.get("InputFileName").get(0),
                    dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");

            String s = PatientLastName + " " + PatientFirstName;

            if (isElementPresentVerification(dataReviewConstants.DE_Patient_Name_Validation)) {
                String Name = FrameworkLibrary.chromeDriver
                        .findElement(By.xpath(dataReviewConstants.DE_Patient_Name_Validation)).getText();

                Assert.assertEquals(Name, s);

                String PatientContact = getXLSTestData(dataMap.get("InputFileName").get(0),
                        dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");

                Assert.assertTrue(
                        IntakeLibrary.getElement(dataReviewConstants.DE_Patient_Contact_Number_Validation)
                                .getAttribute("value").equals(PatientContact),
                        "Patient Contact number displayed incorrectly" + "from excel : " + PatientContact
                                + "From Application Data Entry screen page:"
                                + IntakeLibrary.getElement(dataReviewConstants.DE_Patient_Contact_Number_Validation)
                                .getAttribute("value"));

            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^User selects pickup time as later with todays date$")
    public void User_selects_pickup_time_as_later_with_todays_date() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            Thread.sleep(3000);
            FrameworkLibrary
                    .isElementPresentVerifyClick(dataReviewConstants.Intake_Pickup_Timings_Dropdown_Box_Selected_Feild);
            Thread.sleep(2000);
            Actions ab = new Actions(chromeDriver);
            Action series = ab.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build();
            series.perform();

            if (isElementPresentVerification(IntakeConstants.RADIO_PICKUPLATER)) {
                boolean clickedPickuplater = FrameworkLibrary
                        .isElementPresentVerifyClick(IntakeConstants.RADIO_PICKUPLATER);
                if (clickedPickuplater) {
                    if (isElementPresentVerification(IntakeConstants.PICKUPLATER_TODAYSDATE)) {
                        isElementPresentVerifyClick(IntakeConstants.PICKUPLATER_TODAYSDATE);
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

    @When("^User selects pickup time as later with tomorrows date$")
    public void user_selects_pickup_time_as_later_with_tomorrows_date() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.RADIO_PICKUPLATER)) {
                boolean clickedPickuplater = FrameworkLibrary
                        .isElementPresentVerifyClick(IntakeConstants.RADIO_PICKUPLATER);
                if (clickedPickuplater) {
                    if (isElementPresentVerification(IntakeConstants.PICKUPLATER_TOMORROWDATE)) {
                        FrameworkLibrary.isElementPresentVerifyClick(IntakeConstants.PICKUPLATER_TOMORROWDATE);
                    }
                }
                if (isElementPresentVerification(
                        dataReviewConstants.Intake_Pickup_Timings_Dropdown_Box_Selected_Feild)) {
                    FrameworkLibrary.isElementPresentVerifyClick(
                            dataReviewConstants.Intake_Pickup_Timings_Dropdown_Box_Selected_Feild);
                }
                Thread.sleep(2000);
                Actions ab = new Actions(chromeDriver);
                Action series = ab.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build();
                series.perform();
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^System should display an alert asking to continue this task on ICplus$")
    public void validate_rems_alert() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.dr_rems_alert_message)) {
                Assert.assertTrue(getElementText(dataReviewConstants.dr_rems_alert_message).contains("This function cannot be completed in this system."));
                Assert.assertTrue(getElementText(dataReviewConstants.dr_rems_alert_message).contains("Please complete in IC+."));
            }
            if (isElementPresentVerification(DataEntryConstants.dr_rems_popup_cancelButton)) {
                if (!isElementPresentVerifyClick(DataEntryConstants.dr_rems_popup_cancelButton)) {
                    throw new Exception("unable to click on rems popup cancel button");
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


    @Then("^User clicks cancel button on the rems alert$")
    public void click_cancel_on_rems_alert() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(DataEntryConstants.dr_rems_popup_cancelButton)) {
                if (!isElementPresentVerifyClick(DataEntryConstants.dr_rems_popup_cancelButton)) {
                    throw new Exception("unable to click on rems popup");
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

    @Then("^System displays an alert - Stop Current task$")
    public void CE_alert_message_to_Stop_current_task() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(ClinicalEvaluationConstants.CE_stop_current_Task_alert_message)) {
                String actualval = getElementText(ClinicalEvaluationConstants.CE_stop_current_Task_alert_message);
                Assert.assertTrue(actualval.contains("Stop Current Task"));
                Assert.assertTrue(actualval.contains("Are you sure you want to lose your work and exit?"));
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
	 * This method is used to check whether the Rx number is displayed or not in
	 * patient order status
	 */
    @Then("^System should display rx number of current prescription$")
    public void rxnumber_validation_in_medhistory() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            long timeoutExpiredMS = System.currentTimeMillis() + 100000;

            String rxnum = SmokeTestStepDef.dynamicrxnum;
            if (SmokeTestStepDef.dynamicrxnum.startsWith("0")) {
                rxnum = SmokeTestStepDef.dynamicrxnum.substring(1);
            }

            Thread.sleep(5000);
            WebElement e = chromeDriver.findElementByClassName("md-virtual-repeat-offsetter");
            while (!e.getText().contains(rxnum)) {
                Actions ac = new Actions(chromeDriver);
                Action a = ac.sendKeys(Keys.ARROW_DOWN).build();
                a.perform();
                if (System.currentTimeMillis() > timeoutExpiredMS) {
                    throw new Exception("Time out..");
                }
            }
            Thread.sleep(2000);

            Assert.assertTrue(isElementPresents("//*[contains(text(),'" + rxnum + "')]"),
                    "Rx number is not displayed in MedHistory");
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^System should display rxnumber hyperlink of current prescription$")
    public void rxnumber_hyper_link_validation_in_medhistory() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String rxnumMedHistory = "";
            if (SmokeTestStepDef.dynamicrxnum.startsWith("0")) {
                rxnumMedHistory = SmokeTestStepDef.dynamicrxnum.substring(1, SmokeTestStepDef.dynamicrxnum.length());
            }
            WebElement rxnum = chromeDriver.findElement(By.xpath("//*[contains(text(),'" + rxnumMedHistory + "')]"));
            rxnum.click();
            Assert.assertTrue(isElementPresents(""), "Rx number is not displayed in MedHistory");
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^System should generate a Rx number for current prescription and status should be check ICplus$")
    public void System_should_generate_a_Rx_number_for_current_prescription_check_ICplus(DataTable arg1)
            throws Exception {

        SmokeTestStepDef.i_click_search_button_on_patient_order_status();
        SmokeTestStepDef.i_click_search_button_on_patient_order_status();

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.POS_patientNames)) {
                List<WebElement> list1 = chromeDriver.findElements(By.xpath(SmokeTestConstants.POS_patientNames));
                String expectedPatientName = SmokeTestLibrary.getData(arg1, "LastName").toUpperCase();
                String pickuptime = SmokeTestStepDef.currentPickupTime;
                String pickupdate = SmokeTestStepDef.IntakeDate;
                String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;

                for (int i = 0; i < list1.size(); i++) {
                    if (list1.get(i).getText().contains(
                            expectedPatientName)/*
												 * && list1.get(i).getText().
												 * contains(expectedPhoneNumber)
												 */) {
                        String s = list1.get(i).getAttribute("id");
                        String[] parts = s.split("-");
                        String part2 = parts[1];
                        List<WebElement> singlepresc = chromeDriver
                                .findElements(By.xpath("//*[contains(@id,'single-prescription-" + part2 + "')]"));

                        for (int z = 0; z < singlepresc.size(); z++) {
                            if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate)
                                    && singlepresc.get(z).getText().contains(pickuptime)) {

                                String dyn = singlepresc.get(z).getAttribute("id");
                                String[] dynamo = dyn.split("-");
                                String part = dynamo[2];
                                String Rxnumber = "//*[@id='single-prescription-" + part + "-" + z + "']/div[3]";
                                String currentRxnumber = getElementText(Rxnumber);
                                Assert.assertTrue(getElementText(Rxnumber) != null);
                                String[] rxnumberparts = currentRxnumber.split("-");
                                dynamicrxnum = rxnumberparts[0];

                            } else if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate)
                                    && singlepresc.get(z).getText().contains(possiblepickupTime1)) {
                                String dyn = singlepresc.get(z).getAttribute("id");
                                String[] dynamo = dyn.split("-");
                                String part = dynamo[2];
                                String Rxnumber = "//*[@id='single-prescription-" + part + "-" + z + "']/div[3]";
                                String currentRxnumber = getElementText(Rxnumber);
                                Assert.assertTrue(getElementText(Rxnumber) != null);
                                String[] rxnumberparts = currentRxnumber.split("-");
                                dynamicrxnum = rxnumberparts[0];
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

    @Then("^prescription status should be check ICplus in patient order status$")
    public void prescription_status_should_be_check_Icplus(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.POS_patientNames)) {
                List<WebElement> list1 = chromeDriver.findElements(By.xpath(SmokeTestConstants.POS_patientNames));
                String expectedPatientName = SmokeTestLibrary.getData(arg1, "LastName").toUpperCase();
                String pickuptime = SmokeTestStepDef.currentPickupTime;
                String pickupdate = SmokeTestStepDef.IntakeDate;
                String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
                for (int i = 0; i < list1.size(); i++) {
                    if (list1.get(i).getText().contains(
                            expectedPatientName)/*
												 * && list1.get(i).getText().
												 * contains(expectedPhoneNumber)
												 */) {
                        String s = list1.get(i).getAttribute("id");
                        String[] parts = s.split("-");
                        String part2 = parts[1];
                        List<WebElement> singlepresc = chromeDriver
                                .findElements(By.xpath("//*[contains(@id,'single-prescription-" + part2 + "')]"));

                        for (int z = 0; z < singlepresc.size(); z++) {
                            if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate)
                                    && singlepresc.get(z).getText().contains(pickuptime)) {

                                Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("check ic+"));
                                singlepresc.get(z).click();

                            } else if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate)
                                    && singlepresc.get(z).getText().contains(possiblepickupTime1)) {

                                Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("check ic+"));
                                singlepresc.get(z).click();
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

    @When("^User hits alt plus s hotkey$")
    public void user_hits_alt_plus_s_hotkey() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "s", chromeDriver);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^User hits alt plus o hotkey to close the alert message$")
    public void user_hits_alt_plus_o_hotkey_to_close_the_alert_message() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(3000);
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "o", chromeDriver);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^User hits alt plus one hotkey$")
    public void user_hits_alt_plus_one_hotkey() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "1", chromeDriver);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^first accept button should be selected$")
    public void first_accept_button_should_be_selected() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(FrameworkConstants.DR_PATIENT_ACCEPT_BTN)) {
                Assert.assertTrue(getElementByProperty(FrameworkConstants.DR_PATIENT_ACCEPT_BTN, chromeDriver)
                        .getAttribute("disabled").equalsIgnoreCase("true"));

            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^User hits alt plus e hotkey$")
    public void user_hits_alt_plus_e_hotkey() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(1000);
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "e", chromeDriver);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^User hits alt plus r hotkey$")
    public void user_hits_alt_plus_r_hotkey() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "r", chromeDriver);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^User hits alt plus l hotkey$")
    public void user_hits_alt_plus_l_hotkey() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(2000);
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "L", chromeDriver);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^all the fields should be cleared$")
    public void all_the_fields_should_be_cleared() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.dr_prescriberSearch_firstname)) {
                Assert.assertTrue(getElementText(dataReviewConstants.dr_prescriberSearch_firstname).equals(""));
                Assert.assertTrue(getElementText(SmokeTestConstants.prescriberSearch_LastName).equals(""));
                Assert.assertTrue(getElementText(dataReviewConstants.prescriber_npi).equals(""));
                Assert.assertTrue(getElementText(SmokeTestConstants.Prescriber_Phonenumber).equals(""));
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^User hits alt plus c hotkey$")
    public void user_hits_alt_plus_c_hotkey() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "c", chromeDriver);

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^prescriber search page on dr should be closed$")
    public void prescriber_search_page_on_dr_should_be_closed() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(DataEntryConstants.Prescriber_AcceptButton)) {
                if (!isElementPresentVerifyClick(DataEntryConstants.Prescriber_AcceptButton)) {
                    Assert.assertTrue(isElementPresents(DataEntryConstants.Prescriber_AcceptButton));
                    throw new Exception("unable to click on prescriber accept button");
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

    @When("^User hits alt plus two hotkeys$")
    public void user_hits_alt_plus_two_hotkeys() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(5000);
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "2", chromeDriver);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^second accept button should be selected$")
    public void second_accept_button_should_be_selected() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(FrameworkConstants.DR_PRESCRIBER_ACCEPT_BTN)) {
                Assert.assertFalse(
                        getElementByProperty(FrameworkConstants.DR_PRESCRIBER_ACCEPT_BTN, chromeDriver).isEnabled());
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^User hits alt plus U hotkeys$")
    public void user_hits_alt_plus_U_hotkeys() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "U", chromeDriver);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^User enters updated data$")
    public void user_enters_updated_data(DataTable updateddata) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.DR_ProductDirections)) {
                enter_Text(updateddata, 0, "Directions", SmokeTestConstants.DR_ProductDirections, chromeDriver);
                enter_Text(updateddata, 0, "DaysSupply", SmokeTestConstants.Days_Supply, chromeDriver);
                enter_Text(updateddata, 0, "Refills", SmokeTestConstants.Refills_field, chromeDriver);
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^User hits alt plus three hot key$")
    public void user_hits_alt_plus_three_hot_key() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "3", chromeDriver);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^third accept button should be selected$")
    public void third_accept_button_should_be_selected() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(FrameworkConstants.DR_PATIENT_ACCEPT_BTN)) {
                Assert.assertTrue(getElementByProperty(FrameworkConstants.DR_PATIENT_ACCEPT_BTN, chromeDriver)
                        .getAttribute("disabled").equalsIgnoreCase("true"));
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^User hits alt plus f hotkeys$")
    public void user_hits_alt_plus_f_hotkeys() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "f", chromeDriver);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @When("^User clicks OK Button on the Icplus alert$")
    public void click_ok_on_the_ICplus_alert() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.dr_patient_search_confirm)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.dr_patient_search_confirm)) {
                    throw new Exception("Unable to click on patient search confirm");
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

    @Then("^system should display the list of prescribers that matches the search criteria$")
    public void validate_presc_search_results(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Search_Results)) {
                isElementPresents(DataEntryConstants.DE_Prescriber_Search_Results);
                String result_Text = getElementText(DataEntryConstants.DE_Prescriber_Search_Results);
                boolean isResultEmpty = result_Text.equalsIgnoreCase("");
                Assert.assertFalse(isResultEmpty);
                String expectedmessage = "The following prescriber(s) matched your search criteria:";
                if (isElementPresentVerification(DataEntryConstants.de_prescriber_results_label)) {
                    String actualmessage = getElementText(DataEntryConstants.de_prescriber_results_label);
                    Assert.assertTrue(expectedmessage.equals(actualmessage));
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

    @When("^User click on Search in Prescriber on DR page$")
    public void user_click_on_Search_in_Prescriber_on_DR_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.dr_prescriber_search_Btn)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.dr_prescriber_search_Btn)) {
                    throw new Exception("unable to click on dr prescriber search button");
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

    @When("^User enters prescriber first name and Last name on DR page$")
    public void user_enters_prescriber_first_name_and_Last_name_on_DR_page(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
			String FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
			if (isElementPresentVerification(hangOnConstants.DR_Last_Name)) {
				if (!clearAndEnterText(hangOnConstants.DR_Last_Name, LastName)) {
					throw new Exception("Not able to enter value in LastName text field");
				}
			}
			if (isElementPresentVerification(hangOnConstants.DR_First_Name)) {
				if (!clearAndEnterText(hangOnConstants.DR_First_Name, FirstName)) {
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

    @When("^clicks on select prescriber Button$")
    public void clicks_on_select_prescriber_Button() throws Exception {

    	 methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

         try {
             if (isElementPresentVerification(dataReviewConstants.Dr_Select_Prescriber_Btn)) {
                 if (!isElementPresentVerifyClick(dataReviewConstants.Dr_Select_Prescriber_Btn)) {
                     throw new Exception("unable to click on Dr search prescriber button");
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

    @When("^User click on Add New Button$")
    public void user_click_on_Add_New_Button() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.Dr_AddNew_Button)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.Dr_AddNew_Button)) {
                    throw new Exception("unable to click on Dr search prescriber button");
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

    @Then("^Screen pop up a message \"([^\"]*)\"$")
    public void screen_pop_up_a_message(String arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.PopUp_SendIC_Msg)) {
                String message = FrameworkLibrary.getElementText(dataReviewConstants.PopUp_SendIC_Msg);
                      Assert.assertEquals(message, "This function cannot be completed in this system. Please complete in IC+.");
                      if(!isElementPresentVerifyClick("//*[@id='dialog-button-confirm']")){
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

    @When("^User click on Update Button$")
    public void user_click_on_Update_Button() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_Update_Prescriber_update)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.DR_Update_Prescriber_update)) {
                    throw new Exception("unable to click on Dr search prescriber button");
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

    @When("^User click on View Button$")
    public void user_click_on_View_Button() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.Dr_View_Button)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.Dr_View_Button)) {
                    throw new Exception("unable to click on Dr search prescriber button");
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

    @When("^user clicks on DR task$")
    public void user_clicks_on_DR_task() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.main_right_sidenav_burger_menu_DR_text)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.main_right_sidenav_burger_menu_DR_text)) {
                    throw new Exception("unable to click on Dr search prescriber button");
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

    @When("^When user opens product panel$")
    public void When_user_opens_product_panel() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.product_info_form)) {
                Assert.assertTrue(isElementPresentVerification(dataReviewConstants.product_info_form));
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @And("^Rx expiration field should be blank and disabled$")
    public void Rx_expiration_field_should_be_blank_and_disabled() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.rx_exp_date)) {
                if (!getElementText(dataReviewConstants.rx_exp_date).equals("")) {
                    throw new Exception("Exp Date not blank");
                }
                Boolean condition = chromeDriver.findElementByXPath(dataReviewConstants.rx_exp_date).isEnabled();
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

    @Then("^User click On PRODUCT UPDATE BTN$")
    public void user_click_On_PRODUCT_UPDATE_BTN() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(FrameworkConstants.DR_PRODUCT_UPDATE_BTN)) {
                if (!isElementPresentVerifyClick(FrameworkConstants.DR_PRODUCT_UPDATE_BTN)) {
                    throw new Exception("unable to click on one search button");
                }
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * Validate Original Date, Drug Exp Date and Rx Expiration date pass 6 and 7
	 * numbers in each date text box and validate result.
	 */
    @Then("^Validate Original Date, Drug Exp Date and Rx Expiration date field and validate Error message$")
    public void validate_Original_Date_Drug_Exp_Date_and_Rx_Expiration_date_field_and_validate_error_message()
            throws Exception {

        Actions tab = new Actions(chromeDriver);
        Action hitTab = tab.sendKeys(Keys.TAB).build();
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            // validate date element present or not
            Assert.assertTrue(isElementPresentVerification(dataReviewConstants.DR_ORIGINAL_DATE));
            Assert.assertTrue(isElementPresentVerification(dataReviewConstants.DR_DRUG_EXP_DATE));
            Assert.assertTrue(isElementPresentVerification(dataReviewConstants.DR_REFILL_EXP_DATE));

            // clean all date text box
            FrameworkLibrary.getElementByProperty(dataReviewConstants.DR_ORIGINAL_DATE, chromeDriver).clear();
            FrameworkLibrary.getElementByProperty(dataReviewConstants.DR_DRUG_EXP_DATE, chromeDriver).clear();
            FrameworkLibrary.getElementByProperty(dataReviewConstants.DR_REFILL_EXP_DATE, chromeDriver).clear();

            // validate Original Date, Drug Exp Date and Rx Expiration date
            // after passing 8 numbers
            if (clearAndEnterText(dataReviewConstants.DR_ORIGINAL_DATE, "11112011")) {
                hitTab.perform();
                Assert.assertEquals((String) getElementText(dataReviewConstants.DR_ORIGINAL_DATE), "11/11/2011");
            } else {
                throw new Exception("User not able to enter value in prescriber first name text field");
            }

            if (clearAndEnterText(dataReviewConstants.DR_DRUG_EXP_DATE, "11112011")) {
                hitTab.perform();
                Assert.assertEquals((String) getElementText(dataReviewConstants.DR_DRUG_EXP_DATE), "11/11/2011");
            } else {
                throw new Exception("User not able to enter value in prescriber first name text field");
            }

            if (clearAndEnterText(dataReviewConstants.DR_REFILL_EXP_DATE, "11112011")) {
                hitTab.perform();
                Assert.assertEquals((String) getElementText(dataReviewConstants.DR_REFILL_EXP_DATE), "11/11/2011");
            } else {
                throw new Exception("User not able to enter value in prescriber first name text field");
            }

            // clean all date text box
            FrameworkLibrary.getElementByProperty(dataReviewConstants.DR_ORIGINAL_DATE, chromeDriver).clear();
            FrameworkLibrary.getElementByProperty(dataReviewConstants.DR_DRUG_EXP_DATE, chromeDriver).clear();
            FrameworkLibrary.getElementByProperty(dataReviewConstants.DR_REFILL_EXP_DATE, chromeDriver).clear();
            
            // after passing 6 numbers
            if (clearAndEnterText(dataReviewConstants.DR_ORIGINAL_DATE, "111116")) {
                hitTab.perform();
                Assert.assertEquals((String) getElementText(dataReviewConstants.DR_ORIGINAL_DATE), "11/11/2016");
            } else {
                throw new Exception("User not able to enter value in prescriber first name text field");
            }

            if (clearAndEnterText(dataReviewConstants.DR_DRUG_EXP_DATE, "111116")) {
                hitTab.perform();
                Assert.assertEquals((String) getElementText(dataReviewConstants.DR_DRUG_EXP_DATE), "11/11/2016");
            } else {
                throw new Exception("User not able to enter value in prescriber first name text field");
            }

            if (clearAndEnterText(dataReviewConstants.DR_REFILL_EXP_DATE, "111116")) {
                hitTab.perform();
                Assert.assertEquals((String) getElementText(dataReviewConstants.DR_REFILL_EXP_DATE), "11/11/2016");
            } else {
                throw new Exception("User not able to enter value in prescriber first name text field");
            }

            // clean all date text box
            FrameworkLibrary.getElementByProperty(dataReviewConstants.DR_ORIGINAL_DATE, chromeDriver).clear();
            FrameworkLibrary.getElementByProperty(dataReviewConstants.DR_DRUG_EXP_DATE, chromeDriver).clear();
            FrameworkLibrary.getElementByProperty(dataReviewConstants.DR_REFILL_EXP_DATE, chromeDriver).clear();

            // validate error message for Original Date, Drug Exp Date and Rx
            // Expiration date after passing 7 numbers
            if (clearAndEnterText(dataReviewConstants.DR_ORIGINAL_DATE, "1111111")) {
                hitTab.perform();
                Assert.assertTrue(isElementPresentVerification(dataReviewConstants.Incorrect_Original_date));
                Assert.assertEquals((String) getElementText(dataReviewConstants.Incorrect_Original_date),
                        dataReviewConstants.Incorrect_Date_error_msg);
            } else {
                throw new Exception("User not able to enter value in prescriber first name text field");
            }

            if (clearAndEnterText(dataReviewConstants.DR_DRUG_EXP_DATE, "1111111")) {
                Assert.assertTrue(isElementPresentVerification(dataReviewConstants.Incorrect_Exp_date));
                Assert.assertEquals((String) getElementText(dataReviewConstants.Incorrect_Exp_date),
                        dataReviewConstants.Incorrect_Date_error_msg);
            } else {
                throw new Exception("User not able to enter value in prescriber first name text field");
            }

            if (clearAndEnterText(dataReviewConstants.DR_REFILL_EXP_DATE, "1111111")) {
                Assert.assertTrue(isElementPresentVerification(dataReviewConstants.Incorrect_RX_Exp_Date));
                Assert.assertEquals((String) getElementText(dataReviewConstants.Incorrect_RX_Exp_Date),
                        dataReviewConstants.Incorrect_Date_error_msg);
            } else {
                throw new Exception("User not able to enter value in prescriber first name text field");
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * This method is to Click on Update Rx Button in POS
	 */
    @And("^Clicks on UpdateRx Btn$")
    public void clicks_on_updateRx_btn() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_UPDATE_RX_BUTTON)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.DR_UPDATE_RX_BUTTON)) {
                    throw new Exception("unable to click on DR UPDATE RX BUTTON");
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

    @When("^User clicks Update button from product panel$")
    public void userClicksUpdateButtonFromProductPanel() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            isElementPresentVerifyClick(dataReviewConstants.dr_product_update_btn);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^System displays message \"([^\"]*)\"$")
    public void systemDisplaysMessage(String message) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.RX_EXPIRATIONDATE_ERRORMESSAGE)) {
                String error_msg = FrameworkLibrary
                        .getElementByProperty(dataReviewConstants.RX_EXPIRATIONDATE_ERRORMESSAGE, chromeDriver)
                        .getText();
                Assert.assertEquals(error_msg, message);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @When("^User modifies Refills field so that RX Expiration date is past default date allowed by State$")
    public void userModifiesRefillsFieldSoThatRXExpirationDateIsPastDefaultDateAllowedByState(DataTable data)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.drug_refills)) {
                FrameworkLibrary.enter_Text(data, 0, "Refills", dataReviewConstants.drug_refills, chromeDriver);
                chromeDriver.switchTo().activeElement().sendKeys(Keys.TAB);
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
	 * This method is to check the entered refills is in PXXXY format
	 */
    @When("^user validates the entered refills format$")
    public void user_validates_the_entered_refills_format(DataTable arg1) throws Exception {
        Map<String, List<String>> dataMap = FrameworkLibrary.getHorizontalData(arg1);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "Refills");
            String Refills_format = Refills.substring(1, 5);

            if (!Refills_format.matches("\\d{3}[W|D|Y]")) {
                throw new Exception("Entered refills format is wrong");
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @And("^User adds \"([^\"]*)\" days to RX Expiration date field so that it pasts default date allowed by State$")
    public void userAddsDaysToRXExpirationDateFieldSoThatItPastsDefaultDateAllowedByState(int count) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String new_date = addsDaystoOriginDate(count);
            if (isElementPresentVerification(dataReviewConstants.rx_exp_date)) {
                FrameworkLibrary.clearAndEnterText(dataReviewConstants.rx_exp_date, new_date);
                chromeDriver.switchTo().activeElement().sendKeys(Keys.TAB);
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**********
     * Clears Qty, Qty Disp, and Refills values @
     */
    @When("^user clears the Qty, Qty Disp, Refills values$")
    public void user_clears_the_Qty_Qty_Disp_Refills_values() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.drug_qty)
                    && isElementPresentVerification(dataReviewConstants.drug_qty_disp)) {
                FrameworkLibrary.clearTextField(dataReviewConstants.drug_qty);
                FrameworkLibrary.clearTextField(dataReviewConstants.drug_qty_disp);
                FrameworkLibrary.clearTextField(dataReviewConstants.drug_refills);

                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**********
     * Total Prescribed Quantity is intended as Qty * Refills. This step
     * modifies the Qty text box value to be greater. @
     */

    @And("^modifies Qty value as greater than Total Prescribed Qty value and leaves the field$")
    public void modifies_Qty_value_as_greater_than_Total_Prescribed_Qty_value_and_leaves_the_field(DataTable arg1)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.drug_qty)
                    && isElementPresentVerification(dataReviewConstants.drug_qty_disp)) {
                int qtyVal = Integer.parseInt(SmokeTestLibrary.getData(arg1, "Quantity"));
                int refillsVal = Integer.parseInt(SmokeTestLibrary.getData(arg1, "Refills"));
                int totalDispVal = qtyVal + refillsVal;
                int greaterVal = totalDispVal + qtyVal;
                clearAndEnterText(dataReviewConstants.drug_qty, String.valueOf(greaterVal));
                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**********
     * Total Prescribed Quantity is intended as Qty * Refills. This step assert
     * that Qty is greater than Total. @
     */

    @Then("^The system should check if the entered Qty is greater than the Total Prescribed Qty$")
    public void The_system_should_check_if_the_entered_Qty_is_greater_than_the_Total_Prescribed_Qty(DataTable arg1)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.drug_qty)) {
                int qtyVal = Integer.parseInt(SmokeTestLibrary.getData(arg1, "Quantity"));
                int refillsVal = Integer.parseInt(SmokeTestLibrary.getData(arg1, "Refills"));
                int totalDispVal = qtyVal + refillsVal;
                int drugQtyVal = Integer.parseInt(getElementText(dataReviewConstants.drug_qty));
                Assert.assertTrue(drugQtyVal > totalDispVal);

                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**********
     * Total Prescribed Quantity is intended as Qty * Refills. This step assert
     * that Qty Disp is greater than Total. @
     */

    @Then("^The system should check if the entered Qty Disp is greater than the Total Prescribed Qty$")
    public void The_system_should_check_if_the_entered_Qty_Disp_is_greater_than_the_Total_Prescribed_Qty(DataTable arg1)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.drug_qty_disp)) {
                int qtyVal = Integer.parseInt(SmokeTestLibrary.getData(arg1, "Quantity"));
                int refillsVal = Integer.parseInt(SmokeTestLibrary.getData(arg1, "Refills"));
                int totalDispVal = qtyVal + refillsVal;
                int drugQtyDispVal = Integer.parseInt(getElementText(dataReviewConstants.drug_qty_disp));
                Assert.assertTrue(drugQtyDispVal > totalDispVal);

                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**********
     * Total Prescribed Quantity is intended as Qty * Refills. This step
     * modifies the Qty text box value to be equal. @
     */

    @And("^modifies QTY value is equal to Total Prescribed Qty value and leaves the field$")
    public void modifies_QTY_value_is_equal_to_Total_Prescribed_Qty_value_and_leaves_the_field(DataTable arg1)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.drug_qty)
                    && isElementPresentVerification(dataReviewConstants.drug_qty_disp)) {
                int qtyVal = Integer.parseInt(SmokeTestLibrary.getData(arg1, "Quantity"));
                int refillsVal = Integer.parseInt(SmokeTestLibrary.getData(arg1, "Refills"));
                int totalDispVal = qtyVal + refillsVal;
                clearAndEnterText(dataReviewConstants.drug_qty, String.valueOf(totalDispVal));

                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**********
     * Asserts that changing the value is acceptable by attempting it then
     * restoring value @
     */

    @Then("^system should allow the user to enter other values and no message should be displayed$")
    public void system_should_allow_the_user_to_enter_other_values_and_no_message_should_be_displayed(DataTable arg1)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.drug_qty)
                    && isElementPresentVerification(dataReviewConstants.drug_qty_disp)) {
                String oldval1 = getElementText(dataReviewConstants.drug_qty);
                clearAndEnterText(dataReviewConstants.drug_qty, SmokeTestLibrary.getData(arg1, "Quantity"));
                Assert.assertTrue(getElementText(dataReviewConstants.drug_qty)
                        .equals(SmokeTestLibrary.getData(arg1, "Quantity")));
                // Asserts that a new value is entered successfully
                clearAndEnterText(dataReviewConstants.drug_qty, oldval1);
                Assert.assertTrue(getElementText(dataReviewConstants.drug_qty).equals(oldval1));
                // restores old value for consistency

                String oldval2 = getElementText(dataReviewConstants.drug_qty_disp);
                clearAndEnterText(dataReviewConstants.drug_qty_disp, SmokeTestLibrary.getData(arg1, "QuantityDisp"));
                Assert.assertTrue(getElementText(dataReviewConstants.drug_qty_disp)
                        .equals(SmokeTestLibrary.getData(arg1, "QuantityDisp")));
                // Asserts that a new value is entered successfully
                clearAndEnterText(dataReviewConstants.drug_qty_disp, oldval2);
                Assert.assertTrue(getElementText(dataReviewConstants.drug_qty_disp).equals(oldval2));
                // restores old value for consistency

                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**********
     * Total Prescribed Quantity is intended as Qty * Refills. This step
     * modifies the Qty text box value to be less. @
     */

    @And("^modifies QTY value is less than Total Prescribed Qty value and leaves the field$")
    public void modifies_QTY_value_is_less_than_Total_Prescribed_Qty_value_and_leaves_the_field(DataTable arg1)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.drug_qty)
                    && isElementPresentVerification(dataReviewConstants.drug_qty_disp)) {
                int qtyVal = Integer.parseInt(SmokeTestLibrary.getData(arg1, "Quantity"));
                int refillsVal = Integer.parseInt(SmokeTestLibrary.getData(arg1, "Refills"));
                int totalDispVal = qtyVal + refillsVal;
                int lesserVal = totalDispVal - qtyVal;
                clearAndEnterText(dataReviewConstants.drug_qty, String.valueOf(lesserVal));
                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**********
     * Clears Qty Disp and Refills values @
     */

    @When("^user clears the Qty Disp, Refills values$")
    public void user_clears_the_Qty_Disp_Refills_values() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.drug_qty_disp)
                    && isElementPresentVerification(dataReviewConstants.drug_refills)) {
                FrameworkLibrary.clearTextField(dataReviewConstants.drug_qty_disp);
                FrameworkLibrary.clearTextField(dataReviewConstants.drug_refills);
                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**********
     * Total Prescribed Quantity is intended as Qty * Refills. This step
     * modifies the Qty Disp text box value to be greater. @
     */

    @And("^modifies Qty Disp value as greater than Total Prescribed Qty value and leaves the field$")
    public void modifies_Qty_Disp_value_as_greater_than_Total_Prescribed_Qty_value_and_leaves_the_field(DataTable arg1)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.drug_qty)
                    && isElementPresentVerification(dataReviewConstants.drug_qty_disp)) {
                int qtyVal = Integer.parseInt(SmokeTestLibrary.getData(arg1, "Quantity"));
                int refillsVal = Integer.parseInt(SmokeTestLibrary.getData(arg1, "Refills"));
                int totalDispVal = qtyVal + refillsVal;
                int greaterVal = totalDispVal + qtyVal;
                clearAndEnterText(dataReviewConstants.drug_qty_disp, String.valueOf(greaterVal));
                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**********
     * Total Prescribed Quantity is intended as Qty * Refills. This step
     * modifies the Qty text box value to be equal. @
     */

    @And("^modifies QTY Disp value is equal to Total Prescribed Qty value and leaves the field$")
    public void modifies_QTY_Disp_value_is_equal_to_Total_Prescribed_Qty_value_and_leaves_the_field(DataTable arg1)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.drug_qty)
                    && isElementPresentVerification(dataReviewConstants.drug_qty_disp)) {
                int qtyVal = Integer.parseInt(SmokeTestLibrary.getData(arg1, "Quantity"));
                int refillsVal = Integer.parseInt(SmokeTestLibrary.getData(arg1, "Refills"));
                int totalDispVal = qtyVal + refillsVal;
                clearAndEnterText(dataReviewConstants.drug_qty_disp, String.valueOf(totalDispVal));
                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**********
     * Total Prescribed Quantity is intended as Qty * Refills. This step
     * modifies the Qty text box value to be less. @
     */

    @And("^modifies QTY Disp value is less than Total Prescribed Qty value and leaves the field$")
    public void modifies_QTY_Disp_value_is_less_than_Total_Prescribed_Qty_value_and_leaves_the_field(DataTable arg1)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.drug_qty)
                    && isElementPresentVerification(dataReviewConstants.drug_qty_disp)) {
                int qtyVal = Integer.parseInt(SmokeTestLibrary.getData(arg1, "Quantity"));
                int refillsVal = Integer.parseInt(SmokeTestLibrary.getData(arg1, "Refills"));
                int totalDispVal = qtyVal + refillsVal;
                int lesserVal = totalDispVal - qtyVal;
                clearAndEnterText(dataReviewConstants.drug_qty_disp, String.valueOf(lesserVal));
                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**********
     * Clears Refills values @
     */

    @When("^user clears the Refills value$")
    public void user_clears_the_Refills_value() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.drug_refills)) {
                FrameworkLibrary.clearTextField(dataReviewConstants.drug_refills);

                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }
        } catch (Exception e) {

            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**********
     * Changes value of Refill to 8 @
     */

    @And("^modifies Refills value 8$")
    public void modifies_Refills_value_8() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.drug_refills)) {
                FrameworkLibrary.clearAndEnterText(dataReviewConstants.drug_refills, "8");
                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^focus should be on '(\\d+) Accept'$")
    public void focus_should_be_on_Accept(String arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String Button = "";
            if (arg1.equals("1 Accept")) {
                Button = dataReviewConstants.one_accept;
            } else if (arg1.equals("2 Accept")) {
                Button = dataReviewConstants.two_accept;
            } else if (arg1.equals("3 Accept")) {
                Button = dataReviewConstants.three_accept;
            }
            if (!(Button.equals(""))) {
                if (isElementPresentVerification(Button)) {
                    Assert.assertTrue(
                            getElementByProperty(Button, chromeDriver).getAttribute("class").contains("md-focused"));
                }
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^user hits the Space Bar$")
    public void user_hits_the_Space_Bar() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions Key = new Actions(chromeDriver);
            Action Space = Key.sendKeys(Keys.ENTER).build();
            Space.perform();
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @Then("^the color and name of the '(\\d+) Accept' button will change to '(\\d+) Unaccept'$")
    public void the_color_and_name_of_the_Accept_button_will_change_to_Unaccept(String arg1, String arg2)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String Button = "";
            if (arg1.equals("1 Accept")) {
                Button = dataReviewConstants.one_accept;
            } else if (arg1.equals("2 Accept")) {
                Button = dataReviewConstants.two_accept;
            } else if (arg1.equals("3 Accept")) {
                Button = dataReviewConstants.three_accept;
            }
            if (!(Button.equals(""))) {
                if (isElementPresentVerification(Button)) {
                    Assert.assertTrue(
                            getElementByProperty(Button, chromeDriver).getAttribute("class").contains("md-focused"));
                    Assert.assertTrue(getElementByProperty(Button, chromeDriver).getAttribute("style")
                            .contains("background: rgb(0, 137, 123)"));
                    Assert.assertTrue(getElementText(Button).contains(arg2));

                }
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }

    }

    @Then("^adds validation flag '(\\d+) Accept' to the Patient to indicate the patient has been validated$")
    public void adds_validation_flag_to_the_Patient_to_indicate_the_patient_has_been_validated(String arg)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String Button = "";
            if (arg.equals("1 Accept")) {
                Button = dataReviewConstants.Dr_one_accept_correct_sign;
            } else if (arg.equals("2 Accept")) {
                Button = dataReviewConstants.Dr_two_accept_correct_sign;
            } else if (arg.equals("3 Accept")) {
                Button = dataReviewConstants.Dr_three_accept_correct_sign;
            }
            if (!(Button.equals(""))) {
                if (isElementPresentVerification(dataReviewConstants.Dr_one_accept_correct_sign)) {
                    Assert.assertTrue(isElementPresentVerification(dataReviewConstants.Dr_one_accept_correct_sign));
                }
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^system changes the color and the name of the '(\\d+) Unaccept' button to '(\\d+) Accept'$")
    public void system_changes_the_color_and_the_name_of_the_Unaccept_button_to_Accept(String arg1, String arg2)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String Button = "";
            if (arg1.equals("1 Unaccept")) {
                Button = dataReviewConstants.one_accept;
            } else if (arg1.equals("2 Unaccept")) {
                Button = dataReviewConstants.two_accept;
            } else if (arg1.equals("3 Unaccept")) {
                Button = dataReviewConstants.three_accept;
            }
            if (!(Button.equals(""))) {
                if (isElementPresentVerification(Button)) {
                    Assert.assertTrue(
                            getElementByProperty(Button, chromeDriver).getAttribute("class").contains("md-focused"));
                    Assert.assertTrue(!(getElementByProperty(Button, chromeDriver).getAttribute("style")
                            .contains("background: rgb(0, 137, 123)")));
                    Assert.assertTrue(getElementText(Button).contains(arg2));
                }
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^removes the validation '(\\d+) Unaccept' flag from the Patient$")
    public void removes_the_validation_flag_from_the_Patient(String arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            String Button = "";
            if (arg1.equals("1 Unaccept")) {
                Button = dataReviewConstants.Dr_one_accept_correct_sign;
            } else if (arg1.equals("2 Unaccept")) {
                Button = dataReviewConstants.Dr_two_accept_correct_sign;
            } else if (arg1.equals("3 Unaccept")) {
                Button = dataReviewConstants.Dr_three_accept_correct_sign;
            }
            if (!(Button.equals(""))) {
                Assert.assertFalse(isElementPresents(Button));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Moves the focus to the Accept button '(\\d+) Accept' element$")
    public void moves_the_focus_to_the_accept_button_element(String arg) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            int j = 0;
            if (arg.equals("2 Accept")) {
                j = 3;
            } else if (arg.equals("3 Accept")) {
                j = 2;
            } else {
                j = 3;
            }

            for (int i = 0; i < j; i++) {
                Actions key = new Actions(chromeDriver);
                Action Space = key.sendKeys(Keys.TAB).build();
                Space.perform();
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Validate message$")
    public void validate_message() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            boolean isTheTextPresent = chromeDriver.getPageSource()
                    .contains("This patient might have a coupon for this prescription");
            Assert.assertTrue(isTheTextPresent);

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @And("^User checks the first accept button is selected$")
    public void userChecksTheFirstAcceptButtonIsSelected() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            boolean patientAccept = IntakeLibrary
                    .isElementPresent(hangOnConstants.DATA_REVIEW_FIRST_ACCEPT_BUTTON_STATUS);
            org.testng.Assert.assertTrue(patientAccept, "Patient accept button is not in accepted state");
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @And("^adds validation flag to the product to indicate the product details had been validated$")
    public void addsValidationFlagToThePatientToIndicateTheProductDetailsHadBeenValidated() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {

            boolean validationFlag = chromeDriver.findElement(By.xpath(dataReviewConstants.DR_PRODUCT_VALIDATION_FLAG))
                    .isDisplayed();
            Assert.assertTrue(validationFlag, "Product details are not validated in DR");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @And("^User checks the third accept button is selected$")
    public void userChecksTheThirdAcceptButtonIsSelected() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            boolean productAccept = IntakeLibrary
                    .isElementPresent(hangOnConstants.DATA_REVIEW_THIRD_ACCEPT_BUTTON_STATUS);
            org.testng.Assert.assertTrue(productAccept, "Product accept button is not in accepted state");

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @And("^adds validation flag to the prescriber to indicate the prescriber details had been validated$")
    public void addsValidationFlagToThePatientToIndicateThePrescriberDetailsHadBeenValidated() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            boolean validationFlag = chromeDriver
                    .findElement(By.xpath(dataReviewConstants.DR_PRESCRIBER_VALIDATION_FLAG)).isDisplayed();
            Assert.assertTrue(validationFlag, "Prescriber details are not validated in DR");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @And("^User checks the second accept button is selected$")
    public void userChecksTheSecondAcceptButtonIsSelected() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            boolean prescriberAccept = IntakeLibrary
                    .isElementPresent(hangOnConstants.DATA_REVIEW_SECOND_ACCEPT_BUTTON_STATUS);
            org.testng.Assert.assertTrue(prescriberAccept, "Prescriber accept button is not accepted state");

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @And("^adds validation flag to the Patient to indicate the patient details had been validated$")
    public void addsValidationFlagToThePatientToIndicateThePatientDetailsHadBeenValidated() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            boolean validationFlag = chromeDriver.findElement(By.xpath(dataReviewConstants.DR_PATIENT_VALIDATION_FLAG))
                    .isDisplayed();
            Assert.assertTrue(validationFlag, "Patient details are not validated in DR");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @When("^user hit tab in dr$")
    public void user_hits_tab_in_dr() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions Key = new Actions(chromeDriver);
            Action tab = Key.sendKeys(Keys.TAB).build();
            tab.perform();
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^focus should be on '(\\d+) Search' button in dr$")
    public void focus_should_be_on_Search_button_in_dr(String arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String Button = "";
            if (arg1.equals("1 Search")) {
                Button = dataReviewConstants.DR_ONE_PATIENT_SEARCH;
            } else if (arg1.equals("2 Search")) {
                Button = dataReviewConstants.DR_TWO_PRESCRIBER_SEARCH;
            } else if (arg1.equals("3 Search")) {
                Button = dataReviewConstants.DR_THREE_PRODUCT_SEARCH;
            }
            if (!(Button.equals(""))) {
                if (isElementPresentVerification(Button)) {
                    Assert.assertTrue(
                            getElementByProperty(Button, chromeDriver).getAttribute("class").contains("md-focused"));
                }
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on payment dropdown$")
    public void focus_should_be_on_payment_dropdown() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
                Assert.assertTrue(getElementByProperty(SmokeTestConstants.Payment_Dropdown, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on paycode$")
    public void focus_should_be_on_paycode() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_paycode_focus)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_paycode_focus, chromeDriver)
                        .getAttribute("class").contains("md-input-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on payment cash$")
    public void focus_should_be_on_payment_cash() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_PAYMENT_CASH)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_cash_amount_focus, chromeDriver)
                        .getAttribute("class").contains("md-input-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on Finish button$")
    public void focus_should_be_on_finish_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.DR_FINISH)) {
                if (!getElementByProperty(SmokeTestConstants.DR_FINISH, chromeDriver).getAttribute("class").contains("md-focused")) {
                    throw new Exception("Focus not on Finish button");
                }
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on Send to IC plus button$")
    public void focus_should_be_on_send_to_ic_plus_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_SEND_TO_IC_PLUS)) {
                if (!getElementByProperty(dataReviewConstants.DR_SEND_TO_IC_PLUS, chromeDriver).getAttribute("class").contains("md-focused")) {
                    throw new Exception("Focus not on IC plus button");
                }
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on Cancel button$")
    public void focus_should_be_on_cancel_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_PRESCRIPTION_CANCEL_BUTTON)) {
                if (getElementByProperty(dataReviewConstants.DR_PRESCRIPTION_CANCEL_BUTTON, chromeDriver).getAttribute("class").contains("md-focused")) {
                    throw new Exception("Focus not on cancel button.");
                }
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on Side Front button$")
    public void focus_should_be_on_side_front_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_SIDE_FRONT)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_SIDE_FRONT, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on Rotate Clockwise button$")
    public void focus_should_be_on_rotate_clockwise_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_SIDE_CLOCKWISE_BUTTON)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_SIDE_CLOCKWISE_BUTTON, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on Rotate CounterClockwise button$")
    public void focus_should_be_on_rotate_counterClockwise_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_SIDE_COUNTERCLOCKWISE_BUTTON)) {
                Assert.assertTrue(
                        getElementByProperty(dataReviewConstants.DR_SIDE_COUNTERCLOCKWISE_BUTTON, chromeDriver)
                                .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on Reset Image button$")
    public void focus_should_be_on_Reset_Image_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_SIDE_RESET_IMAGE)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_SIDE_RESET_IMAGE, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on Zoom in button$")
    public void focus_should_be_on_zoom_in_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_SIDE_ZOOM_IN_BUTTON)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_SIDE_ZOOM_IN_BUTTON, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on Zoom Out button$")
    public void focus_should_be_on_zoom_out_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_SIDE_ZOOM_OUT_BUTTON)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_SIDE_ZOOM_OUT_BUTTON, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on Full screen button$")
    public void focus_should_be_on_full_screen_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_SIDE_FULL_SCREEN_BUTTON)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_SIDE_FULL_SCREEN_BUTTON, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on Back button$")
    public void focus_should_be_on_back_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_BACK_BUTTON)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_BACK_BUTTON, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on Patient hyperlink$")
    public void focus_should_be_on_patient_hyperlink() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_PATIENT_HYPERLINK)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_PATIENT_HYPERLINK, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on ORIGINAL DATE$")
    public void focus_should_be_on_original_date() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_ORIGINAL_DATE)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_ORIGINAL_DATE, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on DAW$")
    public void focus_should_be_on_daw() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_DAW_TEXT)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_DAW_TEXT, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on SUBSTITUTE$")
    public void focus_should_be_on_substitute() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_SUBSTITUTE_TEXT)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_SUBSTITUTE_TEXT, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on INPUT_PRESCRIBED_PRODUCT$")
    public void focus_should_be_on_input_prescribed_product() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_INPUT_PRESCRIBED_PRODUCT)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_INPUT_PRESCRIBED_PRODUCT, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on PRESCRIBER PRODUCT CHANGE BUTTON$")
    public void focus_should_be_on_prescriber_product_change_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_PRESCRIBER_PRODUCT_CHANGE_BUTTON)) {
                Assert.assertTrue(
                        getElementByProperty(dataReviewConstants.DR_PRESCRIBER_PRODUCT_CHANGE_BUTTON, chromeDriver)
                                .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on DR DRUG EXP DATE$")
    public void focus_should_be_on_dr_drug_exp_date() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_DRUG_EXP_DATE)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_DRUG_EXP_DATE, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on DR QTY PRESCRIBED$")
    public void focus_should_be_on_dr_qty_prescribed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_QTY_PRESCRIBED)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_QTY_PRESCRIBED, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on DR QTY DISPENSED$")
    public void focus_should_be_on_dr_qty_dispensed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_QTY_DISPENSED)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_QTY_DISPENSED, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on DR REFILL EXP DATE$")
    public void focus_should_be_on_dr_refill_exp_date() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_REFILL_EXP_DATE)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_REFILL_EXP_DATE, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on DR DIRECTION$")
    public void focus_should_be_on_dr_direction() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.drug_direction)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.drug_direction, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }
    // Then Focus should be on Side Front button

    @Then("^Focus should be on DAYS SUPPLY$")
    public void focus_should_be_on_days_supply() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_DAYS_SUPPLY)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_DAYS_SUPPLY, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on NUMBER REFILL$")
    public void focus_should_be_on_number_refill() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_NUMBER_REFILL)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_NUMBER_REFILL, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @When("^User hit right arrow key$")
    public void user_hit_right_arrow_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions Key = new Actions(chromeDriver);
            Action arrow_right = Key.keyDown(Keys.ARROW_RIGHT).keyUp(Keys.ARROW_RIGHT).build();
            arrow_right.perform();
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Focus should be on Side Back button$")
    public void focus_should_be_on_side_back_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_SIDE_BACK)) {
                Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_SIDE_BACK, chromeDriver)
                        .getAttribute("class").contains("md-focused"));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @And("^User hit enter key$")
    public void user_hit_enter_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions Key = new Actions(chromeDriver);
            Action enter = Key.sendKeys(Keys.ENTER).build();
            enter.perform();
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @When("^User hit left arrow key$")
    public void user_hit_left_arrow_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions Key = new Actions(chromeDriver);
            Action arrow_right = Key.keyDown(Keys.ARROW_LEFT).keyUp(Keys.ARROW_LEFT).build();
            arrow_right.perform();
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * This method checks for the validation flag removed from patient details
	 */
    @And("^removes the validation flag from the Patient details$")
    public void removesTheValidationFlagFromThePatientDetails() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            boolean validationFlag = chromeDriver.findElement(By.xpath(dataReviewConstants.DR_PATIENT_VALIDATION_FLAG))
                    .isDisplayed();
            Assert.assertTrue(!validationFlag, "validation flag from the Patient details is not removed in DR");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**
     * This method will click on patient accept button using mouse.
     */
    @And("^user clicks with mouse on the (\\d+) Accept button for patient details$")
    public void userClicksWithMouseTheAcceptButtonForPatientDetails(int arg0) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Patient_AccceptButton)) {
                HoverAndClick(chromeDriver, SmokeTestConstants.Patient_AccceptButton,
                        SmokeTestConstants.Patient_AccceptButton);
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
     * This method will click on patient unaccept button using mouse.
     */
    @And("^user clicks with mouse on the (\\d+) Unaccept button for patient details$")
    public void userClicksWithMouseOnTheUnacceptButtonForPatientDetails(int arg0) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Patient_AccceptButton)) {
                HoverAndClick(chromeDriver, SmokeTestConstants.Patient_AccceptButton,
                        SmokeTestConstants.Patient_AccceptButton);
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
     * This method will click on Prescriber accept button using mouse.
     */
    @And("^user clicks with mouse on the (\\d+) Accept button for prescriber details$")
    public void userClicksWithMouseOnTheAcceptButtonForPrescriberDetails(int arg0) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Prescriber_AcceptButton)) {
                HoverAndClick(chromeDriver, SmokeTestConstants.Prescriber_AcceptButton,
                        SmokeTestConstants.Prescriber_AcceptButton);
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
     * This method will click on Prescriber unaccept button using mouse.
     */
    @And("^user clicks with mouse on the (\\d+) Unaccept button for prescriber details$")
    public void userClicksWithMouseOnTheUnacceptButtonForPrescriberDetails(int arg0) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Prescriber_AcceptButton)) {
                HoverAndClick(chromeDriver, SmokeTestConstants.Prescriber_AcceptButton,
                        SmokeTestConstants.Prescriber_AcceptButton);
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
     * This method will click on product accept button using mouse.
     */
    @And("^user clicks with mouse on the (\\d+) Accept button for product details$")
    public void userClicksWithMouseOnTheAcceptButtonForProductDetails(int arg0) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Product_AcceptButton)) {
                HoverAndClick(chromeDriver, SmokeTestConstants.Product_AcceptButton,
                        SmokeTestConstants.Product_AcceptButton);
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
     * This method will click on product unaccept button using mouse.
     */
    @And("^user clicks with mouse on the (\\d+) Unaccept button for product details$")
    public void userClicksWithMouseOnTheUnacceptButtonForProductDetails(int arg0) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Product_AcceptButton)) {
                HoverAndClick(chromeDriver, SmokeTestConstants.Product_AcceptButton,
                        SmokeTestConstants.Product_AcceptButton);
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
	 * This method checks for the validation flag removed from prescriber
	 * details
	 */
    @And("^removes the validation flag from the Prescriber details$")
    public void removesTheValidationFlagFromThePrescriberDetails() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            boolean validationFlag = chromeDriver
                    .findElement(By.xpath(dataReviewConstants.DR_PRESCRIBER_VALIDATION_FLAG)).isDisplayed();
            Assert.assertTrue(!validationFlag, "validation flag from the Prescriber details is not removed in DR");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * This method checks for the validation flag removed from product details
	 */
    @And("^removes the validation flag from the product details$")
    public void removesTheValidationFlagFromTheProductDetails() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            boolean validationFlag = chromeDriver.findElement(By.xpath(dataReviewConstants.DR_PRODUCT_VALIDATION_FLAG))
                    .isDisplayed();
            Assert.assertTrue(!validationFlag, "Product details are not validated in DR");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * This method will click on accept button for patient details using enter
	 * key on Keyboard
	 */
    @And("^user hits enter on keyboard on the (\\d+) Accept button for patient details$")
    public void userHitsEnterOnKeyboardOnTheAcceptButtonForPatientDetails(int arg0) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Patient_AccceptButton)) {
                HitEnterKey(SmokeTestConstants.Patient_AccceptButton);
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
	 * This method will click on unaccept button for patient details using enter
	 * key on Keyboard
	 */
    @And("^user hits enter on keyboard on the (\\d+) Unaccept button for patient details$")
    public void userHitsEnterOnKeyboardOnTheUnacceptButtonForPatientDetails(int arg0) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Patient_AccceptButton)) {
                HitEnterKey(SmokeTestConstants.Patient_AccceptButton);
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
	 * This method will click on accept button for prescriber details using
	 * enter key on Keyboard
	 */
    @And("^user hits enter on keyboard on the (\\d+) Accept button for prescriber details$")
    public void userHitsEnterOnKeyboardOnTheAcceptButtonForPrescriberDetails(int arg0) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Prescriber_AcceptButton)) {
                HitEnterKey(SmokeTestConstants.Prescriber_AcceptButton);
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
	 * This method will click on unaccept button for prescriber details using
	 * enter key on Keyboard
	 */
    @And("^user hits enter on keyboard on the (\\d+) Unaccept button for prescriber details$")
    public void userHitsEnterOnKeyboardOnTheUnacceptButtonForPrescriberDetails(int arg0) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Prescriber_AcceptButton)) {
                HitEnterKey(SmokeTestConstants.Prescriber_AcceptButton);
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
	 * This method will click on accept button for product details using enter
	 * key on Keyboard
	 */
    @And("^user hits enter on keyboard on the (\\d+) Accept button for product details$")
    public void userHitsEnterOnKeyboardOnTheAcceptButtonForProductDetails(int arg0) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Product_AcceptButton)) {
                HitEnterKey(SmokeTestConstants.Product_AcceptButton);
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
	 * This method will click on unaccept button for product details using enter
	 * key on Keyboard
	 */
    @And("^user hits enter on keyboard on the (\\d+) Unaccept button for product details$")
    public void userHitsEnterOnKeyboardOnTheUnacceptButtonForProductDetails(int arg0) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Product_AcceptButton)) {
                HitEnterKey(SmokeTestConstants.Product_AcceptButton);
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @When("^validate the original date by entering six digits in product information$")
    public void validate_the_original_date_by_entering_six_digits_in_product_information(DataTable arg1)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        String Date = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                dataMap.get("RowId").get(0), "Date");
        try {
            if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
                if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, Date)) {
                    throw new Exception("Not able to enter value in user name text field");
                }
                Actions Tab = new Actions(chromeDriver);
                Action PressTab = Tab.sendKeys(Keys.TAB).build();
                PressTab.perform();
                if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
                    String sixdigitdate = FrameworkLibrary.getElementText(SmokeTestConstants.Product_OriginalDate);
                    String newdate = Date.substring(0, 4) + "20" + Date.substring(4, 6);
                    SimpleDateFormat originaldate = new SimpleDateFormat("MMddyyyy");
                    Date date = originaldate.parse(newdate);
                    originaldate.applyPattern("MM/dd/yyyy");
                    String fd = originaldate.format(date);
                    Assert.assertEquals(sixdigitdate, fd);
                }
            }
            String Expirydate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "Date");
            if (isElementPresentVerification(SmokeTestConstants.DrugExpiryDate_Field)) {
                if (!clearAndEnterText(SmokeTestConstants.DrugExpiryDate_Field, Expirydate)) {
                    throw new Exception("Not able to enter value in user name text field");
                }
                Actions Tab = new Actions(chromeDriver);
                Action PressTab = Tab.sendKeys(Keys.TAB).build();
                PressTab.perform();
                if (isElementPresentVerification(SmokeTestConstants.DrugExpiryDate_Field)) {
                    String sixdigitdate1 = FrameworkLibrary.getElementText(SmokeTestConstants.DrugExpiryDate_Field);
                    String newdate = Expirydate.substring(0, 4) + "20" + Expirydate.substring(4, 6);
                    SimpleDateFormat originaldate = new SimpleDateFormat("MMddyyyy");
                    Date date = originaldate.parse(newdate);
                    originaldate.applyPattern("MM/dd/yyyy");
                    String fd = originaldate.format(date);
                    Assert.assertEquals(sixdigitdate1, fd);
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

    @When("^validate the original date by entering eight digits in product information$")
    public void validate_the_original_date_by_entering_eight_digits_in_product_information(DataTable arg1)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        String Date = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                dataMap.get("RowId").get(0), "Date");
        try {
            if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
                if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, Date)) {
                    throw new Exception("Not able to enter value in user name text field");
                }
                Actions Tab = new Actions(chromeDriver);
                Action PressTab = Tab.sendKeys(Keys.TAB).build();
                PressTab.perform();
                if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
                    String eightdigitdate = FrameworkLibrary.getElementText(SmokeTestConstants.Product_OriginalDate);
                    SimpleDateFormat originaldate = new SimpleDateFormat("MMddyyyy");
                    Date date = originaldate.parse(Date);
                    originaldate.applyPattern("MM/dd/yyyy");
                    String fd = originaldate.format(date);
                    Assert.assertEquals(eightdigitdate, fd);
                }
            }
            Date today = Calendar.getInstance().getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy");
            String Date_1 = formatter.format(today);
            if (isElementPresentVerification(SmokeTestConstants.DrugExpiryDate_Field)) {
                if (!clearAndEnterText(SmokeTestConstants.DrugExpiryDate_Field, Date_1)) {
                    throw new Exception("Not able to enter value in user name text field");
                }
                Actions Tab = new Actions(chromeDriver);
                Action PressTab = Tab.sendKeys(Keys.TAB).build();
                PressTab.perform();
                if (isElementPresentVerification(SmokeTestConstants.DrugExpiryDate_Field)) {
                    String eightdigitdate = FrameworkLibrary.getElementText(SmokeTestConstants.DrugExpiryDate_Field);
                    SimpleDateFormat originaldate = new SimpleDateFormat("MMddyyyy");
                    Date date = originaldate.parse(Date_1);
                    originaldate.applyPattern("MM/dd/yyyy");
                    String fd = originaldate.format(date);
                    Assert.assertEquals(eightdigitdate, fd);
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

    @When("^validate the original date by entering seven digits in product information$")
    public void validate_the_original_date_by_entering_seven_digits_in_product_information(DataTable arg1)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            String Date = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "Date");
            if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
                if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, Date)) {
                    throw new Exception("Not able to enter value in user name text field");
                }
                Actions Tab = new Actions(chromeDriver);
                Action PressTab = Tab.sendKeys(Keys.TAB).build();
                PressTab.perform();
                if (isElementPresentVerification(dataReviewConstants.Incorrect_Original_date)) {
                    String errormessage = FrameworkLibrary.getElementText(dataReviewConstants.Incorrect_Original_date);
                    Assert.assertEquals(errormessage, dataReviewConstants.Incorrect_Date_error_msg);
                }
            }
            String Expirydate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "Date");
            if (isElementPresentVerification(SmokeTestConstants.DrugExpiryDate_Field)) {
                if (!clearAndEnterText(SmokeTestConstants.DrugExpiryDate_Field, Expirydate)) {
                    throw new Exception("Not able to enter value in user name text field");
                }
                Actions Tab = new Actions(chromeDriver);
                Action PressTab = Tab.sendKeys(Keys.TAB).build();
                PressTab.perform();
                if (isElementPresentVerification(dataReviewConstants.Incorrect_Exp_date)) {
                    String errormessage = FrameworkLibrary.getElementText(dataReviewConstants.Incorrect_Exp_date);
                    Assert.assertEquals(errormessage, dataReviewConstants.Incorrect_Date_error_msg);
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

    @When("^validate if any message is displayed$")
    public void validate_if_any_message_is_displayed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.Payment_message)) {
                boolean ad = chromeDriver.getPageSource().contains(dataReviewConstants.Payment_message);
                Assert.assertFalse(ad);
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*********************************************************************************
     * Opens product panel in DR
     *
     * @throws Exception
     **********************************************************************************/
    @When("^user opens product panel$")
    public void user_opens_product_panel() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.dr_product_update_btn)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.dr_product_update_btn)) {
                    throw new Exception("Unable to open product panel");
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

    /*********************************************************************************
     * Enters only a drug in the DE product section
     *
     * @throws Exception
     **********************************************************************************/
    @And("^user verifies Rx Expiration Date$")
    public void user_verifies_Rx_Expiration_Date() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.rx_exp_date)) {
                if (getElementText(dataReviewConstants.rx_exp_date).equals(null)) {
                    throw new Exception("Exp Date not available.");
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

    /*********************************************************************************
     * Asserts that Rx expiration date is disabled.
     *
     * @throws Exception
     **********************************************************************************/
    @Then("^Rx expiration date should be disabled$")
    public void Rx_expiration_date_should_be_disabled() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.rx_exp_date)) {
                if (!getElementByProperty(dataReviewConstants.rx_exp_date, chromeDriver).getAttribute("disabled")
                        .equals("disabled")) {
                    throw new Exception("Rx Exp Date not disabled");
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

    /*********************************************************************************
     * Enters only a drug in the DE product section
     *
     * @throws Exception
     **********************************************************************************/
    @When("^user verifies Refills field$")
    public void user_verifies_Refills_field() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.drug_refills)) {
                if (getElementText(dataReviewConstants.drug_refills).equals(null)) {
                    throw new Exception("Exp Date not available.");
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

    /*********************************************************************************
     * Asserts that Refills is disabled.
     *
     * @throws Exception
     **********************************************************************************/
    @Then("^Refills should be disabled$")
    public void Refills_should_be_disabled() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.drug_refills)) {
                if (!getElementByProperty(dataReviewConstants.drug_refills, chromeDriver).getAttribute("disabled")
                        .equals("disabled")) {
                    throw new Exception("Rx Exp Date not disabled");
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

    /*********************************************************************************
     * Replaces current refill data with string "PRN"
     *
     * @throws Exception
     **********************************************************************************/
    @And("^user clears Refills data and modifies the Refills value as \"([^\"]*)\"$")
    public void user_clears_Refills_data_and_modifies_the_Refills_value_as(String value) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.drug_refills)) {
                if (!clearAndEnterText(dataReviewConstants.drug_refills, value)) {
                    throw new Exception("Unable to modify refills");
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

    // And user leaves the Refills field

    /*********************************************************************************
     * Takes focus away from Refills field.
     *
     * @throws Exception
     **********************************************************************************/
    @And("^user leaves the Refills field$")
    public void user_leaves_the_Refills_field() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.drug_refills)) {
                if (getElementByProperty(SmokeTestConstants.Refills_field, chromeDriver).getAttribute("class")
                        .contains("md-focused")) {
                    throw new Exception("Not able to shift focus.");
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
	 * This method is used to select a payment type as ILBC plan with a drug
	 * associated
	 *
	 * @param arg1
	 *
	 * @throws Exception
	 */
    @When("^selects payment type as plan that has no expiration date but drug associated to it$")
    public void select_payment_type_plan__that_has_no_exp_date_drug_associated(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
                isElementPresentVerifyClick(SmokeTestConstants.Payment_Dropdown);
            }

            WebElement couponPlan = chromeDriver.findElementsByXPath(dataReviewConstants.DE_ILBCplan).get(1);
            if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
                couponPlan.click();
            }

            String Drug = SmokeTestLibrary.getData(arg1, "DrugName").toUpperCase();
            if (isElementPresentVerification("//button[contains(text(),'" + Drug + "')]")) {
                isElementPresentVerifyClick("//button[contains(text(),'" + Drug + "')]");
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
	 * This method is used to assert that the payment plan message is displayed
	 * when a patient with coupon plan and drug associated is used.
	 */
    @Then("^System should display the following message in the expanded Payment Panel \"([^\"]*)\"$")
    public void system_should_display_the_following_message_in_the_expanded_Payment_Panel(String arg1)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Assert.assertTrue((getElementText(dataReviewConstants.DR_payment_plan_message).toUpperCase()
                    .contains(arg1.toUpperCase())));

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * Method to update Refill field value in UpdateRx page
	 */
    @Then("^update refill data$")
    public void update_refill_data(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            Map<String, List<String>> dataMap = null;
            dataMap = FrameworkLibrary.getHorizontalData(arg1);
            String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "Refills");

            if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
                if (!clearAndEnterText(SmokeTestConstants.Refills_field, Refills)) {
                    throw new Exception("Not able to enter value in Refills text field");
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
	 * Method to click Update button to finish UpdateRx functionality
	 */
    @Then("^clicks Update button to complete UpdateRX functionality$")
    public void clicks_Update_button_to_complete_UpdateRX_functionality() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.UPDATERX_UPDATE_BUTTON)) {
                proxy.newHar();
                if (!isElementPresentVerifyClick(dataReviewConstants.UPDATERX_UPDATE_BUTTON)) {
                    throw new Exception("Not able to click UpdateButton");
                }
                waitForVisibility(dataReviewConstants.CLOSE_UPDATERX_POPUP);
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

    /*
	 * Method to close the popup window which appears after
	 *  UpdateRX functionality
	 */
    @Then("^user clicks close button on popup dialog$")
    public void user_clicks_close_button_on_popup_dialog() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.CLOSE_UPDATERX_POPUP)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.CLOSE_UPDATERX_POPUP)) {
                    throw new Exception("Not able to click close button");
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
	 * Validate Original Date, Drug Exp Date and Rx Expiration date in RXUPDATE
	 * PAGE pass 6 and 7 numbers in each date text box and validate result.
	 */
    @Then("^Validate rxupdate page Original Date, Drug Exp Date and Rx Expiration date field and validate Error message$")
    public void validate_rxupdate_page_Original_Date_Drug_Exp_Date_and_Rx_Expiration_date_field_and_validate_error_message()
            throws Exception {

        Actions tab = new Actions(chromeDriver);
        Action hitTab = tab.sendKeys(Keys.TAB).build();
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            // validate date element present or not
            Assert.assertTrue(isElementPresentVerification(dataReviewConstants.DR_ORIGINAL_DATE));
            Assert.assertTrue(isElementPresentVerification(dataReviewConstants.DR_DRUG_EXP_DATE));
            Assert.assertTrue(isElementPresentVerification(dataReviewConstants.DR_REFILL_EXP_DATE));

            // clean all date text box
            FrameworkLibrary.getElementByProperty(dataReviewConstants.DR_ORIGINAL_DATE, chromeDriver).clear();
            FrameworkLibrary.getElementByProperty(dataReviewConstants.DR_DRUG_EXP_DATE, chromeDriver).clear();
            FrameworkLibrary.getElementByProperty(dataReviewConstants.DR_REFILL_EXP_DATE, chromeDriver).clear();

            // validate Original Date, Drug Exp Date and Rx Expiration date
            // after passing 6 numbers
            if (clearAndEnterText(dataReviewConstants.DR_ORIGINAL_DATE, "111111")) {
                hitTab.perform();
                Assert.assertEquals((String) getElementText(dataReviewConstants.DR_ORIGINAL_DATE), "11/11/2011");
            } else {
                throw new Exception("User not able to enter value in prescriber first name text field");
            }

            if (clearAndEnterText(dataReviewConstants.DR_DRUG_EXP_DATE, "111111")) {
                hitTab.perform();
                Assert.assertEquals((String) getElementText(dataReviewConstants.DR_DRUG_EXP_DATE), "11/11/2011");
            } else {
                throw new Exception("User not able to enter value in prescriber first name text field");
            }

            if (clearAndEnterText(dataReviewConstants.DR_REFILL_EXP_DATE, "111111")) {
                hitTab.perform();
                Assert.assertEquals((String) getElementText(dataReviewConstants.DR_REFILL_EXP_DATE), "11/11/2011");
            } else {
                throw new Exception("User not able to enter value in prescriber first name text field");
            }

            // clean all date text box
            FrameworkLibrary.getElementByProperty(dataReviewConstants.DR_ORIGINAL_DATE, chromeDriver).clear();
            FrameworkLibrary.getElementByProperty(dataReviewConstants.DR_DRUG_EXP_DATE, chromeDriver).clear();
            FrameworkLibrary.getElementByProperty(dataReviewConstants.DR_REFILL_EXP_DATE, chromeDriver).clear();

            // validate error message for Original Date, Drug Exp Date and Rx
            // Expiration date after passing 7 numbers
            if (clearAndEnterText(dataReviewConstants.DR_ORIGINAL_DATE, "1111111")) {
                hitTab.perform();
                if (isElementPresentVerification(dataReviewConstants.Incorrect_Original_date)) {
                    String exp = FrameworkLibrary.getElementText(dataReviewConstants.Incorrect_Original_date);
                    Assert.assertEquals(exp, dataReviewConstants.Incorrect_Date_error_msg);
                }
            } else {
                throw new Exception("User not able to enter value in prescriber first name text field");
            }

            if (clearAndEnterText(dataReviewConstants.DR_DRUG_EXP_DATE, "1111111")) {
                hitTab.perform();
                if (isElementPresentVerification(dataReviewConstants.Incorrect_Exp_date)) {
                    String exp = FrameworkLibrary.getElementText(dataReviewConstants.Incorrect_Exp_date);
                    Assert.assertEquals(exp, dataReviewConstants.Incorrect_Date_error_msg);
                }
            } else {
                throw new Exception("User not able to enter value in prescriber first name text field");
            }

            if (clearAndEnterText(dataReviewConstants.DR_REFILL_EXP_DATE, "1111111")) {
                hitTab.perform();

                if (isElementPresentVerification(dataReviewConstants.UPDATERX_RXIncorrect_RX_Exp_Date)) {
                    String exp = FrameworkLibrary.getElementText(dataReviewConstants.UPDATERX_RXIncorrect_RX_Exp_Date);
                    Assert.assertEquals(exp, dataReviewConstants.Incorrect_Date_error_msg);
                }
            } else {
                throw new Exception("User not able to enter value in prescriber first name text field");
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception("Assertion failure");
        }
    }
	/*
	 * This method is used to validate that the expected patient name and date
	 * of birth are displayed in the patient information card on DR page.
	 */

    @When("^the system displays Date of Birth of the selected patient in Patient panel as additional information$")
    public void the_system_displays_Date_of_Birth_of_the_selected_patient_in_Patient_panel_as_additional_information(
            DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String expectedPatientName = SmokeTestLibrary.getData(arg1, "LastName") + ","
                    + SmokeTestLibrary.getData(arg1, "FirstName").toUpperCase();
            getElementText(dataReviewConstants.DR_patient_name).toUpperCase().contains(expectedPatientName);
            String DOB = SmokeTestLibrary.getData(arg1, "DateOfBirth");
            Assert.assertTrue((getElementText(dataReviewConstants.DR_patient_DOB).equals(DOB)));

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * This method is used to enter a lengthy string in to the drug name field
	 * in DR. The string is passed from the feature file.
	 */
    @When("^enters drug name as \"([^\"]*)\" to exceed the available space on the screen$")
    public void enters_drug_name_as_to_exceed_the_available_space_on_the_screen(String lengthydrugName)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.DR_ProductName)) {
                if (!clearAndEnterText(dataReviewConstants.DR_ProductName, lengthydrugName)) {
                    throw new Exception("not able to enter data in dr product name");
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
	 * This method is used to enter a lengthy string in to directions field that
	 * exceeds the available space on the screen. The string is passed from the
	 * feature file step.
	 */
    @When("^directions as \"([^\"]*)\" to exceed the available space on the screen$")
    public void directions_as_to_exceed_the_available_space_on_the_screen(String lengthyDirections) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.DR_ProductDirections)) {
                if (!clearAndEnterText(SmokeTestConstants.DR_ProductDirections, lengthyDirections)) {
                    throw new Exception("not able to enter data in dr directions");
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
	 * This method is used to validate that prescribed drug, dispensed drug and
	 * directions fields are wrapped around when user enters a drug name and
	 * directions that exceed the available space
	 */
    @When("^the Prescribed Drug, Dispensed Drug/Orange Book Rating, and Directions will wrap around if they exceed the available space on the screen$")
    public void the_Prescribed_Drug_Dispensed_Drug_Orange_Book_Rating_and_Directions_will_wrap_around_if_they_exceed_the_available_space_on_the_screen()
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Assert.assertTrue(getElementText(dataReviewConstants.DR_prescribedDrug_readonly).trim().equals(""));
            Assert.assertTrue(getElementText(dataReviewConstants.DR_dispensedDrug_readonly).trim().equals(""));
            Assert.assertTrue(getElementText(dataReviewConstants.DR_directions_readonly).trim().equals(""));

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * This method is used to validate that prescriber name is displayed as
	 * expected in prescriber information card after clicking 2nd accept on DR
	 * page
	 */
    @Then("^system displays the following prescriber details in the Prescriber panel: Last Name, First Name, Middle Initial$")
    public void system_displays_the_following_prescriber_details_in_the_Prescriber_panel_Last_Name_First_Name_Middle_Initial(
            DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String PrescriberData = getElementText(dataReviewConstants.DR_prescriber_data).toUpperCase();
            String Prescriber_FN = SmokeTestLibrary.getData(arg1, "FirstName");
            String Prescriber_LN = SmokeTestLibrary.getData(arg1, "LastName");
            String expectedPrescName = Prescriber_LN + ", " + Prescriber_FN;
            Assert.assertTrue(PrescriberData.contains(expectedPrescName.toUpperCase()));

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * This method is used to assert that prescriber drug, dispensed drug,
	 * original date, DAW, refill and directions are displayed in read only mode
	 * with expected values in DR page after clicking third accept
	 *
	 */
    @Then("^system displays the following product information in read-only mode: Prescribed Drug, Dispensed Drug/Orange Book rating, Original Date, DAW, Qty, Refills, Directions$")
    public void system_displays_the_following_product_information_in_read_only_mode_Prescribed_Drug_Dispensed_Drug_Orange_Book_rating_Original_Date_DAW_Qty_Refills_Directions(
            DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {

            Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_prescribedDrug_readonly, chromeDriver)
                    .getAttribute("readonly").equalsIgnoreCase("true"));
            Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_dispensedDrug_readonly, chromeDriver)
                    .getAttribute("readonly").equalsIgnoreCase("true"));
            Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_OriginalDate_readonly, chromeDriver)
                    .getAttribute("readonly").equalsIgnoreCase("true"));
            Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_DAW_readonly, chromeDriver)
                    .getAttribute("readonly").equalsIgnoreCase("true"));
            Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_refills_readonly, chromeDriver)
                    .getAttribute("readonly").equalsIgnoreCase("true"));
            Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_Qty_readonly, chromeDriver)
                    .getAttribute("readonly").equalsIgnoreCase("true"));
            Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_directions_readonly, chromeDriver)
                    .getAttribute("readonly").equalsIgnoreCase("true"));

            Assert.assertTrue(
                    getElementByProperty(dataReviewConstants.DR_prescribedDrug_readonly, chromeDriver).isDisplayed());
            Assert.assertTrue(
                    getElementByProperty(dataReviewConstants.DR_dispensedDrug_readonly, chromeDriver).isDisplayed());
            Assert.assertTrue(
                    getElementByProperty(dataReviewConstants.DR_OriginalDate_readonly, chromeDriver).isDisplayed());
            Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_DAW_readonly, chromeDriver).isDisplayed());
            Assert.assertTrue(
                    getElementByProperty(dataReviewConstants.DR_refills_readonly, chromeDriver).isDisplayed());
            Assert.assertTrue(getElementByProperty(dataReviewConstants.DR_Qty_readonly, chromeDriver).isDisplayed());
            Assert.assertTrue(
                    getElementByProperty(dataReviewConstants.DR_directions_readonly, chromeDriver).isDisplayed());
            String PrescribedDrug = SmokeTestLibrary.getData(arg1, "DrugName").toUpperCase();
            Assert.assertTrue(getElementText(dataReviewConstants.DR_prescribedDrug_readonly).contains(PrescribedDrug));
           // Assert.assertTrue(getElementText(dataReviewConstants.DR_dispensedDrug_readonly).contains(PrescribedDrug));
            Date today = Calendar.getInstance().getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
            String Date = formatter.format(today);
            Assert.assertTrue(getElementText(dataReviewConstants.DR_OriginalDate_readonly).equals(Date));
            String DAW = SmokeTestLibrary.getData(arg1, "DAW");
            Assert.assertTrue(getElementText(dataReviewConstants.DR_DAW_readonly).equalsIgnoreCase(DAW));
            String refills = SmokeTestLibrary.getData(arg1, "Refills");
            Assert.assertTrue(getElementText(dataReviewConstants.DR_refills_readonly).equalsIgnoreCase(refills));
            String Quantity = SmokeTestLibrary.getData(arg1, "Quantity");
            Assert.assertTrue(getElementText(dataReviewConstants.DR_Qty_readonly).equalsIgnoreCase(Quantity));
            Assert.assertTrue(getElementText(dataReviewConstants.DR_directions_readonly)
                    .equalsIgnoreCase("TAKE 1 TABLET BY MOUTH DAILY"));

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
 * This method is used to validate that prescriber search page is closed on data review page
 */
    @Then("^system closes the Prescriber Search Results overlay on DR page$")
    public void system_closes_the_Prescriber_Search_Results_overlay_on_DR_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            Assert.assertTrue(!isElementPresents(dataReviewConstants.dr_prescriberSearch_lastname));
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
     * This method is used to enter drug information in data entry with DAW as
     * 'Y'
     */
    @When("^enters product information with DAW as \"([^\"]*)\"$")
    public void enters_product_information_with_DAW_as(String arg2, DataTable arg1) throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            Map<String, List<String>> dataMap = null;
            dataMap = FrameworkLibrary.getHorizontalData(arg1);
            String DAW = arg2.toUpperCase();
            String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "DrugName");
            String Quantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "Quantity");
            String Directions = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "Directions");
            String DaysSupply = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "DaysSupply");
            String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "Refills");

            Assert.assertTrue(isElementPresents(SmokeTestConstants.Product_OriginalDate));
            if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
                if (!clearAndEnterText(SmokeTestConstants.Product_DAW, DAW)) {
                    throw new Exception("Not able to enter value in DAW text field");
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

            if (isElementPresentVerification(SmokeTestConstants.DispensedDrug_Field)) {
                if (getElementByProperty(SmokeTestConstants.DispensedDrug_Field, chromeDriver).getAttribute("aria-disabled").equalsIgnoreCase("false")) {
                    IntakeStepDef.user_hits_Enter_Key();
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

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^click on Finish to complete Data Review$")
    public void clicks_on_Finish_to_complete_Data_Review() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(SmokeTestConstants.DR_FINISH)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.DR_FINISH)) {
                    throw new Exception("Not able to click DR_FINISH button");
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
     * This method is to enter the product information for c2 drug
     */
    @Then("^enters product information for c2$")
    public void enters_product_information_for_c2(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            Map<String, List<String>> dataMap = null;
            dataMap = FrameworkLibrary.getHorizontalData(arg1);
            String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
            String Quantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
            String Directions = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Directions");
            String DaysSupply = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DaysSupply");
            if (!isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {

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

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }
    
    /*
     * This method is to clear all the product information field in DR
     */
    @Then("^clear all the product information fields$")
    public void clear_all_the_product_information_fields(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
                chromeDriver.findElementByXPath(SmokeTestConstants.DrugName_Field).clear();
                chromeDriver.findElementByXPath(SmokeTestConstants.Refills_field).clear();
                chromeDriver.findElementByXPath(SmokeTestConstants.Quantity_field).clear();
                chromeDriver.findElementByXPath(SmokeTestConstants.Days_Supply).clear();
                chromeDriver.findElementByXPath(SmokeTestConstants.Directions_field).clear();
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
     * This method is to select null value in state Dropdown in DR
     */
    @Then("^User selects null value in the state dropdown in DR$")
    public void select_null_value_state_drpdown_in_DR() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.DR_prescriber_dropdown)) {
                FrameworkLibrary.isElementPresentVerifyClick(dataReviewConstants.DR_prescriber_dropdown);
            }
            Thread.sleep(2000);
            chromeDriver.findElementByCssSelector("md-option.md-ink-ripple[value='']").click();
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }
    
    /*
     * This method is to click on prescriber search button in DR
     */
    @Then("^clicks search button on prescriber search in DR$")
    public void clicks_search_button_on_prescriber_search_in_DR() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(dataReviewConstants.Prescriber_SelectButton_DR)) {
                if (!isElementPresentVerifyClick(dataReviewConstants.Prescriber_SelectButton_DR)) {
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

    @Then("^The system should display PRN in Refills field$")
	public void The_system_should_display_PRN_in_Refills_field() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
				if (!getElementText(SmokeTestConstants.Refills_field).equals(DataEntryConstants.PRN_Refills)) {
					throw new Exception("Field dos not display PRN.");
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
     * This method is to validate the prescriber info when you click on view button in prescriber update
     */
    @Then("^validate general info of the prescriber$")
    public void validate_general_info_of_the_prescriber(DataTable arg1) throws Throwable {
    	methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    	Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        String Firstname = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
        String Lastname = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
		try {
				if(isElementPresentVerification(dataReviewConstants.DR_Update_Prescriber_Viewbutton_details)){
					Assert.assertEquals(getElementText(dataReviewConstants.DR_Update_Prescriber_Viewbutton_firstname).toLowerCase(), Firstname);
					Assert.assertEquals(getElementText(dataReviewConstants.DR_Update_Prescriber_Viewbutton_lastname).toLowerCase(), Lastname);
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
     * This method is to validate the location and communication details in prescriber update view button and to click on close button
     */
    @Then("^validate the location and communication details$")
    public void validate_the_location_and_communication_details() throws Throwable {
        	methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    		try {
    				if(!isElementPresentVerification(dataReviewConstants.DR_Update_Prescriber_Viewbutton_location)){
    					throw new Exception("unable to find the address");
    				}
    				if(!isElementPresentVerification(dataReviewConstants.DR_Update_Prescriber_Viewbutton_contact)){
    					throw new Exception("unable to find the communication");
    				}
    				if(isElementPresentVerification(dataReviewConstants.DR_Update_Prescriber_update_close_button)){
    					if(!isElementPresentVerification(dataReviewConstants.DR_Update_Prescriber_update_close_button)){
    						throw new Exception("unable to click on close button");
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
