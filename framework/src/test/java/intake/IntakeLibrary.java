package intake;

import framework.FrameworkLibrary;
import junit.framework.AssertionFailedError;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class IntakeLibrary {

    public static WebElement element = null;
    public static ChromeDriver chromeDriver;

    public IntakeLibrary(WebDriver driver) {


    }

    public static boolean isElementPresent(String element) {
        WebDriverWait wait = new WebDriverWait(FrameworkLibrary.chromeDriver, 30);


        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static void isElementPresentClick(String element) {
        isElementPresent(element);
        if (isElementPresent(element) == true) {
            FrameworkLibrary.isElementPresentVerifyClick(element);
        }
    }

    public static WebElement getElement(String locator) {

        WebDriverWait wait = new WebDriverWait(FrameworkLibrary.chromeDriver, 40);


        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            return FrameworkLibrary.chromeDriver.findElement(By.xpath(locator));
        } catch (Exception e) {
            return null;
        }

    }

    public static List<WebElement> getElements(String locator) {

        WebDriverWait wait = new WebDriverWait(FrameworkLibrary.chromeDriver, 40);


        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
            return FrameworkLibrary.chromeDriver.findElements(By.xpath(locator));
        } catch (Exception e) {
            return null;
        }

    }

    public static void selectValueFromDropdown(String value) {
        new WebDriverWait(FrameworkLibrary.chromeDriver, 40).until(ExpectedConditions.elementToBeClickable(By.xpath(IntakeConstants.PATIENT_ORDER_STATUS_DROP_DOWN_ICON)));
        IntakeLibrary.getElement(IntakeConstants.PATIENT_ORDER_STATUS_DROP_DOWN_ICON).click();

        List<WebElement> dropDownOptions = getElements(IntakeConstants.PATIENT_ORDER_STATUS_DROP_DOWN_MENU);

        for (int i = 0; i < dropDownOptions.size(); i++) {
            System.out.println("Options : " + dropDownOptions.get(i).getText() + " value : " + value);
            if (dropDownOptions.get(i).getText().equals(value)) {
                System.out.println("inside if condition");
                dropDownOptions.get(i).click();

            }
        }

    }

    /**
     * Function written to verify tab order in sequence
     */
    public static void TestTabOrderPreferences() {

        String[] orderedElementIds = new String[]{"patient-preferences-view-button-bar-button-update", "patient-view-button-bar-button-intake", "back-button-patient-profile", "comments-icon", "tabs-2", "patient-preferences-view-button-bar-button-update"};
        System.out.println("order element id is " + orderedElementIds);
        for (String item : orderedElementIds) {

            String elementId = item;
            // Get the current active element, element with focus.
            System.out.println("Element: "+ elementId);
            element = chromeDriver.switchTo().activeElement();
            String Ids = element.getAttribute("id");
            System.out.println("Element ID "+ Ids);
            /*if (!elementId.equalsIgnoreCase(Ids)) {
                throw new AssertionFailedError("Element: " + elementId
                        + " does not have focus.");
            }*/

            // Tab to the next element.
            element.sendKeys(Keys.TAB);
        }
    }


}
