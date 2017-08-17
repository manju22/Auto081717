@accessManagement @Regressiontest	

Feature: Role Management test cases

@RXAPPD-12055 @Regression @AccessMgmtOnly
  Scenario: Verify that the user can access to the list of Team Members and see the phone numbers
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData  		| login     | Row_PH 	|
    And User clicks login button
    When I click on pharmacist profile button
    Then I should be able to see team members option and click
    Then I should navigate to list of team members profile
    Then I click on team member profile and able to see Phone Number

  @RXAPPD-12058 @Regression @AccessMgmtOnly
  Scenario: Verify that the system doesnt show any Team Member in the Team Member List
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   	|
      | TestData   		| login     | Row_TECH 	|
    And User clicks login button
    Then I will be navigate to user profile
    Then I should not be able to see team members option
    Then I navigate to home button

  @RXAPPD-12054 @Regression @AccessMgmtOnly
  Scenario: Verify that the system allow to update some personal information
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   	|
      | TestData   		| login     | Row_TECH 	|
    And User clicks login button
    #Then I navigate back to home screen
    When I click on pharmacist profile button
    Then I click on update button it navigate to employee information update

  @RXAPPD-12052 @Regression @AccessMgmtOnly
  Scenario: Verify that the user cannot access the list of Team Members -FAILURE
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   	|
      | TestData   		| login     | Row_TECH 	|
    And User clicks login button
    #Then I navigate back to home screen
    When user click on task board it will expand
    When I click on pharmacist profile button
    Then I should not be able to see team members option
    Then I navigate to home button
    
    @RXUAT-264 @UAT @Regression @AccessMgmtOnly
  Scenario: View patient details
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData   		| login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName  | RowId   		|
      | TestData 			| patient		 | Row_AM_One |
    And clicks search button on patient search page
    Then System should display patient search results
     When User clicks view button
    #When User clicks log out button in left side navigation menu
    And I click on logout button
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId   |
      | TestData 			| login     | Row_PH 	|
    And User clicks login button
    Then System should display RxMS home page
    When User clicks on patient tab in left side menu
    Then System should navigate to patient search page
    When User enters patient First Name and Last Name
      | InputFileName | SheetName   | RowId   		|
      | TestData 			| patient 		| Row_AM_Two 	|
    And clicks search button on patient search page
    When User clicks view button
    And go back to the patient search
    When User enters patient First Name and Last Name
      | InputFileName | SheetName   | RowId   			|
      | TestData 			| patient 		| Row_AM_Three 	|
    And clicks search button on patient search page
    Then System should display patient search results
    When User clicks view button
    And click on third party link
    And Verify all the details
    And Click on Relation to plan Cardholder
    And Click on view comments
    And Click on Hide Comments
    And User closes the application
    
    
  
@RXAPPD-11733 @Fiat_Appdev @Regression @AccessMgmtOnly
  Scenario: UI - Verify that when the user logged the system does not display Team Member menu
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData   		| login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    And I should see navigation panel is expanded
    And I should not see Team Member Menu
    
     @RXAPPD-11881 @task_board @Fiat_Appdev @Regression @AccessMgmtOnly
  Scenario: UI View Task Board-Verify the tasks enabled
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData   		| login     | Row_PH |
    And User clicks login button
    When I click on any "enabled" task
    Then System should display the specific task enabled
    And I logout of RxMS
    And I close the application

  @RXAPPD-11886 @Fiat_Appdev @Regression @AccessMgmtOnly
  Scenario: Prescription fulfillment
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData  		| login     | Row_PH |
    And User clicks login button
    Then System should display RxMS home page
    When user click on refresh button on task board
    Then System task board refresh and update with current count

  @RXAPPD-12051 @Regression @AccessMgmtOnly
  Scenario: Verify that the system show the My Team Member profile
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData  		| login     | Row_PH |
    And User clicks login button
    Then I will be navigate to user profile
    Then User validating team member profile
    
     @RXAPPD-10839 @Regression @AccessMgmtOnly
  Scenario: To verify that it is possible to view all Role associated to my Team Member profile with Scroll
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData  		| login     | Row_PH |
    And User clicks login button
    Then I will be navigate to user profile
    Then User validating the team member role

  @RXQE-1640 @E2E @Regression @AccessMgmtOnly
  Scenario: Users should be able to successfully login and logout from UI application
    Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData  		| login     | Row_PH |
    And User clicks login button
    When User click cancel button while performing logout operation
    When User click ThisDevice button and validate while performing logout operation
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData  		| login     | Row_PH |
    And User clicks login button
    When User click AllDevice button and validate while performing logout operation

  # @RXAPPD-10687
  @RXAPPD-10686 @Regression @AccessMgmtOnly
  Scenario: Verify that the system displays the Navigation Panel with all features and buttons and respects tab order
   Given User launches the RxMS desktop application
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData  		| login     | Row_PH |
    And I click on login buton
    Then User verify RxMs home screen elements
    Then User navigate the tabs in RxMs home screen

