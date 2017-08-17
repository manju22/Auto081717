@clinicalEvaluation @Regressiontest @CE_1
Feature: Clinical Evaluation

 @RXUAT-230 @UAT @Regression 
  Scenario: View Med History from DUR
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
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_Six |
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
    Then System should not display AddToRefill Button
    And System should not display Reprint Button
    And System should not display Inactive Button
    And System should not display Transfer Button
    And System should not display Close Button
    And User should see Green dot in med history status
    And User should see Additional Medications Tab
    When User click on Additional Medications link
    Then system displays the message No additional Med have been added
    And System should not display Update button

  @RXUAT-231 @RXUAT-225 @RXQE-3160 @UAT @P1 @Regression
  Scenario: View Clinical References for DUR
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
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_Six |
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
    When User click on Clinical References Tab
    And the system should not show Stock Plus Report Hyperlink
    Then User should see Logos with Hyperlinks
    When User click on First existing logo for each of the Six clinical references
    Then system will open the related URL in the application frame passing the information from the First link
    When User click on Second existing logo for each of the Six clinical references
    Then system will open the related URL in the application frame passing the information from the Second link
    When User click on Third existing logo for each of the Six clinical references
    Then system will open the related URL in the application frame passing the information from the Third link
    When User click on Fourth existing logo for each of the Six clinical references
    Then system will open the related URL in the application frame passing the information from the Fourth link
    When User click on Fifth existing logo for each of the Six clinical references
    Then system will open the related URL in the application frame passing the information from the Fifth link
    When User click on Sixth existing logo for each of the Six clinical references
    Then system will open the related URL in the application frame passing the information from the Sixth link

 @RXUAT-232 @UAT  @Regression
  Scenario: Override Interaction - Systematic DUR
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
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_Six |
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
    When User click on Major Interaction FirstCheckBox
    And User click on Override Button
    Then system must display the DUR Override pop-up
    And Focus will be on the DUR Intervention Code field
    And The Comment field will be blank
    And Save button will be enabled
    And Cancel buttons will be enabled
    And user should be allowed to navigate through all intervention codes
    #And user should select DUR intervention codes
    And user click on Save button
    Then system display Error msg "DUR Comment is required"
    And The user selects Alt+C
    And Save functionality will be invoked redirect to clincal check page
    When User click on Override Button
    And user should select DUR intervention codes
    And user tries to enter more than two hundred fifty characters in the Comment field
    And The user selects Alt+S
    And Save functionality will be invoked redirect to clincal check page   
    And user wishes to perform a DUR override for all interactions where there are multiple interactions and at least one is major interaction
    #And clicks select all for therapy review
 		And clicks Override in CE screen
    And user should select DUR intervention codes
    And user tries to enter more than two hundred fifty characters in the Comment field
    And The user selects Alt+S
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
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_Six |
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
    And clicks select all for therapy review
    And user clicks on Override in CE screen
    Then System should display patient order status page
    And User clicks search button on patient order status
    And The prescription status should be In Progress -Reviewed after completing CE for respective first Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_One |
      | TestData  | product   | Product_CE_Six |
