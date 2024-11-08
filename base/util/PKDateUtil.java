package com.conurets.parking_kiosk.base.util;

import com.conurets.parking_kiosk.base.exception.PKException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Adeel Ali
 * @version 1.0
 */

@Slf4j
public class PKDateUtil {
    /**
     * getCurrentDate
     *
     * @return Date
     */
    public static Date getCurrentDate() {
        return new Date(); //convertInToTimeZone(new Date().getTime());
    }

    /**
     * Get current timestamp
     *
     * @return Timestamp
     */
    public static final Timestamp getCurrentTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * Get date object by format
     *
     * @param input
     * @param format
     * @return Date
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
     * @return Date
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
     * @return Timestamp
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
     * @return Long
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

    public static Timestamp stringToTimestamp(String dateTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(PKConstants.Common.DATE_FORMAT_YYYY_MM_DD);
        Date date = sdf.parse(dateTime);
        String pattern = PKConstants.Common.DATE_FORMAT_YYYY_MM_DD;
        SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
        String data = dateFormatter.format(date) + " 00:00:00.000";
        //Convert  Date to Timestamp
        Timestamp t1 = Timestamp.valueOf(data);

        return t1;
    }

    public static Timestamp stringToDateStamp(String date) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("0000-00-00 HH:mm:ss");
            Date parsedDate = dateFormat.parse(date);
            return new Timestamp(parsedDate.getDate());
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

    public static Timestamp getStartDate() {
        Date date = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
        String data = dateFormatter.format(date) + " 00:00:00.000";
        //Convert  Date to Timestamp
        Timestamp t1 = Timestamp.valueOf(data);
        return t1;
    }

    public static Timestamp getEndDate() {
        Date date = new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
        String data = dateFormatter.format(date) + " 23:59:59.000";
        //Convert  Date to Timestamp
        Timestamp t1 = Timestamp.valueOf(data);

        return t1;
    }

    public static Timestamp getEndDate(String endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(PKConstants.Common.DATE_FORMAT_YYYY_MM_DD);
        Date date = sdf.parse(endDate);
        String pattern = PKConstants.Common.DATE_FORMAT_YYYY_MM_DD;
        SimpleDateFormat dateFormatter = new SimpleDateFormat(pattern);
        String data = dateFormatter.format(date) + " 23:59:59.000";
        //Convert  Date to Timestamp
        Timestamp t1 = Timestamp.valueOf(data);

        return t1;
    }

