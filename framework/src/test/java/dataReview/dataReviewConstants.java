package dataReview;

public class dataReviewConstants {
    public static final String left_sidebar_patient_button = "//*[@id='main-left-sidenav-button-Patient']";
    public static final String patient_search_screen = "//*[@rxms-title=' : : 'PATIENT.SEARCH.TITLE' | translate']";
    public static final String patient_lastname_bar = "//*[@id='input-lname-patient']";//"//*[@id='input-container-last-name']";
    public static final String patient_firstname_bar = "//*[@id='input-fname-patient']";//"//*[@id='input-container-first-name']";
    public static final String patient_submit = "//*[@id='patient-submit']";
    public static final String patient_table = "//*[@id='patient-table']";
    public static final String patient_result = "//*[@class='patient-table-row layout-padding selectable-row layout-align-start-center layout-row']";
    public static final String view_patient = "//*[@rxms-i18n-button='PATIENT.SEARCH.ACTIONS.VIEW']";
    public static final String intake_Rx_button = "//*[@id='patient-view-button-bar-button-intake']";
    public static final String intake_screen_title = "//*[@rxms-title='::'INTAKE.INTAKE.TITLE' | translate']";
    public static final String scanRx_radio_waiting = "//*[@id='scanrx-radio-waiting']";
    public static final String scanRx_radio_pickup = "//*[@id='scanrx-radio-pickup']";
    public static final String pickup_next_day = "//*[@id='pickup-later-button-date-1']";
    public static final String pickup_later_hour = "//*[@id='hour']";
    public static final String pickup_later_hour_menu = "//*[@id='select_container_12']";
    public static final String pickup_time = "02:00";
    public static final String pickup_later_am_pm = "//*[@id='meridian']";
    public static final String pickup_later_am_pm_menu = "//*[@id='select_container_13']";
    public static final String pickup_meridian = "PM";

    public static final String user_initials = "//*[@id='main-left-sidenav-button-team-member']/div[1]/span/label";
    public static final String back_button = "//*[@id='back-button-drug-search']/md-icon";
    public static final String comments_button = "//*[@id='patient-tab-manager-container']/rxms-secondary-toolbar/md-toolbar/div/ng-transclude/rxms-view-patient-information/div/div/button";
    public static final String comments_box = "//*[@id='sidenav-comments']";
    public static final String comments_box_text = "//*[@id='sidenav-comments']/md-content/div/span";

    //intake rx
    public static final String scanRx_radio_scan = "//*[@id='scanrx-radio-scan']";
    public static final String scanRx_button_finish = "//*[@id='scanrx-button-finish']";
    public static final String Patientprofile_GroupId = "//*[@id='input-group-patient']";
    public static final String div_rx_entry = "//*[@id='div-rx-entry']";
    public static final String main_right_sidenav_burger_menu_DE = "//*[@id='main-right-sidenav-burger-menu-DE']";
    public static final String main_right_sidenav_burger_menu_DE_text = "//*[@id='main-right-sidenav-burger-menu-DE']/div[2]/span[1]";
    public static final String main_right_sidenav_burger_menu_DR = "//*[@id='main-right-sidenav-burger-menu-DR']";
    public static final String main_right_sidenav_burger_menu_DR_text = "//*[@id='main-right-sidenav-burger-menu-DR']/div[2]/span[1]";
    public static final String main_right_sidenav_burger_menu_CE = "//*[@id='main-right-sidenav-burger-menu-CE']";
    public static final String main_right_sidenav_burger_menu_CE_text = "//*[@id='main-right-sidenav-burger-menu-CE']/div[2]/span[1]";
    public static final String data_entry_title = "//*[@id='div-rx-entry']/rxms-main-patient-toolbar/rxms-secondary-toolbar/md-toolbar/div/span[1]";

