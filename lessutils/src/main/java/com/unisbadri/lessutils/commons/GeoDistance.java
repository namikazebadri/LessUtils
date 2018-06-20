package com.unisbadri.lessutils.commons;

public class GeoDistance {

    public static final int UNIT_KILOMETERS = 0;
    public static final int UNIT_MILES = 1;
    public static final int UNIT_METERS = 2;
    public static final int UNIT_NAUTICAL = 3;

    private static double calculate(double latitudeSource, double longitudeSource, double latitudeDestination, double longitudeDestination, int unit) {
        double theta = longitudeSource - longitudeDestination;

        double distance = Math.sin(deg2rad(latitudeSource)) * Math.sin(deg2rad(latitudeDestination)) + Math.cos(deg2rad(latitudeSource)) * Math.cos(deg2rad(latitudeDestination)) * Math.cos(deg2rad(theta));

        distance = Math.acos(distance);
        distance = rad2deg(distance);
        distance = distance * 60 * 1.1515;

        if (unit == UNIT_KILOMETERS || unit == UNIT_METERS) {
            distance = distance * 1.609344;

            if(unit == UNIT_METERS) {
                distance /= 1000;
            }
        } else if (unit == UNIT_NAUTICAL) {
            distance = distance * 0.8684;
        }

        return (distance);
    }

    private static double deg2rad(double degrees) {
        return (degrees * Math.PI / 180.0);
    }

    private static double rad2deg(double radius) {
        return (radius * 180 / Math.PI);
    }

    public static double calculate(double latitudeSource, double longitudeSource, double latitudeDestination, double longitudeDestination) {
        return calculate(latitudeSource, longitudeSource, latitudeDestination, longitudeDestination, UNIT_MILES);
    }
}