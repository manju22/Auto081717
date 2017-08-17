@RxMSSmokeTestSuite
Feature: Smoke Test

  @PrescriptionFulfillmentSmoke
  Scenario: This flow includes Login=>patient search=>Prescription Intake=>Data Entry=>Data Review=>Clinical Evaluation=>Patient order status
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
    And clicks select all for therapy review
    And clicks Override in CE screen
    Then System should display patient order status page
    And User clicks search button on patient order status
    And The prescription status should be In Progress -Reviewed
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then A filling task should get created in the taskboard
    When User clicks filling in the taskboard
    And The system should display a message Use - the Mobile Device to complete Filling
    And User closes the application

  @drugSearchSmoke
  Scenario: Drug search using durg name and validating results
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks drug search in left side menu
    Then System should display drug search page
    When User enters drug name in text box labeled drug name
      | InputFileName | SheetName | RowId   |
      | TestData      | drug      | Row_one |
    And clicks search button on drug search page
    Then System should display the drug results
      | InputFileName | SheetName | RowId   |
      | TestData      | drug      | Row_one |
    And User closes the application

  @payorSearchSmoke
  Scenario: Payor search using plan name and validating results
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks plan search button in left side menu
    Then System should display plan search page
    When User enters plan name in the text box labeled plan name
      | InputFileName | SheetName | RowId   |
      | TestData      | plan      | Row_one |
    And clicks search button on plan search page
    Then plan results should be displayed
      | InputFileName | SheetName | RowId   |
      | TestData      | plan      | Row_one |
    And User closes the application

  @prescriberSearchSmoke
  Scenario: Prescriber search using prescriber first and last names and validating the results
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks prescriber search in left side navigation menu
    Then System should display prescriber search page
    When User enters prescriber first name and last name on prescriber search page
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search on prescriber search page
    Then prescriber search results should be displayed
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User closes the application

  @LogoutSmoke
  Scenario: Logout functionality of RxMS application
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks log out button in left side navigation menu
    Then System should display an alert message asking for this device or all devices
    When User clicks this device on the logout alert
    Then System should display the login page
    And User closes the application

  @HotKeysSmoke
  Scenario: verification of Hot Keys from Dashboard to navigate to Patient search page, Drug search page, Prescriber search page, patient order status, payor search, DE, DR, CE and PV
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User hits ctrl plus p hot key
    Then System should navigate to patient search page
    When User hits ctrl plus d hot key
    Then System should display drug search page
    When User hits ctrl plus r hot key
    Then System should display prescriber search page
    When User hits ctrl plus l hot key
    Then System should display plan search page
    When User hits ctrl plus s hot key
    Then System should display patient order status page
    When User hits ctrl plus h hot key
    Then System should display RxMS home page
    When User hits ctrl plus one hot key
    Then System should navigate to DE screen or System shows a pop-up if there are no DE tasks
    When User hits ctrl plus two hot key
    Then System should navigate to DR screen or System shows a pop-up if there are no DR tasks
    When User hits ctrl plus three hot key
    Then System should navigate to CE screen or System shows a pop-up if there are no CE tasks
    When User hits ctrl plus four hot key
    Then System should navigate to PV screen or System shows a pop-up if there are no PV tasks
    When User hits ctrl plus h hot key
    Then System should display RxMS home page
    When User hits ctrl plus o hot key
    Then System should display an alert message asking for this device or all devices
    When User hits alt plus t hot key
    Then System should display the login page
    And User closes the application

  @roleBasedPrescriptionfulfillment
  Scenario: This scenario validates functionality of technician and pharmacist roles in prescription fulfillment => Technicican - Intake,DE => Pharmacist - DR, CE
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId    |
      | TestData      | login     | Row_TECH |
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
    When User hits ctrl plus o hot key
    Then System should display an alert message asking for this device or all devices
    When User clicks this device on the logout alert
    Then System should display the login page
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    And User clicks patient order status button in navigation panel
    Then System should display patient order status page
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    #And User enters patient phone number in POS phone number text box
      #| InputFileName | SheetName | RowId   |
      #| TestData      | patient   | Row_one |
    And User clicks search button on patient order status
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
    And clicks select all for therapy review
    And clicks Override in CE screen
    Then Number of CE tasks should be decreased by one
    Then System should display patient order status page
    And User clicks search button on patient order status
    And The prescription status should be In Progress -Reviewed
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then A filling task should get created in the taskboard
    When User clicks filling in the taskboard
    And The system should display a message Use - the Mobile Device to complete Filling
    
    @addNewPatient
  Scenario: This scenario will create a new patient
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters random patient First Name and Last Name
    And clicks search button on patient search page for failure
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
    And user click on global search icon
    When User enters newly registered patient First Name and Last Name
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    Then System should display RxMS home page
    When User navigates to patient order status
    And User enters newly added patient last name and phone number in POS
    And User clicks search button on patient order status
    And User validates the status as "pending" and selects the current prescription and validate newly created lastname
    And User clicks delete prescription in patient order status
     And clicks delete rx button on the alert message
    Then The prescription should be deleted
    
    
    
