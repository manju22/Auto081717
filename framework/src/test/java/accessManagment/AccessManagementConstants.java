package accessManagment;

public class AccessManagementConstants {

    // appDev
    public static final String Patient_MedHIstory_Button = "//*[@id='tabs-4']";
    public static final String Patient_Images_Tab = "//*[@id='tabs-3']";
    public static final String Patient_Clinical_History = "//*[@id='tabs-5']";
    public static final String Patient_Preferences_Tab = "//*[@id='tabs-2']";
    public static final String Patient_3rd_Party_Plans = "//*[@id='tabs-1']";
    public static final String MedHistory_Arrow_Dropdown = "//*[@id='down-arrow-icon-button-0']/md-icon";
    public static final String Patient_Genaral_Info = "//*[@id='tabs-0']";

    public static final String Patient_Add_New = "//*[@id='patient-add-button']";
    public static final String Patient_Update_Button = "//*[@id='patient-update-button']";
    public static final String Patient_View_Update_Button = "//*[@id='patient-view-button-bar-button-update']";
    public static final String Patient_Update_Enabled_Button = "//*[@id='bottom-tray']/md-toolbar/div/ng-transclude/button";
    public static final String Patient_Scan_Hidden_Button = "//*[@id='bottom-tray']/md-toolbar";
    public static final String Patient_Allergies_Feild = "//*[@id='patient-view-form']/md-card[2]";
    public static final String Admin_Add_role_Popup = "/html/body/div[3]/md-dialog/md-dialog-actions/button";
    public static final String userManagement = "//rxms-role-sidenav//div[contains(@class,'md-active')]/div[contains(text(),'User Management')]";
    public static final String Patient_Profile_thirdpartyplan_Update_Hidden = "//*[@id='patient-view-button-bar-button-update']";//"//*[@id='patient-plan-button-bar-button-update']";
    public static final String Patient_RXMS_RoleManagement = "//rxms-role-management";
    public static final String Clinical_Evaluation_Pediatric_feild = "//*[@id='THERAPY-anchor']/div/div[1]/div[1]/div/div[3]/span[contains(text(),'PEDIATRICS 4-9 YEARS is a POTENTIAL contraindication for ADVIL PM TABLETS')]";
    public static final String Clinical_Evaluation_Pediatric_Message_Validation = "//*[@id='THERAPY-anchor']/div/div[2]/div[contains(text(),'PEDIATRICS 4-9 YEARS is a POTENTIAL contraindication for ADVIL PM TABLETS')]";


    public static final String Drop_down_admin_role_information = "//div[contains(@class,'md-select-menu-container')]//md-content/md-option";

    public static final String Navigation_link = "//*[@id='main-toolbar-buttonicon-navigation-panel']";
    public static final String Navigation_collapsed = "//*[@id='main-left-sidenav'][contains(@class,'open')]";
    public static final String Navigation_initial = "//*[@id='main-left-sidenav-button-team-member']/div[1]";
    public static final String Navigation_name = "//*[@id='main-left-sidenav-button-team-member']/div[2]";
    public static final String Profile_back_button = "//*[@id='back-button-my-profile']";


    public static final String Dashboard_patient_search_Tab = "//*[@id='main-left-sidenav-button-Patient']";
    public static final String Dashboard_prescriber_search_Tab = "//*[@id='main-left-sidenav-button-Prescriber']";
    public static final String Dashboard_drug_search_Tab = "//*[@id='main-left-sidenav-button-Drug']";
    public static final String Dashboard_plan_search_Tab = "//*[@id='main-left-sidenav-button-Plan']";
    public static final String Dashboard_patient_order_status_search_Tab = "//*[@id='main-left-sidenav-button-PatientOrderStatus']";

    public static final String Dashboard_admin = "//*[@id='main-left-sidenav-button-RoleManagement']";
    public static final String Dashboard_logout_button = "//*[@id='main-left-sidenav-button-logout']";

    public static final String Admin_Pharmacist_Role = "//div class='md-list-item-inner' and conatins(text(),'RetailPharmacist')]";

    //Patient permissions removed
    public static final String Patient_Update_Row1 = "//*[@id='available']/md-list[1]/md-list-item/div/md-checkbox";
    public static final String Patient_Update_Row2 = "//*[@id='available']/md-list[3]/md-list-item/div/md-checkbox";
    public static final String Patient_Update_Row3 = "//*[@id='available']/md-list[10]/md-list-item/div/md-checkbox";
    public static final String Admin_Password_Missmatch = "//*[@id='user-management-form']/div/div/md-card/md-card-content/div[2]";
    public static final String Drug_Clinical_Reference = "//*[@id='tabs-8']/div";
    public static final String Drug_Quick_Code = "//*[@id='drug-quickcode']";
    public static final String Drug_NDC_Code = "//*[@id='drug-ndc']";
    public static final String Drug_Clinical_Reference_Results = "//*[@id='product-view']/rxms-product-clinical-references/md-content/div[1]";
    public static final String Drug_General_Info_Product = "//*[@id='product-details']/div/md-card[2]";
    public static final String Admin_Create_role_Search_NotAvailable = "//*[@id='create-role-input-search-notavaaible']";
    public static final String Admin_Create_role_Search_Available = "//*[@id='create-role-search-available']";
    //public static final String Drug_AMI_Search_Results = "//*[@id='scrollbar-table-product-result']";
    public static final String Drug_AMI_Search_Results = "//*[@id='product-list']/table/tbody/tr[1]";
    public static final String Store_Home_Update_Button = "//*[@id='home-store-info-button-update']";
    public static final String Admin_View_Button = "//*[@id='role-management-button-view']";
    public static final String TeamMember_Phone_Profile = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-team-members/div/div/md-content/div/div[1]/div/div[3]/span";
    public static final String TeamMember_Profile_Back_Button = "//*[@id='back-button-my-profile']";
    public static final String Drug_Clinical_Clinical_Pharmacology = "//*[@id='product-view']/rxms-product-clinical-references/md-content/div[1]";
    public static final String Clinical_Evaluation_Therapeutic_Feild = "//*[@id='rx-details-card']/md-card-content/div/div[3]/md-input-container[2]";
    public static final String Clinical_Evaluation_Pediatric_Feild_Age13_Dropdown_Down = "//*[@id='THERAPY-toggle-2']/md-icon";


    /********************************** roles ****************************************************/

    public static final String Admin__Read_Role_tech = "//*[@id='role-management-list']/md-list-item/div/button";
    public static final String Admin_Read_Role_DE = "//*[@id='main-right-sidenav-burger-menu-DE']";
    public static final String Admin_Read_Role_DR = "//*[@id='main-right-sidenav-burger-menu-DR']";
    public static final String Admin_Read_Role_CE = "//*[@id='main-right-sidenav-burger-menu-CE']";
    public static final String Admin_Read_Role_CE_Popup = "/html/body/div[2]/md-dialog/md-dialog-actions/button";
    public static final String MY_Profile = "//*[@id='tabs-0']";
    public static final String Team_member_tab = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-team-members-sidenav/div/div[2]";
    public static final String User_profile_tab = "//*[@id='main-left-sidenav-button-team-member']";
    public static final String Team_member_UXA = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-team-members/div/div/md-content/div/div[1]/div";
    public static final String Team_profile_Update = "//*[@id='dialogContent_team-member-dialog']/div/rxms-member-profile/md-content/md-card[1]/md-card-content/div/div[2]/div/a";
    public static final String Team_member_UXP = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-team-members/div/div/md-content/div/div[3]/div";
    public static final String Employeed_Id_Searchfeild = "//*[@id='user-management-input-employeeid']";
    public static final String Employee_New_password = "//*[@id='change-password-input-newpass']";
    public static final String Employee_conform_password = "//*[@id='change-password-input-confpass']";
    public static final String Password_Reset_button = "//*[@id='user-management-button-reset']";
    public static final String Selecting_Role6 = "//*[@id='role-management-list'][6]/md-list-item/div/button";
    public static final String Patient_All_Intake_Presents = "//*[@id='buttons-bar']/md-toolbar";
    public static final String Store_From_Button = "//*[@id='home-store-information-form']//*[@id='input_1']";
    public static final String Role_Permission_Dropdown = "//*[@id='select_container_2']/md-select-menu/md-content//*[@id='select_option_4']";
    public static final String Store_To_Button = "//*[@id='input_3']";
    public static final String Store_Closed_click5 = "//*[@id='home-store-info-radio-closed-5']";
    public static final String Store_Closed_click6 = "//*[@id='home-store-info-radio-closed-6']";
    public static final String Store_UserManagement_List = "//*[@id='select_container_2']/md-select-menu/md-content";
    public static final String Team_Back_Navigation = "//*[@id='back-button-my-profile']";


