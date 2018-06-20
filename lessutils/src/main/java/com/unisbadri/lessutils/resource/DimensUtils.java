package com.unisbadri.lessutils.resource;

import com.unisbadri.lessutils.LessUtils;

public class DimensUtils
{
    public static float fromResource(int resource)
    {
        return LessUtils.getContext().getResources().getDimension(resource);
    }
}