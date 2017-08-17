package intake;

public class IntakeConstants {

	// constants for intake image manipulation
	public static String IMAGE_ANNOTATION_BUTTON = "//md-toolbar//*[contains(text(),'rotate_right')]/../preceding-sibling::button/md-icon";

	public static String IMAGE_ROTATE_RIGHT_BUTTON = "//md-toolbar//*[contains(text(),'rotate_right')]";
	public static String IMAGE_ROTATE_LEFT_BUTTON = "//md-toolbar//*[contains(text(),'rotate_left')]";
	public static String IMAGE_ZOOM_IN_BUTTON = "//md-toolbar//*[contains(text(),'zoom_in')]";
	public static String IMAGE_ZOOM_OUT_BUTTON = "//md-toolbar//*[contains(text(),'zoom_out')]";
	public static String IMAGE_RESTORE_BUTTON = "//md-toolbar//*[contains(text(),'restore')]";
	public static String IMAGE_FULL_SCREEN_BUTTON = "//md-toolbar//*[contains(text(),'fullscreen')]";
	public static String IMAGE_PREVIEW = "//div/md-dialog/md-toolbar/div/h2[contains(text(),'Image Preview')]";
	public static String IMAGE_CLOSE_BUTTON = "//button//span[contains(text(),'Close')]";
	public static String VIEW_ALL_BUTTON ="//md-toolbar//*[contains(text(),'View All')]";
	public static String CLOSE_BUTTON ="//md-toolbar//*[contains(text(),'Close')]";
	public static String IMAGE_FRONT_INTAKE_FINISH_SCREEN = "//one-image-viewer/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]//md-tabs-content-wrapper[1]/md-tab-content[1]/div/md-card/md-card-content/div/div/div/div[1]/div/img";
	public static String IMAGE_BACK_INTAKE_FINISH_SCREEN = "//one-image-viewer/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]//md-tabs-content-wrapper[1]/md-tab-content[2]/div/md-card/md-card-content/div/div/div/div[1]/div/img";
	public static String IMAGE_INTAKE_FINISH_SCREEN_BACK_BUTTON = "//one-image-viewer/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]//md-tabs-wrapper//md-pagination-wrapper//span[contains(text(),'Back')]";

	public static String PATIENT_ADD_UPDATE_MESSAGE_POPUP = "//md-dialog//p[contains(text(),'This function cannot be completed in this system.  Please complete in IC+.')]";
	public static String NOTES = "//md-toolbar//*[contains(@class,'scrollable-notes')]/div";
	public static final String RADIO_PICKUPLATER = "//*[@id='scanrx-radio-pickup']";
	public static final String PICKUPLATER_TODAYSDATE ="//*[@id='pickup-later-button-date-0']";
	public static final String PICKUPLATER_TOMORROWDATE = "//*[@id='pickup-later-button-date-1']";
	public static final String PICKUPLATER_TIME = "//*[@id='scanrx-form']//md-card-content/div/rxms-pickup-later/div/div[5]/md-input-container/md-select//span[1]";
	// constants from landing page.
	public static final String LANDINGPAGE = "//*[@id='main-dashboard']";
	public static final String LANDINGPAGE_LEFT_NAV = "//*[@id='main-left-sidenav-burger-menu']";
	public static final String LANDINGPAGE_RIGHT_TASK_BAR = "//*[@id='main-right-sidenav']";
	public static final String LANDINGPAGE_PHARMACY_INFORMATION_SECTION = "//*[@id='pharmacy-information-card']";
	public static final String LANDINGPAGE_PHARMACY_STORE_NUMBER = "//*[@id='pharmacy-information-card']/md-card-content/div[2]/div[1]/h5[1]/a";
	public static final String LANDING_PHARMACY_HOURS_SECTION = "//*[@id='pharmacy-information-card']/md-card-content/div[2]/div[1]/h5[2]";
	public static final String LANDINGPAGE_PHARMACY_INFO = "//*[@id='pharmacy-info']";
	public static final String LANDINGPAGE_PHARMACY_HOURS = "//*[@id='pharmacy-hours']/div[1]";

	//constants for Drug Search
	public static final String USER_INITIALS = "//*[@id='main-left-sidenav-button-team-member']/div[1]/span/label";
	public static final String DRUGSEARCH_BACK_BUTTON = "//*[@id='back-button-drug-search']/md-icon"; 
	public static final String Drug_search_field="//*[@id='search-text']";
	public static final String Drug_search_view="//*[@id='bottom-tray']/md-toolbar/div/ng-transclude/button";
	public static final String Drug_search_button="//*[@id='product-search-button-search']";
	public static final String Drug_search_result="//*[@id='scrollbar-table-product-result']";
	public static final String Drug_back_button="//*[@id='back-button-drug-search']/md-icon";
	//public static final String Drug_search_drug_result="//div[contains(@data-title,'Drug Name')]";
	public static final String DRUG_DETAIL_BACK_BUTTON = "//*[@id='back-button-drug-details']";
	public static final String Drug_search_drug_result="//*[@id='product-list']/table/tbody/tr[1]/td[1]";
	public static final String Drug_view_details="//*[@id='product-list']"; 
	public static final String Drug_view_result="//*[@id='product-details']/div/md-card[1]";
	public static final String Drug_search_errormsg="//*[@id='product-error-div']/p"; 
	public static final String Drug_first_result="//*[@id='scrollbar-table-product-result']/div[1]/div/div[1]/div";
	public static final String Drug_Quick_code="//*[@id='drug-quickcode']";
	public static final String Drug_search_Product_name="//*[@id='rxms-main-container']/ng-outlet/rxms-product-search/div/div[2]/ng-outlet/rxms-product-tab-manager-empty/ng-outlet/rxms-product-tab-manager/div/rxms-secondary-toolbar/md-toolbar/div/ng-transclude/div/md-input-container[1]";
	public static final String Drug_search_package_size="//*[@id='drug-pkgsize']";
	public static final String Drug_search_NDC="//*[@id='drug-ndc']";
	public static final String Drug_search_WIC="//*[@id='drug-wic']";
	public static final String Drug_search_linked_products="//*[@id='product-list']/div/div[1]/div/div[2]/md-checkbox/div[1]";
	//public static final String Drug_search_result_error="//*[@id='product-list']/div/div[1]/div/div[2]/div[2]";
	public static final String Drug_search_result_error="//*[@id='rxms-main-container']/ng-outlet/rxms-product-search/div/ng-outlet/rxms-product-list/div/div[1]/div/div[2]/div[2]";
	public static final String Drug_search_page="//*[@id='rxms-main-container']/ng-outlet/rxms-product-search/div/rxms-secondary-toolbar/md-toolbar/div/span[1]";

	//constants for Patient Profile
	public static final String COMMENTS_BUTTON = "//*[@id='patient-tab-manager-container']/rxms-secondary-toolbar/md-toolbar/div/ng-transclude/rxms-view-patient-information/div/div/button";
	public static final String COMMENTS_BOX = "//*[@id='sidenav-comments']";
	public static final String COMMENTS_BOX_MESSAGE = "//*[@id='sidenav-comments']/md-content/div/span";

	// constants from store information page.
	public static final String STORE_INFORMATION_PAGE = "//*[@id='home-store-information-form']/rxms-secondary-toolbar/md-toolbar/div/span[1]";
	public  static final String STORE_INFORMATION_PAGE_PHARMACY_INFO_SECTION = "//*[@id='home-store-information-form']/md-content/div/div/div[1]/div[1]/md-card/md-card-header";
	public static final String STORE_INFORMATION_PAGE_PHARMACY_INFO = "//*[@id='home-store-information-form']/md-content/div/div/div[1]/div[1]/md-card/md-card-content";


