@HangOn
Feature: HangOn defects

  @RXQE-5165 @Regression @HangOn_Regression
  Scenario: comment section
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And User clicks view commet yellow button

  @RXQE-5115 @Regression @HangOn_Regression
  Scenario: Task completion in Data Entry
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User hits ctrl plus l hot key
    Then Sytem should display data entry page
    When User click DE screen Image back button
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks finish button on Data Entry page
    When User hits ctrl plus l hot key
    When User validate focus of DE screen Image front tab

  @RXQE-4586 @HangOn4
  Scenario: Tab order is incorrect on intake screen
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When I click TAB key from "Waiting" field
    Then I should be on "Pick Up Later" field
    When I click TAB key from "Pick Up Later" field
    Then I should be on "scan" field
    When I click TAB key from "scan" field
    Then I should be on "fax" field
    When I click TAB key from "fax" field
    Then I should be on "phone" field
    When I click TAB key from "phone" field
    Then I should be on "Finish" field
    When I click TAB key from "Finish" field
    Then I should be on "Cancel" field
    When I click TAB key from "Cancel" field
    Then I should be on "X button" field
    When I click on Phone Number field and click TAB key
    Then I should be on "first day button" field
    When I click TAB key from "first day button" field
    Then I should be on "second day button" field
    When I click TAB key from "second day button" field
    Then I should be on "third day button" field
    When I click TAB key from "third day button" field
    Then I should be on "fourth day button" field
    When I click TAB key from "fourth day button" field
    Then I should be on "fifth day button" field
    When I click TAB key from "fifth day button" field
    Then I should be on "sixth day button" field
    When I click TAB key from "sixth day button" field
    Then I should be on "seventh day button" field
    When I click TAB key from "seventh day button" field
    Then I should be on "time" field
    When I click TAB key from "time field" field
    Then I should be on "am-pm" field

  @RXQE-5146 
  Scenario: Multiple Locations Showing for Prescriber on Prescriber Profile
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When user navigates to prescriber search
    Then prescriber search page should be displayed
    When user enters details of the prescriber
      | InputFileName | SheetName  | RowId   |
      | TestData         | prescriber | Row_one |
    #And User selects null value in the state dropdown
    And choose state from the drop down and click search
      | State |
      | IL    |
    Then prescriber details should be displayed
    And User clicks view button using ALT plus V hot key
    Then User should see the prescriber information

  @RXQE-4579 @HangOn4 @Regression @HangOn_Regression
  Scenario: Incorrect Error message in POS when searching for a patient
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User navigates to patient order status
    Then I should be on patient order status page
    And I should see patient selected in drop down
    When User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And User clicks search button on patient order status
    Then I should see valid search results
    When User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId       |
      | TestData  | patient   | Row_Hangon_Invalid |
    And I clear the LastName TexField  
    And User clicks search button on patient order status
    Then I should see "No Results found" message
    When User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId       |
      | TestData  | patient   | Row_Hangon_Invalid |
    And I clear the PhoneNo TexField  
    And User clicks search button on patient order status
    Then I should see "No Results found" message

  @RXQE-5148
  Scenario: Validate - a Non-LDD drug not sent to IC+, when Add Rx done with a LDD drug
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId    |
      | TestData         | patient   | Row_five |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId    |
      | TestData         | patient   | Row_five |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId    |
      | TestData         | patient   | Row_five |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
      | TestData         | patient   | Row_five |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId          |
      | TestData  | product   | Row_twentyfive |
    And clicks open payment button
    And selects payment type
    And User clicks Add Rx button
    And clicks open product button
    And enters product information for rems drug
      | InputFileName | SheetName | RowId         |
      | TestData  | product   | Row_twentysix |
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked after adding Rx
      | InputFileName | SheetName | RowId          |
      | TestData         | patient   | Row_five       |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page

  @RXQE-5149 @Regression @HangOn_Regression
  Scenario: Validate from Dashboard , clicking on DE multiple times opens DE window with 'ALL changes will be lost' message
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    #Then Data Entry task should be created
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And clicks DE taskboard
    When System must show a pop-up
    Then User clicks Yes on the pop-up
   # And DE screen should be closed

  @RXQE-5152 @Regression @HangOn_Regression
  Scenario: Validate Sig Codes for Upper and Lower case translation
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_RXQE_5152 |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    #Then Data Entry task should be created
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_RXQE_5152 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_RXQE_5152 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_RXQE_5152 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information to validate sig codes
      | InputFileName | SheetName | RowId    |
      | TestData  | product   | Row_RXQE_5152 |
    And enters following sigcode in directions
			| InputFileName | SheetName | RowId    |
      | TestData  | product   | Row_sigcode |
      

  @RXQE-5124 @Regression @HangOn_Regression
  Scenario: Verify if the hot key for Intake is working after intake retry
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Gaurav |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When user click on cancel a popup screen will display click yes
    Then patient profile should be displayed
    When user hits alt plus x hot key
    Then System should navigate to Intake Method Screen
	
	@RXQE-5140 @Regression @HangOn_Regression
  Scenario: selecting the drug using Quick Code in DE
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Raghu |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Raghu |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Raghu |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Raghu |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    Then I enter product info for quick code
      | InputFileName      | SheetName | RowId     |
      | TestData | product   | Row_Quickcode |
    And user able to see dispended drug in field

  @RXQE-5133 @Regression @HangOn_Regression
