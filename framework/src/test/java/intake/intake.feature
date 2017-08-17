@intake @Regressiontest
Feature: Intake

  #@RXAPPD-12628
  #Scenario: Verify that the in Patient search results,Update and Add buttons
  #	 Given User launches the RxMS desktop application
  #When User enters the valid credentials in login text fields
  #| InputFileName | SheetName | RowId   |
  #| TestData  | login     | Row_PH |
  #And User clicks login button
  #Then System should display RxMS home page
  #When User clicks on patient tab in left side menu
  #Then System should navigate to patient search page
  #When User enters patient First Name and Last Name
  #| InputFileName | SheetName | RowId   |
  #| TestData  | patient   | Row_Intake_1 |
  #And clicks search button on patient search page
  #Then System should display patient search results
  #	Then User able to see hidden buttons AddNew and Update
  #@RXQE_2230 @E2E
  #Scenario: View task board - TAB Sequence and HOT keys
  #Tab sequence steps are not working as the steps
  #Given User launches the RxMS desktop application
  #When User enters the valid credentials in login text fields
  #		| InputFileName | SheetName    | RowId    |
  #		| TestData    | login | Row_ADMIN |
  #And I click on login buton
  #Then System should display RxMS home page
  #Then User able to see following task board
  #|Data Entry|
  #|Data Review|
  #|Clinical Evaluaion|
  #|Product Verification|
  #When User hits ctrl plus one hot key
  #Then System should navigate to DE screen or System shows a pop-up if there are no DE tasks
  #When User hits ctrl plus two hot key
  #When User hits ctrl plus two hot key
  #Then System should navigate to DR screen or System shows a pop-up if there are no DR tasks
  #When User hits ctrl plus three hot key
  #Then System should navigate to CE screen or System shows a pop-up if there are no CE tasks
  #When User hits ctrl plus four hot key
  #Then System should navigate to PV screen or System shows a pop-up if there are no PV tasks
  #When User hits ctrl plus h hot key
  #When User hits ctrl plus o hot key
  #Then System should display the login page
  #And user should following the sequence tab
  #When user hits tab
  #Then system should navigate to Data Entry
  #When user hits tab
  #Then system should navigate to Data Review
  #When user hits tab
  #Then system should navigate to Clinical Evaluation
  #When user hits tab
  #Then system should navigate to Product Verification
  #pending at last step to execute
  #@RXAPPD-10750
  #Scenario: Verify that the system closes correctly the linked page of General Drug References for general Product
  #Given User launches the RxMS desktop application
  #When User enters the valid credentials in login text fields
  #| InputFileName | SheetName | RowId   |
  #| TestData  | login     | Row_PH |
  #And User clicks login button
  #When User clicks drug search in left side menu
  #Then System should display drug search page
  #When User enters drug name in text box labeled drug name
  #| InputFileName | SheetName | RowId  |
  #| TestData    | drug | Row_Intake_1 |
  #And clicks search button on drug search page
  #Then System should display the drug results
  #| InputFileName | SheetName | RowId   |
  #| TestData  | drug      | Row_Intake_2 |
  #And user click on Clinical References
  #Then system displays correctly Genereal Drug References for generic Product
  #And clicks on logos with an internet link
  #Then system opens the related URL in the application frame passing
  #Then clicks on logos with an internet link
  #And clicks on close 'X' button
  #Then system opens General Drug References pop up
  @RXAPPD-10745 @Regression @OnlyIntake
  Scenario: Verify that the System allows to close the Clinical References window
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    When User clicks drug search in left side menu
    Then I enter Drug NDC number on search feild
      | InputFileName | SheetName   | RowId        |
      | TestData      | Product-NDC | Row_Intake_1 |
    And clicks search button on drug search page using ALT plus S hot key
    And I able to see the drug NDC on drug search results
    And user click on Clinical References
    Then system displays correctly Genereal Drug References for generic Product
    When I click on left keyword arrow
    Then System should display drug search page

  @RXAPPD-10734 @Regression @OnlyIntake 
  Scenario: Verify that the system shows the Product General Info tab in Drug Details screen
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    When User clicks drug search in left side menu
    Then I enter Drug Quick Code on search feild
      | InputFileName | SheetName     | RowId        |
      | TestData      | Product-Quick | Row_Intake_1 |
    And clicks search button on drug search page
    Then I able to see the Quick Code on drug search results
    And shows the Product General Info tab

  @RXAPPD-10729 @Regression @OnlyIntake 
  Scenario: Verify that the system allows the user to search for the product
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    When User clicks drug search in left side menu
    Then I enter Minimum Criteria Drug name on search feild
      | InputFileName | SheetName | RowId        |
      | TestData      | drug      | Row_Intake_3 |
    And clicks search button on drug search page
    Then I able to see product that matches with the search criteria entered
      | InputFileName | SheetName | RowId        |
      | TestData      | drug      | Row_Intake_3 |

  #@RXAPPD-15288
  #Scenario: Search for a Team Member with a wrong Employee ID - FAILURE
  #Given User launches the RxMS desktop application
  #When User enters the valid credentials in login text fields
  #| InputFileName | SheetName | RowId   |
  #| TestData  | login     | Row_PH |
  #And User clicks login button
  #When I click on "Admin Button" from left side menu
  #Then I should see "Role Management" navigation link
  #Then I should see "User Management" navigation link
  #Then I enter employeeID on user management feild and i will click on search
  #| InputFileName | SheetName | RowId  |
  #| TestData  | Role-Info | Row_Intake_1 |
  #Then User able to see error message No results found
  #@RXAPPD-11739
  #Scenario: Verify that the system brings the user to User Management screen
  #Given User launches the RxMS desktop application
  #When User enters the valid credentials in login text fields
  #| InputFileName | SheetName | RowId   |
  #| TestData  | login     | Row_PH |
  #And User clicks login button
  #When user click on task board it will expand
  #When I click on "Admin Button" from left side menu
  #Then User Management by deafult it will be highlited
  #When I click on "Role Management" from left side menu
  #Then I should see "Add" Button
  #And I should see the "Update" Button
  #And I should see the "Delete" Button
  #AKEESA7 Start
  @maintainLocation @RXAPPD-9137 @RXAPPD-11775 @Regression @OnlyIntake 
  Scenario: View Pharmacy Information - The System displays the Store elements Pharmacy Information
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then I see the landing page
    And I verify for pharmacy information
      | InputFileName | SheetName            | RowId        |
      | TestData      | Pharmacy_Information | Row_Intake_1 |

  @maintainLocation @RXAPPD-9149 @Regression @OnlyIntake 
  Scenario: View Pharmacy Information - The System displays the Store elements Pharmacy Information
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then I see the landing page
    When I click on store ID
    Then I see store information page
    And I verify for pharmacy information in store information page
      | InputFileName | SheetName                  | RowId        |
      | TestData      | Store_Pharmacy_Information | Row_Intake_1 |
    And I verify  for pharmacy hours

  @maintainLocation @RXAPPD-9141 @Regression @OnlyIntake 
  Scenario: View Pharmacy Information - The User clicks the Store hyperlink
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then I see the landing page
    When I click on store ID
    Then I see store information page
    And I verify for pharmacy information in store information page
      | InputFileName | SheetName                  | RowId        |
      | TestData      | Store_Pharmacy_Information | Row_Intake_1 |
    And I verify  for pharmacy hours
    #And I verify for healthcare clinic hours
    And I verify for store hours
    And I verify for pharmacy inventory information
      | InputFileName | SheetName          | RowId        |
      | TestData      | Pharmacy_Inventory | Row_Intake_1 |
    And I verify for general information
      | InputFileName | SheetName           | RowId        |
      | TestData      | General_Information | Row_Intake_1 |
    And User closes the application

  @maintainLocation @RXAPPD-9749 @Regression @OnlyIntake 
  Scenario: Maintain location data - Verify that the system displays correctly License and ID label for a Location with all fields filled in Store Information screen
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then I see the landing page
    When I click on store ID
    Then I see store information page
    And I verify for pharmacy information in store information page
      | InputFileName | SheetName                  | RowId        |
      | TestData      | Store_Pharmacy_Information | Row_Intake_1 |
    And I verify  for pharmacy hours
    And I verify for license and ID
      | InputFileName | SheetName  | RowId        |
      | TestData      | License_ID | Row_Intake_1 |

  @PatSearch @RXAPPD-9911 @Regression @OnlyIntake 
  Scenario: Patient Update via PMS - Verify that the system hides the Edit button on patient comment panel from the General Info tab
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_4 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then user should see patient profile page
    When user clicks on patient comment icon
    Then user can see patient comments
    When user clicks on hide comments button
    Then user should see patient profile page
    And User closes the application

  @RXQE-2632 @E2E
  Scenario: By clicking on Enter pull up patient profile
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_4 |
    And clicks search button on patient search page
    Then System should display patient search results
    When user hits enter on keyboard
    Then patient profile should be displayed
    And User closes the application

  @RXQE-2636 @E2E
  Scenario: when Double clicked on selected patient pull up patient profile
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_4 |
    And clicks search button on patient search page
    Then System should display patient search results
    When user double clicks on patient result
    Then patient profile should be displayed
    And User closes the application

  @RXQE-2581 @E2E @Regression @OnlyIntake 
  Scenario: Prescriber search in left panel link
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When user navigates to prescriber search
    Then prescriber search page should be displayed
    When user enters details of the prescriber
      | InputFileName | SheetName  | RowId        |
      | TestData      | prescriber | Row_Intake_1 |
    And choose state from the drop down and hit search
    Then prescriber details should be displayed successfully
    And User closes the application

  @RXQE-2582 @E2E @Regression @OnlyIntake @rerunallfail
  Scenario: Prescriber search-Multiple license
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When user navigates to prescriber search
    Then prescriber search page should be displayed
    When user enters details of the prescriber
      | InputFileName | SheetName  | RowId        |
      | TestData      | prescriber | Row_Intake_1 |
    And choose state from the drop down and hit search
    Then prescriber details should be displayed successfully
    When user hits ctrl plus h
    Then System should display RxMS home page
    When user navigates to prescriber search
    Then prescriber search page should be displayed
    When user enters details of the prescriber
      | InputFileName | SheetName  | RowId        |
      | TestData      | prescriber | Row_Intake_1 |
    When user search with wrong state
    Then prescriber details should not display
    And User closes the application

  @taskbuckets @RXAPPD-11870 @RXAPPD-11890 @RXAPPD-11903 @Regression @OnlyIntake
  Scenario: Check task type buckets empty
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    And user selects a task from empty bucket
    And User closes the application

  #@RXAPPD-11890
  #Scenario: Confirm Task Type Buckets empty
  #Given User launches the RxMS desktop application
  #When User enters the valid credentials in login text fields
  #| InputFileName | SheetName | RowId   |
  #| TestData         | login     | Row_PH |
  #And User clicks login button
  #Then System should display RxMS home page
  #And user selects a task from empty bucket
  #And User closes the application
  #@RXAPPD-11903
  #Scenario: Check the hotkeys for a Task not available
  #Given User launches the RxMS desktop application
  #When User enters the valid credentials in login text fields
  #| InputFileName | SheetName | RowId   |
  #| TestData        | login     | Row_PH |
  #And User clicks login button
  #Then System should display RxMS home page
  #When user selects a task from empty bucket
  #Then sytem shows the warning message
  #When user hits alt plus o
  #Then System should display RxMS home page
  #Scenario: Check the hotkeys for a Task not available
  #Given User launches the RxMS desktop application
  #When User enters the valid credentials in login text fields
  #| InputFileName | SheetName | RowId   |
  #| TestData        | login     | Row_PH |
  #And User clicks login button
  #Then System should display RxMS home page
  #When user selects a task from empty bucket
  #Then sytem shows the warning message
  #When user hits alt plus o hot key
  #Then System should display RxMS home page
  @taskboard @RXAPPD-11866 @RXAPPD-11867 @RXAPPD-11912 @RXAPPD-12129 @Regression @OnlyIntake 
  Scenario: Open the taskboard
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User navigates to Patient search page
    And the task board is collapsed
    When User navigates to home page
    And the task board is expanded
    When User navigates to Drug search page
    And the task board is collapsed
    When User navigates to home page
    And the task board is expanded
    When User navigates to Prescriber search page
    And the task board is collapsed
    When User navigates to home page
    And the task board is expanded
    When User navigates to Plan search page
    And the task board is collapsed
    When User navigates to home page
    And the task board is expanded
    When User navigates to Patient order status page
    And the task board is collapsed
    When User navigates to home page
    And the task board is expanded
    #When User navigates to role management page
    #And the task board is collapsed
    #When User navigates to home page
    #And the task board is expanded
    #When the user clicks on filling task
    #Then the system shows the message
    #And click ok
    And User closes the application

  #taskboard @RXAPPD-11867
  #Scenario: Close the taskboard
  #Given User launches the RxMS desktop application
  #When User enters the valid credentials in login text fields
  #| InputFileName | SheetName | RowId   |
  #| TestData  | login     | Row_PH |
  #And User clicks login button
  #Then System should display RxMS home page
  #And the task board is expanded
  #When User clicks on patient tab in left side menu
  #Then System should navigate to patient search page
  #And the task board is collapsed
  #And User closes the application
  @RXAPPD-5233 @RXAPPD-5152 @pickuLaterToday @Regression @OnlyIntake
  Scenario: Intake - Perform Intake for a Scanned Rx with all mandatory fields
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_3 |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as later with today date
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    #Then Data Entry task should be created
    And User closes the application

  @RXAPPD-5153 @pickuLaterTomorrow @Regression @OnlyIntake 
  Scenario: Intake - Pick Up Time for a Scanned Rx if the Pharmacy is opened AND selecting a different day from the current day
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_3 |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as later with tomorrow date
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    #Then Data Entry task should be created
    And User closes the application

  @RXUAT-171 @intake_imageManipulation @UAT
  Scenario: Image Manipulation - Intake
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_3 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When user click on annotation button and add a note with below text for front image on Intake page
      | Team       |
      | RxRenewal  |
      | Automation |
    And user clicks on annotaton button and adds no text "" in note and checks the notes for front image on Intake page
    Then User check the annotations are saved in descending order
      | Automation |
      | RxRenewal  |
      | Team       |
    When user click to rotate scanned image to right for front image on Intake page
    Then user check  the scanned image rotated to right for front image on Intake page
    When user click to rotate scaned image left for front image on Intake page
    Then user check the image rotated left for front image on Intake page
    And user click to zoom in scanned Image for front image on Intake page
    Then user click on resize to original size for front image on Intake page
    And user click to zoom out scanned image for front image on Intake page
    Then user click on resize to original size for front image on Intake page
    When user click on full screen image
    And user see the image full screen
    Then user click on close
    And user click on back button on tab bar in Intake page
    When user click on annotation button and add a note with below text for back image on Intake page
      | Walgreens |
      | Deerfield |
    Then user clicks on annotaton button and adds no text "" in note and checks the notes for back image on Intake page
    Then User check the annotations are saved in descending order
      | Deerfield  |
      | Walgreens  |
     #And user clicks on the note created on the image
    When user click to rotate scanned image to right for back image on Intake page
    Then user check  the scanned image rotated to right for back image on Intake page
    When user click to rotate scaned image left for back image on Intake page
    Then user check the image rotated left for back image on Intake page
    And user click to zoom in scanned Image for back image on Intake page
    Then user click on resize to original size for back image on Intake page
    And user click to zoom out scanned image for back image on Intake page
    Then user click on resize to original size for back image on Intake page
    When user click on full screen image
    And user see the image full screen
    Then user click on close
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen

  #Then Data Entry task should be created
  @RXUAT-17 @UAT
  Scenario: Patient Search
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User click TAB key from "Last Name" field
    Then User should be on "First Name" field
    When User click TAB key from "First Name" field
    Then User should be on "Phone Number" field
    When User click TAB key from "Phone Number" field
    Then User should be on "Date of Birth" field
    When User click TAB key from "Date of Birth" field
    Then User should be on "Search" field
    When User clicks on search button using ALT plus S hot key with out search criteria
    Then System should display a message to the user
    When User enters first name of the patient
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_2 |
    Then System should display a message to the user
    When User enters invalid phone number and perfroms search using ALT plus S hot key
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_4 |
    Then System displays invalid format message
    When User enters future date of birth in the search criteria and performs search using ALT plus S hot key
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_5 |
    Then System displays a message for that future date
    When User enters an search criteria that does not match an existing patient
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_6 |
    Then System should display a message for that search criteria
    When User enters last name of the patient
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_7 |
    And clicks search button on patient search page
    Then System should display patient search results
    And User should see first row of the results is selected automatically
    And User navigates through the results using arrow keys
    And User checks the results are sorted in ascending order
    And User checks number of search results returned in the table with the number of results found
    When User enters pet name and performs search using ALT plus S hot key
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_8 |
    Then User should see the results and check the pet indicator
    When User clicks view button
    Then user should see patient profile page
    And User should see pet indicator in patient demographic section
    When User tries to navigate back to patient search results
    Then System should navigate to patient search page
    When User enters twin patient name and performs search using ALT plus S hot key
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_9 |
    Then User should see the results and check the twin indicator
    And User clicks view button using ALT plus V hot key
    Then user should see patient profile page
    And User should see twin indicator in patient demographic section
    When User tries to navigate back to patient search results
    Then System should navigate to patient search page
    When User selects Add New button by clicking
    Then System displays a message in the popup
    And User clicks on ok button using ALT plus o hot key
    When User clicks on add new button using ALT plus A hot key
    Then System displays a message in the popup
    And User clicks on ok button using ALT plus o hot key
    When User selects Update button by clicking
    Then System displays a message in the popup
    And User clicks on ok button using ALT plus o hot key
    And User clicks on update button using ALT plus U hot key
    Then System displays a message in the popup
    And User clicks on ok button using ALT plus o hot key
    When User clicks view button
    Then user should see patient profile page
    When User tries to navigate back to patient search results
    Then System should navigate to patient search page
    And User clicks view button using ALT plus V hot key
    Then user should see patient profile page

  @RXUAT-282 @UAT
  Scenario: Patient Rework for Hybrid
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_3 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks on add new button using ALT plus A hot key
    Then System displays a message in the popup
    And User clicks on ok button using ALT plus o hot key
    And User clicks on update button using ALT plus U hot key
    Then System displays a message in the popup
    And User clicks on ok button using ALT plus o hot key
    When User clicks view button
    Then user should see patient profile page
    And User clicks on update button in patient profile page using ALT plus U hot key
    Then System displays a message in the popup
    And User clicks on ok button using ALT plus o hot key
    When user clicks on patient comment icon
    Then user can see patient comments
    When User clicks on add comment button in patient profile page comments section using ALT plus A hot key
    Then System displays a message in the popup
    And User clicks on ok button using ALT plus o hot key
    When user clicks on hide comments button
    Then user should see patient profile page
    And User closes the application

  @RXUAT-4 @UAT @Regression @OnlyIntake 
  Scenario: View Dashboard
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User navigates to Patient search page
    And the task board is collapsed
    #And the navigation bar is collapsed
    When User navigates to home page
    And the task board is expanded
    And the navigation bar is expanded
    When User navigates to Drug search page
    And the task board is collapsed
    #And the navigation bar is collapsed
    When User navigates to home page
    And the task board is expanded
    And the navigation bar is expanded
    When User navigates to Prescriber search page
    And the task board is collapsed
    #And the navigation bar is collapsed
    When User navigates to home page
    And the task board is expanded
    And the navigation bar is expanded
    When User navigates to Plan search page
    And the task board is collapsed
    #And the navigation bar is collapsed
    When User navigates to home page
    And the task board is expanded
    And the navigation bar is expanded
    When User navigates to Patient order status page
    And the task board is collapsed
    #And the navigation bar is collapsed
    When User navigates to home page
    And the task board is expanded
    And the navigation bar is expanded
    #When the user clicks on filling task
    #Then the system shows the message
    #And click ok
    #Then System should display RxMS home page
    When User hits ctrl plus one hot key
    And the task board is collapsed
    #And the navigation bar is collapsed
    Then System should navigate to DE screen or System shows a pop-up if there are no DE tasks
    And the task board is expanded
    And the navigation bar is expanded
    When User hits ctrl plus two hot key
    And the task board is collapsed
    #And the navigation bar is collapsed
    Then System should navigate to DR screen or System shows a pop-up if there are no DR tasks
    And the task board is expanded
    And the navigation bar is expanded
    When User hits ctrl plus three hot key
    And the task board is collapsed
    #And the navigation bar is collapsed
    Then System should navigate to CE screen or System shows a pop-up if there are no CE tasks
    And the task board is expanded
    And the navigation bar is expanded
    When User hits ctrl plus four hot key
    And the task board is collapsed
    #And the navigation bar is collapsed
    Then System should navigate to PV screen or System shows a pop-up if there are no PV tasks
    When User hits ctrl plus h hot key
    Then System should display RxMS home page
    And the task board is expanded
    And the navigation bar is expanded
    And I verify for pharmacy information
      | InputFileName | SheetName            | RowId        |
      | TestData      | Pharmacy_Information | Row_Intake_2 |
    When I click on store ID
    Then I see store information page
    And I verify for pharmacy information in store information page
      | InputFileName | SheetName                  | RowId        |
      | TestData      | Store_Pharmacy_Information | Row_Intake_2 |
    And I verify  for pharmacy hours
    And I verify for store hours
    And I verify for pharmacy inventory information
      | InputFileName | SheetName          | RowId        |
      | TestData      | Pharmacy_Inventory | Row_Intake_2 |
    And I verify for general information
      | InputFileName | SheetName           | RowId        |
      | TestData      | General_Information | Row_Intake_2 |
    And I verify for license and ID
      | InputFileName | SheetName  | RowId        |
      | TestData      | License_ID | Row_Intake_2 |
    When User hits ctrl plus h hot key
    Then System should display RxMS home page
    When User clicks on RxMS help from the dashboard
    Then System should display RxMS help
    When User hits ctrl plus o hot key
    Then System should display the login page
    And User closes the application

  #AKEESA7 End
  @RXAPPD-11627 @Regression @OnlyIntake
  Scenario: UI - Verify that when the user logged the system displays User initials and UserName
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    And dashboard should display user initials

  @RXAPPD-11636 @Regression @OnlyIntake
  Scenario: UI - Task Maintenance - Verify that the system returns to the Dashboard by clicking on Back button in the Drug Search Results screen
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks drug search in left side menu
    Then System should display drug search page
    When User enters drug name in text box labeled drug name
      | InputFileName | SheetName | RowId        |
      | TestData      | drug      | Row_Intake_2 |
    And clicks search button on drug search page
    Then System should display the drug results
      | InputFileName | SheetName | RowId        |
      | TestData      | drug      | Row_Intake_2 |
    When user clicks back button from drug search
    Then System should display RxMS home page

  @RXAPPD-11637 @Regression @OnlyIntake
  Scenario: UI - Task Maintenance - Verify that the system returns to the Dashboard by clicking on Back button in the Drug Search Criteria screen
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks drug search in left side menu
    Then System should display drug search page
    When user clicks back button from drug search
    Then System should display RxMS home page

  @RXAPPD-9782
  Scenario: UI - Validate Assembled Product - Verify that the system displays the patient comment overlay without comments in View General Patient Information
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_2 |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    When user clicks comment link
    Then comment box should display
    And should not show comments

  #commited by shiva kiran
  @RXAPPD-11877 @Regression @OnlyIntake
  Scenario: UI- View Task board - Determine and display the number of tasks by the system
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    And All the tasks in taskboard should be displayed
    And show the number of respective tasks if available
    And User closes the application

  @RXUAT-46 @UAT @Regression @OnlyIntake 
  Scenario: Role Management - Intake
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_2 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    #When User clicks log out button in left side navigation menu
    #Then System should display the login page
    And User closes the application
    #logging as a Read only credentials
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId    |
      | TestData      | login     | Row_TECH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_2 |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And User should not able to see intakeRx button
    And I click on logout button
    Then System should display the login page
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_2 |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    And user able to see Walkin and ScanRx button visible but not selectable

  @RXUAT-8 @UAT @Regression @OnlyIntake @rerunallfail1
  Scenario: Product search
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    When User clicks drug search in left side menu
    And enter drug information with drug name
      | InputFileName | SheetName | RowId        |
      | TestData      | drug      | Row_Intake_4 |
    And Search for product
    And results should be displayed
    And enter drug information with drug name
      | InputFileName | SheetName | RowId        |
      | TestData      | drug      | Row_Intake_4 |
    And check the hot keys
      | InputFileName | SheetName | RowId        |
      | TestData      | drug      | Row_Intake_4 |
    Then check the hot keys to view drug detail
    And search drug with no drug
    And search with Quick code
      | InputFileName | SheetName | RowId        |
      | TestData      | drug      | Row_Intake_5 |
    And search with NDC
      | InputFileName | SheetName | RowId        |
      | TestData      | drug      | Row_Intake_4 |
    And search with partial NDC
      | InputFileName | SheetName | RowId        |
      | TestData      | drug      | Row_Intake_4 |
    And search with leaving zeros
      | InputFileName | SheetName | RowId        |
      | TestData      | drug      | Row_Intake_4 |
    And search with WIC number
      | InputFileName | SheetName | RowId        |
      | TestData      | drug      | Row_Intake_4 |
    #And check the show linked products
      #| InputFileName | SheetName | RowId        |
      #| TestData      | drug      | Row_Intake_7 |
    And search with three digit NDC
      | InputFileName | SheetName | RowId        |
      | TestData      | drug      | Row_Intake_4 |
    And search with three digit UPC
      | InputFileName | SheetName | RowId        |
      | TestData      | drug      | Row_Intake_4 |
    #And selelct the dashboard
    #When User clicks drug search in left side menu
    And search for inactive drug
      | InputFileName | SheetName | RowId        |
      | TestData      | drug      | Row_Intake_6 |
    And enter drug information with drug name
      | InputFileName | SheetName | RowId        |
      | TestData      | drug      | Row_Intake_4 |
    And Search for product
    And results should be displayed
    And User closes the application

  @RXQE-2965 @E2E @Regression @OnlyIntake
  Scenario: E2E- DE- Payor Search
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks plan search button in left side menu
    Then System should display plan search page
    When User enters enter the BIN information labeled BIN
    And clicks search button on plan search page
    Then plan results should be displayed as matching BIN
    When Erase BIN information and enter PCN information only
      | InputFileName | SheetName | RowId        |
      | TestData      | plan      | Row_Intake_1 |
    And clicks search button on plan search page
    Then User should be prompted to enter BIN number error message
    When User enters enter the BIN information labeled BIN
    And User enters enter the PCN information labeled PCN
      | InputFileName | SheetName | RowId        |
      | TestData      | plan      | Row_Intake_1 |
    And clicks search button on plan search page
    Then Screen should display plans matching BIN and PCN information
    And User enters enter the PlanId information labeled PlanId
      | InputFileName | SheetName | RowId        |
      | TestData      | plan      | Row_Intake_1 |
    And clicks search button on plan search page
    Then Screen should display plans matching Plan Id information
    When User enters plan name in the text box labeled plan name
      | InputFileName | SheetName | RowId        |
      | TestData      | plan      | Row_Intake_1 |
    And clicks search button on plan search page
    Then plan results should be displayed
      | InputFileName | SheetName | RowId        |
      | TestData      | plan      | Row_Intake_1 |

  @RXQE-2956 @E2E @Regression @OnlyIntake
  Scenario: Determine prescription Intake Type
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_2 |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as Scan
    Given get the total number of prescriptions by scan in database
    And clicks Finish button in intake method screen    
    Then validate the number of prescriptions in database by scan after completing intake    
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_2 |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as phone
    Given get the total number of prescriptions by phone in database
    And clicks Finish button in intake method screen    
    Then validate the number of prescriptions in database by phone after completing intake    
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_2 |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    And selects origin code as fax
    Given get the total number of prescriptions by fax in database
    And clicks Finish button in intake method screen    
    Then validate the number of prescriptions in database by fax after completing intake
    And User closes the application

  @RXQE-5781 @IkariWarriors @Regression @OnlyIntake
  Scenario: SIT | View Patient Rx Preferences | No Rx Preferences
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
      | TestData      | patient   | Row_Intake_17 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System will navigate the Patient Profile Page
    And User click the Preference Tab
    Then System should display "No Rx Preferences" when no preferences are entered

  @RXQE-5794 @IkariWarriors @Regression @OnlyIntake
  Scenario: SIT | View Patient Rx Preferences |Update Rx Preferences
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
      | TestData      | patient   | Row_Intake_10 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System will navigate the Patient Profile Page
    And User click the Preference Tab
    Then System should display Rx Preferences
    When User click on Update Button on Rx Preferences Page
    Then System will navigate the user to the Update Patient Rx Preferences screen
    When User deselect snap cap
    And User click on SaveAndExit Button
    Then System will update and shows No Rx Preferences

  @RXQE-5835 @IkariWarriors @Regression @OnlyIntake @rerunallfail
  Scenario: SIT | View Rx Preferences | Back to Patient Search Result Page
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
      | TestData      | patient   | Row_Intake_10 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System will navigate the Patient Profile Page
    And User click the Preference Tab
    Then User should be able to view the Preference snap Cap
    When User click on Back Button on Patient Profile page
    Then System will navigate the user Patient Search Result Page

  @RXQE-5754 @IkariWarriors @Regression @OnlyIntake
  Scenario: View Additional Medications, Validate Tab Order and Hot Keys
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData  | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_Intake_11 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
  #Then System should navigate to Medication History Screen
    Then Validate Medication History has default Rx History tab
    Then User clicks Additional Medication tab and validate result with number of additional Meds
    #Then validate tab order for Additional Medication
    Then validate Hot key Alt+M and Alt+U
    And User closes the application
    