	public static final String STORE_INFORMATION_PAGE_PHARMACY_HOURS_SECTION = "//*[@id='home-store-information-form']/md-content/div/div/div[2]/div[1]/md-card/md-card-header";
	public static final String STORE_INFORMATION_PAGE_PHARMACY_HOURS = "//*[@id='home-store-information-form']/md-content/div/div/div[2]/div[1]/md-card/md-card-content/div[1]/div[1]";


	public static final String STORE_INFORMATION_PAGE_LICENSE_ID_SECTION = "//*[@id='home-store-information-form']/md-content/div/div/div[1]/div[2]/md-card/md-card-header";
	public static final String STORE_INFORMATION_PAGE_LICENSE_ID = "//*[@id='home-store-information-form']/md-content/div/div/div[1]/div[2]/md-card/md-card-content";
	public static final String STORE_INFORMATION_PAGE_LICENSE_ID_PROTOCOL_PRESCRIBER = "//*[@id='home-store-information-form']/md-content/div/div/div[1]/div[2]/md-card/md-card-content/dl";

	public static final String STORE_INFORMATION_PAGE_HEALTH_CLINIC_HOURS_SECTION = "//*[@id='home-store-information-form']/md-content/div/div/div[2]/div[2]/md-card/md-card-header";
	public static final String STORE_INFORMATION_PAGE_HEALTH_CLINIC_HOURS = "//*[@id='home-store-information-form']/md-content/div/div/div[2]/div[2]/md-card/md-card-content/div[1]";


	public static final String STORE_INFORMATION_PAGE_STORE_HOURS_SECTION = "//*[@id='home-store-information-form']/md-content/div/div/div[2]/div[3]/md-card/md-card-header";
	public static final String STORE_INFORMATION_PAGE_STORE_HOURS = "//*[@id='home-store-information-form']/md-content/div/div/div[2]/div[3]/md-card/md-card-content/div[1]";

	public static final String STORE_INFORMATION_PAGE_PHARMACY_INVENTORY_INFORMATION_SECTION = "//*[@id='home-store-information-form']/md-content/div/div/div[1]/div[3]/md-card/md-card-header";
	public static final String STORE_INFORMATION_PAGE_PHARMACY_INVENTORY_INFORMATION = "//*[@id='home-store-information-form']/md-content/div/div/div[1]/div[3]/md-card/md-card-content";

	public static final String STORE_INFORMATION_PAGE_GENERAL_INFORMATION_SECTION = "//*[@id='home-store-information-form']/md-content/div/div/div[1]/div[4]/md-card/md-card-header";
	public static final String STORE_INFORMATION_PAGE_GENERAL_INFORMATION = "//*[@id='home-store-information-form']/md-content/div/div/div[1]/div[4]/md-card/md-card-content";

	public static final String PATIENT_ORDER_STATUS_DROP_DOWN_MENU = "//md-select-menu[@class='_md md-material-theme']//md-option";

	public static final String PATIENT_ORDER_STATUS_DROP_DOWN_ICON = "//*[@class='md-select-icon']";

	public static final String HOME_STORE_INFO_BUTTON_UPDATE = "//*[@id='home-store-info-button-update']";
	public static final String DATE_PICKERS = "//*[@id='date_pickers']";
	public static final String DATE_FROM = "//*[@id='date-from']";
	public static final String DATE_TO = "//*[@id='date-to']";


	// appDev11
	public static String DE_BUTTON_FOR_TASK_CHANGE = "//*[@id='main-right-sidenav-burger-menu-DE']//div//span[contains(text(),'DE')]";

	// get number of tasks
	public static String DE_TASK_NUMBER_TASK_BOARD = "//*[@id='main-right-sidenav-burger-menu-DE']//div/span[1]";
	public static String DR_TASK_NUMBER_TASK_BOARD = "//*[@id='main-right-sidenav-burger-menu-DR']//div/span[1]";
	public static String CE_TASK_NUMBER_TASK_BOARD = "//*[@id='main-right-sidenav-burger-menu-CE']//div/span[1]";
	public static String FILL_TASK_NUMBER_TASK_BOARD = "//*[@id='main-right-sidenav-burger-menu-FILL']//div/span[1]";
	public static String PV_TASK_NUMBER_TASK_BOARD = "//*[@id='main-right-sidenav-burger-menu-PV']//div/span[1]";

	public static String DE_TASK_BOARD = "//*[@id='main-right-sidenav-burger-menu-DE']";
	public static String DR_TASK_BOARD = "//*[@id='main-right-sidenav-burger-menu-DR']";
	public static String CE_TASK_BOARD = "//*[@id='main-right-sidenav-burger-menu-CE']";
	public static String FILL_TASK_BOARD = "//*[@id='main-right-sidenav-burger-menu-FILL']";
	public static String PV_TASK_BOARD = "//*[@id='main-right-sidenav-burger-menu-PV']";


	public static String TASK_BOARD_POP_UP = "//md-dialog";
	public static String TASK_BOARD_POP_UP_OK_BUTTON = "//md-dialog//button//strong/u[contains(text(),'O')]";

	public static String PATIENT_PROFILE_PATIENT_COMMENTS_SIDE_NAV = "//*[@id='sidenav-comments']";
	public static String PATIENT_PROFILE_PATIENT_COMMENTS_HIDE_BUTTON = "//*[@id='sidenav-comments']//div/button/md-icon[contains(text(),'insert_comment')]";
	public static String PATIENT_PROFILE_HIDE_COMMENTS_ICON = "//*[@id='sidenav-comments-icon']";

	public static String DASH_BOARD_ADMIN_BUTTON = "//*[@id='main-left-sidenav-button-RoleManagement']";
	public static final String PATIENT_SEARCH_ADD_NEW_BUTTON_CLICK_POPUP = "//*[@id='dialogContent_patient-search-dialog']/p";
	public static final String PATIENT_SEARCH_ADD_NEW_BUTTON_CLICK_POPUP_OK_BUTTON = "//*[@id='dialog-button-confirm']";
	public static final String PATIENT_SEARCH_ADD_NEW_BUTTON = "//*[@id='patient-add-button']";
	public static final String PATIENT_SEARCH_BACK_BUTTON = "//*[@id='back-button-patient-search']";
	public static final String PATIENT_SEARCH_DOB = "//*[@id='patient-datepicker']";
	public static final String PATIENT_SEARCH_DOB_INVALID_DATE_ERROR = "//*[@id='patient-search-datepicker']//div[contains(@class,'md-input-messages-animation')]/div";
	public static final String PATIENT_SEARCH_RESULTS_MESSAGE = "//*[@id='patients-results-external-div']//div/span[3]";
	public static final String PATIENT_SEARCH_SEARCH_CRITERIA_ERROR_MESSAGE = "//*[@id='patient-error-div']/p";
	public static final String PATIENT_SEARCH_GLOBAL_OPTION = "//*[@id='button-global']";
	public static final String PATIENT_SEARCH_DOB_FOCUSED = "//rxms-input-date//md-input-container[contains(@class,'md-input-focused')]";
	public static final String PATIENT_SEARCH_RESULTS_LIST = "//*[@id='patient-list']//tr[contains(@class,'ng-scope')]";
	public static final String PATIENT_SEARCH_RESULTS_FOCUSED_ROW = "//*[@id='patient-list']//tr[contains(@class,'selected')]";
	public static final String PATIENT_SEARCH_LABELS = "//md-input-container/label";
	public static final String PATIENT_SEARCH_ADDNEW_POPUP_SEARCH_ALL_STORES = "//*[@id='dialog-button-ok']";
	//tryingPOS
	public static String PATIENT_ORDER_STATUS_PATIENT_LIST = "//div[@id='patient-order-status-table']/md-content/div";

	// E2E

	public static String DR_SCREEN_FUNCTION_UNAVAILABLE_POP_UP = "//*[@id='hybrid-popup-title']";
	public static String DR_SCREEN_FUNCTION_UNAVAILABLE_POP_UP_CANCEL_BUTTON = "//md-dialog//button[contains(text(),'ancel')]";

