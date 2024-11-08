package com.conurets.parking_kiosk.base.util;

/**
 * @author Adeel Ali
 * @version 1.0
 */

public class PKStatusConstants {
    public static final int STATUS_CODE_SUCCESS = 200;
    public static final String STATUS_MSG_SUCCESS = "success";
    public static final int STATUS_CODE_ADDED_SUCCESS = 200;
    public static final String STATUS_MSG_ADDED_SUCCESS = "Added Successfully";
    public static final String STATUS_MSG_CHECKED_IN_SUCCESS = "Checked-In Successfully";
    public static final int STATUS_CODE_UPDATE_SUCCESS = 204;
    public static final String STATUS_MSG_UPDATE_SUCCESS = "Updated Successfully";
    public static final String STATUS_MSG_CHECKED_OUT_SUCCESS = "Checked-Out Successfully";

    public static final String STATUS_MSG_CHECKED_OUT_PREVIOUS_WORKING_DAY = "Kindly Check-Out Previous Working Day !";
    public static final int STATUS_CODE_DELETE_SUCCESS = 204;
    public static final String STATUS_MSG_DELETE_SUCCESS = "Deleted Successfully";
    public static final int STATUS_CODE_SOMETHING_WENT_WRONG = 500;
    public static final String STATUS_MSG_SOMETHING_WENT_WRONG = "Something Went Wrong";

    public static final int CODE_INTERNAL_SERVER_ERROR = 500;
    public static final String MSG_INTERNAL_SERVER_ERROR = "Internal Server Error";
    public static  final String FORGET_PASSWORD_TOKEN_EXPIRED="Forget token expired";
    public static final int CODE_BAD_GATEWAY = 502;
    public static final String MSG_BAD_GATEWAY = "Bad Gateway";



    public static final int CONURE_ORGANIZATION_ID = 1;
    public static final String CONURE_ORGANIZATION_NAME = "Conure Telecom Service";
    public static final int STATUS_CODE_RECORD_ALREADY_EXISTS = 409;
    public static final String STATUS_MSG_RECORD_ALREADY_EXISTS = "Record Already Exists";
    public static final int STATUS_CODE_EMAIL_ALREADY_EXISTS = 409;
    public static final String STATUS_MSG_EMAIL_ALREADY_EXISTS = "EmailAddress Already Exists";
    public static final int STATUS_CODE_RECORD_VEHICLE_LIMIT_EXHAUSTED = 429;
    public static final String STATUS_MSG_RECORD_VEHICLE_LIMIT_EXHAUSTED = "Vehicle Limit Exhausted";

    public static final int STATUS_CODE_NO_VEHICLE_FOUND = 404;
    public static final String STATUS_MSG_NO_VEHICLE_FOUND = "No vehicle found";

    public static final int STATUS_CODE_RECORD_PERMIT_LIMIT_EXHAUSTED = 429;
    public static final String STATUS_MSG_RECORD_PERMIT_LIMIT_EXHAUSTED = "Sorry permit and wait list limit both are exhausted";

    public static final int STATUS_CODE_RECORD_VISITOR_PERMIT_LIMIT_EXHAUSTED = 429;
    public static final String STATUS_MSG_RECORD_VISITOR_PERMIT_LIMIT_EXHAUSTED = "Error! permit inventory exhausted";


    public static final int STATUS_CODE_RECORD_HANDICAP_NOT_AVAILABLE = 7;
    public static final String STATUS_MSG_RECORD_HANDICAP_NOT_AVAILABLE = "Error! Handicap parking is not available";

    public static final int STATUS_CODE_RECORD_EV_PARKING_NOT_AVAILABLE = 8;
    public static final String STATUS_MSG_RECORD_EV_PARKING_NOT_AVAILABLE = "Error! EV parking is not available";

    public static final int STATUS_CODE_RECORD_INVALID_SPOT_TYPE = 9;
    public static final String STATUS_MSG_RECORD_INVALID_SPOT_TYPE = "Error! Invalid parking spot";

    public static final int STATUS_CODE_RECORD_WAIT_LIST_CHECK = 429002;
    public static final String STATUS_MSG_RECORD_WAIT_LIST_CHECK = "Permit limit exhausted and You are already in the wait list of selected parking lot";

    public static final int STATUS_CODE_RECORD_WAIT_LIST_CREATED = 429003;
    public static final String STATUS_MSG_RECORD_WAIT_LIST_CREATED = "Permit already created against this wait list record";

    public static final String STATUS_MSG_RECORD_WAIT_LIST_CANCELLED_BY_USER = "wait list record has been cancelled by user";

    public static final String STATUS_MSG_RECORD_WAIT_LIST_CANCELLED_BY_ADMIN = "wait list record has been cancelled by admin";

