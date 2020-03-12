public class InvitationDistance {

    //    boundary to determine those that get invited
    private static final int RANGE_BOUNDARY = 100;

    //    lat and long for the company of invitation
    private static final double DUBLIN_LATITUDE = 53.339428;
    private static final double DUBLIN_LONGITUDE = -6.257664;

    private final EarthDistance mEarthDistance;

    public InvitationDistance(final EarthDistance earthDistance) {
        this.mEarthDistance = earthDistance;
    }

    /**
     * @param latitude
     * @param longitude
     * @return true | false if invitation is within boundary
     */
    public boolean isWithinBoundary(final double latitude, final double longitude) {
        return calculateShortestDistance(latitude, longitude) <= RANGE_BOUNDARY;
    }

    /**
     * Given lat and long, calculate the distance btw the dublin office and the given points
     *
     * @param latitude
     * @param longitude
     * @return distance
     */
    private double calculateShortestDistance(final double latitude, final double longitude) {
//        convert lat1 and lat2 to radians
        final double latitudeOneRad = this.mEarthDistance.convertDegreeToRadian(latitude);
        final double latitudeTwoRad = this.mEarthDistance.convertDegreeToRadian(DUBLIN_LATITUDE);

//        convert long1 and long2 to radians
        final double longitudeOneRad = this.mEarthDistance.convertDegreeToRadian(longitude);
        final double longitudeTwoRad = this.mEarthDistance.convertDegreeToRadian(DUBLIN_LONGITUDE);

        return this.mEarthDistance.calculateDistance(latitudeOneRad, latitudeTwoRad, longitudeOneRad, longitudeTwoRad);
    }
}
