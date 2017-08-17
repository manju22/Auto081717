 @RM
Feature: role management test steps 
 
#@RXAPPD-12628 
#Scenario: Verify that the in Patient search results,Update and Add buttons 
#	 Given Pharmacy user launches the RxMS application
    #When Pharmacy user enters valid credentials
      #| InputFileName | SheetName | RowId   |
      #| smokeTestSIT  | login     | Row_one |
    #And clicks login button
    #Then System should display RxMS home page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| smokeTestSIT  | patient   | Row_one |
    #And clicks search button on patient search page
    #Then System should display patient search results
#	 Then User able to see hidden buttons AddNew and Update 
	 
	 
 @RXAPPD-11775 @RXAPPD-9137
  Scenario: Verify that the system displays the View Pharmacy Location panel
    Given I launch the browser
    And I login as a admin
      | InputFileName        | SheetName | RowId  |
      | maintainLocationData | Login     | Rowone |
    Then I see the landing page
    And I verify for pharmacy information
      | InputFileName        | SheetName            | RowId  |
      | maintainLocationData | Pharmacy_Information | RowOne |
      
      
      
  #@RXAPPD-15288
  #Scenario: Search for a Team Member with a wrong Employee ID - FAILURE
   #Given Pharmacy user launches the RxMS application
    #When Pharmacy user enters valid credentials
      #| InputFileName | SheetName | RowId   |
      #| smokeTestSIT  | login     | Row_one |
      #And clicks login button
    #When I click on "Admin Button" from left side menu
    #Then I should see "Role Management" navigation link
    #Then I should see "User Management" navigation link
    #Then I enter employeeID on user management feild and i will click on search
      #| InputFileName | SheetName | RowId  |
      #| ValidateData  | Role-Info | Rowsix |
    #Then User able to see error message No results found    
    
        #@RXAPPD-9804
  #Scenario: Navigation to Create Role screen
  #Given Pharmacy user launches the RxMS application
   #When Pharmacy user enters valid credentials
      #| InputFileName | SheetName | RowId   |
      #| smokeTestSIT  | login     | Row_one |
     #And clicks login button
    #When I click on "Admin Button" from left side menu
    #Then I should see "Role Management" navigation link
    #Then I should see "User Management" navigation link
    #When I click on "Role Management" from left side menu
    #Then I should see "Add" Button
    #And I should see the "Update" Button
    #And I should see the "Delete" Button
    #When I click the "Add" Button
    #When I click the View Button
    #Then user able to see following feilds
      #| Role Maintenance       |
      #| Permission Maintenance |
    
    @RXAPPD-12052
  Scenario: Verify that the user cannot access the list of Team Members -FAILURE
    Given Pharmacy user launches the RxMS application
    When Pharmacy user enters valid credentials
      | InputFileName | SheetName | RowId   |
      | roles_input   | Login     | RowFive |
    And clicks login button
    Then I navigate back to home screen
    When user click on task board it will expand
    When I click on pharmacist profile button
    Then I should not be able to see team members option
    Then I navigate to home button
    
      @RXAPPD-12054
  Scenario: Verify that the system allow to update some personal information
    Given Pharmacy user launches the RxMS application
    When Pharmacy user enters valid credentials
      | InputFileName | SheetName    | RowId  |
      | roles_input    | Login | RowFive |
     And clicks login button 
    Then I navigate back to home screen
    When I click on pharmacist profile button
    Then I click on update button it navigate to employee information update
    
    
    @RXAPPD-12058
  Scenario: Verify that the system doesnt show any Team Member in the Team Member List
   Given Pharmacy user launches the RxMS application
    When Pharmacy user enters valid credentials
      | InputFileName | SheetName    | RowId   |
      | roles_input   | Login | RowFive |
    And clicks login button 
    Then I will be navigate to user profile
    Then I should not be able to see team members option
    Then I navigate to home button  
    
    
    @RXAPPD-12055
  Scenario: Verify that the user can access to the list of Team Members and see the phone numbers
   Given Pharmacy user launches the RxMS application
    When Pharmacy user enters valid credentials
      | InputFileName | SheetName | RowId|
      | roles_input    | Login | Row_one |
    And clicks login button
    When I click on pharmacist profile button
    Then I should be able to see team members option and click
    Then I should navigate to list of team members profile
    Then I click on team member profile and able to see Phone Number
    
    
    #@RXAPPD-11770
  #Scenario: Verify that when the user has the Read and Update permissions for Location Pharmacy Hours, the Update button
    #Given I Logged in as Admin full access
    #Given I enter username and password
      #| InputFileName | SheetName    | RowId  |
      #| DrugSearch    | Logindetails | Rowone |
    #And I click on login buton
    #Then I click on store number
    #Then I am able to see store information window
      #| Pharmacy Information           |
      #| Pharmacy Inventory Information |
      #| License and ID                 |
      #| General Information            |
      #| Pharmacy Hours                 |
      #| Store Hours                    |
    #And user able to see store update button  
    

 

    
 
 

  #@RXAPPD-11768
  #Scenario: Verify that the system displays all Home Store Location according to the Read and Update permissions
    #Given I Logged in as Admin full access
    #Given I enter username and password
      #| InputFileName | SheetName    | RowId  |
      #| DrugSearch    | Logindetails | Rowthree  |
    #And I click on login buton
    #Then I will be navigate to user profile
    #Then I click on store number
    #Then I am able to see store information window
      #| Pharmacy Hours       |
      #| Store Information    |
      #| Pharmacy Information |
      #| Store Hours          |
     #Then user able to see update button
     
     
     #@RXAPPD-11767
  #Scenario: Verify that the system displays all Home Store Location according to the Read permissions associated to the Home Store Location Entity
    #Given I logged in as Admin read only acess
    #Given I enter username and password
      #| InputFileName | SheetName    | RowId   |
      #| DrugSearch    | Logindetails | Rowfive |
    #And I click on login buton
    #Then I will be navigate to user profile
    #Then I am able to see store information window
      #| Pharmacy Information           |
      #| Pharmacy Inventory Information |
      #| License and ID                 |
      #| General Information            |
      #| Pharmacy Hours                 |
      #| Store Hours                    |
    #Then I can view page i dont have access to edit or update


