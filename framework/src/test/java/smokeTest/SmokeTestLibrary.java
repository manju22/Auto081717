package smokeTest;

import cucumber.api.DataTable;
import framework.FrameworkLibrary;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SmokeTestLibrary extends FrameworkLibrary {

    public static WebDriverWait wait;

    public SmokeTestLibrary() throws ConfigurationException, IOException {
        super();
    }

    /**
     *  This method is to enter text into a text field
     *
     * @param arg1 Datatable comes from feature file denoting the test data sheet
     * @param colval column value comes from test data sheet excel column name
     * @param propval text to be entered in to the text box
     * @param driver   Webdriver
     * @throws Exception IO Exception
     * usage sample - SmokeTestLibrary.enter_Text(arg1, "LastName", SmokeTestConstants.Patient_LastName, chromeDriver)
     */

    public static void enter_Text(DataTable arg1, String colval, String propval, WebDriver driver) throws Exception {
        try {
            Map<String, List<String>> dataMap = null;
            dataMap = FrameworkLibrary.getHorizontalData(arg1);
            val = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), colval);
            System.out.println(val);
            if (!clearAndEnterText(propval, val)) {
                throw new Exception("User Not able to Enter" + val + "in TextField");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * This method is used to get the data from excel sheet and store it into a string.
     * It picks the data from excel sheet based on the file name, sheet name and Row Id given in the DataTable
     *
     * @param arg1 Datatable comes from feature file denoting the test data sheet
     * @param colval column value comes from test data sheet excel column name
     * @return value returns the string value got from excel
     * @throws IOException
     * usage sample  String expectedFirstName = SmokeTestLibrary.getData(arg1, "FirstName").toLowerCase()
     */

    public static String getData(DataTable arg1, String colval) throws IOException {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        String value = getXLSTestData(dataMap.get("InputFileName").get(0), dataMap.get("SheetName").get(0), dataMap.get("RowId").get(0), colval);
        System.out.println(value);
        return value;
    }

    /**
     * This method is to verify if the text on the below field starts with zero
     *
     * @return returns boolean true or false
     * usage sample condition = isDRZero();
     */

    public static boolean isDRZero() {
        WebElement elementByProperty = FrameworkLibrary.getElementByProperty(SmokeTestConstants.DataReview_RightMenuButton, chromeDriver);
        String text = elementByProperty.getText();
        return !text.startsWith("0");
    }

    /**
     *This method is to wait for a condition boolean
     *
     * @param condition boolean condition
     * @return returns false
     */

    public static boolean wait(boolean condition) {
        try {
            if (condition) {
                return true;
            } else {
                Thread.sleep(3000);
                condition = isDRZero();
                wait(condition);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }



    /**
     *This method is used to wait for an element before clicking
     *
     * @param xpath object identifier
     * @return web element
     * usage sample - waitToClick(dataReviewConstants.two_accept);
     */
    public static WebElement waitToClick(String xpath) {
        wait = new WebDriverWait(chromeDriver, 60);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        return element;
    }

    /**
     *This mehtod is to quit RxMs app
     *
     * @return boolean true or false
     * usage sample SmokeTestLibrary.quitRxmsApp()
     */
    public static boolean quitRxmsApp() {
        try {
            chromeDriver.quit();
            isLogin = false;
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * This method is to quit Fill app
     *
     * @return boolean true or false
     * usage sample - SmokeTestLibrary.quitFillApp()
     */

    public static boolean quitFillApp() {
        try {
            aDriver.quit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This method is to quit POS App
     *
     * @return boolean true or false
     * usage sample - SmokeTestLibrary.quitPOSApp()
     */

    public static boolean quitPOSApp() {
        try {
            driver1.quit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This method to verify if Log out alert message is displayed
     * @return boolean true or false
     * usage sample - Assert.assertTrue(SmokeTestLibrary.isLogoutAlertPresent());
     */

    public static boolean isLogoutAlertPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(chromeDriver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SmokeTestConstants.this_device_button_logout_cssSelector)));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * This method is to perform hot Key action
     * @param Key1 Key name
     * @param alphabet Alphabet for whic key action has to be performed
     * @param driver Webdriver
     * usage sample - SmokeTestLibrary.hotkeyAction(Keys.ALT, "r", chromeDriver);
     */

    public static void hotkeyAction(Keys Key1, String alphabet, WebDriver driver) {
        Actions ac = new Actions(driver);
        Action a = ac.keyDown(Key1).sendKeys(alphabet).keyUp(Key1).build();
        a.perform();
    }

}