@RXQE-5736 @IkariWarriors @Regression @OnlyIntake
  Scenario: SIT-Verify user is not able to delete multiple prescriptions
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
      | TestData      | patient   | Row_Intake_11 |
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
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_Intake_11 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_Intake_11 |
    And User clicks search button on patient order status
    #Then The pending link for current prescription should be clicked
    Then The pending link for current prescription should be selected
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_Intake_11 |
    Then Validate Hot keys for Delete RX
    And User closes the application
    
  @RXQE-5858 @IkariWarriors @Regression @OnlyIntake
  Scenario: SIT | Expanded patient search | TAB Order Flow
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User click TAB key from "Date of Birth" field
    Then User should be on "Phone Number" field
    When User click TAB key from "Phone Number" field
    Then User should be on "First Name" field
    When User click TAB key from "First Name" field
    Then User should be on "Last Name" field
    When User click TAB key from "Last Name" field
    Then User should be on "Search" field

  @RXQE-5961 @IkariWarriors @Regression @OnlyIntake
  Scenario: SIT | Enhanced Patient Search Criteria | Search for a Patient not inserting the minimum search criteria for Local Patien Search - Failure
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name only
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display a message to the user

  @RXQE-5740 @IkariWarriors @Regression @OnlyIntake
  Scenario: SIT-Verify Pop up message for delete Rx
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId    |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData		  | patient   | Row_Intake_11 |
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
      | TestData		  | patient   | Row_Intake_11 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData		  | patient   | Row_Intake_11 |
    And User clicks search button on patient order status
