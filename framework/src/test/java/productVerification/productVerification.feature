@productVerification
Feature: Product Verification

  @TestAPPE2E @RXQE-2919 @RXUAT-369 @RXUAT-375 @RXUAT-178 @RXQE-2869 @UAT @P1 @Regression_pv
  Scenario: TestAPPE2E
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    And user gets the store number from RXMS
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
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
      | TestData      | patient   | Row_CE_Two |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information for first product
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Product_CE_Eight |
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
      | TestData      | patient   | Row_CE_Two |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And clicks select all for therapy review
    And user clicks on Override in CE screen
    Then System should display patient order status page
    And User clicks search button on patient order status
    And The prescription status should be In Progress -Reviewed after completing CE for respective first Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData  | product   | Product_CE_Eight |
    Then A filling task should get created in the taskboard
    When User clicks filling in the taskboard
    And The system should display a message Use - the Mobile Device to complete Filling
    When User logs in to the Fill appplication on android device
    Then I should see the Drug Information page
    When User clicks Yes button on Drug Information page
    Then System should display Scan Product page
    When User clicks Manually Enter NDC button on scan product page
    Then System should display Drug Identifier page
    When User enter the NDC number dynamically in NDC Number edit field
    When I click on Next button on Enter Drug Identifier page
    Then I should see Reason for Manual Entry screen
    And User selects one of the four reasons
    And I should see the Next button on Reason for Manual Entry Page
    When I click on Next button on Reason for Manual Entry Page
    Then I should see Confirm Quantity page
    When I click on Yes button on Confirm Quantity page
    When I click on FillNextRx button
    When User clicks patient order status button in navigation panel
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
#    And User enters patient phone number in POS phone number text box
#      | InputFileName | SheetName | RowId   |
#      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    Then The prescription status should be In Progress-Filled
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    When User clicks product verification task in the task board
    Then The RxMS system should display product verification page
    When User enters Rx number in PV window
    And User clicks Verify Button in PV page
    When User clicks accept on PV window
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
#    And User enters patient phone number in POS phone number text box
#      | InputFileName | SheetName | RowId   |
#      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    And The status in patient order status should be changed to Ready
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    When User completes the point of sale transaction
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
#    And User enters patient phone number in POS phone number text box
#      | InputFileName | SheetName | RowId   |
#      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    And The status in patient order status should be changed to Sold
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |

  #@RXUAT-254
  #Scenario: Verify the rx number displayed in clinical check page, device and product verification page
  #Add assertions in clinical check page, device and pv page for rx number
  @RXQE-2874 @RXQE-2872 @RXQE-2951 @RXQE-2875 @RXQE-2934 @E2E @P1 @Regression_pv
  Scenario: Validate product verification scenariosk
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    And user gets the store number from RXMS
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
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
      | TestData      | patient   | Row_CE_Two |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information for first product
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Product_CE_Eight |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
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
      | TestData      | patient   | Row_CE_Two |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And clicks select all for therapy review
    And user clicks on Override in CE screen
    Then System should display patient order status page
    And User clicks search button on patient order status
    And The prescription status should be In Progress -Reviewed after completing CE for respective first Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData  | product   | Product_CE_Eight |
    Then A filling task should get created in the taskboard
    When User clicks filling in the taskboard
    And The system should display a message Use - the Mobile Device to complete Filling
    When User logs in to the Fill appplication on android device
    Then I should see the Drug Information page
    When User clicks Yes button on Drug Information page
    Then System should display Scan Product page
    When User clicks Manually Enter NDC button on scan product page
    Then System should display Drug Identifier page
    When User enter the NDC number dynamically in NDC Number edit field
    When I click on Next button on Enter Drug Identifier page
    Then I should see Reason for Manual Entry screen
    And User selects one of the four reasons
    And I should see the Next button on Reason for Manual Entry Page
    When I click on Next button on Reason for Manual Entry Page
    Then I should see Confirm Quantity page
    When I click on Yes button on Confirm Quantity page
    When I click on FillNextRx button
    When User clicks patient order status button in navigation panel
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
#    And User enters patient phone number in POS phone number text box
#      | InputFileName | SheetName | RowId   |
#      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    Then The prescription status should be In Progress-Filled
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    When User clicks product verification task in the task board
    Then The RxMS system should display product verification page
    When User enters Rx number in PV window
    And User clicks Verify Button in PV page
    When User clicks Add Consult Button on product verification page
    Then System should display an alert message that this function cannot be completed please complete in ICplus
    And User clicks ok button on add consult alert
    Then System should display the reason for manual entry selected in filling task
    And System should display the waiting indicator in pickuptime on PV page
    #Then Generic For text box should be blank
    When User clicks image enlarge button on pv page
    Then System should display enlarged image
    When User clicks close button on enlarged image
    Then System should unzoom the enlarged image
    When User clicks image enlarge button on pv page
    Then System should display enlarged image
    When User clicks exit full screen button
    Then System should unzoom the enlarged image
    And User clicks cancel button on product verification page
    Then System displays enter rx number page

  @RXQE-5524 @RXQE-5720 @IkariWarriors @Regression_pv
  Scenario: SIT | RXMS | Delete image from POS after script is SOLD
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    And user gets the store number from RXMS
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
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
      | TestData      | patient   | Row_CE_Two |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information for first product
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Product_CE_Eight |
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
      | TestData      | patient   | Row_CE_Two |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And clicks select all for therapy review
    And user clicks on Override in CE screen
    Then System should display patient order status page
    And User clicks search button on patient order status
    And The prescription status should be In Progress -Reviewed after completing CE for respective first Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData  | product   | Product_CE_Eight |
    Then A filling task should get created in the taskboard
    When User clicks filling in the taskboard
    And The system should display a message Use - the Mobile Device to complete Filling
    When User logs in to the Fill appplication on android device
    Then I should see the Drug Information page
    When User clicks Yes button on Drug Information page
    Then System should display Scan Product page
    When User clicks Manually Enter NDC button on scan product page
    Then System should display Drug Identifier page
    When User enter the NDC number dynamically in NDC Number edit field
    When I click on Next button on Enter Drug Identifier page
    Then I should see Reason for Manual Entry screen
    And User selects one of the four reasons
    And I should see the Next button on Reason for Manual Entry Page
    When I click on Next button on Reason for Manual Entry Page
    Then I should see Confirm Quantity page
    When I click on Yes button on Confirm Quantity page
    When I click on FillNextRx button
    When User clicks patient order status button in navigation panel
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
#    And User enters patient phone number in POS phone number text box
#      | InputFileName | SheetName | RowId   |
#      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    Then The prescription status should be In Progress-Filled
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    When User clicks product verification task in the task board
    Then The RxMS system should display product verification page
    When User enters Rx number in PV window
    And User clicks Verify Button in PV page
    When User clicks accept on PV window
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
#    And User enters patient phone number in POS phone number text box
#      | InputFileName | SheetName | RowId   |
#      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    And The status in patient order status should be changed to Ready
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    When User completes the point of sale transaction
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
#    And User enters patient phone number in POS phone number text box
#      | InputFileName | SheetName | RowId   |
#      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    And User validates the status as "Sold" and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    And User clicks delete prescription in patient order status
    Then System should display a message "A prescription in sold status cannot be deleted" under the prescription

  @RXQE-5887 @IkariWarriors @Regression_pv
  Scenario: SIT - Track Delete - Deleting sold Prescription should be failure
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    And user gets the store number from RXMS
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
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
      | TestData      | patient   | Row_CE_Two |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information for first product
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Product_CE_Eight |
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
      | TestData      | patient   | Row_CE_Two |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And clicks select all for therapy review
    And user clicks on Override in CE screen
    Then System should display patient order status page
    And User clicks search button on patient order status
    And The prescription status should be In Progress -Reviewed after completing CE for respective first Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData  | product   | Product_CE_Eight |
    Then A filling task should get created in the taskboard
    When User clicks filling in the taskboard
    And The system should display a message Use - the Mobile Device to complete Filling
    When User logs in to the Fill appplication on android device
    Then I should see the Drug Information page
    When User clicks Yes button on Drug Information page
    Then System should display Scan Product page
    When User clicks Manually Enter NDC button on scan product page
    Then System should display Drug Identifier page
    When User enter the NDC number dynamically in NDC Number edit field
    When I click on Next button on Enter Drug Identifier page
    Then I should see Reason for Manual Entry screen
    And User selects one of the four reasons
    And I should see the Next button on Reason for Manual Entry Page
    When I click on Next button on Reason for Manual Entry Page
    Then I should see Confirm Quantity page
    When I click on Yes button on Confirm Quantity page
    When I click on FillNextRx button
    When User clicks patient order status button in navigation panel
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
#    And User enters patient phone number in POS phone number text box
#      | InputFileName | SheetName | RowId   |
#      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    Then The prescription status should be In Progress-Filled
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    When User clicks product verification task in the task board
    Then The RxMS system should display product verification page
    When User enters Rx number in PV window
    And User clicks Verify Button in PV page
    When User clicks accept on PV window
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
#    And User enters patient phone number in POS phone number text box
#      | InputFileName | SheetName | RowId   |
#      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    And The status in patient order status should be changed to Ready
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    When User completes the point of sale transaction
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
#    And User enters patient phone number in POS phone number text box
#      | InputFileName | SheetName | RowId   |
#      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    And User validates the status as "Sold" and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    And User clicks delete prescription in patient order status
    Then System should display a message "A prescription in sold status cannot be deleted" under the prescription

  @RXQE-5910 @IkariWarriors @Regression_pv
  Scenario: SIT | Update stock when delete an new Rx after Fill
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
      | TestData      | patient   | Row_DR_ten |
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
      | TestData      | patient   | Row_DR_ten |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_DR_ten |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_DR_ten |
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
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_DR_ten |
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
      | TestData      | patient   | Row_DR_ten |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_DR_ten |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And clicks select all for therapy review
    And user clicks on Override in CE screen
    Then System should display patient order status page
    And User clicks search button on patient order status
    And The prescription status should be In Progress -Reviewed
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_DR_ten |
    Then A filling task should get created in the taskboard
    When User clicks filling in the taskboard
    Then The system should display a message Use - the Mobile Device to complete Filling
    When User logs in to the Fill appplication on android device
    Then I should see the Drug Information page
    When User clicks Yes button on Drug Information page
    Then System should display Scan Product page
    When User clicks Manually Enter NDC button on scan product page
    Then System should display Drug Identifier page
    When User enter the NDC number dynamically in NDC Number edit field
    And I click on Next button on Enter Drug Identifier page
    Then I should see Reason for Manual Entry screen
    When User selects one of the four reasons
    Then I should see the Next button on Reason for Manual Entry Page
    When I click on Next button on Reason for Manual Entry Page
    Then I should see Confirm Quantity page
    When I click on Yes button on Confirm Quantity page
    And I click on FillNextRx button
    And User clicks patient order status button in navigation panel
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_DR_ten |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_DR_ten |
    And User clicks search button on patient order status
    And User validates the status as "Sold" and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_DR_ten |
    And User clicks delete prescription in patient order status
    And check the soft allocation after delete rx in stock plus
    And check the stock db for onshelf count after fill

  @RXQE-5911 @IkariWarriors @Regression_pv
  Scenario: SIT | Update stock when delete an new Rx after PV
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
    And user clicks on Override in CE screen
    Then System should display patient order status page
    And User clicks search button on patient order status
    And The prescription status should be In Progress -Reviewed
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then A filling task should get created in the taskboard
    When User clicks filling in the taskboard
    Then The system should display a message Use - the Mobile Device to complete Filling
    When User logs in to the Fill appplication on android device
    Then I should see the Drug Information page
    When User clicks Yes button on Drug Information page
    Then System should display Scan Product page
    When User clicks Manually Enter NDC button on scan product page
    Then System should display Drug Identifier page
    When User enter the NDC number dynamically in NDC Number edit field
    And I click on Next button on Enter Drug Identifier page
    Then I should see Reason for Manual Entry screen
    When User selects one of the four reasons
    Then I should see the Next button on Reason for Manual Entry Page
    When I click on Next button on Reason for Manual Entry Page
    Then I should see Confirm Quantity page
    When I click on Yes button on Confirm Quantity page
    And I click on FillNextRx button
    And User clicks patient order status button in navigation panel
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User clicks search button on patient order status
    Then The prescription status should be In Progress-Filled
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    When User clicks product verification task in the task board
    Then The RxMS system should display product verification page
    When User enters Rx number in PV window
    And User clicks Verify Button in PV page
    When User clicks accept on PV window
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User clicks search button on patient order status
    And The status in patient order status should be changed to Ready
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User validates the status as "Ready" and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User clicks delete prescription in patient order status
    And check the soft allocation after delete rx in stock plus
    And check the stock db for onshelf count after fill

    @RXQE-5523 @IkariWarriors @Regression_pv
    Scenario: Delete an rx after completing PV task
      Given User launches the RxMS desktop application
      When User enters the valid credentials in login text fields
        | InputFileName | SheetName | RowId   |
        | TestData      | login     | Row_one |
      And User clicks login button
      Then System should display RxMS home page
      And user gets the store number from RXMS
      When User clicks on patient tab in left side menu
      Then System should navigate to patient search page
      When User enters patient First Name and Last Name
        | InputFileName | SheetName | RowId   |
        | TestData      | patient   | Row_CE_Two |
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
        | TestData      | patient   | Row_CE_Two |
      And User enters patient phone number in POS phone number text box
        | InputFileName | SheetName | RowId   |
        | TestData      | patient   | Row_CE_Two |
      And User clicks search button on patient order status
      Then The pending link for current prescription should be clicked
        | InputFileName | SheetName | RowId   |
        | TestData      | patient   | Row_CE_Two |
      Then System displays a donut chart
      When User clicks perform data entry hyperlink
      Then Sytem should display data entry page
      When User enters prescriber first name and Last name
        | InputFileName | SheetName  | RowId   |
        | TestData      | prescriber | Row_one |
      And User selects null value in the state dropdown
      And clicks search button on prescriber search
      And clicks select to select a prescriber
      And enters product information for first product
        | InputFileName | SheetName | RowId   |
        | TestData      | product   | Product_CE_Eight |
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
        | TestData      | patient   | Row_CE_Two |
      And The In progress link for current prescription should be clicked
        | InputFileName | SheetName | RowId   |
        | TestData      | patient   | Row_CE_Two |
      Then System displays a donut chart
      When User clicks perform clinical evaluation hyperlink
      And clicks select all for therapy review
      And user clicks on Override in CE screen
      Then System should display patient order status page
      And User clicks search button on patient order status
      And The prescription status should be In Progress -Reviewed after completing CE for respective first Rx
        | InputFileName | SheetName | RowId   |
        | TestData  | patient   | Row_CE_Two |
        | TestData  | product   | Product_CE_Eight |
      Then A filling task should get created in the taskboard
      When User clicks filling in the taskboard
      And The system should display a message Use - the Mobile Device to complete Filling
      When User logs in to the Fill appplication on android device
      Then I should see the Drug Information page
      When User clicks Yes button on Drug Information page
      Then System should display Scan Product page
      When User clicks Manually Enter NDC button on scan product page
      Then System should display Drug Identifier page
      When User enter the NDC number dynamically in NDC Number edit field
      When I click on Next button on Enter Drug Identifier page
      Then I should see Reason for Manual Entry screen
      And User selects one of the four reasons
      And I should see the Next button on Reason for Manual Entry Page
      When I click on Next button on Reason for Manual Entry Page
      Then I should see Confirm Quantity page
      When I click on Yes button on Confirm Quantity page
      When I click on FillNextRx button
      When User clicks patient order status button in navigation panel
      And User enters patient last name in POS last name text box
        | InputFileName | SheetName | RowId   |
        | TestData  | patient   | Row_CE_Two |