    //Patient Order Status
    public static final String patient_order_status_sidebar = "//*[@id='main-left-sidenav-button-PatientOrderStatus']";
    public static final String patient_order_status_header = "//*[@id='rxms-main-container']/ng-outlet/rxms-patient-order-status/div/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String patient_order_status_lastname = "//*[@id='patient-order-status-input-lastname']";
    public static final String patient_order_status_search = "//*[@id='patient-order-status-button-search']";
    public static final String patient_order_status_table = "//*[@id='patient-order-status-table']";
    public static final String patient_order_status_pending_item = "//*[@ng-attr-id='single-prescription-{{patientCode}}-{{$index}}']";
    public static final String patient_order_status_add_rx = "//*[@id='main-data-entry-button-toolbar-addrx']";
    public static final String patient_order_status_finish = "//*[@id='main-data-entry-button-toolbar-finish']";
    public static final String patient_order_status_send_to_ic = "//*[@id='main-data-entry-button-toolbar-sendtoicplus']";
    public static final String patient_order_status_cancel = "//*[@id='go-to-dashboard-cancel-button']";

    //DE
    public static final String de_header = "//*[@id='div-rx-entry']/rxms-main-patient-toolbar/rxms-secondary-toolbar/md-toolbar";
    public static final String de_header_text = "//*[@id='div-rx-entry']/rxms-main-patient-toolbar/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String de_cancel_popup = "//*[@id='dialogContent_main-data-entry-button-toolbar-cancel-confirm']";
    public static final String de_cancel_yes = "//*[@id='main-data-entry-button-toolbar-cancel-confirm']/md-dialog-actions/button[1]";
    public static final String de_cancel_no = "//*[@id='main-data-entry-button-toolbar-cancel-confirm']/md-dialog-actions/button[2]";

    //prescriber box in DE
    public static final String prescriber_information_card = "//*[@id='prescriber-information-card']";
    public static final String prescription_search_prescriber_form = "//*[@id='prescription-search-prescriber-form']";
    public static final String prescriber_open = "//*[@id='prescriber-info-button-openprescriber']";
    public static final String prescriber_lastname = "//*[@id='last-name']";
    public static final String prescriber_firstname = "//*[@id='first-name']";
    public static final String prescriber_phone = "//*[@id='phone']";
    public static final String prescriber_npi = "//*[@id='npidea']";
    public static final String prescriber_state = "//*[@id='state-select']";
    public static final String prescriber_search_de = "//*[@id='prescription-search-prescriber-button-search']";

    public static final String prescriber_sidenav = "//*[@id='data-entry-prescriber-sidenav']";
    public static final String prescriber_sidenav_select = "//*[@id='main-data-prescriber-sidenav-button-select']";
    public static final String prescriber_sidenav_view = "//*[@id='main-data-prescriber-sidenav-button-view']";
    public static final String prescriber_sidenav_update = "//*[@id='main-data-prescriber-sidenav-button-update']";
    public static final String prescriber_sidenav_add_new = "//*[@id='main-data-prescriber-sidenav-button-addnew']";
    public static final String prescriber_sidenav_cancel = "//*[@id='main-data-prescriber-sidenav-button-cancel']";

    //product box in DE and DR
    public static final String product_information_card = "//*[@id='product-information-card']";
    public static final String product_info_form = "//*[@id='product-info-form']";
    public static final String product_open = "//*[@id='product-info-button-openproduct']";
    public static final String product_original_date = "//*[@id='orig-data']";
    public static final String daw_box = "//*[@id='daw']";
    public static final String substitute_box = "//*[@id='substitute']";
  
    public static final String product_info_checkbox = "//*[@id='product-information-checkbox-viewsize']";
    public static final String product_info_search = "//*[@id='autocompleted-product-search']";
    public static final String product_info_input = "//*[@id='input-autocomplete-location']";
    public static final String dispensed_field = "//*[@id='dispensed']";
    public static final String dispensed_menu = "//*[@id='select_container_62']";
    public static final String dispensed = "//*[@id='changebtnid']";
    public static final String drug_exp_date = "//*[@id='drug-exp-date']";
    public static final String drug_qty = "//*[@id='qty']";
    public static final String drug_qty_disp = "//*[@id='qty-disp']";
    public static final String drug_direction = "//*[@id='directions']";
    public static final String drug_day_supply = "//*[@id='day-supply']";
    public static final String drug_refills = "//*[@id='number-refill']";
    public static final String rx_exp_date = "//*[@id='refill-exp-date']";