@RXQE-2972 @P1 @Regression @AccessMgmtOnly
  Scenario: E2E | Access Management | Users should be able to successfully login and logout from UI application
    Given User launches the RxMS desktop application
     When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData  		| login     | Row_PH |
    And User clicks login button
    And User click on only logout button
    Then Pop-up should display with message information the user to Logout with "All device", "This Device"  and Cancel option
    When User click cancel button
    And User click ThisDevice button and validate while performing logout operation
    When User enters the valid credentials in login text fields
      | InputFileName | SheetName | RowId  |
      | TestData  		| login     | Row_PH |
    And User clicks login button

#TO BE EXECUTED ONCE WE GET NONE PERMISSION CREDENTIALS
#@RXUAT-18 @UAT
#@Grandprix_UAT
#Scenario: Role Management - Prescriber
    #Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId  |
      #| TestData  		| login     | Row_NONE |
    #And User clicks login button
    #Then System should display RxMS home page
    #And I should not be able to see prescriber menu in the left nav
    #And I click on logout button
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId  |
      #| TestData  		| login     | Row_PH |
    #And User clicks login button
    #Then System should display RxMS home page
    #And I should be able to see prescriber menu in the left nav
    #When User hits ctrl plus r hot key
    #Then System should display prescriber search page
    #When user enters details of prescriber
      #| InputFileName | SheetName  | RowId  |
      #| TestData  | prescriber | Row_AM_One |
    #And click hot key to search
    #Then prescriber details should be displayed successfully
    #When User hits Alt plus U hotkey
    #Then I should get "This function cannot be completed in this system.  Please complete in IC+."
    #When User hits Alt plus A hotkey
    #Then I should get "This function cannot be completed in this system.  Please complete in IC+."
    #When User hits Alt plus V hotkey
    #Then prescriber details page should be displayed successfully
    #Then I should not see plus minus button for DEA
#		Then I should not see plus minus button for State Or Ctrl License
#		#Need STEP DEF for BELOW STEPS
    #And I should not see "Add Location" button
    #And I should not see "Update Location" button


#TO BE EXECUTED ONCE WE GET NONE PERMISSION CREDENTIALS
#@RXUAT-14 @UAT
#@Grandprix_UAT
#Scenario: Role Management - Team Member
    #Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_NONE |
    #And User clicks login button
    #Then System should display RxMS home page
    #When I will click on My profile
    #Then I will be navigate to user profile
    #And I should be able to see Update button in Employee Information
    #And I should be able to see Update button in Licenses Certification
    #When I click on team member tab
    #Then I able to see list of team members
    #And I should not be able to click the team members
    #And I should not see phone numbers
    #And I click on logout button
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_PH |
    #And User clicks login button
    #Then System should display RxMS home page
    #When I will click on My profile
    #Then I will be navigate to user profile
    #When I click on team member tab
    #Then I able to see list of team members
    #And I should be able to click the team members
    #And I should see phone numbers
    #Then I click on other profile from team members list and navigate to see his profile
      #| InputFileName | SheetName | RowId    |
      #| TestData  | login     | Row_NONE1 |
    #And I should not see the update option in that page
    #And I should not see deactivate or active button
    #And I click on logout button
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_STORELEADER |
    #And User clicks login button
    #Then System should display RxMS home page
    #When I will click on My profile
    #Then I will be navigate to user profile
    #When I click on team member tab
    #Then I able to see list of team members
    #Then I click on other profile from team members list and navigate to see his profile
      #| InputFileName | SheetName | RowId    |
      #| TestData  | login     | Row_PH |
    #And I should be able to see roles assigned to the team member
    #And I should see scroll bar if role count is more 

