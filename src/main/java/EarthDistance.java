/**
 * This class holds the utils methods relating to earth radius computation
 */
public class EarthDistance {

    private static final double EARTH_RADIUS_R = 6378.137;
    private static final double DEGREE_PER_RADIAN = 0.0174532925;

    /**
     * convert degree to radian. According to google, 1 degree ~= 0.017
     *
     * @param degree
     * @return
     */
    public double convertDegreeToRadian(final double degree) {
        return degree * DEGREE_PER_RADIAN;
    }

    /**
     * absolute change btw longitude1 and longitude2
     *
     * @param long1
     * @param long2
     * @return
     */
    public double changeInLongitude(final double long1, final double long2) {
        return Math.abs(long1 - long2);
    }

    public double calculateDistance(final double lat1, final double lat2, final double long1, final double long2) {
//        get the change in longitude
        final double longChange = changeInLongitude(long1, long2);

//        calculate the central angle
        final double centralAngle =
                Math.acos((Math.sin(lat1) * Math.sin(lat2)) + (Math.cos(lat1) * Math.cos(lat2) * Math.cos(longChange)));

        return centralAngle * EARTH_RADIUS_R;
    }
}