#@RXAPPD-11736
#@admin_tab
#@Fiat_Appdev
#Scenario: UI - Verify that the system brings the user to User Management screen
   #Given I Logged in as Admin full access
   #Given I enter username and password
      #| InputFileName | SheetName    | RowId  |
      #| roles_mgmt  | login		| SIT_PH44 	|
   #And I click on login buton
   #Then System should display RxMS home page
   #And I should see navigation panel is expanded
   #When I click on "Admin Button" from left side menu
   #Then I should see navigation panel is collapsed
   #Then I should see "User Management" navigation link
     #
#
#@RXAPPD-11735
#@admin_tab
#@Fiat_Appdev
#Scenario: UI - Verify that the system collapses the Navigation Panel
#	Given I Logged in as Admin full access
  #Given I enter username and password
    #| InputFileName | SheetName    | RowId  |
    #| roles_mgmt  | login		| SIT_PH44 	|
  #And I click on login buton
  #Then System should display RxMS home page
  #And I should see navigation panel is expanded
  #When I click on "Admin Button" from left side menu
  #Then I should see navigation panel is collapsed

@RXAPPD-11733
@Fiat_Appdev
Scenario: UI - Verify that when the user logged the system does not display Team Member menu
   Given I Logged in as Admin full access
    Given I enter username and password
      | InputFileName | SheetName    | RowId  |
      | roles_mgmt  | login		| SIT_PH44 	|
    And I click on login buton
    Then System should display RxMS home page
    And I should see navigation panel is expanded
    And I should not see Team Member Menu
    

#@admin_tab
#@RXAPPD-11732
#@Fiat_Appdev
#Scenario: UI - Verify that when the user logged the system displays Admin menu - focus on User Management
#	Given I Logged in as Admin full access
#	Given I enter username and password
#	  | InputFileName | SheetName    | RowId   |
#	  | roles_mgmt  | login		| SIT_PH44 	|
#	And I click on login buton
#	When user click on task board it will expand
#	When I click on "Admin Button" from left side menu
#	Then User Management by deafult it will be highlited
#
#@RoleManagement
#@RXAPPD-11734
#@admin_tab
#@Fiat_Appdev
#Scenario: Verify that when the user logged the system displays Role Management
  #Given I Logged in as Admin full access
  #Given I enter username and password
    #| InputFileName | SheetName    | RowId   |
    #| roles_mgmt  | login		| SIT_PH44 	|
  #And I click on login buton
  #When I click on "Admin Button" from left side menu
  #Then I should see "Role Management" navigation link
  #Then I should see "User Management" navigation link
  #Then User Management by deafult it will be highlited
  #When I click on "Role Management" from left side menu
  #Then user will be on role management Screen
