import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class InvitationDistanceTest {
    private InvitationDistance mInvitationDistance;
    private EarthDistance mEarthDistance;

    @Before
    public void setup() {
        mEarthDistance = mock(EarthDistance.class);
        mInvitationDistance = new InvitationDistance(mEarthDistance);
    }

    @Test
    public void validate_distance_given_is_within_boundaries() {
//        given varying lat and long, the distance should return 90
        when(mEarthDistance.calculateDistance(anyDouble(), anyDouble(), anyDouble(), anyDouble())).thenReturn(90.0);

//        verify the distance is within the boundary set
        assertTrue(mInvitationDistance.isWithinBoundary(4.0, 5.0));
    }

    @Test
    public void validate_conversion_to_degree_is_called_at_least_once() {

        //        given varying lat and long, the distance should return 90
        when(mEarthDistance.calculateDistance(anyDouble(), anyDouble(), anyDouble(), anyDouble()))
                .thenReturn(anyDouble());

        mInvitationDistance.isWithinBoundary(4.0, 6.0);

//        ensure degree to radian conversion has been called for lat1, lat2, long1, long2
        final ArgumentCaptor<Double> doubleArgumentCaptor = ArgumentCaptor.forClass(Double.class);
        verify(mEarthDistance, times(4)).convertDegreeToRadian(doubleArgumentCaptor.capture());
    }

}
