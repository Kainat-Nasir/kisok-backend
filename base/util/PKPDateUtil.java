package com.conurets.parking_kiosk.base.util;

import com.conurets.parking_kiosk.base.exception.PKException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
public class PKPDateUtil {
    /**
     * getCurrentDate
     *
     * @return
     */
    public static Date getCurrentDate() {
        return convertInToTimeZone(new Date().getTime());
    }

    /**
     * Get current timestamp
     *
     * @return
     */
    public static final Timestamp getCurrentTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * Get date object by format
     *
     * @param input
     * @param format
     * @return
     */
    public static Date getDateByFormat(String input, String format) {
        Date date = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            date = simpleDateFormat.parse(input);
        } catch (ParseException e) {
            log.error("HCMDateUtil.getDateByFormat", e);
        }
        return date;
    }

    /**
     * Convert into time zone
     *
     * @param ts
     * @return
     */
    public static Date convertInToTimeZone(long ts) {
        SimpleDateFormat easternDateFormat = new SimpleDateFormat(PKConstants.Common.DATE_FORMAT_MM_DD_YYYY_HH_MM_SS);
        TimeZone easternTimeZone = TimeZone.getTimeZone("UTC");

        Date currentDate = new Date(ts);
        Date datEasternTimeZone = null;

        try {
            easternDateFormat.setTimeZone(easternTimeZone);
            String strEasternTime = easternDateFormat.format(currentDate.getTime());

            SimpleDateFormat sdf = new SimpleDateFormat(PKConstants.Common.DATE_FORMAT_MM_DD_YYYY_HH_MM_SS);
            datEasternTimeZone = sdf.parse(strEasternTime);
        } catch (ParseException e) {
            log.error("convertInToTimeZone", e);
        }

        return datEasternTimeZone;
    }

    /**
     * Convert String Date into Timestamp Date
     *
     * @param stringDate,RecievingDatePattren,RecievingDateLocale
     * @return
     */

    public static Timestamp getTimestampFromString(String stringDate, String RecievingDatePattren, Locale RecievingDateLocale) {
        //Convert String to LocalDate format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(RecievingDatePattren, RecievingDateLocale);

        LocalDate dateDate = LocalDate.parse(stringDate, formatter);

        //Convert LocalDate to Date format
        Date date = java.sql.Date.valueOf(dateDate);

        // Format StartDate and EndDate to Custom Date format
        // SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        SimpleDateFormat dateFormatter = new SimpleDateFormat(PKConstants.Common.DATE_FORMAT_YYYY_MM_DD_00_00_00);
        String _stringDate = dateFormatter.format(date);

        //Convert  Date to Timestamp
        Timestamp t1 = Timestamp.valueOf(_stringDate);
        return t1;
    }

    /**
     * Get Age in Years from String Date
     *
     * @param stringDate
     * @return
     */
    public static Long getAgeFromTimestampDate(Timestamp stringDate) {
        Timestamp _dateToday = getCurrentTimestamp();
        // Difference in Time
        long diff = _dateToday.getYear() - stringDate.getYear();
        return diff; // Difference in Years
    }

    /**
     * Returns the time left before a future date (provided in Timestamp)
     * (unit is milliseconds)
     */
    public static Long getTimeLeftFromToday(Timestamp till) {
        return till.getTime() - getCurrentTimestamp().getTime();
    }

    /**
     * Returns the date / time in String in the format specified
     */
    public static String getFormattedDateStringFromTimestamp(Timestamp ts, String pattern) {
        return new SimpleDateFormat(pattern).format(ts);
    }

    public static String getFormattedTimeStringFromLocalTime(LocalTime ts, String pattern) {
        return new SimpleDateFormat(pattern).format(ts);
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }


//    public static Long calculateDuration(String date1 ,String date2, String value) {
//        Timestamp date_1 = stringToTimestamp(date1);
//        Timestamp date_2 = stringToTimestamp(date2);
//        assert date_1 != null;
//        long milliseconds = date_1.getTime() - date_2.getTime();
//        if (value.equals("second"))
//            return milliseconds / 1000;
//        if (value.equals("minute"))
//            return milliseconds / 1000 / 60;
//        if (value.equals("hours"))
//            return milliseconds / 1000 / 3600;
//        else
//            return new Long(999999999);
//    }

    public static Timestamp stringToTimestamp(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("0000-00-00 HH:mm:ss");
            Date parsedDate = dateFormat.parse(date);
            return new Timestamp(parsedDate.getTime());
        } catch (Exception e) {
            return null;
        }
    }

    public static LocalTime convertStringToTime(String inputTime, String Format) {
        try {
            // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Format);
            LocalTime outPutTime = LocalTime.parse(inputTime, dtf);
            return outPutTime;
        } catch (Exception e) {
            return null;
        }
    }

    public static String convertMonthToString(Long index) {
        String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};
        return months[index.intValue() - 1];
    }

    public static Double getDuration(LocalTime start, LocalTime end) {

        Double duration = Double.valueOf(0);
        Integer startTimeHrs = start.getHour();
        Integer endTimeHrs = end.getHour();
        Integer startTimeMin = start.getMinute();
        Integer endTimeMin = end.getMinute();

        if (startTimeHrs > endTimeHrs) {
            duration = (double) (24 - startTimeHrs) + endTimeHrs;
        } else {
            duration = (double) endTimeHrs - startTimeHrs;
        }

        if (startTimeMin > endTimeMin) {
            duration += ((double) ((60 - startTimeMin) + endTimeMin)) / 60;// 15/60 => duration + 0.25 i.e. 3+0.25 = 3.25
            duration--;
        } else {
            duration += ((double) (endTimeMin - startTimeMin)) / 60;
        }
        return duration;
    }

    @SneakyThrows
    public static Long calculateOverTime(String start_date, String end_date, Double duration) throws PKException {
        // SimpleDateFormat converts the
        // string format to date object
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        //LocalTime hours =  null;
        // Try Block

        // parse method is used to parse
        // the text from a string to
        // produce the date
        Date d1 = sdf.parse(start_date);
        Date d2 = sdf.parse(end_date);
        // Calculate time difference
        // in milliseconds
        long difference_In_Time = d2.getTime() - d1.getTime();

        // Calculate time difference in
        // seconds, minutes, hours, years,
        // and days

        long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;

        long overTime = (long) (difference_In_Hours - duration);

        overTime = overTime <= 0 ? 0 : overTime;
        return overTime;
    }

    @SneakyThrows
    public static String findDifference(String start_date, String end_date) throws PKException {
        // SimpleDateFormat converts the
        // string format to date object
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        //LocalTime hours =  null;
        // Try Block

        // parse method is used to parse
        // the text from a string to
        // produce the date
        Date d1 = sdf.parse(start_date);
        Date d2 = sdf.parse(end_date);
        // Calculate time difference
        // in milliseconds
        long difference_In_Time = d2.getTime() - d1.getTime();

        // Calculate time difference in
        // seconds, minutes, hours, years,
        // and days
        long difference_In_Seconds = (difference_In_Time / 1000) % 60;

        long difference_In_Minutes = (difference_In_Time / (1000 * 60)) % 60;

        long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)) % 24;

        //long difference_In_Years = (difference_In_Time / (1000l * 60 * 60 * 24 * 365));

        //long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

        String differences = difference_In_Hours + ":" + difference_In_Minutes + ":" + difference_In_Seconds;
        return differences;
    }

    public static String convertHrsToTimeString(double hours) {
        double hourPart = (int) hours;
        double minutePart = (hours - hourPart) * 60;
        return String.format("%02.0f:%02.0f", hourPart, minutePart);
    }

    public static LocalDate convertStringToLocalDate(String Date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
        String date = Date;

        //convert String to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);
        return localDate;
    }

    public static String ReturnDayName(LocalDate localDate) {
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return dayOfWeek.toString();
    }

    public static LocalDate getStartDate() {

        LocalDate dt = LocalDate.now();
        LocalDate Date = dt.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
        //System.out.println("\nNext Saturday: "+dt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)));

        return Date;
    }

    public static LocalDate getEndDate() {

        LocalDate dt = LocalDate.now();
        LocalDate Date = dt.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        //System.out.println("\nNext Saturday: "+dt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY)));

        return Date;
    }

    public static String convertStringToTimeStamp(Timestamp ts) {
        //ts = ...;
        Date date = new Date();
        date.setTime(ts.getTime());
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return formattedDate;
    }


    public static String timestampToDateFormat(long timestamp,String format){

        Timestamp ts=new Timestamp(timestamp);
        SimpleDateFormat formatter = new SimpleDateFormat(format);

        return formatter.format(ts);
    }

}