	public static String DR_SCREEN_CAUTION_ALERT_POP_UP = "//*[@id='main-data-entry-quality-alert']";
	public static String DR_SCREEN_CAUTION_ALERT_POP_UP_OK_BUTTON = "//*[@id='main-data-entry-quality-alert']//button";
	public static String DE_SCREEN_PRESCRIBER_VIEW_BUTTON = "//*[@id='bottom-tray']//button[contains(text(),'Vie')]";
	public static String PRESCRIBER_DETAILS_GENERAL_INFO_SECTION = "//*[@id='prescriber-general-info-card']";//"//*[@id='prescriber-common-general-info-form']";
	public static String PRESCRIBER_DETAILS_LOCATION_COMMUNICATION_SECTION = "//*[@id='prescriber-update-location-card']";

	public static String PRESCRIBER_SEARCH_PAGE_DISPLAY = "//md-toolbar//span[contains(text(),'Prescriber Search')]";

	public static String PRESCRIBER_SEARCH_FIRST_NAME = "//*[@id='first-name']";
	public static String PRESCRIBER_SEARCH_LAST_NAME = "//*[@id='last-name']";
	public static String PRESCRIBER_SEARCH_SEARCH_BUTTON = "//*[@id='prescriber-search']";
	public static String PRESCRIBER_SEARCH_PAGE_STATE_SELECTION = "//*[@id='state']";
	public static String PRESCRIBER_SEARCH_PAGE_STATE_SELECTION_OPTIONS ="//md-select-menu/md-content/md-option";

	//public static String PRESCRIBER_SEARCH_PAGE_VIEW_BUTTON = "//*[@id='prescriber-search-results-button-view']";
	public static String PRESCRIBER_SEARCH_PAGE_VIEW_BUTTON = "//*[@id='prescriber-search-results-button-view']";

	public static String PATIENT_SEARCH_PAGE_SELECTABLE_RESULTS = "//div[contains(@class,'selectable-row')]";

	public static String PATIENT_PROFILE_INTAKE_PAGE = "//*[@id='patient-tab-manager-container']";

	// Constant file for Patient order status- Med History 

	public static final String MED_HISTORY_TAB = "//*[@id='tabs-4']";
	public static final String MEDICATION_HISTORY_HEADING = "//*[@id='patient-plan']/rxms-patient-med-history/div/h2";
	public static final String PATIENT_PROFILE_HEADING = "//*[@id='patient-tab-manager-container']/rxms-secondary-toolbar/md-toolbar/div/span[1]";
	public static final String clinical_checkIcon = "//*[@id='fab-menu']/div/div/md-toolbar/md-fab-actions/div/div/div[2]/div[3]/button";
	public static final String CLINICAL_CHECK_HOME = "//*[@id='fab-menu']/div/div/md-fab-trigger/button";
	public static final String AGREEMENT_CHECKBOX = "//*[@id='div-rx-entry']/md-content/div[2]/md-content/rxms-manual-dur/div/div/div[1]/div/md-checkbox/div[1]";
	public static final String OVERRIDE_BUTTON = "//*[@id='override-button']";
	public static final String MEDHISTORY_DOWN_ARROW_ICON = "//*[@id='down-arrow-icon-button-7']/md-icon";
	public static final String MEDHISTORY_UP_ARROW_ICON = "//*[@id='up-arrow-icon-button-7']/md-icon";
	public static final String MEDHISTORY_STATUS_HYPERLINK = "//*[contains(@id, 'rx-history-status-')]";
	public static final String GREEN_DOT_OVER_HYPERLINK = "//*[@id='rx-history-status-0']";
	public static final String GREEN_DOT = "//*[contains(@id, 'rx-history-item-list-')]/td[11]/div/div/span";//"//*[@id='rx-history-status-0']";
	public static final String DownArrow_Dynamic = "//*[contains(@id, 'down-arrow-icon-button-')]";//"//*[@id='down-arrow-icon-button-32']/md-icon";
	public static final String DownArrow_first = "//*[@id='down-arrow-icon-button-0']";
	public static final String DownArrow_second = "//*[@id='down-arrow-icon-button-1']";
	public static final String UpArrow_first = "//*[@id='up-arrow-icon-button-0']";
	public static final String UpArrow_second = "//*[@id='up-arrow-icon-button-1']";
	public static final String UPArrow_Dynamic= "//*[contains(@id, 'up-arrow-icon-button-')]";//"//*[@class='md-icon-button md-button md-material-theme md-ink-ripple ng-show']";
	public static final String Status_field_Pending_as_a_hyperlink="//*[contains(text(),'Pending')]";
	public static final String Status_field_In_Progress_as_a_hyperlink="//*[contains(text(),'In Progress')]";
	public static final String Patient_Order_Status_Highlighted_Row= "//*[contains(@id, 'patient-')]/td[5]";//"//*[@id='full-row-patient-00000001025']/div/div[2]/div[1]/div/div";
	public static final String Patient_Order_Status_Highlighted_PreviouslySelectedPatient= "//*[contains(@id, 'patient-')]/a/ng-bind-html";//"//*[@id='patient-00000001025']/div";
	public static final String expanded_medhistory_tab = "//*[@id='rx-history-details']/rxms-rx-history-details/div";

	//shiva
	public static final String Login_UserName="//*[@id='username-input']";
	public static final String password="//*[@id='password-input']";
	public static final String Login_Button ="//*[@id='login-button']";
	public static final String Dashbord_MenuButton = "//*[@id='main-left-sidenav-button-Prescriber']/div";
	public static final String home_Button = "//*[@id='main-left-sidenav-burger-menu']/md-list/md-list-item[1]";
	public static final String local_button = "//*[@id='button-local']";
	public static final String Patient_LeftMenuButton = "//*[@id='main-left-sidenav-button-Patient']";
	public static final String PATIENT_LEFTMENU_LINKICON = "//*[@id='main-left-sidenav-button-Patient']/div[1]/md-icon";
	public static final String Patient_LastName = "//*[@id='input-lname-patient']";
	public static final String Patient_FirstName = "//*[@id='input-fname-patient']"; 
	public static final String Patient_Phonenumber = "//*[@id='input-phone-patient']";
	public static final String Patient_DateOfBrith ="//*[@id='input_79']";
	public static final String Patient_SearchButton ="//*[@id='patient-submit']";
	public static final String Patient_ViewButton = "//*[@id='patient-view-button']";
	public static final String Intake_RxButton = "//*[@id='patient-view-button-bar-button-intake']";
	public static final String Rx_FinishButton = "//*[@id='scanrx-button-finish']";
	public static final String Last_Fill_Date_Col = "//*[contains(@id, 'rx-history-item-list-')]/td[6]";//"//*[@id='rx-history-table-lastfilldate']";