    public static final int STATUS_CODE_NO_INVENTORY_EXISTS = 404;
    public static final String STATUS_MSG_NO_INVENTORY_EXISTS = "No Inventory exits";

    public static final int STATUS_CODE_RECORD_PERMIT_CHECK = 429;
    public static final String STATUS_MSG_RECORD_PERMIT_CHECK = "Permit limit exhausted. Do you want to add in wait list?";


    public static final int STATUS_CODE_RECORD_PERMIT_AGAINST_PARKING_LOT_CHECK = 430;
    public static final String STATUS_MSG_RECORD_PERMIT_AGAINST_PARKING_LOT_CHECK = "Error! selected parking lot already exists in your permit";

    public static final int STATUS_CODE_PERMIT_LIMIT_CHECK = 431;
    public static final String STATUS_MSG_PERMIT_LIMIT_CHECK = "Permits are full";
    public static final String STATUS_MSG_CARPOOL_PERMIT_LIMIT_CHECK = "Permit for this user already exist.";
    public static final int STATUS_CODE_CARPOOL_REQUEST_LIMIT_CHECK = 432;
    public static final String STATUS_MSG_CARPOOL_REQUEST_LIMIT_CHECK = "Carpool Request Already Exist";


    public static final int STATUS_CODE_CARPOOL_REQUEST_USER_CHECK = 433;
    public static final String STATUS_MSG_CARPOOL_REQUEST_USER_CHECK = "Only Student or Faculty can create Carpool Request";

    public static final int STATUS_CODE_CARPOOL_REQUEST_USER_TYPE_CHECK = 434;
    public static final String STATUS_MSG_CARPOOL_REQUEST_USER_TYPE_CHECK = "Error! your member user type can only be : ";

    public static final int STATUS_CODE_PURCHASING_DATE = 435;

    public static final String CARPOOL_TYPR_PUBLIC = "Public";

    public static final int STATUS_CODE_NO_PERMIT_FOUND = 432;
    public static final String STATUS_MSG_NO_PERMIT_FOUND = "No permit found";

    public static final int STATUS_CODE_RECORD_PERMIT_RENEWAL = 1;
    public static final String STATUS_MSG_RECORD_PERMIT_RENEWAL = "Error, fall semester permits are not allowed to renewed";

    public static final int STATUS_CODE_SEMESTER_DETAIL = 1;
    public static final String STATUS_MSG_SEMESTER_DETAIL = "Error, semester detail mapping is missing for selected year";

    public static final String STATUS_POS_PERMIT_TYPE = "permits";
    public static final String STATUS_POS_PARTNER_PAYMENT_TYPE = "partner payments";
    public static final String STATUS_POS_EVENT_PAYMENT_TYPE = "event payments";
    public static final String STATUS_POS_VISITOR_PAYMENT_TYPE = "visitor payments";
    //TransactionActionType
    public static final String TRANSACTION_ACTION_TYPE_PERMIT = "Permit";
    public static final int TRANSACTION_ACTION_TYPE_CODE_PERMIT = 1;
    public static final String TRANSACTION_ACTION_TYPE_INVOICE = "Invoice";
    public static final int TRANSACTION_ACTION_TYPE_CODE_REFUND = 3;


    public static final String TRANSACTION_ACTION_TYPE_REFUND = "refund";
    public static final String TRANSACTION_ACTION_TYPE_PARTNER_PERMIT = "Partner Permit";
    public static final String TRANSACTION_ACTION_TYPE_VENDOR_PERMIT = "Vendor Permit";
    public static final String TRANSACTION_ACTION_TYPE_CITATION = "Citation";
    public static final String TRANSACTION_ACTION_TYPE_CARPOOL = "Carpool";

    // Dummy User
    public static final String DUMMY_USER_VENDOR_EMAIL = "dummyVendor@suny.com";
    public static final String DUMMY_USER_VISITOR_EMAIL = "dummyVisitor@suny.com";
    public static final String DUMMY_USER_EVENT_VISITOR_EMAIL = "dummyEventVisitor@suny.com";
    public static final String DUMMY_USER_EVENT_MANAGER_EMAIL = "dummyEventManager@suny.com";
    public static final String DUMMY_USER_EVENT_GUEST_EMAIL = "dummyEventGuest@suny.com";
    //Permit Type Statics
    public static final String STUDENT_PERMIT_TYPE_VALUE = "Student";
    public static final int STUDENT_PERMIT_TYPE_CODE = 1;
    public static final String FACULTY_PERMIT_TYPE_VALUE = "Faculty / Staff";
    public static final int FACULTY_PERMIT_TYPE_CODE = 2;
    public static final String VISITOR_PERMIT_TYPE_VALUE = "Visitor";
    public static final String EVENT_GUEST_PERMIT_TYPE_VALUE = "Event Guest";
    public static final String EVENT_VISITOR_PERMIT_TYPE_VALUE = "Event Visitor";
    public static final String VENDOR_EMPLOYEE_PERMIT_TYPE_VALUE = "Vendor Employee";
    public static final String PARTNER_EMPLOYEE_PERMIT_TYPE_VALUE = "Partner Employee";
    public static final String WHITE_LIST_PERMIT_TYPE_VALUE = "White List";

