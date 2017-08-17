package hangOn;

import accessManagment.AccessManagementConstants;
import clinicalEvaluation.ClinicalEvaluationConstants;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataEntry.DataEntryConstants;
import dataReview.dataReviewConstants;
import framework.ConnectionFactory;
import framework.FrameworkConstants;
import framework.FrameworkLibrary;
import intake.IntakeConstants;
import intake.IntakeLibrary;

import intake.IntakeStepDef;


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
import smokeTest.SmokeTestLibrary;
import smokeTest.SmokeTestStepDef;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;


public class hangOnStepDef extends FrameworkLibrary {

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
    public static List<WebElement> address;
    public static String CEOverride;
    public static int NumberOfFillingTasks;
    private static Log log = LogFactory.getLog(hangOnStepDef.class);
    private static String methodName;
    public String plan;
    public boolean condition;
    public String Depnum;
    public String UPC;
    public String Quan;
    public Statement stmt;
    int Number_BeforeIntake;
    int i = 0;
    List<WebElement> prescriptionsInPOS;
    int numberOfPatientRecordsBeforeDE;
    int numberOfPatientRecordsAfterDE;
    String attributeBeforeValue;
    String attributeAfterValue;
    List<WebElement> notesList;
    hangOnLibrary hangOnLibrary = null;

    public hangOnStepDef() throws ConfigurationException, IOException {
        super();
        hangOnLibrary = new hangOnLibrary(chromeDriver);
    }