#Then The pending link for current prescription should be clicked
    Then The pending link for current prescription should be selected
      | InputFileName | SheetName | RowId   |
      | TestData		  | patient   | Row_Intake_11 |
    Then Validate Hot keys for Delete RX
    And User closes the application

@RXQE-5778 @IkariWarriors @Regression @OnlyIntake 
  Scenario: Verify hot keys in the delete Rx pop up window
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId    |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData		  | patient   | Row_Intake_11 |
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
      | TestData		  | patient   | Row_Intake_11 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData		  | patient   | Row_Intake_11 |
    And User clicks search button on patient order status
#Then The pending link for current prescription should be clicked
    Then The pending link for current prescription should be selected
      | InputFileName | SheetName | RowId   |
      | TestData		  | patient   | Row_Intake_11 |
    Then Validate Hot keys for Delete RX
    And User closes the application
    
    
  @RXQE-5970 @IkariWarriors
  Scenario: Verify user without delete Rx permission
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId        |
      | TestData      | login     | Row_ADMIN_RO |
    And User clicks login button
    Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
    #| InputFileName | SheetName | RowId   |
    #| TestData		  | patient   | Row_Intake_11 |
    #And clicks search button on patient search page
    #Then System should display patient search results
    #When User clicks view button
    #And clicks intake Rx
    #Then System should navigate to Intake Method Screen
    #When User selects pickup time as waiting
    #And selects origin code as Scan
    #And clicks Finish button in intake method screen
    #Then Data Entry task should be created
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_Intake_11 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_Intake_11 |
    And User clicks search button on patient order status
    Then DeleteRx Button should not display for first prescription
    And User closes the application

  @RXQE-5883 @IkariWarriors @Regression @OnlyIntake
  Scenario: SIT - Track Delete - Cancel deletion request
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
      | TestData      | patient   | Row_DE_IW_1 |
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
      | TestData      | patient   | Row_DE_IW_1 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_DE_IW_1 |
    And User clicks search button on patient order status
    Then User validates the status as "pending" and selects the current prescription
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_DE_IW_1 |
    When User clicks on Delete Rx button
    Then validates the popup
    And User clicks on cancel message

  @RXQE-5891 @IkariWarriors @Regression @OnlyIntake 
  Scenario: SIT Enhanced Patient Search Search for a Patient not inserting the minimum search criteria for Global Patien Search - Failure
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And The focus should be on date of birth text field
    And User selects global search option to search the patient
    When User enters patient Last Name
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_pat_two |
    And clicks the search button on patient search page
    Then System should display error "Please specify the required search criteria." message about the search criteria
    When User enter patient date of birth
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_pat_two |
    And clicks the search button on patient search page
    Then System should display error "Please specify the required search criteria." message about the search criteria
    When User enters patient First Name
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_pat_two |
    And clicks the search button on patient search page
    Then System should display error "Please specify the required search criteria." message about the search criteria

  @RXQE-5956 @IkariWarriors @Regression @OnlyIntake 
  Scenario: SIT Enhanced Patient Search Criteria To Verify that the System returns the specific messages if no result are found
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And The focus should be on date of birth text field
    When User all the information in the text boxes of patient search screen
      | InputFileName | SheetName | RowId       		|
      | TestData      | patient   | Row_Zero_Result |
    And clicks the search button on patient search page
    Then System should display "0 Results found. Please refine your search." message about the patient results

  @RXQE-5906 @IkariWarriors @Regression @OnlyIntake
  Scenario: SIT Enhanced Patient Search Criteria To Verify that the System doesnt allow to search for a Patient by an invalid format for the Date of birth
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And The focus should be on date of birth text field
    When User enters valid Last Name,First Name and phone Number
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_pat_two |
    And User enters invalid date of birth and sees error "Invalid date format" message while performing search
      | 05/02/197  |
      | 00/00/0000 |
      | 00/_/___   |
      | 13/02/2017 |
      | 12/32/2017 |
      | 01/32/2017 |
      | 02/30/2017 |

  @RXQE-5902 @IkariWarriors @Regression @OnlyIntake
  Scenario: SIT Enhanced Patient Search Criteria To Verify that the System returns on the Dashboard by clicking on the Back button
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And The focus should be on date of birth text field
    And User checks the Add New button in patient search is enabled
    When User clicks on search button using ALT plus S hot key with out search criteria
    Then System should display error "Please specify the required search criteria." message about the search criteria
    When User clicks on back button in patient search page
    Then System should display RxMS home page

  @RXQE-5897 @IkariWarriors @Regression @OnlyIntake @rerunallfail
  Scenario: SIT Enhanced Patient Search Criteria To Verify that the System notifies the User that no search has been performed by selecting the Add New button
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And The focus should be on date of birth text field
    And User checks the Add New button in patient search is enabled
    When User clicks on Add New button using ALT plus A hot key
    Then System shows a popup with "You must conduct a global search before adding a new patient." message and "Ok" button

  @RXQE-5830 @IkariWarriors @Regression @OnlyIntake 
  Scenario: SIT | View Rx Preferences | Double Count Icon
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
      | TestData      | patient   | Row_Intake_10 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System will navigate the Patient Profile Page
    And User click the Preference Tab
    Then System should display Rx Preferences
    When User click on Update Button on Rx Preferences Page
    Then System will navigate the user to the Update Patient Rx Preferences screen
    And Preferences is displayed with Snap Cap and Double Count Icons on Update Patient screen
    When User deselect snap cap and select double count on Update Patient screen
    And User click on SaveAndExit Button
    #Then System will update and shows No Rx Preferences

  @RXQE-5814 @IkariWarriors @Regression @OnlyIntake 
  Scenario: SIT | View Rx Preferences | Snap Cap Icon
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
      | TestData      | patient   | Row_Intake_10 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System will navigate the Patient Profile Page
    And User click the Preference Tab
    Then System should display Rx Preferences
    When User click on Update Button on Rx Preferences Page
    Then System will navigate the user to the Update Patient Rx Preferences screen
    And Preferences is displayed with Snap Cap and Double Count Icons on Update Patient screen
    When User select snap cap only
    And User click on SaveAndExit Button
    #Then System displays Rx Preferences screen with Snap Cap Icon as Preferences

  @RXQE-5728 @IkariWarriors @Regression @OnlyIntake
  Scenario: Enhanced Patient Search Results | Local Patient Search | No Results
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    Then system should display the following editable fields
      | Last Name     |
      | First Name    |
      | Phone Number  |
      | Date of Birth |
    And user enters lastname and perform local search
      | InputFileName | SheetName | RowId              |
      | TestData      | patient   | Row_Intake_fifteen |
    Then system display the message Zero results found view and update button not available
    And user enters lastname and Date of Birth to perform local search
      | InputFileName | SheetName | RowId              |
      | TestData      | patient   | Row_Intake_fifteen |
    Then system display the message Zero results found view and update button not available
    And user enters Date of Birth and perform local search
      | InputFileName | SheetName | RowId              |
      | TestData      | patient   | Row_Intake_fifteen |
    Then system display the message Zero results found view and update button not available
    And user enters phone number and perform local search
      | InputFileName | SheetName | RowId              |
      | TestData      | patient   | Row_Intake_fifteen |
    Then system display the message Zero results found view and update button not available
    And User closes the application

  @RXQE-5734 @IkariWarriors @Regression @OnlyIntake 
  Scenario: Enhanced Patient Search Results | Local Patient Search Results
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    Then system should display the following editable fields
      | Last Name     |
      | First Name    |
      | Phone Number  |
      | Date of Birth |
    And user enters lastname and perform local search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And system displayed the list of Patients matching with the inserted criteria
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And user enters phone number and perform local search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And system displayed the list of Patients matching with phone number inserted criteria
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And user enters Date of Birth and perform local search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And system displayed the list of Patients matching with Date of Birth the inserted criteria
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And user enter patient first name and last name perform local search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And system displayed the list of Patients matching with first name and last name inserted criteria
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And user enter patient last name and phone number perform local search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And system displayed the list of Patients matching with last name and phone number inserted criteria
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And user enter patient first name and last name and date of birth perform local search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And system displayed the list of Patients matching with first name and last name inserted criteria
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then user enter Patient Search Screen criteria for a patient that is deceased in patient profile
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_Deceased |
    And system should be displayed results with validated deceased symbol
    Then user enter Patient Search criteria for a patient that is a pet
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_Intake_12 |
    And system should be displayed results with validated pet symbol in patient profile
    Then user enter Patient Search criteria for a patient that is a twin
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_9 |
    And system should be displayed results with validated twin symbol in patient profile
    And User closes the application

  @RXQE-5752 @IkariWarriors @Regression @OnlyIntake
  Scenario: Enhanced Patient Search Results | Local Patient search | Add New Patient
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    Then system should display the following editable fields
      | Last Name     |
      | First Name    |
      | Phone Number  |
      | Date of Birth |
    And user enters lastname and perform local search
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_7 |
    And user click Add new button
    Then System shows a popup with "You must conduct a global search before adding a new patient. Would you like to conduct a search across all stores now?" message
    And user click cancel popup button
    And User closes the application

  @RXQE-5753 @IkariWarriors @Regression @OnlyIntake
  Scenario: Enhanced Patient Search Results | Global Patient search | Add New Patient
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    Then system should display the following editable fields
      | Last Name     |
      | First Name    |
      | Phone Number  |
      | Date of Birth |
    And user click on global search icon
    And user enters lastname and date of birth perform global search
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_Intake_12 |
    And user click Add new button and it navigate to patient registration page
    And User closes the application

  @RXQE-5770 @IkariWarriors @Regression @OnlyIntake
  Scenario: Enhanced Patient Search Results | Global Patient Search | View Existing Patient Details
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    Then system should display the following editable fields
      | Last Name     |
      | First Name    |
      | Phone Number  |
      | Date of Birth |
    And user click on global search icon
    And user enters phone number and perform global search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    When User clicks view button
    Then user should see patient profile page
    And User closes the application

  @RXQE-5783 @IkariWarriors @Regression @OnlyIntake 
  Scenario: Enhanced Patient Search Results | Local Patient Refinement
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    Then system should display the following editable fields
      | Last Name     |
      | First Name    |
      | Phone Number  |
      | Date of Birth |
    And user enter patient first name and last name perform local search
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_Intake_14 |
    And system displayed the list of Patients matching with first name and last name inserted criteria
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_Intake_14 |
    And user enter patient first name and last name perform local search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And system displayed the list of Patients matching with first name and last name inserted criteria
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And user enter patient first name and last name and phone number perform local search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And system displayed the list of Patients matching first name and last name and phone number perform local search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And user enter patient last name and phone number perform local search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And system displayed the list of Patients matching with last name and phone number inserted criteria
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User closes the application

  @RXQE-5905 @IkariWarriors @Regression @OnlyIntake
  Scenario: To Verify that the System doesnt allow to search for a Patient by an invalid format for the Phone Number
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enter the Invalid phonenumber "9" and validate the error msg
    When User hits ctrl plus h hot key
    When User clicks on patient tab in left side menu
    When User enter the Invalid phonenumber "98" and validate the error msg
    When User hits ctrl plus h hot key
    When User clicks on patient tab in left side menu
    When User enter the Invalid phonenumber "987" and validate the error msg
    When User hits ctrl plus h hot key
    When User clicks on patient tab in left side menu
    When User enter the Invalid phonenumber "9872" and validate the error msg
    When User hits ctrl plus h hot key
    When User clicks on patient tab in left side menu
    When User enter the Invalid phonenumber "98722" and validate the error msg
    When User hits ctrl plus h hot key
    When User clicks on patient tab in left side menu
    When User enter the Invalid phonenumber "987221" and validate the error msg
    When User hits ctrl plus h hot key
    When User clicks on patient tab in left side menu
    When User enter the Invalid phonenumber "9872212" and validate the error msg
    When User hits ctrl plus h hot key
    When User clicks on patient tab in left side menu
    When User enter the Invalid phonenumber "98722129" and validate the error msg
    When User hits ctrl plus h hot key
    When User clicks on patient tab in left side menu
    When User enter the Invalid phonenumber "987221298" and validate the error msg

  @RXQE-5904 @RXQE-5903 @IkariWarriors @Regression @OnlyIntake
  Scenario: To verify that the System navigates to the Enhanced Patient Search Criteria screen with the hotkey
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    Then User Validating Add New button is enable in patient search screen
    When User hits alt plus S hot key
    Then User Validating patient invalid search error msg
    When User hits alt plus A hot key
    Then User Validating add new patient popUp msg
    When User hits alt plus O hot key
    When User hits alt plus left hot key

  @RXQE-5831 @IkariWarriors @Regression @OnlyIntake 
  Scenario: SIT| Patient view | Perform an Intake
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_2 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    Then I am able to see following fields:
      | Origin Code |
      | Pickup Time |
      | Finish      |
      | Cancel      |

  @RXQE-5733 @IkariWarriors @Regression @OnlyIntake 
  Scenario: Verify delete Rx is not available for Check IC+ prescriptions
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
      | TestData      | patient   | Row_Intake_11 |
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
      | TestData      | patient   | Row_Intake_11 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_Intake_11 |
    And User clicks search button on patient order status
    Then The check IC+ prescription should be selected
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_Intake_11 |

  @RXQE-5757 @IkariWarriors @Regression @OnlyIntake
  Scenario: SIT | Expanded patient search | Minimum Search Criteria - LOCAL
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
    And all patient search forms should be present

  @RXQE-5810 @IkariWarriors @Regression @OnlyIntake @rerunallfail1
  Scenario: SIT | Expanded patient search | Minimum Search Criteria - GLOBAL
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And all patient search forms should be present
    Then User selects global search option to search the patient
    Then user enters lastname and Date of Birth to perform local search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System should display patient search results
    Then User selects global search option to search the patient
    Then user enters phone number and perform local search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System should display patient search results
    Then User selects global search option to search the patient
    Then user enter patient last name and DOB and phone number perform local search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then System should display patient search results

  @RXQE-5959 @IkariWarriors @Regression @OnlyIntake
  Scenario: SIT Enhanced Patient Search Criteria To Verify that the System displays the previously entered values in the relevant search fields for the new Search option
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And The focus should be on date of birth text field
    When User all the information in the text boxes of patient search screen
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_pat_one |
    And clicks search button on patient search page
    Then System should display patient search results
    And User gets the data from text fields and compares it to data entered before
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_pat_one |
    When User clicks on global search option
    And clicks search button on patient search page
    Then System should display patient search results
    And User gets the data from text fields and compares it to data entered before
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_pat_one |

  @RXQE-5886 @IkariWarriors @Regression @OnlyIntake
  Scenario: SIT Enhanced Patient Search To Verify that the System displays the previously entered values in the relevant search fields without performing the search (Local & Global)
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And The focus should be on date of birth text field
    When User all the information in the text boxes of patient search screen
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_pat_one |
    And User gets the data from text fields and compares it to data entered before
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_pat_one |
    When User clicks on global search option
    And User gets the data from text fields and compares it to data entered before
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_pat_one |

  @RXQE-5805 @IkariWarriors @Regression @OnlyIntake
  Scenario: SIT Enhanced Patient Search Criteria Patient Search by future Date of Birth - Negative Scenario
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And The focus should be on date of birth text field
    When User enters valid Last Name,First Name and phone Number
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_pat_two |
    And User enters future date of birth and sees error "No future date allowed" message while performing search
      | 06/02/2020 |
      | 07/03/2021 |
      | 08/05/2022 |
      | 09/06/2023 |
      | 10/07/2024 |

  @RXQE-5890 @IkariWarriors @Regression @OnlyIntake 
  Scenario: SIT  Enhanced Patient Search To Verify that the System returns the specific messages if no result are found
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And The focus should be on date of birth text field
    When User enters patient First Name
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_pat_two |
    And clicks the search button on patient search page
    Then System should display error "Please specify the required search criteria." message about the search criteria
    And User selects global search option to search the patient
    When User enters patient First Name
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_pat_two |
    And clicks the search button on patient search page
    Then System should display error "Please specify the required search criteria." message about the search criteria

  @RXQE-5850 @IkariWarriors @Regression @OnlyIntake 
  Scenario: SIT | Enhanced Patient Search Results | Add New Button Before Performing Global Search
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And The focus should be on date of birth text field
    When User all the information in the text boxes of patient search screen
      | InputFileName | SheetName | RowId              |
      | TestData      | patient   | Row_pat_GlobalOnly |
    And clicks the search button on patient search page
    Then System should display "0 Results found. Please refine your search." message about the patient results
    And User checks the Add New button in patient search is enabled
    When User clicks on Add New button using ALT plus A hot key
    Then System shows a popup with "You must conduct a global search before adding a new patient. Would you like to conduct a search across all stores now?" message
    And User clicks on search all stores button using ALT plus s hot key
    Then System should display patient search results

  @RXQE-5843 @IkariWarriors @Regression @OnlyIntake @rerunallfail1
  Scenario: SIT | Enhanced Patient Search Results | At least One Result Found
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And The focus should be on date of birth text field
    When User all the information in the text boxes of patient search screen
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_pat_one |
    And clicks search button on patient search page
    Then System should display patient search results
    And System sets the focus on the first row in returned patient results
    When User clicks on global search option
    When User all the information except phone number in the text boxes of patient search screen
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_pat_one |
    And clicks search button on patient search page
    Then System should display patient search results
    And System sets the focus on the first row in returned patient results

  @RXQE-5793 @IkariWarriors 
  Scenario: SIT  Enhanced Patient Search Criteria To verify that the System follows the TAB order sequence
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And The focus should be on date of birth text field
    And User checks the tab order of the following text fields
      | input-phone-patient        |
      | input-fname-patient        |
      | input-lname-patient        |
      | patient-submit             |
      | patient-add-button         |
      | back-button-patient-search |
      | button-local               |

  @RXQE-5723 @IkariWarriors @Regression @OnlyIntake 
  Scenario: SIT | Enhanced Patient Search Results | Global Patient Search | No results
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And all patient search forms should be present
    Then User selects global search option to search the patient
    Then user enters lastname and Date of Birth to perform local search
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_invalid |
    Then System should display "0 Results found. Please refine your search." message about the patient results
    And update button should not be available
    Then User selects global search option to search the patient
    Then user enters phone number and perform local search
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_invalid |
    Then System should display "0 Results found. Please refine your search." message about the patient results
    And update button should not be available
    Then User selects global search option to search the patient
    Then user enter patient last name and phone number perform local search
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_invalid |
    Then System should display "0 Results found. Please refine your search." message about the patient results
    And update button should not be available

  @RXQE-5724 @IkariWarriors
  Scenario: SIT Enhanced Patient Search Criteria Layout and Navigation Scenarios
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And The focus should be on date of birth text field
    And User checks the tab order of the following text fields
      | input-phone-patient        |
      | input-fname-patient        |
      | input-lname-patient        |
      | patient-submit             |
      | patient-add-button         |
      | back-button-patient-search |
      | button-local               |
    And User checks the following labels are present
      | Date of Birth |
      | Phone Number  |
      | First Name    |
      | Last Name     |

  @RXQE-5846 @IkariWarriors @Regression @OnlyIntake 
  Scenario: SIT | View Rx Preferences | Validate Hot Keys
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
      | TestData      | patient   | Row_Intake_10 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System will navigate the Patient Profile Page
    When User hits Alt+P
    Then System should display Rx Preferences
    When User hits Alt+U
    Then System will navigate the user to the Update Patient Rx Preferences screen

  @RXQE-5853 @IkariWarriors @Regression @OnlyIntake 
  Scenario: SIT | View Rx Preferences | Tab Order
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
      | TestData      | patient   | Row_Intake_10 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System will navigate the Patient Profile Page
    And User click the Preference Tab
    Then System should display Rx Preferences
    And Validate the tab order Update->Back->Patient Comments->Prefresences->Update

  @RXQE-5852 @IkariWarriors @Regression @OnlyIntake 
  Scenario: SIT Enhanced Patient Search Criteria, To search for a Patient by minimum search criteria for Local Patient Search
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient Last Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_pat_four |
    And clicks search button on patient search page
    Then User should see search results matching the search criteria
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_pat_four |
    When User enters patient Phone Number
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_pat_four |
    And clicks search button on patient search page
    Then User should see search results matching the search criteria
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_pat_four |
    When User enter patient date of birth
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_pat_four |
    And clicks search button on patient search page
    Then User should see search results matching the search criteria
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_pat_four |
    When User enters patient Last Name and Date of Birth
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_pat_four |
    And clicks search button on patient search page
    Then User should see search results matching the search criteria
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_pat_four |
    When User enters patient Last Name with 1 minimum character
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_pat_five |
    And clicks search button on patient search page
    Then User should see search results matching the search criteria
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_pat_five |
    When User enters patient Last Name and First Name
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_pat_four |
    And clicks search button on patient search page
    Then User should see search results matching the search criteria
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_pat_four |
    When User enters patient First Name and Phone Number
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_pat_four |
    And clicks search button on patient search page
    Then User should see search results matching the search criteria
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_pat_four |
    When User enters patient First Name and Date of Birth
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_pat_four |
    And clicks search button on patient search page
    Then User should see search results matching the search criteria
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_pat_four |

  @RXQE-5895 @RXQE-5894 @IkariWarriors @Regression @OnlyIntake
  Scenario: To Verify that the System allows to enter a Date of Birth of 8 digits
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    Then User enter and validate dob in patient search screen
      | ActualDOB | ExpectedDOB |
      |    060617 | 06/06/2017  |
    Then User enter and validate dob in patient search screen
      | ActualDOB | ExpectedDOB |
      |    060688 | 06/06/1988  |
    Then User enter and validate dob in patient search screen
      | ActualDOB | ExpectedDOB |
      |    060612 | 06/06/2012  |

    @RXQE-5761 @IkariWarriors @Regression @OnlyIntake
    Scenario: View patient without address information
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
      | TestData      | patient   | Row_Intake_18 |
    And clicks search button on patient search page
    Then click on patient without address
      | InputFileName | SheetName | RowId   |
    	| TestData      | patient   | Row_Intake_18 |
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    And validate patient address should not display 

  @RXQE-5838 @IkariWarriors @Regression @OnlyIntake 
  Scenario: Enhanced Patient Search Results | Global & Local Patient Search Maximum & Minimum Results Reached
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And user enters lastname and perform local search
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_7 |
    When User validate search patient minimum maximum reached

  @RXQE-5722 @IkariWarriors @Regression @OnlyIntake 
  Scenario: SIT- Verify delete button is not enabled when there is no Rx for a patient
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId     |
      | TestData      | patient   | Row_No_result |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId     |
      | TestData      | patient   | Row_No_result |
    And User clicks search button on patient order status
    Then System should display no Result found
    And Delete Rx Button should not display

  @RXQE-7437 @production_hotfix @Regression @OnlyIntake
  Scenario: Prod HotFix |Drug Search | multiple products are displayed in multi hit window when entering invalid NDC with hyphens | SCENARIO ONE in Drug Search
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks drug search in left side menu
    And I enter Invalid NDC number on search field
      | InputFileName | SheetName | RowId          |
      | TestData      | product   | Row_NDCinvalid |
    And clicks search button on drug search page using ALT plus S hot key
    Then drug search system should display no results

  @RXQE-5748 @IkariWarriors @Regression @OnlyIntake @rerunallfail1 
  Scenario: SIT Enhanced Patient Search results, Verifying local patient search results sort
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient Last Name
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_5748 |
    And clicks search button on patient search page
    Then User should see search results matching the search criteria
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_5748 |
    When user clicks on "Name" column header
    Then system should sort the results based on Last Name,First Name,Middle Name
    When user clicks on "Phone No" column header
    Then system should sort the results based on Phone No
    When user clicks on "DOB" column header
    Then system should sort the results based on DOB

  @RXQE-5860 @IkariWarriors @Regression @OnlyIntake @rerunallfail1 
  Scenario: SIT | Expanded patient search | HOT keys
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User navigates to Patient search page
    And all patient search forms should be present
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_Third_Party |
    When User clicks on search button using ALT plus S hot key with out search criteria
    Then System should display patient search results
    When User clicks on add new button using ALT plus A hot key
    Then System shows global search popup with "You must conduct a global search before adding a new patient. Would you like to conduct a search across all stores now?" message and "Search All Stores" button
    And user click cancel popup button
    Then User clicks view button using ALT plus V hot key
    Then user should see patient profile page
    Then User clicks on update button using ALT plus U hot key
    And Should display patient update window
    And user click cancel update registration button
    #Then User clicks on yes on the system message
    When User presses ALT plus three hot key
    Then Should display third party plans
    When User presses ALT plus P hot key
    Then System should display Rx Preferences
    When User presses ALT plus I hot key
    Then Should display patient images page
    When User presses ALT plus M hot key
    Then system displays the Patient Med History tab visible and active
    When User presses ALT plus L hot key
    Then Should display clinical history tab
    When User presses ALT plus G hot key
    Then user should see patient profile page
    #When User tries to navigate back to patient search results
    When User presses ALT plus back hot key
    Then System should navigate to patient search page
    When User presses ALT plus back hot key
    Then System should display RxMS home page

  @RXQE-5517 @RXQE-5893 @IkariWarriors @Regression @OnlyIntake 
  Scenario: SIT | RXMS | Delete image after Intake from POS
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
      | TestData      | patient   | Row_Ikari |
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
      | TestData      | patient   | Row_Ikari |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_Ikari |
    And User clicks search button on patient order status
    And User validates the status as "pending" and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_Ikari |
    And User clicks delete prescription in patient order status
    And clicks delete rx button on the alert message
    Then The prescription should be deleted
    And User closes the application

  @RXQE-5753 @IkariWarriors @Regression @OnlyIntake
  Scenario: Enhanced Patient Search Results | Local Patient search | Add New Patient
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    Then system should display the following editable fields
      | Last Name     |
      | First Name    |
      | Phone Number  |
      | Date of Birth |
    And user click on global search icon
    And user enters lastname and date of birth perform global search
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_Intake_12 |
    And user click Add new button and it navigate to patient registration page
    And User closes the application

  @RXQE-5766 @IkariWarriors @Regression @OnlyIntake @rerunallfail1
  Scenario: Enhanced Patient Search Results | Add New Patient Request Cancelled
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    Then system should display the following editable fields
      | Last Name     |
      | First Name    |
      | Phone Number  |
      | Date of Birth |
    And user enters lastname and perform local search
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_7 |
    And user click Add new button
    Then System should display a message "You must conduct a global search before adding a new patient. Would you like to conduct a search across all stores now?"
    # And user click cancel popup button
    And user click on global search icon
    And user enters lastname and date of birth perform global search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And user click Add new button and click cancel button
    And user enters phone number and perform global search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And user click Add new button and click cancel button
    And User closes the application

  @RXQE-5770 @IkariWarriors @Regression @OnlyIntake @rerunallfail
  Scenario: Enhanced Patient Search Results | Global Patient Search | View Existing Patient Details
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    Then system should display the following editable fields
      | Last Name     |
      | First Name    |
      | Phone Number  |
      | Date of Birth |
    And user click on global search icon
    And user enters phone number and perform global search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And system displayed the list of Patients matching with phone number inserted criteria
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    When User clicks view button
    Then user should see patient profile page
    And User closes the application

  

  @RXQE-6103 @IkariWarriors @Regression @OnlyIntake @rerunallfail
  Scenario: Enhanced Patient Search Results | Global Patient Refinement
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    Then system should display the following editable fields
      | Last Name     |
      | First Name    |
      | Phone Number  |
      | Date of Birth |
    And user click on global search icon
    And user enter patient first name and last name and date of birth perform global search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And system displayed the list of Patients matching with first name and last name inserted criteria
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And user enter patient first name and last name and phone number perform global search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And system displayed the list of Patients matching first name and last name and phone number perform global search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User closes the application

  @RXQE-6674 @IkariWarriors @Regression @OnlyIntake @rerunallfail
  Scenario: Enhanced Patient Search Results | Hot Keys
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    And system should display the following editable fields
      | Last Name     |
      | First Name    |
      | Phone Number  |
      | Date of Birth |
    And user hits Alt plus left hot key
    When User hits ctrl plus p hot key
    Then System should navigate to patient search page
    And user enter lastname
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And user hits Alt plus S hot key
    Then system should navigate to search
    And user hits Alt plus V hot key
    Then system should navigate to view button
    And user hits Alt plus left hot key
    Then system should navigate to back screen
    And user hits Alt plus A hot key
    Then System shows a popup with "You must conduct a global search before adding a new patient. Would you like to conduct a search across all stores now?" message
    And user hits Alt plus C hot key
    Then System should navigate to patient search page
    And User closes the application

  @RXQE-5822 @IkariWarriors @Regression @OnlyIntake 
  Scenario: Expanded patient search | All search criteria - LOCAL
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    Then system should display the following editable fields
      | Last Name     |
      | First Name    |
      | Phone Number  |
      | Date of Birth |
    And user enters phone number and perform local search
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_one |
    And system displayed the list of Patients matching with phone number inserted criteria
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_one |
    And user enters lastname and perform local search
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_one |
    And system displayed the list of Patients matching with the inserted criteria
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_one |
    And user enters Date of Birth and perform local search
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_one |
    And system displayed the list of Patients matching with Date of Birth the inserted criteria
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_one |
    And user enter patient first name and last name perform local search
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And system displayed the list of Patients matching with first name and last name inserted criteria
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then user enter Patient Search Screen criteria for a patient that is deceased in patient profile
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_deceased |
    And system should be displayed results with validated deceased symbol
    Then user enter Patient Search criteria for a patient that is a pet
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_Intake_11 |
    And system should be displayed results with validated pet symbol in patient profile
    Then user enter Patient Search criteria for a patient that is a twin
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_9 |
    And system should be displayed results with validated twin symbol in patient profile
    And user enter patient first name and last name perform local search
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_Intake_16 |
    When user validating the error  "0 Results found. Please refine your search." message
    And User closes the application

  @RXQE-5741 @IkariWarriors @Regression @OnlyIntake 
  Scenario: Enhanced Patient Search Results | Tab Order Sequence No Result
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    Then system should display the following editable fields
      | Last Name     |
      | First Name    |
      | Phone Number  |
      | Date of Birth |
    And user enters lastname and perform local search
      | InputFileName | SheetName | RowId              |
      | TestData      | patient   | Row_Intake_fifteen |
    When user validating the error  "0 Results found. Please refine your search." message
    And user perform tab order in patient profile
    And User closes the application

  @RXQE-5789 @IkariWarriors @Regression @OnlyIntake
  Scenario: SIT | Enhanced Patient Search Results | Local Patient Search | Select Restrictions
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters last name of the patient
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_7 |
    And clicks search button on patient search page
    Then System should display patient search results
    Then Multiple user selection restiction
    And User closes the application

  @RXQE-5738 @IkariWarriors @Regression @OnlyIntake @rerunallfail
  Scenario: Enhanced Patient Search Results | Tab Order Sequence at least One Result
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData      | login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    Then system should display the following editable fields
      | Last Name     |
      | First Name    |
      | Phone Number  |
      | Date of Birth |
    And user enters lastname and perform local search
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_7 |
    And user validate the first row patient has been selected
    And user Checks Tab order by clicking Tab
    And User closes the application

  @RXQE-5725 @IkariWarriors @Regression @OnlyIntake
  Scenario: View General Patient Information
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
      | TestData      | patient   | Row_Intake_18 |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then Validate patient Demographic View labels
      | First Name         |
      | M                  |
      | Last Name          |
      | local_phone        |
      | Suffix             |
      | Date of Birth      |
      | Gender             |
      | iPledge Patient ID |
      | HIPAA on File      |
    Then Validate No 3rd Party Plan Information labels
    Then Validate No Clinical Information on file labels
    Then Validate UpdateBtn
    And Validate IntakeRxBtn

  
  @RXQE-7518 @Joust @Regression @OnlyIntake
  Scenario: SIT | View Failure Preview | Viewing activity | Failure Preview Selection - Patient Search
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   			|
      | TestData      | patient   | Row_RXQE-7518 |
    And clicks search button on patient search page
    Then System should display patient search results
    And the user clicks on the notification alert icon
    Then the system opens the failure preview
    When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
    And the system closes the failure preview
    And the system brings the user to the failure queue overlay
    And the focus is on first failure in the queue
    When the user clicks on the X button of the Failure Preview Overlay
    Then the Failure Preview Overlay is closed
    And the patient search results screen user is viewing still remains open
    When the user clicks on the notification alert icon
    Then the system opens the failure preview
    When user clicks or selects Enter on a failure in the failure preview
    And the system closes the failure preview
    And the system brings the user to the failure queue overlay
    And the focus is on user selected failure
    When the user clicks on the X button of the Failure Preview Overlay
    Then the Failure Preview Overlay is closed
    And the patient search results screen user is viewing still remains open
    
  @RXQE-7521 @Joust @Regression @OnlyIntake
  Scenario: SIT | View Failure Preview | Viewing activity | Failure Preview Selection - Patient Profile - General InfoTab
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   						|
      | TestData  		| patient   | Row_Intake_Failures |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And the user clicks on the notification alert icon
    Then the system opens the failure preview
    When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
    And the system closes the failure preview
    And the system brings the user to the failure queue overlay
    And the focus is on first failure in the queue
    When the user clicks on the X button of the Failure Preview Overlay
    Then the Failure Preview Overlay is closed
    And the General Tab Demographic screen user is viewing still remains open
    When the user clicks on the notification alert icon
    Then the system opens the failure preview
    When user clicks or selects Enter on a failure in the failure preview
    And the system closes the failure preview
    And the focus is on user selected failure
    And the system brings the user to the failure queue overlay
    And the focus is on user selected failure
    When the user clicks on the X button of the Failure Preview Overlay
    Then the Failure Preview Overlay is closed
    And the General Tab Demographic screen user is viewing still remains open

  @RXQE-7523 @Joust @Regression @OnlyIntake
  Scenario: SIT | View Failure Preview | Viewing activity | Failure Preview Selection - Patient Profile - Third Party Plan
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   						|
      | TestData  		| patient   | Row_Intake_Failures |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks on Third Party Plan tab
    And the user clicks on the notification alert icon 
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		Then the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Third Party Plan screen user is viewing still remains open
		#User is viewing the 3rd Party Plan screen of patient search results screen
		When the user clicks on the notification alert icon
		Then the system opens the failure preview 
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Third Party Plan screen user is viewing still remains open

  
  @RXQE-7524 @Joust @Regression @OnlyIntake
  Scenario: SIT | View Failure Preview | Viewing activity | Failure Preview Selection - Patient Profile - Patient Preferences
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   						|
      | TestData  		| patient   | Row_Intake_Failures |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System will navigate the Patient Profile Page
    And User click the Preference Tab
    Then System should display Rx Preferences
    And the user clicks on the notification alert icon 
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		Then the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Rx Preferences screen user is viewing still remains open 
		When the user clicks on the notification alert icon
		Then the system opens the failure preview 
		When user clicks or selects Enter on a failure in the failure preview
		Then the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Rx Preferences screen user is viewing still remains open 

  @RXQE-7525 @Joust @Regression @OnlyIntake
  Scenario: SIT | View Failure Preview | Viewing activity | Failure Preview Selection - Patient Profile - Images
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData  		| login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
     	| InputFileName | SheetName | RowId   						|
      | TestData  		| patient   | Row_Intake_Failures |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And User clicks on Images tab
    #User is viewing the patient scan Images for that particular patient in Images 
		And user hits HOT Keys Ctrl + E 
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		Then the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Patient Images screen user is viewing still remains open 
		#User is viewing the Patient Images screen
		And user hits HOT Keys Ctrl + E 
		Then the system opens the failure preview 
		When user clicks or selects Enter on a failure in the failure preview
		Then the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Patient Images screen user is viewing still remains open 

  @RXQE-7526 @Joust @Regression @OnlyIntake
  Scenario: SIT | View Failure Preview | Viewing activity | Failure Preview Selection - Patient Profile - Med History | Rx History & Additional Medication
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData  		| login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   						|
      | TestData  		| patient   | Row_Intake_Failures |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    When User click on Med History Tab from patient profile page
    Then System should navigate to Medication History Screen
    #User is viewing the Rx History for that particular patient in Medication History screen
		And user hits HOT Keys Ctrl + E  
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		Then the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Rx History screen user is viewing still remains open
		#User is viewing the Rx History screen under Medication History
		When the user clicks on the notification alert icon
		Then the system opens the failure preview  
		When user clicks or selects Enter on a failure in the failure preview
		Then the system closes the failure preview 
		And the focus is on user selected failure
		Then the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Rx History screen user is viewing still remains open
		When User clicks Additional Medication tab
    Then System should display Additional Medication screen
		And user hits HOT Keys Ctrl + E 
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Additional Medications screen user is viewing still remains open
		#User is viewing the Additional Medications screen of Medication History
		When the user clicks on the notification alert icon
		Then the system opens the failure preview
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Additional Medications screen user is viewing still remains open
		