    public static Timestamp addDays(Timestamp date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);// w ww.  j ava  2  s  .co m
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return new Timestamp(cal.getTime().getTime());
    }

    public static String convertStringToTimeStamp(Timestamp ts) {
        //ts = ...;
        Date date = new Date();
        date.setTime(ts.getTime());
        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return formattedDate;
    }

    public static Timestamp getDate(Timestamp timestamp) {
        LocalDate lDate = timestamp.toInstant().atZone(ZoneId.of("UTC")).toLocalDate();
        return Timestamp.valueOf(lDate.atStartOfDay());
    }

    public static String addOneYear(String date) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(date));
        c.add(Calendar.YEAR, 1);
        return sdf.format(c.getTime());
    }

    public static Long getDayDifference(String startDate, String endDate) throws ParseException {
        // SimpleDateFormat converts the
        // string format to date object
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        //LocalTime hours =  null;
        // Try Block

        // parse method is used to parse
        // the text from a string to
        // produce the date
        Date d1 = sdf.parse(startDate);
        Date d2 = sdf.parse(endDate);
        // Calculate time difference
        // in milliseconds
        long difference_In_Time = d2.getTime() - d1.getTime();

        // Calculate time difference in
        // seconds, minutes, hours, years,
        // and days

        long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

        return difference_In_Days;
    }

    public static Long getDifferenceBetweenTwoDates(String startDate, String endDate){
        Long difference_In_Days = 0L;
        // Define two LocalDate objects for the dates you want to compare
        LocalDate date1 = LocalDate.of(Integer.parseInt(startDate.split("-")[0]), Integer.valueOf(startDate.split("-")[1]), Integer.parseInt(startDate.split("-")[2]));
        LocalDate date2 = LocalDate.of(Integer.parseInt(endDate.split("-")[0]), Integer.parseInt(endDate.split("-")[1]), Integer.parseInt(endDate.split("-")[2]));

        Period period = Period.between(date1, date2);
        // Calculate the difference between the two dates
        difference_In_Days = Long.valueOf(period.getDays())+1;
        return difference_In_Days;
    }

    public static Date convertTimestampToDate(Timestamp timestamp) {
        Date date = new Date(timestamp.getTime());
        return date;
    }

    public static Long getTotalNoOfDays(Date startDate, Date endDate, Boolean saturday, Boolean sunday) {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);

        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);

        Long workDays = Long.valueOf(0);

        //Return 0 if start and end are the same
        if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
            return 1L;
        } else if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
            startCal.setTime(endDate);
            endCal.setTime(startDate);
        }

        do {
            //excluding start date
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            if (!saturday && !sunday) {
                if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                    ++workDays;
                }
            } else if (!saturday) {
                if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                    ++workDays;
                }
            } else if (!sunday) {
                if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
                    ++workDays;
                }
            } else {
                ++workDays;
            }

        } while (startCal.getTimeInMillis() <= endCal.getTimeInMillis()); //excluding end date

        return workDays;
    }

    public static Integer getDayNumber() {
        Integer day = 0;

        Calendar Date = Calendar.getInstance();
        Date.setTime(convertTimestampToDate(getCurrentTimestamp()));

        day = Date.get(Calendar.DATE);

        return day;
    }

    public static String getDayName() {
        String day = "";
        String dayNames[] = new DateFormatSymbols().getWeekdays();
        Calendar Date = Calendar.getInstance();
        Date.setTime(convertTimestampToDate(getCurrentTimestamp()));

        day = dayNames[Date.get(Calendar.DAY_OF_WEEK)];

        return day;
    }

    public static Timestamp getFirstDateOfMonth(Timestamp date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(convertTimestampToDate(date));
        // set day to minimum
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Timestamp getLastDateOfMonth(Timestamp date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(convertTimestampToDate(date));
        // set day to minimum
        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Timestamp getFirstDateOfWeek(Timestamp date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(convertTimestampToDate(date));
        // set day to minimum
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Timestamp getLastDateOfWeek(Timestamp date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getFirstDateOfWeek(date));
        for (int i = 0; i < 6; i++) {
            calendar.add(Calendar.DATE, 1);
        }
        // set day to minimum
        //calendar.set(Calendar.DAY_OF_WEEK,calendar.SUNDAY);;
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static int compareDates(Date date1, Date date2) throws ParseException {
        SimpleDateFormat sdformat = new SimpleDateFormat(PKConstants.Common.DATE_FORMAT_YYYY_MM_DD);
        String d1 = sdformat.format(date1);
        String d2 = sdformat.format(date2);

        return d1.compareTo(d2);
    }

    public static Long findMonthFromDate(Timestamp timestamp) {
        Long month = 0L;
        Calendar cal = Calendar.getInstance();
        cal.setTime(convertTimestampToDate(timestamp));
        month = Long.valueOf(cal.get(Calendar.MONTH) + 1);
        return month;
    }

    public static Long findYearFromDate(Timestamp timestamp) {
        Long year = 0L;
        Calendar cal = Calendar.getInstance();
        cal.setTime(convertTimestampToDate(timestamp));
        year = Long.valueOf(cal.get(Calendar.YEAR));
        return year;
    }

    public static Date longTimestampToDateYYYYMMDD(long time) {
        return getDateYYYYMMDD(dateToString(new Date(time)));
    }

    public static String dateToString(Date input) {
        String strDate = PKConstants.Common.SC_EMPTY;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PKConstants.Common.DATE_FORMAT_MM_DD_YYYY_HH_MM_SS);
            strDate = simpleDateFormat.format(input);
        } catch (Exception e) {
            log.error("PEDateUtil.getDateByDateAndFormat", e);
        }
        return strDate;
    }

    public static Date getDateYYYYMMDD(String input) {
        Date date = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PKConstants.Common.DATE_FORMAT_YYYY_MM_DD);
            date = simpleDateFormat.parse(input);
        } catch (ParseException e) {
            log.error("PEDateUtil.getDateByDateAndFormat", e);
        }
        return date;
    }

    /**
     *
     * @param date
     * @param format
     * @return
     */
    public static String getDateByDateAndFormat(Date date, String format) {
        SimpleDateFormat localDateFormat = new SimpleDateFormat(format);
        String currentDate = null;

        try {
            currentDate = localDateFormat.format(date);
        } catch (Exception e) {
            log.error("PEDateUtil.getDateByDateAndFormat", e);
        }

        return currentDate;
    }

    public static Boolean validateCurrentDateBetweenTwoDates(Timestamp t1, Timestamp t2){

        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Parse the start and end date-time strings into LocalDateTime objects
        LocalDateTime startDateTime = t1.toLocalDateTime();
        LocalDateTime endDateTime = t2.toLocalDateTime();

        // Check if the current date-time is between the start and end date-times
        if (currentDateTime.isAfter(startDateTime) && currentDateTime.isBefore(endDateTime)) {
            return true;
        } else {
            return false;
        }
    }
    public static String dateFormat(Timestamp t){
        LocalDateTime localDateTime = t.toLocalDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedTimestamp = localDateTime.format(formatter);
        return formattedTimestamp;

    }

    public static Long getDurationInHourFromCurrentDate(Timestamp timestamp){
        Long duration = 0L;

        // Get the current timestamp
        Instant timestamp1 = Instant.now();

        // Create another timestamp (for example, from a database or other source)
        Instant timestamp2 = timestamp.toInstant();
        // Calculate the time difference
        Duration dur = Duration.between(timestamp1, timestamp2);
        String s = String.valueOf(dur.toHours());
        duration =  Long.parseLong(s);

        return duration;
    }
}