package com.conurets.parking_kiosk.base.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
public class PKUtil {

    private static final String[] INVOICE_REFUND_TYPES = new String[]{
            PKStatusConstants.EVENT_REFUND_TYPE_VALUE,
            PKStatusConstants.VENDOR_EMPLOYEE_REFUND_TYPE_VALUE
    };
    private static final String[] PERMIT_REFUND_TYPES = new String[]{
            PKStatusConstants.STUDENT_REFUND_TYPE_VALUE,
            PKStatusConstants.EVENT_GUEST_REFUND_TYPE_VALUE,
            PKStatusConstants.VENDOR_EMPLOYEE_REFUND_TYPE_VALUE,
            PKStatusConstants.EVENT_VISITOR_REFUND_TYPE_VALUE,
            PKStatusConstants.FACULTY_REFUND_TYPE_VALUE,
            PKStatusConstants.CARPOOL_REFUND_TYPE_VALUE,
            PKStatusConstants.VISITOR_REFUND_TYPE_VALUE,
            PKStatusConstants.PARTNER_EMPLOYEE_REFUND_TYPE_VALUE,
            PKStatusConstants.PARTNER_PAYMENT_TYPE_VALUE
    };

    public static void main(String[] args) {
        long deviceStartTime = 1679825716794L;
        long deviceEndTime = PKDateUtil.getCurrentDate().getTime();
        long seconds = PKUtil.calcTimeDifference(deviceStartTime, deviceEndTime);

        String duration = PKUtil.calcDuration(seconds);

        log.info("seconds={}, duration={}", seconds, duration);
    }

    /**
     * String into integer
     *
     * @param input
     * @return int
     */
    public static final int stringToInteger(String input) {
        int parseValue = PKConstants.Common.INT_ZERO;
        try {
            parseValue = Integer.parseInt(input);
        } catch (Exception e) {
            parseValue = PKConstants.Common.INT_ZERO;
        }
        return parseValue;
    }

    /**
     * String into long
     *
     * @param input
     * @return long
     */
    public static final long stringToLong(String input) {
        long parseValue = PKConstants.Common.INT_ZERO;
        try {
            parseValue = Long.parseLong(input);
        } catch (Exception e) {
            parseValue = PKConstants.Common.INT_ZERO;
        }
        return parseValue;
    }

    /**
     * stringToBoolean
     *
     * @param input
     * @return boolean
     */
    public static final boolean stringToBoolean(String input) {
        boolean parseValue = Boolean.FALSE;
        try {
            parseValue = input.equals("true") ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            parseValue = Boolean.FALSE;
        }
        return parseValue;
    }

    /**
     * String into double
     *
     * @param input
     * @return double
     */
    public static final double stringToDouble(String input) {
        double parseValue = PKConstants.Common.INT_ZERO;
        try {
            parseValue = Double.parseDouble(input);
        } catch (Exception e) {
            parseValue = PKConstants.Common.INT_ZERO;
        }
        return parseValue;
    }

    /**
     * Validate list
     *
     * @param list
     * @return boolean
     */
    public static final boolean isCollectionNotBlank(Collection list) {
        return (list != null && list.size() > PKConstants.Common.INT_ZERO) ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * DB result status
     *
     * @return List<Integer>
     */
    public static List<Integer> getDBResultStatus() {
        List<Integer> statusList = new ArrayList<>();
        String[] statusArray = {"1,2"}; /*PreferenceUtil.getProperty(APConstants.DB_RESULT_STATUS)
                .split(ParkERPConstants.Common.SC_COMMA);*/

        for (String status : statusArray) {
            statusList.add(PKUtil.stringToInteger(status));
        }

        return statusList; //Arrays.asList(1, 2);
    }

    /**
     * Convert class object into string
     *
     * @param object
     * @return String
     * @throws JsonProcessingException
     */
    public static String writeValue(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(object);
    }

    /**
     * Convert string value into class object
     *
     * @param content
     * @param valueType
     * @param <T>
     * @return <T> T
     * @throws IOException
     */
    public static <T> T readValue(String content, Class<T> valueType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(content, valueType);
    }

    public static boolean isTokenExpired(String token) {
        String[] chunks = token.split("\\.");
        Long currentTime = new Date().getTime();
        Long expire;
        Base64.Decoder decoder = Base64.getUrlDecoder();
        String payload = new String(decoder.decode(chunks[1]));
        JSONObject jsonObjec = new JSONObject(payload);
        if (jsonObjec.has("exp")) {
            expire = jsonObjec.getLong("exp") * 1000;
        } else {
            expire = null;
        }
        if (expire != null && currentTime >= expire) {
            return true;
        } else {
            return false;
        }
    }

    public static long getDueDate(Long startDate, Integer numberOfDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(startDate));
        calendar.add(Calendar.DATE, numberOfDays);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime().getTime();
    }