    //Refund Type
    public static final String STUDENT_REFUND_TYPE_VALUE = "Student Permit";
    public static final String FACULTY_REFUND_TYPE_VALUE = "Faculty/Staff Permit";
    public static final String EVENT_GUEST_REFUND_TYPE_VALUE = "Event Guest Permit";
    public static final String EVENT_VISITOR_REFUND_TYPE_VALUE = "Event Visitor Permit";
    public static final String EVENT_REFUND_TYPE_VALUE = "Event";
    public static final String CARPOOL_REFUND_TYPE_VALUE = "Carpool Permit";
    public static final String VISITOR_REFUND_TYPE_VALUE = "Visitor Permit";
    public static final Long PARTNER_EMPLOYEE_REFUND_TYPE_ID = 8l;
    public static final String PARTNER_EMPLOYEE_REFUND_TYPE_VALUE = "Partner Employee Permit";
    public static final String VENDOR_EMPLOYEE_REFUND_TYPE_VALUE = "Vendor Permit";
    public static final String PARTNER_PAYMENT_TYPE_VALUE = "Partner Payment";
    public static final String VENDOR_REFUND_TYPE_VALUE = "Vendor";

    // OTP Types
    public static final String OTP_VISITOR_REFUND_TYPE_VALUE = "Refund Visitor Permit";

    //Transaction
    public static final String TRANSACTION_TYPE_SALE = "sale";
    public static final String TRANSACTION_TYPE_REFUND = "refund";

    //Adjustment History type
    public static final String ADJUSTMENT_HISTORY_TYPE_PERMIT = "Permit Transaction";
    public static final String ADJUSTMENT_HISTORY_TYPE_CARPOOL = "Carpool Transaction";
    public static final String ADJUSTMENT_HISTORY_TYPE_EVENT = "Event Transaction";

    //Invoice Type
    public static final String EVENT_INVOICE_TYPE_VALUE = "Event";
    public static final String VENDOR_INVOICE_TYPE_VALUE = "Vendor";

    //Invoice Products
    public static final String INVOICE_PRODUCT_PARKING_LOT = "Parking Lot";
    public static final String INVOICE_PRODUCT_PARKING_LOT_PLAN = "Parking Lot Plan";
    public static final String INVOICE_PRODUCT_GURST_PERMIT = "Guest Permit";
    public static final String INVOICE_PRODUCT_VOLUNTEER = "Volunteer";
    public static final String INVOICE_PRODUCT_ADMISSION_COST = "Admission Cost";
    public static final String INVOICE_PRODUCT_VENDOR_PERMIT = "Vendor Permit";

    public static final String EVENT_PERMIT_INVOICE_DESCRIPTION = "Permit Amount";

    public static final int INVENTORIED_SPOT_TYPE_CODE = 1;
    public static final String INVENTORIED_SPOT_TYPE_NAME = "INVENTORIED";

    public static final int NONINVENTORIED_SPOT_TYPE_CODE = 2;
    public static final String NONINVENTORIED_SPOT_TYPE_NAME = "NONINVENTORIED";

    public static final int NORMAL_SPOT_DETAIL_TYPE_CODE = 4;
    public static final String NORMAL_SPOT_DETAIL_TYPE_NAME = "Normal";

    public static final int RESERVED_SPOT_TYPE_CODE = 3;
    public static final String RESERVED_SPOT_TYPE_NAME = "RESERVED";

    public static final int HANDICAP_SPOT_TYPE_CODE = 4;
    public static final String HANDICAP_SPOT_TYPE_NAME = "HANDICAP";

    public static final int EV_PARKING_SPOT_TYPE_CODE = 5;
    public static final String EV_PARKING_SPOT_TYPE_NAME = "EV PARKING";

    public static final int SPECIAL_PERMIT_SPOT_TYPE_CODE = 6;
    public static final String SPECIAL_PERMIT_SPOT_TYPE_NAME = "SPECIAL PERMIT";


    public static final int DAY_PARKING_PRICING_TYPE_CODE = 1;
    public static final String DAY_PRICING_TYPE_NAME = "DAY";

    public static final int WEEKLY_PRICING_TYPE_CODE = 2;
    public static final String WEEKLY_PRICING_TYPE_NAME = "WEEKLY";

    public static final int SPRING_SEMESTER_PRICING_TYPE_CODE = 3;
    public static final String SPRING_SEMESTER_PRICING_TYPE_NAME = "SPRING SEMESTER";

