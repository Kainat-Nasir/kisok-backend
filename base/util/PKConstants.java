package com.conurets.parking_kiosk.base.util;

import com.conurets.parking_kiosk.base.cache.PreferenceCache;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
public class PKConstants {

    private String name;

    public static final class Common {
        public static final Map<String, String> SPOT_STATUS_MAP = new HashMap<>();

        static {
            SPOT_STATUS_MAP.put(Common.SPOT_STATUS_KEY_OCCUPIED, Common.SPOT_STATUS_VALUE_OCCUPIED);
            SPOT_STATUS_MAP.put(Common.SPOT_STATUS_KEY_UNOCCUPIED, Common.SPOT_STATUS_VALUE_UNOCCUPIED);
        }

        public static final String ZXRzLmNvbSIsImV4c = "";
        public static final String OGLA = "";

        public static final String ORIGIN_WEB = "WEB";
        public static final String ORIGIN_MOBILE = "MOBILE";

        public static final String SPOT_STATUS_KEY_OCCUPIED = "OCCUPIED";
        public static final String SPOT_STATUS_KEY_UNOCCUPIED = "UNOCCUPIED";

        public static final String SPOT_STATUS_VALUE_OCCUPIED = "Occupied";
        public static final String SPOT_STATUS_VALUE_UNOCCUPIED = "Unoccupied";
        public static final String MSG_ALL_PARKING_LOTS = "All Parking Lots";
        public static final int CODE_ALL_PARKING_LOTS = -1;

        public static final Long LONG_ZERO = Long.valueOf(0);
        public static final int INT_ZERO = 0;
        public static final int INT_ONE = 1;
        public static final int INT_TWO = 2;
        public static final int INT_THREE = 3;
        public static final int INT_FOUR = 4;
        public static final int INT_FIVE = 5;
        public static final int INT_SIX = 6;
        public static final int INT_SEVEN = 7;
        public static final int INT_EIGHT = 8;
        public static final int INT_NINE = 9;
        public static final int INT_TEN = 10;
        public static final int INT_ELEVEN = 11;
        public static final int INT_TWELVE = 12;
        public static final int INT_THIRTEEN = 13;
        public static final int INT_FOURTEEN = 14;
        public static final int INT_FIFTEEN = 15;
        public static final int INT_SIXTEEN = 16;
        public static final int INT_SEVENTEEN = 17;
        public static final int INT_EIGHTEEN = 18;
        public static final int INT_NINETEEN = 19;
        public static final int INT_TWENTY = 20;

        public static final String SC_EMPTY = "";
        public static final String SC_STAR = "*";
        public static final String SC_SPACE = " ";
        public static final String SC_DASH = "-";
        public static final String SC_DOT = ".";
        public static final String SC_FALSE = "false";
        public static final String SC_COLON = ":";
        public static final String SC_COLON_SPACE = ": ";
        public static final String SC_UNDER_SCORE = "_";
        public static final String SC_BACK_SLASH = "\\";
        public static final String SC_FORWARD_SLASH = "/";
        public static final String SC_DOUBLE_FORWARD_SLASH = "//";
        public static final String SC_AT_THE_RATE = "@";
        public static final String SC_GREATER_THAN = ">";
        public static final String SC_LESS_THAN = "<";
        public static final String SC_NULL = "null";
        public static final String SC_COMMA = ",";
        public static final String LEFT_BRACE = "{";
        public static final String RIGHT_BRACE = "}";
        public static final String SC_DASH_WITH_SPACE = " - ";

        public static final String SC_T = "T";

        public static final int STATUS_CODE_UNKNOWN = 0;
        public static final int STATUS_CODE_ACTIVE = 1;
        public static final int STATUS_CODE_INACTIVE = 2;
        public static final int STATUS_CODE_DELETE = 3;
        public static final int STATUS_CODE_TERMINATE = 4;
        public static final int STATUS_CODE_LOGGED_IN = 5;
        public static final int STATUS_CODE_LOGGED_OUT = 6;