#    And The prescription status should be In Progress -Reviewed
#      | InputFileName | SheetName | RowId   |
#      | TestData  | patient   | Row_CE_One |
    And User closes the application



  @RXUAT-233 @RXQE-2793 @UAT @Regression
  Scenario: View Interaction Summary
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
      | TestData  | patient   | Row_CE_Two |
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
      | TestData  | patient   | Row_CE_Two |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_Six |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
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
      | TestData  | patient   | Row_CE_Two |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then User should see Clinical Check page
    When User clicks on down arrow button to view Interaction Summary for Major Interactions
    Then System should display documentation Label
    And System should display documentation Text
    And System should display Drug Name Last Fill Date Label
    And System should display Drug Name Last Fill Date
    And System should display Onset Label
    And System should display Onset Text
    And System should display Informative Message TBD
    And System should display View Interaction Monograph
    When User clicks on down arrow button to view Interaction Summary for Theraphy Review "Duplicate Theraphy"
    Then System should display Significance Label
    And System should display Significance Text
    And System should display Duplicate Allowance Label
    And System should display Duplicate Allowance Text
    And System should display Informative Message Text

  @RXUAT-234 @RXQE-2785 @UAT @P1  @Regression
  Scenario: View Drug-Drug Interaction Monograph
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
      | TestData  | patient   | Row_CE_Six |
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
      | TestData  | patient   | Row_CE_Six |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_gaurav |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_Seven |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
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
      | TestData  | patient   | Row_CE_Six |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then User should see Clinical Check page
    When User clicked on drug drug Interaction down arrow
    And I click on drug drug View Interaction Monograph Link
    Then I should see Drug Drug Interaction Monograph Label
    And I should see Effect lable Text
    And I should see Mechanism label Text
    And I should see Management label Text
    And I should see Discussion label Text
    And I should see Reference label Text
    And I should see Ok button Enabled
    When I click on Ok Popup Button
    Then Popup should close and redirected to Clinical Check Screen

  @RXUAT-235 @RXQE-2786 @UAT @P1  @Regression
  Scenario: View Drug-Allergy Interaction Monograph
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
      | TestData  | patient   | Row_CE_Two |
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
      | TestData  | patient   | Row_CE_Two |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
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
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Row_CE_Ten |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Product_CE_Seven |
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
      | TestData  | patient   | Row_CE_Two |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then User should see Clinical Check page
    When User click on downArrow button for drug-allergy interaction for Major Interactions
    And I click on View Interaction Monograph Link
    Then I should see Drug Allergy Interaction Monograph Label
    And I should see Drugs Reported to Cause An Adverse Reaction and the Symtoms Associated With The Drug's Administration
    And I should see Oher Structurally Related Drugs
    And I should see Discussion label Text
    And I should see Reference label Text
    And I should see Ok button Enabled
    When I click on Ok Popup Button
    Then Popup should close and redirected to Clinical Check Screen

  @RXQE-2893 @E2E @Regression 
  Scenario: E2E | Drug Utilization Review | Validate tab order and hot keys
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
     | TestData  | patient   | Row_CE_Six |
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
     | TestData  | patient   | Row_CE_Six |
   And User enters patient phone number in POS phone number text box
     | InputFileName | SheetName | RowId   |
     | TestData  | patient   | Row_CE_Six |
   And User clicks search button on patient order status
   Then The pending link for current prescription should be clicked
     | InputFileName | SheetName | RowId   |
     | TestData  | patient   | Row_CE_Six |
   Then System displays a donut chart
   When User clicks perform data entry hyperlink
   Then Sytem should display data entry page
   When User enters prescriber first name and Last name
     | InputFileName | SheetName  | RowId   |
     | TestData  | prescriber | Prescriber_CE_Two |
     And User selects null value in the state dropdown
   And clicks search button on prescriber search
   And clicks select to select a prescriber
   And enters product information
     | InputFileName | SheetName | RowId   |
     | TestData  | product   | Product_CE_Seven |
   And clicks open payment button
   And selects payment type
   And clicks Finish button to complete Data Entry
   And System should display patient order status page
   And clicks search button on patient order status page
   And The In progress link for current prescription should be clicked
     | InputFileName | SheetName | RowId   |
     | TestData  | patient   | Row_CE_Six |
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
     | TestData  | patient   | Row_CE_Six |
   And The In progress link for current prescription should be clicked
     | InputFileName | SheetName | RowId   |
     | TestData  | patient   | Row_CE_Six |
   Then System displays a donut chart
   When User clicks perform clinical evaluation hyperlink
   Then User should see Clinical Check page
    And Validate the Tab Order Select All Override Send to IC+  Cancel
   #Validate Hot Keys:
    When user hits Alt plus S
    Then should Select All the checkboxes
    When user hits Alt plus O
    Then system must display the DUR Override pop-up
    When The user selects Alt+C
    Then User should see Clinical Check page
    When user hits Shift Alt plus
    And user hits Alt plus R
    Then System should display Rx details page

  @RXQE-3750 @E2E @Regression
  Scenario: E2E | Clinical Evaluation task | In Interactions Tab, Validate jumplinks for all Interactions (Major, Moderate & Therphy)
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
      | TestData  | patient   | Row_CE_Two |
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
      | TestData  | patient   | Row_CE_Two |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Prescriber_CE_Two|
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_Seven |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
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
      | TestData  | patient   | Row_CE_Two |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then User should see Clinical Check page
    When User Select the jump link for major Interaction
    Then User should see all major interactions in front
    When User Select the jump link for moderate Interaction
    Then User should see all moderate interactions in front
    When User Select the jump link for Therapy review
    Then User should see all Therapy review in front

  @RXAPPD-13648 @CE @Fiat_Appdev @Regression
  Scenario: UI - Drug Utilization Review - Verify that the system displays a message if the patient does not have any additional meds associated
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
      | TestData  | patient   | Row_CE_Two |
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
      | TestData  | patient   | Row_CE_Two |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_One |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    Then System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then User should see Clinical Check page
    When I clicks Med History
    Then I clicks Additional Medications
    And I should see "No Additional medications have been added. Click update to add a medication"
    And User closes the application

  @RXAPPD-12613 @RXAPPD-15415 @RXAPPD-10697 @RXQE-1830 @RXQE-3138 @E2E @Regression
  Scenario: UI - Patient Order Status Navigation - Rework For Hybrid - To display all information of prescription updated in Patient Order Status perfoming a Rx Review
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
      | TestData  | patient   | Row_CE_Six |
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
      | TestData  | patient   | Row_CE_Six |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
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
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_One |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    Then System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And clicks select all for therapy review
    And user clicks on Override in CE screen
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    And the donut chart should display filling directions

  @RXQE-2887 @E2E  @Regression
  Scenario: E2E | Drug Utilization Review | Verify Send IC+ button clicked while processing a Clinical Evaluation task
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
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_One |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And  System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_One |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks first accept to validate patient data
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
    And clicks select all for therapy review
    And click Send to IC plus button in CE
    Then The pending link for current prescription should say check IC
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_One |

  @RXUAT-258 @RXQE-2792 @UAT @P1 @Regression
  Scenario: View Prescription Summary
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
      | TestData  | patient   | Row_CE_Five |
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
      | TestData  | patient   | Row_CE_Five |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Five |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Five |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_One |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And  System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Five |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Five |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Five |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And user last fill date will be blank
    Then user able to see following feilds
      |Patient Information|
      |No Allergies|
      |No Health Conditions|
    Then user selects Alt plus R
    And Rx details will be displayed on the Rx Details pop up
    Then user click close on popup
    Then user clicks on the Rx Number hyperlink
    And Rx details will be displayed on the Rx Details pop up

  @RXQE-2895 @E2E @Regression
  Scenario: verify that it is possible to display Therapeutic class of a product
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
      | TestData  | patient   | Row_CE_Six |
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
      | TestData  | patient   | Row_CE_Six |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_One |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And  System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then User is on clinical evaluation page
    Then system displays Therapeutic Class populated in Rx Details screen
    And User closes the application

  @RXQE-2897 @E2E @Regression
  Scenario: Verify the format information in the Rx Details section of the Clinical screen
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
      | TestData  | patient   | Row_CE_Five |
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
      | TestData  | patient   | Row_CE_Five |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Five |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Five |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName 		 | SheetName | RowId     |
      | TestData | product   | Row_three |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And  System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Five |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Five |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Five |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And user able to see following formats feilds
      | InputFileName      | SheetName     | RowId     |
      | TestData | product       | Row_Seven |
      | TestData       | prescriber    | Prescriber_CE_One   |


  @RXQE-2922 @E2E @P1 @Regression
  Scenario: Verify that Pediatric Interactions appears for a patient Under Age of 13
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
      | TestData  | patient   | Row_CE_Six |
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
      | TestData  | patient   | Row_CE_Six |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_Two |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And  System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And system displays a Pediatric Interaction for the patient
    And clicks select all for therapy review
    And user clicks on Override in CE screen

  @RXQE-2924 @E2E @P1 @Regression
  Scenario: Verify that Elderly Interactions appears for a patient over Age 65
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
      | TestData  | patient   | Row_CE_Nine |
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
      | TestData  | patient   | Row_CE_Nine |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Nine |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Nine |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_Two |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And  System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Nine |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    When User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Nine |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Nine |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And system displays an interaction for Eldery patients
    And clicks select all for therapy review
    And user clicks on Override in CE screen


