@medhistory @Regressiontest
Feature: Med History 

@RXAPPD-12999 @Regression @MedhistoryOnly
  Scenario: View Rx History Summary - To verify that only one panel can be expanded at a time
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    Then System should navigate to Medication History Screen
    And system displays the Patient Med History tab visible and active
    When user select the First zone around the Expand button of Prescription
    Then the system shows the first panel expanded
    When  user select the Second zone around the Expand button of Prescription
    Then system shows the first panel collapsed 
    And the system shows the second panel expanded
    
    @RXAPPD-13001 @Regression @MedhistoryOnly
  Scenario: system displays the Patient Med History tab visible and active 
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    Then System should navigate to Medication History Screen
    And system displays the Patient Med History tab visible and active
   
   #Only Skeleton created 
    @RXAPPD-13002 @Regression @MedhistoryOnly
  Scenario: verify View History Summary after a first fill deleted
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    Then System should navigate to Medication History Screen
    #And system does not displayed in the View History Summary screen
    
    
    #No data available & only skelton created
    #@RXAPPD-13003
  #Scenario: system displays the Patient Med History tab hidden 
#Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_one |
    #And User clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_one |
    #And clicks search button on patient search page
    #Then System should display patient search results
    #And Select a patient
    #When User clicks view button
    #Then System should navigate to Patient Profile Screen
    #When User click on Med History Tab from patient profile page
    #Then System should navigate to Medication History Screen
    #And System displays the Patient Med History tab hidden
    
    @RXAPPD-13004 @Regression @MedhistoryOnly
  Scenario: Rx History tab in the Patient Med History tab enabled 
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    Then System should navigate to Medication History Screen
    And system displays the Patient Med History tab Enable
    
     @RXAPPD-13005 @Regression @MedhistoryOnly
  Scenario: Verify that the system displays hyperlinks enabled 
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    Then System should navigate to Medication History Screen
    And system displays the Patient Med History tab visible and active
    
     @RXAPPD-13006 @Regression @MedhistoryOnly
  Scenario: View Rx History Summary - To verify View History Summary for an order according to the status
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    Then System should navigate to Medication History Screen
    #And verify View History Summary for an order according to the label status
    
     #@RXAPPD-13070
  #Scenario: Check the History tab if no Rx history exists in View Mode
#Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_one |
    #And User clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_one |
    #And clicks search button on patient search page
    #Then System should display patient search results
    #And Select a patient
    #When User clicks view button
    #Then System should navigate to Patient Profile Screen
    #When User click on Med History Tab from patient profile page
    #Then System should navigate to Medication History Screen
    #Data not available for this steps
    #And System shows a message No Rx history on file
    
    #RXAPPD-13076
    @RXAPPD-13071 @Regression @MedhistoryOnly
  Scenario: Check the status hyperlink for a prescription
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    Then System should navigate to Medication History Screen
    And System displays the Status field In Progress as a hyperlink
    And System displays a green dot over the hyperlink
    
     @RXAPPD-13074 @Regression @MedhistoryOnly
  Scenario: Check the status hyperlink for more prescriptions In Progress
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    Then System should navigate to Medication History Screen
    And System displays the Status field In Progress as a hyperlink
    And System displays a green dot over the hyperlink
    When User selects the Status hyperlink
    Then System should display patient order status page
    And displays all the active fills highlighted for the previously selected prescription
    
     @RXAPPD-13075 @Regression @MedhistoryOnly
  Scenario: Check the status hyperlink for a prescription RxMS In Pending status
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    Then System should navigate to Medication History Screen
    And System displays the Status field Pending as a hyperlink
    And System displays a green dot over the hyperlink
       
       #@RXAPPD-13077
  #Scenario: Check the external prescriptions in read-only mode
#Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_one |
    #And User clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_one |
    #And clicks search button on patient search page
    #Then System should display patient search results
    #And Select a patient
    #When User clicks view button
    #Then System should navigate to Patient Profile Screen
    #When User click on Med History Tab from patient profile page
    #Then System should navigate to Medication History Screen
    #Then the system displays the prescription information in read only mode
       #And enables the checkbox
       #And does not display the dedicated inverted triangle
       #And fills the row with a halftone pattern
       
       #RXAPPD-13079
       #@RXAPPD-13078
  #Scenario: Display a prescription that has no active fill and Most recent filled
#Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_one |
    #And User clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_one |
    #And clicks search button on patient search page
    #Then System should display patient search results
    #And Select a patient
    #When User clicks view button
    #Then System should navigate to Patient Profile Screen
    #When User click on Med History Tab from patient profile page
    #And the user selects a prescription
       #Then the system displays the most recent sold information for this prescription
    
    @RXAPPD-12986 @Regression @MedhistoryOnly
  Scenario: View Rx History Summary - To verify that it is possible to display Last Fill Date column populated
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    Then System should navigate to Medication History Screen
    And System displays the Medication History Screen with Last Fill Date column populated 
    And User closes the application
    
    #@RXAPPD-12987
  #Scenario: View Rx History Summary - To verify that it is possible to display Last Fill Date column empty provided by IC+
   #Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_one |
    #And User clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_one |
    #And clicks search button on patient search page
    #Then System should display patient search results
    #And Select a patient
    #When User clicks view button
    #Then System should navigate to Patient Profile Screen
    #When User click on Med History Tab from patient profile page
    #Then System should navigate to Medication History Screen
    #And System displays the Medication History Screen with Last Fill Date column empty
    #And User closes the application
    
    #Data not available
    #@RXAPPD-12988
  #Scenario: View Rx History Summary - To verify that it is possible to display Rx Number of a prescription in RxMS system as hyperlink 
    #Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_one |
    #And User clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_one |
    #And clicks search button on patient search page
    #Then System should display patient search results
    #And Select a patient
    #When User clicks view button
    #Then System should navigate to Patient Profile Screen
    #When User click on Med History Tab from patient profile page
    #Then System should navigate to Medication History Screen
    #And System displays the Rx Number as hyperlink
    #And User closes the application
    
    @RXAPPD-12989 @Regression @MedhistoryOnly
  Scenario: View Rx History Summary - To verify that it is possible to display Last Fill Date column empty       
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    Then System should navigate to Medication History Screen
    #And System displays the "Medication History" Screen with Last Fill Date column empty
    And User closes the application
    
    #@RXAPPD-12991
  #Scenario: View Rx History Summary - To verify that it is possible to display external prescriptions
   #Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_one |
    #And User clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_one |
    #And clicks search button on patient search page
    #Then System should display patient search results
    #And Select a patient
    #When User clicks view button
    #Then System should navigate to Patient Profile Screen
    #When User click on Med History Tab from patient profile page
    #Then System should navigate to Medication History Screen
    #Then System displays the Prescription row as a external prescription
    #And System does not display the expanded panel
    #And System does not display the expand button
    #And User closes the application
    
    #Skelton completed
       #@RXAPPD-13080
  #Scenario: Not display the fill information for any other fills
#Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_one |
    #And User clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_one |
    #And clicks search button on patient search page
    #Then System should display patient search results
    #And Select a patient
    #When User clicks view button
    #Then System should navigate to Patient Profile Screen
    #When User click on Med History Tab from patient profile page
    #And User selects a prescription
       #Then System does not display the fill information for any other fills for selected prescription
       
       @RXAPPD-13081 @Regression @MedhistoryOnly
  Scenario: Verify the focus on the checkbox of the first row by default
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    #Then System shows the focus on the check box of the first row by default
    #And Check box will not be selected
    
    #@RXAPPD-13082
  #Scenario: Select multiple prescriptions for a patient
#Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_one |
    #And User clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_one |
    #And clicks search button on patient search page
    #Then System should display patient search results
    #And Select a patient
    #When User clicks view button
    #Then System should navigate to Patient Profile Screen
    #When User click on Med History Tab from patient profile page
    #Then prescriptions for a Patient are displayed
    #When User selects multiple prescriptions
    #Then System shows the check boxes selected for multiple prescriptions
    
    
    #@RXAPPD-13092 @RXAPPD-13093
  #Scenario: Verify the prescription with Qty Remaining greater than "0"
#Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_one |
    #And User clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_one |
    #And clicks search button on patient search page
    #Then System should display patient search results
    #And Select a patient
    #When User clicks view button
    #Then System should navigate to Patient Profile Screen
    #When User click on Med History Tab from patient profile page
    #Data not available for below steps
    #Then System displays Refillable in the Status column for a Prescription sent to IC+ 
    #And Qty Remaining greater than Zero
    
    #Only Skelton created
     #@RXAPPD-13094
  #Scenario: Verify the Order Status "in Pending" when the script is sent to IC+
#Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_one |
    #And User clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_one |
    #And clicks search button on patient search page
    #Then System should display patient search results
    #And Select a patient
    #When User clicks view button
    #Then System should navigate to Patient Profile Screen
    #When User click on Med History Tab from patient profile page
    #Then System does not display the order status
    
   #Only skelton created 
    #@RXAPPD-13095
  #Scenario: Verify the prescription no Qty Remaining
#Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_one |
    #And User clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_one |
    #And clicks search button on patient search page
    #Then System should display patient search results
    #And Select a patient
    #When User clicks view button
    #Then System should navigate to Patient Profile Screen
    #When User click on Med History Tab from patient profile page
    #Then System displays Prescriber Auth Req in the Status column
    #And it has no qty Remaining
    
     #Only skelton created
    #@RXAPPD-13096
  #Scenario: Verify the prescription no Refills Remaining
#Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_one |
    #And User clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_one |
    #And clicks search button on patient search page
    #Then System should display patient search results
    #And Select a patient
    #When User clicks view button
    #Then System should navigate to Patient Profile Screen
    #When User click on Med History Tab from patient profile page
    #Then System displays Prescriber Auth Req in the Status column
    #And it has no Refills Remaining
    
    
     #Only skelton created
     #@RXAPPD-13097
  #Scenario: Verify the prescription expired sent to IC+
#Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_one |
    #And User clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_one |
    #And clicks search button on patient search page
    #Then System should display patient search results
    #And Select a patient
    #When User clicks view button
    #Then System should navigate to Patient Profile Screen
    #When User click on Med History Tab from patient profile page
    #Then System displays Prescriber Auth Req in the Status column
    #And it is expired
    
    @RXAPPD-13098 @Regression @MedhistoryOnly
  Scenario: Verify any fill for a prescription in Patient Order Status
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    Then System displays the RxMS Prescription dispensing Team Member status as a hyperlink
    And System displays a green dot over the hyperlink
    
    #Only skelton created
     #@RXAPPD-13099
  #Scenario:  Verify a prescription that has kicked back to IC+
#Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_one |
    #And User clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_one |
    #And clicks search button on patient search page
    #Then System should display patient search results
    #And Select a patient
    #When User clicks view button
    #Then System should navigate to Patient Profile Screen
    #When User click on Med History Tab from patient profile page
    #Then System reflects the Prescription status not the Fill
       #And Status will be read only no hyperlink
    
       
       @RXAPPD-13822 @Regression @MedhistoryOnly
  Scenario: View Prescription Summary - To verify that it is possible to display a prescription order and a Team Member status correctly with a Data Entry complited
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
      | TestData  | patient   | Row_Five |
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
      | TestData  | patient   | Row_Five |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_Five |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_Five |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And user open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    Then System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_Five |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    
    #commited by shiva
    @RXAPPD-13102
  Scenario: UI- View Rx History Summary screen
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks Med history tab
    Then System should display all buttons
    #and lablels
    And User closes the application
    
    @RXAPPD-13091
  Scenario: User clicks Transfer Button
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks Med history tab
    And User clicks Transfer button
    Then System displays a message -- This function cannot be completed in IC+
    And User closes the application

  @RXAPPD-13089
  Scenario: USer clicks Reprint Button on Med history page
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks Med history tab
    And Uer clicks Reprint button
    Then System displays a message -- This function cannot be completed in IC+
    And User closes the application

  @RXAPPD-13088
  Scenario: User clicks Add refill Button on Med History page
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
      | TestData  | patient   | Row_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks Med history tab
    And User clicks Add refill button
    Then System displays a message -- This function cannot be completed in IC+
    And User closes the application
    #MSKEND
    
    @RXQE-5726 @IkariWarriors @Regression @MedhistoryOnly
  Scenario: SIT | Med History | View Additional Medications
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
      | TestData      | patient   | Row_Intake_7 |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    Then System should navigate to Medication History Screen
    When User clicks Additional Medication tab
    Then System should display Additional Medication screen
    Then User clicks Additional Medication tab and validate result with number of additional Meds

    @RXQE-5773 @RXQE-5790 @RXQE-5731 @IkariWarriors @Regression @MedhistoryOnly
		Scenario: SIT | Med History | View Additional Medications | No additional Medications
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
      | TestData  | patient   | Row_Four |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    Then System should navigate to Medication History Screen
    When User clicks Additional Medication tab
    Then System should display Additional Medication screen
    And Additional Medication screen should display No Additional Meds
    