        public static final int STATUS_ERROR_CODE = 1;
        public static final int STATUS_SUCCESS_CODE = 2;

        public static final String STATUS_MSG_UNKNOWN = "Unknown";
        public static final String STATUS_MSG_ACTIVE = "Active";
        public static final String STATUS_MSG_INACTIVE = "InActive";
        public static final String STATUS_MSG_DELETE = "Deleted";
        public static final String STATUS_MSG_TERMINATE = "Terminate";
        public static final String STATUS_MSG_LOGGED_IN = "Active logged in";
        public static final String STATUS_MSG_LOGGED_OUT = "Logged out";

        public static final int STATUS_CODE_ATTSTATE_CHECK_IN = 0;
        public static final int STATUS_CODE_ATTSTATE_CHECK_OUT = 1;
        public static final int STATUS_CODE_ATTSTATE_BREAK_IN = 4;
        public static final int STATUS_CODE_ATTSTATE_BREAK_OUT = 5;

        public static final String STATUS_MSG_ATTSTATE_CHECK_IN = "Check-In";
        public static final String STATUS_MSG_ATTSTATE_CHECK_OUT = "Check-Out";
        public static final String STATUS_MSG_ATTSTATE_BREAK_IN = "Break-In";
        public static final String STATUS_MSG_ATTSTATE_BREAK_OUT = "Break-Out";

        public static final String ROLE = "ROLE";
        public static final String ROLE_SPACE = "ROLE ";
        public static final String ROLE_UNDERSOCRE = "ROLE_";

        public static final String EVENT_TYPE_IN = "IN";
        public static final String EVENT_TYPE_OUT = "OUT";
        public static final String EVENT_TYPE_EARLY = "EARLY";
        public static final String EVENT_TYPE_EARLY_OUT = "EARLY OUT";
        public static final String EVENT_TYPE_ON_TIME_DEPARTURE = "ON TIME DEPARTURE";
        public static final String EVENT_TYPE_LATE = "LATE";
        public static final String EVENT_TYPE_ON_TIME = "ON TIME";
        public static final String EVENT_TYPE_ABSENT = "ABSENT";
        public static final String EVENT_TYPE_PRESENT = "PRESENT";

        public static final String DATE_FORMAT_MM_DD = "MM-dd";
        public static final String DATE_FORMAT_MM_DD_YYYY = "MM-dd-yyyy";
        public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
        public static final String DATE_FORMAT_DD_MM_YYYY = "dd-MM-yyyy";
        public static final String DATE_FORMAT_MM_DD_YYYY_HH_MM_SS = "MM-dd-yyyy HH:mm:ss";
        public static final String DATE_FORMAT_0000_00_00_HH_MM_SS = "0000-00-00 HH:mm:ss";
        public static final String DATE_FORMAT_TIME_HH_MM_SS = "HH:mm:ss";
        public static final String DATE_FORMAT_TIME_HH_MM = "HH:mm";
        public static final String DATE_FORMAT_YYYY_MM_DD_00_00_00 = "yyyy-MM-dd 00:00:00";
        public static final String TIME_FORMAT_HHMMSS = "HHmmss";
        public static final String DATE_FORMAT_MMDDYY = "MMddYY";
        public static final String DATE_FORMAT_DEFAULT = "1970-01-01";

        public static final int VERIFY_METHOD_FINGER_PRINT = 1;
        public static final int VERIFY_METHOD_RFID = 2;
        public static final int VERIFY_METHOD_FACE = 16;

        public static final Boolean BOOLEAN_TRUE = true;
        public static final Boolean BOOLEAN_FALSE = false;

        public static final long DEFAULT_USER_ID = 1;

