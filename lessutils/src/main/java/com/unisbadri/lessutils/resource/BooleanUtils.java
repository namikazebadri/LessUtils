package com.unisbadri.lessutils.resource;

import com.unisbadri.lessutils.LessUtils;

public class BooleanUtils
{
    public static boolean fromResource(int resource)
    {
        return LessUtils.getContext().getResources().getBoolean(resource);
    }
}