#
#@Fiat_Appdev
#@RXAPPD-11737
#@admin_tab
#Scenario: UI - Verify that the system display two tabs: UserManagement and RoleManagement
  #Given I Logged in as Admin full access
  #Given I enter username and password
    #| InputFileName | SheetName    | RowId   |
    #| roles_mgmt  | login		| SIT_PH44 	|
  #And I click on login buton
  #Then System should display RxMS home page
  #And I should see navigation panel is expanded
  #When I click on "Admin Button" from left side menu
  #Then I should see navigation panel is collapsed
  #Then I should see "Role Management" navigation link
  #Then I should see "User Management" navigation link

#@Fiat_Appdev
#@RXAPPD-11738
#@admin_tab
#Scenario: UI - Verify that the system expands the Navigation Panel
  #Given I Logged in as Admin full access
  #Given I enter username and password
    #| InputFileName | SheetName    | RowId   |
    #| roles_mgmt  | login		| SIT_PH44 	|
  #And I click on login buton
  #When user click on navigation panel
  #Then I should see navigation panel is collapsed
  #When I click on "Admin Button" from left side menu
  #Then I should see "Role Management" navigation link
  #Then I should see "User Management" navigation link
#
#@Fiat_Appdev
#@admin_tab
#@RXAPPD-11739
#Scenario: Verify that the system brings the user to User Management screen
  #Given I Logged in as Admin full access
  #Given I enter username and password
    #| InputFileName | SheetName    | RowId   |
    #| roles_mgmt  | login		| SIT_PH44 	|
  #And I click on login buton
  #When user click on task board it will expand
  #When I click on "Admin Button" from left side menu
  #Then User Management by deafult it will be highlited
  #When I click on "Role Management" from left side menu
  #Then I should see "Add" Button
  #And I should see the "Update" Button
  #And I should see the "Delete" Button
#
#@RXAPPD-11740
#@admin_tab
#@Fiat_Appdev
#Scenario: UI - Verify that the system display two tabs: UserManagement and RoleManagement
  #Given I Logged in as Admin full access
  #Given I enter username and password
    #| InputFileName | SheetName    | RowId   |
    #| roles_mgmt  | login		| SIT_PH44 	|
  #And I click on login buton
  #When I click on the username
  #Then I should see navigation panel is collapsed
  #Then I click back to navigate to dashboard page
  #When I click on the initial
  #Then I should see navigation panel is collapsed
  #When I click on "Admin Button" from left side menu
  #Then I should see "Role Management" navigation link
  #Then I should see "User Management" navigation link

         
@RXAPPD-11881
@task_board
@Fiat_Appdev
Scenario: UI View Task Board-Verify the tasks enabled
  Given Login to the application as Admin user
    | InputFileName   | SheetName   | RowId    |
    | roles_mgmt  | login		| SIT_PH44 	|
  And clicks login button  
  When I click on any "enabled" task
  Then System should display the specific task enabled
  And I logout of RxMS
  And I close the application

@RXAPPD-11886
@Fiat_Appdev
Scenario: Prescription fulfillment
    Given Pharmacy user launches the RxMS application
    When Pharmacy user enters valid credentials
      | InputFileName | SheetName | RowId   	|
      | roles_mgmt  | login		| SIT_PH44 	|
    And clicks login button
    Then System should display RxMS home page
    When user click on refresh button on task board 
   	Then System task board refresh and update with current count
   	
   	
   	
   	 @RXAPPD-12051
  Scenario: Verify that the system show the My Team Member profile
	Given Pharmacy user launches the RxMS application
    When Pharmacy user enters valid credentials
      | InputFileName| SheetName  | RowId  |
      | roles_mgmt  | login		| SIT_PH44 	| 
    And clicks login button  
     Then I will be navigate to user profile
     Then User validating team member profile
   	
   	
  #RXAPPD-15284
  #RXAPPD-15265
 #@RXUAT-212 @UAT
  #Scenario: Validating reset password fields and Reset Password 
