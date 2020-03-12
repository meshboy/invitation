import com.google.gson.annotations.SerializedName;

public class Customer implements Comparable<Customer> {
    @SerializedName("user_id")
    private int userId;
    private String name;
    private double latitude;
    private double longitude;

    public Customer() {

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(final int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(final double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(final double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("userId='").append(userId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(final Customer customer) {
        if ((customer.getUserId() - getUserId()) > 0) {
            return -1;
        } else if ((customer.getUserId() - getUserId()) < 0) {
            return 1;
        }
        return 0;
    }
}