	public static final String MedHistory = "//*[@id='tabs-4']";
	public static final String NoRx_Message = "//*[@id='patient-rx-history-tab']/div[2]/span";
	public static final String radio_pickuplater = "//*[@id='pickup-later-button-date-0']/div/span[1]";
	public static final String pickup_date_tomorrow = "//*[@id='pickup-later-button-date-1']";
	public static final String pickup_time_dayAfterTomorrow = "//*[@id='pickup-later-button-date-2']";
	public static final String MedHistory_PageTitle = "//*[@id='patient-med-history']/h2";
	public static final String Preferences_Tab = "//*[@id='tabs-2']";
	public static final String Preferences_NoRxHistoryMessage ="//*[@id='patient-plan']/rxms-patient-preferences-view/md-card/div[2]/div[1]/div";
	public static final String preferences_PageTitle = "//*[@id='patient-plan']/rxms-patient-preferences-view/md-card/div[1]/strong";
	//public static final String pickup_date ="//*[@id='pickup-later-button-date-3']/div/span[2]";
	public static final String RxHistory_ExpandButton= "//*[@id='down-arrow-icon-button-7']";
	public static final String RxHistory_CollapseButton = "//*[@id='up-arrow-icon-button-7']";
	public static final String RxHistory_ExpandButtonClassName = "md-icon-button ng-show md-button md-material-theme md-ink-ripple";
	public static final String RxHistory_CollapseButtonClassName="";
	public static final String RxHistory_addToRefillButton= "//*[@id='rx-history-button-bar-button-refill']";
	public static final String RxHistory_ReprintButton= "//*[@id='rx-history-button-bar-button-reprint']";
	public static final String RxHistory_CloseRxButton="//*[@id='rx-history-button-bar-button-closerx']";
	public static final String RxHistory_TransferButton="//*[@id='rx-history-button-bar-button-transfer']";
	public static final String RxHistory_FunctionMessage="//*[contains(@id,'dialogContent_')]";
	public static final String DENumberofTasks = "//*[@id='main-right-sidenav-burger-menu-DE']/div[2]/span[1]";
	public static final String DRNumberofTasks = "//*[@id='main-right-sidenav-burger-menu-DR']/div[2]/span[1]";
	public static final String fillingTaskNumber = "//*[@id='main-right-sidenav-burger-menu-FILL']/div[2]/span[1]";
	public static final String CETaskNumber = "//*[@id='main-right-sidenav-burger-menu-CE']/div[2]/span[1]";
	public static final String PV_NumberofTasks = "//*[@id='main-right-sidenav-burger-menu-PV']/div[2]/span[1]";
	public static final String RxHistory_MedHistory_Title= "//*[@id='patient-plan']/rxms-patient-med-history/div/h2";
	public static final String RxHistory_DrugNameColumn="//*[@id='patient-rx-history-table-header-1']";
	public static final String RxHistory_PrescriberColumn="//*[@id='patient-rx-history-table-header-2']";
	public static final String RxHistory_RxNumberColumnN="//*[@id='patient-rx-history-table-header-3']";
	public static final String RxHistory_StoreNumberColumn="//*[@id='patient-rx-history-table-header-4']";
	public static final String RxHistory_LastFillDateColumn="//*[@id='patient-rx-history-table-header-5']";
	public static final String RxHistory_QtyDispColumn="//*[@id='patient-rx-history-table-header-6']";
	public static final String RxHistory_QtyRemColumn="//*[@id='patient-rx-history-table-header-7']";
	public static final String RxHistory_RefillsRemColumn="//*[@id='patient-rx-history-table-header-8']";
	public static final String RxHistory_expiryDateColumn="//*[@id='patient-rx-history-table-header-9']";
	public static final String RxHistory_StatusColumn="//*[@id='patient-rx-history-table-header-10']";
	public static final String dashboard_UserProfile_PageTitle = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-member-profile/md-content/md-card[1]/md-card-title/md-card-title-text/span";
	public static final String navigationPanel_HomeICon = "//*[@id='id-dashboard-button']/div[1]/md-icon";
	public static final String RxHistory_additional_MedHistory_tableHeader = "//*[@id='mdlist-header-additional-meds']";
	public static final String RxHistory_additional_MedHistory_tableheader_directions ="//*[@id='mdlist-header-additional-meds']/div[2]";
	public static final String RxHistory_AdditionalMedButton = "//*[@id='tabs-pat-med']/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]";
	public static final String RxHistory_AdditionalMeds_None = "//*[@id='mdlist-header-additional-meds']/div/span";//"//*[contains(@id,'tab-content-')]/div/rxms-patient-additional-meds/div/div/div/span";

	public static final String PATIENT_SEARCH_FORM_LASTNAME_INPUT = "//*[@id='input-lname-patient']";
	public static final String PATIENT_SEARCH_FORM_FIRSTNAME_INPUT = "//*[@id='input-fname-patient']";
	public static final String PATIENT_SEARCH_FORM_PHONE_NUMBER = "//*[@id='input-phone-patient']";
	public static final String PATIENT_SEARCH_FORM_DOB = "//*[@id='patient-datepicker']";
	public static final String PATIENT_SEARCH_FORM_SUBMIT_BUTTON = "//*[@id='patient-submit']";
	public static final String PATIENT_SEARCH_FORM_SEARCH_ERROR = "//*[@id='patient-error-div']/p";
	//public static final String PATIENT_SEARCH_FORM_FUTURE_DATE_ERROR = "//*[@id='patient-datepicker-container']/div[2]/div";
	public static final String PATIENT_SEARCH_FORM_FUTURE_DATE_ERROR = "//*[@id='patient-search-datepicker']/rxms-input-date/ng-form/md-input-container/div[2]/div";
	public static final String PATIENT_SEARCH_FORM_NO_RESULTS_MESSAGE = "//*[@id='patients-results-external-div']//div/div[2]/div[2]";
	public static final String PATIENT_SEARCH_FORM_RESULTS_FIRST_ROW  = "//*[@id='rx-patient-table']/div[1]";
	public static final String PATIENT_SEARCH_FORM_RESULTS_SELECTED_ROW_DEFAULT = "//*[@id='rx-patient-table']//div[contains(@class,'selectable-row')]";
	public static final String PATIENT_SEARCH_FORM_RESULTS = "//*[@id='rx-patient-table']/div";
	public static final String PATIENT_SEACH_FORM_ADD_NEW_BUTTON_CLICK = "//*[@id='patient-add-button']";
	public static final String PATIENT_SEARCH_FORM_UPDATE_BUTTON_CLICK = "//*[@id='patient-update-button']";
	public static final String PATIENT_PROFILE_BACK_BUTTON = "//*[@id='back-button-patient-profile']";
	public static final String PATIENT_SEARCH_FORM_PATIENT_RESULTS = "//div[contains(@id, 'patient-bk-')]/div[1]";
	public static final String PATIENT_SEARCH_FORM_RESULTS_NUMBER_TEXT = "//*[@id='patients-results-external-div']//div/div[2]/div[4]";
	public static final String PATIENT_SEARCH_FORM_PET_INDICATOR = "//md-content//div[2]/i[1]";
	public static final String PATIENT_VIEW_FORM_PET_INDICATOR = "//*[@id='patient-view-form']/md-card//div[3]/i";
	public static final String PATIENT_SEARCH_FORM_TWIN_INDICATOR = "//md-content//div[2]/div[1]//i[1]";
	public static final String PATIENT_VIEW_FORM_TWIN_INDICATOR = "//*[@id='patient-view-form']/md-card//div[3]/i";

	public static final String NAVIGATION_BAR_DASHBOARD_BUTTON = "//*[@id='id-dashboard-button']//div/span";
	public static final String NAVIGATION_BAR_PATIENT_BUTTON = "//*[@id='main-left-sidenav-button-Patient']//div/span";
	public static final String NAVIGATION_BAR_DRUG_BUTTON = "//*[@id='main-left-sidenav-button-Drug']//div/span";
	public static final String NAVIGATION_BAR_PRESCRIBER_BUTTON = "//*[@id='main-left-sidenav-button-Prescriber']//div/span";
	public static final String NAVIGATION_BAR_PLAN_BUTTON = "//*[@id='main-left-sidenav-button-Plan']//div/span";
	public static final String NAVIGATION_BAR_PATIENT_ORDER_STATUS_BUTTON = "//*[@id='main-left-sidenav-button-PatientOrderStatus']//div/span";
	public static final String HOMEPAGE_RXMS_HELP_LINK = "//rxms-useful-links//md-card-content//div/button/span";