    /**
     * Get status value
     *
     * @param status
     * @return String
     */
    public static String getStatus(int status) {
        String statusValue = PKConstants.Common.STATUS_MSG_ACTIVE;

        if (status == PKConstants.Common.STATUS_CODE_UNKNOWN) {
            statusValue = PKConstants.Common.STATUS_MSG_UNKNOWN;
        } else if (status == PKConstants.Common.STATUS_CODE_ACTIVE) {
            statusValue = PKConstants.Common.STATUS_MSG_ACTIVE;
        } else if (status == PKConstants.Common.STATUS_CODE_INACTIVE) {
            statusValue = PKConstants.Common.STATUS_MSG_INACTIVE;
        } else if (status == PKConstants.Common.STATUS_CODE_DELETE) {
            statusValue = PKConstants.Common.STATUS_MSG_DELETE;
        } else if (status == PKConstants.Common.STATUS_CODE_TERMINATE) {
            statusValue = PKConstants.Common.STATUS_MSG_TERMINATE;
        }
        return statusValue;
    }

    /**
     * Get AttState value
     *
     * @param attState
     * @return String
     */
    public static String getAttState(int attState) {
        String statusValue = PKConstants.Common.STATUS_MSG_ATTSTATE_CHECK_IN;

        if (attState == PKConstants.Common.STATUS_CODE_ATTSTATE_CHECK_IN) {
            statusValue = PKConstants.Common.STATUS_MSG_ATTSTATE_CHECK_IN;
        } else if (attState == PKConstants.Common.STATUS_CODE_ATTSTATE_CHECK_OUT) {
            statusValue = PKConstants.Common.STATUS_MSG_ATTSTATE_CHECK_OUT;
        } else if (attState == PKConstants.Common.STATUS_CODE_ATTSTATE_BREAK_IN) {
            statusValue = PKConstants.Common.STATUS_MSG_ATTSTATE_BREAK_IN;
        } else if (attState == PKConstants.Common.STATUS_CODE_ATTSTATE_BREAK_OUT) {
            statusValue = PKConstants.Common.STATUS_MSG_ATTSTATE_BREAK_OUT;
        }
        return statusValue;
    }

    /**
     * Create employeeMaster name like... ROLE_ADMIN, ROLE_USER
     *
     * @param roleName
     * @return String
     */
    public static String createRoleName(String roleName) {
        int roleLength = PKConstants.Common.INT_ZERO;

        roleName = roleName.toUpperCase();

        if (roleName.contains(PKConstants.Common.ROLE_UNDERSOCRE)) {
            roleLength = PKConstants.Common.ROLE_UNDERSOCRE.length();
        } else if (roleName.contains(PKConstants.Common.ROLE_SPACE)) {
            roleLength = PKConstants.Common.ROLE_SPACE.length();
        } else if (roleName.contains(PKConstants.Common.ROLE)) {
            roleLength = PKConstants.Common.ROLE.length();
        }

        roleName = roleName.substring(roleLength);

        roleName = new StringBuilder(PKConstants.Common.ROLE_UNDERSOCRE).append(roleName).toString();
        roleName = roleName.replace(PKConstants.Common.SC_SPACE, PKConstants.Common.SC_UNDER_SCORE);
        roleName = roleName.replace(PKConstants.Common.SC_DASH, PKConstants.Common.SC_UNDER_SCORE);

        return roleName;
    }


    /**
     * Calc time difference
     *
     * @param startDateTime
     * @param endDateTime
     * @return long
     */
    public static long calcTimeDifference(long startDateTime, long endDateTime) {
        log.info("startDateTime={}, endDateTime={}", new Date(startDateTime), new Date(endDateTime));
        return Math.abs(startDateTime -endDateTime);
    }

    /**
     * containsName
     *
     * @param list
     * @param name
     * @return boolean
     */
    public static boolean containsName(final List<SimpleGrantedAuthority> list, final String name) {
        return list.stream().filter(o -> o.getAuthority().equals(name)).findFirst().isPresent();
    }