    /****************************************************************************
     * Method : Verify and clicks down arrow button and validate fill history for current prescription
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/

    @When("^User clicks down arrow button and validate fill history for current prescription$")
    public static void click_down_arrow() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            boolean isElementClicked = false;
            long timeoutExpiredMS = System.currentTimeMillis() + 100000;
            Thread.sleep(5000);
            WebElement e = chromeDriver.findElementByClassName("md-virtual-repeat-offsetter");
            log.info(e.getText());
            while (!e.getText().toLowerCase().contains("in progress")) {
                Actions ac = new Actions(chromeDriver);
                Action a = ac.sendKeys(Keys.ARROW_DOWN).build();
                a.perform();
                if (System.currentTimeMillis() > timeoutExpiredMS) {
                    Assert.fail("Time out..");
                }
            }
            log.info(e.getText());
            Thread.sleep(2000);
            log.info("Rx number is visible in MedHistory");
            Thread.sleep(5000);
            List<WebElement> l = chromeDriver.findElements(By.xpath("//*[contains(@id,'rx-history-item-list-')]"));

            for (int i = 0; i < l.size(); i++) {
                if (/*l.get(i).getText().contains(prescriberLastname)&& l.get(i).getText().contains(expDrugname)*/ l.get(i).getText().toLowerCase().contains("in progress")) {
                    String currentid = l.get(i).getAttribute("id");
                    String[] idparts = currentid.split("-");
                    String uniqueid = idparts[4];
                    isElementPresentVerifyClick("//*[@id='down-arrow-icon-button-" + uniqueid + "']");
                    Thread.sleep(2000);
                    isElementPresentVerifyClick("//*[@id='rx-history-details-" + uniqueid + "']/rxms-rx-history-details/div/div[2]/div/div/div/md-list[1]/md-list-item/div/a");
                    Thread.sleep(5000);
                    Assert.assertTrue(getElementText("//*[@id='fill-audit-history-content-dialog']/md-content/rxms-fill-history-card/md-card/md-card-title").equals("Fill History"));
                    isElementClicked = true;
                    break;
                }
            }
            Assert.assertTrue(isElementClicked);

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : Validate rx history details with store numbers
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @Then("^system should display rx history details with store numbers$")
    public static void rx_history_store_num() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            long timeoutExpiredMS = System.currentTimeMillis() + 100000;
            String rxnum = SmokeTestStepDef.dynamicrxnum;
            if (SmokeTestStepDef.dynamicrxnum.startsWith("0")) {
                rxnum = SmokeTestStepDef.dynamicrxnum.substring(1);
            }
            Thread.sleep(5000);
            WebElement e = chromeDriver.findElementByClassName("md-virtual-repeat-offsetter");
            log.info(e.getText());
            while (!e.getText().contains(rxnum)) {
                Actions ac = new Actions(chromeDriver);
                Action a = ac.sendKeys(Keys.ARROW_DOWN).build();
                a.perform();
                if (System.currentTimeMillis() > timeoutExpiredMS) {
                    Assert.fail("Time out..");
                }
            }
            log.info(e.getText());
            Thread.sleep(2000);
            List<WebElement> l = chromeDriver.findElements(By.xpath("//*[contains(@id,'rx-history-item-list-')]"));
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i).getText().contains(rxnum)) {
                    String currentid = l.get(i).getAttribute("id");
                    String[] idparts = currentid.split("-");
                    String uniqueid = idparts[4];
                    Assert.assertTrue(getElementText("//*[@id='rx-history-item-list-" + uniqueid + "']/div/div/div[5]") != null);
                }
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    /****************************************************************************
     * Method : Verify and clicks view commet yellow button
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/

    @And("^User clicks view commet yellow button$")
    public void user_clicks_view_commet_yellow_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.COMMENTS_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.COMMENTS_BUTTON)) {
                    throw new Exception("Not able to click on comments Button");
                }
            }
            Actions keyAction = new Actions(chromeDriver);
            Thread.sleep(2000);
            keyAction.sendKeys(Keys.TAB).perform();
            keyAction.sendKeys(Keys.TAB).perform();
            keyAction.sendKeys(Keys.TAB).perform();
            Thread.sleep(1000);
            Assert.assertTrue(isElementPresentVerification(IntakeConstants.COMMENTS_BOX));

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : Verify and click on Phone Number field and click TAB key
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/

    @When("^I click on Phone Number field and click TAB key$")
    public void i_click_on_Phone_Number_field_and_click_TAB_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.RADIO_PICKUPLATER)) {
                isElementPresentVerifyClick(IntakeConstants.RADIO_PICKUPLATER);
                chromeDriver.findElement(By.xpath(IntakeConstants.RADIO_PICKUPLATER)).sendKeys(Keys.TAB);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : Verify and click DE screen Image back button
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/

    @When("^User click DE screen Image back button$")
    public void user_click_de_screen_img_back_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(DataEntryConstants.IMAGE_DE_FINISH_SCREEN_BACK_BUTTON)) {
                isElementPresentVerifyClick(DataEntryConstants.IMAGE_DE_FINISH_SCREEN_BACK_BUTTON);
            }
            boolean backImg = chromeDriver.findElement(By.xpath(DataEntryConstants.IMAGE_BACK_DE_FINISH_SCREEN)).isDisplayed();
            Assert.assertTrue(backImg);
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : Validate focus of DE screen Image front tab
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @When("^User validate focus of DE screen Image front tab$")
    public void user_click_de_screen_img_front_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            boolean backImg = chromeDriver.findElement(By.xpath(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)).isDisplayed();
            Assert.assertTrue(backImg);
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


    /****************************************************************************
     * Method : Verify prescriber details should be displayed
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @Then("^prescriber details should be displayed$")
    public void prescriber_details_should_be_displayed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            List<WebElement> prescriberResult = FrameworkLibrary.chromeDriver.findElements(By.xpath(hangOnConstants.PRESCRIBER_SEARCH_PAGE_RESULTS_TABLE));
            for (int i = 0; i < prescriberResult.size(); i++) {
                log.info("Results returned for prescriber Locations:" + prescriberResult.get(i).getText());
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : Select state from the drop down and click on search Button
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @And("^choose state from the drop down and click search$")
    public void choose_state_from_the_drop_down_and_click_search(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_SEARCH_PAGE_STATE_SELECTION)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PRESCRIBER_SEARCH_PAGE_STATE_SELECTION)) {
                    throw new Exception("Not able to click on Patient search page state selection");
                }
            }
            List<WebElement> states = FrameworkLibrary.chromeDriver.findElements(By.xpath(IntakeConstants.PRESCRIBER_SEARCH_PAGE_STATE_SELECTION_OPTIONS));
            Map<String, List<String>> dataMap = null;
            dataMap = FrameworkLibrary.getHorizontalData(arg1);
            String State = dataMap.get("State").get(0);
            for (int i = 0; i < states.size(); i++) {
                if (states.get(i).getAttribute("value").equals(State)) {
                    states.get(i).click();
                    break;
                }
            }
            Actions searchButton = new Actions(chromeDriver);
            Action series = searchButton.keyDown(Keys.ALT).sendKeys("s").keyUp(Keys.ALT).build();
            series.perform();
            address = FrameworkLibrary.chromeDriver.findElements(By.xpath(hangOnConstants.PRESCRIBER_SEARCH_PAGE_RESULTS_TABLE_ADDRESSES));
            WebDriverWait wait = new WebDriverWait(FrameworkLibrary.chromeDriver, watingForElement);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IntakeConstants.PRESCRIBER_SEARCH_PAGE_VIEW_BUTTON)));
            boolean viewButton = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PRESCRIBER_SEARCH_PAGE_VIEW_BUTTON)).isEnabled();
            if (viewButton) {
                FrameworkLibrary.isElementPresentVerifyClick(IntakeConstants.PRESCRIBER_SEARCH_PAGE_VIEW_BUTTON);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : Validate User should see the prescriber information
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @Then("^User should see the prescriber information$")
    public void user_should_see_the_prescriber_information() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Assert.assertTrue(IntakeLibrary.isElementPresent(IntakeConstants.PRESCRIBER_DETAILS_GENERAL_INFO_SECTION), "Prescriber details general info section is not displayed");
            Assert.assertTrue(IntakeLibrary.isElementPresent(IntakeConstants.PRESCRIBER_DETAILS_LOCATION_COMMUNICATION_SECTION), "Prescriber details location and communication section is not displayed");
            List<WebElement> locations = FrameworkLibrary.chromeDriver.findElements(By.xpath(hangOnConstants.PRESCRIBER_DETAILS_LOCATION_RESULTS));
            Assert.assertTrue(address.size() == locations.size(), "User could not see all the addresses/locations related to prescriber");
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : Verify and click on Third party plans using alt plus three hot key
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @When("^User click on Third party plans using alt plus three hot key$")
    public void user_click_on_Third_party_plans_using_alt_plus_three_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("3").keyUp(Keys.ALT).build();
            series.perform();
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : Validate user will be on Third party plans page
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @Then("^User will be on Third party plans$")
    public void user_will_be_on_Third_party_plans() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            WebElement thirdPartyPlans = FrameworkLibrary.chromeDriver.findElement(By.xpath(hangOnConstants.PATIENT_SEARCH_PATIENT_PROFILE_THIRD_PARTY_PLANS_PAGE));
            Assert.assertTrue(thirdPartyPlans != null, "User is not on 3rd party plans");
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : Validate checks relation to plan holder section and plan holder name field
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @Then("^User checks relation to plan holder section and plan holder name field$")
    public void user_checks_relation_to_plan_holder_section_and_plan_holder_name_field(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            for (int i = 0; i < arg1.raw().size(); i++) {
                String familyMember = arg1.raw().get(i).get(0);
                WebElement relationShipToCardHolder = FrameworkLibrary.chromeDriver
                        .findElement(By.xpath(hangOnConstants.PATIENT_SEARCH_THIRD_PARTY_PLANS_RELATIONSHIP_TO_CARDHOLDER));
                WebElement planHolderName = FrameworkLibrary.chromeDriver
                        .findElement(By.xpath(hangOnConstants.PATIENT_SEARCH_THIRD_PARTY_PLANS_PLANHOLDER_NAME));
                if (familyMember.equals(relationShipToCardHolder.getText())) {
                    log.info("plan holder name is: " + planHolderName.getText());
                    Assert.assertTrue(!(planHolderName.getText().isEmpty()),
                            "Plan holder name field is empty for: " + relationShipToCardHolder.getText());
                } else if (familyMember.equals(relationShipToCardHolder.getText())) {
                    Assert.assertTrue(!(planHolderName.getText().isEmpty()),
                            "Plan holder name field is empty for: " + relationShipToCardHolder.getText());
                } else if (familyMember.equals(relationShipToCardHolder.getText())) {
                    Assert.assertTrue(!(planHolderName.getText().isEmpty()),
                            "Plan holder name field is empty for: " + relationShipToCardHolder.getText());
                } else if (familyMember.equals(relationShipToCardHolder.getText())) {
                    Assert.assertTrue(!(planHolderName.getText().isEmpty()),
                            "Plan holder name field is empty for: " + relationShipToCardHolder.getText());
                }

            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    /****************************************************************************
     * Method : Verify and clicks on first accept and not to select that button
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @When("^User clicks on first accept to unselect that button$")
    public void user_clicks_on_first_accept_to_unselect_that_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("1").keyUp(Keys.ALT).build();
            series.perform();
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : Validate first accept button is unselected
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @When("^User checks the first accept button is unselected$")
    public void user_checks_the_first_accept_button_is_unselected() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            boolean patientAccept = IntakeLibrary.isElementPresent(hangOnConstants.DATA_REVIEW_FIRST_ACCEPT_BUTTON_STATUS);
            Assert.assertTrue(!patientAccept, "Patient accept button is accepted already");
        } catch (AssertionError e) {
            e.printStackTrace();
            takeScreenShot(methodName);

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : Verify and clicks on second accept to unselect that button
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @When("^User clicks on second accept to unselect that button$")
    public void user_clicks_on_second_accept_to_unselect_that_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("2").keyUp(Keys.ALT).build();
            series.perform();

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : Validate second accept button is unselected
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @When("^User checks the second accept button is unselected$")
    public void user_checks_the_second_accept_button_is_unselected() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            boolean prescriberAccept = IntakeLibrary.isElementPresent(hangOnConstants.DATA_REVIEW_SECOND_ACCEPT_BUTTON_STATUS);
            Assert.assertTrue(!prescriberAccept, "Prescriber accept button is accepted already");

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : Verify and clicks on third accept to unselect that button
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @When("^User clicks on third accept to unselect that button$")
    public void user_clicks_on_third_accept_to_unselect_that_button() throws Exception {
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
        } catch (AssertionError e) {
            e.printStackTrace();
            takeScreenShot(methodName);
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : Validate third accept button is unselected
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @When("^User checks the third accept button is unselected$")
    public void user_checks_the_third_accept_button_is_unselected() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            boolean productAccept = IntakeLibrary.isElementPresent(hangOnConstants.DATA_REVIEW_THIRD_ACCEPT_BUTTON_STATUS);
            Assert.assertTrue(!productAccept, "Product accept button is accepted already");

        } catch (AssertionError e) {
            e.printStackTrace();
            takeScreenShot(methodName);

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : Validate user is on patient order status screen
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @Then("^I should be on patient order status page$")
    public void i_should_be_on_patient_order_status_page() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Assert.assertTrue(chromeDriver.getPageSource().contains("Patient Order Status"), "Not on Patient Order Status Page");
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


    @Then("^I should see patient selected in drop down$")
    public void i_should_see_patient_selected_in_drop_down() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Assert.assertTrue(chromeDriver.findElement(By.xpath(hangOnConstants.POS_DROP_DOWN)).getText().equals("Patient"), "Patient is not selected");
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


    @Then("^I should see valid search results$")
    public void i_should_see_valid_search_results() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(hangOnConstants.POS_SEARCH_RESULT_SECTION)) {
                Assert.assertTrue(chromeDriver.getPageSource().contains("Tel:"), "No search results found");
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

    @When("^enters product information to validate sig codes$")
    public void enters_product_information_to_validate_sig_codes(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            waitToClick(SmokeTestConstants.Product_OriginalDate);
            if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
                SmokeTestLibrary.enter_Text(arg1, "Date", SmokeTestConstants.Product_OriginalDate, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
                SmokeTestLibrary.enter_Text(arg1, "DAW", SmokeTestConstants.Product_DAW, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
                SmokeTestLibrary.enter_Text(arg1, "DrugName", SmokeTestConstants.DrugName_Field, chromeDriver);
            }
            Thread.sleep(2000);
            Actions upArrow = new Actions(chromeDriver);
            Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
            PressUpArrow.perform();
            Thread.sleep(1000);
            if (isElementPresentVerification(SmokeTestConstants.Quantity_field)) {
                SmokeTestLibrary.enter_Text(arg1, "Quantity", SmokeTestConstants.Quantity_field, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Directions_field)) {
                SmokeTestLibrary.enter_Text(arg1, "Directions", SmokeTestConstants.Directions_field, chromeDriver);
            }
           // String sigcode = FrameworkLibrary.getXLSTestData("smokeTestSIT", "product", "Row_nine", "Directions");
            if (isElementPresentVerification(SmokeTestConstants.Days_Supply)) {
                SmokeTestLibrary.enter_Text(arg1, "DaysSupply", SmokeTestConstants.Days_Supply, chromeDriver);
            }
            String sigcoderesult = FrameworkLibrary.getElementText(SmokeTestConstants.Directions_field).trim();
            Assert.assertEquals(sigcoderesult, "TAKE 1 TABLET BY MOUTH DAILY");
            if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
                SmokeTestLibrary.enter_Text(arg1, "Refills", SmokeTestConstants.Refills_field, chromeDriver);
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


    @Then("^enters product information for rems drug$")
    public void enters_product_information_for_rems_drug(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            waitToClick(SmokeTestConstants.Product_OriginalDate);
            if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
                SmokeTestLibrary.enter_Text(arg1, "Date", SmokeTestConstants.Product_OriginalDate, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
                SmokeTestLibrary.enter_Text(arg1, "DAW", SmokeTestConstants.Product_DAW, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
                SmokeTestLibrary.enter_Text(arg1, "DrugName", SmokeTestConstants.DrugName_Field, chromeDriver);
            }
            Thread.sleep(2000);
            Actions upArrow = new Actions(chromeDriver);
            Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
            PressUpArrow.perform();
            Thread.sleep(1000);
            if (isElementPresentVerification(hangOnConstants.DataEntry_RemsDrug_popup)) {
                if (!isElementPresentVerifyClick(hangOnConstants.DataEntry_RemsDrug_popup)) {
                    throw new Exception("Not able to click on DataEntry_RemsDrug_popup");
                }
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


    @When("^user click on cancel a popup screen will display click yes$")
    public void user_click_on_cancel_a_popup_screen_will_display_click_yes() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(hangOnConstants.Intake_Cancel_Button)) {
                if (!isElementPresentVerifyClick(hangOnConstants.Intake_Cancel_Button)) {
                    throw new Exception("Not able to click on Intake_Cancel_Button");
                }
            }
            if (isElementPresentVerification(hangOnConstants.Intake_Cancel_Popup_Yes_Button)) {
                if (!isElementPresentVerifyClick(hangOnConstants.Intake_Cancel_Popup_Yes_Button)) {
                    throw new Exception("Not able to click on Intake_Cancel_Popup_Yes_Button");
                }
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


    @When("^user hits alt plus x hot key$")
    public void user_hits_alt_plus_x_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            waitForVisibility(SmokeTestConstants.Intake_RxButton);
            Actions ab = new Actions(chromeDriver);
            Action series = ab.keyDown(Keys.ALT).sendKeys("x").keyUp(Keys.ALT).build();
            series.perform();
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


    @And("^user able to see dispended drug in field$")
    public void user_able_to_see_dispended_drug_in_field() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String dispended = FrameworkLibrary.chromeDriver.findElement(By.xpath(SmokeTestConstants.DispensedDrug_Field)).getText();
            Assert.assertNotNull(dispended, "the dispended value is not present");
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


    @When("^User hits ALT plus P hot key$")
    public void user_hits_alt_plus_p_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
                SmokeTestLibrary.hotkeyAction(Keys.ALT, "p", chromeDriver);
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


    @When("^User hits ALT plus R hot key$")
    public void user_hits_alt_plus_R_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
                SmokeTestLibrary.hotkeyAction(Keys.ALT, "r", chromeDriver);
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


    @When("^User hits Alt plus W hotkey$")
    public void user_hits_Alt_plus_W_hotkey() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(1000);
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("w").keyUp(Keys.ALT).build();
            series.perform();
            Thread.sleep(2000);
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


    @When("^User click on Rx number hyper link in CE$")
    public void user_click_on_Rx_number_hyper_link_in_CE() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(hangOnConstants.CE_RxDetails_HyperLink)) {
                if (!isElementPresentVerifyClick(hangOnConstants.CE_RxDetails_HyperLink)) {
                    throw new Exception("Not able to click on CE_RxDetails_HyperLink");
                }
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


    @Then("^Rx Details window should open succesfuly Prescribed and Dispensed drug should be displayed successfully$")
    public void rx_Details_window_should_open_succesfuly_Prescribed_and_Dispensed_drug_should_be_displayed_successfully() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
        	Assert.assertTrue(FrameworkLibrary.isElementPresentVerification(hangOnConstants.CE_RxDetails_Popup_Window));
            Assert.assertTrue(FrameworkLibrary.isElementPresentVerification(hangOnConstants.CE_Prescribed_Drug));
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


    @And("^clicks third accept to validate product data and validate the refills$")
    public void clicks_third_accept_to_validate_product_data_and_validate_the_refills(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            waitToClick(SmokeTestConstants.Product_AcceptButton).click();
            String Refill = FrameworkLibrary.chromeDriver.findElement(By.xpath(SmokeTestConstants.Refills_field)).getText();
            String refilled = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
            Assert.assertEquals(refilled, Refill);

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


    @Then("^System should validate Rx number for current prescriptions$")
    public void system_should_validate_Rx_number_for_current_prescriptions(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            SmokeTestStepDef.i_click_search_button_on_patient_order_status();
            SmokeTestStepDef.i_click_search_button_on_patient_order_status();
            SmokeTestStepDef.i_click_search_button_on_patient_order_status();
            List<WebElement> list1 = chromeDriver.findElements(By.xpath(SmokeTestConstants.POS_patientNames));
            String expectedPatientName = SmokeTestLibrary.getData(arg1, "LastName").toUpperCase();
            String pickuptime = SmokeTestStepDef.currentPickupTime;
            String pickupdate = SmokeTestStepDef.IntakeDate;
            String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;

            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).getText().contains(expectedPatientName)/* && list1.get(i).getText().contains(expectedPhoneNumber)*/) {
                    String s = list1.get(i).getAttribute("id");
                    log.info(s);
                    String[] parts = s.split("-");
                    String part2 = parts[1];
                    List<WebElement> singlepresc = chromeDriver.findElements(By.xpath("//*[contains(@id,'single-prescription-" + part2 + "')]"));
                    log.info("size is" + singlepresc.size());

                    for (int z = 0; z < singlepresc.size(); z++) {
                        if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate) && singlepresc.get(z).getText().contains(pickuptime)) {
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
                        } else if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate) && singlepresc.get(z).getText().contains(possiblepickupTime1)) {
                            log.info("single current prescription contains" + singlepresc.get(z).getText());
                            Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("in progress"));
                            Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("entered"));
                            log.info("The status is In Progress - Entered after completing the data review task");
                            String dyn = singlepresc.get(z).getAttribute("id");
                            String[] dynamo = dyn.split("-");
                            String part = dynamo[2];
                            String Rxnumber = "//*[@id='single-prescription-" + part + "-" + z + "']/div[3]";
                            String currentRxnumber = getElementText(Rxnumber);
                            log.info(currentRxnumber);
                            Assert.assertTrue(getElementText(Rxnumber) != null);
                        } else if (singlepresc.get(z).getText().toLowerCase().contains(SmokeTestStepDef.intakenextdate) && singlepresc.get(z).getText().contains(possiblepickupTime1)) {
                            log.info("single current prescription contains" + singlepresc.get(z).getText());
                            Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("in progress"));
                            Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("entered"));
                            log.info("The status is In Progress - Entered after completing the data review task");
                            String dyn = singlepresc.get(z).getAttribute("id");
                            String[] dynamo = dyn.split("-");
                            String part = dynamo[2];
                            String Rxnumber = "//*[@id='single-prescription-" + part + "-" + z + "']/div[3]";
                            String currentRxnumber = getElementText(Rxnumber);
                            log.info(currentRxnumber);
                            Assert.assertTrue(getElementText(Rxnumber) != null);
                        }
                    }
                }
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


    @Then("^I enter product info including Substitute N and Y$")
    public void i_enter_product_info_including_Substitute_N_and_Y(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            waitToClick(SmokeTestConstants.Product_OriginalDate);
            if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
                SmokeTestLibrary.enter_Text(arg1, "Date", SmokeTestConstants.Product_OriginalDate, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
                SmokeTestLibrary.enter_Text(arg1, "DAW", SmokeTestConstants.Product_DAW, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Product_Substitute)) {
                SmokeTestLibrary.enter_Text(arg1, "Substitute", SmokeTestConstants.Product_Substitute, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
                SmokeTestLibrary.enter_Text(arg1, "DrugName", SmokeTestConstants.DrugName_Field, chromeDriver);
            }
            Thread.sleep(2000);
            Actions upArrow = new Actions(chromeDriver);
            Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
            PressUpArrow.perform();
            Thread.sleep(3000);
            FrameworkLibrary.isElementPresentVerifyClick(hangOnConstants.DE_Dispensed_Field);
            Thread.sleep(2000);
            Actions DownArrow = new Actions(chromeDriver);
            Action UpArrow = DownArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
            PressUpArrow.perform();
            Thread.sleep(3000);
            if (isElementPresentVerification(SmokeTestConstants.DrugExpiryDate_Field)) {
                SmokeTestLibrary.enter_Text(arg1, "DrugExpDate", SmokeTestConstants.DrugExpiryDate_Field, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Quantity_field)) {
                SmokeTestLibrary.enter_Text(arg1, "Quantity", SmokeTestConstants.Quantity_field, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Quantity_disp)) {
                SmokeTestLibrary.enter_Text(arg1, "QuantityDisp", SmokeTestConstants.Quantity_disp, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Directions_field)) {
                SmokeTestLibrary.enter_Text(arg1, "Directions", SmokeTestConstants.Directions_field, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Days_Supply)) {
                SmokeTestLibrary.enter_Text(arg1, "DaysSupply", SmokeTestConstants.Days_Supply, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
                SmokeTestLibrary.enter_Text(arg1, "Refills", SmokeTestConstants.Refills_field, chromeDriver);
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

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^system should show new Data Entry page$")
    public void system_should_show_new_data_entry_page() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            waitForVisibility(dataReviewConstants.DR_ProductName);
            String text = FrameworkLibrary.getElementByProperty(dataReviewConstants.DR_ProductName, chromeDriver).getText();
            Assert.assertEquals(text.trim(), "");

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


    @Then("^enters product with DAW N and substitute as Y and Quick code for product$")
    public void enters_daw_n_substitute_y_and_quickcode(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
                SmokeTestLibrary.enter_Text(arg1, "Date", SmokeTestConstants.Product_OriginalDate, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
                SmokeTestLibrary.enter_Text(arg1, "DAW", SmokeTestConstants.Product_DAW, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Product_Substitute)) {
                SmokeTestLibrary.enter_Text(arg1, "Substitute", SmokeTestConstants.Product_Substitute, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
                SmokeTestLibrary.enter_Text(arg1, "DrugName", SmokeTestConstants.DrugName_Field, chromeDriver);
            }
            Thread.sleep(2000);
            Actions upArrow = new Actions(chromeDriver);
            Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
            PressUpArrow.perform();

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


    @And("^I should see expected drug as dispensed product$")
    public void should_see_expected_drug_dispensed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(2000);
            Assert.assertTrue(chromeDriver.getPageSource().contains("Simvastatin 10mg Tablets"));
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


    @Then("^User see All the data required should be entered$")
    public void user_see_All_the_data_required_should_be_entered() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Assert.assertTrue(FrameworkLibrary.isElementPresentVerification(hangOnConstants.Fill_History_PaymentType));
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


    @When("^User click on Expand next to Inprogress$")
    public void user_click_on_Expand_next_to_Inprogress() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(hangOnConstants.Med_History_Next_To_InProgress_Expansion_Link)) {
                if (!isElementPresentVerifyClick(hangOnConstants.Med_History_Next_To_InProgress_Expansion_Link)) {
                    throw new Exception("Not able to click on Med_History_Next_To_InProgress_Expansion_Link");
                }
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


    @When("^User click on View link$")
    public void user_click_on_View_link() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(hangOnConstants.Med_History_View_Link)) {
                if (!isElementPresentVerifyClick(hangOnConstants.Med_History_View_Link)) {
                    throw new Exception("Not able to click on Med_History_View_Link");
                }
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


    @Then("^Fill history tab will be displayed$")
    public void fill_history_tab_will_be_displayed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            FrameworkLibrary.verifyTextPresentElectron(hangOnConstants.Med_History_Fill_History, "Fill History");
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


    @When("^User enters prescriber Phone no on DR page$")
    public void user_enters_prescriber_Phone_no_on_DR_page(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

        SmokeTestLibrary.enter_Text(arg1, "PhoneNumber", hangOnConstants.DR_PhoneNo, chromeDriver);

    }

    /****************************************************************************
     * Method :
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @Then("^I Only see the team member icon and name without the phone number$")
    public void i_Only_see_the_team_member_icon_and_name_without_the_phone_number() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Assert.assertTrue(FrameworkLibrary.isElementPresents(AccessManagementConstants.TeamMember_Phone_Profile));
            Assert.assertTrue(FrameworkLibrary.isElementPresents(hangOnConstants.Profile_Icone));
            Assert.assertTrue(FrameworkLibrary.isElementPresents(hangOnConstants.Profile_TeamMember_Name));
            String Phone = getElementText(AccessManagementConstants.TeamMember_Phone_Profile);
            Assert.assertTrue(Phone == null);
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


    @Then("^User checks the content sorted by Last Filled Date in order$")
    public void user_checks_the_health_conditions_of_the_patient_are_in_order() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
        	List<WebElement> creationDate = chromeDriver.findElements(By.xpath(hangOnConstants.CE_MED_HISTORY_LAST_FILLED_DATE_COLUMN));
            List<Date> dt = new ArrayList<Date>();
            for (int i = 0; i < creationDate.size(); i++) {
                String dateinString = creationDate.get(i).getText().trim();
                SimpleDateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");
                
                if(dateinString.length()!=0){
                Date date = formatter.parse(dateinString);
                dt.add(date);
                
            }
            	
                List<Date> expecteddt = new ArrayList<Date>(dt);
                log.info("expected----1"+expecteddt);
                Collections.sort(expecteddt,Collections.reverseOrder());
                log.info("----"+dt);
                log.info("expected====2"+expecteddt);
                Assert.assertTrue(dt.equals(expecteddt));
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


    @Then("^The status for current prescription should be \"([^\"]*)\"$")
    public void the_status_should_be(String status, DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            SmokeTestStepDef.i_click_search_button_on_patient_order_status();
            SmokeTestStepDef.i_click_search_button_on_patient_order_status();
            List<WebElement> list1 = chromeDriver.findElements(By.xpath(SmokeTestConstants.POS_patientNames));
            String expectedPatientName = SmokeTestLibrary.getData(arg1, "LastName").toUpperCase();
            String pickuptime = SmokeTestStepDef.currentPickupTime;
            String pickupdate = SmokeTestStepDef.IntakeDate;
            String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;

            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).getText().contains(expectedPatientName)) {
                    String s = list1.get(i).getAttribute("id");
                    log.info(s);
                    String[] parts = s.split("-");
                    String part2 = parts[1];
                    List<WebElement> singlepresc = chromeDriver.findElements(By.xpath("//*[contains(@id,'single-prescription-" + part2 + "')]"));
                    for (int z = 0; z < singlepresc.size(); z++) {

                        if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate) && singlepresc.get(z).getText().contains(pickuptime)) {
                            Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains(status));
                            break;
                        } else if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate) && singlepresc.get(z).getText().contains(possiblepickupTime1)) {
                            Thread.sleep(2000);
                            Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains(status), "The pending link is not found for current prescription");
                            break;
                        } else if (singlepresc.get(z).getText().toLowerCase().contains(SmokeTestStepDef.intakenextdate) && singlepresc.get(z).getText().contains(possiblepickupTime1)) {
                            Thread.sleep(2000);
                            Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains(status), "The pending link is not found for current prescription");
                            break;

                        } else {
                            log.info("The " + z + " prescription does not contain expected pickuptime in patient order status");
                        }
                    }
                }
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


    @When("^clicks pending link for current prescription on med history page$")
    public void click_pending_link_in_medhistory() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(5000);
            long timeoutExpiredMS = System.currentTimeMillis() + 100000;
            List<WebElement> elements = chromeDriver.findElements(By.xpath("//*[contains(@id,'rx-history-item-list-')]/div/div/div[11]/div/a//*[contains(text(),'Pending')]"));
            while (elements.size() == 0) {
                Actions ac = new Actions(chromeDriver);
                Action a = ac.sendKeys(Keys.ARROW_DOWN).build();
                a.perform();
                chromeDriver.navigate().refresh();
                if (System.currentTimeMillis() > timeoutExpiredMS) {
                    Assert.fail("time out..");
                }
            }
            for (int z = 0; z < elements.size(); z++) {
                elements.get(z).click();
                break;
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


    @When("^Validate error message is not displayed when quantity is entered as dispensed$")
    public void enters_product_information_with_DAW_N_and_SUB_Y(DataTable arg1) throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
                SmokeTestLibrary.enter_Text(arg1, "UPC", SmokeTestConstants.DrugName_Field, chromeDriver);
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
				SmokeTestLibrary.enter_Text(arg1, "Quantity", SmokeTestConstants.Quantity_field, chromeDriver);
			}
        
            Actions tabBtn = new Actions(chromeDriver);
            Action presstab = tabBtn.sendKeys(Keys.TAB).build();
            presstab.perform();
            
            IntakeStepDef.user_hits_TAB_key();
            Assert.assertFalse(isElementPresents(hangOnConstants.DE_PRODUCT_QUANTITY_ERROR_MESSAGE));

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


    @When("^user checks the patient plan$")
    public void user_checks_the__patient_plan() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String plan = FrameworkLibrary.getElementText(hangOnConstants.Intake_payment_plan_summary);
            boolean condition = chromeDriver.getPageSource().contains("No Primary Plan associated");
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


    @When("^user checks for the plan message$")
    public void user_checks_for_the_plan_message() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (condition == true) {
                Assert.assertEquals(plan, "No Primary Plan associated");
            } else {
                String DEplan = FrameworkLibrary.getElementText(hangOnConstants.DataEntry_payment_plan_summary);
                log.info("====" + DEplan);
                Assert.assertEquals(DEplan, "This patient might have a coupon for this prescription.");
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


    @When("^user clicks on update product button$")
    public void user_clicks_on_update_product_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(hangOnConstants.dr_product_update_btn)) {
                isElementPresentVerifyClick(hangOnConstants.dr_product_update_btn);
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


    @When("^user checks the paycode for generic drug when DAW=Y$")
    public void user_checks_the_paycode_for_generic_drug_when_DAW_Y(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
                SmokeTestLibrary.enter_Text(arg1, "DAW", SmokeTestConstants.Product_DAW, chromeDriver);
            }
            Actions tab = new Actions(chromeDriver);
            Action presstab = tab.sendKeys(Keys.TAB).build();
            presstab.perform();
            Assert.assertTrue(isElementPresentVerifyClick(dataReviewConstants.substitute_box));
            String s = FrameworkLibrary.getElementText(dataReviewConstants.Dr_payment_paycode1);
            log.info("The paycode is: " + s);
            boolean cond = s.contains("01-");
            Assert.assertTrue(cond);
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


    @When("^user checks the paycode for generic drug when DAW=N and substitute=N$")
    public void user_checks_the_paycode_for_generic_drug_when_DAW_N_and_substitute_N(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
                SmokeTestLibrary.enter_Text(arg1, "DAW", SmokeTestConstants.Product_DAW, chromeDriver);
            }
            Thread.sleep(2000);
            Actions tab = new Actions(chromeDriver);
            Action presstab = tab.sendKeys(Keys.TAB).build();
            presstab.perform();
            if (isElementPresentVerification(dataReviewConstants.substitute_box)) {
                SmokeTestLibrary.enter_Text(arg1, "Substitute", dataReviewConstants.substitute_box, chromeDriver);
            }
            Actions tab1 = new Actions(chromeDriver);
            Action presstab1 = tab1.sendKeys(Keys.TAB).build();
            presstab1.perform();
            Thread.sleep(2000);
            String paycode = FrameworkLibrary.getElementText(dataReviewConstants.Dr_payment_paycode1);
            log.info(paycode);
            boolean cond = paycode.contains("2 -");
            Assert.assertTrue(cond);

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


    @When("^user checks the paycode for generic drug when DAW=N and substitute=Y$")
    public void user_checks_the_paycode_for_generic_drug_when_DAW_N_and_substitute_Y(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(dataReviewConstants.substitute_box)) {
                SmokeTestLibrary.enter_Text(arg1, "Substitute", dataReviewConstants.substitute_box, chromeDriver);
            }
            Actions tab = new Actions(chromeDriver);
            Action presstab = tab.sendKeys(Keys.TAB).build();
            presstab.perform();
            Thread.sleep(2000);
            String paycode1 = FrameworkLibrary.getElementText(dataReviewConstants.Dr_payment_paycode1);
            boolean cond = paycode1.contains("0 -");
            Assert.assertTrue(cond);
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


    @When("^check the data base validations for product in stock$")
    public void check_the_data_base_validations_for_product_in_stock() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Connection connection = ConnectionFactory.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select a.code,b.CODE_TYPE,b.CODE_VALUE,b.ID_ACTUAL_PRODUCT_PACK from actual_product_pack a join product_coding b on a.ID = b.ID_ACTUAL_PRODUCT_PACK where a.code = 11460 ");
            ArrayList<String> ar = new ArrayList<String>();
            while (rs.next()) {
                String product_value = new String(rs.getString("CODE_VALUE"));
                log.info("the value is" + product_value);
                ar.add(product_value);
                log.info("The value is" + ar);
            }
            String Depnum = ar.get(4);
            String UPC = ar.get(5);
            log.info("the UPC number is :" + UPC);
            log.info("the value is:" + Depnum);
            if (Integer.parseInt(Depnum) == 1) {
                Assert.assertTrue(true);
                log.info("1=====");
            } else if (Integer.parseInt(Depnum) == 15) {
                Assert.assertTrue(true);
                log.info("2=======");
            } else {
                Assert.assertTrue(false);
            }
            connection.close();
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


    

    /****************************************************************************
     * Method :
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @Then("^check the stock in the stock plus$")
    public void check_the_stock_in_the_stock_plus() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Connection connection = ConnectionFactory.getConnectionStock();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select a.id,a.PRODUCT_SKU_CODE,a.STORE_CODE,B.TYPE,B.QUANTITY from STOCK A inner join stock_item b on a.id=b.id_stock where PRODUCT_SKU_CODE ='11460' and A.STORE_CODE='00001' and b.TYPE='On Shelf'"
            );
            while (rs.next()) {
                String Quantity = rs.getString("QUANTITY");
                log.info("======" + Quantity);
                int Qua = Integer.parseInt(Quantity) + 5;
                String Quan = Integer.toString(Qua);
                log.info("" + Quan);
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


    @Then("^enters following sigcode in directions$")
    public void enters_product_information(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Directions_field)) {
                getElementByProperty(SmokeTestConstants.Directions_field, chromeDriver).clear();
                SmokeTestLibrary.enter_Text(arg1, "Directions", SmokeTestConstants.Directions_field, chromeDriver);
            }
            chromeDriver.findElement(By.xpath(SmokeTestConstants.Directions_field)).sendKeys(Keys.TAB);
            String sigcoderesult = FrameworkLibrary.getElementText(SmokeTestConstants.Directions_field).trim();
            Assert.assertEquals(sigcoderesult, "TAKE 1 TABLET BY MOUTH DAILY");

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


    @Then("^Prescriber should be same in DR$")
    public void prescriber_should_be_same_in_DR(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String expectedFirstName = SmokeTestLibrary.getData(arg1, "FirstName").toLowerCase();
            String expectedLastName = SmokeTestLibrary.getData(arg1, "LastName").toLowerCase();
            log.info("Expected: " + expectedFirstName + " " + expectedLastName);
            String actualFirstName = getElementText(dataReviewConstants.Dr_Prescriber_FirstName).toLowerCase();
            String actualLastName = getElementText(dataReviewConstants.Dr_Prescriber_LastName).toLowerCase();
            log.info("Actual: " + actualFirstName + " " + actualLastName);
            Assert.assertTrue(actualFirstName.equals(expectedFirstName), "First names do not match");
            Assert.assertTrue(actualLastName.equals(expectedLastName), "Last names do not match");
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


    @Then("^User checks atleast one prescription in the POS is selected for the patient$")
    public void user_checks_atleast_one_prescription_in_the_POS_is_selected_for_the_patient() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            WebElement selectedPrescription = FrameworkLibrary.chromeDriver.findElement(By.xpath("//md-content/div[contains(@class,'patient-table-row')]/div[2]//div[contains(@class,'selected-list-item')]"));
            Assert.assertTrue(selectedPrescription != null, "No prescriptions are in selected state for the patient in POS page");
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


    @And("^User presses downarrow key to navigate through the patient prescriptions$")
    public void user_presses_downarrow_key_to_navigate_through_the_patient_prescriptions() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            prescriptionsInPOS = FrameworkLibrary.chromeDriver.findElements(By.xpath("//md-content/div[contains(@class,'patient-table-row')]/div[2]/div"));

            int i;
            for (i = 0; i < prescriptionsInPOS.size(); i++) {
                WebElement selectedPrescription = FrameworkLibrary.chromeDriver.findElement(By.xpath("//md-content/div[contains(@class,'patient-table-row')]/div[2]//div[contains(@class,'selected-list-item')]"));
                log.info("patient prescription " + i + " is: " + prescriptionsInPOS.get(i).getText());
                selectedPrescription.sendKeys(Keys.ARROW_DOWN);
            }
            Assert.assertTrue(i == prescriptionsInPOS.size() - 1, "Unable to navigate through the prescription using down arrow key");

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


    @And("^User presses uparrow key to navigate through the patient prescriptions$")
    public void user_presses_uparrow_key_to_navigate_through_the_patient_prescriptions() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            prescriptionsInPOS = FrameworkLibrary.chromeDriver.findElements(By.xpath("//md-content/div[contains(@class,'patient-table-row')]/div[2]/div"));
            int i;
            for (i = 0; i < prescriptionsInPOS.size(); i++) {
                WebElement selectedPrescription = FrameworkLibrary.chromeDriver.findElement(By.xpath("//md-content/div[contains(@class,'patient-table-row')]/div[2]//div[contains(@class,'selected-list-item')]"));
                log.info("patient prescription " + i + " is: " + prescriptionsInPOS.get(i).getText());
                selectedPrescription.sendKeys(Keys.ARROW_UP);
            }
            Assert.assertTrue(i == prescriptionsInPOS.size() - 1, "Unable to navigate through the prescription using up arrow key");

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


    @When("^clicks Med history tab using Alt plus m hot key$")
    public void clicks_Med_history_tab_using_Alt_plus_m_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(2000);
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("m").keyUp(Keys.ALT).build();
            series.perform();
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


    @Then("^User clicks the In progress link for current prescription in med history$")
    public void user_clicks_the_In_progress_link_for_current_prescription_in_med_history() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String rxnum = SmokeTestStepDef.dynamicrxnum;
            if (SmokeTestStepDef.dynamicrxnum.startsWith("0")) {
                rxnum = SmokeTestStepDef.dynamicrxnum.substring(1);
            }
            waitForVisibility("//div[contains(@class,'md-virtual-repeat-offsetter')]");
            WebElement e = chromeDriver.findElementByClassName("md-virtual-repeat-offsetter");
            while (!e.getText().contains(rxnum)) {
                Actions ac = new Actions(chromeDriver);
                Action a = ac.sendKeys(Keys.ARROW_DOWN).build();
                a.perform();
            }
            List<WebElement> l = chromeDriver.findElements(By.xpath("//*[contains(@id,'rx-history-item-list-')]"));
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i).getText().contains(rxnum)) {

                    String currentid = l.get(i).getAttribute("id");
                    String[] idparts = currentid.split("-");
                    String uniqueid = idparts[4];
                    boolean downArrowClicked = isElementPresentVerifyClick("//*[@id='down-arrow-icon-button-" + uniqueid + "']");
                    Assert.assertTrue(downArrowClicked, "User did not clicked on the down arrow in med history for Rx Number" + rxnum);
                    waitForVisibility("//*[@id='rx-history-details-" + uniqueid + "']/rxms-rx-history-details/div/div[2]/div/div/div/md-list[1]/md-list-item/div/a");
                    isElementPresentVerifyClick("//*[@id='rx-history-details-" + uniqueid + "']/rxms-rx-history-details/div/div[2]/div/div/div/md-list[1]/md-list-item/div/a");
                    waitForVisibility("//*[@id='fill-audit-history-content-dialog']/md-content/rxms-fill-history-card/md-card/md-card-title");
                    Assert.assertTrue(getElementText("//*[@id='fill-audit-history-content-dialog']/md-content/rxms-fill-history-card/md-card/md-card-title").equals("Fill History"));
                    break;
                }

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


    @Then("^update product name and validate directions, days supply and refills$")
    public void update_product_name_and_validate_directions_days_supply_and_refills(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            waitToClick(FrameworkConstants.DR_PRODUCT_UPDATE_BTN).click();
            String directionsData = new String(SmokeTestLibrary.getElementText(dataReviewConstants.drug_direction));
            String daysSupply = new String(SmokeTestLibrary.getElementText(dataReviewConstants.drug_day_supply));
            String refills = new String(SmokeTestLibrary.getElementText(dataReviewConstants.drug_refills));

            int directionsDataLen = directionsData.length();
            int daysSupplyLen = daysSupply.length();
            int refillsLen = refills.length();
            if (isElementPresentVerification(dataReviewConstants.DR_INPUT_PRESCRIBED_PRODUCT)) {
                SmokeTestLibrary.enter_Text(arg1, "DrugName", dataReviewConstants.DR_INPUT_PRESCRIBED_PRODUCT, chromeDriver);
            }
            Thread.sleep(5000);
            Actions upArrow = new Actions(chromeDriver);
            Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
            PressUpArrow.perform();
            Thread.sleep(3000);
            Actions tabBtn = new Actions(chromeDriver);
            Action presstab = tabBtn.sendKeys(Keys.TAB).build();
            presstab.perform();
            Thread.sleep(1000);
            directionsData = SmokeTestLibrary.getElementText(dataReviewConstants.drug_direction);
            daysSupply = SmokeTestLibrary.getElementText(dataReviewConstants.drug_day_supply);
            refills = SmokeTestLibrary.getElementText(dataReviewConstants.drug_refills);

            Assert.assertEquals(directionsData.length(), directionsDataLen);
            Assert.assertEquals(daysSupply.length(), daysSupplyLen);
            Assert.assertEquals(refills.length(), refillsLen);
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


    @When("^enters product information for Dispensed quantity less than quantity entered$")
    public void enters_product_information_for_Dispensed_quantity_less_than_quantity_entered(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            waitToClick(SmokeTestConstants.Product_OriginalDate);
            if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
                SmokeTestLibrary.enter_Text(arg1, "Date", SmokeTestConstants.Product_OriginalDate, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
                SmokeTestLibrary.enter_Text(arg1, "DAW", SmokeTestConstants.Product_DAW, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Product_Substitute)) {
                SmokeTestLibrary.enter_Text(arg1, "Substitute", SmokeTestConstants.Product_Substitute, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
                SmokeTestLibrary.enter_Text(arg1, "DrugName", SmokeTestConstants.DrugName_Field, chromeDriver);
            }
            Thread.sleep(2000);

            Actions upArrow = new Actions(chromeDriver);
            Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
            PressUpArrow.perform();
            Thread.sleep(1000);
            String entered_quantity = SmokeTestLibrary.getData(arg1, "Quantity");
            if (isElementPresentVerification(SmokeTestConstants.Quantity_field)) {
                SmokeTestLibrary.enter_Text(arg1, "Quantity", SmokeTestConstants.Quantity_field, chromeDriver);
            }
            String entered_Quantitydis = SmokeTestLibrary.getData(arg1, "QuantityDisp");
            if (isElementPresentVerification(SmokeTestConstants.Quantity_disp)) {
                SmokeTestLibrary.enter_Text(arg1, "QuantityDisp", SmokeTestConstants.Quantity_disp, chromeDriver);
            }
            String error_message = FrameworkLibrary.getElementText(hangOnConstants.DE_PRODUCT_QUANTITY_ERROR_MESSAGE);
            if (Integer.parseInt(entered_quantity) > Integer.parseInt(entered_Quantitydis)) {
                //Assert.assertEquals("the qty entered cannot be greater than"+ entered_quantity, error_message);
                log.info("entered dispensed value if greater than quantity");
            } else if (Integer.parseInt(entered_quantity) < Integer.parseInt(entered_Quantitydis)) {
                Assert.assertEquals("the qty entered should be equal or greater than prescribed qty", error_message);
            } else {
                log.info("entered dispensed quantity is equal to qunatity");
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


    @When("^enters product information for Dispensed quantity greater than quantity entered$")
    public void enters_product_information_for_Dispensed_quantity_greater_than_quantity_entered(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String entered_quantity = SmokeTestLibrary.getData(arg1, "Quantity");
            if (isElementPresentVerification(SmokeTestConstants.Quantity_field)) {
                SmokeTestLibrary.enter_Text(arg1, "Quantity", SmokeTestConstants.Quantity_field, chromeDriver);
            }
            String entered_Quantitydis = SmokeTestLibrary.getData(arg1, "QuantityDisp");
            if (isElementPresentVerification(SmokeTestConstants.Quantity_disp)) {
                SmokeTestLibrary.enter_Text(arg1, "QuantityDisp", SmokeTestConstants.Quantity_disp, chromeDriver);
            }
            String error_message = FrameworkLibrary.getElementText(hangOnConstants.DE_PRODUCT_QUANTITY_ERROR_MESSAGE);
            if (Integer.parseInt(entered_quantity) > Integer.parseInt(entered_Quantitydis)) {
                //Assert.assertEquals("the qty entered cannot be greater than"+ entered_quantity, error_message);
                log.info("entered dispensed value if greater than quantity");
            } else if (Integer.parseInt(entered_quantity) < Integer.parseInt(entered_Quantitydis)) {
                Assert.assertEquals("the qty entered should be equal or greater than prescribed qty", error_message);
            } else {
                log.info("entered dispensed quantity is equal to qunatity");
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


    @When("^performs all the actions on image$")
    public void performs_all_the_actions_on_image() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            waitToClick(hangOnConstants.DR_image_rotate_clockwise).click();
            waitToClick(hangOnConstants.DR_image_rotate_counterclockwise).click();
            waitToClick(hangOnConstants.DR_image_zoom_in).click();
            waitToClick(hangOnConstants.DR_image_reset).click();
            waitToClick(hangOnConstants.DR_image_zoom_out).click();
            waitToClick(hangOnConstants.DR_image_view_full_size).click();
            waitToClick(hangOnConstants.DR_image_full_size_close).click();

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


    @When("^click finish using ctrl f key$")
    public void click_finish_using_ctrl_f_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions click = new Actions(chromeDriver);
            Action Pressclick = click.keyDown(Keys.ALT).sendKeys("f").keyUp(Keys.ALT).build();
            Pressclick.perform();

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


    @Then("^state should default to \"([^\"]*)\"$")
    public void state_should_default_to_WI(String arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_SEARCH_PAGE_STATE_SELECTION)) {
                String actualState = FrameworkLibrary.getElementText(IntakeConstants.PRESCRIBER_SEARCH_PAGE_STATE_SELECTION);
                Assert.assertEquals(actualState, arg1, "expected state is " + arg1 + ", but actual is" + actualState);

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


    @Then("^state should default to \"([^\"]*)\" in DE$")
    public void state_should_default_to_WI_in_DE(String arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(hangOnConstants.PRESCRIBER_SEARCH_STATE_SELECTION_DE)) {
                String actualState = FrameworkLibrary.getElementText(hangOnConstants.PRESCRIBER_SEARCH_STATE_SELECTION_DE);
                Assert.assertEquals(actualState, arg1, "expected state is " + arg1 + ", but actual is" + actualState);
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


    @And("^validate directions field with description$")
    public void validate_directions_field_with_description(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            waitToClick(SmokeTestConstants.Product_OriginalDate);
            if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
                SmokeTestLibrary.enter_Text(arg1, "Date", SmokeTestConstants.Product_OriginalDate, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
                SmokeTestLibrary.enter_Text(arg1, "DAW", SmokeTestConstants.Product_DAW, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
                SmokeTestLibrary.enter_Text(arg1, "DrugName", SmokeTestConstants.DrugName_Field, chromeDriver);
            }

            Thread.sleep(2000);

            Actions upArrow = new Actions(chromeDriver);
            Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
            PressUpArrow.perform();
            Thread.sleep(1000);

            if (isElementPresentVerification(SmokeTestConstants.Quantity_field)) {
                SmokeTestLibrary.enter_Text(arg1, "Quantity", SmokeTestConstants.Quantity_field, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Directions_field)) {
                SmokeTestLibrary.enter_Text(arg1, "Directions", SmokeTestConstants.Directions_field, chromeDriver);
            }
            String expDrctns = FrameworkLibrary.getElementText(SmokeTestConstants.Directions_field);
            Robot key = new Robot();
            key.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(2000);
            String actDrctns = FrameworkLibrary.getElementText(SmokeTestConstants.Directions_field);
            Assert.assertTrue(actDrctns.equalsIgnoreCase(expDrctns), "actual did not match with expected");


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


    @Then("^system should allow to enter specific product information manually$")
    public void system_should_allow_to_enter_specific_product_information_manually(DataTable productInfo)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            waitToClick(SmokeTestConstants.Product_OriginalDate);
            if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
                SmokeTestLibrary.enter_Text(productInfo, "Date", SmokeTestConstants.Product_OriginalDate, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
                SmokeTestLibrary.enter_Text(productInfo, "DAW", SmokeTestConstants.Product_DAW, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Product_Substitute)) {
                SmokeTestLibrary.enter_Text(productInfo, "Substitute", DataEntryConstants.Product_Substitute, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
                SmokeTestLibrary.enter_Text(productInfo, "NDC", SmokeTestConstants.DrugName_Field, chromeDriver);
            }
            Thread.sleep(2000);

            Actions upArrow = new Actions(chromeDriver);
            Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
            PressUpArrow.perform();

            Thread.sleep(1000);
            if (isElementPresentVerification(SmokeTestConstants.Quantity_field)) {
                SmokeTestLibrary.enter_Text(productInfo, "Quantity", SmokeTestConstants.Quantity_field, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Directions_field)) {
                SmokeTestLibrary.enter_Text(productInfo, "Directions", SmokeTestConstants.Directions_field, chromeDriver);
            }

            Assert.assertFalse(isElementPresents(hangOnConstants.DE_QtyErrorMsg),
                    "system should allow to enter quantity in multiples");

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


    @And("^system should allow to enter specific product information using notation$")
    public void system_should_allow_to_enter_specific_product_information_using_notation(DataTable productInfo)
            throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            clearTextField(SmokeTestConstants.Quantity_field);
            clearTextField(SmokeTestConstants.Quantity_disp);
            if (isElementPresentVerification(SmokeTestConstants.Quantity_field)) {
                SmokeTestLibrary.enter_Text(productInfo, "Quantity", SmokeTestConstants.Quantity_field, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Directions_field)) {
                SmokeTestLibrary.enter_Text(productInfo, "Directions", SmokeTestConstants.Directions_field, chromeDriver);
            }
            Assert.assertFalse(isElementPresents(hangOnConstants.DE_QtyErrorMsg),
                    "system should allow to enter quantity in multiples");

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


    @When("^user hits Alt plus R to search results$")
    public void user_hits_Alt_plus_R_to_search_results() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(2000);
            Actions ab = new Actions(chromeDriver);
            Action series = ab.keyDown(Keys.ALT).sendKeys("r").keyUp(Keys.ALT).build();
            series.perform();
            waitForVisibility(DataEntryConstants.DE_Prescriber_Search_Results);
            String Prescriber = FrameworkLibrary.chromeDriver.findElement(By.xpath(DataEntryConstants.DE_Prescriber_Search_Results)).getText();
            Assert.assertTrue(!Prescriber.isEmpty(), "the prescriber message not present");
            String Label = FrameworkLibrary.chromeDriver.findElement(By.xpath(DataEntryConstants.de_prescriber_results_label)).getText();
            Assert.assertTrue(!Label.isEmpty(), "the message not present on page");
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


    @When("^user hits Alt plus L to clear the search prescriber$")
    public void user_hits_Alt_plus_L_to_clear_the_search_prescriber() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            waitForVisibility(hangOnConstants.DE_Prescriber_Clear_Field);
            Thread.sleep(2000);
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("L").keyUp(Keys.ALT).build();
            series.perform();
            waitForVisibility(SmokeTestConstants.Prescriber_LastName);
            String Prescriber = FrameworkLibrary.chromeDriver.findElement(By.xpath(SmokeTestConstants.Prescriber_LastName)).getText();
            Assert.assertTrue(Prescriber.isEmpty(), "the prescriber message not present");
            String Label = FrameworkLibrary.chromeDriver.findElement(By.xpath(SmokeTestConstants.Prescriber_FirstName)).getText();
            Assert.assertTrue(Label.isEmpty(), "the message not present on page");
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


    @And("^System should focus on patient accept button$")
    public void system_should_focus_on_patient_accept_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
        	if (getElementByProperty(SmokeTestConstants.Patient_AccceptButton, chromeDriver).getAttribute("class").contains("md-focused")) {
					throw new Exception("1 Accept not focused.");
			}
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


    @And("^user clicks on clinical history tab$")
    public void user_clicks_on_clinical_history_tab() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(ClinicalEvaluationConstants.CE_CLINICAL_HISTORY_TAB1)) {
                if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.CE_CLINICAL_HISTORY_TAB1)) {
                    throw new Exception("Not able to click on Patient_Left Menu Button");
                }
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


    @And("^system should display rx history details with store numbers in clinical history$")
    public void system_should_display_rx_history_details_with_store_numbers_in_clinical_history() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String rxnum = SmokeTestStepDef.dynamicrxnum;
            if (SmokeTestStepDef.dynamicrxnum.startsWith("0")) {
                rxnum = SmokeTestStepDef.dynamicrxnum.substring(1);
            }
            WebElement e = chromeDriver.findElementByClassName("md-virtual-repeat-offsetter");
            isElementPresentVerifyClick("//div[contains(@class,'md-virtual-repeat-offsetter')]/md-list");
            while (!e.getText().contains(rxnum)) {
                Actions ac = new Actions(chromeDriver);
                Action a = ac.sendKeys(Keys.ARROW_DOWN).build();
                a.perform();
            }
            List<WebElement> l = chromeDriver.findElements(By.xpath("//*[contains(@id,'clinical-history-item-list-')]"));
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i).getText().contains(rxnum)) {
                    String id = l.get(i).getAttribute("id");
                    String[] idparts = id.split("-");
                    String dynamicid = idparts[4];
                    waitForVisibility("//*[@id='down-arrow-icon-button-" + dynamicid + "']");
                    boolean downArrowClicked = isElementPresentVerifyClick("//*[@id='down-arrow-icon-button-" + dynamicid + "']");
                    Assert.assertTrue(downArrowClicked, "Unable to click on down arrow");
                    isElementPresentVerifyClick("//*[@id='fill-history-details-" + dynamicid + "']/div/div[2]/md-list/div[2]/a");
                }
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


    @And("^user able to see all interactions date and timings$")
    public void user_able_to_see_all_interactions_date_and_timings() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String rxnum = SmokeTestStepDef.dynamicrxnum;
            if (SmokeTestStepDef.dynamicrxnum.startsWith("0")) {
                rxnum = SmokeTestStepDef.dynamicrxnum.substring(1);
            }
            waitForVisibility("//*[@id='MAJOR-anchor']//div[contains(@id,'intervention-')]");

            List<WebElement> listForDatesOveride = chromeDriver.findElements(By.xpath("//*[@id='MAJOR-anchor']//div[contains(@id,'intervention-')]"));
            for (int i = 0; i < listForDatesOveride.size(); i++) {

                WebElement dateOveride = chromeDriver.findElement(By.xpath("//*[@id='MAJOR-anchor']//div[contains(@id,'intervention-" + i + "')]//div[2]/p"));
                String dateAndTimeFromApp = dateOveride.getText().substring(3);
                Connection sitConnection = ConnectionFactory.getConnectionICplus();
                String queryForPatientCode = "select rx_nbr,dur_override_dttm from ST_APP_1.TBF0_DUR_INTERACTION where rx_nbr='" + rxnum + "' and store_nbr='59144' FETCH FIRST 1 ROW ONLY";
                Statement createStatement = sitConnection.createStatement();
                ResultSet rs_overrride_info = createStatement.executeQuery(queryForPatientCode);
                java.sql.Timestamp date;
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MM/dd/YYYY hh:mm a");
                while (rs_overrride_info.next()) {
                    date = rs_overrride_info.getTimestamp("DUR_OVERRIDE_DTTM");
                    String dateAndTimeFromDB = sdf.format(date);
                    Assert.assertTrue(dateAndTimeFromApp.equals(dateAndTimeFromDB));
                }
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


    @And("^user validate the dispensed drug not displayed$")
    public void user_validate_the_dispensed_drug_not_displayed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Boolean dispended = FrameworkLibrary.isElementPresents(hangOnConstants.DE_No_Dispensed_Drug_Error);
            Assert.assertFalse(dispended);
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


    @And("^enters product information and validate dispensed drug not displayed$")
    public void enters_product_information_and_validate_dispensed_drug_not_displayed(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            waitToClick(SmokeTestConstants.Product_OriginalDate);
            if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
                SmokeTestLibrary.enter_Text(arg1, "Date", SmokeTestConstants.Product_OriginalDate, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
                SmokeTestLibrary.enter_Text(arg1, "DAW", SmokeTestConstants.Product_DAW, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
                SmokeTestLibrary.enter_Text(arg1, "DrugName", SmokeTestConstants.DrugName_Field, chromeDriver);
            }
            Thread.sleep(2000);
            Actions upArrow = new Actions(chromeDriver);
            Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
            PressUpArrow.perform();
            Thread.sleep(1000);
            Boolean dispended = FrameworkLibrary.isElementPresents(hangOnConstants.DE_No_Dispensed_Drug_Error);
            Assert.assertFalse(dispended);

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


    @And("^user hits alt plus e to select prescriber$")
    public void user_hits_alt_plus_e_to_select_prescriber() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(2000);
            Actions ab = new Actions(chromeDriver);
            Action series = ab.keyDown(Keys.ALT).sendKeys("e").keyUp(Keys.ALT).build();
            series.perform();
            boolean bc = FrameworkLibrary.isElementPresents(hangOnConstants.DE_Entire_Screen_Down_Buttons);
            Assert.assertFalse(bc);
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


    @And("^user hits alt plus p to open prescriber$")
    public void user_hits_alt_plus_p_to_open_prescriber() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(2000);
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("p").keyUp(Keys.ALT).build();
            series.perform();
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


    @And("^user clicks on Override in CE screen and select override timings$")
    public void user_clicks_on_Override_in_CE_screen_and_select_override_timings() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            NumberOfFillingTasks = Integer.parseInt(FrameworkLibrary.getElementText(SmokeTestConstants.fillingTaskNumber));
            String count = FrameworkLibrary.getElementText(ClinicalEvaluationConstants.Clinical_Evaluation_Major_Iteractions_Radio_Button);

            if (isElementPresentVerification(SmokeTestConstants.CE_OverrideButton)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.CE_OverrideButton)) {
                    throw new Exception("Not able to click on CE_OverrideButton");
                }
            }
            int cnt = Integer.parseInt(count);
            WebDriverWait waitforAlert = new WebDriverWait(chromeDriver, watingForElement);
            waitforAlert.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_override_popup)));
            boolean elementPresent = FrameworkLibrary.isElementPresents(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_override_popup);

            if (elementPresent == true) {
                for (int i = 0; i < cnt; i++) {
                    if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_dropdown)) {
                        if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_dropdown)) {
                            throw new Exception("Not able to click on Clinical_Evaluation_DUR_Override_dropdown");
                        }
                    }
                    Thread.sleep(2000);
                    Actions downArrow = new Actions(chromeDriver);
                    Action PressdownArrow = downArrow.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build();
                    PressdownArrow.perform();
                    if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_comments)) {
                        if (!clearAndEnterText(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_comments, "As per the patient guidance")) {
                            throw new Exception("Not able to enter value in password text field");
                        }
                    }
                    if (isElementPresentVerification(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_save)) {
                        if (!isElementPresentVerifyClick(ClinicalEvaluationConstants.Clinical_Evaluation_DUR_Override_save)) {
                            throw new Exception("Not able to click on Clinical_Evaluation_DUR_Override_save");
                        }
                    }
                }
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        } finally {
            Date today = Calendar.getInstance().getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("MM/dd");
            SimpleDateFormat formatter2 = new SimpleDateFormat("h:mm a");
            CEOverride = formatter.format(today);
        }
    }


    /****************************************************************************
     * Method :
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/


    @Then("^The pending link for current prescription should be clicked More than one time$")
    public void The_pending_link_for_current_prescription_should_be_clicked_More_than_one_time(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            SmokeTestStepDef.i_click_search_button_on_patient_order_status();
            SmokeTestStepDef.i_click_search_button_on_patient_order_status();
            List<WebElement> list1 = chromeDriver.findElements(By.xpath(SmokeTestConstants.POS_patientNames));
            String expectedPatientName = SmokeTestLibrary.getData(arg1, "LastName").toUpperCase();
            String pickuptime = SmokeTestStepDef.currentPickupTime;
            String pickupdate = SmokeTestStepDef.IntakeDate;
            String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;

            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).getText().contains(expectedPatientName)) {
                    String s = list1.get(i).getAttribute("id");
                    log.info(s);
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
                            log.info(ele);
                            Thread.sleep(4000);
                            WebElement elementToClick = waitToClick(ele);
                            Actions action = new Actions(chromeDriver);
                            action.moveToElement(elementToClick).doubleClick().build().perform();
                            break;
                        } else if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate) && singlepresc.get(z).getText().contains(possiblepickupTime1)) {
                            Thread.sleep(2000);
                            Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("pending"), "The pending link is not found for current prescription");
                            String dyn = singlepresc.get(z).getAttribute("id");
                            String[] dynamo = dyn.split("-");
                            String part = dynamo[2];
                            String ele = "//*[@id='single-prescription-" + part + "-" + z + "']/div[5]/div[1]/a";
                            log.info(singlepresc.get(z).getText());
                            Thread.sleep(4000);
                            WebElement elementToClick = waitToClick(ele);
                            Actions action = new Actions(chromeDriver);
                            action.moveToElement(elementToClick).doubleClick().build().perform();
                            break;
                        } else if (singlepresc.get(z).getText().toLowerCase().contains(SmokeTestStepDef.intakenextdate) && singlepresc.get(z).getText().contains(possiblepickupTime1)) {
                            Thread.sleep(2000);
                            Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("pending"), "The pending link is not found for current prescription");
                            String dyn = singlepresc.get(z).getAttribute("id");
                            String[] dynamo = dyn.split("-");
                            String part = dynamo[2];
                            String ele = "//*[@id='single-prescription-" + part + "-" + z + "']/div[5]/div[1]/a";
                            log.info(singlepresc.get(z).getText());
                            Thread.sleep(4000);
                            WebElement elementToClick = waitToClick(ele);
                            Actions action = new Actions(chromeDriver);
                            action.moveToElement(elementToClick).doubleClick().build().perform();
                            break;
                        } else {
                            log.info("The " + z + " prescription does not contain expected pickuptime in patient order status");
                        }
                    }
                }
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


    @When("^User click on Cancel donut popup$")
    public void user_click_on_Cancel_donut_popup() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(hangOnConstants.Pending_Donut_Cancel_Popup)) {
                if (!isElementPresentVerifyClick(hangOnConstants.Pending_Donut_Cancel_Popup)) {
                    throw new Exception("Not able to click on Pending_Donut_Cancel_Popup");
                }
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


    @Then("^User should not see donut popup$")
    public void user_should_not_see_donut_popup() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Assert.assertFalse(isElementPresents(hangOnConstants.Pending_Donut_Cancel_Popup));
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


    @When("^user hits Alt plus R to search the prescriber results$")
    public void When_user_hits_Alt_plus_R_to_search_the_prescriber_results() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(2000);
            Actions ab = new Actions(chromeDriver);
            Action series = ab.keyDown(Keys.ALT).sendKeys("r").keyUp(Keys.ALT).build();
            series.perform();
            if (isElementPresentVerification(hangOnConstants.DE_Prescriber_Empty_Screen)) {
                String Prescriber = FrameworkLibrary.chromeDriver.findElement(By.xpath(hangOnConstants.DE_Prescriber_Empty_Screen)).getText();
                Assert.assertTrue(!Prescriber.isEmpty(), "the prescriber message not present");
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


    @When("^User hit Enter$")
    public void user_hit_Enter() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            waitToClick(hangOnConstants.DR_PhoneNo).sendKeys(Keys.ENTER);
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


    @Then("^should not see error message$")
    public void should_not_see_error_message() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Assert.assertFalse(isElementPresents(hangOnConstants.DR_PhoneErrorMsg),
                    "system should not display error message");
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


    @When("^clicks DE taskboard$")
    public void click_DE_taskboard() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(SmokeTestConstants.DENumberofTasks)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.DENumberofTasks)) {
                    throw new Exception("Not able to click on DE Number of Tasks");
                }
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }
    
    /****************************************************************************
     * Method : clear phone no text field
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/
    
    @Then("^I clear the PhoneNo TexField$")
    public void i_clear_the_PhoneNo_TexField() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            FrameworkLibrary.clearTextField(SmokeTestConstants.patientOrder_phoneNumber);
            	
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }
    
    /****************************************************************************
     * Method : Clear Last name text field
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/
    
    @Then("^I clear the LastName TexField$")
    public void i_clear_the_LastName_TexField() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            FrameworkLibrary.clearTextField(SmokeTestConstants.patientOrderStatuts_patientSearchField);
            	
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }
    
    /****************************************************************************
     * Method : Validate Focus is on Phone no field
     * author : Photon
     * Date :
     * Modifier :
     * Modification Data :
     ******************************************************************************/
    
    @Then("^Focus is on PhoneNo Field$")
    public void focus_is_on_PhoneNo_Field() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
        	if (isElementPresentVerification(hangOnConstants.DR_PhoneNo_Focus)) {
                Boolean phoneNo = chromeDriver.findElement(By.xpath(hangOnConstants.DR_PhoneNo_Focus)).getAttribute("class").contains("md-input-focused");
                Assert.assertTrue(phoneNo);
            }	
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }
    
    @And("^user select product and perform tab order in product section$")
  public void user_select_product_and_perform_tab_order_in_product_section() throws Exception {

      methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

     try {
      	if (isElementPresentVerification(SmokeTestConstants.Open_Product)) {
				//if (isElementPresentVerifyClick(SmokeTestConstants.Open_Product)) {
                    
					if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
						WebElement prodOriginalDate = chromeDriver.findElementByXPath(SmokeTestConstants.Product_OriginalDate);
						Assert.assertTrue(prodOriginalDate.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Product Original Date field ");
						prodOriginalDate.sendKeys(Keys.TAB);
					}						  

					
						 if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
						      WebElement prodDAW = chromeDriver.findElementByXPath(SmokeTestConstants.Product_DAW);
						      Assert.assertTrue(prodDAW.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Product DAW field ");
						      prodDAW.sendKeys(Keys.TAB);
						   }
						
						if (isElementPresentVerification(SmokeTestConstants.Product_Substitute)) {
						      WebElement prodSubstitute = chromeDriver.findElementByXPath(SmokeTestConstants.Product_Substitute);
						      Assert.assertTrue(prodSubstitute.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Product Substitute field ");
						      prodSubstitute.sendKeys(Keys.TAB);
						   }
					
						
						if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
						      WebElement prodDrugName = chromeDriver.findElementByXPath(SmokeTestConstants.DrugName_Field);
						      Assert.assertTrue(prodDrugName.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the DrugName field ");
						      prodDrugName.sendKeys(Keys.TAB);
						   }
						
						if (isElementPresentVerification(SmokeTestConstants.DrugExpiryDate_Field)) {
						      WebElement prodDrugexpire = chromeDriver.findElementByXPath(SmokeTestConstants.DrugExpiryDate_Field);
						      Assert.assertTrue(prodDrugexpire.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Drug expiration field ");
						      prodDrugexpire.sendKeys(Keys.TAB);
						   }
						
						if (isElementPresentVerification(SmokeTestConstants.Quantity_field)) {
						      WebElement prodQuantityField = chromeDriver.findElementByXPath(SmokeTestConstants.Quantity_field);
						      Assert.assertTrue(prodQuantityField.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Quantity field ");
						      prodQuantityField.sendKeys(Keys.TAB);
						   }
					
						
						if (isElementPresentVerification(SmokeTestConstants.Quantity_disp)) {
						      WebElement prodQuantitydisp = chromeDriver.findElementByXPath(SmokeTestConstants.Quantity_disp);
						      Assert.assertTrue(prodQuantitydisp.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Quantity disp field ");
						      prodQuantitydisp.sendKeys(Keys.TAB);
						   }
						
						if (isElementPresentVerification(SmokeTestConstants.Directions_field)) {
						      WebElement prodDirectionsfield = chromeDriver.findElementByXPath(SmokeTestConstants.Directions_field);
						      Assert.assertTrue(prodDirectionsfield.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Directions field field ");
						      prodDirectionsfield.sendKeys(Keys.TAB);
						   }
					
						
						if (isElementPresentVerification(SmokeTestConstants.Days_Supply)) {
						      WebElement prodDaysSupply = chromeDriver.findElementByXPath(SmokeTestConstants.Days_Supply);
						      Assert.assertTrue(prodDaysSupply.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Days Supply field ");
						      prodDaysSupply.sendKeys(Keys.TAB);
						   }
						
						
						if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
						      WebElement prodRefillsfield = chromeDriver.findElementByXPath(SmokeTestConstants.Refills_field);
						      Assert.assertTrue(prodRefillsfield.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Refills field field ");
						      prodRefillsfield.sendKeys(Keys.TAB);
						   }
						
						if (isElementPresentVerification(SmokeTestConstants.RxExpiration_date)) {
						      WebElement prodRxExpirationdate = chromeDriver.findElementByXPath(SmokeTestConstants.RxExpiration_date);
						      Assert.assertTrue(prodRxExpirationdate.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the RxExpiration date field ");
						      prodRxExpirationdate.sendKeys(Keys.TAB);
						   }
				}
      	
    
          	
      } catch (Exception e) {
          takeScreenShot(methodName);
          throw new Exception(e.getMessage());
      }
   }
    
    /** This method is used to select the null value in the state dropdown in DR prescriber search.
	 *
	 * 
	 */

	@When("^User selects null value in the state dropdown on DR$")
	public static void select_null_value_state_drpdown_on_DR() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(hangOnConstants.DR_State_Dropdown)) {
				FrameworkLibrary.isElementPresentVerifyClick(hangOnConstants.DR_State_Dropdown);
			}
			Thread.sleep(5000);
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

    @When("^User clicks multiple times on Rxnumber hyperlink of current prescription$")
    public void user_double_clicks_rxnumber_hyperlink() throws Throwable {
    	methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions act = new Actions(chromeDriver);
			act.doubleClick(SmokeTestStepDef.RxnumberHyperlink).build().perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());		
	}
    }
    
    @Then("^The rx details popup should be displayed only once$")
    public void rx_details_popup_should_be_displayed_once() throws Throwable {
    	methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerification(SmokeTestConstants.rxDetailsPopup_POS_XButton)){
				if(!isElementPresentVerifyClick(SmokeTestConstants.rxDetailsPopup_POS_XButton)){
					throw new Exception("User not able to click X button on the popup");
				}
			Assert.assertFalse(isElementPresents(SmokeTestConstants.rxDetailsPopup_POS_XButton));
				
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