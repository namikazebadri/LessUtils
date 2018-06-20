package com.unisbadri.lessutils.commons;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.MimeTypeMap;

import com.unisbadri.lessutils.LessUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

public class CommonUtils {

    public static Locale getLocale(String country) {
        for (Locale locale : Locale.getAvailableLocales()) {
            if((locale.getLanguage() + "_" + locale.getCountry()).equals(country)) {
                return locale;
            }
        }

        return Locale.getDefault();
    }

    public static Locale getLocale(String language, String country) {
        for (Locale locale : Locale.getAvailableLocales()) {
            if(locale.getLanguage().equals(language) && locale.getCountry().equals(country)) {
                return locale;
            }
        }

        return Locale.getDefault();
    }

    public static void showKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) LessUtils.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
    }

    public static void hideKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) LessUtils.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static float convertPixelsToDp(Context context, float px) {
        float scale = context.getResources().getDisplayMetrics().density;

        int dpAsPixels = (int) (px*scale + 0.5f);

        return dpAsPixels;
    }

    public static String removePathSegment(String url) throws URISyntaxException {
        URI uri = new URI(url);

        return uri.getScheme() + "://" + uri.getHost();
    }
}