        public static final String SESSION_EXPIRED_ACTION_STATUS_PENDING = "PENDING";
        public static final String SESSION_EXPIRED_ACTION_STATUS_COMPLETED = "COMPLETED";
        public static final String SESSION_EXPIRED_ACTION_STATUS_DUPLICATE = "DUPLICATE";

        public static final int INT_SIXTY = 60;
        public static final int INT_FOURTEEN_FORTY = 1440;

        public static final int MINUTE_IN_SECONDS = 60;
        public static final int HOUR_IN_SECONDS = 3600;

        public static final String SESSION_DURATION_DAYS = " days ";
        public static final String SESSION_DURATION_HOURS = " hrs ";
        public static final String SESSION_DURATION_MINUTES = " mins ";
        public static final String SESSION_DURATION_SECONDS = " secs";

        //role
        public static final String ROLE_ADMIN = "ROLE_ADMIN";
        public static final String ROLE_CUSTOMER = "ROLE_CUSTOMER";

    }

    public static final class appProperties {
        public static final String NAME = "Calamus University";
        public static final String ACRONYM = "CU";
        public static final String EMAIL = "parking@calamusuniverstiy.com";
    }

    public static final class Query {
        public static final String PARAM = "@param";
    }

    public static final class SpotGateway {
        public static final String GATEWAY_LOG_KEY_CMD = "cmd";
        public static final String GATEWAY_LOG_KEY_EUI = "EUI";
        public static final String GATEWAY_LOG_KEY_SEQ_NO = "seqno";
        public static final String GATEWAY_LOG_KEY_TS = "ts";
        public static final String GATEWAY_LOG_KEY_FCNT = "fcnt";
        public static final String GATEWAY_LOG_KEY_PORT = "port";
        public static final String GATEWAY_LOG_KEY_FREQ = "freq";
        public static final String GATEWAY_LOG_KEY_RSSI = "rssi";
        public static final String GATEWAY_LOG_KEY_SNR = "snr";
        public static final String GATEWAY_LOG_KEY_TOA = "toa";
        public static final String GATEWAY_LOG_KEY_DR = "dr";
        public static final String GATEWAY_LOG_KEY_ACK = "ack";
        public static final String GATEWAY_LOG_KEY_OFFLINE = "offline";
        public static final String GATEWAY_LOG_KEY_BAT = "bat";
        public static final String GATEWAY_LOG_KEY_DATA = "data";
        public static final String GATEWAY_LOG_KEY_GWS = "gws";
        public static final String GATEWAY_LOG_KEY_GWS_TS = "ts";
        public static final String GATEWAY_LOG_KEY_GWS_TIME = "time";
        public static final String GATEWAY_LOG_KEY_GWS_GWEUI = "gweui";
        public static final String GATEWAY_LOG_KEY_GWS_ANT = "ant";
        public static final String GATEWAY_LOG_KEY_GWS_LAT = "lat";
        public static final String GATEWAY_LOG_KEY_GWS_LON = "lon";

        public static final String GATEWAY_LOG_CMD_VALUE_RX = "rx";
        public static final String GATEWAY_LOG_CMD_VALUE_GW = "gw";
        public static final String GATEWAY_LOG_CMD_VALUE_TXD = "txd";

