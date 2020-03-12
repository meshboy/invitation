import java.io.FileNotFoundException;
import java.util.PriorityQueue;

public class DistanceApplication {

    public static void main(final String[] args) throws FileNotFoundException {

        final FileReader fileReader = new FileReader();

//        read the sample file
        final String customers = fileReader.readFile("src/main/resources/customers.txt");
        final EarthDistance earthDistance = new EarthDistance();
        final InvitationDistance invitationDistance = new InvitationDistance(earthDistance);
        final Invitation invitation = new Invitation(invitationDistance);

//        find the customers within the dublin office from the sample file
        final PriorityQueue<Customer> invitedCustomers = invitation.findCustomersWithinDublin(customers);

//        display those that made it based on the condition
        while (!invitedCustomers.isEmpty()) {
            System.out.println(invitedCustomers.remove());
        }
    }
}
