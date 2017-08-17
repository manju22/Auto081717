package dataEntry;

public class DataEntryConstants {

    public static final String DE_PRODUCT_DIRECTIONS_FIELD = "//*[@id='directions']";
    public static final String DE_CANCEL_ALERT_POPUP = "//*[@id='main-data-entry-button-toolbar-cancel-confirm']";
    public static final String SEND_TO_IC_PLUS = "//*[@id='main-data-entry-button-toolbar-sendtoicplus']";

    public static final String PATIENT_ORDER_STATUS_TOTAL_RECORDS = "//div[starts-with(@class,'patient-table-row')]//div[@role='button']";
    public static final String IMAGE_ANNOTATION_BUTTON = "//md-toolbar//*[contains(text(),'rotate_right')]/../preceding-sibling::button/md-icon";

    public static final String IMAGE_ROTATE_RIGHT_BUTTON = "//md-toolbar//*[contains(text(),'rotate_right')]";
    public static final String IMAGE_ROTATE_LEFT_BUTTON = "//md-toolbar//*[contains(text(),'rotate_left')]";
    public static final String IMAGE_ZOOM_IN_BUTTON = "//md-toolbar//*[contains(text(),'zoom_in')]";
    public static final String IMAGE_ZOOM_OUT_BUTTON = "//md-toolbar//*[contains(text(),'zoom_out')]";
    public static final String IMAGE_RESTORE_BUTTON = "//md-toolbar//*[contains(text(),'restore')]";
    public static final String IMAGE_FULL_SCREEN_BUTTON = "//md-toolbar//*[contains(text(),'fullscreen')]";
    public static final String IMAGE_PREVIEW = "//div/md-dialog/md-toolbar/div/h2[contains(text(),'Image Preview')]";
    public static final String IMAGE_CLOSE_BUTTON = "//button//span[contains(text(),'Close')]";
    public static final String IMAGE_X_BUTTON = "/html/body/div[3]/md-dialog/md-toolbar/div/button";
    public static final String VIEW_ALL_BUTTON = "//md-toolbar//*[contains(text(),'View All')]";
    public static final String CLOSE_BUTTON = "//md-toolbar//*[contains(text(),'Close')]";
    public static final String de_prescriberdetails_title = "//*[@id='update-prescriber']/div[3]/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String NOTES = "//md-toolbar//*[contains(@class,'scrollable-notes')]/div";

    public static final String CE_PAGE_CLINICAL_CHECK_TITLE = "//*[@id='rxms-main-container']//span[contains(text(),'Clinical Check')]";
    public static final String CE_CANCEL_BUTTON = "//*[@id='cancel-button']";
    public static final String CE_STOP_CURRENT_TASK_POP_UP = "//md-dialog//h2[contains(text(),'Stop Current Task')]";
    public static final String CE_STOP_CURRENT_TASK_YES_BUTTON = "//md-dialog//button[contains(text(),'es')]";
    public static final String CE_STOP_CURRENT_TASK_CANCEL_BUTTON = "//md-dialog//button[contains(text(),'ancel')]";


    public static final String IMAGE_FRONT_INTAKE_FINISH_SCREEN = "//one-image-viewer/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]//md-tabs-content-wrapper[1]/md-tab-content[1]/div/md-card/md-card-content/div/div/div/div[1]/div/img";
    public static final String IMAGE_BACK_INTAKE_FINISH_SCREEN = "//one-image-viewer/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]//md-tabs-content-wrapper[1]/md-tab-content[2]/div/md-card/md-card-content/div/div/div/div[1]/div/img";

    public static final String IMAGE_FRONT_DE_FINISH_SCREEN = "//one-image-viewer/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-card/md-card-content/div/div/div/div/div/img";
    public static final String IMAGE_BACK_DE_FINISH_SCREEN = "//one-image-viewer/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-tabs/md-tabs-content-wrapper/md-tab-content[2]/div/md-card/md-card-content/div/div/div/div/div/img";
    // DR screen images
    public static final String IMAGE_FRONT_DR_FINISH_SCREEN = "//one-image-viewer/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-tab-body/md-card/md-card-content/div/div/div/div/div/img";
    public static final String IMAGE_BACK_DR_FINISH_SCREEN = "//one-image-viewer/div/md-tabs/md-tabs-content-wrapper/md-tab-content[2]/div/div/md-tab-body/md-card/md-card-content/div/div/div/div/div/img";