Scenario: Validate that RXMS accepts refills number as P5W
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_DR_two |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_DR_two |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_DR_two |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_DR_two |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName      | SheetName | RowId    |
      | TestData | product   | Row_Nine |
    And hit on tab
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_DR_two |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    #And clicks third accept to validate product data and validate the refills
    #| InputFileName      | SheetName | RowId    |
      #| TestData | product   | Row_Nine |
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |

  @RXQE-4442 @RXQE-5116 @HangOn4 @Regression @HangOn_Regression
  Scenario: Hot Key for Prescriber Select,View and Cancel is not working if we re-open Prescriber search
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    Then User hits ALT plus R hot key
    When User hits alt plus e hotkey
    Then Sytem should display data entry page
    When User hits ALT plus P hot key
    And User selects null value in the state dropdown
    Then User hits ALT plus R hot key
    When User hits alt plus e hotkey
    Then Sytem should display data entry page
    When User hits ALT plus P hot key
    And User selects null value in the state dropdown
    Then User hits ALT plus R hot key
    Then Sytem should display data entry page
    When User hits Alt plus W hotkey
    Then prescriber details page should be displayed successfully
    #And User clicks back button on prescriber details page from DE
    When User hits alt plus c hotkey
    Then Sytem should display data entry page

  @RXQE-5179
  Scenario: Validate Plan Holder name is getting displayed in 3rd party Plans window
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User navigates to Patient search page
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId      |
      | TestData         | patient   | Row_twelve |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then user should see patient profile page
    When User click on Third party plans using alt plus three hot key
    Then User will be on Third party plans
    And User checks relation to plan holder section and plan holder name field
      | 03-Child      |
      | 02-Spouse     |
      | 01-CardHolder |
      | 04-Other      |

  @RXQE-5354 @Regression @HangOn_Regression
  Scenario: Perform unselect Accept 1, Accept 2 and Accept 3 operations in DR screen
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_new_pat |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_new_pat |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_new_pat |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_new_pat |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_new_pat |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User checks the first accept button is unselected
    And User clicks first accept to validate patient data
    And User checks the second accept button is unselected
    And clicks second accept to validate prescriber data
    And User checks the third accept button is unselected
    And clicks third accept to validate product data
    When User clicks on first accept to unselect that button
    And User checks the first accept button is unselected
    When User clicks on second accept to unselect that button
    And User checks the second accept button is unselected
    When User clicks on third accept to unselect that button
    And User checks the third accept button is unselected
    And User closes the application

@RXQE-5122
  Scenario: Patient Order Status Search for Patient with Multiple Prescription
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
		  When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Raghu |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
     When User hits ctrl plus h hot key
    Then System should display RxMS home page
      When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Raghu |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
     When User hits ctrl plus h hot key
    Then System should display RxMS home page
      When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Raghu |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
     When User hits ctrl plus h hot key
    Then System should display RxMS home page
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Raghu |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Raghu |
    And User clicks search button on patient order status
    Then User checks atleast one prescription in the POS is selected for the patient
    And User presses downarrow key to navigate through the patient prescriptions
		And User presses uparrow key to navigate through the patient prescriptions
		