    public static final int SUMMER_SEMESTER_1_PRICING_TYPE_CODE = 4;
    public static final String SUMMER_SEMESTER_1_PRICING_TYPE_NAME = "SUMMER SEMESTER 1";

    public static final int SUMMER_SEMESTER_2_PRICING_TYPE_CODE = 5;
    public static final String SUMMER_SEMESTER_2_PRICING_TYPE_NAME = "SUMMER SEMESTER 2";

    public static final int FALL_SEMESTER_PRICING_TYPE_CODE = 6;
    public static final String FALL_SEMESTER_PRICING_TYPE_NAME = "FALL SEMESTER";

    public static final int YEARLY_PRICING_TYPE_CODE = 7;
    public static final String YEARLY_PRICING_TYPE_NAME = "YEARLY";

    public static final int MONTHLY_PRICING_TYPE_CODE = 8;
    public static final String MONTHLY_PRICING_TYPE_NAME = "MONTHLY";

    public static final int UNLIMITED_PRICING_TYPE_CODE = 9;
    public static final String UNLIMITED_PRICING_TYPE_NAME = "UNLIMITED";

    public static final int EMPTY_PRICING_TYPE_CODE = -1;

    public static final int FAILED_TRANSACTION_CODE = -1;

    //UNASSIGNED
    public static final int ASSIGNED_WAIT_LIST_TYPE_CODE = 1;
    public static final String ASSIGNED_WAIT_LIST_TYPE_NAME = "ASSIGNED";

    public static final int UNASSIGNED_WAIT_LIST_TYPE_CODE = 2;
    public static final String UNASSIGNED_WAIT_LIST_TYPE_NAME = "UNASSIGNED";

    public static final int CANCELLED_BY_USER_WAIT_LIST_TYPE_CODE = 3;
    public static final String CANCELLED_BY_USER_WAIT_LIST_TYPE_NAME = "CANCELLED_BY_USER";

    public static final int CANCELLED_BY_ADMIN_WAIT_LIST_TYPE_CODE = 4;
    public static final String CANCELLED_BY_ADMIN_WAIT_LIST_TYPE_NAME = "CANCELLED_BY_ADMIN";


    public static final int WAIT_LIST_EMAIL_SENT_CODE = 1;
    public static final String WAIT_LIST_EMAIL_SENT_NAME = "Sent";

    public static final int WAIT_LIST_EMAIL_REMAINING_CODE = 2;
    public static final String WAIT_LIST_EMAIL_REMAINING_NAME = "Remaining";

    public static final int WAIT_LIST_EMAIL_DISCARD_CODE = 3;
    public static final String WAIT_LIST_EMAIL_DISCARD_NAME = "Discard";

    public static final String EMAIL_SENT = "Email Sent to Your Email Address";

/*    public static final String NORMAL_VISITOR_USER_TYPE_VALUE = "Normal";
    public static final String EVENT_MANAGER_USER_TYPE_VALUE = "Event Manager";
    public static final String CONTRACTOR_USER_TYPE_VALUE = "CONTRACTOR";*/

    public static final int PAID_TRANSACTION_TYPE_CODE = 1;
    public static final String PAID_TRANSACTION_TYPE_NAME = "PAID";

    public static final int UNPAID_TRANSACTION_TYPE_CODE = 2;
    public static final String UNPAID_TRANSACTION_TYPE_NAME = "UNPAID";

    public static final int PAYMENT_GATEWAY_PROCESSING_FAILED_TRANSACTION_TYPE_CODE = 3;
    public static final String PAYMENT_GATEWAY_PROCESSING_FAILED_TRANSACTION_TYPE_NAME = "PAYMENT_GATEWAY_PROCESSING_FAILED";

    public static final int INACTIVE_PAID_TRANSACTION_TYPE_CODE = 4;
    public static final String INACTIVE_PAID_TRANSACTION_TYPE_NAME = "INACTIVE_PAID";

    public static final int REFUND_TRANSACTION_TYPE_CODE = 5;
    public static final String REFUND_TRANSACTION_TYPE_NAME = "REFUND";

    public static final int CREDIT_CARD_PAYMENT_TYPE_CODE = 1;
    public static final String CREDIT_CARD_PAYMENT_TYPE_NAME = "CREDIT_CARD";

    public static final int PAYMENT_GATEWAY_PAYMENT_TYPE_CODE = 2;
    public static final String PAYMENT_GATEWAY_PAYMENT_TYPE_NAME = "PAYMENT_GATEWAY";

    public static final int UNIVERSITY_PAYROLL_PAYMENT_TYPE_CODE = 3;
    public static final String UNIVERSITY_PAYROLL_PAYMENT_TYPE_NAME = "UNIVERSITY_PAYROLL";

    public static final int VENDOR_PAYROLL_PAYMENT_TYPE_CODE = 4;
    public static final String VENDOR_PAYROLL_PAYMENT_TYPE_NAME = "VENDOR_PAYROLL";