@RXQE-5758 @IkariWarriors @Regression @MedhistoryOnly
  Scenario: SIT| Patient view | View patient with Additional medication
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData  		| login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId          |
      | TestData      | patient   | Row_RXQE5777   |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
    Then Validate Medication History has default Rx History tab 
    Then User clicks Additional Medication tab and validate result with number of additional Meds

		@RXQE-5760 @IkariWarriors @Regression @MedhistoryOnly
  	Scenario: SIT | Med History | Update Additional Medications
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
      | TestData  | patient   | Row_AddMed |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    When User click on Med History Tab from patient profile page
  #Then System should navigate to Medication History Screen
    Then Validate Medication History has default Rx History tab
    Then User clicks Additional Medication tab and validate result with number of additional Meds
    When User clicks Additional Meds Update button
    Then System should allow user to update Additional Meds
		
@RXQE-5785 @IkariWarriors @Regression @MedhistoryOnly
  Scenario: SIT| Patient view | View patient with Allergy and health condition confirmed with patient
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData  		| login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   		|
      | TestData  		| patient   | Row_RXQE5785 	|
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    And User should see the message "Confirm Allergies" in "Allergy Name" section
    And User should see the message "Confirm Health Conditions" in "Health Conditions" section

@RXQE-5764 @IkariWarriors @Regression @MedhistoryOnly
  Scenario: SIT| Patient view |View patient without Allergies
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData  		| login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   				|
      | TestData  		| patient   | Row_No_Allergy 	|
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    And User should see the message "No Allergies" in "Allergy Name" section

@RXQE-5801 @IkariWarriors @RXQE-5756 @Regression @MedhistoryOnly
  Scenario: SIT| Patient view |View Patient without Plan information SIT| Patient view| View Patient without Primary Plan 
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData  		| login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_No_Plan |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    And User should see the message "No 3rd Party Plan Information" in "Plan Summary" section

@RXQE-5847 @IkariWarriors @Regression @MedhistoryOnly
  Scenario: SIT| Patient view| View Deceased patient 
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData  		| login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   		|
      | TestData  		| patient   | Row_Deceased |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    And User should see Deceased text on the profile page
    And User should not see the following fields:
    	| Weight       						|
      | Visually Impaired   		|
      | Hearing Impaired				|
      | Pet and Pet Species			|
    And User should not see Intake button

@RXQE-5777 @RXQE-5768 @IkariWarriors @Regression @MedhistoryOnly
  Scenario: SIT| Patient view| View Patient without clinical information
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData  		| login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   			|
      | TestData  		| patient   | Row_RXQE5777	|
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    And User should see the message "No Allergies" in "Allergy Name" section
    And User should see the message "No Health Conditions" in "Health Conditions" section    	
	        		    

@RXQE-5808 @IkariWarriors @Regression @MedhistoryOnly
  Scenario: SIT| Patient view|No all XX Plans
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData  		| login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   		|
      | TestData  		| patient   | Row_AM_One 	|
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    And User should see the message "View All " in "Plan Summary Bottom" section
    When User tries to navigate back to patient search results
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   		|
      | TestData  		| patient   | Row_No_Plan	|
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    Then System should navigate to Patient Profile Screen
    And User should not see the message "View all " in "Plan Summary Bottom" section


@RXQE-5732 @IkariWarriors @Regression @MedhistoryOnly
  Scenario: SIT| Update View | View Patient with primary plan 
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData  		| login     | Row_one |
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
    Then System should navigate to Patient Profile Screen
    And User should see following fields in Plan Summary section:
    	| Plan ID       	|
      | Recipient ID   	|
      | Group ID				|    

@RXQE-5817 @IkariWarriors @Regression @MedhistoryOnly
  Scenario: SIT|Patient view | View all XX Plans link 
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData  		| login     | Row_one |
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
    Then System should navigate to Patient Profile Screen
    And User should see following fields in Plan Summary section:
    	| Plan ID       	|
      | Recipient ID   	|
      | Group ID				|        		        		   
    When User clicks on View all plans link
    Then User will be on Third party plans

@RXQE-5735 @IkariWarriors @Regression @MedhistoryOnly
  Scenario: SIT| Patient view| View Patient all fields and Icons populated in Update mode 
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData  		| login     | Row_one |
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
    Then System should navigate to Patient Profile Screen
    When User clicks update button
    Then User should see patient details on demographic tab
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    		        		    