        public static final String DB_COLUMN_DOCUMENT_ID = "documentId";
        public static final String DB_COLUMN_DEV_EUI = "devEUI";
        public static final String DB_COLUMN_PAYLOAD = "payload";
        public static final String DB_COLUMN_SESSION_ID = "sessionId";
        public static final String DB_COLUMN_SPOT_ID = "spotId";
        public static final String DB_COLUMN_SPOT_NAME = "spotName";
        public static final String DB_COLUMN_SPOT_STATUS = "spotStatus";
        public static final String DB_COLUMN_EMAIL_ADDRESS = "emailAddress";
        public static final String DB_COLUMN_SESSION_EXPIRED = "sessionExpired";
        public static final String DB_COLUMN_SPOT_CLEAR = "spotClear";
        public static final String DB_COLUMN_ACTION_STATUS = "actionStatus";
        public static final String DB_COLUMN_DEVICE_DATE_TIME = "deviceDatetime";
        public static final String DB_COLUMN_START_TIME = "startTime";
        public static final String DB_COLUMN_END_TIME = "endTime";
        public static final String DB_COLUMN_OCCUPY_STATUS = "occupyStatus";
        public static final String DB_COLUMN_TICKET_NUMBER = "ticketNumber";
        public static final String DB_COLUMN_LPN = "lpn";
        public static final String DB_COLUMN_START_DATE_TIME = "startDateTime";
        public static final String DB_COLUMN_END_DATE_TIME = "endDateTime";
        public static final String DB_COLUMN_INTERNAL_ZONE_CODE = "internalZoneCode";
        public static final String DB_COLUMN_CREATED_DATE = "createdDate";
        public static final String DB_COLUMN_UPDATE_DATE = "lastUpdateDate";
        public static final String DB_COLUMN_PAYMENT_SESSION_ID = "paymentSessionId";
        public static final String DB_COLUMN_ZONE_ID = "zoneId";
        public static final String DB_COLUMN_ZONE_NAME = "zoneName";
        public static final String DB_COLUMN_SPECIAL_PERSON = "specialPersonSpot";
        public static final String DB_COLUMN_PAYMENT_ENABLED = "paymentSpot";
        public static final String DB_COLUMN_PEO_ENABLED = "peoSpot";
        public static final String DB_COLUMN_BUSINESS_ENABLED = "businessSpot";
        public static final String DB_COLUMN_ACTION_VALUE = "actionValue";
        public static final String DB_COLUMN_TS = "ts";
        public static final String DB_COLUMN_EUI = "eui";
        public static final String DB_COLUMN_CMD = "cmd";
    }

    public static final class Header {
        public static final String AUTHORIZATION = "Authorization";
        public static final String AUTHORIZATION_BEARER = "Bearer";
        public static final String AUTHORIZATION_BASIC = "Basic";
        public static final String AUTHORIZATION_BEARER_SPACE = "Bearer ";
        public static final String AUTHORIZATION_BASIC_SPACE = "Basic ";

        public static final String ALLOW_METHOD_HEAD = "HEAD";
        public static final String ALLOW_METHOD_GET = "GET";
        public static final String ALLOW_METHOD_POST = "POST";
        public static final String ALLOW_METHOD_PUT = "PUT";
        public static final String ALLOW_METHOD_DELETE = "DELETE";
        public static final String ALLOW_METHOD_PATCH = "PATCH";

        public static final String ALLOW_HEADER_AUTHORIZATION = "Authorization";
        public static final String ALLOW_HEADER_CACHE_CONTROL = "Cache-Control";
        public static final String ALLOW_HEADER_CONTENT_TYPE = "Content-Type";

        public static final String ALLOW_PATH = "/**";

        public static final String ALLOW_ORIGIN_FRONTEND = "http://localhost:4200";
        public static final String ALLOW_ORIGIN_FRONTEND_PROD = "https://hcm.conurets.com";
    }

    public static final class PARKING_LOT_FIEILD_INDEX {
        public static final int ORGANIZATION_ID = 0;
        public static final int PARKING_PLOT_NAME = 1;
        public static final int PARKING_PLOT_DESCRIPTION = 2;
        public static final int STATUS = 3;
        public static final int DETAILS = 4;
        public static final int USERTYPES = 5;
    }

    public static final class PARKING_PRICE_FIEILD_INDEX {
        public static final int USER_TYPE_ID = 0;
        public static final int PRICE_TYPE_ID = 1;
        public static final int PARKING_LOT_ID = 2;
        public static final int DEC_PRICE = 3;
        public static final int STATUS = 4;
    }