    public static final int UNIVERSITY_FEES_PAYMENT_TYPE_CODE = 5;
    public static final String UNIVERSITY_FEES_PAYMENT_TYPE_NAME = "UNIVERSITY_FEES";

    public static final int CASH_PAYMENT_TYPE_CODE = 7;
    public static final String CASH_PAYMENT_TYPE_NAME = "CASH";

    public static final int TO_BE_PAY_BY_COMPANY_TYPE_CODE = 6;
    public static final String TO_BE_PAY_BY_COMPANY_TYPE_NAME = "TO_BE_PAY_BY_COMPANY";

    public static final int In_PROCESS_EVENT_STATUS_TYPE_CODE = 1;
    public static final String In_PROCESS_EVENT_STATUS_TYPE_NAME = "InProcess";

    public static final int INVOICE_SENT_EVENT_STATUS_TYPE_CODE = 2;
    public static final String INVOICE_SENT_EVENT_STATUS_TYPE_NAME = "Invoice Sent";

    public static final int INVOICE_PAID_EVENT_STATUS_TYPE_CODE = 7;
    public static final String INVOICE_PAID_EVENT_STATUS_TYPE_NAME = "Invoice Paid";

    public static final int APPROVE_EVENT_STATUS_TYPE_CODE = 3;
    public static final String APPROVE_EVENT_STATUS_TYPE_NAME = "Approve";

    public static final int REJECT_EVENT_STATUS_TYPE_CODE = 4;
    public static final String REJECT_EVENT_STATUS_TYPE_NAME = "Reject";

    public static final int CANCEL_BY_USER_EVENT_STATUS_TYPE_CODE = 5;
    public static final String CANCEL_BY_USER_EVENT_STATUS_TYPE_NAME = "Cancel By User";

    public static final int CANCEL_BY_USER_ADMIN_STATUS_TYPE_CODE = 6;
    public static final String CANCEL_BY_USER_ADMIN_STATUS_TYPE_NAME = "Cancel By Admin";

    public static final int REFUND_EVENT_STATUS_TYPE_CODE = 13;
    public static final String REFUND_EVENT_STATUS_TYPE_NAME = "Refund";

    // USER TYPE NAME
    public static final int STUDENT_USER_TYPE_CODE = 1;
    public static final String STUDENT_USER_TYPE_NAME = "STUDENT";

    public static final int FACULTY_USER_TYPE_CODE = 2;
    public static final String FACULTY_USER_TYPE_NAME = "FACULTY / STAFF";

    public static final int NORMAL_VISITOR_USER_TYPE_CODE = 3;
    public static final String NORMAL_VISITOR_USER_TYPE_NAME = "USER_TYPE_NORMAL_VISITOR";

    public static final int EVENT_MANAGER_USER_TYPE_CODE = 4;
    public static final String EVENT_MANAGER_USER_TYPE_NAME = "EVENT MANAGER";

    public static final int VENDOR_USER_TYPE_CODE = 5;
    public static final String VENDOR_USER_TYPE_NAME = "VENDOR";

    public static final int ADMIN_USER_TYPE_CODE = 6;
    public static final String ADMIN_USER_TYPE_NAME = "ADMIN";
    //EVENT GUEST
    public static final int EVENT_GUEST_USER_TYPE_CODE = 7;
    public static final String EVENT_GUEST_USER_TYPE_NAME = "EVENT GUEST";

    public static final int EVENT_VISITOR_USER_TYPE_CODE = 8;
    public static final String EVENT_VISITOR_USER_TYPE_NAME = "EVENT VISITOR";

    public static final int PARTNER_MANAGER_USER_TYPE_CODE = 9;
    public static final String PARTNER_MANAGER_USER_TYPE_NAME = "PARTNER MANAGER";

    public static final int PARTNER_EMPLOYEE_USER_TYPE_CODE = 10;
    public static final String PARTNER_EMPLOYEE_USER_TYPE_NAME = "PARTNER EMPLOYEE";

    public static final int POINT_OF_SALES_USER_TYPE_CODE = 11;
    public static final String POINT_OF_SALES_USER_TYPE_NAME = "POINT OF SALES";

    public static final int PARTNER_MANAGER_USER_ROLE_CODE = 9;
    public static final String PARTNER_MANAGER_USER_ROLE_NAME = "ROLE_PARTNER_MANAGER";

    public static final String EVENT_MANAGER_USER_ROLE_NAME = "ROLE_EVENT_MANAGER";

    public static final int PARTNER_EMPLOYEE_USER_ROLE_CODE = 10;
    public static final String PARTNER_EMPLOYEE_USER_ROLE_NAME = "ROLE_PARTNER_EMPLOYEE";


    public static final String USA_COUNTRY_NAME = "United States of America";


