package com.unisbadri.lessutils;

import android.content.Context;
import android.util.Log;

public class LessUtils {

    private static Context context;

    public static void initialize(Context context) {
        LessUtils.context = context;
    }

    public static Context getContext() {
        return context;
    }

    static {
        try {
            Class<?> c = Class.forName("android.app.ActivityThread");
            context = (android.app.Application) c.getDeclaredMethod("currentApplication").invoke(null);
        } catch (Throwable e) {
            Log.e("LessUtils ERROR!!", "LessUtils failed to initialize Context", e);
        }
    }
}