    public static final String Full_Admin_Role = "//*[@id='role-management-list'][1]/md-list-item/div/button";
    public static final String User_Management_Dropdown = "//*[@id='select_option_19']";
    public static final String Permission_Revoke2 = "//*[@id='available']/md-list[1]";
    public static final String Selecting_Role7 = "//*[@id='role-management-list'][7]/md-list-item/div/button";
    public static final String Dashboard_buttuon = "//*[@id='main-left-sidenav-burger-menu']/md-list/md-list-item[1]";
    public static final String Store_number = "//*[@id='pharmacy-information-card']/md-card-content/div[2]/div[1]/h5[1]/a";
    public static final String Store_Update_button = "//*[@id='home-store-info-button-update']";
    public static final String Store_Date__from_Dropdown = "//*[@id='date-from']/div[1]/button";
    public static final String Store_Radio_Click0 = "//*[@id='home-store-info-radio-24hrs-0']";
    public static final String Store_Radio_Click1 = "//*[@id='home-store-info-radio-24hrs-1']";
    public static final String Store_Radio_Click2 = "//*[@id='home-store-info-radio-24hrs-2']";
    public static final String Store_Date_To_Dropdown = "//*[@id='date-to']/div[1]/button";
    public static final String Store_Save_Button = "//*[@id='home-store-info-button-save']";
    public static final String Pharmacy_Manager_DE = "//*[@id='main-right-sidenav-burger-menu-DE']";
    public static final String Pharmacy_Manager_DR = "//*[@id='main-right-sidenav-burger-menu-DR']";
    public static final String Team_member_Pharmacit = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-team-members/div/div/md-content/div/div[2]";
    public static final String Team_member_Close_Icon = "//*[@id='close-button-team-member-details']/md-icon";
    public static final String User_Management_Search_Button = "//*[@id='user-management-button-search']";
    public static final String Store_All_Button_Presents = "//*[@id='bottom-tray']/md-toolbar";
    public static final String pickup_date_tomorrow = "//*[@id='pickup-later-button-date-1']";
    public static final String Clinical_Evaluation_Popup_Close_Symbol = "//*[@id='close-button']/md-icon";
    public static final String Clinical_Evaluation_Popup_Close_Button = "//*[@id='go-back']";
    public static final String Clinical_Evaluation_Rxnumber_Hyperlink = "//*[@id='rx-details-rxnumber-button']";
    public static final String Clinical_Evaluation_Rxnumber_Hyperlink_Displayed_Page = "//md-dialog//div/strong[contains(text(),'Rx Details for')]";


    public static final String Perf_Team_Member_Mnager = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-team-members/div/div/md-content/div/div[2]";


    public static final String PROFILE_BUTTON = "//*[@id='main-left-sidenav-button-team-member']";


    // can use this for side nav, logout
    public static final String RXMS_MEMBER_SIDENAV = "//*[@id='rxms-main-container']//rxms-team-members-sidenav";
    public static final String RXMS_MY_PROFILE_BACKBUTTON = "//*[@id='back-button-my-profile']";
    public static final String RXMS_LOGOUT_BUTTON = "//*[@id='main-left-sidenav-button-logout']/div";
    public static final String RXMS_TEAM_MEMBERS_SIDENAV_TEAM_MEMBERS_OPTION = RXMS_MEMBER_SIDENAV + "//div[contains(text(),'Team Members')]";
    public static final String RXMS_ALL_TEAM_MEMBERS_LIST = "//div[@class='rxms-team-members layout-fill layout-row']//div[@role='button']";
    public static final String RXMS_MY_PROFILE_PAGE = "//div/rxms-member-profile";

    public static final String RXMS_TEAM_MEMBER_PROFILE_STATUS_DROP_DOWN = "//*[@class='md-select-icon']";
    public static final String RXMS_TEAM_MEMBER_PROFILE_STATUS_DROP_DOWN_MENU = "//md-select-menu[@class='_md md-material-theme']//md-option";
    public static final String RXMS_PERFORM_DATA_ENTRY_BUTTON = "//span[contains(text(),'Perform Data Entry')]";
    public static final String RXMS_PATIENT_ORDER_STATUS_SEARCH_RESULTS = "//*[@id='patient-order-status-table']/md-content/div";


    /************************************ roleManagement **********************************************/

    public static final String DASHBOARD_ADMIN_NAVLINK = "//*[@id='main-left-sidenav-burger-menu']/md-list/md-list-item[7]";
    public static final String USER_MGMT_NAVLINK = "//*[@id='tabs-0']";
    //public static final String ROLE_MGMT_NAVLINK = "//*[@id='role-container']/rxms-role-sidenav/nav/div[2]";
    public static final String ROLE_MGMT_NAVLINK = "//*[@id='rxms-main-container']/ng-outlet/rxms-role-main/div/md-content/div/rxms-role-sidenav/nav/div[2]";
    public static final String TEXTROLE_MGMT_LIST = "//*[@id='role-management-list'][7]/md-list-item/div/button";
    public static final String NEWROLE_MGMT_LIST = "//*[@id='role-management-list'][7]/md-list-item/div/div[1]/div[1]";
    public static final String ADD_ROLE_BUTTON = "//*[@id='role-management-button-add']";
    public static final String UPDATE_ROLE_BUTTON = "//*[@id='role-management-button-update']";
    public static final String DELETE_ROLE_BUTTON = "//*[@id='role-management-button-delete']";
    public static final String VIEW_ROLE_BUTTON = "//*[@id='role-management-button-view']";
    public static final String ROLE_DROP_DOWN = "//*[@id='select_value_label_0']";
    public static final String CREATE_ROLE_PAGE = "//*[@id='create-update-role-dialog']/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String ROLE_NAME_TEXTBOX = "//*[@id='create-role-input-role-name']";
    public static final String ROLE_DESC_TEXTBOX = "//*[@id='create-role-input-role-description']";
    public static final String UPDATE_ROLE_NAME_TEXTBOX = "//*[@id='create-role-input-role-name-update']";
    public static final String UPDATE_ROLE_DESC_TEXTBOX = "//*[@id='create-role-input-role-description']";
    public static final String USER_ONLY_CHECKBOX = "//*[@id='create-role-checkbox-user-only']/div[1]";
    public static final String SYSTEM_AREA_DROPDOWNS = "//*[@id='dialogContent_create-update-role-dialog']//span/div[contains(text(),'BPM')]";
    public static final String ROLE_DROPDOWN_ITEM = "//*[@id='select_option_18']";
    public static final String NOTAVAILABLE_PERMISSIONS_SEARCH_TEXT = "//*[@id='create-role-input-search-notavaaible']";
    public static final String AVAILABLE_PERMISSIONS_SEARCH_TEXT = "//*[@id='create-role-search-available']";
    public static final String NOTAVAILABLE_PERMISSIONS_ITEM = "//*[@id='not-available']/md-list[1]";
    public static final String AVAILABLE_PERMISSIONS_ITEM = "//*[@id='available']/md-list[1]";
    public static final String UPDATE_NOTAVAILABLE_PERMISSIONS_ITEM = "//*[@id='not-available']/md-list[1]";
    public static final String UPDATE_AVAILABLE_PERMISSIONS_ITEM = "//*[@id='available']/md-list[1]";
    public static final String SELECT_PERMISSION1 = "//*[@id='not-available']/md-list[1]/md-list-item/div";
    public static final String SELECT_PERMISSION2 = "//*[@id='not-available']/md-list[2]/md-list-item/div";
    public static final String SELECT_PERMISSION3 = "//*[@id='not-available']/md-list[3]/md-list-item/div";
    public static final String MOVE_TO_RIGHT = "//*[@id='create-role-button-forward']";
    public static final String MOVE_TO_LEFT = "//*[@id='create-role-button-rewind']";
    public static final String ADDUPDATE_ROLE_SAVE_BUTTON = "//*[@id='create-role-button-save']";
    public static final String ADDUPDATE_ROLE_CANCEL_BUTTON = "//*[@id='create-role-button-cancel']";
    public static final String DELETE_OVERLAY_CONFIRM_STRING = "Are you sure you want to delete the role?";
    public static final String DELETE_OVERLAY_CONFIRM_TEXT = "//*[@id='dialogContent_role-maintenance-cancel-confirm']/div/p";
    public static final String DELETE_OVERLAY_YES_BUTTON = "//*[@id='role-maintenance-cancel-confirm']/md-dialog-actions/button[1]";
    public static final String DELETE_OVERLAY_NO_BUTTON = "//*[@id='role-maintenance-cancel-confirm']/md-dialog-actions/button[2]";
    public static final String TEAM_MEMBER_MENU = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-team-members-sidenav/div/div[2]";
    public static final String MY_PROFILE_LINK = "//*[@id='main-left-sidenav-burger-menu']/div";
    public static final String ADMIN_BACK_BUTTON = "//*[@id='back-button-administrative-functions']";
    //*[@id="role-management-list"]/md-list-item/div/button
    public static final String All_buttons_Present = "//*[@id='role-management-bottom-tray']/md-toolbar";
    //*[@id='role-management-bottom-tray']/md-toolbar"
    public static final String PRESCRIBER_SEARCH_BUTTON = "//*[@id='main-left-sidenav-burger-menu']/md-list/md-list-item[4]";
    public static final String PRESCRIBER_input_last_name = "//*[@id='input-lname-patient']";
    public static final String PRESCRIBER_input_first_name = "//*[@id='input-fname-patient']";
    public static final String PRESCRIBER_Seacrh_button = "//*[@id='patient-submit']";
    public static final String PRESCRIBER_result_1st_row = "//*[@id='patient-table']/md-content/div[1]/div";
    public static final String PRESCRIBER_VIEW = "//*[@id='prescriber-search-results-button-view']";
    public static final String PRESCRIBER_DETAIL_UPDATE_LOCATION_BUTTON = "//*[@id='prescriber-update-button-update']";
    public static final String PRESCRIBER_DETAIL_ADD_LOCATION_BUTTON = "//*[@id='add-location-button']";

