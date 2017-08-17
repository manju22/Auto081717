@dataEntry @Regressiontest
Feature: Data Entry Flow

  @RXQE-2248 @E2E @Regression
  Scenario: State Rule Validation
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
      | TestData      | patient   | Row_Raghu |
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
      | TestData      | patient   | Row_Raghu |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId     |
      | TestData      | patient   | Row_Raghu |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId     |
      | TestData      | patient   | Row_Raghu |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information in the fields
      | InputFileName | SheetName | RowId        |
      | TestData      | product   | RowDatathree |
    Then User able to see error message display in refills feild

  @RXQE-1764 @E2E @Regression
  Scenario: DE without Product details
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
    And clicks finish button on Data Entry page
    Then An error message "No drug selected" should be displayed under the prescribed drug
    And An error message "Mandatory field" should be displayed under all the drug fields

  @RXAPPD-11872 @RXAPPD-11871 @claimingTask
  Scenario: Claim a different task
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | PatientRowfour |
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
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | PatientRowfour |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | PatientRowfour |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | PatientRowfour |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    When User navigates to home page by using CTRL plus h hot key
    Then User will be on RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | PatientRow_six |
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
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | PatientRow_six |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | PatientRow_six |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | PatientRow_six |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User clicks on DR task while performing DE task
    Then User sees the message
    And User clicks on yes on the system message
    Then System should display data review page
    And User closes the application

  #@RXAPPD-15501 @RXQE-2527 @E2E
  #Scenario: Verify that in Data Entry in the manipulation tool the system allows to switch between documents and pages
  #Given User launches the RxMS desktop application
  #When User enters the valid credentials in login text fields
  #| InputFileName        | SheetName | RowId  |
  # | TestData  | login     | Row_one |
  #And User clicks login button
  #Then System should display RxMS home page
  #When User clicks on patient tab in left side menu
  #Then System should navigate to patient search page
  #When User enters patient First Name and Last Name
  #| InputFileName | SheetName | RowId    |
  #| TestData         | patient   | PatientRowfour |
  #And clicks search button on patient search page
  #Then System should display patient search results
  #And Select a patient
  #When User clicks view button
  #And clicks intake Rx
  #Then System should navigate to Intake Method Screen
  #When User selects pickup time as waiting
  #And selects origin code as Scan
  #And clicks Finish button in intake method screen
  #Then Data Entry task should be created
  #When User navigates to patient order status
  #And User enters patient last name in POS last name text box
  #| InputFileName | SheetName | RowId    |
  #| TestData         | patient   | PatientRowfour |
  #And User enters patient phone number in POS phone number text box
  #| InputFileName | SheetName | RowId    |
  #| TestData         | patient   | PatientRowfour |
  #And User clicks search button on patient order status
  #Then The pending link for current prescription should be clicked
  #| InputFileName | SheetName | RowId    |
  #| TestData         | patient   | PatientRowfour |
  #Then System displays a donut chart
  #When User clicks perform data entry hyperlink
  #Then Sytem should display data entry page
  #And User click on back button on tab bar in DE page
  #And User click on front button on tab bar in DE page
  #When user click on annotation button and add a note with below text for front image on DE page
  #| RxRenewal  |
  #| Automation |
  #| Walgreens  |
  #| Deerfield  |
  #And user clicks on annotaton button and adds no text "" in note and checks the notes for front image on DE page
  #Then User check the annotations are saved in descending order
  #| Deerfield  |
  #| Walgreens  |
  #| Automation |
  #| RxRenewal  |
  #When user click to rotate scanned image to right on DE page
  #Then user check  the scanned image rotated to right on DE page
  #When user click to rotate scaned image left on DE page
  #Then user check the image rotated left on DE page
  #And user click to zoom in scanned Image on DE page
  #Then user click on resize to original size on DE page
  #And user click to zoom out scanned image on DE page
  #Then user click on resize to original size on DE page
  #When user click on full screen image
  #And user see the image full screen
  #Then user click on close
  #And User click on back button on tab bar in DE page
  @RXAPPD-9852 @data_entry @GrandPrix2
  Scenario: UI - View Patient Order Status - Verify that it is possible to display all prescription for a time defined into Prescription Lifetime parameter
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
      | TestData      | patient   | Row_Five |
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
      | TestData      | patient   | Row_Five |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_Five |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_Five |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    When User clicks patient order status in left side menu
    Then System should display patient order status page
    When User enters patient last name in the search field
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_Five |
    And clicks search button on patient order status page
    Then patient order status results should be displayed
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_Five |

  @RXQE-2991 @E2E @P1 @Regression
  Scenario: E2E | DE | Determine Payment Method Cash Option
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
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_new_pat |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_new_pat |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
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
    Then pay code drop down should disable
    And clicks Finish button to complete Data Entry
    And User validates the status as "entered" and selects the current prescription
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_new_pat |

  @RXAPPD-12611
  Scenario: UI - Patient Order Status Navigation - Rework For Hybrid - To transfer an Intake to IC+ using 'Send to IC+' in 'Rx Entry' screen
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
    And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And click on Send to IC plus
    Then System should display patient order status page
    And clicks search button on patient order status page
    And User validates the status as "check ic+" and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |

  @RXAPPD-15412
  Scenario: UI- Systematic Task Creation Rework for Hybrid - Performing a Data Entry when no prescription entered into the system
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
    And click DE cancel
    Then Data Entry task should be created

  @RXQE-1911 @E2E @Regression
  Scenario: Determine Paycode | Negative Scenario
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
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_new_pat |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_new_pat |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
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
    And enters product information with DAW as "Y"
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    Then System should set the Pay code to one substitution of the drugs will not be allowed
    And Paycode dropdown should be enabled

  @RXUAT-228 @RXQE-2998 @E2E @UAT @P1 @Regression
  Scenario: verify that you are able to see under the price column the cash price returned + plan ID.
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
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
    And selects payment type as plan
    And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And get the plan displayed in DR
    And clicks Finish to complete data review
    Then System should generate rx number, price and plan ID for current prescription
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |

  @RXQE-1792 @E2E @Regression
  Scenario: E2E - Data Entry - Determine Payment Method - With plan
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
      | TestData      | patient   | Row_new_pat |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    Then Number of DR tasks should be decreased

 @RXQE-1638 @E2E @Regression
  Scenario: E2E - Data Entry - Create a Prescription Number
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
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_new_pat |

  @RXQE-1805 @E2E @Regression
  Scenario: E2E Data Entry Identify Preferred Dispened Product DAW=N and Substitute=N
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    Then The user enters DAW field as "N" and the Substitute field as "N"
    When The user enters all the mandatory fields in Product panel daw N and substitute N
      | InputFileName | SheetName | RowId    |
      | TestData      | product   | Row_four |
    Then The system would display the right dispensed product if daw N and substitute N

  @RXAPPD-15433 @RXAPPD-9775 @RXAPPD-3235 @RXAPPD-10694 @RXAPPD-10693 @RXAPPD-3439 @RXAPPD-3444 @RXAPPD-3206 @RXAPPD-13178
  Scenario: Product scenarios
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type as plan
    Then System should set the Pay code to one substitution of the drugs will not be allowed
    And User clicks Add Rx button
    Then System should add the Rx and create a DR task
    And clicks open product button
    When User sets DAW=Y and Substitute=N
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    When User selects a Rems or LDD drug
      | InputFileName | SheetName | RowId       |
      | TestData      | rems      | Rems_Rowone |
    Then I should see REMS popup message
    And I enter product information while DAW is set to Y
      | InputFileName | SheetName | RowId          |
      | TestData      | product   | Product_Rowtwo |
    And I attempt to change the substitute
    Then The system displays a message that the dispensed drug may not be changed when DAW is set to Y
    And check only view size and manufacturer
      | InputFileName | SheetName | RowId          |
      | TestData      | product   | Product_Rowtwo |
    And I attempt to change the substitute
    Then The system displays a message that the dispensed drug may not be changed when DAW is set to Y
    When I enter product information while DAW is set to N
      | InputFileName | SheetName | RowId            |
      | TestData      | product   | Product_RowThree |
    And I attempt to change the substitute
    Then System allows me to change the substitute
    When I change the DAW from N to Y
      | InputFileName | SheetName | RowId          |
      | TestData      | product   | Product_Rowtwo |
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    Then The substitute field will be disabled
    #And The system would display the right dispensed product
    #| InputFileName | SheetName | RowId   |
    #| TestData  | product   | Row_one |
    #And clicks open product button
    #And enters product information with valid directions
    #| InputFileName | SheetName | RowId   |
    #| TestData  | product   | Row_ten |
    #Then System should calculate days supply
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    And User closes the application

  @RXQE-3556 @E2E @Regression
  Scenario: Systematic task creation
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
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
    And User clicks cancel Button on DE page
    Then System unreserves the task by adding the task back to the taskboard

  @RXQE-3111 @E2E @Regression
  Scenario: E2E |DE| Drug Search - Changes the selected drug and cancels the operation of changing the drug
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
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
    When I click cancel button on product textbox
    Then I should be able to enter new product information
      | InputFileName | SheetName | RowId     |
      | TestData      | product   | Row_three |

  #And I click on logout button
  #And I click yes on popup window
  @RXQE-2845 @E2E @P1 @Regression
  Scenario: E2E | DE | Identify Preferred Dispensed Product-Store Level
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
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
    And enters product with DAW N and substitute as Y
      | InputFileName | SheetName | RowId     |
      | TestData      | product   | Row_eight |
    And I should see preferred drug as dispensed product

  #And I click on logout button
  #And I click yes on popup window
  @RXQE-3120 @E2E @Regression
  Scenario: E2E | DE | Prescriber Search - Change Search after Results shown
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And I should see new prescriber result
    Then atleast one result should be displayed and highlighted
    Then user hits the Enter Key
    When displays new prescriber details in the Prescriber panel in read only mode
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And system closes the Prescriber Search Results overlay
    And Click on updateRx prescriber expand button
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_four |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And I should see new prescriber result
    Then atleast one result should be displayed and highlighted
    When User enters new prescriber first name and Last name
      | InputFileName | SheetName  | RowId     |
      | TestData      | prescriber | Row_three |
    Then clicks search button on prescriber search in expand window
    And I should see new prescriber result
    Then atleast one result should be displayed and highlighted
    Then user hits the Enter Key
    When displays new prescriber details in the Prescriber panel in read only mode
      | InputFileName | SheetName  | RowId     |
      | TestData      | prescriber | Row_three |
    And system closes the Prescriber Search Results overlay
    And Click on updateRx prescriber expand button
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    When User enters new prescriber first name and Last name
      | InputFileName | SheetName  | RowId    |
      | TestData      | prescriber | Row_four |
    Then clicks search button on prescriber search in expand window
    And I should see new prescriber result
    Then atleast one result should be displayed and highlighted
    Then user hits the Enter Key
    When displays new prescriber details in the Prescriber panel in read only mode
      | InputFileName | SheetName  | RowId    |
      | TestData      | prescriber | Row_four |
    And system closes the Prescriber Search Results overlay

  @RXQE-2917 @RXQE-3102 @E2E @P1 @Regression
  Scenario: REMS & Quality Check Pop-up on Data Entry Screen
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
    When User sets DAW=Y and Substitute=N
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    When User selects a Rems or LDD drug
      | InputFileName | SheetName | RowId       |
      | TestData      | rems      | Rems_Rowone |
    Then I should see REMS popup message
    And User closes the application

  @RXQE-2918 @E2E @P1 @Regression
  Scenario: Quality & Safety Checks LDD Pop-up Message on DE Screen
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
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
    When User sets DAW=Y and Substitute=N
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    When User selects a Rems or LDD drug
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Rems_Rowone |
    Then I should see REMS popup message
    When User selects a Rems or LDD drug Error message
      | InputFileName | SheetName | RowId          |
      | TestData      | product   | Row_REMS_ALERT |
    Then I should see REMS Error popup message
    And User closes the application

  @RXUAT-290 @UAT
  Scenario: Identify drug for fulfillment
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | Patient_RowFive |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | Patient_RowFive |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | Patient_RowFive |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | Patient_RowFive |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId              |
      | TestData      | prescriber | Prescriber_RowFour |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters the drug information
      | InputFileName | SheetName | RowId     |
      | TestData      | product   | Row_three |
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | Patient_RowFive |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | Patient_RowFive |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | Patient_RowFive |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId              |
      | TestData      | prescriber | Prescriber_RowFour |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters the drug information two
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_RowFive |
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | Patient_RowFive |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | Patient_RowFive |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | Patient_RowFive |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId              |
      | TestData      | prescriber | Prescriber_RowFour |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters the drug information two
      | InputFileName | SheetName | RowId             |
      | TestData      | product   | Product_RowEleven |
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | Patient_RowFive |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | Patient_RowFive |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | Patient_RowFive |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId              |
      | TestData      | prescriber | Prescriber_RowFour |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters the drug information for no dispensed drug
      | InputFileName | SheetName | RowId            |
      | TestData      | product   | Row_four_Product |
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | Patient_RowFive |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | Patient_RowFive |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | Patient_RowFive |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId              |
      | TestData      | prescriber | Prescriber_RowFour |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters the drug information for dispensed drug
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_Row_six |
    And enters the drug information for list of drugs
      | InputFileName | SheetName | RowId             |
      | TestData      | product   | Product_Row_seven |
    And enters the drug information for list of drug
      | InputFileName | SheetName | RowId             |
      | TestData      | product   | Product_Row_eight |
    And User closes the application

  @RXQE-2959 @E2E @Regression
  Scenario: E2E | DE | Determine Paycode | When generic substitute is NOT available when DAW is set to Y and Substitute is set to N
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
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_new_pat |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_new_pat |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
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
    And enters product information with DAW as "Y"
      | InputFileName | SheetName | RowId         |
      | TestData      | product   | Row_noGeneric |
    And clicks open payment button
    Then System should set the Pay code to one substitution of the drugs will not be allowed
    And Paycode dropdown should be enabled

  @RXQE-2962 @E2E @Regression
  Scenario: E2E | DE | Determine Paycode | When generic substitute is NOT available when DAW is set to N and Substitute is set to N
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
      | TestData      | patient   | Row_Five |
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
      | TestData      | patient   | Row_Five |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_Five |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_Five |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    Then The user enters DAW field as "N" and the Substitute field as "N"
    When The user enters all the mandatory fields in Product panel
      | InputFileName | SheetName | RowId         |
      | TestData      | product   | Row_noGeneric |
    #Then The system would display the right dispensed product
    And clicks open payment button
    And selects payment type as plan
    Then System should set the Pay code to two substitution of the drugs allowed

  @RXQE-2964 @E2E @Regression
  Scenario: E2E | DE | Determine Paycode | When Generic Substitute is Available when DAW is set to Y and Substitute is set to N
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
      | TestData      | patient   | Row_Five |
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
      | TestData      | patient   | Row_Five |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_Five |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_Five |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    Then The user enters DAW field as "Y" and the Substitute field as "N"
    When The user enters all the mandatory fields in Product panel
      | InputFileName | SheetName | RowId         |
      | TestData      | product   | Row_noGeneric |
    #Then The system would display the right dispensed product
    And clicks open payment button
    And selects payment type as plan
    Then System should set the Pay code to one substitution of the drugs will not be allowed

  @RXQE-2966 @E2E @Regression
  Scenario: E2E | DE | Determine Paycode | When generic substitute is NOT available when DAW is set to N and Substitute is set to Y
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
      | TestData      | patient   | Row_Five |
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
      | TestData      | patient   | Row_Five |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_Five |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_Five |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    Then The user enters DAW field as "N" and the Substitute field as "Y"
    When The user enters all the mandatory fields in Product panel
      | InputFileName | SheetName | RowId         |
      | TestData      | product   | Row_noGeneric |
    And clicks open payment button
    Then System should set the Pay code to zero - No product selection indicated
    And Paycode dropdown should be enabled

  @RXQE-2968 @E2E @Regression
  Scenario: E2E | DE | Determine Paycode | When Generic Substitute is Available when DAW is set to 'N' and Substitute is set to 'Y'
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
      | TestData      | patient   | Row_Five |
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
      | TestData      | patient   | Row_Five |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_Five |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_Five |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    Then The user enters DAW field as "N" and the Substitute field as "Y"
    When The user enters all the mandatory fields in Product panel
      | InputFileName | SheetName | RowId          |
      | TestData      | product   | Row_twentyfive |
    And clicks open payment button
    Then System should set the Pay code to zero - No product selection indicated
    And Paycode dropdown should be enabled

  @RXQE-2970 @E2E @Regression
  Scenario: E2E | DE | Determine Paycode | When the Payment method is selected as cash the Paycode drop down should be disabled
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
    Then pay code drop down should disable

  @RXQE-3488 @E2E @Regression
  Scenario: DE | Prescriber Search - Prescriber Search when multiple DE tasks in queue
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
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_Five |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    Then System should display RxMS home page
    When User clicks DE task in the taskboard
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
    And clicks finish button on Data Entry page
    Then DE task for next patient is displayed with empty text fields

  @RXUAT-180 @UAT @Regression
  Scenario: Image Manipulation - Data Entry
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | PatientRowfour |
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
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | PatientRowfour |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | PatientRowfour |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | PatientRowfour |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    #uncomment
    #And User click on back button on tab bar in DE page
    #And User click on front button on tab bar in DE page
    #When user click on annotation button and add a note with below text for front image on DE page
    #| RxRenewal  |
    #| Automation |
    #| Walgreens  |
    #| Deerfield  |
    #And user clicks on annotaton button and adds no text "" in note and checks the notes for front image on DE page
    #Then User check the annotations are saved in descending order
    #| Deerfield  |
    #| Walgreens  |
    #| Automation |
    #| RxRenewal  |
    #uncomment
    When user click to rotate scanned image to right for front image on DE page
    Then user check  the scanned image rotated to right for front image on DE page
    When user click to rotate scaned image left for front image on DE page
    Then user check the image rotated left for front image on DE page
    And user click to zoom in scanned Image for front image on DE page
    Then user click on resize to original size for front image on DE page
    And user click to zoom out scanned image for front image on DE page
    Then user click on resize to original size for front image on DE page
    When user click on full screen image
    And user see the image full screen
    Then user click on close
    And User click on back button on tab bar in DE page
    When user click to rotate scanned image to right for back image on DE page
    Then user check  the scanned image rotated to right for back image on DE page
    When user click to rotate scaned image left for back image on DE page
    Then user check the image rotated left for back image on DE page
    And user click to zoom in scanned Image for back image on DE page
    Then user click on resize to original size for back image on DE page
    And user click to zoom out scanned image for back image on DE page
    Then user click on resize to original size for back image on DE page
    When user click on full screen image
    And user see the image full screen
    Then user click on close

  @RXUAT-21 @Grandprix_UAT @UAT @Regression
  Scenario: Prescriber Search
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When user navigates to prescriber search
    Then prescriber search page should be displayed
    When I click TAB key from "Phone Number" field
    Then I should be on "NPI" field
    When I click TAB key from "NPI" field
    Then I should be on "First Name" field
    When I click TAB key from "First Name" field
    Then I should be on "Last Name" field
    When you click search button with empty input
    Then I should see "Please specify the required search criteria!"
    When you click search button after entering first name
    Then I should see "Please specify the required search criteria!"
    When I enter invalid "NPI" value
    Then I should see "Invalid Format"
    When I enter invalid "DEA" value
    Then I should see "Invalid Format"
    When user enters details of prescriber
      | InputFileName | SheetName  | RowId        |
      | TestData      | prescriber | Row_multiple |
    And click hot key to search
    Then prescriber details should be displayed successfully
    And I should be able to use up and down arrows to navigate through the records
    #Multiple locations steps needs to be added
    When user enters details of the prescriber with DEA
      | InputFileName | SheetName  | RowId        |
      | TestData      | prescriber | Row_multiple |
    And click hot key to search
    Then prescriber details should be displayed successfully
    When I click on Last, First Name label
    Then I should see results in descending order
    When user enters details of the prescriber with NPI
      | InputFileName | SheetName  | RowId        |
      | TestData      | prescriber | Row_multiple |
    And click hot key to search
    Then prescriber details should be displayed successfully
    When user clicks "Update" button
    Then I should get "This function cannot be completed in this system.  Please complete in IC+."
    And click ok
    When User hits Alt plus U hotkey
    Then I should get "This function cannot be completed in this system.  Please complete in IC+."
    And click ok
    When User hits Alt plus V hotkey
    Then prescriber details page should be displayed successfully

  @RXUAT-220 @UAT
  Scenario: Selecting Drug associated to Coupon for Hybrid
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
      | TestData      | patient   | Row_Raghu4 |
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
      | TestData      | patient   | Row_Raghu4 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_Raghu4 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_Raghu4 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    When user select payment type and select a plan and validating all plans
    Then system should display the coupon plan in payment plan with message
    When user open drop down and checks the plan and drugs with out selecting any feild

  @RXQE-3116 @E2E @Regression
  Scenario: E2E|DE|DRUG SEARCH |  Negative Scenario(Non LDD Drug is entered in DE screen then pop-up message should not be displayed )
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
    And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    Then I should not see popup message

  @RXQE-3105 @E2E @Regression
  Scenario: E2E | DE | DRUG SEARCH |Quality & Safety Checks LDD Pop-up Message on DE Screen
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
      | InputFileName | SheetName  | RowId     |
      | TestData      | prescriber | Row_three |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters REMS product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_six |
    Then I should see REMS popup message
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId     |
      | TestData      | patient   | Row_Marie |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks update and enters a Rems or LDD drug
      | InputFileName | SheetName | RowId       |
      | TestData      | rems      | Rems_Rowone |
    Then I should see REMS popup message

  @RXQE-3099 @E2E @Regression
  Scenario: E2E | DE| Enter Rx Attributes | Negative Scenario (Set Correct Days Supply)
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
      | TestData      | patient   | Row_Ramesh |
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
      | TestData      | patient   | Row_Ramesh |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_Ramesh |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_Ramesh |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId     |
      | TestData      | prescriber | Row_three |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information until qty
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And I should see Rx Expiration date field is auto popualated
    And I should see Rx Expiration date field is auto popualated
    When I enter "1 per day" in Directions field
    Then I should see days supply field is same as qty field
    When I change the Qty field now
      | InputFileName | SheetName | RowId     |
      | TestData      | product   | Row_empty |
    Then I should see days supply field is same as qty field
    When I enter "2 per day" in Directions field
    Then I should see days supply field is set to empty

  @RXQE-2961 @E2E @Regression
  Scenario: E2E | DE |Rx ATTRIBUTES | CALCULATE DAYS SUPPLY
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
      | TestData      | patient   | Row_Ramesh |
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
      | TestData      | patient   | Row_Ramesh |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_Ramesh |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_Ramesh |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId     |
      | TestData      | prescriber | Row_three |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information until qty
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    #And I should see Rx Expiration date field is auto popualated
    #And I should see Rx Expiration date field is auto popualated
    When I enter "tk 1 t po d" in Directions field
    Then I should see days supply field is same as qty field
    When I enter "tk 2 t po d" in Directions field
    Then I should see days supply field is half of the qty field
    When I enter "tk 1 t po d" in Directions field
    When I change the Qty field now
      | InputFileName | SheetName | RowId     |
      | TestData      | product   | Row_empty |
    Then I should see days supply field is same as qty field

  @RXQE-2927 @E2E @Regression
  Scenario: E2E | DE | DRUG SEARCH
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
      | TestData      | patient   | Row_Ramesh |
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
      | TestData      | patient   | Row_Ramesh |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_Ramesh |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_Ramesh |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId     |
      | TestData      | prescriber | Row_three |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information until qty
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    When I enter "+Qd" in Directions field
    Then I should see text changed to " TAKE ONE TABLET BY MOUTH EVERY DAY"


	@RXQE-3058 @Regression
