package framework;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataEntry.DataEntryStepDef;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;


public class FrameworkStep {
    public static Configuration config = null;
    public static String tagName = "";
    public static File file = new File("OutputData/report.txt");
    static HSSFWorkbook workBook = null;
    static FileInputStream fis = null;
    static HSSFSheet workSheet = null;
    static HSSFRow row = null;
    private static Log log = LogFactory.getLog(DataEntryStepDef.class);
    // New Changes
    private Scenario scenario;
    private String status;

    @Before
    public void launchBrowser(Scenario scenario) throws ConfigurationException, FileNotFoundException, IOException {
        new FrameworkLibrary();
        this.scenario = scenario;
       
    }

    @Given("^Customer launch the Browser$")
    public void Customer_launch_the_Browser() throws IOException, InterruptedException, ConfigurationException {
        try {
            FrameworkLibrary.initiateBrowser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("^Pharmacy user launch the App$")
    public void pharmacy_user_launch_the_App() throws IOException, InterruptedException, ConfigurationException {
        try {
            FrameworkLibrary.initiateBrowser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("^Customer Close the Browser$")
    public void Customer_Close_the_Browser() throws IOException, InterruptedException {
        try {
            FrameworkLibrary.closeBrowser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^Customer navigate back$")
    public void Customer_navigate_back() throws IOException, InterruptedException {
        try {
            FrameworkLibrary.browserNavigation_Back();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // stepDefinition(cucumber.runtime.StepDefinition stepDefinition)


    //Framework common steps.
    @Given("^User launches the rxmsappp$")
    public void user_launches_the_rxmsapp() throws Throwable {
        FrameworkLibrary.initiateBrowser();
    }
    
   @After
    public void afterScenario() throws Exception {
    	TestCaseMgmt Tcm = new TestCaseMgmt();
    	status = scenario.getStatus();
    	 Collection<String> tags = scenario.getSourceTagNames();
         for (String tag : tags) {
             if(tag.toLowerCase().startsWith("@rxqe")){
             	tagName=tag.replace("@","").trim();
             	System.out.println("tagName : "+tagName);
                System.out.println("status : " + status);
             	Tcm.updateExecutioStatus(tagName, status);
             }
         }
    }
   
    //@After
    public void closeBrowser() throws IOException {
        log.info("Geneating Text report");
/*
        if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fop = new FileOutputStream(file, true);
		String output = tagName + "," + scenario.getName() + "," + scenario.getStatus();
		if (output != null)
			fop.write(output.getBytes());
		fop.write(System.getProperty("line.separator").getBytes());
		fop.flush();
		fop.close();*/
    }
}