#	Given I Logged in as Admin full access
     #Given I enter username and password
      #| InputFileName| SheetName  | RowId  |
      #| roles_mgmt  | login		| SIT_PH44 	| 
     #And I click on login buton
     #When I click on "Admin Button" from left side menu
     #Then I should see "Role Management" navigation link
     #Then I should see "User Management" navigation link
     #Then User enter employeeID on user management feild and i will click on search
      #| InputFileName | SheetName | RowId    |EmpId    | 
      #| ValidateData  | Role-Info | Invalid  | Invalid | 
     #Then User enter employeeID on user management feild and i will click on search
      #| InputFileName | SheetName | RowId     |EmpId  | Click_X_Icon |
      #| ValidateData  | Role-Info | Rowthree  | Valid |      Yes     |
     #Then User enter employeeID on user management feild and i will click on search
      #| InputFileName | SheetName | RowId     |EmpId  | 
      #| ValidateData  | Role-Info | Rowthree  | Valid |
     #Then I am able to see password management
     #And I able to see Password Guidelines
     #Then User validating password fields and reset the password
      #| InputFileName | SheetName  | RowId  |Password | ConfirmPWD | PasswordValidation | PasswordType |
      #| ValidateData  | Reset_Pswd | Rowone |  Pass12 |  Pass12    |        Yes         |     LessChar |
     #Then User validating password fields and reset the password
      #| InputFileName | SheetName  | RowId  |Password     | ConfirmPWD   | PasswordValidation | PasswordType    |
      #| ValidateData  | Reset_Pswd | Rowone |  passwords1 |  passwords1  |        Yes         |  WithoutNumeric |
     #Then User validating password fields and reset the password
      #| InputFileName | SheetName  | RowId  |Password   | ConfirmPWD   | PasswordValidation | PasswordType     |
      #| ValidateData  | Reset_Pswd | Rowone | Pass1Word |  Pass2Word   |        Yes         | PasswordNotMatch |
     #Then User validating password fields and reset the password
      #| InputFileName | SheetName  | RowId  |Password   | ConfirmPWD   | Cancel_Password_Reset |
      #| ValidateData  | Reset_Pswd | Rowone | Pass1Word |  Pass1Word   |       Yes             |
     #Then User validating password fields and reset the password
      #| InputFileName | SheetName  | RowId  |Password   | ConfirmPWD   | 
      #| ValidateData  | Reset_Pswd | Rowone | Pass1Word |  Pass1Word   | 
      #
      #
      #
   #@RXQE-3952 @E2E     
  #Scenario: Reset Password for the User using Hot Keys
#	Given I Logged in as Admin full access
     #Given I enter username and password
      #| InputFileName| SheetName  | RowId  |
      #| roles_mgmt  | login		| SIT_PH44 	|
     #And I click on login buton
     #When I click on "Admin Button" from left side menu
     #Then I should see "Role Management" navigation link
     #Then I should see "User Management" navigation link   
     #Then User enter employeeID on user management feild and i will click on search
      #| InputFileName | SheetName | RowId     |EmpId    | Alt+S |
      #| ValidateData  | Role-Info | Rowthree  | Valid   |  Yes  |  
     #Then User validating password fields and reset the password
      #| InputFileName | SheetName  | RowId  |Password   | ConfirmPWD   | Alt+R | 
      #| ValidateData  | Reset_Pswd | Rowone | Pass1Word |  Pass1Word   |   Yes |
      #
      #
      #
       #@RXAPPD-11648
  #Scenario:  Verify that the system doesnt allow the user to save the incorrectly password - Failure
#	Given I Logged in as Admin full access
     #Given I enter username and password
      #| InputFileName| SheetName  | RowId  |
      #| roles_mgmt  | login		| SIT_PH44 	|
     #And I click on login buton
     #When I click on "Admin Button" from left side menu
     #Then I should see "Role Management" navigation link
     #Then I should see "User Management" navigation link
     #Then User enter employeeID on user management feild and i will click on search
      #| InputFileName | SheetName | RowId     |EmpId  | 
      #| ValidateData  | Role-Info | Rowthree  | Valid |
     #When User enter the without lower upper numeric values in paasword field and validate
      #| InputFileName | SheetName  | RowId  |Password | ConfirmPWD | PasswordValidation | PasswordType |
      #| ValidateData  | Reset_Pswd | Rowone | AAAAAAA1|AAAAAAA1    |        Yes         |   InvalidPWD |
     #When User enter the without lower upper numeric values in paasword field and validate
      #| InputFileName | SheetName  | RowId  |Password | ConfirmPWD | PasswordValidation | PasswordType |
      #| ValidateData  | Reset_Pswd | Rowone | aaaaaaa2| aaaaaaa2   |        Yes         |   InvalidPWD |
     #When User enter the without lower upper numeric values in paasword field and validate
      #| InputFileName | SheetName  | RowId  |Password | ConfirmPWD | PasswordValidation | PasswordType |
      #| ValidateData  | Reset_Pswd | Rowone | Aaaaaaaaa| Aaaaaaaaa   |        Yes         |   InvalidPWD |
     #When User enter the without lower upper numeric values in paasword field and validate
      #| InputFileName | SheetName  | RowId  |Password | ConfirmPWD | PasswordValidation | PasswordType |
      #| ValidateData  | Reset_Pswd | Rowone | 88888333| 88888333   |        Yes         |   InvalidPWD |
      #
      #
      #
       #@RXAPPD-15289
  #Scenario: Reset the Password for a Team Member