	public static final String PlanSearch_BIN = "//*[@id='input-bin-plan']";
	public static final String PlanSearch_PCN = "//*[@id='input-pcn-plan']";
	public static final String PlanSearch_PLAN_ID = "//*[@id='input-planid-plan']";
	public static final String PlanSearch_PLAN_NAME = "//*[@id='input-plan-name-plan']";
	public static final String PlanSearch_BIN_Result = "//*[@id='plan-search']/table/tbody/tr[1]/td[1]"; //"//*[@id='singlerow-plan-0']/div[1]";
	public static final String PlanSearch_PCN_Result = "//*[@id='plan-search']/table/tbody/tr[1]/td[3]"; //"//*[@id='singlerow-plan-0']/div[2]";
	public static final String PlanSearch_PlanId_Result = "//*[@id='plan-search']/table/tbody/tr[1]/td[2]"; //"//*[@id='singlerow-plan-0']/div[3]";
	public static final String PlanSearch_BIN_PCN_Required_Error_Prompt = "//*[@id='plan-search-form']/md-input-container[1]/div[2]/div"; //"//div[contains(text(),'BIN is required when searching by PCN.')]";

	//HARD CODED XPATHs
	public static final String INTAKE_PATIENT_SEARCH_XPATH = "//rxms-patient-search/div";
	public static final String INTAKE_PRESCRIBER_SEARCH_XPATH = "//rxms-prescriber-search/div";
	public static final String INTAKE_PATIENT_ORDER_STATUS_XPATH = "//rxms-patient-order-status/div";
	public static final String INTAKE_DIALOG_XPATH = "//md-dialog";
	public static final String No_Rx_Preferences_Text = "//div[@class='padding-left-3x ng-binding layout-align-start-center layout-row' and contains(text(),'No Rx Preferences')]";
	public static final String allergies_and_health_conditions_text_box = "//*[@id='clinical-info-patient-view-container']/div[1]/div/div[2]/span";

	//Update Additional Rx
	public static final String UPDATE_PATIENT_POPUP = "//*[@id='patient-stepper-form']";
	public static final String UPDATE_PATIENT_POPUP_TEXT = "//*[@id='patient-stepper-dialog']/rxms-secondary-toolbar/md-toolbar/div/span[1]";
	public static final String UPDATE_PATIENT_ADDITIONAL_MEDS_TAB = "//*[@id='patient-stepper']/rxms-step[3]/rxms-step-header";
	public static final String ADDITIONAL_MEDS_RADIO_NO = "//*[@id='no-add-meds-taken']";
	public static final String ADDITIONAL_MEDS_RADIO_YES = "//*[@id='add-meds-taken']";
	public static final String ADDITIONAL_MEDS_DRUGSEARCH = "//*[@id='input-501']";
	public static final String ADDITIONAL_MEDS_DIRECTIONS = "//*[@id='patient-add-meds-directions-0']";

	//General Info Tab of Patient Profile  
	public static final String GENERAL_INFORMATION_SECTION = "//*[@id='clinical-info-patient-view-container']/div[1]/div/div[1]";
	public static final String GENERAL_INFORMATION_SECTION_MESSAGE = "//*[@id='clinical-info-patient-view-container']/div[1]/div/div[2]/span";
	public static final String PLAN_SUMMARY_SECTION = "//*[@id='patient-view-form']/md-card[3]/div[1]/div";
	public static final String PLAN_SUMMARY_SECTION_MESSAGE = "//*[@id='no-patient-primary-plan']";
	public static final String PATIENT_PROFILE_PET_INDICATOR_TEXT = "//*[@id='patient-view-form']/md-card[1]/div[2]/div[3]/div[2]";
	public static final String DECEASED_PATIENT_TEXT = "//*[@id='patient-view-form']/md-card[1]/div[2]/div[3]";
	public static final String VIEW_ALL_PLAN_LINK = "//*[@id='patient-view-form']/md-card[3]/div[3]/button";
	public static final String UPDATE_PATIENT_FIRST_NAME = "//*[@id='patient-add-demo-info-first-name']";
	public static final String UPDATE_PATIENT_LAST_NAME = "//*[@id='input-lname']";
	public static final String UPDATE_PATIENT_DOB = "//*[@id='patientDateOfBirthAddDemo']";
	public static final String UPDATE_PATIENT_PHONE_NUMBER = "//*[@id='patient-add-demo-info-input-phone-0']";
	public static final String UPDATE_PATIENT_DEMOGRAPHIC_NEXT_BUTTON = "//*[@id='patient-stepper']/rxms-step[1]/rxms-step-body/rxms-step-content/rxms-step-actions/button";
	public static final String UPDATE_PATIENT_CLINICAL_INFO_CONTENT = "//*[@id='patient-add-demo-info-form']/div[2]/div[1]/div[2]/div[1]/div/span[1]";
	public static final String PATIENT_PROFILE_GENERAL_TAB_ALLERGY_NAME = "//*[@id='allergies-container']/div/div[1]/div/div";
	public static final String PATIENT_PROFILE_GENERAL_TAB_ALLERGY_NAME_TEXT = "//*[@id='allergies-container']/div/div[2]/div/div/span";
	public static final String PATIENT_PROFILE_GENERAL_TAB_HEALTH_CONDITIONS = "//*[@id='health-conditions-container']/div/div[1]/div";
	public static final String PATIENT_PROFILE_GENERAL_TAB_HEALTH_CONDITIONS_TEXT = "//*[@id='health-conditions-container']/div/div[2]/div";
	public static final String PATIENT_PROFILE_ALLERGY_LAST_UPDATED = "//*[@id='allergies-container']//small";
	

	public static final String Rx_Preferences_Tab = "//*[@id='tabs-2']/div";
	public static final String Rx_Preferences_Text = "//div[@class='text-bold ng-binding' and contains(text(),'Rx Preferences')]";
	public static final String Rx_Preferences_Update_Button = "//*[@id='patient-view-button-bar-button-update']";
	public static final String Rx_Preferences_TAB_Update_Button = "//*[@id='patient-preferences-view-button-bar-button-update']";
	public static final String Rx_Preferences_Update_Page_Title = "//span[@class='md-title ng-binding flex-noshrink' and contains(text(),'Update Patient')]";
	public static final String Rx_Preferences_SnapCap = "//*[@id='patient-stepper']/rxms-step[5]/rxms-step-body/rxms-step-content/rxms-patient-add-preferences/ng-form/div/button[2]";
	public static final String Rx_Preferences_Save_Exit_Button = "//*[@id='patient-add-button-bar-button-saveeexit']/div/div";
	public static final String Rx_Preferences_Patient_Name = "//*[@name='name-information']";
	public static final String Rx_Patient_Search = "//span[@class='md-title ng-binding flex-noshrink' and contains(text(),'Patient Search')]";
	public static final String Back_Button = "//*[@id='back-button-patient-profile']";
	public static final String Patient_Profile_Title = "//span[@class='md-title ng-binding flex-20' and contains(text(),'Patient Profile')]";
	public static final String Rx_Preferences_Snap_Cap = "//*[@id='patient-plan']/rxms-patient-preferences-view/md-card/div[2]/div/div";
	public static final String Rx_Preferences_Update_Patient_Double_Count = "//*[@id='patient-stepper']/rxms-step[5]/rxms-step-body/rxms-step-content/rxms-patient-add-preferences/ng-form/div/button[1]";

	//Assertion Data
	public static final String No_Rx_Preferences_Text_Value = "No Rx Preferences";
	public static final String Rx_Preferences_Text_Value = "Rx Preferences";
	public static final String Rx_Preferences_Update_Title_Value = "Update Patient";
	public static final String Rx_Patient_Search_Value = "Patient Search";
	public static final String Rx_Patient_Profile_Value = "Patient Profile";

	public static final String RxHistory_AdditionalMed_UPDATE_BUTTON = "//*[@id='patient-plan-button-bar-button-update']";
	public static final String RxHistory_UPDATE_PATIENT_DIALOG="//*[@id='patient-stepper-dialog']/rxms-secondary-toolbar/md-toolbar/div/span[1]";
	public static final String RxHistory_AdditionalMed_DrugList="//*[@ng-if='$ctrl.items.length']";
	public static final String RxHistory_AdditionalMed_Tab_Numbers="//*[@id='add-meds-number']";
	public static final String RxHistory_tab ="//*[@id='tabs-pat-med']/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]";


