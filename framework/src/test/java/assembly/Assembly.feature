@assembly 
Feature: Assembly smoke test case E2E flow

  @Smoke_Assembly_E2E @RXUAT-217 @UAT @regression_device
  Scenario: This flow includes Login=>patient search=>Prescription Intake=>Data Entry=>Data Review=>Clinical Evaluation=>Patient order status=> Filling on Device
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
    And The system should display a message Use - the Mobile Device to complete Filling
    Given User logs in to the Fill appplication on android device
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
    #Then I should see Initial Page screen again

  #And User clicks search button on patient order status
  #RXAPPD-14485 Log In - Navigation to the Home Page
  @RXQE-1811 @E2E @regression_device
  Scenario: E2E Fiat  Assembly  No Task page
    Given User logs in to the Fill appplication on android device
    Then I see Hamburger menu is located
    And I see Fill text after login
    And I see All caught up you have no other prescriptions to fill is present

    
     @RXUAT-219 @UAT @regression_device
  Scenario: Assembly - Manual Override
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
    And The system should display a message Use - the Mobile Device to complete Filling
    Given User logs in to the Fill appplication on android device
    Then I should see the Drug Information page
    When User clicks Yes button on Drug Information page
    Then System should display Scan Product page
    When User clicks Manually Enter NDC button on scan product page
    Then System should display Drug Identifier page
    When User enter the NDC number dynamically in NDC Number edit field
    #When User enter the UPC number in UPC Number edit field
     #| InputFileName | SheetName | RowId   |
     #| TestData      | UPC       | Row_one | 
    #Then NDC number field should be greyed out
    When User clicks back button on android device
    Then System should display Scan Product page
    When User clicks Manually Enter NDC button on scan product page
    Then System should display Drug Identifier page
    When User enter the NDC number dynamically in NDC Number edit field
    #And User enters the NDC number in NDC Number edit field
    Then UPC number field should be greyed out
    When User clicks back button on android device
    Then System should display Scan Product page
    When User clicks Manually Enter NDC button on scan product page
    And User enters incorrect NDC or UPC in drug identifier page
    And User clicks next Button on enter drug identifier page
    Then System should display an error message - there was an error with the entered product identifier
    When User clicks Try again on the incorrect product identifier error message
    Then System should display Drug Identifier page
    When User clicks back button on android device
    When User clicks back button on android device
    Then System should display Scan Product page
    When User clicks Manually Enter NDC button on scan product page
    Then System should display Drug Identifier page
    When User enter the NDC number dynamically in NDC Number edit field
    And User clicks next Button on enter drug identifier page
    Then System should display reason for manual entry screen
    Then System should display following four reason codes as radio buttons
      | Barcode will not scan  |
      | Filled from automation |
      | Barcode missing        |
      | Stock bottle missing   |
    Then next button should be disabled on reason for manual entry page
    When User clicks back button on android device
    Then System should display Drug Identifier page
    When User clicks next Button on enter drug identifier page
    Then System should display reason for manual entry screen
    When User selects one of the four reasons
    #Then System should display error message - Please enter a reason
    #When User selects ok on the reason for manual entry error message
    #Then System should display reason for manual entry page
    When User selects additional reason on reason for manual entry screen
    Then System should enable the user to select only one reason at a time
    When User clicks next button on reason for manual entry screen
    Then System should display confirm quantity page
    When User clicks Yes button on confirm quantity page
    And User should be navigated to packaging and preferences screen

  @RXUAT-221 @UAT @regression_device
  Scenario: Assembly-Confirm Quantity
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
    And User clicks No button on confirm quantity page
    Then An alert message should be displayed - This function cannot be completed in ICplus
    When User selects Ok on the partial fill error message
    Then System should display No Assemby tasks screen or drug information page of the next rx
    #Then prescription status should be check ICplus in patient order status
      #| InputFileName | SheetName | RowId   |
      #| smokeTestSIT  | patient   | Row_one |

    @RXQE-5791 @RXQE-5521 @IkariWarriors_device @regression_device
  Scenario: SIT-Verify delete Rx for FILLED prescriptions	
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
    And User validates the status as "filled" and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    And User clicks delete prescription in patient order status
    Then System should diplay popup error message on POS after click on DeletRx In filling
    And clicks delete rx button on the alert message
    Then The prescription should be deleted
    
     @RXQE-6006 @RXQE-5528 @IkariWarriors_device @regression_device
  Scenario: SIT | Push back | Delete an Rx which has the status of Check ic+ due to pushback
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
    Then System should display drug information page
    And User clicks No button on durg information page
    When User selects Ok on the partial fill error message
    Then System should display No Assemby tasks screen or drug information page of the next rx
    When User clicks patient order status button in navigation panel
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    #And User enters patient phone number in POS phone number text box
      #| InputFileName | SheetName | RowId   |
      #| TestData      | patient   | Row_one |
    And User clicks search button on patient order status
    Then User validates the status as "Check IC+" and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    And User clicks delete prescription in patient order status
    Then System should display a message "IC+ prescription can only be deleted in IC+" under the prescription