#	Given I Logged in as Admin full access
     #Given I enter username and password
      #| InputFileName | SheetName  | RowId  |
     #| roles_mgmt  | login		| SIT_PH44 	|
     #And I click on login buton
     #When I click on "Admin Button" from left side menu
     #Then User enter employeeID on user management feild and i will click on search
      #| InputFileName | SheetName | RowId     |EmpId  | 
      #| ValidateData  | Role-Info | Rowthree  | Valid |
     #Then User validating password fields and reset the password
      #| InputFileName | SheetName  | RowId  |  Password  | ConfirmPWD | Alt+R |
      #| ValidateData  | Reset_Pswd | Rowone |  Changeme1 |  Changeme1 |  Yes  |
      #
      #
      
      
       @RXAPPD-10839
  Scenario: To verify that it is possible to view all Role associated to my Team Member profile with Scroll
	Given Pharmacy user launches the RxMS application
    When Pharmacy user enters valid credentials
      | InputFileName| SheetName  | RowId  |
      | roles_mgmt  | login		| SIT_PH44 	|
     And clicks login button 
     Then I will be navigate to user profile 
     Then User validating the team member role
     
     
 
 @RXQE-1640 @E2E
  Scenario: Users should be able to successfully login and logout from UI application
	Given Pharmacy user launches the RxMS application
    When Pharmacy user enters valid credentials
      | InputFileName| SheetName  | RowId  |
     | roles_mgmt  | login		| SIT_PH44 	|
   And clicks login button  
     When User click cancel button while performing logout operation
     When User click ThisDevice button and validate while performing logout operation
     When Pharmacy user enters valid credentials
      | InputFileName  | SheetName  | RowId  |
      | roles_mgmt  | login		| SIT_PH44 	| 
      And clicks login button
     When User click AllDevice button and validate while performing logout operation
     
     
     
     # @RXAPPD-10687 
   @RXAPPD-10686 
   Scenario:  Verify that the system displays the Navigation Panel with all features and buttons and respects tab order
     Given I Logged in as Admin full access
       Given I enter username and password
        | InputFileName | SheetName  | RowId  |
      | roles_mgmt  | login		| SIT_PH44 	|
       And I click on login buton  
       Then User verify RxMs home screen elements
       Then User navigate the tabs in RxMs home screen
     
     
     
#@RXAPPD-10799
#@Fiat_Appdev
#@prescriber_search
#Scenario: Verify that the system does not display Update Location button and Add Location button for a user with only Read permission for Prescriber Locations    
    #Given I Logged in as Admin full access
    #Given I enter username and password
      #| InputFileName | SheetName    | RowId  |
      #| roles_mgmt  | login		| SIT_PH44 	|
    #And I click on login buton
    #When I click on "Admin Button" from left side menu
    #Then I should see "Role Management" navigation link
    #When I click on "Role Management" from left side menu
    #Then I should be on "Role Management" screen
#		And I select the Technician role
#		When I click the "Update" Button
#		And I select role from role information
       #| InputFileName | SheetName | RowId   |
      #| ValidateData  | Roles     | Row_seven |
#		And I select Prescriber from Role type
#		And I select following permissions and click move to left
#		| UPDATE Prescriber Entity |
#		| Create Prescriber Locations |
#		When I click the "Save" Button
#		Then I should be on "Role Management" screen
#		#When I click the "Admin Back" Button
#		#When I click on "Admin Button" from left side menu
    #And I click on logout button
   #Given I Logged in as Admin full access
    #Given I enter username and password
      #| InputFileName 	| SheetName   | RowId  		|
      #| TaskMaintenance | login_RO  	| PERF_ENV 	|
    #And I click on login buton
    #When I click on "Prescriber Search Button" from left side menu
    #Then I should be on "Prescriber Search" screen
    #Then I enter prescriber name on search field 