    public static final String INVOICE_STATUS_TYPE_PAID = "Paid";
    public static final String INVOICE_STATUS_TYPE_UNPAID = "UnPaid";
    public static final String INVOICE_STATUS_TYPE_DRAFT = "Draft";
    public static final String INVOICE_STATUS_TYPE_REFUND = "Refund";


    public static final String ADDRESS_TYPE_HOME = "HOME";
    public static final String ADDRESS_TYPE_MAILING = "MAILING";
    public static final String ADDRESS_TYPE_CAMPUS = "CAMPUS";
    public static final String ADDRESS_TYPE_COMPANY = "COMPANY";

    public static final int STATUS_CODE_NO_RESULT_FOUND = 404; // Not Found
    public static final String STATUS_MSG_NO_RESULT_FOUND = "No result found";
    public static final String STATUS_MSG_NO_RESULT_FOUND_ZONE = "No Zone found for the specified address.";
    public static final int STATUS_CODE_ALREADY_EXISTS = 409; // Conflict
    public static final String STATUS_MSG_ALREADY_EXISTS = "Resource already exists.";

    public static final int INVALID_PARAMETERS_CODE = 400; // Bad Request
    public static final String INVALID_PARAMETERS_MESSAGE = "Invalid parameters.";

    public static final int STATUS_CODE_INVALID_SESSION = 401; // Unauthorized
    public static final String STATUS_MSG_INVALID_SESSION = "Invalid session";

    public static final int FAILED_TRANSACTION = 500; // Internal Server Error
    public static final String STATUS_FAILED_TRANSACTION = "Transaction failed";

    public static final int FAILED_TRANSACTION_TYPE = 400; // Bad Request
    public static final String STATUS_FAILED_TRANSACTION_TYPE = "Invalid transaction type";

    public static final int FAILED_REFUND = 500; // Internal Server Error
    public static final String STATUS_FAILED_REFUND = "Refund failed";

    public static final int FAILED_REFUND_TYPE = 400; // Bad Request
    public static final String STATUS_FAILED_REFUND_TYPE = "Invalid refund type";

    public static final int STATUS_CODE_NO_USER_FOUND = 404; // Not Found
    public static final String STATUS_MSG_NO_USER_FOUND = "No user found";

    public static final int STATUS_CODE_INVALID_CREDENTIALS = 401; // Unauthorized
    public static final String STATUS_MSG_INVALID_CREDENTIALS = "Bad credentials";

    public static final int STATUS_CODE_INACTIVE_USER = 403; // Forbidden
    public static final String STATUS_MSG_INACTIVE_USER = "Inactive user";

    public static final int STATUS_CODE_USER_DELETED = 410; // Gone
    public static final String STATUS_MSG_USER_DELETED = "User already deleted";

    public static final int STATUS_CODE_FULL_AUTHENTICATION_REQUIRED = 401; // Unauthorized
    public static final String STATUS_MSG_FULL_AUTHENTICATION_REQUIRED = "Full authentication is required to access this resource";

    public static final int STATUS_CODE_NO_ENTITY_FOUND = 404; // Not Found

    public static final String STATUS_MSG_NO_ENTITY_FOUND = "No entity found for query";

    public static final int STATUS_CODE_NO_CREDENTIAL_FOUND = 401; // Unauthorized
    public static final String STATUS_MSG_NO_CREDENTIAL_FOUND = "No credential found";

    public static final int STATUS_CODE_NO_USER_TYPE_FOUND = 404; // Not Found
    public static final String STATUS_MSG_NO_USER_TYPE_FOUND = "No user type found";

    public static final int STATUS_CODE_NO_MENU_DEFINED = 404; // Not Found
    public static final String STATUS_MSG_NO_MENU_DEFINED = "No menu defined";

    public static final int STATUS_CODE_EVENT_DATES_OVERLAPPING = 409; // Conflict
    public static final String STATUS_MSG_EVENT_DATES_OVERLAPPING = "Event dates are overlapping";

    public static final int STATUS_CODE_PERMITS_DATES_OVERLAPPING = 409; // Conflict
    public static final String STATUS_MSG_PERMITS_DATES_OVERLAPPING = "Permits dates are overlapping";

    public static final int STATUS_CODE_EVENT_ALREADY_REJECTED = 409; // Conflict
    public static final String STATUS_MSG_EVENT_ALREADY_REJECTED = "Event already rejected";

    public static final int STATUS_CODE_EVENT_ALREADY_APPROVED = 409; // Conflict
    public static final String STATUS_MSG_EVENT_ALREADY_APPROVED = "Event already approved";

    public static final int STATUS_CODE_PARKING_PRICE_NOT_FOUND = 404; // Not Found
    public static final String STATUS_MSG_PARKING_PRICE_NOT_FOUND = "Error! Parking price is not defined";
    public static final int STATUS_CODE_NO_ROLE_FOUND = 404; // Not Found
    public static final String STATUS_MSG_NO_ROLE_FOUND = "No role found";