    //pay box in DE and DR
    public static final String payment_information_card = "//*[@id='payment-information-card']";
    public static final String payment_open = "//*[@id='payment-info-button-openpayment']";
    public static final String payment_type_dropdown = "//*[@id='payment-type-multilevel-dropdown']";
    public static final String payment_type_dropdown_button = "//*[@id='payment-info-buttonicon-down']";
    public static final String payment_type_menu = "//*[@id='payment-type-container']";
    public static final String payment_cash_option = "//*[@id='payment-info-button-cash']/span";
    public static final String PLAN_OPTIONS = "//*[contains(@id,'menu_container')]/md-menu-content/md-menu-item[3]";
    public static final String payment_paycode = "//*[@id='pay-code]";
    public static final String paycode_dropdown = "//*[@id='select_container_3']";
    public static final String cash_div = "//*[@id='cash-div']";

    //bottom toolbar of DE
    public static final String de_add_rx = "//*[@id='main-data-entry-button-toolbar-addrx']";
    public static final String de_finish = "//*[@id='main-data-entry-button-toolbar-finish']";
    public static final String de_cancel = "//*[@id='go-to-dashboard-cancel-button']";

    //DR
    public static final String dr_header = "//*[@id='rxms-main-container']/ng-outlet/rxms-main-data-review/div/div[1]/rxms-data-review-patient-toolbar/div/rxms-secondary-toolbar/md-toolbar";
    public static final String dr_header_text = "//*[@id='rxms-main-container']/ng-outlet/rxms-main-data-review/div/div[1]/rxms-data-review-patient-toolbar/div/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String one_accept = "//*[@id='dr-patient-accept']";
    public static final String one_accept_text = "//*[@id='dr-patient-accept']/ng-bind-html/text()";
    public static final String one_accept_check = "//*[@id='main-data-rewiew-content']/div/div[1]/div/md-card/div[1]/div/md-icon";
    public static final String one_search = "//*[@id='dr-patient-search']";
    public static final String two_accept = "//*[@id='dr-prescriber-accept']";
    public static final String two_accept_text = "//*[@id='dr-prescriber-accept']/ng-bind-html/text()";
    public static final String two_accept_check = "//*[@id='main-data-rewiew-content']/div/div[2]/div/md-card/div[1]/div/i";
    public static final String two_search = "//*[@id='dr-prescriber-search']";
    public static final String three_accept = "//*[@id='dr-product-accept']";
    public static final String three_accept_text = "//*[@id='dr-product-accept']/ng-bind-html/text()";
    public static final String three_accept_check = "//*[@id='main-data-rewiew-content']/div/div[3]/div/md-card/div[1]/i";
    public static final String three_search = "//*[@id='dr-product-search']";
    public static final String dr_patient_search = "//*[@id='dr-patient-search']";
    public static final String dr_patient_search_confirm = "//*[@id='dialog-button-confirm']";
    public static final String dr_prescriber_search = "//*[@id='dr-prescriber-search']";
    public static final String dr_prescriber_lastname = "//*[@id='data-entry-prescriber-sidenav']//*[@id='last-name']";
    public static final String dr_prescriber_firstname = "//*[@id='data-entry-prescriber-sidenav']//*[@id='first-name']";
    public static final String dr_prescriber_search_btn = "//*[@id='data-entry-prescriber-sidenav']//*[@id='prescription-search-prescriber-button-search']";
    public static final String dr_prescriber_select = "//*[@id='prescriber-location-result-4-0']/div[1]/div/div[2]";
    public static final String dr_prescriber_select_button = "//*[@id='main-data-prescriber-sidenav-button-select']";
    public static final String dr_prescriberSearch_lastname = "//*[@id='last-name']";
    public static final String dr_prescriberSearch_searchButton = "//*[@id='prescription-search-prescriber-button-search']";
    public static final String dr_prescriberSearch_firstname = "//*[@id='first-name']";
    public static final String Dr_Product_drug_cancel = "//*[@id='dialog-button-cancel']";
    public static final String Dr_Product_drug_Icplus = "//*[@id='dialog-button-continueonicplus']";
    public static final String Dr_Product_drug_popup = "//*[@id='dialogContent_donut-popup-dialog']/div/p[1]";
    public static final String dr_product_update_btn = "//*[@id='dr-product-search']";
    public static final String Dr_payment_paycode = "//*[@id='payment-info']/div[2]/div[1]/div[2]/md-input-container/md-select/md-select-value/span/div";
    public static final String dr_click_payment = "//*[@id='payment-info-buttonicon-down']/i";
    public static final String dr_select_payment_type_cash = "//*[@id='payment-info-button-cash']";