#@RXUAT-182 @UAT
#Scenario: Cancel clinical check
# Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData      | login     | Row_one |
    #And User clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_CE_One |
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
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_CE_One |
    #And User enters patient phone number in POS phone number text box
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_CE_One |
    #And User clicks search button on patient order status
    #Then The pending link for current prescription should be clicked
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_CE_One |
    #Then System displays a donut chart
    #When User clicks perform data entry hyperlink
    #Then Sytem should display data entry page
    #When User enters prescriber first name and Last name
      #| InputFileName | SheetName  | RowId   |
      #| TestData  | prescriber | Prescriber_CE_One |
    #And User selects null value in the state dropdown
    #And clicks search button on prescriber search
    #And clicks select to select a prescriber
    #And enters product information
      #| InputFileName | SheetName | RowId   |
      #| TestData  | product   | Product_CE_One |
    #And clicks open payment button
    #And selects payment type
    #And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    #And System should display patient order status page
    #And clicks search button on patient order status page
    #And The In progress link for current prescription should be clicked
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_CE_One |
    #Then System displays a donut chart
    #When User clicks perform data review hyperlink
    #Then System should display data review page
    #When User validates patient data
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_CE_One |
    #And User clicks first accept to validate patient data
    #And User validates prescriber data
      #| InputFileName | SheetName  | RowId   |
      #| TestData  | prescriber | Prescriber_CE_One |
    #And clicks second accept to validate prescriber data
    #And User validates product data
      #| InputFileName | SheetName  | RowId   |
      #| TestData  | prescriber | Row_one |
    #And clicks third accept to validate product data
    #And clicks Finish to complete data review
   # Then Number of DR tasks should be decreased
    #Then A clinical evaluation task should get created
    #And System should display patient order status page
    #And User clicks search button on patient order status
    #Then System should generate Rx number for current prescription
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_CE_One |
    #And The In progress link for current prescription should be clicked
      #| InputFileName | SheetName | RowId   |
      #| TestData  | patient   | Row_CE_One |
    #Then System displays a donut chart
    #When User clicks perform clinical evaluation hyperlink
    #Then User is on Clinical Evaluation screen
    #When User selects no evaluation criteria and clicks cancel using ALT plus C hot keys
    #Then User should see a popup
    #And User selects cancel using ALT plus C hot keys
    #Then User is on Clinical Evaluation screen
    #And clicks select all for therapy review
    #And User selects cancel using ALT plus C hot keys
    #Then User should see a popup
    #And User selects yes using ALT plus y hot keys
    #Then User is on previous screen

  @RXQE-3159 @RXQE-2846 @RXQE-2847 @E2E @P1 @Regression
  Scenario: E2E DUR Single image multiple Rx
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
      | TestData  | patient   | Row_CE_Two |
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
      | TestData  | patient   | Row_CE_Two |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information for first product
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_Eight |
    And clicks open payment button
    And selects payment type
    And User clicks Add Rx button
    And enters product information for second product
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_Seven |
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked after adding Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData       |   product     |     Product_CE_Eight     |
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
      | TestData  | patient   | Row_CE_Two |
      | TestData       |   product     |     Product_CE_Seven     |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription after adding Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData       |   product     |     Product_CE_Eight     |
    And The In progress link for current prescription should be clicked after adding Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData       |   product     |     Product_CE_Eight     |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And clicks select all for therapy review
    And clicks Override in CE screen
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription after adding Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData       |   product     |     Product_CE_Seven     |
    And The In progress link for current prescription should be clicked after adding Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData       |   product     |     Product_CE_Seven     |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And clicks select all for therapy review
    And clicks Override in CE screen
    Then System should display patient order status page
    And User clicks search button on patient order status
    And The prescription status should be In Progress -Reviewed after completing CE for respective first Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData       |   product     |     Product_CE_Eight     |
    And The prescription status should be In Progress -Reviewed after completing CE for respective second Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData       |   product     |     Product_CE_Seven     |
    When User clicks filling in the taskboard
    And The system should display a message Use - the Mobile Device to complete Filling
    And User closes the application

  @RXQE-2894 @E2E @Regression
  Scenario: Search Clinical History
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName 		| SheetName 			| RowId   |
      | TestData  | patient   | Row_CE_Six |
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
      | InputFileName 		| SheetName 			| RowId   |
      | TestData  | patient   | Row_CE_Six |
    And User enters patient phone number in POS phone number text box
      | InputFileName 		| SheetName 			| RowId   |
      | TestData  | patient   | Row_CE_Six |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName 		| SheetName 			| RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName 		| SheetName  				| RowId   |
      | TestData  | prescriber 	 	| Prescriber_CE_Three |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName 		| SheetName  				| RowId   |
      | TestData  | product 	 	| Product_CE_Six |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName 		| SheetName 		  | RowId   |
      | TestData  | patient   | Row_CE_Six |
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
      | InputFileName 		| SheetName 		  | RowId   |
      | TestData  | patient   | Row_CE_Six |
    And The In progress link for current prescription should be clicked
      | InputFileName 		| SheetName 		  | RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then user clicks on the Clinical History tab
    And user checks the header fields
    And user verify drug name and strength
    And verify store number is five digit format
    And click on downward arrow
    And check fill date is in correct format
    And CE is displayed as hyperlink
    And select the CE hyperlink
    And User closes the application

  @UAT @RXAPPD-13822 @RXAPPD-13821 @RXAPPD-10753 @RXAPPD-15409 @RXAPPD-9830 @RXAPPD-9744 @RXAPPD-9751 @RXAPPD-9849 @RXAPPD-9851 @RXAPPD-9857 @RXAPPD-10695 @RXAPPD-10696 @RXAPPD-14025 @RXAPPD-15426 @Regression 
  Scenario: This flow covers the prescription fulfillment right from intake to the creation of filling task.
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
      | TestData  | prescriber | Row_one|
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Row_three |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_One|
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
      | TestData  | patient   | Row_CE_One|
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And clicks select all for therapy review
    And user clicks on Override in CE screen
    Then System should display patient order status page
    And User clicks search button on patient order status
    And The prescription status should be In Progress -Reviewed after completing CE for respective first Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_One|
       | TestData  | product   | Row_three |
    When User clicks filling in the taskboard
    And The system should display a message Use - the Mobile Device to complete Filling

  @RXUAT-372 @UAT  @Regression
  Scenario: Continue prescription progress- Rework for hybrid(scenario 4-5)
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_one |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName 		| SheetName 			| RowId   |
      | TestData  | patient   | Row_CE_One |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName 		| SheetName 			| RowId   |
      | TestData  | patient   | Row_CE_One |
    And User enters patient phone number in POS phone number text box
      | InputFileName 		| SheetName 			| RowId    |
      | TestData  | patient   | Row_CE_One|
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName			| SheetName 			| RowId   |
      | TestData  | patient   | Row_CE_One |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName 		| SheetName  				| RowId   |
      | TestData  | prescriber 	 	| Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName 		| SheetName  				| RowId   |
      | TestData  | product 	 	| Row_three |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName 		| SheetName 		  | RowId    |
      | TestData  | patient   | Row_CE_One |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    Then System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName 		| SheetName 			| RowId    |
      | TestData  | patient   | Row_CE_One|
    When User hits ctrl plus o hot key
    Then System should display an alert message asking for this device or all devices
    When User clicks this device on the logout alert
    Then System should display the login page
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData      | login     | Row_Tech |
    And User clicks login button
    And User clicks patient order status button in navigation panel
    Then System should display patient order status page
    And User enters patient last name in POS last name text box
      | InputFileName 		| SheetName 			| RowId   |
      | TestData  | patient   | Row_CE_One |
    And User enters patient phone number in POS phone number text box
      | InputFileName 		| SheetName 			| RowId    |
      | TestData  | patient   | Row_CE_One |
    And User clicks search button on patient order status
    And The In progress link for current prescription should be clicked
      | InputFileName 		| SheetName 			| RowId    |
      | TestData  | patient   | Row_CE_One |
    Then System displays a donut chart
    And The perform clinical evaluation hyperlink should be disabled

  @RXUAT-183 @UAT @Regression
  Scenario: View Health Conditions
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
      | TestData  | patient   | Row_CE_Six |
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
      | TestData  | patient   | Row_CE_Six |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_One |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
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
      | TestData  | patient   | Row_CE_Six |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then User is on clinical evaluation page
    When User clicks on health conditions using ALT plus H hot key
    Then User is able to see a pop showing health conditions of patient
    And User checks the health conditions of the patient are in order
    When The user viewing the Health Conditions pop-up screen selects the hot keys combination Alt+C
    Then User is on clinical evaluation page
    When User clicks on health conditions using ALT plus H hot key
    And The user viewing the Health Conditions pop-up screen clicks the close button
    Then User is on clinical evaluation page
    When User clicks on health conditions using ALT plus H hot key
    And The user viewing the Health Conditions pop-up screen clicks the X button
    Then User is on clinical evaluation page

  @RXUAT-184 @UAT @Regression
  Scenario: View Allergies
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
      | TestData  | patient   | Row_CE_Six |
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
      | TestData  | patient   | Row_CE_Six |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_One |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
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
      | TestData  | patient   | Row_CE_Six |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Six |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then User is on clinical evaluation page
    When User clicks on allergies using ALT plus A hot key
    Then User is able to see a pop showing allergies of patient
    And User checks the allergies of the patient are in order
    When The user viewing the allergies pop-up screen selects the hot keys combination Alt+C
    Then User is on clinical evaluation page
    When User clicks on allergies using ALT plus A hot key
    And The user viewing the allergies pop-user screen clicks the close button
    Then User is on clinical evaluation page
    When User clicks on allergies using ALT plus A hot key
    And The user viewing the allergies pop-up screen clicks the X button
    Then User is on clinical evaluation page

  @RXUAT-257 @UAT  @Regression
  Scenario: View Patient Information
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
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_One |
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
    Then User is on clinical evaluation page
    When User clicks on health conditions using ALT plus H hot key
    Then User is able to see a pop showing health conditions of patient
    And User checks the health conditions of the patient are in order
    When The user viewing the Health Conditions pop-up screen selects the hot keys combination Alt+C
    Then User is on clinical evaluation page
    When User clicks on allergies using ALT plus A hot key
    Then User is able to see a pop showing allergies of patient
    And User checks the allergies of the patient are in order
    When The user viewing the allergies pop-up screen selects the hot keys combination Alt+C
    Then User is on clinical evaluation page
    When user clicks on Allergies hyper link
    Then User is able to see a pop showing allergies of patient
    And The user viewing the allergies pop-user screen clicks the close button
    When user clicks on Health Condition hyper link
    Then User is able to see a pop showing health conditions of patient
    And The user viewing the Health Conditions pop-up screen clicks the close button
   #the patient doens't have allergies and health condition

    #Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData      | login     | Row_one |
    #And User clicks login button
    When User hits ctrl plus h hot key
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Ten |
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
      | TestData  | patient   | Row_CE_Ten |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Ten |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Ten |
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
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_One |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Ten |
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
      | TestData  | patient   | Row_CE_Ten |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Ten |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    When user check Allergies feild system display as Confirm with patient
    When user check health condition system display as Confirm with patient
    And User closes the application

  @RXUAT-250 @RXQE-2850 @UAT @Regression
  Scenario: E2E | Drug Utilization Review | To verify that it is possible to display “Rx Number” label
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
      | TestData  | patient   | Row_CE_Eight |
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
      | TestData  | patient   | Row_CE_Eight |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Eight |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Eight |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_One |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Eight |
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
      | TestData  | patient   | Row_CE_Eight |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Eight |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then CE screen should display Rx number
    When user selects CE Rx number
    Then the system opens Rx details popup

  @RXQE-2855 @E2E @Regression
  Scenario: E2E | Drug Utilization Review | Pharmacists hits 'Cancel' After Entering Clinical Evaluation
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
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_One |
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
    And clicks select all for therapy review
    Then User clicks cancel button on CE page without popup
    And CE cancel current task popup appears
    Then click cancel on cancel current task popup
    And clicks select all for therapy review
    Then User clicks cancel button on CE page without popup

  @RXQE-3748 @E2E @Regression
  Scenario: Drug Utilization Review  Pharmacists hits Cancel After override some of the Interaction
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
      | TestData  | patient   | Row_CE_Nine |
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
      | TestData  | patient   | Row_CE_Nine |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Nine |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Nine |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_One |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Nine |
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
      | TestData  | patient   | Row_CE_Nine |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Nine |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And user selects few iteractions from iteraction clinical evaluation screen and click override
    Then user click cancel button and system shows popup screen and click yes
    When User navigates to patient order status
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Nine |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Nine |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then user validates the previous override iteractions

  @RXUAT-239 @RXQE-2789 @UAT @P1 @Regression
  Scenario: Search Clinical History
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
      | TestData  | patient   | Row_CE_Eight |
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
      | TestData  | patient   | Row_CE_Eight |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId    |
      | TestData  | patient   | Row_CE_Eight |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
      | TestData  | patient   | Row_CE_Eight |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Prescriber_CE_One |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_One |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
      | TestData  | patient   | Row_CE_Eight |
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
      | InputFileName | SheetName | RowId    |
      | TestData  | patient   | Row_CE_Eight |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId    |
      | TestData  | patient   | Row_CE_Eight |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    When user clicks on Clinical History tab
    Then system should show Clinical History tab
    Then CH text box should show shadow text
    When click CH text box and type
      | InputFileName | SheetName | RowId     |
      | TestData  | product   | Product_CE_Five |
    Then confirm no CH search results found
    When click CH text box and type and enter
      | InputFileName | SheetName | RowId     |
      | TestData  | product   | Product_CE_Three |
    Then CH search shadow text should disappear
    And CH search bar is emptied out
  #NOTE: Below step should represent entering only partial name.  Code works the same as simple CH search
    When user enters drug name in clinical history search
      | InputFileName | SheetName | RowId     |
      | TestData  | product   | Product_CE_Four |
    Then The CE search results should contain the drug keyword
      | InputFileName | SheetName | RowId     |
      | TestData  | product   | Product_CE_Four |
  #NOTE: Unlike previous step, this represents typing in full name.  Code is the same, but intentions are different, hence two different sheets
    When user enters drug name in clinical history search
      | InputFileName | SheetName | RowId     |
      | TestData  | product   | Product_CE_Three |
    Then The CE search results should contain the drug keyword
      | InputFileName | SheetName | RowId     |
      | TestData  | product   | Product_CE_Three |
    When select X at end of clinical history search and refine
    Then clinical history search bar should be blanked

  @RXQE-2851 @E2E @Regression
  Scenario: Major Moderate, and Therapy Review Rows are Matching
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
      | TestData  | patient   | Row_CE_Two |
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
      | TestData  | patient   | Row_CE_Two |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
    When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData  | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    And enters product information for first product
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_2851 |
    And clicks open payment button
    And selects payment type
    And User clicks Add Rx button
    And enters product information for second product
      | InputFileName | SheetName | RowId   |
      | TestData  | product   | Product_CE_Seven |
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And clicks search button on patient order status page
    And The In progress link for current prescription should be clicked after adding Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData       |   product     |     Product_CE_2851     |
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
      | TestData  | patient   | Row_CE_Two |
      | TestData       |   product     |     Product_CE_Seven     |
    Then System displays a donut chart
    When User clicks perform data review hyperlink
    Then System should display data review page
    And User clicks first accept to validate patient data
    And clicks second accept to validate prescriber data
    And clicks third accept to validate product data
    And clicks Finish to complete data review
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription after adding Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData       |   product     |     Product_CE_2851     |
    And The In progress link for current prescription should be clicked after adding Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData       |   product     |     Product_CE_2851     |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then user validates the Major iteractions feilds
    And user validates the Moderate Iteractions Feilds
    And user validates the Therapy_Iteractions Feilds
    And clicks select all for therapy review
    And user clicks on Override in CE screen
    And System should display patient order status page
    And User clicks search button on patient order status
    Then System should generate Rx number for current prescription after adding Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData  | product   | Product_CE_Seven |
    And The In progress link for current prescription should be clicked after adding Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Two |
      | TestData  | product   | Product_CE_Seven |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    Then user validates the Major iteractions feilds
    And user validates the Moderate Iteractions Feilds
    And user validates the Therapy_Iteractions Feilds
    And clicks select all for therapy review
    And user clicks on Override in CE screen
    And System should display patient order status page
    And User clicks search button on patient order status
    And The prescription status should be In Progress -Reviewed after completing CE for respective first Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Eight |
      | TestData  | product   | Product_CE_2851 |
    And The prescription status should be In Progress -Reviewed after completing CE for respective second Rx
      | InputFileName | SheetName | RowId   |
      | TestData  | patient   | Row_CE_Eight |
      | TestData  | product   | Product_CE_Seven |
    When User clicks filling in the taskboard
    And The system should display a message Use - the Mobile Device to complete Filling
    And User closes the application

  @RXQE-5527 @IkariWarriors @Regression
  Scenario: SIT | RXMS | Delete image from POS after user clicks on send to IC+ in CE
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
    Then System should display clinical evaluation page
    And click Send to IC plus button in CE
    Then System should display patient order status page
    And User clicks search button on patient order status
    Then User validates the status as "check ic+" and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_one |
    And User clicks delete prescription in patient order status
    Then System should display a message "IC+ prescription can only be deleted in IC+" under the prescription


  @RXQE-5909 @IkariWarriors  @Regression
  Scenario: SIT | Update stock when delete an new Rx after CE
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
      | TestData      | patient   | Row_CE_One |
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And clicks intake Rx
    Then System should navigate to Intake Method Screen
    And clicks Finish button in intake method screen
    When User navigates to patient order status
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_One|
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_One |
    And User clicks search button on patient order status
    Then The pending link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_One |
    Then System displays a donut chart
    When User clicks perform data entry hyperlink
    Then Sytem should display data entry page
     When User enters prescriber first name and Last name
      | InputFileName | SheetName  | RowId   |
      | TestData      | prescriber | Row_one |
    And User selects null value in the state dropdown
    And clicks search button on prescriber search
    And clicks select to select a prescriber
    #And selects a prescriber from DE
    And checks for available product in onshelf in Stock data base
    And get the product name from database
    #And clicks open product button
    And enters product information from db
      | InputFileName | SheetName | RowId   |
      | TestData      | product   | Row_DR_fourteen |
    And clicks open payment button
    And selects payment type
    And clicks Finish button to complete Data Entry
    And System should display patient order status page
    And check the soft allocation for DE in stock plus
    And User enters patient last name in POS last name text box
      | InputFileName | SheetName | RowId   |
      | TestData		  | patient   | Row_CE_One |
    And User enters patient phone number in POS phone number text box
      | InputFileName | SheetName | RowId   |
      | TestData		  | patient   | Row_CE_One |
    And User clicks search button on patient order status
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData		  | patient   | Row_CE_One |
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
      | TestData		  | patient   | Row_CE_One |
    And The In progress link for current prescription should be clicked
      | InputFileName | SheetName | RowId   |
      | TestData		  | patient   | Row_CE_One |
    Then System displays a donut chart
    When User clicks perform clinical evaluation hyperlink
    And clicks select all for therapy review
    And user clicks on Override in CE screen
    Then System should display patient order status page
    And User clicks search button on patient order status
    And User validates the status as Reviewed and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_One |
      | TestData       |   product     |     Row_DR_fourteen     |
    And User clicks delete prescription in patient order status
    And clicks delete rx button on the alert message
    #And User clicks search button on patient order status
    #And User validates the status as "Reviewed" and selects the current prescription
      #| InputFileName | SheetName | RowId   |
      #| TestData      | patient   | Row_CE_One |
      #| TestData       |   product    |   Row_DR_fourteen    |
    #When User clicks on Delete Rx button
    #Then validates the popup
    #And clicks on Delete RX
   And check the soft allocation after delete rx in stock plus

  @RXQE-5519 @IkariWarriors  @Regression
  Scenario: SIT | RXMS | Delete image after CE from POS
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
      | TestData      | product   | Row_one |
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
    And User validates the status as Reviewed and selects the current prescription
      | InputFileName | SheetName | RowId   |
      | TestData      | patient   | Row_CE_Two |
      | TestData       |   product     |     Row_one     |
    And User clicks delete prescription in patient order status
    And clicks delete rx button on the alert message
    Then The prescription should be deleted

  @RXQE-7566 @Joust  
  Scenario: SIT | View Failure Preview | Task activity | Failure Preview Selection | CE Task
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
    And the user clicks on the notification alert icon
    Then the system opens the failure preview
    When clicks on See All button
    And the system closes the failure preview
    And the system brings the user to the failure queue overlay
    And the focus is on first failure in the queue
    When the user clicks on the X button of the Failure Preview Overlay
    Then the Failure Preview Overlay is closed
    And the Clinical Evaluation screen user is viewing still remains open
    When the user clicks on the notification alert icon
    Then the system opens the failure preview
    When user clicks or selects Enter on a failure in the failure preview
    And the system closes the failure preview
    And the system brings the user to the failure queue overlay
    And the focus is on user selected failure
    When the user clicks on the X button of the Failure Preview Overlay
    Then the Failure Preview Overlay is closed
    And the Clinical Evaluation screen user is viewing still remains open
