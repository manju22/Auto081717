package hangOn;

public class hangOnConstants {


    public static final String BACK_BUTTON_PAT_PROFILE = "//*[@id='back-button-patient-profile']";
    public static final String RXMS_HOME_PAGE = "//*[@id='id-dashboard-button']";
    public static final String DRUG_CLINICAL_REF = "//*[@id='product-sidenav']/div[9]";
    public static final String DRUG_VIEW_BUT = "//*[@id='bottom-tray']/md-toolbar/div/ng-transclude/button";
    public static final String DRUG_CLI_REF = "//*[@id='clinical-ref-0']";
    public static final String INTAKE_CLOSE_BUT = "//*[@id='close-button-intake-method']";


    // constants for hangOn code
    //INTAKE PAGE CONTANTS
    public static final String RADIO_PICKUPLATER = "//*[@id='scanrx-radio-pickup']";
    public static final String ORIGIN_CODE_SCAN = "//*[@id='scanrx-radio-scan']";
    public static final String ORIGIN_CODE_FAX = "//*[@id='scanrx-radio-fax']";
    public static final String ORIGIN_CODE_PHONE = "//*[@id='scanrx-radio-phone']";
    public static final String INTAKE_CANCEL_BUTTON = "//*[@id='scanrx-button-cancel']";
    public static final String INTAKE_X_BUTTON = "//*[@id='close-button-intake-method']";
    public static final String PICKUP_LATER_DAY1 = "//*[@id='pickup-later-button-date-0']";
    public static final String PICKUP_LATER_DAY2 = "//*[@id='scanrx-form']/md-card[1]/md-card-content/div[2]/rxms-pickup-later/div/div[3]/div[2]";
    public static final String PICKUP_LATER_DAY3 = "//*[@id='scanrx-form']/md-card[1]/md-card-content/div[2]/rxms-pickup-later/div/div[3]/div[3]";
    public static final String PICKUP_LATER_DAY4 = "//*[@id='scanrx-form']/md-card[1]/md-card-content/div[2]/rxms-pickup-later/div/div[3]/div[4]";
    public static final String PICKUP_LATER_DAY5 = "//*[@id='scanrx-form']/md-card[1]/md-card-content/div[2]/rxms-pickup-later/div/div[3]/div[5]";
    public static final String PICKUP_LATER_DAY6 = "//*[@id='scanrx-form']/md-card[1]/md-card-content/div[2]/rxms-pickup-later/div/div[3]/div[6]";
    public static final String PICKUP_LATER_DAY7 = "//*[@id='scanrx-form']/md-card[1]/md-card-content/div[2]/rxms-pickup-later/div/div[3]/div[7]";
    public static final String PICKUP_LATER_TIME = "//*[@id='hour']";
    public static final String PICKUP_LATER_AMPM = "//*[@id='scanrx-form']/md-card[1]/md-card-content/div[2]/rxms-pickup-later/div/div[5]/md-input-container[2]";
    public static final String RADIO_PICKUP_WAITING = "//*[@id='scanrx-radio-waiting']";
    public static final String CE_REFERENCE_STOCKPLUS_LINK = "//*[text()='Stock+ Report']";

    public static final String PRESCRIBER_SEARCH_PAGE_RESULTS_TABLE = "//*[@id='prescriber-search-result-table']";
    public static final String PRESCRIBER_SEARCH_PAGE_RESULTS_TABLE_ADDRESSES = "//div[contains(@id,'singlerow-location-')]//div[contains(@data-title,'Address')]";
    public static final String PRESCRIBER_DETAILS_LOCATION_RESULTS = "//*[@id='prescriber-update-location-card']//md-content/md-content/div";
    public static final String PATIENT_SEARCH_PATIENT_PROFILE_THIRD_PARTY_PLANS_PAGE = "//*[contains(@id,'standard-plan-form-0')]";//"//*[@id='patient-plan-form']//div/strong";
    public static final String PATIENT_SEARCH_THIRD_PARTY_PLANS_RELATIONSHIP_TO_CARDHOLDER = "//md-select-value/span/div";
    public static final String PATIENT_SEARCH_THIRD_PARTY_PLANS_PLANHOLDER_NAME = "//*[@id='standard-plan-holder-name']";
    public static final String DATA_REVIEW_FIRST_ACCEPT_BUTTON_STATUS = "//*[@id='dr-patient-accept']/ng-bind-html//strong[contains(text(),'Unaccept')]";
    public static final String DATA_REVIEW_SECOND_ACCEPT_BUTTON_STATUS = "//*[@id='prescriber-review-buttons']//ng-bind-html//strong[contains(text(),'Unaccept')]";
    public static final String DATA_REVIEW_THIRD_ACCEPT_BUTTON_STATUS = "//*[@id='product-review-buttons']//ng-bind-html//strong[contains(text(),'Unaccept')]";


    //PATIENT ORDER STATUS PAGE
    public static final String POS_SEARCH_RESULT_MESSAGE = "//*[@id='rxms-main-container']/ng-outlet/rxms-patient-order-status/div/div/div/p";
    public static final String POS_DROP_DOWN = "//*[@id='patient-order-status-select-searchtype']";
    public static final String POS_SEARCH_RESULT_SECTION = "//*[@id='patient-order-status-table']";
    public static final String POST_SEARCH_ERROR_SECTION = "//*[@id='rxms-main-container']/ng-outlet/rxms-patient-order-status/div/div/div";
    public static final String DataEntry_RemsDrug_popup = "//*[@id='dialog-button-continueonicplus']";

