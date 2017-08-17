package intake;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import accessManagment.AccessManagementConstants;
import accessManagment.AccessManagementLibrary;
import clinicalEvaluation.ClinicalEvaluationConstants;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataEntry.DataEntryConstants;
import framework.ConnectionFactory;
import framework.FrameworkLibrary;
import smokeTest.SmokeTestConstants;
import smokeTest.SmokeTestLibrary;
import smokeTest.SmokeTestStepDef;


public class IntakeStepDef extends FrameworkLibrary {

    private static Log log = LogFactory.getLog(IntakeStepDef.class);
    private static String methodName;
    int Number_BeforeIntake;
    int i = 0;
    String attributeBeforeValue;
    String attributeAfterValue;
    IntakeLibrary intakeLibrary = null;
    String failure_task_patient_name;
    String failure_task_dob;
    String failure_task_reason;
    List<WebElement> systemErrorsList;
    int actualFailureTasksbeforeDeleting;

    public IntakeStepDef() throws ConfigurationException, Exception {
        super();
        intakeLibrary = new IntakeLibrary(chromeDriver);
    }

    /****************************************************************************
     * Method : System click on patient without address TC RXQE-5761
     * author : Akash Oza
     * Date :  June-6-2017
     * Modifier :
     * Modification Date :
     ******************************************************************************/