    public static final String IMAGE_INTAKE_FINISH_SCREEN_BACK_BUTTON = "//one-image-viewer/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]//md-tabs-wrapper//md-pagination-wrapper//span[contains(text(),'Back')]";
    public static final String IMAGE_DE_FINISH_SCREEN_FRONT_BUTTON = "//one-image-viewer/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]//md-tabs-wrapper//md-pagination-wrapper//span[contains(text(),'Front')]";
    public static final String IMAGE_DE_FINISH_SCREEN_BACK_BUTTON = "//one-image-viewer/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]//md-tabs-wrapper//md-pagination-wrapper//span[contains(text(),'Back')]";
    public static final String IMAGE_DR_FINISH_SCREEN_BACK_BUTTON = "//one-image-viewer/div/md-tabs//md-tabs-wrapper//md-pagination-wrapper//span[contains(text(),'Back')]";
    public static final String PLAN_OPTIONS = "//*[@id='payment-type-standard-item-0']/span";
    public static final String PAY_CODE_DROPDOWN = "//*[@id='pay-code']";


//<<<<<<< HEAD

//=======
    //more

    public static final String DE_Prescriber_Search_Results_Phn_no = "//*[@id='prescriber-location-result-0-0']/div[4]/div/div[1]";
    public static final String DE_Prescriber_Search_Results_DEA = "//*[@id='prescriber-location-result-0-0']/div[3]/div";
    public static final String DE_Prescriber_Search_Cancel_Button = "//*[@id='main-data-prescriber-sidenav-button-cancel']";
    public static final String DE_Prescriber_Search_cancel_popup = "//*[@id='main-data-entry-button-toolbar-cancel-confirm']/md-dialog-actions/button[1]";
    public static final String DE_Prescriber_Search_Error_Message = "//*[@id='prescription-search-prescriber-form']/div[3]/div/div/div";
    public static final String DE_Prescriber_Lastname_Search_Error_Message = "//*[@id='data-entry-prescriber-sidenav']/div/rxms-prescription-search-results/md-content/div[3]/p";

    public static final String DE_Prescriber_Phone_Number_Field = "//*[@id='prescriber-information-card']//input[@id='phone']";
    public static final String DE_Prescriber_Phone_Number_Field_Container="//*[@id='prescription-rx-prescriber-search-form']/div[1]/md-input-container[1]";
    public static final String DE_Prescriber_NPIorDEA_Field = "//*[@id='prescriber-information-card']//input[@id='npidea']";
    public static final String DE_Prescriber_Search_NoMatchCriteria = "//*[@id='no-prescribers']";
    public static final String DE_Product_Search_Results = "//*[@id='autocompleted-product-search']";
    public static final String product_Results = "md-autocomplete-suggestions";
    public static final String DE_AddRx_Button = "//*[@id='prescription-addrx-button']";
    public static final String DE_ICplusButton = "//*[@id='main-data-entry-button-toolbar-sendtoicplus']";
    public static final String DR_PatientSearch = "//*[@id='dr-patient-search']";
    public static final String DR_PrescriberSearch = "//*[@id='dr-prescriber-search']";
    public static final String DR_prescriberPageTitle = "//*[@id='rxms-main-container']/ng-outlet/rxms-prescription/form/md-sidenav/rxms-rx-prescriber-search-sidenav/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String patientProfile_Demographic = "//*[@id='patient-view-form']/md-card[1]/div[1]/strong";
    public static final String patientProfile_third_PartyPlansButton = "//*[@id='tabs-1']";
    public static final String patientProfile_thirdParty_PrimarycheckBox = "//*[@id='standard-plan-checkbox-primary']";
    public static final String patientProfile_GeneralInfo = "//*[@id='tabs-0']";
    public static final String DE_Payment_Drpdown = " //*[@id='payment-info-buttonicon-down']/i";
    public static final String DE_PaymentTypeResultsClassName = "payment-button-label-align md-button ng-scope md-material-theme md-ink-ripple";
    public static final String patientProfile_PlanId_Text = "//*[@id='input-plan-id']";
    public static final String DE_SelectedPaymentType = "//*[@id='payment-type-input']";
    public static final String DE_Dispensed_drug_quantity = "//div[@class='md-scroll-mask']/following-sibling::div[1]/md-select-menu/md-content/md-option";


