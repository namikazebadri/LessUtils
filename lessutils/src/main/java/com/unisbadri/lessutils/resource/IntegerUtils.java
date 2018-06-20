package com.unisbadri.lessutils.resource;

import com.unisbadri.lessutils.LessUtils;

public class IntegerUtils
{
    public static int fromResource(int resource)
    {
        return LessUtils.getContext().getResources().getInteger(resource);
    }
}