    public static final String Intake_Cancel_Button = "//*[@id='scanrx-button-cancel']";
    public static final String Intake_Cancel_Popup_Yes_Button = "//*[@id='intake-cancel-confirm']/md-dialog-actions/button[1]";
    public static final String DE_Dispensed_Field = "//*[@id='dispensed']";
    public static final String CE_Prescribed_Drug = "//*[@id='prescribed-drug']";
    public static final String CE_RxDetails_HyperLink = "//*[@id='rx-details-rxnumber-button']";
    public static final String DE_Dispensed_Change_Button = "//*[@id='changebtnid']";

    public static final String DE_product_closed_not_completed_text = "//*[@id='product-info-closed']/div[1]/label";
    public static final String DE_payment_closed_not_completed_text = "//*[@id='payment-info-closed']/div[1]/label";

    public static final String Intake_payment_plan_summary = "//*[@id='no-patient-primary-plan']/div";
    public static final String DataEntry_payment_plan_summary = "//*[@id='payment-info']/div[1]";
    public static final String dr_product_update_btn = "//*[@id='dr-product-search']";
    public static final String Med_History_Next_To_InProgress_Expansion_Link = "//*[@id='down-arrow-icon-button-1']";
    public static final String Med_History_Fill_History = "//strong[@class='ng-binding' and contains(text(),'Fill History')]";
    public static final String Med_History_View_Link = "//a[@class='rx-link-focus md-accent ng-binding md-material-theme' and contains(text(),'View')]";
    public static final String Fill_History_PaymentType = "//*[@id='fill-history-payment-type']";
    public static final String DR_PhoneNo_Field = "//*[@id='phone']";

    public static final String MEd_history_presc_Status = "//a[contains(@id,'rx-history-status')]";
    public static final String rx_history_phonenum = "//*[@id='rx-history-storenumber']";
    public static final String medhistory_downArrow = "//*[contains(@id,'down-arrow-icon-button-']";

    public static final String Profile_Icone = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-team-members/div/div/md-content/div/div[1]/div/div[1]/div";
    public static final String Profile_TeamMember_Name = "//*[@id='rxms-main-container']/ng-outlet/rxms-member-view/div/md-content/div/rxms-team-members/div/div/md-content/div/div[1]/div/div[2]";

    //Med HIstory Tab in CE
    public static final String CE_MED_HISTORY_LAST_FILLED_DATE_COLUMN = "//*[@id='rx-history-lastfilldate']";

    //DE Quantity Error message
    public static final String DE_PRODUCT_QUANTITY_ERROR_MESSAGE = "  //*[@id='prescription-rx-product-create-form']/div[4]/md-input-container[3]/div[2]/div";

    //DR Image
    public static final String DR_image_rotate_clockwise = "//*[@aria-label='Rotate Clockwise']";
    public static final String DR_image_rotate_counterclockwise = "//*[@aria-label='Rotate Counterclockwise']";
    public static final String DR_image_zoom_in = "//*[@aria-label='Zoom In']";
    public static final String DR_image_zoom_out = "//*[@aria-label='Zoom Out']";
    public static final String DR_image_view_full_size = "//*[@aria-label='View image full screen']";
    public static final String DR_image_full_size_close = "/html/body/div[3]/md-dialog/md-dialog-actions/button";
    public static final String DR_image_reset = "//*[@aria-label='Reset Image']";
    public static final String DR_image_preview_close = "/html/body/div[3]/md-dialog/md-dialog-actions/button";
    public static final String PRESCRIBER_SEARCH_STATE_SELECTION_DE = "//*[@id='state-select']";
    public static final String Pending_Donut_Cancel_Popup = "//*[@id='donut-popup-dialog']/md-toolbar/div/button";

    public static final String DE_QtyErrorMsg = "//div[contains(., 'the qty entered should be a multiple of 28.35')]";


    public static final String DE_Prescriber_Clear_Field = "//*[@id='prescription-search-prescriber-button-clearfield']";
    public static final String CH_Drug_Details_Rowone = "//*[@id='down-arrow-icon-button-1']";
    public static final String DE_No_Dispensed_Drug_Error = "//*[@id='product-info']/div[3]/div[1]/md-input-container/div[2]/div";
    public static final String DE_Entire_Screen_Down_Buttons = "//*[@id='main-data-entry-div-bottom-buttons']/md-toolbar";
    public static final String DE_Prescriber_Empty_Screen = "//*[@id='prescription-search-prescriber-form']/div[3]/div";
    public static final String DR_PhoneErrorMsg = "//*[@id='main-notification-toast']/div";
    public static final String DR_PhoneNo = "//*[@id='phone']";
    public static final String DR_PhoneNo_Focus = "//*[@id='prescription-rx-prescriber-search-form']/div[1]/md-input-container[1]";
    public static final String CE_Rxnumber_Window_Page_Popup="//*[contains(@class,'rx-entry-label')]";
    
    public static final String CE_RxDetails_Popup_Window = "//*[@id='view-prescription-information-content']";
    public static final String DR_Last_Name = "//*[@id='last-name']";
    public static final String DR_First_Name = "//*[@id='first-name']";
    public static final String DR_PhoneNo_Name = "//*[@id='phone']";
    public static final String DR_State_Dropdown = "//*[@id='prescriber-search-dropdown']//*[contains(@class,'md-select-icon')]";

}