    public static final class TransactionType {
        public static final String SALE = "sale";
        public static final String AUTHORIZATION = "auth";
        public static final String CAPTURE = "capture";
        public static final String VOID = "void";
        public static final String REFUND = "refund";
        public static final String CREDIT = "credit";
        public static final String VALIDATE = "validate";
        public static final String UPDATE = "update";
    }

    public static final class UserRegistrationEmail {
        public static final String REGISTRATION_EMAIL_SUBJECT = "Partner Registration";
        public static final String REGISTRATION_EMAIL_CONTENT = "Dear Concerned, \n" +
                "A new user has been added to " + appProperties.NAME + " (Parking Enterprise Resource Planning). \n" +
                "\n" +
                "Please find your login details:\n" +
                "\n" +
                "Email: %s\n" +
                "Password: %s\n" +
                "University Registration Number: %s\n" +
                "Link: " + PreferenceCache.getProperty(APConstants.USER_UI_BASE_URL) + "/#/auth";

        public static final String REGISTRATION_UPDATE_EMAIL_SUBJECT = "Partner Registration Updated";
        public static final String REGISTRATION_UPDATE_EMAIL_CONTENT = "Dear Concerned, \n" +
                "User has been updated to " + appProperties.ACRONYM + " (Parking Enterprise Resource Planning). \n" +
                "\n" +
                "Please find your updated Login details:\n" +
                "\n" +
                "Email: %s\n" +
                "Password: %s\n" +
                "Link: " + PreferenceCache.getProperty(APConstants.USER_UI_BASE_URL) + "/#/auth" +
                "\n";
    }

    public static final class VisitorPermitEmail {
        public static final String VISITOR_PERMIT_EMAIL_SUBJECT = "Visitor Permits";
        public static final String VISITOR_PERMIT_EMAIL_CONTENT = "Dear Concerned, \n\n" +
                "A new permit has been added to " + appProperties.NAME + " (Parking Enterprise Resource Planning). \n" +
                "\n" +
                "Please find your below permit details:\n" +
                "\n" +
                "Permit Number: %s\n";
    }

    public static final class Olios {
        public static final String OLIOS_BASE_URL = "https://olios-peo-web-dev.conurets.com/oliospeo-web";
        public static final String OLIOS_AUTH_URL = OLIOS_BASE_URL + "/api/authenticate";
        public static final String OLIOS_CITATION_UPDATE_URL = OLIOS_BASE_URL + "/api/citation/update";

        public static final String FIND_ALL_PARKING_LOTS = OLIOS_BASE_URL + "/api/downSync/find-all-zone";


        public static final String OLIOS_USER_ADMIN = "admin@sbu.edu";
        public static final String OLIOS_PASSWORD_ADMIN = "test";
    }

    public static final class POSUserRegistrationEmail {


        public static final String POS_REGISTRATION_EMAIL_SUBJECT = "POS User Registration";
        public static final String POS_REGISTRATION_EMAIL_CONTENT = "Dear Concerned, \n" +
                "A new user from point of sale has been added to " + appProperties.NAME + " (Parking Enterprise Resource Planning). \n" +
                "\n" +
                "Please find your login details:\n" +
                "\n" +
                "Email: %s\n" +
                "Password: %s\n" +
                "University Registration Number: %s\n" +
                "Link: %s\n";

    }

    public static final class VendorRegistrationEmail {

        public static final String VENDOR_REGISTRATION_EMAIL_SUBJECT = "Welcome to " + appProperties.ACRONYM + " Parking System - Vendor Credentials";
        public static final String VENDOR_REGISTRATION_EMAIL_CONTENT = EmailConstants.EMAIL_START +
                "Welcome to the " + appProperties.ACRONYM + " Parking System! We are pleased to inform you that your account has been created and is ready for use. Below are your auto-generated login credentials:\n" +
                "\n" +
                "%s\n" +
                "Username: %s\n" +
                "Password: %s\n" +
                "\n" +
                "Please make sure to keep your login information safe and secure, and change your password as soon as possible after logging in.\n" +
                "\n" +
                "As a registered vendor, you will be able to request and manage permits along with vehicle information through your account. If you have any questions or concerns, please do not hesitate to contact our customer support team at " + appProperties.EMAIL + ".\n" +
                "\n" +
                EmailConstants.EMAIL_THANKYOU_MESSAGE +
                EmailConstants.EMAIL_END;