Scenario: Prescriber search | Data Entry
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
    When User enters partial prescriber first name and partial Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    Then System should display a message please refine your search criteria
     When User does a prescriber search with phone number in invalid format
      | InputFileName | SheetName  | RowId           |
      | TestData      | prescriber | Row_invaliddata |	
    Then System should display a invalid field format message

  @RXUAT-294 @RXQE-2796 @RXUAT-279 @RXAUT-3 @UAT
  Scenario: Data Entry
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
    And clicks search button on prescriber search
    Then system displays the list of prescribers that matches the search criteria
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    When User does a prescriber search by First name only
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    Then system displays error specify the required search criteria
    When User does a prescriber search by Last name only
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    Then system displays error specify the required search criteria
    When User does a prescriber search by phone number only
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    Then system displays the list of prescribers that matches the search criteria
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_Gaurav |
    When User does a prescriber search with NPI or DEA
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    Then system displays the list of prescribers that matches the search criteria
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    When User searches for a prescriber that practices outside the default state
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_two |
    Then System should display a message no results found matching the search criteria
    When User does a prescriber search by invalid phone number
      | InputFileName | SheetName  | RowId                   |
      | TestData      | prescriber | Prescriber_invalidPhone |
    Then System should display a message please refine your search criteria
    When User does a prescriber search with phone number in invalid format
      | InputFileName | SheetName  | RowId           |
      | TestData      | prescriber | Row_invaliddata |
    Then System should display a invalid field format message
    When User enters partial prescriber first name and partial Last name
      | InputFileName | SheetName  | RowId           |
      | TestData      | prescriber | Row_invaliddata |
    Then System should display a message please refine your search criteria
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search button on prescriber search
    Then Update and Add New Buttons should be invisible
    When User clicks view Button on DE prescriber results page
    Then System should display prescriber details page from DE
    And All fields in the prescriber details page from DE should be disabled
    And User clicks back button on prescriber details page from DE
    And clicks select to select a prescriber
    And clicks open product button
    When User searches for a product with product name in the prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_ten |
    Then System displays the drugs matching the search criteria
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_ten |
    When User selects a Rems or LDD drug
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Rems_Rowone |
    Then I should see REMS popup message
    When User searches for a product with quick code
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_fifteen |
    Then System displays the drugs matching the search criteria
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_fifteen |
    When User searches for a product with NDC
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_sixteen |
    Then System displays the drugs matching the search criteria
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_sixteen |
    When User searches for a product with UPC
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_sixteen |
    Then System displays the drugs matching the search criteria
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_sixteen |
    When User searches for a product with WIC
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_sixteen |
    Then System displays the drugs matching the search criteria
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_sixteen |
    When User enters original Rx date
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    Then System should auto populate the Drug Exp Date and the RX expiration data
    When User enters the product quantity
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_sixteen |
    Then Only the quantity entered should be dispensed
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_sixteen |
    When User enters the directions provided by the prescriber
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_sixteen |
    Then appropriate directions are added
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_sixteen |
    When User enters all mandatory fields
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And User clicks cancel Button on DE page
    Then System should display patient order status page
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
    And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And User clicks Add Rx button
    Then System should add the Rx and create a DR task
    And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_sixteen |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_sixteen |
    And clicks open payment button
    And selects payment type as plan
    Then System should set the Pay code to one substitution of the drugs will not be allowed
    When User clicks open product2 Button
    And enters DAW=N and Substitute=N
      | InputFileName | SheetName | RowId           |
      | TestDatas     | product   | ProductRow_four |
    And clicks open payment2 button
    Then System should set the Pay code to two substitution of the drugs allowed
    When User clicks open product3 Button
    And enters DAW=N and Substitute=Y
      | InputFileName | SheetName | RowId            |
      | TestData      | product   | ProductRow_three |
    And clicks open payment button
    Then System should set the Pay code to zero - No product selection indicated
    When User clicks send to ICplus button
    Then System should display patient order status page
    And User clicks search button on patient order status
    Then prescription status should be check ICplus in patient order status
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
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
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And clicks open product button
    When User sets DAW=Y and Substitute=N
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    When User selects a Rems or LDD drug
      | InputFileName | SheetName | RowId       |
      | TestData      | rems      | Rems_Rowone |
    #Then System displays an error message, please complete the process in IC+
    When User clicks continue in ICplus Button
    Then System should display RxMS home page
    When User navigates to patient order status
    And User clicks search button on patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_nineteen |
    And User clicks search button on patient order status
    Then prescription status should be check ICplus in patient order status
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |

  #RXAPPD-14421
  #RXAPPD-14417
  @RXAPPD-15462
  Scenario: Verify an Image Pullback with a Data Entry started
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | PatientRow_Four |
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
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | PatientRow_Three |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | PatientRow_Three |
    And User clicks search button on patient order status
    Then User verify pending link for current prescription should be clicked
      | LastName |
      | PATIENT  |
    Then I click on DataEntry
    And Users enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    Then Clicks Check ICPlus button to complete Data Entry
    Then System should display patient order status page
    And clicks search button on patient order status page
    And The ICPlus link for current prescription should be verified
      | LastName |
      | PATIENT  |

  @RXQE-3195 @E2E @Regression
  Scenario: Verify the prescriber selection without Location value
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
      | TestData      | prescriber | Row_DR_one |
    Then User click the Prescriber search button in de
    And validate prescriber result which is out of state
    And Click on prescriber cancel button
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    Then User click the Prescriber search button in de
    And validate prescriber result with null state


 @RXQE-3506 @E2E @Regression
  Scenario: Verify that the system hides Add Comment + button in the Commens panel for patient for the user with Read permission to patient comments
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | PatientRowsix |
    And I click on Search button
    Then System should display patient search results
    When User clicks view button
    And User clicks add comments button and validate the popup msg

  @RXQE-3503 @E2E @Regression
  Scenario: Patient Search and validating his 3rd party plans
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | PatientRowsix |
    And I click on Search button
    Then System should display patient search results
    When User clicks view button
    And User clicks 3rd party plans button and validate plans

 @RXUAT-27 @RXQE-2399 @RXUAT-291 @RXQE-2800 @E2E @Regression
  Scenario: Plan Search Navigation
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    Then User search Appropriate plan
      | PlanID | BIN    | PCN | PLAN_NAME          |
      | ILBC   | 003585 | VDZ | ILLINOIS BLUE PLAN |
    And User navigate back to dashboard screen
    When User clicks plan search button in left side menu
    Then System should display plan search page
    Then  validate the tab order in plan search page

  # @RXAPPD-14430
  @RXAPPD-14429
  Scenario: Update a Team Member prescription in RxMS_Failure
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | PatientRow_Three |
    And User clicks search button on patient order status
    Then I checks the status of a prescription for a patient

  @RXUAT-227 @UAT @Regression
  Scenario: Drug Details page validation
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    When User clicks drug search in left side menu
    Then System should display drug search page
    When User enters drug name in text box labeled drug name
      | InputFileName | SheetName | RowId   |
      | TestData      | drug      | Row_one |
    And clicks search button on drug search page
    And clicks view button on drug search page
    And Validating the drug details page sub menu
    Then Click Print patient handout and validate popup
    Then Validating drug type in drug details page

  @RXAPPD-3398
  Scenario: To display an alert message if there isn't dispensed drugs identified selecting DAW=N
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | PatientRow_Four |
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
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | PatientRow_Three |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | PatientRow_Three |
    And User clicks search button on patient order status
    Then User verify pending link for current prescription should be clicked
      | LastName |
      | PATIENT  |
    Then I click on DataEntry
    And clicks open product button
    And User Enters DE product information
      | Date     | DAW | Substitute | DrugName                | DrugExpiryDate | Qty | Qty_Disp | Dir      | Days_Supply | Refills | RxExpiration |
      | 03112016 | N   | Y          | Advil 200mg Gel Caplets |       03112018 | 100 |      100 | per meal |          10 |      10 |     03112018 |
    Then User validating no dispensed drug identified

  @RXAPPD-3396
  Scenario: To display multiple drugs with the same Equivalent Group of the prescribed drug in the list of dispensed drugs selecting DAW=N
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    When User clicks on patient tab in left side menu
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId           |
      | TestData      | patient   | PatientRow_Four |
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
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | PatientRow_Three |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | PatientRow_Three |
    And User clicks search button on patient order status
    Then User verify pending link for current prescription should be clicked
      | LastName |
      | PATIENT  |
    Then I click on DataEntry
    And clicks open product button
    And User Enters DE product information
      | Date     | DAW | Substitute | DrugName | DrugExpiryDate | Qty | Qty_Disp | Dir      | Days_Supply | Refills | RxExpiration |
      | 03112016 | N   | Y          | Warfarin |       03112018 | 100 |      100 | per meal |          10 |      10 |     03112018 |

  @RXQE-4082 @E2E @Regression
  Scenario: View Patient Details
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    When User clicks on patient tab in left side menu
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_Pat_Plan_1 |
    And clicks search button on patient search page
    When User clicks view button
    Then User view and validate the patient details
    And User clicks add comments button and validate the popup msg

 @RXQE-5525 @IkariWarriors @Regression
  Scenario: SIT | RXMS | Delete image from POS after user clicks on send to IC+ in DE
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
      | TestData      | patient   | Row_one_7402 |
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
      | TestData      | patient   | Row_one_7402 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one_7402 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one_7402 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And click on Send to IC plus
    Then System should display patient order status page
    And User clicks search button on patient order status
    And User validates the status as "Check IC" and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one_7402 |
    And User clicks delete prescription in patient order status
    Then System should display a message "IC+ prescription can only be deleted in IC+" under the prescription

  @RXQE-5851 @IkariWarriors @Regression
  Scenario: SIT|Patient view|Return back to patient search screen
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
    Then User selects the current patient
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    And Click on back arrow button
    Then User selects the current patient
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |

  @RXQE-7755 @production_hotfix @Regression
  Scenario: Prod HotFix |Drug Search | multiple products are displayed in multi hit window when entering invalid NDC with hyphens | SCENARIO TWO in Data Entry Product Search
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
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And user enters product with invalid NDC "00000-0000-00"
    Then no product results should be shown

  @RXQE-5907 @IkariWarriors @Regression
  Scenario: SIT | Update stock when delete an new Rx before DR
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
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_DE_IW_1 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_DE_IW_1 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_DE_IW_1 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_DE_IW_1 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And checks for available product in onshelf in Stock data base
    And get the product name from database
    And enters product information from db
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Row_DR_fourteen |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And check the soft allocation for DE in stock plus
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_DE_IW_1 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_DE_IW_1 |
    And User clicks search button on patient order status
    Then User validates the status as "entered" and selects the current prescription
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_DE_IW_1 |
    When User clicks on Delete Rx button
    Then validates the popup
    And clicks on Delete RX
    And check the soft allocation after delete rx in stock plus

  @RXQE-5516 @IkariWarriors @Regression
  Scenario: SIT | RXMS | Delete image after DE from POS
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_5516 |
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
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_5516 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_5516 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_5516 |
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
    And User validates the status as "entered" and selects the current prescription
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_5516 |
    And User clicks delete prescription in patient order status
    And clicks delete rx button on the alert message
    Then The prescription should be deleted

  @RXQE-7411 @Joust @Regression
  Scenario: SIT | DE Optimization | Rx expiration date past default date
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
    And clicks open product button
    Then The Original date should be populated with the current date by default
    And The DAW field should be defaulted to "N" and the Substitute field should be defaulted to "Y"
    And The 'View Size' and 'View Size & Manufacturer' check boxes should be selected by default
    When The user enters a drug
      | DrugName                |
      | Glucose 4gm Chw Tablets |
    Then The system should populate the Rx expiration date by default
    Then The system verifies that the Rx Expiration Date is not older then the defaulted date
    #https://oneit.wba.com/confluence/display/RXRNWRQMTS/RXBR0005-017+Refill+for+Standard+drugs
    And The user clears and enters the Rx Expiration Date which is past the defaulted date and leaves the field (tab off)

  @RXQE-7522 @Joust @Regression
  Scenario: SIT | DE Optimization | PRN value in Refills field
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_5516 |
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
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_5516 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_5516 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_5516 |
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
    #And enters product information
    #  | InputFileName | SheetName | RowId   |
    #  | TestData      | product   | Row_one |
    Then The Original date should be populated with the current date by default
    And The DAW field should be defaulted to "N" and the Substitute field should be defaulted to "Y"
    And The 'View Size' and 'View Size & Manufacturer' check boxes should be selected by default
    When The user enters a Standard drug
      | InputFileName | SheetName | RowId         |
      | TestData      | product   | Row_RXQE-7522 |
    And The user enters a value "P45D" and leaves the refills field
    Then The system should display PRN in the Refills field
    #or P10W or P6M or PRN in Refills field and leaves the field
    When The user comes back to Refills field
    Then The 'PRN' value should still be displayed in Refills field

  @RXQE-7553 @Joust @Regression
  Scenario: SIT | DE Optimization | Drug Expiration Date default value
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
    Then The Original date should be populated with the current date by default
    And The DAW field should be defaulted to "N" and the Substitute field should be defaulted to "Y"
    And enters a Dispensed Drug with no expiration days value associated
    Then The system should calculate the Drug Expiration Date as current date plus one year substracted by one day
    #When The user clears the drug field
    And The user selects a Dispensed Drug with an expiration days value associated
    Then The system should defaults the Drug Exp Date field with the following value: 'current date + expiration days value'

  @RXQE-7554 @Joust @Regression
  Scenario: SIT | DE Optimization | Product panel collapsed in Date Entry
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
    And clicks open product button
    Then The Original date should be populated with the current date by default
    And The DAW field should be defaulted to "N" and the Substitute field should be defaulted to "Y"
    And The 'View Size' and 'View Size & Manufacturer' check boxes should be selected by default
    When The user enters all the mandatory fields in Product panel
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And The user leaves the Product panel
    Then The system should collapse the Product panel and display: Prescribed Drug, Dispensed Drug/Orange Book rating, Original Date, DAW, Qty, Refills, Directions information

  @RXQE-8477 @Joust @Regression
  Scenario: SIT | DE Optimization | DE page load - Payment panel when Payment type defaulted to Cash
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
    Then System should display "Rx will be billed to Cash" for payment as cash

  @RXQE-8478 @Joust @Regression
  Scenario: SIT | DE Optimization | DE page load - Payment panel when Payment type defaulted to Primary Plan
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
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
    And selects payment type as plan from the dropdown
    Then System should not display "Rx will be billed to Cash" for payment as plan

  @RXQE-7557 @Joust @Regression
  Scenario: SIT | DE Optimization | Payment panel collapsed in Data Entry
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
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
    Then System should display "Rx will be billed to Cash" for payment as cash
    And clicks open payment button
    And selects payment type as plan from the dropdown
    Then System should not display "Rx will be billed to Cash" for payment as plan

  @RXQE-7600 @Joust @Regression
  Scenario: SIT | DE Optimization | Add Annotation in Data Entry
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
    And User click on back button on tab bar in DE page
    And User click on front button on tab bar in DE page
    #When user click on annotation button and add a note with below text for front image on DE page
      #| RxRenewal  |
      #| Automation |
      #| Walgreens  |
      #| Deerfield  |
    #And user clicks on annotaton button and adds no text "" in note and checks the notes for front image on DE page
    #Then User check the annotations are saved in descending order
      #| Deerfield  |
      #| Walgreens  |
      #| Automation |
      #| RxRenewal  |
    When user click to rotate scanned image to right for front image on DE page
    Then user check  the scanned image rotated to right for front image on DE page
    When user click to rotate scaned image left for front image on DE page
    Then user check the image rotated left for front image on DE page
    And user click to zoom in scanned Image for front image on DE page
    Then user click on resize to original size for front image on DE page
    And user click to zoom out scanned image for front image on DE page
    Then user click on resize to original size for front image on DE page
    And User click on back button on tab bar in DE page
    When user click to rotate scanned image to right for back image on DE page
    Then user check  the scanned image rotated to right for back image on DE page
    When user click to rotate scaned image left for back image on DE page
    Then user check the image rotated left for back image on DE page
    And user click to zoom in scanned Image for back image on DE page
    Then user click on resize to original size for back image on DE page
    And user click to zoom out scanned image for back image on DE page
    Then user click on resize to original size for back image on DE page

  @RXQE-7644 @Joust @Regression
  Scenario: SIT | DE Optimization | DE page load when Add Rx selected
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
    And enters valid but a different date in to original date field
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And enters product information for RX
    And clicks open payment button
    And selects payment type
    And User clicks Add Rx button
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And validates the prescriber and product information
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |

  @RXQE-7350 @Joust @Regression
  Scenario: SIT | DE Optimization | View prescriber button
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And User clicks view button in presciber search
    Then System should display prescriber details page from DE
    And All fields in the prescriber details page from DE should be disabled

  @RXQE-7402 @Joust @Regression
  Scenario: SIT | DE Optimization | Rx expiration date based on dispensed drug and state
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one_7402 |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one_7402 |
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
      | TestData      | patient   | Row_one_7402 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one_7402 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When clicks open product button
    Then The Original date should be populated with the current date by default
    And The DAW field should be defaulted to "N" and the Substitute field should be defaulted to "Y"
    And The 'View Size' and 'View Size & Manufacturer' check boxes should be selected by default
    When user clears the drug field and enters "C2" drug
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_7402_C2 |
    Then system should disable the Rx expiration date field
    When user changes DAW to Y and Substitute to N
    Then system should disable the Rx expiration date field
    When user clears the drug field and enters "C3" drug
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_7402_C3 |
    Then system should default Rx Expiration Date to the Original date plus a configurable number of days "182" for "C3" drug
    When user changes DAW to N and Substitute to Y
    Then system should default Rx Expiration Date to the Original date plus a configurable number of days "182" for "C3" drug
    When user clears the drug field and enters "C4" drug
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_7402_C4 |
    Then system should default Rx Expiration Date to the Original date plus a configurable number of days "182" for "C4" drug
    When user changes DAW to Y and Substitute to N
    Then system should default Rx Expiration Date to the Original date plus a configurable number of days "182" for "C4" drug
    When user clears the drug field and enters "C5" drug
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_7402_C5 |
    Then system should default Rx Expiration Date to the Original date plus a configurable number of days "365" for "C5" drug
    When user changes DAW to N and Substitute to Y
    Then system should default Rx Expiration Date to the Original date plus a configurable number of days "365" for "C5" drug
    When user clears the drug field and enters "Rx" drug
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_7402_Rx |
    Then system should default Rx Expiration Date to the Original date plus a configurable number of days "365" for "Rx" drug
    When user changes DAW to Y and Substitute to N
    Then system should default Rx Expiration Date to the Original date plus a configurable number of days "365" for "Rx" drug
    When user clears the drug field and enters "OTC" drug
      | InputFileName | SheetName | RowId            |
      | TestData      | product   | Product_7402_OTC |
    Then system should default Rx Expiration Date to the Original date plus a configurable number of days "365" for "OTC" drug
    When user changes DAW to N and Substitute to Y
    Then system should default Rx Expiration Date to the Original date plus a configurable number of days "365" for "OTC" drug

  @RXQE-7302 @Joust @Regression
  Scenario: SIT | DE Optimization | Prescriber panel expand for patient with frequent prescribers
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters random patient First Name and Last Name
    And clicks search button on patient search page
    Then System should display patient search results for the random patient
    And User checks the Add New button in patient search is enabled
    When User clicks on Add New button using ALT plus A hot key
    Then System shows a popup with "You must conduct a global search before adding a new patient. Would you like to conduct a search across all stores now?" message
    And User clicks on search all stores button using ALT plus s hot key
    Then System should display patient search results for the random patient
    When User clicks on Add New button using ALT plus A hot key
    Then System should navigate to new patient registration page
    And User validates the random patient lastname,firstname and phonenumber
    Then User enters "Female" for gender field
    Then User clicks on save and exit button to complete the registration ""
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters newly registered patient Last Name in patient order status screen
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
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters newly registered patient First Name and Last Name
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters newly registered patient Last Name in patient order status screen
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When clicks open product button
    And clicks open prescriber button
    And system should display the list of frequent prescribers for the selected patient
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |

  @RXQE-7308 @Joust @Regression
  Scenario: SIT | DE Optimization | Prescriber panel expand for prescriber search criteria fields with no prescriber previously selected
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When clicks open product button
    And clicks open prescriber button
    Then system should display all prescriber search criteria fields empty apart from those that are prepopulated by default

  @RXQE-7434 @Joust @Regression
  Scenario: SIT | DE Optimization | when user performs Prescriber search in Update New Rx task
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7667 |
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
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7667 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7667 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7667 |
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
    #And User enters patient last name in POS last name text box
    #| InputFileName | SheetName | RowId         |
    #| TestData      | patient   | Row_RXQE_7667 |
    #And User enters patient phone number in POS phone number text box
    #| InputFileName | SheetName | RowId         |
    #| TestData      | patient   | Row_RXQE_7667 |
    #And clicks search button on patient order status page
    Then User validates the status as "IN PROGRESS" and selects the current prescription
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7667 |
    And Clicks on UpdateRx Btn
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    And Click on updateRx prescriber expand button
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_two |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    Then atleast one result should be displayed and highlighted
    Then user hits the Enter Key
    When displays new prescriber details in the Prescriber panel in read only mode
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_two |
    And system closes the Prescriber Search Results overlay
    And Click on updateRx prescriber expand button
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    Then atleast one result should be displayed and highlighted
    And double click on prescriber result
    When displays new prescriber details in the Prescriber panel in read only mode
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And system closes the Prescriber Search Results overlay

  @RXQE-7309 @Joust @Regression
  Scenario: SIT | DE Optimization | Prescriber panel expand for prescriber search criteria fields with no prescriber previously selected
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_Pat_Plan |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User selects a frequent prescriber
    Then the prescriber panel should be collapsed
    When clicks open prescriber button
    Then system should populate Last Name and First Name search criteria fields with the details of the previously selected prescriber
    And system does not display a list of frequent prescribers in the Prescriber panel

  @RXQE-7179 @Joust @Regression
  Scenario: SIT | DE Optimization | Data Entry Page Load for a Patient with no Frequent Prescribers
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters random patient First Name and Last Name
    And clicks search button on patient search page
    Then System should display patient search results for the random patient
    And User checks the Add New button in patient search is enabled
    When User clicks on Add New button using ALT plus A hot key
    Then System shows a popup with "You must conduct a global search before adding a new patient. Would you like to conduct a search across all stores now?" message
    And User clicks on search all stores button using ALT plus s hot key
    Then System should display patient search results for the random patient
    When User clicks on Add New button using ALT plus A hot key
    Then System should navigate to new patient registration page
    And User validates the random patient lastname,firstname and phonenumber
    Then User enters "Female" for gender field
    And User clicks on next button using Alt plus N hot key
    Then User is on clinical information section
    And Selects confirm with patient radio button
    And User clicks on next button using Alt plus N hot key
    Then user is on additional medications section
    And selects no button for additional medication
    And User clicks on next button using Alt plus N hot key
    Then User is on third party plans section
    And selects no plan or cash button for third party plans
    And User clicks on next button using Alt plus N hot key
    Then user is on preferences section
    And selects snap cap for preferences
    Then User clicks on save and exit button to complete the registration ""
    Then user should see patient profile page
    When user hits ctrl plus h
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters newly registered patient First Name and Last Name
    And clicks search button on patient search page
    Then System should display patient search results
    #And user click on global search icon
    #When User enters newly registered patient First Name and Last Name
    #And clicks search button on patient search page
    #Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters newly registered patient Last Name in patient order status screen
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    And The name of the Patient should be displayed as a hyperlink
    And The system should display the prescriber search criteria fields and Search button
    And system does not display a list of frequent prescribers in the Prescriber panel

  @RXQE-7310 @Joust @Regression
  Scenario: SIT | DE Optimization | Prescriber panel expand with prescriber search criteria previously entered
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | Row_Joust_Plan |
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
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | Row_Joust_Plan |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | Row_Joust_Plan |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    When clicks open product button
    And clicks open prescriber button
    Then The system should display the previously entered prescriber search criteria
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |

  @RXQE-7305 @Joust @Regression
  Scenario: SIT | DE Optimization | Prescriber panel expand for patient with no frequent prescribers
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters random patient First Name and Last Name
    And clicks search button on patient search page
    Then System should display patient search results for the random patient
    And User checks the Add New button in patient search is enabled
    When User clicks on Add New button using ALT plus A hot key
    Then System shows a popup with "You must conduct a global search before adding a new patient. Would you like to conduct a search across all stores now?" message
    And User clicks on search all stores button using ALT plus s hot key
    Then System should display patient search results for the random patient
    When User clicks on Add New button using ALT plus A hot key
    Then System should navigate to new patient registration page
    And User validates the random patient lastname,firstname and phonenumber
    Then User enters "Female" for gender field
    Then User clicks on save and exit button to complete the registration ""
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters newly registered patient Last Name in patient order status screen
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    And system does not display a list of frequent prescribers in the Prescriber panel
    When clicks open product button
    And clicks open prescriber button
    And system does not display a list of frequent prescribers in the Prescriber panel

    @RXQE-7492 @Joust @Regression
  	Scenario: SIT | DE Optimization | Perform Update New Rx for a patient that has Coupon plan that has no Expiration date and attached to a drug
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan_1 |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan_1 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan_1 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan_1 |
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
    #And selects payment type as plan
    Then system should display the coupon plan in payment plan with message
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    Then User validates the status as "In Progress" and selects the current prescription
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    And clicks open payment button
    And Validate message 

  

  @RXQE-7374 @Joust @Regression
  Scenario: SIT | DE Optimization | Prescriber panel tab order when frequent prescriber list is displayed
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | Row_Joust_Plan |
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
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | Row_Joust_Plan |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | Row_Joust_Plan |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    And system should display the list of frequent prescribers for the selected patient
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And the focus should be on the first row of the Frequent Prescriber list
    And User verifies tab order in prescriber section when frequent prescriber is present

  @RXQE-7386 @Joust @Regression
  Scenario: SIT | DE Optimization | Prescriber panel tab order when no frequent prescriber list is displayed
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters random patient First Name and Last Name
    And clicks search button on patient search page
    Then System should display patient search results for the random patient
    And User checks the Add New button in patient search is enabled
    When User clicks on Add New button using ALT plus A hot key
    Then System shows a popup with "You must conduct a global search before adding a new patient. Would you like to conduct a search across all stores now?" message
    And User clicks on search all stores button using ALT plus s hot key
    Then System should display patient search results for the random patient
    When User clicks on Add New button using ALT plus A hot key
    Then System should navigate to new patient registration page
    And User validates the random patient lastname,firstname and phonenumber
    Then User enters "Female" for gender field
    Then User clicks on save and exit button to complete the registration ""
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters newly registered patient Last Name in patient order status screen
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    And system does not display a list of frequent prescribers in the Prescriber panel
    And the focus should be on the Phone number field
    And User verifies tab order in prescriber section when frequent prescriber is not present

  @RXQE-7665 @Joust @Regression
  Scenario: SIT | DE Optimization | Product panel tab order when the Product panel is expanded and a Dispensed drug has been selected
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7665 |
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
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7665 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7665 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7665 |
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
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_RowFive |
    And clicks open payment button
    And clicks open product button
    #When I click TAB key
    Then I should be on "Original Date" field
    When I click TAB key
    #When I click TAB key from "Original Date" field
    Then I should be on "DAW" field
    When I click TAB key
    #When I click TAB key from "DAW" field
    Then I should be on "Substitute" field
    When I click TAB key
    #When I click TAB key from "Substitute" field
    Then I should be on "Prescribed Drug" field
    When I click TAB key
    #When I click TAB key from "Prescribed Drug" field
    Then I should be on "change" field
    When I click TAB key
    #When I click TAB key from "change" field
    #Then I should be on "Drug Exp Date" field
    #When I click TAB key
    #When I click TAB key from "Drug Exp Date" field
    Then I should be on "Qty" field
    When I click TAB key
    #When I click TAB key from "Qty" field
    Then I should be on "Qty Disp" field
    When I click TAB key
    #When I click TAB key from "Qty Disp" field
    Then I should be on "Rx Expiration Date" field
    When I click TAB key
    #When I click TAB key from "Rx Expiration Date" field
    Then I should be on "Directions" field
    When I click TAB key
    #When I click TAB key from "Directions" field
    Then I should be on "Days Supply" field
    When I click TAB key
    #When I click TAB key from "Days Supply" field
    Then I should be on "Refills" field

  @RXQE-7697 @Joust @Regression
  Scenario: DE Optimization | Verify the "payment type cash" message is displayed when Update Rx page loads and user collapses the payment panel
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
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And clicks Finish button to complete Data Entry with product plan
    And System should display patient order status page
    And clicks search button on patient order status page
    Then User validates the status as "In Progress" and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    Then Rx will be billed to Cash message should be displayed in Product panel
    When user expands payment panel and collapses
    Then Rx will be billed to Cash message should be displayed in Product panel

    @RXQE-7701 @Joust @regression
    Scenario: DE Optimization | Verify the "payment type cash" message is displayed when user modifies payment type and collapses payment panel
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
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
    And clicks Finish button to complete Data Entry with product
    And System should display patient order status page
    And clicks search button on patient order status page
    Then User validates the status as "In Progress" and selects the current prescription
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    Then Rx will be billed to plan id message should be displayed in Product panel
    When user modifies payment type to cash and collapses the payment panel
    Then Rx will be billed to Cash message should be displayed in Product

  @RXQE-7702 @Joust @Regression
  Scenario: DE Optimization | Verify the "payment type Plan" message is displayed when Update Rx page loads and user collapses payment panel
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
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
    And clicks Finish button to complete Data Entry with product plan
    And System should display patient order status page
    And clicks search button on patient order status page
    Then User validates the status as "In Progress" and selects the current prescription
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    Then Rx will be billed to plan id message should be displayed in Product panel
    When user expands payment panel and collapses
    Then Rx will be billed to plan id message should be displayed in Product panel

  

  @RXQE-7483 @Joust @Regression
  Scenario: DE Optimization | Max number of Refills
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
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
    And The 'View Size' and 'View Size & Manufacturer' check boxes should be selected by default
    And enters product information with C2 drug
      | InputFileName | SheetName | RowId             |
      | TestData      | product   | Row_Joust_C2_Drug |
    And enters product information with C3 drug
      | InputFileName | SheetName | RowId             |
      | TestData      | product   | Row_Joust_C3_Drug |
    And enters product information with C4 drug
      | InputFileName | SheetName | RowId             |
      | TestData      | product   | Row_Joust_C4_Drug |
    And enters product information with C5 drug
      | InputFileName | SheetName | RowId             |
      | TestData      | product   | Row_Joust_C5_Drug |
    And enters product information with RX Drug Name
      | InputFileName | SheetName | RowId             |
      | TestData      | product   | Row_Joust_Rx_Drug |
    And enters product information with RX Drug Name and OTC drug
      | InputFileName | SheetName | RowId              |
      | TestData      | product   | Row_Joust_OTC_Drug |
    And enters product information with C3 drug with error message
      | InputFileName | SheetName | RowId                  |
      | TestData      | product   | Row_Joust_C3_ErrorDrug |
    And enters product information with C4 drug with error message
      | InputFileName | SheetName | RowId                  |
      | TestData      | product   | Row_Joust_C4_ErrorDrug |
    And enters product information with C5 drug with error message
      | InputFileName | SheetName | RowId                  |
      | TestData      | product   | Row_Joust_C5_ErrorDrug |

  @RXQE-7712 @Joust @Regression
  Scenario: DE Optimization | Max number of refills allowed in Data Review screen
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | Row_Joust_Plan |
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
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | Row_Joust_Plan |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | Row_Joust_Plan |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | Row_Joust_Plan |
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
      | InputFileName | SheetName | RowId               |
      | TestData      | product   | Row_Joust_RXQE-7712 |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | Row_Joust_Plan |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks open update button in product
    And clears Refills data and modifies the Refills value
      | InputFileName | SheetName | RowId                  |
      | TestData      | product   | Row_Joust_C3_ErrorDrug |
    Then system displays the following error message as Number of refills not allowed
    And clears Refills data and modifies the Refills value
      | InputFileName | SheetName | RowId                  |
      | TestData      | product   | Row_Joust_C4_ErrorDrug |
    Then system displays the following error message as Number of refills not allowed

  @RXQE-7074 @Joust @Regression
  Scenario: SIT | DE Optimization | View Patient Med History Light Box
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7054 |
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
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7054 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7054 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7054 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    And click on patient hyperlink
    And validate the displayed patient profile
    #And click on comments
    #And validate the comments popup
    And click on MedHistory tab
    And valides the focus is on RX history
    And validates the history is in read only
    And validates the close and X fields
    And click on Additional medication tab
    And validates the fields
    And click on Close button
    Then Sytem should display data entry page

  @RXQE-7051 @Joust @Regression
  Scenario: SIT | DE Optimization | Bucket of Failures Preview | Notify User of Annotation failure during DE
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
    #Commented steps not in scope for Joust
    #When User adds annotation to an Rx image during Data Entry and RxMS fails to send annotation to IC+
    When the user clicks on the notification alert icon
    Then the system opens the failure preview

 @RXQE-7531 @Joust @Regression
  Scenario: SIT | DE Optimization | Perform Update New Rx | Modify Rx Expiration Date or entered PXXXY in the Refills field for C2 drug
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
      | TestData      | patient   | Row_one_7402 |
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
      | TestData      | patient   | Row_one_7402 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one_7402 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one_7402 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information with C2 drug in de
      | InputFileName | SheetName | RowId             |
      | TestData      | product   | Row_Joust_C2_7531 |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    Then User validates the status as "In Progress" and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one_7402 |
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    And user verifies Rx Expiration Date in updateRX c2 drug
    When user verifies Refills field in updateRX c2 drug

 

  @RXQE-7202 @Joust @Regression
  Scenario: SIT | DE Optimization | Data Entry page load for a patient who has multiple frequent prescribers
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
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    And system should display the list of frequent prescribers for the selected patient
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And the focus should be on the first row of the Frequent Prescriber list
    And The system should display the prescriber search criteria fields and Search button
    When User selects a frequent prescriber
    Then the prescriber panel should be collapsed
    And displays new prescriber details in the Prescriber panel in read only mode
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    When clicks open prescriber button
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search button on prescriber search
    When User double clicks on a prescriber from results
    Then the prescriber panel should be collapsed

   @RXQE-7625 @Joust @Regression
  Scenario: SIT | DE Optimization | Navigation between panels using Tab in Data Entry
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7054 |
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
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7054 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7054 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    Then focus should be on username field or on the first row of the frequent prescriber list
    When User tabs off last field in "prescriber" panel
    And System should collapse "prescriber" panel
    Then the focus should be on first selectable element in "product" panel
    When User tabs off last field in "product" panel
    And System should collapse "product" panel
    Then the focus should be on first selectable element in "payment" panel
    When User shift tabs off first field in "payment" panel
    And System should collapse "payment" panel
    Then the focus should be on first selectable element in "product" panel
    When User shift tabs off the first field of product panel
    Then focus should be on username field or on the first row of the frequent prescriber list 
     When User shift tabs off the first field of prescriber panel
     Then focus should be shifted to patient name hyperlink or back button if hyperlink does not exist

  @RXQE-7631 @Joust @Regression
  Scenario: SIT | DE Optimization | Check if the system advises user if the entered Qty Disp is greater than the Total Prescribed Quantity
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7628 |
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
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7628 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7628 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7628 |
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
    And enters product information and check the disp quantity is greater than quantity
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_RowFive |
    And enter the refills fields and check the qty disensed
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_RowFive |
    And Clear fields and enter refills first and then qty dispensed
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_RowFive |

  @RXQE-7615 @Joust @Regression
  Scenario: SIT | DE Optimization | Patient hyperlink in Data Entry, Data Review and Update New Rx
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | Row_patient_auto |
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
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | Row_patient_auto |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | Row_patient_auto |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | Row_patient_auto |
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
    And clicks Finish button to complete Data Entry with product plan
    And System should display patient order status page
    And clicks search button on patient order status page
    Then User validates the status as "In Progress" and selects the current prescription
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | Row_patient_auto |
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    When User clicks on Patient name hyperlink in Update Rx page
    Then System displays Patient Profile light box
    And The focus should be on the 'General Info' tab
    And the Information in all tabs should displayed in read only mode

  @RXQE-7085 @Joust @Regression
  Scenario: SIT | DE Optimization | View Patient Preferences Light Box
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7085 |
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
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7085 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7085 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7085 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User clicks on Patient hyperlink
    Then System displays Patient Profile light box
    And User click the Preference Tab
    When System displays the Preferences information in read only mode
    And System displays Close button and X button and does not display the Update button
    When User clicks on close button or X button
    Then system closes the View Patient light box and navigates the user back to the previous screen
    When User clicks on Patient hyperlink
    When user clicks ALT+P hot key
    Then Preferences tab should be open
    And user clicks on ALT+C hot key
    Then system closes the View Patient light box and navigates the user back to the previous screen

  @RXQE-7054 @Joust @Regression
  Scenario: SIT | DE Optimization | View Patient Additional Medications Light Box
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7054 |
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
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7054 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7054 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7054 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    And click on patient hyperlink
    And validate the displayed patient profile
    And click on MedHistory tab
    And click on Additional medication tab
    And validates the fields
    And validates the close and X fields
    And click on Close button
    Then Sytem should display data entry page

  @RXQE-7056 @Joust @Regression
  Scenario: SIT | DE Optimization | View Patient Clinical History Light Box
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId                        |
      | TestData      | patient   | Row_patient_Clinical_history |
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
      | InputFileName | SheetName | RowId                        |
      | TestData      | patient   | Row_patient_Clinical_history |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId                        |
      | TestData      | patient   | Row_patient_Clinical_history |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId                        |
      | TestData      | patient   | Row_patient_Clinical_history |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    #And click on patient hyperlink
    And User clicks on patient hyperlink in DE page
    And validate the displayed patient profile
    And click on Clinical history tab
    And validates the close and X fields
    #And checks clinical history is in read only mode
    And click on clinical history drop down
    And check the service type as label
    And click on Close button
    Then Sytem should display data entry page

  @RXQE-7148 @Joust @Regression
  Scenario: SIT | DE Optimization | View Prescriber Profile in Update New RxGiven User launches the RxMS desktop application
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
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
    Then User validates the status as "In Progress" and selects the current prescription
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    And Click on updateRx prescriber expand button
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And User clicks view button in presciber search
    Then User should see the prescriber information
    And System should display close and X button
    And System should focus on first row in prescriber location results
    And User clicks on X button to close
    And System brings the user back to the Data Entry screen as it was before the Prescriber Profile was opened
    And User clicks view button in presciber search
    Then User should see the prescriber information
    And System should focus on first row in prescriber location results
    And User clicks on close button using ALT plus C hot key
    And System brings the user back to the Data Entry screen as it was before the Prescriber Profile was opened
    And User clicks view button in presciber search
    Then User should see the prescriber information
    And System should focus on first row in prescriber location results
    And User clicks tab key
    Then the focus should be on close button
    And User clicks tab key
    Then the focus should be on X button

  @RXQE-7140 @Joust @Regression
  Scenario: SIT | DE Optimization | View Prescriber Profile in Data Entry
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And User clicks view button in presciber search
    Then User should see the prescriber information
    And System should display close and X button
    And System should focus on first row in prescriber location results
    And User clicks on X button to close
    And System brings the user back to the Data Entry screen as it was before the Prescriber Profile was opened
    And User clicks view button in presciber search
    Then User should see the prescriber information
    And System should focus on first row in prescriber location results
    And User clicks on close button using ALT plus C hot key
    And System brings the user back to the Data Entry screen as it was before the Prescriber Profile was opened
    And User clicks view button in presciber search
    Then User should see the prescriber information
    And System should focus on first row in prescriber location results
    And User clicks tab key
    Then the focus should be on close button
    And User clicks tab key
    Then the focus should be on X button

  @RXQE-7100 @Joust @Regression
  Scenario: Verify the 3rd party plans of a patient in a light box so that the prescription can be dispensed to the right patient.
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_RXQE-7100 |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_RXQE-7100 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_RXQE-7100 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_RXQE-7100 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    And User clicks on patient hyperlink in DE page
    And User should see patient profile light box
    And User Clicks on the third Party Plans tab
    Then System displays 3rd Party Plans in read only mode
    And 3rd Party Plans Screen should have close button and X button and the Update button is not displayed
    And user clicks on close button in patient light box
    Then The system closes the View Patient light box and navigates the user back to the screen previous screen
    And User clicks on patient hyperlink in DE page
    And User should see patient profile light box
    And User Clicks on the third Party Plans tab
    Then System displays 3rd Party Plans in read only mode
    And user clicks on X button in patient profile light box
    Then The system closes the View Patient light box and navigates the user back to the screen previous screen
    And User Clicks on the third Party Plans tab
    Then System displays 3rd Party Plans in read only mode
    And User clicks on third party plans tab using  ALT plus 3 hot key from keyboard
    Then System displays 3rd Party Plans in read only mode
    And user clicks on close button in patient light box ALT plus C hot key from keyboard
    Then The system closes the View Patient light box and navigates the user back to the screen previous screen
    And User clicks on patient hyperlink in DE page
    And User should see patient profile light box
    And User Clicks on the third Party Plans tab
    Then System displays 3rd Party Plans in read only mode
    #And User clicks tab key in third party plans
    #And focus should be on third party plans Close button
    #And User clicks tab key in third party plans
    #Then focus should be on third party plans X button
		And user clicks on close button in patient light box ALT plus C hot key from keyboard
    Then Sytem should display data entry page

  @RXQE-7142 @Joust @Regression
  Scenario: SIT | DE Optimization | View Patient General Info Light Box
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_RXQE-7100 |
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_RXQE-7100 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_RXQE-7100 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_RXQE-7100 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    And User clicks on patient hyperlink in DE page
    And User should see patient profile light box
    And User Clicks on the third Party Plans tab
    Then System displays 3rd Party Plans in read only mode
    And 3rd Party Plans Screen should have close button and X button and the Update button is not displayed
    And user clicks on general info tab to view patient General Info
    And system should display the Patient General Info tab
    #And user clicks on X button in patient profile light box
    And user clicks on close button in patient light box ALT plus C hot key from keyboard
    Then The system closes the View Patient light box and navigates the user back to the screen previous screen
    And User clicks on patient hyperlink in DE page
    And User should see patient profile light box
    And User Clicks on the third Party Plans tab
    And User clicks on general info tab using ALT plus G hot key
    And system should display the Patient General Info tab
    And User clicks on close button in patient general info using ALT plus C hot key
    Then The system closes the View Patient light box and navigates the user back to the screen previous screen

  @RXQE-7192 @Joust @Regression
  Scenario: SIT | DE Optimization | Data Entry Page Load for a Patient with only one frequent prescriber on the file
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_Pat_New |
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
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_Pat_New |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_Pat_New |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_Pat_New |
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
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_Pat_New |
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
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_Pat_New |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_Pat_New |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_Pat_New |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    And The system should display the prescriber search criteria fields and Search button underneath the frequent prescribers list
    And User selects frequent prescriber using enter key on keyboard
    And clicks open prescriber button
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And User selects prescriber using enter key on keyboard
    And The system should collapses the Prescriber panel displaying the prescriber information in read only mode and expands the Product panel

  @RXQE-7571 @Joust @Regression
  Scenario: DE Optimization | No coupon message shows when patient has an expired coupon plan
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7571 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks on Third Party Plan tab with coupon
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7571 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7571 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7571 |
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
    Then System should display following message in the expanded Payment Panel "This patient might have a coupon for this prescription"
    And selects payment type
    And clicks Finish button to complete Data Entry

  @RXQE-7670 @Joust @Regression
  Scenario: DE Optimization | Payment panel tab order in Data Entry
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | Row_Joust_Plan |
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
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | Row_Joust_Plan |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | Row_Joust_Plan |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | Row_Joust_Plan |
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
    And user perform tab order from payment panel without paycode dropdown
    And User performs arrows on side by side

  @RXQE-7664 @Joust @Regression
  Scenario: DE Optimization | Product panel tab order when the Product panel is expanded and a Dispensed drug has not been selected
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
    And user select product and perform tab order

    @RXQE-7704 @Joust @Regression
  Scenario: DE Optimization | Verify the "payment type plan" message is displayed when user modifies payment type and collapses the payment panel
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId      								  |
      | TestData      | patient   | Row_couponplanNoDrugEXPIRED |
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
      | InputFileName | SheetName | RowId        								|
      | TestData      | patient   | Row_couponplanNoDrugEXPIRED |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        								|
      | TestData      | patient   | Row_couponplanNoDrugEXPIRED |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        								|
      | TestData      | patient   | Row_couponplanNoDrugEXPIRED |
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
    Then User validates the status as "entered" and selects the current prescription
      | InputFileName | SheetName | RowId        								|
      | TestData      | patient   | Row_couponplanNoDrugEXPIRED |
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    Then Rx will be billed to cash message should be displayed on update rx page
    When user modifies payment type to plan and collapses the payment panel
    Then Rx will be billed to plan id message should be displayed in Product panel