#		| InputFileName     | SheetName     	| RowId    	|
#		| Prescriber_Input 	| prescriberinfo 	| PERF_ENV	|
#		And I click on Search button 
#		Then System should display patient search results
#		And I click on view button 
#		Then I am able to see Prescriber Profile Page 
#	  Then I should not see "Update Location" button
#	  Then I should not see "Add Location" button  
#	  
#	  
#@RXAPPD-10798
#@Fiat_Appdev
#@prescriber_search_update
#Scenario: Verify that it is not possible to display Plus and Minus buttons for DEA, State or Ctrl License    
    #Given I Logged in as Admin full access
    #Given I enter username and password
      #| InputFileName | SheetName    | RowId  |
      #| DrugSearch    | Logindetails | Rownine |
    #And I click on login buton
    #When I click on "Admin Button" from left side menu
    #Then I should see "Role Management" navigation link
    #When I click on "Role Management" from left side menu
    #Then I should be on "Role Management" screen
#		And I select the Technician role
#		When I click the "Update" Button
#		And I select role from role information
       #| InputFileName | SheetName | RowId   |
      #| ValidateData  | Roles     | Row_seven |
#		And I select Prescriber from Role type
#		And I select following permissions and click move to left
#		| UPDATE Prescriber Entity |
#		| Create Prescriber Locations |
#		When I click the "Save" Button
#		Then I should be on "Role Management" screen
#		#When I click the "Admin Back" Button
#		#When I click on "Admin Button" from left side menu
    #And I click on logout button
   #Given I Logged in as Admin full access
    #Given I enter username and password
      #| InputFileName 	| SheetName   | RowId  		|
      #| TaskMaintenance | login_RO  	| PERF_ENV 	|
    #And I click on login buton
    #When I click on "Prescriber Search Button" from left side menu
    #Then I should be on "Prescriber Search" screen
    #Then I enter prescriber name on search field 
#		| InputFileName     | SheetName     	| RowId    	|
#		| Prescriber_Input 	| prescriberinfo 	| PERF_ENV	|
#		And I click on Search button 
#		Then System should display patient search results
#		And I click on view button 
#		Then I am able to see Prescriber Profile Page 
#	  #Then I should not see plus minus button for DEA
#	  #Then I should not see plus minus button for State Or Ctrl License
     #
#
#@RXQE-2986 @E2E
#@role
#Scenario: E2E | Access Management | Role Management | Verify if Retail Pharmacy Manager can perform intake, DE and DR
    #Given Pharmacy user launches the RxMS application
    #Given I enter username and password
      #| InputFileName 	| SheetName  | RowId  		|
      #| Role_Managemnt  | login			 | PHARMACIST |
    #And clicks login button
    #When I click on "Store #" from Pharmacy Information
    #Then I should see "Store Information" page
    #And I "should not" see "Update" button
    #When I click on "Admin Button" from left side menu
#		Then I should see "Role Management" navigation link
#		Then I should not see following fields:
      #| Add       |
      #| Update   	|
      #| Delete		|
    #And I select the Technician role
#		When I click the "View" Button
#		Then I should not see "Save" button
#		When I click on the username
#		Then I should be able to see team members option and click
#		Then I should navigate to list of team members profile
    #Then I click on self profile from team members list and navigate to see his profile
      #| InputFileName | SheetName | RowId  |
      #| roles_input   | Login     | RowTwo |
    #And I should not see the update option in that page
    #Then I click on other profile from team members list and navigate to see his profile
      #| InputFileName | SheetName | RowId    |
      #| roles_input   | Login     | RowThree |
    #And I should not see the update option in that page
    #When User clicks on patient tab in left side menu
    #Then System should navigate to patient search page
    #When User enters patient First Name and Last Name
      #| InputFileName | SheetName | RowId   |
      #| smokeTestSIT  | patient   | Row_Five |
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
      #| smokeTestSIT  | patient   | Row_one |
    #And User enters patient phone number in POS phone number text box
      #| InputFileName | SheetName | RowId   |
      #| smokeTestSIT  | patient   | Row_one |
    #And User clicks search button on patient order status
    #Then The pending link for current prescription should be clicked
      #| InputFileName | SheetName | RowId   |
      #| smokeTestSIT  | patient   | Row_one |
    #Then System displays a donut chart
    #When User clicks perform data entry hyperlink
    #Then Sytem should display data entry page
    #When User enters prescriber first name and Last name
      #| InputFileName | SheetName  | RowId   |
      #| smokeTestSIT  | prescriber | Row_one |
    #And clicks search button on prescriber search
    #And clicks select to select a prescriber
    #And clicks open product button
    #And enters product information
      #| InputFileName | SheetName | RowId   |
      #| smokeTestSIT  | product   | Row_one |
    #And clicks open payment button
    #And selects payment type
    #And clicks Finish button to complete Data Entry
    #Then A DR task should be created
    #And System should display patient order status page
    #And clicks search button on patient order status page
    #And The In progress link for current prescription should be clicked
      #| InputFileName | SheetName | RowId   |
      #| smokeTestSIT  | patient   | Row_one |
    #Then System displays a donut chart
    #When User clicks perform data review hyperlink
    #Then System should display data review page
    #When User clicks first accept to validate patient data
    #And clicks second accept to validate prescriber data
    #When User clicks search button to update prescriber
    #Then prescriber search page should be displayed from DR
    #When User enters prescriber first name and Last name
      #| InputFileName | SheetName  | RowId   |
      #| smokeTestSIT  | prescriber | Row_one |
    #And clicks search button on prescriber search
    #And clicks select to select a prescriber
    #When User clicks update to update the product data
      #| InputFileName | SheetName   | RowId   |
      #| SmokeTestSIT  | UpdatedData | Row_one |
    #Then product data should be updated
      #| InputFileName | SheetName   | RowId   |
      #| SmokeTestSIT  | UpdatedData | Row_one |
    #When clicks Finish to complete data review
    #Then System must display a message that validation has not been completed
    #And User validates product data
      #| InputFileName | SheetName  | RowId   |
      #| smokeTestSIT  | prescriber | Row_one |
    #And clicks third accept to validate product data
    #And User closes the application
    #Then Number of DR tasks should be decreased
  #