@Joust @RXQE-7088 
Scenario: SIT|Update Outstanding Quantity- After An update of the prescription has been completed
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
	And The system should display a message Use - the Mobile Device to complete Filling
	When User logs in to the Fill appplication on android device
	Then System should display drug information page
  When User clicks Yes button on Drug Information page
  Then System should display Scan Product page
  When User clicks Manually Enter NDC button on scan product page
  Then System should display Drug Identifier page
  When User enter the UPC number in UPC Number edit field
   | InputFileName | SheetName | RowId   |
   | TestData      | UPC       | Row_one |
	And User clicks next Button on enter drug identifier page
  Then System should display reason for manual entry screen
  When User selects one of the four reasons
  When User clicks next button on reason for manual entry screen
  Then System should display confirm quantity page
  And User clicks Yes button on confirm quantity page
	And User should be navigated to packaging and preferences screen
	When I click on Print button
	Then I should see Initial Page screen again 
	Then stock movement updates Outstanding Quantity    	
	
	
@Joust @RXQE-7170
Scenario: SIT|Update Stock When Dispensing Below zero-Dispense of the item partially exceeds
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
	And The system should display a message Use - the Mobile Device to complete Filling
	When assembly partially exceeds the on-shelf 
	And quantity dispensed is 200 and the stock in shelf is 70
	Then the inventory system deducts the quantity from the shelf -70
	When User logs in to the Fill appplication on android device
	Then I should see the Drug Information page
	When User clicks Yes button on Drug Information page
	Then System should display drug information page
  When User clicks Yes button on Drug Information page
  Then System should display Scan Product page
  When User clicks Manually Enter NDC button on scan product page
	When User enter the UPC number in UPC Number edit field
   | InputFileName | SheetName | RowId   |
   | TestData      | UPC       | Row_one |
	And User clicks next Button on enter drug identifier page
  Then System should display reason for manual entry screen
  When User selects one of the four reasons
  When User clicks next button on reason for manual entry screen
	Then I should see Confirm Quantity page	
	
@Joust @RXQE-7058
Scenario: SIT|Update Outstanding Quantity| when no On Shelf-After Assembly operation has been completed
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
  And checks for available product with zero in onshelf in Stock data base
  And get the product name from database
  And clicks open product button
  And enters product information from db
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_DR_fourteen |
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
	And The system should display a message Use - the Mobile Device to complete Filling
	When User logs in to the Fill appplication on android device
	Then System should display drug information page
  When User clicks Yes button on Drug Information page
  Then System should display Scan Product page
  When User clicks Manually Enter NDC button on scan product page
  Then System should display Drug Identifier page
  When User enter the UPC number in UPC Number edit field
   | InputFileName | SheetName | RowId   |
   | TestData      | UPC       | Row_one |
	And User clicks next Button on enter drug identifier page
  Then System should display reason for manual entry screen
  When User selects one of the four reasons
  When User clicks next button on reason for manual entry screen
  Then System should display confirm quantity page
  And User clicks Yes button on confirm quantity page
	And User should be navigated to packaging and preferences screen
	When I click on Print button
	Then I should see Initial Page screen again 
	Then stock movement updates Outstanding Quantity	
	
	
