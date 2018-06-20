package com.unisbadri.lessutils.resource;

import android.content.ContentResolver;
import android.net.Uri;
import android.webkit.MimeTypeMap;

import com.unisbadri.lessutils.LessUtils;

public class FileUtils
{
    public static String getRealPath() {
        return null;
    }

    public static String getMimeType(Uri uri, String defaultMime) {
        String mimeType;

        if (uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
            ContentResolver contentResolver = LessUtils.getContext().getContentResolver();

            mimeType = contentResolver.getType(uri);
        } else {
            String fileExtension = MimeTypeMap.getFileExtensionFromUrl(uri.toString());

            mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtension.toLowerCase());
        }

        return mimeType == null ? defaultMime : mimeType;
    }
}
