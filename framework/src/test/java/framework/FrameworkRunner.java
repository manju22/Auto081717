package framework;

import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeClass;

import java.io.File;

@CucumberOptions(glue = {"smokeTest","dataEntry","intake","clinicalEvaluation","accessManagment","assembly","dataReview","productVerification","hangOn","registerPatient"},
        features = "src/test/java/",
        plugin = {"html:target/cucumber-htmlreport", "json:target/cucumber-report.json", "com.cucumber.listener.ExtentCucumberFormatter"},
        tags = {"@RxMSSmokeTestSuite"}, monochrome = true)
public class FrameworkRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void setup() {
        ExtentCucumberFormatter.initiateExtentCucumberFormatter();
        ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));
    }
}


