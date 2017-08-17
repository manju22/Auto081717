package accessManagment;


import cucumber.api.DataTable;
import framework.FrameworkLibrary;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//maintainLocationLibrary


/**
 * @author rperiate
 *
 */
/**
 * @author rperiate
 *
 */
public class AccessManagementLibrary extends FrameworkLibrary {

    public static String val = null;

    public AccessManagementLibrary() throws ConfigurationException, IOException {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * The arg1 argument passes spread sheet nam along with row details
     * <p>
     * This method doesn't returns anything, Passes username and password
     * in login screen.  
     * Usage - used in AccessManagementStepDef
     * 
     */

    /**
     * @param arg1
     * @throws Throwable
     */
    public static void enter_username_and_password_drugSearch(DataTable arg1) throws Throwable {

        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        String userNameVal = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                dataMap.get("RowId").get(0), "UserName");
        String passwordVal = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0),
                dataMap.get("RowId").get(0), "Password");


        FrameworkLibrary.clearAndEnterText(AccessManagementConstants.user_name, userNameVal);
        FrameworkLibrary.clearAndEnterText(AccessManagementConstants.password, passwordVal);

        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(1000);

    }

    /**
     * locator parameter refers the element for which wait is applicable
     * timeout parameter refers the wait time in milliseconds
     * <p>
     * The method doesn't return any value
     * The function is used to set explicit wait time for the selected element
     * Usage - Not used in any modules. Replaced with Thread.sleep
     * @param locator
     * @param timeout
     */
    public static void explicitWait(String locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(chromeDriver, timeout);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(chromeDriver.findElement(By.xpath(locator))));

    }

    // roleLibrary
    
    /**
     *  
     * Method returns the team member list
     * <p>
     * Method is used to get the list of team members
     * @return
     * @throws InterruptedException
     */
    public static List<WebElement> getTeamMemberList() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> list = FrameworkLibrary.chromeDriver.findElements(By.xpath("//strong"));
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list-1 :" + list.get(i).getText());
        }
        return list;
    }

    
    /**
     * Method returns the team member phone list
     * <p>
     * Method is used to get the list of team members
     * Usage - AccessManagementStepDef
     * @return
     * @throws InterruptedException
     */
    public static List<WebElement> getTeamMemberphoneList() throws InterruptedException {
        List<WebElement> List1 = FrameworkLibrary.chromeDriver.findElements(By.xpath("//span"));
        for (int i = 0; i < List1.size(); i++) {
            System.out.println("Phone number: " + List1.get(i).getText());
        }
        return List1;

    }

    /**
     * Method to get the elements by using the locator
     * locator parameter refers to the element id
     * Method returns elements present for the specified locator id 
     * @param locator
     * @return
     */
    public static List<WebElement> getElements(String locator) {

        WebDriverWait wait = new WebDriverWait(FrameworkLibrary.chromeDriver, 40);


        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            return FrameworkLibrary.chromeDriver.findElements(By.xpath(locator));
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * Method doesn't return any values
     * <p>
     * Method is used to select the specified value
     * from dropdown field
     * value param is the dropdown field value
     * @param value
     * @throws InterruptedException
     */
    public static void selectValueFromDropdown(String value) throws InterruptedException {
        new WebDriverWait(FrameworkLibrary.chromeDriver, 2000).until(ExpectedConditions.elementToBeClickable(By.xpath(AccessManagementConstants.RXMS_TEAM_MEMBER_PROFILE_STATUS_DROP_DOWN)));
        AccessManagementLibrary.getElement(AccessManagementConstants.RXMS_TEAM_MEMBER_PROFILE_STATUS_DROP_DOWN).click();
        new WebDriverWait(FrameworkLibrary.chromeDriver, 2000).until(ExpectedConditions.elementToBeClickable(By.xpath(AccessManagementConstants.RXMS_TEAM_MEMBER_PROFILE_STATUS_DROP_DOWN_MENU)));


        List<WebElement> dropDownOptions = getElements(AccessManagementConstants.RXMS_TEAM_MEMBER_PROFILE_STATUS_DROP_DOWN_MENU);

        for (int i = 0; i < dropDownOptions.size(); i++) {
            System.out.println("Options : " + dropDownOptions.get(i).getText() + " value : " + value);
            if (dropDownOptions.get(i).getText().equals(value)) {
                System.out.println("inside if condition");
                dropDownOptions.get(i).click();

            }
        }

    }

    /**
     * Method doesn't return any value
     * <p>
     * Method to get patient name from patient order status page search results
     * No parameter for the method
     * @throws InterruptedException
     */
    public static void getPatientOrderStatusSearchResults() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> list = FrameworkLibrary.chromeDriver.findElements(By.xpath(AccessManagementConstants.RXMS_PATIENT_ORDER_STATUS_SEARCH_RESULTS));

        for (WebElement element : list) {

            String patientNameFromApplication = element.findElement(By.xpath("//a//mark")).getText();
            System.out.println("Patient name :" + patientNameFromApplication);
        }


    }


    /**
     * Method returns true or false based on the element present verification
     * <p>
     * Method is used to check if a specific element is present or not
     * element parameter refers to the locator to validate
     * @param element
     * @return
     */
    public static boolean isElementPresent(String element) {
        WebDriverWait wait = new WebDriverWait(FrameworkLibrary.chromeDriver, 30);


        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * Method doesn't return any value
     * <p>
     * Method is used to check if a element is present and click the element
     * element parameter refers the locator id on a page
     * @param element
     */
    public static void isElementPresentClick(String element) {
        isElementPresent(element);
        if (isElementPresent(element) == true) {
            FrameworkLibrary.isElementPresentVerifyClick(element);
        }
    }

    /**
     * Method to get the element by using the locator
     * locator parameter refers to the element id
     * Method returns elements present for the specified locator id 
     * @param locator
     * @return
     */
    public static WebElement getElement(String locator) {

        WebDriverWait wait = new WebDriverWait(FrameworkLibrary.chromeDriver, 40);


        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            return FrameworkLibrary.chromeDriver.findElement(By.xpath(locator));
        } catch (Exception e) {
            return null;
        }

    }

    // Plan library
    
    /**
     * Method doesn't return any value
     * <p>
     * Method is used to enter value from the data table on the specified text field
     * arg1 is datatabe with sheetname column name and value to be entered on the field
     * Throws exception when user is unable to enter value in the text field 
     * @param arg1
     * @param colval
     * @param propval
     * @param driver
     * @throws Exception
     */
    public static void enter_Text(DataTable arg1, String colval, String propval, WebDriver driver) throws Exception {
        try {
            Map<String, List<String>> dataMap = null;
            dataMap = FrameworkLibrary.getHorizontalData(arg1);
            val = FrameworkLibrary.getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), colval);
            System.out.println(val);
            if (!clearAndEnterText(propval, val)) {
                throw new Exception("User Not able to Enter" + val + "in TextField");
            }


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