    //bottom toolbar of DR
    public static final String dr_finish = "//*[@id='dr-form-finish']";
    public static final String dr_send_to_ic = "//*[@id='prescription-sendtoicplus-button']";
    public static final String dr_cancel = "//*[@id='dr-form-cancell']";

    //CC
    public static final String cc_header = "//*[@id='div-rx-entry']/rxms-secondary-toolbar/md-toolbar";
    public static final String cc_header_text = "//*[@id='div-rx-entry']/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String cc_interaction = "//*[@id='tabs-0']";
    public static final String cc_med_history = "//*[@id='tabs-1']";
    public static final String cc_clinical_history = "//*[@id='tabs-2']";
    public static final String cc_clinical_references = "//*[@id='tabs-3']";
    public static final String cc_search_tab = "//*[@id='div-rx-entry']/md-content/div[2]/md-content";
    public static final String cc_clinical_history_field = "//*[@id='div-rx-entry']/md-content/div[2]/md-content/rxms-clinical-history";
    public static final String cc_clinical_history_search_form = "//*[@id='clinical-search-form']";
    public static final String cc_clinical_history_search_field = "//*[@id='search-text']";
    public static final String cc_clinical_history_search_cancel = "//*[@id='clinical-search-buttonicon-cancel']/md-icon";
    public static final String cc_clinical_history_result_field = "//*[@id='div-rx-entry']/md-content/div[2]/md-content/rxms-clinical-history/div/div[3]";
    public static final String cc_clinical_history_result_text = "//*[@id='div-rx-entry']/md-content/div[2]/md-content/rxms-clinical-history/div/div[3]/span";
    public static final String cc_3_string_example = "Tyl";
    public static final String misspelled_drug = "Tynelol";
    public static final String cc_clinical_history_search_error_message = "No results matched your search criteria";

    //CC bottom bar
    public static final String cc_send_to_ic = "//*[@id='sendtoicp-button']";
    public static final String cc_consult_prescriber = "//*[@id='consult-prescriber-button']";
    public static final String cc_consult_patient = "//*[@id='consult-patient-button']";
    public static final String cc_cancel = "//*[@id='cancel-button']";

    public static final String DataReview_Error_Msg = "//*[@id='dialogContent_accept-popup']/div/div";
    public static final String Home_Menu_Dashboard = "//*[@id='main-left-sidenav-burger-menu']/md-list/md-list-item[1]";
    public static final String Drug_Popup_Alert = "//*[@id='dialogContent_main-data-entry-quality-alert']/div/p";
    public static final String Drug_Popup_Alert_OK_Btn = "//*[@id='main-data-entry-quality-alert']/md-dialog-actions/button";


    public static final String TASKBAR_EXPANDED = "//*[@id='main-right-sidenav'][contains(@class,' open')]";
    public static final String DR_DISABLED = "//*[@id='main-right-sidenav-burger-menu-DR']";
    public static final String DASHBOARD_HOME_BUTTON = "//*[@id='main-left-sidenav-burger-menu']/md-list/md-list-item[1]";
    public static final String TASKBAR_LINK = "//*[@id='workflow-button-panel']";
    public static final String TASK_FILLING_LINK = "//*[@id='main-right-sidenav-burger-menu-FILL']/div[2]";
    public static final String TASK_CE_PRIORITY_ICON = "//*[@id='main-right-sidenav-burger-menu-DE']/div[1]/div[2]/md-icon[1]";
    public static final String FILLING_TASK_MESSAGE = "//*[@id='dialogContent_45']/div";
    public static final String TASK_ON_MOBILE_POPUP_OK = "//*[@class='md-primary md-confirm-button md-button md-autofocus md-material-theme md-ink-ripple']";