    /**
     * Validate Field is Empty or has a Value
     *
     * @param value
     * @return boolean
     * @CreatedBy Ibrahim Inam
     */
    public static boolean isFieldBlank(Object value) {
        return value == null && Objects.isNull(value) ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * isFieldNull
     *
     * @param value
     * @return boolean
     */
    public static boolean isFieldNull(Object value) {
        if (Objects.nonNull(value)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * Get object value
     *
     * @param object
     * @param index
     * @return String
     */
    public static String getObjectValue(Object[] object, int index) {
        String objectValue = null;

        if (object[index] != null) {
            objectValue = object[index].toString();
        }

        return objectValue;
    }

    /**
     * getAssociationUpdateData
     *
     * @param sourceList
     * @param requestList
     * @return HashMap<String, List < Long>>
     */
    public static HashMap<String, List<Long>> getAssociationUpdateData(List<Long> sourceList, List<Long> requestList) {
        HashMap<String, List<Long>> result = new HashMap<>();

        if(Objects.nonNull(sourceList)){
            result.put("ToDelete", sourceList.stream().filter(x -> !requestList.contains(x)).collect(Collectors.toList()));
        }
        if(Objects.nonNull(requestList))
        {
            result.put("ToInsert", requestList.stream().filter(x -> !sourceList.contains(x)).collect(Collectors.toList()));
        }


        return result;
    }

    /**
     * generateRandomNumber
     *
     * @return int
     */
    public static int generateRandomNumber() {
        return new Random().nextInt(9000000) + 1000000;
    }

    /**
     * createPermitNumber
     *
     * @param eventName
     * @param eventStartDate
     * @return String
     */
    public static String createPermitNumber(String eventName, String eventStartDate) {
        return new StringBuilder().append(eventName.substring(PKConstants.Common.INT_ZERO, PKConstants.Common.INT_THREE))
//                .append(PKConstants.Common.SC_DASH)
//                .append(eventStartDate)
                .append(PKConstants.Common.SC_DASH)
                .append(generateRandomNumber())
                .toString();
    }

    /**
     * createPermitNumber
     *
     * @param parkingName
     * @param paymentModeId
     * @param loggedOnUserId
     * @return String
     */
    public static String createPermitNumber(String parkingName, long paymentModeId, long loggedOnUserId) {
        return new StringBuilder().append(parkingName.substring(PKConstants.Common.INT_ZERO, PKConstants.Common.INT_THREE))
                .append(PKConstants.Common.SC_DASH)
                .append(paymentModeId)
                .append(PKConstants.Common.SC_DASH)
                .append(loggedOnUserId)
                .append(PKConstants.Common.SC_DASH)
                .append(generateRandomNumber())
                .append(loggedOnUserId)
                .toString();
    }

    /**
     * getEventStartTime
     *
     * @param time
     * @return String
     */
    public static String getEventStartTime(long time) {
        Date date = new Date(time);
        DateFormat dateFormat = new SimpleDateFormat(PKConstants.Common.DATE_FORMAT_MM_DD);

        return dateFormat.format(date);
    }

    public static Boolean isInvoiceType(String type) {
        return Arrays.asList(INVOICE_REFUND_TYPES).indexOf(type) >= 0;
    }

    public static Boolean isPermitType(String type) {
        return Arrays.asList(PERMIT_REFUND_TYPES).indexOf(type) >= 0;
    }

    /**
     * generateSessionId
     *
     * @param spotName
     * @param ts
     * @return String
     */
    public static String generateSessionId(String spotName, long ts) {
        StringBuilder sessionId = new StringBuilder();
        Date date = new Date(ts);

        sessionId.append(spotName);
        sessionId.append(PKDateUtil.getDateByDateAndFormat(date, PKConstants.Common.DATE_FORMAT_MMDDYY));
        sessionId.append(PKDateUtil.getDateByDateAndFormat(date, PKConstants.Common.TIME_FORMAT_HHMMSS));

        return sessionId.toString();
    }

    /**
     * calcDuration
     *
     * @param seconds
     * @return String
     */
    public static String calcDuration(long seconds) {
        StringBuilder result = new StringBuilder();

        //long days = (seconds / PKConstants.Common.INT_FOURTEEN_FORTY) | PKConstants.Common.INT_ZERO;
        long hours = (seconds / 3600); //((seconds % PKConstants.Common.INT_FOURTEEN_FORTY) / PKConstants.Common.INT_SIXTY) | PKConstants.Common.INT_ZERO;
        long mins = (seconds % 3600) / 60; //seconds % PKConstants.Common.INT_SIXTY;
        long secs = seconds % PKConstants.Common.INT_SIXTY;

        //result.append(days);
        //result.append(PKConstants.Common.SESSION_DURATION_DAYS);
        result.append(hours);
        result.append(PKConstants.Common.SESSION_DURATION_HOURS);
        result.append(mins);
        result.append(PKConstants.Common.SESSION_DURATION_MINUTES);
        result.append(secs);
        result.append(PKConstants.Common.SESSION_DURATION_SECONDS);

        return result.toString();
    }

    /**
     * getValueFromMapByKey
     *
     * @param model
     * @param key
     * @return String
     */
    public static String getValueFromMapByKey(Map<String, Object> model, String key) {
        String mapValue = PKConstants.Common.SC_EMPTY;

        if (model.get(key) != null) {
            mapValue = model.get(key).toString();
        }

        return mapValue;
    }

    /**
     * isSessionExpired
     *
     * @param sessionCurrentTime
     * @param sessionExpiredTime
     * @return boolean
     */
    public static boolean isSessionExpired(long sessionCurrentTime, int sessionExpiredTime) {
        boolean sessionExpired = Boolean.FALSE;

        if (sessionExpiredTime > PKConstants.Common.INT_ZERO) {
            sessionExpiredTime = sessionExpiredTime * PKConstants.Common.MINUTE_IN_SECONDS;

            if (sessionCurrentTime > sessionExpiredTime) {
                sessionExpired = Boolean.TRUE;
            }
        }

        return sessionExpired;
    }
}