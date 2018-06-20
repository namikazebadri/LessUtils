package com.unisbadri.lessutils.commons;

import android.util.Log;

import com.unisbadri.lessutils.R;
import com.unisbadri.lessutils.resource.StringUtils;

public class Logger
{
    private static String TAG = StringUtils.fromResource(R.string.log_tag);

    public static class Verbose {
        public static void log(String content) {
            Log.v(TAG, content);
        }

        public static void log(int content) {
            log(String.valueOf(content));
        }

        public static void log(long content) {
            log(String.valueOf(content));
        }

        public static void log(double content) {
            log(String.valueOf(content));
        }

        public static void log(float content) {
            log(String.valueOf(content));
        }

        public static void log(boolean content) {
            log(String.valueOf(content));
        }

        public static void log(Object content) {
            log(content.toString());
        }

        public static void forThrowable(Throwable throwable) {
            Log.i(TAG, StringUtils.fromResource(R.string.throwable_log_signature), throwable);
        }
    }

    public static class Warning {
        public static void log(String content)
        {
            Log.w(TAG, content);
        }

        public static void log(int content) {
            log(String.valueOf(content));
        }

        public static void log(long content) {
            log(String.valueOf(content));
        }

        public static void log(double content) {
            log(String.valueOf(content));
        }

        public static void log(float content) {
            log(String.valueOf(content));
        }

        public static void log(boolean content) {
            log(String.valueOf(content));
        }

        public static void log(Object content) {
            log(content.toString());
        }

        public static void forThrowable(Throwable throwable) {
            Log.i(TAG, StringUtils.fromResource(R.string.throwable_log_signature), throwable);
        }
    }

    public static class Info {
        public static void log(String content) {
            Log.i(TAG, content);
        }

        public static void log(int content) {
            log(String.valueOf(content));
        }

        public static void log(long content) {
            log(String.valueOf(content));
        }

        public static void log(double content) {
            log(String.valueOf(content));
        }

        public static void log(float content) {
            log(String.valueOf(content));
        }

        public static void log(boolean content) {
            log(String.valueOf(content));
        }

        public static void log(Object content) {
            log(content.toString());
        }

        public static void forThrowable(Throwable throwable) {
            Log.i(TAG, StringUtils.fromResource(R.string.throwable_log_signature), throwable);
        }
    }

    public static class Debug {
        public static void log(String content) {
            Log.d(TAG, content);
        }

        public static void log(int content) {
            log(String.valueOf(content));
        }

        public static void log(long content) {
            log(String.valueOf(content));
        }

        public static void log(double content) {
            log(String.valueOf(content));
        }

        public static void log(float content) {
            log(String.valueOf(content));
        }

        public static void log(boolean content) {
            log(String.valueOf(content));
        }

        public static void log(Object content) {
            log(content.toString());
        }

        public static void forThrowable(Throwable throwable) {
            Log.i(TAG, StringUtils.fromResource(R.string.throwable_log_signature), throwable);
        }
    }

    public static class Error {
        public static void log(String content) {
            Log.e(TAG, content);
        }

        public static void log(int content) {
            log(String.valueOf(content));
        }

        public static void log(long content) {
            log(String.valueOf(content));
        }

        public static void log(double content) {
            log(String.valueOf(content));
        }

        public static void log(boolean content) {
            log(String.valueOf(content));
        }

        public static void log(Object content) {
            log(content.toString());
        }

        public static void forThrowable(Throwable throwable) {
            Log.i(TAG, StringUtils.fromResource(R.string.throwable_log_signature), throwable);
        }
    }
}