    public static final int STATUS_CODE_NO_PRIVILEGE_FOUND = 404; // Not Found
    public static final String STATUS_MSG_NO_PRIVILEGE_FOUND = "No privilege found";

    public static final int STATUS_CODE_NO_ROLE_ASSIGNED = 400; // Bad Request
    public static final String STATUS_MSG_NO_ROLE_ASSIGNED = "No role assigned";

    public static final int STATUS_CODE_NO_PRIVILEGE_ASSIGNED = 404; // Not Found
    public static final String STATUS_MSG_NO_PRIVILEGE_ASSIGNED = "No privilege assigned";

    public static final int STATUS_CODE_NO_USER_ROLE_FOUND = 404; // Not Found
    public static final String STATUS_MSG_NO_USER_ROLE_FOUND = "No user role found";

    public static final int STATUS_CODE_INVALID_CURRENT_PASSWORD = 401; // Unauthorized
    public static final String STATUS_MSG_INVALID_CURRENT_PASSWORD = "Invalid current password";

    public static final int STATUS_CODE_INVALID_ORIGIN = 400; // Bad Request
    public static final String STATUS_MSG_INVALID_ORIGIN = "Invalid origin";

    public static final int STATUS_CODE_VERIFY_RESET_TOKEN = 401; // Unauthorized
    public static final String STATUS_MSG_VERIFY_RESET_TOKEN = "Invalid reset token";

    public static final int STATUS_CODE_INVALID_EMAIL = 400; // Bad Request
    public static final String STATUS_MSG_INVALID_EMAIL = "Invalid email";

    public static final int STATUS_CODE_INVALID_USER = 400; // Bad Request
    public static final String STATUS_MSG_INVALID_USER = "Invalid user";



    public static final int MONTHLY_PAYMENT_TERM_CODE = 1;
    public static final String MONTHLY_PAYMENT_TERM_NAME = "Monthly";

    public static final int WEEKLY_PAYMENT_TERM_CODE = 2;
    public static final String WEEKLY_PAYMENT_TERM_NAME = "Weekly";

    public static final String DASHBOARD_HEADER_STUDENT_PERMITS = "Student Permits";
    public static final String DASHBOARD_HEADER_CITATIONS = "Citations";
    public static final String DASHBOARD_HEADER_FACULTY_PERMITS = "Faculty Permits";


    public static final String NOTIFICATION_CITATION_APPEAL = "Citation Appeal";
    public static final String NOTIFICATION_EVENT_REQUEST = "Event Request";
    public static final String NOTIFICATION_VENDOR_REQUEST = "Vendor Request";
    public static final String NOTIFICATION_REFUND_REQUEST = "Refund Request";
    public static final String NOTIFICATION_CARPOOL_REQUEST = "Carpool Request";
    public static final String NOTIFICATION_EVENT_INVOICE_DUE_REQUEST = "Event Invoice | Due";
    public static final String NOTIFICATION_PARTNER_INVOICE_DUE_REQUEST = "Partner Invoice | Due";
    public static final String NOTIFICATION_VENDOR_INVOICE_DUE_REQUEST = "Vendor Invoice | Due";
    public static final String NOTIFICATION_CARPOOL_INVOICE_DUE_REQUEST = "Carpool Invoice | Due";
    public static final int STATUS_CODE_REFUND_ALREADY_PROCESSED = 1101;
    public static final String STATUS_MSG_REFUND_ALREADY_PROCESSED = "Requested refund is already processed by the system.";
    public static final String STATUS_MSG_VENDOR_ALREADY_APPROVED = "Error! vendor already approved";
    public static final String STATUS_MSG_VENDOR_ALREADY_REJECTED = "Error! vendor already rejected";

    public static final int STATUS_CODE_REFUND_INVALID_TYPE = 400; // Bad Request
    public static final String STATUS_MSG_REFUND_INVALID_TYPE = "Invalid refund type.";

    public static final int STATUS_CODE_REFUND_PERMIT_NOT_FOUND = 404; // Not Found
    public static final String STATUS_MSG_REFUND_PERMIT_NOT_FOUND = "Refund permit not found.";

    public static final int STATUS_CODE_EMAIL_ADDRESS_EXIST = 409; // Conflict
    public static final String STATUS_MSG_EMAIL_ADDRESS_EXIST = "Email address already exists.";

    public static final int STATUS_CODE_REFUND_NOT_READY = 400; // Bad Request
    public static final String STATUS_MSG_REFUND_NOT_READY = "Refund amount not processed. Kindly process the amount.";

    public static final int STATUS_CODE_INVALID_OTP = 401; // Unauthorized
    public static final String STATUS_MSG_INVALID_OTP = "Invalid OTP.";

