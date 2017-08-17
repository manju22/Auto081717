@datareview @Regressiontest
Feature: data review

  @RXQE-1744 @E2E @Regression
  Scenario: E2E - Task Creation - DR task Without Clicking 3 accept
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
      | TestData      | patient   | Row_DR_one |
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
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And click on Finish to complete Data Review
    #And clicks Finish to complete data review
    Then Alert message should be displayed states that Vaildation is not done, please validate

  @RXQE-1701 @RXQE-1775 @E2E @Regression
  Scenario: E2E - Data Entry - Determine Payment Method - Cash
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
      | TestData      | patient   | Row_DR_one |
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
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review

  #Then Number of DR tasks should be decreased
  @RXQE-1810 @E2E @Regression
  Scenario: E2E | Data Entry | REMS,Quality & Safety Checks | Verify Pop-up Message is displayed in DE and DR for REMS Drug
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
      | TestData      | patient   | Row_DR_one |
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
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    When User selects a Rems or LDD drug
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_two |
    Then I should see REMS popup message
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    When User updates product data with rems drug in data review screen
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_two |
    Then System should display an alert asking to continue this task on ICplus

  #And clicks third accept to validate product data
  #And User clicks send to ICplus Button on DR page
  #And User clicks search button on patient order status
  #Then prescription status should be check ICplus in patient order status
  #| InputFileName | SheetName | RowId   |
  #| TestData  | patient   | Row_DR_one |
  @RXQE-1803 @RXQE-2564 @RXQE-2565 @RXQE-2566 @RXQE-2577 @RXQE-2573 @RXQE-2841 @E2E @P1 @Regression
  Scenario: iPledge pop-up in DE and DR
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
      | TestData      | patient   | Row_DR_two |
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
      | TestData      | patient   | Row_DR_two |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_two |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_two |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    When User selects a Rems or LDD drug
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_two |
    Then I should see REMS popup message
    When User enters an LDD drug during data entry
      | InputFileName | SheetName | RowId        |
      | TestData      | product   | Row_DR_three |
    Then I should see REMS popup message
    When User enters Sound alike drug during data entry
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_DR_four |
    Then System should display a caution message
    And enters product information
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_two |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    #And clicks third accept to validate product data
    #When User clicks update to update the product data
    #| InputFileName | SheetName   | RowId   |
    #| TestData  | product     | Row_DR_five |
    #Then product data should be updated
    #| InputFileName | SheetName   | RowId   |
    #| TestData  | product  | Row_DR_five |
    When User updates product data with rems drug in data review screen
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_two |
    Then System should display an alert asking to continue this task on ICplus
    #And System should display data review page
    When User updates product data with LDD drug in data review
      | InputFileName | SheetName | RowId        |
      | TestData      | product   | Row_DR_three |
    Then System should display an alert asking to continue this task on ICplus
    #And User clicks cancel button on the rems alert
    When User enters sound alike during data review
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_DR_four |
    Then System should display a caution message
    And User closes the application

  @RXQE-1737 @RXQE-2572 @E2E @P1 @Regression
  Scenario: Update the prescriber and product data in DR
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
      | TestData      | patient   | Row_DR_one |
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
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks first accept to validate patient data
    When User clicks search button to update prescriber
    Then prescriber search page should be displayed from DR
    When User enters prescriber first name and Last name from DR
      | InputFileName | SheetName  | RowId       |
      | TestData      | prescriber | Row_DR_five |
    And User selects null value in the state dropdown in DR
    And clicks search button on prescriber search in DR
    And clicks select to select a prescriber
    And clicks second accept to validate prescriber data
    When User clicks update to update the product data
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_DR_five |
    #Then product data should be updated
    #| InputFileName | SheetName   | RowId   |
    #| TestData  | product   |  Row_DR_five |
    And clicks third accept to validate product data
    When clicks Finish to complete data review
    #Then Number of DR tasks should be decreased
    #Then A clinical evaluation task should get created
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User closes the application

  @RXQE-1909 @Regression
  Scenario: E2E | Data Review
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
      | TestData      | patient   | Row_DR_one |
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
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    When User clicks update to update the product data
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_DR_five |
    And clicks third accept to validate product data
    When clicks Finish to complete data review
    #Then Number of DR tasks should be decreased
    #Then A clinical evaluation task should get created
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User closes the application

  @RXQE-2997 @E2E @Regression
  Scenario: E2E | Prescription History | View Med History from DUR
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
      | TestData      | patient   | Row_DR_two |
    And clicks search button on patient search page
    Then System should display patient search results
    Then I am able to see following fields:
      | Last Name     |
      | First Name    |
      | Phone Number  |
      | Date of Birth |
    And I should be able to see "Search" "View" and "Update" buttons
    Then I am able to see following fields:
      | Name          |
      | Phone Number  |
      | Date of Birth |
      | Address       |
    #And Select a patient
    When User clicks view button
    Then I am able to see following fields:
      | 3rd Party Plans  |
      | Preferences      |
      | Images           |
      | Med History      |
      | Clinical History |
      | General Info     |
      | Intake Rx        |
      | Update           |
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    Then I am able to see following fields:
      | Origin Code |
      | Pickup Time |
      | Finish      |
      | Cancel      |
    When User selects pickup time as waiting
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    #Then Data Entry task should be created
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_two |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_two |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_two |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    Then I am able to see following fields:
      | Last Name    |
      | First Name   |
      | Phone Number |
      | Add Rx       |
      | Finish       |
      | Send to IC+  |
      | Cancel       |
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_two |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    Then I am able to see following fields:
      | 1 Accept    |
      | 2 Accept    |
      | Search      |
      | 3 Accept    |
      | Update      |
      | Finish      |
      | Send to IC+ |
      | Cancel      |
    When User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    #Then Number of DR tasks should be decreased
    #Then A clinical evaluation task should get created
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_two |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_two |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then I am able to see following fields:
      | Rx Details          |
      | Patient Information |
      | Allergies           |
      | Health Conditions   |
      | Med History         |
      | Clinical History    |
      | Clinical References |
      | Interactions        |
    When I clicks Med History
    Then I clicks Additional Medications
    #Then I should not see following fields:
    #| Reprint         			|
    #| Inactive       				|
    #| Transfer							|
    #| Close									|
    And I should see "No Additional medications have been added."

  #@RXAPPD-12086
  #Scenario: Verify Retail Pharmacy Manager role for Data Review Task
  #Given I logged in as Retail Manager
  #And I enter username and password
  #| InputFileName | SheetName | RowId  |
  #| TestData   | Login     | RowTwo |
  #And clicks login button
  #Then System should display RxMS home page
  #When User clicks on patient tab in left side menu
  #Then System should navigate to patient search page
  #When User enters patient First Name and Last Name
  #| InputFileName      | SheetName     | RowId   |
  #| TestData | Patient_input | Rowfive |
  #And I click on Search button
  #Then System should display patient search results
  #When User clicks view button
  #And clicks intake Rx
  #Then System should navigate to Intake Method Screen
  #When User selects pickup time as waiting
  #And selects origin code as Scan
  #And clicks Finish button in intake method screen
  #When User navigates to patient order status
  #And User enters patient last name in POS last name text box
  #| InputFileName | SheetName | RowId   |
  #| TestData  | patient   | Row_DR_one |
  #And User enters patient phone number in POS phone number text box
  #| InputFileName | SheetName | RowId   |
  #| TestData  | patient   | Row_DR_one |
  #And User clicks search button on patient order status
  #Then The pending link for current prescription should be clicked
  #| InputFileName | SheetName | RowId   |
  #| TestData  | patient   | Row_DR_one |
  #Then System displays a donut chart
  #When User clicks perform data entry hyperlink
  #Then Sytem should display data entry page
  #When User enters prescriber first name and Last name
  #| InputFileName | SheetName  | RowId   |
  #| TestData  | prescriber | Row_one |
  #And clicks search button on prescriber search
  #And clicks select to select a prescriber
  ##And clicks open product button
  #And enters product information
  #| InputFileName | SheetName | RowId   |
  #| TestData  | product   | Row_one |
  #And clicks open payment button
  #And selects payment type
  #And clicks Finish button to complete Data Entry
  #When User clicks log out button in left side navigation menu
  #Then System should display the login page
  #Given Pharmacy user launches the RxMS application
  #When Pharmacy user enters valid credentials
  #| InputFileName | SheetName | RowId   |
  #| TestData  | login     | Row_one |
  #And clicks login button
  #And System should display patient order status page
  #And clicks search button on patient order status page
  #And The In progress link for current prescription should be clicked
  #| InputFileName | SheetName | RowId   |
  #| TestData  | patient   | Row_DR_one |
  #Then System displays a donut chart
  #When User clicks perform data review hyperlink
  #Then System should display data review page
  #And User clicks first accept to validate patient data
  #And clicks second accept to validate prescriber data
  #And clicks third accept to validate product data
  #And clicks Finish to complete data review
  @RXUAT-236 @UAT @Regression
  Scenario: Notify User of Quality Alerts
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
      | TestData      | patient   | Row_DR_two |
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
      | TestData      | patient   | Row_DR_two |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_two |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_two |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    When User is selecting a dispensed drug during the Data Entry
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_six |
    Then System displays quality alert message and a quality alert screen indicator of S or B associated
    When click on Ok in quality alert message
    And enters product information
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_two |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    When User clicks update to update the product data
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_DR_five |
    When User is selecting a dispensed drug during the data review screen
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_DR_five |
    Then System displays quality alert message and a quality alert screen indicator of S or B associated
    When click on Ok in quality alert message
    And clicks third accept to validate product data
    When User is selecting a dispensed drug during the data review screen
      | InputFileName | SheetName | RowId        |
      | TestData      | product   | Row_DR_eight |
    Then System should not displays quality alert message

  @RXUAT-22 @Grandprix_UAT @rxnew @UAT
  Scenario: View Task Board
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId    |
      | TestData      | login     | Row_TECH |
    And User clicks login button
    Then System should display RxMS home page
    And I should see Task board is expanded
    And I should see following tabs:
      | Data Entry           |
      | Data Review          |
      | Clinical Evaluation  |
      | Filling              |
      | Product Verification |
    And I am not able to access DR Screen
    And I click on logout button
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_DR_five |
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
    And I should see priority icon in DE
    When User clicks on patient tab in left side menu
    And the task board is collapsed
    When I click on taskboard
    And the task board is expanded
    When I click on home button
    And the task board is expanded
    When User hits ctrl plus one hot key
    Then System should navigate to DE screen or System shows a pop-up if there are no DE tasks
    #When User clicks on patient tab in left side menu
    #And I click yes on popup window
    #Then system displays the following message All changes will be lost Do you want to proceed
    When User hits ctrl plus two hot key
    Then System should navigate to DR screen or System shows a pop-up if there are no DR tasks
    And User clicks Filling task in taskboard
    And System should display message that Use the Mobile Device to complete Filling
    And User closes the application

  @RXUAT-243 @UAT @Regression
  Scenario: Accept a Rejected Response from payor
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
      | TestData      | patient   | Row_DR_six |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And click on intake
    Then System should navigate to Intake Method Screen
    And clicks Finish button in intake method screen
    #Then Data Entry task should be created
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_six |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_six |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_six |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId       |
      | TestData      | prescriber | Row_DR_five |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId        |
      | TestData      | Product   | Row_DR_seven |
    #And clicks open payment button
    #And selects payment type plan
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_six |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_six |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_six |
    And User clicks search button on patient order status
    And clicks search button on patient order status page
    #Then System should generate a Rx number and Ic plus status for current prescriptionone
    #| InputFileName 	  | SheetName 		| RowId   |
    #| TestData  | patientsearch | Row_five |
    Then The pending link for current prescription should say check IC
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_six |

  @RXUAT-2 @UAT
  Scenario: Role Management - Data Review
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId    |
      | TestData      | login     | Row_TECH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
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
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    And I am not able to access DR screen
    And I close the DR screen
    And User closes the application
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId       |
      | TestData      | Login     | Row_manager |
    #When User enters the valid credentials in login text fields
    #| InputFileName | SheetName | RowId   |
    #| TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And User closes the application
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
      | TestData      | patient   | Row_DR_seven |
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
      | TestData      | patient   | Row_DR_seven |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_DR_seven |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_DR_seven |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And clicks search button on prescriber search
    And user click view button system displays prescriber details page
    And user validate the Prescriber details page and navigate back
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_one |
    And clicks open payment button
    And selects payment type
    And click on Finish to complete Data Review

  @RXUAT-6 @Grandprix_UAT @UAT @Regression
  Scenario: Prescription fulfillment
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId    |
      | TestData      | login     | Row_TECH |
    And User clicks login button
    Then System should display RxMS home page
    Then I should not be able to click on DR from taskboard
    When User hits ctrl plus two hot key
    Then I should not see DR screen
    And I click on logout button
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    Then I should be able to click on DR from taskboard
    When I click on back button from DR screen
    Then I should click yes
    When User hits ctrl plus two hot key
    Then I should see DR screen

  @RXUAT-186 @UAT @Regression
  Scenario: Rework for hybrid
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
      | TestData      | patient   | Row_DR_six |
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
      | TestData      | patient   | Row_DR_six |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_six |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_six |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId       |
      | TestData      | prescriber | Row_DR_five |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enter the product information
      | InputFileName | SheetName | RowId        |
      | TestData      | product   | Row_DR_eight |
    And clicks open payment button
    #And selects payment type plan
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_six |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And user edits paycode for one
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_DR_nine |
    And user edits paycode for two
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_ten |
    And user edits paycode for zero
      | InputFileName | SheetName | RowId        |
      | TestData      | product   | Row_DR_eight |
    And user selects a rems drug
      | InputFileName | SheetName | RowId         |
      | TestData      | product   | Row_DR_eleven |
    And User closes the application

  @RXUAT-242 @UAT @Regression
  Scenario: createPrescriptionResponse - REWORK for DUR info and fail-over scenarios - Patient Order Status
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
      | TestData      | patient   | Row_DR_six |
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
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_six |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_six |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_six |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId       |
      | TestData      | prescriber | Row_DR_five |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId        |
      | TestData      | Product   | Row_DR_seven |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_six |
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
    Then The pending link for current prescription should say check IC
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_six |

  @RXQE-3397 @E2E
  Scenario: Task Prioritization- DR task
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
      | TestData      | patient   | Row_DR_eight |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as later with todays date
    And selects origin code as Scan
    And clicks Finish button in intake method screen
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_DR_nine |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as later with tomorrows date
    When user selects fax field
    And clicks Finish button in intake method screen
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_ten |
    And User selects null value in the state dropdown
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    When User selects pickup time as waiting
    When user selects phone field
    And clicks Finish button in intake method screen
    Then System should display RxMS home page
    When User clicks DE task in the taskboard
    Then Sytem should display data entry page
    #Then System should navigate to DE screen or System shows a pop-up if there are no DE tasks
    And User validate the patient name and contact number
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_DR_eight |
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    When User hits ctrl plus one hot key
    Then Sytem should display data entry page
    #Then System should navigate to DE screen or System shows a pop-up if there are no DE tasks
    And User validate the patient name and contact number
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_DR_nine |
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId         |
      | TestData      | product   | Row_DR_twelve |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    When User hits ctrl plus one hot key
    Then Sytem should display data entry page
    #Then System should navigate to DE screen or System shows a pop-up if there are no DE tasks
    And User validate the patient name and contact number
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_ten |
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Row_DR_thirteen |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    When User hits ctrl plus two hot key
    Then System should display data review page
    #Then System should navigate to DR screen or System shows a pop-up if there are no DR tasks
    And User validate the patient name and contact number
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_DR_eight |
    When User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    #Then Number of DR tasks should be decreased
    When User hits ctrl plus two hot key
    Then System should display data review page
    #Then System should navigate to DR screen or System shows a pop-up if there are no DR tasks
    And User validate the patient name and contact number
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_DR_nine |
    When User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    #Then Number of DR tasks should be decreased
    When User hits ctrl plus two hot key
    Then System should display data review page
    #Then System should navigate to DR screen or System shows a pop-up if there are no DR tasks
    And User validate the patient name and contact number
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_ten |
    When User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    Then Number of DR tasks should be decreased
    And User closes the application

  @RXUAT-295 @UAT @Regression
  Scenario: Data review
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
      | TestData      | patient   | Row_DR_one |
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
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    Then patient data is reviewed and accepted
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    When User clicks search update the patient information
    Then System displays an error message, please complete the process in IC+
    And User clicks OK Button on the Icplus alert
    Then prescriber data is reviewed and accepted
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    When User clicks search button to update prescriber
    Then prescriber search page should be displayed from DR
    When User enters prescriber first name and Last name from DR
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search from DR
    And clicks select to select a prescriber
    And clicks second accept to validate prescriber data
    Then product data is reviewed and accepted
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_one |
    When User clicks update to update the product data
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_DR_five |
    Then product data should be updated
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_DR_five |
    When User updates product data with rems drug in data review screen
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_two |
    Then System should display an alert asking to continue this task on ICplus
    And User clicks cancel button on the rems alert
    And enters product information
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Row_DR_fourteen |
    And clicks third accept to validate product data
    And All the accept buttons should be green
    And clicks Finish to complete data review
    And System should display patient order status page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
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
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User hits alt plus s hotkey
    Then System displays an error message, please complete the process in IC+
    And User hits alt plus o hotkey to close the alert message
    When User hits alt plus one hotkey
    Then first accept button should be selected
    When User hits alt plus e hotkey
    Then prescriber search page should be displayed from DR
    When User enters prescriber first name and Last name from DR
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_two |
    And User selects null value in the state dropdown
    And User hits alt plus r hotkey
    Then system displays the list of prescribers that matches the search criteria
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_two |
    When User hits alt plus e hotkey
    When User hits alt plus l hotkey
    Then all the fields should be cleared
    When User hits alt plus c hotkey
    Then prescriber search page on dr should be closed
    When User hits alt plus e hotkey
    Then prescriber search page should be displayed from DR
    When User enters prescriber first name and Last name from DR
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_two |
    And User selects null value in the state dropdown
    And User hits alt plus r hotkey
    Then system should display the list of prescribers that matches the search criteria
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_two |
    And User hits alt plus e hotkey
    When User hits alt plus two hotkeys
    Then second accept button should be selected
    When User hits alt plus U hotkeys
    And User enters updated data
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_DR_five |
    When User hits alt plus three hot key
    Then third accept button should be selected
    And product data should be updated
      | InputFileName | SheetName | RowId       |
      | TestData      | product   | Row_DR_five |
    When User hits alt plus f hotkeys
    Then System should display patient order status page

  @RXUAT-174 @UAT @Regression
  Scenario: Display IC+ Rx number - Patient Order Status and Med History
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
      | TestData      | patient   | Row_DR_one |
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
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    And System should display patient order status page
    Then The price should not be displayed in patient order status
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
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
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId      |
      | TestData      | product   | Row_DR_one |
    And clicks open payment button
    And selects payment type
    And User clicks Add Rx button
    #Then System should add the Rx and create a DR task
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And clicks search button on patient order status page
    Then The price should not be displayed in patient order status
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
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
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And clicks search button on patient search page
    Then System should display patient search results
    #And Select a patient
    When User clicks view button
    And clicks Med history tab
    Then System should display rx number of current prescription

  @RXUAT-281 @RXUAT-244 @RXUAT-292 @UAT @Regression
  Scenario: Successful billing primary plan and receiving response from IC+ to RxMS (Push)
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
      | TestData      | patient   | Row_DR_eleven |
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
      | TestData      | patient   | Row_DR_eleven |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_DR_eleven |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_DR_eleven |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId      |
      | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId          |
      | TestData      | product   | Row_DR_fifteen |
    And clicks open payment button
    #And selects payment type as plan
    And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_DR_eleven |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    Then Number of DR tasks should be decreased
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_DR_eleven |

  @RXQE-3085 @P1 @Regression
  Scenario: E2E | DE | Prescriber Search Prescriber in DE RxMS Screen
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
    | TestData      | patient   | Row_DR_one |
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
    | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
    | InputFileName | SheetName | RowId      |
    | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
    | InputFileName | SheetName | RowId      |
    | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
    | InputFileName | SheetName  | RowId      |
    | TestData      | prescriber | Row_DR_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And clicks open product button
    And enters product information
    | InputFileName | SheetName | RowId      |
    | TestData      | product   | Row_DR_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
    | InputFileName | SheetName | RowId      |
    | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks search button to update prescriber
    Then prescriber search page should be displayed from DR
    When User enters prescriber first name and Last name from DR
      | InputFileName | SheetName  | RowId       |
      | TestData      | prescriber | Row_DR_five |
    And User selects null value in the state dropdown in DR
    And clicks search button on prescriber search in DR
    #And clicks on select prescriber Button
    And User click on Add New Button
    Then Screen pop up a message "This function cannot be completed in this system. Please complete it IC+."
    When User click on Update Button
    Then Screen pop up a message "This function cannot be completed in this system. Please complete it IC+."
    When User click on View Button
    And validate general info of the prescriber
    	| InputFileName | SheetName  | RowId       |
      | TestData      | prescriber | Row_DR_five |
    And validate the location and communication details

  @RXQE-5526 @IkariWarriors @Regression
  Scenario: SIT | RXMS | Delete image from POS after user clicks on send to IC+ in DR
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
      | TestData      | patient   | Row_DR_one |
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
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
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
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And User clicks send to ICplus Button on DR page
    Then System should display patient order status page
    And User clicks search button on patient order status
    Then User validates the status as "check ic+" and selects the current prescription
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks delete prescription in patient order status
    Then System should display a message "IC+ prescription can only be deleted in IC+" under the prescription

  @RXQE-5908 @RXQE-5500 @IkariWarriors @Regression
  Scenario: SIT | Update stock when delete an new Rx after DR
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
    #And clicks open product button
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
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_DE_IW_1 |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    #Then System should generate Rx number for current prescription
    #| InputFileName | SheetName | RowId   |
    #| TestData		  | patient   | Row_DE_IW_1 |
    Then User validates the status as "entered" and selects the current prescription
      | InputFileName | SheetName | RowId       |
      | TestData      | patient   | Row_DE_IW_1 |
    When User clicks on Delete Rx button
    Then validates the popup
    And clicks on Delete RX
    And check the soft allocation after delete rx in stock plus

  @RXQE-5518 @IkariWarriors @Regression
  Scenario: SIT | RXMS | Delete image after DR from POS
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
      | TestData      | patient   | Row_DR_one |
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
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
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
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
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
      | TestData      | patient   | Row_DR_one |
    And User validates the status as "entered" and selects the current prescription
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks delete prescription in patient order status
    And clicks delete rx button on the alert message
    Then The prescription should be deleted

  @RXQE-7666 @Joust @Regression
  Scenario: SIT | DE Optimization | Perform Data Review | Six digit Date format in the Original Date or Drug Exp Date or Rx Expiration date field
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
      | TestData      | patient   | Row_DR_one |
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
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
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
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User click On PRODUCT UPDATE BTN
    And Validate Original Date, Drug Exp Date and Rx Expiration date field and validate Error message

  @RXQE-7667 @Joust @Regression
  Scenario: SIT | DE Optimization | Update New Rx | Six digit Date format in the Original Date or Drug Exp Date or Rx Expiration date field
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
    And clicks search button on patient order status page
    Then User validates the status as "In Progress" and selects the current prescription
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7667 |
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    And Validate rxupdate page Original Date, Drug Exp Date and Rx Expiration date field and validate Error message

  @RXQE-7530 @Joust @Regression
  Scenario: SIT | DE Optimization | Perform Data Review | Modify Rx Expiration Date or entered PXXXY in the Refills field for C2 Drugd
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
      | TestData      | patient   | Row_DR_one |
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
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
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
    And enters product information for c2
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_7402_C2 |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    When User clicks Update button from product panel
    And Rx expiration field should be blank and disabled

  @RXQE-7607 @Joust @Regression
  Scenario: SIT | DE Optimization | Perform Data Review | Modify Rx Expiration Date or entered PXXXY in the Refills field for C3 Drug
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
      | TestData      | patient   | Row_DR_one |
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
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_DR_one |
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
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_7402_C3 |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_DR_one |
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks Update button from product panel
    And User adds "180" days to RX Expiration date field so that it pasts default date allowed by State
    Then System displays message "Invalid entry. Max Days to Fill exceeded"
    And user validates the entered refills format
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_7402_C3 |
    When User modifies Refills field so that RX Expiration date is past default date allowed by State
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_DR_one |
    Then System displays message "Invalid entry. Max Days to Fill exceeded"

  @RXQE-7626 @Joust @Regression
  Scenario: SIT | DE Optimization | Perform Data Review | Modify Rx Expiration Date or entered PXXXY in the Refills field for C4 Drug
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
      | TestData      | patient   | Row_7626 |
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
      | TestData      | patient   | Row_7626 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_7626 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId    |
      | TestData      | prescriber | Row_7626 |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId  |
      | TestData      | product   | Row_C4 |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_7626 |
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks Update button from product panel
    And User adds "360" days to RX Expiration date field so that it pasts default date allowed by State
    Then System displays message "Invalid entry.Max Days to Fill exceeded"
    And user validates the entered refills format
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    When User modifies Refills field so that RX Expiration date is past default date allowed by State
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays message "Invalid entry. Max Days to Fill exceeded"

  @RXQE-7627 @Joust @Regression
  Scenario: SIT | DE Optimization | Perform Data Review | Modify Rx Expiration Date or entered PXXXY in the Refills field for C5 Drug
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
      | TestData      | patient   | Row_7627 |
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
      | TestData      | patient   | Row_7627 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_7627 |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId    |
      | TestData      | prescriber | Row_7627 |
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId  |
      | TestData      | product   | Row_C5 |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
      | TestData      | patient   | Row_7627 |
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks Update button from product panel
    And User adds "360" days to RX Expiration date field so that it pasts default date allowed by State
    Then System displays message "Invalid entry.Max Days to Fill exceeded"
    And user validates the entered refills format
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    When User modifies Refills field so that RX Expiration date is past default date allowed by State
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays message "Invalid entry. Max Days to Fill exceeded"

  @RXQE-7628 @Joust @Regression
  Scenario: SIT | DE Optimization | Perform Data Review | Modify Rx Expiration Date or entered PXXXY in the Refills field for RX Drug
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
    And enters product information
      | InputFileName | SheetName | RowId               |
      | TestData      | product   | Row_Joust_RXQE-7638 |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7628 |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And user clicks on third update button
    And User adds "360" days to RX Expiration date field so that it pasts default date allowed by State
    Then System displays message "Invalid entry.Max Days to Fill exceeded"
    And user validates the entered refills format
      | InputFileName | SheetName | RowId               |
      | TestData      | product   | Row_Joust_RXQE-7638 |
    And enters the refills
    And System displays message "Invalid entry.Max Days to Fill exceeded"

  @RXQE-7682 @Joust @Regression
  Scenario: SIT | DE Optimization | Verify Qty Disp is greater than the Total Prescribed Quantity in Data Review page
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
      | TestData      | patient   | Row_DR_one |
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
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
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
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    When User clicks Update button from product panel
    And clear all the product information fields
    And enters product information and check the disp quantity is greater than quantity
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_RowFive |
    And enter the refills fields and check the qty disensed
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_RowFive |
    And Clear fields and enter refills first and then qty dispensed
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Product_RowFive |

  #		And modifies Qty value as greater than Total Prescribed Qty value and leaves the field
  #		  | InputFileName | SheetName | RowId        |
  #| TestData      | product   | Row_DR_seven |
  #		Then The system should check if the entered Qty is greater than the Total Prescribed Qty
  #		When user clears the Qty, Qty Disp, Refills values
  #		And modifies QTY value is equal to Total Prescribed Qty value and leaves the field
  #		  | InputFileName | SheetName | RowId        |
  #| TestData      | product   | Row_DR_seven |
  #		Then system should allow the user to enter other values and no message should be displayed
  #		When user clears the Qty, Qty Disp, Refills values
  #		And modifies QTY value is less than Total Prescribed Qty value and leaves the field
  #			| InputFileName | SheetName | RowId        |
  #| TestData      | product   | Row_DR_seven |
  #		Then system should allow the user to enter other values and no message should be displayed
  #		When user clears the Qty Disp, Refills values
  #		And modifies Qty Disp value as greater than Total Prescribed Qty value and leaves the field
  #			| InputFileName | SheetName | RowId        |
  #| TestData      | product   | Row_DR_seven |
  #		Then The system should check if the entered Qty Disp is greater than the Total Prescribed Qty
  #		When user clears the Qty Disp, Refills values
  #		And modifies QTY Disp value is equal to Total Prescribed Qty value and leaves the field
  #			| InputFileName | SheetName | RowId        |
  #| TestData      | product   | Row_DR_seven |
  #		Then system should allow the user to enter other values and no message should be displayed
  #		When user clears the Qty, Qty Disp, Refills values
  #		And modifies QTY Disp value is less than Total Prescribed Qty value and leaves the field
  #			| InputFileName | SheetName | RowId        |
  #| TestData      | product   | Row_DR_seven |
  #		Then system should allow the user to enter other values and no message should be displayed
  #		When user clears the Refills value
  #		And modifies Refills value 8
  #		Then The system should check if the entered Qty Disp is greater than the Total Prescribed Qty
  @RXQE-7414 @Joust @Regression
  Scenario: Verify enhanced Data Review so that Data Review should complete quickly and accurately.
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
      | TestData      | patient   | Row_DR_one |
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
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
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
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And focus should be on '1 Accept'
    And user hits the Space Bar
    And the color and name of the '1 Accept' button will change to '1 Unaccept'
    And adds validation flag '1 Accept' to the Patient to indicate the patient has been validated
    When user hits the Space Bar
    Then system changes the color and the name of the '1 Unaccept' button to '1 Accept'
    And removes the validation '1 Unaccept' flag from the Patient
    And Moves the focus to the Accept button '2 Accept' element
    And user hits the Space Bar
    And the color and name of the '2 Accept' button will change to '2 Unaccept'
    And adds validation flag '2 Accept' to the Patient to indicate the patient has been validated
    And user hits the Space Bar
    Then system changes the color and the name of the '2 Unaccept' button to '2 Accept'
    And removes the validation '2 Unaccept' flag from the Patient
    And Moves the focus to the Accept button '3 Accept' element
    And user hits the Space Bar
    And the color and name of the '3 Accept' button will change to '3 Unaccept'
    And adds validation flag '3 Accept' to the Patient to indicate the patient has been validated
    And user hits the Space Bar
    Then system changes the color and the name of the '3 Unaccept' button to '3 Accept'
    And removes the validation '3 Unaccept' flag from the Patient

  @RXQE-7475 @Joust @Regression
  Scenario: SIT | DE Optimization | Perform DR for a patient that has Coupon plan assosciated to Expiration date and attached to a drug
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
      | TestData      | patient   | Row_Pat_Plan_Exp |
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
      | TestData      | patient   | Row_Pat_Plan_Exp |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | Row_Pat_Plan_Exp |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | Row_Pat_Plan_Exp |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    ##And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type as plan
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | Row_Pat_Plan_Exp |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And Validate message

  @RXQE-7306 @Joust @Regression
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And focus should be on '1 Accept'
    And User checks the first accept button is unselected
    And User clicks first accept to validate patient data
    And User checks the first accept button is selected
    And adds validation flag to the Patient to indicate the patient details had been validated
    And Moves the focus to the Accept button '2 Accept' element
    And User checks the second accept button is unselected
    And clicks second accept to validate prescriber data
    And User checks the second accept button is selected
    And adds validation flag to the prescriber to indicate the prescriber details had been validated
    And Moves the focus to the Accept button '3 Accept' element
    And User checks the third accept button is unselected
    And clicks third accept to validate product data
    And User checks the third accept button is selected
    And adds validation flag to the product to indicate the product details had been validated
    When User clicks on first accept to unselect that button
    And User checks the first accept button is unselected
    When User clicks on second accept to unselect that button
    And User checks the second accept button is unselected
    When User clicks on third accept to unselect that button
    And User checks the third accept button is unselected
    And User closes the application

  @RXQE-7404 @Joust @Regression
  Scenario: SIT | DE Optimization | Validate the Accept, Unaccept buttons when user clicks with mouse
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
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And focus should be on '1 Accept'
    And user clicks with mouse on the 1 Accept button for patient details
    And the color and name of the '1 Accept' button will change to '1 Unaccept'
    And adds validation flag to the Patient to indicate the patient details had been validated
    And user clicks with mouse on the 1 Unaccept button for patient details
    Then system changes the color and the name of the '1 Unaccept' button to '1 Accept'
    And removes the validation flag from the Patient details
    And Moves the focus to the Accept button '2 Accept' element
    And user clicks with mouse on the 2 Accept button for prescriber details
    And the color and name of the '2 Accept' button will change to '2 Unaccept'
    And adds validation flag to the prescriber to indicate the prescriber details had been validated
    And user clicks with mouse on the 2 Unaccept button for prescriber details
    Then system changes the color and the name of the '2 Unaccept' button to '2 Accept'
    And removes the validation flag from the Prescriber details
    And Moves the focus to the Accept button '3 Accept' element
    And user clicks with mouse on the 3 Accept button for product details
    And the color and name of the '3 Accept' button will change to '3 Unaccept'
    And adds validation flag to the product to indicate the product details had been validated
    And user clicks with mouse on the 3 Unaccept button for product details
    Then system changes the color and the name of the '3 Unaccept' button to '3 Accept'
    And removes the validation flag from the product details

  @RXQE-7406 @Joust @Regression
  Scenario: SIT | DE Optimization | Validate the Accept, Unaccept buttons when user hits Enter
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
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    #And focus should be on '1 Accept'
    #And user hits the Space Bar
    #Then system changes the color and the name of the '1 Unaccept' button to '1 Accept'
    #When user hit tab in dr
    #And focus should be on '1 Search' button in dr
    #When user hit tab in dr
    #And focus should be on '2 Accept'
    #And user hits the Space Bar
    #Then system changes the color and the name of the '2 Unaccept' button to '2 Accept'
    #When user hit tab in dr
    #And focus should be on '2 Search' button in dr
    #When user hit tab in dr
    #And focus should be on '3 Accept'
    #And user hits the Space Bar
    #Then system changes the color and the name of the '3 Unaccept' button to '3 Accept'
    #When user hit tab in dr
    #And focus should be on '3 Search' button in dr
    #When user hit tab in dr
    #And Focus should be on payment dropdown
    #When user hit tab in dr
    #And Focus should be on payment cash
    #When user hit tab in dr
    #Then Focus should be on Finish button
    #When user hit tab in dr
    #Then Focus should be on Send to IC plus button
    #When user hit tab in dr
    #Then Focus should be on Cancel button
    #When user hit tab in dr
    #When user hit tab in dr
    #Then Focus should be on Side Front button
    #When user hit tab in dr
    #Then Focus should be on Rotate Clockwise button
    #When user hit tab in dr
    #Then Focus should be on Rotate CounterClockwise button
    #When user hit tab in dr
    #Then Focus should be on Reset Image button
    #When user hit tab in dr
    #Then Focus should be on Zoom in button
    #When user hit tab in dr
    #Then Focus should be on Zoom Out button
    #When user hit tab in dr
    #Then Focus should be on Full screen button
    #When user hit tab in dr
    #Then Focus should be on Back button
    #When user hit tab in dr
    #Then Focus should be on Patient hyperlink
    #When User clicks Update button from product panel
    #Then Focus should be on ORIGINAL DATE
    #When user hit tab in dr
    #Then Focus should be on ORIGINAL DATE
    #When user hit tab in dr
    #Then Focus should be on DAW
    #When user hit tab in dr
    #		Then Focus should be on SUBSTITUTE
    #		When user hit tab in dr
    #		Then Focus should be on INPUT_PRESCRIBED_PRODUCT
    #		When user hit tab in dr
    #		Then Focus should be on PRESCRIBER PRODUCT CHANGE BUTTON
    #		When user hit tab in dr
    #		Then Focus should be on DR DRUG EXP DATE
    #		When user hit tab in dr
    #		Then Focus should be on DR QTY PRESCRIBED
    #		When user hit tab in dr
    #		Then Focus should be on DR QTY DISPENSED
    #		When user hit tab in dr
    #		Then Focus should be on DR REFILL EXP DATE
    #		When user hit tab in dr
    #		Then Focus should be on DR DIRECTION
    #		When user hit tab in dr
    #		Then Focus should be on DAYS SUPPLY
    #		When user hit tab in dr
    #		Then Focus should be on NUMBER REFILL
    #		When user hit tab in dr
    #		And focus should be on '3 Accept'
    #		When user hit tab in dr
    #And Focus should be on payment dropdown
    #When user hit tab in dr
    #And Focus should be on payment cash
    #When user hit tab in dr
    #Then Focus should be on Finish button
    #When user hit tab in dr
    #Then Focus should be on Send to IC plus button
    #When user hit tab in dr
    #Then Focus should be on Cancel button
    #When user hit tab in dr
    #When user hit tab in dr
    #Then Focus should be on Side Front button
    #When User hit right arrow key
    #And User hit enter key
    #Then Focus should be on Side Back button
    #When User hit left arrow key
    #And User hit enter key
    #Then Focus should be on Side Front button
    #When user hit tab in dr
    #Then Focus should be on Rotate Clockwise button
    #When user hit tab in dr
    #Then Focus should be on Rotate CounterClockwise button
    #When user hit tab in dr
    #Then Focus should be on Reset Image button
    #When user hit tab in dr
    #Then Focus should be on Zoom in button
    #When user hit tab in dr
    #Then Focus should be on Zoom Out button
    #When user hit tab in dr
    #Then Focus should be on Full screen button
    #When user hit tab in dr
    #Then Focus should be on Back button
    #When user hit tab in dr
    #Then Focus should be on Patient hyperlink
    And focus should be on '1 Accept'
    And user hits enter on keyboard on the 1 Accept button for patient details
    And the color and name of the '1 Accept' button will change to '1 Unaccept'
    And adds validation flag to the Patient to indicate the patient details had been validated
    And user hits enter on keyboard on the 1 Unaccept button for patient details
    Then system changes the color and the name of the '1 Unaccept' button to '1 Accept'
    And removes the validation flag from the Patient details
    And Moves the focus to the Accept button '2 Accept' element
    And user hits enter on keyboard on the 2 Accept button for prescriber details
    And the color and name of the '2 Accept' button will change to '2 Unaccept'
    And adds validation flag to the prescriber to indicate the prescriber details had been validated
    And user hits enter on keyboard on the 2 Unaccept button for prescriber details
    Then system changes the color and the name of the '2 Unaccept' button to '2 Accept'
    And removes the validation flag from the Prescriber details
    And removes the validation '2 Unaccept' flag from the Patient
    And Moves the focus to the Accept button '3 Accept' element
    And user hits enter on keyboard on the 3 Accept button for product details
    And the color and name of the '3 Accept' button will change to '3 Unaccept'
    And adds validation flag to the product to indicate the product details had been validated
    And user hits enter on keyboard on the 3 Unaccept button for product details
    Then system changes the color and the name of the '3 Unaccept' button to '3 Accept'
    And removes the validation flag from the product details

  @RXQE-7958 @Joust @Regression
  Scenario: SIT | DE Optimization | Verify the tab order in Data Review screen and Update Rx screen
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
    ##And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId        |
      | TestData      | patient   | Row_Pat_Plan |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And focus should be on '1 Accept'
    And user hits the Space Bar
    Then system changes the color and the name of the '1 Unaccept' button to '1 Accept'
    When user hit tab in dr
    And focus should be on '1 Search' button in dr
    When user hit tab in dr
    And focus should be on '2 Accept'
    And user hits the Space Bar
    Then system changes the color and the name of the '2 Unaccept' button to '2 Accept'
    When user hit tab in dr
    And focus should be on '2 Search' button in dr
    When user hit tab in dr
    And focus should be on '3 Accept'
    And user hits the Space Bar
    Then system changes the color and the name of the '3 Unaccept' button to '3 Accept'
    When user hit tab in dr
    And focus should be on '3 Search' button in dr
    When user hit tab in dr
    And User hit enter key
    And selects payment type
    #And Focus should be on payment dropdown
    When user hit tab in dr
    #Then Focus should be on paycode
    #When user hit tab in dr
    Then Focus should be on payment cash
    When user hit tab in dr
    Then Focus should be on Finish button
    When user hit tab in dr
    Then Focus should be on Send to IC plus button
    When user hit tab in dr
    Then Focus should be on Cancel button
    When user hit tab in dr
    When user hit tab in dr
    Then Focus should be on Side Front button
    When user hit tab in dr
    Then Focus should be on Rotate Clockwise button
    When user hit tab in dr
    Then Focus should be on Rotate CounterClockwise button
    When user hit tab in dr
    Then Focus should be on Reset Image button
    When user hit tab in dr
    Then Focus should be on Zoom in button
    When user hit tab in dr
    Then Focus should be on Zoom Out button
    When user hit tab in dr
    Then Focus should be on Full screen button
    When user hit tab in dr
    Then Focus should be on Back button
    When user hit tab in dr
    Then Focus should be on Patient hyperlink
    When User clicks Update button from product panel
    Then Focus should be on ORIGINAL DATE
    When user hit tab in dr
    Then Focus should be on ORIGINAL DATE
    When user hit tab in dr
    Then Focus should be on DAW
    When user hit tab in dr
    Then Focus should be on SUBSTITUTE
    When user hit tab in dr
    Then Focus should be on INPUT_PRESCRIBED_PRODUCT
    When user hit tab in dr
    Then Focus should be on PRESCRIBER PRODUCT CHANGE BUTTON
    When user hit tab in dr
    Then Focus should be on DR DRUG EXP DATE
    When user hit tab in dr
    Then Focus should be on DR QTY PRESCRIBED
    When user hit tab in dr
    Then Focus should be on DR QTY DISPENSED
    When user hit tab in dr
    Then Focus should be on DR REFILL EXP DATE
    When user hit tab in dr
    Then Focus should be on DR DIRECTION
    When user hit tab in dr
    Then Focus should be on DAYS SUPPLY
    When user hit tab in dr
    Then Focus should be on NUMBER REFILL
    When user hit tab in dr
    And focus should be on '3 Accept'
    When user hit tab in dr
    And Focus should be on payment dropdown
    When user hit tab in dr
    And Focus should be on payment cash
    When user hit tab in dr
    Then Focus should be on Finish button
    When user hit tab in dr
    Then Focus should be on Send to IC plus button
    When user hit tab in dr
    Then Focus should be on Cancel button
    When user hit tab in dr
    When user hit tab in dr
    Then Focus should be on Side Front button
    When User hit right arrow key
    And User hit enter key
    Then Focus should be on Side Back button
    When User hit left arrow key
    And User hit enter key
    Then Focus should be on Side Front button
    When user hit tab in dr
    Then Focus should be on Rotate Clockwise button
    When user hit tab in dr
    Then Focus should be on Rotate CounterClockwise button
    When user hit tab in dr
    Then Focus should be on Reset Image button
    When user hit tab in dr
    Then Focus should be on Zoom in button
    When user hit tab in dr
    Then Focus should be on Zoom Out button
    When user hit tab in dr
    Then Focus should be on Full screen button
    When user hit tab in dr
    Then Focus should be on Back button
    When user hit tab in dr
    Then Focus should be on Patient hyperlink

  @RXQE-7478 @Joust @Regression
  Scenario: SIT | DE Optimization | Perform DR for a patient that has Coupon plan assosciated to Expiration date passed and not attached to a drug
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId                            |
      | TestData      | patient   | Row_couponPlanExpirationDatePast |
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
      | InputFileName | SheetName | RowId                            |
      | TestData      | patient   | Row_couponPlanExpirationDatePast |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId                            |
      | TestData      | patient   | Row_couponPlanExpirationDatePast |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId                            |
      | TestData      | patient   | Row_couponPlanExpirationDatePast |
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
    And selects payment type plan
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId                            |
      | TestData      | patient   | Row_couponPlanExpirationDatePast |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And validate if any message is displayed

  #And clicks Finish to complete data review
  @RXQE-7655 @Joust @Regression
  Scenario: SIT | DE Optimization | Six digit prescription dates (Original Date, Drug Exp Date & Rx Expiration Date) in Data Entry
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
    And validate the original date by entering six digits in product information
      | InputFileName | SheetName | RowId             |
      | TestData      | product   | Row_RXQE-7655_six |
    And validate the original date by entering eight digits in product information
      | InputFileName | SheetName | RowId           |
      | TestData      | product   | Row_twentyseven |
    And validate the original date by entering seven digits in product information
      | InputFileName | SheetName | RowId               |
      | TestData      | product   | Row_RXQE-7655_seven |

  @RXQE-7714 @Joust @Regression
  Scenario: SIT | DE Optimization | Verify system displays PRN value when user enters PRN or PXXY in Refills field and leaves the field in Data Review screen
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
      | TestData      | patient   | Row_DR_one |
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
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
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
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    When user opens product panel
    And user clears Refills data and modifies the Refills value as "PRN"
    When user hit tab in dr
    And user leaves the Refills field
    Then The system should display PRN in Refills field
    And user clears Refills data and modifies the Refills value as "P123D"
    When user hit tab in dr
    And user leaves the Refills field
    Then The system should display PRN in the Refills field

  @RXQE-7732 @Joust @Regression
  Scenario: SIT | DE Optimization | Verify system displays PRN value when user enters PRN or PXXY in Refills field and leaves the field in Update Rx screen
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
      | TestData      | patient   | Row_DR_one |
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
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    ##And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then User validates the status as "In Progress" and selects the current prescription
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    #When user opens product panel
    And user clears Refills data and modifies the Refills value as "PRN"
    When user hit tab in dr
    And user leaves the Refills field
    Then The system should display PRN in Refills field
    And user clears Refills data and modifies the Refills value as "PXXXY"
    When user hit tab in dr
    And user leaves the Refills field
    Then The system should display PRN in the Refills field

  @RXQE-7733 @Joust @Regression
  Scenario: SIT | DE Optimization | Verify system displays PRN value when user re-enters PRN or PXXY in Refills field in Data Review screen
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
      | TestData      | patient   | Row_DR_one |
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
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
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
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    When user opens product panel
    And user clears Refills data and modifies the Refills value as "PRN"
    When user hit tab in dr
    And user leaves the Refills field
    When The user comes back to Refills field
    Then The system should display PRN in Refills field
    And user clears Refills data and modifies the Refills value as "P123D"
    When user hit tab in dr
    And user leaves the Refills field
    When The user comes back to Refills field
    Then The system should display PRN in the Refills field

  @RXQE-7735 @Joust @Regression
  Scenario: SIT | DE Optimization | Verify system displays PRN value when user re-enters PRN or PXXY in Refills field in Update Rx screen
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
      | TestData      | patient   | Row_DR_one |
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
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    ##And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then User validates the status as "In Progress" and selects the current prescription
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    #When user opens product panel
    And user clears Refills data and modifies the Refills value as "PRN"
    When user hit tab in dr
    And user leaves the Refills field
    When The user comes back to Refills field
    Then The system should display PRN in Refills field
    And user clears Refills data and modifies the Refills value as "PXXXY"
    When user hit tab in dr
    And user leaves the Refills field
    When The user comes back to Refills field
    Then The system should display PRN in the Refills field

  @RXQE-7477 @Joust @Regression
  Scenario: SIT | DE Optimization | Perform DR for a patient that has Coupon plan that has no Expiration date and attached to a drug
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId                 |
      | TestData      | patient   | Row_patientwithCoupon |
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
      | InputFileName | SheetName | RowId                 |
      | TestData      | patient   | Row_patientwithCoupon |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId                 |
      | TestData      | patient   | Row_patientwithCoupon |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId                 |
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
    ##And clicks open product button
    And enters product information with DAW as "Y"
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type as plan that has no expiration date but drug associated to it
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    Then System should display the following message in the expanded Payment Panel "This patient might have a coupon for this prescription"

  @Joust @RXQE-7689 @Regression
  Scenario: SIT| Prerequisite-Validate 'Update Rx' and 'Delete Rx' functionalities in RxMS
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
      | TestData      | patient   | Row_RXQE_7689 |
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
      | TestData      | patient   | Row_RXQE_7689 |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7689 |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7689 |
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
      | InputFileName | SheetName | RowId         |
      | TestData      | product   | Row_RXQE_7689 |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    Then User validates the status as "In Progress" and selects the current prescription
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7689 |
    And Clicks on UpdateRx Btn
    And update refill data
      | InputFileName | SheetName | RowId             |
      | TestData      | product   | Row_Joust_C3_Drug |
    And clicks Update button to complete UpdateRX functionality
    And user clicks close button on popup dialog
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE_7689 |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    When User clicks on Delete Rx button
    Then validates the popup
    And clicks on Delete RX

  @RXQE-7423 @Joust @Regression
  Scenario: SIT | DE Optimization | Verify the display of product information when user performs Data Review task and all values in Product panel are filled
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
    ##And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_7423|
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | Row_patient_auto |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    When the system displays Date of Birth of the selected patient in Patient panel as additional information
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | Row_patient_auto |
    When clicks second accept to validate prescriber data
    Then system displays the following prescriber details in the Prescriber panel: Last Name, First Name, Middle Initial
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    Then clicks third accept to validate product data
    Then system displays the following product information in read-only mode: Prescribed Drug, Dispensed Drug/Orange Book rating, Original Date, DAW, Qty, Refills, Directions
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_7423|
    When User click On PRODUCT UPDATE BTN
    And enters drug name as "SEBEX SHAMPOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOooooOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO" to exceed the available space on the screen
    And directions as "tk 1 t po dddddddddddddddddddddddddddddddddddddddddddddddddddfdfddddfdfdfdfdfdfdfdfdfddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" to exceed the available space on the screen
    And clicks third accept to validate product data
    Then the Prescribed Drug, Dispensed Drug/Orange Book Rating, and Directions will wrap around if they exceed the available space on the screen

  @RXQE-7629 @Joust @Regression
  Scenario: SIT | DE Optimization | Perform Data Review | Modify Rx Expiration Date or entered PXXXY in the Refills field for OTC Drug
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
    And enters product information
      | InputFileName | SheetName | RowId               |
      | TestData      | product   | Row_Joust_RXQE-7629 |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId         |
      | TestData      | patient   | Row_RXQE-7628 |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And user clicks on third update button
    And User adds "367" days to RX Expiration date field so that it pasts default date allowed by State
    Then System displays message "Invalid entry.Max Days to Fill exceeded"
    And user validates the entered refills format
      | InputFileName | SheetName | RowId               |
      | TestData      | product   | Row_Joust_RXQE-7629 |
    And enters the refills
    And System displays message "Invalid entry.Max Days to Fill exceeded"

  @RXQE-7633 @RXQE-7637 @RXQE-7635 @Joust @Regression
  Scenario: SIT | DE Optimization | Perform Update New Rx | Modify Rx Expiration Date or entered PXXXY in the Refills field for C3 Drug
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
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId               |
      | TestData      | product   | Row_Joust_RXQE-7633 |
    And User hits TAB key
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | Row_patient_auto |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then User validates the status as "In Progress" and selects the current prescription
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | Row_patient_auto |
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    And User adds "367" days to RX Expiration date field so that it pasts default date allowed by State
    Then System displays message "Invalid entry.Max Days to Fill exceeded"
    And user validates the entered refills format
      | InputFileName | SheetName | RowId               |
      | TestData      | product   | Row_Joust_RXQE-7633 |
    And enters the refills
    And System displays message "Invalid entry.Max Days to Fill exceeded"

  @RXQE-7638 @Joust @Regression
  Scenario: SIT | DE Optimization | Perform Update New Rx | Modify Rx Expiration Date or entered PXXXY in the Refills field for RX Drug
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
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId               |
      | TestData      | product   | Row_Joust_RXQE-7638 |
    And User hits TAB key
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | Row_patient_auto |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then User validates the status as "In Progress" and selects the current prescription
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | Row_patient_auto |
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    And User adds "367" days to RX Expiration date field so that it pasts default date allowed by State
    Then System displays message "Invalid entry.Max Days to Fill exceeded"
    And user validates the entered refills format
      | InputFileName | SheetName | RowId               |
      | TestData      | product   | Row_Joust_RXQE-7638 |
    And enters the refills
    And System displays message "Invalid entry.Max Days to Fill exceeded"

  @RXQE-7639 @Joust @Regression
  Scenario: SIT | DE Optimization | Perform Update New Rx | Modify Rx Expiration Date or entered PXXXY in the Refills field for OTC Drug
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
    #And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId               |
      | TestData      | product   | Row_Joust_RXQE-7629 |
    And User hits TAB key
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | Row_patient_auto |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then User validates the status as "In Progress" and selects the current prescription
      | InputFileName | SheetName | RowId            |
      | TestData      | patient   | Row_patient_auto |
    And Clicks on UpdateRx Btn
    Then System should display Update Rx page
    And User adds "367" days to RX Expiration date field so that it pasts default date allowed by State
    Then System displays message "Invalid entry.Max Days to Fill exceeded"
    And user validates the entered refills format
      | InputFileName | SheetName | RowId               |
      | TestData      | product   | Row_Joust_RXQE-7629 |
    And enters the refills
    And System displays message "Invalid entry.Max Days to Fill exceeded"

  @RXQE-7427 @Joust @Regression
  Scenario: SIT | DE Optimization | When user performs Prescriber search in Data Review task
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
      | TestData      | patient   | Row_DR_one |
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
      | TestData      | patient   | Row_DR_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    ##And clicks open product button
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId      |
      | TestData      | patient   | Row_DR_one |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks first accept to validate patient data
    When User click on Search in Prescriber on DR page
    When User enters prescriber first name and Last name from DR
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_two |
    When click search button on prescriber search
    And atleast one result should be displayed and highlighted
    And User hits Enter Key
    #Then system closes the Prescriber Search Results overlay on DR page
    Then system displays the following prescriber details in the Prescriber panel: Last Name, First Name, Middle Initial
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_two |
    When User click on Search in Prescriber on DR page
    When User enters prescriber first name and Last name from DR
      | InputFileName | SheetName  | RowId        |
      | TestData      | prescriber | Row_multiple |
    When click search button on prescriber search
    And atleast one result should be displayed and highlighted
    And double click on prescriber result
    #Then system closes the Prescriber Search Results overlay on DR page
    Then system displays the following prescriber details in the Prescriber panel: Last Name, First Name, Middle Initial
      | InputFileName | SheetName  | RowId        |
      | TestData      | prescriber | Row_multiple |