@RXQE-5156 @RXQE-4257
  Scenario: Medication history
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_five |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_five |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_five |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_five |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_five |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_five |
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_five |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks Med history tab using Alt plus m hot key 
    Then User clicks the In progress link for current prescription in med history

  @RXQE-2947
  Scenario: Multiple Locations Showing for Prescriber on Prescriber Profile
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    #Then Data Entry task should be created
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks Med history tab
    Then System should display rx number of current prescription
    Then System should display rxnumber hyperlink of current prescription

  @RXQE-5157 @Regression @HangOn_Regression
  Scenario: Validate Rx Number hyper link from Rx Details in Clinical Evaluation Page
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And User click on Rx number hyper link in CE
    Then Rx Details window should open succesfuly Prescribed and Dispensed drug should be displayed successfully

  #@RXQE-5133
  Scenario: Validate that RXMS accepts refills number as P5W
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId      |
      | TestData  | patient   | Row_Raghu6 |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId      |
      | TestData  | patient   | Row_Raghu6 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData  | patient   | Row_Raghu6 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData  | patient   | Row_Raghu6 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And clicks open product button
    Then I enter product info including Substitute N and Y
      | InputFileName      | SheetName | RowId    |
      | TestData | product   | Row_Nine |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData  | patient   | Row_Raghu6 |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data and validate the refills
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should validate Rx number for current prescriptions
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |

  @RXQE-5174 @Regression @HangOn_Regression
  Scenario: Time is Updated in Clinical Evaluation from Patient Profile screen after overriding interaction for major
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId      |
      | TestData  | patient   | Row_Gaurav1|
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId      |
      | TestData  | patient   | Row_Gaurav1 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData  | patient   | Row_Gaurav1 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData  | patient   | Row_Gaurav1 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName      | SheetName | RowId   |
      | TestData | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData  | patient   | Row_Gaurav1 |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId      |
      | TestData  | patient   | Row_Gaurav1 |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData  | patient   | Row_Gaurav1 |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then user validates the Major iteractions feilds
    And user validates the Moderate Iteractions Feilds
    And user validates the Therapy_Iteractions Feilds
    And clicks select all for therapy review
    And user clicks on Override in CE screen
    When User clicks on patient tab in left side menu
    And clicks on OK button on current task cancel pop up
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId      |
      | TestData  | patient   | Row_Gaurav1 |
    And clicks search button on patient search page
    Then System should display patient search results

   @RXQE-5175 @HangOn4
  Scenario: View Size and Manufacturer Check boxes in tab order
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Marie |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Marie |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Marie |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Marie |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
     And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber  
    Then User hits ALT plus R hot key
    When User hits alt plus e hotkey
    Then Sytem should display data entry page
    And clicks open product button
    And user select product and perform tab order in product section
    #When I click TAB key from "Original Date" field
    #Then I should be on "DAW" field
    #When I click TAB key from "DAW" field
    #Then I should be on "Substitute" field
    #When I click TAB key from "Substitute" field
    #Then I should be on "Prescribed Drug" field
    #When I click TAB key from "Prescribed Drug" field
    #Then I should be on "Drug Exp Date" field


  @RXQE-5003 @HangOn4 @Regression @HangOn_Regression
  Scenario: DE - Dispensed Product not auto-populating with Generic when selecting search results returned via Quick Code
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Marie |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Marie |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Marie |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Marie |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    And clicks open product button
    And enters product with DAW N and substitute as Y and Quick code for product
      | InputFileName | SheetName | RowId         |
      | TestData  | product   | Row_Quickcode |
    And I should see expected drug as dispensed product

  @RXQE-5178
  Scenario: SIT | Intake | View Fill History in Patient Profile
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    Then System should navigate to Medication History Screen
    When User click on Expand next to Inprogress
    And User click on View link
    Then Fill history tab will be displayed
    And User see All the data required should be entered

  @RXQE-5128
  Scenario: SIT | Cursor need to be placed in last name of the Prescriber in DE  after clicking on clear fields
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Marie |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    #Then Data Entry task should be created
    #When User clicks DE button in the taskboard
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Marie |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Marie |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_Marie |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    #And clicks select to select a prescriber
    When I click clear field button
    Then Prescriber info should be cleared

  @RXQE-5163 @Regression @HangOn_Regression
  Scenario: SIT |user should navigate to new data entry screen when click on add RX
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_three|
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    #Then Data Entry task should be created
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_three|
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_three|
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId     |
      | TestData  | patient   | Row_three|
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Row_one |
    And clicks open payment button
    And selects payment type
    #And clicks Finish button to complete Data Entry
    When User clicks Add Rx button
    Then Sytem should display data entry page
    Then system should show new Data Entry page

  @RXQE-5145 @Regression @HangOn_Regression
  Scenario: Validate Hit Enter key when Tab focus is on Phone No
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User click on Search in Prescriber on DR page
    And User enters prescriber first name and Last name on DR page
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    #And User selects null value in the state dropdown on DR
      And User enters prescriber Phone no on DR page
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    And User hit Enter
    Then should not see error message
    And User enters prescriber Phone no on DR page
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    Then Focus is on PhoneNo Field
    #And User selects null value in the state dropdown on DR
    When clicks on select prescriber Button
    
	
	@RXQE-5161
  Scenario: Read only user has ability to view Own Profile without Phone Number
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    When I click on pharmacist profile button
    Then I should be able to see team members option and click
    Then I should navigate to list of team members profile
    Then I click on team member profile and able to see Phone Number
    And I Only see the team member icon and name without the phone number


  @RXQE-5127 @HangOn4 @Regression @HangOn_Regression
 Scenario: SIT | Clinical Evaluation | View Med History and Clinical History.
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_One |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_One |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_One |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_One |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
      And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber  
    And enters product information
      | InputFileName | SheetName | RowId    |
      | TestData  | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_One |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_One |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_One |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then User should see Clinical Check page
    And User should see Med History Tab
    When User click on Med History Tab
    Then User checks the content sorted by Last Filled Date in order

  @RXQE-3369
  Scenario: Verify that the system displays View Fill History window using View hyperlink
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    And System should display patient order status page
    And clicks search button on patient order status page
    And The status for current prescription should be "in progress"
      | InputFileName | SheetName | RowId    |
      | TestData  | patient   | Row_five |
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
     | InputFileName | SheetName | RowId    |
      | TestData  | patient   | Row_five |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks Med history tab
    When User clicks down arrow button and validate fill history for current prescription
    
  @RXQE-5114
  Scenario: Validate Patient Order Status page displays correct status when "Pending" link in Med History is clicked
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks Med history tab
    And clicks pending link for current prescription on med history page
    Then System should display patient order status page
    And The status for current prescription should be "pending"
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |

  @RXQE-5142
  Scenario: Verify if the Store number is displayed in the RX history view
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    #Then Data Entry task should be created
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    #Then Number of DR tasks should be decreased
    #Then A clinical evaluation task should get created
    #When User clicks CE in the task board
    And System should display patient order status page
    And User clicks search button on patient order status
    #Then System should generate Rx number for current prescription
    #  | InputFileName | SheetName | RowId   |
    #  | TestData      | patient   | Row_one |
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks Med history tab
    Then system should display rx history details with store numbers