    public static final String TASK_DE_COUNT = "//*[@id='main-right-sidenav-burger-menu-DE']/div[2]/span[1]";
    public static final String TASK_BOARD_REFRESH_BUTTON = "//*[@id='main-right-sidenav-burger-menu']/rxms-progress-bar/div/div/button";
    public static final String TASK_BOARD_PROGRESS_BAR = "//*[@id='main-right-sidenav-burger-menu']/rxms-progress-bar/div/div/md-progress-linear/div/div[3]";

    public static final String STORE_LINK = "//*[@id='pharmacy-information-card']/md-card-content/div[2]/div[1]/h5[1]/a";
    public static final String STORE_INFO_VALID_FROM = "//*[@id='date-from']/div[1]/button";

    public static final String STORE_INFO_VALID_TO = "//*[@id='date-to']/div/button";
    public static final String STORE_INFO_MONDAY_24HRS = "//*[@id='home-store-info-radio-24hrs-0']";
    public static final String STORE_INFO_TUEDAY_24HRS = "//*[@id='home-store-info-radio-24hrs-1']";
    public static final String STORE_INFO_WEDDAY_24HRS = "//*[@id='home-store-info-radio-24hrs-2']";
    public static final String STORE_INFO_THUDAY_24HRS = "//*[@id='home-store-info-radio-24hrs-3']";
    public static final String STORE_INFO_FRIDAY_24HRS = "//*[@id='home-store-info-radio-24hrs-4']";
    public static final String STORE_INFO_SATDAY_24HRS = "//*[@id='home-store-info-radio-24hrs-5']";
    public static final String STORE_INFO_SUNDAY_24HRS = "//*[@id='home-store-info-radio-24hrs-6']";
    public static final String STORE_INFO_MONDAY_CLOSED = "//*[@id='home-store-info-radio-closed-0']";
    public static final String STORE_INFO_TUEDAY_CLOSED = "//*[@id='home-store-info-radio-closed-1']";
    public static final String STORE_INFO_WEDDAY_CLOSED = "//*[@id='home-store-info-radio-closed-2']";
    public static final String STORE_INFO_THUDAY_CLOSED = "//*[@id='home-store-info-radio-closed-3']";
    public static final String STORE_INFO_FRIDAY_CLOSED = "//*[@id='home-store-info-radio-closed-4']";
    public static final String STORE_INFO_SATDAY_CLOSED = "//*[@id='home-store-info-radio-closed-5']";
    public static final String STORE_INFO_SUNDAY_CLOSED = "//*[@id='home-store-info-radio-closed-6']";
    public static final String STORE_INFO_SAVE_BUTTON = "//*[@id='home-store-info-button-save']";
    public static final String STORE_INFO_CANCEL_BUTTON = "//*[@id='home-store-info-button-cancel']";
    public static final String STORE_UPDATE_BUTTON = "//*[@id='home-store-info-button-update']";

    public static final String TEAM_MEMBER_DEACTIVATE_BUTTON = "//*[@id='member-profile-button-deactive']";
    public static final String TEAM_MEMBER_ACTIVATE_BUTTON = "//*[@id='member-profile-button-active']";

    /**************************** roleManage******************************************/
    public static final String Testing_Role1 = "//*[@id='role-management-list'][7]/md-list-item/div/button";
    public static final String BPM_Dropdown = "//*[@id='select_option_4']";
    public static final String Permission_Revoke1 = "//*[@id='available']/md-list[1]";
    //public static final String MOVE_TO_RIGHT = "//*[@id='create-role-button-forward']";
    //public static final String MOVE_TO_LEFT = "//*[@id='create-role-button-rewind']";
    public static final String Grant_Permission1 = "//*[@id='not-available']/md-list[1]";
    public static final String Grant_Permission2 = "//*[@id='not-available']/md-list[3]";
    public static final String Grant_Permission3 = "//*[@id='not-available']/md-list[6]";
    public static final String Grant_Permission4 = "//*[@id='not-available']/md-list[8]";
    public static final String SYSTEM_AREA_DROPDOWN = "//*[@id='select_value_label_0']";
    public static final String Logout_button = "//*[@id='main-left-sidenav-button-logout']";
    public static final String Logout_This_device = "//*[@id='bottom-tray']/md-toolbar/div/ng-transclude/button[1]";
    public static final String Update_button = "//*[@id='role-management-button-update']";
    public static final String DE_Disabled = "//*[@id='main-right-sidenav-burger-menu-DE']";
    public static final String DR_Disabled = "//*[@id='main-right-sidenav-burger-menu-DR']";


    /************************************** Drug ***************************/
    public static final String drug_menu_button = "//*[@id='main-left-sidenav-burger-menu']/md-list/md-list-item[3]";
    public static final String user_name = "//*[@id='username-input']";
    public static final String password = "//*[@id='password-input']";
    public static final String login_button = "//*[@id='login-button']";
    public static final String drug_search_feild = "//*[@id='search-text']";
    public static final String drug_input_search = "//*[@id='product-search-form']/md-input-container";
    public static final String search_button = "//*[@id='product-search-button-search']";
    public static final String drug_name_input_result_page = "//*[@id='input_1']";
    public static final String Drug_Clinical_Reference_Page = "//*[@id='product-view']/rxms-product-clinical-references/md-content";
    public static final String DrugClinical_Reference_Page_First_Box = "//*[@id='clinical-ref-0']/div/img";
    public static final String error_display_message = "//*[@id='product-search-form']/md-input-container/div/div[2]/div";
    //if we dont pass any value in feild bar error message displays
    public static final String requiredfeild_error_message_displays = "//*[@id='product-search-form']/md-input-container/div/div[2]";
    //listed icons on RXMS page
    public static final String listed_left_side_icons_page = "//*[@id='main-left-sidenav-burger-menu']/div[3]";
    //all items with breif info of icons
    public static final String all_icons_listed_left_side = "/html/body/rxms-app/ng-outlet/rxms-main/div/div[3]";
    public static final String keyword_arrow = "//*[@id='back-button-drug-details']/md-icon";
    public static final String drug_UPC_input_result = "//*[@id='drug-upc']";
    public static final String drug_NDC_input_result = "//*[@id='drug-ndc']";
    public static final String drug_WIC_input_result = "//*[@id='drug-wic']";
    public static final String drug_search_matching_criteria = "//*[@id='product-list']/md-content/div[1]/div/div[2]/div[2]";
    public static final String drug_error_msg_for_lessthan_three_letters = "Search text shouldn't be less than 3 characters";
    public static final String drug_error_msg_for_no_drug_match = "No drugs matched your search criteria";
    public static final String button_this_device = "//*[@id='logout-popup']/md-dialog-actions/button[1]";
    public static final String button_logout = "//*[@id='main-left-sidenav-button-logout']/div[2]";
    public static final String Drug_Keyword_Back_Result_Page = "//*[@id='rxms-main-container']/ng-outlet/rxms-product-search/div/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String RADIO_PICKUPLATER = "//*[@id='scanrx-radio-pickup']";
    public static final String PICKUPLATER_TODAYSDATE = "//*[@id='pickup-later-button-date-1']";
    public static final String Patient_Profile_Update_Authentication = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-member-profile/md-content/md-card[1]/md-card-content/div/div[2]/div/a";
    public static final String Patient_Profile_Update_Authentication2_option = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-member-profile/md-content/md-card[2]/md-card-content/div/div[2]/a";
    public static final String TEAM_MEMBER_PROFILE_PHONE_NUMBER = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-team-members/div/div/md-content/div/div[3]/div/div[3]";
    public static final String TEAM_MEMBER_PROFILE_ROLE_1 = "//*[@id='dialogContent_team-member-dialog']/div/rxms-member-profile/md-content/md-card[1]/md-card-content/div/div[2]/md-list/md-list-item[1]";

    /******************************************patient prescriber********************************/

