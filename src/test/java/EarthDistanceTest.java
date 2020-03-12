import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EarthDistanceTest {

    private EarthDistance mEarthDistance;

    @Before
    public void setup() {
        mEarthDistance = new EarthDistance();
    }

    @Test
    public void validate_change_in_longitude_is_accurate() {
        final double changeInLongitude = mEarthDistance.changeInLongitude(-1.7297222222222221, -1.6997222222222223);
        assertEquals(changeInLongitude, (Math.abs(-1.7297222222222221 - -1.6997222222222223)), 0.0);
    }

    @Test
    public void validate_change_longitude_gives_absolute_value() {
        final double changeInLongitude = mEarthDistance.changeInLongitude(-1.7297222222222221, -1.6997222222222223);
        assertTrue(changeInLongitude > 0);
    }
}
