@Perf_IkariWarriors
Feature: Ikariwarriors
Scenario: PerfTest For Ikari Warriors
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
    Then User clicks on save and exit button to complete the registration "add"
    Then user click on the update button to update patient information
    Then user enter approximate weight to update
    Then User clicks on save and exit button to complete the registration "update"
   	#Then user should see patient profile page
    When User hits ctrl plus h hot key
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters newly registered patient First Name and Last Name
    And clicks search button on patient search page
    Then System should display patient search results
    And user click on global search icon
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And clicks search button on patient search page for failure
    When User enters newly registered patient First Name and Last Name
    And clicks search button on patient search page for global search
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