    public static final String patient_buton = "//*[@id='main-left-sidenav-burger-menu']/md-list/md-list-item[2]";
    public static final String input_name_feild = "//*[@id='input-lname-patient']";
    public static final String input_first_name = "//*[@id='input-fname-patient']";
    public static final String Seacrh_button = "//*[@id='patient-submit']";
    public static final String input_result_1st_row = "//*[@id='patient-table']/md-content/div[1]/div";
    public static final String view_button = "//*[@id='patient-view-button']";
    public static final String IntakeRX_button = "//*[@id='patient-view-button-bar-button-intake']";
    public static final String pickup_latter = "//md-radio-group/md-radio-button[@id='scanrx-radio-pickup' and @value='pickUpLater']";
    public static final String pickup_time = "//*[@id='scanrx-radio-pickup']";

    public static final String date_tuesday = "//*[@id='pickup-later-button-date-1']";
    public static final String time_dropdown = "//*[@id='select_value_label_11']";
    public static final String AM_PM_dropdown = "//*[@id='select_value_label_241']";
    public static final String scan_radio_button = "//*[@id='scanrx-radio-scan']";
    public static final String Finish_button = "//*[@id='scanrx-button-finish']";
    public static final String Last_name = "//*[@id='last-name']";
    public static final String First_name = "//*[@id='first-name']";
    public static final String Select_button_prescriber = "//*[@id='main-data-prescriber-sidenav-button-select']";
    public static final String All_days = "//*[@id='scanrx-form']/md-card[1]/md-card-content/div[2]/rxms-pickup-later/div/div[3]";
    public static final String Product_original_date = "//*[@id='orig-data']";
    public static final String Product_daw_feild = "//*[@id='daw']";
    public static final String Product_Substitute_feild = "//*[@id='substitute']";
    public static final String Product_search_name_feild = "//*[@id='input-autocomplete-location']";
    public static final String Product_mandatory_error_message = "//*[@id='autocompleted-product-search']/md-autocomplete-wrap/md-input-container/div[2]/div/div";
    public static final String Product_Drug_expire_date = "//*[@id='drug-exp-date']";
    public static final String Product_Quantity = "//*[@id='qty']";
    public static final String Product_Quantity_display = "//*[@id='qty-disp']";
    public static final String Product_days_supply = "//*[@id='day-supply']";
    public static final String Product_Rx_expiration_date = "//*[@id='rx-exp-date']";
    public static final String Product_directions = "//*[@id='directions']";
    public static final String Product_open_plus_button = "//*[@id='product-info-button-openproduct']/span";
    public static final String Payment_type = "//*[@id='payment-type-input']";
    public static final String Payment_dropdown_button = "//*[@id='payment-info-buttonicon-down']";
    public static final String Payment_dropdown_result = "//*[@id='payment-info-button-cash']";
    public static final String Prescriber_final_finsh_button = "//*[@id='main-data-entry-button-toolbar-finish']";
    public static final String Pickup_radio_button = "//*[@id='scanrx-radio-pickup']/div[1]";
    public static final String Prescriber_search_button = "//*[@id='prescriber-fieldset']//*[@id='prescription-search-prescriber-button-search']";
    public static final String Prescriber_clear_button = "//*[@id='prescription-search-prescriber-button-clearfiel']";
    public static final String prescriber_select_button = "//*[@id='main-data-prescriber-sidenav-button-select']";
    public static final String Prescriber_plus_button = "//*[@id='rescriber-info-button-openprescriber2']";
    public static final String Product_refills = "//*[@id='refills']";
    public static final String Payment_plus_button = "//*[@id='payment-info-button-openpayment']/md-icon";
    public static final String Pickup_date_starting = "//*[@id='select_value_label_10']";
    //*[@id="pickup-later-button-date-3"]/div[1]
    public static final String Select_time_dropdown = "//*[@id='select_value_label_241']";
    public static final String Slected_time_result = "//*[@id='select_option_21']";
    public static final String Click_timezone_dropdown = "//*[@id='select_value_label_11']";
    //public static final String Select_timezone_AM="//*[@id='select_value_label_1004']";
    public static final String Select_timezone_PM = "//*[@class='ng-scope md-ink-ripple']//*[@class='md-text ng-binding']//*[@class='md-ripple-container']";
    //*[@class='ng-scope md-ink-ripple']//*[@class='md-text ng-binding']//*[@class='md-ripple-container'];
    //*[@id='scanrx-form']/md-card[1]/md-card-content/div[2]/rxms-pickup-later/div/div[5]/md-input-container[2]
    public static final String Prescriber_clear_feild = "//*[@id='prescription-search-prescriber-button-clearfield']";
    //	public static final String button_this_device="//*[@id='logout-popup']/md-dialog-actions/button[1]";
//	public static final String button_logout="//*[@id='main-left-sidenav-button-logout']/div[2]";
    //public static final String DE_button="//*[@id='main-right-sidenav-burger-menu-DE']/div[2]/span[1]";
    public static final String Dispended_feild = "//*[@id='select_value_label_90']";
    public static final String PRESCRIBER_LN = "//*[@id='prescriber-fieldset']//input[@id='last-name']";
    public static final String PRESCRIBER_FN = "//*[@id='prescriber-fieldset']//input[@id='first-name']";
    public static final String SELECT_PRESCRIBER_BTN = "//*[@id='main-data-prescriber-sidenav-button-select']";
    public static final String PAYMENT_DROPDOWN = "//*[@id='payment-type-input']";
    public static final String CASH_OPTION = "//*[@id='payment-info-button-cash']/span";
    public static final String DE_FINISH = "//*[@id='main-data-entry-button-toolbar-finish']";
    public static final String DR_CLICK = "//*[@id='main-right-sidenav-burger-menu-DR']/div[2]/span[1]";
    public static final String DR_ALERT_OK_BTN = "//*[@id='main-data-entry-button-toolbar-cancel-confirm']/md-dialog-actions/button[2]";
    public static final String DR_PATIENT_ACCEPT_BTN = "//*[@id='dr-patient-accept']";
    public static final String DR_PRESCRIBER_ACCEPT_BTN = "//*[@id='dr-prescriber-accept']";
    public static final String DR_PRODUCT_ACCEPT_BTN = "//*[@id='dr-product-accept']/ng-bind-html";
    public static final String DR_FINISH = "//*[@id='dr-form-finish']";
    public static final String CLICK_DE = "//*[@id='main-right-sidenav-burger-menu-DE']/div[2]/span[1]";
    public static final String Patient_order = "//*[@id='chart-arc']";
    public static final String Patient_order_dropdown = "//*[@id='patient-order-status-form']//*[@class='md-material-theme md-input-has-value']//*[@class='md-select-value']";
    public static final String Patient_order_prescriber = "//*[@class='md-select-menu-container md-material-theme md-active md-clickable']//md-select-menu//md-content//md-option[@class='md-ink-ripple' and @value='Prescriber]//div[contains(text(),'Prescriber')]";
    public static final String Patient_order_precriber_lastname = "//*[@name='prescriberLastNameName']";
    public static final String Patient_order_search = "//*[@id='patient-order-status-button-search']";
    public static final String Patient_phone_number = "//*[@id='patient-order-status-input-phone']";
    public static final String Patient_DOB = "//*[@id='input_8']";

    //*[@id="input_8"]
    //*[@id="patient-order-status-input-phone"]


    /*********************************task Maintenance***********************/