        public static final String VENDOR_REQUEST_EMAIL_SUBJECT = "Welcome to " + appProperties.ACRONYM + "Parking System - Vendor Request";
        public static final String VENDOR_REQUEST_EMAIL_CONTENT = EmailConstants.EMAIL_START +
                "Welcome to the " + appProperties.ACRONYM + " Parking System! We are pleased to inform you that your account has been generated, once it will be approved you will get your credentials:\n" +
                "\n" +
                "If you have any questions or concerns, please do not hesitate to contact our customer support team at " + appProperties.EMAIL + ".\n" +
                "\n" +
                EmailConstants.EMAIL_THANKYOU_MESSAGE +
                EmailConstants.EMAIL_END;
    }


    public static final class VendorPermitRequestInvoiceEmail {

        public static final String VENDOR_PERMIT_REQUEST_INVOICE_EMAIL_SUBJECT = "%s Permit Request - Invoice";
        public static final String VENDOR_PERMIT_REQUEST_INVOICE_EMAIL_CONTENT = EmailConstants.EMAIL_START +
                "We are pleased to inform you that your permit request has been approved, and an invoice has been generated for you. To gain access to your permit(s), please proceed with the payment by clicking the link provided in the email.\n" +
                "%s\n" +
                "\n" +
                EmailConstants.EMAIL_THANKYOU_MESSAGE +
                EmailConstants.EMAIL_END;
    }


    public static final class VendorPermitRequestRejectEmail {

        public static final String VENDOR_PERMIT_REQUEST_REJECT_EMAIL_SUBJECT = "Vendor Permit Request - Rejected";
        public static final String VENDOR_PERMIT_REQUEST_REJECT_EMAIL_CONTENT = EmailConstants.EMAIL_START +
                "We regret to inform you that your permit request has been rejected. If you have any questions or concerns, please to contact our customer support team at " + appProperties.EMAIL + ".\n" +
                "\n" +
                "\n" +
                EmailConstants.EMAIL_END;
    }

    public static final class PartnerRegistrationEmail {

        public static final String PARTNER_REGISTRATION_EMAIL_SUBJECT = "Welcome to" + appProperties.ACRONYM + " Parking System - Partner Credentials";
        public static final String PARTNER_REGISTRATION_EMAIL_CONTENT = EmailConstants.EMAIL_START +
                "Welcome to the " + appProperties.ACRONYM + " Parking System! We are pleased to inform you that your account has been created and is ready for use. Below are your auto-generated login credentials:\n" +
                "\n" +
                "%s\n" +
                "Username: %s\n" +
                "Password: %s\n" +
                "\n" +
                "Please make sure to keep your login information safe and secure, and change your password as soon as possible after logging in.\n" +
                "\n" +
                "As a registered partner, you will be able to manage employees, permits, invoices, and vehicle information through your account. If you have any questions or concerns, please to contact our customer support team at " + appProperties.EMAIL + ".\n" +
                "\n" +
                EmailConstants.EMAIL_THANKYOU_MESSAGE +
                EmailConstants.EMAIL_END;

    }


    public static final class PartnerEmployeeRegistrationEmail {