@RXQE-5579 @Regression @HangOn_Regression @HangOn2
Scenario: DE | Qty-should validate on dispensed qty package size
  Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    Then The Original date should be populated with the current date by default
    And The DAW field should be defaulted to "N" and the Substitute field should be defaulted to "Y"
		And Validate error message is not displayed when quantity is entered as dispensed
    | InputFileName | SheetName | RowId 	|
    | TestData		  | product   | Row_RXQE-5579 |
    
@RXQE-5137 @Regression @HangOn_Regression @HangOn2
Scenario: Validate that the patient coupon message is displayed if the drug entered is attached to coupon for patient's plan
 Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId         				|
      | TestData      | patient   | Row_patientwithCoupon |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    #And clicks on Third Party Plan tab with coupon
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId         				|
      | TestData      | patient   | Row_patientwithCoupon |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId         				|
      | TestData      | patient   | Row_patientwithCoupon |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId         				|
      | TestData      | patient   | Row_patientwithCoupon |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId               |
      | TestData      | product   | Row_couponPlanDrug  |
    And clicks open payment button
    Then System should display the following message in the expanded Payment Panel "This patient might have a coupon for this prescription"
    And selects payment type
    And clicks Finish button to complete Data Entry
    
    
  @RXQE-4083
  Scenario: Data Review - Rework for Hybrid
  	 Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_DR_nine |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName   | SheetName | RowId   |
      | TestData        | patient   | Row_DR_nine |
    And User enters patient phone number in POS phone number text box
      | InputFileName		 | SheetName | RowId   |
      | TestData         | patient   | Row_DR_nine |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName 	| SheetName | RowId   |
      | TestData        | patient   | Row_DR_nine |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   	|
      | TestData      | product   | Row_DR_eleven |
    And clicks open payment button
    And selects payment type
    And User clicks Add Rx button
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
     And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked after adding Rx
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_DR_nine |
      | TestData      | product   | Row_DR_eleven |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And user clicks on update product button
    And user checks the paycode for generic drug when DAW=Y
    	| InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_DR_eleven |
    And user checks the paycode for generic drug when DAW=N and substitute=N
    	| InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And user checks the paycode for generic drug when DAW=N and substitute=Y
    	| InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_five |
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And clicks search button on patient order status page
     And The In progress link for current prescription should be clicked after adding Rx
      | InputFileName | SheetName | RowId   |
     	| TestData      | patient   | Row_DR_nine |
      | TestData      | product   | Row_one  |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And user edits paycode for one
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_DR_eleven |
    And user edits paycode for two
      | InputFileName | SheetName | RowId    |
      | TestData      | product   | Row_one |
    And user edits paycode for zero
      | InputFileName | SheetName | RowId    |
      | TestData      | product   | Row_five |
   	And user selects a rems drug
      | InputFileName | SheetName | RowId    |
      | TestData      | product   | Row_nine |
    #And clicks third accept to validate product data
    #And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription after adding Rx
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_DR_nine |
     	| TestData      | product   | Row_DR_eleven |
     	