    //Rems
    public static final String Product_OriginalDate = "//*[@id='original-date']";
    public static final String Product_DAW = "//*[@id='prescription-rx-product-create-form']/div[1]/md-input-container[2]//*[starts-with(@id,'input_')]";
    public static final String Product_Substitute = "//*[@id='prescription-rx-product-create-form']/div[1]/md-input-container[3]//*[starts-with(@id,'input_')]";
    public static final String ViewSize_CheckBox = "//*[@id='prescription-rx-product-create-form']/div[2]/div/md-checkbox[1]";
    public static final String ViewSizeManufacturer_CheckBox = "//*[@id='prescription-rx-product-create-form']/div[2]/div/md-checkbox[2]";
    public static final String DrugName_Field = "//*[@id='input-prescribed-product']";
    public static final String DrugExpiryDate_Field = "//*[@id='drug-exp-date']";
    public static final String Quantity_field = "//*[@name='qtyPrescribed']";
    public static final String Quantity_disp = "//*[@name='qtyDispensed']";
    public static final String Directions_field = "//*[@name='directions']";
    public static final String Days_Supply = "//*[@name='daysSupply']";

    public static final String Refills_field = "//*[@id='number-refill']";
    public static final String RxExpiration_date = "//*[@id='refill-exp-date']";
    public static final String open_prescriber = "//*[@id='prescriber-info-button-openprescriber']/md-icon";
    public static final String Open_Product = "//*[@id='product-info-button-openproduct']";
    // public static final String Open_payment = "//*[@id='product-info-button-openproduct']/span";
    // public static final String DE_FinishButton = "//*[@id='main-data-entry-button-toolbar-finish']";
    public static final String DispensedDrug_errormsg = "//*[@id='product-info']/div[3]/div[1]/md-input-container/div[2]/div";
    public static final String Patient_AccceptButton = "//*[@id='dr-patient-accept']";
    public static final String Prescriber_AcceptButton = "//*[@id='dr-prescriber-accept']";
    public static final String Product_AcceptButton = "//*[@id='dr-product-accept']/ng-bind-html";
    public static final String Productdispensed_check = "//*[@id='product-info']//div/md-input-container//md-select//span/div/small";
    public static final String DE_FunctionPopup_cancel = "//*[@id='dialog-button-cancel']";
    // public static final String rems_ProductResult = "//span[contains(text(),'PROLASTIN')]";
    public static final String productChange_Button = "//*[@id='prescription-rx-product-create-form']/div[3]/button";
    public static final String No_of_dipensed_drugs = "//div[@class='md-scroll-mask']/following-sibling::div[1]";
    public static final String productSubstitute_Field = "//*[@id='dispensed']";


    public static final String RxMS_logoutButton = "//*[@id='main-left-sidenav-button-logout']/div[1]/md-icon";
    public static final String LogoutAlert_button = "//*[@id='bottom-tray']/md-toolbar/div/ng-transclude/button[2]";
    public static final String DR_ProductUpdate = "//*[@id='dr-product-search']";
    public static final String DR_ProductName = "//*[@id='input-prescribed-product']";


    //Identify dispensed product
    public static final String PRESCRIBER_SEARCH_UPDATE_BUTTON = "//*[@id='prescriber-search-results-button-update']";
    public static final String PRESCRIBER_SEARCH_PHONE_NUMBER = "//*[@id='phone-number']";
    public static final String PRESCRIBER_SEARCH_NPI_DEA = "//*[@id='npi-dea-state']";
    public static final String PRESCRIBER_SEARCH_FIRST_NAME = "//*[@id='first-name']";
    public static final String PRESCRIBER_SEARCH_LAST_NAME = "//*[@id='last-name']";
    public static final String PRESCRIBER_SEARCH_SEARCH_BUTTON = "//*[@id='prescriber-search']";
    public static final String DE_PRESCRIBER_SEARCH_SEARCH_BUTTON = "//*[@id='prescriber-information-card']/md-card-content//*[@id='prescription-search-prescriber-button-search']";
    public static final String PRESCRIBER_SEARCH_RESULT_NAME_COLUMN = "//*[@id='rxms-main-container']/ng-outlet/rxms-prescriber-search/div/div[3]/ng-outlet/rxms-prescriber-search-results/div/div[1]/div[2]/md-radio-group/div[1]/div/div/div[1]/div[1]";

    public static final String PRESCRIBER_SEARCH_EXPANDED_PHONE_NUMBER="//*[@id='prescriber-information-content-expanded']/rxms-rx-prescriber-search//*[@id='prescription-rx-prescriber-search-form']/div[1]/md-input-container[1]";
    
    public static final String productDispensed_Field = "//*[@id='dispensed-product-menu']";
    public static final String checkBox_ViewSize = "//*[@id='product-information-checkbox-viewsize']";
    public static final String productDispensed_Select_Field="//*[@id='dispensed-product-menu']//span[1]/div/small";
    