    //Patient Order Status
    public static final String POS_PAYMENT_UPDATE = "//*[@id='patient-order-status-button-update-payment']";
    public static final String POS_UPDATE_RX = "//*[@id='patient-order-status-button-update-rx']";
    public static final String POS_DELETE_RXS = "//*[@id='patient-order-status-button-delete-rx']";
    public static final String POS_REPRINT_PAPERWORK = "//*[@id='patient-order-status-button-reprint-paperwork']";
    public static final String POS_FUNCTION_UNAVAILABLE_OK = "//*[@id='dialog-button-confirm']";

    public static final String DR_BACK_BUTTON = "//*[@id='back-button-data-review']/md-icon";


    public static final String DE_Patient_Name_Validation = "//*[@aria-label='Name Patient Information']";
    public static final String DE_Patient_Contact_Number_Validation = "//*[@aria-label='Phone Patient Information']";

    public static final String Intake_Pickup_Timings_Dropdown_Entire_Box = "//*[@class='md-select-menu-container md-material-theme md-active md-clickable']";
    public static final String Intake_Pickup_Timings_Dropdown_Box_Selected_Feild = "//*[@id='hour']";
    public static final String dr_prescriber_search_Btn = "//*[@id='dr-prescriber-search']";
    public static final String Dr_Prescriber_LastName = "//*[@id='last-name']";
    public static final String Dr_Prescriber_FirstName = "//*[@id='first-name']";
    public static final String Dr_Search_Prescriber_Btn = "//*[@id='prescription-search-prescriber-button-search']";
    public static final String Dr_AddNew_Button = "//*[@id='main-data-prescriber-sidenav-button-addnew']";
    public static final String Dr_Update_Button = "//*[@id='main-data-prescriber-sidenav-button-update']";
    public static final String Dr_View_Button = "//*[@id='main-data-prescriber-sidenav-button-view']";
    public static final String PopUp_SendIC_Msg = "//*[@id='dialogContent_donut-popup-dialog']/p";
    public static final String PopUp_Ok_Btn = "//*[@id='dialog-button-confirm']";
    public static final String dr_paymenttype = "//*[@id='open-payment-panel']";

    public static final String DR_ORIGINAL_DATE="//*[@id='original-date']";
    public static final String DR_DRUG_EXP_DATE="//*[@id='drug-exp-date']";
    public static final String DR_REFILL_EXP_DATE="//*[@id='refill-exp-date']";
    
    public static final String DR_UPDATE_RX_BUTTON="//*[@id='patient-order-status-button-update-rx']";
    public static final String UPDATERX_UPDATE_BUTTON  = "//*[@id='prescription-update-button']";
    public static final String CLOSE_UPDATERX_POPUP = "//*[@id='patient-order-status-confirm-update-prescription-close-btn']";

    //blank because feature not implemented
    public static final String RX_EXPIRATIONDATE_ERRORMESSAGE = "//*[@id='prescription-rx-product-create-form']/div[4]/md-input-container[4]/div[2]/div";
    
    public static final String Dr_one_accept_correct_sign ="//*[@id='patient-information-card']/md-card-content/div/div[1]/i";
    public static final String Dr_two_accept_correct_sign ="//*[@id='prescriber-information-card']/md-card-content/div[1]/div[1]/i[1]";
    public static final String Dr_three_accept_correct_sign ="//*[@id='product-information-card']/ng-form/md-card-content[2]/div/div[1]/i[1]";

    public static final String DR_PATIENT_VALIDATION_FLAG = "//*[@id='patient-information-card']/md-card-content//div[contains(@ng-show,'')]//i";
    public static final String DR_PRESCRIBER_VALIDATION_FLAG = "//*[@id='prescriber-information-card']//md-card-content//div[contains(@ng-show,'')]//i[1]";
    public static final String DR_PRODUCT_VALIDATION_FLAG = "//*[@id='product-information-card']//md-card-content//div[contains(@ng-show,'')]//i[1]";
    