@RXQE-7740 @Joust @Regression @OnlyIntake
		Scenario: View Bucket of Failure Queue
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
    And User clicks failure notification Icon
    Then System should display failure preview
    When User selects a failure task from the list of failure tasks
    Then System displays failure queue 
    And the selected failure should be highlighted
    When User clicks cancel button in the failure queue
    Then failure queue should be closed
    And User should be able to continue with patient search
    
    @RXQE-7527 @Joust @Regression @OnlyIntake
  Scenario: SIT | View Failure Preview | Viewing activity | Failure Preview Selection - Patient Profile - Clinical History
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData  		| login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   						|
      | TestData  		| patient   | Row_Intake_Failures |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And User clicks on Clinical History tab
		And the user clicks on the notification alert icon 
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Clinical History screen user is viewing still remains open
		#User is viewing the patient profile - Clinical History screen
		When the user clicks on the notification alert icon
		Then the system opens the failure preview
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Clinical History screen user is viewing still remains open
		
		@RXQE-7528 @Joust @Regression @OnlyIntake
  Scenario: SIT | View Failure Preview | Viewing activity | Failure Preview Selection - Drug Search
		Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks drug search in left side menu
    Then System should display drug search page
    And the user clicks on the notification alert icon 
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Drug search screen user is viewing still remains open
		When the user clicks on the notification alert icon
		Then the system opens the failure preview
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Drug search screen user is viewing still remains open
		When User enters drug name in text box labeled drug name
      | InputFileName | SheetName | RowId   |
      | TestData      | drug      | Row_one |
    And clicks search button on drug search page
    And the user clicks on the notification alert icon 
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Drug search screen user is viewing still remains open
		When the user clicks on the notification alert icon
		Then the system opens the failure preview
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Drug search screen user is viewing still remains open
		When User clicks view button from Drug Search Page
		And the user clicks on the notification alert icon 
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the General Info Tab Core Drug Info screen user is viewing still remains open
		When the user clicks on the notification alert icon
		Then the system opens the failure preview
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the General Info Tab Core Drug Info screen user is viewing still remains open
		When the user clicks on the clinical references tab
		And the user clicks on the notification alert icon 
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Clinical References screen user is viewing still remains open 
		When the user clicks on the notification alert icon
		Then the system opens the failure preview
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Clinical References screen user is viewing still remains open
		
		@RXQE-7532 @Joust @Regression @OnlyIntake
  Scenario: SIT | View Failure Preview | Viewing activity | Failure Preview Selection - Prescriber Search
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks prescriber search in left side navigation menu
    Then System should display prescriber search page
    And the user clicks on the notification alert icon 
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Prescriber Search screen user is viewing still remains open 
		When the user clicks on the notification alert icon
		Then the system opens the failure preview
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Prescriber Search screen user is viewing still remains open  
		When User enters prescriber first name and last name on prescriber search page
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search on prescriber search page
    Then prescriber search results should be displayed
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |  
    And the user clicks on the notification alert icon 
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Prescriber Search Results screen user is viewing still remains open 
		When the user clicks on the notification alert icon
		Then the system opens the failure preview
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Prescriber Search Results screen user is viewing still remains open
		When User clicks view button from prescriver Search
		And the user clicks on the notification alert icon 
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Prescriber Details screen user is viewing still remains open
		When the user clicks on the notification alert icon
		Then the system opens the failure preview
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Prescriber Details screen user is viewing still remains open
		
		@RXQE-7535 @Joust @Regression @OnlyIntake
  Scenario: SIT | View Failure Preview | Viewing activity | Failure Preview Selection - Plan Search
		 Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks plan search button in left side menu
    Then System should display plan search page
    And the user clicks on the notification alert icon 
		Then the system opens the failure preview
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Intake_Fail |		 
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Plan Search screen user is viewing still remains open 
		When the user clicks on the notification alert icon
		Then the system opens the failure preview
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Plan Search screen user is viewing still remains open
		When User enters plan name in the text box labeled plan name
      | InputFileName | SheetName | RowId   |
      | TestData      | plan      | Row_one |
    And clicks search button on plan search page
    Then plan results should be displayed
      | InputFileName | SheetName | RowId   |
      | TestData      | plan      | Row_one |
      And the user clicks on the notification alert icon 
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Plan Search screen user is viewing still remains open 
		When the user clicks on the notification alert icon
		Then the system opens the failure preview
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Plan Search screen user is viewing still remains open 
		
		@RXQE-7549 @Joust @Regression @OnlyIntake
  Scenario: SIT | View Failure Preview | Viewing activity | Failure Preview Selection - POS
		 Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User navigates to patient order status
    Then System should display POS page
    And the user clicks on the notification alert icon 
		Then the system opens the failure preview 
		When clicks on See All button
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Patient Order Status screen user is viewing still remains open
		When the user clicks on the notification alert icon
		Then the system opens the failure preview
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		And the Patient Order Status screen user is viewing still remains open
		And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User clicks search button on patient order status
    And the user clicks on the notification alert icon 
		Then the system opens the failure preview 
		When clicks on See All button
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Patient Order Status screen user is viewing still remains open
		When the user clicks on the notification alert icon
		Then the system opens the failure preview
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Patient Order Status screen user is viewing still remains open
		
		@RXQE-7552 @Joust @Regression @OnlyIntake
  Scenario: SIT | View Failure Preview | Viewing activity | Failure Preview Selection - My Profile
		Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on the user profile icon on top left on the navigation panel
		Then User validating team member profile
    And the user clicks on the notification alert icon 
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Employee Information screen user is viewing still remains open
		When the user clicks on the notification alert icon
		Then the system opens the failure preview
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		And the Employee Information screen user is viewing still remains open
		When the user clicks on the Team Member tab
		Then the system should display the list of team members
    And the user clicks on the notification alert icon 
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Team Members screen user is viewing still remains open 
		When the user clicks on the notification alert icon
		Then the system opens the failure preview
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		And the Team Members screen user is viewing still remains open 
		
		@RXQE-7565 @Joust @Regression @OnlyIntake
  Scenario: SIT | View Failure Preview | Task activity| Failure Preview Selection | DR Task
   Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   			|
      | TestData      | patient   | Row_RXQE_7565 |
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
      | InputFileName | SheetName | RowId   			|
      | TestData      | patient   | Row_RXQE_7565 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   			|
      | TestData      | patient   | Row_RXQE_7565 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   			|
      | TestData      | patient   | Row_RXQE_7565 |
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
      | InputFileName | SheetName | RowId   			|
      | TestData      | patient   | Row_RXQE_7565 |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data 
     And the user clicks on the notification alert icon 
		Then the system opens the failure preview 
		When clicks on See All button or create intake
      | InputFileName | SheetName | RowId        		|
      | TestData      | patient   | Row_Intake_Fail |
		And the system closes the failure preview
		And the system brings the user to the failure queue overlay 
		And the focus is on first failure in the queue
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Data Review screen user is viewing still remains open 
		When the user clicks on the notification alert icon
		Then the system opens the failure preview
		When user clicks or selects Enter on a failure in the failure preview
		And the system closes the failure preview 
		And the system brings the user to the failure queue overlay 
		And the focus is on user selected failure
		When the user clicks on the X button of the Failure Preview Overlay
		Then the Failure Preview Overlay is closed
		And the Data Review screen user is viewing still remains open 
    
    @RXQE-7762 @Joust @Regression @OnlyIntake
  	Scenario: SIT | View Bucket of Failure Queue | Page load and Multiple selection
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    And User clicks failure notification Icon
    Then System should display failure preview
    When User selects a failure task from the list of failure tasks
    Then System displays failure queue
    And the selected failure should be highlighted
    #And the most recent failure, that has occurred for a prescription and for that store user is logged in, is displayed on top.
    And all the failures are displayed in the descending order based on creation date and time
    And the user tries to select another failure in the queue
    Then the system will not allow the user to select multiple failures at the same time
    And system deselects the previous selection and selects the new one
    
    @RXQE-7713 @Joust @Regression @OnlyIntake @rerunallfail1
  Scenario: SIT | View Bucket of Failure Queue| HOT Keys and Tab Order
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When user hits HOT Keys Ctrl + E 
    Then System should display failure preview
    When User hits Enter Key
    Then System displays failure queue
    And Focus is on the first failure
    When User hits alt plus c hotkey
    Then failure queue should be closed
    And User clicks failure notification Icon
    Then System should display failure preview
    When User selects a failure task from the list of failure tasks
    Then System displays failure queue
    And the selected failure should be highlighted
    When User hits ALT plus D hotkey
    Then System should display an alert "Have you already resolved this error in IC+?"
    When User hits alt plus c hotkey
    Then the popup should be closed
    Then System displays failure queue
    And the selected failure should be highlighted
    And get total number of failures in the failure queue overlay
    When User hits ALT plus D hotkey
    Then System should display an alert "Have you already resolved this error in IC+?"
    When User hits ALT plus Y hotkey
    Then selected failure should be deleted from the failure queue
    When User hits alt plus c hotkey
    And User clicks failure notification Icon
    Then System should display failure preview
    #And failure deleted in system error list should be deleted from failure preview
    When User selects a failure task from the list of failure tasks
    Then System displays failure queue
    When User hits down arrow Key
    Then User should be able to navigate to next failure in the failure queue
    When User hits Up arrow key
    Then User should be able to navigate to previous failure in the failure queue
    When User hits TAB key
    Then User should be able to navigate to next failure in the failure queue
    When User hits TAB while focus is on the last failure
    Then focus should be shifted to X button
    When User hits Enter Key
    Then failure queue should be closed
    
      @RXQE-7763 @Joust @Regression
     Scenario: SIT | View Bucket of Failure Queue | Delete a failure
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks failure notification Icon
    Then System should display failure preview
    When User selects a failure task from the list of failure tasks
    Then System displays failure queue
    And the selected failure should be highlighted
    When User clicks delete button on the failure highlighted
    Then System should display an alert "Have you already resolved this error in IC+?"
    When User clicks cancel button on the alert
    Then the popup should be closed
    Then System displays failure queue
    And the selected failure should be highlighted
    And get total number of failures in the failure queue overlay
    When User clicks delete button on the failure highlighted
    Then System should display an alert "Have you already resolved this error in IC+?"
    When User clicks Yes button on the alert
    Then selected failure should be deleted from the failure queue
     When the user clicks on the X button of the Failure Preview Overlay
    And User clicks failure notification Icon
    Then System should display failure preview
    When User selects a failure task from the list of failure tasks
    Then System displays failure queue
    And User deletes all the failure tasks
    Then A message "You're all caught up!" should be seen on the failure overlay
    When the user clicks on the X button of the Failure Preview Overlay
    And User clicks failure notification Icon
    Then A message "You're all caught up!" should be seen on the failure preview