@RXQE-7520 @Joust @Regression
  Scenario: SIT | DE Optimization | Perform Update New Rx for a patient that has Coupon plan assosciated to Expiration date passed and not attached to a drug
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   														|
      | TestData      | patient   | Row_couponPlanExpirationDatePast	  |
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
      | InputFileName | SheetName | RowId   										     |
      | TestData      | patient   | Row_couponPlanExpirationDatePast |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   										     |
      | TestData      | patient   | Row_couponPlanExpirationDatePast |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId  								   	 		  |
      | TestData      | patient   | Row_couponPlanExpirationDatePast|
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
    #Then System should display the following message in the expanded Payment Panel "This patient might have a coupon for this prescription"
    #And selects payment type as plan
    And selects payment type as plan
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks open payment button
    And the system does not display any message in the expanded Payment panel

@RXQE-7709 @Regression
  Scenario: DE Optimization | Max number of refills allowed in Update Rx screen
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   										|
      | TestData      | patient   | Row_couponplanNoDrugEXPIRED |
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
      | InputFileName | SheetName | RowId   										|
      | TestData      | patient   | Row_couponplanNoDrugEXPIRED |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   										|
      | TestData      | patient   | Row_couponplanNoDrugEXPIRED |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   										|
      | TestData      | patient   | Row_couponplanNoDrugEXPIRED |
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
      | InputFileName | SheetName | RowId   										|
      | TestData      | patient   | Row_couponplanNoDrugEXPIRED |
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
      | InputFileName | SheetName | RowId   										|
      | TestData      | patient   | Row_couponplanNoDrugEXPIRED |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   										|
      | TestData      | patient   | Row_couponplanNoDrugEXPIRED |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And clicks select all for therapy review
    And clicks Override in CE screen
    Then System should display patient order status page
    And User clicks search button on patient order status
    Then User validates the status as "entered" and selects the current prescription
      | InputFileName | SheetName | RowId   										|
      | TestData      | patient   | Row_couponplanNoDrugEXPIRED |
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
     And enters product information with C3 drug with error message
      | InputFileName | SheetName | RowId                  	|
      | TestData      | product   | Row_Joust_C3_ErrorDrug1 |
    And enters product information with C3 drug with error message
      | InputFileName | SheetName | RowId                  |
      | TestData      | product   | Row_Joust_C3_ErrorDrug |

 @RXQE-7563 @Regression
  Scenario: DE Optimization | Coupon message when coupon plan with an expiration date not passed
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

 @RXQE-7569 @Regression
  Scenario: DE Optimization | Coupon message when coupon plan with no expiration date
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    #use a patient that has couplan plan with no expiration date but drug associated
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        					|
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
      | InputFileName | SheetName | RowId        					|
      | TestData      | patient   | Row_patientwithCoupon |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        					|
      | TestData      | patient   | Row_patientwithCoupon |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        					|
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
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId               |
      | TestData      | product   | Row_Joust_RXQE-7569 |
    And clicks open payment button
    Then System should display the following message in the expanded Payment Panel "This patient might have a coupon for this prescription"
    And selects payment type
    And clicks Finish button to complete Data Entry
