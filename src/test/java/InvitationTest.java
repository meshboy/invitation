import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.PriorityQueue;

import static org.junit.Assert.assertTrue;

public class InvitationTest {

    private Invitation mInvitation;
    private FileReader mFileReader;

    @Before
    public void setup() {
        final EarthDistance earthDistance = new EarthDistance();
        final InvitationDistance invitationDistance = new InvitationDistance(earthDistance);

        mFileReader = new FileReader();
        mInvitation = new Invitation(invitationDistance);
    }

    @Test
    public void validate_customers_are_fetched_in_ascending_order() throws FileNotFoundException {

        final String customers = mFileReader.readFile("src/test/resources/customers.txt");

        final PriorityQueue<Customer> customerPriorityQueue = mInvitation.findCustomersWithinDublin(customers);

        final Customer[] customerArray = customerPriorityQueue.toArray(new Customer[customerPriorityQueue.size()]);

        assertTrue(customerArray[customerArray.length - 1].getUserId() > customerArray[0].getUserId());
    }
}