    public static final String userName = "//*[@id='username-input']";
    //public static final String password="//*[@id='password-input']";
    public static final String Login_Button = "//*[@id='login-button']";
    public static final String Taskboard_MenuButton = "//*[@id='workflow-button-panel']/md-icon";
    public static final String DE_TaskButton = "//*[@id='main-right-sidenav-burger-menu-DE']";
    public static final String DR_TaskButton = "//*[@id='main-right-sidenav-burger-menu-DR']";
    public static final String CE_TaskButton = "//*[@id='main-right-sidenav-burger-menu-CE']";
    public static final String Filling_TaskButton = "//*[@id='main-right-sidenav-burger-menu-FILL']";
    public static final String ProductVerification_TaskButton = "//*[@id='main-right-sidenav-burger-menu-PV']";
    public static final String Dashbord_MenuButton = "//*[@id='main-left-sidenav-button-Prescriber']/div";
    public static final String Patient_LeftMenuButton = "//*[@id='main-left-sidenav-button-Patient']";
    public static final String Patient_LastName = "//*[@id='input-lname-patient']";
    public static final String Patient_FirstName = "//*[@id='input-fname-patient']";
    public static final String Patient_Phonenumber = "//*[@id='input-phone-patient']";
    public static final String Patient_DateOfBrith = "//*[@id='input_79']";
    public static final String Patient_SearchButton = "//*[@id='patient-submit']";
    public static final String Patient_ViewButton = "//*[@id='patient-view-button']";
    public static final String Intake_RxButton = "//*[@id='patient-view-button-bar-button-intake']";
    public static final String Rx_FinishButton = "//*[@id='scanrx-button-finish']";
    public static final String Prescriber_SelectButton = "//*[@id='main-data-prescriber-sidenav-button-select']";
    // public static final String Prescriber_FirstName = "//*[@id='first-name']";
    public static final String Prescriber_LastName = "//*[@id='prescriber-fieldset']//input[@id='last-name']";
    public static final String Prescriber_FirstName = "//*[@id='prescriber-fieldset']//input[@id='first-name']";
    public static final String Prescriber_Phonenumber = "//*[@id='phone']";
    public static final String Prescriber_NPIDEA = "//*[@id='npidea']";
    //public static final String Prescriber_StateDrpdwn ="//*[@id='select_value_label_642']";
    //public static final String Prescriber_searchButton= "//*[@id='prescription-search-prescriber-button-search']";
    public static final String Prescriber_searchButton = "//*[@id='prescriber-fieldset']//*[@id='prescription-search-prescriber-button-search']";
    public static final String Product_OriginalDate = "//*[@id='orig-data']";
    public static final String Product_DAW = "//*[@id='daw']";
    public static final String Product_Substitute = "//*[@id='substitute']";
    public static final String ViewSize_CheckBox = "//*[@id='product-information-checkbox-viewsize']/div[1]/div[2]";
    public static final String ViewSizeManufacturer_CheckBox = "//*[@id='product-information-checkbox-viewsize-manufacturer']/div[1]/div[1]";
    public static final String DrugName_Field = "//*[@id='input-autocomplete-location']";
    public static final String DrugExpiryDate_Field = "//*[@id='drug-exp-date']";
    public static final String Quantity_field = "//*[@id='qty']";
    public static final String Quantity_disp = "//*[@id='qty-disp']";
    public static final String Directions_field = "//*[@id='directions']";
    public static final String Days_Supply = "//*[@id='day-supply']";
    public static final String Refills_field = "//*[@id='refills']";
    public static final String RxExpiration_date = "//*[@id='rx-exp-date']";
    public static final String open_prescriber = "//*[@id='prescriber-info-button-openprescriber']/md-icon";
    public static final String Open_Product = "//*[@id='product-info-button-openproduct']/span";
    public static final String Open_payment = "//*[@id='payment-info-button-openpayment']/md-icon";
    public static final String Payment_Dropdown = "//*[@id='payment-type-input']";
    public static final String Cash_option = "//*[@id='payment-info-button-cash']/span";
    public static final String DE_FinishButton = "//*[@id='main-data-entry-button-toolbar-finish']";
    public static final String Product_result = "//span[contains(text(),'ESTRING')]";
    public static final String DR_Title = "//*[@id='rxms-main-container']/ng-outlet/rxms-main-data-review/div/div/rxms-data-review-patient-toolbar/div/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    //	public static final String DR_ALERT_OK_BTN = "//*[@id='main-data-entry-button-toolbar-cancel-confirm']/md-dialog-actions/button[2]";
    public static final String numberOfDETasks = "//*[@id='main-right-sidenav-burger-menu-DE']/div[2]/span[1]";
    public static final String numberOfDRTasks = "//*[@id='main-right-sidenav-burger-menu-DR']/div[2]/span[1]";

    public static final String RxMS_logoutButton = "//*[@id='main-left-sidenav-button-logout']/div[1]/md-icon";
    public static final String LogoutAlert_button = "//*[@id='bottom-tray']/md-toolbar/div/ng-transclude/button[2]";
    public static final String Patientprofile_Demographic = "//*[@id='patient-view-form']/md-card[1]/div[2]/div[3]";
    public static final String Patientprofile_thirdparty = "//*[@id='tabs-1']/div";
    public static final String Patientprofile_back = "//*[@id='back-button-patient-profile']/md-icon";
    public static final String Patientprofile_thirdparty_PlanId = "//*[contains(@id,'input-plan-id-1')]";
    public static final String Patientprofile_thirdparty_RecID = "//*[contains(@id,'input-recipient-1')]";
    public static final String Patientprofile_thirdparty_GroupId = "//*[contains(@id,'input-group-id-1')]";
    public static final String Patientprofile_thirdparty_BIN = "//*[@id='input-bin-plan']";
    public static final String Patientprofile_thirdparty_PCN = "//*[@id='input-pcn-plan']";
    public static final String Patientprofile_thirdparty_Rtp = "//*[@id='standard-plan-select-relationship-toplan']";
    public static final String Patientprofile_thirdparty_Personcode = "//*[@id='standard-plan-form-0']/div[1]//*[@id='input-person-code-plan']";
    public static final String Patientprofile_thirdparty_preferences = "//*[@id='standard-plan-form-0']/div[1]//*[@id='tabs-2']";
    public static final String Patientprofile_thirdparty_preferences_snapcap = "//*[@id='patient-plan']/rxms-patient-preferences-view/md-card/div[2]/div";
    public static final String Patientprofile_showcomments = "//*[@id='comments-icon']";
    public static final String Patientprofile_hidecomments = "//*[@id='sidenav-comments-icon']";
    public static final String Patientprofile_comments = "//*[@id='sidenav-comments']/md-content/div/span";
    
    /***************************************Smoke Test Sit********************************************/


    // public static final String Open_payment = "//*[@id='product-info-button-openproduct']/span";
    // public static final String DE_FinishButton = "//*[@id='main-data-entry-button-toolbar-finish']";
    public static final String Patient_AccceptButton = "//*[@id='dr-patient-accept']";
    public static final String Prescriber_AcceptButton = "//*[@id='dr-prescriber-accept']";
    public static final String Product_AcceptButton = "//*[@id='dr-product-accept']/ng-bind-html";

    public static final String SendToIcplus_Button = "//*[@id='main-data-entry-button-toolbar-sendtoicplus']";
    public static final String Prescriber_ClearFields = "//*[@id='prescription-search-prescriber-button-clearfield']";
    public static final String PrescriberState_DropDown = " //*[@id='state-select']";
    public static final String Select_NoState = "//*[@id='select_option_64']";
    public static final String State_Drpdwn = "//*[@id='select_value_label_62']";

    //public static final String Product_result = "//span[contains(text(),'QUINDAL')]";
    //*[@id="main-data-entry-button-toolbar-cancel-confirm"]/md-dialog-actions/button[1]

    public static final String DR_ProductUpdate = "//*[@id='dr-product-search']";
    public static final String DR_ProductDirections = "//*[@id='directions']";
    public static final String DR_PrescriberField = "//*[@id='main-data-review-divcontainer']/div[2]/div[2]/div/fieldset";
    public static final String DR_ProductName = "//*[@id='input-autocomplete-location']";
    public static final String DR_PatientName = "//*[@id='main-data-review-divcontainer']/div[2]/div[1]/div/fieldset/div/div[1]/rxms-data-review-patient/div/div";
    public static final String DR_PrescriberName = "//*[@id='main-data-review-divcontainer']/div[2]/div[2]/div/fieldset/div/div[1]/rxms-data-review-prescriber/div/div[1]/div/div[1]";
    public static final String DE_FunctionPopup_cancel = "//*[@id='dialog-button-cancel']";
    // public static final String rems_ProductResult = "//span[contains(text(),'PROLASTIN')]";
    public static final String productChange_Button = "//*[@id='changebtnid']";
    public static final String productSubstitute_Field = "//*[@id='dispensed']";
    public static final String drugSelect_dropdown = "//*[@id='select_value_label_57']";
    public static final String radio_pickuplater = "//*[@id='pickup-later-button-date-0']/div/span[1]";
    public static final String date_latest = "//*[@id='scanrx-radio-pickup']";
    public static final String pickup_date = "//*[@id='pickup-later-button-date-3']/div/span[2]";
    public static final String DR_ValidationPopupOkButton = "//*[@id='main-data-review-popup-validate-button-ok']";
    public static final String DR_Validation_popup = "//*[@id='accept-popup']";
    public static final String DR_Validation_message = "//*[@id='dialogContent_accept-popup']/div/div";
    public static final String radio_Waiting_Button = " //*[@id='scanrx-radio-waiting']";
    public static final String radio_Scan_Button = "//*[@id='scanrx-radio-scan']";

    public static final String drug_LeftMenuButton = "  //*[@id='main-left-sidenav-button-Drug']";
    public static final String drug_search_field = "//*[@id='search-text']";
    public static final String drugSearch_Button = "//*[@id='product-search-button-search']";
    public static final String drug_results = "//*[@id='scrollbar-table-product-result']/div[1]/div/div[1]/div";
    public static final String drug_CoreDrugInfo = "//*[@id='product-details']";

    public static final String plan_LeftMenuButton = "//*[@id='main-left-sidenav-burger-menu']/md-list/md-list-item[5]";
    public static final String planName_searchfield = "//*[@id='input-plan-name-plan']";
    public static final String plan_searchButton = "//*[@id='plan-search-button-search']";
    public static final String plan_results = "//*[@id='singlerow-plan-0']/div[4]";

    public static final String patientOrderStatus_LefttMenuButton = "//*[@id='main-left-sidenav-button-PatientOrderStatus']";
    public static final String patientOrderStatuts_patientSearchField = "//*[@id='patient-order-status-input-lastname']";
    public static final String patientOrderStatus_patientSearchButton = "//*[@id='patient-order-status-button-search']";
    public static final String patientOrderStatus_Table = "//*[@id='patient-order-status-table']";