    public static final String checkBox_ViewManufacturer = "//*[@id='product-information-checkbox-viewsize-manufacturer']";
    public static final String Substitute_Alert_Ok_Button = "//*[@id='product-information-dispensed-drug-alert']/md-dialog-actions/button";
    public static final String Substitute_Alert_Message = "//*[@id='dialogContent_product-information-dispensed-drug-alert']/div/p ";
    public static final String RADIO_PICKUPLATER = "//*[@id='scanrx-radio-pickup']";
    public static final String PICKUPLATER_TODAYSDATE = "//*[@id='pickup-later-button-date-1']";
    public static final String soundAlikeDrugPopupMessage = "//*[@id='dialogContent_main-data-entry-quality-alert']";
    public static final String soundAlikeDrugPopupOkButton = "//*[@id='main-data-entry-quality-alert']/md-dialog-actions/button";
    public static final String DATAENTRY_PRODUCT_CANCEL_BUTTON = "//*[@id='prescribed-product']/md-autocomplete-wrap/button/md-icon";
    public static final String DE_WANT_TO_PROCEED_YES = "//*[@id='main-logout-popup-cancel-confirm']/md-dialog-actions/button[1]";
    public static final String DE_WANT_TO_PROCEED_NO = "//*[@id='main-logout-popup-cancel-confirm']/md-dialog-actions/button[2]";
    public static final String PRESCRIBER_CLEAR_FIELD = "//*[@id='prescription-search-prescriber-button-clearfield']";
    public static final String PRESCRIBER_SEARCH_BUTTON = "//*[@id='prescriber-information-card']/md-card-content//*[@id='prescription-rx-prescriber-search-button-search']";
    public static final String product_dropdown_result = "//*[contains(@id,'ul-')]/li";
    public static final String DE_Prescriber_Search_Results = "//*[@id='prescriber-general-name']/label/strong";
    public static final String De_Prescriber_Search_Results_TD="//*[@id='prescriber-location-list']/table/tbody/tr[2]/td[1]";