#    And User enters patient phone number in POS phone number text box
#      | InputFileName | SheetName | RowId   |
#      | TestData  | patient   | Row_CE_Two |
      And User clicks search button on patient order status
      Then The prescription status should be In Progress-Filled
        | InputFileName | SheetName | RowId   |
        | TestData  | patient   | Row_CE_Two |
      When User clicks product verification task in the task board
      Then The RxMS system should display product verification page
      When User enters Rx number in PV window
      And User clicks Verify Button in PV page
      When User clicks accept on PV window
      When User navigates to patient order status
      And User enters patient last name in POS last name text box
        | InputFileName | SheetName | RowId   |
        | TestData  | patient   | Row_CE_Two |
#    And User enters patient phone number in POS phone number text box
#      | InputFileName | SheetName | RowId   |
#      | TestData  | patient   | Row_CE_Two |
      And User clicks search button on patient order status
    Then User validates the status as "Ready" and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
      And User clicks delete prescription in patient order status
      And clicks on Delete RX
      Then The prescription should be deleted
    
  @RXQE-7567 @Joust @Regression_pv
  Scenario: SIT | View Failure Preview | Task activity | Failure Preview Selection | PV Task
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    And user gets the store number from RXMS
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
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
      | TestData      | patient   | Row_CE_Two |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information for first product
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Product_CE_Eight |
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
      | TestData      | patient   | Row_CE_Two |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And clicks select all for therapy review
    And user clicks on Override in CE screen
    Then System should display patient order status page
    And User clicks search button on patient order status
    And The prescription status should be In Progress -Reviewed after completing CE for respective first Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData  | product   | Product_CE_Eight |
    When User clicks filling in the taskboard
    And The system should display a message Use - the Mobile Device to complete Filling
    When User logs in to the Fill appplication on android device
    Then I should see the Drug Information page
    When User clicks Yes button on Drug Information page
    Then System should display Scan Product page
    When User clicks Manually Enter NDC button on scan product page
    Then System should display Drug Identifier page
    When User enter the NDC number dynamically in NDC Number edit field
    When I click on Next button on Enter Drug Identifier page
    Then I should see Reason for Manual Entry screen
    And User selects one of the four reasons
    And I should see the Next button on Reason for Manual Entry Page
    When I click on Next button on Reason for Manual Entry Page
    Then I should see Confirm Quantity page
    When I click on Yes button on Confirm Quantity page
    When I click on FillNextRx button
    When User clicks patient order status button in navigation panel
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
#    And User enters patient phone number in POS phone number text box
#      | InputFileName | SheetName | RowId   |
#      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    Then The prescription status should be In Progress-Filled
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    When User clicks product verification task in the task board
    Then The RxMS system should display product verification page
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
    And the Product Verification screen user is viewing still remains open
    When the user clicks on the notification alert icon
    Then the system opens the failure preview
    When user clicks or selects Enter on a failure in the failure preview
    And the system closes the failure preview
    And the system brings the user to the failure queue overlay
    And the focus is on user selected failure
    When the user clicks on the X button of the Failure Preview Overlay
    Then the Failure Preview Overlay is closed
    And the Product Verification screen user is viewing still remains open
		
  @RXQE-7484 @Joust_device @Regression_pv
  Scenario: SIT | View Failure Preview | Information Displayed in Failure Preview | Update Rx - Failure | after PV
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
    And user clicks on Override in CE screen
    Then System should display patient order status page
    And User clicks search button on patient order status
    And The prescription status should be In Progress -Reviewed
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    Then A filling task should get created in the taskboard
    When User clicks filling in the taskboard
    Then The system should display a message Use - the Mobile Device to complete Filling
    When User logs in to the Fill appplication on android device
    Then I should see the Drug Information page
    When User clicks Yes button on Drug Information page
    Then System should display Scan Product page
    When User clicks Manually Enter NDC button on scan product page
    Then System should display Drug Identifier page
    When User enter the NDC number dynamically in NDC Number edit field
    And I click on Next button on Enter Drug Identifier page
    Then I should see Reason for Manual Entry screen
    When User selects one of the four reasons
    Then I should see the Next button on Reason for Manual Entry Page
    When I click on Next button on Reason for Manual Entry Page
    Then I should see Confirm Quantity page
    When I click on Yes button on Confirm Quantity page
    And I click on FillNextRx button
    When User clicks patient order status button in navigation panel
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User clicks search button on patient order status
    Then The prescription status should be In Progress-Filled
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    When User clicks product verification task in the task board
    Then The RxMS system should display product verification page
    When User enters Rx number in PV window
    And User clicks Verify Button in PV page
    When User clicks accept on PV window
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User clicks search button on patient order status
    And The status in patient order status should be changed to Ready
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User validates the status as "Ready" and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User clicks delete prescription in patient order status
    And check the soft allocation after delete rx in stock plus
    And check the stock db for onshelf count after fill
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_Pharmasist |
    And User clicks login button
    Then System should display RxMS home page
   	When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User clicks search button on patient order status
    And User validates the status as "pending" and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    When User clicks on the Update Rx button
    Then the system should display Update Rx page
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_one |
    And clicks on the Update button
    And an error has encountered
    And click on the close popup error
    When user hits HOT Keys Ctrl + E
    Then the system opens the failure preview
    And focus is on the first item by default
    Then system should display the patient information that reflect the information at time of Updating the Rx
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And system should display Error Reason Update Rx Failed
    And system should display Rx Number


