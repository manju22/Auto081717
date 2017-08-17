package framework;


public final class FrameworkConstants {
    public static final String APKPATH = "apkPath";
    public static final String DEVICENAME = "deviceName";
    public static final String PLATFROMVERSION = "platformVersion";
    public static final String PLATFROMNAME = "platformName";
    public static final String HUBURL = "hubURL";
    public static final String APPPAKAGE = "";
    public static final String APPACTIVITY = "";
    public static final String BROWSERURL = "browserURL";
    public static final String ENVIRONMENT = "env";


    //Xpath

    public static final String PATIENT_SEARCH = "//*[@id='main-left-sidenav-burger-menu']/md-list/md-list-item[2]";
    public static final String PATIENT_LN = "//*[@id='input-lname-patient']";
    public static final String PATIENT_SEARCH_BTN = "//*[@id='patient-submit']";
    public static final String SEARCH_FAIL_MESSAGE_PATH = "//*[@id='patient-table']/md-content/div/p";
    public static final String PATIENT_SEARCH_RESULT_TABLE = "//*[@id='patient-table']/md-content/div[1]/div/div[1]/div[1]";
    public static final String ADD_NEW_PATIENT_BTN = "//*[@id='patient-add-button']";
    public static final String ADD_NEW_PATIENT_POPUP_OK = "/html/body/div[2]/md-dialog/md-dialog-actions/button";


    public static final String USER_NAME = "//*[@id='username-input']";
    public static final String PASSWORD = "//*[@id='password-input']";
    public static final String LOGIN = "//*[@id='login-button']";

    public static final String PATIENT_SEARCH_LN = "//*[@id='input-lname-patient']";
    public static final String PATIENT_SEARCH_FN = "//*[@id='input-fname-patient']";
    public static final String PATIENT_SEARCH_PHONE = "//*[@id='input-phone-patient']";
    public static final String PATIENT_SEARCH_DOB = "//*[@id='input_2']";

    public static final String SELECT_PATIENT = "//*[@id='patient-table']/md-content/div[1]/div/div[1]/div[1]";
    public static final String PATIENT_VIEW_BTN = "//*[@id='patient-view-button']";

    public static final String INTAKE_RX_BTN = "//*[@id='patient-view-button-bar-button-intake']";
    public static final String INPUT_ORGIN_CODE_FAX = "//*[@id='scanrx-radio-fax']/div[1]/div[1]";
    public static final String INTAKE_FINISH = "//*[@id='scanrx-button-finish']";

    public static final String GET_PATIENT_FN_LN = "//*[@id='div-rx-entry']/div[1]/rxms-main-patient-toolbar/rxms-secondary-toolbar/md-toolbar/div/ng-transclude/rxms-view-patient-information/div/md-input-container[1]";
    public static final String GET_PATIENT_PHONE = "//*[@id='div-rx-entry']/div[1]/rxms-main-patient-toolbar/rxms-secondary-toolbar/md-toolbar/div/ng-transclude/rxms-view-patient-information/div/md-input-container[6]";
    public static final String SEND_IC_PLUS_BTN = "//*[@id='main-data-entry-button-toolbar-sendtoicplus']";

    public static final String WALKIN_OR_SCAN_RX = "//*[@id='intake-dialog']/md-content/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item";
    public static final String SCAN_IMAGE_ROTATE_CLOCKWISE = "//md-icon[contains(text(),'rotate_left')]";
    public static final String SCAN_IMAGE_ZOOMIN = "//md-icon[contains(text(),'zoom_in')]";
    public static final String SCAN_IMAGE_ZOOMOUT = "//md-icon[contains(text(),'zoom_out')]";
    public static final String SCAN_IMAGE_BACK_SIDE = "//*[@id='sub-tabs']/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]/span";
    public static final String SCAN_IMAGE_RESTORE = "//md-icon[contains(text(),'restore')]";

    public static final String DENumberofTasks = "//*[@id='main-right-sidenav-burger-menu-DE']/div[2]/span[1]";
    public static final String CLICK_DE = "//*[@id='main-right-sidenav-burger-menu-DE']/div[2]/span[1]";
    public static final String PRESCRIBER_LN = "//*[@id='prescriber-information-card']//input[@id='last-name']";
    public static final String PRESCRIBER_FN = "//*[@id='prescriber-information-card']//input[@id='first-name']";
    public static final String PRESCRIBER_SEARCH_BTN = "//*[@id='prescriber-information-card']//*[@id='prescription-search-prescriber-button-search']";
    public static final String PRESCRIBER_PAGE_SEARCH_BTN="//*[@id='prescriber-search']";