	public static final String Incorrect_Original_date="//*[@id='prescription-rx-product-create-form']/div[1]/md-input-container[1]/div[2]/div";
    public static final String Incorrect_Exp_date="//*[@id='prescription-rx-product-create-form']/div[4]/md-input-container[1]/div[2]/div";
    public static final String Incorrect_RX_Exp_Date="//*[@id='prescription-rx-product-create-form']/div[4]/md-input-container[4]/div[2]/div";
    public static final String UPDATERX_RXIncorrect_RX_Exp_Date="//*[@id='prescription-rx-product-create-form']/div[4]/md-input-container[5]/div[2]/div";
    public static final String Incorrect_Date_error_msg= "Invalid date format";
    
	public static final String DR_ONE_PATIENT_SEARCH = "//*[@id='dr-patient-search']";
    public static final String DR_TWO_PRESCRIBER_SEARCH = "//*[@id='dr-product-search']";
    public static final String DR_THREE_PRODUCT_SEARCH="//*[@id='product-review-buttons']/button[2]";
    
    public static final String DR_PAYMENT_CASH ="//*[@id='cash-div']";
    public static final String DR_SEND_TO_IC_PLUS ="//*[@id='prescription-sendtoicplus-button']";
    public static final String DR_PRESCRIPTION_CANCEL_BUTTON="//*[@id='prescription-cancel-button']";
    
    public static final String DR_SIDE_FRONT="//*[@id='sub-tabs']/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]";
    public static final String DR_SIDE_BACK="//*[@id='sub-tabs']/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]";
    public static final String DR_SIDE_CLOCKWISE_BUTTON="//*[@id='clockwise-button']/md-icon";
    public static final String DR_SIDE_COUNTERCLOCKWISE_BUTTON="//*[@aria-label='Rotate Counterclockwise']/md-icon";
    public static final String DR_SIDE_RESET_IMAGE="//*[@aria-label='Reset Image']/md-icon";
    public static final String DR_SIDE_ZOOM_IN_BUTTON="//*[@aria-label='Zoom In']/md-icon";
    public static final String DR_SIDE_ZOOM_OUT_BUTTON="//*[@aria-label='Zoom Out']/md-icon";
    public static final String DR_SIDE_FULL_SCREEN_BUTTON="//*[@aria-label='View image full screen']/md-icon";
    public static final String DR_PATIENT_HYPERLINK="//*[@name='name-information']";
    public static final String DR_DAW_TEXT="//*[@name='daw']";
    public static final String DR_SUBSTITUTE_TEXT="//*[@name='substitute']";
    public static final String DR_INPUT_PRESCRIBED_PRODUCT="//*[@id='input-prescribed-product']";
    public static final String DR_PRESCRIBER_PRODUCT_CHANGE_BUTTON="//*[@id='prescription-rx-product-create-form']/div[3]/button";
    public static final String DR_QTY_PRESCRIBED="//*[@name='qtyPrescribed']";
    public static final String DR_QTY_DISPENSED="//*[@name='qtyDispensed']";
    public static final String DR_DAYS_SUPPLY="//*[@name='daysSupply']";
    public static final String DR_NUMBER_REFILL="//*[@name='numberRefill']";
    
    
    public static final String Patient_Profile_Plan_ID="//*[@id='payment-information-content-collapsed']/p/span[2]";
    public static final String DE_Payment_Plan_Message_Displayed="Rx will be billed to " + "PLAN";
    public static final String DE_UpdateRx_Screen_Page="//*[@id='rxms-main-container']/ng-outlet/rxms-prescription/form/rxms-secondary-toolbar/md-toolbar";
    public static final String DE_Open_Payment_Field="//*[@id='payment-information-expand-button']";
    public static final String DE_Open_Product_Field="//*[@id='product-information-expand-button']";
    public static final String DE_Payment_Option_Field="//*[@id='payment-information-card']";

public static final String DE_Product_Refills_Error_Message="Number of refills not allowed.";
public static final String DE_Product_Refills_Error="//*[@id='prescription-rx-product-create-form']/div[5]/md-input-container[3]/div[2]/div";
public static final String DE_Payment_Cash_Message="//*[@id='payment-information-content-collapsed']/p"; 

 public static final String DE_Payment_Cash_Message_Displayed="Rx will be billed to Cash"; 
 