	public static final String Patient_search_update_button ="//*[@id='patient-view-button-bar-button-update']";
	public static final String Patient_search_update_third_party_plans="//*[@id='patient-plan-party-header']/rxms-step-title";
	public static final String Patient_search_third_party_plans_Addplan="//*[@id='add-plan-radio']/div[1]";
	public static final String Third_party_PlanID="//*[@id='input-planid-plan']";
	public static final String Third_party_plans_search ="//*[@id='plan-search-button-search']";
	public static final String Third_party_plans_Plantype="//*[@id='plan-type']";
	public static final String Third_party_plans_add="//*[@id='rxms-plan-search-add-button']";
	public static final String Third_party_plans_Recipient_ID="//*[@id='input-recipient-1']";
	public static final String Third_party_plans_Relationship_to_plan="//*[@id='standard-plan-form-0']/div[2]/div/div[1]/div[4]/md-input-container/md-select";
	public static final String Third_party_plans_next = "//*[@id='patient-stepper']/rxms-step[4]/rxms-step-body/rxms-step-content/rxms-step-actions/button[1]";

	public static final String POS_FirstOfPatient = "//*[@class='data-wrapper ng-scope first-of-patient selected']";
	public static final String Rx_DeleteBtnDialog = "//*[@id='patient-order-popup-dialog']";
	public static final String Rx_DeleteBtnDilog_CancelBtn = "//*[@id='dialog-button-close']";
	public static final String Rx_DeleteBtnDilog_DeleteRxBtn = "//*[@id='dialog-button-confirm']";

	public static final String Patient_search_date_of_birth="//*[@id='patient-datepicker']";
	public static final String Patient_search_phone_number="//*[@id='input-phone-patient']";
	public static final String Patient_global_search="//*[@id='button-global']/md-icon";
	public static final String Patient_search_global_error_message="//*[@id='patient-error-div']/p";
	public static final String Patient_search_add_new_button="//*[@id='patient-add-button']";
	public static final String Patient_search_error_message="//*[@id='patients-results-external-div']/div/div/div/span[3]";
	public static final String Patient_search_add_new_popup_message="//*[@id='dialogContent_patient-search-dialog']/p";
	public static final String Patient_search_add_new_popup_search_all_stores="//*[@id='dialog-button-ok']";
	public static final String Patient_search_expected_error_message= "0 Results found. Please refine your search.";
	public static final String Patient_profile_general_info="//*[@id='tabs-0']";
	public static final String Patient_profile_third_party_plans ="//*[@id='tabs-1']";
	public static final String Patient_profile_preferences ="//*[@id='tabs-2']";
	public static final String Patient_profile_images ="//*[@id='tabs-3']";
	public static final String Patient_profile_med_history ="//*[@id='tabs-4']";
	public static final String Patient_profile_Clinical_history ="//*[@id='tabs-5']";
	public static final String Patient_profile_update_patient_view="//*[@id='patient-stepper-dialog']/rxms-secondary-toolbar/md-toolbar/div/span[1]";
	public static final String Patient_profile_update_patient_Additional_medications="//*[@id='patient-stepper']/rxms-step[3]/rxms-step-header/rxms-step-title";
	public static final String Patient_profile_add_additional_medications_="//*[@id='add-meds-taken']/div[1]/div[1]";
	public static final String Patient_profile_demographic_dob="//*[@id='patientDateOfBirthAddDemo']";
	public static final String Patient_profile_update_patient_save_and_exit="//*[@id='patient-add-button-bar-button-saveeexit']/div/div";

	public static final String Patient_date_Picker_Feild="//*[@id='patient-datepicker']";
	public static final String Patient_Phone_Number_Feild="//*[@id='input-phone-patient']";
	public static final String Patient_first_Name_Feild="//*[@id='input-fname-patient']";
	public static final String Patient_Last_Name_Feild="//*[@id='input-lname-patient']";
	public static final String Patient_Local_Search_Icon="//*[@id='button-local']";
	public static final String Patient_Global_Search_Icon="//*[@id='button-global']";
	public static final String Patient_profile_Search_Button="//*[@id='patient-submit']";
	public static final String Patient_profile_Entire_Screen="//*[@id='patients-results-external-div']/div/div/div";
	public static final String Patient_profile_view_Update_Addnew_Button="//*[@id='bottom-tray']/md-toolbar";
	public static final String Patient_profile_Search_Results_Screen="//*[contains(@id,'patient-bk')]";
	public static final String Patient_profile_phone_Results_Screen="//*[@id='patient-list']/table/tbody/tr[1]/td[5]";
	public static final String Patient_profile_Date_of_Birth_Results_Screen="//*[@id='patient-list']/table/tbody/tr[1]/td[3]";
	public static final String Patient_profile_Indicator="//*[@id='patient-view-form']/md-card[1]/div[2]/div[3]";
	public static final String Patient_profile_Back_Button_To_Profile="//*[@id='back-button-patient-profile']";
	public static final String Patient_profile_Pet_Indicator="//*[@id='patient-view-form']/md-card[1]/div[2]/div[3]/md-icon";
	public static final String Patient_profile_Results_Row_One="//*[@id='patient-list']/table/tbody/tr[1]";
	public static final String Patient_profile_Add_Button="//*[@id='patient-add-button']";
	public static final String Patient_profile_New_Registration_Patient_Form="//*[@id='patient-stepper-form']";
	public static final String Patient_profile_Error_Dialog_Popup_Screen_Cancel_Button="//*[@id='dialog-button-cancel']";
	
	public static final String Patient_profile_update_cancel_popup = "//*[@id='dialogContent_stepper-dialog-cancel-confirm']";
	public static final String Patient_profile_update_cancel_yes = "//*[@id='stepper-dialog-cancel-confirm']/md-dialog-actions/button[1]";

	public static final String Patient_profile_Error_Dialog_Message="//*[@id='patient-search-dialog']";
	public static final String Patient_profile_Error_Dialog_Popup_Screen="//*[@id='dialogContent_patient-search-dialog']";
	public static final String Patient_profile_Registration_Form_Cancel_Button="//*[@id='patient-add-button-bar-button-cancel']";
	public static final String Patient_profile_Zero_Error_Message="0 Results found. Please refine your search.";
	public static final String Patient_profile_Global_Search_Message="You must conduct a global search before adding a new patient. Would you like to conduct a search across all stores now?";
	public static final String Patient_profile_Name_click="//*[@id='patient-tab-manager-container']/rxms-secondary-toolbar/md-toolbar/div/span[1]";

	public static final String Patient_invalid_ph_number ="//*[contains(text(),'Please insert a valid Phone Number')]" ;
 	public static final String hotKey_Search_patient_error_msg ="//*[contains(text(),'Please specify the required search criteria.')]" ;
 	public static final String addNew_Item_PopUp_Msg ="//*[contains(text(),'You must conduct a global search before adding a new patient.')]" ;
 	public static final String addNew_Btn ="//*[@id='patient-add-button']";

	//Tabs
 	public static final String patient_tab_update_patient_window = "//*[@id='patient-stepper-dialog']/rxms-secondary-toolbar/md-toolbar/div/span[1]";
	public static final String patient_profile_third_party_screen = "//*[@id='patient-plan']/rxms-patient-plan/div";
	public static final String PATIENT_PROFILE_THIRD_PARTY_TAB_PAGE_TEXT = "//*[@id='standard-plan-form-0']/div[2]/div/div[1]/div[1]";
 	public static final String patient_tab_3rd_party_plan_box = "//*[contains(@id,'standard-plan-form-')]";
 	public static final String patient_tab_patient_images = "//*[@id='patient-plan']/rxms-patient-images/form/md-card/div";
 	public static final String patient_tab_clinical_history = "//*[@id='patient-plan']/rxms-clinical-history";
 	public static final String preferences_Update_Button = "//*[@id='patient-preferences-view-button-bar-button-update']";
    public static final String preferences_Back_Button = "//*[@id='back-button-patient-profile']";