    public static final String prescriberSearch_LeftSideNavButton = "//*[@id='main-left-sidenav-burger-menu']/md-list/md-list-item[4]";
    public static final String prescriberSearch_FirstName = "//*[@id='first-name']";
    public static final String prescriberSearch_LastName = "//*[@id='last-name']";
    public static final String prescriberSearch_SearchButton = "//*[@id='prescriber-search']";
    public static final String prescriberSearch_StateDropDown = "//*[@id='prescriber-search-form']/div/md-input-container[5]";
    public static final String prescriberSearch_StateResults = "//*[contains(@id,'select_option_')]";
    public static final String prescriberSearch_Results = "//*[@id='singlerow-prescriber-0']";
    public static final String logout_Button = " //*[@id='main-left-sidenav-button-logout']";
    public static final String login_card = "//*[@id='login-card']";
    public static final String patientSearchPageTitle = "//*[@id='rxms-main-container']/ng-outlet/rxms-patient-search-form/div/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String patient_table = "//*[@id='patient-table']";
    public static final String RxMSHome_PharmacyInformationCard = "//*[@id='pharmacy-information-card']";
    public static final String intakeMethodTitle = "//*[@id='intake-dialog']/div/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item";
    public static final String drugSearchPageTitle = "//*[@id='rxms-main-container']/ng-outlet/rxms-product-search/div/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String planSearchPageTitle = "//*[@id='rxms-main-container']/ng-outlet/rxms-plan-search/div/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String patientOrderStatusPageTitle = "//*[@id='rxms-main-container']/ng-outlet/rxms-patient-order-status/div/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String DataEntryPageTitle = "//*[@id='div-rx-entry']/rxms-main-patient-toolbar/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String DataReviewPageTitle = "//*[@id='rxms-main-container']/ng-outlet/rxms-main-data-review/div/div[1]/rxms-data-review-patient-toolbar/div/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String prescriberSearchPageTitle = "//*[@id='prescriber-search-tray']/md-toolbar/div/span[1]";
    public static final String patientOrderStatus_Alert_OK_Button = "//*[@id='main-data-entry-button-toolbar-cancel-confirm']/md-dialog-actions/button[1]";
    public static final String intakeMethod_CancelButton = "//*[@id='scanrx-button-cancel']";
    public static final String DENumberofTasks = "//*[@id='main-right-sidenav-burger-menu-DE']/div[2]/span[1]";
    public static final String DRNumberofTasks = "//*[@id='main-right-sidenav-burger-menu-DR']/div[2]/span[1]";
    public static final String fillingTaskNumber = "//*[@id='main-right-sidenav-burger-menu-FILL']/div[2]/span[1]";
    public static final String Radio_phone = "//*[@id='scanrx-radio-phone']";
    public static final String Radio_fax = "//*[@id='scanrx-radio-fax']";
    public static final String CETaskNumber = "//*[@id='main-right-sidenav-burger-menu-CE']/div[2]/span[1]";
    //public static final String CE_selectAll_TherapyReview = "//*[@id='select-all']/div[2]/ng-bind-html";
    public static final String CE_selectAll_TherapyReview = "//*[@id='select-all']";
    public static final String CE_OverrideButton = "//*[@id='override-button']";
    public static final String FillingTask_Message = "md-dialog-content-body";
    public static final String FillingTask_PopupOkButton = "md-confirm-button";
    public static final String CE_Alert_Yes_Button = "//*[@id='main-data-entry-button-toolbar-cancel-confirm']/md-dialog-actions/button[1]";
    public static final String No_Task_Alert_Button = "md-confirm-button";
    public static final String DE_CancelButton = "//*[@id='go-to-dashboard-cancel-button']";
    public static final String DE_Cancel_Alert_Yes_Btn = "//*[@id='main-data-entry-button-toolbar-cancel-confirm']/md-dialog-actions/button[1]";
    public static final String CE_Cancel = "//*[@id='cancel-button']";
    public static final String CE_StopCurrentTassk_OkButton = "//*[@id='dialog-button-confirm']";
    public static final String productVerificationPageTitle = "//*[@id='div-rx-entry']/ng-outlet/rxms-manual-entry/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    /********************************************** E2E *************************/

    public static final String Taskboard_navigation = "//*[@id='main-toolbar-buttonicon-navigation-panel']/md-icon";
    public static final String Refresh_button_Icon = "//*[@id='main-right-sidenav-burger-menu']/rxms-progress-bar/div/div/button/md-icon";
    public static final String Patient_Fax_RadioButton = "//*[@id='scanrx-radio-fax']";
    public static final String Patient_Phone_RadioButton = "//*[@id='scanrx-radio-phone']";
    public static final String Patient_Pickup_RadioButton = "//*[@id='scanrx-radio-pickup']";
    public static final String Patient_Scan_RadioButton = "//*[@id='scanrx-radio-scan']";
    public static final String Patient_Waiting_RadioButton = "//*[@id='scanrx-radio-waiting']";
    public static final String DE_Product_Error_Mandatory = "//*[@id='product-info']/div[1]/div[1]/md-input-container/div[2]";
    public static final String DE_Without_Product_Mandatory_Feild = "//*[@id='product-information-card']";
    public static final String DE_Plan_Paycode_One = "//*[@id='pay-code']//span[1]";
    /****************************************************************************
     * Method :
     *
     * author :
     *
     * Date :
     *
     * Modifier :
     *
     * Modification Data :
     *
     ******************************************************************************/


    public static final String DR_SCREEN_CLOSE_BTN = "//*[@id='donut-popup-dialog']/md-toolbar/div/button/md-icon";
    public static final String DRUG_DETAILS_GENERALINFO_TAB = "//*[contains(text(),'General Info')]";//*[@id="tabs-0"]/div