 public static final String DR_Product_Update_Button="//*[@id='product-review-buttons']/button[2]";
 public static final String Payment_message ="This patient might have a coupon for this prescription";
 public static final String DR_payment_plan_message ="//*[@id='payment-create']/div[1]";
 public static final String DR_cash_amount_focus = "//*[@id='payment-create']/div/div/div[3]/md-input-container";
 public static final String DR_paycode_focus = "//*[@id='payment-create']/div/div/div[2]/md-input-container";
 public static final String DE_ILBCplan="//button[contains(text(),'ILBC')]";
 public static final String DE_listofPlans = "payment-item";



public static final String DR_patient_DOB = "//md-input-container/label[contains(text(),'DOB')]/following-sibling::input";
 public static final String DR_patient_name="//*[@id='patient-information-card']/md-card-content/rxms-rx-patient-review/div/div/div/div[1]";
 public static final String DR_prescriber_data ="//*[@id='prescriber-information-card']/md-card-content";
 public static final String DR_prescribedDrug_readonly="//md-input-container/label[contains(text(),'Prescribed Drug')]/following-sibling::input";
 public static final String DR_dispensedDrug_readonly="//md-input-container/label[contains(text(),'Dispensed / Orange Book Rating')]/following-sibling::input";
 public static final String DR_OriginalDate_readonly="//md-input-container/label[contains(text(),'Original Date')]/following-sibling::input";
 public static final String DR_DAW_readonly="//md-input-container/label[contains(text(),'DAW')]/following-sibling::input";
 public static final String DR_Qty_readonly="//md-input-container/label[contains(text(),'Qty')]/following-sibling::input";
 public static final String DR_refills_readonly="//md-input-container/label[contains(text(),'Refills')]/following-sibling::input";
 public static final String DR_directions_readonly="//md-input-container/label[contains(text(),'Directions')]/following-sibling::input";
 public static final String DR_ProductName = "//*[@id='input-prescribed-product']";
 
 public static final String DR_PRESCRIBER_RESULTS_LIST = "//*[@id='prescriber-location-list']/table/tbody/tr[contains(@class,'prescriber')]";
 public static final String DR_PRESCRIBER_RESULTS_FIRST_PATIENT_LOCATION_ROW = "//*[@id='prescriber-location-list']/table/tbody/tr[2]";
 
 public static final String dr_rems_alert_message = "//*[@id='dialogContent_donut-popup-dialog']/div/md-dialog-content";
 public static final String Dr_payment_paycode1 = "//*[@id='payment-create']/div//*[contains(@id, 'select_value_label')]";
 public static final String DataReview_Finsh_error_popup ="//*[@id='accept-popup']";
 public static final String de_add_to_ic = "//*[@id='prescription-sendtoicplus-button']";
 public static final String DR_prescriber_dropdown ="//*[@id='prescription-rx-prescriber-search-form']/div[1]//*[contains(@id, 'select_value_label')]/span[2]";
 public static final String Prescriber_SelectButton_DR = "//*[@id='prescription-rx-prescriber-search-button-search']";
 public static final String POS_CheckIC_plus ="//*[contains(@id, 'patient-order-status-team-member-status-id-')]";
 public static final String DE_backbutton_Popup ="//*[@id='main-data-entry-button-toolbar-cancel-confirm']";
 public static final String DR_Update_Prescriber_Viewbutton_details="//*[@id='update-prescriber']/div[3]/rxms-secondary-toolbar/md-toolbar/div";
 public static final String DR_Update_Prescriber_Viewbutton_firstname="//*[@id='prescr-first-name']"; 
 public static final String DR_Update_Prescriber_Viewbutton_lastname="//*[@id='prescr-last-name']";
 public static final String DR_Update_Prescriber_Viewbutton_location="//*[@id='prescriber-update-row-0']/td[1]/div[1]/md-icon";
 public static final String DR_Update_Prescriber_Viewbutton_contact="//*[@id='prescriber-update-row-0']/td[2]/i/md-icon";
 public static final String DR_Update_Prescriber_update="//*[@id='main-data-prescriber-sidenav-button-update']";
 public static final String DR_Update_Prescriber_update_close_button="//*[@id='close-button-view-prescriber']";
 public static final String Dr_Select_Prescriber_Btn = "//*[@id='main-data-prescriber-sidenav-button-select']";
 
}