	public static final String Patient_search_results_table = "//*[@id='patient-list']";
	public static String Patient_Search_Results_Column_Name =  "//*[@id='patient-list']/table/thead/tr/th[1]/span";
	public static String Patient_Search_Results_Column_DOB =  "//*[@id='patient-list']/table/thead/tr/th[3]/span";
	public static String Patient_Search_Results_Column_PhNo =  "//*[@id='patient-list']/table/thead/tr/th[5]/span";
	public static String Patient_Search_Results_Row = "//*[@id='patient-list']/table/tbody/tr";
	public static final String UPArrow_second = "[@id='up-arrow-icon-button-1']";

	public static final String patient_NoAddressOnRecord_Lable = "//*[@id='patient-view-form']/md-card[1]/div[2]/div[1]/div[1]/div";
	public static final String patient_NoAddressOnRecord_Lable_Text= "No Address on Record";
	public static final String patient_dataNotFound_error="data does not exist which has no address";
	public static final String TestData_FirstName = "FirstName";
	public static final String TestData_LastName = "LastName";
	 public static final String POS_No_Result_Found= "//p[@class='md-caption layout-padding ng-binding' and contains(text(),'No results found.')]";
	    public static final String POS_DeleteRx_Button= "//*[@id='patient-order-status-button-delete-rx']";
	    public static final String patient_profile_Error_Message="//*[contains(text(),'0 Results found. Please refine your search']";
	 	public static final String patient_profile_Error_Message_Results_Not_Displayed="//*[@id='patients-results-external-div']/div/div/div/span[3]";
	 	public static final String Patient_date_Picker_Focus="//*[@id='patient-search-datepicker']/rxms-input-date/ng-form/md-input-container";
		public static final String Patient_Phone_Number_Focus="//*[@id='input-container-phone-number']";
		public static final String Patient_first_Name_Focus="//*[@id='input-container-first-name']";
		public static final String Patient_Last_Name_Focus="//*[@id='input-container-last-name']";
		public static final String patient_profile_View_Button="//*[@id='patient-view-button']";			
	 	public static final String patient_profile_Back_button_Search="//*[@id='back-button-patient-search']";
	 	public static final String Patient_profile_Screen="//*[@id='patient-tab-manager-container']";
		public static final String Patient_Screen_Profile="//*[@id='rxms-main-container']";
		public static final String patientSearch_gloablsearchAlertMessage = "//*[@id='dialogContent_donut-popup-dialog']";
		
		public static final String patient_NoPatientPrimaryPlan_Label="//*[@id='no-patient-primary-plan']";    
		public static final String patient_NoPatientPrimaryPlan_Label_TEXT="No 3rd Party Plan Information";
		public static final String patient_NoAdditionalMedications_Label="//*[@id='clinical-info-patient-view-container']/div/div/div[2]/span";
		public static final String patient_NoAdditionalMedications_Label_TEXT="No Additional Medications";
		public static final String patient_NoClinicalRecord_Label="//*[@id='allergies-container']/div/div[2]/div/div/span";
		public static final String patient_NoClinicalRecord_Label_TEXT="No Allergies";
		//public static final String patient_DemographicView ="//*[@id='patient-view-form']/md-card[1]/div[2]";
		public static final String patient_DemographicView_Label_FirstName="//*[@id='patient-view-form']/md-card[1]/div[2]/div[1]/md-input-container[1]/label";
		public static final String patient_DemographicView_Label_MiddleName="//*[@id='patient-view-form']/md-card[1]/div[2]/div[1]/md-input-container[2]/label";
		public static final String patient_DemographicView_Label_LastName="//*[@id='patient-view-form']/md-card[1]/div[2]/div[1]/md-input-container[3]/label";
		public static final String patient_DemographicView_Label_Place="//*[@id='patient-view-form']/md-card[1]/div[2]/div[1]/div[1]/div[1]/md-icon";
		public static final String patient_DemographicView_Label_Local_Phone1="//*[@id='patient-view-form']/md-card[1]/div[2]/div[1]/div[2]/div[1]/div[1]/md-icon";
		public static final String patient_DemographicView_Label_Local_Phone2="//*[@id='patient-view-form']/md-card[1]/div[2]/div[1]/div[2]/div[1]/div[2]/md-icon";
		public static final String patient_DemographicView_Label_Local_Phone3="//*[@id='patient-view-form']/md-card[1]/div[2]/div[1]/div[2]/div[2]/div/md-icon";
		public static final String patient_DemographicView_Label_Suffix="//*[@id='patient-view-form']/md-card[1]/div[2]/div[2]/md-input-container[1]/label";
		public static final String patient_DemographicView_Label_DOB="//*[@id='patient-view-form']/md-card[1]/div[2]/div[2]/md-input-container[2]/label";
		public static final String patient_DemographicView_Label_Gender="//*[@id='patient-view-form']/md-card[1]/div[2]/div[2]/md-input-container[3]/label";
		public static final String patient_DemographicView_Label_IPledgePatientID="//*[@id='patient-view-form']/md-card[1]/div[2]/div[4]/div[1]/div";
		public static final String patient_DemographicView_Label_HipaaOnFile="//*[@id='patient-view-form']/md-card[1]/div[2]/div[4]/div[2]/div";

		public static final String patient_search_ViewAdditionalMedicationsLink = "//*[@id='clinical-info-patient-view-container']/div[3]/button/span";
		public static final String patient_search_ViewAllPlanLink = "//*[@id='patient-view-form']/md-card[3]/div[3]/button/span";
		
		public static final String PATIENT_SEARCH_NOTIFICATION_ICON = "//*[@id='bof-preview-menu-button']/md-icon";
        public static final String PATIENT_SEARCH_NOTIFICATION_ICON_FALURE_PREVIEW = "//*[@id='bof-preview-menu-content']";
        public static final String SEE_ALL_BUTTON = "//*[@id='see-all-button']";
        public static final String SYSTEM_ERROR_FAILURE_OVERLAY = "//*[@id='bucket-of-failure-queue']";
        public static final String SYSTEM_ERROR_FAILURE_OVERLAY_DEFAULT_SELECTED = "//*[@id='failure-0-anchor']";
        public static final String SYSTEM_ERROR_FAILURE_OVERLAY_USER_SELECTED = "//*[@id='failure-2-anchor']";
        public static final String SYSTEM_ERROR_FAILURE_OVERLAY_X_LINK = "//*[@id='bucket-of-failure-icon-cancel']/md-icon";
        public static final String PATIENT_SEARCH_DETAILS = "//*[@id='patient-list']/table/tbody/tr";
        public static final String FAILURES_LIST_THIRD_LINK = "//*[@id='bof-preview-menu-content']/md-menu-item[4]";
        public static final String DEMOGRAPHIC_TITLE = "//*[@id='patient-view-form']/md-card[1]/div[1]";
        public static final String PATIENT_PROFILE_THIRD_PARTY_PLAN_TAB = "//*[@id='tabs-1']";
        public static final String PATIENT_PROFILE_THIRD_PARTY_PLAN_PAGE = "//*[@id='patient-plan-form']/md-content";
        public static final String PATIENT_PROFILE_THIRAPRTY_PLAN_TEXT = "//*[@id='patient-plan']/rxms-patient-plan/div/div/div[2]";
        public static final String PATIENT_PROFILE_IMAGE_TAB = "//*[@id='tabs-3']";
        public static final String PATIENT_PROFILE_IMAGE_PAGE = "//*[@id='patient-plan']/rxms-patient-images/form";
        public static final String PATIENT_PROFILE_RX_HISTORY_PAGE = "//*[@id='rx-hitory-table']";
        public static final String PATIENT_PROFILE_ADDITIONAL_MEDICATION = "//*[@id='tabs-pat-med']/md-tabs-content-wrapper";
        