#TO BE EXECUTED ONCE WE GET NONE PERMISSION CREDENTIALS
#@RXUAT-12 @UAT
#@Grandprix_UAT
#Scenario: Role Management - Manage Role Access
    #Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_NONE |
    #And User clicks login button
    #Then System should display RxMS home page
    #When I click on "Admin Button" from left side menu
    #Then I should not see "Role Management" navigation link
    #Then I should see "User Management" navigation link
    #And I click on logout button
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_ADMINRO |
    #And User clicks login button
    #Then System should display RxMS home page
    #When I click on "Admin Button" from left side menu
    #Then I should see "Role Management" navigation link
    #When I click on "Role Management" from left side menu
    #Then I should not see following fields:
      #| Add       |
      #| Update   	|
      #| Delete		|
    #And I click on logout button
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_CRU |
    #And User clicks login button
    #Then System should display RxMS home page 
    #When I click on "Admin Button" from left side menu
    #Then I should see "Role Management" navigation link
    #When I click on "Role Management" from left side menu
    #Then I should see "Delete" button
    #When User hits Alt plus "" hotkey
    #Then I should not see any functionality
    #And I click on logout button
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_ADMIN |
    #And User clicks login button
    #Then System should display RxMS home page 
    #When I click on "Admin Button" from left side menu
    #Then I should see "Role Management" navigation link
    #When I click on "Role Management" from left side menu    
    #Then I should see following fields:
      #| Add       |
      #| Update   	|
      #| Delete		|        

#TO BE EXECUTED ONCE WE GET ADD, EDIT FUNCTIONALITY      
#@RXUAT-13 @UAT
#@Grandprix_UAT
#Scenario: Role Management - Role List
    #Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   	|
      #| TestData  | login     | Row_ADMIN 	|
    #And User clicks login button
    #Then System should display RxMS home page
    #When I click on "Admin Button" from left side menu
    #Then I should see "Role Management" navigation link
    #When I click on "Role Management" from left side menu
    #Then I should be on "Role Management" screen
    #Then I should see Roles listed in ascending order
    #When I click the "Add" Button
#		Then I should see "Save" Button
#		And I should see the "Cancel" Button
#		When I click the "Cancel" Button
#		Then I should be on "Role Management" screen
#		Then I enter role name on role field
#				| InputFileName | SheetName | RowId  			|
#		  	| TestData 			| Roles 		| Row_AM_one 	|
#		And I select one item from Role type
#		And I select few permissions and click move to right
#		When I click the "Save" Button
#		Then I should see the new role on Role Management screen
#				| InputFileName | SheetName | RowId  			|
#		  	| TestData 			| Roles 		| Row_AM_one 	|
#		And I select the new role
#				| InputFileName | SheetName | RowId  			|
#		  	| TestData 			| Roles 		| Row_AM_one 	|
#		When I click the "Update" Button
#		Then I should see role name on update screen
#				| InputFileName | SheetName | RowId  			|
#		  	| TestData 			| Roles 		| Row_AM_one 	|
#		When I click the "Cancel" Button
#		Then I should be on "Role Management" screen
#		And I select the new role
#				| InputFileName | SheetName | RowId  			|
#		  	| TestData 			| Roles 		| Row_AM_one 	|
#		When I click the "Delete" Button
#		Then I should see confirmation text on overlay
#		When I click the "No" Button
#		Then I should be on "Role Management" screen
#		When I enter a keyword in search field
#				| InputFileName | SheetName     | RowId  			|
  #			| TestData 			| Roles 				| Row_AM_Two 	|
#		Then I should see results based on the keyword 
#				| InputFileName | SheetName     | RowId  			|
  #			| TestData 			| Roles 				| Row_AM_Two 	|
  #	When I click on Role Description column
  #	Then I should see role descriptions listed in ascending order
  #	When I click on Role Name column
  #	Then I should see role names listed in ascending order
  #	When User hits Alt plus A hotkey
  #	Then I should see "Save" Button
  #	Then I click the "Cancel" Button
  #	When User hits Alt plus U hotkey
  #	Then I should see "Save" Button
  #	When I click the "Cancel" Button
  #	When User hits Alt plus D hotkey
  #	Then I should see confirmation text on overlay
#		Then I click the "No" Button		
#		When I click TAB key 
    #Then I should be on "search" field
    #When I click TAB key from "search" field
    #Then I should be on "Add" field
    #When I click TAB key from "Add" field
    #Then I should be on "Update" field
    #When I click TAB key from "Update" field
    #Then I should be on "Delete" field

#TO BE EXECUTED ONCE WE GET NONE PERMISSION CREDENTIALS
#@RXUAT-23 @UAT
#@Grandprix_UAT
#Scenario: Role Management - Plan
    #Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   	|
      #| TestData  | login     | Row_NONE 	|
    #And User clicks login button
    #Then System should display RxMS home page