#@RXQE-2999 @E2E @P1
#@store_info
#Scenario: E2E | Access Management | Role Management | Verify if Admin is able to Update Store Hours
    #Given Pharmacy user launches the RxMS application
    #Given I enter username and password
      #| InputFileName 	| SheetName  | RowId  	|
      #| Role_Managemnt  | login			 | ADMIN	 	|
    #And clicks login button
    #When I click on "Store #" from Pharmacy Information
    #Then I should see "Store Information" page
    #Then I am able see following fields:
      #| Pharmacy Information         |
      #| License and ID       |
      #| Pharmacy Inventory Information      |
      #| General Information |
      #| Pharmacy Hours      |
      #| Store Hours      |
    #When I click on Update button
    #Then I am able see following fields:
    #	| Valid From         |
      #| Valid To       |
    #Then I select Valid From field 
#			| InputFileName     | SheetName     	| RowId    	|
#			| store_data 	| store_hours 	| valid_from	|
#		Then I select Valid To field 
#			| InputFileName     | SheetName     	| RowId    	|
#			| store_data 	| store_hours 	| valid_to	|
#		Then I set "24 Hrs" for the following days:
#			| Monday		|
      #| Tuesday   |
      #| Wednesday |
      #| Thursday	|
      #| Friday    |
      #| Saturday  |
      #| Sunday 		|
#		When I clik on Save button
#		Then I should see "24 hrs" for the following days:
#		  | Monday		|
      #| Tuesday   |
      #| Wednesday |
      #| Thursday	|
      #| Friday    |
      #| Saturday  |
      #| Sunday 		|
  #
  
  #@RXQE-3012 @E2E
#@team_member @activate_deactivate
#Scenario: E2E | Role Management | Admin and Retail Pharmacy Manager should be able to Activate and De-activate Team Members
    #Given Pharmacy user launches the RxMS application
    #Given I enter username and password
      #| InputFileName 	| SheetName  | RowId  		|
      #| Role_Managemnt  | login			 | ADMIN			|
    #And clicks login button
#		Then I click on Pharmacist Manager profile icon
    #Then I should be able to see team members option and click
    #Then I should navigate to list of team members profile
    #Then I click on other profile from team members list and navigate to see his profile
      #| InputFileName 	| SheetName 		| RowId |
      #| Role_Managemnt  | Team_members  | user1 |
    #And I select the user and make deactive
    #And I click close
    #And I select the Deactivated option from drop down
    #And I see the Deactived team members
    #And I click on them and change them to active
    #And I click close
    #And I select active from drop down and see the user
    #And I press the logout button
    #Given I enter username and password
      #| InputFileName 	| SheetName  | RowId  		|
      #| Role_Managemnt  | login			 | PHARMACIST	|
    #And clicks login button