    public static final String de_prescriber_results_label = "//*[@id='follow']/label";
    public static final String de_prescriber_viewButton = "//*[@id='main-data-prescriber-sidenav-button-view']";
    //public static final String de_prescriberdetails_title = "//*[@id='update-prescriber']/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String de_prescriberdetails_backButton = "//*[@id='back-button-prescriber-details']/md-icon";
    public static final String de_prescriberdetails_FirstName = "//*[@id='prescr-first-name']";
    public static final String de_prescriberdetails_LastName = "//*[@id='prescr-last-name']";
    public static final String de_prescriberdetails_NPI = "//*[@id='prescr-npi']";
    public static final String de_prescriberdetails_DEA = "//*[@id='prescriber-dea-general-info-0']";
    public static final String de_prescriberdetails_StateLicesnseNumber = "//*[@id='prescr-state-license-0']";
    public static final String de_prescriberdetails_StateSubstanceNumber = "//*[@id='prescr-ctrl-substance-0']";
    public static final String de_prescriberdetails_locationCommunication = "//*[@id='prescriber-update-location-card']/md-content/md-content/div/div";
    public static final String de_prescriberresults_updateButton = "//*[@id='main-data-prescriber-sidenav-button-update']";
    public static final String de_prescriberresults_addNewButton = "//*[@id='main-data-prescriber-sidenav-button-addnew']";
    public static final String open_product2 = "//*[@id='product-info-button-openproduct2']";
    public static final String open_product3 = "//*[@id='product-info-button-openproduct']";
    public static final String DE_Screen_Payment_PlanType = "//*[@id='payment-type-container']/div[3]/div[2]//button/span";
    public static final String DE_Screen_Payment_Plan_Message_Display = "//*[@id='payment-create']/div[1]";
    public static final String DE_Screen_Selected_Payment_Displayed_Field = "//*[@id='payment-type-input']";
    public static final String DE_Screen_Selected_Payment_Jamedo_First_Highlited = "//md-menu-item/button[contains(@id,'payment-information-button-actual-productpack-JAMED0-')]";
    public static final String DE_Screen_Selected_Payment_Medicare_Second_Highlited = "//md-menu-item/button[contains(@id,'payment-information-button-actual-productpack-MEDICARE-1')]";
    public static final String DE_REMS_POPUP_WINDOW = "//*[@id='donut-popup-dialog']";
    public static final String DE_REMS_POPUP_CANCEL_BUTTON = "//*[@id='dialog-button-cancel']";
    public static final String dr_popupOkBtn = "//*[@id='dialog-button-confirm']";
    public static final String dr_rems_popup_cancelButton = "//*[@id='dialog-button-cancel']";
    public static final String de_rems_popup_continueonicplus = "//*[@id='dialog-button-continueonicplus']";
    public static final String incorrect_phone_number_errorMSg = "//*[@ng-messages='formSearch.phoneNumber.$error']//div";
    public static final String de_prescriber_please_refine_criteria_message = "//rxms-prescription-search-results/md-content//p";
    public static final String DR_Click_Performing_DE_Task = "//*[@id='main-right-sidenav-burger-menu']//div//span[contains(text(),'DR')]";
    public static final String DE_Prescriber_Last_First_Label = "//*[@id='singlerow-prescriber-0']/div[1]";
    public static final String Patient_order_status_update_button = "//*[@id='patient-order-status-button-update-payment']";
    public static final String Patient_order_status_update_Rx = "//*[@id='patient-order-status-button-update-rx']";
    public static final String Patient_order_status_Delete_Rx = "//*[@id='patient-order-status-button-delete-rx']";
    public static final String Patient_order_status_Reprint_paperwork = "//*[@id='patient-order-status-button-reprint-paperwork']";
    public static final String Patient_order_status_Popup_Delete_Rx = "//*[@id='dialog-button-confirm']";
    public static final String Patient_order_status_Popup_Cancel_button = "//*[@id='dialog-button-close']";
    public static final String Patient_order_status_first_result = "//*[@class='data-wrapper ng-scope first-of-patient selected']";
    public static final String Patient_order_status_list = "//*[@id='patient-order-status-list']";
    public static final String Patient_order_status_Popup_Description = "//*[@id='dialogContent_patient-order-popup-dialog']";
    public static final String Prescriber_search_frequently_first_result = "//*[@id='most-frequently-prescriber-table-0']";
    public static final String Prescriber_info_select_button = "//*[@id='prescriber-info-button-select']";
    public static final String RXMS_store_number = "//*[@id='pharmacy-information-card']/md-card-content/div[2]/div[1]/h5[1]/a";
    public static final String de_cancel = "//*[@id='prescription-cancel-button']";
    public static final String DE_PAYMENT_PANEL_COLLAPSED_PATIENT_BILLED_FOR= "//*[@id='payment-information-content-collapsed']/p";
    public static final String DE_PAYMENT_PANEL_PLANID = "//md-menu-item[contains(@class,'payment-item')]//button[contains(@ng-bind,'::standardPlan.planID')]";
    public static final String DE_prescriber_name="//*[@id='prescriber-information-content-collapsed']/rxms-rx-prescriber-view/div/div[1]/div[1]/strong";
    public static final String DE_PRESCRIBER_SEARCH_RESULTS_VIEW_BUTTON = "//*[@id='main-data-prescriber-sidenav-button-view']";

    public static final String DE_RX_EXP_DATE_ERROR = "//*[@id='prescription-rx-product-create-form']/div[4]/md-input-container[4]/div[2]/div";
    public static final String DE_RX_EXP_DATE_EXPECTED_ERROR = "Invalid entry. Max Days to Fill exceeded";
    public static final String DE_RX_EXP_DATE_EXPECTED_ERROR_1="Invalid Rx Expiration date";

    public static final String Prescriber_frequent_names = "//*[@id='prescriber-information-content-expanded']/rxms-rx-prescriber-frequent//div[contains(@class,'full-height-container')]";
    public static final String Prescriber_frequent_names_first_row ="//*[@id='most-frequently-prescriber-table-0']";
    public static final String Open_prescriber = "//*[@id='prescriber-information-content-collapsed']/div";
    
    public static final String PRN_Refills = "PRN";
    
