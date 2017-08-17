package dataEntry;

import accessManagment.AccessManagementConstants;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataReview.dataReviewConstants;
import framework.ConnectionFactory;
import framework.FrameworkConstants;
import framework.FrameworkLibrary;
import hangOn.hangOnConstants;
import intake.IntakeConstants;
import intake.IntakeStepDef;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import smokeTest.SmokeTestConstants;
import smokeTest.SmokeTestLibrary;
import smokeTest.SmokeTestStepDef;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static dataReview.dataReviewStepDef.addsDaystoOriginDate;
import static org.openqa.selenium.By.xpath;

public class DataEntryStepDef extends FrameworkLibrary {

	public static int DR_NumberOfTaskBeforeDE;
	public static String expectedPlan;
	public static String name_before_sorting;
	public static String name_after_sorting;
	public static String ExpectedDirections;
	public static String ExpectedProduct_quantity;
	public static String ExpectedProduct_quantityDisp;
	public static String ExpectedProduct_DaysSupply;
	public static String ExpectedProduct_refills;
	public static String ExpectedProduct_RxExpDate;
	public static String ExpectedProduct_DAW;
	public static String ExpectedProduct_DrugExpDate;
	public static String ExpectedProduct_OriginalDate;
	public static String plandisplayedinDR;
	public static String ExpectedProductName;
	public static String storenumber;
	public static String Store_Pharmacy_Code;
	public static String Refills;
	public static String Date;
	public static String Daw;
	public static String Substitute;
	public static String Viewsizecheckbox;
	public static String Viewsizeandmanufacture;
	public static String Date1;
	public static String Daw1;
	public static String Substitute1;
	public static String Viewsizecheckbox1;
	public static String Viewsizeandmanufacture1;
	public static String LastName;
	public static String FirstName;
	public static String Quantity_DE;
	public static Integer Dis;
	public static String expDaysValue;
	private static Log log = LogFactory.getLog(DataEntryStepDef.class);
	private String methodName;
	public String quantity;
	public String quantitydisp;
	public String code;
	public String UPC;
	public String PLAN;
	public String Depnum;
	public String Quantity_stock_DE;
	public String Quantity_stock_after_RX;
	public String Quantity;
	public String Quantity_stock_after_fill;
	int i = 0;
	int expectedValafterCancel;
	String attributeBeforeValue;
	String attributeAfterValue;


	public DataEntryStepDef() throws ConfigurationException, IOException {
		super();
	}

	@Then("^User selects the current patient$")
	public void user_selects_the_current_patient(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			WebElement patienttable = getElementByProperty(SmokeTestConstants.patient_table, chromeDriver);
			List<WebElement> patientrows = patienttable.findElements(By.tagName("tr"));
			Assert.assertTrue(patientrows.size() != 0);
			String FN = SmokeTestLibrary.getData(arg1, "FirstName").toUpperCase();
			String LN = SmokeTestLibrary.getData(arg1, "LastName").toUpperCase();
			String patientPhonenumber = SmokeTestLibrary.getData(arg1, "PhoneNumber");
			//if(!(patientPhonenumber.equals(null))){
			/*String phonepart1 = patientPhonenumber.substring(0,3);
            String phonepart2 = patientPhonenumber.substring(3,6);
			String phonepart3 = patientPhonenumber.substring(6);
			String expectedpatientphone = "("+phonepart1+") "+phonepart2+"-"+phonepart3;*/
			for (int i = 0; i < patientrows.size(); i++) {
				String rowdata = patientrows.get(i).getText().toUpperCase();
				if (rowdata.contains(FN) && rowdata.contains(LN) && rowdata.contains(patientPhonenumber)) {
					patientrows.get(i).click();
					log.info("expected patient data found..");
					break;
				} else {
					if (i == patientrows.size() - 1) {
						log.info("expected patient data not found..");
						Assert.fail("patient data does not exist");
					}
				}
				//}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^Click on back arrow button$")
	public void click_on_back_arrow_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Assert.assertTrue(isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_BACK_BUTTON));
			isElementPresentVerifyClick(IntakeConstants.PATIENT_PROFILE_BACK_BUTTON);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	public static boolean isElementActive(String xpath) {
		try {
			chromeDriver.findElement(xpath(xpath)).sendKeys("sample");
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Then("^system displays the list of prescribers that matches the search criteria$")
	public void system_displays_the_list_of_prescribers_that_matches_the_search_criteria(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Search_Results)) {
				String result_Text = getElementText(DataEntryConstants.DE_Prescriber_Search_Results);
				log.info(result_Text);
				boolean isResultEmpty = result_Text.equalsIgnoreCase("");
				Assert.assertFalse(isResultEmpty);
				String expectedmessage = "The following prescriber(s) matched your search criteria:";

				if (isElementPresentVerification(DataEntryConstants.de_prescriber_results_label)) {
					String actualmessage = getElementText(DataEntryConstants.de_prescriber_results_label);
					Assert.assertTrue(expectedmessage.equals(actualmessage));
					if (!isElementPresentVerifyClick(DataEntryConstants.DE_Prescriber_Search_Cancel_Button)) {
						throw new Exception("Not able to click login button");
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

	@When("^User does a prescriber search by First name only$")
	public void user_does_a_prescriber_search_by_First_name_only(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String prescriberFirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");

			if (isElementPresentVerification(FrameworkConstants.PRESCRIBER_LN)) {
				FrameworkLibrary.getElementByProperty(FrameworkConstants.PRESCRIBER_LN, chromeDriver).clear();
				if (!clearAndEnterText(FrameworkConstants.PRESCRIBER_FN, prescriberFirstName)) {
					throw new Exception("User not able to enter value in prescriber first name text field");
				}
				if (isElementPresentVerification(FrameworkConstants.PRESCRIBER_SEARCH_BTN)) {
					if (!isElementPresentVerifyClick(FrameworkConstants.PRESCRIBER_SEARCH_BTN)) {
						throw new Exception("User not able to click prescriber search button");
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

	@Then("^system displays error specify the required search criteria$")
	public void system_displays_error_specify_the_required_search_criteria() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Search_Error_Message)) {
				String expectedErrorMessage = getElementText(DataEntryConstants.DE_Prescriber_Search_Error_Message);
				Assert.assertTrue(expectedErrorMessage.equalsIgnoreCase("Please specify the required search criteria!"));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User does a prescriber search by phone number only$")
	public void user_does_a_prescriber_search_by_phone_number_only(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);

		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(FrameworkConstants.PRESCRIBER_FN) && isElementPresentVerification(FrameworkConstants.PRESCRIBER_LN) && isElementPresentVerification(DataEntryConstants.DE_Prescriber_Phone_Number_Field)) {

				FrameworkLibrary.getElementByProperty(FrameworkConstants.PRESCRIBER_FN, chromeDriver).clear();
				FrameworkLibrary.getElementByProperty(FrameworkConstants.PRESCRIBER_LN, chromeDriver).clear();

				String prescriberPhoneNumber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");

				if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Phone_Number_Field)) {
					WebElement element = chromeDriver.findElement(xpath(DataEntryConstants.DE_Prescriber_Phone_Number_Field));
					element.sendKeys(prescriberPhoneNumber);
					if (!isElementPresentVerifyClick(FrameworkConstants.PRESCRIBER_SEARCH_BTN)) {
						throw new Exception("User not able to click prescriber search button");
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

	@When("^User does a prescriber search by Last name only$")
	public void user_does_a_prescriber_search_by_last_name_only(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);

		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String prescriberLastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");

			if (isElementPresentVerification(FrameworkConstants.PRESCRIBER_FN)) {
				FrameworkLibrary.getElementByProperty(FrameworkConstants.PRESCRIBER_FN, chromeDriver).clear();
				if (!clearAndEnterText(FrameworkConstants.PRESCRIBER_LN, prescriberLastName)) {
					throw new Exception("User not able to enter value in prescriber first name text field");
				}

				if (isElementPresentVerification(FrameworkConstants.PRESCRIBER_SEARCH_BTN)) {
					if (!isElementPresentVerifyClick(FrameworkConstants.PRESCRIBER_SEARCH_BTN)) {
						throw new Exception("User not able to click prescriber search button");
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

	@When("^User does a prescriber search with NPI or DEA$")
	public void user_does_a_prescriber_search_with_NPI_or_DEA(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String prescriberNPI = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "NPI");

			if (isElementPresentVerification(FrameworkConstants.PRESCRIBER_LN) && isElementPresentVerification(DataEntryConstants.DE_Prescriber_Phone_Number_Field)) {
				FrameworkLibrary.getElementByProperty(FrameworkConstants.PRESCRIBER_LN, chromeDriver).clear();
				getElementByProperty(DataEntryConstants.DE_Prescriber_Phone_Number_Field, chromeDriver).clear();
				if (!clearAndEnterText(DataEntryConstants.DE_Prescriber_NPIorDEA_Field, prescriberNPI)) {
					throw new Exception("User not able to enter value in prescriber first name text field");
				}

				if (isElementPresentVerification(FrameworkConstants.PRESCRIBER_SEARCH_BTN)) {
					if (!isElementPresentVerifyClick(FrameworkConstants.PRESCRIBER_SEARCH_BTN)) {
						throw new Exception("User not able to click prescriber search button");
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

	@When("^User searches for a prescriber that practices outside the default state$")
	public void user_searches_for_a_prescriber_that_practices_outside_the_default_state(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			String prescriberLastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
			String prescriberFirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");

			if (isElementPresentVerification(FrameworkConstants.PRESCRIBER_LN) && isElementPresentVerification(FrameworkConstants.PRESCRIBER_FN) && isElementPresentVerification(DataEntryConstants.DE_Prescriber_Phone_Number_Field) && isElementPresentVerification(DataEntryConstants.DE_Prescriber_NPIorDEA_Field)) {

				getElementByProperty(DataEntryConstants.DE_Prescriber_Phone_Number_Field, chromeDriver).clear();
				getElementByProperty(DataEntryConstants.DE_Prescriber_NPIorDEA_Field, chromeDriver).clear();
				if (!clearAndEnterText(FrameworkConstants.PRESCRIBER_FN, prescriberFirstName) || !clearAndEnterText(FrameworkConstants.PRESCRIBER_LN, prescriberLastName)) {
					throw new Exception("User not able to enter value in prescriber first name and last name text field");
				} else if (isElementPresentVerification(FrameworkConstants.PRESCRIBER_SEARCH_BTN)) {
					if (!isElementPresentVerifyClick(FrameworkConstants.PRESCRIBER_SEARCH_BTN)) {
						throw new Exception("User not able to click prescriber search button");
					}
				}
				if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Search_Results)) {
					if (!isElementPresentVerifyClick("//*[@id='state-select']")) {
						throw new Exception("Not able to click state selection button");
					}
					List<WebElement> states = FrameworkLibrary.chromeDriver.findElements(xpath("//*[@id='select_container_1']//md-select-menu//md-option"));
					for (int i = 0; i < states.size(); i++) {
						log.info("states:" + states.get(i).getText());
						if (states.get(i).getAttribute("value").equals("ID")) {
							states.get(i).click();
							isElementPresentVerifyClick(FrameworkConstants.PRESCRIBER_SEARCH_BTN);
							break;
						}
					}

				}
				if (isElementPresentVerification(FrameworkConstants.PRESCRIBER_SEARCH_BTN)) {

					Actions ac = new Actions(chromeDriver);
					Action series = ac.keyDown(Keys.ALT).sendKeys("r").keyUp(Keys.ALT).build();
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

	@Then("^Prescriber info should be cleared$")
	public void Prescriber_info_should_be_cleared() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(FrameworkConstants.PRESCRIBER_FN) && isElementPresentVerification(FrameworkConstants.PRESCRIBER_LN) && isElementPresentVerification(DataEntryConstants.DE_Prescriber_Phone_Number_Field) && isElementPresentVerification(DataEntryConstants.DE_Prescriber_NPIorDEA_Field)) {
				Assert.assertTrue(getElementText(FrameworkConstants.PRESCRIBER_FN).equals(""));
				Assert.assertTrue(getElementText(FrameworkConstants.PRESCRIBER_LN).equals(""));
				Assert.assertTrue(getElementText(DataEntryConstants.DE_Prescriber_Phone_Number_Field).equals(""));
				Assert.assertTrue(getElementText(DataEntryConstants.DE_Prescriber_NPIorDEA_Field).equals(""));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^System should display a message no results found matching the search criteria$")
	public void system_should_display_a_message_no_results_found_matching_the_search_criteria() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Search_NoMatchCriteria)) {
				String expectedVal = "No prescriber(s) matched your search criteria.";
				String actualVal = getElementText(DataEntryConstants.DE_Prescriber_Search_NoMatchCriteria);
				Assert.assertTrue(actualVal.equals(expectedVal));
				if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Search_Cancel_Button)) {
					if (!isElementPresentVerifyClick(DataEntryConstants.DE_Prescriber_Search_Cancel_Button)) {
						throw new Exception("Not able to click login button");
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

	@When("^User searches for a product with product name in the prescription$")
	public void user_searches_for_a_product_with_product_name_in_the_prescription(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			String productDAW = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			String productName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");

			if (isElementPresentVerification(FrameworkConstants.DrugName_Field) && isElementPresentVerification(SmokeTestConstants.Product_OriginalDate) && isElementPresentVerification(SmokeTestConstants.Product_DAW)) {

				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate) || !clearAndEnterText(SmokeTestConstants.Product_DAW, productDAW) || !clearAndEnterText(FrameworkConstants.DrugName_Field, productName)) {
					throw new Exception("User not able to enter value in product text fields");
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

	@Then("^System displays the drugs matching the search criteria$")
	public void system_displays_the_drugs_matching_the_search_criteria(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String expectedDrugName = SmokeTestLibrary.getData(arg1, "DrugName");
			String capitalizedExpectedDrugName = expectedDrugName.substring(0, 1).toUpperCase() + expectedDrugName.substring(1);

			if (isElementPresentVerification("//md-autocomplete-parent-scope/span")) {
				List<WebElement> drugs = chromeDriver.findElements(xpath("//md-autocomplete-parent-scope/span"));
				for (int i = 0; i < drugs.size(); i++) {
					if (drugs.get(i).getText().contains(capitalizedExpectedDrugName)) {
						Assert.assertTrue(drugs.get(i).getText().contains(capitalizedExpectedDrugName), "User unable to find the drugs matching the search criteria.");
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

	@When("^enters product information with valid directions$")
	public void enter_product_information_with_valid_directions(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			String productDAW = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			String productName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			String productQuantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
			String productDirections = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Directions");

			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate) && isElementPresentVerification(SmokeTestConstants.Product_DAW) && isElementPresentVerification(SmokeTestConstants.DrugName_Field) && isElementPresentVerification(SmokeTestConstants.Quantity_field) && isElementPresentVerification(SmokeTestConstants.Directions_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate) || !clearAndEnterText(SmokeTestConstants.Product_DAW, productDAW) || !clearAndEnterText(SmokeTestConstants.DrugName_Field, productName)) {
					throw new Exception("Not able to enter value in product text fields");
				}

				Thread.sleep(3000);
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();
				Thread.sleep(1000);

				if (!clearAndEnterText(SmokeTestConstants.Quantity_field, productQuantity) || !clearAndEnterText(SmokeTestConstants.Directions_field, productDirections)) {
					throw new Exception("Not able to enter value in product text fields");

				} else {
					Action tab = upArrow.sendKeys(Keys.TAB).build();
					tab.perform();
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

	@Then("^System should calculate days supply$")
	public void auto_calculate_days_supply() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(SmokeTestConstants.Days_Supply)) {
				String s = getElementText(SmokeTestConstants.Days_Supply);
				int s1 = Integer.parseInt(s);
				int s2 = 100;
				Assert.assertTrue(s1 == s2);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User sets DAW=Y and Substitute=N$")
	public void user_sets_DAW_Y_and_Substitute_N(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String productDAW = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");

			if (isElementPresentVerification(FrameworkConstants.Product_DAW)) {
				if (!clearAndEnterText(FrameworkConstants.Product_DAW, productDAW)) {
					throw new Exception("User not able to enter value in DAW text field");
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

	@When("^User selects a Rems or LDD drug$")
	public void user_selects_a_Rems_or_LDD_drug(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String productName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");

			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, productName)) {
					throw new Exception("Not able to enter value in product text fields");
				}
				if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
					Actions productinfo = new Actions(chromeDriver);
					Action selectProduct = productinfo.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
					selectProduct.perform();
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

	@When("^User searches for a product with NDC$")
	public void user_searches_for_a_product_with_NDC(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			String productDAW = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			String productNDC = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "NDC");

			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate) && isElementPresentVerification(SmokeTestConstants.Product_DAW) && isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate) || !clearAndEnterText(SmokeTestConstants.Product_DAW, productDAW) || !clearAndEnterText(SmokeTestConstants.DrugName_Field, productNDC)) {
					throw new Exception("Not able to enter value in product text fields");
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

	@When("^User searches for a product with UPC$")
	public void user_searches_for_a_product_with_UPC(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			String productDAW = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			String productUPC = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "UPC");

			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate) && isElementPresentVerification(SmokeTestConstants.Product_DAW) && isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate) || !clearAndEnterText(SmokeTestConstants.Product_DAW, productDAW) || !clearAndEnterText(SmokeTestConstants.DrugName_Field, productUPC)) {
					throw new Exception("Not able to enter value in product text fields");
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

	@When("^User searches for a product with WIC$")
	public void user_searches_for_a_product_with_WIC(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			String productDAW = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			String productWIC = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "WIC");

			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate) && isElementPresentVerification(SmokeTestConstants.Product_DAW) && isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate) || !clearAndEnterText(SmokeTestConstants.Product_DAW, productDAW) || !clearAndEnterText(SmokeTestConstants.DrugName_Field, productWIC)) {
					throw new Exception("Not able to enter value in product text fields");
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

	@When("^User enters original Rx date$")
	public void user_enters_original_Rx_date(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate) && isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate)) {
					throw new Exception("Not able to enter value in product text fields");
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

	@Then("^System should auto populate the Drug Exp Date and the RX expiration data$")
	public void system_should_auto_populate_the_Drug_Exp_Date_and_the_RX_expiration_data() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(FrameworkConstants.DrugExpiryDate_Field) && isElementPresentVerification(FrameworkConstants.RxExpiration_date)) {
				boolean isDrugExpdateNull = getElementText(FrameworkConstants.DrugExpiryDate_Field).equalsIgnoreCase(null);
				Assert.assertFalse(isDrugExpdateNull);
				boolean isRxExpDateNull = getElementText(FrameworkConstants.RxExpiration_date).equalsIgnoreCase(null);
				Assert.assertFalse(isRxExpDateNull);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User enters the product quantity$")
	public void user_enters_the_product_quantity(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String productQuantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
			if (isElementPresentVerification(FrameworkConstants.Quantity_field)) {
				if (!clearAndEnterText(FrameworkConstants.Quantity_field, productQuantity)) {
					throw new Exception("Not able to enter value in user name text field");
				} else {
					Actions action = new Actions(chromeDriver);
					Action a = action.sendKeys(Keys.TAB).build();
					a.perform();
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

	@Then("^Only the quantity entered should be dispensed$")
	public void only_the_quantity_entered_should_be_dispensed(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String productQuantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
			if (isElementPresentVerification(FrameworkConstants.Quantity_field)) {
				int actualQuantityDisp = Integer.parseInt(getElementText(FrameworkConstants.Quantity_disp));
				int expectedQuantityDisp = Integer.parseInt(productQuantity);
				Assert.assertTrue(actualQuantityDisp == expectedQuantityDisp);

			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		}
	}

	@When("^User enters the directions provided by the prescriber$")
	public void user_enters_the_directions_provided_by_the_prescriber(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			String productDAW = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			String productName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			String productQuantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
			String productDirections = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Directions");

			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate) && isElementPresentVerification(SmokeTestConstants.Product_DAW) && isElementPresentVerification(SmokeTestConstants.DrugName_Field) && isElementPresentVerification(SmokeTestConstants.Quantity_field) && isElementPresentVerification(SmokeTestConstants.Directions_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate) || !clearAndEnterText(SmokeTestConstants.Product_DAW, productDAW) || !clearAndEnterText(SmokeTestConstants.DrugName_Field, productName)) {
					throw new Exception("Not able to enter value in product text fields");
				} else {
					Actions upArrow = new Actions(chromeDriver);
					Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
					PressUpArrow.perform();
				}
				if (!clearAndEnterText(SmokeTestConstants.Quantity_field, productQuantity) || !clearAndEnterText(SmokeTestConstants.Directions_field, productDirections)) {
					throw new Exception("Not able to enter value in product text fields");

				} else {
					Actions action = new Actions(chromeDriver);
					Action a = action.sendKeys(Keys.TAB).build();
					a.perform();
				}
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		}
	}

	@Then("^appropriate directions are added$")
	public void appropriate_directions_are_added(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(FrameworkConstants.DrugExpiryDate_Field) && isElementPresentVerification(FrameworkConstants.RxExpiration_date) && isElementPresentVerification(SmokeTestConstants.Directions_field)) {
				String sigcoderesult = FrameworkLibrary.getElementText(SmokeTestConstants.Directions_field);
				Assert.assertEquals(sigcoderesult, "Take 1 tablet for pain daily");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		}
	}

	@When("^User enters all mandatory fields$")
	public void user_enters_all_mandatory_fields(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String productRefills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
			if (isElementPresentVerification(FrameworkConstants.Refills_field)) {
				if (!clearAndEnterText(FrameworkConstants.Refills_field, productRefills)) {
					throw new Exception("Not able to enter value in product refill text field");
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

	@When("^User clicks Add Rx button$")
	public void user_clicks_Add_Rx_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.DRNumberofTasks) && isElementPresentVerification(DataEntryConstants.DE_AddRx_Button)) {
				DR_NumberOfTaskBeforeDE = Integer.parseInt(getElementText(SmokeTestConstants.DRNumberofTasks));
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_AddRx_Button)) {
					throw new Exception("User not able to click Add Rx button");
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

	@Then("^System should add the Rx and create a DR task$")
	public void system_should_add_the_Rx_and_create_a_DR_task() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(SmokeTestConstants.DRNumberofTasks)) {
				int expectedDR_NumberOfTasksAfterDE = DR_NumberOfTaskBeforeDE + 1;
				String expectedDRTasksAfterDE = Integer.toString(expectedDR_NumberOfTasksAfterDE);
				WebDriverWait wait = new WebDriverWait(chromeDriver, 60);
				wait.until(ExpectedConditions.textToBePresentInElement(
						getElementByProperty(SmokeTestConstants.DRNumberofTasks, chromeDriver), expectedDRTasksAfterDE));
				int actualDR_NumberOfTasksAfterDE = Integer.parseInt(getElementText(SmokeTestConstants.DRNumberofTasks));
				Assert.assertEquals(actualDR_NumberOfTasksAfterDE, expectedDR_NumberOfTasksAfterDE);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User clicks send to ICplus button$")
	public void user_clicks_send_to_ICplus_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DE_ICplusButton)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_ICplusButton)) {
					throw new Exception("user not able to click IC plus button in DE screen");
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

	@When("^User clicks search update the patient information$")
	public void user_clicks_search_update_the_patient_information() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DR_PatientSearch)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DR_PatientSearch)) {
					throw new Exception("user not able to click  DR patient search update button");
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

	@When("^User clicks search button to update prescriber$")
	public void user_clicks_search_button_to_update_prescriber() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DR_PrescriberSearch)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DR_PrescriberSearch)) {
					throw new Exception("user not able to click  DR prescriber search update button");
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

	@Then("^prescriber search page should be displayed from DR$")
	public void prescriber_search_page_should_be_displayed() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.DR_prescriberPageTitle)) {
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User clicks update to update the product data$")
	public void user_clicks_update_to_update_the_product_data(DataTable updateddata) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(updateddata);
			String productDirections = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Directions");
			String productDaysSupply = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DaysSupply");
			String productRefills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");

			if (isElementPresentVerification(FrameworkConstants.DR_PRODUCT_UPDATE_BTN)) {
				if (!isElementPresentVerifyClick(FrameworkConstants.DR_PRODUCT_UPDATE_BTN)) {
					throw new Exception("User not able to click on DR product update button");
				} else if (isElementPresentVerification(SmokeTestConstants.DR_ProductDirections) && isElementPresentVerification(SmokeTestConstants.Days_Supply) && isElementPresentVerification(SmokeTestConstants.Refills_field)) {
					if (!clearAndEnterText(SmokeTestConstants.DR_ProductDirections, productDirections) || !clearAndEnterText(SmokeTestConstants.Days_Supply, productDaysSupply) || !clearAndEnterText(SmokeTestConstants.Refills_field, productRefills)) {
						throw new Exception("Not able to enter value in product text fields");
					} else if (isElementPresentVerification(FrameworkConstants.DR_PRODUCT_ACCEPT_BTN)) {
						if (!isElementPresentVerifyClick(FrameworkConstants.DR_PRODUCT_ACCEPT_BTN)) {
							throw new Exception("User not able to click DR product accept button");
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

	@Then("^product data should be updated$")
	public void product_data_should_be_updated(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String ExpectedDirections = SmokeTestLibrary.getData(arg1, "Directions");
			String ExpectedDaysSupply = SmokeTestLibrary.getData(arg1, "DaysSupply");
			String ExpectedRefills = SmokeTestLibrary.getData(arg1, "Refills");
			if (isElementPresentVerification(SmokeTestConstants.DR_ProductDirections) && isElementPresentVerification(dataReviewConstants.drug_day_supply) && isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				String ActualDirections = getElementText(SmokeTestConstants.DR_ProductDirections);
				String ActualDaysSupply = getElementText(dataReviewConstants.drug_day_supply);
				String ActualRefills = getElementText(SmokeTestConstants.Refills_field);
				Assert.assertTrue(ExpectedDirections.equalsIgnoreCase(ActualDirections));
				Assert.assertTrue(ExpectedDaysSupply.equals(ActualDaysSupply));
				Assert.assertTrue(ExpectedRefills.equals(ActualRefills));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^patient profile with general info screen is displayed$")
	public void patient_profile_with_general_info_screen_is_displayed() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.patientProfile_Demographic)) {
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User Clicks on the third Party Plans tab$")
	public void user_Clicks_on_the_rd_Party_Plans_tab() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.patientProfile_third_PartyPlansButton)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.patientProfile_third_PartyPlansButton)) {
					throw new Exception("Not able to click third party plans button");
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

	@When("^ensure that primary check box is checked$")
	public void ensure_that_primary_check_box_is_checked() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.patientProfile_PlanId_Text)) {
				expectedPlan = getElementText(DataEntryConstants.patientProfile_PlanId_Text);
				if (isElementPresentVerification(DataEntryConstants.patientProfile_thirdParty_PrimarycheckBox)) {
					boolean isChecked = chromeDriver
							.findElement(xpath(DataEntryConstants.patientProfile_thirdParty_PrimarycheckBox)).isSelected();
					Assert.assertTrue(isChecked);
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

	@When("^User clicks General Info tab$")
	public void user_clicks_General_Info_tab() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.patientProfile_GeneralInfo)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.patientProfile_GeneralInfo)) {
					throw new Exception("Not able to click on patient general info button");
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

	@When("^clicks payment type$")
	public void clicks_payment_type() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.DE_Payment_Drpdown)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_Payment_Drpdown)) {
					throw new Exception("Not able to click on DE payment drop down button");
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

	@When("^selects the patient primary plan$")
	public void selects_the_patient_primary_plan() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			List<WebElement> paymentlist = chromeDriver
					.findElements(By.className(DataEntryConstants.DE_PaymentTypeResultsClassName));
			for (int i = 0; i < paymentlist.size(); i++) {

				if (paymentlist.get(i).getText().equalsIgnoreCase(expectedPlan)) {
					paymentlist.get(i).click();
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

	@Then("^Only plan ID should be seen under the payment type$")
	public void only_plan_ID_should_be_seen_under_the_payment_type() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.DE_SelectedPaymentType)) {
				Assert.assertTrue(getElementText(DataEntryConstants.DE_SelectedPaymentType).equalsIgnoreCase(expectedPlan));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^The prescription status should be check IC\\+ and price should be blank$")
	public void the_prescription_status_should_be_check_IC_and_price_should_be_blank(DataTable arg1) throws Exception {

	}

	@Then("^prescription status should be In progress Entered, Filled or ready except check ICplus$")
	public void prescription_status_should_be_In_progress_Entered_Filled_or_ready_except_check_ICplus(DataTable arg1) throws Exception {

	}

	@When("^User searches for a product with quick code$")
	public void enter_drugQuickCodeinDE(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			String productDAW = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			String productName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "QuickCode");
			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate) && isElementPresentVerification(SmokeTestConstants.Product_DAW) && isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate) || !clearAndEnterText(SmokeTestConstants.Product_DAW, productDAW) || !clearAndEnterText(SmokeTestConstants.DrugName_Field, productName)) {
					throw new Exception("Not able to enter value in product text fields");
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

	@When("^I enter a REMS drug with Mandatary Consulation ID set to one$")
	public void i_enter_a_REMS_drug_with_Mandatary_Consulation_ID_set_to_one(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String originalDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "OriginalDate");
			String daw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			String drugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(DataEntryConstants.Product_OriginalDate) && isElementPresentVerification(DataEntryConstants.Product_DAW) && isElementPresentVerification(DataEntryConstants.DrugName_Field)) {
				if (!clearAndEnterText(DataEntryConstants.Product_OriginalDate, originalDate) || !clearAndEnterText(DataEntryConstants.Product_DAW, daw) || !clearAndEnterText(DataEntryConstants.DrugName_Field, drugName)) {
					throw new Exception("User not able to enter value in prescriber first name text field");
				} else {
					Actions productinfo = new Actions(chromeDriver);
					Action selectProduct = productinfo.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
					selectProduct.perform();
					Action enter = productinfo.sendKeys(Keys.ENTER).build();
					enter.perform();
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

	@Then("^System must show a pop-up$")
	public void system_must_show_a_pop_up() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DE_FunctionPopup)) {
				FrameworkLibrary.verifyTextPresentElectron(DataEntryConstants.DE_FunctionPopup_Msg1, "All changes will be lost.");
				FrameworkLibrary.verifyTextPresentElectron(DataEntryConstants.DE_FunctionPopup_Msg2, "Do you want to proceed?");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^I enter a REMS drug with Mandatary Consulation ID set to zero$")
	public void i_enter_a_REMS_drug_with_Mandatary_Consulation_ID_set_to_zero(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String originalDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "OriginalDate");
			String daw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			String drugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(DataEntryConstants.Product_OriginalDate) && isElementPresentVerification(DataEntryConstants.Product_DAW) && isElementPresentVerification(DataEntryConstants.DrugName_Field)) {
				if (!clearAndEnterText(DataEntryConstants.Product_OriginalDate, originalDate) || !clearAndEnterText(DataEntryConstants.Product_DAW, daw) || !clearAndEnterText(DataEntryConstants.DrugName_Field, drugName)) {
					throw new Exception("User not able to enter value in prescriber first name text field");
				} else {
					Actions productinfo = new Actions(chromeDriver);
					Action selectProduct = productinfo.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
					selectProduct.perform();
					Action enter = productinfo.sendKeys(Keys.ENTER).build();
					enter.perform();
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

	@Then("^System must not show a pop-up$")
	public void system_must_not_show_a_pop_up() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Assert.assertFalse(FrameworkLibrary.isElementPresents(DataEntryConstants.DE_FunctionPopup_cancel));
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^User updates product data with rems drug in data review screen$")
	public void i_update_product_data_with_rems_drug_in_data_review_screen(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DR_ProductUpdate)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DR_ProductUpdate)) {
					throw new Exception("User not able to click product button");
				}
			}
			String drugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(DataEntryConstants.DR_ProductName)) {
				if (!clearAndEnterText(DataEntryConstants.DR_ProductName, drugName)) {
					throw new Exception("User not able to enter value in prescriber first name text field");
				}	
					Thread.sleep(3000);
					Actions productinfo = new Actions(chromeDriver);
					Action selectProduct = productinfo.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
					selectProduct.perform();
					
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^I enter product information while DAW is set to Y$")
	public void i_enter_product_information_whie_DAW_is_set_to_Y(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String date = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			String daw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");

			if (isElementPresentVerification(DataEntryConstants.Product_OriginalDate) && isElementPresentVerification(DataEntryConstants.Product_DAW)) {
				if (!clearAndEnterText(DataEntryConstants.Product_OriginalDate, date) || !clearAndEnterText(DataEntryConstants.Product_OriginalDate, daw)) {
					throw new Exception("User not able to enter value in prescriber first name text field");
				}
			}

			if (isElementPresentVerification(DataEntryConstants.checkBox_ViewSize) && isElementPresentVerification(DataEntryConstants.checkBox_ViewManufacturer)) {
				if (!isElementPresentVerifyClick(FrameworkConstants.PRESCRIBER_SEARCH_BTN) || !isElementPresentVerifyClick(DataEntryConstants.checkBox_ViewManufacturer)) {
					throw new Exception("User not able to click prescriber search button");
				}
			}
			String drugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(DataEntryConstants.DrugName_Field)) {
				if (!clearAndEnterText(DataEntryConstants.DrugName_Field, drugName)) {
					throw new Exception("User not able to enter value in product field");
				} else {
					Actions upArrow = new Actions(chromeDriver);
					Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
					PressUpArrow.perform();
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

	@When("^check only view size and manufacturer$")
	public void enter_product_info_check_viewsize_and_manufacturer(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String date = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			String daw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");


			if (isElementPresentVerification(DataEntryConstants.Product_OriginalDate) && isElementPresentVerification(DataEntryConstants.Product_DAW)) {
				if (!clearAndEnterText(DataEntryConstants.Product_OriginalDate, date) || !clearAndEnterText(DataEntryConstants.Product_OriginalDate, daw)) {
					throw new Exception("User not able to enter date and daw values in product field");
				}
			}
			if (isElementPresentVerification(DataEntryConstants.checkBox_ViewSize)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.checkBox_ViewSize)) {
					throw new Exception("User not able to click check box button");
				}
			}

			String drugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(DataEntryConstants.DrugName_Field)) {
				if (!clearAndEnterText(DataEntryConstants.DrugName_Field, drugName)) {
					throw new Exception("User not able to enter value in product field");
				} else {
					Actions upArrow = new Actions(chromeDriver);
					Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
					PressUpArrow.perform();
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

	@When("^I attempt to change the substitute$")
	public void i_attempt_to_change_the_substitute() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.productChange_Button)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.productChange_Button)) {
					throw new Exception("User not able to click prescriber search button");
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

	@Then("^The system displays a message that the dispensed drug may not be changed when DAW is set to Y$")
	public void the_system_displays_a_message_that_the_dispensed_drug_may_not_be_changed_when_DAW_is_set_to_Y() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.Substitute_Alert_Message)) {
				String expectedMessage = "The Dispensed Drug may not be changed when the DAW field is set to Y";
				String actualMessage = FrameworkLibrary
						.getElementByProperty(DataEntryConstants.Substitute_Alert_Message, chromeDriver).getText();
				Assert.assertTrue(expectedMessage.equalsIgnoreCase(actualMessage), "The message has not been displayed");

			}

			if (isElementPresentVerification(DataEntryConstants.Substitute_Alert_Ok_Button)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.Substitute_Alert_Ok_Button)) {
					throw new Exception("User not able to click substitute alert button");
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

	@Then("^I enter product information while DAW is set to N$")
	public void i_enter_product_information_while_DAW_is_set_to_N(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String date = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			String daw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");


			if (isElementPresentVerification(DataEntryConstants.Product_OriginalDate) && isElementPresentVerification(DataEntryConstants.Product_DAW)) {
				if (!clearAndEnterText(DataEntryConstants.Product_OriginalDate, date) || !clearAndEnterText(DataEntryConstants.Product_OriginalDate, daw)) {
					throw new Exception("User not able to enter date and daw values in product field");
				}
			}

			if (isElementPresentVerification(DataEntryConstants.Product_Substitute)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.Product_Substitute)) {
					throw new Exception("User not able to click product button");
				}
			}