        public static final String PARTNER_EMPLOYEE_REGISTERATION_EMAIL_SUBJECT = "Welcome to " + appProperties.ACRONYM + " Parking System - Partner Employee Credentials";
        public static final String PARTNER_EMPLOYEE_REGISTERATION_EMAIL_CONTENT = EmailConstants.EMAIL_START +
                "Welcome to the " + appProperties.ACRONYM + " Parking System! We are pleased to inform you that your account has been created and is ready for use. Below are your auto-generated login credentials:\n" +
                "\n" +
                "%s\n" +
                "Username: %s\n" +
                "Password: %s\n" +
                "\n" +
                "Please make sure to keep your login information safe and secure, and change your password as soon as possible after logging in.\n" +
                "\n" +
                "As a registered partner employee, you will be able to manage permits and vehicle information through your account. If you have any questions or concerns, please to contact our customer support team at " + appProperties.EMAIL + ".\n" +
                "\n" +
                EmailConstants.EMAIL_THANKYOU_MESSAGE +
                EmailConstants.EMAIL_END;

    }


    public static final class EventConfirmationEmail {

        public static final String EVENT_CONFIRMATION_EMAIL_SUBJECT = "%s - Guests Permit";
        public static final String EVENT_CONFIRMATION_EMAIL_CONTENT =
                "Your requested event %s guests permit has been generated. Please refer to attached permit details for more information.\n" +
                        "\n";
    }

    public static final class EventRequestRejectEmail {
        public static final String EVENT_REQUEST_REJECT_EMAIL_SUBJECT = "%s Request - Rejected";
        public static final String EVENT_REQUEST_REJECT_EMAIL_CONTENT =
                "We regret to inform you that your event %s request has been rejected. If you have any questions or concerns, please to contact our customer support team at " + appProperties.EMAIL + ".\n" +
                        "\n";

    }

    public static final class EventVisitorPermitEmail {
        public static final String EVENT_VISITOR_PERMIT_EMAIL_SUBJECT = "%s - Permit \n";
        public static final String EVENT_VISITOR_PERMIT_EMAIL_CONTENT = EmailConstants.EMAIL_START +
                "\n" +
                "We are pleased to inform you that you have successfully purchased a permit for %s. Please refer to the attached permit details for more information.\n" +
                "\n" +
                "\n" +
                EmailConstants.EMAIL_END;
    }

    public static final class EventInvoiceEmail {
        public static final String EVENT_INVOICE_EMAIL_SUBJECT = "Event Invoice - %s";
        public static final String EVENT_INVOICE_EMAIL_CONTENT = EmailConstants.EMAIL_START +
                "We are pleased to inform you that your event request has been approved, and an invoice has been generated for you. To gain access to your event, please proceed with the payment by clicking the link provided in the email.\n" +
                "%s\n" +
                "\n" +
                EmailConstants.EMAIL_THANKYOU_MESSAGE +
                EmailConstants.EMAIL_END;
    }

    public static final class InventoryAvailable {
        public static final String INVENTORY_EMAIL_SUBJECT = "Inventory available - %s";
        public static final String INVENTORY_EMAIL_CONTENT = EmailConstants.EMAIL_START +
                "We are pleased to inform you that inventory is available against your requested parking lot, please proceed to purchase a permit .\n" +
                "%s\n" +
                "\n" +
                EmailConstants.EMAIL_THANKYOU_MESSAGE +
                EmailConstants.EMAIL_END;
    }

    public static final class EventManagerRegistrationEmail {
        public static final String EVENT_MANAGER_REGISTRATION_EMAIL_SUBJECT = "Welcome to " + appProperties.ACRONYM + " Parking System - Partner Credentials  ";
        public static final String EVENT_MANAGER_REGISTRATION_EMAIL_CONTENT =
                "Welcome to the " + appProperties.ACRONYM + " Parking System! We are pleased to inform you that your account has been created and is ready for use. Below are your auto-generated login credentials:\n" +
                        "\n" +
                        PreferenceCache.getProperty(APConstants.USER_UI_BASE_URL) +
                        "/#/auth\n" +
                        "Username: %s\n" +
                        "Password: %s\n" +
                        "\n" +
                        "Please make sure to keep your login information safe and secure, and change your password as soon as possible after logging in.\n" +
                        "\n" +
                        "As a registered event manager, you will be able to register event, manage guests and visitor permits through your account. If you have any questions or concerns, please to contact our customer support team at" + appProperties.EMAIL + ".\n";
    }

