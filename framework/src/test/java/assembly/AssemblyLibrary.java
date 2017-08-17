package assembly;

import framework.FrameworkLibrary;

import org.apache.commons.configuration.ConfigurationException;

import cucumber.api.DataTable;
import smokeTest.SmokeTestConstants;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AssemblyLibrary extends FrameworkLibrary {

    public AssemblyLibrary() throws ConfigurationException, IOException {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This method is used to enter UserName, Password and click login on android device
     * @throws Exception
     */
    public static void login_Assembly_Android() throws Exception {
        FrameworkLibrary.android_switchWebView("WEBVIEW");
        isElementPresentVerificationAndroid(AssemblyConstants.USER_NAME);
        FrameworkLibrary.clearAndEnterTextForAndroid(AssemblyConstants.USER_NAME, username);
        isElementPresentVerificationAndroid(AssemblyConstants.PASSWORD);
        FrameworkLibrary.clearAndEnterTextForAndroid(AssemblyConstants.PASSWORD, password);
        proxy.newHar();
        isElementPresentVerificationAndroid(AssemblyConstants.LOGIN_BUTTON);
        FrameworkLibrary.isElementVerifyclickAndroid(AssemblyConstants.LOGIN_BUTTON);
        waitForVisibilityAndroid(AssemblyConstants.Strenth_Drug_Fromat);
        writeHarFile(workingFolder, "Fill-login", row.getRowNum(), 16);


    }

}