    public static final String UPDATERX_PAGE_LABLE="//*[@id='rxms-main-container']/ng-outlet/rxms-prescription/form/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String UPDATERX_PRESCRIBER_EXPAND_BUTTON="//*[@id='prescriber-information-expand-button']";
    public static final String UPDATERX_PRESCRIBER_SEARCH_LIST="//*[contains(@id,'most-frequently-prescriber-table-')]/div[1]";
    public static final String UPDATERX_PRESCRIBER_NAME_RO="//*[@id='prescriber-information-content-collapsed']/rxms-rx-prescriber-view/div/div[1]/div[1]/strong";
    public static final String expand_Open_Prescriber_Button = "//*[@id='prescriber-information-expand-button']";
    public static final String DE_SCREEN_PATIENT_NAME_HYPERLINK = "//rxms-view-patient-information//div/md-input-container[1]/input[contains(@class,'name-hyperlink')]";
    public static final String Patient_DE="//*[@id='rxms-main-container']/ng-outlet/rxms-prescription/form/rxms-secondary-toolbar/md-toolbar/div/ng-transclude/rxms-view-patient-information/div/div/md-input-container[1]//*[contains(@id, 'input')]";
    public static final String Patient_DE_Med_history ="//*[@id='tabs-4']";
    public static final String Patient_DE_Med_Additional_medications ="//*[@id='tabs-pat-med']/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]/span";
    public static final String Patient_DE_Med_Additional_medications_Drugname="//*[@id='mdlist-header-additional-meds']/table/thead/tr/th[1]/span";
    public static final String Patient_DE_Med_Additional_medications_Directions="//*[@id='mdlist-header-additional-meds']/table/thead/tr/th[2]/span";
    public static final String Patient_DE_Med_Additional_medications_Therapy="//*[@id='mdlist-header-additional-meds']/table/thead/tr/th[3]/span";
    public static final String Patient_DE_Med_Additional_medications_close="//*[@id='patient-view-button-bar-button-close']";
    public static final String Patient_DE_Med_Additional_medications_X ="//*[@id='close-button-patient-profile']/md-icon";
    public static final String Patient_DE_comments="//*[@id='comments-icon']";
    public static final String Patient_DE_comments_close="//*[@id='sidenav-comments']/div[1]/button";
    public static final String Patient_DE_comments_popup="//*[@id='sidenav-comments']";
    public static final String Patient_DE_RX_history="//*[@id='tabs-pat-med']/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]";
    public static final String Patient_Profile_thirdparty_Drug_Expiration_Date="//*[starts-with(@id,'coupon-plan-date-expiration-')]";
    public static final String Patient_Profile_thirdparty_Drug_Name="//*[starts-with(@id,'input-drug-')]";
    public static final String Patient_Profile_thirdparty_Drug_Actual_Message_Name="TRINESSA TABLETS 28'S";
    public static final String DataEntry_Payment_Field_Coupon_Message_Prescription="//*[starts-with(@id,'payment-create')]";
    public static final String DataEntry_Payment_Field_Coupon_Actual_Message_Prescription="This patient might have a coupon for this prescription";
    public static final String Patient_Profile_thirdparty_Drug_Arrow_Button="//*[@id='coupon-plan-form-1']/div[2]/div/div[1]/div[3]/button[1]/md-icon";
    public static final String DE_qty_disp_error_msg="//*[@id='prescription-rx-product-create-form']/div[4]/md-input-container[3]/div[2]/div";

    public static final String UPDATE_RX_PRESCRIBER_RESULTS_LIST = "//*[@id='prescriber-location-list']/table/tbody/tr[contains(@class,'prescriber')]";
    public static final String UPDATE_RX_PRESCRIBER_RESULTS_FIRST_PATIENT_LOCATION_ROW = "//*[@id='prescriber-location-list']/table/tbody/tr[2]";


    public static final String PATIENT_DETAILS = "//*[@id='patient-tab-manager-container']/rxms-secondary-toolbar/md-toolbar/div/ng-transclude/rxms-view-patient-information/div/div";
    public static final String PATIENT_DETAILS_DOB =  "//*[@id='input-dob-patient']";
    public static final String PATIENT_DETAILS_GENDER = "//*[@id'input-gender-patient']";
    
