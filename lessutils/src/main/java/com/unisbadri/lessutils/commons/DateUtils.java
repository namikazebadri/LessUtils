package com.unisbadri.lessutils.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static class Formatter {
        public static String format(Date date, String format) {
            return format(date, format, Locale.getDefault());
        }

        public static String format(Calendar calendar, String format) {
            return format(calendar.getTime(), format, Locale.getDefault());
        }

        public static String format(Date date, String format, Locale locale) {
            return new SimpleDateFormat(format, locale).format(date);
        }

        public static String format(Calendar calendar, String format, Locale locale) {
            return new SimpleDateFormat(format, locale).format(calendar.getTime());
        }
    }

    public static class FormatChanger {
        public static String changeFormat(String date, String currentFormat, String resultFormat) {
            Date dateObject = Parser.parseToDate(date, currentFormat, Locale.getDefault());

            return Formatter.format(dateObject, resultFormat, Locale.getDefault());
        }

        public static String changeFormat(String date, String currentFormat, String resultFormat, Locale locale) {
            Date dateObject = Parser.parseToDate(date, currentFormat, locale);

            return Formatter.format(dateObject, resultFormat, locale);
        }

        public static String changeFormat(String date, String currentFormat, Locale previousLocale, String resultFormat, Locale resultLocale) {
            Date dateObject = Parser.parseToDate(date, currentFormat, previousLocale);

            return Formatter.format(dateObject, resultFormat, resultLocale);
        }
    }

    public static class Parser {
        public static Calendar parseToCalendar(String dateString, String format, Locale locale) {
            Calendar calendar = Calendar.getInstance();

            Date date = parseToDate(dateString, format, locale);

            if(date != null) {
                calendar.setTime(date);

                return calendar;
            } else {
                return null;
            }
        }

        public static Calendar parseToCalendar(String dateString, String format) {
            return parseToCalendar(dateString, format, Locale.getDefault());
        }

        public static Date parseToDate(String date, String format) {
            return parseToDate(date, format, Locale.getDefault());
        }

        public static Date parseToDate(String date, String format, Locale locale) {
            try {
                return new SimpleDateFormat(format, locale).parse(date);
            } catch (ParseException e) {
                return null;
            }
        }
    }
}