#		Then I should not see Plan link in the left navigation
#		When User hits ctrt plus l hot key
#		Then I should not see Plan search page		
#		And I click on logout button
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   |
      #| TestData  | login     | Row_PH |
    #And User clicks login button
    #Then System should display RxMS home page
    #Then I should see Plan link in the left navigation
    		      

#TO BE EXECUTED ONCE WE GET NONE PERMISSION CREDENTIALS    		      
#@RXUAT-24 @UAT
#@Grandprix_UAT
#Scenario: Create Role - Access Management
    #Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   		|
      #| TestData  | login     | Row_ADMIN 	|
    #And User clicks login button
    #Then System should display RxMS home page
    #When I click on "Admin Button" from left side menu
    #Then I should see "Role Management" navigation link
    #When I click on "Role Management" from left side menu
    #Then I should be on "Role Management" screen
    #When I click the "Add" Button
#		Then I should see following fields:
      #| Role Name       					|
      #| Role Description   				|
      #| Role Type									|
      #| Named User Only						|
      #| Filter by system area			|
      #| Non available permissions	|
      #| Available permissions			|
    #And "Role Name" field should be empty
    #And "Role Description" field should be empty
    #And "Role Type" field should be empty
    #And "Available permissions" field should be empty
    #And "Named user only" should be disabled
    #When I click the "Add" Button
#		Then I enter role name on role field
#			| InputFileName   | SheetName     | RowId  				|
#		  | TestData | Roles 				| Row_AM_One 	| 
#		  #ADD DATA with existing ROLE NAME
#		And I select one item from Role type
#		And I select few permissions and click move to right
#		When I click the "Save" Button
    #Then I should see "This role name already exists. Update role name" message
    #When I click the "Cancel" Button
#		Then I should be on "Role Management" screen
#		When I click the "Add" Button
#		Then I enter role name on role field
#			| InputFileName   | SheetName     | RowId  					|
#		  | role_management | Roles 				| Row_incomplete 	| 
#		  # ADD DATA for INCOMPLETE role
#		When I click the "Save" Button
    #Then I should see "Fill mandatory field" message 
    #Check ERROR MESSAGE
#		When I select one item from Role type
#		And I select few permissions from "Not available permissions" field 
#		And I should see move to "left" button is disabled
#		When I click move to right
#		Then I should see permissions in Available permissions field
#		When I select few permissions from "Available permissions" field
    #Then I should see move to "right" button is disabled
    #When I click move to right
    #Then I should not see permissions in Available permissions field
    #When I search for a permission in "Not available permissions" field
#				| InputFileName | SheetName     | RowId  			|
  #			| TestData 			| Roles 				| Row_AM_Two 	|
    #Then I should see results in counter field
#				| InputFileName | SheetName     | RowId  			|
  #			| TestData 			| Roles 				| Row_AM_Two 	|
    #When I click the "Cancel" Button
#		Then I should be on "Role Management" screen
#		When I click the "Add" Button
#		Then I enter role name on role field
#				| InputFileName | SheetName     | RowId  			|
  #			| TestData 			| Roles 				| Row_AM_Three 	| 
#		  #ADD TEST DATA WITH NEW ROLE
#		And I select one item from Role type
#		And I select few permissions and click move to right
#		When I click the "Save" Button
    #Then I should see the new role on Role Management screen
#				| InputFileName | SheetName     | RowId  			|
  #			| TestData 			| Roles 				| Row_AM_Three 	|
  #	When I click the "Add" Button
#		Then I enter role name on role field
#				| InputFileName | SheetName     | RowId  			|
  #			| TestData 			| Roles 				| Row_AM_Three 	| 
#		  #ADD TEST DATA WITH NEW ROLE
#		When I click the "Save" Button
    #Then I should see "Fill all mandatory fields" message 
    #CHECK ERROR MESSAGE AND CHANGE ACCORDINGLY
    #When I click the "Cancel" Button
#		Then I should be on "Role Management" screen
    #When I click the "Add" Button
#		Then I enter role name on role field
#				| InputFileName | SheetName     | RowId  				|
  #			| TestData 			| Roles 				| Row_AM_Four 	| 
#		  #ADD TEST DATA WITH NEW ROLE
#		And I select "Named User Only" check box
#		And I select one item from Role type
#		And I select few permissions and click move to right
#		When I click the "Save" Button
#		Then I should see the new role on Role Management screen
#				| InputFileName | SheetName     | RowId  			|
  #			| TestData 			| Roles 				| Row_AM_Three 	|
  #	When I click the "Add" Button
  #	Then I select one item from Role type
  #	Then I should see permissions listed in counter
  #	And I click on logout button    		      
  	
