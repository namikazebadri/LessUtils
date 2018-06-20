package com.unisbadri.lessutils.commons;

import android.content.Context;
import android.content.SharedPreferences;

import com.unisbadri.lessutils.BuildConfig;
import com.unisbadri.lessutils.LessUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

public class Store
{
    private static SharedPreferences sharedPreferences;

    public static class Json {
        public static JSONObject getJSONObject(String key) {
            try {
                return new JSONObject(sharedPreferences.getString(key, "{}"));
            } catch (JSONException e) {
                return null;
            }
        }

        public static void putJSONObject(String key, JSONObject value) {
            sharedPreferences.edit().putString(key, value.toString()).apply();
        }

        public static JSONArray getJSONArray(String key) {
            try {
                return new JSONArray(sharedPreferences.getString(key, "[]"));
            } catch (JSONException e) {
                return null;
            }
        }

        public static void putJSONArray(String key, JSONArray value) {
            sharedPreferences.edit().putString(key, value.toString()).apply();
        }
    }

    public static class Primitive {
        public static String getString(String key, String defaultValue) {
            return sharedPreferences.getString(key, defaultValue);
        }

        public static void putString(String key, String value) {
            sharedPreferences.edit().putString(key, value).apply();
        }

        public static Boolean getBoolean(String key, Boolean defaultValue) {
            return sharedPreferences.getBoolean(key, defaultValue);
        }

        public static void putBoolean(String key, Boolean value) {
            sharedPreferences.edit().putBoolean(key, value).apply();
        }

        public static int getInt(String key, int defaultValue) {
            return sharedPreferences.getInt(key, defaultValue);
        }

        public static void putInt(String key, int value) {
            sharedPreferences.edit().putInt(key, value).apply();
        }

        public static long getLong(String key, long defaultValue) {
            return sharedPreferences.getLong(key, defaultValue);
        }

        public static void putLong(String key, long value) {
            sharedPreferences.edit().putLong(key, value).apply();
        }

        public static float getFloat(String key, float defaultValue) {
            return sharedPreferences.getFloat(key, defaultValue);
        }

        public static void putFloat(String key, float value) {
            sharedPreferences.edit().putFloat(key, value).apply();
        }
    }

    public static class Date {
        public static String getDateWithFormat(String key, String format) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

            return simpleDateFormat.format(getDate(key));
        }

        public static java.util.Date getDate(String key) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

            try {
                return simpleDateFormat.parse(sharedPreferences.getString(key, null));
            } catch(Exception e) {
                return null;
            }
        }

        public static void putDate(String key, Date date) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

            sharedPreferences.edit().putString(key, simpleDateFormat.format(date)).apply();
        }
    }

    public static class Calendar {
        public static String getWithFormat(String key, String format) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

            return simpleDateFormat.format(get(key));
        }

        public static java.util.Calendar get(String key) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

            try {
                java.util.Calendar calendar = java.util.Calendar.getInstance();
                calendar.setTime(simpleDateFormat.parse(sharedPreferences.getString(key, null)));

                return calendar;
            } catch(Exception e) {
                return null;
            }
        }

        public static void put(String key, java.util.Calendar calendar) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

            sharedPreferences.edit().putString(key, simpleDateFormat.format(calendar.getTime())).apply();
        }
    }

    public static boolean isExists(String key) {
        return sharedPreferences.contains(key);
    }

    public static void remove(String key) {
        sharedPreferences.edit().remove(key).apply();
    }

    public static void clear() {
        sharedPreferences.edit().clear().apply();
    }

    public static void initialize() {
        if(sharedPreferences == null) {
            sharedPreferences = LessUtils.getContext().getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);
        }
    }
}