    //*****************************************JP ****************************************
    public static final String DRUG_DETAILS_CLINICAL_REFERENCE = "//*[contains(text(),'Clinical References')]";//*[@id='tabs-8']/div
    public static final String PRIENT_PATIENT_HANDOUT = "//*[@id='product-details-button-bar-print']";
    public static final String PRIENT_PATIENT_HANDOUT_POPUP_FUNCTION_UNAVAILABLE = "//*[contains(text(),'Function Unavailable')]";
    public static final String PRIENT_PATIENT_HANDOUT_ICPLUS = "//*[contains(text(),'This function cannot be completed in this system.  Please complete in IC+.')]";
    public static final String PRIENT_PATIENT_HANDOUT_POPUP_OK_BTN = "//*[@aria-label='Ok Button']";
    public static final String DRUG_DETAILS_PAGE_DRUG_TYPE = "//*[@id='drug-type']";
    public static final String ADMIN_EMPID_FIELD_X_ICON = "//*[@id='user-management-search-buttonicon-cancel']/md-icon";
    public static final String ADMIN_NO_RESULT_FOUND_TXT = "//*[@id='rxms-main-container']/ng-outlet/rxms-role-main/div/md-content/div/md-content/rxms-user-management/div/form/div[2]/div[2]";
    public static final String PWD_VALIDATION_LESSTHAN_8_CHAR = "//*[contains(text(),'The password has to be at least 8 characters long.')]";
    public static final String PWD_DOES_NOT_MATCH = "//*[@id='user-management-form']/div/div/md-card/md-card-content/div[2]/div";
    public static final String INVALID_PWD = "//*[@id='user-management-form']/div/div/md-card/md-card-content/div[1]/div[1]/md-input-container[1]/div[2]/div";
    public static final String PWD_VALIDATION_WITHOUT_NUMERIC_LOWER_UPER = "//*[contains(text(),'The password must be at least 8 characters long, including at least one uppercase letter, one lower case letter and at least one numeric.')]";
    public static final String PATIENT_ORDER_STATUS_ICON = "//*[@id='main-left-sidenav-burger-menu']/md-list/md-list-item[6]";
    public static final String PATIENT_ORDER_STATUS_LASTNAME_TXT = "//*[@id='patient-order-status-input-lastname']";
    public static final String PATIENT_ORDER_STATUS_SEARCH_BTN = "//*[@id='patient-order-status-button-search']";
    public static final String PATIENT_CASH_WITH_PLAN = "//*[starts-with(@id,'single-prescription-00000001457-1')]/div[6]/*[contains(text(),'$5.00')]";
    public static final String PATIENT_CASH_WITH_PLANS = "//*[starts-with(@id,'single-prescription-00000001457-1')]/div[6]/*[contains(text(),'AETNA')]";
    public static final String PWD_RESET_MSG_USE_ALT_R = "";
    public static final String PWD_X_ICON = "";
    public static final String LOGOUT_BTN = "//*[@id='main-left-sidenav-button-logout']/div[2]";
    public static final String LOGOUT_ALL_DEVICE = "//*[@id='bottom-tray']/md-toolbar/div/ng-transclude/button[2]";
    public static final String LOGOUT_THIS_DEVICE = "//*[@id='bottom-tray']/md-toolbar/div/ng-transclude/button[1]";
    public static final String LOGOUT_CANCEL = "//*[@id='bottom-tray']/md-toolbar/div/ng-transclude/button[3]";
    public static final String LOGIN_TXT = "//*[@id='login-card']/md-card-content/h2/strong";
    public static final String NOTIFICATION_TXT = "";
    public static final String TASK_REFRESH_BTN = "//*[contains(text(),'autorenew')]";
    public static final String DATA_ENTRY_TAB = "//*[@id='main-right-sidenav-burger-menu-DE']/div[1]";
    public static final String NO_TASK_AVAILABLE_POPUP_H = "//h2[contains(text(),'No Tasks Available')]";
    public static final String NO_TASK_PLS_CHOOSE_ANOTHER_TASK = "//p[contains(text(),'Please choose another task.Please choose another task.')]";
    public static final String COMMENTS_ICON = "//*[@id='comments-icon']";
    public static final String HIDE_COMMENTS = "//*[@id='sidenav-comments']/div[1]/button/ng-bind-html";
    public static final String ADD_COMMENTS_ICON = "//*[@id='sidenav-comments']/div[2]/button/md-icon";
    public static final String COMMENTS_POPUP_MSG = "//*[contains(text(),'This function cannot be completed in this system.  Please complete in IC+.')]";
    public static final String PATIENT_3RD_PLAN_ICON = "//*[@id='tabs-1']";
    public static final String PATIENT_3RD_PLANS = "//*[@id='patient-plan-form']/div/div";
    public static final String PATIENT_3RD_PARTY_PLANS = "//*[contains(@id,'standard-plan-form-')]";
    public static final String PATIENT_NO_PLANS = "//*[@id='patient-plan']/rxms-patient-plan/div/div/div[2]";
    public static final String PLAN_TAB = "//*[@id='main-left-sidenav-button-Plan']/div[2]/span";
    public static final String PLAN_ID_SEARCH_FIELD = "//*[@id='input-planid-plan']";
    public static final String PLAN_ID_SEARCH_FIELD_CONTAINER="//*[@id='plan-search-form']/md-input-container[3]";
    public static final String PLAN_SEARCH_BTN = "//*[@id='plan-search-button-search']";
    public static final String PLAN_SEARCH_RESULT = "//*[contains(text(),'Plan Search Results')]";
    public static final String PLAN_NAVIGATE_BACK_BTN = "//*[@id='back-button-plan-search']/md-icon";
    public static final String NO_TASK_AVAILABLE_POPUP_OK_BTN = "/html/body/div[2]/md-dialog/md-dialog-actions/button/ng-bind-html";
    public static final String EMP_INFO = "//*[contains(text(),'Employee Information')]";
    public static final String LICENSE_CERTIFICATION = "//*[contains(text(),'License & Certification')]";
    public static final String ASSIGNED_STORE = "//*[contains(text(),'Assigned Stores')]";
    public static final String EMP_UPDATE_LNK = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-member-profile/md-content/md-card[1]/md-card-content/div/div[2]/div/a";
    public static final String EMP_CLOSE_BTN = "";
    public static final String LICENSE_UPDATE_LNK = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-member-profile/md-content/md-card[2]/md-card-content/div/div[2]/a";
    public static final String LICENSE_CLOSE_BTN = "";
    public static final String TEAM_MEMBER_ROLE_H = "//*[contains(text(),'Roles')]";
    public static final String TEAM_MEMBER_ROLE1 = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-member-profile/md-content/md-card[1]/md-card-content/div/div[2]/md-list/md-list-item[1]/p";
    public static final String TEAM_MEMBER_ROLE2 = "//*[contains(text(),'Techfullaccesscmsuser')]";
    public static final String TEAM_MEMBER_ROLE3 = "//*[contains(text(),'Techfullaccessworkflowuser')]";
    public static final String CHECK_ICPLUS = "//*[contains(text(),'Check IC+')]";
    public static final String POS_patientNames = "//*[starts-with(@id,'patient-0')]";
    //	public static final String Prescriber_SelectButton = "//*[@id='main-data-prescriber-sidenav-button-select']";
//	public static final String Prescriber_LastName = "//*[@id='prescriber-information-card']//input[@id='last-name']";
//	public static final String Prescriber_FirstName = "//*[@id='prescriber-information-card']//input[@id='first-name']";
    public static final String PATIENT_ORDER_TAB = "//*[@id='main-left-sidenav-button-PatientOrderStatus']/div[2]/span";
    public static final String PATIENT_TAB = "//*[@id='main-left-sidenav-button-Patient']/div[2]/span";
    public static final String PLAN__TAB = "//*[@id='main-left-sidenav-button-Plan']/div[2]/span";
    //public static final String DRUG_TAB = "//*[@id='main-left-sidenav-button-Drug']/div[2]/span";
    public static final String DRUG_TAB = "//*[@id='main-left-sidenav-button-Drug']";
    public static final String PRESCRIBER_TAB = "//*[@id='main-left-sidenav-button-Prescriber']/div[2]/span";
    public static final String ADMIN_TAB = "//*[@id='main-left-sidenav-button-RoleManagement']/div[2]/span";
    public static final String LOGOUT_TAB = "//*[@id='main-left-sidenav-button-logout']/div[2]/span";
    public static final String DASHBOARD_TAB = "//*[@id='main-left-sidenav-burger-menu']/md-list/md-list-item[1]";
    public static final String LOGO = "/html/body/rxms-app/ng-outlet/rxms-main/a/img";
    public static final String PERFORM_DATAENTRY = "//*[@id='dialogContent_donut-popup-dialog']/div/rxms-donut-chart/rxms-donut-chart-data-entry/button/span";
    public static final String SEND_ICPLUS = "//*[@id='main-data-entry-button-toolbar-sendtoicplus']";
    public static final String SELECT_STATE = "//*[@id='data-entry-prescriber-sidenav']//md-select-value/span[2]";
    public static final String PLAN_SEARCH_BIN = "//*[@id='input-bin-plan']";
    public static final String PLAN_SEARCH_BIN_CONTAINER="//*[@id='plan-search-form']/md-input-container[1]";
    public static final String PLAN_SEARCH_PCN = "//*[@id='input-pcn-plan']";
    public static final String PLAN_SEARCH_PCN_CONTAINER="//*[@id='plan-search-form']/md-input-container[2]";
    public static final String PLAN_SEARCH_PLAN_NAME = "//*[@id='input-plan-name-plan']";
    public static final String PLAN_SEARCH_PLAN_NAME_CONTAINER="//*[@id='plan-search-form']/md-input-container[4]";
    public static final String PRESCRIBER_VALIDATION_MSG = "//*[@id='prescription-search-prescriber-form']/div[3]/div/div/div/span";
    public static final String PRESCRIBER_PHONE = "//*[@id='phone']";
    public static final String PRESCRIBER_NPI_DEA = "//*[@id='data-entry-prescriber-sidenav']//*[@id='npidea']";
    public static final String CANCEL_BTN = "//*[@id='dialog-button-cancel']";
    public static final String TX = "//*[contains(text(),'TX')]";
    public static final String REMS_POP_UP = "//*[@id='dialogContent_donut-popup-dialog']/div/p[1]";
    public static final String Finish = "//*[@id='scanrx-button-finish']";
    public static final String Clinical_check_product_RXnumber = "//*[@id='rx-number']";
    public static final String Clinical_Check_Product_Original_Date = "//*[@id='orig-data']";
    public static final String Clinical_Check_Product_Prescribed_Drug = "//*[@id='prescribed-drug']";
    public static final String Clinical_Check_Product_Directions_Feild = "//*[@id='directions']";
    public static final String Clinical_Check_Product_RX_Expiration_Date = "//*[@id='rx-exp-date']";
    public static final String Clinical_Check_Product_Qty = "//*[@id='qty']";
    public static final String Clinical_Check_Product_Refills = "//*[@id='refills']";
    public static final String Clinical_Check_Product_Daw_Filled = "//*[@id='daw-filled']";
    public static final String Clinical_Check_Product_Substitute_Filled = "//*[@id='substitute-filled']";
    public static final String Clinical_Check_Last_Fill_Date = "//*[@id='last-fill-date']";
    public static final String Clinical_Check_Allergies_Popup_Displayed_Feild = "//*[@id='patient-al-hc-popup']/rxms-secondary-toolbar/md-toolbar";
    public static final String Clinical_Check_Health_Popup_Displayed_Feild = "//*[@id='patient-al-hc-popup']/rxms-secondary-toolbar/md-toolbar";
    public static final String Patient_Profile_Intake_Walkin_ScanRx_Feild = "//*[@id='intake-tabs']/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item";
    public static final String Patient_Profile_Intake_Empty_Button = "//*[@id='buttons-bar']/md-toolbar/div";
    /*************************************Clinical Evaluation***********************************************************/
    public static final String Clinical_Check_Dispended_Drug_Name_label = "//*[@id='rx-details-card']/md-card-content/div/div[1]/md-input-container[1]/label";
    public static final String Clinical_Check_Dispended_Drug_Feild = "//*[@id='dipensed-drug']";
    public static final String Clinical_Check_RXnumber_Label = "//*[@id='rx-details-rxnumber-button']";
    public static final String Clinical_Check_RXnumber_Feild = "//*[@id='rx-number']";
    public static final String Clinical_Check_Quantity_Display_Label = "//*[@id='rx-details-card']/md-card-content/div/div[3]/div/div/div[1]/md-input-container/label";
    public static final String Clinical_Check_Quantity_Disp_feild = "//*[@id='qty-disp']";
    public static final String Clinical_Check_Days_Supply_Label = "//*[@id='rx-details-card']/md-card-content/div/div[3]/div/div/div[2]/md-input-container/label";
    public static final String Clinical_Check_Days_Supply_Feild = "//*[@id='day-supply']";
    public static final String Clinical_Check_Directions_Label = "//*[@id='rx-details-card']/md-card-content/div/div[1]/md-input-container[2]/label";
    public static final String Clinical_Check_Directions_Feild = "//*[@id='directions']";
    public static final String Clinical_Check_Prescriber_Label = "//*[@id='rx-details-card']/md-card-content/div/div[2]/md-input-container[2]/label";
    public static final String Clinical_Check_Prescriber_Feild = "//*[@id='prescriber']";
    public static final String Clinical_Check__Last_Fill_Date_Label = "//*[@id='rx-details-card']/md-card-content/div/div[3]/md-input-container[1]/label";
    public static final String Clinical_Check__Last_Fill_Feild = "//*[@id='last-fill-date']";
    public static final String Clinical_Check_Phone_Label = "//*[@id='rx-details-card']/md-card-content/div/div[2]/md-input-container[3]/label";
    public static final String Clinical_Check_Phone_Feild = "//*[@id='phone']";
    public static final String Clinical_Check_Thearapeutic_Class_Label = "//*[@id='rx-details-card']/md-card-content/div/div[3]/md-input-container[2]/label";
    public static final String Clinical_Check_Thearapeutic_Feild = "//*[@id='therapeutic-class']";
    public static final String Clinical_Check_Rxdetails_Total_Content_Screen = "//*[@id='rx-details-card']/md-card-content";
    public static final String Demographic = "//*[contains(text(),'Demographic')]";
    public static final String AllergiesHealthConditions = "//*[contains(text(),'Clinical Information')]";
    public static final String PlanSummary = "//*[contains(text(),'Plan Summary')]";
    public static final String RxPreferences = "//*[@id='patient-plan']/rxms-patient-preferences-view/md-card/div[1]";
    public static final String NO_DISPENSED_DRUG = "//*[contains(text(),'No dispensed drug identified')]";
    public static final String SUBSTITUTE = "//*[@id='substitute']";
    public static final String Preferences = "//*[@id='tabs-2']/div/ng-bind-html";
    public static final String Dataentry_Page_Prescriber_View_Button = "//*[@id='main-data-prescriber-sidenav-button-view']";
    public static final String Dataentry_Page_Prescriber_Page_Details = "//*[@id='update-prescriber']/md-content/div";
    public static final String Dataentry_Page_Prescriber_Details_Back_Button = "//*[@id='back-button-prescriber-details']/md-icon";
    public static final String Dataentry_Page_Prescriber_Page_General_Info_Details = "//*[@id='prescriber-general-info-card']";
    public static final String Dataentry_Page_Prescriber_Page_Location_Communication = "//*[@id='prescriber-update-location-card']";
    public static final String Clinical_Evaluation_Allergies_Field = "//*[@id='div-rx-entry']/md-content/div[1]/rxms-patient-allergies-health-conditions/md-card/md-card-content/div/div[1]";
    public static final String Clinical_Evaluation_HealthCondition_Field = "//*[@id='div-rx-entry']/md-content/div[1]/rxms-patient-allergies-health-conditions/md-card/md-card-content/div/div[2]";
    public static final String Clinical_Evaluation_Allergies_Popup_Lastdate = "//*[@id='allergies-container']//div/span/small/i";
    public static final String Clinical_Evaluation_Elderly_Patient_Field = "//div/span[contains(text(), 'ELDERLY indicates using CAUTION with ADVIL PM TABLETS')]";
    public static final String Clinical_Evaluation_Elderly_Patient_Message_Displayed = "//div[contains(text(), 'ELDERLY indicates using CAUTION with ADVIL PM TABLETS')]";
    public static final String Clinical_Evaluation_Health_Conditions_Link = "//*[@id='div-rx-entry']/md-content/div[1]/rxms-patient-allergies-health-conditions/md-card/md-card-content/div/div[2]/md-input-container/label/button";
    public static final String Clinical_Evaluation_Allergies_Link = "//*[@id='div-rx-entry']/md-content/div[1]/rxms-patient-allergies-health-conditions/md-card/md-card-content/div/div[1]/md-input-container/label/button";
    public static final String Clinical_Evaluation_Allergies_Confirm_Patient = "//*[@id='div-rx-entry']/md-content/div[1]/rxms-patient-allergies-health-conditions/md-card/md-card-content/div/div[1]/md-content/div";
    public static final String Clinical_Evaluation_Health_Conditions_Confirm_Patient = "//*[@id='div-rx-entry']/md-content/div[1]/rxms-patient-allergies-health-conditions/md-card/md-card-content/div/div[2]/md-content/div";
    public static final String Clinical_Evaluation_Allergies_Popup_Close_Button = "//*[@id='patient-al-hc-popup']//*[@id='bottom-tray']/md-toolbar/div/ng-transclude/button";
    public static final String Clinical_Evaluation_Health_Condition_Popup_Close_Button = "//*[@id='patient-al-hc-popup']//*[@id='bottom-tray']/md-toolbar/div/ng-transclude/button";
    public static final String ROLE_MANAGEMENT_SEARCH_FIELD = "//*[@id='role-management-input-search']";
    public static final String ROLE_MANAGEMENT_ROLES_ROW_1 = "//*[@id='role-management-list']/md-list-item/div/div[1]/div[1]";
    public static final String ROLE_MANAGEMNT_ROLE_NAME_COLUMN = "//*[@id='mdlist-header']/div[1]";
    public static final String ROLE_MANAGEMNT_ROLE_DESCRIPTION_COLUMN = "//*[@id='mdlist-header']/div[2]";
    //Store HOURS PHARMACY INFO SECTIONS
    public static final String DASHBOARD_PHARMACY_INFORMATION_SECTION = "//*[@id='empty-global-search-list-div-container']/rxms-pharmacy-information";
    public static final String DASHBOARD_USEFUL_LINKS_SECTION = "//*[@id='empty-global-search-list-div-container']/rxms-useful-links/md-card/md-card-content";
    public static final String STORE_INFO_PHARMACY_HOURS = "//*[@id='home-store-information-form']/md-content/div/div/div[2]/div[1]";
    public static final String STORE_INFO_STORE_HOURS = "//*[@id='home-store-information-form']/md-content/div/div/div[2]/div[3]";
    public static final String STORE_INFO_PHARMACY_INFORMATION = "//*[@id='home-store-information-form']/md-content/div/div/div[1]/div[1]";
    public static final String STORE_INFO_PHARMACY_INVENTORY_INFO = "//*[@id='home-store-information-form']/md-content/div/div/div[1]/div[3]";
    public static final String drug_view_size = "//*[@id='product-information-checkbox-viewsize']/div[2]";
    public static final String drug = "//*[contains(text(),'Advil 200mg Gel Caplets 200')]";
    //Hard Coded Xpaths
    public static final String PHARMACIST_ROLE_FROM_LIST = "//*[@id='role-management-list'][3]/md-list-item/div/button";
    public static final String UPDATE_BUTTON_STRING_XPATH = "*//a[contains(text(),'Update')]";
    public static final String ACTIVATE_BUTTON_STRING_XPATH = "//button[contains(text(),'ctivate')]";
    public static final String CLOSE_BUTTON_STRING_XPATH = "//button[contains(text(),'lose')]";
    public static final String DEACTIVATE_BUTTON_STRING_XPATH = "//button[contains(text(),'eactivate')]";
    public static final String OK_BUTTON_STRING_XPATH = "//button[contains(text(),'k')]";
    public static final String XPATH_TECHNICIAN_ROLE = "//*[@id='role-management-list'][5]/md-list-item/div/button";
    public static final String XPATH_PRESCRIBER_ROLE_IN_DROPDOWN = "//*[@id='select_option_7']";
    public static final String De_Product_State_Refill_Error = "//*[@id='prescription-rx-product-create-form']/div[5]/md-input-container[3]/div[2]/div";
    public static final String Third_paty_plan_Title ="//*[@id='standard-plan-form-0']/div[2]/div/div[1]/div[1]/span";
    public static final String plan_search_rows="//*[@id='plan-search']/table/tbody/tr";
    public static String NoStateLocator(String id) {
        String NoStateId = "select_option_" + id;
        return NoStateId;
    }
}