@Joust @RXQE-7102
Scenario: SIT|Update Outstanding quantity-After pullback prescription has been received from IC+
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
	And The system should display a message Use - the Mobile Device to complete Filling
	When User logs in to the Fill appplication on android device
	Then System should display drug information page
  When User clicks Yes button on Drug Information page
  Then System should display Scan Product page
  When User clicks Manually Enter NDC button on scan product page
  Then System should display Drug Identifier page
  When User enter the UPC number in UPC Number edit field
   | InputFileName | SheetName | RowId   |
   | TestData      | UPC       | Row_one |
	And User clicks next Button on enter drug identifier page
  Then System should display reason for manual entry screen
  When User selects one of the four reasons
  When User clicks next button on reason for manual entry screen
  Then System should display confirm quantity page
  And User clicks Yes button on confirm quantity page
	And User should be navigated to packaging and preferences screen
	When I click on Print button
	Then I should see Initial Page screen again 
	When Status is changed to 'Sent to IC+' from 'Filled/Ready' in Patient Order Status screen 
	Then stock movement reverts back On Shelf and Outstanding Quantities
	
@Joust @RXQE-7118
Scenario: SIT|Update Outstanding Quantity-After a failure has been received from Super Mario
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
	And The system should display a message Use - the Mobile Device to complete Filling
	When User logs in to the Fill appplication on android device		
	Then System should display drug information page
  When User clicks Yes button on Drug Information page
  Then System should display Scan Product page
  When User clicks Manually Enter NDC button on scan product page
  Then System should display Drug Identifier page
  When User enter the UPC number in UPC Number edit field
   	| InputFileName | SheetName | RowId   |
   	| TestData      | UPC       | Row_one |
  And User clicks next Button on enter drug identifier page
  Then System should display reason for manual entry screen
  When User selects one of the four reasons
  When User clicks next button on reason for manual entry screen
  Then System should display confirm quantity page
  And User clicks Yes button on confirm quantity page
	And User should be navigated to packaging and preferences screen
	When I click on Print button
	#And I click on OK button in Popup message
	Then I should see Initial Page screen again 
	When Status is changed to 'Sent to IC+' from 'Filled/Ready' in Patient Order Status screen due to failure from Super Mario
	Then stock movement reverts back On Shelf and Outstanding Quantities

	
@Joust @RXQE-7753
Scenario: CLONE - SIT|Update Outstanding Quantity| when no ENOUGH On Shelf-After Assembly operation has been completed
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
	And The system should display a message Use - the Mobile Device to complete Filling
	When User logs in to the Fill appplication on android device	
	Then System should display drug information page
  When User clicks Yes button on Drug Information page
  Then System should display Scan Product page
  When User clicks Manually Enter NDC button on scan product page
  Then System should display Drug Identifier page
  When User enter the UPC number in UPC Number edit field
   | InputFileName | SheetName | RowId   |
   | TestData      | UPC       | Row_one |
	And User clicks next Button on enter drug identifier page
  Then System should display reason for manual entry screen
  When User selects one of the four reasons
  When User clicks next button on reason for manual entry screen
  Then System should display confirm quantity page
  And User clicks Yes button on confirm quantity page
	And User should be navigated to packaging and preferences screen
	When I click on Print button
	Then I should see Initial Page screen again 
	Then stock movement updates Outstanding Quantity
	
	@RXQE-7481 @Joust_device @regression_device
  Scenario: SIT | View Failure Preview | Information Displayed in Failure Preview | Update Rx - Failure | after FILL
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
        | TestData      | product   | Product_CE_Seven |
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
        | TestData  | product   | Product_CE_Seven |
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
      When User hits ctrl plus four hot key
      Then System should navigate to PV screen or System shows a pop-up if there are no PV tasks
      When User hits ctrl plus h hot key
      Then System should display RxMS home page
      When User hits ctrl plus o hot key
      Then System should display an alert message asking for this device or all devices
      When User hits alt plus t hot key
      Then System should display the login page
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_Pharmacist |
    And User clicks login button
    Then System should display RxMS home page
   	When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
    And User clicks search button on patient order status
      Then User validates the status as "IN PROGRESS" and selects the current prescription
        | InputFileName | SheetName | RowId         |
        | TestData      | patient   | Row_CE_Two |
      And Clicks on UpdateRx Btn
      Then System should display Update Rx page
      And enters product information for first product
        | InputFileName | SheetName | RowId   |
        | TestData      | product   | Product_CE_Eight |
		And clicks on the Update button
		And an error has encountered
		And click on the close popup error
		When user hits HOT Keys Ctrl + E
		Then the system opens the failure preview
	    And focus is on the first item by default
		Then system should display the patient information that reflect the information at time of Updating the Rx
			| InputFileName | SheetName | RowId   |
		  | TestData      | patient   | Row_CE_Two |
		And system should display Error Reason Update Rx Failed
		And system should display Rx Number