    public static final String UPDATE_DOUBLE_COUNT_BUTTON="//button[@type='button' and ./div/text()='Double Count']";
    public static final String UPDATE_SNAP_CAP_BUTTON="//button[@type='button' and ./div/text()='Snap Cap']";
    public static final String PATIENT_PROFILE_PREFERENCES_RXPREFRENCES_TEXT="//*[@id='patient-plan']/rxms-patient-preferences-view/md-card/div[1]";
    public static final String PATIENT_PROFILE_PREFERENCES_RXPREFRENCES_DOUBLE_COUNT_TEXT="//*[@id='patient-plan']/rxms-patient-preferences-view/md-card/div[2]/div/div[1]";
    public static final String PATIENT_PROFILE_PREFERENCES_RXPREFRENCES_SNAP_CAP_TEXT="//*[@id='patient-plan']/rxms-patient-preferences-view/md-card/div[2]/div/div[2]";
    public static final String DATA_ENTRY_PATIENT_LINK="//*[@name='name-information']";
    public static final String DATA_ENTRY_LIGHT_BOX="//*[@id='patient-tab-manager-container']";
    public static final String DATA_ENTRY_LIGHT_BOX_CLOSE_LINK="//*[@id='close-button-patient-profile']";
    public static final String DATA_ENTRY_LIGHT_BOX_CLOSE_BUTTON="//*[@id='patient-view-button-bar-button-close']";
    public static final String DATA_ENTRY_UPDATE_BUTTON = "//button[starts-with(.,'Update')]/text()";
    public static final String Patient_DE_clinical_history="//*[@id='tabs-5']";
    public static final String Clinical_history_drugname="//*[@class='md-no-proxy ng-binding _md flex-55']";
    public static final String Clinical_history_down_arrow="//*[@id='down-arrow-icon-button-0']";
    public static final String PATIENT_HYPERLINK = "//*[@id='view-patient-info-patient-link']";
    public static final String PATIENT_PROFILE_LIGHT_BOX = "//rxms-patient-tab-manager";
    public static final String PRESCRIBER_PROFILE_X_BUTTON = "//*[@id='close-button-prescriber-profile']/md-icon";
    public static final String PRESCRIBER_PROFILE_CLOSE_BUTTON = "//*[@id='close-button-view-prescriber']";
    public static final String PRESCRIBER_PROFILE_FIRST_ROW_SELECTED = "//*[@id='prescriber-update-vertical-container']//tr[contains(@class,'selected')]";
    public static final String PRESCRIBER_SEARCH_RESULTS = "//*[@id='prescriber-location-list']//tr[contains(@class,'location')]";
    public static final String PATIENT_PLANS_READONLY = "//rxms-patient-plan//md-input-container//input[contains(@disabled,'disabled')]";
    public static final String PATIENT_PROFILE_THIRD_PARTY_PLANS_CLOSE_BUTTON  = "//*[contains(@class,'close-button')]";
    public static final String PATIENT_PROFILE_THIRD_PARTY_PLANS_X_BUTTON = "//*[@id='close-button-patient-profile']/md-icon";
    public static final String PATIENT_PROFILE_THIRD_PARTY_PLANS_UPDATE_BUTTON = "//*[contains(@class,'update-button')]";
    public static final String PATIENT_PROFILE_GENERAL_INFO_TAB = "//div[contains(@id,'tabs-')]//div[contains(@class,'ng-binding')]";
    public static final String PATIENT_PROFILE_GENERAL_INFO_PAGE = "//*[@id='patient-view-form']";
    public static final String PATIENT_PROFILE_GENERAL_INFO_CLOSE_BUTTON = "//*[@id='patient-view-button-bar-button-close']";
    public static final String DE_PAGE_FREQUENT_PRESCRIBER_LIST = "//*[@id='prescriber-information-content-expanded']/rxms-rx-prescriber-frequent//div[contains(@ng-attr-id,'most-') and contains(@class,'focused-location')]";
    public static final String DE_SELECTED_PRESCRIBER = "//*[@id='prescriber-location-list']//tr[contains(@class,'selected')]";
    public static final String DE_PRESCRIBER_INFO_COLLAPSED = "//*[@id='prescriber-information-content-collapsed']";
    public static final String DE_Patient_profile ="//*[@id='patient-tab-manager-container']/rxms-secondary-toolbar/md-toolbar/div/span[1]";
    public static final String PATIENT_THIRDPARTY_PLANS_STANDARD_PLAN = "//*[@id='patient-plan-form']//rxms-standard-plan";
    public static  final String PATIENT_THIRDPARTY_PLANS_STANDARD_PLAN_PLAN_ID = "//md-input-container//input[contains(@id,'input-plan-id-1')]";
    public static  final String PATIENT_THIRDPARTY_PLANS_STANDARD_PLAN_BIN = "//md-input-container//input[contains(@id,'input-bin-plan')]";
    public static  final String PATIENT_THIRDPARTY_PLANS_STANDARD_PLAN_PCN = "//md-input-container//input[contains(@id,'input-pcn-plan')]";
    public static  final String PATIENT_THIRDPARTY_PLANS_STANDARD_PLAN_RECIPIENT = "//md-input-container//input[contains(@id,'input-recipient-1')]";
    public static  final String PATIENT_THIRDPARTY_PLANS_STANDARD_PLAN_GROUPID = "//md-input-container//input[contains(@id,'input-group-id-1')]";
    public static final String REMS_Quality_Alert="//*[@id='main-data-entry-quality-alert']";
    public static final String PREFERENCES_DOUBLE_COUNT_BUTTON="//*[@id='patient-plan']/rxms-patient-preferences-view/md-card/div[2]/div/div[1]";
    public static final String PREFERENCES_SNAP_CAP_BUTTON="//*[@id='patient-plan']/rxms-patient-preferences-view/md-card/div[2]/div/div[2]";
    public static final String Patient_DE_Actual_Coupon_Message="This patient might have a coupon for this prescription";
    public static final String Patient_DE_Payment_Cash_Price="//*[@id='cash-div']";
    public static final String DE_Screen_SendtoIcplus_Button="//*[@id='prescription-sendtoicplus-button']";
    public static final String DE_Screen_Cancel_Button="//*[@id='prescription-cancel-button']";
    public static final String DE_Screen_Image_Front_Side_One="//*[@id='sub-tabs']/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]";
    public static final String DE_Screen_Image_Back_Side_One="//*[@id='sub-tabs']/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]";
    public static final String DE_Screen_Patient_hyperlink_Field="//*[starts-with(@aria-label,'Patient Link Information')]";
    public static final String ILBC_option="//button[contains(text(),'ILBC')]";
    public static final String paycode = "//*[@id='pay-code']";  
	public static final String DE_drugNameField_Error_Mesage="//*[@id='prescription-rx-product-create-form']/div[2]/md-input-container/div/div";
    public static final String DE_DrugExpDate_Error_Message ="//*[@id='prescription-rx-product-create-form']/div[3]/md-input-container[1]/div[2]/div";
    public static final String DE_Quantity_Error_Message="//*[@id='prescription-rx-product-create-form']/div[3]/md-input-container[1]/div[2]/div";
    public static final String DE_Quantity_Disp_Error_Message="//*[@id='prescription-rx-product-create-form']/div[3]/md-input-container[3]/div[2]/div";
    public static final String DE_rxExpDate_Error_Message="//*[@id='prescription-rx-product-create-form']/div[4]/md-input-container[4]/div[2]/div";
    public static final String DE_Directions_Error_Message="//*[@id='prescription-rx-product-create-form']/div[4]/md-input-container[1]/div[3]/div";
    public static final String DE_DaysSupply_Error_Message="//*[@id='prescription-rx-product-create-form']/div[4]/md-input-container[2]/div[2]/div";
    public static final String DE_Refills_Error_Message="//*[@id='prescription-rx-product-create-form']/div[4]/md-input-container[3]/div[2]/div";
    public static final String DE_back_arrow_Button="//*[@id='back-button-data-entry']";
    public static final String patient_name_hyperLink_container ="//*[@id='rxms-main-container']/ng-outlet/rxms-prescription/form/rxms-secondary-toolbar/md-toolbar/div/ng-transclude/rxms-view-patient-information/div/div/md-input-container[1]";