    public static final String Open_Product = "//*[@id='product-info-button-openproduct']";
    public static final String Product_OriginalDate = "//*[@id='orig-data']";
    public static final String Product_DAW = "//*[@id='prescription-rx-product-create-form']/div[1]/md-input-container[2]//*[starts-with(@id,'input_')]";
    public static final String substitute = "//*[@id='prescription-rx-product-create-form']/div[1]/md-input-container[3]//*[starts-with(@id,'input_')]";
    public static final String DrugName_Field = "//*[@id='input-autocomplete-location']";
    public static final String DrugExpiryDate_Field = "//*[@id='drug-exp-date']";
    public static final String Quantity_field = "//*[@id='qty']";
    public static final String Quantity_disp = "//*[@id='qty-disp']";
    public static final String Refills_field = "//*[@id='refills']";
    public static final String RxExpiration_date = "//*[@id='rx-exp-date']";
    public static final String Directions_field = "//*[@id='directions']";
    public static final String Days_Supply = "//*[@id='day-supply']";
    public static final String SELECT_PRESCRIBER_BTN = "//*[@id='main-data-prescriber-sidenav-button-select']";

    public static final String OPEN_PAYMENT = "//*[@id='payment-info-button-openpayment']/md-icon";
    public static final String PAYMENT_DROPDOWN = "//*[@id='payment-type-input']";
    public static final String CASH_OPTION = "//*[@id='payment-info-button-cash']/span";
    public static final String DE_FINISH = "//*[@id='main-data-entry-button-toolbar-finish']";

    public static final String DR_CLICK = "//*[@id='main-right-sidenav-burger-menu-DR']/div[2]/span[1]";
    public static final String DR_ALERT_OK_BTN = "//*[@id='main-data-entry-button-toolbar-cancel-confirm']/md-dialog-actions/button[2]";
    public static final String DR_PATIENT_ACCEPT_BTN = "//*[@id='dr-patient-accept']";
    public static final String DR_PRESCRIBER_ACCEPT_BTN = "//*[@id='dr-prescriber-accept']";
    public static final String DR_PRODUCT_ACCEPT_BTN = "//*[@id='dr-product-accept']/ng-bind-html";
    public static final String DR_FINISH = "//*[@id='dr-form-finish']";
    public static final String DR_SEARCH_PATIENT = "//*[@id='dr-patient-search']";
    public static final String DR_SEARCH_PATIENT_POPUP = "//*[@id='dialog-button-confirm']";
    public static final String DR_SEARCH_PRESCRIBER = "//*[@id='dr-prescriber-search']";
    public static final String DR_PRE_LAST_NAME = "//*[@id='data-entry-prescriber-sidenav']//*[@id='last-name']";
    public static final String DR_PRE_FIRST_NAME = "//*[@id='data-entry-prescriber-sidenav']//*[@id='first-name']";
    public static final String DR_PRE_SEARCH_BTN = "//*[@id='data-entry-prescriber-sidenav']//*[@id='prescription-search-prescriber-button-search']";
    public static final String DR_PRE_SELECT = "//*[@id='prescriber-location-result-4-0']/div[1]/div/div[2]";
    public static final String DR_PRE_SELECT_BTN = "//*[@id='main-data-prescriber-sidenav-button-select']";

    public static final String DR_PRODUCT_UPDATE_BTN = "//*[@id='dr-product-search']";
    public static final String DR_CLICK_PAYMENT = "//*[@id='payment-info-buttonicon-down']/i";
    public static final String DR_SELECT_PAYMENT_TYPE_CASH = "//*[@id='payment-info-button-cash']";
    public static final String DR_SEND_IC_PLUS_BTN = "//*[@id='main-data-entry-button-toolbar-sendtoicplus']";

    public static final String LOGOUT = "//*[@id='main-left-sidenav-button-logout']/div[1]/md-icon";
    public static final String LOGOUT_THIS_DEVICE = "//*[@id='bottom-tray']/md-toolbar/div/ng-transclude/button[1]";
    public static final String DR_DESABLED = "//*[@id='main-right-sidenav-burger-menu-DR']";


}
