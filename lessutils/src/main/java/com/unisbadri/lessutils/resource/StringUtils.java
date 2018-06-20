package com.unisbadri.lessutils.resource;

import android.support.annotation.NonNull;
import android.text.Html;
import android.text.Spanned;

import com.unisbadri.lessutils.LessUtils;
import com.unisbadri.lessutils.R;

import org.json.JSONArray;

import java.text.NumberFormat;
import java.util.Locale;

public class StringUtils
{
    @NonNull
    public static String emptyString()
    {
        return fromResource(R.string.lessEmptyText);
    }

    @NonNull
    public static String fromResource(int resource)
    {
        return LessUtils.getContext().getString(resource);
    }

    @NonNull
    public static String fromResource(int resource, Object... parameters)
    {
        return LessUtils.getContext().getString(resource, parameters);
    }

    public static Spanned convertHtml(String text)
    {
        return Html.fromHtml(text);
    }

    public static Spanned htmlFromResource(int resource)
    {
        return Html.fromHtml(LessUtils.getContext().getString(resource));
    }

    public static Spanned htmlFromResource(int resource, Object... parameters)
    {
        return Html.fromHtml(LessUtils.getContext().getString(resource, parameters));
    }

    @NonNull
    public static String implode(JSONArray items, String glue) throws Exception
    {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < items.length(); i++)
        {
            stringBuilder.append(items.getString(i).toUpperCase());

            if(i < items.length() - 1)
            {
                stringBuilder.append(glue);
            }
        }

        return stringBuilder.toString();
    }

    public static JSONArray explode(String chain, String separator)
    {
        JSONArray items = new JSONArray();

        String[] chains = chain.split(separator);

        for(int i = 0; i < chains.length; i++)
        {
            items.put(chains[i]);
        }

        return items;
    }

    public static String formatCurrency(int number, Locale locale)
    {
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);

        return format.format(number);
    }
}