    public static final String UPDATE_RX_REFILL="//*[@id='number-refill']";
    public static final String DRUG_SEARCH_PAGE_VIEW_BUTTON= "//*[@id='bottom-tray']/md-toolbar/div/ng-transclude/button";
    
    public static final String DE_FunctionPopup = "//*[@id='dialogContent_main-data-entry-button-toolbar-cancel-confirm']";
    public static final String DE_FunctionPopup_Msg1 = "//*[@id='dialogContent_main-data-entry-button-toolbar-cancel-confirm']/div/p[1]";
    public static final String DE_FunctionPopup_Msg2 = "//*[@id='dialogContent_main-data-entry-button-toolbar-cancel-confirm']/div/p[2]";
    public static final String updateRx_CashMessage = "//*[@id='payment-information-content-collapsed']/p/span[2]";
    
    public static final String DE_Prescriber_Search_Error_message = "//*[@id='rxms-main-container']/ng-outlet/rxms-prescription/form/md-sidenav/rxms-rx-prescriber-search-sidenav/div/rxms-rx-prescriber-search-results/div[1]/div[3]";
    public static final String DE_Prescriber_Search_close_button ="//*[@id='close-button-prescriber-search']/md-icon";
    public static final String DE_Prescriber_Search_Button_Expand_Window="//*[@id='rxms-main-container']/ng-outlet/rxms-prescription/form/md-sidenav/rxms-rx-prescriber-search-sidenav//*[@id='prescription-rx-prescriber-search-button-search']";
                                                                        
}
