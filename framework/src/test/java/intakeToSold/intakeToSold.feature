@RxMSSOLD
Feature: IntakeToSold

  @TestAPPE2E
  Scenario: TestAPPE2E
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData  | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    And user gets the store number from RXMS
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
    #Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And clicks open product button
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
    #Then Number of DR tasks should be decreased
    #Then A clinical evaluation task should get created
    #When User clicks CE in the task board
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then click on CE med history
    Then click on CE clinical History
    Then click on CE interaction    
    And clicks select all for therapy review
    And clicks Override in CE screen
    #Then Number of CE tasks should be decreased by one
    Then System should display patient order status page
    And User clicks search button on patient order status
    #And The prescription status should be In Progress -Reviewed
     # | InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_one |
    Then A filling task should get created in the taskboard
    When User clicks filling in the taskboard
    And The system should display a message Use - the Mobile Device to complete Filling
    # device start
    And User logs in to the Fill appplication on android device
    Then I should see the Drug Information page
    When User clicks Yes button on Drug Information page
    Then System should display Scan Product page
    When User clicks Manually Enter NDC button on scan product page
    Then System should display Drug Identifier page
    When User enter the UPC number in UPC Number edit field
     | InputFileName | SheetName | RowId   |
     | TestData      | UPC       | Row_one |
    When I click on Next button on Enter Drug Identifier page
    Then I should see Reason for Manual Entry screen
    And User selects one of the four reasons
    And I should see the Next button on Reason for Manual Entry Page
    When I click on Next button on Reason for Manual Entry Page
    Then I should see Confirm Quantity page
    When I click on Yes button on Confirm Quantity page
    When I click on FillNextRx button
    #And I click on OK button in Popup message
    #Then I should see Initial Page screen again
    #Device end
    #pv
    When User clicks patient order status button in navigation panel
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And User clicks search button on patient order status
    Then The prescription status should be In Progress-Filled
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    #PV starts
    When User clicks product verification task in the task board
    Then The RxMS system should display product verification page
    When User enters Rx number in PV window
    And User clicks Verify Button in PV page
    When User clicks accept on PV window
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And User clicks search button on patient order status
    And The status in patient order status should be changed to Ready
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    #PV end
    #POS starts
    When User completes the point of sale transaction
    #POS end
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
    And User clicks search button on patient order status
    And The status in patient order status should be changed to Sold
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_one |