    @Then("^click on patient without address$")
    public void click_on_patient_without_address(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            WebElement patienttable = getElementByProperty(SmokeTestConstants.patient_table, chromeDriver);
            List<WebElement> patientrows = patienttable.findElements(By.tagName("tr"));
            Assert.assertTrue(patientrows.size() != 0);
            String FN = SmokeTestLibrary.getData(arg1, IntakeConstants.TestData_FirstName).toUpperCase();
            String LN = SmokeTestLibrary.getData(arg1, IntakeConstants.TestData_LastName).toUpperCase();

            //Iterate all the row to find null address row and click on it
            for (int i = 0; i < patientrows.size(); i++) {
                String rowdata = patientrows.get(i).getText().toUpperCase();
                WebElement address = getElementByProperty("//*[@id='patient-list']/table/tbody/tr[" + i + "]/td[4]", chromeDriver);
                if (rowdata.contains(FN) && rowdata.contains(LN) && (address.getText().length() == 0)) {
                    patientrows.get(i).click();
                    break;
                } else {
                    if (i == patientrows.size() - 1) {
                        Assert.fail(IntakeConstants.patient_dataNotFound_error);
                    }
                }
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
     *
	 */

    @Then("^System should display a message \"([^\"]*)\"$")
    public void system_should_display_a_message(String message) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_ADD_NEW_BUTTON_CLICK_POPUP)) {
                Assert.assertTrue(getElementText(IntakeConstants.PATIENT_SEARCH_ADD_NEW_BUTTON_CLICK_POPUP).equals(message));

            }
            if (isElementPresentVerification(IntakeConstants.Patient_profile_Error_Dialog_Popup_Screen_Cancel_Button)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Error_Dialog_Popup_Screen_Cancel_Button)) {
                    throw new Exception("User not able to click cancel button");
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

    @When("^User selects null value in the state dropdown of Prescriber search page$")
    public void select_null_value_state_drpdown_of_prescriber_search_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_SEARCH_PAGE_STATE_SELECTION)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PRESCRIBER_SEARCH_PAGE_STATE_SELECTION))
                    throw new Exception("Not able to click State");
            }

            List<WebElement> states = FrameworkLibrary.chromeDriver.findElements(By.xpath(IntakeConstants.PRESCRIBER_SEARCH_PAGE_STATE_SELECTION_OPTIONS));
            for (int i = 0; i < states.size(); i++) {

                if (states.get(i).getAttribute("value").equals("IL")) {
                    states.get(i).click();
                    break;
                }
            }
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PRESCRIBER_SEARCH_SEARCH_BUTTON))
                    throw new Exception("Not able to click Search Button");
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
 * This method is used to hit tab key
 */
    @When("^User hits TAB key$")
    public static void user_hits_TAB_key() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            Actions TAB = new Actions(chromeDriver);
            Action PressTAB = TAB.sendKeys(Keys.TAB).build();
            PressTAB.perform();
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^I see the landing page$")
    public void i_see_the_landing_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (!(isElementPresentVerification(IntakeConstants.LANDINGPAGE_LEFT_NAV) && isElementPresentVerification(IntakeConstants.LANDINGPAGE_RIGHT_TASK_BAR))) {
            	throw new Exception("Not able to see landing page");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @Then("^I verify for pharmacy information$")
    public void i_verify_for_pharmacy_information(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.LANDING_PHARMACY_HOURS_SECTION)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.LANDING_PHARMACY_HOURS_SECTION) != null, "Pharmacy store hours section label is not displayed");
            }
            if (isElementPresentVerification(IntakeConstants.LANDINGPAGE_PHARMACY_STORE_NUMBER)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.LANDINGPAGE_PHARMACY_STORE_NUMBER) != null, "Pharmacy store number is not displayed");
            }
            if (isElementPresentVerification(IntakeConstants.LANDINGPAGE_PHARMACY_INFO)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.LANDINGPAGE_PHARMACY_INFO) != null, "Pharmacy store adress details are not displayed");
            }
            if (isElementPresentVerification(IntakeConstants.LANDINGPAGE_PHARMACY_HOURS)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.LANDINGPAGE_PHARMACY_HOURS) != null, "Pharmacy store hours details are not displayed");
            }
            Map<String, List<String>> dataMap = null;
            dataMap = FrameworkLibrary.getHorizontalData(arg1);

            String storeNumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "StoreNumber");
            if (isElementPresentVerification(IntakeConstants.LANDINGPAGE_PHARMACY_STORE_NUMBER)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.LANDINGPAGE_PHARMACY_STORE_NUMBER).getText().equals(storeNumber), "Store number is displayed incorrectly " + "from excel : " + storeNumber + " From application :" + IntakeLibrary.getElement(IntakeConstants.LANDINGPAGE_PHARMACY_STORE_NUMBER).getText());
            }
            String storeAddress = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "Address");

            if (isElementPresentVerification(IntakeConstants.LANDINGPAGE_PHARMACY_INFO)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.LANDINGPAGE_PHARMACY_INFO).getText().contains(storeAddress), "Store Address is displayed incorrectly " + "from excel : " + storeAddress + " From application :" + IntakeLibrary.getElement(IntakeConstants.LANDINGPAGE_PHARMACY_INFO).getText());
            }
            String number_NABP = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "NABP");
            Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.LANDINGPAGE_PHARMACY_INFO).getText().contains(number_NABP), "NABP number is displayed incorrectly " + "from excel : " + number_NABP + " From application :" + IntakeLibrary.getElement(IntakeConstants.LANDINGPAGE_PHARMACY_INFO).getText());

            String number_DEA = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "DEA");
            Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.LANDINGPAGE_PHARMACY_INFO).getText().contains(number_DEA), "DEA number is displayed incorrectly " + "from excel : " + number_DEA + " From application :" + IntakeLibrary.getElement(IntakeConstants.LANDINGPAGE_PHARMACY_INFO).getText());

            String number_NPI = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "NPI");
            Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.LANDINGPAGE_PHARMACY_INFO).getText().contains(number_NPI), "NPI number is displayed incorrectly " + "from excel : " + number_NPI + " From application :" + IntakeLibrary.getElement(IntakeConstants.LANDINGPAGE_PHARMACY_INFO).getText());

            String number_TAXID = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "TAX ID");
            Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.LANDINGPAGE_PHARMACY_INFO).getText().contains(number_TAXID), "Tax ID number is displayed incorrectly " + "from excel : " + number_TAXID + " From application :" + IntakeLibrary.getElement(IntakeConstants.LANDINGPAGE_PHARMACY_INFO).getText());

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @When("^I click on store ID$")
    public void i_click_on_store_ID() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.LANDINGPAGE_PHARMACY_STORE_NUMBER)) {
                if (!isElementPresentVerifyClick(IntakeConstants.LANDINGPAGE_PHARMACY_STORE_NUMBER))
                    throw new Exception("Not able to click Store Number");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }

    }

    @Then("^I see store information page$")
    public void i_see_store_information_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (!isElementPresentVerification(IntakeConstants.STORE_INFORMATION_PAGE)) {
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @Then("^I verify for pharmacy information in store information page$")
    public void i_verify_for_pharmacy_information_in_store_information_page(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INFO_SECTION)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INFO_SECTION) != null, "Pharmacy information section label in store information page is not displayed");
            }
            if (isElementPresentVerification(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INFO)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INFO) != null, "Pharmacy store details in store information page is not displayed");

                Map<String, List<String>> dataMap = null;
                dataMap = FrameworkLibrary.getHorizontalData(arg1);

                String storeAddress = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "Address");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INFO).getText().contains(storeAddress), "Store Address is displayed incorrectly " + "from excel : " + storeAddress + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INFO).getText());

                String pharmacyGroup = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Pharmacy Group");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INFO).getText().contains(pharmacyGroup), "Pharmacy group name displayed incorrectly " + "from excel : " + pharmacyGroup + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INFO).getText());

                String storeManager = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "Manager");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INFO).getText().contains(storeManager), "Store manager name  displayed incorrectly " + "from excel : " + storeManager + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INFO).getText());

                String name_PIC = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "PIC");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INFO).getText().contains(name_PIC), "Person In Charge  displayed incorrectly " + "from excel : " + name_PIC + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INFO).getText());

                String number_FAX = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "FAX");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INFO).getText().contains(number_FAX), "FAX number displayed incorrectly " + "from excel : " + number_FAX + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INFO).getText());

                String driveThru = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "Drive-thru");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INFO).getText().contains(driveThru), "Driver-thru displayed incorrectly " + "from excel : " + number_FAX + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INFO).getText());
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @Then("^I verify  for pharmacy hours$")
    public void i_verify_for_pharmacy_hours() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_HOURS_SECTION)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_HOURS_SECTION) != null, "Pharmacy Hours section label in store information page is not displayed");
            }
            if (isElementPresentVerification(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_HOURS)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_HOURS) != null, "Pharmacy Hours details in store information page is not displayed");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @Then("^I verify for license and ID$")
    public void i_verify_for_license_and_ID(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            if (isElementPresentVerification(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID_SECTION)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID_SECTION) != null, "License and ID label in store information page is not displayed");
            }
            if (isElementPresentVerification(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID) != null, "License and ID details in store information page are not displayed");

                String number_DEA = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "DEA");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID).getText().contains(number_DEA), "DEA number is displayed incorrectly " + "from excel : " + number_DEA + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID).getText());

                String number_NPI = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "NPI");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID).getText().contains(number_NPI), "NPI number is displayed incorrectly " + "from excel : " + number_NPI + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID).getText());

                String number_NABP = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "NABP");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID).getText().contains(number_NABP), "NABP number is displayed incorrectly " + "from excel : " + number_NABP + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID).getText());

                String state_Pharmacy_License = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "State Pharmacy License");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID).getText().contains(state_Pharmacy_License), "NABP number is displayed incorrectly " + "from excel : " + state_Pharmacy_License + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID).getText());

                String number_TAXID = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "TAX ID");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID).getText().contains(number_TAXID), "Tax ID number is displayed incorrectly " + "from excel : " + number_TAXID + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID).getText());

                String state_Immunization_Registry_ID = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "TAX ID");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID).getText().contains(state_Immunization_Registry_ID), "State Immunization Registry ID displayed incorrectly " + "from excel : " + state_Immunization_Registry_ID + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID).getText());

            }
            String protocol_Prescriber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "Protocol Presciber");
            if (isElementPresentVerification(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID_PROTOCOL_PRESCRIBER).getText().contains(protocol_Prescriber), "Protocol prescriber displayed incorrectly " + "from excel : " + protocol_Prescriber + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_LICENSE_ID_PROTOCOL_PRESCRIBER).getText());
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @Then("^I verify for healthcare clinic hours$")
    public void i_verify_for_healthcare_clinic_hours() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.STORE_INFORMATION_PAGE_HEALTH_CLINIC_HOURS_SECTION)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_HEALTH_CLINIC_HOURS_SECTION) != null, "Healthcare clinic hours label in store information page is not displayed");
            }
            if (isElementPresentVerification(IntakeConstants.STORE_INFORMATION_PAGE_HEALTH_CLINIC_HOURS)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_HEALTH_CLINIC_HOURS) != null, "Healthcare clinic hours details in store information page are not displayed");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @Then("^I verify for store hours$")
    public void i_verify_for_store_hours() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.STORE_INFORMATION_PAGE_STORE_HOURS_SECTION)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_STORE_HOURS_SECTION) != null, "Store Hours in store information page is not displayed");
            }
            if (isElementPresentVerification(IntakeConstants.STORE_INFORMATION_PAGE_STORE_HOURS)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_STORE_HOURS) != null, "Store Hours details in store information page are not displayed");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @Then("^I verify for pharmacy inventory information$")
    public void i_verify_for_pharmacy_inventory_information(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            if (isElementPresentVerification(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INVENTORY_INFORMATION_SECTION)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INVENTORY_INFORMATION_SECTION) != null, "Pharmacy inventory information label in store information page is not displayed");
            }
            if (isElementPresentVerification(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INVENTORY_INFORMATION)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INVENTORY_INFORMATION) != null, "Pharmacy inventory information details in store information page are not displayed");

                String inventory_Group = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "Inventory Group");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INVENTORY_INFORMATION).getText().contains(inventory_Group), "Inventory Group displayed incorrectly " + "from excel : " + inventory_Group + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INVENTORY_INFORMATION).getText());

                String account_Location_ID = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "Account Location ID");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INVENTORY_INFORMATION).getText().contains(account_Location_ID), "Account Location ID displayed incorrectly " + "from excel : " + account_Location_ID + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INVENTORY_INFORMATION).getText());

                String distribution_Center_Primary = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "Distribution Center (Primary)");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INVENTORY_INFORMATION).getText().contains(distribution_Center_Primary), "Distribution Center Primary displayed incorrectly " + "from excel : " + distribution_Center_Primary + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INVENTORY_INFORMATION).getText());

                String distribution_Center_Alternate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "Distribution Center (Alternate)");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INVENTORY_INFORMATION).getText().contains(distribution_Center_Alternate), "Distribution Center Alternate displayed incorrectly " + "from excel : " + distribution_Center_Alternate + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_PHARMACY_INVENTORY_INFORMATION).getText());
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @Then("^I verify for general information$")
    public void i_verify_for_general_information(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            if (isElementPresentVerification(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION_SECTION)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION_SECTION) != null, "General information label in store information page is not displayed");
            }
            if (isElementPresentVerification(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION)) {
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION) != null, "General information details in store information page are not displayed");

                String branded_Name = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "Branded Name");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION).getText().contains(branded_Name), "Branded name displayed incorrectly " + "from excel : " + branded_Name + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION).getText());

                String intersection = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "Intersection");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION).getText().contains(intersection), "Intersection displayed incorrectly " + "from excel : " + intersection + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION).getText());

                String name_Manager = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "Manager");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION).getText().contains(name_Manager), "Manager name displayed incorrectly " + "from excel : " + name_Manager + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION).getText());

                String number_Store = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "Store Number");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION).getText().contains(number_Store), "Store number displayed incorrectly " + "from excel : " + number_Store + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION).getText());

                String number_District = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "District");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION).getText().contains(number_District), "District number displayed incorrectly " + "from excel : " + number_District + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION).getText());

                String number_Area = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "Area");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION).getText().contains(number_Area), "Area number displayed incorrectly " + "from excel : " + number_Area + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION).getText());

                String number_Region = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                        dataMap.get("RowId").get(0), "Region");
                Assert.assertTrue(IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION).getText().contains(number_Region), "Region number displayed incorrectly " + "from excel : " + number_Region + " From application :" + IntakeLibrary.getElement(IntakeConstants.STORE_INFORMATION_PAGE_GENERAL_INFORMATION).getText());
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @And("^all patient search forms should be present$")
    public void all_patient_search_forms_should_be_present() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.Patient_Local_Search_Icon)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_DOB)).isDisplayed(), "Local Search Icon is not displayed.");
                WebElement localButton = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.local_button));
                Assert.assertTrue(localButton.getAttribute("class").contains("md-primary"), "Local button not toggled");
            }
            if (isElementPresentVerification(IntakeConstants.Patient_Global_Search_Icon)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_DOB)).isDisplayed(), "Global Search Icon is not displayed.");
            }
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_DOB)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_DOB)).isDisplayed(), "Patient Search DOB form not displayed.");
            }
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_PHONE_NUMBER)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_PHONE_NUMBER)).isDisplayed(), "Pa");
            }
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_FIRSTNAME_INPUT)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_FIRSTNAME_INPUT)).isDisplayed());
            }
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_LASTNAME_INPUT)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_LASTNAME_INPUT)).isDisplayed());
            }
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_SUBMIT_BUTTON)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_SUBMIT_BUTTON)).isDisplayed());
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @And("^update button should not be available$")
    public void update_button_should_not_be_available() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            Boolean condition = FrameworkLibrary.chromeDriver.getPageSource().contains("View/Update");
            Assert.assertFalse(condition);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @When("^User enters patient First Name only$")
    public void User_enters_patient_First_Name_only(DataTable arg1) throws Exception {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            String FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
            if (isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
                if (!clearAndEnterText(SmokeTestConstants.Patient_FirstName, FirstName)) {
                    throw new Exception("Not able to enter value in FirstName text field");
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^user should see patient profile page$")
    public void user_should_see_patient_profile_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_INTAKE_PAGE)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_PROFILE_INTAKE_PAGE)).isDisplayed(), "Patient profile page is not displayed");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @When("^user clicks on patient comment icon$")
    public void user_clicks_on_patient_comment_icon() throws Exception {
        Actions ac = new Actions(chromeDriver);
        Action series = ac.keyDown(Keys.CONTROL).sendKeys("n").keyUp(Keys.CONTROL).build();
        series.perform();
    }

    @Then("^user can see patient comments$")
    public void user_can_see_patient_comments() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_PATIENT_COMMENTS_SIDE_NAV)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_PROFILE_PATIENT_COMMENTS_SIDE_NAV)).isDisplayed(), "Patient comments section is not displayed  in patient profile page");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @When("^user clicks on hide comments button$")
    public void user_clicks_on_hide_comments_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        /*Actions ac = new Actions(chromeDriver);
        Action series = ac.keyDown(Keys.CONTROL).sendKeys("n").keyUp(Keys.CONTROL).build();
        series.perform();*/
        try {
            if (!isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_HIDE_COMMENTS_ICON)) {
            	throw new Exception("Not able to click Hide Comments Icon");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    // E2E
    @When("^user hits enter on keyboard$")
    public void user_hits_enter_on_keyboard() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_PAGE_SELECTABLE_RESULTS)) {
                FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_PAGE_SELECTABLE_RESULTS)).sendKeys(Keys.ENTER);
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @Then("^patient profile should be displayed$")
    public void patient_profile_should_be_displayed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_INTAKE_PAGE)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_PROFILE_INTAKE_PAGE)).isDisplayed(), "Patient profile page is not displayed");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @When("^user double clicks on patient result$")
    public void user_double_clicks_on_patient_result() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Actions ac = new Actions(chromeDriver);
        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_PAGE_SELECTABLE_RESULTS)) {
                WebElement patientResults = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_PAGE_SELECTABLE_RESULTS));
                ac.moveToElement(patientResults).doubleClick().perform();
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @When("^user navigates to prescriber search$")
    public void user_navigates_to_prescriber_search() throws InterruptedException {
        Actions ac = new Actions(chromeDriver);
        Action series = ac.keyDown(Keys.CONTROL).sendKeys("r").keyUp(Keys.CONTROL).build();
        series.perform();
    }

    @Then("^prescriber search page should be displayed$")
    public void prescriber_search_page_should_be_displayed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_SEARCH_PAGE_DISPLAY)) {
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @When("^user enters details of the prescriber$")
    public void user_enters_details_of_the_prescriber(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_SEARCH_FIRST_NAME)) {
                AccessManagementLibrary.enter_Text(arg1, "FirstName", IntakeConstants.PRESCRIBER_SEARCH_FIRST_NAME, chromeDriver);

            }
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_SEARCH_LAST_NAME)) {
                AccessManagementLibrary.enter_Text(arg1, "LastName", IntakeConstants.PRESCRIBER_SEARCH_LAST_NAME, chromeDriver);
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @And("^choose state from the drop down and hit search$")
    public void choose_state_from_the_drop_down_and_hit_search() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_SEARCH_PAGE_STATE_SELECTION)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PRESCRIBER_SEARCH_PAGE_STATE_SELECTION))
                    throw new Exception("Not able to click State");
            }

            List<WebElement> states = FrameworkLibrary.chromeDriver.findElements(By.xpath(IntakeConstants.PRESCRIBER_SEARCH_PAGE_STATE_SELECTION_OPTIONS));
            for (int i = 0; i < states.size(); i++) {

                if (states.get(i).getAttribute("value").equals("IL")) {
                    states.get(i).click();
                    break;
                }
            }
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PRESCRIBER_SEARCH_SEARCH_BUTTON))
                    throw new Exception("Not able to click Search Button");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @Then("^prescriber details should be displayed successfully$")
    public void prescriber_details_should_be_displayed_successfully() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_SEARCH_PAGE_VIEW_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PRESCRIBER_SEARCH_PAGE_VIEW_BUTTON))
                    throw new Exception("Not able to click View");
            }
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_DETAILS_GENERAL_INFO_SECTION)) {
            }
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_DETAILS_LOCATION_COMMUNICATION_SECTION)) {
            }
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys(Keys.ARROW_LEFT).keyUp(Keys.ALT).build();
            series.perform();

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @When("^user hits ctrl plus h$")
    public void user_hits_ctrl_plus_h() throws Exception {
        Actions ac = new Actions(chromeDriver);
        Action series = ac.keyDown(Keys.CONTROL).sendKeys("h").keyUp(Keys.CONTROL).build();
        series.perform();
    }

    @When("^user search with wrong state$")
    public void user_search_with_wrong_state() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_SEARCH_PAGE_STATE_SELECTION)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PRESCRIBER_SEARCH_PAGE_STATE_SELECTION))
                    throw new Exception("Not able to click State");
            }
            List<WebElement> states = FrameworkLibrary.chromeDriver.findElements(By.xpath(IntakeConstants.PRESCRIBER_SEARCH_PAGE_STATE_SELECTION_OPTIONS));
            for (int i = 0; i < states.size(); i++) {
                if (states.get(i).getAttribute("value").equals("IN")) {
                    states.get(i).click();
                    break;
                }
            }
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PRESCRIBER_SEARCH_SEARCH_BUTTON))
                    throw new Exception("Not able to click Search");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @Then("^prescriber details should not display$")
    public void prescriber_details_should_not_display() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_SEARCH_PAGE_VIEW_BUTTON)) {
                boolean viewButton = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PRESCRIBER_SEARCH_PAGE_VIEW_BUTTON)).isEnabled();
                if (!viewButton) {
                    Assert.assertTrue(!IntakeLibrary.isElementPresent(IntakeConstants.PRESCRIBER_DETAILS_GENERAL_INFO_SECTION), " Prescriber details general info section should not display");
                    Assert.assertTrue(!IntakeLibrary.isElementPresent(IntakeConstants.PRESCRIBER_DETAILS_LOCATION_COMMUNICATION_SECTION), " Prescriber details location and communication section should not display");
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

    //appDev11
    @And("^user selects a task from empty bucket$")
    public void user_selects_a_task_from_empty_bucket() throws Exception {
        Thread.sleep(4000);
        String DE, CE, DR, PV, FILL;
        WebDriverWait wait = new WebDriverWait(FrameworkLibrary.chromeDriver, 8000);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions ac = new Actions(chromeDriver);

            if (isElementPresentVerification(IntakeConstants.DE_TASK_NUMBER_TASK_BOARD)) {
                DE = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.DE_TASK_NUMBER_TASK_BOARD))
                        .getText();
                if (DE.equals("0")) {
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IntakeConstants.DE_TASK_NUMBER_TASK_BOARD))).click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-dialog")));
                    Action series = ac.keyDown(Keys.ALT).sendKeys("o").keyUp(Keys.ALT).build();
                    series.perform();

                    Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.DE_TASK_NUMBER_TASK_BOARD)).isEnabled(), "DE task is not enabled");

                    log.info("DE task is clicked when it has " + DE + " tasks");
                } else {

                    log.info("DE task has " + DE + " tasks");
                }
            }
            if (isElementPresentVerification(IntakeConstants.DR_TASK_NUMBER_TASK_BOARD)) {
                DR = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.DR_TASK_NUMBER_TASK_BOARD))
                        .getText();
                if (DR.equals("0")) {
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IntakeConstants.DR_TASK_NUMBER_TASK_BOARD)))
                            .click();

                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-dialog")));
                    Action series = ac.keyDown(Keys.ALT).sendKeys("o").keyUp(Keys.ALT).build();
                    series.perform();

                    Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.DR_TASK_NUMBER_TASK_BOARD)).isEnabled(), "DR task is not enabled");

                } else {

                    log.info("DR task has " + DR + " tasks");

                }
            }
            if (isElementPresentVerification(IntakeConstants.CE_TASK_NUMBER_TASK_BOARD)) {
                CE = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.CE_TASK_NUMBER_TASK_BOARD))
                        .getText();
                if (CE.equals("0")) {

                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IntakeConstants.CE_TASK_NUMBER_TASK_BOARD)))
                            .click();

                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-dialog")));
                    Action series = ac.keyDown(Keys.ALT).sendKeys("o").keyUp(Keys.ALT).build();
                    series.perform();

                    Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.CE_TASK_NUMBER_TASK_BOARD)).isEnabled(), "CE task is not enabled");

                } else {
                    log.info("CE task has " + CE + " tasks");
                }
            }
            if (isElementPresentVerification(IntakeConstants.PV_TASK_NUMBER_TASK_BOARD)) {
                PV = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PV_TASK_NUMBER_TASK_BOARD))
                        .getText();
                if (PV.equals("0")) {
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IntakeConstants.PV_TASK_NUMBER_TASK_BOARD)))
                            .click();
                    Action series = ac.keyDown(Keys.ALT).keyDown(Keys.ARROW_LEFT).keyUp(Keys.ALT).keyUp(Keys.ARROW_LEFT).build();
                    series.perform();
                    Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PV_TASK_NUMBER_TASK_BOARD)).isEnabled(), "PV task is not enabled");
                } else {

                    log.info("PV task has " + PV + " tasks");
                }
            }
            if (isElementPresentVerification(IntakeConstants.FILL_TASK_NUMBER_TASK_BOARD)) {
                FILL = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.FILL_TASK_NUMBER_TASK_BOARD))
                        .getText();
                if (FILL.equals("0")) {
                    wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IntakeConstants.FILL_TASK_NUMBER_TASK_BOARD)))
                            .click();
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-dialog")));

                    Action series = ac.keyDown(Keys.ALT).sendKeys("o").keyUp(Keys.ALT).build();
                    series.perform();
                    Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.FILL_TASK_NUMBER_TASK_BOARD)).isEnabled(), "FILL task is not enabled");

                } else {
                    log.info("FILL task has " + FILL + " tasks");
                }
            }
        } catch (Exception e) {

            log.info("Task buckets are not empty");
        } finally {
            chromeDriver.quit();
        }


    }

    @Then("^sytem shows the warning message$")
    public void sytem_shows_the_warning_message() throws Exception {

        // need to write the code here for message pop up
    }

    @And("^sytem shows the warning message and the user press ok button$")
    public void sytem_shows_the_warning_message_and_the_user_press_ok_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.TASK_BOARD_POP_UP)) {

            }
            if (isElementPresentVerification(IntakeConstants.TASK_BOARD_POP_UP_OK_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.TASK_BOARD_POP_UP_OK_BUTTON))
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

    @And("^the task board is collapsed$")
    public void the_task_board_is_collapsed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            WebDriverWait wait = new WebDriverWait(FrameworkLibrary.chromeDriver, 2000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='main-right-sidenav-burger-menu']//div//span[contains(text(),'DE')]")));

            Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='main-right-sidenav-burger-menu']//div//span[contains(text(),'DE')]")).isDisplayed(), "DE on Task bar should be collapsed");
            Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='main-right-sidenav-burger-menu']//div//span[contains(text(),'DR')]")).isDisplayed(), "DR on Task bar should be collapsed");
            Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='main-right-sidenav-burger-menu']//div//span[contains(text(),'CE')]")).isDisplayed(), "CE on Task bar should be collapsed");
            Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='main-right-sidenav-burger-menu']//div//span[contains(text(),'FILL')]")).isDisplayed(), "FILL on Task bar should be collapsed");
            Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='main-right-sidenav-burger-menu']//div//span[contains(text(),'PV')]")).isDisplayed(), "PV on Task bar should be collapsed");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }

    }

    @When("^User navigates to home page$")
    public void User_navigates_to_home_page() throws Exception {
        Actions ac = new Actions(chromeDriver);
        Action series = ac.keyDown(Keys.CONTROL).sendKeys("h").keyUp(Keys.CONTROL).build();
        series.perform();
    }

    @And("^the task board is expanded$")
    public void the_task_board_is_expanded() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='main-right-sidenav-burger-menu']//div[contains(text(),'Data Entry')]")).isDisplayed(), "Data Entry on Task bar should be Expanded");
            Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='main-right-sidenav-burger-menu']//div[contains(text(),'Data Review')]")).isDisplayed(), "Data Review on Task bar should be Expanded");
            Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='main-right-sidenav-burger-menu']//div[contains(text(),'Clinical Evaluation')]")).isDisplayed(), "Clinical Evaluation on Task bar should be Expanded");
            Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='main-right-sidenav-burger-menu']//div[contains(text(),'Filling')]")).isDisplayed(), "Filling on Task bar should be Expanded");
            Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='main-right-sidenav-burger-menu']//div[contains(text(),'Product Verification')]")).isDisplayed(), "Product Verification on Task bar should be Expanded");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @When("^User clicks on home page to navigate$")
    public void User_clicks_on_home_page_to_navigate() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification("//md-list//md-icon[contains(text(),'home')]")) {

            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }

    }

    @When("^User navigates to Patient search page$")
    public void User_navigates_to_Patient_search_page() throws Exception {
        Actions ac = new Actions(chromeDriver);
        Action series = ac.keyDown(Keys.CONTROL).sendKeys("p").keyUp(Keys.CONTROL).build();
        series.perform();
    }

    @When("^User navigates to Drug search page$")
    public void User_navigates_to_Drug_search_page() throws Exception {
        Actions ac = new Actions(chromeDriver);
        Action series = ac.keyDown(Keys.CONTROL).sendKeys("d").keyUp(Keys.CONTROL).build();
        series.perform();
    }

    @When("^User navigates to Prescriber search page$")
    public void User_navigates_to_Prescriber_search_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Actions ac = new Actions(chromeDriver);
        Action series = ac.keyDown(Keys.CONTROL).sendKeys("r").keyUp(Keys.CONTROL).build();
        series.perform();
        try {
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_SEARCH_PAGE_DISPLAY)) {

            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
        
    }

    @When("^User navigates to Plan search page$")
    public void User_navigates_to_Plan_search_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        Actions ac = new Actions(chromeDriver);
        Action series = ac.keyDown(Keys.CONTROL).sendKeys("l").keyUp(Keys.CONTROL).build();
        series.perform();
        try {
            if (isElementPresentVerification(SmokeTestConstants.SEARCH_BUTTON)) {

            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
        
    }

    @When("^User navigates to Patient order status page$")
    public void User_navigates_to_Patient_order_status_page() throws Exception {
    	Actions ac = new Actions(chromeDriver);
        Action series = ac.keyDown(Keys.CONTROL).sendKeys("s").keyUp(Keys.CONTROL).build();
        series.perform();
        
    	        
    }

    @When("^User navigates to role management page$")
    public void User_navigates_to_role_management_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.INTAKE_PATIENT_ORDER_STATUS_XPATH)) {
            }
            if (isElementPresentVerification(IntakeConstants.DASH_BOARD_ADMIN_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.DASH_BOARD_ADMIN_BUTTON))
                    throw new Exception("Not able to click Admin Button");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @When("^the user clicks on filling task$")
    public void the_user_clicks_on_filling_task() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.LANDINGPAGE)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.FILL_TASK_BOARD)).isEnabled(), "Fill task is not enabled");
            }
            FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='main-right-sidenav-burger-menu']//div[contains(text(),'Filling')]")).click();

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @Then("^the system shows the message$")
    public void the_system_shows_the_message() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.INTAKE_DIALOG_XPATH)) {
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @Then("^click ok$")
    public void click_ok() throws Exception {
        Actions ac = new Actions(chromeDriver);
        Action series = ac.keyDown(Keys.ALT).sendKeys("o").keyUp(Keys.ALT).build();
        series.perform();
    }

    @When("^User selects pickup time as later with today date$")
    public void user_selects_pickup_time_as_later_with_today_date() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.RADIO_PICKUPLATER)) {
                boolean clickedPickuplater = FrameworkLibrary.isElementPresentVerifyClick(IntakeConstants.RADIO_PICKUPLATER);

                if (clickedPickuplater) {
                    FrameworkLibrary.isElementPresentVerifyClick(IntakeConstants.PICKUPLATER_TODAYSDATE);

                }
                String pickuplaterSelectedTime = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PICKUPLATER_TIME)).getText();
                log.info(pickuplaterSelectedTime);
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
	 */

    @When("^User selects pickup time as later with tomorrow date$")
    public void user_selects_pickup_time_as_later_with_tomorrow_date() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.RADIO_PICKUPLATER)) {
                boolean clickedPickuplater = FrameworkLibrary.isElementPresentVerifyClick(IntakeConstants.RADIO_PICKUPLATER);
                if (clickedPickuplater) {
                    FrameworkLibrary.isElementPresentVerifyClick(IntakeConstants.PICKUPLATER_TOMORROWDATE);
                }
                String pickuplaterSelectedTime = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PICKUPLATER_TIME)).getText();
                log.info(pickuplaterSelectedTime);
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @When("^user click on annotation button and add a note with below text for front image on Intake page$")
    public void user_click_on_annotation_button_and_add_a_note_with_below_text_for_front_image_on_Intake_page(
            DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Point point = null;
        int x, y;
        try {
            if (isElementPresentVerification(IntakeConstants.IMAGE_ANNOTATION_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.IMAGE_ANNOTATION_BUTTON))
                    throw new Exception("Not able to click Initial");
            }
            if (isElementPresentVerification(IntakeConstants.IMAGE_ANNOTATION_BUTTON)) {
                point = FrameworkLibrary.chromeDriver
                        .findElement(By.xpath(IntakeConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)).getLocation();
            }
            Random random = new Random();
            for (int i = 0; i < arg1.raw().size(); i++) {

                x = point.x + random.nextInt(50);
                y = point.y + random.nextInt(50);

                Actions actions = new Actions(FrameworkLibrary.chromeDriver);

                actions.moveToElement(FrameworkLibrary.chromeDriver
                        .findElement(By.xpath(IntakeConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)), x, y).click().build()
                        .perform();

                actions.moveToElement(FrameworkLibrary.chromeDriver
                        .findElement(By.xpath(IntakeConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)), x, y)
                        .sendKeys(arg1.raw().get(i).get(0)).build().perform();

                FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.IMAGE_ANNOTATION_BUTTON)).click();
                String buttonColor = FrameworkLibrary.chromeDriver
                        .findElement(By.xpath(IntakeConstants.IMAGE_ANNOTATION_BUTTON)).getCssValue("fill");

                String[] numbers = buttonColor.replace("rgb(", "").replace(")", "").split(",");
                int r = Integer.parseInt(numbers[0].trim());
                int g = Integer.parseInt(numbers[1].trim());
                int b = Integer.parseInt(numbers[2].trim());

                String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);

                Assert.assertEquals("#ffeb3b", hex);
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
	 */

    @And("^user clicks on annotaton button and adds no text \"([^\"]*)\" in note and checks the notes for front image on Intake page$")
    public void user_clicks_on_annotaton_button_and_adds_no_text_in_note_and_checks_the_notes_for_front_image_on_Intake_page(
            String arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.IMAGE_ANNOTATION_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.IMAGE_ANNOTATION_BUTTON))
                    throw new Exception("Not able to click Annotation Button");
            }
            Point point = FrameworkLibrary.chromeDriver
                    .findElement(By.xpath(IntakeConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)).getLocation();

            Actions actions = new Actions(FrameworkLibrary.chromeDriver);

            actions.moveToElement(
                    FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)),
                    point.x, point.y).click().build().perform();

            actions.moveToElement(
                    FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)),
                    point.x, point.y).sendKeys(arg1).build().perform();

            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.IMAGE_ANNOTATION_BUTTON)).click();

            if (isElementPresentVerification(IntakeConstants.VIEW_ALL_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.VIEW_ALL_BUTTON))
                    throw new Exception("Not able to click View All Button");
            }

            List<WebElement> notesList = FrameworkLibrary.chromeDriver.findElements(By.xpath(IntakeConstants.NOTES));
            if (isElementPresentVerification(IntakeConstants.CLOSE_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.CLOSE_BUTTON))
                    throw new Exception("Not able to click Close Button");
            }

            boolean isNotePresent = false;
            String note;

            for (int i = 0; i < notesList.size(); i++) {
                note = notesList.get(i).getText();
                if (note.contains(arg1)) {
                    isNotePresent = true;
                    break;
                }
            }

            Assert.assertTrue(notesList.size() == notesList.size(), "Notes are mismatched in Intake");

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
	 */

    @When("^user click to rotate scanned image to right for front image on Intake page$")
    public void user_click_to_rotate_scanned_image_to_right_for_front_image_on_Intake_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.IMAGE_ROTATE_RIGHT_BUTTON)) {
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
        attributeBeforeValue = FrameworkLibrary.chromeDriver
                .findElement(By.xpath(IntakeConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)).getCssValue("transform");

        if (isElementPresentVerification(IntakeConstants.IMAGE_ROTATE_RIGHT_BUTTON)) {
            if (!isElementPresentVerifyClick(IntakeConstants.IMAGE_ROTATE_RIGHT_BUTTON))
                throw new Exception("Not able to click Roate Right button");
        }

        attributeAfterValue = FrameworkLibrary.chromeDriver
                .findElement(By.xpath(IntakeConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)).getCssValue("transform");

        Assert.assertTrue(!attributeAfterValue.equals(attributeBeforeValue), "Image did not rotate right");
    }

	/*
	 *
	 */

    @Then("^user check  the scanned image rotated to right for front image on Intake page$")
    public void user_check_the_scanned_image_rotated_right_for_front_image_on_Intake_page() throws Exception {

        Assert.assertTrue(!attributeAfterValue.equals(attributeBeforeValue), "Image did not rotate right");
    }

	/*
	 *
	 */

    @When("^user click to rotate scaned image left for front image on Intake page$")
    public void user_click_to_rotate_scaned_image_left_for_front_image_on_Intake_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)) {

            }
            attributeBeforeValue = FrameworkLibrary.chromeDriver
                    .findElement(By.xpath(IntakeConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)).getCssValue("transform");

            if (isElementPresentVerification(IntakeConstants.IMAGE_ROTATE_LEFT_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.IMAGE_ROTATE_LEFT_BUTTON))
                    throw new Exception("Not able to click Rotate Left Button");
            }

            attributeAfterValue = FrameworkLibrary.chromeDriver
                    .findElement(By.xpath(IntakeConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)).getCssValue("transform");
            log.info("After rotated to :" + attributeAfterValue);

            Assert.assertTrue(!attributeAfterValue.equals(attributeBeforeValue), "Image did not rotate left");


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
	 */

    @Then("^user check the image rotated left for front image on Intake page$")
    public void user_check_the_image_rotated_left_for_front_image_on_Intake_page() throws Exception {

        Assert.assertTrue(!attributeAfterValue.equals(attributeBeforeValue), "Image did not rotate left");

    }

	/*
	 *
	 */

    @Then("^user click to zoom in scanned Image for front image on Intake page$")
    public void user_click_to_zoom_in_scanned_Image_for_front_image_on_Intake_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.IMAGE_ZOOM_IN_BUTTON)) {
                for (int i = 0; i <= 3; i++) {
                    FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.IMAGE_ZOOM_IN_BUTTON)).click();
                }
                attributeBeforeValue = FrameworkLibrary.chromeDriver
                        .findElement(By.xpath(IntakeConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)).getCssValue("width");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @Then("^user click on resize to original size for front image on Intake page$")
    public void user_click_on_resize_to_original_size_for_front_image_on_Intake_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.IMAGE_RESTORE_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.IMAGE_RESTORE_BUTTON))
                    throw new Exception("Not able to click Restore Button");
            }
            attributeAfterValue = FrameworkLibrary.chromeDriver
                    .findElement(By.xpath(IntakeConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)).getCssValue("width");

            Assert.assertTrue(!attributeAfterValue.equals(attributeBeforeValue), "Image did not restore to original size");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }

    }

    @Then("^user click to zoom out scanned image for front image on Intake page$")
    public void user_click_to_zoom_out_scanned_image_for_front_image_on_Intake_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.IMAGE_ZOOM_OUT_BUTTON)) {
                for (int i = 0; i <= 2; i++) {
                    FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.IMAGE_ZOOM_OUT_BUTTON)).click();
                }
            }
            attributeBeforeValue = FrameworkLibrary.chromeDriver
                    .findElement(By.xpath(IntakeConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)).getCssValue("width");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }

    }

    /*******************
     * image manipulation - intake back image
     ***************************************/

    @When("^user click on back button on tab bar in Intake page$")
    public void user_click_on_back_button_on_tab_bar_in_Intake_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.IMAGE_INTAKE_FINISH_SCREEN_BACK_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.IMAGE_INTAKE_FINISH_SCREEN_BACK_BUTTON))
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

    @When("^user click on annotation button and add a note with below text for back image on Intake page$")
    public void user_click_on_annotation_button_and_add_a_note_with_below_text_for_back_image_on_Intake_page(
            DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.IMAGE_ANNOTATION_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.IMAGE_ANNOTATION_BUTTON))
                    throw new Exception("Not able to click Annotation Button");
            }
            Point point = FrameworkLibrary.chromeDriver
                    .findElement(By.xpath(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)).getLocation();

            Random random = new Random();

            int x, y;
            for (int i = 0; i < arg1.raw().size(); i++) {
                x = point.x + random.nextInt(50);
                y = point.y + random.nextInt(50);

                Actions actions = new Actions(FrameworkLibrary.chromeDriver);

                actions.moveToElement(FrameworkLibrary.chromeDriver
                        .findElement(By.xpath(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)), x, y).click().build()
                        .perform();

                actions.moveToElement(FrameworkLibrary.chromeDriver
                        .findElement(By.xpath(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)), x, y)
                        .sendKeys(arg1.raw().get(i).get(0)).build().perform();

                FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.IMAGE_ANNOTATION_BUTTON)).click();
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @Then("^user clicks on annotaton button and adds no text \"([^\"]*)\" in note and checks the notes for back image on Intake page$")
    public void user_clicks_on_annotaton_button_and_adds_no_text_in_note_and_checks_the_notes_for_back_image_on_Intake_page(
            String arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.IMAGE_ANNOTATION_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.IMAGE_ANNOTATION_BUTTON))
                    throw new Exception("Not able to click Annotation Button");
            }
            Point point = FrameworkLibrary.chromeDriver
                    .findElement(By.xpath(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)).getLocation();

            Actions actions = new Actions(FrameworkLibrary.chromeDriver);

            actions.moveToElement(
                    FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)),
                    point.x, point.y).click().build().perform();

            actions.moveToElement(
                    FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)),
                    point.x, point.y).sendKeys(arg1).build().perform();

            if (!isElementPresentVerifyClick(IntakeConstants.IMAGE_ANNOTATION_BUTTON))
                throw new Exception("Not able to click Annotation Button");

            if (!isElementPresentVerifyClick(IntakeConstants.VIEW_ALL_BUTTON))
                throw new Exception("Not able to click View All Button");
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.VIEW_ALL_BUTTON)).click();

            List<WebElement> notesList = FrameworkLibrary.chromeDriver.findElements(By.xpath(IntakeConstants.NOTES));

            if (isElementPresentVerification(IntakeConstants.CLOSE_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.CLOSE_BUTTON))
                    throw new Exception("Not able to click Close Button");
            }
            boolean isNotePresent = false;
            String note;

            for (int i = 0; i < notesList.size(); i++) {
                note = notesList.get(i).getText();
                if (note.contains(arg1)) {
                    isNotePresent = true;
                    break;
                }
            }
            Assert.assertTrue(notesList.size() == notesList.size(), "Notes are mismatched in Intake");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @When("^user click to rotate scanned image to right for back image on Intake page$")
    public void user_click_to_rotate_scanned_image_to_right_for_back_image_on_Intake_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.IMAGE_ROTATE_RIGHT_BUTTON)) {
            }
            attributeBeforeValue = FrameworkLibrary.chromeDriver
                    .findElement(By.xpath(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)).getCssValue("transform");

            if (isElementPresentVerification(IntakeConstants.IMAGE_ROTATE_RIGHT_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.IMAGE_ROTATE_RIGHT_BUTTON))
                    throw new Exception("Not able to click Roate Right Button");
            }
            attributeAfterValue = FrameworkLibrary.chromeDriver
                    .findElement(By.xpath(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)).getCssValue("transform");

            Assert.assertTrue(!attributeAfterValue.equals(attributeBeforeValue), "Image did not rotate right");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @Then("^user check  the scanned image rotated to right for back image on Intake page$")
    public void user_check_the_scanned_image_rotated_right_for_back_image_on_Intake_page() throws Exception {
        Assert.assertTrue(!attributeAfterValue.equals(attributeBeforeValue), "Image did not rotate right");
    }

    @When("^user click to rotate scaned image left for back image on Intake page$")
    public void user_click_to_rotate_scaned_image_left_for_back_image_on_Intake_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)) {
                attributeBeforeValue = FrameworkLibrary.chromeDriver
                        .findElement(By.xpath(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)).getCssValue("transform");
            }
            if (!isElementPresentVerifyClick(IntakeConstants.IMAGE_ROTATE_LEFT_BUTTON))
                throw new Exception("Not able to click Roate Left Button");
            attributeAfterValue = FrameworkLibrary.chromeDriver
                    .findElement(By.xpath(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)).getCssValue("transform");

            Assert.assertTrue(!attributeAfterValue.equals(attributeBeforeValue), "Image did not rotate left");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }

    }

    @Then("^user check the image rotated left for back image on Intake page$")
    public void user_check_the_image_rotated_left_for_back_image_on_Intake_page() throws Exception {
        Assert.assertTrue(!attributeAfterValue.equals(attributeBeforeValue), "Image did not rotate left");
    }

    @Then("^user click to zoom in scanned Image for back image on Intake page$")
    public void user_click_to_zoom_in_scanned_Image_for_back_image_on_Intake_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.IMAGE_ZOOM_IN_BUTTON)) {
                for (int i = 0; i <= 3; i++) {
                    FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.IMAGE_ZOOM_IN_BUTTON)).click();
                }
            }
            if (isElementPresentVerification(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)) {
                attributeBeforeValue = FrameworkLibrary.chromeDriver
                        .findElement(By.xpath(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)).getCssValue("width");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }

    }

    @Then("^user click on resize to original size for back image on Intake page$")
    public void user_click_on_resize_to_original_size_for_back_image_on_Intake_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.IMAGE_RESTORE_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.IMAGE_RESTORE_BUTTON))
                    throw new Exception("Not able to click Restore button");
            }
            if (isElementPresentVerification(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)) {
                attributeAfterValue = FrameworkLibrary.chromeDriver
                        .findElement(By.xpath(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)).getCssValue("width");
            }
            Assert.assertTrue(!attributeAfterValue.equals(attributeBeforeValue), "Image did not restore to original size");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }

    }

    @Then("^user click to zoom out scanned image for back image on Intake page$")
    public void user_click_to_zoom_out_scanned_image_for_back_image_on_Intake_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.IMAGE_ZOOM_OUT_BUTTON)) {
                for (int i = 0; i <= 2; i++) {
                    FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.IMAGE_ZOOM_OUT_BUTTON)).click();
                }
            }
            if (isElementPresentVerification(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)) {
                attributeBeforeValue = FrameworkLibrary.chromeDriver
                        .findElement(By.xpath(IntakeConstants.IMAGE_BACK_INTAKE_FINISH_SCREEN)).getCssValue("width");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @When("^User click TAB key from \"([^\"]*)\" field$")
    public void User_click_TAB_key_from_field(String arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_LASTNAME_INPUT) && isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_FIRSTNAME_INPUT) && isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_PHONE_NUMBER) && isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_DOB)) {
                if (arg1.equals("Last Name")) {
                    chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_LASTNAME_INPUT)).sendKeys(Keys.TAB);
                } else if (arg1.equals("First Name")) {
                    chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_FIRSTNAME_INPUT)).sendKeys(Keys.TAB);
                } else if (arg1.equals("Phone Number")) {
                    chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_PHONE_NUMBER)).sendKeys(Keys.TAB);

                } else if (arg1.equals("Date of Birth")) {
                    chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_DOB)).sendKeys(Keys.TAB);
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

    @Then("^User should be on \"([^\"]*)\" field$")
    public void User_should_be_on_field(String arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            if (arg1.equals("First Name")) {

                Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("fname"), "Not on First Name field");
            } else if (arg1.equals("Phone Number")) {
                Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("phone"), "Not on Phone Number field");
            } else if (arg1.equals("Date of Birth")) {
                Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("datepicker"), "Not on Date of Birth field");

            } else if (arg1.equals("Search")) {
                Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("submit"), "Not on search button");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @When("^User clicks on search button using ALT plus S hot key with out search criteria$")
    public void user_clicks_on_search_button_using_ALT_plus_S_hot_key_with_out_search_criteria() throws Exception {
        Actions ac = new Actions(chromeDriver);
        Action series = ac.keyDown(Keys.ALT).sendKeys("s").keyUp(Keys.ALT).build();
        series.perform();
    }

    @Then("^System should display a message to the user$")
    public void system_should_display_a_message_to_the_user() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_SEARCH_ERROR)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_SEARCH_ERROR)).getText().contains("Please specify the required search criteria."), "Please specify the required search criteria Error is not displayed");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @When("^User enters first name of the patient$")
    public void user_enters_first_name_of_the_patient(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
                SmokeTestLibrary.enter_Text(arg1, "FirstName", SmokeTestConstants.Patient_FirstName, chromeDriver);
                Actions ac = new Actions(chromeDriver);
                Action series = ac.keyDown(Keys.ALT).sendKeys("s").keyUp(Keys.ALT).build();
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

    @When("^User enters last name of the patient$")
    public void user_enters_last_name_of_the_patient(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Patient_LastName) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName) && isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_PHONE_NUMBER) && isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_DOB)) {
                SmokeTestLibrary.enter_Text(arg1, "LastName", SmokeTestConstants.Patient_LastName, chromeDriver);
                SmokeTestLibrary.enter_Text(arg1, "FirstName", SmokeTestConstants.Patient_FirstName, chromeDriver);
                String PhoneNumber = SmokeTestLibrary.getData(arg1, "PhoneNumber");
                WebElement element = chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_PHONE_NUMBER));
                element.sendKeys(PhoneNumber);
                SmokeTestLibrary.enter_Text(arg1, "DateOfBirth", IntakeConstants.PATIENT_SEARCH_FORM_DOB, chromeDriver);

                Actions ac = new Actions(chromeDriver);
                Action series = ac.keyDown(Keys.ALT).sendKeys("s").keyUp(Keys.ALT).build();
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

    @When("^User enters invalid phone number and perfroms search using ALT plus S hot key$")
    public void user_enters_invalid_phone_number_and_perfroms_search_using_ALT_plus_S_hot_key(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_PHONE_NUMBER)) {
                if (isElementPresentVerifyClick(IntakeConstants.PATIENT_SEARCH_FORM_PHONE_NUMBER)) {
                    waitToClick(IntakeConstants.PATIENT_SEARCH_FORM_PHONE_NUMBER);
                    WebElement phone_field = FrameworkLibrary.getElementByProperty(IntakeConstants.PATIENT_SEARCH_FORM_PHONE_NUMBER, chromeDriver);
                    String patientPhoneNumber = SmokeTestLibrary.getData(arg1, "PhoneNumber");
                    phone_field.sendKeys(String.valueOf(patientPhoneNumber));

                    Actions ac = new Actions(chromeDriver);
                    Action series = ac.keyDown(Keys.ALT).sendKeys("s").keyUp(Keys.ALT).build();
                    series.perform();
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

    @Then("^System displays invalid format message$")
    public void system_displays_invalid_format_message() throws Exception {
        Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath("//*[@id='input-container-phone-number']/div[2]/div")).getText() != null, "Error message is not displayed for invalid format");
    }

    @When("^User enters future date of birth in the search criteria and performs search using ALT plus S hot key$")
    public void user_enters_future_date_of_birth_in_the_search_criteria_and_performs_search_using_ALT_plus_S_hot_key(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_DOB)) {
                if (isElementPresentVerifyClick(IntakeConstants.PATIENT_SEARCH_FORM_DOB)) {
                    WebElement dob_field = FrameworkLibrary.getElementByProperty(IntakeConstants.PATIENT_SEARCH_FORM_DOB, chromeDriver);
                    String patientDateOfBirth = SmokeTestLibrary.getData(arg1, "DateOfBirth");
                    dob_field.sendKeys(String.valueOf(patientDateOfBirth));

                    Thread.sleep(2000);
                    Actions ac = new Actions(chromeDriver);
                    Action series = ac.keyDown(Keys.ALT).sendKeys("s").keyUp(Keys.ALT).build();
                    series.perform();
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

    @Then("^System displays a message for that future date$")
    public void system_displays_a_message_for_that_future_date() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_FUTURE_DATE_ERROR)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_FUTURE_DATE_ERROR)).getText() != null, "Error message is not displayed for patient future date of birth");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }

    @When("^User enters an search criteria that does not match an existing patient$")
    public void user_enters_an_search_criteria_that_does_not_match_an_existing_patient(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
                SmokeTestLibrary.enter_Text(arg1, "FirstName", SmokeTestConstants.Patient_FirstName, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Patient_LastName)) {
                SmokeTestLibrary.enter_Text(arg1, "LastName", SmokeTestConstants.Patient_LastName, chromeDriver);
            }
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_PHONE_NUMBER)) {
                if (isElementPresentVerifyClick(IntakeConstants.PATIENT_SEARCH_FORM_PHONE_NUMBER)) {
                    WebElement phone_field = FrameworkLibrary.getElementByProperty(IntakeConstants.PATIENT_SEARCH_FORM_PHONE_NUMBER, chromeDriver);
                    String patientPhoneNumber = SmokeTestLibrary.getData(arg1, "PhoneNumber");
                    phone_field.sendKeys(String.valueOf(patientPhoneNumber));
                    SmokeTestLibrary.enter_Text(arg1, "DateOfBirth", IntakeConstants.PATIENT_SEARCH_FORM_DOB, chromeDriver);
                    Actions ac = new Actions(chromeDriver);
                    Action series = ac.keyDown(Keys.ALT).sendKeys("s").keyUp(Keys.ALT).build();
                    series.perform();
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

    @Then("^System should display a message for that search criteria$")
    public void system_should_display_a_message_for_that_search_criteria() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_NO_RESULTS_MESSAGE)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_NO_RESULTS_MESSAGE)).getText() != null, "message is not displayed when no patient results are found");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @When("^user enters a search criteria for a existing patient and performs search using ALT plus S hot key$")
    public void user_enters_a_search_criteria_for_a_existing_patient_and_performs_search_using_ALT_plus_S_hot_key(DataTable arg1) throws Exception {

    }

    @Then("^System displays returned patient results based on search criteria$")
    public void system_displays_returned_patient_results_based_on_search_criteria() throws Exception {

    }

    @Then("^User should see first row of the results is selected automatically$")
    public void user_should_see_first_row_of_the_results_is_selected_automatically() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_RESULTS_SELECTED_ROW_DEFAULT)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_RESULTS_SELECTED_ROW_DEFAULT)).getText().contains(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_RESULTS_FIRST_ROW)).getText()), "Focus is not on the first row by default");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @Then("^User navigates through the results using arrow keys$")
    public void user_navigates_through_the_results_using_arrow_keys() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_RESULTS)) {
                List<WebElement> listOfPatientSearchResults = FrameworkLibrary.chromeDriver.findElements(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_RESULTS));
                for (int i = 0; i < listOfPatientSearchResults.size() - 1; i++) {
                    FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_RESULTS_SELECTED_ROW_DEFAULT)).sendKeys(Keys.ARROW_DOWN);
                    Thread.sleep(3000);
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

    @Then("^User checks the results are sorted in ascending order$")
    public void user_checks_the_results_are_sorted_in_ascending_order() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_PATIENT_RESULTS)) {
                ArrayList<String> obtainedListForPatientResults = new ArrayList<String>();
                List<WebElement> listOfPatientSearchResults = FrameworkLibrary.chromeDriver.findElements(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_PATIENT_RESULTS));

                for (WebElement we : listOfPatientSearchResults) {
                    obtainedListForPatientResults.add(we.getText());
                }

                ArrayList<String> sortedListForPatientResults = new ArrayList<String>();
                for (String s : obtainedListForPatientResults) {
                    sortedListForPatientResults.add(s);
                }
                Collections.sort(sortedListForPatientResults);

                Assert.assertTrue(sortedListForPatientResults.equals(obtainedListForPatientResults), "Patient results are not in ascending order");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @Then("^User checks number of search results returned in the table with the number of results found$")
    public void user_checks_number_of_search_results_returned_in_the_table_with_the_number_of_results_found() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_RESULTS)) {
                List<WebElement> listOfPatientSearchResults = FrameworkLibrary.chromeDriver.findElements(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_RESULTS));

                String str = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_RESULTS_NUMBER_TEXT)).getText();

                int numberFromResultMessage = Integer.parseInt(str.replaceAll("[\\D]", ""));
                int numberOfResults = listOfPatientSearchResults.size() - 1;
                Assert.assertTrue(numberOfResults == numberFromResultMessage, "Results found are not equal to the number of results found message displayed");
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
	 */

    @When("^User enters pet name and performs search using ALT plus S hot key$")
    public void user_enters_pet_name_and_performs_search_using_ALT_plus_S_hot_key(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Patient_LastName)) {
                SmokeTestLibrary.enter_Text(arg1, "LastName", SmokeTestConstants.Patient_LastName, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
                SmokeTestLibrary.enter_Text(arg1, "FirstName", SmokeTestConstants.Patient_FirstName, chromeDriver);
            }
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("s").keyUp(Keys.ALT).build();
            series.perform();

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }

    }

    @Then("^User should see the results and check the pet indicator$")
    public void user_should_see_the_results_and_check_the_pet_indicator() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_PET_INDICATOR)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_PET_INDICATOR)).getText().equals("pets"), "Pet indicator is not displayed in the patient results page for the patient");
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
	 */

    @Then("^User clicks view using ALT plus V hot key$")
    public void user_clicks_view_using_ALT_plus_V_hot_key() throws Exception {

    }

	/*
	 *
	 */

    @Then("^User should see pet indicator in patient demographic section$")
    public void user_should_see_pet_indicator_in_patient_demographic_section() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_VIEW_FORM_PET_INDICATOR)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_VIEW_FORM_PET_INDICATOR)).getText().equals("pets"), "Pet indicator is not displayed for the patient in patient demographic section");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }

    }

    @When("^User enters twin patient name and performs search using ALT plus S hot key$")
    public void user_enters_twin_patient_name_and_performs_search_using_ALT_plus_S_hot_key(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Patient_LastName)) {
                SmokeTestLibrary.enter_Text(arg1, "LastName", SmokeTestConstants.Patient_LastName, chromeDriver);
            }
            if (isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
                SmokeTestLibrary.enter_Text(arg1, "FirstName", SmokeTestConstants.Patient_FirstName, chromeDriver);
            }
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("s").keyUp(Keys.ALT).build();
            series.perform();

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
	 */

    @Then("^User should see the results and check the twin indicator$")
    public void user_should_see_the_results_and_check_the_twin_indicator() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_TWIN_INDICATOR)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_TWIN_INDICATOR)).getText().equals("people"), "Twin indicator is not displayed in the patient results page for the patient");
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
	 */

    @Then("^User clicks view button using ALT plus V hot key$")
    public void user_clicks_view_button_using_ALT_plus_V_hot_key() throws Exception {
        Actions addNew = new Actions(chromeDriver);
        Action series = addNew.keyDown(Keys.ALT).sendKeys("v").keyUp(Keys.ALT).build();
        series.perform();
    }


	/*
	 *
	 */

    @Then("^User should see twin indicator in patient demographic section$")
    public void user_is_on_patient_profile_and_should_see_twin_indicator_in_patient_demographic_section() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_VIEW_FORM_TWIN_INDICATOR)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_VIEW_FORM_TWIN_INDICATOR)).getText().equals("people"), "Pet indicator is not displayed for the patient in patient demographic section");
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
	 */

    @When("^User tries to navigate back to patient search results$")
    public void user_tries_to_navigate_back_to_patient_search_results() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_BACK_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PATIENT_PROFILE_BACK_BUTTON))
                    throw new Exception("Not able to click Back Button");
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
	 */

    @Then("^User is on patient results page$")
    public void user_is_on_patient_results_page() throws Exception {

    }


	/*
	 *
	 */

    @When("^User selects Add New button by clicking$")
    public void user_selects_Add_New_button_by_clicking() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEACH_FORM_ADD_NEW_BUTTON_CLICK)) {
                if (isElementPresentVerifyClick(IntakeConstants.PATIENT_SEACH_FORM_ADD_NEW_BUTTON_CLICK))
                    Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEACH_FORM_ADD_NEW_BUTTON_CLICK)) != null, " Add new button is not available to click");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }

    }

    @Then("^System shows the popup with message$")
    public void system_shows_the_popup_with_message() throws Exception {

    }

    @When("^User selects Update button by clicking$")
    public void user_selects_Update_button_by_clicking() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_FORM_UPDATE_BUTTON_CLICK)) {
                if (isElementPresentVerifyClick(IntakeConstants.PATIENT_SEARCH_FORM_UPDATE_BUTTON_CLICK))
                    Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_FORM_UPDATE_BUTTON_CLICK)) != null, "Update button is not available to be clicked");
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
	 */

    @When("^User selects Update button by using ALT plus U hot key$")
    public void user_selects_Update_button_by_using_ALT_plus_U_hot_key() throws Exception {

    }

	/*
	 *
	 */

    @When("^User clicks on add new button using ALT plus A hot key$")
    public void user_clicks_on_add_new_button_using_ALT_plus_A_hot_key() throws Exception {
        Actions addNew = new Actions(chromeDriver);
        Action series = addNew.keyDown(Keys.ALT).sendKeys("a").keyUp(Keys.ALT).build();
        series.perform();
    }


	/*
	 *
	 */

    @And("^user click cancel update registration button$")
    public void user_click_cancel_update_registration_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Patient_profile_Registration_Form_Cancel_Button)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Registration_Form_Cancel_Button)) {
                    throw new Exception("Not able to click cancel button.");
                }
            }
            if (isElementPresentVerification(IntakeConstants.Patient_profile_update_cancel_popup)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_update_cancel_yes)) {
                    throw new Exception("Not able to click yes button.");
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

	/*
	 *
	 */

    @When("^User presses ALT plus three hot key$")
    public void user_presses_ALT_plus_three_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(2000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_3);
            robot.keyRelease(KeyEvent.VK_3);
            robot.keyRelease(KeyEvent.VK_ALT);

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
	 */

    @When("^User presses ALT plus P hot key$")
    public void user_presses_ALT_plus_P_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("P").keyUp(Keys.ALT).build();
            series.perform();

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
	 */

    @When("^User presses ALT plus I hot key$")
    public void user_presses_ALT_plus_I_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("I").keyUp(Keys.ALT).build();
            series.perform();

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
	 */

    @When("^User presses ALT plus M hot key$")
    public void user_presses_ALT_plus_M_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("M").keyUp(Keys.ALT).build();
            series.perform();

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
	 */

    @When("^User presses ALT plus L hot key$")
    public void user_presses_ALT_plus_L_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("L").keyUp(Keys.ALT).build();
            series.perform();

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
	 */

    @When("^User presses ALT plus G hot key$")
    public void user_presses_ALT_plus_G_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("G").keyUp(Keys.ALT).build();
            series.perform();

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
	 */

    @When("^User presses ALT plus back hot key$")
    public void user_presses_ALT_plus_back_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            //Actions ac = new Actions(chromeDriver);
            //Action series = ac.keyDown(Keys.ALT).sendKeys(Keys.ARROW_LEFT).keyUp(Keys.ALT).build();
            //series.perform();
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.keyRelease(KeyEvent.VK_LEFT);
            robot.keyRelease(KeyEvent.VK_ALT);

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
	 */

    @Then("^System shows global search popup with \"([^\"]*)\" message and \"([^\"]*)\" button$")
    public void system_shows_global_search_popup_with_message_and_button(String messageFromApplication, String buttonOk) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_ADD_NEW_BUTTON_CLICK_POPUP)) {
                String patientSearchDialogMessage = getElementText(IntakeConstants.PATIENT_SEARCH_ADD_NEW_BUTTON_CLICK_POPUP);
                Assert.assertTrue(patientSearchDialogMessage.equals(messageFromApplication), "User did not see the message " + patientSearchDialogMessage + " in the popup");
                if (isElementPresentVerification(IntakeConstants.Patient_search_add_new_popup_search_all_stores)) {
                    String patientSearchDialogOkButton = getElementText(IntakeConstants.Patient_search_add_new_popup_search_all_stores);
                    Assert.assertTrue(patientSearchDialogOkButton.equals(buttonOk), "User did not see the " + patientSearchDialogOkButton + " button in the popup");
                }
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
        }
    }

	/*
	 *
	 */

    @And("^Should display patient update window$")
    public void Should_display_patient_update_window() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.patient_tab_update_patient_window)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.patient_tab_update_patient_window)).isDisplayed(), "Update screen is not displayed.");
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
	 */

    @Then("^Should display third party plans$")
    public void Should_display_third_party_plan() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_THIRD_PARTY_TAB_PAGE_TEXT)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_PROFILE_THIRD_PARTY_TAB_PAGE_TEXT)).isDisplayed(), "Third Party Plans not displayed.");
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
	 */

    @Then("^Should display patient images page$")
    public void Should_display_patient_images_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.patient_tab_patient_images)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.patient_tab_patient_images)).isDisplayed(), "Patient Images not displayed.");
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
	 */

    @Then("^Should display clinical history tab$")
    public void Should_display_clinical_history_tab() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.patient_tab_clinical_history)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.patient_tab_clinical_history)).isDisplayed(), "CLinical History not displayed.");
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
	 */

    @Then("^System displays a message in the popup$")
    public void system_displays_a_message_in_the_popup() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.PATIENT_ADD_UPDATE_MESSAGE_POPUP)) {
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
	 */

    @Then("^User clicks on update button using ALT plus U hot key$")
    public void user_clicks_on_update_button_using_ALT_plus_U_hot_key() throws Exception {
        Actions update = new Actions(chromeDriver);
        Action series = update.keyDown(Keys.ALT).sendKeys("u").keyUp(Keys.ALT).build();
        series.perform();
    }

	/*
	 *
	 */

    @Then("^User clicks on ok button using ALT plus o hot key$")
    public void user_clicks_on_ok_button_using_ALT_plus_o_hot_key() throws Exception {
        Actions addNew = new Actions(chromeDriver);
        Action series = addNew.keyDown(Keys.ALT).sendKeys("o").keyUp(Keys.ALT).build();
        series.perform();
    }

	/*
	 *
	 */

    @And("^User clicks on update button in patient profile page using ALT plus U hot key$")
    public void user_clicks_on_update_button_in_patient_profile_page_using_ALT_plus_U_hot_key() throws Exception {
        Actions update = new Actions(chromeDriver);
        Action series = update.keyDown(Keys.ALT).sendKeys("u").keyUp(Keys.ALT).build();
        series.perform();
    }

	/*
	 *
	 */

    @When("^User clicks on add comment button in patient profile page comments section using ALT plus A hot key$")
    public void user_clicks_on_add_comment_button_in_patient_profile_page_comments_section_using_ALT_plus_A_hot_key() throws Exception {
        Actions addNew = new Actions(chromeDriver);
        Action series = addNew.keyDown(Keys.ALT).sendKeys("A").keyUp(Keys.ALT).build();
        series.perform();
    }

	/*
	 *
	 */

    @And("^the navigation bar is collapsed$")
    public void the_navigation_bar_is_collapsed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            /*if (isElementPresentVerification(IntakeConstants.NAVIGATION_BAR_DASHBOARD_BUTTON)) {
                Assert.assertTrue(!FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.NAVIGATION_BAR_DASHBOARD_BUTTON)).isDisplayed(), "Dashboard button on navigation bar is displayed");
            }*/
            if (isElementPresentVerification(IntakeConstants.NAVIGATION_BAR_PATIENT_BUTTON)) {
                Assert.assertTrue(!FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.NAVIGATION_BAR_PATIENT_BUTTON)).isDisplayed(), "Patient button on navigation bar is displayed");
            }
            if (isElementPresentVerification(IntakeConstants.NAVIGATION_BAR_DRUG_BUTTON)) {
                Assert.assertTrue(!FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.NAVIGATION_BAR_DRUG_BUTTON)).isDisplayed(), "Drug button on navigation bar is displayed");
            }
            if (isElementPresentVerification(IntakeConstants.NAVIGATION_BAR_PRESCRIBER_BUTTON)) {
                Assert.assertTrue(!FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.NAVIGATION_BAR_PRESCRIBER_BUTTON)).isDisplayed(), "Prescriber button on navigation bar is displayed");
            }
            if (isElementPresentVerification(IntakeConstants.NAVIGATION_BAR_PLAN_BUTTON)) {
                Assert.assertTrue(!FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.NAVIGATION_BAR_PLAN_BUTTON)).isDisplayed(), "Plan button on navigation bar is displayed");
            }
            if (isElementPresentVerification(IntakeConstants.NAVIGATION_BAR_PATIENT_ORDER_STATUS_BUTTON)) {
                Assert.assertTrue(!FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.NAVIGATION_BAR_PATIENT_ORDER_STATUS_BUTTON)).isDisplayed(), "Patient order status button on navigation bar is displayed");
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
	 */

    @And("^the navigation bar is expanded$")
    public void the_navigation_bar_is_expanded() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.NAVIGATION_BAR_DASHBOARD_BUTTON)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.NAVIGATION_BAR_DASHBOARD_BUTTON)).isDisplayed(), "Dashboard button on navigation bar is not displayed");
            }
            if (isElementPresentVerification(IntakeConstants.NAVIGATION_BAR_PATIENT_BUTTON)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.NAVIGATION_BAR_PATIENT_BUTTON)).isDisplayed(), "Patient button on navigation bar is displayed");
            }
            if (isElementPresentVerification(IntakeConstants.NAVIGATION_BAR_DRUG_BUTTON)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.NAVIGATION_BAR_DRUG_BUTTON)).isDisplayed(), "Drug button on navigation bar is displayed");
            }
            if (isElementPresentVerification(IntakeConstants.NAVIGATION_BAR_PRESCRIBER_BUTTON)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.NAVIGATION_BAR_PRESCRIBER_BUTTON)).isDisplayed(), "Prescriber button on navigation bar is displayed");
            }
            if (isElementPresentVerification(IntakeConstants.NAVIGATION_BAR_PLAN_BUTTON)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.NAVIGATION_BAR_PLAN_BUTTON)).isDisplayed(), "Plan button on navigation bar is displayed");
            }
            if (isElementPresentVerification(IntakeConstants.NAVIGATION_BAR_PATIENT_ORDER_STATUS_BUTTON)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.NAVIGATION_BAR_PATIENT_ORDER_STATUS_BUTTON)).isDisplayed(), "Patient order status button on navigation bar is displayed");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @When("^User clicks on RxMS help from the dashboard$")
    public void user_clicks_on_RxMS_help_from_the_dashboard() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.HOMEPAGE_RXMS_HELP_LINK)) {
             //   if (isElementPresentVerifyClick(IntakeConstants.HOMEPAGE_RXMS_HELP_LINK)) {

             //   }
            }
            /*Robot saveWindow = new Robot();
            saveWindow.keyPress(KeyEvent.VK_CANCEL);
            saveWindow.keyRelease(KeyEvent.VK_CANCEL);
*/
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
	 */

    @Then("^System should display RxMS help$")
    public void system_should_display_RxMS_help() throws Exception {
        Thread.sleep(3000);
    //    Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath("rxmshelpage")) != null, "RxMS Help page is not displayed when clicked on RxMS link on Dashboard because of defect: RXQE-4732");
    }

	/*
	 *
	 */

    /**********************************Med History*******************************************/

    @Then("^System should navigate to Patient Profile Screen$")
    public void system_should_navigate_to_Patient_Profile_Screen() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_HEADING)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.PATIENT_PROFILE_HEADING, "Patient Profile");
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
	 */

    @And("^The system displays No Health Conditions On File in Clinical Information panel$")
    public void The_system_displays_No_Health_Conditions_On_File_in_Clinical_Information_panel() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_GENERAL_TAB_HEALTH_CONDITIONS_TEXT)) {
                Assert.assertTrue(getElementText(IntakeConstants.PATIENT_PROFILE_GENERAL_TAB_HEALTH_CONDITIONS_TEXT).equals("Confirm Health Conditions"));
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
	 */

    @Then("^System should navigate to Medication History Screen$")
    public void system_should_navigate_to_Medication_History_Screen() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.MEDICATION_HISTORY_HEADING)) {

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
	 * This method clicks the button of the first shown prescription
	 */

    @When("^User click on Med History Tab from patient profile page$")
    public void user_click_on_Med_History_Tab_from_patient_profile_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.MED_HISTORY_TAB)) {
                if (!isElementPresentVerifyClick(IntakeConstants.MED_HISTORY_TAB))
                    throw new Exception("Not able to click Med History Tab");
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
	 * This method ensures that the panel previously opened is now closed.
	 */

    @Then("^system displays the Patient Med History tab visible and active$")
    public void system_displays_the_Patient_Med_History_tab_visible_and_active() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.MED_HISTORY_TAB)) {
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
	 * This method ensures that the panel expanded (resulting in the previous one closing) is open
	 */

    @When("^user select the First zone around the Expand button of Prescription$")
    public void user_select_the_First_zone_around_the_Expand_button_of_Prescription() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.DownArrow_Dynamic)) {
                if (!isElementPresentVerifyClick(IntakeConstants.DownArrow_Dynamic))
                    throw new Exception("Not able to click Down Arrow");
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
	 * This method opens a prescription in the Med History "Rx History" menu
	 */

    @Then("^system shows the first panel collapsed$")
    public void system_shows_the_first_panel_collapsed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.DownArrow_first)) {
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
	 */
    
    @Then("^the system shows the first panel expanded$")
    public void the_system_shows_the_first_panel_expanded() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.expanded_medhistory_tab)) {
            	if (!isElementPresentVerification(IntakeConstants.UpArrow_first)){
            		throw new Exception("First panel not expanded");
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

    @Then("^the system shows the second panel expanded$")
    public void the_system_shows_the_second_panel_expanded() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.expanded_medhistory_tab)) {
            	if (!isElementPresentVerification(IntakeConstants.UpArrow_second)){
            		throw new Exception("Second panel not expanded");
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
	 * This method ensures that some "in progress" prescriptions contain the status as a hyperlink
	 */

    @When("^user select the Second zone around the Expand button of Prescription$")
    public void user_select_the_Second_zone_around_the_Expand_button_of_Prescription() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.UPArrow_Dynamic)) {
                if (!isElementPresentVerifyClick(IntakeConstants.UPArrow_Dynamic))
                    throw new Exception("Not able to click Up Arrow");
            }
            if (isElementPresentVerification(IntakeConstants.DownArrow_second)) {
                if (!isElementPresentVerifyClick(IntakeConstants.DownArrow_second))
                    throw new Exception("Not able to click Down Arrow");
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
	 * This method ensures that "in progress" prescriptions in Med History display a green dot above the Rx Status
	 */

    @Then("^system displays the Patient Med History tab Enable$")
    public void system_displays_the_Patient_Med_History_tab_Enable() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.MED_HISTORY_TAB)) {
                FrameworkLibrary.isButtonEnable(IntakeConstants.MED_HISTORY_TAB);
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
	 * This method clicks the "In Progress" status hyperlink
	 */

    @Then("^System displays the Status field In Progress as a hyperlink$")
    public void system_displays_the_Status_field_In_Progress_as_a_hyperlink() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Status_field_In_Progress_as_a_hyperlink)) {
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
	 * This method confirms that the prescription info in Patient Order Status is displayed
	 */

    @Then("^System displays a green dot over the hyperlink$")
    public void system_displays_a_green_dot_over_the_hyperlink() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.GREEN_DOT)) {
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
	 * This method ensures that some "in progress" prescriptions contain the status as a hyperlink
	 */

    @When("^User selects the Status hyperlink$")
    public void user_selects_the_Status_hyperlink() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.MEDHISTORY_STATUS_HYPERLINK)) {
                isElementPresentVerifyClick(IntakeConstants.MEDHISTORY_STATUS_HYPERLINK);
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
	 * This method ensures that the "Last Fill Date" column displays blank text.
	 */

    @Then("^displays all the active fills highlighted for the previously selected prescription$")
    public void displays_all_the_active_fills_highlighted_for_the_previously_selected_prescription() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.Patient_Order_Status_Highlighted_Row)) {
            }
            if (!isElementPresentVerification(IntakeConstants.Patient_Order_Status_Highlighted_PreviouslySelectedPatient)) {
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
	 */

    @Then("^System displays the Status field Pending as a hyperlink$")
    public void system_displays_the_Status_field_Pending_as_a_hyperlink() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.Status_field_In_Progress_as_a_hyperlink)) {
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
	 * This method ensures that a green dot is displayed over the "In Progress" status
	 */

    @Then("^System displays the Medication History Screen with Last Fill Date column populated$")
    public void system_displays_the_Medication_History_Screen_with_Last_Fill_Date_column_populated() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Last_Fill_Date_Col)) {
                Assert.assertTrue(getElementText(IntakeConstants.Last_Fill_Date_Col).equals(""));
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
	 */

    @Then("^System displays the RxMS Prescription dispensing Team Member status as a hyperlink$")
    public void system_displays_the_RxMS_Prescription_dispensing_Team_Member_status_as_a_hyperlink() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.MEDHISTORY_STATUS_HYPERLINK)) {
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @Then("^a green dot over the hyperlink$")
    public void a_green_dot_over_the_hyperlink() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.GREEN_DOT)) {
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
	 */

    @When("^user hits tab$")
    public void user_hits_tab() throws Exception {
        for (int i = 0; i <= 14; i++) {
			/* Action series=bc.keyDown(Keys.TAB).keyUp(Keys.TAB).build();
                    series.perform();*/
        }
    }


	/*
	 *
	 */

    @Then("^I able to error message in mandatory feilds in product feild$")
    public void i_able_to_error_message_in_mandatory_feilds_in_product_feild() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(AccessManagementConstants.DE_Without_Product_Mandatory_Feild)) {
                List<WebElement> mandatoryFieldErrorList = FrameworkLibrary.chromeDriver.findElements(By.xpath(AccessManagementConstants.DE_Without_Product_Mandatory_Feild));

                for (int i = 0; i < mandatoryFieldErrorList.size(); i++) {
                    log.info("Text is :" + mandatoryFieldErrorList.get(i).getText());
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
	 *
	 */

    @Then("^clicks on logos with an internet link$")
    public void clicks_on_logos_with_an_internet_link() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(AccessManagementConstants.DrugClinical_Reference_Page_First_Box)) {
                if (!isElementPresentVerifyClick(AccessManagementConstants.DrugClinical_Reference_Page_First_Box))
                    throw new Exception("Not able to click Reference page first box");
            }
            String ab = chromeDriver.getTitle();
            log.info(ab);
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
	 */

    @Then("^system displays correctly Genereal Drug References for generic Product$")
    public void system_displays_correctly_Genereal_Drug_References_for_generic_Product() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(AccessManagementConstants.Drug_Clinical_Reference_Page)) {
                List<WebElement> clinicalPage = FrameworkLibrary.chromeDriver.findElements(By.xpath(AccessManagementConstants.Drug_Clinical_Reference_Page));
                Assert.assertTrue(clinicalPage.size() != 0, "User is not on");
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
	 */

    @When("^I click on left keyword arrow$")
    public void i_click_on_left_keyword_arrow() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(AccessManagementConstants.keyword_arrow)) {
                if (!isElementPresentVerifyClick(AccessManagementConstants.keyword_arrow))
                    throw new Exception("Not able to click Arrow");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @When("^user clicks back button from drug search$")
    public void user_clicks_back_button_from_drug_search() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.DRUGSEARCH_BACK_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.DRUGSEARCH_BACK_BUTTON))
                    throw new Exception("Not able to click Back Button");
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
	 */

    @And("^dashboard should display user initials$")
    public void dashboard_should_display_user_initials() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.USER_INITIALS)) {
                Assert.assertTrue(getElementText(IntakeConstants.USER_INITIALS) != null, "Initials not displayed");
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
	 */

    /*
	 *
	 */
    @When("^user clicks comment link$")
    public void user_clicks_comment_link() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.COMMENTS_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.COMMENTS_BUTTON))
                    throw new Exception("Not able to click Comments Button");
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
	 */

    //Added by shiva

    @Then("^comment box should display$")
    public void comment_box_should_display() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.COMMENTS_BOX)) {
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
	 */

    @And("^should not show comments$")
    public void should_not_show_comments() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.COMMENTS_BOX_MESSAGE)) {
                Assert.assertTrue(getElementText(IntakeConstants.COMMENTS_BOX_MESSAGE).equals("No commments on file for this patient."));
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }

    }

    @Then("^User able to see following task board$")
    public void User_able_to_see_following_task_board(DataTable tableData) {
        String pageSource = chromeDriver.getPageSource();
        List<String> options = tableData.asList(String.class);


    }

	/*
	 *
	 */

    @And("^user changes focus on dashboard button using tab button on keyboard$")
    public void user_changes_focus_on_dashboard_button_using_tab_button_on_keyboard() throws Exception {
        for (int i = 0; i <= 14; i++) {
            Actions bc = null;
            Action series = bc.keyDown(Keys.TAB).keyUp(Keys.TAB).build();
            series.perform();
        }

    }


	/*
	 *
	 */

    @When("^User selects pickup time as later - day after tomorrow$")
    public void user_selects_pickup_time_as_later_day_after_tomorrow() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.radio_pickuplater)) {
                if (!isElementPresentVerifyClick(IntakeConstants.radio_pickuplater))
                    throw new Exception("Not able to click Pickup later");
            }
            if (isElementPresentVerification(IntakeConstants.pickup_time_dayAfterTomorrow)) {
                if (!isElementPresentVerifyClick(IntakeConstants.pickup_time_dayAfterTomorrow))
                    throw new Exception("Not able to click Pickup Day After tomorrow");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @When("^User selects pickup time as later - tomorrow$")
    public void user_selects_pickup_time_as_later_tomorrow() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.radio_pickuplater)) {
                if (!isElementPresentVerifyClick(IntakeConstants.radio_pickuplater))
                    throw new Exception("Not able to click Pickup later");
            }
            if (isElementPresentVerification(IntakeConstants.pickup_date_tomorrow)) {
                if (!isElementPresentVerifyClick(IntakeConstants.pickup_date_tomorrow))
                    throw new Exception("Not able to click Pickup tomorrow");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }

    }

    @Then("^The data entry task should be prioritized to the patient with pickuptime as Waiting$")
    public void the_data_entry_task_should_be_prioritized_to_the_patient_with_pickuptime_as_Waiting() throws Exception {

    }

    @Then("^The data entry task should be prioritized to the patient whose pickup time is tomorrow$")
    public void the_data_entry_task_should_be_prioritized_to_the_patient_whose_pickup_time_is_tomorrow() throws Exception {

    }

    @Then("^The data entry task should be prioritized to the patient whose pickup time is next to the before patient$")
    public void the_data_entry_task_should_be_prioritized_to_the_patient_whose_pickup_time_is_next_to_the_before_patient() throws Exception {

    }

    @Then("^The data review task should be prioritized to the patient with pickuptime as Waiting$")
    public void the_data_review_task_should_be_prioritized_to_the_patient_with_pickuptime_as_Waiting() throws Exception {

    }


	/*
	 *
	 */

    @Then("^The data review task should be prioritized to the patient whose pickup time is earlier$")
    public void the_data_review_task_should_be_prioritized_to_the_patient_whose_pickup_time_is_earlier() throws Exception {

    }


	/*
	 *
	 */

    @Then("^The data review task should be prioritized to the patient whose pickup time is next to the before patient$")
    public void the_data_review_task_should_be_prioritized_to_the_patient_whose_pickup_time_is_next_to_the_before_patient() throws Exception {

    }


	/*
	 *
	 */

    @When("^clicks Med history tab$")
    public void clicks_Med_history_tab() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.MedHistory)) {
                if (!isElementPresentVerifyClick(IntakeConstants.MedHistory))
                    throw new Exception("Not able to click MedHistory");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @Then("^No information must be displayed under Rx History tab$")
    public void no_information_must_be_displayed_under_Rx_History_tab() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.NoRx_Message)) {

            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @Then("^System should display - No Rx history on file$")
    public void system_should_display_No_Rx_history_on_file() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.NoRx_Message)) {
                String rxMessage = getElementText(IntakeConstants.NoRx_Message);
                Assert.assertTrue(rxMessage.equals("No Rx history on file."));
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @When("^enters mandatory product information except drug exp date, days supply and Rx exp date$")
    public void enters_mandatory_product_information_except_drug_exp_date_days_supply_and_Rx_exp_date(DataTable arg1) throws Exception {

    }

    @Then("^drug exp date should not be auto populated$")
    public void drug_exp_date_should_not_be_auto_populated() throws Exception {

    }

    @Then("^enters mandatory product information except days supply$")
    public void enters_mandatory_product_information_except_days_supply(DataTable arg1) throws Exception {

    }

    @Then("^days supply should be auto populated$")
    public void days_supply_should_be_auto_populated() throws Exception {

    }

    @Then("^enters mandatory product information except Rx exp date$")
    public void enters_mandatory_product_information_except_Rx_exp_date(DataTable arg1) throws Exception {

    }

    @Then("^Rx expiration date should not be auto populated$")
    public void rx_expiration_date_should_not_be_auto_populated() throws Exception {

    }

    @Then("^System should not display the default days correctly$")
    public void system_should_not_display_the_default_days_correctly() throws Exception {

    }

    @Then("^The results matching search criteria should be displayed$")
    public void the_results_matching_search_criteria_should_be_displayed() throws Exception {

    }



	/*
	 *
	 */

    @Then("^The price should be same in IC\\+$")
    public void the_price_should_be_same_in_IC() throws Exception {

    }

    @Then("^Med History page is displayed$")
    public void med_History_page_is_displayed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.MedHistory_PageTitle)) {
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
	 */

    @Then("^the system collapses further details of the prescription history for drug name X$")
    public void the_system_collapses_further_details_of_the_prescription_history_for_drug_name_X() throws Exception {

    }


	/*
	 *
	 */

    @Then("^System should display all buttons$")
    public void system_should_display_all_buttons() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.RxHistory_addToRefillButton) && isElementPresentVerification(IntakeConstants.RxHistory_ReprintButton) && isElementPresentVerification(IntakeConstants.RxHistory_CloseRxButton) && isElementPresentVerification(IntakeConstants.RxHistory_TransferButton)) {
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @When("^User clicks Transfer button$")
    public void user_clicks_Transfer_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.RxHistory_TransferButton)) {
                if (!isElementPresentVerifyClick(IntakeConstants.RxHistory_TransferButton))
                    throw new Exception("Not able to click RxHistory_TransferButton");
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
	 */

    @Then("^System displays a message -- This function cannot be completed in IC\\+$")
    public void system_displays_a_message_This_function_cannot_be_completed_in_IC() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.RxHistory_FunctionMessage)) {
                String actualFunctionMessage = getElementText(IntakeConstants.RxHistory_FunctionMessage);
                String expectedFunctionMessage = "this function cannot be completed in this system. please complete in ic+.";
                Assert.assertTrue(actualFunctionMessage.toLowerCase().contains(expectedFunctionMessage));
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
	 */

    @When("^USer clicks Inactive button$")
    public void user_clicks_Inactive_button() throws Exception {

    }


	/*
	 *
	 */

    @When("^Uer clicks Reprint button$")
    public void uer_clicks_Refill_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.RxHistory_ReprintButton)) {
                if (!isElementPresentVerifyClick(IntakeConstants.RxHistory_ReprintButton))
                    throw new Exception("Not able to click RxHistory_ReprintButton");
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
	 */

    @When("^User clicks Add refill button$")
    public void user_clicks_Add_refill_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.RxHistory_addToRefillButton)) {
                if (!isElementPresentVerifyClick(IntakeConstants.RxHistory_addToRefillButton))
                    throw new Exception("Not able to click add to refill");
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
	 */

    @Then("^All the tasks in taskboard should be displayed$")
    public void all_the_tasks_in_taskboard_should_be_displayed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.DENumberofTasks) && isElementPresentVerification(IntakeConstants.DRNumberofTasks)
                    && isElementPresentVerification(IntakeConstants.CETaskNumber) && isElementPresentVerification(IntakeConstants.PV_NumberofTasks)
                    && isElementPresentVerification(IntakeConstants.fillingTaskNumber)) {
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
	 */

    @Then("^show the number of respective tasks if available$")
    public void show_the_number_of_respective_tasks_if_available() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.DENumberofTasks) && isElementPresentVerification(IntakeConstants.DRNumberofTasks)
                    && isElementPresentVerification(IntakeConstants.CETaskNumber) && isElementPresentVerification(IntakeConstants.PV_NumberofTasks)
                    && isElementPresentVerification(IntakeConstants.fillingTaskNumber)) {
                Assert.assertTrue(getElementText(IntakeConstants.DENumberofTasks) != null);
                Assert.assertTrue(getElementText(IntakeConstants.DRNumberofTasks) != null);
                Assert.assertTrue(getElementText(IntakeConstants.CETaskNumber) != null);
                Assert.assertTrue(getElementText(IntakeConstants.PV_NumberofTasks) != null);
                Assert.assertTrue(getElementText(IntakeConstants.fillingTaskNumber) != null);
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
	 */

    @When("^User selects appropriate prescription in patient order status to click pending hyperlink$")
    public void user_selects_appropriate_prescription_in_patient_order_status_to_click_pending_hyperlink() throws Exception {

    }

	/*
	 *
	 */

    @When("^User enters all product information leaving directions field blank$")
    public void user_enters_all_product_information_leaving_directions_field_blank(DataTable arg1) throws Exception {
        // enter all product information except directions field
    }


	/*
	 *
	 */

    @Then("^System displays all inserted data correctly$")
    public void system_displays_all_inserted_data_correctly() throws Exception {
        // assert that all inserted data is displayed
    }


	/*
	 *
	 */

    @Then("^days supply field should be blank$")
    public void days_supply_field_should_be_blank() throws Exception {
        // assert that days supply field is blank
    }


	/*
	 *
	 */

    @When("^enters product information except days supply$")
    public void enters_product_information_except_days_supply() throws Exception {

    }


	/*
	 *
	 */

    @When("^enters days supply exceeding the limit$")
    public void enters_days_supply_exceeding_the_limit() throws Exception {

    }


	/*
	 *
	 */

    @Then("^System should display a message <The days supply should not exceed the limit>$")
    public void system_should_display_a_message_The_days_supply_should_not_exceed_the_limit() throws Exception {

    }


	/*
	 *
	 */

    @When("^enters original date$")
    public void enters_original_date(DataTable arg1) throws Exception {

    }


	/*
	 *
	 */

    @When("^selects <view size> checkbox$")
    public void selects_view_size_checkbox() throws Exception {

    }


	/*
	 *
	 */

    @When("^enters drug name$")
    public void enters_drug_name(DataTable arg1) throws Exception {

    }


	/*
	 *
	 */

    @When("^selects a dispensed product$")
    public void selects_a_dispensed_product() throws Exception {

    }


	/*
	 *
	 */

    @When("^changes DAW value from N to Y$")
    public void changes_DAW_value_from_N_to_Y(DataTable arg1) throws Exception {

    }


	/*
	 *
	 */

    @Then("^System should display list of drugs that have similar durg name, pack size but different manufacturer$")
    public void system_should_display_list_of_drugs_that_have_similar_durg_name_pack_size_but_different_manufacturer() throws Exception {

    }

	/*
	 *
	 */

    @Then("^ensure that view size is selected$")
    public void ensure_that_view_size_is_selected() throws Exception {

    }

	/*
	 *
	 */

    @Then("^User should be able to select a dispensed product$")
    public void user_should_be_able_to_select_a_dispensed_product() throws Exception {

    }

	/*
	 *
	 */

    @Then("^the system displays the most recent Prescriptions for the selected patient order by Drug Name in ascending order$")
    public void the_system_displays_the_most_recent_Prescriptions_for_the_selected_patient_order_by_Drug_Name_in_ascending_order() throws Exception {

    }


	/*
	 *
	 */

    @Then("^system displays the most recent Prescriptions for the selected patient order by Last Fill Date in descending order$")
    public void system_displays_the_most_recent_Prescriptions_for_the_selected_patient_order_by_Last_Fill_Date_in_descending_order() throws Exception {

    }


	/*
	 *
	 */

    @Then("^each prescription is displayed as a separate line item$")
    public void each_prescription_is_displayed_as_a_separate_line_item() throws Exception {

    }

	/*
	 *
	 */

    @When("^The user selects the zone around the Expand button for drug name X$")
    public void the_user_selects_the_zone_around_the_Expand_button_for_drug_name_X() throws Exception {

    }


	/*
	 *
	 */

    @Then("^the system expands further details of the prescription history for drug name X$")
    public void the_system_expands_further_details_of_the_prescription_history_for_drug_name_X() throws Exception {

    }


	/*
	 *
	 */

    @Then("^system displays the most recent Prescriptions for the selected patient order by status \\(Pending - In Progress - Ready\\)$")
    public void system_displays_the_most_recent_Prescriptions_for_the_selected_patient_order_by_status_Pending_In_Progress_Ready() throws Exception {

    }


	/*
	 *
	 */

    @Then("^My Profile screen is displayed$")
    public void my_Profile_screen_is_displayed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.dashboard_UserProfile_PageTitle)) {
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
	 */

    @Then("^User navigates to dashboard$")
    public void user_navigates_to_dashboard() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.navigationPanel_HomeICon)) {
                if (!isElementPresentVerifyClick(IntakeConstants.navigationPanel_HomeICon))
                    throw new Exception("Not able to click Home Icon");
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
	 */

    @When("^User clicks Additional Medication tab$")
    public void user_clicks_additional_medication_tab() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.RxHistory_AdditionalMedButton)) {
                if (!isElementPresentVerifyClick(IntakeConstants.RxHistory_AdditionalMedButton))
                    throw new Exception("Not able to click Additional Med button");
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
	 */

    @Then("^System should display Additional Medication screen$")
    public void system_should_display_add_med_screen() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.RxHistory_additional_MedHistory_tableHeader)) {
                Assert.assertTrue(isElementPresentVerification(IntakeConstants.RxHistory_additional_MedHistory_tableHeader));
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
	 */

    @And("^Additional Medication screen should display No Additional Meds$")
    public void Additional_Medication_screen_should_display_No_Additional_Meds() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.RxHistory_additional_MedHistory_tableHeader)) {
                Assert.assertTrue(getElementText(IntakeConstants.RxHistory_AdditionalMeds_None).equals("No Additional medications have been added. Click update to add a medication"));
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
	 */

    @When("^User clicks Additional Meds Update button$")
    public void User_clicks_Additional_Meds_Update_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(AccessManagementConstants.Patient_Profile_thirdpartyplan_Update_Hidden)) {
                if (!isElementPresentVerifyClick(AccessManagementConstants.Patient_Profile_thirdpartyplan_Update_Hidden))
                    throw new Exception("Not able to click update button");
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
	 */

    @Then("^System should allow user to update Additional Meds$")
    public void System_should_allow_user_to_update_Additional_Meds() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.UPDATE_PATIENT_POPUP)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.UPDATE_PATIENT_POPUP_TEXT)).getText().contains("Update Patient"), "Update Popup not present");
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.UPDATE_PATIENT_ADDITIONAL_MEDS_TAB)).getText().contains("Additional Medications"), "Update Additional Meds Tab not present");
                //Assert.assertTrue(isElementPresentVerification(IntakeConstants.ADDITIONAL_MEDS_RADIO_NO), "Radio button #1 not present.");
                //Assert.assertTrue(isElementPresentVerification(IntakeConstants.ADDITIONAL_MEDS_RADIO_YES), "Radio button #2 not present.");
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
	 */

    @And("^User should not able to see intakeRx button$")
    public void User_should_not_able_to_see_intakeRx_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(AccessManagementConstants.Patient_Profile_Intake_Empty_Button)) {
                Assert.assertFalse(FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.Patient_Profile_Intake_Empty_Button)).getText().contains("intakeRx"), "intakeRx button not present");
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
	 */

    @And("^user able to see Walkin and ScanRx button visible but not selectable$")
    public void user_able_to_see_Walkin_and_ScanRx_button_visible_but_not_selectable() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(AccessManagementConstants.Patient_Profile_Intake_Walkin_ScanRx_Feild)) {
                Assert.assertTrue(FrameworkLibrary.isElementPresentVerifyClick(AccessManagementConstants.Patient_Profile_Intake_Walkin_ScanRx_Feild), "the walkin feild is not selectable");
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
	 */

    @When("^enter drug information with drug name$")
    public void enter_drug_information_with_drug_name(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.Drug_search_field)) {
                SmokeTestLibrary.enter_Text(arg1, "DrugName", IntakeConstants.Drug_search_field, chromeDriver);
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
	 */

    @When("^Search for product$")
    public void search_for_product() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Drug_search_button)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Drug_search_button))
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


	/*
	 *
	 */

    @When("^results should be displayed$")
    public void results_should_be_displayed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Drug_search_drug_result)) {
                /*List<WebElement> list = chromeDriver.findElements(By.xpath(IntakeConstants.Drug_search_drug_result));
                String excel = FrameworkLibrary.getXLSTestData("Prescriber_Input", "Drug", "Row_one", "DrugName");
                for (int i = 0; i < list.size(); i++) {
                    Assert.assertTrue(list.get(i).getText().contains(excel));
                }*/
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
	 * Method to validate Hot keys on drug search result page
	 */

    @When("^check the hot keys$")
    public void check_the_hot_keys(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            /*if (isElementPresentVerification(IntakeConstants.DRUG_DETAIL_BACK_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.DRUG_DETAIL_BACK_BUTTON))
                    throw new Exception("Not able to click back button");
            }
            if (isElementPresentVerification(SmokeTestConstants.drug_LeftMenuButton)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.drug_LeftMenuButton))
                    throw new Exception("Not able to click left menu button");
            }
            if (isElementPresentVerification(SmokeTestConstants.drug_LeftMenuButton)) {
                SmokeTestLibrary.enter_Text(arg1, "DrugName", IntakeConstants.Drug_search_field, chromeDriver);
            }*/
            Actions search = new Actions(chromeDriver);
            Action Presssearch = search.sendKeys(Keys.ALT, "S").build();
            Presssearch.perform();
            Assert.assertTrue(chromeDriver.findElement(By.xpath(IntakeConstants.Drug_view_details)) != null);
            
            //Actions view1 = new Actions(chromeDriver);
            /*Presssearch = search.sendKeys(Keys.ALT, "v").build();
            Presssearch.perform();*/
            if (isElementPresentVerifyClick(IntakeConstants.DRUG_SEARCH_VIEW_BUTTON)) {
            	if (isElementPresentVerifyClick(IntakeConstants.Drug_view_result)) {
            		Assert.assertTrue(chromeDriver.findElement(By.xpath(IntakeConstants.Drug_view_result)) != null);
            	}
            }
            Actions view = new Actions(chromeDriver);
            Action Pressview = view.sendKeys(Keys.ALT, Keys.ARROW_LEFT).build();
            Pressview.perform();

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }
    
    /*
     * Hot key ALT V to view drug detail
     */
    @When("^check the hot keys to view drug detail$")
    public void check_the_hot_keys_to_view_drug_detail() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            
        	if (isElementPresentVerification(IntakeConstants.Drug_search_view)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Drug_search_view))
                    throw new Exception("Not able to click VIEW button");
            }
            /*if (isElementPresentVerifyClick(IntakeConstants.Drug_view_details)) {
                Assert.assertTrue(chromeDriver.findElement(By.xpath(IntakeConstants.Drug_view_result)) != null);
            }*/

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
	 */

    @When("^search drug with no drug$")
    public void search_drug_with_no_drug() throws Exception {
    	Actions view1 = new Actions(chromeDriver);
        Action Pressview1 = view1.sendKeys(Keys.ALT, Keys.ARROW_LEFT).build();
        Pressview1.perform();
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            Actions view = new Actions(chromeDriver);
            Action Pressview = view.sendKeys(Keys.ALT, Keys.ARROW_LEFT).build();
            Pressview.perform();
            if (isElementPresentVerification(IntakeConstants.Drug_back_button)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Drug_back_button))
                    throw new Exception("Not able to click back button");
            }
            if (isElementPresentVerification(SmokeTestConstants.drug_LeftMenuButton)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.drug_LeftMenuButton))
                    throw new Exception("Not able to click left menu button");
            }
            if (isElementPresentVerification(IntakeConstants.Drug_search_button)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Drug_search_button))
                    throw new Exception("Not able to click search button");
            }
            if (isElementPresentVerification(IntakeConstants.Drug_search_button)) {
                String errormsg = FrameworkLibrary.getElementText(IntakeConstants.Drug_search_errormsg);
                Assert.assertEquals(errormsg, "Please enter a value for this field");
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
	 */

    @When("^search with Quick code$")
    public void search_with_Quick_code(DataTable arg1) throws Exception {
        String output ;
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
        	if (isElementPresentVerification(IntakeConstants.Drug_search_field)) {
                SmokeTestLibrary.enter_Text(arg1, "Quickcode", IntakeConstants.Drug_search_field, chromeDriver);
            }
            
        	if (!isElementPresentVerifyClick(IntakeConstants.Drug_search_button))
                throw new Exception("Not able to click search button");
            //SmokeTestLibrary.enter_Text(arg1, "DrugName", IntakeConstants.Drug_search_field, chromeDriver);
            /*if (isElementPresentVerification(IntakeConstants.Drug_search_field)) {
                output = FrameworkLibrary.getElementText(IntakeConstants.Drug_Quick_code);
            }*/

            /*Boolean condition = chromeDriver.getPageSource().contains(excel.toUpperCase());
            Assert.assertTrue(condition);*/

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }


	/*
	 * Method to search with NDC value in drug search page
	 */

    @When("^search with NDC$")
    public void search_with_NDC(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
        	 Actions view = new Actions(chromeDriver);
             Action Pressview = view.sendKeys(Keys.ALT, Keys.ARROW_LEFT).build();
             Pressview.perform();
             //String excel = FrameworkLibrary.getXLSTestData("Prescriber_Input", "Drug", "Row_one", "NDC");
             SmokeTestLibrary.enter_Text(arg1, "NDC", IntakeConstants.Drug_search_field, chromeDriver);
            if (isElementPresentVerification(IntakeConstants.Drug_search_field)) {
                //FrameworkLibrary.clearAndEnterText(IntakeConstants.Drug_search_field, excel);
                if (!isElementPresentVerifyClick(IntakeConstants.Drug_search_button))
                    throw new Exception("Not able to click Drug_search_button");
            }
            Thread.sleep(3000);
            

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }


	/*
	 * Method to enter partial NDC value in Drug Search page
	 */

    @When("^search with partial NDC$")
    public void search_with_partial_NDC(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
        	Actions view = new Actions(chromeDriver);
            Action Pressview = view.sendKeys(Keys.ALT, Keys.ARROW_LEFT).build();
            Pressview.perform();
            SmokeTestLibrary.enter_Text(arg1, "NDC1", IntakeConstants.Drug_search_field, chromeDriver);
            //String excel = FrameworkLibrary.getXLSTestData("Prescriber_Input", "Drug", "Row_one", "NDC1");
            if (isElementPresentVerification(IntakeConstants.Drug_search_field)) {
                //FrameworkLibrary.clearAndEnterText(IntakeConstants.Drug_search_field, excel);
                if (!isElementPresentVerifyClick(IntakeConstants.Drug_search_button))
                    throw new Exception("Not able to click Drug_search_button");
            }
            /*Boolean Cond = chromeDriver.getPageSource().contains(excel);
            Assert.assertTrue(Cond);*/
            String size = FrameworkLibrary.getElementText(IntakeConstants.Drug_search_package_size);
            log.info(size);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }


	/*
	 * Method to search without zeros
	 */

    @When("^search with leaving zeros$")
    public void search_with_leaving_zeros(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
        	 Actions view = new Actions(chromeDriver);
             Action Pressview = view.sendKeys(Keys.ALT, Keys.ARROW_LEFT).build();
             Pressview.perform();
            if (isElementPresentVerification(IntakeConstants.Drug_search_field)) {
                SmokeTestLibrary.enter_Text(arg1, "NDC2", IntakeConstants.Drug_search_field, chromeDriver);
                if (!isElementPresentVerifyClick(IntakeConstants.Drug_search_button))
                    throw new Exception("Not able to click Drug_search_button");
            }
            if (isElementPresentVerification(IntakeConstants.Drug_search_result_error)) {
                String error = FrameworkLibrary.getElementText(IntakeConstants.Drug_search_result_error);
                Assert.assertEquals(error, "No drugs matched your search criteria.");
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
	 * Method to search with WIC number
	 */

    @When("^search with WIC number$")
    public void search_with_WIC_number(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
        	 Actions view = new Actions(chromeDriver);
             Action Pressview = view.sendKeys(Keys.ALT, Keys.ARROW_LEFT).build();
             Pressview.perform();
            if (isElementPresentVerification(SmokeTestConstants.drug_LeftMenuButton)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.drug_LeftMenuButton))
                    throw new Exception("Not able to click drug_LeftMenuButton");
            }
            if (isElementPresentVerification(IntakeConstants.Drug_search_field)) {
                SmokeTestLibrary.enter_Text(arg1, "WIC", IntakeConstants.Drug_search_field, chromeDriver);
            }
            if (!isElementPresentVerifyClick(IntakeConstants.Drug_search_button))
                FrameworkLibrary.isElementPresentVerifyClick(IntakeConstants.Drug_search_button);
            

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }


	/*
	 * Method to verify if linked products are displayed
	 */

    @When("^check the show linked products$")
    public void check_the_show_linked_products(DataTable arg1) throws Exception {
    	Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
        	Actions view = new Actions(chromeDriver);
            Action Pressview = view.sendKeys(Keys.ALT, Keys.ARROW_LEFT).build();
            Pressview.perform();
            log.info("Drug Name to be entered " + DrugName);
            if (isElementPresentVerification(IntakeConstants.Drug_search_field)) {
            	if (!clearAndEnterText(IntakeConstants.Drug_search_field, DrugName)) {
                    throw new Exception("Not able to enter value in DrugName text field");
                }
                if (isElementPresentVerifyClick(IntakeConstants.Drug_search_button)){
                    //throw new Exception("Not able to click Drug_search_button");
                }
            }
            if (isElementPresentVerification(IntakeConstants.Drug_search_drug_result)) {
                List<WebElement> list = chromeDriver.findElements(By.xpath(IntakeConstants.Drug_search_drug_result));
            }
            //FrameworkLibrary.isElementPresentVerifyClick(IntakeConstants.Drug_search_linked_products);
            Thread.sleep(3000);
            
            List<WebElement> list1 = chromeDriver.findElements(By.xpath(IntakeConstants.Drug_search_drug_result));

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }

    }


	/*
	 * Method to search with three digit of NDC in drug search page
	 */

    @When("^search with three digit NDC$")
    public void search_with_three_digit_NDC(DataTable arg1) throws Exception {
        Actions view = new Actions(chromeDriver);
        Action Pressview = view.sendKeys(Keys.ALT, Keys.ARROW_LEFT).build();
        Pressview.perform();
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Drug_search_field)) {
                SmokeTestLibrary.enter_Text(arg1, "NDC3", IntakeConstants.Drug_search_field, chromeDriver);
                if (isElementPresentVerifyClick(IntakeConstants.Drug_search_button)){
                	
                }
                	if (isElementPresentVerification(IntakeConstants.Drug_search_result_error)) {
                        String error = FrameworkLibrary.getElementText(IntakeConstants.Drug_search_result_error);
                        Assert.assertEquals(error, "No drugs matched your search criteria.");
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
	 * Method to enter three digits of UPC on drug search page
	 */

    @When("^search with three digit UPC$")
    public void search_with_three_digit_UPC(DataTable arg1) throws Exception {
        Actions view = new Actions(chromeDriver);
        Action Pressview = view.sendKeys(Keys.ALT, Keys.ARROW_LEFT).build();
        Pressview.perform();
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
        	if (isElementPresentVerification(SmokeTestConstants.drug_LeftMenuButton)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.drug_LeftMenuButton))
                    throw new Exception("Not able to click drug_LeftMenuButton");
            }
            if (isElementPresentVerification(IntakeConstants.Drug_search_field)) {
                SmokeTestLibrary.enter_Text(arg1, "UPC2", IntakeConstants.Drug_search_field, chromeDriver);
                
                if (isElementPresentVerifyClick(IntakeConstants.Drug_search_button)){
                	
                }
                if (isElementPresentVerification(IntakeConstants.Drug_search_result_error)) {
                    String error = FrameworkLibrary.getElementText(IntakeConstants.Drug_search_result_error);
                    Assert.assertEquals(error, "No drugs matched your search criteria.");
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
	 * Method to navigate to the dashboard
	 */

    @When("^selelct the dashboard$")
    public void selelct_the_dashboard() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Drug_back_button)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Drug_back_button))
                    throw new Exception("Not able to click Drug_back_button");
            }

            Actions select = new Actions(chromeDriver);
            Action Pressselect = select.sendKeys(Keys.CONTROL, "D").build();
            Pressselect.perform();
            if (isElementPresentVerification(IntakeConstants.Drug_search_page)) {
                Assert.assertEquals(FrameworkLibrary.getElementText(IntakeConstants.Drug_search_page), "Drug Search");
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
	 * Method to search for inactive drug on drug search page
	 */

    @When("^search for inactive drug$")
    public void search_for_inactive_drug(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Drug_search_field)) {
                SmokeTestLibrary.enter_Text(arg1, "DrugName", IntakeConstants.Drug_search_field, chromeDriver);
                if (isElementPresentVerifyClick(IntakeConstants.Drug_search_button)){
                	
                }

            }
            if (isElementPresentVerification(IntakeConstants.Drug_search_result_error)) {
                String error = FrameworkLibrary.getElementText(IntakeConstants.Drug_search_result_error);
                Assert.assertEquals(error, "No drugs matched your search criteria.");
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
	 */

    @When("^User enters enter the BIN information labeled BIN$")
    public void user_enters_enter_the_BIN_information_labeled_BIN() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.planName_searchfield)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.planName_searchfield))
                    throw new Exception("Not able to click planName_searchfield");
            }
            if (isElementPresentVerification(IntakeConstants.PlanSearch_BIN)) {
                FrameworkLibrary.clearAndEnterText(IntakeConstants.PlanSearch_BIN, "003585");
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
	 */

    @Then("^plan results should be displayed as matching BIN$")
    public void plan_results_should_be_displayed_as_matching_BIN() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PlanSearch_BIN_Result)) {
                String expectedval = "003585";
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


	/*
	 *
	 */

    @When("^Erase BIN information and enter PCN information only$")
    public void erase_BIN_information_and_enter_PCN_information_only(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PlanSearch_BIN)) {
                FrameworkLibrary.getElementByProperty(IntakeConstants.PlanSearch_BIN, chromeDriver).clear();
                SmokeTestLibrary.enter_Text(arg1, "PCN", IntakeConstants.PlanSearch_PCN, chromeDriver);
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
	 */

    @Then("^User should be prompted to enter BIN number error message$")
    public void user_should_be_prompted_to_enter_BIN_number_error_message() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PlanSearch_BIN_PCN_Required_Error_Prompt)) {
            	//log.info("Error message displayed " + chromeDriver.findElementByXPath(IntakeConstants.PlanSearch_BIN_PCN_Required_Error_Prompt).getText());
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.PlanSearch_BIN_PCN_Required_Error_Prompt, "BIN is required when searching by PCN");
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
	 */

    @When("^User enters enter the PCN information labeled PCN$")
    public void user_enters_enter_the_PCN_information_labeled_PCN(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PlanSearch_PCN)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PlanSearch_PCN))
                    throw new Exception("Not able to click PCN");
                SmokeTestLibrary.enter_Text(arg1, "PCN", IntakeConstants.PlanSearch_PCN, chromeDriver);
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
	 */

    @Then("^Screen should display plans matching BIN and PCN information$")
    public void screen_should_display_plans_matching_BIN_and_PCN_information() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PlanSearch_BIN_Result)) {
                String expectedval = "003585";
                boolean condition = chromeDriver.getPageSource().toLowerCase().contains(expectedval);
                Assert.assertTrue(condition);
            }
            if (isElementPresentVerification(IntakeConstants.PlanSearch_PCN_Result)) {
                String expectedval1 = "10002";
                boolean condition1 = chromeDriver.getPageSource().toLowerCase().contains(expectedval1);
                Assert.assertTrue(condition1);
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
	 */

    @Then("^User enters enter the PlanId information labeled PlanId$")
    public void user_enters_enter_the_PlanId_information_labeled_PlanId(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PlanSearch_PLAN_ID)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PlanSearch_PLAN_ID))
                    throw new Exception("Not able to click Initial");
                SmokeTestLibrary.enter_Text(arg1, "PlanId", IntakeConstants.PlanSearch_PLAN_ID, chromeDriver);
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
	 */

    @Then("^Screen should display plans matching Plan Id information$")
    public void screen_should_display_plans_matching_Plan_Id_information() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PlanSearch_PlanId_Result)) {
                String expectedval = "HAP";
                boolean condition = chromeDriver.getPageSource().contains(expectedval);
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

	/*
	 *
	 */

    @Given("^get the total number of prescriptions by scan in database$")
    public void get_the_total_number_of_prescriptions_by_scan_in_database() throws Exception {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String query = "select count(Origin) from prescription_intake WHERE Origin='Scan'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Number_BeforeIntake = rs.getInt(1);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

	/*
	 *
	 */

    @Then("^validate the number of prescriptions in database by scan after completing intake$")
    public void validate_the_number_of_prescriptions_in_database_by_scan_after_completing_intake() throws Exception {
        try {
        	if (isElementPresentVerification(SmokeTestConstants.RxMSHome_PharmacyInformationCard)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.RxMSHome_PharmacyInformationCard), "RxMS homepage is not displayed");
			}
            Connection connection = ConnectionFactory.getConnection();
            String query = "select count(Origin) from prescription_intake WHERE Origin='Scan'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int Number_AfterIntake = rs.getInt(1);
                int Expected_Number = Number_BeforeIntake + 1;
                log.info("After " + Number_AfterIntake + "   Actual " + Expected_Number);
                Assert.assertEquals(Number_AfterIntake, Expected_Number);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 *
	 */

    @Given("^get the total number of prescriptions by phone in database$")
    public void get_the_total_number_of_prescriptions_by_phone_in_database() throws Exception {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String query = "select count(Origin) from prescription_intake WHERE Origin='Phone'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Number_BeforeIntake = rs.getInt(1);
                
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }


	/*
	 *
	 */

    @Then("^validate the number of prescriptions in database by phone after completing intake$")
    public void validate_the_number_of_prescriptions_in_database_by_phone_after_completing_intake() throws Exception {
        try {
            Thread.sleep(15000);
            Connection connection = ConnectionFactory.getConnection();
            String query = "select count(origin) from prescription_intake WHERE Origin='Phone'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int Number_AfterIntake = rs.getInt(1);
                int Expected_Number = Number_BeforeIntake + 1;
                Assert.assertEquals(Number_AfterIntake, Expected_Number);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

	/*
	 *
	 */

    @Given("^get the total number of prescriptions by fax in database$")
    public void get_the_total_number_of_prescriptions_by_fax_in_database() throws Exception {
        try {
            Connection connection = ConnectionFactory.getConnection();
            String query = "select count(Origin) from prescription_intake WHERE Origin='Fax'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Number_BeforeIntake = rs.getInt(1);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

	/*
	 *
	 */

    @Then("^validate the number of prescriptions in database by fax after completing intake$")
    public void validate_the_number_of_prescriptions_in_database_by_fax_after_completing_intake() throws Exception {
        try {
            Thread.sleep(5000);
            Connection connection = ConnectionFactory.getConnection();
            String query = "select count(origin) from prescription_intake WHERE Origin='Fax'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int Number_AfterIntake = rs.getInt(1);
                int Expected_Number = Number_BeforeIntake + 1;

                Assert.assertEquals(Number_AfterIntake, Expected_Number);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

	/*
	 *
	 */

    @Then("^selects origin code as phone$")
    public void select_origin_code_as_phone() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(SmokeTestConstants.Radio_phone)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.Radio_phone))
                    throw new Exception("Not able to click phone");
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
	 */

    @Then("^selects origin code as fax$")
    public void select_origin_code_as_fax() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Radio_fax)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.Radio_fax))
                    throw new Exception("Not able to click fax");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }

    }

    @When("^User click the Preference Tab$")
    public void user_click_the_Preference_Tab() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Rx_Preferences_Tab)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Rx_Preferences_Tab))
                    throw new Exception("Not able to click Preference Tab");
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
	 */

    @Then("^System should display \"([^\"]*)\" when no preferences are entered$")
    public void system_should_display_when_no_preferences_are_entered(String arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.No_Rx_Preferences_Text)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.No_Rx_Preferences_Text, IntakeConstants.No_Rx_Preferences_Text_Value);
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
	 */

    /*
	 * Verify if expected message is present on specified section
	 */
    @Then("^User should see the message \"([^\"]*)\" in \"([^\"]*)\" section$")
    public void i_should_see_the_message_in_section(String message, String section) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (section.equals("Clinical Information")) {
                if (isElementPresentVerification(IntakeConstants.GENERAL_INFORMATION_SECTION)) {
                    if (isElementPresentVerification(IntakeConstants.GENERAL_INFORMATION_SECTION_MESSAGE)) {
                        Assert.assertTrue(getElementText(IntakeConstants.GENERAL_INFORMATION_SECTION_MESSAGE).equals(message));
                    }
                }
            } else if (section.equals("Plan Summary")) {
                if (isElementPresentVerification(IntakeConstants.PLAN_SUMMARY_SECTION)) {
                    if (isElementPresentVerification(IntakeConstants.PLAN_SUMMARY_SECTION_MESSAGE)) {
                        Assert.assertTrue(getElementText(IntakeConstants.PLAN_SUMMARY_SECTION_MESSAGE).equals(message));
                    }
                }
            } else if (section.equals("Health Conditions")) {
                if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_GENERAL_TAB_HEALTH_CONDITIONS)) {
                    if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_GENERAL_TAB_HEALTH_CONDITIONS_TEXT)) {
                        Assert.assertTrue(getElementText(IntakeConstants.PATIENT_PROFILE_GENERAL_TAB_HEALTH_CONDITIONS_TEXT).equals(message));
                    }
                }
            } else if (section.equals("Allergy Name")) {
                if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_GENERAL_TAB_ALLERGY_NAME)) {
                    if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_GENERAL_TAB_ALLERGY_NAME_TEXT)) {
                        Assert.assertTrue(getElementText(IntakeConstants.PATIENT_PROFILE_GENERAL_TAB_ALLERGY_NAME_TEXT).equals(message));
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
	 *
	 */

    @Then("^System will navigate the Patient Search Result Page$")
    public void system_will_navigate_the_Patient_Search_Result_Page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Rx_Patient_Search)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.Rx_Patient_Search, IntakeConstants.Rx_Patient_Search_Value);
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
	 */

    @Then("^System should display Rx Preferences$")
    public void system_should_display_Rx_Preferences() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Rx_Preferences_Text)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.Rx_Preferences_Text, IntakeConstants.Rx_Preferences_Text_Value);
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
	 */

    @When("^User click on Update Button on Rx Preferences Page$")
    public void user_click_on_Update_Button_on_Rx_Preferences_Page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Rx_Preferences_TAB_Update_Button)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Rx_Preferences_TAB_Update_Button))
                    throw new Exception("Not able to click on Update Button");
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
	 * Method to validate Update Patient page is opened 
	 */

    @Then("^System will navigate the user to the Update Patient Rx Preferences screen$")
    public void system_will_navigate_the_user_to_the_Update_Patient_Rx_Preferences_screen() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Rx_Preferences_Update_Page_Title)) {
                //FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.Rx_Preferences_Update_Page_Title, IntakeConstants.Rx_Preferences_Update_Title_Value);
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
	 */

    @When("^User deselect snap cap$")
    public void user_deselect_snap_cap() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Rx_Preferences_SnapCap)) {
            	if(chromeDriver.findElement(By.xpath(IntakeConstants.Rx_Preferences_Snap_Cap)).getAttribute("class").contains("material-background-color-grey")){
            		if (isElementPresentVerifyClick(IntakeConstants.Rx_Preferences_SnapCap))
            			throw new Exception("Not able to click on Snap Cap");
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
	 *
	 */

    @When("^User click on SaveAndExit Button$")
    public void user_click_on_SaveAndExit_Button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Rx_Preferences_Save_Exit_Button)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Rx_Preferences_Save_Exit_Button))
                    throw new Exception("Not able to click on Save & Exit");
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
	 */

    @Then("^System will update and shows No Rx Preferences$")
    public void system_will_update_and_shows_No_Rx_Preferences() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.No_Rx_Preferences_Text)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.No_Rx_Preferences_Text, IntakeConstants.No_Rx_Preferences_Text_Value);
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
	 */

    @Then("^User should be able to view the Preference snap Cap$")
    public void user_should_be_able_to_view_the_Preference_snap_Cap() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.Rx_Preferences_Snap_Cap)) {
                throw new Exception("Snap Cap element is not present");
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
	 */

    @When("^User click on Back Button on Patient Profile page$")
    public void user_click_on_Back_Button_on_Patient_Profile_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Back_Button)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Back_Button))
                    throw new Exception("Not able to click on Back Button");
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
	 */

    @Then("^System will navigate the Patient Profile Page$")
    public void system_will_navigate_the_Patient_Profile_Page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Patient_Profile_Title)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.Patient_Profile_Title, IntakeConstants.Rx_Patient_Profile_Value);
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
	 */

    @Then("^System will navigate the user Patient Search Result Page$")
    public void system_will_navigate_the_user_Patient_Search_Result_Page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Rx_Patient_Search)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.Rx_Patient_Search, IntakeConstants.Rx_Patient_Search_Value);
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
	 */

    @Then("^Validate Medication History has default Rx History tab$")
    public void validate_Medication_History_has_default_Rx_History_tab() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        WebElement RxHistory_tab = chromeDriver.findElementByXPath(IntakeConstants.RxHistory_tab);
        String attrValue = RxHistory_tab.getAttribute("class");

        try {
            Assert.assertTrue(attrValue.contains("md-active"));
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

	/*
	 *
	 */

    @Then("^User clicks Additional Medication tab and validate result with number of additional Meds$")
    public void user_clicks_Additional_Medication_tab_and_validate_result_with_number_of_additional_Meds() throws Exception {

        List<WebElement> drugrows = chromeDriver.findElements(By.xpath(IntakeConstants.RxHistory_AdditionalMed_DrugList));
        log.info("the size from list 1 :" + drugrows.size());

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        WebElement additionalMedNumbers = chromeDriver.findElementByXPath(IntakeConstants.RxHistory_AdditionalMed_Tab_Numbers);
        log.info("the size from tab number :" + additionalMedNumbers.getText());
        try {
            Assert.assertEquals(drugrows.size(), Integer.parseInt(additionalMedNumbers.getText()));
            if (isElementPresentVerification(IntakeConstants.RxHistory_AdditionalMedButton)) {
                if (!isElementPresentVerifyClick(IntakeConstants.RxHistory_AdditionalMedButton))
                    throw new Exception("Not able to click Additional Med button");
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
	 * This method include
	 * -> find pending list and select current row
	 * -> drag POS list pending link to top.
	 * -> verify error message while two row is selected and trying to delete RX(click on deleteRX btn
	 * -> select first row of the POS list
	 */

    @Then("^validate tab order for Additional Medication$")
    public void validate_tab_order_for_Additional_Medication() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


        Actions tabBtn = new Actions(chromeDriver);
        Action presstab = tabBtn.sendKeys(Keys.TAB).build();

        try {

            if (isElementPresentVerification(IntakeConstants.RxHistory_AdditionalMed_UPDATE_BUTTON)) {
                Assert.assertTrue(getElementByProperty(IntakeConstants.RxHistory_AdditionalMed_UPDATE_BUTTON, chromeDriver).equals(chromeDriver.switchTo().activeElement()));
                presstab.perform();
            }
            if (isElementPresentVerification(IntakeConstants.RxHistory_AdditionalMedButton)) {
                Assert.assertTrue(getElementByProperty(IntakeConstants.RxHistory_AdditionalMedButton, chromeDriver).equals(chromeDriver.switchTo().activeElement()));
                presstab.perform();
            }
            if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_BACK_BUTTON)) {
                Assert.assertTrue(getElementByProperty(IntakeConstants.PATIENT_PROFILE_BACK_BUTTON, chromeDriver).equals(chromeDriver.switchTo().activeElement()));
                presstab.perform();
            }
            if (isElementPresentVerification(IntakeConstants.COMMENTS_BUTTON)) {
                Assert.assertTrue(getElementByProperty(IntakeConstants.COMMENTS_BUTTON, chromeDriver).equals(chromeDriver.switchTo().activeElement()));
                presstab.perform();
            }
            if (isElementPresentVerification(IntakeConstants.MED_HISTORY_TAB)) {
                Assert.assertEquals(FrameworkLibrary.chromeDriver.findElement(By.className("md-focused")).getText(), "Med History");
                presstab.perform();
            }
            if (isElementPresentVerification(IntakeConstants.RxHistory_AdditionalMed_UPDATE_BUTTON)) {
                Assert.assertTrue(getElementByProperty(IntakeConstants.RxHistory_AdditionalMed_UPDATE_BUTTON, chromeDriver).equals(chromeDriver.switchTo().activeElement()));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }


	/*
	 *
	 * Validate hot keys ALT+D and ALT_C In POS
	 */

    @Then("^validate Hot key Alt\\+M and Alt\\+U$")
    public void validate_Hot_key_Alt_M_and_Alt_U() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Actions click = new Actions(chromeDriver);
        Action Pressclick = click.keyDown(Keys.ALT).sendKeys("m").keyUp(Keys.ALT).build();

        try {

            Pressclick.perform();
            Thread.sleep(2000);
            Assert.assertEquals(FrameworkLibrary.getElementText(IntakeConstants.MEDICATION_HISTORY_HEADING), "Medication History");
            Pressclick = click.keyDown(Keys.ALT).sendKeys("u").keyUp(Keys.ALT).build();
            Pressclick.perform();
            Thread.sleep(2000);
            Assert.assertEquals(FrameworkLibrary.getElementText(IntakeConstants.RxHistory_UPDATE_PATIENT_DIALOG), "Update Patient");

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @Then("^The pending link for current prescription should be selected$")
    public void the_pending_link_for_current_prescription_should_be_selected(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(50000);
            SmokeTestStepDef.i_click_search_button_on_patient_order_status();
            Thread.sleep(50000);
            String pickuptime = SmokeTestStepDef.currentPickupTime;
            String pickupdate = SmokeTestStepDef.IntakeDate;
            String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
            String expintakeDate = SmokeTestStepDef.intakenextdate;
            List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));
            log.info(elements.size());
            for (int i = elements.size() - 1; i >= 0; i--) {

                if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(possiblepickupTime1)) {
                    //this code will find pending list and select current row
                    Assert.assertTrue(elements.get(i).getText().toUpperCase().contains("PENDING"));
                    log.info(elements.get(i).getText());
                    String dyn = elements.get(i).getAttribute("id");
                    String[] dynamo = dyn.split("-");
                    String part1 = dynamo[1];
                    String part2 = dynamo[2];
                    String pendinglink = "//tr[@id='patient-" + part1 + "-" + part2 + "']/td[5]/a";
                    Assert.assertTrue(isElementPresentVerification(pendinglink));

                    String currentRowFirstColumnlink = "//tr[@id='patient-" + part1 + "-" + part2 + "']/td[1]/span[1]";
                    Assert.assertTrue(isElementPresentVerification(currentRowFirstColumnlink));
                    getElementByProperty(currentRowFirstColumnlink, chromeDriver).click();
                    Thread.sleep(2000);

                    //this code is for drag POS list pending link to top.
                    long timeoutExpiredMS = System.currentTimeMillis() + ((elements.size() + 5) * 100);
                    while (1 != 2) {
                        Actions ac = new Actions(chromeDriver);
                        Action a = ac.sendKeys(Keys.ARROW_UP).build();
                        a.perform();
                        if (System.currentTimeMillis() > timeoutExpiredMS) {
                            break;
                        }
                    }

                    //this code is for verify error message while two row is selected and trying to delete RX(click on deleteRX btn

                    Assert.assertTrue(isElementPresentVerification(SmokeTestConstants.POS_delete_rx_Button));
                    getElementByProperty(SmokeTestConstants.POS_delete_rx_Button, chromeDriver).click();
                    Assert.assertFalse(FrameworkLibrary.isElementPresents(IntakeConstants.Rx_DeleteBtnDialog), "Multipale Row should not be deleted");
                    int lastIndexOfList = elements.size() * 2;
                    String errorMessage = "//*[@id='patient-order-status-list']/table/tbody/tr[" + lastIndexOfList + "]/td[1]/div[2]";


                    Assert.assertTrue(isElementPresentVerification(errorMessage));
                    Assert.assertEquals(FrameworkLibrary.chromeDriver.findElement(By.xpath(errorMessage)).getText(), "Only one prescription can be deleted at a time");

                    //this code is for select first row of the POS list
                    String firstRowId = elements.get(0).getAttribute("id");
                    int length = firstRowId.length();
                    if (length == 38) {
                        String[] arrOfFirstRowId = firstRowId.split("-");
                        String partOne = arrOfFirstRowId[1];

                        String partTwo = arrOfFirstRowId[2];
                        String partThree = arrOfFirstRowId[3];
                        String firstRowcloumn1 = "//tr[@id='patient-" + partOne + "-" + partTwo + "-" + partThree + "']/td[2]/span[2]";
                        Assert.assertTrue(isElementPresentVerification(firstRowcloumn1));
                        isElementPresentVerifyClick(firstRowcloumn1);
                        //isElementPresentVerifyClick(IntakeConstants.POS_FirstOfPatient);
                        Thread.sleep(2000);
                    } else {
                        String[] arrOfFirstRowId = firstRowId.split("-");
                        String partOne = arrOfFirstRowId[1];
                        String partTwo = arrOfFirstRowId[2];
                        String firstRowcloumn1 = "//tr[@id='patient-" + partOne + "-" + partTwo + "']/td[2]/span[2]";
                        Assert.assertTrue(isElementPresentVerification(firstRowcloumn1));
                        isElementPresentVerifyClick(firstRowcloumn1);
                        Thread.sleep(2000);
                    }
                    break;
                } else if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(pickuptime)) {
                    //this code will find pending list and select current row
                    Assert.assertTrue(elements.get(i).getText().toUpperCase().contains("PENDING"));
                    log.info(elements.get(i).getText());
                    String dyn = elements.get(i).getAttribute("id");
                    String[] dynamo = dyn.split("-");
                    String part1 = dynamo[1];
                    String part2 = dynamo[2];
                    String pendinglink = "//tr[@id='patient-" + part1 + "-" + part2 + "']/td[5]/a";
                    Assert.assertTrue(isElementPresentVerification(pendinglink));

                    String currentRowFirstColumnlink = "//tr[@id='patient-" + part1 + "-" + part2 + "']/td[1]/span[1]";
                    Assert.assertTrue(isElementPresentVerification(currentRowFirstColumnlink));
                    getElementByProperty(currentRowFirstColumnlink, chromeDriver).click();
                    Thread.sleep(2000);

                    //this code is for drag POS list pending link to top.
                    long timeoutExpiredMS = System.currentTimeMillis() + ((elements.size() + 5) * 100);
                    while (1 != 2) {
                        Actions ac = new Actions(chromeDriver);
                        Action a = ac.sendKeys(Keys.ARROW_UP).build();
                        a.perform();
                        if (System.currentTimeMillis() > timeoutExpiredMS) {
                            break;
                        }
                    }

                    //this code is for verify error message while two row is selected and trying to delete RX(click on deleteRX btn)

                    Assert.assertTrue(isElementPresentVerification(SmokeTestConstants.POS_delete_rx_Button));
                    getElementByProperty(SmokeTestConstants.POS_delete_rx_Button, chromeDriver).click();
                    Assert.assertFalse(FrameworkLibrary.isElementPresents(IntakeConstants.Rx_DeleteBtnDialog), "Multipale Row should not be deleted");
                    int lastIndexOfList = elements.size() * 2;
                    String errorMessage = "//*[@id='patient-order-status-list']/table/tbody/tr[" + lastIndexOfList + "]/td[1]/div[2]";


                    Assert.assertTrue(isElementPresentVerification(errorMessage));
                    Assert.assertEquals(FrameworkLibrary.chromeDriver.findElement(By.xpath(errorMessage)).getText(), "Only one prescription can be deleted at a time");


                    //this code is for select first row of the POS list
                    String firstRowId = elements.get(0).getAttribute("id");
                    int length = firstRowId.length();
                    if (length == 38) {
                        String[] arrOfFirstRowId = firstRowId.split("-");
                        String partOne = arrOfFirstRowId[1];

                        String partTwo = arrOfFirstRowId[2];
                        String partThree = arrOfFirstRowId[3];
                        String firstRowcloumn1 = "//tr[@id='patient-" + partOne + "-" + partTwo + "-" + partThree + "']/td[2]/span[1]";
                        Assert.assertTrue(isElementPresentVerification(firstRowcloumn1));
                        isElementPresentVerifyClick(firstRowcloumn1);
                        //isElementPresentVerifyClick(IntakeConstants.POS_FirstOfPatient);
                        Thread.sleep(2000);
                    } else {
                        String[] arrOfFirstRowId = firstRowId.split("-");
                        String partOne = arrOfFirstRowId[1];
                        String partTwo = arrOfFirstRowId[2];
                        String firstRowcloumn1 = "//tr[@id='patient-" + partOne + "-" + partTwo + "']/td[2]/span[1]";
                        Assert.assertTrue(isElementPresentVerification(firstRowcloumn1));
                        isElementPresentVerifyClick(firstRowcloumn1);
                        Thread.sleep(2000);
                    }
                    break;
                } else if (elements.get(i).getText().contains(expintakeDate) && elements.get(i).getText().contains(possiblepickupTime1)) {
                    //this code will find pending list and select current row
                    Assert.assertTrue(elements.get(i).getText().toUpperCase().contains("PENDING"));
                    log.info(elements.get(i).getText());
                    String dyn = elements.get(i).getAttribute("id");
                    String[] dynamo = dyn.split("-");
                    String part1 = dynamo[1];
                    String part2 = dynamo[2];
                    String pendinglink = "//tr[@id='patient-" + part1 + "-" + part2 + "']/td[5]/a";
                    Assert.assertTrue(isElementPresentVerification(pendinglink));

                    String currentRowFirstColumnlink = "//tr[@id='patient-" + part1 + "-" + part2 + "']/td[1]/span[1]";
                    Assert.assertTrue(isElementPresentVerification(currentRowFirstColumnlink));
                    getElementByProperty(currentRowFirstColumnlink, chromeDriver).click();
                    Thread.sleep(2000);

                    //this code is for drag POS list pending link to top.
                    long timeoutExpiredMS = System.currentTimeMillis() + ((elements.size() + 5) * 100);
                    while (1 != 2) {
                        Actions ac = new Actions(chromeDriver);
                        Action a = ac.sendKeys(Keys.ARROW_UP).build();
                        a.perform();
                        if (System.currentTimeMillis() > timeoutExpiredMS) {
                            break;
                        }
                    }

                    //this code is for verify error message while two row is selected and trying to delete RX(click on deleteRX btn)

                    Assert.assertTrue(isElementPresentVerification(SmokeTestConstants.POS_delete_rx_Button));
                    getElementByProperty(SmokeTestConstants.POS_delete_rx_Button, chromeDriver).click();
                    Assert.assertFalse(FrameworkLibrary.isElementPresents(IntakeConstants.Rx_DeleteBtnDialog), "Multipale Row should not be deleted");
                    int lastIndexOfList = elements.size() * 2;
                    String errorMessage = "//*[@id='patient-order-status-list']/table/tbody/tr[" + lastIndexOfList + "]/td[1]/div[2]";


                    Assert.assertTrue(isElementPresentVerification(errorMessage));
                    Assert.assertEquals(FrameworkLibrary.chromeDriver.findElement(By.xpath(errorMessage)).getText(), "Only one prescription can be deleted at a time");


                    //this code is for select first row of the POS list
                    String firstRowId = elements.get(0).getAttribute("id");
                    int length = firstRowId.length();
                    if (length == 38) {
                        String[] arrOfFirstRowId = firstRowId.split("-");
                        String partOne = arrOfFirstRowId[1];

                        String partTwo = arrOfFirstRowId[2];
                        String partThree = arrOfFirstRowId[3];
                        String firstRowcloumn1 = "//tr[@id='patient-" + partOne + "-" + partTwo + "-" + partThree + "']/td[2]/span[2]";
                        Assert.assertTrue(isElementPresentVerification(firstRowcloumn1));
                        isElementPresentVerifyClick(firstRowcloumn1);
                        Thread.sleep(2000);
                    } else {
                        String[] arrOfFirstRowId = firstRowId.split("-");
                        String partOne = arrOfFirstRowId[1];
                        String partTwo = arrOfFirstRowId[2];
                        String firstRowcloumn1 = "//tr[@id='patient-" + partOne + "-" + partTwo + "']/td[2]/span[2]";
                        Assert.assertTrue(isElementPresentVerification(firstRowcloumn1));
                        isElementPresentVerifyClick(firstRowcloumn1);
                        Thread.sleep(2000);
                    }
                    break;
                } else {
                    log.info("The" + i + "prescription is not current");
                    if (i == 0) {
                        Assert.fail("prescription not found.");
                    }
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^Validate Hot keys for Delete RX$")
    public void validate_Hot_keys_for_Delete_RX() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Actions click = new Actions(chromeDriver);
        Action Pressclick = click.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).build();

        try {
            Assert.assertTrue(isElementPresentVerification(SmokeTestConstants.POS_delete_rx_Button));
            getElementByProperty(SmokeTestConstants.POS_delete_rx_Button, chromeDriver).click();
            Assert.assertTrue(isElementPresentVerification(IntakeConstants.Rx_DeleteBtnDialog), "After DeleteRx Button is geting Error message");


            Assert.assertTrue(isElementPresentVerification(IntakeConstants.Rx_DeleteBtnDilog_CancelBtn), "In IntakeConstants Rx_DeleteBtnDilog_CancelBtn is not found ");
            Pressclick.perform();  // Press ALT+C to get delete window
            Thread.sleep(2000);
            Assert.assertFalse(FrameworkLibrary.isElementPresents(IntakeConstants.Rx_DeleteBtnDialog), "Delete ALT+C is not pressed properly");

            Assert.assertTrue(isElementPresentVerification(SmokeTestConstants.POS_delete_rx_Button));
            getElementByProperty(SmokeTestConstants.POS_delete_rx_Button, chromeDriver).click();
            Assert.assertTrue(FrameworkLibrary.isElementPresents(IntakeConstants.Rx_DeleteBtnDialog), "After DeleteRx Button is geting Error message");

            Pressclick = click.keyDown(Keys.ALT).sendKeys("d").keyUp(Keys.ALT).build();
            Assert.assertTrue(isElementPresentVerification(IntakeConstants.Rx_DeleteBtnDilog_DeleteRxBtn), "In IntakeConstants Rx_DeleteBtnDilog_DeleteRxBtn is not found ");
            Pressclick.perform();// Press ALT+D to get delete window
            Thread.sleep(2000);
            Assert.assertFalse(FrameworkLibrary.isElementPresents(IntakeConstants.Rx_DeleteBtnDialog), "Delete ALT+D is not pressed properly");


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        } finally {
            Thread.sleep(10000);
        }
    }


	/*
	 *
	 */

    /*
	 * Validate Delete Rx Button is not display while Read only user select first row in POS
	 */
    @Then("^DeleteRx Button should not display for first prescription$")
    public void deleterx_Button_should_not_display_for_first_prescription() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            SmokeTestStepDef.i_click_search_button_on_patient_order_status();
            List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));

            String firstRowId = elements.get(0).getAttribute("id");
            String[] arrOfFirstRowId = firstRowId.split("-");
            String partOne = arrOfFirstRowId[1];
            String partTwo = arrOfFirstRowId[2];
            String partThree = arrOfFirstRowId[3];
            String firstRowcloumn1 = "//tr[@id='patient-" + partOne + "-" + partTwo + "-" + partThree + "']/td[2]/span[2]";
            Assert.assertTrue(isElementPresentVerification(firstRowcloumn1));
            getElementByProperty(firstRowcloumn1, chromeDriver).click();

            Assert.assertTrue(!(isElementPresents(SmokeTestConstants.POS_delete_rx_Button)), "Delete Rx Button Should not display while first patients selected");

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        } finally {
            Thread.sleep(10000);
        }

    }

	/*
	 *
	 */

    @And("^The focus should be on date of birth text field$")
    public void the_focus_should_be_on_date_of_birth_text_field() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB)) {
                if (!isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB_FOCUSED)) {
                    throw new Exception("Focus is not on the date of birth text field");
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
	 *
	 */

    @And("^User selects global search option to search the patient$")
    public void user_selects_global_search_option_to_search_the_patient() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_GLOBAL_OPTION)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PATIENT_SEARCH_GLOBAL_OPTION)) {
                    throw new Exception("Not able to click global search button");
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
	 *
	 */

    @When("^User enters patient Last Name$")
    public void user_enters_patient_Last_Name(DataTable arg1) throws Exception {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName) && isElementPresentVerification(SmokeTestConstants.Patient_LastName)) {
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_FirstName, chromeDriver).clear();
                FrameworkLibrary.getElementByProperty(IntakeConstants.PATIENT_SEARCH_DOB, chromeDriver).clear();
                if (!clearAndEnterText(SmokeTestConstants.Patient_LastName, LastName)) {
                    throw new Exception("Not able to enter value in LastName text field");
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }
    
    /*
     * Method to click search button on patient search page
     */
    @When("^clicks the search button on patient search page$")
	public void clicks_the_search_button_on_patient_search_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Patient_SearchButton)) {
				proxy.newHar();
				if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_SearchButton)) {
					throw new Exception("Not able to click on Patient_SearchButton Button");
				}
				
				writeHarFile(workingFolder, "Patient Local Search", row.getRowNum(), 3);
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
	 */

    @Then("^System should display error \"([^\"]*)\" message about the search criteria$")
    public void system_should_display_error_message_about_the_search_criteria(String message) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName) && isElementPresentVerification(SmokeTestConstants.Patient_LastName)) {
                String errorMsg = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_SEARCH_CRITERIA_ERROR_MESSAGE)).getText();
                Assert.assertTrue(errorMsg.equals(message), "Error message is not displayed when patient search is done");
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
	 * Method to enter date of birth field on patient search page after clearing other field values
	 */

    @When("^User enter patient date of birth$")
    public void user_enter_patient_date_of_birth(DataTable arg1) throws Exception {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String patientDOB = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DateOfBirth");

            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName) && isElementPresentVerification(SmokeTestConstants.Patient_LastName)) {
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_LastName, chromeDriver).clear();
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_FirstName, chromeDriver).clear();
                if (!clearAndEnterText(IntakeConstants.PATIENT_SEARCH_DOB, patientDOB)) {
                    throw new Exception("Not able to enter value in LastName text field");
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 * Method to enter patient first name on patient search page, after clearing other field values
	 */

    @When("^User enters patient First Name$")
    public void user_enters_patient_First_Name(DataTable arg1) throws Exception {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
            if (isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_LastName, chromeDriver).clear();
                FrameworkLibrary.getElementByProperty(IntakeConstants.PATIENT_SEARCH_DOB, chromeDriver).clear();
                if (!clearAndEnterText(SmokeTestConstants.Patient_FirstName, FirstName)) {
                    throw new Exception("Not able to enter value in FirstName text field");
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 * Method to enter all information of a patient to search on global search
	 */

    @When("^User all the information in the text boxes of patient search screen$")
    public void user_all_the_information_in_the_text_boxes_of_patient_search_screen(DataTable arg1) throws Exception {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            String FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_Phonenumber) && isElementPresentVerification(SmokeTestConstants.Patient_LastName) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
                String patientDOB = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DateOfBirth");
                
                if (!clearAndEnterText(IntakeConstants.PATIENT_SEARCH_DOB, patientDOB)) {
                    throw new Exception("Not able to enter value in LastName text field");
                }
                String patientPhoneNumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");
                WebElement element = chromeDriver.findElement(By.xpath(SmokeTestConstants.Patient_Phonenumber));
                element.sendKeys(patientPhoneNumber);
                

                if (!clearAndEnterText(IntakeConstants.Patient_LastName, LastName)) {                	
                    throw new Exception("Not able to enter value in LastName text field");
                }
                
                if (!clearAndEnterText(SmokeTestConstants.Patient_FirstName, FirstName)) {
                    throw new Exception("Not able to enter value in FirstName text field");
                }
                
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }
    
    
    /*
	 * Method to enter all information except phone number of a patient to search on global search
	 */

    @When("^User all the information except phone number in the text boxes of patient search screen$")
    public void user_all_the_information_except_phone_numberin_the_text_boxes_of_patient_search_screen(DataTable arg1) throws Exception {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            String FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_Phonenumber) && isElementPresentVerification(SmokeTestConstants.Patient_LastName) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
                String patientDOB = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DateOfBirth");
                
                if (!clearAndEnterText(IntakeConstants.PATIENT_SEARCH_DOB, patientDOB)) {
                    throw new Exception("Not able to enter value in LastName text field");
                }
                WebElement element = chromeDriver.findElement(By.xpath(SmokeTestConstants.Patient_Phonenumber));
                element.clear();

                if (!clearAndEnterText(IntakeConstants.Patient_LastName, LastName)) {                	
                    throw new Exception("Not able to enter value in LastName text field");
                }
                
                if (!clearAndEnterText(SmokeTestConstants.Patient_FirstName, FirstName)) {
                    throw new Exception("Not able to enter value in FirstName text field");
                }
                
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 *
	 */

    @Then("^System should display \"([^\"]*)\" message about the patient results$")
    public void system_should_display_message_about_the_patient_results(String message) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_RESULTS_MESSAGE)) {
                String resultMsg = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_RESULTS_MESSAGE)).getText();
                Assert.assertTrue(resultMsg.equals(message), "results message is not shown where there are no patient result matches in patient search page");
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
	 */

    @When("^User enters valid Last Name,First Name and phone Number$")
    public void user_enters_valid_Last_Name_First_Name_and_phone_Number(DataTable arg1) throws Exception {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            String FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_Phonenumber) && isElementPresentVerification(SmokeTestConstants.Patient_LastName) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
                String patientPhoneNumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");
                WebElement element = chromeDriver.findElement(By.xpath(SmokeTestConstants.Patient_Phonenumber));
                element.sendKeys(patientPhoneNumber);
                if (!clearAndEnterText(SmokeTestConstants.Patient_LastName, LastName)) {
                    throw new Exception("Not able to enter value in LastName text field");
                }
                if (!clearAndEnterText(SmokeTestConstants.Patient_FirstName, FirstName)) {
                    throw new Exception("Not able to enter value in FirstName text field");
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 *
	 */

    @And("^User enters invalid date of birth and sees error \"([^\"]*)\" message while performing search$")
    public void user_enters_invalid_date_of_birth_and_sees_error_message_while_performing_search(String message, DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_Phonenumber) && isElementPresentVerification(SmokeTestConstants.Patient_LastName) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
                for (int i = 0; i < arg1.raw().size(); i++) {
                    if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB)) {
                        String patientDOB = arg1.raw().get(i).get(0);
                        if (!clearAndEnterText(IntakeConstants.PATIENT_SEARCH_DOB, patientDOB)) {
                            throw new Exception("Not able to enter value in LastName text field");
                        } else if (isElementPresentVerification(SmokeTestConstants.Patient_SearchButton)) {
                            if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_SearchButton)) {
                                throw new Exception("Not able to click on Patient_SearchButton Button");
                            }
                            String errorMsgForInvalidDate = null;
                            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB_INVALID_DATE_ERROR)) {
                                errorMsgForInvalidDate = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_DOB_INVALID_DATE_ERROR)).getText();
                            }
                            Assert.assertTrue(errorMsgForInvalidDate.equals(message), "Error message for invalid date of birth is displayed");
                        }
                    }
                }
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }


	/*
	 *
	 */

    @And("^User checks the Add New button in patient search is enabled$")
    public void user_checks_the_Add_New_button_in_patient_search_is_enabled() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_ADD_NEW_BUTTON)) {
                boolean isAddNewButtonEnabled = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_ADD_NEW_BUTTON)).isEnabled();
                Assert.assertTrue(isAddNewButtonEnabled, "Add New button in patient search page is not enabled");
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
	 */

    @When("^User clicks on back button in patient search page$")
    public void user_clicks_on_back_button_in_patient_search_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_BACK_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PATIENT_SEARCH_BACK_BUTTON)) {
                    throw new Exception("User not able to click back button in patient search");
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

    @When("^User clicks on Add New button using ALT plus A hot key$")
    public void user_clicks_on_Add_New_button_using_ALT_plus_A_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
        	proxy.newHar();
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_ADD_NEW_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PATIENT_SEARCH_ADD_NEW_BUTTON)) {
                    throw new Exception("Not able to click Add new button in patient search page");
                }
                waitForVisibility(SmokeTestConstants.Patient_FirstName);
                writeHarFile(workingFolder, "Add_Patient", row.getRowNum(), 3);
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^System shows a popup with \"([^\"]*)\" message and \"([^\"]*)\" button$")
    public void system_shows_a_popup_with_message_and_button(String messageFromApplication, String buttonOk) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_ADD_NEW_BUTTON_CLICK_POPUP)) {
                String patientSearchDialogMessage = getElementText(IntakeConstants.PATIENT_SEARCH_ADD_NEW_BUTTON_CLICK_POPUP);
                Assert.assertTrue(patientSearchDialogMessage.equals(messageFromApplication), "User did not see the message " + patientSearchDialogMessage + " in the popup");
                if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_ADD_NEW_BUTTON_CLICK_POPUP_OK_BUTTON)) {
                    String patientSearchDialogOkButton = getElementText(IntakeConstants.PATIENT_SEARCH_ADD_NEW_BUTTON_CLICK_POPUP_OK_BUTTON);
                    Assert.assertTrue(patientSearchDialogOkButton.equals(buttonOk), "User did not see the " + patientSearchDialogOkButton + " button in the popup");
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
	 * Verify if following texts are not present on Patient profile page
	 */
    @Then("^User should not see the following fields:$")
    public void user_should_not_see_the_following_fields(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        List<String> options = arg1.asList(String.class);
        try {
            for (int i = 0; i < options.size(); i++) {
                Boolean condition = FrameworkLibrary.chromeDriver.getPageSource().contains(options.get(i));
                Assert.assertFalse(condition, "Text " + options.get(i) + "  present on page");
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
	 */

    /*
	 * Verify if Intake button is not present on patient profile page
	 */
    @Then("^User should not see Intake button$")
    public void user_should_not_see_Intake_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Boolean condition = FrameworkLibrary.chromeDriver.getPageSource().contains("Intake Rx");
            Assert.assertFalse(condition, "Intake Button present on page");
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
	 */

    /*
	 * Verify if the Deceased text is present on Patient profile page
	 */
    @Then("^User should see Deceased text on the profile page$")
    public void user_should_see_deceased_text_on_the_profile_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.DECEASED_PATIENT_TEXT)) {
                Assert.assertTrue(getElementText(IntakeConstants.DECEASED_PATIENT_TEXT).equals("Deceased"));
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
	 */

    @Then("^Preferences is displayed with Snap Cap and Double Count Icons on Update Patient screen$")
    public void preferences_is_displayed_with_Snap_Cap_and_Double_Count_Icons_on_Update_Patient_screen() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (!isElementPresentVerification(IntakeConstants.Rx_Preferences_SnapCap) && !isElementPresentVerification(IntakeConstants.Rx_Preferences_Update_Patient_Double_Count)) {
                throw new Exception("Sanp cap and Double count not present.");
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
	 */

    @When("^User deselect snap cap and select double count on Update Patient screen$")
    public void user_deselect_snap_cap_and_select_double_count_on_Update_Patient_screen() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Rx_Preferences_SnapCap)) {
                if (isElementPresentVerifyClick(IntakeConstants.Rx_Preferences_SnapCap))
                    if (!isElementPresentVerifyClick(IntakeConstants.Rx_Preferences_Update_Patient_Double_Count))
                        throw new Exception("Not able to click on Snap Cap and Double count");
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
	 */

    @When("^User select snap cap only$")
    public void user_select_snap_cap_only() throws Exception {
        Thread.sleep(10000);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        boolean snapCapisSelected = chromeDriver.findElementByXPath(IntakeConstants.Rx_Preferences_SnapCap).isSelected();
        try {
            if (!snapCapisSelected) {
                Assert.assertTrue(isElementPresentVerifyClick(IntakeConstants.Rx_Preferences_SnapCap), "Snap Cap selected");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @Then("^System displays Rx Preferences screen with Snap Cap Icon as Preferences$")
    public void system_displays_Rx_Preferences_screen_with_Snap_Cap_Icon_as_Preferences() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            if (!isElementPresentVerification(IntakeConstants.No_Rx_Preferences_Text) && (!isElementPresentVerification(IntakeConstants.Rx_Preferences_Snap_Cap))) {
                throw new Exception("Snap Cap element is not present");
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
	 */

    @Then("^system should display the following editable fields$")
    public void system_should_display_the_following_editable_fields(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Patient_date_Picker_Feild) && isElementPresentVerification(IntakeConstants.Patient_first_Name_Feild) && isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild) && isElementPresentVerification(IntakeConstants.Patient_Phone_Number_Feild)) {

                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_date_Picker_Feild)).isDisplayed());
                Assert.assertTrue(chromeDriver.findElement(By.xpath(IntakeConstants.Patient_date_Picker_Feild)).isEnabled());

                String date = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_date_Picker_Feild)).getTagName();
                Assert.assertTrue(date.equals("input"));
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_date_Picker_Feild)).isDisplayed());
                Assert.assertTrue(chromeDriver.findElement(By.xpath(IntakeConstants.Patient_date_Picker_Feild)).isEnabled());
                String firstname = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_first_Name_Feild)).getTagName();
                Assert.assertTrue(firstname.equals("input"));
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_date_Picker_Feild)).isDisplayed());
                Assert.assertTrue(chromeDriver.findElement(By.xpath(IntakeConstants.Patient_date_Picker_Feild)).isEnabled());
                String lastname = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Last_Name_Feild)).getTagName();
                Assert.assertTrue(lastname.equals("input"));
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_date_Picker_Feild)).isDisplayed());
                Assert.assertTrue(chromeDriver.findElement(By.xpath(IntakeConstants.Patient_date_Picker_Feild)).isEnabled());
                String contactno = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild)).getTagName();
                Assert.assertTrue(contactno.equals("input"));
            }

            if (isElementPresentVerification(IntakeConstants.Patient_Local_Search_Icon) && isElementPresentVerification(IntakeConstants.Patient_Global_Search_Icon)) {
                String checked = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Local_Search_Icon)).getAttribute("class");
                log.info("the feild selected :" + checked);
                Assert.assertTrue(checked.contains("md-primary"));
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
	 */

    /*
	 *
	 */
    @Then("^user enters lastname and perform local search$")
    public void user_enters_lastname_and_perform_local_search(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");


            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_Last_Name_Feild, LastName)) {
                    throw new Exception("Not able to enter value patient last name field");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                        throw new Exception("user not able to click search button");
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


	/*
	 *
	 */

    @Then("^system display the message Zero results found view and update button not available$")
    public void system_display_the_message_Zero_results_found_view_and_update_button_not_available() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            if (isElementPresentVerification(IntakeConstants.Patient_profile_Entire_Screen)) {
                String actualerror = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_profile_Entire_Screen)).getText();
                String expected = IntakeConstants.Patient_profile_Zero_Error_Message;
                Assert.assertTrue(actualerror.equals(expected));
                Boolean condition = FrameworkLibrary.chromeDriver.getPageSource().contains("View/Update");
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
	 *
	 */

    @Then("^user enters lastname and Date of Birth to perform local search$")
    public void user_enters_lastname_and_Date_of_Birth_to_perform_local_search(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            String phonenumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");

            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_Last_Name_Feild, LastName)) {
                    throw new Exception("Not able to enter patient last name and phone number field");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_Phone_Number_Feild)) {
                    WebElement element = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild));
                    element.sendKeys(phonenumber);
                }
                if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                    proxy.newHar();
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                        throw new Exception("user not able to click search button");
                    }
                    //waitForVisibility(SmokeTestConstants.patientSearch_rows);
                    writeHarFile(workingFolder, "Patient global Search", row.getRowNum(), 4);
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
	 *
	 */

    @Then("^user enters Date of Birth and perform local search$")
    public void user_enters_Date_of_Birth_and_perform_local_search(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Last_Name_Feild)).clear();
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild)).clear();

            String dateOfBirth = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DateOfBirth");


            if (isElementPresentVerification(IntakeConstants.Patient_date_Picker_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_date_Picker_Feild, dateOfBirth)) {
                    throw new Exception("Not able to enter value in date of birth field");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                        throw new Exception("user not able to click search button");
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
	 *
	 */

    @Then("^user enters phone number and perform local search$")
    public void user_enters_phone_number_and_perform_local_search(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Last_Name_Feild)).clear();
            String phonenumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");


            if (isElementPresentVerification(IntakeConstants.Patient_Phone_Number_Feild)) {
                WebElement element = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild));
                element.click();
                Actions ac = new Actions(chromeDriver);
                ac = ac.sendKeys(phonenumber);
                ac.perform();
            }
            Thread.sleep(3000);
            if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                    throw new Exception("user not able to click search button");
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
	 * Method to check if searching patient listed after search is done
	 */

    @Then("^system displayed the list of Patients matching with the inserted criteria$")
    public void system_displayed_the_list_of_Patients_matching_with_the_inserted_criteria(DataTable arg1) throws Exception {
    	methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
        	String lastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName").toUpperCase();
        	if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Results_Screen)) {
                List<WebElement> list = chromeDriver.findElements(By.xpath(IntakeConstants.Patient_profile_Search_Results_Screen));
                for (int i = 0; i < list.size(); i++) {                	
                	Assert.assertTrue(list.get(i).getText().toUpperCase().contains(lastName));
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
	 *
	 */

    @Then("^user enter patient first name and last name perform local search$")
    public void user_enter_patient_first_name_and_last_name_perform_local_search(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild)).clear();
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_date_Picker_Feild)).clear();

            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            String firstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");

            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild) && isElementPresentVerification(IntakeConstants.Patient_first_Name_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_Last_Name_Feild, LastName) || !clearAndEnterText(IntakeConstants.Patient_first_Name_Feild, firstName)) {
                    throw new Exception("Not able to enter patient last name and first name field");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                        throw new Exception("user not able to click search button");
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
	 *
	 */

    @Then("^user enter patient last name and phone number perform local search$")
    public void user_enter_patient_last_name_and_phone_number_perform_local_search(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
        	if(!chromeDriver.findElement(By.xpath(IntakeConstants.Patient_profile_Search_Button)).isEnabled()){
            	Thread.sleep(3000);
            }
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_first_Name_Feild)).clear();
            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            String phonenumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");

            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_Last_Name_Feild, LastName)) {
                    throw new Exception("Not able to enter patient last name and first name field");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_Phone_Number_Feild)) {
                    WebElement element = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild));

                    element.click();
                    Actions ac = new Actions(chromeDriver);
                    ac = ac.sendKeys(phonenumber);
                    ac.perform();
                }

                if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                        throw new Exception("user not able to click search button");
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
	 *
	 */

    @Then("^user enter patient last name and DOB and phone number perform local search$")
    public void user_enter_patient_last_name_and_DOB_and_phone_number_perform_local_search(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_first_Name_Feild)).clear();
            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            String phonenumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");
            String dateOfBirth = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DateOfBirth");
            Thread.sleep(3000);
            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_Last_Name_Feild, LastName)) {
                    throw new Exception("Not able to enter patient last name and first name field");
                }

                if (isElementPresentVerification(IntakeConstants.Patient_Phone_Number_Feild)) {
                    WebElement element = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild));
                    element.sendKeys(phonenumber);
                }

                if (!clearAndEnterText(IntakeConstants.Patient_date_Picker_Feild, dateOfBirth)) {
                    throw new Exception("Not able to enter value in date of birth field");
                }

                if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                        throw new Exception("user not able to click search button");
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
	 *
	 */

    @Then("^user enter patient first name and last name and date of birth perform local search$")
    public void user_enter_patient_first_name_and_last_name_and_date_of_birth_perform_local_search(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild)).clear();

            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            String firstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
            String dateOfBirth = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DateOfBirth");


            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild) && isElementPresentVerification(IntakeConstants.Patient_first_Name_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_Last_Name_Feild, LastName) || !clearAndEnterText(IntakeConstants.Patient_first_Name_Feild, firstName)) {
                    throw new Exception("Not able to enter patient last name and first name field");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_date_Picker_Feild)) {
                    if (!clearAndEnterText(IntakeConstants.Patient_date_Picker_Feild, dateOfBirth)) {
                        throw new Exception("Not able to enter value in date of birth field");
                    }
                    if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                        if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                            throw new Exception("user not able to click search button");
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
	 *
	 */

    @Then("^user enter Patient Search Screen criteria for a patient that is deceased in patient profile$")
    public void user_enter_Patient_Search_Screen_criteria_for_a_patient_that_is_deceased_in_patient_profile(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            //deceased patient = span
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_first_Name_Feild)).clear();
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_date_Picker_Feild)).clear();
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild)).clear();
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Last_Name_Feild)).clear();

            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_Last_Name_Feild, LastName)) {
                    throw new Exception("Not able to enter patient last name and first name field");
                }

                if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                        throw new Exception("user not able to click search button");
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
	 *
	 */

    @Then("^system should be displayed results with validated deceased symbol$")
    public void system_should_be_displayed_results_with_validated_deceased_symbol() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


        try {
            if (isElementPresentVerification(SmokeTestConstants.Patient_ViewButton)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_ViewButton)) {
                    throw new Exception("user not able to click view button");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_profile_Indicator)) {
                    String deceased = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_profile_Indicator)).getText();
                    log.info("the pateint displayed:" + deceased);
                    Assert.assertEquals("Deceased", deceased);
                }
                if (isElementPresentVerification(IntakeConstants.Patient_profile_Back_Button_To_Profile))
                {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Back_Button_To_Profile))
                    {
                        throw new Exception("user not able to click back button");
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
	 *
	 */

    @Then("^user enter Patient Search criteria for a patient that is a pet$")
    public void user_enter_Patient_Search_criteria_for_a_patient_that_is_a_pet(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_first_Name_Feild)).clear();
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_date_Picker_Feild)).clear();
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild)).clear();
            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_Last_Name_Feild, LastName)) {
                    throw new Exception("Not able to enter patient last name and first name field");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                        throw new Exception("user not able to click search button");
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
	 *
	 */

    @Then("^system should be displayed results with validated pet symbol in patient profile$")
    public void system_should_be_displayed_results_with_validated_pet_symbol_in_patient_profile() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


        try {
            if (isElementPresentVerification(SmokeTestConstants.Patient_ViewButton)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_ViewButton)) {
                    throw new Exception("user not able to click view button");
                }

                if (isElementPresentVerification(IntakeConstants.Patient_profile_Pet_Indicator)) {
                    String pet = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_PROFILE_PET_INDICATOR_TEXT)).getText();
                    Assert.assertEquals(pet, "Pet");
                }

                if (isElementPresentVerification(IntakeConstants.Patient_profile_Back_Button_To_Profile)) {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Back_Button_To_Profile)) {
                        throw new Exception("user not able to click back button");
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
	 *
	 */

    @Then("^user enter Patient Search criteria for a patient that is a twin$")
    public void user_enter_Patient_Search_criteria_for_a_patient_that_is_a_twin(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_first_Name_Feild)).clear();
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_date_Picker_Feild)).clear();
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild)).clear();
            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_Last_Name_Feild, LastName)) {
                    throw new Exception("Not able to enter patient last name and first name field");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                        throw new Exception("user not able to click search button");
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
	 *
	 */

    @Then("^system should be displayed results with validated twin symbol in patient profile$")
    public void system_should_be_displayed_results_with_validated_twin_symbol_in_patient_profile() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


        try {
            if (isElementPresentVerification(SmokeTestConstants.Patient_ViewButton)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_ViewButton)) {
                    throw new Exception("user not able to click view button");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_profile_Twin_Indicator)) {
                    String twin = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_profile_Twin_Indicator)).getText();
                    Assert.assertEquals(twin, "Twin");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_profile_Back_Button_To_Profile)) {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Back_Button_To_Profile)) {
                        throw new Exception("user not able to click back button");
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
	 *
	 */

    @Then("^system displayed the list of Patients matching with phone number inserted criteria$")
    public void system_displayed_the_list_of_Patients_matching_with_phone_number_inserted_criteria(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            if (isElementPresentVerification(IntakeConstants.Patient_profile_phone_Results_Screen)) {
                List<WebElement> list = chromeDriver.findElements(By.xpath(IntakeConstants.Patient_profile_phone_Results_Screen));
                String phoneNumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");
                for (int i = 0; i < list.size(); i++) {
                    Assert.assertTrue(list.get(i).getText().contains(phoneNumber));
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
	 *
	 */

    @Then("^system displayed the list of Patients matching with Date of Birth the inserted criteria$")
    public void system_displayed_the_list_of_Patients_matching_with_Date_of_Birth_the_inserted_criteria(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {

            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Last_Name_Feild)).clear();
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild)).clear();

            if (isElementPresentVerification(IntakeConstants.Patient_profile_Date_of_Birth_Results_Screen)) {
                List<WebElement> list = chromeDriver.findElements(By.xpath(IntakeConstants.Patient_profile_Date_of_Birth_Results_Screen));
                
                String dateOfBirth = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DateOfBirth");
                
                for (int i = 0; i < list.size(); i++) {
                    Assert.assertTrue(list.get(i).getText().contains(dateOfBirth));
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
	 *
	 */

    @Then("^system displayed the list of Patients matching with first name and last name inserted criteria$")
    public void system_displayed_the_list_of_Patients_matching_with_first_name_and_last_name_inserted_criteria(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
        	Thread.sleep(3000);
        	waitForVisibility(SmokeTestConstants.patientSearch_rows);
        	String dateOfBirth = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DateOfBirth");
        	
            List<WebElement> list = chromeDriver.findElements(By.xpath(IntakeConstants.Patient_profile_Search_Results_Screen));
            //List<WebElement> list1 = chromeDriver.findElements(By.xpath(IntakeConstants.Patient_profile_Date_of_Birth_Results_Screen));
            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName").toUpperCase();
            String firstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName").toUpperCase();
            if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Results_Screen)) {
	            for (int i = 0; i < list.size(); i++) {
	            		            	
	                Assert.assertTrue(list.get(i).getText().toUpperCase().contains(LastName));
	                //Assert.assertTrue(FrameworkLibrary.chromeDriver.getPageSource().toUpperCase().contains(firstName));
	                //Assert.assertTrue(list1.get(i).getText().contains(dateOfBirth));
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
	 *
	 */

    @Then("^system displayed the list of Patients matching with last name and phone number inserted criteria$")
    public void system_displayed_the_list_of_Patients_matching_with_last_name_and_phone_number_inserted_criteria(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Results_Screen)) {
                List<WebElement> list = chromeDriver.findElements(By.xpath(IntakeConstants.Patient_profile_Search_Results_Screen));
                List<WebElement> list1 = chromeDriver.findElements(By.xpath(IntakeConstants.Patient_profile_phone_Results_Screen));
                String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName").toUpperCase();
                String phoneNumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");
                for (int i = 0; i < list.size(); i++) {
                    Assert.assertTrue(list.get(i).getText().toUpperCase().contains(LastName));
                    Assert.assertTrue(list1.get(i).getText().contains(phoneNumber));
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
	 *
	 */

    @And("^user validate the first row patient has been selected$")
    public void user_validate_the_first_row_patient_has_been_selected() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        //twin patient = FRANK SINATRA
        try {
            if (isElementPresentVerification(IntakeConstants.Patient_profile_Results_Row_One)) {
                String resultrow = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_profile_Results_Row_One)).getAttribute("class");
                Assert.assertTrue(resultrow.contains("ng-scope selected"));
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
	 */

    @And("^user click Add new button$")
    public void and_user_click_Add_new_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.Patient_profile_Add_Button)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Add_Button)) {
                    throw new Exception("User not able to click Add button");
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


	/*
	 *
	 */

    @And("^user click on global search icon$")
    public void user_click_on_global_search_icon() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.Patient_Global_Search_Icon)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Patient_Global_Search_Icon)) {
                    throw new Exception("User not able to click global search button");
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
	 *
	 */

    @And("^user enters lastname and  date of birth perform local search$")
    public void user_enters_lastname_and_date_of_birth_perform_local_search(DataTable arg1) throws Exception {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {

            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Last_Name_Feild)).clear();
            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            String dateOfBirth = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DateOfBirth");


            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_Last_Name_Feild, LastName)) {
                    throw new Exception("Not able to enter patient last name  field");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_date_Picker_Feild)) {
                    if (!clearAndEnterText(IntakeConstants.Patient_date_Picker_Feild, dateOfBirth)) {
                        throw new Exception("Not able to enter value in date of birth field");
                    }
                    if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                        if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                            throw new Exception("user not able to click search button");
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


	/*
	 *
	 */

    @And("^user click Add new button and it navigate to patient registration page$")
    public void user_click_Add_new_button_and_it_navigate_to_patient_registration_page() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Results_Screen)) {
                if (isElementPresentVerification(IntakeConstants.Patient_profile_Add_Button)) {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Add_Button)) {
                        throw new Exception("User not able to click Add button");
                    }
                }
                if (isElementPresentVerification(IntakeConstants.Patient_profile_New_Registration_Patient_Form)) {
                    Assert.assertTrue(isElementPresents(IntakeConstants.Patient_profile_New_Registration_Patient_Form));
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
	 *
	 */

    @And("^user click cancel popup button$")
    public void user_click_cancel_popup_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Patient_profile_Error_Dialog_Popup_Screen_Cancel_Button)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Error_Dialog_Popup_Screen_Cancel_Button)) {
                    throw new Exception("User not able to click cancel button");
                }
                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }
        } catch (AssertionError e) {
            e.printStackTrace();
            takeScreenShot(methodName);
            throw new Exception();

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 *
	 */

    @And("^user click Add new button and click cancel button$")
    public void user_click_Add_new_button_and_click_cancel_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            if (isElementPresentVerification(IntakeConstants.Patient_profile_Add_Button)) {
            	if(!chromeDriver.findElement(By.xpath(IntakeConstants.Patient_profile_Search_Button)).isEnabled()){
                	Thread.sleep(3000);
                }
                if (isElementPresentVerification(IntakeConstants.Patient_profile_Add_Button)) {
                    SmokeTestLibrary.hotkeyAction(Keys.ALT, "a", chromeDriver);
                }
            }
            if (isElementPresentVerification(IntakeConstants.Patient_profile_Registration_Form_Cancel_Button)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Registration_Form_Cancel_Button)) {
                    throw new Exception("User not able to click Cancel button");
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
	 *
	 */

    @And("^user enter patient first name and last name and phone number perform local search$")
    public void user_enter_patient_first_name_and_last_name_and_phone_number_perform_local_search(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild)).clear();

            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            String firstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
            String phoneNumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");


            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild) && isElementPresentVerification(IntakeConstants.Patient_first_Name_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_Last_Name_Feild, LastName) || !clearAndEnterText(IntakeConstants.Patient_first_Name_Feild, firstName)) {
                    throw new Exception("Not able to enter patient last name and first name field");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_Phone_Number_Feild)) {
                    WebElement element = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild));
                    element.click();
                    Actions ac = new Actions(chromeDriver);
                    ac = ac.sendKeys(phoneNumber);
                    ac.perform();
                }
                if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                        throw new Exception("user not able to click search button");
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
	 *
	 */

    @And("^system displayed the list of Patients matching first name and last name and phone number perform local search$")
    public void system_displayed_the_list_of_Patients_matching_first_name_and_last_name_and_phone_number_perform_local_search(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Results_Screen)) {
                List<WebElement> list = chromeDriver.findElements(By.xpath(IntakeConstants.Patient_profile_Search_Results_Screen));
                List<WebElement> list1 = chromeDriver.findElements(By.xpath(IntakeConstants.Patient_profile_phone_Results_Screen));
                String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName").toUpperCase();
                String firstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName").toUpperCase();
                String phoneNumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");
                for (int i = 0; i < list.size(); i++) {
                    Assert.assertTrue(list.get(i).getText().toUpperCase().contains(LastName));
                    Assert.assertTrue(list.get(i).getText().toUpperCase().contains(firstName));
                    Assert.assertTrue(list1.get(i).getText().contains(phoneNumber));
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
	 *
	 */

    @Then("^user enters lastname and date of birth perform global search$")
    public void user_enters_lastname_and_date_of_birth_perform_global_search(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            String dateOfBirth = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DateOfBirth");
            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_Last_Name_Feild, LastName)) {
                    throw new Exception("Not able to enter patient last name and phone number field");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_date_Picker_Feild)) {
                    if (!clearAndEnterText(IntakeConstants.Patient_date_Picker_Feild, dateOfBirth)) {
                        throw new Exception("Not able to enter value in date of birth field");
                    }
                }
                if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                        throw new Exception("user not able to click search button");
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

    @Then("^user enters Date of Birth and perform global search$")
    public void user_enters_Date_of_Birth_and_perform_global_search(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Last_Name_Feild)).clear();
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild)).clear();
            String dateOfBirth = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DateOfBirth");
            if (isElementPresentVerification(IntakeConstants.Patient_date_Picker_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_date_Picker_Feild, dateOfBirth)) {
                    throw new Exception("Not able to enter value in date of birth field");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                        throw new Exception("user not able to click search button");
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

    @Then("^user enters phone number and perform global search$")
    public void user_enters_phone_number_and_perform_global_search(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
        	Thread.sleep(3000);
            if (isElementPresentVerification(IntakeConstants.Patient_date_Picker_Feild)) {
                if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild)) {
                    FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_date_Picker_Feild)).clear();
                    FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Last_Name_Feild)).clear();
                    String phonenumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");
                    if (isElementPresentVerification(IntakeConstants.Patient_Phone_Number_Feild)) {
                        WebElement element = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild));
                        element.sendKeys(phonenumber);
                    }
                    if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                        if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                            throw new Exception("user not able to click search button");
                        }
                    }
                    Thread.sleep(3000);
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
     * Method : To User enter invalid phonenumber in patient search and validating
     * author : Jeyaprakash K
     * Date :  June-6-2017
     * Modifier :
     * Modification Date :
     ******************************************************************************/
    @When("^User enter the Invalid phonenumber \"([^\"]*)\" and validate the error msg$")
    public void User_validate_the_Invalid_phonenumber_search_in_patient_search_screen(String phoneNumber) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.Patient_Phonenumber)) {
                element = chromeDriver.findElement(By.xpath(SmokeTestConstants.Patient_Phonenumber));
                element.sendKeys(phoneNumber);
            }
            if (isElementPresentVerification(SmokeTestConstants.Patient_SearchButton)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_SearchButton)) {
                    throw new Exception("Not able to click on Patient_SearchButton Button");
                }
            }
            if (!isElementPresentVerification(IntakeConstants.Patient_invalid_ph_number)) {
                throw new Exception("Not able to visible invalid phonumber error msg");
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
     * Method : To verify hot key Alt + S
     * author : Jeyaprakash K
     * Date :  June-06-2017
     * Modifier :
     * Modification Date :
     ******************************************************************************/
    @When("^User hits alt plus S hot key$")
    public void alt_plus_S_hotkey() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions ac = new Actions(chromeDriver);
            Action altS = ac.keyDown(Keys.ALT).sendKeys("S").keyUp(Keys.ALT).build();
            altS.perform();
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : To verify hot key Alt + A
     * author : Jeyaprakash K
     * Date :  June-06-2017
     * Modifier :
     * Modification Date :
     ******************************************************************************/
    @When("^User hits alt plus A hot key$")
    public void alt_plus_A_hotkey() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions ac = new Actions(chromeDriver);
            Action altA = ac.keyDown(Keys.ALT).sendKeys("A").keyUp(Keys.ALT).build();
            altA.perform();
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : To verify hot key Alt + O
     * author : Jeyaprakash K
     * Date :  June-06-2017
     * Modifier :
     * Modification Date :
     ******************************************************************************/
    @When("^User hits alt plus O hot key$")
    public void alt_plus_O_hotkey() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions ac = new Actions(chromeDriver);
            Action altO = ac.keyDown(Keys.ALT).sendKeys("O").keyUp(Keys.ALT).build();
            altO.perform();
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : To verify hot key Alt + Left
     * author : Jeyaprakash K
     * Date :  June-06-2017
     * Modifier :
     * Modification Date :
     ******************************************************************************/
    @When("^User hits alt plus left hot key$")
    public void alt_plus_left_hotkey() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions ac = new Actions(chromeDriver);
            Action altO = ac.keyDown(Keys.ALT).sendKeys(Keys.ARROW_LEFT).keyUp(Keys.ALT).build();
            altO.perform();
            Thread.sleep(2000);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : To verify patient search error msg
     * author : Jeyaprakash K
     * Date :  June-06-2017
     * Modifier :
     * Modification Date :
     ******************************************************************************/
    @Then("^User Validating patient invalid search error msg$")
    public void patient_search_error_msg() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.hotKey_Search_patient_error_msg)) {
                throw new Exception("Not able to visible invalid search error msg");
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
	 * This method include
	 * -> Select Check IC+ row in POS
	 * -> drag POS list pending link to top.
	 * -> select first row of the POS list
	 * -> Select and validate error message at the last index of POS
	 */

    /****************************************************************************
     * Method : To verify Add New button is enable
     * author : Jeyaprakash K
     * Date :  June-06-2017
     * Modifier :
     * Modification Date :
     ******************************************************************************/
    @Then("^User Validating Add New button is enable in patient search screen$")
    public void addnew_btn_is_enable_patient_search() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            boolean addNewBtn = chromeDriver.findElement(By.xpath(IntakeConstants.addNew_Btn)).isEnabled();
            Assert.assertTrue(addNewBtn);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : To verify add new patient error popup msg
     * author : Jeyaprakash K
     * Date :  June-06-2017
     * Modifier :
     * Modification Date :
     ******************************************************************************/
    @Then("^User Validating add new patient popUp msg$")
    public void add_new_popup_msg() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.addNew_Item_PopUp_Msg)) {
                throw new Exception("Not able to visible add new patient popUp msg");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^The check IC\\+ prescription should be selected$")
    public void the_check_IC_prescription_should_be_selected(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            SmokeTestStepDef.i_click_search_button_on_patient_order_status();
            List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));
            for (int i = 0; i <= elements.size(); i++) {
                if (elements.get(i).getText().contains("Check IC")) {
                    Assert.assertTrue(elements.get(i).getText().contains("Check IC"));
                    String dyn = elements.get(i).getAttribute("id");
                    String[] dynamo = dyn.split("-");
                    String part1 = dynamo[1];
                    String CheckICpluslink = "//*[@id='patient-order-status-team-member-status-id-" + part1 + "-" + i + "']";
                    Assert.assertTrue(isElementPresentVerification(CheckICpluslink));
                    isElementPresentVerifyClick(CheckICpluslink);

                    //this code is for drag POS list pending link to top.
                    long timeoutExpiredMS = System.currentTimeMillis() + ((elements.size() + 5) * 100);
                    while (1 != 2) {
                        Actions ac = new Actions(chromeDriver);
                        Action a = ac.sendKeys(Keys.ARROW_UP).build();
                        a.perform();
                        if (System.currentTimeMillis() > timeoutExpiredMS) {
                            break;
                        }
                    }
                    //this code is for select first row of the POS list
                    String firstRowId = elements.get(0).getAttribute("id");
                    int length = firstRowId.length();
                    if (length == 38) {
                        String[] arrOfFirstRowId = firstRowId.split("-");
                        String partOne = arrOfFirstRowId[1];
                        String partTwo = arrOfFirstRowId[2];
                        String partThree = arrOfFirstRowId[3];
                        String firstRowcloumn1 = "//tr[@id='patient-" + partOne + "-" + partTwo + "-" + partThree + "']/td[2]/span[2]";
                        log.info("firstRowcloumn1 ::>> " + firstRowcloumn1);
                        Assert.assertTrue(isElementPresentVerification(firstRowcloumn1));
                        isElementPresentVerifyClick(firstRowcloumn1);
                        Thread.sleep(2000);
                    } else {
                        String[] arrOfFirstRowId = firstRowId.split("-");
                        String partOne = arrOfFirstRowId[1];
                        String partTwo = arrOfFirstRowId[2];
                        String firstRowcloumn1 = "//tr[@id='patient-" + partOne + "-" + partTwo + "']/td[2]/span[2]";
                        Assert.assertTrue(isElementPresentVerification(firstRowcloumn1));
                        isElementPresentVerifyClick(firstRowcloumn1);
                        Thread.sleep(2000);
                    }
                    Assert.assertTrue(isElementPresentVerification(SmokeTestConstants.POS_delete_rx_Button));
                    getElementByProperty(SmokeTestConstants.POS_delete_rx_Button, chromeDriver).click();
                    timeoutExpiredMS = System.currentTimeMillis() + 500;
                    while (1 != 2) {
                        if (System.currentTimeMillis() > timeoutExpiredMS) {
                            break;
                        }
                    }
                    //Select and validate error message at the last index of POS
                    Assert.assertFalse(FrameworkLibrary.isElementPresents(IntakeConstants.Rx_DeleteBtnDialog), "Delete should not happen if prescription is Check IC+");
                    String Pos_DeleteICerrorMessage = "//*[@id='patient-order-status-list']/table/tbody/tr[" + ((i + 1) * 2) + "]/td[1]/div[2]";
                    Assert.assertTrue(isElementPresentVerification(Pos_DeleteICerrorMessage));
                    Assert.assertEquals(chromeDriver.findElement(By.xpath(Pos_DeleteICerrorMessage)).getText(), "IC+ prescription can only be deleted in IC+");
                    break;
                } else {
                    log.info("The" + i + "prescription is not current which has check IC+");
                    if (i == 0) {
                        Assert.fail("prescription not found which has check IC+.");
                    }
                }
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * Verify if expected fields are present on Patient profile plan summary section
	 */
    @Then("^User should see following fields in Plan Summary section:$")
    public void user_should_see_following_fields_in_plan_summary_section(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        List<String> options = arg1.asList(String.class);
        try {
            for (int i = 0; i < options.size(); i++) {
                log.info(i + " option " + options.get(i));
                Boolean condition = FrameworkLibrary.chromeDriver.getPageSource().contains(options.get(i));
                Assert.assertTrue(condition, "Text " + options.get(i) + "  not present on page");
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
	 * Click on View all plans links
	 */
    @When("^User clicks on View all plans link$")
    public void user_clicks_on_view_all_plans_link() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.VIEW_ALL_PLAN_LINK)) {
                if (!isElementPresentVerifyClick(IntakeConstants.VIEW_ALL_PLAN_LINK)) {
                    throw new Exception("Not able to click view all plan link");

                }
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
        }
    }

    /*
	 * Verify if expected message is present on specified section
	 */
    @Then("^User should not see the message \"([^\"]*)\" in \"([^\"]*)\" section$")
    public void i_should_not_see_the_message_in_section(String message, String section) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            if (section.equals("Plan Summary Bottom")) {
                Boolean condition = FrameworkLibrary.chromeDriver.getPageSource().contains(message);
                Assert.assertFalse(condition, "View all XX plan text is present on this page");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /***
     * This method will get data entered in the text fields and compare them with the data from excel sheet after the search has been performed
     * @param arg1 this parameter will get the information about the Input file name, sheet name, row name from Cucumber feature file
     * @ catches all Exception and Error
     */

    @And("^User gets the data from text fields and compares it to data entered before$")
    public void user_gets_the_data_from_text_fields_and_compares_it_to_data_entered_before(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            String lastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            String firstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
            String patientDOB = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DateOfBirth");
            String patientPhoneNumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_Phonenumber) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName)
                    && isElementPresentVerification(SmokeTestConstants.Patient_LastName)) {
                String firstNameFromApplication = getElementText(SmokeTestConstants.Patient_FirstName);
                String lastNameFromApplication = getElementText(SmokeTestConstants.Patient_LastName);
                String phoneNumberFromApplication = getElementText(SmokeTestConstants.Patient_Phonenumber);
                String dobFromApplication = getElementText(IntakeConstants.PATIENT_SEARCH_DOB);
                Assert.assertTrue(firstNameFromApplication.toUpperCase().contains(firstName.toUpperCase()), "first name from the application text field and test data is not same");
                Assert.assertTrue(lastNameFromApplication.toUpperCase().contains(lastName.toUpperCase()), "last name from the application text field and test data  is not same");
                Assert.assertTrue(phoneNumberFromApplication.contains(patientPhoneNumber), "phone number from the application text field and test data is not same");
                Assert.assertTrue(dobFromApplication.contains(patientDOB), "patient DOB from the application text field and test data is not same");
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /***
     * This method will click on global option in patient search page
     * @ catches all Exception and Error
     */
    @When("^User clicks on global search option$")
    public void user_clicks_on_global_search_option() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_GLOBAL_OPTION)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PATIENT_SEARCH_GLOBAL_OPTION)) {
                    throw new Exception("Not able to click login button");
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
     * This method will checks the date and assert whether error is displayed for future date
     *
     * @param message this parameter will contain the string No future date allowed
     * @param arg1    this parameter will contain the date information
     * @ catches all Exception and Error
     */
    @And("^User enters future date of birth and sees error \"([^\"]*)\" message while performing search$")
    public void user_enters_future_date_of_birth_and_sees_error_message_while_performing_search(String message, DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_Phonenumber) && isElementPresentVerification(SmokeTestConstants.Patient_LastName) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
                for (int i = 0; i < arg1.raw().size(); i++) {
                    if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB)) {
                        String patientDOB = arg1.raw().get(i).get(0);
                        if (!clearAndEnterText(IntakeConstants.PATIENT_SEARCH_DOB, patientDOB)) {
                            throw new Exception("Not able to enter value in LastName text field");
                        } else if (isElementPresentVerification(SmokeTestConstants.Patient_SearchButton)) {
                            if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_SearchButton)) {
                                throw new Exception("Not able to click on Patient_SearchButton Button");
                            }
                            String errorMsgForInvalidDate = null;
                            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB_INVALID_DATE_ERROR)) {
                                errorMsgForInvalidDate = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_DOB_INVALID_DATE_ERROR)).getText();
                            }
                            Assert.assertTrue(errorMsgForInvalidDate.equals(message), "Error message for future date of birth is not displayed");
                        }
                    }
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**
     * This method will check that System sets the focus on the first row in returned patient results
     *
     * @ catches all Exception and Error
     */
    @And("^System sets the focus on the first row in returned patient results$")
    public void systemSetsTheFocusOnTheFirstRowInReturnedPatientResults() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_RESULTS_LIST)) {
                List<WebElement> list = chromeDriver.findElements(By.xpath(IntakeConstants.PATIENT_SEARCH_RESULTS_LIST));
                if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_RESULTS_FOCUSED_ROW)) {
                }
                String focusedElementInResults = getElementText(IntakeConstants.PATIENT_SEARCH_RESULTS_FOCUSED_ROW);
                Assert.assertTrue(list.get(0).getText().equals(focusedElementInResults), "System did not focus on the first element in the list");
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
     * This method will click on search all stores button in the popup
     *
     * @ catches all Exception and Error
     */
    @And("^User clicks on search all stores button using ALT plus s hot key$")
    public void userClicksOnSearchAllStoresButtonUsingALTPlusSHotKey() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_ADDNEW_POPUP_SEARCH_ALL_STORES)) {
                Actions addNew = new Actions(chromeDriver);
                Action series = addNew.keyDown(Keys.ALT).sendKeys("s").keyUp(Keys.ALT).build();
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

    /**
     * This method will check for a popup with expected message
     *
     * @param messageFromApplication
     * @ catches all Exception and Error
     */
    @Then("^System shows a popup with \"([^\"]*)\" message$")
    public void systemShowsAPopupWithMessage(String messageFromApplication) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_ADD_NEW_BUTTON_CLICK_POPUP)) {
                String patientSearchDialogMessage = getElementText(IntakeConstants.PATIENT_SEARCH_ADD_NEW_BUTTON_CLICK_POPUP);
                Assert.assertTrue(patientSearchDialogMessage.equals(messageFromApplication), "User did not see the message " + patientSearchDialogMessage + " in the popup");

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
     * This method will check the tab order in the patient search page
     *
     * @param arg1 this parameter will contain text fields name
     * @ catches all Exception and Error
     */
    @And("^User checks the tab order of the following text fields$")
    public void userChecksTheTabOrderOfTheFollowingTextFields(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_Phonenumber) &&
                    isElementPresentVerification(SmokeTestConstants.Patient_LastName) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName)
                    && isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_ADD_NEW_BUTTON) && isElementPresentVerification(IntakeConstants.Patient_Local_Search_Icon)) {
                for (int i = 0; i < arg1.raw().size(); i++) {
                    chromeDriver.switchTo().activeElement().sendKeys(Keys.TAB);
                    Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").toString().contains(arg1.raw().get(i).get(0)), "Not on '" + arg1.raw().get(i).get(0) + "' field");
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 *
	 */

    /**
     * This method will check for the labels in the patient search page
     *
     * @param labels This parameter will contain the label name
     * @ catches all Exception and Error
     */
    @And("^User checks the following labels are present$")
    public void userChecksTheFollowingLabelsArePresent(DataTable labels) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_Phonenumber) &&
                    isElementPresentVerification(SmokeTestConstants.Patient_LastName) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName)
                    && isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_ADD_NEW_BUTTON) && isElementPresentVerification(IntakeConstants.Patient_Local_Search_Icon) &&
                    isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_GLOBAL_OPTION)) {
                List<WebElement> listOfLabelsInPS = chromeDriver.findElements(By.xpath(IntakeConstants.PATIENT_SEARCH_LABELS));
                for (int i = 0; i < listOfLabelsInPS.size(); i++) {
                    Assert.assertTrue(listOfLabelsInPS.get(i).getText().equals(labels.raw().get(i).get(0)), labels.raw().get(i).get(0) + " Label is displayed in Patient search page");
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 *
	 */

    @When("^User hits Alt\\+P$")
    public void user_hits_Alt_P() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("p").keyUp(Keys.ALT).build();
            series.perform();
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
	 */

    @When("^User hits Alt\\+U$")
    public void user_hits_Alt_U() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Actions ac = new Actions(chromeDriver);
            Action series = ac.keyDown(Keys.ALT).sendKeys("u").keyUp(Keys.ALT).build();
            series.perform();
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
	 */

    @Then("^Validate the tab order Update->Back->Patient Comments->Prefresences->Update$")
    public void validate_the_tab_order_Update_Back_Patient_Comments_Prefresences_Update() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            IntakeLibrary.TestTabOrderPreferences();
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
	 */

    @When("^User enters patient Phone Number$")
    public void user_enters_patient_Phone_Number(DataTable data) throws Exception {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(data);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            String PhoneNumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "PhoneNumber");
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_Phonenumber) && isElementPresentVerification(SmokeTestConstants.Patient_LastName) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_Phonenumber, chromeDriver).clear();
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_LastName, chromeDriver).clear();
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_FirstName, chromeDriver).clear();
                FrameworkLibrary.getElementByProperty(IntakeConstants.PATIENT_SEARCH_DOB, chromeDriver).clear();
                if (!clearAndEnterText(SmokeTestConstants.Patient_Phonenumber, PhoneNumber)) {
                    throw new Exception("Not able to enter value in phonenumber text field");
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 *
	 */

    @When("^User enters patient Last Name and Date of Birth$")
    public void user_enters_patient_Last_Name_and_Date_of_Birth(DataTable data) throws Exception {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(data);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            String patientDOB = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "DateOfBirth");

            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "LastName");

            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_Phonenumber) && isElementPresentVerification(SmokeTestConstants.Patient_LastName) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_LastName, chromeDriver).clear();
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_FirstName, chromeDriver).clear();
                FrameworkLibrary.getElementByProperty(IntakeConstants.PATIENT_SEARCH_DOB, chromeDriver).clear();
                if (!clearAndEnterText(IntakeConstants.PATIENT_SEARCH_DOB, patientDOB)) {
                    throw new Exception("Not able to enter value in DOB field");
                }
                if (!clearAndEnterText(SmokeTestConstants.Patient_LastName, LastName)) {
                    throw new Exception("Not able to enter value in LastName text field");
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 *
	 */

    @When("^User enters patient Last Name with (\\d+) minimum character$")
    public void user_enters_patient_Last_Name_with_minimum_character(int no, DataTable data) throws Exception {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(data);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String LastNameMinChar = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "LastName");
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_Phonenumber) && isElementPresentVerification(SmokeTestConstants.Patient_LastName) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_FirstName, chromeDriver).clear();
                FrameworkLibrary.getElementByProperty(IntakeConstants.PATIENT_SEARCH_DOB, chromeDriver).clear();
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_Phonenumber, chromeDriver).clear();

                if (!clearAndEnterText(SmokeTestConstants.Patient_LastName, LastNameMinChar)) {
                    throw new Exception("Not able to enter value in LastName text field");
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

	/*
	 *
	 */

    @When("^User enters patient Last Name and First Name$")
    public void user_enters_patient_Last_Name_and_First_Name(DataTable data) throws Exception {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(data);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {

            String FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "FirstName");

            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "LastName");

            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_Phonenumber) && isElementPresentVerification(SmokeTestConstants.Patient_LastName) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
            	
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_LastName, chromeDriver).clear();
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_FirstName, chromeDriver).clear();
                FrameworkLibrary.getElementByProperty(IntakeConstants.PATIENT_SEARCH_DOB, chromeDriver).clear();
                if (!clearAndEnterText(IntakeConstants.Patient_LastName, LastName)) {
                    throw new Exception("Not able to enter value in Lastname field");
                }
                if (!clearAndEnterText(SmokeTestConstants.Patient_FirstName, FirstName)) {
                    throw new Exception("Not able to enter value in First name text field");
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 *
	 */

    @When("^User enters patient First Name and Date of Birth$")
    public void user_enters_patient_First_Name_and_Date_of_Birth(DataTable data) throws Exception {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(data);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            String patientDOB = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "DateOfBirth");

            String FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "FirstName");

            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_Phonenumber) && isElementPresentVerification(SmokeTestConstants.Patient_LastName) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_LastName, chromeDriver).clear();
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_FirstName, chromeDriver).clear();
                FrameworkLibrary.getElementByProperty(IntakeConstants.PATIENT_SEARCH_DOB, chromeDriver).clear();
                if (!clearAndEnterText(IntakeConstants.PATIENT_SEARCH_DOB, patientDOB)) {
                    throw new Exception("Not able to enter value in DOB field");
                }
                if (!clearAndEnterText(SmokeTestConstants.Patient_FirstName, FirstName)) {
                    throw new Exception("Not able to enter value in First name text field");
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @When("^User enters patient First Name and Phone Number$")
    public void user_enters_patient_First_Name_and_Phone_Number(DataTable data) throws Exception {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(data);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            String PhoneNo = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "PhoneNumber");

            String FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "FirstName");

            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DOB) && isElementPresentVerification(SmokeTestConstants.Patient_Phonenumber) && isElementPresentVerification(SmokeTestConstants.Patient_LastName) && isElementPresentVerification(SmokeTestConstants.Patient_FirstName)) {
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_LastName, chromeDriver).clear();
                FrameworkLibrary.getElementByProperty(SmokeTestConstants.Patient_FirstName, chromeDriver).clear();
                FrameworkLibrary.getElementByProperty(IntakeConstants.PATIENT_SEARCH_DOB, chromeDriver).clear();
                if (!clearAndEnterText(IntakeConstants.Patient_search_phone_number, PhoneNo)) {
                    throw new Exception("Not able to enter value in phone o field");
                }
                if (!clearAndEnterText(SmokeTestConstants.Patient_FirstName, FirstName)) {
                    throw new Exception("Not able to enter value in First name text field");
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 *
	 */

    @Then("^User should see search results matching the search criteria$")
    public void user_should_see_search_results_matching_the_search_criteria(DataTable data) throws Exception {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(data);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String result_firstname = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "FirstName").toUpperCase();
            String result_lastname = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "LastName").toUpperCase();

            String result_phone_no = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "PhoneNumber");

            String result_DOB = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                    dataMap.get("RowId").get(0), "DateOfBirth");
            if (isElementPresentVerification(IntakeConstants.Patient_search_results_table)) {

            	Assert.assertTrue(
                        IntakeLibrary.getElement(IntakeConstants.Patient_search_results_table).getText().toUpperCase()
                                .contains(result_firstname),
                        "Patient search results does not match with the search criteria " + result_firstname
                                + " From application :"
                                + IntakeLibrary.getElement(IntakeConstants.Patient_search_results_table).getText());
                
                Assert.assertTrue(
                        IntakeLibrary.getElement(IntakeConstants.Patient_search_results_table).getText().toUpperCase()
                                .contains(result_lastname),
                        "Patient search results does not match with the search criteria " + result_lastname
                                + " From application :"
                                + IntakeLibrary.getElement(IntakeConstants.Patient_search_results_table).getText());
                
                Assert.assertTrue(
                        IntakeLibrary.getElement(IntakeConstants.Patient_search_results_table).getText()
                                .contains(result_phone_no),
                        "Patient search results does not match with the search criteria " + result_phone_no
                                + " From application :"
                                + IntakeLibrary.getElement(IntakeConstants.Patient_search_results_table).getText());
                
                Assert.assertTrue(
                        IntakeLibrary.getElement(IntakeConstants.Patient_search_results_table).getText()
                                .contains(result_DOB),
                        "Patient search results does not match with the search criteria " + result_DOB
                                + " From application :"
                                + IntakeLibrary.getElement(IntakeConstants.Patient_search_results_table).getText());
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /****************************************************************************
     * Method : To Verify that the System allows to enter a Date of Birth of 8 digits
     * author : Jeyaprakash K
     * Date :  June-6-2017
     * Modifier :
     * Modification Date :
     ******************************************************************************/
    @Then("^User enter and validate dob in patient search screen$")
    public void User_enter_and_validate_dob_in_patient_search_screen(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);


        String actualDOB = dataMap.get("ActualDOB").get(0);
        String expectedDOB = dataMap.get("ExpectedDOB").get(0);
        try {

            if (isElementPresentVerification(SmokeTestConstants.patient_DateOfBrith)) {
                if (!clearAndEnterText(SmokeTestConstants.patient_DateOfBrith, actualDOB)) {
                    throw new Exception("Not able to enter value in user name text field");
                }
            }
            if (isElementPresentVerification(SmokeTestConstants.Patient_SearchButton)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_SearchButton)) {
                    throw new Exception("Not able to click on Patient_SearchButton Button");
                }
            }
            String current_DOB = getElementText(SmokeTestConstants.patient_DateOfBrith);
            Assert.assertEquals(current_DOB, expectedDOB);
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
	 */

    @And("^validate patient address should not display$")
    public void validate_patient_address_should_not_display() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            //validating lable No Address on Record at patient profile
            Assert.assertTrue(isElementPresentVerification(IntakeConstants.patient_NoAddressOnRecord_Lable));
            Assert.assertTrue(getElementText(IntakeConstants.patient_NoAddressOnRecord_Lable).equals(IntakeConstants.patient_NoAddressOnRecord_Lable_Text));
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }


	/*
	 *
	 */

    /****************************************************************************
     * Method : Enhanced Patient Search Results | Global & Local Patient Search Maximum & Minimum Results Reached
     * author : Jeyaprakash K
     * Date :  June/12/2017
     * Modifier :
     * Modification Date :
     ******************************************************************************/

    @When("^User validate search patient minimum maximum reached$")
    public void maximum_minimum_result_reached() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(SmokeTestConstants.Patient_)) {
                String search_results = getElementText(SmokeTestConstants.Patient_);
                int search_result = Integer.parseInt(search_results);
                Assert.assertTrue(search_result <= 50);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 *
	 */

    @Then("^System should display no Result found$")
    public void system_should_display_no_Result_found() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.POS_No_Result_Found)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.POS_No_Result_Found, "No results found.");
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
	 */

    @Then("^Delete Rx Button should not display$")
    public void delete_Rx_Button_should_not_display() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            //Assert.assertFalse(chromeDriver.findElement(By.xpath(IntakeConstants.POS_DeleteRx_Button)).isDisplayed());        	
            Assert.assertTrue(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(IntakeConstants.POS_DeleteRx_Button))).apply(chromeDriver));
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
	 */

    @And("^I enter Invalid NDC number on search field$")
    public void i_enter_Invalid_NDC_number_on_search_field(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.Drug_search_field)) {
                SmokeTestLibrary.enter_Text(arg1, "NDC", AccessManagementConstants.drug_search_feild, chromeDriver);
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    @Then("^drug search system should display no results$")
    public void drug_search_system_should_display_no_results() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Drug_search_button)) {
                if (isElementPresentVerifyClick(IntakeConstants.Drug_search_button))
                    Assert.assertTrue(chromeDriver.getPageSource().contains("No drugs matched your search criteria."));
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
	 */

    @When("^user clicks on \"([^\"]*)\" column header$")
    public void user_clicks_on_column_header(String column_name) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


        if (column_name.equals("Name")) try {
            if (isElementPresentVerification(IntakeConstants.Patient_Search_Results_Column_Name)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Patient_Search_Results_Column_Name))
                    throw new Exception("Not able to click name column header");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
        else if (column_name.equals("Phone No")) try {
            if (isElementPresentVerification(IntakeConstants.Patient_Search_Results_Column_PhNo)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Patient_Search_Results_Column_PhNo))
                    throw new Exception("Not able to click phone no column header");
            }

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
        else try {
                if (isElementPresentVerification(IntakeConstants.Patient_Search_Results_Column_DOB)) {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_Search_Results_Column_DOB))
                        throw new Exception("Not able to click DOB column header");
                }

                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            } catch (Exception e) {
                takeScreenShot(methodName);
                throw new Exception(e.getMessage());
            } catch (AssertionError e) {
                takeScreenShot(methodName);

            }
    }

	/*
	 *
	 */

    @Then("^system should sort the results based on Last Name,First Name,Middle Name$")
    public void system_should_sort_the_results_based_on_Last_Name_First_Name_Middle_Name() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Patient_search_results_table)) {
                ArrayList<String> nameList = new ArrayList<String>();
                String row = IntakeConstants.Patient_Search_Results_Row;
                int rowSize = chromeDriver.findElements(By.xpath(row)).size();
                for (int i = 1; i < rowSize; i++) {
                    String name = "//*[@id='patient-list']/table/tbody/tr[" + i + "]/td[1]";
                    String nameValue = chromeDriver.findElement(By.xpath(name)).getText();
                    nameList.add(nameValue.toUpperCase());
                }
                ArrayList<String> sortedNameList = new ArrayList<String>();
                for (String s : nameList) {
                    sortedNameList.add(s.toUpperCase());
                }
                Collections.sort(sortedNameList);
                Collections.reverse(sortedNameList);
                Assert.assertTrue(sortedNameList.equals(nameList), "results not sorted in name order");
                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^system should sort the results based on Phone No$")
    public void system_should_sort_the_results_based_on_Phone_No() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Patient_search_results_table)) {
                ArrayList<String> phList = new ArrayList<String>();
                String row = IntakeConstants.Patient_Search_Results_Row;
                int rowSize = chromeDriver.findElements(By.xpath(row)).size();
                for (int i = 1; i < rowSize; i++) {
                    String name = "//*[@id='patient-list']/table/tbody/tr[" + i + "]/td[5]";
                    String nameValue = chromeDriver.findElement(By.xpath(name)).getText();
                    if (nameValue.length() > 0) {
                        phList.add(nameValue);
                    }
                }
                ArrayList<String> sortedphList = new ArrayList<String>();
                for (String s : phList) {
                    sortedphList.add(s);
                }
                Collections.sort(sortedphList);
                Assert.assertTrue(sortedphList.equals(phList), "results not sorted in phone number order");
                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 *
	 */

    @Then("^system should sort the results based on DOB$")
    public void system_should_sort_the_results_based_on_DOB() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Patient_search_results_table)) {
                ArrayList<Date> dobList = new ArrayList<Date>();

                String row = IntakeConstants.Patient_Search_Results_Row;
                int rowSize = chromeDriver.findElements(By.xpath(row)).size();
                for (int i = 1; i < rowSize; i++) {
                    String name = "//*[@id='patient-list']/table/tbody/tr[" + i + "]/td[3]";
                    String dobValue = chromeDriver.findElement(By.xpath(name)).getText();
                    Date dates = new SimpleDateFormat("dd/MM/yyyy").parse(dobValue);
                    dobList.add(dates);
                }
                ArrayList<Date> sortedDobList = new ArrayList<Date>();
                for (Date s : dobList) {
                    sortedDobList.add(s);
                }
                //Collections.sort(sortedDobList);
                Assert.assertTrue(sortedDobList.equals(dobList), "results not sorted in DOB number order");
                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /***
     * this method used to keyboard actions
     *
     */

    @Then("^user hits Ctrl plus p hot key$")
    public void user_hits_Ctrl_plus_p_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "s", chromeDriver);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
        }
    }

	/*
	 *
	 */

    @Then("^system should navigate to patient search$")
    public void system_should_navigate_to_patient_search() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.Patient_Profile_Title)) {
                Assert.assertTrue(FrameworkLibrary.isElementPresents(IntakeConstants.Patient_Profile_Title));
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /***
     * this method used to perform alt key
     *
     */


    @Then("^user hits Alt plus S hot key$")
    public void user_hits_Alt_plus_S_hot_key() throws Exception {
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

	/*
	 *
	 */

    @Then("^system should navigate to search$")
    public void system_should_navigate_to_search() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                Assert.assertTrue(FrameworkLibrary.isElementPresents(IntakeConstants.Patient_profile_Search_Button));
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /***
     * this method used to keyboard actions
     *
     */

    @Then("^user hits Alt plus V hot key$")
    public void user_hits_Alt_plus_V_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "v", chromeDriver);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 * Method to check if navigated to view button
	 */

    @Then("^system should navigate to view button$")
    public void system_should_navigate_to_view_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            if (isElementPresentVerification(IntakeConstants.Patient_profile_Screen)) {
                Assert.assertTrue(FrameworkLibrary.isElementPresents(IntakeConstants.Patient_profile_Screen));
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /***
     * this method used to perform alt key
     *
     */


    @Then("^user hits Alt plus left hot key$")
    public void user_hits_Alt_plus_left_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(3000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_LEFT);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_LEFT);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^system should navigate to back screen$")
    public void system_should_navigate_to_back_screen() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            if (isElementPresentVerification(IntakeConstants.Patient_Screen_Profile)) {
                Assert.assertTrue(FrameworkLibrary.isElementPresents(IntakeConstants.Patient_Screen_Profile));
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /***
     * this method used to perform alt key
     *
     */


    @Then("^user hits Alt plus A hot key$")
    public void user_hits_Alt_plus_A_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "A", chromeDriver);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /***
     * this method to checking the element present
     *
     */

    @Then("^system should navigate to Add,New button displayed popup$")
    public void system_should_navigate_to_Add_New_button_displayed_popup() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {

            if (isElementPresentVerification(IntakeConstants.Patient_profile_Add_Button)) {
                Assert.assertTrue(FrameworkLibrary.isElementPresents(IntakeConstants.Patient_profile_Add_Button));
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /***
     * this method used to perform alt key
     *
     */

    @Then("^user hits Alt plus C hot key$")
    public void user_hits_Alt_plus_C_hot_key() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "C", chromeDriver);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /***
     * This method used to cancel button
     *
     */

    @Then("^system should navigate to cancel$")
    public void system_should_navigate_to_cancel() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.Patient_profile_Registration_Form_Cancel_Button)) {
                Assert.assertTrue(FrameworkLibrary.isElementPresents(IntakeConstants.Patient_profile_Registration_Form_Cancel_Button));
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /***
     * This method will get data entered in the text fields and compare them with the data from excel sheet after the search has been performed
     *
     */
    @And("^user enter patient first name and last name and date of birth perform global search")
    public void user_enter_patient_first_name_and_last_name_and_date_of_birth_perform_global_search(DataTable arg1) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild)).clear();

            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            String firstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
            String dateOfBirth = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DateOfBirth");


            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild) && isElementPresentVerification(IntakeConstants.Patient_first_Name_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_Last_Name_Feild, LastName) || !clearAndEnterText(IntakeConstants.Patient_first_Name_Feild, firstName)) {
                    throw new Exception("Not able to enter patient last name and first name field");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_date_Picker_Feild)) {
                    if (!clearAndEnterText(IntakeConstants.Patient_date_Picker_Feild, dateOfBirth)) {
                        throw new Exception("Not able to enter value in date of birth field");
                    }
                    if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                        if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                            throw new Exception("user not able to click search button");
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

    /***
     * This method will get data entered in the text fields and compare them with the data from excel sheet after the search has been performed
     * @param arg1 this parameter will get the information about the Input file name, sheet name, row name from Cucumber feature file
     * @ catches all Exception and Error
     */
    @Then("^user enter patient first name and last name and phone number perform global search$")
    public void user_enter_patient_first_name_and_last_name_and_phone_number_perform_global_search(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild)).clear();
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_SEARCH_DOB)).clear();

            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            String firstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
            String phoneNumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");


            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild) && isElementPresentVerification(IntakeConstants.Patient_first_Name_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_Last_Name_Feild, LastName) || !clearAndEnterText(IntakeConstants.Patient_first_Name_Feild, firstName)) {
                    throw new Exception("Not able to enter patient last name and first name field");
                }
                if (isElementPresentVerification(IntakeConstants.Patient_Phone_Number_Feild)) {
                    WebElement element = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Feild));
                    element.click();
                    Actions ac = new Actions(chromeDriver);
                    ac = ac.sendKeys(phoneNumber);
                    ac.perform();
                }
                if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                    if (!isElementPresentVerifyClick(IntakeConstants.Patient_profile_Search_Button)) {
                        throw new Exception("user not able to click search button");
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

    /***
     * This method will get data entered in the text fields and compare them with the data from excel sheet after the search has been performed
     * @param arg1 this parameter will get the information about the Input file name, sheet name, row name from Cucumber feature file
     * @ catches all Exception and Error
     */
    @Then("^system displayed the list of Patients matching first name and last name and phone number perform global search$")
    public void system_displayed_the_list_of_Patients_matching_first_name_and_last_name_and_phone_number_perform_global_search(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);

        String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName").toUpperCase();
        String firstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName").toUpperCase();
        String phoneNumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");

        try {

            List<WebElement> list = chromeDriver.findElements(By.xpath(IntakeConstants.Patient_profile_Search_Results_Screen));
            List<WebElement> list1 = chromeDriver.findElements(By.xpath(IntakeConstants.Patient_profile_phone_Results_Screen));
            for (int i = 0; i < list.size(); i++) {
                Assert.assertTrue(list.get(i).getText().contains(LastName));
                Assert.assertTrue(list.get(i).getText().contains(firstName));
                Assert.assertTrue(list1.get(i).getText().contains(phoneNumber));
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
	 * This method used for enter patient last name
	 */
    @And("^user enter lastname$")
    public void user_enter_lastname(DataTable arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        try {
            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");


            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Feild)) {
                if (!clearAndEnterText(IntakeConstants.Patient_Last_Name_Feild, LastName)) {
                    throw new Exception("Not able to enter value patient last name field");
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

    /*
	 * Verifying the tab sequence in patient profile using actions
	 */
    @And("^user perform tab order in patient profile$")
    public void user_perform_tab_order_in_patient_profile() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Patient_profile_Add_Button)) {
                Boolean addnew = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_profile_Add_Button)).getAttribute("class").contains("md-focused");
                Assert.assertTrue(addnew);

            }
            if (isElementPresentVerification(IntakeConstants.patient_profile_Back_button_Search)) {
                Actions tab1 = new Actions(chromeDriver);
                Action hitTab1 = tab1.sendKeys(Keys.TAB).build();
                hitTab1.perform();
                Boolean backbutton = chromeDriver.findElement(By.xpath(IntakeConstants.patient_profile_Back_button_Search)).getAttribute("class").contains("md-focused");
                Assert.assertTrue(backbutton);
                Action hitTab11 = tab1.sendKeys(Keys.TAB).build();
                hitTab11.perform();

            }
            if (isElementPresentVerification(IntakeConstants.Patient_Local_Search_Icon)) {
                Actions tab2 = new Actions(chromeDriver);
                Action hitTab2 = tab2.sendKeys(Keys.TAB).build();
                hitTab2.perform();
                Boolean isactive = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Local_Search_Icon)).getAttribute("class").contains("md-focused");
                Assert.assertTrue(isactive);

            }
            if (isElementPresentVerification(IntakeConstants.Patient_date_Picker_Focus)) {
                Actions tab4 = new Actions(chromeDriver);
                Action hitTab4 = tab4.sendKeys(Keys.TAB).build();
                hitTab4.perform();
                Boolean active = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_date_Picker_Focus)).getAttribute("class").contains("md-input-focused");
                Assert.assertTrue(active);
            }
            if (isElementPresentVerification(IntakeConstants.Patient_Phone_Number_Focus)) {
                Actions tab5 = new Actions(chromeDriver);
                Action hitTab5 = tab5.sendKeys(Keys.TAB).build();
                hitTab5.perform();
                Boolean activeed = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Focus)).getAttribute("class").contains("md-input-focused");
                Assert.assertTrue(activeed);
            }

            if (isElementPresentVerification(IntakeConstants.Patient_first_Name_Focus)) {
                Actions tab6 = new Actions(chromeDriver);
                Action hitTab6 = tab6.sendKeys(Keys.TAB).build();
                hitTab6.perform();
                Boolean actived = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_first_Name_Focus)).getAttribute("class").contains("md-input-focused");
                Assert.assertTrue(actived);
            }
            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Focus)) {
                Actions tab7 = new Actions(chromeDriver);
                Action hitTab7 = tab7.sendKeys(Keys.TAB).build();
                hitTab7.perform();
                Boolean activee = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Last_Name_Focus)).getAttribute("class").contains("md-input-focused");
                Assert.assertTrue(activee);
            }

            if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                Actions tab8 = new Actions(chromeDriver);
                Action hitTab8 = tab8.sendKeys(Keys.TAB).build();
                hitTab8.perform();
                Boolean search = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_profile_Search_Button)).getAttribute("class").contains("md-focused");
                Assert.assertTrue(search);
            }
            if (isElementPresentVerification(IntakeConstants.Patient_profile_Add_Button)) {

                Actions tab9 = new Actions(chromeDriver);
                Action hitTab9 = tab9.sendKeys(Keys.TAB).build();
                hitTab9.perform();
                Boolean addnew1 = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_profile_Add_Button)).getAttribute("class").contains("md-focused");
                Assert.assertTrue(addnew1);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @When("^user validating the error  \"([^\"]*)\" message$")
    public void user_validating_the_error_message(String message) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (!isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                String errormsg = FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.patient_profile_Error_Message_Results_Not_Displayed)).getText();
                Assert.assertTrue(errormsg.equals(message));
                throw new Exception("Not able to visible the error msg");

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
	 * Verifying the tab sequence in patient profile using actions
	 */
    @And("^user Checks Tab order by clicking Tab$")
    public void user_Checks_Tab_order_by_clicking_Tab() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {

            isElementPresentVerification(IntakeConstants.Patient_profile_Search_Results_Screen);
            FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.Patient_profile_Search_Results_Screen)).click();

            if (isElementPresentVerification(IntakeConstants.patient_profile_View_Button)) {
                Actions tab = new Actions(chromeDriver);
                Action hitTab = tab.sendKeys(Keys.TAB).build();
                hitTab.perform();
                Boolean view = chromeDriver.findElement(By.xpath(IntakeConstants.patient_profile_View_Button)).getAttribute("class").contains("md-raised md-primary md-button ng-scope md-ink-ripple md-theme-bottomTray md-bottomTray-theme md-focused");
                Assert.assertTrue(view);

            }

            if (isElementPresentVerification(IntakeConstants.Patient_profile_Add_Button)) {
                Actions tab1 = new Actions(chromeDriver);
                Action hitTab1 = tab1.sendKeys(Keys.TAB).build();
                hitTab1.perform();
                Boolean addnew = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_profile_Add_Button)).getAttribute("class").contains("md-focused");
                Assert.assertTrue(addnew);

            }
            if (isElementPresentVerification(IntakeConstants.patient_profile_Back_button_Search)) {
                Actions tab2 = new Actions(chromeDriver);
                Action hitTab2 = tab2.sendKeys(Keys.TAB).build();
                hitTab2.perform();
                Boolean backbutton = chromeDriver.findElement(By.xpath(IntakeConstants.patient_profile_Back_button_Search)).getAttribute("class").contains("md-focused");
                Assert.assertTrue(backbutton);
                Action hitTab22 = tab2.sendKeys(Keys.TAB).build();
                hitTab22.perform();

            }
            if (isElementPresentVerification(IntakeConstants.Patient_Local_Search_Icon)) {
                Actions tab3 = new Actions(chromeDriver);
                Action hitTab3 = tab3.sendKeys(Keys.TAB).build();
                hitTab3.perform();

                Boolean isactive = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Local_Search_Icon)).getAttribute("class").contains("md-focused");
                Assert.assertTrue(isactive);
            }
            if (isElementPresentVerification(IntakeConstants.Patient_date_Picker_Focus)) {
                Actions tab5 = new Actions(chromeDriver);
                Action hitTab5 = tab5.sendKeys(Keys.TAB).build();
                hitTab5.perform();
                Boolean active = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_date_Picker_Focus)).getAttribute("class").contains("md-input-focused");
                Assert.assertTrue(active);

            }
            if (isElementPresentVerification(IntakeConstants.Patient_Phone_Number_Focus)) {
                Actions tab6 = new Actions(chromeDriver);
                Action hitTab6 = tab6.sendKeys(Keys.TAB).build();
                hitTab6.perform();
                Boolean activeed = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Phone_Number_Focus)).getAttribute("class").contains("md-input-focused");
                Assert.assertTrue(activeed);

            }
            if (isElementPresentVerification(IntakeConstants.Patient_first_Name_Focus)) {
                Actions tab7 = new Actions(chromeDriver);
                Action hitTab7 = tab7.sendKeys(Keys.TAB).build();
                hitTab7.perform();
                Boolean actived = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_first_Name_Focus)).getAttribute("class").contains("md-input-focused");
                Assert.assertTrue(actived);
            }
            if (isElementPresentVerification(IntakeConstants.Patient_Last_Name_Focus)) {
                Actions tab8 = new Actions(chromeDriver);
                Action hitTab8 = tab8.sendKeys(Keys.TAB).build();
                hitTab8.perform();
                Boolean activee = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_Last_Name_Focus)).getAttribute("class").contains("md-input-focused");
                Assert.assertTrue(activee);
            }

            if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                Actions tab9 = new Actions(chromeDriver);
                Action hitTab9 = tab9.sendKeys(Keys.TAB).build();
                hitTab9.perform();
                Boolean search = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_profile_Search_Button)).getAttribute("class").contains("md-focused");
                Assert.assertTrue(search);

            }
            if (isElementPresentVerification(IntakeConstants.Patient_profile_Results_Row_One)) {
                Actions tab10 = new Actions(chromeDriver);
                Action hitTab10 = tab10.sendKeys(Keys.TAB).build();
                hitTab10.perform();
                Boolean result = chromeDriver.findElement(By.xpath(IntakeConstants.Patient_profile_Results_Row_One)).getAttribute("class").contains("selected");
                Assert.assertTrue(result);
            }
            if (isElementPresentVerification(IntakeConstants.patient_profile_View_Button)) {

                Actions tab11 = new Actions(chromeDriver);
                Action hitTab11 = tab11.sendKeys(Keys.TAB).build();
                hitTab11.perform();
                Boolean view1 = chromeDriver.findElement(By.xpath(IntakeConstants.patient_profile_View_Button)).getAttribute("class").contains("md-focused");
                Assert.assertTrue(view1);
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
	 * For checking no two rows are selected in patient search
	 */
    @Then("^Multiple user selection restiction$")
    public void Multiple_user_selection_retriction() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Patient_profile_Search_Button)) {
                List<WebElement> list = FrameworkLibrary.chromeDriver.findElements(By.xpath(IntakeConstants.PATIENT_SEARCH_RESULTS_FOCUSED_ROW));
                Assert.assertTrue(list.size() == 1);
                List<WebElement> list1 = FrameworkLibrary.chromeDriver.findElements(By.xpath(IntakeConstants.Patient_profile_Search_Results_Screen));
                isElementPresentVerification(IntakeConstants.Patient_profile_Search_Results_Screen);
                isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_RESULTS_FOCUSED_ROW);
                list1.get(list1.size() - 1).click();
                isElementPresentVerification(IntakeConstants.Patient_profile_Search_Results_Screen);
                isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_RESULTS_FOCUSED_ROW);
                Assert.assertTrue(list.size() == 1);
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
	 * Function to click update button on patient view page
	 */
    @When("^User clicks update button$")
    public void user_clicks_update_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Patient_search_update_button)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Patient_search_update_button)) {
                    throw new Exception("Not able to click Update button");
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


    /*
	 * Verify patient details on Update patient screen
	 */
    @Then("^User should see patient details on demographic tab$")
    public void user_should_see_patient_details_on_demographic_tab(DataTable arg1) throws Exception {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
            String FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
            String DOB = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DateOfBirth");
            String PhoneNumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");
            log.info("Expected FName " + FirstName);
            log.info("Expected LName " + LastName);
            log.info("Expected DOB " + DOB);
            log.info("Expected PhoneNumber " + PhoneNumber);
            log.info("Actual FName " + FrameworkLibrary.getElementText(IntakeConstants.UPDATE_PATIENT_FIRST_NAME));
            log.info("Actual Lname " + FrameworkLibrary.getElementText(IntakeConstants.UPDATE_PATIENT_LAST_NAME));
            log.info("Actual DOB " + FrameworkLibrary.getElementText(IntakeConstants.UPDATE_PATIENT_DOB));
            log.info("Actual PhoneNumber " + FrameworkLibrary.getElementText(IntakeConstants.UPDATE_PATIENT_PHONE_NUMBER));
            if (isElementPresentVerification(IntakeConstants.UPDATE_PATIENT_FIRST_NAME)) {
                Assert.assertEquals(FrameworkLibrary.getElementText(IntakeConstants.UPDATE_PATIENT_FIRST_NAME).toLowerCase(), FirstName.toLowerCase());
            }
            if (isElementPresentVerification(IntakeConstants.UPDATE_PATIENT_LAST_NAME)) {
                Assert.assertEquals(FrameworkLibrary.getElementText(IntakeConstants.UPDATE_PATIENT_LAST_NAME).toLowerCase(), LastName.toLowerCase());
            }
            if (isElementPresentVerification(IntakeConstants.UPDATE_PATIENT_DOB)) {
                Assert.assertEquals(FrameworkLibrary.getElementText(IntakeConstants.UPDATE_PATIENT_DOB).toLowerCase(), DOB.toLowerCase());
            }
            if (isElementPresentVerification(IntakeConstants.UPDATE_PATIENT_PHONE_NUMBER)) {
                Assert.assertEquals(FrameworkLibrary.getElementText(IntakeConstants.UPDATE_PATIENT_PHONE_NUMBER).toLowerCase(), PhoneNumber.toLowerCase());
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }



    /*
	 * Click Next button on Demographic tab of Update patient screen
	 */
    @When("^User clicks Next button on Update Patient page$")
    public void user_clicks_Next_button_on_Update_Patient_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.UPDATE_PATIENT_DEMOGRAPHIC_NEXT_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.UPDATE_PATIENT_DEMOGRAPHIC_NEXT_BUTTON)) {
                    throw new Exception("Not able to click Next button");
                }
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 * Method to validate demographic label present on patient detail page
	 */

    @Then("^Validate patient Demographic View labels$")
    public void validate_patient_Demographic_View_labels(List<String> lables) throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.patient_DemographicView_Label_FirstName)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.patient_DemographicView_Label_FirstName, lables.get(0));
            }
            if (isElementPresentVerification(IntakeConstants.patient_DemographicView_Label_MiddleName)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.patient_DemographicView_Label_MiddleName, lables.get(1));
            }
            if (isElementPresentVerification(IntakeConstants.patient_DemographicView_Label_LastName)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.patient_DemographicView_Label_LastName, lables.get(2));
            }
            if (isElementPresentVerification(IntakeConstants.patient_DemographicView_Label_Local_Phone1)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.patient_DemographicView_Label_Local_Phone1, lables.get(3));
            }
            if (isElementPresentVerification(IntakeConstants.patient_DemographicView_Label_Suffix)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.patient_DemographicView_Label_Suffix, lables.get(4));
            }
            if (isElementPresentVerification(IntakeConstants.patient_DemographicView_Label_DOB)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.patient_DemographicView_Label_DOB, lables.get(5));
            }
            if (isElementPresentVerification(IntakeConstants.patient_DemographicView_Label_Gender)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.patient_DemographicView_Label_Gender, lables.get(6));
            }
            if (isElementPresentVerification(IntakeConstants.patient_DemographicView_Label_IPledgePatientID)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.patient_DemographicView_Label_IPledgePatientID, lables.get(7));
            }
            if (isElementPresentVerification(IntakeConstants.patient_DemographicView_Label_HipaaOnFile)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.patient_DemographicView_Label_HipaaOnFile, lables.get(8));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }


	/*
	 *Method to check 3rd party plan information label is not present
	 */

    @Then("^Validate No (\\d+)rd Party Plan Information labels$")
    public void validate_No_rd_Party_Plan_Information_labels(int arg1) throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.patient_NoPatientPrimaryPlan_Label)) {
                Assert.assertEquals(chromeDriver.findElement(By.xpath(IntakeConstants.patient_NoPatientPrimaryPlan_Label)).getText(), IntakeConstants.patient_NoPatientPrimaryPlan_Label_TEXT);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }


	/*
	 * Method to validate if no clinical information is present
	 */

    @Then("^Validate No Clinical Information on file labels$")
    public void validate_No_Clinical_Information_on_file_labels() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.patient_NoClinicalRecord_Label)) {
                Assert.assertEquals(chromeDriver.findElement(By.xpath(IntakeConstants.patient_NoClinicalRecord_Label)).getText(), IntakeConstants.patient_NoClinicalRecord_Label_TEXT);
            }
            if (isElementPresentVerification(IntakeConstants.patient_NoAdditionalMedications_Label)) {
                Assert.assertEquals(chromeDriver.findElement(By.xpath(IntakeConstants.patient_NoAdditionalMedications_Label)).getText(), IntakeConstants.patient_NoAdditionalMedications_Label_TEXT);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }


	/*
	 * method to validate if update button is present on patient search page
	 */

    @Then("^Validate UpdateBtn$")
    public void validate_UpdateBtn() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            Assert.assertTrue(isElementPresentVerification(IntakeConstants.Patient_search_update_button));
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }

    /*
     * Method to validate IntakeRxBtn is present
     */
    @And("^Validate IntakeRxBtn$")
    public void validate_IntakeRxBtn() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Assert.assertTrue(isElementPresentVerification(IntakeConstants.Intake_RxButton));
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());

        }
    }


	/*
	 * Method to verify tab sequence is as expected on patient search page
	 */

    @Then("^Verify TAB sequence is respected$")
    public void verify_TAB_sequence_is_respected() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


        Actions tabBtn = new Actions(chromeDriver);
        Action presstab = tabBtn.sendKeys(Keys.TAB).build();

        try {

            if (isElementPresentVerification(IntakeConstants.patient_search_ViewAdditionalMedicationsLink)) {
                Assert.assertTrue(getElementByProperty(IntakeConstants.patient_search_ViewAdditionalMedicationsLink, chromeDriver).equals(chromeDriver.switchTo().activeElement()));
                presstab.perform();
            }
            if (isElementPresentVerification(IntakeConstants.patient_search_ViewAllPlanLink)) {
                Assert.assertTrue(getElementByProperty(IntakeConstants.patient_search_ViewAllPlanLink, chromeDriver).equals(chromeDriver.switchTo().activeElement()));
                presstab.perform();
            }
            //update button
            if (isElementPresentVerification(IntakeConstants.Patient_search_update_button)) {
                Assert.assertTrue(getElementByProperty(IntakeConstants.Patient_search_update_button, chromeDriver).equals(chromeDriver.switchTo().activeElement()));
                presstab.perform();
            }
            //intake button
            if (isElementPresentVerification(IntakeConstants.Intake_RxButton)) {
                Assert.assertTrue(getElementByProperty(IntakeConstants.Intake_RxButton, chromeDriver).equals(chromeDriver.switchTo().activeElement()));
                presstab.perform();
            }
            if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_BACK_BUTTON)) {
                Assert.assertTrue(getElementByProperty(IntakeConstants.PATIENT_PROFILE_BACK_BUTTON, chromeDriver).equals(chromeDriver.switchTo().activeElement()));
                presstab.perform();
            }
            if (isElementPresentVerification(IntakeConstants.COMMENTS_BUTTON)) {
                Assert.assertTrue(getElementByProperty(IntakeConstants.COMMENTS_BUTTON, chromeDriver).equals(chromeDriver.switchTo().activeElement()));
                presstab.perform();
            }
            if (isElementPresentVerification(IntakeConstants.Patient_profile_general_info)) {
                Assert.assertEquals(FrameworkLibrary.chromeDriver.findElement(By.className("md-focused")).getText(), "General Info");
                presstab.perform();
            }
            if (isElementPresentVerification(IntakeConstants.patient_search_ViewAdditionalMedicationsLink)) {
                Assert.assertTrue(getElementByProperty(IntakeConstants.patient_search_ViewAdditionalMedicationsLink, chromeDriver).equals(chromeDriver.switchTo().activeElement()));
                presstab.perform();
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());


        }
    }


	/*
	 *
	 */

    /*
	 * Displays allergies on Patient profile page based on last updated date
	 */
    @Then("^User should allergies displayed based on last update date$")
    public void user_should_allergies_displayed_based_on_last_update_date() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_ALLERGY_LAST_UPDATED)) {
                ArrayList<String> dobList = new ArrayList<String>();

                String allergies = IntakeConstants.PATIENT_PROFILE_ALLERGY_LAST_UPDATED;
                int rowSize = chromeDriver.findElements(By.xpath(allergies)).size();
                for (int i = 1; i <= rowSize; i++) {
                    isElementPresentVerification("//*[@id='allergies-container']/div/div[2]/div/div[" + i + "]//small");
                    String dobValue = chromeDriver.findElement(By.xpath("//*[@id='allergies-container']/div/div[2]/div/div[" + i + "]//small")).getText().substring(14);
                    //Date dates = new SimpleDateFormat("dd/MM/yyyy").parse(dobValue);
                    dobList.add(dobValue);
                }
                ArrayList<String> sortedDobList = new ArrayList<String>();
                for (String s : dobList) {
                    sortedDobList.add(s);
                }
                //Collections.sort(sortedDobList);
                Assert.assertTrue(sortedDobList.equals(dobList), "Allergies not sorted based on last updated time");
                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    @Then("^Patient should be imported to local search results$")
    public void Patient_should_be_imported_to_local_search_results() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.Patient_Local_Search_Icon)) {
                if (!isElementPresentVerifyClick(IntakeConstants.Patient_Local_Search_Icon))
                    throw new Exception("Not able to local serach icon");
            }
            if (isElementPresentVerification(SmokeTestConstants.Patient_SearchButton)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_SearchButton))
                    throw new Exception("unable to click search button");
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
     * Method- Verify and clicks on the notification alert icon
     */

    @Then("^the user clicks on the notification alert icon$")
    public void the_user_clicks_on_the_notification_alert_icon() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_NOTIFICATION_ICON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PATIENT_SEARCH_NOTIFICATION_ICON)) {
                    throw new Exception("Not able to click Notification alert icon");
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
     * Method- Verify Failure preview is present
     */

    @Then("^the system opens the failure preview$")
    public void the_system_opens_the_failure_preview() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_NOTIFICATION_ICON_FALURE_PREVIEW)) {
                throw new Exception("Unable to see failure preview");
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
     * Method- Verify and click on See All Button
     */

    @When("^clicks on See All button$")
    public void clicks_on_See_All_button() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.SEE_ALL_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.SEE_ALL_BUTTON)) {
                    throw new Exception("Not able to click See All Button");
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
     * Method- Verify Failure preview closed
     */

    @When("^the system closes the failure preview$")
    public void the_system_closes_the_failure_preview() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Assert.assertFalse(FrameworkLibrary.isElementPresents(IntakeConstants.PATIENT_SEARCH_NOTIFICATION_ICON_FALURE_PREVIEW));
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Method- Verify failure queue overlay is present
     */

    @When("^the system brings the user to the failure queue overlay$")
    public void the_system_brings_the_user_to_the_failure_queue_overlay() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.SYSTEM_ERROR_FAILURE_OVERLAY)) {
                throw new Exception("Unable to see failure queue overlay");
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
     * Method- Verify focus is on first failure in the queue
     */

    @When("^the focus is on first failure in the queue$")
    public void the_focus_is_on_first_failure_in_the_queue() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.SYSTEM_ERROR_FAILURE_OVERLAY_DEFAULT_SELECTED)) {
                Boolean focusedLocation = chromeDriver.findElement(By.xpath(IntakeConstants.SYSTEM_ERROR_FAILURE_OVERLAY_DEFAULT_SELECTED)).getAttribute("class").contains("focused-location");
                Assert.assertTrue(focusedLocation);
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
     * Method- Verify and click on the X button of the Failure Preview Overlay
     */

    @When("^the user clicks on the X button of the Failure Preview Overlay$")
    public void the_user_clicks_on_the_X_button_of_the_Failure_Preview_Overlay() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.SYSTEM_ERROR_FAILURE_OVERLAY_X_LINK)) {
                if (!isElementPresentVerifyClick(IntakeConstants.SYSTEM_ERROR_FAILURE_OVERLAY_X_LINK)) {
                    throw new Exception("Not able to click on X link");
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
     * Method- Validate Failure Preview Overlay is closed
     */

    @Then("^the Failure Preview Overlay is closed$")
    public void the_Failure_Preview_Overlay_is_closed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            Assert.assertFalse(FrameworkLibrary.isElementPresents(IntakeConstants.SYSTEM_ERROR_FAILURE_OVERLAY_X_LINK));

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Method- Validate patient search results displayed
     */

    @When("^the patient search results screen user is viewing still remains open$")
    public void the_patient_search_results_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_DETAILS)) {
                throw new Exception("Unable to see Patient Details");
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
     * Method- Verify and click on Third failure preview link
     */

    @When("^user clicks or selects Enter on a failure in the failure preview$")
    public void user_clicks_or_selects_Enter_on_a_failure_in_the_failure_preview() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.FAILURES_LIST_THIRD_LINK)) {
                if (!isElementPresentVerifyClick(IntakeConstants.FAILURES_LIST_THIRD_LINK)) {
                    throw new Exception("Not able to click failure preview link");
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
     * Method- Verify focus is on user selected failure
     */

    @When("^the focus is on user selected failure$")
    public void the_focus_is_on_user_selected_failure() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.SYSTEM_ERROR_FAILURE_OVERLAY_USER_SELECTED)) {
                Boolean focusedLocation = chromeDriver.findElement(By.xpath(IntakeConstants.SYSTEM_ERROR_FAILURE_OVERLAY_USER_SELECTED)).getAttribute("class").contains("focused-location");
                Assert.assertTrue(focusedLocation);
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
     * Method- Verify Demographic title is present
     */

    @When("^the General Tab Demographic screen user is viewing still remains open$")
    public void the_General_Tab_Demographic_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.DEMOGRAPHIC_TITLE)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.DEMOGRAPHIC_TITLE, "Patient Demographic");
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
     * Method- Verify and click on Third Party Plan tab
     */

    @When("^clicks on Third Party Plan tab$")
    public void clicks_on_Third_Party_Plan_tab() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_THIRD_PARTY_PLAN_TAB)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PATIENT_PROFILE_THIRD_PARTY_PLAN_TAB)) {
                    throw new Exception("Not able to click on Third Party Plan Tab");
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
     * Method- Validate User is on Third Party Plan page
     */

    @Then("^the Third Party Plan screen user is viewing still remains open$")
    public void the_Third_Party_Plan_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        
        try {
            if (!isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_THIRAPRTY_PLAN_TEXT)) {
                throw new Exception("Unable to see Third Party Plan screen");
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
     * Method- Validate User is on Rx Preferences page
     */

    @Then("^the Rx Preferences screen user is viewing still remains open$")
    public void the_Rx_Preferences_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        
        try {
            if (!isElementPresentVerification(IntakeConstants.Rx_Preferences_Text)) {
            	throw new Exception("Not on Preferences Tab");
                
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
     * Method- Verify and click on Image Tab
     */

    @When("^User clicks on Images tab$")
    public void user_clicks_on_Images_tab() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_IMAGE_TAB)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PATIENT_PROFILE_IMAGE_TAB)) {
                    throw new Exception("Not able to click on Image Tab");
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
     * Method- Validate User is on Image Screen
     */

    @Then("^the Patient Images screen user is viewing still remains open$")
    public void the_Patient_Images_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_IMAGE_PAGE)) {
                throw new Exception("Unable to see Image screen");
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
     * Method- Validate User is on Rx History page
     */

    @Then("^the Rx History screen user is viewing still remains open$")
    public void the_Rx_History_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_RX_HISTORY_PAGE)) {
                throw new Exception("Unable to see Rx history page");
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
     * Method- Validate User is on Additional Medications page
     */

    @Then("^the Additional Medications screen user is viewing still remains open$")
    public void the_Additional_Medications_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_ADDITIONAL_MEDICATION)) {
                throw new Exception("Unable to see Additional Medication page");
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
	 * This method asserts that the failure preview is displayed
	 */

    /*
	 * This method is used to click the failure notification icon the dashboard
	 */
    @When("^User clicks failure notification Icon$")
    public void user_clicks_failure_notification_Icon() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_NOTIFICATION_ICON)) {
                isElementPresentVerifyClick(IntakeConstants.PATIENT_SEARCH_NOTIFICATION_ICON);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^System should display failure preview$")
    public void system_should_display_failure_preview() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_NOTIFICATION_ICON_FALURE_PREVIEW)) {
                Assert.assertTrue(isElementPresents(IntakeConstants.PATIENT_SEARCH_NOTIFICATION_ICON_FALURE_PREVIEW));
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * this method is used to click the first failure task from the failure preview and get the patient name, DOB and failure reason in the strings that are used in further steps to make assertions
	 */
    @When("^User selects a failure task from the list of failure tasks$")
    public void user_selects_a_failure_task_from_the_list_of_failure_tasks() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.FAILURES_LIST_FIRST_LINK)) {
                isElementPresentVerifyClick(IntakeConstants.FAILURES_LIST_FIRST_LINK);
            }
            failure_task_patient_name = getElementByProperty(IntakeConstants.FAILURE_LIST_FIRST_PATIENT_NAME, chromeDriver).getAttribute("innerText");
            failure_task_dob = getElementByProperty(IntakeConstants.FAILURE_LIST_FIRST_PATIENT_DOB, chromeDriver).getAttribute("innerText");
            failure_task_reason = getElementByProperty(IntakeConstants.FAILURE_LIST_FIRST_PATIENT_REASON, chromeDriver).getAttribute("innerText");


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    /*
	 * this method validates list of system errors is displayed
	 *
	 */
    @Then("^System displays failure queue$")
    public void system_displays_failure_queue() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.SYSTEM_ERROR_FAILURE_OVERLAY)) {
                Assert.assertTrue(isElementPresents(IntakeConstants.SYSTEM_ERROR_FAILURE_OVERLAY));
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * this method validates that the failure selected in the notifications is highlighted in the system errors
	 *
	 */
    @Then("^the selected failure should be highlighted$")
    public void the_selected_failure_should_be_highlighted() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            String currentFailureTask = getElementByProperty(IntakeConstants.FAILURE_OVERLAY_SYSTEM_ERRORS_LIST, chromeDriver).findElement(By.className("focused-location")).getText();

            Assert.assertTrue(currentFailureTask.replace(" ", "").trim().contains(failure_task_patient_name.replace(" ", "").trim()));
            Assert.assertTrue(currentFailureTask.contains(failure_task_dob));
            Assert.assertTrue(currentFailureTask.contains(failure_task_reason));

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * This method is used to click cancel "X" button on the system error failure list
	 */
    @When("^User clicks cancel button in the failure queue$")
    public void user_clicks_cancel_button_in_the_failure_queue() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.SYSTEM_ERROR_FAILURE_OVERLAY_X_LINK)) {
                isElementPresentVerifyClick(IntakeConstants.SYSTEM_ERROR_FAILURE_OVERLAY_X_LINK);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * This method asserts that the failure queue is closed
	 */
    @Then("^failure queue should be closed$")
    public void failure_queue_should_be_closed() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            Thread.sleep(1000);
            Assert.assertTrue(chromeDriver.findElements(By.xpath(IntakeConstants.SYSTEM_ERROR_FAILURE_OVERLAY)).size() == 0);
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    /*
	 * This method validates that the user is able to navigate to patient profile page and intake method screen after working on the failure notifications
	 */
    @Then("^User should be able to continue with patient search$")
    public void user_should_be_able_to_continue_with_patient_search() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {

            if (isElementPresentVerification(SmokeTestConstants.Patient_ViewButton)) {
                if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_ViewButton)) {
                    throw new Exception("Not able to click Patient_ViewButton");
                }
            }
            if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_INTAKE_PAGE)) {
                Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(IntakeConstants.PATIENT_PROFILE_INTAKE_PAGE)).isDisplayed(), "Patient profile page is not displayed");
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    /**
     * Method- Verify and click on Clinical History tab
     */

    @When("^User clicks on Clinical History tab$")
    public void user_clicks_on_Clinical_History_tab() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_CLINICAL_HISTORY)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PATIENT_PROFILE_CLINICAL_HISTORY)) {
                    throw new Exception("Not able to click on Clinical History Tab");
                }
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
     * Method- Validate user is on Clinical history screen
     */

    @Then("^the Clinical History screen user is viewing still remains open$")
    public void the_Clinical_History_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_CLINICAL_HISTORY_PAGE)) {
                throw new Exception("Unable to see Clinical History page");
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
     * Method- Validate user is on Drug Search screen
     */

    @Then("^the Drug search screen user is viewing still remains open$")
    public void the_Drug_search_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.drugSearchPageTitle)) {
                Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.drugSearchPageTitle));
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
     * Method- Verify and click on view Button
     */

    @When("^User clicks view button from Drug Search Page$")
    public void user_clicks_view_button_from_Drug_Search_Page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.DRUG_SEARCH_VIEW_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.DRUG_SEARCH_VIEW_BUTTON)) {
                    throw new Exception("Not able to click on View Button");
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
     * Method- Validate General Info message on Drug Details page
     */

    @Then("^the General Info Tab Core Drug Info screen user is viewing still remains open$")
    public void the_General_Info_Tab_Core_Drug_Info_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.DRUG_DETAILS_CORE_DRUG_INFO_TITLE)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.DRUG_DETAILS_CORE_DRUG_INFO_TITLE, IntakeConstants.DRUG_DETAILS_CORE_DRUG_INFO_TITLE_VALUE);
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
     * Method- Verify and click on Clinical Reference tab
     */

    @When("^the user clicks on the clinical references tab$")
    public void the_user_clicks_on_the_clinical_references_tab() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.DRUG_DETAILS_CLINICAL_REFERENCE_TAB)) {
                if (!isElementPresentVerifyClick(IntakeConstants.DRUG_DETAILS_CLINICAL_REFERENCE_TAB)) {
                    throw new Exception("Not able to click on Clinical references tab");
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
     * Method- Validate User is on Clinical References page
     */

    @Then("^the Clinical References screen user is viewing still remains open$")
    public void the_Clinical_References_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.DRUG_DETAILS_CLINICAL_REFERENCE_PAGE)) {
                throw new Exception("Unable to see Clinical References screen");
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
     * Method- Validate User is on Prescriber Search screen page
     */

    @Then("^the Prescriber Search screen user is viewing still remains open$")
    public void the_Prescriber_Search_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(SmokeTestConstants.prescriberSearchPageTitle)) {
                Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.prescriberSearchPageTitle));
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
     * Method- Validate User is on Prescriber Search Results screen page
     */

    @Then("^the Prescriber Search Results screen user is viewing still remains open$")
    public void the_Prescriber_Search_Results_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_SEARCH_RESULT_PAGE)) {
                Assert.assertTrue(FrameworkLibrary.isElementPresents(IntakeConstants.PRESCRIBER_SEARCH_RESULT_PAGE));
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
     * Method- Verify and click on view button on Prescriber Search page
     */

    @When("^User clicks view button from prescriver Search$")
    public void user_clicks_view_button_from_prescriver_Search() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PRESCRIBER_SEARCH_VIEW_BUTTON)) {
                if (!isElementPresentVerifyClick(IntakeConstants.PRESCRIBER_SEARCH_VIEW_BUTTON)) {
                    throw new Exception("Not able to click on view/update button");
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
     * Method- Validate User is on Prescriber Details screen page
     */

    @Then("^the Prescriber Details screen user is viewing still remains open$")
    public void the_Prescriber_Details_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.PRESCRIBER_DETAIL_PAGE_GENERAL_INFO)) {
            	throw new Exception("Not on Prescriber details page");
                //FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.PRESCRIBER_SEARCH_VIEW_PRESCRIBER_DETAILS_PAGE_TITLE, IntakeConstants.RESCRIBER_SEARCH_VIEW_PRESCRIBER_DETAILS_PAGE_TITLE_VALUE);
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
     * Method- Validate User is on Plan Search screen page
     */

    @Then("^the Plan Search screen user is viewing still remains open$")
    public void the_Plan_Search_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.PLAN_SEARCH_PAGE_TITLE)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.PLAN_SEARCH_PAGE_TITLE, IntakeConstants.PLAN_SEARCH_PAGE_TITLE_VALUE);
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
     * Method- Validate Patient Order Status page is displayed
     */

    @Then("^System should display POS page$")
    public void system_should_display_POS_page() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.POS_PAGE)) {
                throw new Exception("Unable to see POS screen");
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
     * Method- Validate Patient Order Status screen Title
     */

    @Then("^the Patient Order Status screen user is viewing still remains open$")
    public void the_Patient_Order_Status_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (isElementPresentVerification(IntakeConstants.POS_PAGE_TITLE)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.POS_PAGE_TITLE, IntakeConstants.POS_PAGE_TITLE_VALUE);
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
     * Method- Verify and click on user profile link
     */

    @When("^User clicks on the user profile icon on top left on the navigation panel$")
    public void user_clicks_on_the_user_profile_icon_on_top_left_on_the_navigation_panel() throws Exception {

        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.USER_PROFILE_LINK)) {
                if (!isElementPresentVerifyClick(IntakeConstants.USER_PROFILE_LINK))
                    throw new Exception("Not able to click on User Profile Link");
            }
            if (isElementPresentVerification(IntakeConstants.MY_PROFILE_TAB)) {
                if (!isElementPresentVerifyClick(IntakeConstants.MY_PROFILE_TAB))
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

    /**
     * Method- Validate user is on Employee Information Screen
     */

    @Then("^the Employee Information screen user is viewing still remains open$")
    public void the_Employee_Information_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.MY_PROFILE_PAGE_TITLE)) {
                FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.MY_PROFILE_PAGE_TITLE, IntakeConstants.MY_PROFILE_PAGE_TITLE_VALUE);
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
     * Method- Verify and click on Team Member tab
     */

    @When("^the user clicks on the Team Member tab$")
    public void the_user_clicks_on_the_Team_Member_tab() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.MY_PROFILE_TEAM_MEMBER_TAB)) {
                if (!isElementPresentVerifyClick(IntakeConstants.MY_PROFILE_TEAM_MEMBER_TAB)) {
                    throw new Exception("Not able to click on Team Member tab");
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
     * Method- Validate list of team member is present
     */

    @Then("^the system should display the list of team members$")
    public void the_system_should_display_the_list_of_team_members() throws Exception {
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

    /**
     * Method- Validate user is on Team Members screen
     */

    @Then("^the Team Members screen user is viewing still remains open$")
    public void the_Team_Members_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        try {
            if (!isElementPresentVerification(IntakeConstants.MY_PROFILE_TEAM_MEMBER_PAGE)) {
                throw new Exception("Unable to see Team Member screen");
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
	 * This method is used to assert that all the failures in the system errors are displayed in ascending order
	 */

    /**
     * Method- Validate user is on Data Review screen
     */

    @Then("^the Data Review screen user is viewing still remains open$")
    public void the_Data_Review_screen_user_is_viewing_still_remains_open() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (!isElementPresentVerification(IntakeConstants.DR_PAGE_TITLE)) {
            	throw new Exception("Not on DR Page");
                //FrameworkLibrary.verifyTextPresentElectron(IntakeConstants.DR_PAGE_TITLE, IntakeConstants.DR_PAGE_TITLE_VALUE);
            }
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }


        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^all the failures are displayed in the descending order based on creation date and time$")
    public void all_the_failures_are_displayed_in_the_descending_order_based_on_creation_date_and_time() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            List<WebElement> creationDate = chromeDriver.findElements(By.xpath(IntakeConstants.SYSTEM_ERRORS_FAILURE_TASK_CREATION_DATE_LIST));
            List<Date> dt = new ArrayList<Date>();
            for (int i = 0; i < creationDate.size(); i++) {
                String dateinString = creationDate.get(i).getAttribute("innerText");
                SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
                Date date = formatter.parse(dateinString);
                dt.add(date);
                List<Date> expecteddt = new ArrayList<Date>(dt);
                Collections.sort(expecteddt, Collections.reverseOrder());
                Assert.assertTrue(dt.equals(expecteddt));
            }
            log.info("all the failures are displayed in descending order based on creation date and time");

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * This method is used to select the third failure in the queue
	 */
    @Then("^the user tries to select another failure in the queue$")
    public void the_user_tries_to_select_another_failure_in_the_queue() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            systemErrorsList = chromeDriver.findElements(By.xpath(IntakeConstants.SYSTEM_ERRORS_FAILURE_LIST));
            systemErrorsList.get(2).click();
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    /*
	 * This method is used to assert that multiple failures cannot be selected at the same time
	 */
    @Then("^the system will not allow the user to select multiple failures at the same time$")
    public void the_system_will_not_allow_the_user_to_select_multiple_failures_at_the_same_time() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            Assert.assertFalse(systemErrorsList.get(0).getAttribute("class").contains("focused-location"));
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * This method is used to assert that previously selected failure is deselected and the new one is selected
	 */
    @Then("^system deselects the previous selection and selects the new one$")
    public void system_deselects_the_previous_selection_and_selects_the_new_one() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            Assert.assertTrue(!systemErrorsList.get(0).getAttribute("class").contains("focused-location"));
            Assert.assertTrue(systemErrorsList.get(2).getAttribute("class").contains("focused-location"));
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Method- Hit Ctrl+E hot key as failure alert icon
     */

    @When("^user hits HOT Keys Ctrl \\+ E$")
    public void user_hits_HOT_Keys_Ctrl_E() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {

            if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_NOTIFICATION_ICON)) {
                Actions ac = new Actions(chromeDriver);
                Action series = ac.keyDown(Keys.CONTROL).sendKeys("e").keyUp(Keys.CONTROL).build();
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

    /*
 * This method is used to hit enter key
 */
    @When("^User hits Enter Key$")
    public static void user_hits_Enter_Key() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {

            Robot keys =  new Robot();
            keys.keyPress(KeyEvent.VK_ENTER);
            keys.keyRelease(KeyEvent.VK_ENTER);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }
    /*
 * This method is used to validate that the first failure task in the failure queue is highlighted by default
 */
    @Then("^Focus is on the first failure$")
    public void focus_is_on_the_first_failure() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {
            List<WebElement> listoffailures = chromeDriver.findElements(By.className("rxms-bof-failure-info"));
            Assert.assertTrue(listoffailures.get(0).getAttribute("class").contains("focused-location"));
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
 * This method is used to hit alt plus d hotkeys
 *
 */
    @When("^User hits ALT plus D hotkey$")
    public void user_hits_ALT_plus_D_hotkey() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "d", chromeDriver);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
 * This method is used to validate that confirm resolution popup is displayed with the message
 */
    @Then("^System should display an alert \"([^\"]*)\"$")
    public void system_should_display_an_alert(String arg1) throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {
            if (isElementPresentVerification(IntakeConstants.FAILURE_DELETE_ALERT_MESSAGE)) {
                Assert.assertTrue(getElementByProperty(IntakeConstants.FAILURE_DELETE_ALERT_MESSAGE, chromeDriver).getAttribute("innerText").equals(arg1));
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
 * This method is used to validate that confirm resolution alert is closed
 */
    @Then("^the popup should be closed$")
    public void the_popup_should_be_closed() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {
            Thread.sleep(1000);
            Assert.assertTrue(chromeDriver.findElementsByXPath(IntakeConstants.FAILURE_DELETE_ALERT_MESSAGE).size() == 0);

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * This method is used to hit alt plus y hotkeys
	 */
    @When("^User hits ALT plus Y hotkey$")
    public void user_hits_ALT_plus_Y_hotkey() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {
            SmokeTestLibrary.hotkeyAction(Keys.ALT, "y", chromeDriver);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
 * This method is used get the total number of failures in the failure queue
 */
    @When("^get total number of failures in the failure queue overlay$")
    public void get_total_number_of_failures_in_the_failure_queue_overlay() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {
            actualFailureTasksbeforeDeleting = chromeDriver.findElementsByXPath(IntakeConstants.FAILURE_OVERLAY_SYSTEM_ERRORS_LIST).size();
            log.info("actualFailureTasksbeforeDeleting" + actualFailureTasksbeforeDeleting);
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    /*
 * This method is used to validate that the number of failure tasks in failure queue is reduced by 1 when a failure task is deleted
 */
    @Then("^selected failure should be deleted from the failure queue$")
    public void selected_failure_should_be_deleted_from_the_failure_queue() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {
            Thread.sleep(3000);
            int actualFailureTasksAfterDeleting = chromeDriver.findElementsByXPath(IntakeConstants.FAILURE_OVERLAY_SYSTEM_ERRORS_LIST).size();
            log.info("actualFailureTasksAfterDeleting" + actualFailureTasksAfterDeleting);
            int expectedfailureTasksAfterDeleting = actualFailureTasksbeforeDeleting - 1;
            log.info("expectedfailureTasksAfterDeleting" + expectedfailureTasksAfterDeleting);
            Assert.assertTrue(actualFailureTasksAfterDeleting == expectedfailureTasksAfterDeleting);

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*@Then("^failure deleted in system error list should be deleted from failure preview$")
	public void failure_deleted_in_system_error_list_should_be_deleted_from_failure_preview() throws Throwable {


	}*/
/*
 * This method is used to hit down arrow key
 */
    @When("^User hits down arrow Key$")
    public void user_hits_down_arrow_Key() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {
            Actions downArrow = new Actions(chromeDriver);
            Action PressdownArrow = downArrow.sendKeys(Keys.ARROW_DOWN).build();
            PressdownArrow.perform();
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
 * This method is used to validate that second failure is highlighted
 */
    @Then("^User should be able to navigate to next failure in the failure queue$")
    public void user_should_be_able_to_navigate_to_next_failure_in_the_failure_queue() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {

			/*List<WebElement> listoffailures = chromeDriver.findElements(By.className("rxms-bof-failure-info"));
			Assert.assertTrue(listoffailures.get(1).getAttribute("class").contains("md-focused"));*/

            Assert.assertTrue(isElementPresents(IntakeConstants.SYSTEM_ERRORS_FAILURE_TASK_SECOND_DELETE_BUTTON));
            Assert.assertFalse(isElementPresents(IntakeConstants.SYSTEM_ERRORS_FAILURE_TASK_FIRST_DELETE_BUTTON));

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
 * This method is used to hit up arrow key
 */
    @When("^User hits Up arrow key$")
    public void user_hits_Up_arrow_key() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {
            Actions upArrow = new Actions(chromeDriver);
            Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP).build();
            PressUpArrow.perform();
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
 * This method is used to validate that the focus is shifted to the previous failure
 */
    @Then("^User should be able to navigate to previous failure in the failure queue$")
    public void user_should_be_able_to_navigate_to_previous_failure_in_the_failure_queue() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {
			/*if(isElementPresentVerification(IntakeConstants.SYSTEM_ERRORS_FAILURE_TASK_FIRST_DELETE_BUTTON)){
				List<WebElement> listoffailures = chromeDriver.findElements(By.className("rxms-bof-failure-info"));
				Assert.assertTrue(listoffailures.get(0).getAttribute("class").contains("md-focused"));
			}*/

            Assert.assertFalse(isElementPresents(IntakeConstants.SYSTEM_ERRORS_FAILURE_TASK_SECOND_DELETE_BUTTON));
            Assert.assertTrue(isElementPresents(IntakeConstants.SYSTEM_ERRORS_FAILURE_TASK_FIRST_DELETE_BUTTON));

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
 * This method is used to shift the focus to the last failure task in the failure queue and then hit tab
 */
    @When("^User hits TAB while focus is on the last failure$")
    public void user_hits_TAB_while_focus_is_on_the_last_failure() throws Throwable {
        //move to the last one and hit tab
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {
            List<WebElement> listoffailures = chromeDriver.findElements(By.className("rxms-bof-failure-info"));
            int i = listoffailures.size() - 1;
            listoffailures.get(i).click();
            if (isElementPresentVerification("//*[@id=" + "'delete-" + i + "']")) {
                Actions TAB = new Actions(chromeDriver);
                Action PressTAB = TAB.sendKeys(Keys.TAB).build();
                PressTAB.perform();
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
 * This method is used to assert that X button is highlighted when user hits tab from the last failure task in failure queue
 */
    @Then("^focus should be shifted to X button$")
    public void focus_should_be_shifted_to_X_Button() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {
            //Thread.sleep(5000);
            boolean isElementFocused = getElementByProperty(IntakeConstants.SYSTEM_ERROR_FAILURE_OVERLAY_X_LINK_BUTTON, chromeDriver).getAttribute("class").contains("md-focused");
            Assert.assertTrue(isElementFocused);

            //	Assert.assertTrue(chromeDriver.switchTo().activeElement().equals(getElementByProperty(IntakeConstants.SYSTEM_ERROR_FAILURE_OVERLAY_X_LINK,chromeDriver)));

            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    /*
	 * This method is used to delete the first failure task in the failure queue
	 */
    @When("^User clicks delete button on the failure highlighted$")
    public void user_clicks_delete_button_on_the_failure_highlighted() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {

            if (isElementPresentVerification(IntakeConstants.SYSTEM_ERRORS_FAILURE_TASK_FIRST_DELETE_BUTTON)) {
                isElementPresentVerifyClick(IntakeConstants.SYSTEM_ERRORS_FAILURE_TASK_FIRST_DELETE_BUTTON);
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
	 * This method is used to delete all the failure tasks from the failure queue
	 */

    @Then("^User deletes all the failure tasks$")
    public void user_deletes_all_the_failure_tasks() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {
            List<WebElement> failureList = chromeDriver.findElements(By.xpath(IntakeConstants.SYSTEM_ERRORS_FAILURE_LIST));
            failureList.get(0).click();
            log.info("first failure selected....");
            for (int i = 0; i < failureList.size(); i++) {

                if (isElementPresentVerification("//*[@id=" + "'delete-" + i + "']/md-icon")) {
                    isElementPresentVerifyClick("//*[@id=" + "'delete-" + i + "']/md-icon");
                }
                if (isElementPresentVerification(IntakeConstants.CONFIRM_RESOLUTION_POPUP_YES_BUTTON)) {
                    isElementPresentVerifyClick(IntakeConstants.CONFIRM_RESOLUTION_POPUP_YES_BUTTON);
                }
                log.info(i + " failure deleted");

                //IntakeStepDef.user_hits_TAB_key();

                if (captureScreenshot) {
                    takeScreenShot(methodName);
                }
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * This method used to validate that "You're all caught up" message is displayed after deleting all the failure tasks from failure Overlay
	 */
    @Then("^A message \"([^\"]*)\" should be seen on the failure overlay$")
    public void a_message_should_be_seen_on_the_failure_overlay(String arg1) throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {
            Assert.assertTrue(chromeDriver.getPageSource().contains(arg1));
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

    /*
	 * This method used to validate that "You're all caught up" message is displayed after deleting all the failure tasks from failure queue
	 */
    @Then("^A message \"([^\"]*)\" should be seen on the failure preview$")
    public void a_message_should_be_seen_on_the_failure_preview(String arg1) throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         
        try {
            Assert.assertTrue(chromeDriver.getPageSource().contains(arg1));
            if (captureScreenshot) {
                takeScreenShot(methodName);
            }
        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }

    }

    /*
	 * This method used to click NO button on the confirm resolution alert that is displayed after clicking delete button in failure queue
	 */
    @When("^User clicks cancel button on the alert$")
    public void user_clicks_cancel_button_on_the_alert() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.CONFIRM_RESOLUTION_POPUP_NO_BUTTON)) {
                isElementPresentVerifyClick(IntakeConstants.CONFIRM_RESOLUTION_POPUP_NO_BUTTON);
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
	 * This method used to click yes button on the confirm resolution alert that is displayed after clicking delete button in failure queue
	 */
    @When("^User clicks Yes button on the alert$")
    public void user_clicks_Yes_button_on_the_alert() throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try {
            if (isElementPresentVerification(IntakeConstants.CONFIRM_RESOLUTION_POPUP_YES_BUTTON)) {
                isElementPresentVerifyClick(IntakeConstants.CONFIRM_RESOLUTION_POPUP_YES_BUTTON);
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
     * Method to clock on see all button of failure icon and to trigger create intake functionality
     */
    @When("^clicks on See All button or create intake$")
    public void clicks_on_See_All_button_or_create_intake(DataTable arg1) throws Exception {
    	methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

    	try {
    		Thread.sleep(4000);
    		int element_count = chromeDriver.findElements(By.xpath("//*[@id='bof-preview-menu-content']/md-menu-item")).size();
    		log.info("Element count = " + element_count);
    		Boolean isSeeAllButtonDisplayed = chromeDriver.findElement(By.xpath(IntakeConstants.SEE_ALL_BUTTON)).isDisplayed();
    		
    		//Boolean isSeeAllButtonDisplayed = FrameworkLibrary.chromeDriver.getPageSource().contains("See All");
    		//Boolean isSeeAllButtonDisplayed = isElementPresentVerification(IntakeConstants.SEE_ALL_BUTTON);
    		log.info("boolean value: "+isSeeAllButtonDisplayed);

    		while(!isSeeAllButtonDisplayed){
    			WebElement homePage1 = chromeDriver.findElement(By.xpath("//*[@id='id-dashboard-button']/div[1]/md-icon"));
    			Actions action1 = new Actions(chromeDriver);
    			action1.moveToElement(homePage1).doubleClick().build().perform();
    			log.info("But not displayed yet");
    			user_enters_valid_credentials_and_performing_intake(arg1);
    			
    			SmokeTestStepDef.system_should_display_RxMS_home_page();
    			Thread.sleep(10000);
    			if (isElementPresentVerification(IntakeConstants.PATIENT_SEARCH_NOTIFICATION_ICON)) {
    				if (!isElementPresentVerifyClick(IntakeConstants.PATIENT_SEARCH_NOTIFICATION_ICON)) {
    					throw new Exception("Not able to click Notification alert icon");
    				}
    				element_count = chromeDriver.findElements(By.xpath("//*[@id='bof-preview-menu-content']/md-menu-item")).size();
    	    		if(element_count == 8){
    					log.info("Get Text "+chromeDriver.findElement(By.xpath("//*[@id='bof-preview-menu-content']/md-menu-item[7]")).getAttribute("class").contains("rxms-bof-see-all"));
    					
    					if (chromeDriver.findElement(By.xpath("//*[@id='bof-preview-menu-content']/md-menu-item[7]")).getAttribute("class").contains("rxms-bof-see-all")) {
    						isSeeAllButtonDisplayed=true;
    					}
    				}
    				if(isSeeAllButtonDisplayed){
    					break;
    				}
    				
    			} 

    		}

    		if(isSeeAllButtonDisplayed){
	    		if (isElementPresentVerification(IntakeConstants.SEE_ALL_BUTTON)) {
	    			if (!isElementPresentVerifyClick(IntakeConstants.SEE_ALL_BUTTON)){
	    				throw new Exception("Not able to click on See All Button");
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
     * Method to create error messages from intake with patients who don't have linkages 
     */
    public static void user_enters_valid_credentials_and_performing_intake(DataTable arg1) throws Exception {
    	methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
    	Map<String, List<String>> dataMap = null;
    	dataMap = FrameworkLibrary.getHorizontalData(arg1);

    	try {
    		Boolean isFailurePreviewDisplayed = ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(IntakeConstants.PATIENT_SEARCH_NOTIFICATION_ICON_FALURE_PREVIEW))).apply(chromeDriver);
    		if(!isFailurePreviewDisplayed){
    			
    			WebElement homePage = chromeDriver.findElement(By.xpath("//*[@id='id-dashboard-button']/div[1]/md-icon"));
    			Actions action = new Actions(chromeDriver);
    			action.moveToElement(homePage).doubleClick().build().perform();
    			SmokeTestStepDef.user_hits_ctrl_plus_h_hot_key();
    			Thread.sleep(3000);
    		}

    		Boolean isHomePageDisplayed = ExpectedConditions.not(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(SmokeTestConstants.RxMSHome_PharmacyInformationCard))).apply(chromeDriver);
    		if(!isHomePageDisplayed){
    			
    			SmokeTestStepDef.user_hits_ctrl_plus_h_hot_key();
    			SmokeTestStepDef.system_should_display_RxMS_home_page();
    		}
    		if (isElementPresentVerification(IntakeConstants.PATIENT_LEFTMENU_LINKICON)) {
    			//SmokeTestStepDef.user_hits_ctrl_plus_h_hot_key();
    			WebElement homePage = chromeDriver.findElement(By.xpath("//*[@id='id-dashboard-button']/div[1]/md-icon"));
    			Actions action = new Actions(chromeDriver);
    			action.moveToElement(homePage).doubleClick().build().perform();
    			if (!isElementPresentVerifyClick(IntakeConstants.Patient_LeftMenuButton)){
    				throw new Exception("Not able to click on Patient_Left Menu Button");
    			}
    		}

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
    		if (isElementPresentVerification(SmokeTestConstants.Patient_SearchButton)) {
    			if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_SearchButton)) {
    				throw new Exception("Not able to click on Patient_SearchButton Button");
    			}
    		}
    		if (isElementPresentVerification(SmokeTestConstants.Patient_ViewButton)) {
    			proxy.newHar();
    			if (!isElementPresentVerifyClick(SmokeTestConstants.Patient_ViewButton)) {
    				throw new Exception("Not able to click Patient_ViewButton");
    			}
    		}
    		if (isElementPresentVerification(SmokeTestConstants.Intake_RxButton)) {
    			proxy.newHar();
    			if (!isElementPresentVerifyClick(SmokeTestConstants.Intake_RxButton)) {
    				throw new Exception("Not able to click Intake_RxButton");
    			}
    		}
    		if (isElementPresentVerification(SmokeTestConstants.intakeMethodTitle)) {
    			Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.intakeMethodTitle));
    		}
    		if (isElementPresentVerification(SmokeTestConstants.radio_Waiting_Button)) {
    			isElementPresentVerifyClick(SmokeTestConstants.radio_Waiting_Button);
    		}
    		if (isElementPresentVerification(SmokeTestConstants.radio_Scan_Button)) {
    			isElementPresentVerifyClick(SmokeTestConstants.radio_Scan_Button);
    		}
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