@RXQE-5120 @Regression @HangOn_Regression @HangOn2
Scenario: Validate Soft Allocation is not allocated when there is not enough quantity on Shelf
		 Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    And user gets the store number from RXMS
    And get the pharmacy code from database
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    #Then Data Entry task should be created
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And checks for available product "10" in onshelf in Stock data base
    And get the product name from database
    And check the soft allocation in stock plus
    #And clicks open product button
    And enters product information from database
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And check the soft allocation in stock plus after DE
    
    @RXQE-5573 @RXQE-5620 @Regression @HangOn_Regression
		Scenario: Dispensed Drug Showing as Blank 
		 Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    #Then Data Entry task should be created
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId         |
      | TestData      | product   | Row_dispensed |
    Then The dispensed product field should not be blank
    
    @RXQE-5584 @RXQE-5642 @Regression @HangOn_Regression
    Scenario: In regard with hotkey for searching hot key in datareveiw page
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    #Then Data Entry task should be created
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    When User clicks search button to update prescriber
    Then prescriber search page should be displayed from DR
    When User hits alt plus e hotkey
    Then Prescriber should be same in DR
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
      
@RXQE-5589 @Regression @HangOn_Regression
  Scenario: DR - Changing Drug in DR Removed Other Drug Information
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    #Then Data Entry task should be created
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_HangOn1 |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
		And update product name and validate directions, days supply and refills
		  | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_two |
      
      @RXQE-5591
    Scenario: Quantity dispensed cannot be less then quantity entered
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName 	| SheetName 			| RowId   |
      | Prescriber_Input| patientsearch   | Row_ten |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
   	Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName   | SheetName 			| RowId   |
      | Prescriber_Input| patientsearch   | Row_ten |
    And User enters patient phone number in POS phone number text box
      | InputFileName		 | SheetName | RowId   |
      | Prescriber_Input | patientsearch   | Row_ten |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName 	| SheetName 			| RowId   |
      | Prescriber_Input| patientsearch   | Row_ten |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | smokeTestSIT  | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And clicks open product button
    And enters product information for Dispensed quantity less than quantity entered
      | InputFileName 		| SheetName 			| RowId   	|
      | Prescriber_Input  | Productdetails  | Row_seven |
    And enters product information for Dispensed quantity greater than quantity entered
      | InputFileName 		| SheetName 			| RowId   	|
      | Prescriber_Input  | Productdetails  | Row_eight |
      
      
		@RXQE-5585
 		Scenario: Functions Not Working in DR for Multiple Scripts on Image
 		 Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | e2e11  				| patient   | Row_five |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | e2e11  				| patient   | Row_five |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | e2e11 				| patient   | Row_five |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | e2e11  				| patient   | Row_five |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | smokeTestSIT  | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | smokeTestSIT  | product   | Row_twentyfive |
    And clicks open payment button
    And selects payment type
    And User clicks Add Rx button
     And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | smokeTestSIT  | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
     And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked after adding Rx
      | InputFileName | SheetName | RowId   |
      | e2e11  				| patient   | Row_five |
      | smokeTestSIT  | product   | Row_twentyfive |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And clicks search button on patient order status page
     And The In progress link for current prescription should be clicked after adding Rx
      | InputFileName | SheetName | RowId   |
      | e2e11  				| patient   | Row_five |
      | smokeTestSIT  | product   |     Row_one     |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And performs all the actions on image
    And clicks third accept to validate product data
    And click finish using ctrl f key
    #And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription after adding Rx
      | InputFileName | SheetName | RowId   |
      | e2e11 				| patient   | Row_five |
     	| smokeTestSIT  | product   | Row_twentyfive     |
   And The In progress link for current prescription should be clicked after adding Rx
      | InputFileName 		 | SheetName | RowId   |
      | e2e11  						 | patient   | Row_five |
      | smokeTestSIT       | product   | Row_twentyfive |
    And User closes the application
    
     @RXQE-5592 @HangOn4 @Regression @HangOn_Regression
  Scenario: State defaults to IL in Prescriber Search
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When user navigates to prescriber search
    Then prescriber search page should be displayed
    And state should default to "WI"

  @RXQE-5575 @HangOn4 @Regression @HangOn_Regression
  Scenario: Able to Enter "HOURS" Into Directions
   Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId     |
      | TestData      | patient   | Row_Marie |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId     |
      | TestData      | patient   | Row_Marie |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId     |
      | TestData      | patient   | Row_Marie |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId     |
      | TestData      | patient   | Row_Marie |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And state should default to "WI" in DE
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId         |
      | TestData      | product   | Row_RXQE-5575 |
    And validate directions field with description
      | InputFileName | SheetName | RowId         |
      | TestData      | product   | Row_RXQE-5575 |
    
  @RXQE-5580	 @HangOn6 
  Scenario: DE | Qty Entered Should be a Multiple of Qty of Drug Unit
     Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    Then system should allow to enter specific product information manually
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | HangOn_5580_1 |
    And system should allow to enter specific product information using notation
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | HangOn_5580_2 |
      
      
      
   @RXQE-2580 @RXQE-4449 