#		Then I click on Pharmacist Manager profile icon
    #Then I should navigate to list of team members profile
    #Then I click on other profile from team members list and navigate to see his profile
      #| InputFileName 	| SheetName 		| RowId |
      #| Role_Managemnt  | Team_members  | user1 |
    #And I select the user and make deactive
    #And I click close
    #And I select the Deactivated option from drop down
    #And I see the Deactived team members
    #And I click on them and change them to active
    #And I click close
    #And I select active from drop down and see the user
    #And I press the logout button
    #Given I enter username and password
      #| InputFileName 	| SheetName  | RowId  		|
      #| Role_Managemnt  | login			 | ADMINRO	|
    #And clicks login button
#		Then I click on Pharmacist Manager profile icon
    #Then I should navigate to list of team members profile
    #Then I click on other profile from team members list and navigate to see his profile
      #| InputFileName 	| SheetName 		| RowId |
      #| Role_Managemnt  | Team_members  | user1 |
    #And I should not see the update option in that page
    #And I should not see deactivate or active button
    #And I press the logout button
     #
  #
#@RXAPPD-9879
#@store_info1
#Scenario: UI - Maintain location data - Update with a new range of hours after the First Update    
    #Given I Logged in as Admin full access
    #Given I enter username and password
      #| InputFileName | SheetName    | RowId  |
      #| TaskMaintenance    | login_RO | PERF_ADMIN |
    #And I click on login buton
#		When I click on "Store #" from Pharmacy Information
    #Then I should see "Store Information" page
    #Then I am able see following fields:
      #| Pharmacy Information         |
      #| License and ID       |
      #| Pharmacy Inventory Information      |
      #| General Information |
      #| Pharmacy Hours      |
      #| Store Hours      |
    #When I click on Update button
    #Then I am able see following fields:
    #	| Valid From         |
      #| Valid To       |
    #Then I will update valid from and valid to dates
      #| InputFileName | SheetName 	| RowId |
      #| store_data 		| Store_hours | dates	|
    #Then I select "closed" for all days
#		When I clik on Save button
#		Then I should see Overridden Hours on all days
		  

#@RXAPPD-9877
#@store_info
#Scenario: UI - Maintain location data - First Update with Overridden Hours and regular hours    
    #Given I Logged in as Admin full access
    #Given I enter username and password
      #| InputFileName | SheetName    | RowId  |
      #| TaskMaintenance    | login_RO | PERF_ADMIN |
    #And I click on login buton
#		When I click on "Store #" from Pharmacy Information
    #Then I should see "Store Information" page
    #Then I am able see following fields:
      #| Pharmacy Information         |
      #| License and ID       |
      #| Pharmacy Inventory Information      |
      #| General Information |
      #| Pharmacy Hours      |
      #| Store Hours      |
    #When I click on Update button
    #Then I am able see following fields:
    #	| Valid From         |
      #| Valid To       |
    #Then I will update valid from and valid to dates
      #| InputFileName | SheetName 	| RowId |
      #| store_data 		| Store_hours | dates	|
    #Then I set "Monday" as "24 Hrs"
#		Then I set "Tuesday" as "Closed"
#		Then I set "Wednesday" as "24 Hrs"
#		When I clik on Save button
#		Then I should see "Monday" as "24 Hrs"
#		Then I should see "Tuesday" as "Closed"
#		Then I should see "Wednesday" as "24 Hrs"
#		And I should see "8:00 AM" to "8:00 PM" for the following days:
#		  | Thursday	|
      #| Friday    |
      #| Saturday  |
      #| Sunday 		|
    #
#		
#@RXAPPD-9870
#@store_info
#Scenario: UI - Maintain location data - Display Holiday hours for Store and Pharmacy    
    #Given I Logged in as Admin full access
    #Given I enter username and password
      #| InputFileName | SheetName    | RowId  |
      #| TaskMaintenance    | login_RO | PERF_ADMIN |
    #And I click on login buton
#		When I click on "Store #" from Pharmacy Information
    #Then I should see "Store Information" page
    #Then I am able see following fields:
      #| Pharmacy Information         |
      #| License and ID       |
      #| Pharmacy Inventory Information      |
      #| General Information |
      #| Pharmacy Hours      |
      #| Store Hours      |
#		And I should see "Pharmacy Hours" as "8:00 AM" to "10:00 PM" for the following days:
#		  | Monday			|
      #| Tuesday    	|
      #| Wednesday  	|
      #| Thursday		|
      #| Friday    	|
      #| Saturday  	|
      #| Sunday 			|
    #And I should see "Store Hours" as "8:00 AM" to "10:00 PM" for the following days:
#		  | Monday			|
      #| Tuesday    	|
      #| Wednesday  	|
      #| Thursday		|
      #| Friday    	|
      #| Saturday  	|
      #| Sunday 			|      	 
  