    public static final int STATUS_CODE_OTP_ALREADY_GENERATED = 409; // Conflict
    public static final String STATUS_MSG_OTP_ALREADY_GENERATED = "OTP for the requested resource is already present.";

    public static final int STATUS_CODE_OTP_EMAIL_MISMATCH = 400; // Bad Request
    public static final String STATUS_MSG_OTP_EMAIL_MISMATCH = "OTP email mismatched with the registered email.";


    // USER TYPE ROLES **Starts
    public static final String ROLE_STUDENT = "ROLE_STUDENT";

    public static final String ROLE_FACULTY = "ROLE_STAFF";

    public static final String ROLE_NORMAL_VISITOR_NAME = "ROLE_NORMAL_VISITOR";
    public static final String ROLE_VENDOR_NAME = "ROLE_VENDOR";
    public static final String ROLE_EVENT_MANAGER = "ROLE_EVENT_MANAGER";
    public static final String ROLE_PARTNER_MANAGER_NAME = "ROLE_PARTNER_MANAGER";

    public static final String SHIFT_FULL_DAY = "Full Day";
    public static final String SHIFT_MORNING = "Morning";
    public static final String SHIFT_EVENING = "Evening";


    // USER TYPE ROLES  **Ends
    public static final int STATUS_CODE_INVALID_TOKEN = 498;
    public static final int STATUS_CODE_ACCESS_DENIED = 403;
    public static final int STATUS_CODE_TOKEN_EXPIRED = 401;
    public static final int STATUS_CODE_NO_TOKEN_FOUND = 401;
    public static final int STATUS_CODE_JWT_INVALID_SIGNATURE = 403;
    public static final int STATUS_CODE_JWT_MALFORMED = 400;
    public static final int STATUS_CODE_JWT_EXPIRED = 401;
    public static final int STATUS_CODE_JWT_UNSUPPORTED = 400;
    public static final int STATUS_CODE_JWT_ILLEGAL_ARGUMENT = 400;

    public static final int STATUS_CODE_INVALID_DATA = 9999;
    public static final String SPOT_NAME_ALREADY_EXISTS = "Spot name '%s' already exists.";
    public static final String SPOT_NAME_NOT_VALID = "Spot name '%s' is not valid";
    public static final String DEVUI_NAME_NOT_VALID = "DevUI name '%s' is not valid";
    public static final String SPOT_NAME_AND_DEVUI_ALREADY_EXISTS = "Spot name '%s' and DevUI name  '%s' already exists.";
    public static final String DEVEUI_ALREADY_EXISTS = "DEVUI '%s' already exists.";
    public static final String VEHICLES_EXTERNAL_API_URL = "https://public.opendatasoft.com/api/explore/v2.1/catalog/datasets/all-vehicles-model/records";
    public static final String VEHICLES_EXTERNAL_API_RECORD_LIMIT = "limit=100";

    public static final class CITATION {
        public static final String PAID = "Paid";
        public static final String UNPAID = "Unpaid";
        public static final String CANCELLED = "Cancelled";
    }

    public static final class CITATION_APPEAL {
        public static final String PENDING = "Appeal Pending";
        public static final String APPROVED = "Approved";
        public static final String REJECTED = "Rejected";
        public static final String CANCELLED = "Cancelled";
    }

    public static final class CARPOOL {
        public static final class REQUEST_STATUS {
            public static final long DRAFT = 0;
            public static final long SUBMIT = 1;
            public static final long ACCEPT = 2;
            public static final long REJECT = 3;
            public static final long CANCEL = 4;
        }
    }

    public static final class CARPOOL_DETAIL {
        public static final class REQUEST_STATUS {
            public static final long PENDING = 1;
            public static final long ACCEPT = 2;
            public static final long REJECT = 3;
            public static final long CANCEL = 4;
        }

        public static final class REQUEST_TYPE {
            public static final long PRIVATE = 1;
            public static final long JOIN_PUBLIC = 2;
        }
    }
    public static final String STATUS_MSG_NO_ADDRESS_FOUND = "No address found";
    public static final String STATUS_MSG_ZONE_DOES_NOT_EXIST = "Zone does not exists";
    public static final String STATUS_MSG_GEOFENCE_ALREADY_EXIST = "This Geofence already exists";
    public static final String STATUS_MSG_NO_GEOFENCE_FOUND = "No Geofence found";
    public static final String STATUS_MSG_NO_PARKING_LOT_FOUND = "No Parking Lot found";
    public static final String STATUS_MSG_NO_GEOFENCE_DETAILS_FOUND = "No Geofence detail found";
    public static final String STATUS_MSG_ADDRESS_ASSOCIATED_WITH_ZONE = "Cannot Change Coordinates as addresses are bind with it";
}