Scenario: Patient Prescriber    
  Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
     When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_Gaurav |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_Gaurav |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_Gaurav |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
     | TestData  | patient   | Row_Gaurav |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one | 
    And User selects null value in the state dropdown
     When user hits Alt plus R to search results 
     When user hits Alt plus L to clear the search prescriber
     When user hits Alt plus R to search the prescriber results 
   	 
   	 
   	 @RXQE-5164 @Regression @HangOn_Regression
Scenario: Next task transition for Data Review focus reset
  Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
     When User hits ctrl plus two hot key
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    #And clicks Finish to complete data review
    And click on Finish to complete Data Review
    And System should focus on patient accept button
     
     
     
 @RXQE-5594 @Regression @HangOn_Regression
Scenario: Quick codes "AMO500" or "ZIT250" does not populate a dispensed drug
  Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    #Then Data Entry task should be created
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | smokeTestSIT  | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then System should display data review page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information and validate dispensed drug not displayed
      | InputFileName | SheetName | RowId         |
      | TestData      | product   | Rox_RXQE-5594 |
      
      
  @RXQE-5590 @Regression @HangOn_Regression
 Scenario: Prescriber Not Selected When Using Hot Key
   Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
     When User hits ctrl plus one hot key
     When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
     And clicks search button on prescriber search
     And clicks select to select a prescriber
     And user hits alt plus p to open prescriber
     And clicks search button on prescriber search
     And user hits alt plus e to select prescriber   
     
     @RXQE-5130 @Regression @HangOn_Regression
  Scenario: Grand Prix-Regression | DE |Patient Order Status | Window pop up multiple times
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    When User clicks multiple times on Rxnumber hyperlink of current prescription
    Then The rx details popup should be displayed only once
       
     
     