    public static final class EmailConstants {
        public static final String EMAIL_START = "Dear %s, \n\n";
        public static final String EMAIL_THANKYOU_MESSAGE = "Thank you for choosing " + appProperties.ACRONYM + ". We look forward to providing you with exceptional service!\n" + "\n" + "\n";
        public static final String EMAIL_END = "Best regards,\n" +
                "Parking Management Team\n" +
                "" + appProperties.ACRONYM + "\n" +
                "\n" +
                "\n" +
                "Note: This is a system generated email, please do not reply to it.";
    }

    public static final class UserEmail {
        public static final String USER_REGISTRATION_EMAIL_SUBJECT = "Welcome to " + appProperties.ACRONYM + " Parking System - User Credentials  ";
        public static final String USER_REGISTRATION_EMAIL_CONTENT =
                "Welcome to the " + appProperties.ACRONYM + " Parking System! We are pleased to inform you that your account has been created and is ready for use. Below are your auto-generated login credentials:\n" +
                        "\n" +
//                        PreferenceCache.getProperty(APConstants.USER_UI_BASE_URL) +
                        "%s/#/auth\n" +
                        "Username: %s\n" +
                        "Password: %s\n" +
                        "\n" +
                        "Please make sure to keep your login information safe and secure, and change your password as soon as possible after logging in.\n" +
                        "\n" +
                        "If you have any questions or concerns, please to contact our customer support team at " + appProperties.EMAIL + ".\n";


        public static final String RESET_PASSWORD_EMAIL_CONTENT =
                "Welcome to the " + appProperties.ACRONYM + " Parking System! We are pleased to inform you that your account password has been changed . Below are your auto-generated login credentials:\n" +
                        "\n" +
//                        PreferenceCache.getProperty(APConstants.USER_UI_BASE_URL) +
                        "%s/#/auth\n" +
                        "Username: %s\n" +
                        "Password: %s\n" +
                        "\n" +
                        "Please make sure to keep your login information safe and secure, and change your password as soon as possible after logging in.\n" +
                        "\n" +
                        "If you have any questions or concerns, please to contact our customer support team at " + appProperties.EMAIL + ".\n";

    }
    public static final class SuperAdmin{
        public static final String SUPER_ADMIN_EMAIL = "superadmin@cits.com";
        public static final String SUPER_ADMIN_PASSWORD = "$2a$12$NoHNSv2KUw3Y8K//QN8mXO51J1/YrsHoUCHlg1j5mXnKYvxkv6C7a";
        public static final Integer SUPER_ADMIN_USER_ROLE_CODE = 1;
        public static final String SUPER_ADMIN_ROLE = "SUPER_ADMIN";
        public static final String SUPER_ADMIN_PRIVILEGE = "PRIVILEGE_SUPER_ADMIN";
    }
    public  static  final  String OK= "OK";
    public  static  final  String CHANGE_PASSWORD_SUCCESS="Password changed Successfully";
    public  static  final String USER_CREATED_EMAIL="We are excited to inform you that your account has been successfully created." + "\n" +
            "Please use these credentials to log in to your account for the first time. For security reasons, we recommend changing your password after your initial login. You can do this by visiting the account settings page.\n" +
            "Here are your account details: \n Password :   ";

    public static final class NormalVisitor{
        public static final Integer NORMAL_VISITOR_USER_TYPE_CODE = 2;
        public static final String NORMAL_VISITOR_USER_TYPE = "USER_TYPE_NORMAL_VISITOR";
        public static final String NORMAL_VISITOR_ROLE = "ROLE_NORMAL_VISITOR";
        public static final String NORMAL_VISITOR_PRIVILEGE = "PRIVILEGE_NORMAL_VISITOR";
    }
}