        public static final String FAILURES_LIST_FIRST_LINK=" //*[@id='bof-preview-menu-content']/md-menu-item[2]/button";
        public static final String FAILURE_LIST_FIRST_PATIENT_NAME="//*[@id='bof-preview-menu-content']/md-menu-item[2]/button/div/div[1]/p[1]";
        public static final String FAILURE_LIST_FIRST_PATIENT_DOB="//*[@id='bof-preview-menu-content']/md-menu-item[2]/button/div/div[1]/p[2]";
        public static final String FAILURE_LIST_FIRST_PATIENT_REASON="//*[@id='bof-preview-menu-content']/md-menu-item[2]/button/div/div[2]/p[1]";
        public static final String FAILURE_OVERLAY_SYSTEM_ERRORS_LIST = "//*[@id='vertical-container']/md-list-item";
        public static final String FAILURE_LIST_FIRST_TASK_CONTENT ="//*[@id='bof-preview-menu-content']/md-menu-item[2]";
        public static final String highLighted_failure = "focused-location";
        public static final String PATIENT_PROFILE_CLINICAL_HISTORY = "//*[@id='tabs-5']";
        public static final String PATIENT_PROFILE_CLINICAL_HISTORY_PAGE = "//*[@id='patient-plan']/rxms-clinical-history";
        public static final String DRUG_SEARCH_VIEW_BUTTON = "//*[@id='bottom-tray']/md-toolbar/div/ng-transclude/button";
        public static final String DRUG_DETAILS_CORE_DRUG_INFO_TITLE = "//div[@class='padding-bottom padding-top text-bold ng-binding' and contains(text(),'Core Drug Info')]";
        public static final String DRUG_DETAILS_CORE_DRUG_INFO_TITLE_VALUE = "Core Drug Info";
        public static final String RESCRIBER_SEARCH_VIEW_PRESCRIBER_DETAILS_PAGE_TITLE_VALUE = "Prescriber Details";
        public static final String DRUG_DETAILS_CLINICAL_REFERENCE_TAB = "//*[@id='tabs-8']";
        public static final String DRUG_DETAILS_CLINICAL_REFERENCE_PAGE = "//*[@id='product-view']/rxms-product-clinical-references/md-content";
        public static final String PRESCRIBER_SEARCH_RESULT_PAGE = "//*[@id='rxms-main-container']/ng-outlet/rxms-prescriber-search/div/div[3]/ng-outlet/rxms-prescriber-search-results/div/div[1]";
        //public static final String PRESCRIBER_SEARCH_VIEW_BUTTON = "//*[@id='prescriber-search-results-button-view-update']";
        public static final String PRESCRIBER_SEARCH_VIEW_BUTTON = "//*[@id='prescriber-search-results-button-view']";
        public static final String PRESCRIBER_SEARCH_VIEW_PRESCRIBER_DETAILS_PAGE_TITLE = "//*[@id='update-prescriber']/rxms-secondary-toolbar/md-toolbar/div/span[1]";
        public static final String PRESCRIBER_DETAIL_PAGE_GENERAL_INFO = "//*[@id='prescriber-general-info-card']";
        public static final String POS_PAGE_TITLE = "//span[@class='md-title ng-binding flex-noshrink' and contains(text(),'Patient Order Status')]";
        public static final String POS_PAGE = "//*[@id='rxms-main-container']/ng-outlet/rxms-patient-order-status/div";
        public static final String POS_PAGE_TITLE_VALUE = "Patient Order Status";
        public static final String PLAN_SEARCH_PAGE_TITLE = "//span[@class='md-title ng-binding flex-noshrink' and contains(text(),'Plan Search')]";
        public static final String PLAN_SEARCH_PAGE_TITLE_VALUE = "Plan Search";
        public static final String USER_PROFILE_LINK = "//*[@id='main-left-sidenav-button-team-member']";
        public static final String MY_PROFILE_TAB = "//*[@id='tabs-0']";
        public static final String MY_PROFILE_PAGE_TITLE = "//span[@class='md-headline ng-binding' and contains(text(),'Employee Information')]";
        public static final String MY_PROFILE_PAGE_TITLE_VALUE = "Employee Information";
        public static final String MY_PROFILE_TEAM_MEMBER_TAB = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-team-members-sidenav/div/div[2]";
        public static final String MY_PROFILE_TEAM_MEMBER_PAGE = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-team-members/div/div";
        public static final String DR_PAGE_TITLE = "//*[@id='rxms-main-container']/ng-outlet/rxms-prescription/form/rxms-secondary-toolbar/md-toolbar/div/ng-transclude";
        public static final String DR_PAGE_TITLE_VALUE = "Data Review";
        
        public static final String SYSTEM_ERRORS_FAILURE_TASK_CREATION_DATE_LIST = "//*[contains(@id,'-anchor')]/div[1]/div[3]/p[2]";
        public static final String SYSTEM_ERRORS_FAILURE_LIST = "//*[contains(@id,'-anchor')]";
        public static final String FAILURE_NOTIFICATION_LINK = "//*[@id='failure-0-button']";
        public static final String FAILURE_INTAKE_MESSAGE = "//*[@id='failure-0-anchor']/div/div[4]/p";
        public static final String POS_UPDATE_RX_BUTTON = "//*[@id='patient-order-status-button-update-rx']";
        public static final String UPDATE_RX_TITLE = "//*[@id='rxms-main-container']/ng-outlet/rxms-prescription/form/rxms-secondary-toolbar/md-toolbar/div/span[1]";
        public static final String UPDATE_RX_TITLE_VALUE = "Update Rx";
        public static final String UPDATERX_UPDATE_BUTTON = "//*[@id='prescription-update-button']";
        public static final String UPDATE_RX_POPUP_FAILURE_MESSAGE = "//*[@id='product-list']/table/tbody/tr/td[2]/div/div";
        public static final String UPDATE_RX_POPUP_FAILURE_MESSAGE_VALUE = "Check IC+";
        public static final String UPDATE_RX_POPUP_CLOSE_BUTTON = "//*[@id='patient-order-status-confirm-update-prescription-close-btn']";
        public static final String FAILURE_PREVIEW_FNAME_LAME = "//*[@id='failure-0-button']/div/div[1]/p[1]";
        public static final String FAILURE_PREVIEW_DOB = "//*[@id='failure-0-button']/div/div[1]/p[2]";
        public static final String FAILURE_PREVIEW_UPDATE_REASON = "//*[@id='failure-0-button']/div/div[2]/p[1]";
        public static final String FAILURE_PREVIEW_UPDATE_REASON_VALUE = "//*[@id='failure-0-button']/div/div[2]/p[1]";
        public static final String FAILURE_PREVIEW_UPDATE_RX_NUMBER = "//*[@id='failure-0-button']/div/div[2]/p[2]";
        
        public static final String FAILURE_DELETE_ALERT_MESSAGE = "//*[@id='rxms-common-dialog']/div[1]/p";
        public static final String SYSTEM_ERRORS_FAILURE_TASK_FIRST_DELETE_BUTTON="//*[@id='delete-0']";
        public static final String SYSTEM_ERRORS_FAILURE_TASK_SECOND_DELETE_BUTTON="//*[@id='delete-1']";
        public static final String CONFIRM_RESOLUTION_POPUP_YES_BUTTON="//*[@id='dialog-button-confirm']";
        public static final String  CONFIRM_RESOLUTION_POPUP_NO_BUTTON="//*[@id='dialog-button-cancel']";
        public static final String SYSTEM_ERROR_FAILURE_OVERLAY_X_LINK_BUTTON = "//*[@id='bucket-of-failure-icon-cancel']";
       	public static final String Patient_profile_Twin_Indicator="//*[@id='patient-view-form']/md-card[1]/div[2]/div[3]/div[2]";
        
        
        
}