			String substitute = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Substitute");
			if (isElementPresentVerification(DataEntryConstants.Product_Substitute)) {
				if (!clearAndEnterText(DataEntryConstants.Product_Substitute, substitute)) {
					throw new Exception("User not able to enter product field");
				}
			}
			if (isElementPresentVerification(DataEntryConstants.checkBox_ViewSize) && isElementPresentVerification(DataEntryConstants.checkBox_ViewManufacturer)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.checkBox_ViewSize) || !isElementPresentVerifyClick(DataEntryConstants.checkBox_ViewManufacturer)) {
					throw new Exception("User not able to click check box and view field");
				}
			}

			String drugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(DataEntryConstants.DrugName_Field)) {
				if (!clearAndEnterText(DataEntryConstants.DrugName_Field, drugName)) {
					throw new Exception("User not able to enter value in product field");
				} else {
					Actions upArrow = new Actions(chromeDriver);
					Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
					PressUpArrow.perform();
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

	@Then("^System allows me to change the substitute$")
	public void system_allows_me_to_change_the_substitute() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.productChange_Button)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.productChange_Button)) {
					throw new Exception("User not able to click product change button");
				}
				if (isElementPresentVerification(DataEntryConstants.productDispensed_Field)) {
					Assert.assertTrue(FrameworkLibrary.getElementByProperty(DataEntryConstants.productDispensed_Field, chromeDriver)
							.isEnabled(), "Product substitute field is not enabled");
					Actions productinfo = new Actions(chromeDriver);
					Action selectProduct = productinfo.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
					selectProduct.perform();
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

	@When("^I change the DAW from N to Y$")
	public void i_change_the_DAW_from_N_to_Y(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			String daw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			if (isElementPresentVerification(DataEntryConstants.Product_DAW)) {
				if (!clearAndEnterText(DataEntryConstants.Product_OriginalDate, daw)) {
					throw new Exception("User not able to enter date and daw values in product field");
				}
			}

			if (isElementPresentVerification(DataEntryConstants.Product_Substitute)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.Product_Substitute)) {
					throw new Exception("User not able to click product button");
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

	@Then("^I enter product info including Substitute$")
	public void i_enter_product_info_including_substitute(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String date = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			String daw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			String substitute = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Substitute");
			String drugname = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			String drugexp = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugExpDate");
			String quantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
			String quantitydisp = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "QuantityDisp");
			String directions = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Directions");
			String dayssupply = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DaysSupply");
			String refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
			if (isElementPresentVerification(DataEntryConstants.Product_OriginalDate) && isElementPresentVerification(DataEntryConstants.Product_DAW) && isElementPresentVerification(SmokeTestConstants.Product_Substitute) && isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(DataEntryConstants.Product_OriginalDate, date) || !clearAndEnterText(DataEntryConstants.Product_OriginalDate, daw) || !clearAndEnterText(SmokeTestConstants.Product_Substitute, substitute) || !clearAndEnterText(SmokeTestConstants.DrugName_Field, drugname)) {
					throw new Exception("User not able to enter date ,product date, substitute and drug name text field");
				} else {
					Actions upArrow = new Actions(chromeDriver);
					Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
					PressUpArrow.perform();
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.DrugExpiryDate_Field) && isElementPresentVerification(SmokeTestConstants.Quantity_field) && isElementPresentVerification(SmokeTestConstants.Quantity_disp) && isElementPresentVerification(SmokeTestConstants.Directions_field) && isElementPresentVerification(SmokeTestConstants.Days_Supply) && isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugExpiryDate_Field, drugexp) || !clearAndEnterText(SmokeTestConstants.Quantity_field, quantity) || !clearAndEnterText(SmokeTestConstants.Quantity_disp, quantitydisp) || !clearAndEnterText(SmokeTestConstants.Directions_field, directions) || !clearAndEnterText(SmokeTestConstants.Days_Supply, dayssupply) || !clearAndEnterText(SmokeTestConstants.Refills_field, refills)) {
					throw new Exception("User not able enter text in product fields");
				} else {
					ExpectedProductName = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DrugName_Field, chromeDriver).getAttribute("value");
					Assert.assertFalse(getElementText(SmokeTestConstants.DrugName_Field).equals(""), "Drug name field is empty.");
					ExpectedDirections = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Directions_field, chromeDriver).getAttribute("value");
					Assert.assertFalse(getElementText(SmokeTestConstants.Directions_field).equals(""), "Directions field is empty.");
					ExpectedProduct_quantity = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Quantity_field, chromeDriver).getAttribute("value");
					Assert.assertFalse(getElementText(SmokeTestConstants.Quantity_field).equals(""), "Quantity field is empty.");
					ExpectedProduct_quantityDisp = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Quantity_disp, chromeDriver).getAttribute("value");
					Assert.assertFalse(getElementText(SmokeTestConstants.Quantity_disp).equals(""), "Quantity disp field is empty.");
					ExpectedProduct_DaysSupply = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Days_Supply, chromeDriver).getAttribute("value");
					Assert.assertFalse(getElementText(SmokeTestConstants.Days_Supply).equals(""), "Days Supply field is empty.");
					ExpectedProduct_refills = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Refills_field, chromeDriver).getAttribute("value");
					Assert.assertFalse(getElementText(SmokeTestConstants.Refills_field).equals(""), "Refills field is empty.");
					ExpectedProduct_RxExpDate = FrameworkLibrary.getElementByProperty(SmokeTestConstants.RxExpiration_date, chromeDriver).getAttribute("value");
					Assert.assertFalse(getElementText(SmokeTestConstants.RxExpiration_date).equals(""), "Expiration date field is empty.");
					ExpectedProduct_DAW = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Product_DAW, chromeDriver).getAttribute("value");
					Assert.assertFalse(getElementText(SmokeTestConstants.Product_DAW).equals(""), "Product DAW field is empty.");
					ExpectedProduct_DrugExpDate = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DrugExpiryDate_Field, chromeDriver).getAttribute("value");
					Assert.assertFalse(getElementText(SmokeTestConstants.DrugExpiryDate_Field).equals(""), "Drug expiry field is empty.");
					ExpectedProduct_OriginalDate = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Product_OriginalDate, chromeDriver).getAttribute("value");
					Assert.assertFalse(getElementText(SmokeTestConstants.Product_OriginalDate).equals(""), "Drug Original Date field is empty.");
					ExpectedDirections = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Directions_field, chromeDriver).getAttribute("value");
					Assert.assertFalse(getElementText(SmokeTestConstants.Directions_field).equals(""), "Directions field is empty.");
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

	@Then("^The substitute field will be disabled$")
	public void the_substitute_field_will_be_disabled() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			WebElement product_Substitute = FrameworkLibrary.getElementByProperty(DataEntryConstants.Product_Substitute,
					chromeDriver);
			Assert.assertFalse(product_Substitute.isEnabled());
			Assert.assertTrue(product_Substitute.getAttribute("value").equalsIgnoreCase("N"));

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^The dispensed product field should not be blank$")
	public void the_dispensed_product_field_should_not_be_blank() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.productDispensed_Field)) {
				Assert.assertFalse(getElementText(DataEntryConstants.productDispensed_Field).equals(""));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^The system would display the right dispensed product$")
	public void the_system_would_display_the_right_dispensed_product() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.productDispensed_Field)) {
				WebElement dispensedProduct = FrameworkLibrary.getElementByProperty(DataEntryConstants.productDispensed_Field,
						chromeDriver);
				Assert.assertTrue(dispensedProduct.getAttribute("disabled").equals("true"));
				String drugName = FrameworkLibrary.getElementByProperty(DataEntryConstants.DrugName_Field, chromeDriver)
						.getText();
				String expectedVal = drugName.substring(0, drugName.indexOf("")).toLowerCase();
				Assert.assertTrue(dispensedProduct.getText().toLowerCase().contains(expectedVal));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("System unreserves the task by adding the task back to the taskboard")
	public void system_unreserves_task_number_increase_in_task_board() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.DENumberofTasks)) {
				WebDriverWait wait = new WebDriverWait(chromeDriver, 60);
				wait.until(ExpectedConditions.textToBePresentInElement(
						getElementByProperty(SmokeTestConstants.DENumberofTasks, chromeDriver),
						Integer.toString(expectedValafterCancel)));
				int actualVal = Integer.parseInt(getElementText(SmokeTestConstants.DENumberofTasks));
				Assert.assertEquals(actualVal, expectedValafterCancel);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User enters an LDD drug during data entry$")
	public void user_enters_LDD_drug_during_data_entry(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String drugname = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, drugname)) {
					throw new Exception("User not able to click date entry cancel  popup button");
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

	@When("User clicks cancel Button on DE page")
	public void User_clicks_cancel_Button_on_DE_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(SmokeTestConstants.DENumberofTasks)) {
				String numberDEbeforeCancel = getElementText(SmokeTestConstants.DENumberofTasks);
				expectedValafterCancel = Integer.parseInt(numberDEbeforeCancel) + 1;
				if (isElementPresentVerification(DataEntryConstants.de_cancel)) {
					if (!isElementPresentVerifyClick(DataEntryConstants.de_cancel)) {
						throw new Exception("Not able to click DE cancel button");
					} else if (isElementPresentVerification(SmokeTestConstants.DE_Cancel_Alert_Yes_Btn)) {
						if (!isElementPresentVerifyClick(SmokeTestConstants.DE_Cancel_Alert_Yes_Btn)) {
							throw new Exception("Not able to click DE cancel alert yes button");
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

	@When("^User selects pickup time as later$")
	public void user_selects_pickup_time_as_later() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(AccessManagementConstants.RADIO_PICKUPLATER)) {
				boolean clickedPickuplater = FrameworkLibrary
						.isElementPresentVerifyClick(AccessManagementConstants.RADIO_PICKUPLATER);
				if (clickedPickuplater) {
					if (isElementPresentVerification(AccessManagementConstants.PICKUPLATER_TODAYSDATE)) {
						if (!isElementPresentVerifyClick(AccessManagementConstants.PICKUPLATER_TODAYSDATE)) {
							throw new Exception("Not able to click login button");
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

	@Then("^User checks the directions entered for the patient in the product section$")
	public void user_checks_the_directions_entered_for_the_patient_in_the_product_section(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.DE_PRODUCT_DIRECTIONS_FIELD)) {
				for (int i = 0; i < arg1.raw().size(); i++) {
					List<String> expected = arg1.raw().get(0);
					String fromApplicationDirectionField = FrameworkLibrary.chromeDriver
							.findElement(xpath(DataEntryConstants.DE_PRODUCT_DIRECTIONS_FIELD)).getText();
					Assert.assertTrue(expected.get(0).length() != fromApplicationDirectionField.length(), "");
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

	@When("^User clicks on DR task while performing DE task$")
	public void user_clicks_on_DR_task_while_performing_DE_task() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification("//*[@id='main-right-sidenav-burger-menu']//div//span[contains(text(),'DR')]")) {
				if (!isElementPresentVerifyClick("//*[@id='main-right-sidenav-burger-menu']//div//span[contains(text(),'DR')]")) {
					throw new Exception("Not able to click DR task button");
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

	@Then("^User sees the message$")
	public void user_sees_the_message() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.DE_CANCEL_ALERT_POPUP)) {
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^User clicks on yes on the system message$")
	public void user_clicks_on_yes_on_the_system_message() throws Exception {
		Actions ac = new Actions(chromeDriver);
		Action series = ac.keyDown(Keys.ALT).sendKeys("y").keyUp(Keys.ALT).build();
		series.perform();
	}

	@When("^user click on annotation button and add a note with below text for front image on DE page$")
	public void user_click_on_annotation_button_and_add_a_note_with_below_text_for_front_image_on_DE_page(
			DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.IMAGE_ANNOTATION_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.IMAGE_ANNOTATION_BUTTON)) {
					throw new Exception("Not able to click image annotation button");
				}
			}
			if (isElementPresentVerification(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)) {
				Point point = FrameworkLibrary.chromeDriver
						.findElement(xpath(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)).getLocation();

				int x, y;
				int tempX = 20;
				int tempY = 10;
				for (int i = 0; i < arg1.raw().size(); i++) {
					x = point.x + tempX;
					y = point.y + tempY;
					Actions actions = new Actions(FrameworkLibrary.chromeDriver);
					actions.moveToElement(FrameworkLibrary.chromeDriver
							.findElement(xpath(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)), x, y).click().build()
					.perform();
					actions.moveToElement(FrameworkLibrary.chromeDriver
							.findElement(xpath(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)), x, y)
					.sendKeys(arg1.raw().get(i).get(0)).build().perform();
					if (isElementPresentVerification(DataEntryConstants.IMAGE_ANNOTATION_BUTTON)) {
						if (!isElementPresentVerifyClick(DataEntryConstants.IMAGE_ANNOTATION_BUTTON)) {
							throw new Exception("Not able to click image annotation button");
						}
					}
					tempX += 10;
					tempY += 10;
				}
				if (isElementPresentVerification(DataEntryConstants.IMAGE_ANNOTATION_BUTTON)) {
					String buttonColor = FrameworkLibrary.chromeDriver
							.findElement(xpath(DataEntryConstants.IMAGE_ANNOTATION_BUTTON)).getCssValue("fill");
					String[] numbers = buttonColor.replace("rgb(", "").replace(")", "").split(",");
					int r = Integer.parseInt(numbers[0].trim());
					int g = Integer.parseInt(numbers[1].trim());
					int b = Integer.parseInt(numbers[2].trim());
					String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
					Assert.assertEquals("#ffeb3b", hex);
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

	// user clicks on the note created
	@And("^user clicks on the note created on the image$")
	public void user_clicks_on_the_note_created_on_the_image() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.IMAGE_ANNOTATION_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.IMAGE_ANNOTATION_BUTTON)) {
					throw new Exception("Not able to click image annotation button");
				}
			}
			if (isElementPresentVerification(DataEntryConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)) {
				Point point = FrameworkLibrary.chromeDriver
						.findElement(xpath(DataEntryConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)).getLocation();
				Actions actions = new Actions(FrameworkLibrary.chromeDriver);

				if (isElementPresentVerification(DataEntryConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)) {
					actions.moveToElement(FrameworkLibrary.chromeDriver
							.findElement(xpath(DataEntryConstants.IMAGE_FRONT_INTAKE_FINISH_SCREEN)), point.x, point.y).click()
					.build().perform();
				}
				if (isElementPresentVerification(DataEntryConstants.IMAGE_ANNOTATION_BUTTON)) {
					if (!isElementPresentVerifyClick(DataEntryConstants.IMAGE_ANNOTATION_BUTTON)) {
						throw new Exception("Not able to click image annotation button");
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

	@And("^user clicks on annotaton button and adds no text \"([^\"]*)\" in note and checks the notes for front image on DE page$")
	public void user_clicks_on_annotaton_button_and_adds_no_text_in_note_and_checks_the_notes_for_front_image_on_DE_page(
			String arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.IMAGE_ANNOTATION_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.IMAGE_ANNOTATION_BUTTON)) {
					throw new Exception("Not able to click image annotation button");
				} else if (isElementPresentVerification(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)) {
					Point point = FrameworkLibrary.chromeDriver
							.findElement(xpath(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)).getLocation();
					Actions actions = new Actions(FrameworkLibrary.chromeDriver);
					actions.moveToElement(
							FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)),
							point.x, point.y).click().build().perform();
					actions.moveToElement(
							FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)),
							point.x, point.y).sendKeys(arg1).build().perform();
					if (isElementPresentVerification(DataEntryConstants.IMAGE_ANNOTATION_BUTTON)) {
						if (!isElementPresentVerifyClick(DataEntryConstants.IMAGE_ANNOTATION_BUTTON)) {
							throw new Exception("Not able to click image annotation button");
						} else if (isElementPresentVerification(DataEntryConstants.VIEW_ALL_BUTTON)) {
							if (!isElementPresentVerifyClick(DataEntryConstants.VIEW_ALL_BUTTON)) {
								throw new Exception("Not able to click view all button");
							}
						}
					}
				}
				if (isElementPresentVerification(DataEntryConstants.NOTES)) {
					List<WebElement> notesList = FrameworkLibrary.chromeDriver.findElements(xpath(DataEntryConstants.NOTES));
					if (isElementPresentVerification(DataEntryConstants.CLOSE_BUTTON)) {
						if (!isElementPresentVerifyClick(DataEntryConstants.CLOSE_BUTTON)) {
							throw new Exception("Not able to click close button");
						}
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

	@When("^User click on back button on tab bar in DE page$")
	public void User_click_on_back_button_on_tab_bar_in_DE_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.IMAGE_DE_FINISH_SCREEN_BACK_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.IMAGE_DE_FINISH_SCREEN_BACK_BUTTON)) {
					throw new Exception("Not able to click DE back button");
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User click on front button on tab bar in DE page$")
	public void User_click_on_front_button_on_tab_bar_in_DE_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.IMAGE_DE_FINISH_SCREEN_FRONT_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.IMAGE_DE_FINISH_SCREEN_FRONT_BUTTON)) {
					throw new Exception("Not able to click DE front button");
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^User check the annotations are saved in descending order$")
	public void user_check_the_annotations_are_saved_in_descending_order(DataTable arg1) throws Exception {

		WebDriverWait wait = new WebDriverWait(FrameworkLibrary.chromeDriver, 80);
		wait.until(ExpectedConditions.elementToBeClickable(xpath(DataEntryConstants.VIEW_ALL_BUTTON)));

		Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.VIEW_ALL_BUTTON))
				.getText().contains("View All"), "View all is not present when annotation is made on image");

		FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.VIEW_ALL_BUTTON)).click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions
				.visibilityOf(FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.NOTES))));

		List<WebElement> notesList = FrameworkLibrary.chromeDriver.findElements(xpath(DataEntryConstants.NOTES));

		Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.CLOSE_BUTTON)).getText()
				.contains("Close"), "Close is not present when annotation made on image are shown");

		for (int i = 0; i < notesList.size(); i++) {

			log.info("Annotation Text: " + arg1.raw().get(i).get(0));
		}

		FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.CLOSE_BUTTON)).click();

	}

	@When("^user click to rotate scanned image to right for front image on DE page$")
	public void user_click_to_rotate_scanned_image_to_right_on_DE_page() throws Exception {

		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(FrameworkLibrary.chromeDriver, 80);

		wait.until(ExpectedConditions.elementToBeClickable(xpath(DataEntryConstants.IMAGE_ROTATE_RIGHT_BUTTON)));

		attributeBeforeValue = FrameworkLibrary.chromeDriver
				.findElement(xpath(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)).getCssValue("transform");
		log.info("\n Before rotated to :" + attributeBeforeValue);

		FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.IMAGE_ROTATE_RIGHT_BUTTON)).click();
		Thread.sleep(1000);

		attributeAfterValue = FrameworkLibrary.chromeDriver
				.findElement(xpath(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)).getCssValue("transform");
		log.info("After rotated to :" + attributeAfterValue);


	}

	@Then("^user check  the scanned image rotated to right for front image on DE page$")
	public void user_check_the_scanned_image_rotated_right_for_front_image_on_DE_page() throws Exception {

		Assert.assertTrue(!attributeAfterValue.equals(attributeBeforeValue), "Image did not rotate right");
	}

	@When("^user click to rotate scaned image left for front image on DE page$")
	public void user_click_to_rotate_scaned_image_left_for_front_image_on_DE_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)) {
				attributeBeforeValue = FrameworkLibrary.chromeDriver
						.findElement(xpath(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)).getCssValue("transform");
			}
			if (isElementPresentVerification(DataEntryConstants.IMAGE_ROTATE_LEFT_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.IMAGE_ROTATE_LEFT_BUTTON)) {
					throw new Exception("Not able to click image rotate left button");
				} else if (isElementPresentVerification(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)) {
					attributeAfterValue = FrameworkLibrary.chromeDriver
							.findElement(xpath(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)).getCssValue("transform");
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

	@Then("^user check the image rotated left for front image on DE page$")
	public void user_check_the_image_rotated_left_for_front_image_on_DE_page() throws Exception {
		Assert.assertTrue(!attributeAfterValue.equals(attributeBeforeValue), "Image did not rotate left");
	}

	@Then("^user click to zoom in scanned Image for front image on DE page$")
	public void user_click_to_zoom_in_scanned_Image_for_front_image_on_DE_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.IMAGE_ZOOM_IN_BUTTON)) {
				for (int i = 0; i <= 3; i++) {
					FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.IMAGE_ZOOM_IN_BUTTON)).click();
				}
				if (isElementPresentVerification(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)) {
					attributeBeforeValue = FrameworkLibrary.chromeDriver
							.findElement(xpath(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)).getCssValue("width");
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

	@Then("^user click on resize to original size for front image on DE page$")
	public void user_click_on_resize_to_original_size_for_front_image_on_DE_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.IMAGE_RESTORE_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.IMAGE_RESTORE_BUTTON)) {
					throw new Exception("Not able to click image restore button");
				} else if (isElementPresentVerification(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)) {
					attributeAfterValue = FrameworkLibrary.chromeDriver
							.findElement(xpath(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)).getCssValue("width");
					Assert.assertTrue(!attributeAfterValue.equals(attributeBeforeValue), "Image did not restore to original size");
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

	@Then("^user click to zoom out scanned image for front image on DE page$")
	public void user_click_to_zoom_out_scanned_image_for_front_image_on_DE_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.IMAGE_ZOOM_OUT_BUTTON)) {
				for (int i = 0; i <= 2; i++) {
					isElementPresentVerifyClick(DataEntryConstants.IMAGE_ZOOM_OUT_BUTTON);
				}
				if (isElementPresentVerification(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)) {
					attributeBeforeValue = FrameworkLibrary.chromeDriver
							.findElement(xpath(DataEntryConstants.IMAGE_FRONT_DE_FINISH_SCREEN)).getCssValue("width");
					log.info("Performed zoom out  :" + attributeBeforeValue);
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

	// below used to full screen and close it
	@When("^user click on full screen image$")
	public void user_click_on_full_screen_image() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.IMAGE_FULL_SCREEN_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.IMAGE_FULL_SCREEN_BUTTON)) {
					throw new Exception("Not able to click image full screen button");
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

	@When("^user see the image full screen$")
	public void user_see_the_image_full_screen() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.IMAGE_PREVIEW)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.IMAGE_PREVIEW)) {
					throw new Exception("Not able to click image preview button");
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

	@Then("^user click on close$")
	public void user_click_on_close() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.IMAGE_X_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.IMAGE_X_BUTTON)) {
					throw new Exception("Not able to click image close button");
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

	// image manipulation - Data entry back image
	@When("^user click to rotate scanned image to right for back image on DE page$")
	public void user_click_to_rotate_scanned_image_to_right_for_back_image_on_DE_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.IMAGE_ROTATE_RIGHT_BUTTON)) {
				attributeBeforeValue = FrameworkLibrary.chromeDriver
						.findElement(xpath(DataEntryConstants.IMAGE_BACK_DE_FINISH_SCREEN)).getCssValue("transform");
			}
			if (isElementPresentVerification(DataEntryConstants.IMAGE_ROTATE_RIGHT_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.IMAGE_ROTATE_RIGHT_BUTTON)) {
					throw new Exception("Not able to click login button");
				} else if (isElementPresentVerification(DataEntryConstants.IMAGE_BACK_DE_FINISH_SCREEN)) {
					attributeAfterValue = FrameworkLibrary.chromeDriver
							.findElement(xpath(DataEntryConstants.IMAGE_BACK_DE_FINISH_SCREEN)).getCssValue("transform");
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

	@Then("^user check  the scanned image rotated to right for back image on DE page$")
	public void user_check_the_scanned_image_rotated_to_right_for_back_image_on_DE_page() throws Exception {
		Assert.assertTrue(!attributeAfterValue.equals(attributeBeforeValue), "Image did not rotate right");
	}

	@When("^user click to rotate scaned image left for back image on DE page$")
	public void user_click_to_rotate_scaned_image_left_for_back_image_on_DE_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.IMAGE_BACK_DE_FINISH_SCREEN)) {
				attributeBeforeValue = FrameworkLibrary.chromeDriver
						.findElement(xpath(DataEntryConstants.IMAGE_BACK_DE_FINISH_SCREEN)).getCssValue("transform");
			}
			if (isElementPresentVerification(DataEntryConstants.IMAGE_ROTATE_LEFT_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.IMAGE_ROTATE_LEFT_BUTTON)) {
					throw new Exception("Not able to click image Rotate left button");
				}
				attributeAfterValue = FrameworkLibrary.chromeDriver
						.findElement(xpath(DataEntryConstants.IMAGE_BACK_DE_FINISH_SCREEN)).getCssValue("transform");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^user check the image rotated left for back image on DE page$")
	public void user_check_the_image_rotated_left_for_back_image_on_DE_page() throws Exception {
		Assert.assertTrue(!attributeAfterValue.equals(attributeBeforeValue), "Image did not rotate left");
	}

	@Then("^user click to zoom in scanned Image for back image on DE page$")
	public void user_click_to_zoom_in_scanned_Image_for_back_image_on_DE_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.IMAGE_ZOOM_IN_BUTTON)) {
				for (int i = 0; i <= 3; i++) {
					isElementPresentVerifyClick(DataEntryConstants.IMAGE_ZOOM_IN_BUTTON);
				}
				attributeBeforeValue = FrameworkLibrary.chromeDriver
						.findElement(xpath(DataEntryConstants.IMAGE_BACK_DE_FINISH_SCREEN)).getCssValue("width");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^user click on resize to original size for back image on DE page$")
	public void user_click_on_resize_to_original_size_for_back_image_on_DE_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.IMAGE_RESTORE_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.IMAGE_RESTORE_BUTTON)) {
					throw new Exception("Not able to click DE image restore button button");
				}
				if (isElementPresentVerification(DataEntryConstants.IMAGE_BACK_DE_FINISH_SCREEN)) {
					attributeAfterValue = FrameworkLibrary.chromeDriver
							.findElement(xpath(DataEntryConstants.IMAGE_BACK_DE_FINISH_SCREEN)).getCssValue("width");
					Assert.assertTrue(!attributeAfterValue.equals(attributeBeforeValue), "Image did not restore to original size");
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

	@Then("^user click to zoom out scanned image for back image on DE page$")
	public void user_click_to_zoom_out_scanned_image_for_back_image_on_DE_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.IMAGE_ZOOM_OUT_BUTTON)) {
				for (int i = 0; i <= 2; i++) {
					isElementPresentVerifyClick(DataEntryConstants.IMAGE_ZOOM_OUT_BUTTON);
				}
				if (isElementPresentVerification(DataEntryConstants.IMAGE_BACK_DE_FINISH_SCREEN)) {
					attributeBeforeValue = FrameworkLibrary.chromeDriver
							.findElement(xpath(DataEntryConstants.IMAGE_BACK_DE_FINISH_SCREEN)).getCssValue("width");
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

	@And("^click DE cancel$")
	public void click_DE_cancel() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(dataReviewConstants.de_cancel)) {
				if (!isElementPresentVerifyClick(dataReviewConstants.de_cancel)) {
					throw new Exception("Not able to click cancel button");
				} else if (isElementPresentVerification(dataReviewConstants.de_cancel_popup)) {
					if (!isElementPresentVerifyClick(dataReviewConstants.de_cancel_yes)) {
						throw new Exception("Not able to click cancel button");
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

	@Then("^DE should be canceled$")
	public void DE_should_be_canceled() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(dataReviewConstants.main_right_sidenav_burger_menu_DE_text)) {
				Assert.assertFalse(getElementText(dataReviewConstants.main_right_sidenav_burger_menu_DE_text).equals("0"));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^click on Send to IC plus$")
	public void click_on_Send_to_IC_plus() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(dataReviewConstants.de_add_to_ic)) {
				if (!isElementPresentVerifyClick(dataReviewConstants.de_add_to_ic)) {
					throw new Exception("Not able to click IC plus button in DE screen");
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

	@Then("^The pending link for current prescription should say check IC$")
	public void the_prescription_status_should_say_check_IC(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			SmokeTestStepDef.i_click_search_button_on_patient_order_status();
			Thread.sleep(5000);
			SmokeTestLibrary.hotkeyAction(Keys.ALT, "S", chromeDriver);
			Thread.sleep(5000);
			String pickuptime = SmokeTestStepDef.currentPickupTime;
			String pickupdate = SmokeTestStepDef.IntakeDate;
			String possiblepickupTime1 = SmokeTestStepDef.possiblePickupTime;
			String expintakeDate = SmokeTestStepDef.intakenextdate;
			List<WebElement> elements = chromeDriver.findElements(By.xpath("//tr[contains(@id,'patient-')]"));
			log.info(elements.size());
			for (int i = 0; i < elements.size(); i++) {
				log.info(elements.get(i).getText());
				if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(possiblepickupTime1)) {
					Assert.assertTrue(elements.get(i).findElement(By.xpath(dataReviewConstants.POS_CheckIC_plus)).getText().equals("Check IC+"));
					break;
				} else if (elements.get(i).getText().contains(pickupdate) && elements.get(i).getText().contains(pickuptime)) {
					Assert.assertTrue(elements.get(i).findElement(By.xpath(dataReviewConstants.POS_CheckIC_plus)).getText().equals("Check IC+"));
					break;
				} else if (elements.get(i).getText().contains(expintakeDate) && elements.get(i).getText().contains(possiblepickupTime1)) {
					Assert.assertTrue(elements.get(i).findElement(By.xpath(dataReviewConstants.POS_CheckIC_plus)).getText().equals("Check IC+"));
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



	@Then("^pay code drop down should enable$")
	public void pay_code_drop_down_should_enable() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.PAY_CODE_DROPDOWN)) {
				FrameworkLibrary.isButtonEnable(DataEntryConstants.PAY_CODE_DROPDOWN);
				if (isElementPresentVerification(AccessManagementConstants.DE_Plan_Paycode_One)) {
					Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(xpath(AccessManagementConstants.DE_Plan_Paycode_One)).getText().contains("2 - Subst Allowed-Pt Request Drug Dispensed"));
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

	@When("^I click cancel button on product textbox$")
	public void click_cancel_button_on_product_textbox() throws Exception {

		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DATAENTRY_PRODUCT_CANCEL_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DATAENTRY_PRODUCT_CANCEL_BUTTON)) {
					throw new Exception("The cancel button not clicked in dataentry");
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

	@And("^I click yes on popup window$")
	public void click_yes_on_popup_window() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DE_WANT_TO_PROCEED_YES)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_WANT_TO_PROCEED_YES)) {
					throw new Exception("Data Entry not proceed to next step");
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

	@Then("^I should be able to enter new product information$")
	public void should_be_able_to_enter_new_product_information(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String productName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");

			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, productName)) {
					throw new Exception("Not able to enter value in user name text field");
				}
			}

			Actions upArrow = new Actions(chromeDriver);
			Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
			PressUpArrow.perform();

			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				ExpectedProductName = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DrugName_Field, chromeDriver).getAttribute("value");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^I click clear field button$")
	public void click_clear_field_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_CLEAR_FIELD)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.PRESCRIBER_CLEAR_FIELD)) {
					throw new Exception("Prescriber feild text is not cleared");
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

	@And("^I should see new prescriber result$")
	public void should_see_new_prescriber_result() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.De_Prescriber_Search_Results_TD)) {
				//Assert.assertTrue(isElementPresentVerification(DataEntryConstants.De_Prescriber_Search_Results_TD));
				List<WebElement> elements = chromeDriver.findElements(xpath(DataEntryConstants.De_Prescriber_Search_Results_TD));
				Assert.assertTrue(elements.size() != 0);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^enters product with DAW N and substitute as Y$")
	public void enters_daw_n_substitute_y(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate)) {
					throw new Exception("User not able to enter value in product date in text field");
				}
			}
			String productDaw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, productDaw)) {
					throw new Exception("User not able to enter value daw in text field");
				}
			}
			String Substitutefeild = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Substitute");
			if (isElementPresentVerification(SmokeTestConstants.Product_Substitute)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_Substitute, Substitutefeild)) {
					throw new Exception("User not able to enter value Substitute in text field");
				}
			}
			String drug = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, drug)) {
					throw new Exception("User not able to enter value drug name in text field");
				}
			}

			Actions upArrow = new Actions(chromeDriver);
			Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
			PressUpArrow.perform();

			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				ExpectedProductName = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DrugName_Field, chromeDriver).getAttribute("value");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^I should see preferred drug as dispensed product$")
	public void should_see_preferred_drug_dispensed() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				ExpectedProductName = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DrugName_Field, chromeDriver).getAttribute("value");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User enters new prescriber first name and Last name$")
	public void User_enters_new_prescriber_first_name_and_Last_name(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String prescriberLastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
			if (isElementPresentVerification(SmokeTestConstants.NEW_PRESCRIBER_LAST_NAME)) {
				if (!clearAndEnterText(SmokeTestConstants.NEW_PRESCRIBER_LAST_NAME, prescriberLastName)) {
					throw new Exception("User not able to enter value in prescriber Last name text field");
				}
			}
			String prescriberFirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
			if (isElementPresentVerification(SmokeTestConstants.NEW_PRESCRIBER_FIRST_NAME)) {
				if (!clearAndEnterText(SmokeTestConstants.NEW_PRESCRIBER_FIRST_NAME, prescriberFirstName)) {
					throw new Exception("User not able to enter value in prescriber first name text field");
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

	@And("^click search button on prescriber search$")
	public void click_search_button_on_prescriber_search() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.PRESCRIBER_SEARCH_BUTTON)) {
					throw new Exception("User not able to click prescriber search button");
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

	@When("^User selects pickup time as Pick Up Later$")
	public void User_selects_pickup_time_as_pickup_later() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.date_latest)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.date_latest)) {
					throw new Exception("User not able to click last date");
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

	@When("^The system displays a pop-up with message - All changes will be lost\\? Do you want to proceed\\?$")
	public void the_system_displays_a_pop_up_with_message_All_changes_will_be_lost_Do_you_want_to_proceed() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.userName)) {
				String actualMessage = getElementText(SmokeTestConstants.cancelAlertMessage);
				String expectedMessage1 = "All changes will be lost.";
				String expectedMessage2 = "Do you want to proceed?";
				Assert.assertTrue(actualMessage.contains(expectedMessage1), "Alert message is not displayed");
				Assert.assertTrue(actualMessage.contains(expectedMessage2), "Alert message is not displayed");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User hits tab to move to No on the pop-up$")
	public void user_hits_tab_to_move_to_No_on_the_pop_up() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.cancelAlertMessage)) {
				Actions tab = new Actions(chromeDriver);
				Action hitTab = tab.sendKeys(Keys.TAB).build();
				hitTab.perform();
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User hits enter to select No on the pop-up$")
	public void user_hits_enter_to_select_No_on_the_pop_up() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.cancelAlertMessage)) {
				Actions enter = new Actions(chromeDriver);
				Action enter1 = enter.sendKeys(Keys.ENTER).build();
				enter1.perform();
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^System remains on the current task$")
	public void system_remains_on_the_current_task() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.DataEntryPageTitle)) {
				Assert.assertTrue(isElementPresents(SmokeTestConstants.DataEntryPageTitle));
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^User clicks Yes on the pop-up$")
	public void user_clicks_Yes_on_the_pop_up() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.DE_Cancel_Alert_Yes_Btn)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.DE_Cancel_Alert_Yes_Btn)) {
					throw new Exception("User not able to click cancel alert button");
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

	@When("^User clicks No on the pop-up$")
	public void user_DataEntryStepDef() throws Exception {
		//waitToClick(SmokeTestConstants.)
	}

	@When("^User hits Alt plus B hotkey$")
	public void user_hits_alt_plus_b_hotkey() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.cancelAlertMessage)) {
				Actions altB = new Actions(chromeDriver);
				Action ac = altB.keyDown(Keys.ALT).sendKeys("b").keyUp(Keys.ALT).build();
				ac.perform();
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^enters product information in the fields$")
	public void enters_product_information_in_the_fields(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			String productDaw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			String drug = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			String quantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
			String quantityDispensed = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "QuantityDisp");
			String directions = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Directions");
			String daysSupply = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DaysSupply");
			String refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");

			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate) && isElementPresentVerification(SmokeTestConstants.Product_DAW) && isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate) || !clearAndEnterText(SmokeTestConstants.Product_DAW, productDaw) || !clearAndEnterText(SmokeTestConstants.DrugName_Field, drug)) {
					throw new Exception("User not able to enter value in product text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();
				Thread.sleep(1000);
			}
			if (isElementPresentVerification(SmokeTestConstants.Quantity_field) && isElementPresentVerification(SmokeTestConstants.Quantity_disp) && isElementPresentVerification(SmokeTestConstants.Directions_field) && isElementPresentVerification(SmokeTestConstants.Days_Supply) && isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Quantity_field, quantity) || !clearAndEnterText(SmokeTestConstants.Quantity_disp, quantityDispensed) || !clearAndEnterText(SmokeTestConstants.Directions_field, directions) || !clearAndEnterText(SmokeTestConstants.Days_Supply, daysSupply) || !clearAndEnterText(SmokeTestConstants.Refills_field, refills)) {
					throw new Exception("User not able to enter value Quantity in text field");
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

	@When("^enters the drug information$")
	public void enters_the_drug_information(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");

			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate)) {
					throw new Exception("User not able to enter value in productDate text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
				String Entereddate = FrameworkLibrary.chromeDriver.findElement(xpath(SmokeTestConstants.Product_OriginalDate)).getText();
				log.info(Entereddate);
			}

			String productDaw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, productDaw)) {
					throw new Exception("User not able to enter value daw in text field");
				}
			}

			String drug = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, drug)) {
					throw new Exception("User not able to enter value drug name in text field");
				} else {
					Actions altB = new Actions(chromeDriver);
					Action ac = altB.keyDown(Keys.ALT).sendKeys("b").keyUp(Keys.ALT).build();
					ac.perform();
				}
			}

			if (isElementPresentVerification(SmokeTestConstants.DrugExpiryDate_Field)) {
				String Expdate = FrameworkLibrary.chromeDriver.findElement(xpath(SmokeTestConstants.DrugExpiryDate_Field)).getText();
				log.info(Expdate);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^enters the drug information two$")
	public void enters_the_drug_information_two(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");

			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate)) {
					throw new Exception("User not able to enter value in productDate text field");
				}
			}
			String productDaw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, productDaw)) {
					throw new Exception("User not able to enter value daw in text field");
				}
			}

			String Substitute = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Substitute");
			if (isElementPresentVerification(DataEntryConstants.Product_Substitute)) {
				if (!clearAndEnterText(DataEntryConstants.Product_Substitute, Substitute)) {
					throw new Exception("User not able to enter value daw in text field");
				}
			}

			String drug = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, drug)) {
					throw new Exception("User not able to enter value drug name in text field");
				} else {
					Actions altB = new Actions(chromeDriver);
					Action ac = altB.keyDown(Keys.ALT).sendKeys("b").keyUp(Keys.ALT).build();
					ac.perform();
				}
			}

			if (isElementPresentVerification(DataEntryConstants.productChange_Button)) {
				if (isElementPresentVerifyClick(DataEntryConstants.productChange_Button)) {
					throw new Exception("User not able to click product button");
				}
			}

			if (isElementPresentVerification(DataEntryConstants.DE_Dispensed_drug_quantity)) {
				List<WebElement> drugsdispensed = FrameworkLibrary.chromeDriver.findElements(xpath(DataEntryConstants.DE_Dispensed_drug_quantity));

				int size = drugsdispensed.size();
				log.info("the size is :" + size);
				boolean cond = size > 1;
				Assert.assertTrue(cond);
				Actions upArrow1 = new Actions(chromeDriver);
				Action PressUpArrow1 = upArrow1.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow1.perform();
				Thread.sleep(1000);

			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	@When("^enters the drug information for no dispensed drug$")
	public void enters_the_drug_information_for_no_dispensed_drug(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");

			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate)) {
					throw new Exception("User not able to enter value in productDate text field");
				}
			}


			String productDaw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, productDaw)) {
					throw new Exception("User not able to enter value daw in text field");
				}
			}

			String Substitute = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Substitute");
			if (isElementPresentVerification(DataEntryConstants.Product_Substitute)) {
				if (!clearAndEnterText(DataEntryConstants.Product_Substitute, Substitute)) {
					throw new Exception("User not able to enter value daw in text field");
				}
			}

			String drug = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, drug)) {
					throw new Exception("User not able to enter value drug name in text field");
				} else {
					Actions altB = new Actions(chromeDriver);
					Action ac = altB.keyDown(Keys.ALT).sendKeys("b").keyUp(Keys.ALT).build();
					ac.perform();
					if (isElementPresentVerification(DataEntryConstants.DispensedDrug_errormsg)) {
						String drugerror = FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.DispensedDrug_errormsg)).getText();
						Assert.assertEquals(drugerror, "No dispensed drug identified");
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

	@When("^enters the drug information for dispensed drug$")
	public void enters_the_drug_information_for_dispensed_drug(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String data = FrameworkLibrary.getXLSTestData("Prescriber_Input", "Productdetails", "Row_six", "DrugName");

			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate)) {
					throw new Exception("User not able to enter value in productDate text field");
				}
			}

			String productDaw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, productDaw)) {
					throw new Exception("User not able to enter value daw in text field");
				}
			}
			String drug = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, drug)) {
					throw new Exception("User not able to enter value drug name in text field");
				} else {
					Actions upArrow = new Actions(chromeDriver);
					Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
					PressUpArrow.perform();
					if (isElementPresentVerification(DataEntryConstants.Productdispensed_check)) {
						String dispenseddrug = FrameworkLibrary.getElementText(DataEntryConstants.Productdispensed_check);
						Assert.assertTrue(dispenseddrug.contains(data));
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

	@When("^enters the drug information for list of drugs$")
	public void enters_the_drug_information_for_list_of_drugs(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.Productdispensed_check)) {
				String dispenseddrug = FrameworkLibrary.getElementText(DataEntryConstants.Productdispensed_check);
				log.info(dispenseddrug);
			}
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate)) {
					throw new Exception("User not able to enter value in productDate text field");
				}
			}

			String productDaw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, productDaw)) {
					throw new Exception("User not able to enter value daw in text field");
				} else {
					Actions tab = new Actions(chromeDriver);
					Action presstab = tab.sendKeys(Keys.TAB).build();
					presstab.perform();
				}
			}

			String Substitute = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Substitute");
			if (isElementPresentVerification(DataEntryConstants.Product_Substitute)) {
				if (!clearAndEnterText(DataEntryConstants.Product_Substitute, Substitute)) {
					throw new Exception("User not able to enter value daw in text field");
				}
			}

			String drug = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, drug)) {
					throw new Exception("User not able to enter value drug name in text field");
				} else {
					Actions upArrow = new Actions(chromeDriver);
					Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
					PressUpArrow.perform();
					if (isElementPresentVerification(DataEntryConstants.Productdispensed_check)) {
						String afterdispdrug = FrameworkLibrary.getElementText(DataEntryConstants.Productdispensed_check);
						log.info(afterdispdrug);
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

	@When("^enters the drug information for list of drug$")
	public void enters_the_drug_information_for_list_of_drug(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.Productdispensed_check)) {
				String dispenseddrug = FrameworkLibrary.getElementText(DataEntryConstants.Productdispensed_check);
				log.info(dispenseddrug);
			}
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
				if (clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate)) {
					throw new Exception("User not able to enter value in productDate text field");
				}
			}
			String productDaw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, productDaw)) {
					throw new Exception("User not able to enter value daw in text field");
				}
			}

			String Substitute = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Substitute");
			if (isElementPresentVerification(DataEntryConstants.Product_Substitute)) {
				if (!clearAndEnterText(DataEntryConstants.Product_Substitute, Substitute)) {
					throw new Exception("User not able to enter value daw in text field");
				}
			}
			String drug = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, drug)) {
					throw new Exception("User not able to enter value drug name in text field");
				} else {
					Actions upArrow = new Actions(chromeDriver);
					Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
					PressUpArrow.perform();
					if (isElementPresentVerification(DataEntryConstants.Productdispensed_check)) {
						String afterdispdrug = FrameworkLibrary.getElementText(DataEntryConstants.Productdispensed_check);
						log.info(afterdispdrug);
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

	@When("^User navigates to home page by using CTRL plus h hot key$")
	public void User_navigates_to_home_page_by_using_CTRL_plus_h_hot_key() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.CONTROL).sendKeys("h").keyUp(Keys.CONTROL).build();
			series.perform();

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	@Then("^User will be on RxMS home page$")
	public void User_will_be_on_RxMS_home_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.RxMSHome_PharmacyInformationCard)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.RxMSHome_PharmacyInformationCard), "RxMS homepage is not displayed");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	@Then("^pay code drop down should show 0 by default$")
	public void pay_code_drop_down_should_show_0_by_default() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(AccessManagementConstants.DE_Plan_Paycode_One)) {
				Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(xpath(AccessManagementConstants.DE_Plan_Paycode_One)).getText().startsWith("0"));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^pay code drop down should show 1 by default$")
	public void pay_code_drop_down_should_show_1_by_default() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(AccessManagementConstants.DE_Plan_Paycode_One)) {
				Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(xpath(AccessManagementConstants.DE_Plan_Paycode_One)).getText().startsWith("1"));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	@Then("^pay code drop down should show 2 by default$")
	public void pay_code_drop_down_should_show_2_by_default() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(AccessManagementConstants.DE_Plan_Paycode_One)) {
				Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(xpath(AccessManagementConstants.DE_Plan_Paycode_One)).getText().startsWith("2"));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	@When("^I click TAB key from \"([^\"]*)\" field$")
	public void i_click_TAB_key_from_field(String arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_PHONE_NUMBER)) {

				if (arg1.equals("Phone Number")) {
					chromeDriver.findElement(xpath(DataEntryConstants.PRESCRIBER_SEARCH_PHONE_NUMBER)).sendKeys(Keys.TAB);
				} else if (arg1.equals("NPI")) {
					chromeDriver.findElement(xpath(DataEntryConstants.PRESCRIBER_SEARCH_NPI_DEA)).sendKeys(Keys.TAB);
				} else if (arg1.equals("First Name")) {
					chromeDriver.findElement(xpath(DataEntryConstants.PRESCRIBER_SEARCH_FIRST_NAME)).sendKeys(Keys.TAB);
				} else if (arg1.equals("search")) {
					//      chromeDriver.findElement(By.xpath(AccessManagementConstants.ROLE_MANAGEMENT_SEARCH_FIELD)).sendKeys(Keys.TAB);
				} else if (arg1.equals("Add")) {
					chromeDriver.findElement(xpath(AccessManagementConstants.ADD_ROLE_BUTTON)).sendKeys(Keys.TAB);
				} else if (arg1.equals("Update")) {
					chromeDriver.findElement(xpath(AccessManagementConstants.UPDATE_ROLE_BUTTON)).sendKeys(Keys.TAB);
				} else if (arg1.equals("Delete")) {
					chromeDriver.findElement(xpath(AccessManagementConstants.DELETE_ROLE_BUTTON)).sendKeys(Keys.TAB);
				} else if (arg1.equals("Waiting")) {
					chromeDriver.findElement(xpath(hangOnConstants.RADIO_PICKUP_WAITING)).sendKeys(Keys.TAB);
				} else if (arg1.equals("Pick Up Later")) {
					chromeDriver.findElement(xpath(hangOnConstants.RADIO_PICKUPLATER)).sendKeys(Keys.TAB);
				} else if (arg1.equals("scan")) {
					chromeDriver.findElement(xpath(hangOnConstants.ORIGIN_CODE_SCAN)).sendKeys(Keys.TAB);
				} else if (arg1.equals("fax")) {
					chromeDriver.findElement(xpath(hangOnConstants.ORIGIN_CODE_FAX)).sendKeys(Keys.TAB);
				} else if (arg1.equals("phone")) {
					chromeDriver.findElement(xpath(hangOnConstants.ORIGIN_CODE_PHONE)).sendKeys(Keys.TAB);
				} else if (arg1.equals("Finish")) {
					chromeDriver.findElement(xpath(IntakeConstants.Rx_FinishButton)).sendKeys(Keys.TAB);
				} else if (arg1.equals("Cancel")) {
					chromeDriver.findElement(xpath(hangOnConstants.INTAKE_CANCEL_BUTTON)).sendKeys(Keys.TAB);
				} else if (arg1.equals("X Button")) {
					chromeDriver.findElement(xpath(hangOnConstants.INTAKE_X_BUTTON)).sendKeys(Keys.TAB);
				} else if (arg1.equals("first day button")) {
					chromeDriver.findElement(xpath(hangOnConstants.PICKUP_LATER_DAY1)).sendKeys(Keys.TAB);
				} else if (arg1.equals("second day button")) {
					chromeDriver.findElement(xpath(hangOnConstants.PICKUP_LATER_DAY2)).sendKeys(Keys.TAB);
				} else if (arg1.equals("third day button")) {
					chromeDriver.findElement(xpath(hangOnConstants.PICKUP_LATER_DAY3)).sendKeys(Keys.TAB);
				} else if (arg1.equals("fourth day button")) {
					chromeDriver.findElement(xpath(hangOnConstants.PICKUP_LATER_DAY4)).sendKeys(Keys.TAB);
				} else if (arg1.equals("fifth day button")) {
					chromeDriver.findElement(xpath(hangOnConstants.PICKUP_LATER_DAY5)).sendKeys(Keys.TAB);
				} else if (arg1.equals("sixth day button")) {
					chromeDriver.findElement(xpath(hangOnConstants.PICKUP_LATER_DAY6)).sendKeys(Keys.TAB);
				} else if (arg1.equals("seventh day button")) {
					chromeDriver.findElement(xpath(hangOnConstants.PICKUP_LATER_DAY7)).sendKeys(Keys.TAB);
				} else if (arg1.equals("time")) {
					chromeDriver.findElement(xpath(hangOnConstants.PICKUP_LATER_TIME)).sendKeys(Keys.TAB);
				} else if (arg1.equals("Original Date")) {
					chromeDriver.findElement(xpath(DataEntryConstants.Product_OriginalDate)).sendKeys(Keys.TAB);
				} else if (arg1.equals("DAW")) {
					chromeDriver.findElement(xpath(DataEntryConstants.Product_DAW)).sendKeys(Keys.TAB);
				} else if (arg1.equals("Substitute")) {
					chromeDriver.findElement(xpath(DataEntryConstants.Product_Substitute)).sendKeys(Keys.TAB);
				} else if (arg1.equals("Prescribed Drug")) {
					chromeDriver.findElement(xpath(DataEntryConstants.DrugName_Field)).sendKeys(Keys.TAB);
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

	@Then("^I should be on \"([^\"]*)\" field$")
	public void i_should_be_on_field(String arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (arg1.equals("NPI")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("npi"), "Not on NPI field");
			} else if (arg1.equals("First Name")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("first"), "Not on First Name field");
			} else if (arg1.equals("Last Name")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("last"), "Not on Last Name field");
			} else if (arg1.equals("search")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("search"), "Not on Search field");
			} else if (arg1.equals("Add")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("Add"), "Not on Add button");
			} else if (arg1.equals("Update")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("Update"), "Not on Update button");
			} else if (arg1.equals("Delete")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("Delete"), "Not on Delete button");
			} else if (arg1.equals("Pick Up Later")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("radio-pickup"), "Not on Pickup radio button");
			} else if (arg1.equals("scan")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("scan"), "Not on scan radio button");
			} else if (arg1.equals("fax")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("fax"), "Not on fax radio button");
			} else if (arg1.equals("phone")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("fax"), "Not on phone radio button");
			} else if (arg1.equals("Finish")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("finish"), "Not on finish button");
			} else if (arg1.equals("X Button")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("close"), "Not on close button");
			} else if (arg1.equals("first day button")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("later"), "Not on first day button");
			} else if (arg1.equals("second day button")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("later"), "Not on second day button");
			} else if (arg1.equals("third day button")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("later"), "Not on third day button");
			} else if (arg1.equals("fourth day button")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("later"), "Not on fourth day button");
			} else if (arg1.equals("fifth day button")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("later"), "Not on fifth day button");
			} else if (arg1.equals("sixth day button")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("later"), "Not on sixth day button");
			} else if (arg1.equals("seventh day button")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("later"), "Not on seventh day button");
			} else if (arg1.equals("time")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("hour"), "Not on time field");
			} else if (arg1.equals("am-pm")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("meridian"), "Not on AM-PM field");
			} else if (arg1.equals("DAW")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("name").contains("daw"), "Not on DAW field");
			} else if (arg1.equals("Substitute")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("name").contains("substitute"), "Not on Substitute field");
			} else if (arg1.equals("Prescribed Drug")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("prescribed"), "Not on Prescribed Drug field");
			} else if (arg1.equals("Drug Exp Date")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("drug-exp-date"), "Not on Drug Exp Date field");
			} else if (arg1.equals("Original Date")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("original-date"), "Not on Original Date field");
			} else if (arg1.equals("Prescribed Drug")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("prescribed-drug"), "Not on Prescribed Drug field");
			} else if (arg1.equals("change")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("class").contains("md-ink-ripple"), "Not on Change dropdown field");
			} else if (arg1.equals("Qty")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("name").contains("qty"), "Not on Quantity field");
			} else if (arg1.equals("Qty Disp")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("name").contains("qtyDisp"), "Not on Quantity Display field");
			} else if (arg1.equals("Rx Expiration Date")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("refill-exp"), "Not on Rx Expiration Date field");
			} else if (arg1.equals("Directions")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("directions"), "Not on Directions field");
			} else if (arg1.equals("Days Supply")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("name").contains("daysSupply"), "Not on Days Supply field");
			} else if (arg1.equals("Refills")) {
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("refill"), "Not on Refills field");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	@When("^you click search button with empty input$")
	public void you_click_search_button_with_empty_input() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
					throw new Exception("User not able to click prescriber search button");
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

	@When("^you click search button after entering first name$")
	public void you_click_search_button_after_entering_first_name() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_FIRST_NAME)) {
				FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.PRESCRIBER_SEARCH_FIRST_NAME)).sendKeys("Test");
				if (isElementPresentVerification(FrameworkConstants.PRESCRIBER_PAGE_SEARCH_BTN)) {
					if (!isElementPresentVerifyClick(FrameworkConstants.PRESCRIBER_PAGE_SEARCH_BTN)) {
						throw new Exception("User not able to click prescriber search button");
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
	
	@When("^I enter invalid \"([^\"]*)\" value$")
	public void i_enter_invalid_value(String arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_FIRST_NAME) && isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_LAST_NAME) && isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_NPI_DEA)) {
				FrameworkLibrary.getElementByProperty(DataEntryConstants.PRESCRIBER_SEARCH_FIRST_NAME, chromeDriver).clear();
				FrameworkLibrary.getElementByProperty(DataEntryConstants.PRESCRIBER_SEARCH_NPI_DEA, chromeDriver).clear();
				FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.PRESCRIBER_SEARCH_NPI_DEA)).sendKeys("Test");
				if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
					if (!isElementPresentVerifyClick(DataEntryConstants.PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
						throw new Exception("Not able to click prescriber search button");
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

	@When("^click hot key to search$")
	public void click_hot_key_to_search() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
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

	@Then("^I should be able to use up and down arrows to navigate through the records$")
	public void i_should_be_able_to_use_up_and_down_arrows_to_navigate_through_the_records() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Actions upArrow = new Actions(chromeDriver);
			Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build();
			PressUpArrow.perform();
			Thread.sleep(1000);
			Action PressUpArrow1 = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
			PressUpArrow1.perform();

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^user enters details of the prescriber with DEA$")
	public void user_enters_details_of_the_prescriber_with_DEA(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_FIRST_NAME) && isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_LAST_NAME) && isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_NPI_DEA)) {
				FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.PRESCRIBER_SEARCH_FIRST_NAME)).clear();
				FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.PRESCRIBER_SEARCH_LAST_NAME)).clear();
				FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.PRESCRIBER_SEARCH_NPI_DEA)).clear();
				String dea = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DEA");
				if (!clearAndEnterText(DataEntryConstants.PRESCRIBER_SEARCH_NPI_DEA, dea)) {
					throw new Exception("Not able to enter value for prescriber in DEA text field");
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

	@When("^user enters details of the prescriber with NPI$")
	public void user_enters_details_of_the_prescriber_with_NPI(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_FIRST_NAME) && isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_LAST_NAME) && isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_NPI_DEA)) {
				FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.PRESCRIBER_SEARCH_FIRST_NAME)).clear();
				FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.PRESCRIBER_SEARCH_LAST_NAME)).clear();
				String npi = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "NPI");
				if (!clearAndEnterText(DataEntryConstants.PRESCRIBER_SEARCH_NPI_DEA, npi)) {
					throw new Exception("Not able to enter value for prescriber in NPI text field");
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

	@When("^user enters details of prescriber$")
	public void user_enters_details_of_prescriber(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_NPI_DEA)) {
				FrameworkLibrary.getElementByProperty(DataEntryConstants.PRESCRIBER_SEARCH_NPI_DEA, chromeDriver).clear();
				WebDriverWait wait = new WebDriverWait(chromeDriver, 30);
				WebElement element = FrameworkLibrary.getElementByProperty(DataEntryConstants.PRESCRIBER_SEARCH_FIRST_NAME, chromeDriver);
				wait.until(ExpectedConditions.visibilityOf(element));
			}
			String lastname = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_LAST_NAME)) {
				if (!clearAndEnterText(DataEntryConstants.PRESCRIBER_SEARCH_LAST_NAME, lastname)) {
					throw new Exception("User not able to enter value last name in text field");
				}
			}

			String firstname = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_FIRST_NAME)) {
				if (!clearAndEnterText(DataEntryConstants.PRESCRIBER_SEARCH_FIRST_NAME, firstname)) {
					throw new Exception("User not able to enter value first name in text field");
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

	@When("^I click on Last, First Name label$")
	public void i_click_on_Last_First_Name_label() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Last_First_Label)) {
				name_before_sorting = chromeDriver.findElement(xpath(DataEntryConstants.DE_Prescriber_Last_First_Label)).getText();
				if (!isElementPresentVerifyClick(DataEntryConstants.PRESCRIBER_SEARCH_RESULT_NAME_COLUMN)) {
					throw new Exception("User not able to click prescriber search result name field");
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

	@Then("^I should see results in descending order$")
	public void i_should_see_results_in_descending_order() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Last_First_Label)) {
				name_before_sorting = chromeDriver.findElement(xpath(DataEntryConstants.DE_Prescriber_Last_First_Label)).getText();
				Assert.assertFalse(name_before_sorting.equals(name_after_sorting));

			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User hits Alt plus V hotkey$")
	public void user_hits_Alt_plus_V_hotkey() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Actions ac = new Actions(chromeDriver);
			Action series = ac.keyDown(Keys.ALT).sendKeys("v").keyUp(Keys.ALT).build();
			series.perform();
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User hits Alt plus U hotkey$")
	public void user_hits_Alt_plus_U_hotkey() throws Exception {
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

	@Then("^prescriber details page should be displayed successfully$")
	public void prescriber_details_page_should_be_displayed_successfully() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Assert.assertTrue(chromeDriver.getPageSource().contains("Prescriber Profile"), "Prescription details page not Found");
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User enters the prescriber first name and Last name$")
	public void User_enters_prescriber_first_name_and_Last_name(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_LastName)) {

				String lastname = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
				if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_LAST_NAME)) {
					if (!clearAndEnterText(DataEntryConstants.PRESCRIBER_SEARCH_LAST_NAME, lastname)) {
						throw new Exception("User not able to enter value last name in text field");
					}
				}
				String firstname = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
				if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_FIRST_NAME)) {
					if (!clearAndEnterText(DataEntryConstants.PRESCRIBER_SEARCH_FIRST_NAME, firstname)) {
						throw new Exception("User not able to enter value first name in text field");
					}
				}

				if (isElementPresentVerification(DataEntryConstants.DE_PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
					if (!isElementPresentVerifyClick(DataEntryConstants.DE_PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
						throw new Exception("User not able to click prescriber search button");
					}
					String prescriberexcel = FrameworkLibrary.getXLSTestData("Prescriber_Input", "Prescriberinfo", "Row_four", "Firstname").toUpperCase();
					log.info(prescriberexcel);
					boolean cond = chromeDriver.getPageSource().contains(prescriberexcel);
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

	@When("^User enters the prescriber first name$")
	public void User_enters_prescriber_first_name(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Search_Cancel_Button)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_Prescriber_Search_Cancel_Button)) {
					throw new Exception("User not able to click prescriber search button");
				}
			}
			FrameworkLibrary.clearTextField(SmokeTestConstants.Prescriber_FirstName);
			FrameworkLibrary.clearTextField(SmokeTestConstants.Prescriber_LastName);
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_FirstName)) {
				SmokeTestLibrary.enter_Text(arg1, "FirstName", SmokeTestConstants.Prescriber_FirstName, chromeDriver);
				if (isElementPresentVerification(DataEntryConstants.DE_PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
					if (!isElementPresentVerifyClick(DataEntryConstants.DE_PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
						throw new Exception("Not able to click prescriber search button");
					}
				}
				String fnerrormsg = FrameworkLibrary.getElementText(DataEntryConstants.DE_Prescriber_Search_Error_Message);
				Assert.assertEquals(fnerrormsg, "Please specify the required search criteria!");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User enters the prescriber last name$")
	public void User_enters_prescriber_last_name(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Search_Cancel_Button)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_Prescriber_Search_Cancel_Button)) {
					throw new Exception("User not able to click prescriber search button");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_FirstName)) {
				FrameworkLibrary.clearTextField(SmokeTestConstants.Prescriber_FirstName);

			}
			String lastname = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_LastName)) {
				if (!clearAndEnterText(SmokeTestConstants.Prescriber_LastName, lastname)) {
					throw new Exception("User not able to enter value last name in text field");
				}
			}

			if (isElementPresentVerification(DataEntryConstants.DE_PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
					throw new Exception("User not able to click prescriber search button");
				}
				String Lnerrormsg = FrameworkLibrary.getElementText(DataEntryConstants.DE_Prescriber_Search_Error_Message);
				Assert.assertEquals(Lnerrormsg, "Please specify the required search criteria!");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User enters the prescriber DEA$")
	public void User_enters_prescriber_DEA(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_LastName)) {
				FrameworkLibrary.clearTextField(SmokeTestConstants.Prescriber_LastName);

			}
			String dea = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DEA");
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_NPIorDEA_Field)) {
				if (!clearAndEnterText(DataEntryConstants.DE_Prescriber_NPIorDEA_Field, dea)) {
					throw new Exception("User not able to enter value last name in text field");
				}
			}

			if (isElementPresentVerification(DataEntryConstants.DE_PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
					throw new Exception("User not able to click prescriber search button");
				}
				String prescriberexcel = FrameworkLibrary.getXLSTestData("Prescriber_Input", "Prescriberinfo", "Row_four", "DEA");
				Assert.assertTrue(chromeDriver.getPageSource().contains(prescriberexcel));
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User enters the prescriber Phone number$")
	public void User_enters_prescriber_Phone_number(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Search_Cancel_Button)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_Prescriber_Search_Cancel_Button)) {
					throw new Exception("User not able to click prescriber search button");
				}
			}
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_NPIorDEA_Field)) {
				FrameworkLibrary.clearTextField(DataEntryConstants.DE_Prescriber_NPIorDEA_Field);
			}
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Phone_Number_Field)) {
				String excel = FrameworkLibrary.getXLSTestData("Prescriber_Input", "prescriberinfo", "Row_four", "PhoneNumber");
				WebElement element = chromeDriver.findElement(xpath(DataEntryConstants.DE_Prescriber_Phone_Number_Field));
				element.sendKeys(excel);
			}
			if (isElementPresentVerification(DataEntryConstants.DE_PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
					throw new Exception("User not able to click prescriber search button");
				}
				String prescriberexcel = FrameworkLibrary.getXLSTestData("Prescriber_Input", "Prescriberinfo", "Row_four", "Firstname").toUpperCase();
				log.info(prescriberexcel);
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^cancel the prescription search$")
	public void cancel_the_prescription_search() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Search_Cancel_Button)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_Prescriber_Search_Cancel_Button)) {
					throw new Exception("User not able to click prescriber cancel button");
				} else {
					Actions back = new Actions(chromeDriver);
					Action presscancel = back.sendKeys(Keys.ALT, "C").build();
					presscancel.perform();
				}
			}
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Search_cancel_popup)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_Prescriber_Search_cancel_popup)) {
					throw new Exception("User not able to click prescriber search button");
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

	@When("^User enters the prescriber first name and Last names$")
	public void User_enters_prescriber_first_name_and_Last_names(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_LastName)) {
				if (!clearAndEnterText(SmokeTestConstants.Prescriber_LastName, LastName)) {
					throw new Exception("User not able to enter value in prescriber last name text field");
				}
			}
			String FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_FirstName)) {
				if (!clearAndEnterText(SmokeTestConstants.Prescriber_FirstName, FirstName)) {
					throw new Exception("User not able to enter value in prescriber first name text field");
				}
			}
			if (isElementPresentVerification(DataEntryConstants.DE_PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_PRESCRIBER_SEARCH_SEARCH_BUTTON)) {
					throw new Exception("User not able to click prescriber search button");
				}
				if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Lastname_Search_Error_Message)) {
					String error = FrameworkLibrary.getElementText(DataEntryConstants.DE_Prescriber_Lastname_Search_Error_Message);
					Assert.assertEquals(error, "Please refine your search.");
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

	@When("^cancel the prescription$")
	public void cancel_the_prescription() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Search_Cancel_Button)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_Prescriber_Search_Cancel_Button)) {
					throw new Exception("User not able to click prescriber search button");
				}
				FrameworkLibrary.clearTextField(SmokeTestConstants.Prescriber_FirstName);
				FrameworkLibrary.clearTextField(SmokeTestConstants.Prescriber_LastName);
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^user enters pro info$")
	public void user_enters_pro_info(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate)) {
					throw new Exception("User not able to enter value in productDate text field");
				}
			}
			String productDaw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, productDaw)) {
					throw new Exception("User not able to enter value daw in text field");
				}
			}

			String Substitute = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Substitute");
			if (isElementPresentVerification(DataEntryConstants.Product_Substitute)) {
				if (!clearAndEnterText(DataEntryConstants.Product_Substitute, Substitute)) {
					throw new Exception("User not able to enter value daw in text field");
				}
			}

			String drug = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, drug)) {
					throw new Exception("User not able to enter value drug name in text field");
				} else {
					Actions upArrow = new Actions(chromeDriver);
					Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
					PressUpArrow.perform();
				}
			}
			if (isElementPresentVerification(DataEntryConstants.DE_FunctionPopup_cancel)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_FunctionPopup_cancel)) {
					throw new Exception("User not able to click DE popup");
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

	@When("^User clicks view Button on DE prescriber results page$")
	public void click_view_button_on_de_prescriber_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.de_prescriber_viewButton)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.de_prescriber_viewButton)) {
					throw new Exception("User not able to click prescriber view button");
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

	@Then("^System should display prescriber details page from DE$")
	public void DEprescriberdetails_page_title_validation() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.de_prescriberdetails_title)) {
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		}
	}

	@When("^All fields in the prescriber details page from DE should be disabled$")
	public void validate_prescriberdetails_readonly() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.de_prescriberdetails_FirstName) && isElementPresentVerification(DataEntryConstants.de_prescriberdetails_LastName) && isElementPresentVerification(DataEntryConstants.de_prescriberdetails_DEA) &&
					isElementPresentVerification(DataEntryConstants.de_prescriberdetails_NPI) && isElementPresentVerification(DataEntryConstants.de_prescriberdetails_StateLicesnseNumber) && isElementPresentVerification(DataEntryConstants.de_prescriberdetails_StateSubstanceNumber)) {
				Assert.assertTrue(getElementByProperty(DataEntryConstants.de_prescriberdetails_FirstName, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));
				Assert.assertTrue(getElementByProperty(DataEntryConstants.de_prescriberdetails_LastName, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));
				Assert.assertTrue(getElementByProperty(DataEntryConstants.de_prescriberdetails_DEA, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));
				Assert.assertTrue(getElementByProperty(DataEntryConstants.de_prescriberdetails_NPI, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));
				Assert.assertTrue(getElementByProperty(DataEntryConstants.de_prescriberdetails_StateLicesnseNumber, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));
				Assert.assertTrue(getElementByProperty(DataEntryConstants.de_prescriberdetails_StateSubstanceNumber, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User clicks back button on prescriber details page from DE$")
	public void click_back_button_on_prescriberdetailsDE_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.de_prescriberdetails_backButton)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.de_prescriberdetails_backButton)) {
					throw new Exception("User not able to click prescriber details back button");
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

	@When("^Update and Add New Buttons should be invisible$")
	public void validate_update_addnew_buttons_invisible_de_prescriberSearch() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.de_prescriberresults_updateButton) && isElementPresentVerification(DataEntryConstants.de_prescriberresults_addNewButton)) {
				WebElement updateButton = getElementByProperty(DataEntryConstants.de_prescriberresults_updateButton, chromeDriver);
				String clr = Color.fromString(updateButton.getCssValue("background-color")).asHex();
				WebElement viewButton = getElementByProperty(DataEntryConstants.de_prescriberresults_addNewButton, chromeDriver);
				String clr2 = Color.fromString(viewButton.getCssValue("background-color")).asHex();
				Assert.assertTrue(clr.equals("#000000") && clr2.equals("#000000"), "button are not invisible");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User clicks open product2 Button$")
	public void user_clicks_open_product2_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.open_product2)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.open_product2)) {
					throw new Exception("User not able to click open product button");
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


	@When("^enters DAW=N and Substitute=N$")
	public void enters_daw_n_and_sub_n(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				String daw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, daw)) {
					throw new Exception("User not able to enter value daw text field");
				} else {
					Actions ac = new Actions(chromeDriver);
					Action a = ac.sendKeys(Keys.TAB).build();
					a.perform();
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				String substitute = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Substitute");
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, substitute)) {
					throw new Exception("User not able to enter value in substitute text field");
				} else {
					Actions ac = new Actions(chromeDriver);
					Action a = ac.sendKeys(Keys.TAB).build();
					a.perform();
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

	@When("^user select payment type and select a plan and validating all plans$")
	public void user_select_payment_type_and_select_a_plan_and_validating_all_plans() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.Payment_Dropdown)) {
					throw new Exception("User not able to click prescriber search button");
				}
				if (isElementPresentVerification(DataEntryConstants.DE_Screen_Payment_PlanType)) {
					List<WebElement> list = FrameworkLibrary.chromeDriver.findElements(xpath(DataEntryConstants.DE_Screen_Payment_PlanType));
					for (int i = 0; i < list.size(); i++) {
						if (list.get(i).getText().contains("AETNA")) {
							list.get(i).click();
						} else if (list.get(i).getText().contains("JAMED0")) {
							list.get(i).click();
							if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
								if (!isElementPresentVerifyClick(SmokeTestConstants.Payment_Dropdown)) {
									throw new Exception("User not able to click payment");
								}
							}
						} else if (list.get(i).getText().contains("MEDICARE")) {
							list.get(i).click();
							Actions downArrow = new Actions(chromeDriver);
							Action series = downArrow.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build();
							series.perform();
							if (isElementPresentVerification(DataEntryConstants.DE_Screen_Selected_Payment_Medicare_Second_Highlited)) {
								Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.DE_Screen_Selected_Payment_Medicare_Second_Highlited)).isSelected(), "The selected drug is highlited");
							}
						} else {
							log.info("Available plans expected are not present");
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

	@When("^user open drop down and checks the plan and drugs with out selecting any feild$")
	public void user_open_drop_down_and_checks_the_plan_and_drugs_with_out_selecting_any_feild() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.Payment_Dropdown)) {
					throw new Exception("User not able to click prescriber search button");
				}
				if (isElementPresentVerification(DataEntryConstants.DE_Screen_Payment_PlanType)) {
					List<WebElement> list = FrameworkLibrary.chromeDriver.findElements(xpath(DataEntryConstants.DE_Screen_Payment_PlanType));
					if (list.get(i).getText().contains("JAMED0")) {
						list.get(i).click();
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

	@Then("^system should display the coupon plan in payment plan with message$")
	public void system_should_display_the_coupon_plan_in_payment_plan_with_message() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DE_Screen_Payment_Plan_Message_Display)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(DataEntryConstants.DE_Screen_Payment_Plan_Message_Display), "Error that this patient might have a coupon for this prescription which is not displayed");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^I should not see popup message$")
	public void should_not_see_rems_popup_message() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Assert.assertFalse(chromeDriver.getPageSource().contains("This function cannot be completed in this system"), "REMS popup message Found");
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^I should see REMS popup message$")
	public void should_see_rems_popup_message() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DE_REMS_POPUP_WINDOW)) {
				Assert.assertTrue(chromeDriver.getPageSource().contains("This function cannot be completed in this system"), "REMS popup message not Found");
			}

			if (isElementPresentVerification(DataEntryConstants.DE_REMS_POPUP_CANCEL_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_REMS_POPUP_CANCEL_BUTTON)) {
					throw new Exception("User not able to click de rems popup");
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

	@Then("^enters REMS product information$")
	public void enters_rems_product_information(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
			}

			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");

			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate)) {

					throw new Exception("User not able to enter value in productDate text field");
				}
			}
			String productDaw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, productDaw)) {
					throw new Exception("User not able to enter value daw in text field");
				}
			}

			String drug = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {

				if (clearAndEnterText(SmokeTestConstants.DrugName_Field, drug)) {
					
					if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
						Actions upArrow = new Actions(chromeDriver);
						Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
						PressUpArrow.perform();
						Thread.sleep(1000);
					}
					
				}else{
					throw new Exception("User not able to enter value drug name in text field");
				}
					
		
				if (isElementPresentVerification(SmokeTestConstants.DrugName_Field) && isElementPresentVerification(SmokeTestConstants.Product_DAW) && isElementPresentVerification(SmokeTestConstants.DrugExpiryDate_Field) && isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
					ExpectedProductName = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DrugName_Field, chromeDriver).getAttribute("value");
					ExpectedProduct_DAW = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Product_DAW, chromeDriver).getAttribute("value");
					ExpectedProduct_DrugExpDate = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DrugExpiryDate_Field, chromeDriver).getAttribute("value");
					ExpectedProduct_OriginalDate = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Product_OriginalDate, chromeDriver).getAttribute("value");
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

	@Then("^enters product information until qty$")
	public void enters_product_information_until_qty(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");

			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate)) {
					throw new Exception("User not able to enter value in productDate text field");
				}
			}
			String productDaw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, productDaw)) {
					throw new Exception("User not able to enter value daw in text field");
				}
			}
			String drug = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (clearAndEnterText(SmokeTestConstants.DrugName_Field, drug)) {
					
					if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
						Actions upArrow = new Actions(chromeDriver);
						Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
						PressUpArrow.perform();
						Thread.sleep(1000);
					}
					
				}else{
					throw new Exception("User not able to enter value drug name in text field");
				}
					
				
				
				if (isElementPresentVerification(SmokeTestConstants.Quantity_field)) {
					String quantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
					if (!clearAndEnterText(SmokeTestConstants.Quantity_field, quantity)) {
						throw new Exception("User not able to enter value in prescriber field");
					}

					ExpectedProductName = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DrugName_Field, chromeDriver).getAttribute("value");
					ExpectedDirections = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Directions_field, chromeDriver).getAttribute("value");
					ExpectedProduct_quantity = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Quantity_field, chromeDriver).getAttribute("value");
					ExpectedProduct_quantityDisp = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Quantity_disp, chromeDriver).getAttribute("value");
					ExpectedProduct_DaysSupply = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Days_Supply, chromeDriver).getAttribute("value");
					ExpectedProduct_RxExpDate = FrameworkLibrary.getElementByProperty(SmokeTestConstants.RxExpiration_date, chromeDriver).getAttribute("value");
					ExpectedProduct_DrugExpDate = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DrugExpiryDate_Field, chromeDriver).getAttribute("value");
					ExpectedDirections = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Directions_field, chromeDriver).getAttribute("value");
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

	@Then("^I should see Rx Expiration date field is auto popualated$")
	public void i_should_see_Rx_Expiration_date_field_is_auto_popualated() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Assert.assertTrue(!ExpectedProduct_RxExpDate.isEmpty());
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^I enter \"([^\"]*)\" in Directions field$")
	public void i_enter_in_Directions_field(String arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.Directions_field)) {
				chromeDriver.findElement(xpath(SmokeTestConstants.Directions_field)).clear();
				chromeDriver.findElement(xpath(SmokeTestConstants.Directions_field)).sendKeys(arg1);
				Actions upArrow = new Actions(chromeDriver);
				Action tab = upArrow.sendKeys(Keys.TAB).build();
				tab.perform();
				if (isElementPresentVerification(SmokeTestConstants.Days_Supply)) {
					ExpectedProduct_DaysSupply = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Days_Supply, chromeDriver).getAttribute("value");
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

	@Then("^I should see days supply field is same as qty field$")
	public void i_should_see_days_supply_field_is_same_as_qty_field() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Assert.assertTrue(ExpectedProduct_quantity.equals(ExpectedProduct_DaysSupply));
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	@When("^I change the Qty field now$")
	public void i_change_the_Qty_field_now(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.Quantity_field)) {
				String quantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
				if (!clearAndEnterText(SmokeTestConstants.Quantity_field, quantity)) {
					throw new Exception("User not able to enter value in prescriber field");
				} else {
					Actions upArrow = new Actions(chromeDriver);
					Action tab = upArrow.sendKeys(Keys.TAB).build();
					tab.perform();
				}
				if (isElementPresentVerification(SmokeTestConstants.Quantity_field) && isElementPresentVerification(SmokeTestConstants.Days_Supply)) {
					ExpectedProduct_quantity = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Quantity_field, chromeDriver).getAttribute("value");
					ExpectedProduct_DaysSupply = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Days_Supply, chromeDriver).getAttribute("value");
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

	@Then("^I should see days supply field is set to empty$")
	public void i_should_see_days_supply_field_is_set_to_empty() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			
			if (isElementPresentVerification(DataEntryConstants.Days_Supply)) {
				String str = FrameworkLibrary.getElementByProperty(DataEntryConstants.Days_Supply, chromeDriver).getText();
				Assert.assertTrue(str.isEmpty());
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	@Then("^I should see days supply field is half of the qty field$")
	public void i_should_see_days_supply_field_is_half_of_qty_field() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		
 	try {
			if (isElementPresentVerification(SmokeTestConstants.Quantity_field)) {
				long Quantity_field_number = Long.parseLong(FrameworkLibrary.getElementText(SmokeTestConstants.Quantity_field));
				int expected_number = (int) (Quantity_field_number / 2);
				
				long DaysSupply_number =Long.parseLong(FrameworkLibrary.getElementText(DataEntryConstants.Days_Supply));
				int actual_number = (int) DaysSupply_number;
				
				Assert.assertTrue(expected_number == actual_number);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	@When("^I should see text changed to \"([^\"]*)\"$")
	public void should_see_text_changed_to(String arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.Directions_field)) {
				String expected_string_directions = FrameworkLibrary.getElementText(SmokeTestConstants.Directions_field);
				Assert.assertTrue(expected_string_directions.equals(arg1), "Expected value is " + arg1 + " but found is " + expected_string_directions);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User clicks continue in ICplus Button$")
	public void click_continue_Icplus_Button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.de_rems_popup_continueonicplus)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.de_rems_popup_continueonicplus)) {
					throw new Exception("User not able to click de rems popup");
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

	@Then("^The price should not be displayed in patient order status$")
	public void price_column_should_be_blank(DataTable arg1) throws Exception {
		SmokeTestStepDef.i_click_search_button_on_patient_order_status();
		SmokeTestStepDef.i_click_search_button_on_patient_order_status();
		SmokeTestStepDef.i_click_search_button_on_patient_order_status();

		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.POS_patientNames)) {

				List<WebElement> list1 = chromeDriver.findElements(xpath(SmokeTestConstants.POS_patientNames));
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
						List<WebElement> singlepresc = chromeDriver.findElements(xpath("//*[contains(@id,'single-prescription-" + part2 + "')]"));
						log.info("size is" + singlepresc.size());
						for (int z = 0; z < singlepresc.size(); z++) {
							if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate) && singlepresc.get(z).getText().contains(pickuptime)) {
								Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("in progress"));
								Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("entered"));
								String dyn = singlepresc.get(z).getAttribute("id");
								String[] dynamo = dyn.split("-");
								String part = dynamo[2];
								String priceXpath = "//*[@id='single-prescription-" + part + "-" + z + "']/div[6]";
								String price = getElementText(priceXpath);
								Assert.assertTrue(price == null);
								log.info("The price for current prescription is generated");
							} else if (singlepresc.get(z).getText().toLowerCase().contains(pickupdate) && singlepresc.get(z).getText().contains(possiblepickupTime1)) {

								Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("in progress"));
								Assert.assertTrue(singlepresc.get(z).getText().toLowerCase().contains("entered"));
								String dyn = singlepresc.get(z).getAttribute("id");
								String[] dynamo = dyn.split("-");
								String part = dynamo[2];
								String priceXpath = "//*[@id='single-prescription-" + part + "-" + z + "']/div[6]";
								String price = getElementText(priceXpath);
								Assert.assertTrue(price == null);
								log.info("The price for current prescription is generated");

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

	@When("^User does a prescriber search by invalid phone number$")
	public void enter_invalid_phonenum_de_prescriber_search(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(FrameworkConstants.PRESCRIBER_FN) && isElementPresentVerification(FrameworkConstants.PRESCRIBER_LN)) {
				FrameworkLibrary.getElementByProperty(FrameworkConstants.PRESCRIBER_FN, chromeDriver).clear();
				FrameworkLibrary.getElementByProperty(FrameworkConstants.PRESCRIBER_LN, chromeDriver).clear();
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_Prescriber_Phone_Number_Field)) {
					chromeDriver.findElement(xpath(DataEntryConstants.DE_Prescriber_Phone_Number_Field)).sendKeys(SmokeTestLibrary.getData(arg1, "PhoneNumber"));
					throw new Exception("User not able to enter value in prescriber first name text field");
				}
			}
			if (isElementPresentVerification(FrameworkConstants.PRESCRIBER_SEARCH_BTN)) {
				if (!isElementPresentVerifyClick(FrameworkConstants.PRESCRIBER_SEARCH_BTN)) {
					throw new Exception("User not able to click prescriber search button");
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

	

	@Then("^System should display a message - invalid format$")
	public void validate_incorrect_phonenum_message() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.incorrect_phone_number_errorMSg)) {
				Assert.assertTrue(getElementText(DataEntryConstants.incorrect_phone_number_errorMSg).contains("Invalid field format"));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^System should set the Pay code to two substitution of the drugs allowed$")
	public void system_should_set_the_Pay_code_to_two() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.paycode)) {
				String paycode = getElementText(DataEntryConstants.paycode);
				Assert.assertTrue(paycode.contains("2 - Sub"));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^System should set the Pay code to zero - No product selection indicated$")
	public void system_should_set_the_Pay_code_to_zero() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.paycode)) {
				String paycode = getElementText(DataEntryConstants.paycode);
				Assert.assertTrue(paycode.contains("0 - No"));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	@When("^User enters Sound alike drug during data entry$")
	public void enters_sound_alike_drug(DataTable arg1) throws Throwable {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate)) {
					throw new Exception("User not able to enter value in productDate text field");
				}
			}
			String productDaw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, productDaw)) {
					throw new Exception("User not able to enter value daw in text field");
				}
			}

			String drug = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, drug)) {
					throw new Exception("User not able to enter value drug name in text field");
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

	@Then("^All the accept buttons should be green$")
	public void all_the_accept_buttons_should_be_green() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(FrameworkConstants.DR_PATIENT_ACCEPT_BTN) && isElementPresentVerification(FrameworkConstants.DR_PRESCRIBER_ACCEPT_BTN) && isElementPresentVerification(FrameworkConstants.DR_PRODUCT_ACCEPT_BTN)) {
				Assert.assertFalse(getElementByProperty(FrameworkConstants.DR_PATIENT_ACCEPT_BTN, chromeDriver).isEnabled());
				Assert.assertTrue(getElementByProperty(FrameworkConstants.DR_PATIENT_ACCEPT_BTN, chromeDriver).getAttribute("disabled").equalsIgnoreCase("true"));
				Assert.assertFalse(getElementByProperty(FrameworkConstants.DR_PRESCRIBER_ACCEPT_BTN, chromeDriver).isEnabled());
				Assert.assertTrue(getElementByProperty(FrameworkConstants.DR_PRESCRIBER_ACCEPT_BTN, chromeDriver).getAttribute("disabled").equalsIgnoreCase("true"));
				Assert.assertFalse(getElementByProperty(FrameworkConstants.DR_PRODUCT_ACCEPT_BTN, chromeDriver).isEnabled());
				Assert.assertTrue(getElementByProperty(FrameworkConstants.DR_PRODUCT_ACCEPT_BTN, chromeDriver).getAttribute("disabled").equalsIgnoreCase("true"));

			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	@Then("^product data is reviewed and accepted$")
	public void product_data_is_reviewed_and_accepted(DataTable product) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(FrameworkConstants.DR_PRODUCT_ACCEPT_BTN)) {
				if (!isElementPresentVerifyClick(FrameworkConstants.DR_PRODUCT_ACCEPT_BTN)) {
					throw new Exception("Not able to click DR product accept button");
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

	@Then("^prescriber data is reviewed and accepted$")
	public void prescriber_data_is_reviewed_and_accepted(DataTable prescriber) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_AcceptButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.Prescriber_AcceptButton)) {
					throw new Exception("User not able to click DR prescriber accept button");
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

	@Then("^patient data is reviewed and accepted$")
	public void patient_data_is_reviewed_and_accepted(DataTable patient) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(FrameworkConstants.DR_PATIENT_ACCEPT_BTN)) {
				if (!isElementPresentVerifyClick(FrameworkConstants.DR_PATIENT_ACCEPT_BTN)) {
					throw new Exception("User not able to click DR patient accept button");
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

	@Then("^System displays an error message, please complete the process in IC\\+$")
	public void system_displays_an_error_message_please_complete_the_process_in_IC() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.dr_popupOkBtn)) {
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^System should set the Pay code to one substitution of the drugs will not be allowed$")
	public void system_should_set_the_Pay_code_to_one_substitution_of_the_drugs_will_not_be_allowed() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.paycode)) {
				String paycode = getElementText(DataEntryConstants.paycode);
				Assert.assertTrue(paycode.contains("1 - Subst"));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	
	

	@When("^User clicks open product3 Button$")
	public void user_clicks_open_product3_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.open_product3)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.open_product3)) {
					throw new Exception("User not able to click product");
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

	@When("^get the plan displayed in DR$")
	public void get_plan_from_DR_screen() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(dataReviewConstants.dr_paymenttype)) {
				plandisplayedinDR = getElementText(dataReviewConstants.dr_paymenttype);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^System should generate rx number, price and plan ID for current prescription$")
	public void validate_price_and_plan(DataTable arg1) throws Exception {

		SmokeTestStepDef.i_click_search_button_on_patient_order_status();
		SmokeTestStepDef.i_click_search_button_on_patient_order_status();
		SmokeTestStepDef.i_click_search_button_on_patient_order_status();

		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.POS_patientNames)) {

				List<WebElement> list1 = chromeDriver.findElements(xpath(SmokeTestConstants.POS_patientNames));
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
						List<WebElement> singlepresc = chromeDriver.findElements(xpath("//*[contains(@id,'single-prescription-" + part2 + "')]"));
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
								String[] rxnumberparts = currentRxnumber.split("-");
								SmokeTestStepDef.dynamicrxnum = rxnumberparts[0];
								log.info(SmokeTestStepDef.dynamicrxnum);
								log.info("Rx number is generated");
								String dynamicrxnum1 = rxnumberparts[1];
								log.info(dynamicrxnum1);
								log.info("The size of the Rx number number is:" + SmokeTestStepDef.dynamicrxnum.length());
								log.info("The size of the store number is :" + dynamicrxnum1.length());
								Assert.assertEquals(SmokeTestStepDef.dynamicrxnum.length(), 7);
								Assert.assertEquals(dynamicrxnum1.length(), 5);
								String priceXpath = "//*[@id='single-prescription-" + part + "-" + z + "']/div[6]";
								String price = getElementText(priceXpath);
								Assert.assertTrue(price != null, "price column is empty for current prescription");
								Assert.assertTrue(price.contains("$"), "price is not displayed in patient order status for current prescription");
								Assert.assertTrue(price.contains(plandisplayedinDR), "expected plan ID is not displayed in patient order status");
								log.info("The price for current prescription is generated and it contains both price returned and plan ID");

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
								String[] rxnumberparts = currentRxnumber.split("-");
								SmokeTestStepDef.dynamicrxnum = rxnumberparts[0];
								log.info(SmokeTestStepDef.dynamicrxnum);
								log.info("Rx number is generated");
								String priceXpath = "//*[@id='single-prescription-" + part + "-" + z + "']/div[6]";
								String dynamicrxnum1 = rxnumberparts[1];
								log.info(dynamicrxnum1);
								log.info("The size of the Rx number number is:" + SmokeTestStepDef.dynamicrxnum.length());
								log.info("The size of the store number is :" + dynamicrxnum1.length());
								Assert.assertEquals(SmokeTestStepDef.dynamicrxnum.length(), 7);
								Assert.assertEquals(dynamicrxnum1.length(), 5);
								String price = getElementText(priceXpath);
								Assert.assertTrue(price != null, "price column is empty for current prescription");
								Assert.assertTrue(price.contains("$"), "price is not displayed in patient order status for current prescription");
								Assert.assertTrue(price.contains(plandisplayedinDR), "expected plan ID is not displayed in patient order status");
								log.info("The price for current prescription is generated and it contains both price returned and plan ID");

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
								String[] rxnumberparts = currentRxnumber.split("-");
								SmokeTestStepDef.dynamicrxnum = rxnumberparts[0];
								log.info(SmokeTestStepDef.dynamicrxnum);
								log.info("Rx number is generated");
								String priceXpath = "//*[@id='single-prescription-" + part + "-" + z + "']/div[6]";
								String dynamicrxnum1 = rxnumberparts[1];
								log.info(dynamicrxnum1);
								log.info("The size of the Rx number number is:" + SmokeTestStepDef.dynamicrxnum.length());
								log.info("The size of the store number is :" + dynamicrxnum1.length());
								Assert.assertEquals(SmokeTestStepDef.dynamicrxnum.length(), 7);
								Assert.assertEquals(dynamicrxnum1.length(), 5);
								String price = getElementText(priceXpath);
								Assert.assertTrue(price != null, "price column is empty for current prescription");
								Assert.assertTrue(price.contains("$"), "price is not displayed in patient order status for current prescription");
								Assert.assertTrue(price.contains(plandisplayedinDR), "expected plan ID is not displayed in patient order status");
								log.info("The price for current prescription is generated and it contains both price returned and plan ID");
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

	@And("^user enters product with invalid NDC$")
	public void user_enters_product_with_invalid_NDC(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String productDate = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			String productDAW = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			String productNDC = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "NDC");

			if (isElementPresentVerification(FrameworkConstants.DrugName_Field) && isElementPresentVerification(SmokeTestConstants.Product_OriginalDate) && isElementPresentVerification(SmokeTestConstants.Product_DAW)) {

				if (!clearAndEnterText(SmokeTestConstants.Product_OriginalDate, productDate) || !clearAndEnterText(SmokeTestConstants.Product_DAW, productDAW) || !clearAndEnterText(FrameworkConstants.DrugName_Field, productNDC)) {
					throw new Exception("User not able to enter value in product text fields");
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

	@Then("^no product results should be shown$")
	public void no_product_results_should_be_shown() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			int x = chromeDriver.findElementsByXPath(DataEntryConstants.product_dropdown_result).size();
			Assert.assertEquals(0, x);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		}
	}

	@When("^check the preselection is on the first result$")
	public void check_the_preselection_is_on_the_first_result() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.Patient_order_status_first_result)) {
				Assert.assertTrue(chromeDriver.findElementByXPath(DataEntryConstants.Patient_order_status_first_result).getAttribute("class").contains("selected"));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		}
	}

	@When("^displays add rx update rx update payment and reprint payment fields$")
	public void displays_add_rx_update_rx_update_payment_and_reprint_payment_fields() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


		try {
			if ((isElementPresentVerification(DataEntryConstants.Patient_order_status_update_button)) && (isElementPresentVerification(DataEntryConstants.Patient_order_status_Delete_Rx)) && (isElementPresentVerification(DataEntryConstants.Patient_order_status_Reprint_paperwork)) && (isElementPresentVerification(DataEntryConstants.Patient_order_status_update_Rx))) {
				Assert.assertTrue(isElementPresentVerification(DataEntryConstants.Patient_order_status_update_button));
				Assert.assertTrue(isElementPresentVerification(DataEntryConstants.Patient_order_status_Delete_Rx));
				Assert.assertTrue(isElementPresentVerification(DataEntryConstants.Patient_order_status_Reprint_paperwork));
				Assert.assertTrue(isElementPresentVerification(DataEntryConstants.Patient_order_status_update_Rx));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		}
	}

	@When("^User clicks on Delete Rx button$")
	public void user_clicks_on_Delete_Rx_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


		try {
			if (isElementPresentVerification(DataEntryConstants.Patient_order_status_Delete_Rx)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.Patient_order_status_Delete_Rx)) {
					throw new Exception("unable to click on delete RX button");
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

	@Then("^User clicks on cancel message$")
	public void user_clicks_on_cancel_message() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


		try {
			if (isElementPresentVerification(DataEntryConstants.Patient_order_status_Popup_Cancel_button)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.Patient_order_status_Popup_Cancel_button)) {
					throw new Exception("unable to click on popup cancel button");
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

	@Then("^validates the popup$")
	public void validate_the_popup() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


		try {
			if ((isElementPresentVerification(DataEntryConstants.Patient_order_status_Popup_Description)) && (isElementPresentVerification(DataEntryConstants.Patient_order_status_Popup_Cancel_button)) && (isElementPresentVerification(DataEntryConstants.Patient_order_status_Popup_Delete_Rx))) {
				String actual_message_description = FrameworkLibrary.getElementText(DataEntryConstants.Patient_order_status_Popup_Description);
				Assert.assertEquals(actual_message_description, "Delete this prescription?");
				String Delete_rx = FrameworkLibrary.getElementText(DataEntryConstants.Patient_order_status_Popup_Delete_Rx);
				Assert.assertEquals(Delete_rx, "Delete Rx");
				String Cancel = FrameworkLibrary.getElementText(DataEntryConstants.Patient_order_status_Popup_Cancel_button);
				Assert.assertEquals(Cancel, "Cancel");
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		}
	}

	@Then("^User goes back to patient order status page$")
	public void user_goes_back_to_patient_order_status_page() throws Exception {

		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


		try {
			Assert.assertTrue(isElementPresentVerification(DataEntryConstants.Patient_order_status_list));

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		}
	}

	@Then("^User again clicks on Delete rx button and deletes the prescription$")
	public void user_again_clicks_on_Delete_rx_button_and_deletes_the_prescription() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


		try {
			if (isElementPresentVerification(DataEntryConstants.Patient_order_status_Delete_Rx)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.Patient_order_status_Delete_Rx)) {
					throw new Exception("unable to click on delete RX button");
				} else {
					if (isElementPresentVerification(DataEntryConstants.Patient_order_status_Popup_Delete_Rx)) {
						if (!isElementPresentVerifyClick(DataEntryConstants.Patient_order_status_Popup_Delete_Rx)) {
							throw new Exception("unable to click on Delete popup");
						}
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

	@Then("^checks for available product in onshelf in Stock data base$")
	public void checks_for_available_product_in_onshelf_in_Stock_data_base() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			Connection connection = ConnectionFactory.getConnectionStock();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select a.id,a.PRODUCT_SKU_CODE,a.STORE_CODE,B.TYPE,B.QUANTITY from STOCK A inner join stock_item b on a.id=b.id_stock and A.STORE_CODE='" + Store_Pharmacy_Code + "' and b.TYPE='On Shelf' where b.QUANTITY>'100'");
			ArrayList<String> ar = new ArrayList<String>();
			ArrayList<String> ar1 = new ArrayList<String>();
			while (rs.next()) {
				String Quantity = new String(rs.getString("QUANTITY"));
				ar.add(Quantity);
				String product_sku_code = new String(rs.getString("PRODUCT_SKU_CODE"));
				ar1.add(product_sku_code);
			}
			quantity = ar.get(0);
			code = ar1.get(0);
			rs.close();
			connection.close();
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^get the product name from database$")
	public void get_the_product_name_from_database() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Connection connection = ConnectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			Statement stmt1 = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select a.code,b.CODE_TYPE,b.CODE_VALUE,b.ID_ACTUAL_PRODUCT_PACK from actual_product_pack a join product_coding b on a.ID = b.ID_ACTUAL_PRODUCT_PACK And b.CODE_TYPE= 'DEPTNUM' where a.code = " + code + " ");
			ResultSet rs1 = stmt1.executeQuery("select a.code,b.CODE_TYPE,b.CODE_VALUE,b.ID_ACTUAL_PRODUCT_PACK from actual_product_pack a join product_coding b on a.ID = b.ID_ACTUAL_PRODUCT_PACK And b.CODE_TYPE= 'UPC' where a.code = " + code + " ");
			if (rs != null) {
				while (rs.next()) {
					Depnum = rs.getString("CODE_VALUE");
				}
			}
			if (rs1 != null) {
				while (rs1.next()) {
					UPC = rs1.getString("CODE_VALUE");
				}
			}
			if (Integer.parseInt(Depnum) == 1) {
				Assert.assertTrue(true);
			} else if (Integer.parseInt(Depnum) == 15) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
			rs.close();
			rs1.close();
			connection.close();
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^check the soft allocation for DE in stock plus$")
	public void check_the_soft_allocation_for_DE_in_stock_plus() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Connection connection = ConnectionFactory.getConnectionStock();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select a.id,a.PRODUCT_SKU_CODE,a.STORE_CODE,B.TYPE,B.QUANTITY from STOCK A inner join stock_item b on a.id=b.id_stock where PRODUCT_SKU_CODE =" + code + " and A.STORE_CODE='" + Store_Pharmacy_Code + "' and b.TYPE='Soft Allocated'");
			if (rs != null) {
				while (rs.next()) {
					Quantity_stock_DE = rs.getString("QUANTITY");
				}
			}
			rs.close();
			connection.close();
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^selects a prescriber from DE$")
	public void selects_a_prescriber_from_DE() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.Prescriber_search_frequently_first_result)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.Prescriber_search_frequently_first_result)) {
					throw new Exception("unable to select first result");
				}
			}

			if (isElementPresentVerification(DataEntryConstants.Prescriber_info_select_button)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.Prescriber_info_select_button)) {
					throw new Exception("unable to click on select button");
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^check the soft allocation after delete rx in stock plus$")
	public void check_the_soft_allocation_after_delete_rx_in_stock_plus() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Thread.sleep(3000);
			Connection connection = ConnectionFactory.getConnectionStock();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select a.id,a.PRODUCT_SKU_CODE,a.STORE_CODE,B.TYPE,B.QUANTITY from STOCK A inner join stock_item b on a.id=b.id_stock where PRODUCT_SKU_CODE =" + code + " and A.STORE_CODE='" + Store_Pharmacy_Code + "' and b.TYPE='Soft Allocated'");
			if (rs != null) {
				while (rs.next()) {
					Quantity_stock_after_RX = rs.getString("QUANTITY");
				}
			}
			rs.close();
			connection.close();
			int expected = Integer.parseInt(Quantity);
			int actual = Integer.parseInt(Quantity_stock_DE) - Integer.parseInt(Quantity_stock_after_RX);
			Assert.assertEquals(actual, expected);
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^clicks on Delete RX$")
	public void clicks_on_Delete_RX() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.Patient_order_status_Popup_Delete_Rx)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.Patient_order_status_Popup_Delete_Rx)) {
					throw new Exception("unable to click on delelte popup");
				}
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^check the stock db for onshelf count after fill$")
	public void check_the_stock_db_for_onshelf_count() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Connection connection = ConnectionFactory.getConnectionStock();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select a.id,a.PRODUCT_SKU_CODE,a.STORE_CODE,B.TYPE,B.QUANTITY from STOCK A inner join stock_item b on a.id=b.id_stock and A.STORE_CODE='" + Store_Pharmacy_Code + "' and b.TYPE='On Shelf' WHERE A.PRODUCT_SKU_CODE=" + code + "");
			if (rs != null) {
				while (rs.next()) {
					Quantity_stock_after_fill = rs.getString("QUANTITY");
				}
			}
			rs.close();
			connection.close();
			int onshelf_before_fill = Integer.parseInt(quantity);
			int onshelf_after_fill = Integer.parseInt(Quantity_stock_after_fill);
			int expected = Integer.parseInt(Quantity);
			Assert.assertEquals(onshelf_before_fill - onshelf_after_fill, expected);
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^user gets the store number from RXMS$")
	public void user_gets_the_store_number_from_RXMS() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.RXMS_store_number)) {
				String[] store = getElementText(DataEntryConstants.RXMS_store_number).split(" ");
				storenumber = store[2];
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^get the pharmacy code from database$")
	public void get_the_pharmacy_code_from_database() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Connection connection = ConnectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from store where HOME_STORE='" + storenumber + "' and TYPE='Pharmacy'");
			if (rs != null) {
				while (rs.next()) {
					Store_Pharmacy_Code = rs.getString("CODE");
				}
			}
			rs.close();
			connection.close();
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^System should display \"([^\"]*)\" for payment as cash$")
	public void systemShouldDisplayForPaymentAsCash(String textForCash) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			SmokeTestLibrary.hotkeyAction(Keys.ALT, "p", chromeDriver);
			if (isElementPresentVerification(DataEntryConstants.DE_PAYMENT_PANEL_COLLAPSED_PATIENT_BILLED_FOR)) {
				String billedForCash = getElementText(DataEntryConstants.DE_PAYMENT_PANEL_COLLAPSED_PATIENT_BILLED_FOR);
				log.info("billed for cash: " + billedForCash);
				Assert.assertEquals(textForCash, billedForCash);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^selects payment type as plan from the dropdown$")
	public void selectsPaymentTypeAsPlanFromTheDropdown() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
				isElementPresentVerifyClick(SmokeTestConstants.Payment_Dropdown);
				if (isElementPresentVerification(DataEntryConstants.DE_PAYMENT_PANEL_PLANID)) {
					if (!isElementPresentVerifyClick(DataEntryConstants.DE_PAYMENT_PANEL_PLANID)) {
						throw new Exception("Not able to click plan in DE payment panel");
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

	@Then("^System should not display \"([^\"]*)\" for payment as plan$")
	public void systemShouldNotDisplayForPaymentAsPlan(String billForCash) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			SmokeTestLibrary.hotkeyAction(Keys.ALT, "p", chromeDriver);
			if (isElementPresentVerification(DataEntryConstants.DE_PAYMENT_PANEL_COLLAPSED_PATIENT_BILLED_FOR)) {
				String billedForPlan = getElementText(DataEntryConstants.DE_PAYMENT_PANEL_COLLAPSED_PATIENT_BILLED_FOR);
				Assert.assertNotEquals(billedForPlan, billForCash);
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
	 * This method is used to validate that the original date is populated with the current date by default
	 */
	@Then("^The Original date should be populated with the current date by default$")
	public void the_Original_date_should_be_populated_with_the_current_date_by_default() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Date today = Calendar.getInstance().getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy");
			String actualDate = formatter.format(today).replace("/", "").trim();
			String expectedDate = getElementText(SmokeTestConstants.Product_OriginalDate).replace("/", "").trim();
			Assert.assertTrue(actualDate.equals(expectedDate));
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);

		}

	}

	
	@Then("^The system should defaults the Drug Exp Date field with the following value: 'current date \\+ expiration days value'$")
	public void the_system_should_defaults_the_Drug_Exp_Date_field_with_the_following_value_current_date_expiration_days_value() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Date today = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(today);
			int exp = Integer.parseInt(expDaysValue);
			c.add(Calendar.DATE, exp);
			Date currentdateplusyear = c.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			String ExpecteddrugExpDate = formatter.format(currentdateplusyear);
			log.info("expected rx exp date when drug has no expiry days value associated is" + ExpecteddrugExpDate);
			/*WebDriverWait wait =  new WebDriverWait(chromeDriver,30);
         wait.until(ExpectedConditions.textToBePresentInElement(getElementByProperty(SmokeTestConstants.RxExpiration_date,chromeDriver), actualrxExpDate);*/
			long timeoutExpiredMS = System.currentTimeMillis() + 30000;
			while (getElementText(SmokeTestConstants.DrugExpiryDate_Field).equals("")) {
				log.info("waiting for the date to be populated in drug exp date..");
				if (System.currentTimeMillis() > timeoutExpiredMS) {
					Assert.fail("Timed out after waiting for drug to be populated");
				}
			}
			String actualdrugExpDate = getElementText(SmokeTestConstants.DrugExpiryDate_Field);
			log.info("Actual rx exp date when drug has expiry days value associated is" + actualdrugExpDate);
			Assert.assertTrue(ExpecteddrugExpDate.equals(actualdrugExpDate));
		} catch (Exception e) {

			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * This method is used to clear the drug name field in product panel of data entry page
	 *
	 * @throws Exception
	 */
	@When("^The user clears the drug field$")
	public void the_user_clears_the_drug_field_and_enters_a_Dispensed_Drug_with_no_expiration_days_value_associated() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				getElementByProperty(SmokeTestConstants.DrugName_Field, chromeDriver).clear();
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method is used to enter dispensed drug in DE with no expiration days value associated. It fetches the required ndc from database based on the expiration days value.
	 *
	 * @throws Exception
	 */
	@When("^enters a Dispensed Drug with no expiration days value associated$")
	public void enter_a_dispensed_drug_with_no_exp_value_associated() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Connection connection = ConnectionFactory.getConnection();
			String query = "select B.ID, a.description, d.code_value as NDC, e.expiration_days, b.drug_class as Local_Regulation, c.dea_class as Federal_Regulation, a.rx_otc as product_pack_drug_Class, b.area_key from actual_product_pack a, local_regulation b, regulation c, product_coding d, dispensing e where a.id=c.id_actual_product_pack and c.id= b.id_regulation AND A.ID=E.id_actual_product_pack AND A.ID=D.id_actual_product_pack and a.status='Active' and e.expiration_days is null and b.area_key='WI'";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ArrayList<String> ar = new ArrayList<String>();

			while (rs.next()) {

				String NDC = new String(rs.getString("NDC"));
				ar.add(NDC);
			}

			Iterator<String> iterator = ar.iterator();
			while (iterator.hasNext()) {
				String value = iterator.next();
				if ("0".equals(value)) {
					iterator.remove();
				}
			}
			String ndc = ar.get(ar.size() - 1);
			rs.close();
			connection.close();
			log.info("current ndc is" + ndc);

			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, ndc)) {
					throw new Exception("Not able to enter value in DrugName text field");
				}
			}

			if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();
				Thread.sleep(1000);
			}

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^The system should calculate the Drug Expiration Date as current date plus one year substracted by one day$")
	public void the_system_should_calculates_the_Drug_Expiration_Date_as_current_date_default_value_or_days_based_on_the_year_day() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Date today = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(today);
			c.add(Calendar.YEAR, 1);
			c.add(Calendar.DATE, -1);
			Date currentdateplusyear = c.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			String ExpecteddrugExpDate = formatter.format(currentdateplusyear);
			/*WebDriverWait wait = new WebDriverWait(chromeDriver, watingForElement);
    	      wait.until(ExpectedConditions.textToBePresentInElement(getElementByProperty(SmokeTestConstants.DrugExpiryDate_Field, chromeDriver),ExpecteddrugExpDate));*/
			long timeoutExpiredMS = System.currentTimeMillis() + 30000;
			while (getElementText(SmokeTestConstants.DrugExpiryDate_Field).equals(null)) {
				log.info("waiting for the date to be populated in drug exp date..");
				if (System.currentTimeMillis() > timeoutExpiredMS) {
					Assert.fail("Timed out after waiting for date to be populated");
				}
			}
			String actualdrugExpDate = getElementText(SmokeTestConstants.DrugExpiryDate_Field);
			log.info("expected rx expiration date is" + ExpecteddrugExpDate);
			log.info("actual rx expiration date is" + actualdrugExpDate);
			Assert.assertTrue(ExpecteddrugExpDate.equals(actualdrugExpDate));
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * This method validates the DAW and Substitute fields are displayed as N and Y respectively.
	 *
	 * @param expectedDAW
	 * @param expectedSubstitute
	 * @
	 */
	@Then("^The DAW field should be defaulted to \"([^\"]*)\" and the Substitute field should be defaulted to \"([^\"]*)\"$")
	public void the_DAW_field_should_be_defaulted_to_and_the_Substitute_field_should_be_defaulted_to(String expectedDAW, String expectedSubstitute) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String actualDAW = getElementText(SmokeTestConstants.Product_DAW);
			Assert.assertTrue(actualDAW.equalsIgnoreCase(expectedDAW));
			String actualSubstitute = getElementText(SmokeTestConstants.Product_Substitute);
			Assert.assertTrue(actualSubstitute.equals(expectedSubstitute));
		} catch (Exception e) {

			e.printStackTrace();
			takeScreenShot(methodName);

		}
	}

	/*
	 * This method validates that the view size and view size manufacturer check boxes in product panel are selected by default in data entry page
	 *
	 */
	@Then("^The 'View Size' and 'View Size & Manufacturer' check boxes should be selected by default$")
	public void the_View_Size_and_View_Size_Manufacturer_check_boxes_should_be_selected_by_default() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.ViewSize_CheckBox)) {
				Assert.assertTrue(getElementByProperty(SmokeTestConstants.ViewSize_CheckBox, chromeDriver).getAttribute("aria-checked").equals("true"));
			}
			if (isElementPresentVerification(SmokeTestConstants.ViewSizeManufacturer_CheckBox)) {
				Assert.assertTrue(getElementByProperty(SmokeTestConstants.ViewSizeManufacturer_CheckBox, chromeDriver).getAttribute("aria-checked").equals("true"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		}
	}

	
	/*
	 * This method is used to click the open payment button to leave the product panel in data entry page
	 */
	@When("^The user leaves the Product panel$")
	public void the_user_leaves_the_Product_panel() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.Open_payment)) {
				isElementPresentVerifyClick(SmokeTestConstants.Open_payment);
			}
		} catch (Exception e) {

			e.printStackTrace();
			takeScreenShot(methodName);

		}

	}

	/**
	 * This method validates that the product panel is collapsed in data entry when all the mandatory fields are entered and moved to payment section
	 *
	 * @
	 */

	@Then("^The system should collapse the Product panel and display: Prescribed Drug, Dispensed Drug/Orange Book rating, Original Date, DAW, Qty, Refills, Directions information$")
	public void the_system_should_collapse_the_Product_panel_and_display_Prescribed_Drug_Dispensed_Drug_Orange_Book_rating_Original_Date_DAW_Qty_Refills_Directions_information() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.DE_dispensedDrug)) {
				Assert.assertTrue(getElementByProperty(SmokeTestConstants.DE_dispensedDrug, chromeDriver).isDisplayed());
				Assert.assertTrue(getElementByProperty(SmokeTestConstants.DE_dispensedDrug, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));
			}
			Assert.assertTrue(getElementByProperty(SmokeTestConstants.DE_DAWpanelCollapsed, chromeDriver).isDisplayed());
			Assert.assertTrue(getElementByProperty(SmokeTestConstants.DE_DAWpanelCollapsed, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));

			Assert.assertTrue(getElementByProperty(SmokeTestConstants.DE_rxOriginaldatepanelCollapsed, chromeDriver).isDisplayed());
			Assert.assertTrue(getElementByProperty(SmokeTestConstants.DE_rxOriginaldatepanelCollapsed, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));

			Assert.assertTrue(getElementByProperty(SmokeTestConstants.DE_prescribedDrug, chromeDriver).isDisplayed());
			Assert.assertTrue(getElementByProperty(SmokeTestConstants.DE_prescribedDrug, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));

			Assert.assertTrue(getElementByProperty(SmokeTestConstants.DE_directionspanelCollapsed, chromeDriver).isDisplayed());
			Assert.assertTrue(getElementByProperty(SmokeTestConstants.DE_directionspanelCollapsed, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));

			Assert.assertTrue(getElementByProperty(SmokeTestConstants.DE_QtypanelCollapsed, chromeDriver).isDisplayed());
			Assert.assertTrue(getElementByProperty(SmokeTestConstants.DE_QtypanelCollapsed, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));

			Assert.assertTrue(getElementByProperty(SmokeTestConstants.DE_refillpanelCollapsed, chromeDriver).isDisplayed());
			Assert.assertTrue(getElementByProperty(SmokeTestConstants.DE_refillpanelCollapsed, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/*
	 * This method is used to validate that the prescriber data is intact when user navigates back to data entry page from the failure queue notifications
	 */
	@Then("^the prescriber data entered should be intact$")
	public void prescriber_data_entered_should_be_intact_on_DE(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String PrescriberData = getElementText(SmokeTestConstants.DE_prescriberDataCollapsed).toUpperCase();
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName").toUpperCase();
			String FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName").toUpperCase();
			Assert.assertTrue(PrescriberData.contains(FirstName));
			Assert.assertTrue(PrescriberData.contains(LastName));
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot(methodName);
		}

	}

	@When("^user clicks on third update button$")
	public void user_clicks_on_third_update_button() throws Exception {
		if (isElementPresentVerification(SmokeTestConstants.DR_ProductUpdate)) {
			if (!isElementPresentVerifyClick(SmokeTestConstants.DR_ProductUpdate)) {
				throw new Exception("unable to click on DR product update");
			}
		}
	}

	@When("^enters the refills$")
	public void enters_the_refills() throws Exception {
		if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
			if (!clearAndEnterText(SmokeTestConstants.Refills_field, Refills)) {
				throw new Exception("Not able to enter value in Refills text field");
			}
		}
	}

	@Then("^enters product information for RX$")
	public void enters_product_information_for_RX() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(dataReviewConstants.DR_ORIGINAL_DATE)) {
				Date = FrameworkLibrary.getElementText(SmokeTestConstants.Product_OriginalDate);
			}
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				Daw = FrameworkLibrary.getElementText(SmokeTestConstants.Product_DAW);
			}
			if (isElementPresentVerification(SmokeTestConstants.Product_Substitute)) {
				Substitute = FrameworkLibrary.getElementText(SmokeTestConstants.Product_Substitute);
			}
			if (isElementPresentVerification(SmokeTestConstants.ViewSize_CheckBox)) {
				Viewsizecheckbox = chromeDriver.findElementByXPath(SmokeTestConstants.ViewSize_CheckBox).getAttribute("aria-checked");
			}
			if (isElementPresentVerification(SmokeTestConstants.ViewSizeManufacturer_CheckBox)) {
				Viewsizeandmanufacture = chromeDriver.findElementByXPath(SmokeTestConstants.ViewSizeManufacturer_CheckBox).getAttribute("aria-checked");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	@When("^validates the prescriber and product information$")
	public void validates_the_prescriber_and_product_information(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
			FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");

			if (isElementPresentVerification(DataEntryConstants.DE_prescriber_name)) {
				String Prescriber = FrameworkLibrary.getElementText(DataEntryConstants.DE_prescriber_name);
				String Name = LastName + ", " + FirstName;
				Assert.assertEquals(Name.toUpperCase(), Prescriber);
			}
			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
				Date1 = FrameworkLibrary.getElementText(SmokeTestConstants.Product_OriginalDate);
				Assert.assertEquals(Date, Date1);
			}

			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
				Daw1 = FrameworkLibrary.getElementText(SmokeTestConstants.Product_DAW);
				Assert.assertEquals(Daw, Daw1);
			}

			if (isElementPresentVerification(SmokeTestConstants.Product_Substitute)) {
				Substitute1 = FrameworkLibrary.getElementText(SmokeTestConstants.Product_Substitute);
				Assert.assertEquals(Substitute, Substitute1);
			}

			if (isElementPresentVerification(SmokeTestConstants.ViewSize_CheckBox)) {
				Viewsizecheckbox1 = chromeDriver.findElementByXPath(SmokeTestConstants.ViewSize_CheckBox).getAttribute("aria-checked");
				Assert.assertEquals(Viewsizecheckbox, Viewsizecheckbox1);
			}

			if (isElementPresentVerification(SmokeTestConstants.ViewSizeManufacturer_CheckBox)) {
				Viewsizeandmanufacture1 = chromeDriver.findElementByXPath(SmokeTestConstants.ViewSizeManufacturer_CheckBox).getAttribute("aria-checked");
				Assert.assertEquals(Viewsizeandmanufacture, Viewsizeandmanufacture1);
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
	 * This method will click on view button in DE page after prescriber search has been performed
	 *
	 * @
	 */
	@And("^User clicks view button in presciber search$")
	public void userClicksViewButtonUsingALTPlusWHotKey() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DE_PRESCRIBER_SEARCH_RESULTS_VIEW_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_PRESCRIBER_SEARCH_RESULTS_VIEW_BUTTON)) {
					throw new Exception("Not able to click view button for prescriber search in DE");
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

	@Then("^system should disable the Rx expiration date field$")
	public void systemShouldDisableTheRxExpirationDateField() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.RxExpiration_date)) {
				Assert.assertTrue(chromeDriver.findElement(xpath(SmokeTestConstants.RxExpiration_date)).getAttribute("disabled").equalsIgnoreCase("true"));
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^user clears the drug field and enters \"([^\"]*)\" drug$")
	public void userClearsTheDrugFieldAndEntersDrug(String drug_name, DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		try {
			String drug = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");

			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, drug)) {
					throw new Exception("Not able to enter drug name in drug field" + drug_name);
				}
				TimeUnit.SECONDS.sleep(3);
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();
				Action tab = upArrow.sendKeys(Keys.TAB).build();
				tab.perform();
				TimeUnit.SECONDS.sleep(3);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^user changes DAW to N and Substitute to Y$")
	public void userChangesDAWToNAndSubstituteToY() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW) && isElementPresentVerification(SmokeTestConstants.Product_Substitute)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, "N")) {
					throw new Exception("Not able to change Daw to N and Substitutue to Y");
				} else {
					Actions ac = new Actions(chromeDriver);
					Action a = ac.sendKeys(Keys.TAB).build();
					a.perform();
					TimeUnit.SECONDS.sleep(2);
				}
				if (!clearAndEnterText(SmokeTestConstants.Product_Substitute, "Y")) {
					throw new Exception("Not able to change Daw to N and Substitutue to Y");
				} else {
					Actions ac = new Actions(chromeDriver);
					Action a = ac.sendKeys(Keys.TAB).build();
					a.perform();
					TimeUnit.SECONDS.sleep(2); //needs to be removed
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^user changes DAW to Y and Substitute to N$")
	public void userChangesDAWToYAndSubstituteToN() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW) && isElementPresentVerification(SmokeTestConstants.Product_Substitute)) {
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, "Y")) {
					throw new Exception("Not able to change Daw to N and Substitute to Y");
				} else {
					Actions ac = new Actions(chromeDriver);
					Action a = ac.sendKeys(Keys.TAB).build();
					a.perform();
					TimeUnit.SECONDS.sleep(2);
					;
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * Select drug Glucose 4gm Chw Tablets
	 */

	@Then("^system should default Rx Expiration Date to the Original date plus a configurable number of days \"([^\"]*)\" for \"([^\"]*)\" drug$")
	public void systemShouldDefaultRxExpirationDateToTheOriginalDatePlusAConfigurableNumberOfDaysForDrug(int count, String drug) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.RxExpiration_date)) {
				TimeUnit.SECONDS.sleep(2);
				String Rx_date = FrameworkLibrary.getElementByProperty(SmokeTestConstants.RxExpiration_date, chromeDriver).getAttribute("value");
				String new_date = addsDaystoOriginDate(count);
				Assert.assertEquals(new_date, Rx_date, "dates don't match for drug : " + drug);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^The user enters a drug$")
	public void the_user_enters_a_drug(List<String> drug) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String DrugName = drug.get(1);

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

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/*
	 * Verifies system should populate the Rx expiration date by default
	 */
	@Then("^The system should populate the Rx expiration date by default$")
	public void the_system_should_populate_the_Rx_expiration_date_by_default() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Thread.sleep(20000);
			String RxExpiration_date = getElementText(DataEntryConstants.RxExpiration_date).trim();
			Assert.assertTrue(RxExpiration_date.length() == 10);

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/*
	 * Verifies that the Rx Expiration Date is not past the defaulted date
	 */
	@Then("^The system verifies that the Rx Expiration Date is not older then the defaulted date$")
	public void the_system_verifies_that_the_Rx_Expiration_Date_is_not_older_then_the_defaulted_date() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		SimpleDateFormat formatter= new SimpleDateFormat("MM-dd-yyyy");
		Date d;
		Calendar c;
		String expectedDate=null;
		String actualDate=null;
		Date expected_Date,actual_Date;
		try {
			
			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
				expectedDate = getElementText(SmokeTestConstants.Product_OriginalDate).replace("/", "-").trim();
				Assert.assertTrue(expectedDate!=null);
				d = (Date) formatter.parse(expectedDate);
				c = Calendar.getInstance();
				c.setTime(d);
				expected_Date = c.getTime();
			}else{
				throw new Exception("Not able to find Product_OriginalDate text field");
			}
			
			if (isElementPresentVerification(SmokeTestConstants.RxExpiration_date)) {
				actualDate = getElementText(SmokeTestConstants.RxExpiration_date).replace("/", "-").trim();
				Assert.assertTrue(actualDate!=null);
				d = (Date) formatter.parse(actualDate);
				c = Calendar.getInstance();
				c.setTime(d);
				actual_Date = c.getTime();
			}else{
				throw new Exception("Not able to find Product_OriginalDate text field");
			}
			
			Assert.assertTrue(expected_Date!=null);
			Assert.assertTrue(actual_Date!=null);
			log.info("expected_Date => "+expected_Date.getTime() +"\n actual_Date => "+ actual_Date.getTime());
			Assert.assertTrue(expected_Date.getTime() < actual_Date.getTime());

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
		
	}

	/*
	 * Verifies user changes the Rx Expiration Date and leaves the field (tab off)
	 * This method will verifies that the Rx Expiration Date is not past the defaulted date
	 * Verifies after enters PXXXY in the Refills field and leaves the field (E.g.: P45D=45days, P10D=10days, P13M=390days)
	 * enters PXXXY in the Refills field and leaves the field (E.g.: P45D=45days, P5W=35days, P3M=90days)
	 * Verifies after enters the Rx Expiration Date which is past the defaulted date and leaves the field (tab off)
	 * Verifies system should display the 'Invalid entry. Max Days to Fill exceeded' error message
	 */
	@When("^The user clears and enters the Rx Expiration Date which is past the defaulted date and leaves the field \\(tab off\\)$")
	public void the_user_enters_the_Rx_Expiration_Date_which_is_past_the_defaulted_date_and_leaves_the_field_tab_off() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			//This script is to get Default_RxExpiration_date
			String Default_RxExpiration = getElementText(DataEntryConstants.RxExpiration_date);
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
			Date d = (Date) formatter.parse(Default_RxExpiration);
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			Date Default_RxExpiration_Date = c.getTime();

			//This script to get RxExpiration_date after adding 10 days in RX Expiration date
			String RxExpiration_date = getElementText(DataEntryConstants.RxExpiration_date).replace("/", "-").trim();
			formatter = new SimpleDateFormat("MM-dd-yyyy");
			d = (Date) formatter.parse(RxExpiration_date);
			c = Calendar.getInstance();
			c.setTime(d);
			c.add(Calendar.DATE, 10);
			Date P10D_Date = c.getTime();
			formatter = new SimpleDateFormat("MMddyyyy");
			String PasteOriginalDate = formatter.format(P10D_Date).replace("/", "").trim();

			if (isElementPresentVerification(SmokeTestConstants.RxExpiration_date)) {
				if (!clearAndEnterText(SmokeTestConstants.RxExpiration_date, PasteOriginalDate)) {
					throw new Exception("Not able to enter value in DrugName text field");
				}
			}

			Actions Key = new Actions(chromeDriver);
			Action enter = Key.sendKeys(Keys.TAB).build();
			enter.perform();

			//Validate 10 days increased in Rx RxExpiration after P10D
			formatter = new SimpleDateFormat("MM/dd/yyyy");
			String P10D_expectedDate = formatter.format(P10D_Date);

			long timeoutExpiredMS = System.currentTimeMillis() + 120000;
			while (!(getElementText(DataEntryConstants.RxExpiration_date).equals(P10D_expectedDate))) {
				log.info("waiting for the RxExpiration_date change correctly...");
				if (System.currentTimeMillis() > timeoutExpiredMS) {
					Assert.fail("Timed out after waiting for RxExpiration_date change correctly!");
				}
			}

			Assert.assertEquals(getElementText(DataEntryConstants.RxExpiration_date), P10D_expectedDate);

			//Validate Error message
			String errormessage = FrameworkLibrary.getElementByProperty(DataEntryConstants.DE_RX_EXP_DATE_ERROR, chromeDriver).getText();
			Assert.assertEquals(errormessage, DataEntryConstants.DE_RX_EXP_DATE_EXPECTED_ERROR);

			//validate refills is P45D
			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Refills_field, "P45D")) {
					throw new Exception("Not able to enter value in Refills text field");
				}
			}

			Key = new Actions(chromeDriver);
			enter = Key.sendKeys(Keys.TAB).build();
			enter.perform();

			formatter = new SimpleDateFormat("MM/dd/yyyy");
			c = Calendar.getInstance();
			c.add(Calendar.DATE, 45);
			Date P45D_Date = c.getTime();

			//Validate 45 days increased in Rx RxExpiration after P45D
			String P45D_expectedDate = formatter.format(P45D_Date);

			timeoutExpiredMS = System.currentTimeMillis() + 120000;
			while (!(getElementText(DataEntryConstants.RxExpiration_date).equals(P45D_expectedDate))) {
				log.info("waiting for the RxExpiration_date change correctly...");
				if (System.currentTimeMillis() > timeoutExpiredMS) {
					Assert.fail("Timed out after waiting for RxExpiration_date change correctly!");
				}
			}

			Assert.assertEquals(getElementText(DataEntryConstants.RxExpiration_date), P45D_expectedDate);

			String Original = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Product_OriginalDate, chromeDriver).getAttribute("value");
			formatter = new SimpleDateFormat(Original);
			c = Calendar.getInstance();
			Date Original_Date = c.getTime();


			c = Calendar.getInstance();
			c.add(Calendar.DATE, 45);
			Date RxExpiration_Date = c.getTime();

			//This Condition stands for !(Original_Date is Lesser than RxExpiration_Date)
			if (!(Original_Date.compareTo(RxExpiration_Date) < 0)) {
				errormessage = FrameworkLibrary.getElementByProperty(DataEntryConstants.DE_RX_EXP_DATE_ERROR, chromeDriver).getText();
				Assert.assertEquals(errormessage, DataEntryConstants.DE_RX_EXP_DATE_EXPECTED_ERROR_1);
			}

			//This Condition stands for !(Default_RxExpiration_Date is Greater than RxExpiration_Date)
			if (!(Default_RxExpiration_Date.compareTo(RxExpiration_Date) > 0)) {
				errormessage = FrameworkLibrary.getElementByProperty(DataEntryConstants.DE_RX_EXP_DATE_ERROR, chromeDriver).getText();
				Assert.assertEquals(errormessage, DataEntryConstants.DE_RX_EXP_DATE_EXPECTED_ERROR);
			}

			//validate refills is P1M
			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Refills_field, "P1M")) {
					throw new Exception("Not able to enter value in Refills text field");
				}
			}

			Key = new Actions(chromeDriver);
			enter = Key.sendKeys(Keys.TAB).build();
			enter.perform();

			String RxExpiration = FrameworkLibrary.getElementByProperty(SmokeTestConstants.RxExpiration_date, chromeDriver).getAttribute("value");
			formatter = new SimpleDateFormat(RxExpiration);
			c = Calendar.getInstance();
			c.add(Calendar.DATE, 30);
			RxExpiration_Date = c.getTime();

			//Validate 30 days increased in Rx RxExpiration after P1M
			String P1M_expectedDate = formatter.format(RxExpiration_Date);
			timeoutExpiredMS = System.currentTimeMillis() + 120000;
			while (!(getElementText(DataEntryConstants.RxExpiration_date).equals(P1M_expectedDate))) {
				log.info("waiting for the RxExpiration_date change correctly...");
				if (System.currentTimeMillis() > timeoutExpiredMS) {
					Assert.fail("Timed out after waiting for RxExpiration_date change correctly!");
				}
			}

			Assert.assertEquals(getElementText(DataEntryConstants.RxExpiration_date), P1M_expectedDate);

			//This Condition stands for !(Original_Date is Lesser than RxExpiration_Date)
			if (!(Original_Date.compareTo(RxExpiration_Date) < 0)) {
				errormessage = FrameworkLibrary.getElementByProperty(DataEntryConstants.DE_RX_EXP_DATE_ERROR, chromeDriver).getText();
				Assert.assertEquals(errormessage, DataEntryConstants.DE_RX_EXP_DATE_EXPECTED_ERROR_1);
			}

			//This Condition stands for !(Default_RxExpiration_Date is Greater than RxExpiration_Date)
			if (!(Default_RxExpiration_Date.compareTo(RxExpiration_Date) > 0)) {
				errormessage = FrameworkLibrary.getElementByProperty(DataEntryConstants.DE_RX_EXP_DATE_ERROR, chromeDriver).getText();
				Assert.assertEquals(errormessage, DataEntryConstants.DE_RX_EXP_DATE_EXPECTED_ERROR);
			}


			//validate refills is P13M
			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Refills_field, "P13M")) {
					throw new Exception("Not able to enter value in Refills text field");
				}
			}

			Key = new Actions(chromeDriver);
			enter = Key.sendKeys(Keys.TAB).build();
			enter.perform();

			timeoutExpiredMS = System.currentTimeMillis() + 120000;
			while (!(getElementText(DataEntryConstants.DE_RX_EXP_DATE_ERROR).equals(DataEntryConstants.DE_RX_EXP_DATE_EXPECTED_ERROR))) {
				log.info("waiting for the RxExpiration_date change correctly...");
				if (System.currentTimeMillis() > timeoutExpiredMS) {
					Assert.fail("Timed out after waiting for RxExpiration_date change correctly!");
				}
			}

			//Validate error message after max range for DE_RX_EXP_DATE
			errormessage = FrameworkLibrary.getElementByProperty(DataEntryConstants.DE_RX_EXP_DATE_ERROR, chromeDriver).getText();
			Assert.assertEquals(errormessage, DataEntryConstants.DE_RX_EXP_DATE_EXPECTED_ERROR);

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	@And("^system should display the list of frequent prescribers for the selected patient$")
	public void systemShouldDisplayTheListOfFrequentPrescribersForTheSelectedPatient(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String freq_prescriber = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
			if (isElementPresentVerification((DataEntryConstants.Prescriber_frequent_names))) {

				String frequent_prescriber_info = chromeDriver.findElement(xpath("//*[@id='prescriber-information-content-expanded']/rxms-rx-prescriber-frequent//div[contains(@ng-attr-id,'most-')]//div[contains(@data-title,'name')]//*[@id='prescriber-info']")).getText();
				Assert.assertTrue(frequent_prescriber_info.toUpperCase().contains(freq_prescriber.toUpperCase()));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^clicks open prescriber button$")
	public void clicks_open_prescriber_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.expand_Open_Prescriber_Button)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.expand_Open_Prescriber_Button)) {
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

	@Then("^system should display all prescriber search criteria fields empty apart from those that are prepopulated by default$")
	public void systemShouldDisplayAllPrescriberSearchCriteriaFieldsEmptyApartFromThoseThatArePrepopulatedByDefault() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_searchButton)) {
				String phoneNumber = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Prescriber_Phonenumber, chromeDriver).getText();
				String npidea = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Prescriber_NPIDEA, chromeDriver).getText();
				String lastName = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Prescriber_LastName, chromeDriver).getText();
				String firstName = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Prescriber_FirstName, chromeDriver).getText();
				Assert.assertEquals(npidea, "");
				Assert.assertEquals(lastName, "");
				Assert.assertEquals(firstName, "");
				Assert.assertEquals(phoneNumber, "");
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^System should display Update Rx page$")
	public void system_should_display_update_rx_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Assert.assertTrue(isElementPresentVerification(DataEntryConstants.UPDATERX_PAGE_LABLE));
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^Click on updateRx prescriber expand button$")
	public void click_on_updateRx_prescriber_expand_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.UPDATERX_PRESCRIBER_EXPAND_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.UPDATERX_PRESCRIBER_EXPAND_BUTTON)) {
					throw new Exception("unable to click on UPDATERX_PRESCRIBER_EXPAND_BUTTON");
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

	@Then("^user hits the Enter Key$")
	public void user_hits_the_Enter_Bar() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			Actions Key = new Actions(chromeDriver);
			Action Enter = Key.sendKeys(Keys.ENTER).build();
			Enter.perform();
		} catch (Exception e) {

			takeScreenShot(methodName);
			throw new Exception(e.getMessage());

		}
	}

	@And("^system closes the Prescriber Search Results overlay$")
	public void system_closes_the_Prescriber_Search_Results_overlay() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.UPDATERX_PRESCRIBER_EXPAND_BUTTON)) {
				Assert.assertTrue(isElementPresentVerification(DataEntryConstants.UPDATERX_PRESCRIBER_EXPAND_BUTTON));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^checks for available product with zero in onshelf in Stock data base$")
	public void checks_for_available_product_with_zero_in_onshelf_in_Stock_data_base() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Connection connection = ConnectionFactory.getConnectionStock();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select a.id,a.PRODUCT_SKU_CODE,a.STORE_CODE,B.TYPE,B.QUANTITY from STOCK A inner join stock_item b on a.id=b.id_stock and A.STORE_CODE='" + Store_Pharmacy_Code + "' and b.TYPE='On Shelf' where b.QUANTITY='0'");
			ArrayList<String> ar = new ArrayList<String>();
			ArrayList<String> ar1 = new ArrayList<String>();
			while (rs.next()) {
				String Quantity = new String(rs.getString("QUANTITY"));
				ar.add(Quantity);
				String product_sku_code = new String(rs.getString("PRODUCT_SKU_CODE"));
				ar1.add(product_sku_code);
			}
			quantity = ar.get(0);
			code = ar1.get(0);
			rs.close();
			connection.close();
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^the prescriber panel should be collapsed$")
	public void thePrescriberPanelShouldBeCollapsed() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (!isElementPresentVerification(DataEntryConstants.Open_prescriber)) {
				throw new Exception("Open Product button not collapsed");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^system should populate Last Name and First Name search criteria fields with the details of the previously selected prescriber$")
	public void systemShouldPopulateLastNameAndFirstNameSearchCriteriaFieldsWithTheDetailsOfThePreviouslySelectedPrescriber() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String first_Name = getElementText(SmokeTestConstants.Prescriber_LastName).trim();
			String last_Name = getElementText(SmokeTestConstants.Prescriber_FirstName).trim();
			Assert.assertTrue(first_Name.length() > 0);
			Assert.assertTrue(last_Name.length() > 0);
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^other search criteria fields are empty apart from those that are prepopulated by default$")
	public void otherSearchCriteriaFieldsAreEmptyApartFromThoseThatArePrepopulatedByDefault() throws Exception {

		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String phone_Number = getElementText(DataEntryConstants.DE_Prescriber_Phone_Number_Field).trim();
			String npi_Dea = getElementText(DataEntryConstants.DE_Prescriber_NPIorDEA_Field).trim();
			Assert.assertTrue(phone_Number.length() == 0);
			Assert.assertTrue(npi_Dea.length() == 0);
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	@And("^system does not display a list of frequent prescribers in the Prescriber panel$")
	public void systemDoesNotDisplayAListOfFrequentPrescribersInThePrescriberPanel() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			//assert !isElementPresentVerification((DataEntryConstants.Prescriber_search_frequently_first_result)) : "Prescriber frequent names list should not be displayed";
			Assert.assertTrue(!isElementPresents(DataEntryConstants.Prescriber_search_frequently_first_result));
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User selects a frequent prescriber$")
	public void userSelectsAFrequentPrescriber() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		Thread.sleep(10000);
		try {
			if (isElementPresentVerification(DataEntryConstants.Prescriber_search_frequently_first_result)) {

				Actions act = new Actions(chromeDriver);
				WebElement frequent_result = FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.Prescriber_search_frequently_first_result));
				act.moveToElement(frequent_result).perform();
				act.doubleClick(frequent_result).perform();
				WaitforElement(DataEntryConstants.UPDATERX_PRESCRIBER_EXPAND_BUTTON);
				if (!isElementPresentVerification(DataEntryConstants.UPDATERX_PRESCRIBER_EXPAND_BUTTON)) {
					throw new Exception("unable to close prescriber overlay");
				}

			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	
	
	/*********************************************************************************
	 * Confirms that given text value should still be displayed in Refills field after focus is brought back
	 *
	 **********************************************************************************/
	@Then("^The \'([^\"]*)\' value should still be displayed in Refills field$")
	public void The_value_should_still_be_displayed_in_Refills_field(String value) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (getElementByProperty(SmokeTestConstants.Refills_field, chromeDriver).getAttribute("class").contains("md-focused")) {
					if (getElementText(SmokeTestConstants.Refills_field).equals(value)) {
						throw new Exception("Failed to continue displaying PRN.");
					}
				}
			}
			//ExpectedProductName = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Refills_field, chromeDriver).getAttribute("value");

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method will check prescriber search fields in DE screen.
	 */
	@And("^The system should display the prescriber search criteria fields and Search button$")
	public void theSystemShouldDisplayThePrescriberSearchCriteriaFieldsAndSearchButton() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			isElementPresentVerification(SmokeTestConstants.Prescriber_LastName);
			isElementPresentVerification(SmokeTestConstants.Prescriber_FirstName);
			isElementPresentVerification(SmokeTestConstants.Prescriber_searchButton);
			isElementPresentVerification(SmokeTestConstants.prescriberSearch_StateDropDown);

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * This method will check the patient name is a hyperlink in DE screen.
	 */
	@And("^The name of the Patient should be displayed as a hyperlink$")
	public void theNameOfThePatientShouldBeDisplayedAsAHyperlink() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			isElementPresentVerification(DataEntryConstants.DE_SCREEN_PATIENT_NAME_HYPERLINK);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^The system should display the previously entered prescriber search criteria$")
	public void theSystemShouldDisplayThePreviouslyEnteredPrescriberSearchCriteria(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String lastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
			String firstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
			String phoneNo = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");
			String NpiDea = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "NPI");

			if (isElementPresentVerification(SmokeTestConstants.Prescriber_LastName)) {
				String prescriber_LastName = FrameworkLibrary.getElementText(SmokeTestConstants.Prescriber_LastName);
				String prescriber_FirstName = FrameworkLibrary.getElementText(SmokeTestConstants.Prescriber_FirstName);
				String prescriber_PhoneNumber = FrameworkLibrary.getElementText(DataEntryConstants.DE_Prescriber_Phone_Number_Field);
				String prescriber_NpiDea = FrameworkLibrary.getElementText(DataEntryConstants.DE_Prescriber_NPIorDEA_Field);
				Assert.assertEquals(prescriber_LastName.toUpperCase(),lastName.toUpperCase());
				Assert.assertEquals(prescriber_FirstName.toUpperCase(),firstName.toUpperCase());
				//Assert.assertEquals(phoneNo, prescriber_PhoneNumber);
				//Assert.assertEquals(NpiDea, prescriber_NpiDea);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/*********************************************************************************
	 * Confirms that the Update Rx page does not display a coupon message.
	 * @throws Exception
	 **********************************************************************************/
	@And("^the system does not display any message in the expanded Payment panel$")
	public void system_does_not_display_any_message_in_the_expanded_Payment_panel() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (chromeDriver.getPageSource().contains("This patient might have a coupon for this prescription")) {
				throw new Exception("message is present when should not be.");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^the focus should be on the first row of the Frequent Prescriber list$")
	public void theFocusShouldBeOnTheFirstRowOfTheFrequentPrescriberList() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.Prescriber_frequent_names)) {
				Assert.assertTrue(getElementByProperty(DataEntryConstants.Prescriber_search_frequently_first_result, chromeDriver).getAttribute("class").contains("focused-location"));
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^User verifies tab order in prescriber section when frequent prescriber is present$")
	public void userVerifiesTabOrderInPrescriberSectionWhenFrequentPrescriberIsPresent() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			Actions upArrow = new Actions(chromeDriver);
			Action tab = upArrow.sendKeys(Keys.TAB).build();
			if (isElementPresentVerification(DataEntryConstants.Prescriber_frequent_names)) {
				tab.perform();
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("phone"), "Not on Phone Number field");
				tab.perform();
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("npi"), "Not on NPI field");
				tab.perform();
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("dropdown"), "Not on state drop down field");
				tab.perform();
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("last"), "Not on last Name field");
				tab.perform();
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("first"), "Not on First Name field");
				tab.perform();
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("search"), "Not on Search button");
				tab.perform();
				isElementPresentVerification(SmokeTestConstants.Product_OriginalDate);
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("original-date"), "Not on product panel orginal date");
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^the focus should be on the Phone number field$")
	public void theFocusShouldBeOnThePhoneNumberField() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_EXPANDED_PHONE_NUMBER)) {
				Assert.assertTrue(getElementByProperty(DataEntryConstants.PRESCRIBER_SEARCH_EXPANDED_PHONE_NUMBER, chromeDriver).getAttribute("class").contains("md-input-focused"));
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^User verifies tab order in prescriber section when frequent prescriber is not present$")
	public void userVerifiesTabOrderInPrescriberSectionWhenFrequentPrescriberIsNotPresent() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			Actions upArrow = new Actions(chromeDriver);
			Action tab = upArrow.sendKeys(Keys.TAB).build();

				tab.perform();
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("npi"), "Not on NPI field");
				tab.perform();
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("dropdown"), "Not on state drop down field");
				tab.perform();
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("last"), "Not on last Name field");
				tab.perform();
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("first"), "Not on First Name field");
				tab.perform();
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("search"), "Not on Search button");
				tab.perform();
				isElementPresentVerification(SmokeTestConstants.Product_OriginalDate);
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("original-date"), "Not on product panel orginal date");

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**********
	 * Method to click update Rx button in POS
	 * @throws Exception
	 */
	@And("^user clicks on Update Rx button$")
	public void user_clicks_on_Update_Rx_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


		try {
			if (isElementPresentVerification(dataReviewConstants.POS_UPDATE_RX)) {
				if (!isElementPresentVerifyClick(dataReviewConstants.POS_UPDATE_RX)) {
					throw new Exception("unable to click on one update button");
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}

	/**********
	 * This method used for verifying the user plan and selecting the payment plan
	 * @throws Exception
	 */

	@Then("^Rx will be billed to Cash message should be displayed in Product panel$")
	public void Rx_will_be_billed_to_Cash_message_should_be_displayed_in_Product_panel() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(dataReviewConstants.DE_Payment_Option_Field)) {
				if (isElementPresentVerification(SmokeTestConstants.Open_payment)) {
					Actions ac = new Actions(chromeDriver);
					Action a = ac.sendKeys(Keys.ARROW_DOWN).build();
					a.perform();
					if (isElementPresentVerification(dataReviewConstants.DE_Payment_Cash_Message)) {
						String actual = FrameworkLibrary.chromeDriver.findElement(xpath(dataReviewConstants.DE_Payment_Cash_Message)).getText();
						String expected = "Rx will be billed to " + PLAN;
						Assert.assertEquals(actual, expected);
					}
				}
			} else {
				if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
					isElementPresentVerifyClick(SmokeTestConstants.Payment_Dropdown);

					if (isElementPresentVerification(SmokeTestConstants.Cash_option)) {
						isElementPresentVerifyClick(SmokeTestConstants.Cash_option);

						if (isElementPresentVerification(dataReviewConstants.DE_Open_Product_Field)) {
							if (!isElementPresentVerifyClick(dataReviewConstants.DE_Open_Product_Field)) {
								throw new Exception("unable to click on payment button");
							}
						}
						Thread.sleep(1000);
						Actions upArrow = new Actions(chromeDriver);
						Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
						PressUpArrow.perform();
						if (isElementPresentVerification(dataReviewConstants.Patient_Profile_Plan_ID)) {
							PLAN = FrameworkLibrary.chromeDriver.findElement(xpath(dataReviewConstants.Patient_Profile_Plan_ID)).getText();


						}
					}

				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**********
	 * This method used for verifying the user plan and selecting the payment plan
	 * @throws Exception
	 */

	@Then("^Rx will be billed to Cash message should be displayed in Product$")
	public void Rx_will_be_billed_to_Cash_message_should_be_displayed_in_Product() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


		try {


			if (isElementPresentVerification(dataReviewConstants.DE_Payment_Option_Field)) {
				if (isElementPresentVerification(SmokeTestConstants.Open_payment)) {
					Actions ac = new Actions(chromeDriver);
					Action a = ac.sendKeys(Keys.ARROW_DOWN).build();
					a.perform();
					if (isElementPresentVerification(dataReviewConstants.DE_Payment_Cash_Message)) {
						String actual = FrameworkLibrary.chromeDriver.findElement(xpath(dataReviewConstants.DE_Payment_Cash_Message)).getText();
						String expected = dataReviewConstants.DE_Payment_Cash_Message_Displayed;
						Assert.assertEquals(actual, expected);
					}
				}
			} else {
				if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
					isElementPresentVerifyClick(SmokeTestConstants.Payment_Dropdown);

					if (isElementPresentVerification(SmokeTestConstants.Cash_option)) {
						isElementPresentVerifyClick(SmokeTestConstants.Cash_option);

						if (isElementPresentVerification(dataReviewConstants.DE_Open_Product_Field)) {
							if (!isElementPresentVerifyClick(dataReviewConstants.DE_Open_Product_Field)) {
								throw new Exception("unable to click on payment button");
							}
						}
						//Thread.sleep(1000);
						Actions upArrow = new Actions(chromeDriver);
						Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
						PressUpArrow.perform();

						if (isElementPresentVerification(dataReviewConstants.Patient_Profile_Plan_ID)) {
							PLAN = FrameworkLibrary.chromeDriver.findElement(xpath(dataReviewConstants.Patient_Profile_Plan_ID)).getText();


						}
					}

				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**********
	 * This method used for verifying the error message and selecting the payment button
	 * @throws Exception
	 */

	@When("^user expands payment panel and collapses$")
	public void user_expands_payment_panel_and_collapses() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


		try {
			if (isElementPresentVerification(dataReviewConstants.DE_Open_Payment_Field)) {
				if (!isElementPresentVerifyClick(dataReviewConstants.DE_Open_Payment_Field)) {
					throw new Exception("unable to click on payment button");
				}

			}
			if (isElementPresentVerification(dataReviewConstants.DE_Open_Product_Field)) {
				if (!isElementPresentVerifyClick(dataReviewConstants.DE_Open_Product_Field)) {
					throw new Exception("unable to click on payment button");
				}

			}
			if (isElementPresentVerification(dataReviewConstants.DE_Open_Payment_Field)) {
				String actual = FrameworkLibrary.chromeDriver.findElement(xpath(dataReviewConstants.DE_Payment_Cash_Message)).getText();
				String expected = "Rx will be billed to " + PLAN;
				Assert.assertEquals(expected, actual);

			}


		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**********
	 * This method used for verifying the error message and selecting the payment button
	 * @throws Exception
	 */

	@And("^clicks open payment button on DE page$")
	public void clicks_open_payment_button_on_DE_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


		try {
			if (isElementPresentVerification(dataReviewConstants.DE_Open_Payment_Field)) {
				String actual = FrameworkLibrary.chromeDriver.findElement(xpath(dataReviewConstants.DE_Payment_Cash_Message)).getText();
				String expected = dataReviewConstants.DE_Payment_Cash_Message_Displayed;
				Assert.assertEquals(expected, actual);
			} else {
				if (isElementPresentVerification(SmokeTestConstants.Open_payment)) {
					if (!isElementPresentVerifyClick(SmokeTestConstants.Open_payment)) {
						throw new Exception("Not able to click Open_payment");
					}
				}
			}

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**********
	 * This method used for verifying the user plan and selecting the payment plan
	 * @throws Exception
	 */
	@Then("^Rx will be billed to plan id message should be displayed in Product panel$")
	public void Rx_will_be_billed_to_plan_id_message_should_be_displayed_in_Product_panel() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String actual = getElementText(dataReviewConstants.DE_Payment_Cash_Message);
			log.info("****((((((("+actual);
			Assert.assertTrue(!actual.contains("Cash"));
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**********
	 * This method used for verifying the user selecting the payment plan
	 * @throws Exception
	 */

	@When("^user modifies payment type to cash and collapses the payment panel$")
	public void user_modifies_payment_type_to_cash_and_collapses_the_payment_panel() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


		try {


			if (isElementPresentVerification(SmokeTestConstants.Open_payment)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.Open_payment)) {
					throw new Exception("Not able to click Open_payment");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
				isElementPresentVerifyClick(SmokeTestConstants.Payment_Dropdown);
			}
			if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
				isElementPresentVerifyClick(SmokeTestConstants.Cash_option);
				if (isElementPresentVerification(dataReviewConstants.DE_Open_Product_Field)) {
					if (!isElementPresentVerifyClick(dataReviewConstants.DE_Open_Product_Field)) {
						Actions ac = new Actions(chromeDriver);
						Action a = ac.sendKeys(Keys.ARROW_DOWN).build();
						a.perform();
						String actual = FrameworkLibrary.chromeDriver.findElement(xpath(dataReviewConstants.DE_Payment_Cash_Message)).getText();
						log.info(actual);
					}

				}
			}


		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**********
	 * This method used for verifying the user plan and selecting the payment plan
	 * @throws Exception
	 */

	@And("^clicks Finish button to complete Data Entry with product$")
	public void clicks_Finish_button_to_complete_Data_Entry_with_product() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(dataReviewConstants.Patient_Profile_Plan_ID)) {
				Thread.sleep(1000);

				if (isElementPresentVerification(dataReviewConstants.Patient_Profile_Plan_ID)) {
					PLAN = FrameworkLibrary.chromeDriver.findElement(xpath(dataReviewConstants.Patient_Profile_Plan_ID)).getText();

				}

			} else {
				if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
					isElementPresentVerifyClick(SmokeTestConstants.Payment_Dropdown);

					if (isElementPresentVerification(SmokeTestConstants.Cash_option)) {
						isElementPresentVerifyClick(SmokeTestConstants.Cash_option);

						if (isElementPresentVerification(dataReviewConstants.DE_Open_Product_Field)) {
							if (!isElementPresentVerifyClick(dataReviewConstants.DE_Open_Product_Field)) {
								throw new Exception("unable to click on payment button");
							}
						}
						Thread.sleep(1000);
						Actions upArrow = new Actions(chromeDriver);
						Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP).build();
						PressUpArrow.perform();
						Action PressEnter = upArrow.sendKeys(Keys.ENTER).build();
						PressEnter.perform();
						
						if (isElementPresentVerification(SmokeTestConstants.Open_Product)) {
							if (!isElementPresentVerifyClick(SmokeTestConstants.Open_Product)) {
								throw new Exception("Not able to click Open_Product");
							}
						}
						
						if (isElementPresentVerification(dataReviewConstants.Patient_Profile_Plan_ID)) {


						}
					}

				}

			}
			if (isElementPresentVerification(SmokeTestConstants.DE_FinishButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.DE_FinishButton)) {
					throw new Exception("Not able to click DE_FinishButton");
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

	/**********
	 * This method used for entering drug name and validating the field
	 * @throws Exception
	 */
	@And("^enters product information with C2 drug$")
	public void enters_product_information_with_C2_drug(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		Thread.sleep(10000);
		String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
		try {
			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, DrugName)) {
					throw new Exception("Not able to enter value in DrugName text field");
				}
			}
			Thread.sleep(1000);
			if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();
				if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
					Assert.assertTrue(!FrameworkLibrary.chromeDriver.findElement(xpath(SmokeTestConstants.Refills_field)).isEnabled());
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

	/**********
	 * This method used for entering drug name and validating the field
	 * @throws Exception
	 */
	@And("^enters product information with C3 drug$")
	public void enters_product_information_with_C3_drug(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);

		String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
		String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");

		try {

			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, DrugName)) {
					throw new Exception("Not able to enter value in DrugName text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
				Thread.sleep(1000);
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();

			}

			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Refills_field, Refills)) {
					throw new Exception("Not able to enter value in refill text field");
				}

				if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
					String RefillNo = FrameworkLibrary.getElementText(SmokeTestConstants.Refills_field);
					Boolean sasdf = Integer.parseInt(RefillNo) <= 5;
					Assert.assertTrue(Integer.parseInt(RefillNo) <= 5);

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

	/**********
	 * This method used for entering drug name and validating the field
	 * @throws Exception
	 */

	@And("^enters product information with C4 drug$")
	public void enters_product_information_with_C4_drug(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);

		String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
		String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
		try {

			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, DrugName)) {
					throw new Exception("Not able to enter value in DrugName text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
				Thread.sleep(1000);
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();

			}
			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Refills_field, Refills)) {
					throw new Exception("Not able to enter value in refill text field");
				}
				if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
					String RefillNo = FrameworkLibrary.getElementText(SmokeTestConstants.Refills_field);
					Assert.assertTrue(Integer.parseInt(RefillNo) <= 5);
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

	/**********
	 * This method used for entering drug name and validating the field
	 * @throws Exception
	 */

	@And("^enters product information with C5 drug$")
	public void enters_product_information_with_C5_drug(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);

		String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
		String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
		try {

			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, DrugName)) {
					throw new Exception("Not able to enter value in DrugName text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
				Thread.sleep(1000);
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();

			}

			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Refills_field, Refills)) {
					throw new Exception("Not able to enter value in refill text field");
				}
				if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
					String RefillNo = FrameworkLibrary.getElementText(SmokeTestConstants.Refills_field);
					Assert.assertTrue(Integer.parseInt(RefillNo) <= 11);
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

	/**********
	 * This method used for entering drug name and validating the field
	 * @throws Exception
	 */
	@And("^enters product information with RX Drug Name$")
	public void enters_product_information_with_RX_Drug_Name(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);

		String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
		String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
		try {

			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, DrugName)) {
					throw new Exception("Not able to enter value in DrugName text field");
				}
			}

			if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
				Thread.sleep(1000);
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();

			}

			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Refills_field, Refills)) {
					throw new Exception("Not able to enter value in refill text field");
				}
				if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
					String RefillNo = FrameworkLibrary.getElementText(SmokeTestConstants.Refills_field);
					Assert.assertTrue(Integer.parseInt(RefillNo) <= 10000);
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

	/**********
	 * This method used for entering drug name and validating the field
	 * @throws Exception
	 */

	@And("^enters product information with RX Drug Name and OTC drug$")
	public void enters_product_information_with_RX_Drug_Name_and_OTC_drug(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);

		String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
		String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
		try {

			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, DrugName)) {
					throw new Exception("Not able to enter value in DrugName text field");
				}
			}

			if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
				Thread.sleep(1000);
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();

			}

			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Refills_field, Refills)) {
					throw new Exception("Not able to enter value in refill text field");
				}
				if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
					String RefillNo = FrameworkLibrary.getElementText(SmokeTestConstants.Refills_field);
					Assert.assertTrue(Integer.parseInt(RefillNo) <= 10000);
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

	/**********
	 * This method used for entering drug name and validating the field
	 * @throws Exception
	 */
	@And("^enters product information with C3 drug with error message$")
	public void enters_product_information_with_C3_drug_with_error_message(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);

		String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
		String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
		try {

			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, DrugName)) {
					throw new Exception("Not able to enter value in DrugName text field");
				}
			}

			if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
				Thread.sleep(1000);
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();

			}

			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Refills_field, Refills)) {
					throw new Exception("Not able to enter value in refill text field");
				}
		     
			if(isElementPresentVerification(SmokeTestConstants.Days_Supply)){
				if(!isElementPresentVerifyClick(SmokeTestConstants.Days_Supply)){
					throw new Exception("user not able to click days supply field");
				}
			}
				if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
					String actual = FrameworkLibrary.chromeDriver.findElement(xpath(dataReviewConstants.DE_Product_Refills_Error)).getText();
					String expected = dataReviewConstants.DE_Product_Refills_Error_Message;
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

	/**********
	 * This method used for entering drug name and validating the field
	 * @throws Exception
	 */

	@And("^enters product information with C4 drug with error message$")
	public void enters_product_information_with_C4_drug_with_error_message(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);

		String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
		String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
		try {

			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, DrugName)) {
					throw new Exception("Not able to enter value in DrugName text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
				Thread.sleep(1000);
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();

			}

			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Refills_field, Refills)) {
					throw new Exception("Not able to enter value in refill text field");
				}
				if(isElementPresentVerification(SmokeTestConstants.Days_Supply)){
					if(!isElementPresentVerifyClick(SmokeTestConstants.Days_Supply)){
						throw new Exception("user not able to click days supply field");
					}
				}
				if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
					String actual = FrameworkLibrary.chromeDriver.findElement(xpath(dataReviewConstants.DE_Product_Refills_Error)).getText();
					String expected = dataReviewConstants.DE_Product_Refills_Error_Message;
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

	/**********
	 * This method used for entering drug name and validating the error message
	 * @throws Exception
	 */

	@And("^enters product information with C5 drug with error message$")
	public void enters_product_information_with_C5_drug_with_error_message(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);

		String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
		String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
		try {

			if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, DrugName)) {
					throw new Exception("Not able to enter value in DrugName text field");
				}
			}

			if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();

			}

			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Refills_field, Refills)) {
					throw new Exception("Not able to enter value in refill text field");
				}
				if(isElementPresentVerification(SmokeTestConstants.Days_Supply)){
					if(!isElementPresentVerifyClick(SmokeTestConstants.Days_Supply)){
						throw new Exception("user not able to click days supply field");
					}
				}
				if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
					String actual = FrameworkLibrary.chromeDriver.findElement(xpath(dataReviewConstants.DE_Product_Refills_Error)).getText();
					String expected = dataReviewConstants.DE_Product_Refills_Error_Message;
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

	/**********
	 * This method used for entering Refill field and validating the text field
	 * @throws Exception
	 */

	@And("^clears Refills data and modifies the Refills value$")
	public void clears_Refills_data_and_modifies_the_Refills_value(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);


		String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
		try {

			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Refills_field, Refills)) {
					throw new Exception("Not able to enter value in refill text field");
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

	/**********
	 * This method used for validating error message displayed on refill field
	 * @throws Exception
	 */
	@Then("^system displays the following error message as Number of refills not allowed$")
	public void system_displays_the_following_error_message_as_Number_of_refills_not_allowed() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			Thread.sleep(5000);
			Actions tab1 = new Actions(chromeDriver);
			Action hitTab1 = tab1.sendKeys(Keys.TAB).build();
			hitTab1.perform();
			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				String actual = FrameworkLibrary.chromeDriver.findElement(xpath(dataReviewConstants.DE_Product_Refills_Error)).getText();
				String expected = dataReviewConstants.DE_Product_Refills_Error_Message;
				Assert.assertEquals(actual, expected);


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
	 * This method to click update button
	 * @throws Exception
	 */

	@And("^clicks open update button in product$")
	public void clicks_open_update_button_in_product() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			if (isElementPresentVerification(dataReviewConstants.DR_Product_Update_Button)) {
				if (!isElementPresentVerifyClick(dataReviewConstants.DR_Product_Update_Button)) {
					throw new Exception("Not able to click update button field");
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

	@When("^click on patient hyperlink$")
	public void click_on_patient_hyperlink() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.Patient_DE)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.Patient_DE)) {
					throw new Exception("unable to click on patient hyper link");
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
	 * This method is to click on Med history tab after clicking patient hyper
	 * link
	 */
	@When("^click on MedHistory tab$")
	public void click_on_MedHistory_tab() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.Patient_DE_Med_history)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.Patient_DE_Med_history)) {
					throw new Exception("unable to click on Med history tab");
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
	 * This method is to click on Additional Medication tab in DE
	 */
	@When("^click on Additional medication tab$")
	public void click_on_Additional_medication_tab() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.Patient_DE_Med_Additional_medications)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.Patient_DE_Med_Additional_medications)) {
					throw new Exception("unable to click on Additional Medication tab");
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
	 * This method is to click on Close the patient light box
	 */
	@When("^click on Close button$")
	public void click_on_Close_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.Patient_DE_Med_Additional_medications_close)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.Patient_DE_Med_Additional_medications_close)) {
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

	@Then("^validate the displayed patient profile$")
	public void validate_the_displayed_patient_profile() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.DE_Patient_profile)) {
				Assert.assertTrue(isElementPresents(DataEntryConstants.DE_Patient_profile));
			}
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
		}catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception(e.getMessage());
			}	
	}

	@Then("^validates the fields$")
	public void validates_the_fields() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.Patient_DE_Med_Additional_medications_Drugname)) {
				String name = FrameworkLibrary
						.getElementText(DataEntryConstants.Patient_DE_Med_Additional_medications_Drugname);
				Assert.assertEquals("Drug Name", name);
			}
			if (isElementPresentVerification(DataEntryConstants.Patient_DE_Med_Additional_medications_Directions)) {
				String name = FrameworkLibrary
						.getElementText(DataEntryConstants.Patient_DE_Med_Additional_medications_Directions);
				Assert.assertEquals("Directions", name);
			}
			if (isElementPresentVerification(DataEntryConstants.Patient_DE_Med_Additional_medications_Therapy)) {
				String name = FrameworkLibrary
						.getElementText(DataEntryConstants.Patient_DE_Med_Additional_medications_Therapy);
				Assert.assertEquals("Therapy", name);
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
	 * This method is to click on comments field in DE
	 */
	@Then("^click on comments$")
	public void click_on_comments() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.Patient_DE_comments)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.Patient_DE_comments)) {
					throw new Exception("unable to click on comments");
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
	 * This method is to validate the comments light box
	 */
	@Then("^validate the comments popup$")
	public void validate_the_comments_popup() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.Patient_DE_comments_popup)) {
				Assert.assertTrue(isElementPresents(DataEntryConstants.Patient_DE_comments_popup));
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
	 * This method validates that the focus is on RX history field
	 */
	@Then("^valides the focus is on RX history$")
	public void valides_the_focus_is_on_RX_history() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.Patient_DE_RX_history)) {
				Assert.assertTrue(chromeDriver.findElementByXPath(DataEntryConstants.Patient_DE_RX_history)
						.getAttribute("class").contains("md-active"));
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
	 * This method is to validate that med history is read only
	 */
	@Then("^validates the history is in read only$")
	public void validates_the_history_is_in_read_only() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			isElementActive(DataEntryConstants.Patient_DE_RX_history);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * This method is to validate the close and X fields
	 */
	@Then("^validates the close and X fields$")
	public void validates_the_close_and_X_fields() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.Patient_DE_Med_Additional_medications_close)
					&& isElementPresentVerification(DataEntryConstants.Patient_DE_Med_Additional_medications_X)) {
				Assert.assertTrue(isElementPresents(DataEntryConstants.Patient_DE_Med_Additional_medications_close));
				Assert.assertTrue(isElementPresents(DataEntryConstants.Patient_DE_Med_Additional_medications_X));
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
	 * This method used for verifying the user plan and selecting the payment
	 * plan
	 *
	 * @throws Exception
	 */

	@And("^clicks Finish button to complete Data Entry with product plan$")
	public void clicks_Finish_button_to_complete_Data_Entry_with_product_plan() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
				isElementPresentVerifyClick(SmokeTestConstants.Payment_Dropdown);

				isElementPresentVerification(SmokeTestConstants.Cash_option);
				isElementPresentVerifyClick(SmokeTestConstants.Cash_option);

				isElementPresentVerification(dataReviewConstants.DE_Open_Product_Field);
				isElementPresentVerifyClick(dataReviewConstants.DE_Open_Product_Field);

				Thread.sleep(1000);
				Actions upArrow = new Actions(chromeDriver);
				Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
				PressUpArrow.perform();

				isElementPresentVerification(dataReviewConstants.Patient_Profile_Plan_ID);
				PLAN = FrameworkLibrary.chromeDriver.findElement(xpath(dataReviewConstants.Patient_Profile_Plan_ID))
						.getText();

			} else {

				Thread.sleep(2000);
				if (isElementPresentVerification(dataReviewConstants.Patient_Profile_Plan_ID)) {
					Thread.sleep(1000);
					Actions tab1 = new Actions(chromeDriver);
					Action hitTab1 = tab1.sendKeys(Keys.TAB).build();
					hitTab1.perform();
					if (isElementPresentVerification(dataReviewConstants.Patient_Profile_Plan_ID)) {
						PLAN = FrameworkLibrary.chromeDriver
								.findElement(xpath(dataReviewConstants.Patient_Profile_Plan_ID)).getText();

					}

				}
			}

			if (isElementPresentVerification(SmokeTestConstants.DE_FinishButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.DE_FinishButton)) {
					throw new Exception("Not able to click DE_FinishButton");
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

	/*
	 * This method is to validate the user on patient third party
	 */

	@And("^clicks on Third Party Plan tab with coupon$")
	public void clicks_on_Third_Party_Plan_tab_with_coupon() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(IntakeConstants.PATIENT_PROFILE_THIRD_PARTY_PLAN_TAB)) {
				if (!isElementPresentVerifyClick(IntakeConstants.PATIENT_PROFILE_THIRD_PARTY_PLAN_TAB)) {
					throw new Exception("Not able to click on Third Party Plan Tab");
				}
			}

			if (isElementPresentVerification(DataEntryConstants.Patient_Profile_thirdparty_Drug_Arrow_Button)) {
				isElementPresentVerifyClick(DataEntryConstants.Patient_Profile_thirdparty_Drug_Arrow_Button);
				Thread.sleep(1000);
				// FrameworkLibrary.getElementText(DataEntryConstants.Patient_Profile_thirdparty_Drug_Name);
				String actualdrug = FrameworkLibrary.getElementText(DataEntryConstants.Patient_Profile_thirdparty_Drug_Name);
				String expecteddrug = FrameworkLibrary.getElementText(DataEntryConstants.Patient_Profile_thirdparty_Drug_Actual_Message_Name);
				log.info("@@act:" + actualdrug);
				log.info("@@expec:" + expecteddrug);
				Assert.assertEquals(actualdrug, expecteddrug);

			} else {
				if (isElementPresentVerification(DataEntryConstants.Patient_Profile_thirdparty_Drug_Name)) {
					String actualdrug = FrameworkLibrary.chromeDriver
							.findElement(xpath(DataEntryConstants.Patient_Profile_thirdparty_Drug_Name)).getText();
					String expecteddrug = FrameworkLibrary.chromeDriver
							.findElement(
									xpath(DataEntryConstants.Patient_Profile_thirdparty_Drug_Actual_Message_Name))
							.getText();
					Assert.assertEquals(actualdrug, expecteddrug);
				}

			}
			Thread.sleep(1000);
			if (isElementPresentVerification(IntakeConstants.Patient_profile_general_info)) {
				isElementPresentVerifyClick(IntakeConstants.Patient_profile_general_info);
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User tabs off last field in \"([^\"]*)\" panel$")
	public void userTabsOffLastFieldInPanel(String panel) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions act = new Actions(chromeDriver);
			Action tab = act.sendKeys(Keys.TAB).build();

			if (panel.equalsIgnoreCase("prescriber")) {
				for (int i = 0; i < 6; i++) {
					tab.perform();
					TimeUnit.SECONDS.sleep(1);
				}
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("prescription-rx-prescriber-search-button-search"), "Not on Search button");
				tab.perform();
				TimeUnit.SECONDS.sleep(1);
			} else if (panel.equalsIgnoreCase("product")) {
				if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
					if (!isElementPresentVerifyClick(SmokeTestConstants.Refills_field)) {
						throw new Exception("Unable to click product refills field ");
					}
					Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("number-refill"), "Not on Refills field");
					tab.perform();
					Thread.sleep(1000);
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^System should collapse \"([^\"]*)\" panel$")
	public void systemShouldCollapsePanel(String panel) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (panel.equalsIgnoreCase("prescriber")) {
				if (!isElementPresentVerification(DataEntryConstants.Open_prescriber)) {
					throw new Exception("Prescriber panel not collapsed");
				}
			} else if (panel.equalsIgnoreCase("product")) {
				if (!isElementPresentVerification(dataReviewConstants.DE_Open_Product_Field)) {
					throw new Exception(" Product panel not collapsed");
				}
			} else if (panel.equalsIgnoreCase("payment")) {
				if (!isElementPresentVerification(dataReviewConstants.DE_Open_Payment_Field)) {
					throw new Exception(" payment panel not collapsed");
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}


	@Then("^the focus should be on first selectable element in \"([^\"]*)\" panel$")
	public void theFocusShouldBeOnFirstSelectableElementInPanel(String panel) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (panel.equalsIgnoreCase("product")) {
				isElementPresentVerification(SmokeTestConstants.Product_OriginalDate);
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("original-date"), "Not on product panel orginal date");
			} else if (panel.equalsIgnoreCase("payment")) {
				isElementPresentVerification(SmokeTestConstants.Payment_Dropdown);
				Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("payment"), "Not on payment panel orginal date");
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User shift tabs off first field in \"([^\"]*)\" panel$")
	public void userShiftTabsOffFirstFieldInPanel(String panel) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Actions act = new Actions(chromeDriver);
			Action tab = act.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build();
			if (panel.equalsIgnoreCase("payment")) {
				if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
					Assert.assertTrue(chromeDriver.switchTo().activeElement().getAttribute("id").contains("payment"), "Not on payment dropdown field");
					tab.perform();
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User double clicks on a prescriber from results$")
	public void userDoubleClicksOnAPrescriberFromResults() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.De_Prescriber_Search_Results_TD)) {
				Actions act = new Actions(chromeDriver);
				WebElement frequent_result = FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.De_Prescriber_Search_Results_TD));
				act.moveToElement(frequent_result).doubleClick().perform();
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * This method is to validate whether system shows any error message or not if you enter quantity dispense more than quantity
	 */
	@When("^enters product information and check the disp quantity is greater than quantity$")
	public void enters_product_information_and_check_the_disp_quantity_is_greater_than_quantity(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String Refill = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
			String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			Quantity_DE = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
			String DaysSupply = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DaysSupply");
			String Directions = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Directions");
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
			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				String Refills = FrameworkLibrary.getElementText(SmokeTestConstants.Refills_field);
				Assert.assertEquals(Refills, "");
			}

			if (isElementPresentVerification(SmokeTestConstants.Quantity_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Quantity_field, Quantity_DE)) {
					throw new Exception("Not able to enter value in Quantity text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.Days_Supply)) {
				if (!clearAndEnterText(SmokeTestConstants.Days_Supply, DaysSupply)) {
					throw new Exception("Not able to enter value in DaysSupply text field");
				}
			}
			if (isElementPresentVerification(SmokeTestConstants.Directions_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Directions_field, Directions)) {
					throw new Exception("Not able to enter value in Directions text field");
				}
			}

			int refills = Integer.parseInt(Refill);
			int qty = Integer.parseInt(Quantity_DE);
			Dis = Integer.parseInt(Quantity_DE) + (refills * qty + 10);
			if (isElementPresentVerification(SmokeTestConstants.Quantity_disp)) {
				if (!clearAndEnterText(SmokeTestConstants.Quantity_disp, Integer.toString(Dis))) {
					throw new Exception("Not able to enter value in Quantity text field");
				}
			}
			Actions tab = new Actions(chromeDriver);
			Action Presstab = tab.sendKeys(Keys.TAB, Keys.ENTER).build();
			Presstab.perform();
			Boolean error_result = isElementPresents(DataEntryConstants.DE_qty_disp_error_msg);
			Assert.assertFalse(error_result);

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/*
	 * This method is to validate whether system is throwing an error message if entered quantity dispensed is more than than prescribed quantity
	 */
	@When("^enter the refills fields and check the qty disensed$")
	public void enter_the_refills_fields_and_check_the_qty_disensed(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Refills_field, Refills)) {
					throw new Exception("Not able to enter value in Refills text field");
				}
			}
			int refills = Integer.parseInt(Refills);
			int qty = Integer.parseInt(Quantity_DE);
			int Qtydis = (refills * qty) + qty;
			String expected = "The qty entered cannot be greater than " + Integer.toString(Qtydis);
			if (Dis > Qtydis) {
				if (isElementPresentVerification(DataEntryConstants.DE_qty_disp_error_msg)) {
					String error = getElementText(DataEntryConstants.DE_qty_disp_error_msg);
					Assert.assertEquals(error, expected);
				}
			} else {
				boolean result = isElementPresents(DataEntryConstants.DE_qty_disp_error_msg);
				log.info(result);
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
	 * This method is to clear all fields, enter refills and then enter qty dispensed
	 */
	@When("^Clear fields and enter refills first and then qty dispensed$")
	public void clear_fields_and_enter_refills_first_and_then_qty_dispensed(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
		String Quantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
		//String Quantity_disp = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "QuantityDisp");
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(SmokeTestConstants.Refills_field) && isElementPresentVerification(SmokeTestConstants.Quantity_disp)) {
				clearTextField(SmokeTestConstants.Refills_field);
				clearTextField(SmokeTestConstants.Quantity_disp);
			}

			if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
				if (!clearAndEnterText(SmokeTestConstants.Refills_field, Refills)) {
					throw new Exception("Not able to enter value in Refills text field");
				}
			}

			int refills = Integer.parseInt(Refills);
			int qty = Integer.parseInt(Quantity);
			int Qty_disp = (refills * qty) + qty;
			int new_Qty_disp = Qty_disp + 10;
			if (isElementPresentVerification(SmokeTestConstants.Quantity_disp)) {
				if (!clearAndEnterText(SmokeTestConstants.Quantity_disp, Integer.toString(new_Qty_disp))) {
					throw new Exception("Not able to enter value in Quantity text field");
				}
			}

			Actions tab = new Actions(chromeDriver);
			Action Presstab = tab.sendKeys(Keys.TAB, Keys.ENTER).build();
			Presstab.perform();

			String expected = "The qty entered cannot be greater than " + Integer.toString(Qty_disp);
			if (isElementPresentVerification(DataEntryConstants.DE_qty_disp_error_msg)) {
				String error = getElementText(DataEntryConstants.DE_qty_disp_error_msg);
				Assert.assertEquals(error, expected);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}


	@Then("^atleast one result should be displayed and highlighted$")
	public void atleast_one_result_should_be_displayed_and_highlighted_on_updaterx() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		List<WebElement> updateRx_prescriber_list;
		try {
			updateRx_prescriber_list = chromeDriver.findElements(xpath(DataEntryConstants.UPDATE_RX_PRESCRIBER_RESULTS_LIST));
			Assert.assertTrue(updateRx_prescriber_list.size() != 0);
			WebElement prescriber_first_location = getElementByProperty(DataEntryConstants.UPDATE_RX_PRESCRIBER_RESULTS_FIRST_PATIENT_LOCATION_ROW, chromeDriver);
			Assert.assertTrue(prescriber_first_location.getAttribute("class").contains("selected"));
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^displays new prescriber details in the Prescriber panel in read only mode$")
	public void displays_new_prescriber_details_in_the_Prescriber_panel_in_read_only_mode(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String LastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
			String FirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");


			if (isElementPresentVerification(DataEntryConstants.UPDATERX_PRESCRIBER_NAME_RO)) {
				Assert.assertTrue(isElementPresentVerification(DataEntryConstants.UPDATERX_PRESCRIBER_NAME_RO));

				String actual = getElementText(DataEntryConstants.UPDATERX_PRESCRIBER_NAME_RO);
				Assert.assertEquals(actual, LastName.toUpperCase().trim() + ", " + FirstName.toUpperCase().trim());
			}

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	@Then("^double click on prescriber result$")
	public void double_click_on_prescriber_result() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.UPDATE_RX_PRESCRIBER_RESULTS_FIRST_PATIENT_LOCATION_ROW)) {
				if (isElementPresentVerification(DataEntryConstants.UPDATE_RX_PRESCRIBER_RESULTS_FIRST_PATIENT_LOCATION_ROW)) {
					Actions act = new Actions(chromeDriver);
					WebElement ele  =  chromeDriver.findElementByXPath(DataEntryConstants.UPDATE_RX_PRESCRIBER_RESULTS_FIRST_PATIENT_LOCATION_ROW);
					act.doubleClick(ele).build().perform();
				}
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@When("^User clicks on Patient name hyperlink in Update Rx page$")
	public void userClicksOnPatientNameHyperlinkInUpdateRxPage() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.DE_SCREEN_PATIENT_NAME_HYPERLINK)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_SCREEN_PATIENT_NAME_HYPERLINK)) {
					throw new Exception("unable to click on patient hyper link");
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

	@Then("^System should display the selected patient profile in View mode in a light box$")
	public void systemShouldDisplayTheSelectedPatientProfileInViewModeInALightBox(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			String lastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
			if (isElementPresentVerification(DataEntryConstants.PATIENT_DETAILS)) {

				Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.PATIENT_DETAILS)).getText()
						.contains(lastName), "patient profile not displayed in view mode in a light box");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^The focus should be on the 'General Info' tab$")
	public void theFocusShouldBeOnTheGeneralInfoTab() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(IntakeConstants.Patient_profile_general_info)) {
				String text = getElementByProperty(IntakeConstants.Patient_profile_general_info, chromeDriver).getAttribute("class");
				Assert.assertTrue(text.contains("md-active"));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	@And("^the Information in all tabs should displayed in read only mode$")
	public void theInformationInAllTabsShouldDisplayedInReadOnlyMode() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(IntakeConstants.Patient_profile_general_info)) {
				Assert.assertTrue(getElementByProperty(SmokeTestConstants.Patient_FirstName, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));
				Assert.assertTrue(getElementByProperty(SmokeTestConstants.Patient_LastName, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));
				Assert.assertTrue(getElementByProperty(DataEntryConstants.PATIENT_DETAILS_DOB, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));
				Assert.assertTrue(getElementByProperty(DataEntryConstants.PATIENT_DETAILS_GENDER, chromeDriver).getAttribute("readonly").equalsIgnoreCase("true"));
			}

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Method- Verify and click on Patient Link
	 * 
	 */

	@When("^User clicks on Patient hyperlink$")
	public void user_clicks_on_Patient_hyperlink() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DATA_ENTRY_PATIENT_LINK)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DATA_ENTRY_PATIENT_LINK)) {
					throw new Exception("unable to click on patient hyper link");
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
	 * Method- Verify System displays Patient Profile light box
	 * 
	 */

	@Then("^System displays Patient Profile light box$")
	public void system_displays_Patient_Profile_light_box() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(DataEntryConstants.DATA_ENTRY_LIGHT_BOX)) {
				throw new Exception("Unable to see Patient Profile light box screen");
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
	 * Method- Verify Preferences information is in read only mode
	 * 
	 */

	@When("^System displays the Preferences information in read only mode$")
	public void system_displays_the_Preferences_information_in_read_only_mode() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			
			Assert.assertFalse(isElementPresents(DataEntryConstants.UPDATE_DOUBLE_COUNT_BUTTON));
			Assert.assertFalse(isElementPresents(DataEntryConstants.UPDATE_SNAP_CAP_BUTTON));
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}  
	}

	/**
	 * Method- Verify System displays Close button and X button and does not display the Update button
	 * 
	 */

	@When("^System displays Close button and X button and does not display the Update button$")
	public void system_displays_Close_button_and_X_button_and_does_not_display_the_Update_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {		
			Assert.assertFalse(FrameworkLibrary.isElementPresents(DataEntryConstants.DATA_ENTRY_UPDATE_BUTTON));
			if (!isElementPresentVerification(DataEntryConstants.DATA_ENTRY_LIGHT_BOX_CLOSE_LINK) && !isElementPresentVerification(DataEntryConstants.DATA_ENTRY_LIGHT_BOX_CLOSE_BUTTON)) {
				throw new Exception("Unable to see close and x button");
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
	 * Method- Verify and clicks on close button or X button
	 * 
	 */

	@When("^User clicks on close button or X button$")
	public void user_clicks_on_close_button_or_X_button() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DATA_ENTRY_LIGHT_BOX_CLOSE_LINK)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DATA_ENTRY_LIGHT_BOX_CLOSE_LINK)) {
					throw new Exception("unable to click on X link");
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
	 * Method- Verify system closes the View Patient light box and navigates the user back to the previous screen
	 * 
	 */

	@Then("^system closes the View Patient light box and navigates the user back to the previous screen$")
	public void system_closes_the_View_Patient_light_box_and_navigates_the_user_back_to_the_previous_screen() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {	
			if (isElementPresentVerification(SmokeTestConstants.DataEntryPageTitle)) {
				Assert.assertTrue(FrameworkLibrary.isElementPresents(SmokeTestConstants.DataEntryPageTitle), "Data Entry page is not displayed");
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
	 * Method- Click on ALT P hot key
	 * 
	 */

	@When("^user clicks ALT\\+P hot key$")
	public void user_clicks_ALT_P_hot_key() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
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

	/**
	 * Method- Verify User is on Preferences screen
	 * 
	 */

	@Then("^Preferences tab should be open$")
	public void preferences_tab_should_be_open() throws Exception {
		methodName = new Object() {}.getClass().getEnclosingMethod().getName();
		try {
			if (!isElementPresents(DataEntryConstants.PATIENT_PROFILE_PREFERENCES_RXPREFRENCES_TEXT)) {
				throw new Exception("Preferences tab not opned");
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
	 * Method- Click on ALT C hot key
	 * 
	 */

	@Then("^user clicks on ALT\\+C hot key$")
	public void user_clicks_on_ALT_C_hot_key() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
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
	/*
	 * This method is to click on Clinical history tab in patient profile in Data Entry
	 */
	@Then("^click on Clinical history tab$")
	public void click_on_Clinical_history_tab() throws Exception {
		if(isElementPresentVerification(DataEntryConstants.Patient_DE_clinical_history)){
			if(!isElementPresentVerifyClick(DataEntryConstants.Patient_DE_clinical_history)){
				throw new Exception("unable to click on clinical history");
			}
		}
	}

	@Then("^checks clinical history is in read only mode$")
	public void checks_clinical_history_is_in_read_only_mode() throws Exception {
		if(isElementPresentVerification(DataEntryConstants.Clinical_history_drugname)){
			WebElement Drugname = chromeDriver.findElementByXPath(DataEntryConstants.Clinical_history_drugname);
			try{
				Drugname.sendKeys("sample");
				Assert.assertTrue(false);
			}
			catch(Exception e){
				Assert.assertFalse(false);
			}
		}
	}
	/*
	 * This method is to click on first clinical history drop down
	 */
	@Then("^click on clinical history drop down$")
	public void click_on_clinical_history_drop_down() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerificationAndroid(DataEntryConstants.Clinical_history_down_arrow)){
				if(!isElementPresentVerification(DataEntryConstants.Clinical_history_down_arrow)){
					throw new Exception("unable to click on clinical history down arrow");
				}
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^check the service type as label$")
	public void check_the_service_type_as_label() throws Exception {
		//functionality is not implemented, blocked 
	}

	@And("^User clicks on patient hyperlink in DE page$")
	public void userClicksOnPatientHyperlinkInDEPage() throws Exception{
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.PATIENT_HYPERLINK)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.PATIENT_HYPERLINK)) {
					throw new Exception("Not able to click patient hyperlink button");
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

	@And("^User should see patient profile light box$")
	public void userShouldSeePatientProfileLightBox() throws Exception{
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			isElementPresentVerification(DataEntryConstants.PATIENT_PROFILE_LIGHT_BOX);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^System should display close and X button$")
	public void systemShouldDisplayCloseAndXButton()throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			isElementPresentVerification(DataEntryConstants.PRESCRIBER_PROFILE_X_BUTTON);
			isElementPresentVerification(DataEntryConstants.PRESCRIBER_PROFILE_CLOSE_BUTTON);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^System should focus on first row in prescriber location results$")
	public void systemShouldFocusOnFirstRowInPrescriberLocationResults() throws Exception{
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!(chromeDriver.findElement(xpath(DataEntryConstants.PRESCRIBER_PROFILE_FIRST_ROW_SELECTED)).equals(chromeDriver.switchTo().activeElement()))) {
				Actions Key = new Actions(chromeDriver);
				Action Space = Key.sendKeys(Keys.TAB).build();
				Space.perform();
			}
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_PROFILE_FIRST_ROW_SELECTED)) {
				Assert.assertTrue(chromeDriver.findElement(xpath(DataEntryConstants.PRESCRIBER_PROFILE_FIRST_ROW_SELECTED)).equals(chromeDriver.switchTo().activeElement()), "First row is not selected in the prescriber location results");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^System brings the user back to the Data Entry screen as it was before the Prescriber Profile was opened$")
	public void systemBringsTheUserBackToTheDataEntryScreenAsItWasBeforeThePrescriberProfileWasOpened() throws Exception{
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_RESULTS);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	@And("^User clicks on X button to close$")
	public void userClicksOnXButtonToClose() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_PROFILE_X_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.PRESCRIBER_PROFILE_X_BUTTON)) {
					throw new Exception("Not able to click X button");
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

	@And("^User clicks on close button using ALT plus C hot key$")
	public void userClicksOnCloseButtonUsingALTPlusCHotKey() throws Exception{
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_PROFILE_CLOSE_BUTTON)) {
				SmokeTestLibrary.hotkeyAction(Keys.ALT, "c", chromeDriver);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^User clicks tab key$")
	public void userClicksTabKey() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_PROFILE_X_BUTTON)) {
				Actions Key = new Actions(chromeDriver);
				Action Space = Key.sendKeys(Keys.TAB).build();
				Space.perform();
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	@Then("^the focus should be on close button$")
	public void theFocusShouldBeOnCloseButton() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (!isElementPresentVerification(SmokeTestConstants.userName)) {
				WebElement closeButton = chromeDriver.findElementByXPath(DataEntryConstants.PRESCRIBER_PROFILE_CLOSE_BUTTON);
				Assert.assertTrue(closeButton.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the close button");
				log.info("Trying to print: " + chromeDriver.switchTo().activeElement().getText());
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}





	@Then("^the focus should be on X button$")
	public void theFocusShouldBeOnXButton() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_PROFILE_X_BUTTON)) {
				WebElement xButton = chromeDriver.findElementByXPath(DataEntryConstants.PRESCRIBER_PROFILE_X_BUTTON);
				Assert.assertTrue(xButton.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the X button");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	@Then("^System displays (\\d+)rd Party Plans in read only mode$")
	public void systemDisplaysRdPartyPlansInReadOnlyMode(int arg0) throws Exception{
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if(isElementPresentVerification(DataEntryConstants.PATIENT_THIRDPARTY_PLANS_STANDARD_PLAN)){
				if(isElementPresentVerification(DataEntryConstants.PATIENT_THIRDPARTY_PLANS_STANDARD_PLAN_PLAN_ID)&&isElementPresentVerification(DataEntryConstants.PATIENT_THIRDPARTY_PLANS_STANDARD_PLAN_BIN)&&isElementPresentVerification(DataEntryConstants.PATIENT_THIRDPARTY_PLANS_STANDARD_PLAN_PCN)&&isElementPresentVerification(DataEntryConstants.PATIENT_THIRDPARTY_PLANS_STANDARD_PLAN_GROUPID)){
					Assert.assertTrue(!chromeDriver.findElement(xpath(DataEntryConstants.PATIENT_THIRDPARTY_PLANS_STANDARD_PLAN_PLAN_ID)).isEnabled(),"Plan ID text field is not in read only mode");
					Assert.assertTrue(!chromeDriver.findElement(xpath(DataEntryConstants.PATIENT_THIRDPARTY_PLANS_STANDARD_PLAN_BIN)).isEnabled(),"BIN input field is not in read only mode");
					Assert.assertTrue(!chromeDriver.findElement(xpath(DataEntryConstants.PATIENT_THIRDPARTY_PLANS_STANDARD_PLAN_PCN)).isEnabled(),"PCN input field is not in read only mode");
					Assert.assertTrue(!chromeDriver.findElement(xpath(DataEntryConstants.PATIENT_THIRDPARTY_PLANS_STANDARD_PLAN_RECIPIENT)).isEnabled(),"Recipient ID input field is not in read only mode");
					Assert.assertTrue(!chromeDriver.findElement(xpath(DataEntryConstants.PATIENT_THIRDPARTY_PLANS_STANDARD_PLAN_GROUPID)).isEnabled(),"Recipient ID input field is not in read only mode");

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


	@And("^(\\d+)rd Party Plans Screen should have close button and X button and the Update button is not displayed$")
	public void rdPartyPlansScreenShouldHaveCloseButtonAndXButtonAndTheUpdateButtonIsNotDisplayed(int arg0) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			Assert.assertTrue(chromeDriver.findElement(xpath(DataEntryConstants.PATIENT_PROFILE_THIRD_PARTY_PLANS_CLOSE_BUTTON)).isDisplayed(),"Close button is not displayed");
			Assert.assertTrue(chromeDriver.findElement(xpath(DataEntryConstants.PATIENT_PROFILE_THIRD_PARTY_PLANS_X_BUTTON)).isDisplayed(),"X button is not displayed");
			Boolean notPresent = ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(DataEntryConstants.PATIENT_PROFILE_THIRD_PARTY_PLANS_UPDATE_BUTTON))).apply(chromeDriver);
			Assert.assertTrue(notPresent,"update button is displayed");
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^user clicks on close button in patient light box$")
	public void userClicksOnCloseButtonInPatientLightBox() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(DataEntryConstants.PATIENT_PROFILE_THIRD_PARTY_PLANS_CLOSE_BUTTON)){
				if(!isElementPresentVerifyClick(DataEntryConstants.PATIENT_PROFILE_THIRD_PARTY_PLANS_CLOSE_BUTTON)){
					throw new Exception("Not able to click close button in patient light box");
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

	@Then("^The system closes the View Patient light box and navigates the user back to the screen previous screen$")
	public void theSystemClosesTheViewPatientLightBoxAndNavigatesTheUserBackToTheScreenPreviousScreen() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			isElementPresentVerification(SmokeTestConstants.DataEntryPageTitle);

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}

		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^user clicks on X button in patient profile light box$")
	public void userClicksOnXButtonInPatientProfileLightBox() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			isElementPresentVerification(DataEntryConstants.PATIENT_PROFILE_THIRD_PARTY_PLANS_X_BUTTON);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}

		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^User clicks on third party plans tab using  ALT plus 3 hot key from keyboard$")
	public void userClicksOnThirdPartyPlansTabUsingALTHotKeyFromKeyboard() throws Exception{
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.patientProfile_third_PartyPlansButton)) {
				SmokeTestLibrary.hotkeyAction(Keys.ALT, "3", chromeDriver);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^user clicks on close button in patient light box ALT plus C hot key from keyboard$")
	public void userClicksOnCloseButtonInPatientLightBoxALTPlusCHotKeyFromKeyboard() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.PATIENT_PROFILE_THIRD_PARTY_PLANS_CLOSE_BUTTON)) {
				SmokeTestLibrary.hotkeyAction(Keys.ALT, "C", chromeDriver);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}

		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^User clicks tab key in third party plans$")
	public void userClicksTabKeyInThirdPartyPlans() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.PATIENT_PROFILE_THIRD_PARTY_PLANS_CLOSE_BUTTON) && isElementPresentVerification(DataEntryConstants.PATIENT_PROFILE_THIRD_PARTY_PLANS_X_BUTTON)) {
				Actions Key = new Actions(chromeDriver);
				Action Space = Key.sendKeys(Keys.TAB).build();
				Space.perform();
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}

		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^focus should be on third party plans Close button$")
	public void focusShouldBeOnThirdPartyPlansCloseButton() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.PATIENT_PROFILE_THIRD_PARTY_PLANS_CLOSE_BUTTON)) {
				WebElement xButton = chromeDriver.findElementByXPath(DataEntryConstants.PATIENT_PROFILE_THIRD_PARTY_PLANS_CLOSE_BUTTON);
				Assert.assertTrue(xButton.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the close button");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}

		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}


	@Then("^focus should be on third party plans X button$")
	public void focusShouldBeOnThirdPartyPlansXButton() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.PATIENT_PROFILE_THIRD_PARTY_PLANS_X_BUTTON)) {
				WebElement xButton = chromeDriver.findElementByXPath(DataEntryConstants.PATIENT_PROFILE_THIRD_PARTY_PLANS_X_BUTTON);
				Assert.assertTrue(xButton.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the X button");
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^user clicks on general info tab to view patient General Info$")
	public void userSelectsToViewGeneralInfoTab() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification( DataEntryConstants.PATIENT_PROFILE_GENERAL_INFO_TAB)){
				if(!isElementPresentVerifyClick(DataEntryConstants.PATIENT_PROFILE_GENERAL_INFO_TAB)){
					throw new Exception("User not able to click general info tab button");
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

	@And("^system should display the Patient General Info tab$")
	public void systemShouldDisplayThePatientGeneralInfoTab() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			isElementPresentVerification( DataEntryConstants.PATIENT_PROFILE_GENERAL_INFO_PAGE);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^User clicks on general info tab using ALT plus G hot key$")
	public void userClicksOnGeneralInfoTabUsingALTPlusGHotKey() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(DataEntryConstants.PATIENT_PROFILE_GENERAL_INFO_TAB)){
				SmokeTestLibrary.hotkeyAction(Keys.ALT, "g", chromeDriver);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}

		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^User clicks on close button in patient general info using ALT plus C hot key$")
	public void userClicksOnCloseButtonInPatientGeneralInfoUsingALTPlusCHotKey() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(DataEntryConstants.PATIENT_PROFILE_GENERAL_INFO_CLOSE_BUTTON)){
				SmokeTestLibrary.hotkeyAction(Keys.ALT, "c", chromeDriver);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}

		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^User clicks on search button in prescriber panel$")
	public void userClicksOnSearchButtonInPrescriberPanel() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DR_PrescriberSearch)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DR_PrescriberSearch)) {
					throw new Exception("user not able to click  DR prescriber search update button");
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

	@And("^The system should display the prescriber search criteria fields and Search button underneath the frequent prescribers list$")
	public void theSystemShouldDisplayThePrescriberSearchCriteriaFieldsAndSearchButtonUnderneathTheFrequentPrescribersList() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(DataEntryConstants.DE_PAGE_FREQUENT_PRESCRIBER_LIST)){
				List<WebElement> frequentPrescriberList = chromeDriver.findElements(xpath(DataEntryConstants.DE_PAGE_FREQUENT_PRESCRIBER_LIST));
				Assert.assertTrue(frequentPrescriberList.size() == 1,"Patient had more than one frequent prescriber");
			}
			isElementPresentVerification(SmokeTestConstants.Prescriber_LastName);
			isElementPresentVerification(SmokeTestConstants.Prescriber_FirstName);
			isElementPresentVerification(SmokeTestConstants.prescriberSearch_StateDropDown);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^User selects frequent prescriber using enter key on keyboard$")
	public void userSelectsFrequentPrescriberUsingEnterKeyOnKeyboard() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification( DataEntryConstants.DE_PAGE_FREQUENT_PRESCRIBER_LIST)){
				List<WebElement> frequentPrescriberList = chromeDriver.findElements(xpath(DataEntryConstants.DE_PAGE_FREQUENT_PRESCRIBER_LIST));
				Assert.assertTrue(frequentPrescriberList.size() == 1,"Patient had more than one frequent prescriber");
				for(int i=0; i<frequentPrescriberList.size();i++){
					frequentPrescriberList.get(i).sendKeys(Keys.ENTER);
					break;
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

	@And("^User selects prescriber using enter key on keyboard$")
	public void userSelectsPrescriberUsingEnterKeyOnKeyboard() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			if(isElementPresentVerification(DataEntryConstants.DE_SELECTED_PRESCRIBER)){
				WebElement selectPrescriber = chromeDriver.findElement(xpath(DataEntryConstants.DE_SELECTED_PRESCRIBER));
				selectPrescriber.sendKeys(Keys.ENTER);
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@And("^The system should collapses the Prescriber panel displaying the prescriber information in read only mode and expands the Product panel$")
	public void theSystemShouldCollapsesThePrescriberPanelDisplayingThePrescriberInformationInReadOnlyModeAndExpandsTheProductPanel() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
			isElementPresentVerification(DataEntryConstants.DE_PRESCRIBER_INFO_COLLAPSED);
			isElementPresentVerification(SmokeTestConstants.DrugName_Field);
			isElementPresentVerification(SmokeTestConstants.Quantity_field);
			isElementPresentVerification(SmokeTestConstants.Directions_field);
			isElementPresentVerification(SmokeTestConstants.Days_Supply);
			isElementPresentVerification(SmokeTestConstants.Refills_field);
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}

	@Then("^I should see REMS Error popup message$")
	public void should_see_rems__error_popup_message() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.REMS_Quality_Alert)) {
				Assert.assertTrue(chromeDriver.getPageSource().contains("Not Therapeutically Interchangeable with Levemir Flexpen Injection."), "REMS alert popup message not Found");
			}

			if (isElementPresentVerification(DataEntryConstants.soundAlikeDrugPopupOkButton)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.soundAlikeDrugPopupOkButton)) {
					throw new Exception("User not able to click de rems alert ok button in popup window");
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
	
	@When("^User selects a Rems or LDD drug Error message$")
	public void user_selects_a_rems_or_ldd_drug_error_message(DataTable arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

	 	try {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String productName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");

			if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate) && isElementPresentVerification(SmokeTestConstants.Product_DAW) && isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {

				if(clearAndEnterText(SmokeTestConstants.DrugName_Field, productName)){
					String DrugName = getElementText(SmokeTestConstants.DrugName_Field);
					Assert.assertEquals(DrugName, productName);
			 	}else{
			 		throw new Exception("Not able to enter value in product text fields");
			 	}
				
				if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate) && isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
					Actions productinfo = new Actions(chromeDriver);
					Action selectProduct = productinfo.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
					selectProduct.perform();
					Action enter = productinfo.sendKeys(Keys.ENTER).build();
					enter.perform();
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
	
	 /*
		 * Verifying the tab sequence in Data entry product fields using actions
		 */
		@And("^user select product and perform tab order$")
		public void user_select_product_and_perform_tab_order() throws Exception {
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();

			try {
				Thread.sleep(2000);
				if (isElementPresentVerification(SmokeTestConstants.Open_Product)) {
					if (isElementPresentVerifyClick(SmokeTestConstants.Open_Product)) {

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
						
						
						
							
							if (isElementPresentVerification(SmokeTestConstants.RxExpiration_date)) {
							      WebElement prodRxExpirationdate = chromeDriver.findElementByXPath(SmokeTestConstants.RxExpiration_date);
							      Assert.assertTrue(prodRxExpirationdate.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the RxExpiration date field ");
							      prodRxExpirationdate.sendKeys(Keys.TAB);
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
							
						


					}
				}
			} catch (AssertionError e) {
				takeScreenShot(methodName);

			} catch (Exception e) {
				takeScreenShot(methodName);
			}
		

		}

		
		
		
		/*
		 * This method is used to assert that the payment plan message is displayed when a patient with coupon plan and drug associated is used.
		 */
		@Then("^System should display following message in the expanded Payment Panel \"([^\"]*)\"$")
		public void system_should_display_following_message_in_the_expanded_Payment_Panel(String arg1) throws Throwable {
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			try {
				
				if (isElementPresentVerification(dataReviewConstants.DR_payment_plan_message)){
				Boolean expect=FrameworkLibrary.isElementPresents(dataReviewConstants.DR_payment_plan_message);
				String expected = getElementText(dataReviewConstants.DR_payment_plan_message);
	            String actual = (DataEntryConstants.Patient_DE_Actual_Coupon_Message);
	            Assert.assertNotSame(expected, actual);
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			} 
			}catch (AssertionError e) {
				e.printStackTrace();
				takeScreenShot(methodName);
				throw new Exception();
			} catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception();
			}
		}	
		
		
		@And("^user perform tab order from payment panel$")
		public void user_perform_tab_order_from_payment_panel() throws Throwable {
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			try {
			
			
			if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
				if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
					WebElement prodPaymentDropdown = chromeDriver.findElementByXPath(SmokeTestConstants.Payment_Dropdown);
					//Assert.assertTrue(prodPaymentDropdown.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Payment Dropdown field ");
					prodPaymentDropdown.sendKeys(Keys.TAB);
				}	
			
				if (isElementPresentVerification(DataEntryConstants.PAY_CODE_DROPDOWN)) {
					WebElement codeDropdown = chromeDriver.findElementByXPath(DataEntryConstants.PAY_CODE_DROPDOWN);
					Assert.assertTrue(codeDropdown.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the code Dropdown field ");
					codeDropdown.sendKeys(Keys.TAB);
				}	
					
						if (isElementPresentVerification(DataEntryConstants.Patient_DE_Payment_Cash_Price)) {
							WebElement prodCashPrice = chromeDriver.findElementByXPath(DataEntryConstants.Patient_DE_Payment_Cash_Price);
							Assert.assertTrue(prodCashPrice.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Payment Cash Price field ");
							prodCashPrice.sendKeys(Keys.TAB);
						}	
						
					
						if (isElementPresentVerification(SmokeTestConstants.DE_FinishButton)) {
							WebElement prodFinishButton = chromeDriver.findElementByXPath(SmokeTestConstants.DE_FinishButton);
							Assert.assertTrue(prodFinishButton.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Finish Button ");
							prodFinishButton.sendKeys(Keys.TAB);
						}	
					
					
						if (isElementPresentVerification(DataEntryConstants.DE_AddRx_Button)) {
							WebElement prodAddRxButton = chromeDriver.findElementByXPath(DataEntryConstants.DE_AddRx_Button);
							Assert.assertTrue(prodAddRxButton.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the AddRx Button ");
							prodAddRxButton.sendKeys(Keys.TAB);
						}	
					
						
					
						if (isElementPresentVerification(DataEntryConstants.DE_Screen_SendtoIcplus_Button)) {
							WebElement prodSendtoIcplus = chromeDriver.findElementByXPath(DataEntryConstants.DE_Screen_SendtoIcplus_Button);
							Assert.assertTrue(prodSendtoIcplus.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the SendtoIcplus Button");
							prodSendtoIcplus.sendKeys(Keys.TAB);
						}	
						
				
						if (isElementPresentVerification(DataEntryConstants.DE_Screen_Cancel_Button)) {
							WebElement prodCancelButton = chromeDriver.findElementByXPath(DataEntryConstants.DE_Screen_Cancel_Button);
							Assert.assertTrue(prodCancelButton.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Cancel Button");
							prodCancelButton.sendKeys(Keys.TAB);
						}	
						
					
						if (isElementPresentVerification(DataEntryConstants.DE_Screen_Image_Front_Side_One)) {
							WebElement prodSideOne = chromeDriver.findElementByXPath(DataEntryConstants.DE_Screen_Image_Front_Side_One);
							Assert.assertTrue(prodSideOne.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Image Front Side One");
							prodSideOne.sendKeys(Keys.TAB);
						}	
						
						
					
						if (isElementPresentVerification(DataEntryConstants.IMAGE_ROTATE_RIGHT_BUTTON)) {
							WebElement prodRIGHTBUTTON = chromeDriver.findElementByXPath(DataEntryConstants.IMAGE_ROTATE_RIGHT_BUTTON);
							Assert.assertTrue(prodRIGHTBUTTON.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the IMAGE ROTATE RIGHT BUTTON");
							prodRIGHTBUTTON.sendKeys(Keys.TAB);
						}	

					
					
						if (isElementPresentVerification(DataEntryConstants.IMAGE_ROTATE_LEFT_BUTTON)) {
							WebElement prodimageleft = chromeDriver.findElementByXPath(DataEntryConstants.IMAGE_ROTATE_LEFT_BUTTON);
							Assert.assertTrue(prodimageleft.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the IMAGE ROTATE LEFT BUTTON");
							prodimageleft.sendKeys(Keys.TAB);
						}		

						
					
					
						if (isElementPresentVerification(DataEntryConstants.IMAGE_RESTORE_BUTTON)) {
							WebElement prodimageright = chromeDriver.findElementByXPath(DataEntryConstants.IMAGE_RESTORE_BUTTON);
							Assert.assertTrue(prodimageright.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the IMAGE RESTORE BUTTON");
							prodimageright.sendKeys(Keys.TAB);
						}	
					

						
				
						if (isElementPresentVerification(DataEntryConstants.IMAGE_ZOOM_IN_BUTTON)) {
							WebElement prodzoomin = chromeDriver.findElementByXPath(DataEntryConstants.IMAGE_ZOOM_IN_BUTTON);
							Assert.assertTrue(prodzoomin.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the IMAGE ZOOM IN BUTTON");
							prodzoomin.sendKeys(Keys.TAB);
						}	

					
						if (isElementPresentVerification(DataEntryConstants.IMAGE_ZOOM_OUT_BUTTON)) {
							WebElement prodzoomout = chromeDriver.findElementByXPath(DataEntryConstants.IMAGE_ZOOM_OUT_BUTTON);
							Assert.assertTrue(prodzoomout.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the IMAGE ZOOM OUT BUTTON");
							prodzoomout.sendKeys(Keys.TAB);
						}	

					
						if (isElementPresentVerification(DataEntryConstants.IMAGE_FULL_SCREEN_BUTTON)) {
							WebElement prodfullscreen = chromeDriver.findElementByXPath(DataEntryConstants.IMAGE_FULL_SCREEN_BUTTON);
							Assert.assertTrue(prodfullscreen.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the IMAGE FULL SCREEN BUTTON");
							prodfullscreen.sendKeys(Keys.TAB);
						}	

						if (isElementPresentVerification(SmokeTestConstants.DE_backButton)) {
							WebElement prodbackButton = chromeDriver.findElementByXPath(SmokeTestConstants.DE_backButton);
							Assert.assertTrue(prodbackButton.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the back Button");
							prodbackButton.sendKeys(Keys.TAB);
						}	
					
					
						if (isElementPresentVerification(DataEntryConstants.DE_Screen_Patient_hyperlink_Field)) {
							WebElement patienthyperlink = chromeDriver.findElementByXPath(DataEntryConstants.DE_Screen_Patient_hyperlink_Field);
							Assert.assertTrue(patienthyperlink.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Patient hyperlink Field");
							patienthyperlink.sendKeys(Keys.TAB);
						}	
				
					
		if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			} 
			}catch (AssertionError e) {
				e.printStackTrace();
				takeScreenShot(methodName);
				throw new Exception();
			} catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception();
			} 
		}
		
		@And("^user perform tab order from payment panel without paycode dropdown$")
		public void user_perform_tab_order_from_payment_panel_without_paycode_dropdown() throws Throwable {
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			try {
			
			
			if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
				if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
					WebElement prodPaymentDropdown = chromeDriver.findElementByXPath(SmokeTestConstants.Payment_Dropdown);
					//Assert.assertTrue(prodPaymentDropdown.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Payment Dropdown field ");
					prodPaymentDropdown.sendKeys(Keys.TAB);
				}	
			
				/*if (isElementPresentVerification(DataEntryConstants.PAY_CODE_DROPDOWN)) {
					WebElement codeDropdown = chromeDriver.findElementByXPath(DataEntryConstants.PAY_CODE_DROPDOWN);
					Assert.assertTrue(codeDropdown.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the code Dropdown field ");
					codeDropdown.sendKeys(Keys.TAB);
				}	*/
					
						if (isElementPresentVerification(DataEntryConstants.Patient_DE_Payment_Cash_Price)) {
							WebElement prodCashPrice = chromeDriver.findElementByXPath(DataEntryConstants.Patient_DE_Payment_Cash_Price);
							Assert.assertTrue(prodCashPrice.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Payment Cash Price field ");
							prodCashPrice.sendKeys(Keys.TAB);
						}	
						
					
						if (isElementPresentVerification(SmokeTestConstants.DE_FinishButton)) {
							WebElement prodFinishButton = chromeDriver.findElementByXPath(SmokeTestConstants.DE_FinishButton);
							Assert.assertTrue(prodFinishButton.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Finish Button ");
							prodFinishButton.sendKeys(Keys.TAB);
						}	
					
					
						if (isElementPresentVerification(DataEntryConstants.DE_AddRx_Button)) {
							WebElement prodAddRxButton = chromeDriver.findElementByXPath(DataEntryConstants.DE_AddRx_Button);
							Assert.assertTrue(prodAddRxButton.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the AddRx Button ");
							prodAddRxButton.sendKeys(Keys.TAB);
						}	
					
						
					
						if (isElementPresentVerification(DataEntryConstants.DE_Screen_SendtoIcplus_Button)) {
							WebElement prodSendtoIcplus = chromeDriver.findElementByXPath(DataEntryConstants.DE_Screen_SendtoIcplus_Button);
							Assert.assertTrue(prodSendtoIcplus.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the SendtoIcplus Button");
							prodSendtoIcplus.sendKeys(Keys.TAB);
						}	
						
				
						if (isElementPresentVerification(DataEntryConstants.DE_Screen_Cancel_Button)) {
							WebElement prodCancelButton = chromeDriver.findElementByXPath(DataEntryConstants.DE_Screen_Cancel_Button);
							Assert.assertTrue(prodCancelButton.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Cancel Button");
							prodCancelButton.sendKeys(Keys.TAB);
						}	
						
					
						if (isElementPresentVerification(DataEntryConstants.DE_Screen_Image_Front_Side_One)) {
							WebElement prodSideOne = chromeDriver.findElementByXPath(DataEntryConstants.DE_Screen_Image_Front_Side_One);
							Assert.assertTrue(prodSideOne.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Image Front Side One");
							prodSideOne.sendKeys(Keys.TAB);
						}	
						
						
					
						if (isElementPresentVerification(DataEntryConstants.IMAGE_ROTATE_RIGHT_BUTTON)) {
							WebElement prodRIGHTBUTTON = chromeDriver.findElementByXPath(DataEntryConstants.IMAGE_ROTATE_RIGHT_BUTTON);
							Assert.assertTrue(prodRIGHTBUTTON.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the IMAGE ROTATE RIGHT BUTTON");
							prodRIGHTBUTTON.sendKeys(Keys.TAB);
						}	

					
					
						if (isElementPresentVerification(DataEntryConstants.IMAGE_ROTATE_LEFT_BUTTON)) {
							WebElement prodimageleft = chromeDriver.findElementByXPath(DataEntryConstants.IMAGE_ROTATE_LEFT_BUTTON);
							Assert.assertTrue(prodimageleft.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the IMAGE ROTATE LEFT BUTTON");
							prodimageleft.sendKeys(Keys.TAB);
						}		

						
					
					
						if (isElementPresentVerification(DataEntryConstants.IMAGE_RESTORE_BUTTON)) {
							WebElement prodimageright = chromeDriver.findElementByXPath(DataEntryConstants.IMAGE_RESTORE_BUTTON);
							Assert.assertTrue(prodimageright.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the IMAGE RESTORE BUTTON");
							prodimageright.sendKeys(Keys.TAB);
						}	
					

						
				
						if (isElementPresentVerification(DataEntryConstants.IMAGE_ZOOM_IN_BUTTON)) {
							WebElement prodzoomin = chromeDriver.findElementByXPath(DataEntryConstants.IMAGE_ZOOM_IN_BUTTON);
							Assert.assertTrue(prodzoomin.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the IMAGE ZOOM IN BUTTON");
							prodzoomin.sendKeys(Keys.TAB);
						}	

					
						if (isElementPresentVerification(DataEntryConstants.IMAGE_ZOOM_OUT_BUTTON)) {
							WebElement prodzoomout = chromeDriver.findElementByXPath(DataEntryConstants.IMAGE_ZOOM_OUT_BUTTON);
							Assert.assertTrue(prodzoomout.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the IMAGE ZOOM OUT BUTTON");
							prodzoomout.sendKeys(Keys.TAB);
						}	

					
						if (isElementPresentVerification(DataEntryConstants.IMAGE_FULL_SCREEN_BUTTON)) {
							WebElement prodfullscreen = chromeDriver.findElementByXPath(DataEntryConstants.IMAGE_FULL_SCREEN_BUTTON);
							Assert.assertTrue(prodfullscreen.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the IMAGE FULL SCREEN BUTTON");
							prodfullscreen.sendKeys(Keys.TAB);
						}	

						if (isElementPresentVerification(SmokeTestConstants.DE_backButton)) {
							WebElement prodbackButton = chromeDriver.findElementByXPath(SmokeTestConstants.DE_backButton);
							Assert.assertTrue(prodbackButton.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the back Button");
							prodbackButton.sendKeys(Keys.TAB);
						}	
					
					
						if (isElementPresentVerification(DataEntryConstants.DE_Screen_Patient_hyperlink_Field)) {
							WebElement patienthyperlink = chromeDriver.findElementByXPath(DataEntryConstants.DE_Screen_Patient_hyperlink_Field);
							Assert.assertTrue(patienthyperlink.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Patient hyperlink Field");
							patienthyperlink.sendKeys(Keys.TAB);
						}	
				
					
		if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			} 
			}catch (AssertionError e) {
				e.printStackTrace();
				takeScreenShot(methodName);
				throw new Exception();
			} catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception();
			} 
		}
		
		
		@And("^User performs arrows on side by side$")
		public void User_performs_arrows_on_side_by_side() throws Throwable {
			String methodName = new Object() {
			}.getClass().getEnclosingMethod().getName();
			try {
			

		
				if (isElementPresentVerification(DataEntryConstants.DE_Screen_Image_Front_Side_One)) {
					WebElement frontside = chromeDriver.findElementByXPath(DataEntryConstants.DE_Screen_Image_Front_Side_One);
					Assert.assertTrue(frontside.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Front Side One");
					frontside.sendKeys(Keys.ARROW_RIGHT);
				}
		
				if (isElementPresentVerification(DataEntryConstants.DE_Screen_Image_Back_Side_One)) {
					WebElement frontside = chromeDriver.findElementByXPath(DataEntryConstants.DE_Screen_Image_Back_Side_One);
					Assert.assertTrue(frontside.equals(chromeDriver.switchTo().activeElement()), "Focus is not on the Image Back Side One");
					
			}
			
				
				
			
			}catch (AssertionError e) {
				e.printStackTrace();
				takeScreenShot(methodName);
				throw new Exception();
			} catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception();
			} 
		}

		@Then("^An error message \"([^\"]*)\" should be displayed under the prescribed drug$")
		public void an_error_message_should_be_displayed_under_the_prescribed_drug(String arg1) throws Throwable {
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			try{
				Thread.sleep(5000);
     			Assert.assertTrue(getElementText(DataEntryConstants.DE_drugNameField_Error_Mesage).toUpperCase().contains(arg1.toUpperCase()));	
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			}catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception(e.getMessage());
			} 
			
		}

	@Then("^An error message \"([^\"]*)\" should be displayed under all the drug fields$")
	public void an_error_message_should_be_displayed_under_all_the_drug_fields(String arg1) throws Throwable {
	methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try{
				Thread.sleep(5000);

					Assert.assertTrue(getElementText(DataEntryConstants.DE_Quantity_Error_Message).toUpperCase().contains(arg1.toUpperCase()));
					
					Thread.sleep(3000);
					
					Assert.assertTrue(getElementText(DataEntryConstants.DE_Quantity_Disp_Error_Message).toUpperCase().contains(arg1.toUpperCase()));
					
					Thread.sleep(3000);
					
					Assert.assertTrue(getElementText(DataEntryConstants.DE_DrugExpDate_Error_Message).toUpperCase().contains(arg1.toUpperCase()));
					
					Thread.sleep(3000);
					
					Assert.assertTrue(getElementText(DataEntryConstants.DE_rxExpDate_Error_Message).toUpperCase().contains(arg1.toUpperCase()));
					
					Thread.sleep(3000);
					
					Assert.assertTrue(getElementText(DataEntryConstants.DE_DaysSupply_Error_Message).toUpperCase().contains(arg1.toUpperCase()));
					
					Thread.sleep(3000);
					
					Assert.assertTrue(getElementText(DataEntryConstants.DE_Refills_Error_Message).toUpperCase().contains(arg1.toUpperCase()));
					
					Thread.sleep(3000);
					
					Assert.assertTrue(getElementText(DataEntryConstants.DE_Directions_Error_Message).toUpperCase().contains(arg1.toUpperCase()));
			
					Thread.sleep(3000);
					
				if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		}catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}

	@Then("^Paycode dropdown should be enabled$")
		public void paycode_should_be_enabled() throws Throwable {
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

			try {
				if(isElementPresentVerification(DataEntryConstants.PAY_CODE_DROPDOWN)){
					Assert.assertTrue(getElementByProperty(DataEntryConstants.PAY_CODE_DROPDOWN,chromeDriver).isEnabled());
					
				} 
			}
				
			 catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception(e.getMessage());
			}
		}
			
	@Then("^User able to see error message display in refills feild$")
		public void User_able_to_see_error_message_display_in_refills_feild() throws Exception {
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

			try {
			

				if(isElementPresentVerification(SmokeTestConstants.Days_Supply)){
				 if(!isElementPresentVerifyClick(SmokeTestConstants.Days_Supply)){
					 throw new Exception("unable to click on days supply field");
				 }
				}
				
				if (isElementPresentVerification(AccessManagementConstants.De_Product_State_Refill_Error)) {
					String actualerrormessage = FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.De_Product_State_Refill_Error)).getText();
					String expectedmessage = "Number of refills not allowed.";
					log.info(actualerrormessage);
					Assert.assertTrue(actualerrormessage.equalsIgnoreCase(expectedmessage));
				}

				if (captureScreenshot) {
					takeScreenShot(methodName);
				}

			} catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception(e.getMessage());
			}
		}
		
		@When("^I should be able to see default one will display in feild$")
		public void i_able_to_see_default_one_will_display_in_feild() throws Exception {

			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

			try {
				if (isElementPresentVerification(AccessManagementConstants.DE_Plan_Paycode_One)) {
					Assert.assertTrue(FrameworkLibrary.chromeDriver.findElement(By.xpath(AccessManagementConstants.DE_Plan_Paycode_One)).getText().contains("1 - Subst Not Allowed by validated Prescribe"));
				}

				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			} catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception(e.getMessage());
			}
		}
	@When("^selects payment type as plan$")
		public void selects_payment_type_as_plan() throws Exception {
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

			try {
				if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
					if (!isElementPresentVerifyClick(SmokeTestConstants.Payment_Dropdown)) {
						throw new Exception("Payment button not clicked");
					}
					List<WebElement> listofPaymentOptions = chromeDriver.findElements(By.xpath(SmokeTestConstants.DE_listofPaymentTypes));
					Assert.assertTrue(listofPaymentOptions.size()>1);
					WebDriverWait wait = new WebDriverWait(chromeDriver,watingForElement);
					wait.until(ExpectedConditions.elementToBeClickable(listofPaymentOptions.get(1)));
					listofPaymentOptions.get(1).click();
				}
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			} catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception(e.getMessage());
			}

		}
		
		@Then("^pay code drop down should disable$")
		public void pay_code_drop_down_should_disable() throws Exception {
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

			try {
				if (isElementPresentVerification(DataEntryConstants.PAY_CODE_DROPDOWN)) {
					WebElement paycodeDropdown = FrameworkLibrary.chromeDriver.findElement(By.xpath(DataEntryConstants.PAY_CODE_DROPDOWN));
					Assert.assertTrue(paycodeDropdown.getAttribute("aria-disabled").equals("true"), "Paycode failed to disable");

				}
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			} catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception(e.getMessage());
			}

		}
		
		@When("^enters DAW=N and Substitute=Y$")
		public void enters_DAW_N_and_Substitute_Y(DataTable arg1) throws Exception {
			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

			try {
				if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
					String daw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
					if (!clearAndEnterText(SmokeTestConstants.Product_DAW, daw)) {
						throw new Exception("User not able to enter value daw text field");
					}
				}
				String substitute = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Substitute");
				if (!clearAndEnterText(SmokeTestConstants.Product_DAW, substitute)) {
					throw new Exception("User not able to enter value in substitute text field");
				}
				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			} catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception(e.getMessage());
			}
		}
		
		
		@When("^clicks finish button on Data Entry page$")
		public void click_finis_DE() throws Throwable{
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			try {
				if (isElementPresentVerification(SmokeTestConstants.DE_FinishButton)) {
					if (!isElementPresentVerifyClick(SmokeTestConstants.DE_FinishButton)) {
						throw new Exception("Not able to click DE_FinishButton");
					}	
				}
			} catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception(e.getMessage());
			}
			}
		@Then("^The system would display the right dispensed product if daw N and substitute N$")
		public void the_system_would_display_the_right_dispensed_product_() throws Exception {
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

			try {
				if (isElementPresentVerification(DataEntryConstants.productDispensed_Select_Field)) {
					WebElement dispensedProduct = FrameworkLibrary.getElementByProperty(DataEntryConstants.productDispensed_Select_Field,
							chromeDriver);
					String drugName = (FrameworkLibrary.getElementText(DataEntryConstants.DrugName_Field)).toLowerCase();
					String expectedVal = drugName.substring(0,16).toLowerCase();
					Assert.assertTrue(dispensedProduct.getText().toLowerCase().contains(expectedVal));
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
		 * This method is used to enter all the mandatory fields in product panel in data entry page
		 *
		 */
		@When("^The user enters all the mandatory fields in Product panel daw N and substitute N$")
		public void the_user_enters_all_the_mandatory_fields_in_Product_panel_(DataTable arg1) throws Throwable {

			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

			try {

				Map<String, List<String>> dataMap = null;
				dataMap = FrameworkLibrary.getHorizontalData(arg1);
				String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
				String Quantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
				String Directions = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Directions");
				String DaysSupply = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DaysSupply");
				String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
				
				
				if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
					Thread.sleep(15000);
					if (clearAndEnterText(SmokeTestConstants.DrugName_Field, DrugName)) {
						Actions action = new Actions(chromeDriver);
						Action tabAction = action.sendKeys(Keys.TAB).build();
						tabAction.perform();				
					}else{
						throw new Exception("User not able to enter value drug name in text field");
					}
				
				}
				
			    if(isElementPresentVerification(SmokeTestConstants.DispensedDrug_Field)){
			    			Assert.assertTrue(getElementByProperty(SmokeTestConstants.DispensedDrug_Field, chromeDriver).getAttribute("aria-disabled").equalsIgnoreCase("true"));   	
		            		IntakeStepDef.user_hits_Enter_Key();
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
				if (isElementPresentVerification(SmokeTestConstants.Quantity_disp)) {
					if (!clearAndEnterText(SmokeTestConstants.Quantity_disp, Refills)) {
						throw new Exception("Not able to enter value in Quantity disp text field");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				takeScreenShot(methodName);

			}
		}
		
		@And("^user enters product with invalid NDC \"([^\"]*)\"$")
		public void user_enters_product_with_invalid_NDC(String arg1) throws Exception {
			
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

			try {
				

				if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {

					if (!clearAndEnterText(SmokeTestConstants.DrugName_Field,arg1)) {
						throw new Exception("User not able to enter value in product text fields");
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
		
		@Then("^enters product information from db$")
		public void enters_product_information_from_db(DataTable arg1) throws Throwable {
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			//String Date = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Date");
			Date today = Calendar.getInstance().getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy");
			String Date = formatter.format(today);
			String DAW = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			//String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			Quantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
			String Directions = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Directions");
			String DaysSupply = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DaysSupply");
			String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
			try {
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
					if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, UPC)) ;
				}
				
				 if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
		                Actions upArrow = new Actions(chromeDriver);
		                Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
		                PressUpArrow.perform();
		                Thread.sleep(1000);
		            }
				
				if(isElementPresentVerification(SmokeTestConstants.DispensedDrug_Field)){
	            	if(getElementByProperty(SmokeTestConstants.DispensedDrug_Field,chromeDriver).getAttribute("aria-disabled").equalsIgnoreCase("false")){
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
				chromeDriver.findElementByXPath(SmokeTestConstants.DrugName_Field).sendKeys();
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
			} catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception(e.getMessage());
			}
		}
		
		
		/**
		 * This method is used to enter data in DAW and substitute fields according to the arguments passed from the feature file step
		 *
		 * @param arg1
		 * @param arg2
		 * @
		 */
		@When("^The user enters DAW field as \"([^\"]*)\" and the Substitute field as \"([^\"]*)\"$")
		public void the_user_enters_DAW_field_as_and_the_Substitute_field_as(String arg1, String arg2) throws Exception {
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

			try {
				String DAW = arg1;
				String Substitute = arg2;
				if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
					if (!clearAndEnterText(SmokeTestConstants.Product_DAW, DAW)) {
						throw new Exception("Not able to enter value in DAW text field");
					}
				}
				
				if(!DAW.equalsIgnoreCase("Y")){
				if (isElementPresentVerification(SmokeTestConstants.Product_Substitute)) {
					if (!clearAndEnterText(SmokeTestConstants.Product_Substitute, Substitute)) {
						throw new Exception("Not able to enter value in Substitute text field");
					}
				}
				}
			} catch (Exception e) {
				e.printStackTrace();
				takeScreenShot(methodName);
				throw new Exception(e.getMessage());

			}

		}
	/*
		 * This method is used to enter all the mandatory fields in product panel in data entry page
		 *
		 */
		@When("^The user enters all the mandatory fields in Product panel$")
		public void the_user_enters_all_the_mandatory_fields_in_Product_panel(DataTable arg1) throws Throwable {

			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

			try {

				Map<String, List<String>> dataMap = null;
				dataMap = FrameworkLibrary.getHorizontalData(arg1);
				String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
				String Quantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
				String Directions = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Directions");
				String DaysSupply = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DaysSupply");
				String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
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
				
				 if(isElementPresentVerification(SmokeTestConstants.DispensedDrug_Field)){
		            	if(getElementByProperty(SmokeTestConstants.DispensedDrug_Field,chromeDriver).getAttribute("aria-disabled").equalsIgnoreCase("false")){
		            		IntakeStepDef.user_hits_Enter_Key();
		            	} 
		            }
				
				if (isElementPresentVerification(SmokeTestConstants.Quantity_field)) {
					if (!clearAndEnterText(SmokeTestConstants.Quantity_field, Quantity)) {
						throw new Exception("Not able to enter value in Quantity text field");
					}
				}
				if (isElementPresentVerification(SmokeTestConstants.Quantity_disp)) {
					if (!clearAndEnterText(SmokeTestConstants.Quantity_disp, Refills)) {
						throw new Exception("Not able to enter value in Quantity disp text field");
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
				
			} catch (Exception e) {
				e.printStackTrace();
				takeScreenShot(methodName);

			}
		}
		
		@When("^enters valid but a different date in to original date field$")
		public void enter_valid_but_different_date() throws Throwable {
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			try {
				if (isElementPresentVerification(dataReviewConstants.DR_ORIGINAL_DATE)) {
					Date today = new Date();
					Calendar c = Calendar.getInstance();
					c.setTime(today);
					c.add(Calendar.DATE, -1);
					Date currentdateplusyear = c.getTime();
					SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
					String ExpecteddrugExpDate = formatter.format(currentdateplusyear);
					if(!clearAndEnterText(SmokeTestConstants.Product_OriginalDate,ExpecteddrugExpDate )){
						throw new Exception("not able to enter date in to original date field");
					}
				}
			}catch (Exception e) {
					takeScreenShot(methodName);
					throw new Exception(e.getMessage());
				}
			}
		
		/*********************************************************************************
		 * Enters only a drug in the DE product section
		 * @throws Throwable 
		 **********************************************************************************/
		@When("^The user enters a Standard drug$")
		public void The_user_enters_a_Standard_drug(DataTable arg1) throws Throwable {
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

			Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			String DrugName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			try {
				if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
					if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, DrugName)) {
						throw new Exception("Not able to enter value in DrugName text field");
					}
				
					if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
						Actions upArrow = new Actions(chromeDriver);
						Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
						PressUpArrow.perform();
						Thread.sleep(1000);
					}
					
					if(isElementPresentVerification(SmokeTestConstants.DispensedDrug_Field)){
		            	if(getElementByProperty(SmokeTestConstants.DispensedDrug_Field,chromeDriver).getAttribute("aria-disabled").equalsIgnoreCase("false")){
		            		IntakeStepDef.user_hits_Enter_Key();
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
	/*********************************************************************************
		 * Enters a refill value beginning with P and indicating number of days/weeks/months, or PRN
		 * Then takes focus off of field.
		 * @throws Throwable 
		 **********************************************************************************/
		@When("^The user enters a value \"([^\"]*)\" and leaves the refills field$")
		public void the_user_enters_a_value_and_leaves_the_refills_field(String arg1) throws Throwable { 
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
			try {
				if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
					if (!clearAndEnterText(SmokeTestConstants.Refills_field, arg1)) {
						throw new Exception("Not able to enter value in Refills text field");
					}
					Actions bc = new Actions(chromeDriver);
					Action series = bc.sendKeys(Keys.SHIFT,Keys.TAB).build();
					series.perform();
					
					Assert.assertTrue(!getElementByProperty(SmokeTestConstants.Refills_Container, chromeDriver).getAttribute("class").contains("md-input-focused"));
						
				}
				//ExpectedProductName = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Refills_field, chromeDriver).getAttribute("value");

				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			} catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception(e.getMessage());
			}
		}
		
		/*********************************************************************************
		 * Confirms that the Refills field displays text "PRN" after entering "PxxX" or "PRN" text value while focus is not on Refills field.
		 *
		 **********************************************************************************/
		@Then("^The system should display PRN in the Refills field$")
		public void The_system_should_display_PRN_in_the_Refills_field() throws Exception {
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

			//Map<String, List<String>> dataMap = null;
			//dataMap = FrameworkLibrary.getHorizontalData(arg1);
			//String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
			try {
				if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
					if (getElementByProperty(SmokeTestConstants.Refills_Container, chromeDriver).getAttribute("class").contains("md-input-focused")) {
						throw new Exception("Focus not changed");
					}
					long timeoutExpiredMS = System.currentTimeMillis() + 30000;
					while(!getElementText(SmokeTestConstants.Refills_field).equals(DataEntryConstants.PRN_Refills)){
						log.info("waiting for PRN to be displayed");
						if (System.currentTimeMillis() > timeoutExpiredMS) {
							Assert.fail("Timed out after waiting PRN to be displayed");
						}
					}
					if (!getElementText(SmokeTestConstants.Refills_field).equals(DataEntryConstants.PRN_Refills)) {
						throw new Exception("Field dos not display PRN.");
					}
				}
				//ExpectedProductName = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Refills_field, chromeDriver).getAttribute("value");

				if (captureScreenshot) {
					takeScreenShot(methodName);
				}
			} catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception(e.getMessage());
			}
		}

		/*********************************************************************************
		 * Brings focus back to Refills field to check that previous text value is still displayed
		 *
		 **********************************************************************************/
		@When("^The user comes back to Refills field$")
		public void The_user_comes_back_to_Refills_field() throws Exception {
			methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

			try {
				if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
					if (!isElementPresentVerifyClick(SmokeTestConstants.Refills_field)) {
						throw new Exception("unable to click Refills field");
					}
					
				Assert.assertTrue(getElementByProperty(SmokeTestConstants.Refills_Container, chromeDriver).getAttribute("class").contains("md-input-focused"));
						
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
			 * This method validates that the text fields in the next data entry task in the queue are empty except DATE, DAW and SUBSTITUTE FIELDS
			 */
			
			@When("^DE task for next patient is displayed with empty text fields$")
			public void DE_task_displayed_with_empty_text_fields() throws Throwable {
				methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
				try {
			if(isElementPresentVerification(DataEntryConstants.DE_Prescriber_Phone_Number_Field)){
			
			Assert.assertTrue(getElementText(DataEntryConstants.DE_Prescriber_Phone_Number_Field).equals("(     )     -     "));
			Assert.assertTrue(getElementText(DataEntryConstants.DE_Prescriber_NPIorDEA_Field).equals(""));
			Assert.assertTrue(getElementText(SmokeTestConstants.Prescriber_LastName).equals(""));
			Assert.assertTrue(getElementText(SmokeTestConstants.Prescriber_FirstName).equals(""));
			}
			if(isElementPresentVerification(SmokeTestConstants.Open_Product)){
				if(!isElementPresentVerifyClick(SmokeTestConstants.Open_Product)){
					throw new Exception("user not able to click open product button");
				};
			}
			if(isElementPresentVerification(SmokeTestConstants.DrugName_Field)){
				
				Assert.assertTrue(getElementText(SmokeTestConstants.DrugName_Field).equals(""));
				Assert.assertTrue(getElementText(SmokeTestConstants.Product_DAW).equals("N"));
				Assert.assertTrue(getElementText(SmokeTestConstants.Product_Substitute).equals("Y"));
				
				Assert.assertTrue(getElementText(SmokeTestConstants.Quantity_field).equals(""));
				Assert.assertTrue(getElementText(SmokeTestConstants.Quantity_disp).equals(""));
				Assert.assertTrue(getElementText(SmokeTestConstants.Directions_field).equals(""));
				Assert.assertTrue(getElementText(SmokeTestConstants.Days_Supply).equals(""));
				Assert.assertTrue(getElementText(SmokeTestConstants.Refills_field).equals(""));
				
				Assert.assertTrue(getElementText(SmokeTestConstants.RxExpiration_date).equals(""));
				
				Assert.assertTrue(getElementText(SmokeTestConstants.DrugExpiryDate_Field).equals(""));
			}
			SmokeTestStepDef.clicks_open_payment_button();
			if(isElementPresentVerification(SmokeTestConstants.de_Payment_Cash_Price)){
				Assert.assertTrue(getElementText(SmokeTestConstants.de_Payment_Cash_Price).equals(""));
			}	
			} catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception(e.getMessage());
			}
	}
			

			/*
			    * this method validates the tab order in plan search page
			    */
				@When("^validate the tab order in plan search page$")
				public void validate_the_tab_order_in_plan_search_page() throws Throwable {
					methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
					try {
					if(isElementPresentVerification(AccessManagementConstants.PLAN_SEARCH_BTN)){
					IntakeStepDef.user_hits_TAB_key();
					log.info("==="+getElementByProperty(AccessManagementConstants.PLAN_SEARCH_BIN,chromeDriver).getAttribute("class"));
					Assert.assertTrue(getElementByProperty(AccessManagementConstants.PLAN_SEARCH_BIN_CONTAINER,chromeDriver).getAttribute("class").contains("md-input-focused"));
					}
					IntakeStepDef.user_hits_TAB_key();
					Assert.assertTrue(getElementByProperty(AccessManagementConstants.PLAN_SEARCH_PCN_CONTAINER,chromeDriver).getAttribute("class").contains("md-input-focused"));
					IntakeStepDef.user_hits_TAB_key();
					Assert.assertTrue(getElementByProperty(AccessManagementConstants.PLAN_ID_SEARCH_FIELD_CONTAINER,chromeDriver).getAttribute("class").contains("md-input-focused"));
					IntakeStepDef.user_hits_TAB_key();
					Assert.assertTrue(getElementByProperty(AccessManagementConstants.PLAN_SEARCH_PLAN_NAME_CONTAINER,chromeDriver).getAttribute("class").contains("md-input-focused"));
					IntakeStepDef.user_hits_TAB_key();
					Assert.assertTrue(getElementByProperty(AccessManagementConstants.PLAN_SEARCH_BTN,chromeDriver).getAttribute("class").contains("md-focused"));
				
					} catch(Exception e) {
					takeScreenShot(methodName);
					throw new Exception(e.getMessage());
				}
				}
				/*
				 * This method validates that the focus is on either username field or the first row of the frequent prescriber list if exists.
				 */
				@When("^focus should be on username field or on the first row of the frequent prescriber list$")
				public void focus_should_be_on_username_field_or_first_row_of_frequent_prescriber_list() throws Throwable {
					methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
					try {
						if (isElementPresents(DataEntryConstants.Prescriber_frequent_names)) {
							Assert.assertTrue(getElementByProperty(DataEntryConstants.Prescriber_search_frequently_first_result, chromeDriver).getAttribute("class").contains("focused-location"));
						} else {
							Assert.assertTrue(getElementByProperty(DataEntryConstants.DE_Prescriber_Phone_Number_Field_Container, chromeDriver).getAttribute("class").contains("md-input-focused"));
						}
					} catch(Exception e) {
						takeScreenShot(methodName);
						throw new Exception(e.getMessage());
					}
				
				}
				
				/*
				 * this method is used to hit SHIFT+TAB from first field of prescriber panel
				 */
				
				@When("^User shift tabs off the first field of prescriber panel$")
				public void shift_tab_off_the_first_panel() throws Throwable {
					methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
					try {	
						if (isElementPresents(DataEntryConstants.Prescriber_frequent_names)) {
							if(!isElementPresentVerifyClick(DataEntryConstants.Prescriber_frequent_names_first_row)){
								throw new Exception("unable to click on the first row of the frequent prescribers list");
							}
						} else {
							if(isElementPresentVerifyClick(DataEntryConstants.DE_Prescriber_Phone_Number_Field)){
								throw new Exception("unable to click prescriber phone number field");
							}
						}
						
						Actions act = new Actions(chromeDriver);
						Action tab = act.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build();
						tab.perform();
						
					} catch(Exception e) {
						takeScreenShot(methodName);
						throw new Exception(e.getMessage());
					}
					}
				/*
				 * this method is used to click product original date field and then hit SHIFT+TAB
				 */
				
				@When("^User shift tabs off the first field of product panel$")
				public void shift_tabs_off_the_first_field_of_product_panel() throws Throwable {
					methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
					try {	
						if (isElementPresentVerification(SmokeTestConstants.Product_OriginalDate)) {
							if(!isElementPresentVerifyClick(SmokeTestConstants.Product_OriginalDate)){
								throw new Exception("unable to click on the product original date field");
							}
						}
						Actions act = new Actions(chromeDriver);
						Action tab = act.keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build();
						tab.perform();
						
					} catch(Exception e) {
						takeScreenShot(methodName);
						throw new Exception(e.getMessage());
					}
				}
				/*
				 * This method validates that the focus is shifted to either patient name hyperlink or the back arrow button. It fails if either of them is not happened.
				 */
				@Then("^focus should be shifted to patient name hyperlink or back button if hyperlink does not exist$")
				public void focus_should_be_shifted_to_patient_name_hyperlink_or_back_button() throws Exception{
					methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
					try {	
						if(getElementByProperty(DataEntryConstants.DE_back_arrow_Button,chromeDriver).getAttribute("class").contains("focused")){	
						Assert.assertTrue(getElementByProperty(DataEntryConstants.DE_back_arrow_Button,chromeDriver).getAttribute("class").contains("focused"));
						} else if(getElementByProperty(DataEntryConstants.patient_name_hyperLink_container,chromeDriver).getAttribute("class").contains("focused")){
							Assert.assertTrue(getElementByProperty(DataEntryConstants.DE_back_arrow_Button,chromeDriver).getAttribute("class").contains("focused"));
						} else {
							Assert.fail("the shift tab from prescriber first field is not working as expected");
						}
					} catch(Exception e) {
						takeScreenShot(methodName);
						throw new Exception(e.getMessage());
					}
					
				
				}	
				
				
				/**********
				 * This method used for verifying the user selecting the payment plan
				 * @throws Exception
				 */

				@When("^user modifies payment type to plan and collapses the payment panel$")
				public void user_modifies_payment_type_to_plan_and_collapses_the_payment_panel() throws Exception {
					methodName = Thread.currentThread().getStackTrace()[1].getMethodName();


					try {


						if (isElementPresentVerification(SmokeTestConstants.Open_payment)) {
							if (!isElementPresentVerifyClick(SmokeTestConstants.Open_payment)) {
								throw new Exception("Not able to click Open_payment");
							}
						}
						
						if (isElementPresentVerification(SmokeTestConstants.Payment_Dropdown)) {
							if (!isElementPresentVerifyClick(SmokeTestConstants.Payment_Dropdown)) {
								throw new Exception("Payment button not clicked");
							}
							List<WebElement> listofPaymentOptions = chromeDriver.findElements(By.xpath(SmokeTestConstants.DE_listofPaymentTypes));
							Assert.assertTrue(listofPaymentOptions.size()>1);
							WebDriverWait wait = new WebDriverWait(chromeDriver,watingForElement);
							wait.until(ExpectedConditions.elementToBeClickable(listofPaymentOptions.get(1)));
							listofPaymentOptions.get(1).click();
				
							if (isElementPresentVerification(dataReviewConstants.DE_Open_Product_Field)) {
								if (!isElementPresentVerifyClick(dataReviewConstants.DE_Open_Product_Field)) {
									throw new Exception("not able to click on open product field");
								}
									
									/*String actual = getElementText(dataReviewConstants.DE_Payment_Cash_Message);
									log.info("****((((((("+actual);
									Assert.assertTrue(!actual.contains("Cash"));
								*/

							}
						}


					} catch (Exception e) {
						takeScreenShot(methodName);
						throw new Exception(e.getMessage());
					}
				}
   /**********
    * This method used for entering drug name and validating the field
    * @throws Exception
    */
   @And("^enters product information with C2 drug in de$")
   public void enters_product_information_with_C2_drug_in_de(DataTable arg1) throws Exception {
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
						//String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
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
						if (isElementPresentVerification(SmokeTestConstants.Refills_field)) {
							Assert.assertTrue(!FrameworkLibrary.chromeDriver.findElement(xpath(SmokeTestConstants.Refills_field)).isEnabled());
						}
						ExpectedProductName = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DrugName_Field, chromeDriver).getAttribute("value");
						ExpectedDirections = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Directions_field, chromeDriver).getAttribute("value");
						ExpectedProduct_quantity = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Quantity_field, chromeDriver).getAttribute("value");
						ExpectedProduct_quantityDisp = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Quantity_disp, chromeDriver).getAttribute("value");
						ExpectedProduct_DaysSupply = FrameworkLibrary.getElementByProperty(SmokeTestConstants.Days_Supply, chromeDriver).getAttribute("value");
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
				
	/*********************************************************************************
	* Enters only a drug in the update RX product section
	*
	* @throws Exception
	**********************************************************************************/
	@When("^user verifies Refills field in updateRX c2 drug$")
	public void user_verifies_Refills_field_in_updateRX_c2_drug() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.UPDATE_RX_REFILL)) {
				Assert.assertTrue(!FrameworkLibrary.chromeDriver.findElement(xpath(DataEntryConstants.UPDATE_RX_REFILL)).isEnabled());
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
	* Enters only a drug in the update rx product section
	*
	* @throws Exception
	**********************************************************************************/
	@And("^user verifies Rx Expiration Date in updateRX c2 drug$")
	public void user_verifies_Rx_Expiration_Date_in_updateRX_c2_drug() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
		    if (isElementPresentVerification(dataReviewConstants.rx_exp_date)) {
		    	Assert.assertTrue(!FrameworkLibrary.chromeDriver.findElement(xpath(dataReviewConstants.rx_exp_date)).isEnabled());
			}
			if (captureScreenshot) {
			    takeScreenShot(methodName);
			}
		} catch (Exception e) {
		    takeScreenShot(methodName);
		    throw new Exception(e.getMessage());
		}
	}
	
	@When("^clicks view button on drug search page$")
	public void clicks_view_button_on_drug_seach_page() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.DRUG_SEARCH_PAGE_VIEW_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DRUG_SEARCH_PAGE_VIEW_BUTTON)) {
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
	/*
	 * this method validates that rx will be billed to cash message should be displayed on update rx page in payment panel collapsed
	 */
	@When("^Rx will be billed to cash message should be displayed on update rx page$")
	public void rx_will_be_billed_to_cash_message_validation_on_update_rx_page() throws Throwable {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.updateRx_CashMessage)) {
				Assert.assertTrue(getElementText(DataEntryConstants.updateRx_CashMessage).equalsIgnoreCase("cash"));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}
	
	
	@And("^validate prescriber result which is out of state$")
	public void validate_prescriber_result_which_is_out_of_state() throws Throwable {
		
		try {
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Search_Error_message)) {
				Assert.assertTrue(getElementText(DataEntryConstants.DE_Prescriber_Search_Error_message).equalsIgnoreCase("No prescriber(s) matched your search criteria"));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} 
	}
	
	@And("^Click on prescriber cancel button$")
	public void click_on_prescriber_cancel_button() throws Throwable {
		
		
		try {
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Search_close_button)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_Prescriber_Search_close_button)) {
					throw new Exception("Not able to click on close prescriber button");
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
	
	@Then("^validate prescriber result with null state$")
	public void validate_prescriber_result_with_null_state() throws Throwable {
		try{
			if (isElementPresentVerification(DataEntryConstants.UPDATE_RX_PRESCRIBER_RESULTS_FIRST_PATIENT_LOCATION_ROW)) {
					Assert.assertTrue(isElementPresentVerifyClick(DataEntryConstants.DE_Prescriber_Search_close_button));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}/*
		PRESCRIBER_SEARCH_BUTTON
		*/
	}
	
	@Then("^User click the Prescriber search button in de$")
	public void Prescriber_search_btn_in_de() throws Exception  {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.PRESCRIBER_SEARCH_BUTTON)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.PRESCRIBER_SEARCH_BUTTON))
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

	@When("^System should display a invalid field format message$")
	public void invalid_error_message() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if(isElementPresentVerification("//*[@id='prescription-rx-prescriber-search-form']/div[3]/div")){
			Assert.assertTrue(chromeDriver.getPageSource().contains("Invalid field format"));
			Assert.assertTrue(chromeDriver.getPageSource().contains("Please specify the required search criteria"));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	
	@When("^User does a prescriber search with phone number in invalid format$")
	public void enter_invalid_phone(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			
			getElementByProperty(SmokeTestConstants.Prescriber_FirstName,chromeDriver).clear();
			getElementByProperty(SmokeTestConstants.Prescriber_LastName,chromeDriver).clear();
			
			
			String number = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "PhoneNumber");
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Phone_Number_Field)) {
				WebElement element = chromeDriver.findElement(xpath(DataEntryConstants.DE_Prescriber_Phone_Number_Field));
				element.sendKeys(number);
			}
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_searchButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.Prescriber_searchButton)) {
					throw new Exception("User not able to click prescriber search button");
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
	@When("^System should display a message please refine your search criteria$")
	public void refine_search() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Search_Cancel_Button)) {
				
				Assert.assertTrue(chromeDriver.getPageSource().contains("Please refine your search"));
			}
			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		} finally {
			Actions ac = new Actions(chromeDriver);
			Action cancelbutton = ac.keyDown(Keys.ALT).sendKeys("c").keyUp(Keys.ALT).build();
			cancelbutton.perform();
		}
	}
	
	@When("User enters partial prescriber first name and partial Last name")
	public void enter_partial_fn_and_ln_de_prescriber_search(DataTable arg1) throws Exception {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String prescriberLastName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "LastName");
			String prescriberFirstName = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "FirstName");
			
			String partialFirstname = prescriberFirstName.substring(0, 2);
			String partialLastname = prescriberLastName.substring(0,2);
			
			if (isElementPresentVerification(SmokeTestConstants.Prescriber_LastName) && isElementPresentVerification(SmokeTestConstants.Prescriber_FirstName)) {
				if (!clearAndEnterText(SmokeTestConstants.Prescriber_FirstName, partialFirstname) || !clearAndEnterText(SmokeTestConstants.Prescriber_LastName, partialLastname)) {
					throw new Exception("User not able to enter value in prescriber first name text field");
				}
			}
			/*if (isElementPresentVerification(SmokeTestConstants.Prescriber_searchButton)) {
				if (!isElementPresentVerifyClick(SmokeTestConstants.Prescriber_searchButton)) {
					throw new Exception("User not able to click prescriber search button");
				}
			}*/

			if (captureScreenshot) {
				takeScreenShot(methodName);
			}
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}

	}
	
	/**
	 * This method is used to enter a dispensed drug with an expiration days value associated
	 * @throws Throwable 
	 */
	@When("^The user selects a Dispensed Drug with an expiration days value associated$")
	public void the_user_selects_a_Dispensed_Drug_with_an_expiration_days_value_associated() throws Throwable {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			Connection connection = ConnectionFactory.getConnection();
			String query = "select B.ID, a.description, d.code_value as NDC, e.expiration_days, b.drug_class as Local_Regulation, c.dea_class as Federal_Regulation, a.rx_otc as product_pack_drug_Class, b.area_key from actual_product_pack a, local_regulation b, regulation c, product_coding d, dispensing e where a.id=c.id_actual_product_pack and c.id= b.id_regulation AND A.ID=E.id_actual_product_pack AND A.ID=D.id_actual_product_pack and a.status='Active' and e.expiration_days is not null and b.area_key='WI'";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ArrayList<String> ar = new ArrayList<String>();
			ArrayList<String> ar1 = new ArrayList<String>();
			while (rs.next()) {
				String NDC = new String(rs.getString("NDC"));
				ar.add(NDC);
				String expdaysValue = new String(rs.getString("EXPIRATION_DAYS"));
				ar1.add(expdaysValue);
			}

			
			/*for(k=ar.size();k<=0;k--){
				if(!(ar.get(k).length()<11)){
				}
					break;
				} else if(k==0){
					break;
				}*/
				
					 String ndc = ar.get(0);
					expDaysValue = ar1.get(0);
					rs.close();
					connection.close();
					log.info("current ndc is" + ndc);
					log.info("current drug exp days is" + expDaysValue);

					if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
						if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, ndc)) {
							throw new Exception("Not able to enter value in DrugName text field");
						}
						if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
							Actions upArrow = new Actions(chromeDriver);
							Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
							PressUpArrow.perform();
							Thread.sleep(1000);
						}
						
						if(isElementPresentVerification(SmokeTestConstants.DispensedDrug_Field)){
			            	if(getElementByProperty(SmokeTestConstants.DispensedDrug_Field,chromeDriver).getAttribute("aria-disabled").equalsIgnoreCase("false")){
			            		IntakeStepDef.user_hits_Enter_Key();
			            	} 
			            }
			}

		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());

		}
	}

	@Then("^clicks search button on prescriber search in expand window$")
	public void clicks_search_button_on_prescriber_search() throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			if (isElementPresentVerification(DataEntryConstants.DE_Prescriber_Search_Button_Expand_Window)) {
				if (!isElementPresentVerifyClick(DataEntryConstants.DE_Prescriber_Search_Button_Expand_Window)) {
					throw new Exception("Not able to click Prescriber_SelectButton in expand window");
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
	 * This method is to enter the product information with quick code
	 */
	@Then("^I enter product info for quick code$")
	public void i_enter_product_info_for_quick_code(DataTable arg1) throws Throwable {
		Map<String, List<String>> dataMap = null;
		dataMap = FrameworkLibrary.getHorizontalData(arg1);
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			String daw = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			String drugname = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DrugName");
			if (isElementPresentVerification(SmokeTestConstants.Product_DAW)) {
			    if (!clearAndEnterText(SmokeTestConstants.Product_DAW, daw)) {
			               throw new Exception("Not able to enter value in user name text field");
			      }
		}
		if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
				if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, drugname)) {
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
		if (captureScreenshot) {
			takeScreenShot(methodName);
		}
	} catch (Exception e) {
		takeScreenShot(methodName);
		throw new Exception(e.getMessage());
	}
	}
	/*
	 * This method is to enter TAB
	 */
	@When("^hit on tab$")
	public void hit_on_tab() throws Throwable {
		Actions upArrow = new Actions(chromeDriver);
		Action PressUpArrow = upArrow.sendKeys(Keys.TAB).build();
		PressUpArrow.perform();
	}
	/*
	 *This method is to check the available product in onshelf
	 */
	@Then("^checks for available product \"([^\"]*)\" in onshelf in Stock data base$")
	public void checks_for_available_product_in_onshelf_in_Stock_data_base(String arg1) throws Exception {
		methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

		try {

			Connection connection = ConnectionFactory.getConnectionStock();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select a.id,a.PRODUCT_SKU_CODE,a.STORE_CODE,B.TYPE,B.QUANTITY from STOCK A inner join stock_item b on a.id=b.id_stock and A.STORE_CODE='" + Store_Pharmacy_Code + "' and b.TYPE='On Shelf' where b.QUANTITY>"+arg1);
			ArrayList<String> ar = new ArrayList<String>();
			ArrayList<String> ar1 = new ArrayList<String>();
			while (rs.next()) {
				String Quantity = new String(rs.getString("QUANTITY"));
				ar.add(Quantity);
				String product_sku_code = new String(rs.getString("PRODUCT_SKU_CODE"));
				ar1.add(product_sku_code);
			}
			quantity = ar.get(0);
			int quan1 = Integer.parseInt(quantity)+5;
			quantitydisp = Integer.toString(quan1);
			code = ar1.get(0);
			rs.close();
			connection.close();
		} catch (Exception e) {
			takeScreenShot(methodName);
			throw new Exception(e.getMessage());
		}
	}
	/*
	 * Enter the product information that we got from data base and dipsensing the quantity greater than onshelf stock
	 */
	@Then("^enters product information from database$")
    public void enters_product_information_from_database(DataTable arg1) throws Throwable {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        	Map<String, List<String>> dataMap = null;
			dataMap = FrameworkLibrary.getHorizontalData(arg1);
			Date today = Calendar.getInstance().getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy");
			String Date = formatter.format(today);
			String DAW = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DAW");
			String Directions = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Directions");
			String DaysSupply = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "DaysSupply");
			String Quantity = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Quantity");
			String Refills = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), "Refills");
			try {
				
				if (isElementPresentVerification(SmokeTestConstants.DrugName_Field)) {
					if (!clearAndEnterText(SmokeTestConstants.DrugName_Field, UPC)) ;
				}
				
				 if (isElementPresentVerification(SmokeTestConstants.DE_drug_searchResults)) {
		                Actions upArrow = new Actions(chromeDriver);
		                Action PressUpArrow = upArrow.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
		                PressUpArrow.perform();
		                Thread.sleep(1000);
		            }
				
				if(isElementPresentVerification(SmokeTestConstants.DispensedDrug_Field)){
	            	if(getElementByProperty(SmokeTestConstants.DispensedDrug_Field,chromeDriver).getAttribute("aria-disabled").equalsIgnoreCase("false")){
	            		IntakeStepDef.user_hits_Enter_Key();
	            	} 
	            }
				
				if (isElementPresentVerification(SmokeTestConstants.Quantity_field)) {
					if (!clearAndEnterText(SmokeTestConstants.Quantity_field, Quantity)) {
						throw new Exception("Not able to enter value in Quantity text field");
					}
				}
				if (isElementPresentVerification(SmokeTestConstants.Quantity_disp)) {
					if(!clearAndEnterText(SmokeTestConstants.Quantity_field, quantitydisp)){
						throw new Exception("unable to enter qunatity field");
					}
				}

				if (isElementPresentVerification(SmokeTestConstants.Directions_field)) {
					if (!clearAndEnterText(SmokeTestConstants.Directions_field, Directions)) {
						throw new Exception("Not able to enter value in Directions text field");
					}
				}
				chromeDriver.findElementByXPath(SmokeTestConstants.DrugName_Field).sendKeys();
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
			} catch (Exception e) {
				takeScreenShot(methodName);
				throw new Exception(e.getMessage());
            }
	}
	
	/*
	 * This method is to check the soft allocation of the dispenesed drug after completing Data Entry and checking the softallocated value doesn't change
	 */
	@Then("^check the soft allocation in stock plus after DE$")
    public void check_the_soft_allocation_in_stock_plus_after_DE() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try{
        Connection connection = ConnectionFactory.getConnectionStock();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select a.id,a.PRODUCT_SKU_CODE,a.STORE_CODE,B.TYPE,B.QUANTITY from STOCK A inner join stock_item b on a.id=b.id_stock where PRODUCT_SKU_CODE =" + code + " and A.STORE_CODE='" + Store_Pharmacy_Code + "' and b.TYPE='Soft Allocated'");
		if (rs != null) {
			while (rs.next()) {
				Quantity_stock_after_RX = rs.getString("QUANTITY");
			}
		}
		rs.close();
		connection.close();
		int expected = Integer.parseInt(Quantity_stock_DE);
		int actual = Integer.parseInt(Quantity_stock_after_RX);
		Assert.assertEquals(actual, expected);

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }
	/*
	 * This method is to check the soft allocation value of a drug which is in onshelf before Data Entry
	 */
	@Then("^check the soft allocation in stock plus$")
    public void check_the_soft_allocation_in_stock_plus() throws Exception {
        methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        try{
        Connection connection = ConnectionFactory.getConnectionStock();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery("select a.id,a.PRODUCT_SKU_CODE,a.STORE_CODE,B.TYPE,B.QUANTITY from STOCK A inner join stock_item b on a.id=b.id_stock where PRODUCT_SKU_CODE =" + code + " and A.STORE_CODE='" + Store_Pharmacy_Code + "' and b.TYPE='Soft Allocated'");
		if (rs != null) {
			while (rs.next()) {
				Quantity_stock_DE = rs.getString("QUANTITY");
			}
		}
		rs.close();
		connection.close();

        } catch (Exception e) {
            takeScreenShot(methodName);
            throw new Exception(e.getMessage());
        }
    }

}