#TO BE EXECUTED ONCE WE GET NONE PERMISSION CREDENTIALS    		      
#@RXUAT-9 @UAT
#@Grandprix_UAT
#Scenario: Role Management - Location
    #Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   		|
      #| TestData  | login     | Row_NONE	 	|
    #And User clicks login button
    #Then System should display RxMS home page
  #	And I should not see "Pharmacy Location" information
  #	And I should see useful links 
  #	And I click on logout button
  #	When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   		|
      #| TestData  | login     | Row_ADMINRO |
    #And User clicks login button
    #Then System should display RxMS home page
    #When I click on "Store #" from Pharmacy Information
    #Then I should see "Store Information" page
    #Then I should not see update button
    #And I click on logout button
  #	When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   		|
      #| TestData  | login     | Row_PH |
    #And User clicks login button
    #Then System should display RxMS home page
    #When I click on "Store #" from Pharmacy Information
    #Then I should see "Store Information" page
    #When I click on Update button
    #Then I am able see following fields:
    #	| Valid From     |
      #| Valid To       |
    #When I click cancel button
    #Then I should see "Store Information" page
    #And I click on logout button
  #	When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   	|
      #| TestData  | login     | Row_NONE1 |
    #And User clicks login button
    #Then System should display RxMS home page
    #When I click on "Store #" from Pharmacy Information
    #Then I should see "Store Information" page
    #And I should not see "Pharmacy Information" section
    #And I should not see "Pharmacy Inventory Information" section
    #And I should not see "Pharmacy Hours" section
    #And I should not see "Store Hours" section  	


#TO BE EXECUTED ONCE WE GET NONE PERMISSION CREDENTIALS    		      
#@RXUAT-26 @UAT
#@Grandprix_UAT
#Scenario: Role Management - Location
    #Given User launches the RxMS desktop application
    #When User enters the valid credentials in login text fields
      #| InputFileName | SheetName | RowId   		|
      #| TestData  | login     | Row_NONE	 	|
    #And User clicks login button
    #Then System should display RxMS home page
    #When I click on "Admin Button" from left side menu
    #Then I should see "Role Management" navigation link
    #When I click on "Role Management" from left side menu
    #Then I should be on "Role Management" screen
    #Then I should see Roles listed in ascending order
    #And I select the new role
#				| InputFileName | SheetName     | RowId  			|
  #			| TestData 			| Roles 				| Row_AM_One 	|
#		When I click the "Update" Button
#		Then I should see role name on update screen
#				| InputFileName | SheetName     | RowId  			|
  #			| TestData 			| Roles 				| Row_AM_One 	|
    #And I should see permissions in available permissions field
    #And I should see permissions in not available permissions field
    #When I click TAB key 
    #Then I should be on "Role Name" field
    #When I click TAB key from "Role Name" field
    #Then I should be on "Role Description" field
    #When I click TAB key from "Role Description" field
    #Then I should be on "Named User Only" field
    #When I click TAB key from "Named User Only" field
    #Then I should be on "System area dropdown" field
    #When I select all permissions from "non available" and click move to "right"
    #Then I should see all permissions in "Available permissions" field
    #When I select all permissions from "available" and click move to "left"
    #Then I should see all permissions in "non Available permissions" field
    #And I select few permissions from "Not available permissions" field 
#		When I click move to right
#		Then I should see permissions in Available permissions field
#		When I click the "Save" Button
#		Then I should see the changes on Role Management screen
#				| InputFileName | SheetName     | RowId  			|
  #			| TestData 			| Roles 				| Row_AM_Two 	|
#		When I click the "Add" Button
#		Then I should see "Save" Button
#		And I should see the "Cancel" Button
#		When I click the "Cancel" Button
#		Then I should be on "Role Management" screen
#		When I click the "Delete" Button
#		Then I should see confirmation text on overlay
#		When I click the "No" Button
#		Then I should be on "Role Management" screen
#		When I click on Role Description column
  #	Then I should see role descriptions listed in ascending order
  #	When I click on Role Name column
  #	Then I should see role names listed in ascending order
  #	When I enter a keyword in search field
#				| InputFileName | SheetName     | RowId  			|
  #			| TestData 			| Roles 				| Row_AM_One 	|
#		Then I should see results based on the keyword 
#				| InputFileName | SheetName     | RowId  			|
  #			| TestData 			| Roles 				| Row_AM_One 	|
  			    