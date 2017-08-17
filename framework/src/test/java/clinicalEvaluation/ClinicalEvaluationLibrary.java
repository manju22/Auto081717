package clinicalEvaluation;

import cucumber.api.DataTable;
import framework.FrameworkLibrary;
import junit.framework.AssertionFailedError;
import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ClinicalEvaluationLibrary extends FrameworkLibrary {
    public static String val = null;
    static WebDriverWait browserWithElementWait = null;

    public ClinicalEvaluationLibrary() throws ConfigurationException, IOException {
        super();
    }


    public static String getData(DataTable arg1, String colval, int rownum) throws IOException {
        Map<String, List<String>> dataMap = null;
        dataMap = FrameworkLibrary.getHorizontalData(arg1);
        String value = getXLSTestData(dataMap.get("InputFileName").get(rownum), dataMap.get("SheetName").get(rownum), dataMap.get("RowId").get(rownum), colval);
        System.out.println(value);
        return value;
    }

    public static void TestTabOrderDUR() {

        String[] orderedElementIds = new String[]{"select-all", "override-button", "sendtoicp-button", "cancel-button"};
        System.out.println("order element id is" + orderedElementIds);
        for (String item : orderedElementIds) {

            String elementId = item;
            // Get the current active element, element with focus.
            element = chromeDriver.switchTo().activeElement();
            String Ids = element.getAttribute("id");
            if (Ids.isEmpty()) {
                throw new NullPointerException("Element does not have expected ID: " + elementId);
            }
            // If the active element doesn't match the current ID in our
            // orderedElementIds array, fail the test.
            if (!elementId.equalsIgnoreCase(Ids)) {
                throw new AssertionFailedError("Element: " + elementId + " does not have focus.");
            }

            // Tab to the next element.
            element.sendKeys(Keys.TAB);
        }
    }

    public static boolean isEmptyCommentField() {
        boolean commentsTextbox = false;
        WebElement inputBox = chromeDriver.findElement(By.name("comments"));
        String textInsideInputBox = inputBox.getAttribute("value");

        // Check whether input field is blank
        if (textInsideInputBox.isEmpty()) {
            commentsTextbox = true;
            System.out.println("Input field is empty");
        }
        return commentsTextbox;
    }

}


